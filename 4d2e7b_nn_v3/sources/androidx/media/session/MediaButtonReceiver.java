package androidx.media.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import androidx.media.MediaBrowserServiceCompat;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    private static class a extends MediaBrowserCompat.b {

        /* renamed from: c  reason: collision with root package name */
        private final Context f16037c;

        /* renamed from: d  reason: collision with root package name */
        private final Intent f16038d;

        /* renamed from: e  reason: collision with root package name */
        private final BroadcastReceiver.PendingResult f16039e;

        /* renamed from: f  reason: collision with root package name */
        private MediaBrowserCompat f16040f;

        a(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f16037c = context;
            this.f16038d = intent;
            this.f16039e = pendingResult;
        }

        private void e() {
            this.f16040f.b();
            this.f16039e.finish();
        }

        public void a() {
            try {
                new MediaControllerCompat(this.f16037c, this.f16040f.c()).a((KeyEvent) this.f16038d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException e10) {
                Log.e(MediaButtonReceiver.TAG, "Failed to create a media controller", e10);
            }
            e();
        }

        public void b() {
            e();
        }

        public void c() {
            e();
        }

        /* access modifiers changed from: package-private */
        public void f(MediaBrowserCompat mediaBrowserCompat) {
            this.f16040f = mediaBrowserCompat;
        }
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context context, long j10) {
        ComponentName mediaButtonReceiverComponent = getMediaButtonReceiverComponent(context);
        if (mediaButtonReceiverComponent != null) {
            return buildMediaButtonPendingIntent(context, mediaButtonReceiverComponent, j10);
        }
        Log.w(TAG, "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static ComponentName getMediaButtonReceiverComponent(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        } else if (queryBroadcastReceivers.size() <= 1) {
            return null;
        } else {
            Log.w(TAG, "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
            return null;
        }
    }

    private static ComponentName getServiceComponentByAction(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
        }
    }

    public static KeyEvent handleIntent(MediaSessionCompat mediaSessionCompat, Intent intent) {
        return null;
    }

    private static void startForegroundService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            ComponentName unused = context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d(TAG, "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName serviceComponentByAction = getServiceComponentByAction(context, "android.intent.action.MEDIA_BUTTON");
        if (serviceComponentByAction != null) {
            intent.setComponent(serviceComponentByAction);
            startForegroundService(context, intent);
            return;
        }
        ComponentName serviceComponentByAction2 = getServiceComponentByAction(context, MediaBrowserServiceCompat.SERVICE_INTERFACE);
        if (serviceComponentByAction2 != null) {
            BroadcastReceiver.PendingResult goAsync = goAsync();
            Context applicationContext = context.getApplicationContext();
            a aVar = new a(applicationContext, intent, goAsync);
            MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, serviceComponentByAction2, aVar, (Bundle) null);
            aVar.f(mediaBrowserCompat);
            mediaBrowserCompat.a();
            return;
        }
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context context, ComponentName componentName, long j10) {
        if (componentName == null) {
            Log.w(TAG, "The component name of media button receiver should be provided.");
            return null;
        }
        int a10 = PlaybackStateCompat.a(j10);
        if (a10 == 0) {
            Log.w(TAG, "Cannot build a media button pending intent with the given action: " + j10);
            return null;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, a10));
        return PendingIntent.getBroadcast(context, a10, intent, 0);
    }
}
