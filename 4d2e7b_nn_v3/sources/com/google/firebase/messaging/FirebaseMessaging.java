package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.n0;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirebaseMessaging {
    private static final String EXTRA_DUMMY_P_INTENT = "app";
    static final String GMS_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final String INSTANCE_ID_SCOPE = "FCM";
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private static final long MIN_DELAY_SEC = 30;
    private static final String SEND_INTENT_ACTION = "com.google.android.gcm.intent.SEND";
    private static final String SUBTYPE_DEFAULT = "";
    static final String TAG = "FirebaseMessaging";
    @GuardedBy("FirebaseMessaging.class")
    private static n0 store;
    @VisibleForTesting
    @GuardedBy("FirebaseMessaging.class")
    static ScheduledExecutorService syncExecutor;
    @VisibleForTesting
    @SuppressLint({"FirebaseUnknownNullness"})
    @Nullable
    static TransportFactory transportFactory;
    private final a autoInit;
    private final Context context;
    private final Executor fileExecutor;
    /* access modifiers changed from: private */
    public final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi fis;
    private final a0 gmsRpc;
    @Nullable
    private final FirebaseInstanceIdInternal iid;
    private final Executor initExecutor;
    private final Application.ActivityLifecycleCallbacks lifecycleCallbacks;
    private final d0 metadata;
    private final k0 requestDeduplicator;
    @GuardedBy("this")
    private boolean syncScheduledOrRunning;
    private final Executor taskExecutor;
    private final Task<s0> topicsSubscriberTask;

    private class a {

        /* renamed from: a  reason: collision with root package name */
        private final Subscriber f9198a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f9199b;

        /* renamed from: c  reason: collision with root package name */
        private EventHandler f9200c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f9201d;

        a(Subscriber subscriber) {
            this.f9198a = subscriber;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(Event event) {
            if (c()) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
        }

        private Boolean e() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context applicationContext = FirebaseMessaging.this.firebaseApp.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void b() {
            try {
                if (!this.f9199b) {
                    Boolean e10 = e();
                    this.f9201d = e10;
                    if (e10 == null) {
                        x xVar = new x(this);
                        this.f9200c = xVar;
                        this.f9198a.subscribe(DataCollectionDefaultChange.class, xVar);
                    }
                    this.f9199b = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean c() {
            boolean z10;
            try {
                b();
                Boolean bool = this.f9201d;
                if (bool != null) {
                    z10 = bool.booleanValue();
                } else {
                    z10 = FirebaseMessaging.this.firebaseApp.isDataCollectionDefaultEnabled();
                }
            } catch (Throwable th) {
                throw th;
            }
            return z10;
        }

        /* access modifiers changed from: package-private */
        public synchronized void f(boolean z10) {
            try {
                b();
                EventHandler eventHandler = this.f9200c;
                if (eventHandler != null) {
                    this.f9198a.unsubscribe(DataCollectionDefaultChange.class, eventHandler);
                    this.f9200c = null;
                }
                SharedPreferences.Editor edit = FirebaseMessaging.this.firebaseApp.getApplicationContext().getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0).edit();
                edit.putBoolean("auto_init", z10);
                edit.apply();
                if (z10) {
                    FirebaseMessaging.this.startSyncIfNecessary();
                }
                this.f9201d = Boolean.valueOf(z10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    FirebaseMessaging(FirebaseApp firebaseApp2, @Nullable FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable TransportFactory transportFactory2, Subscriber subscriber) {
        this(firebaseApp2, firebaseInstanceIdInternal, provider, provider2, firebaseInstallationsApi, transportFactory2, subscriber, new d0(firebaseApp2.getApplicationContext()));
    }

    @VisibleForTesting
    static synchronized void clearStoreForTest() {
        synchronized (FirebaseMessaging.class) {
            store = null;
        }
    }

    static void clearTransportFactoryForTest() {
        transportFactory = null;
    }

    @NonNull
    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging instance;
        synchronized (FirebaseMessaging.class) {
            instance = getInstance(FirebaseApp.getInstance());
        }
        return instance;
    }

    @NonNull
    private static synchronized n0 getStore(Context context2) {
        n0 n0Var;
        synchronized (FirebaseMessaging.class) {
            try {
                if (store == null) {
                    store = new n0(context2);
                }
                n0Var = store;
            } catch (Throwable th) {
                throw th;
            }
        }
        return n0Var;
    }

    private String getSubtype() {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.firebaseApp.getName())) {
            return "";
        }
        return this.firebaseApp.getPersistenceKey();
    }

    @Nullable
    public static TransportFactory getTransportFactory() {
        return transportFactory;
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeOnTokenRefresh */
    public void lambda$new$0(String str) {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.firebaseApp.getName())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Invoking onNewToken for app: " + this.firebaseApp.getName());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new FcmBroadcastProcessor(this.context).process(intent);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$blockingGetToken$10(String str, n0.a aVar) {
        return this.gmsRpc.f().onSuccessTask(this.fileExecutor, new m(this, str, aVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$blockingGetToken$9(String str, n0.a aVar, String str2) throws Exception {
        getStore(this.context).g(getSubtype(), str, str2, this.metadata.a());
        if (aVar == null || !str2.equals(aVar.f9262a)) {
            lambda$new$0(str2);
        }
        return Tasks.forResult(str2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteToken$5(TaskCompletionSource taskCompletionSource) {
        try {
            this.iid.deleteToken(d0.c(this.firebaseApp), INSTANCE_ID_SCOPE);
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteToken$6(TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(this.gmsRpc.c());
            getStore(this.context).d(getSubtype(), d0.c(this.firebaseApp));
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getToken$4(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(blockingGetToken());
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        if (isAutoInitEnabled()) {
            startSyncIfNecessary();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(s0 s0Var) {
        if (isAutoInitEnabled()) {
            s0Var.q();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3() {
        h0.c(this.context);
    }

    private synchronized void startSync() {
        if (!this.syncScheduledOrRunning) {
            syncWithDelaySecondsInternal(0);
        }
    }

    /* access modifiers changed from: private */
    public void startSyncIfNecessary() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.getToken();
        } else if (tokenNeedsRefresh(getTokenWithoutTriggeringSync())) {
            startSync();
        }
    }

    /* access modifiers changed from: package-private */
    public String blockingGetToken() throws IOException {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) Tasks.await(firebaseInstanceIdInternal.getTokenTask());
            } catch (InterruptedException | ExecutionException e10) {
                throw new IOException(e10);
            }
        } else {
            n0.a tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
            if (!tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
                return tokenWithoutTriggeringSync.f9262a;
            }
            String c10 = d0.c(this.firebaseApp);
            try {
                return (String) Tasks.await(this.requestDeduplicator.b(c10, new u(this, c10, tokenWithoutTriggeringSync)));
            } catch (InterruptedException | ExecutionException e11) {
                throw new IOException(e11);
            }
        }
    }

    @NonNull
    public Task<Void> deleteToken() {
        if (this.iid != null) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.initExecutor.execute(new v(this, taskCompletionSource));
            return taskCompletionSource.getTask();
        } else if (getTokenWithoutTriggeringSync() == null) {
            return Tasks.forResult(null);
        } else {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            i.e().execute(new w(this, taskCompletionSource2));
            return taskCompletionSource2.getTask();
        }
    }

    @NonNull
    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return MessagingAnalytics.deliveryMetricsExportToBigQueryEnabled();
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public void enqueueTaskWithDelaySeconds(Runnable runnable, long j10) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (syncExecutor == null) {
                    syncExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
                }
                syncExecutor.schedule(runnable, j10, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Context getApplicationContext() {
        return this.context;
    }

    @NonNull
    public Task<String> getToken() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            return firebaseInstanceIdInternal.getTokenTask();
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.initExecutor.execute(new s(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public n0.a getTokenWithoutTriggeringSync() {
        return getStore(this.context).e(getSubtype(), d0.c(this.firebaseApp));
    }

    /* access modifiers changed from: package-private */
    public Task<s0> getTopicsSubscriberTask() {
        return this.topicsSubscriberTask;
    }

    public boolean isAutoInitEnabled() {
        return this.autoInit.c();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isGmsCorePresent() {
        return this.metadata.g();
    }

    public boolean isNotificationDelegationEnabled() {
        return h0.d(this.context);
    }

    public void send(@NonNull RemoteMessage remoteMessage) {
        if (!TextUtils.isEmpty(remoteMessage.getTo())) {
            Intent intent = new Intent(SEND_INTENT_ACTION);
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            intent.putExtra(EXTRA_DUMMY_P_INTENT, PendingIntent.getBroadcast(this.context, 0, intent2, 67108864));
            intent.setPackage("com.google.android.gms");
            remoteMessage.populateSendMessageIntent(intent);
            this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }

    public void setAutoInitEnabled(boolean z10) {
        this.autoInit.f(z10);
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z10) {
        MessagingAnalytics.setDeliveryMetricsExportToBigQuery(z10);
    }

    @NonNull
    public Task<Void> setNotificationDelegationEnabled(boolean z10) {
        return h0.f(this.initExecutor, this.context, z10);
    }

    /* access modifiers changed from: package-private */
    public synchronized void setSyncScheduledOrRunning(boolean z10) {
        this.syncScheduledOrRunning = z10;
    }

    @SuppressLint({"TaskMainThread"})
    @NonNull
    public Task<Void> subscribeToTopic(@NonNull String str) {
        return this.topicsSubscriberTask.onSuccessTask(new l(str));
    }

    /* access modifiers changed from: package-private */
    public synchronized void syncWithDelaySecondsInternal(long j10) {
        enqueueTaskWithDelaySeconds(new o0(this, Math.min(Math.max(MIN_DELAY_SEC, 2 * j10), MAX_DELAY_SEC)), j10);
        this.syncScheduledOrRunning = true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean tokenNeedsRefresh(@Nullable n0.a aVar) {
        if (aVar == null || aVar.b(this.metadata.a())) {
            return true;
        }
        return false;
    }

    @SuppressLint({"TaskMainThread"})
    @NonNull
    public Task<Void> unsubscribeFromTopic(@NonNull String str) {
        return this.topicsSubscriberTask.onSuccessTask(new t(str));
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp firebaseApp2) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp2.get(FirebaseMessaging.class);
            Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    FirebaseMessaging(com.google.firebase.FirebaseApp r12, @androidx.annotation.Nullable com.google.firebase.iid.internal.FirebaseInstanceIdInternal r13, com.google.firebase.inject.Provider<com.google.firebase.platforminfo.UserAgentPublisher> r14, com.google.firebase.inject.Provider<com.google.firebase.heartbeatinfo.HeartBeatInfo> r15, com.google.firebase.installations.FirebaseInstallationsApi r16, @androidx.annotation.Nullable com.google.android.datatransport.TransportFactory r17, com.google.firebase.events.Subscriber r18, com.google.firebase.messaging.d0 r19) {
        /*
            r11 = this;
            com.google.firebase.messaging.a0 r7 = new com.google.firebase.messaging.a0
            r0 = r7
            r1 = r12
            r2 = r19
            r3 = r14
            r4 = r15
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5)
            java.util.concurrent.ExecutorService r8 = com.google.firebase.messaging.i.f()
            java.util.concurrent.ScheduledExecutorService r9 = com.google.firebase.messaging.i.c()
            java.util.concurrent.Executor r10 = com.google.firebase.messaging.i.b()
            r0 = r11
            r2 = r13
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessaging.<init>(com.google.firebase.FirebaseApp, com.google.firebase.iid.internal.FirebaseInstanceIdInternal, com.google.firebase.inject.Provider, com.google.firebase.inject.Provider, com.google.firebase.installations.FirebaseInstallationsApi, com.google.android.datatransport.TransportFactory, com.google.firebase.events.Subscriber, com.google.firebase.messaging.d0):void");
    }

    FirebaseMessaging(FirebaseApp firebaseApp2, @Nullable FirebaseInstanceIdInternal firebaseInstanceIdInternal, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable TransportFactory transportFactory2, Subscriber subscriber, d0 d0Var, a0 a0Var, Executor executor, Executor executor2, Executor executor3) {
        this.syncScheduledOrRunning = false;
        transportFactory = transportFactory2;
        this.firebaseApp = firebaseApp2;
        this.iid = firebaseInstanceIdInternal;
        this.fis = firebaseInstallationsApi;
        this.autoInit = new a(subscriber);
        Context applicationContext = firebaseApp2.getApplicationContext();
        this.context = applicationContext;
        k kVar = new k();
        this.lifecycleCallbacks = kVar;
        this.metadata = d0Var;
        this.taskExecutor = executor;
        this.gmsRpc = a0Var;
        this.requestDeduplicator = new k0(executor);
        this.initExecutor = executor2;
        this.fileExecutor = executor3;
        Context applicationContext2 = firebaseApp2.getApplicationContext();
        if (applicationContext2 instanceof Application) {
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(kVar);
        } else {
            Log.w("FirebaseMessaging", "Context " + applicationContext2 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.addNewTokenListener(new n(this));
        }
        executor2.execute(new o(this));
        Task<s0> f10 = s0.f(this, d0Var, a0Var, applicationContext, i.g());
        this.topicsSubscriberTask = f10;
        f10.addOnSuccessListener(executor2, (OnSuccessListener<? super s0>) new p(this));
        executor2.execute(new q(this));
    }
}
