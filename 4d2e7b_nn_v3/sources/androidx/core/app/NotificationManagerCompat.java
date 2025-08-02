package androidx.core.app;

import a0.a;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    public static final int INTERRUPTION_FILTER_ALARMS = 4;
    public static final int INTERRUPTION_FILTER_ALL = 1;
    public static final int INTERRUPTION_FILTER_NONE = 3;
    public static final int INTERRUPTION_FILTER_PRIORITY = 2;
    public static final int INTERRUPTION_FILTER_UNKNOWN = 0;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    @GuardedBy("sEnabledNotificationListenersLock")
    private static Set<String> sEnabledNotificationListenerPackages = new HashSet();
    @GuardedBy("sEnabledNotificationListenersLock")
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock = new Object();
    private static final Object sLock = new Object();
    @GuardedBy("sLock")
    private static i sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterruptionFilter {
    }

    static class a {
        @DoNotInline
        static List<StatusBarNotification> a(NotificationManager notificationManager) {
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            if (activeNotifications == null) {
                return new ArrayList();
            }
            return Arrays.asList(activeNotifications);
        }

        @DoNotInline
        static int b(NotificationManager notificationManager) {
            return notificationManager.getCurrentInterruptionFilter();
        }
    }

    static class b {
        @DoNotInline
        static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        @DoNotInline
        static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    static class c {
        @DoNotInline
        static void a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        @DoNotInline
        static void b(NotificationManager notificationManager, NotificationChannelGroup notificationChannelGroup) {
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }

        @DoNotInline
        static void c(NotificationManager notificationManager, List<NotificationChannelGroup> list) {
            notificationManager.createNotificationChannelGroups(list);
        }

        @DoNotInline
        static void d(NotificationManager notificationManager, List<NotificationChannel> list) {
            notificationManager.createNotificationChannels(list);
        }

        @DoNotInline
        static void e(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannel(str);
        }

        @DoNotInline
        static void f(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannelGroup(str);
        }

        @DoNotInline
        static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        @DoNotInline
        static String h(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        @DoNotInline
        static NotificationChannel i(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannel(str);
        }

        @DoNotInline
        static List<NotificationChannelGroup> j(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannelGroups();
        }

        @DoNotInline
        static List<NotificationChannel> k(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }
    }

    static class d {
        @DoNotInline
        static NotificationChannelGroup a(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannelGroup(str);
        }
    }

    static class e {
        @DoNotInline
        static NotificationChannel a(NotificationManager notificationManager, String str, String str2) {
            return notificationManager.getNotificationChannel(str, str2);
        }

        @DoNotInline
        static String b(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }
    }

    static class f {
        @DoNotInline
        static boolean a(NotificationManager notificationManager) {
            return notificationManager.canUseFullScreenIntent();
        }
    }

    private static class g implements j {

        /* renamed from: a  reason: collision with root package name */
        final String f14820a;

        /* renamed from: b  reason: collision with root package name */
        final int f14821b;

        /* renamed from: c  reason: collision with root package name */
        final String f14822c;

        /* renamed from: d  reason: collision with root package name */
        final Notification f14823d;

        g(String str, int i10, String str2, Notification notification) {
            this.f14820a = str;
            this.f14821b = i10;
            this.f14822c = str2;
            this.f14823d = notification;
        }

        public void a(a0.a aVar) {
            aVar.F(this.f14820a, this.f14821b, this.f14822c, this.f14823d);
        }

        public String toString() {
            return "NotifyTask[" + "packageName:" + this.f14820a + ", id:" + this.f14821b + ", tag:" + this.f14822c + "]";
        }
    }

    private static class h {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f14824a;

        /* renamed from: b  reason: collision with root package name */
        final IBinder f14825b;

        h(ComponentName componentName, IBinder iBinder) {
            this.f14824a = componentName;
            this.f14825b = iBinder;
        }
    }

    private static class i implements Handler.Callback, ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private final Context f14826a;

        /* renamed from: b  reason: collision with root package name */
        private final HandlerThread f14827b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f14828c;

        /* renamed from: d  reason: collision with root package name */
        private final Map f14829d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private Set f14830e = new HashSet();

        private static class a {

            /* renamed from: a  reason: collision with root package name */
            final ComponentName f14831a;

            /* renamed from: b  reason: collision with root package name */
            boolean f14832b = false;

            /* renamed from: c  reason: collision with root package name */
            a0.a f14833c;

            /* renamed from: d  reason: collision with root package name */
            ArrayDeque f14834d = new ArrayDeque();

            /* renamed from: e  reason: collision with root package name */
            int f14835e = 0;

            a(ComponentName componentName) {
                this.f14831a = componentName;
            }
        }

        i(Context context) {
            this.f14826a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f14827b = handlerThread;
            handlerThread.start();
            this.f14828c = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(a aVar) {
            if (aVar.f14832b) {
                return true;
            }
            boolean bindService = this.f14826a.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(aVar.f14831a), this, 33);
            aVar.f14832b = bindService;
            if (bindService) {
                aVar.f14835e = 0;
            } else {
                Log.w(NotificationManagerCompat.TAG, "Unable to bind to listener " + aVar.f14831a);
                this.f14826a.unbindService(this);
            }
            return aVar.f14832b;
        }

        private void b(a aVar) {
            if (aVar.f14832b) {
                this.f14826a.unbindService(this);
                aVar.f14832b = false;
            }
            aVar.f14833c = null;
        }

        private void c(j jVar) {
            j();
            for (a aVar : this.f14829d.values()) {
                aVar.f14834d.add(jVar);
                g(aVar);
            }
        }

        private void d(ComponentName componentName) {
            a aVar = (a) this.f14829d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            a aVar = (a) this.f14829d.get(componentName);
            if (aVar != null) {
                aVar.f14833c = a.C0169a.M(iBinder);
                aVar.f14835e = 0;
                g(aVar);
            }
        }

        private void f(ComponentName componentName) {
            a aVar = (a) this.f14829d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void g(a aVar) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                Log.d(NotificationManagerCompat.TAG, "Processing component " + aVar.f14831a + ", " + aVar.f14834d.size() + " queued tasks");
            }
            if (!aVar.f14834d.isEmpty()) {
                if (!a(aVar) || aVar.f14833c == null) {
                    i(aVar);
                    return;
                }
                while (true) {
                    j jVar = (j) aVar.f14834d.peek();
                    if (jVar == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                            Log.d(NotificationManagerCompat.TAG, "Sending task " + jVar);
                        }
                        jVar.a(aVar.f14833c);
                        aVar.f14834d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                            Log.d(NotificationManagerCompat.TAG, "Remote service has died: " + aVar.f14831a);
                        }
                    } catch (RemoteException e10) {
                        Log.w(NotificationManagerCompat.TAG, "RemoteException communicating with " + aVar.f14831a, e10);
                    }
                }
                if (!aVar.f14834d.isEmpty()) {
                    i(aVar);
                }
            }
        }

        private void i(a aVar) {
            if (!this.f14828c.hasMessages(3, aVar.f14831a)) {
                int i10 = aVar.f14835e;
                int i11 = i10 + 1;
                aVar.f14835e = i11;
                if (i11 > 6) {
                    Log.w(NotificationManagerCompat.TAG, "Giving up on delivering " + aVar.f14834d.size() + " tasks to " + aVar.f14831a + " after " + aVar.f14835e + " retries");
                    aVar.f14834d.clear();
                    return;
                }
                int i12 = (1 << i10) * 1000;
                if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                    Log.d(NotificationManagerCompat.TAG, "Scheduling retry for " + i12 + " ms");
                }
                this.f14828c.sendMessageDelayed(this.f14828c.obtainMessage(3, aVar.f14831a), (long) i12);
            }
        }

        private void j() {
            Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.f14826a);
            if (!enabledListenerPackages.equals(this.f14830e)) {
                this.f14830e = enabledListenerPackages;
                List<ResolveInfo> queryIntentServices = this.f14826a.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
                HashSet<ComponentName> hashSet = new HashSet<>();
                for (ResolveInfo next : queryIntentServices) {
                    if (enabledListenerPackages.contains(next.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = next.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (next.serviceInfo.permission != null) {
                            Log.w(NotificationManagerCompat.TAG, "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f14829d.containsKey(componentName2)) {
                        if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                            Log.d(NotificationManagerCompat.TAG, "Adding listener record for " + componentName2);
                        }
                        this.f14829d.put(componentName2, new a(componentName2));
                    }
                }
                Iterator it = this.f14829d.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (!hashSet.contains(entry.getKey())) {
                        if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                            Log.d(NotificationManagerCompat.TAG, "Removing listener record for " + entry.getKey());
                        }
                        b((a) entry.getValue());
                        it.remove();
                    }
                }
            }
        }

        public void h(j jVar) {
            this.f14828c.obtainMessage(0, jVar).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                c((j) message.obj);
                return true;
            } else if (i10 == 1) {
                h hVar = (h) message.obj;
                e(hVar.f14824a, hVar.f14825b);
                return true;
            } else if (i10 == 2) {
                f((ComponentName) message.obj);
                return true;
            } else if (i10 != 3) {
                return false;
            } else {
                d((ComponentName) message.obj);
                return true;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                Log.d(NotificationManagerCompat.TAG, "Connected to service " + componentName);
            }
            this.f14828c.obtainMessage(1, new h(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                Log.d(NotificationManagerCompat.TAG, "Disconnected from service " + componentName);
            }
            this.f14828c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    private interface j {
        void a(a0.a aVar);
    }

    private NotificationManagerCompat(Context context) {
        this.mContext = context;
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
    }

    @NonNull
    public static NotificationManagerCompat from(@NonNull Context context) {
        return new NotificationManagerCompat(context);
    }

    @NonNull
    public static Set<String> getEnabledListenerPackages(@NonNull Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        synchronized (sEnabledNotificationListenersLock) {
            if (string != null) {
                try {
                    if (!string.equals(sEnabledNotificationListeners)) {
                        String[] split = string.split(":", -1);
                        HashSet hashSet = new HashSet(split.length);
                        for (String unflattenFromString : split) {
                            ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                            if (unflattenFromString2 != null) {
                                hashSet.add(unflattenFromString2.getPackageName());
                            }
                        }
                        sEnabledNotificationListenerPackages = hashSet;
                        sEnabledNotificationListeners = string;
                    }
                } finally {
                }
            }
            set = sEnabledNotificationListenerPackages;
        }
        return set;
    }

    private void pushSideChannelQueue(j jVar) {
        synchronized (sLock) {
            try {
                if (sSideChannelManager == null) {
                    sSideChannelManager = new i(this.mContext.getApplicationContext());
                }
                sSideChannelManager.h(jVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean useSideChannelForNotification(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        if (extras == null || !extras.getBoolean(EXTRA_USE_SIDE_CHANNEL)) {
            return false;
        }
        return true;
    }

    public boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.a(this.mNotificationManager);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.mContext.getSystemService("appops");
        ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
        String packageName = this.mContext.getApplicationContext().getPackageName();
        int i10 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class cls2 = Integer.TYPE;
            Method method = cls.getMethod(CHECK_OP_NO_THROW, new Class[]{cls2, cls2, String.class});
            Integer num = (Integer) cls.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class);
            num.intValue();
            if (((Integer) method.invoke(appOpsManager, new Object[]{num, Integer.valueOf(i10), packageName})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public boolean canUseFullScreenIntent() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 29) {
            return true;
        }
        if (i10 >= 34) {
            return f.a(this.mNotificationManager);
        }
        if (this.mContext.checkSelfPermission("android.permission.USE_FULL_SCREEN_INTENT") == 0) {
            return true;
        }
        return false;
    }

    public void cancel(int i10) {
        cancel((String) null, i10);
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
    }

    public void createNotificationChannel(@NonNull NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.a(this.mNotificationManager, notificationChannel);
        }
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.b(this.mNotificationManager, notificationChannelGroup);
        }
    }

    public void createNotificationChannelGroups(@NonNull List<NotificationChannelGroup> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.c(this.mNotificationManager, list);
        }
    }

    public void createNotificationChannelGroupsCompat(@NonNull List<NotificationChannelGroupCompat> list) {
        if (Build.VERSION.SDK_INT >= 26 && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            for (NotificationChannelGroupCompat notificationChannelGroup : list) {
                arrayList.add(notificationChannelGroup.getNotificationChannelGroup());
            }
            c.c(this.mNotificationManager, arrayList);
        }
    }

    public void createNotificationChannels(@NonNull List<NotificationChannel> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.d(this.mNotificationManager, list);
        }
    }

    public void createNotificationChannelsCompat(@NonNull List<NotificationChannelCompat> list) {
        if (Build.VERSION.SDK_INT >= 26 && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            for (NotificationChannelCompat notificationChannel : list) {
                arrayList.add(notificationChannel.getNotificationChannel());
            }
            c.d(this.mNotificationManager, arrayList);
        }
    }

    public void deleteNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.e(this.mNotificationManager, str);
        }
    }

    public void deleteNotificationChannelGroup(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.f(this.mNotificationManager, str);
        }
    }

    public void deleteUnlistedNotificationChannels(@NonNull Collection<String> collection) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (NotificationChannel a10 : c.k(this.mNotificationManager)) {
                NotificationChannel a11 = j.a(a10);
                if (!collection.contains(c.g(a11)) && (Build.VERSION.SDK_INT < 30 || !collection.contains(e.b(a11)))) {
                    c.e(this.mNotificationManager, c.g(a11));
                }
            }
        }
    }

    @NonNull
    public List<StatusBarNotification> getActiveNotifications() {
        return a.a(this.mNotificationManager);
    }

    public int getCurrentInterruptionFilter() {
        return a.b(this.mNotificationManager);
    }

    public int getImportance() {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.b(this.mNotificationManager);
        }
        return IMPORTANCE_UNSPECIFIED;
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.i(this.mNotificationManager, str);
        }
        return null;
    }

    @Nullable
    public NotificationChannelCompat getNotificationChannelCompat(@NonNull String str) {
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannel = getNotificationChannel(str)) == null) {
            return null;
        }
        return new NotificationChannelCompat(notificationChannel);
    }

    @Nullable
    public NotificationChannelGroup getNotificationChannelGroup(@NonNull String str) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return d.a(this.mNotificationManager, str);
        }
        if (i10 >= 26) {
            for (NotificationChannelGroup a10 : getNotificationChannelGroups()) {
                NotificationChannelGroup a11 = r.a(a10);
                if (c.h(a11).equals(str)) {
                    return a11;
                }
            }
        }
        return null;
    }

    @Nullable
    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(@NonNull String str) {
        NotificationChannelGroup notificationChannelGroup;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            NotificationChannelGroup notificationChannelGroup2 = getNotificationChannelGroup(str);
            if (notificationChannelGroup2 != null) {
                return new NotificationChannelGroupCompat(notificationChannelGroup2);
            }
            return null;
        } else if (i10 < 26 || (notificationChannelGroup = getNotificationChannelGroup(str)) == null) {
            return null;
        } else {
            return new NotificationChannelGroupCompat(notificationChannelGroup, getNotificationChannels());
        }
    }

    @NonNull
    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.j(this.mNotificationManager);
        }
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        List<NotificationChannel> list;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            List<NotificationChannelGroup> notificationChannelGroups = getNotificationChannelGroups();
            if (!notificationChannelGroups.isEmpty()) {
                if (i10 >= 28) {
                    list = Collections.emptyList();
                } else {
                    list = getNotificationChannels();
                }
                ArrayList arrayList = new ArrayList(notificationChannelGroups.size());
                for (NotificationChannelGroup a10 : notificationChannelGroups) {
                    NotificationChannelGroup a11 = r.a(a10);
                    if (Build.VERSION.SDK_INT >= 28) {
                        arrayList.add(new NotificationChannelGroupCompat(a11));
                    } else {
                        arrayList.add(new NotificationChannelGroupCompat(a11, list));
                    }
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannel> getNotificationChannels() {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.k(this.mNotificationManager);
        }
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannelCompat> getNotificationChannelsCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            List<NotificationChannel> notificationChannels = getNotificationChannels();
            if (!notificationChannels.isEmpty()) {
                ArrayList arrayList = new ArrayList(notificationChannels.size());
                for (NotificationChannel a10 : notificationChannels) {
                    arrayList.add(new NotificationChannelCompat(j.a(a10)));
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(int i10, @NonNull Notification notification) {
        notify((String) null, i10, notification);
    }

    public void cancel(@Nullable String str, int i10) {
        this.mNotificationManager.cancel(str, i10);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(@Nullable String str, int i10, @NonNull Notification notification) {
        if (useSideChannelForNotification(notification)) {
            pushSideChannelQueue(new g(this.mContext.getPackageName(), i10, str, notification));
            this.mNotificationManager.cancel(str, i10);
            return;
        }
        this.mNotificationManager.notify(str, i10, notification);
    }

    public void createNotificationChannel(@NonNull NotificationChannelCompat notificationChannelCompat) {
        createNotificationChannel(notificationChannelCompat.getNotificationChannel());
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroupCompat notificationChannelGroupCompat) {
        createNotificationChannelGroup(notificationChannelGroupCompat.getNotificationChannelGroup());
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return e.a(this.mNotificationManager, str, str2);
        }
        return getNotificationChannel(str);
    }

    public static class NotificationWithIdAndTag {
        final int mId;
        Notification mNotification;
        final String mTag;

        public NotificationWithIdAndTag(@Nullable String str, int i10, @NonNull Notification notification) {
            this.mTag = str;
            this.mId = i10;
            this.mNotification = notification;
        }

        public NotificationWithIdAndTag(int i10, @NonNull Notification notification) {
            this((String) null, i10, notification);
        }
    }

    @VisibleForTesting
    NotificationManagerCompat(@NonNull NotificationManager notificationManager, @NonNull Context context) {
        this.mContext = context;
        this.mNotificationManager = notificationManager;
    }

    @Nullable
    public NotificationChannelCompat getNotificationChannelCompat(@NonNull String str, @NonNull String str2) {
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannel = getNotificationChannel(str, str2)) == null) {
            return null;
        }
        return new NotificationChannelCompat(notificationChannel);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(@NonNull List<NotificationWithIdAndTag> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            NotificationWithIdAndTag notificationWithIdAndTag = list.get(i10);
            notify(notificationWithIdAndTag.mTag, notificationWithIdAndTag.mId, notificationWithIdAndTag.mNotification);
        }
    }
}
