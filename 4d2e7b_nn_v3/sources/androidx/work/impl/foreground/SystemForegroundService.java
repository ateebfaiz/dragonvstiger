package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.b {
    private static final String TAG = Logger.tagWithPrefix("SystemFgService");
    @Nullable
    private static SystemForegroundService sForegroundService = null;
    SystemForegroundDispatcher mDispatcher;
    private Handler mHandler;
    private boolean mIsShutdown;
    NotificationManager mNotificationManager;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f17004a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Notification f17005b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f17006c;

        a(int i10, Notification notification, int i11) {
            this.f17004a = i10;
            this.f17005b = notification;
            this.f17006c = i11;
        }

        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.f17004a, this.f17005b, this.f17006c);
            } else {
                SystemForegroundService.this.startForeground(this.f17004a, this.f17005b);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f17008a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Notification f17009b;

        b(int i10, Notification notification) {
            this.f17008a = i10;
            this.f17009b = notification;
        }

        public void run() {
            SystemForegroundService.this.mNotificationManager.notify(this.f17008a, this.f17009b);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f17011a;

        c(int i10) {
            this.f17011a = i10;
        }

        public void run() {
            SystemForegroundService.this.mNotificationManager.cancel(this.f17011a);
        }
    }

    @Nullable
    public static SystemForegroundService getInstance() {
        return sForegroundService;
    }

    @MainThread
    private void initializeDispatcher() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = systemForegroundDispatcher;
        systemForegroundDispatcher.setCallback(this);
    }

    public void cancelNotification(int i10) {
        this.mHandler.post(new c(i10));
    }

    public void notify(int i10, @NonNull Notification notification) {
        this.mHandler.post(new b(i10, notification));
    }

    public void onCreate() {
        super.onCreate();
        sForegroundService = this;
        initializeDispatcher();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    public int onStartCommand(@Nullable Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.mIsShutdown) {
            Logger.get().info(TAG, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.mDispatcher.onDestroy();
            initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        this.mDispatcher.onStartCommand(intent);
        return 3;
    }

    public void startForeground(int i10, int i11, @NonNull Notification notification) {
        this.mHandler.post(new a(i10, notification, i11));
    }

    @MainThread
    public void stop() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        sForegroundService = null;
        stopSelf();
    }
}
