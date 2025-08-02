package com.microsoft.codepush.react;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.g0;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.a;
import com.facebook.react.u;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CodePushNativeModule extends ReactContextBaseJavaModule {
    private boolean _allowed = true;
    private boolean _restartInProgress = false;
    private ArrayList<Boolean> _restartQueue = new ArrayList<>();
    private String mBinaryContentsHash = null;
    private String mClientUniqueId = null;
    /* access modifiers changed from: private */
    public a mCodePush;
    /* access modifiers changed from: private */
    public LifecycleEventListener mLifecycleEventListener = null;
    /* access modifiers changed from: private */
    public int mMinimumBackgroundDuration = 0;
    /* access modifiers changed from: private */
    public o mSettingsManager;
    /* access modifiers changed from: private */
    public f mTelemetryManager;
    /* access modifiers changed from: private */
    public h mUpdateManager;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f10178a;

        a(Activity activity) {
            this.f10178a = activity;
        }

        public void run() {
            this.f10178a.recreate();
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g0 f10180a;

        b(g0 g0Var) {
            this.f10180a = g0Var;
        }

        public void run() {
            try {
                this.f10180a.i0();
                CodePushNativeModule.this.mCodePush.q();
            } catch (Exception unused) {
                CodePushNativeModule.this.loadBundleLegacy();
            }
        }
    }

    class c extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReadableMap f10182a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f10183b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f10184c;

        class a implements m {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public boolean f10186a = false;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public l f10187b = null;

            /* renamed from: com.microsoft.codepush.react.CodePushNativeModule$c$a$a  reason: collision with other inner class name */
            class C0120a implements Runnable {

                /* renamed from: com.microsoft.codepush.react.CodePushNativeModule$c$a$a$a  reason: collision with other inner class name */
                class C0121a extends w6.a {
                    C0121a() {
                    }

                    public void doFrame(long j10) {
                        if (!a.this.f10187b.b()) {
                            a.this.d();
                        }
                        a.this.f10186a = false;
                    }
                }

                C0120a() {
                }

                public void run() {
                    com.facebook.react.modules.core.a.h().m(a.b.TIMERS_EVENTS, new C0121a());
                }
            }

            a() {
            }

            public void a(l lVar) {
                if (c.this.f10183b) {
                    this.f10187b = lVar;
                    if (lVar.b()) {
                        d();
                    } else if (!this.f10186a) {
                        this.f10186a = true;
                        CodePushNativeModule.this.getReactApplicationContext().runOnUiQueueThread(new C0120a());
                    }
                }
            }

            public void d() {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) CodePushNativeModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("CodePushDownloadProgress", this.f10187b.a());
            }
        }

        c(ReadableMap readableMap, boolean z10, Promise promise) {
            this.f10182a = readableMap;
            this.f10183b = z10;
            this.f10184c = promise;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            try {
                JSONObject e10 = k.e(this.f10182a);
                k.k(e10, "binaryModifiedTime", "" + CodePushNativeModule.this.mCodePush.f());
                CodePushNativeModule.this.mUpdateManager.c(e10, CodePushNativeModule.this.mCodePush.e(), new a(), CodePushNativeModule.this.mCodePush.m());
                this.f10184c.resolve(k.c(CodePushNativeModule.this.mUpdateManager.k(k.l(this.f10182a, "packageHash"))));
                return null;
            } catch (c e11) {
                k.i(e11);
                CodePushNativeModule.this.mSettingsManager.h(k.e(this.f10182a));
                this.f10184c.reject((Throwable) e11);
                return null;
            } catch (g | IOException e12) {
                k.i(e12);
                this.f10184c.reject(e12);
                return null;
            }
        }
    }

    class d extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f10191a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10192b;

        d(Promise promise, int i10) {
            this.f10191a = promise;
            this.f10192b = i10;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            try {
                JSONObject e10 = CodePushNativeModule.this.mUpdateManager.e();
                if (e10 == null) {
                    this.f10191a.resolve((Object) null);
                    return null;
                }
                Boolean bool = Boolean.FALSE;
                if (e10.has("packageHash")) {
                    bool = Boolean.valueOf(CodePushNativeModule.this.mSettingsManager.e(e10.optString("packageHash", (String) null)));
                }
                if (this.f10192b == i.PENDING.b() && !bool.booleanValue()) {
                    this.f10191a.resolve((Object) null);
                    return null;
                } else if (this.f10192b != i.RUNNING.b() || !bool.booleanValue()) {
                    if (CodePushNativeModule.this.mCodePush.v()) {
                        k.k(e10, "_isDebugOnly", Boolean.TRUE);
                    }
                    k.k(e10, "isPending", bool);
                    this.f10191a.resolve(k.c(e10));
                    return null;
                } else {
                    JSONObject m10 = CodePushNativeModule.this.mUpdateManager.m();
                    if (m10 == null) {
                        this.f10191a.resolve((Object) null);
                        return null;
                    }
                    this.f10191a.resolve(k.c(m10));
                    return null;
                }
            } catch (d e11) {
                k.h(e11.getMessage());
                CodePushNativeModule.this.clearUpdates();
                this.f10191a.resolve((Object) null);
            } catch (g e12) {
                k.i(e12);
                this.f10191a.reject((Throwable) e12);
            }
        }
    }

    class e extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f10194a;

        e(Promise promise) {
            this.f10194a = promise;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            WritableMap h10;
            try {
                if (CodePushNativeModule.this.mCodePush.x()) {
                    CodePushNativeModule.this.mCodePush.z(false);
                    JSONArray a10 = CodePushNativeModule.this.mSettingsManager.a();
                    if (a10 != null && a10.length() > 0) {
                        WritableMap g10 = CodePushNativeModule.this.mTelemetryManager.g(k.c(a10.getJSONObject(a10.length() - 1)));
                        if (g10 != null) {
                            this.f10194a.resolve(g10);
                            return null;
                        }
                    }
                } else if (CodePushNativeModule.this.mCodePush.c()) {
                    JSONObject e10 = CodePushNativeModule.this.mUpdateManager.e();
                    if (!(e10 == null || (h10 = CodePushNativeModule.this.mTelemetryManager.h(k.c(e10))) == null)) {
                        this.f10194a.resolve(h10);
                        return null;
                    }
                } else if (CodePushNativeModule.this.mCodePush.v()) {
                    WritableMap b10 = CodePushNativeModule.this.mTelemetryManager.b(CodePushNativeModule.this.mCodePush.d());
                    if (b10 != null) {
                        this.f10194a.resolve(b10);
                        return null;
                    }
                } else {
                    WritableMap f10 = CodePushNativeModule.this.mTelemetryManager.f();
                    if (f10 != null) {
                        this.f10194a.resolve(f10);
                        return null;
                    }
                }
                this.f10194a.resolve("");
            } catch (JSONException e11) {
                throw new g("Unable to read failed updates information stored in SharedPreferences.", e11);
            } catch (g e12) {
                k.i(e12);
                this.f10194a.reject((Throwable) e12);
            }
            return null;
        }
    }

    class f extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReadableMap f10196a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10197b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f10198c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Promise f10199d;

        class a implements LifecycleEventListener {

            /* renamed from: a  reason: collision with root package name */
            private Date f10201a = null;

            /* renamed from: b  reason: collision with root package name */
            private Handler f10202b = new Handler(Looper.getMainLooper());

            /* renamed from: c  reason: collision with root package name */
            private Runnable f10203c = new C0122a();

            /* renamed from: com.microsoft.codepush.react.CodePushNativeModule$f$a$a  reason: collision with other inner class name */
            class C0122a implements Runnable {
                C0122a() {
                }

                public void run() {
                    k.h("Loading bundle on suspend");
                    CodePushNativeModule.this.restartAppInternal(false);
                }
            }

            a() {
            }

            public void onHostDestroy() {
            }

            public void onHostPause() {
                this.f10201a = new Date();
                if (f.this.f10197b == b.ON_NEXT_SUSPEND.b() && CodePushNativeModule.this.mSettingsManager.e((String) null)) {
                    this.f10202b.postDelayed(this.f10203c, (long) (f.this.f10198c * 1000));
                }
            }

            public void onHostResume() {
                this.f10202b.removeCallbacks(this.f10203c);
                if (this.f10201a != null) {
                    long time = (new Date().getTime() - this.f10201a.getTime()) / 1000;
                    if (f.this.f10197b == b.IMMEDIATE.b() || time >= ((long) CodePushNativeModule.this.mMinimumBackgroundDuration)) {
                        k.h("Loading bundle on resume");
                        CodePushNativeModule.this.restartAppInternal(false);
                    }
                }
            }
        }

        f(ReadableMap readableMap, int i10, int i11, Promise promise) {
            this.f10196a = readableMap;
            this.f10197b = i10;
            this.f10198c = i11;
            this.f10199d = promise;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            try {
                CodePushNativeModule.this.mUpdateManager.q(k.e(this.f10196a), CodePushNativeModule.this.mSettingsManager.e((String) null));
                String l10 = k.l(this.f10196a, "packageHash");
                if (l10 != null) {
                    CodePushNativeModule.this.mSettingsManager.i(l10, false);
                    if (!(this.f10197b == b.ON_NEXT_RESUME.b() || this.f10197b == b.IMMEDIATE.b())) {
                        if (this.f10197b == b.ON_NEXT_SUSPEND.b()) {
                        }
                        this.f10199d.resolve("");
                        return null;
                    }
                    CodePushNativeModule.this.mMinimumBackgroundDuration = this.f10198c;
                    if (CodePushNativeModule.this.mLifecycleEventListener == null) {
                        CodePushNativeModule.this.mLifecycleEventListener = new a();
                        CodePushNativeModule.this.getReactApplicationContext().addLifecycleEventListener(CodePushNativeModule.this.mLifecycleEventListener);
                    }
                    this.f10199d.resolve("");
                    return null;
                }
                throw new g("Update package to be installed has no hash.");
            } catch (g e10) {
                k.i(e10);
                this.f10199d.reject((Throwable) e10);
            }
        }
    }

    public CodePushNativeModule(ReactApplicationContext reactApplicationContext, a aVar, h hVar, f fVar, o oVar) {
        super(reactApplicationContext);
        this.mCodePush = aVar;
        this.mSettingsManager = oVar;
        this.mTelemetryManager = fVar;
        this.mUpdateManager = hVar;
        this.mBinaryContentsHash = j.e(reactApplicationContext, aVar.s());
        SharedPreferences sharedPreferences = aVar.g().getSharedPreferences("CodePush", 0);
        String string = sharedPreferences.getString("clientUniqueId", (String) null);
        this.mClientUniqueId = string;
        if (string == null) {
            this.mClientUniqueId = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("clientUniqueId", this.mClientUniqueId).apply();
        }
    }

    private void clearLifecycleEventListener() {
        if (this.mLifecycleEventListener != null) {
            getReactApplicationContext().removeLifecycleEventListener(this.mLifecycleEventListener);
            this.mLifecycleEventListener = null;
        }
    }

    private void loadBundle() {
        clearLifecycleEventListener();
        try {
            this.mCodePush.a(resolveInstanceManager());
        } catch (Exception unused) {
            this.mCodePush.a((g0) null);
        }
        try {
            g0 resolveInstanceManager = resolveInstanceManager();
            if (resolveInstanceManager != null) {
                a aVar = this.mCodePush;
                setJSBundle(resolveInstanceManager, aVar.l(aVar.e()));
                new Handler(Looper.getMainLooper()).post(new b(resolveInstanceManager));
            }
        } catch (Exception e10) {
            k.h("Failed to load the bundle, falling back to restarting the Activity (if it exists). " + e10.getMessage());
            loadBundleLegacy();
        }
    }

    /* access modifiers changed from: private */
    public void loadBundleLegacy() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            this.mCodePush.r();
            currentActivity.runOnUiThread(new a(currentActivity));
        }
    }

    private void resetReactRootViews(g0 g0Var) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = g0Var.getClass().getDeclaredField("mAttachedRootViews");
        declaredField.setAccessible(true);
        List<ReactRootView> list = (List) declaredField.get(g0Var);
        for (ReactRootView reactRootView : list) {
            reactRootView.removeAllViews();
            reactRootView.setId(-1);
        }
        declaredField.set(g0Var, list);
    }

    private g0 resolveInstanceManager() throws NoSuchFieldException, IllegalAccessException {
        g0 n10 = a.n();
        if (n10 != null) {
            return n10;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return null;
        }
        return ((u) currentActivity.getApplication()).getReactNativeHost().p();
    }

    /* access modifiers changed from: private */
    public void restartAppInternal(boolean z10) {
        if (this._restartInProgress) {
            k.h("Restart request queued until the current restart is completed");
            this._restartQueue.add(Boolean.valueOf(z10));
        } else if (!this._allowed) {
            k.h("Restart request queued until restarts are re-allowed");
            this._restartQueue.add(Boolean.valueOf(z10));
        } else {
            this._restartInProgress = true;
            if (!z10 || this.mSettingsManager.e((String) null)) {
                loadBundle();
                k.h("Restarting app");
                return;
            }
            this._restartInProgress = false;
            if (this._restartQueue.size() > 0) {
                boolean booleanValue = this._restartQueue.get(0).booleanValue();
                this._restartQueue.remove(0);
                restartAppInternal(booleanValue);
            }
        }
    }

    private void setJSBundle(g0 g0Var, String str) throws IllegalAccessException {
        JSBundleLoader jSBundleLoader;
        try {
            if (str.toLowerCase().startsWith("assets://")) {
                jSBundleLoader = JSBundleLoader.createAssetLoader(getReactApplicationContext(), str, false);
            } else {
                jSBundleLoader = JSBundleLoader.createFileLoader(str);
            }
            Field declaredField = g0Var.getClass().getDeclaredField("mBundleLoader");
            declaredField.setAccessible(true);
            declaredField.set(g0Var, jSBundleLoader);
        } catch (Exception unused) {
            k.h("Unable to set JSBundle - CodePush may not support this version of React Native");
            throw new IllegalAccessException("Could not setJSBundle");
        }
    }

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void allow(Promise promise) {
        k.h("Re-allowing restarts");
        this._allowed = true;
        if (this._restartQueue.size() > 0) {
            k.h("Executing pending restart");
            boolean booleanValue = this._restartQueue.get(0).booleanValue();
            this._restartQueue.remove(0);
            restartAppInternal(booleanValue);
        }
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void clearPendingRestart(Promise promise) {
        this._restartQueue.clear();
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void clearUpdates() {
        k.h("Clearing updates.");
        this.mCodePush.b();
    }

    @ReactMethod
    public void disallow(Promise promise) {
        k.h("Disallowing restarts");
        this._allowed = false;
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void downloadAndReplaceCurrentBundle(String str) {
        try {
            if (a.w()) {
                this.mUpdateManager.b(str, this.mCodePush.e());
            }
        } catch (IOException e10) {
            throw new g("Unable to replace current bundle", e10);
        } catch (d | g e11) {
            k.i(e11);
        }
    }

    @ReactMethod
    public void downloadUpdate(ReadableMap readableMap, boolean z10, Promise promise) {
        new c(readableMap, z10, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getConfiguration(Promise promise) {
        try {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("appVersion", this.mCodePush.d());
            createMap.putString("clientUniqueId", this.mClientUniqueId);
            createMap.putString("deploymentKey", this.mCodePush.i());
            createMap.putString("serverUrl", this.mCodePush.o());
            String str = this.mBinaryContentsHash;
            if (str != null) {
                createMap.putString("packageHash", str);
            }
            promise.resolve(createMap);
        } catch (g e10) {
            k.i(e10);
            promise.reject((Throwable) e10);
        }
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("codePushInstallModeImmediate", Integer.valueOf(b.IMMEDIATE.b()));
        hashMap.put("codePushInstallModeOnNextRestart", Integer.valueOf(b.ON_NEXT_RESTART.b()));
        hashMap.put("codePushInstallModeOnNextResume", Integer.valueOf(b.ON_NEXT_RESUME.b()));
        hashMap.put("codePushInstallModeOnNextSuspend", Integer.valueOf(b.ON_NEXT_SUSPEND.b()));
        hashMap.put("codePushUpdateStateRunning", Integer.valueOf(i.RUNNING.b()));
        hashMap.put("codePushUpdateStatePending", Integer.valueOf(i.PENDING.b()));
        hashMap.put("codePushUpdateStateLatest", Integer.valueOf(i.LATEST.b()));
        return hashMap;
    }

    @ReactMethod
    public void getLatestRollbackInfo(Promise promise) {
        try {
            JSONObject b10 = this.mSettingsManager.b();
            if (b10 != null) {
                promise.resolve(k.c(b10));
            } else {
                promise.resolve((Object) null);
            }
        } catch (g e10) {
            k.i(e10);
            promise.reject((Throwable) e10);
        }
    }

    public String getName() {
        return "CodePush";
    }

    @ReactMethod
    public void getNewStatusReport(Promise promise) {
        new e(promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getUpdateMetadata(int i10, Promise promise) {
        new d(promise, i10).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void installUpdate(ReadableMap readableMap, int i10, int i11, Promise promise) {
        new f(readableMap, i10, i11, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void isFailedUpdate(String str, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(this.mSettingsManager.d(str)));
        } catch (g e10) {
            k.i(e10);
            promise.reject((Throwable) e10);
        }
    }

    @ReactMethod
    public void isFirstRun(String str, Promise promise) {
        boolean z10;
        try {
            if (!this.mCodePush.c() || str == null || str.length() <= 0 || !str.equals(this.mUpdateManager.h())) {
                z10 = false;
            } else {
                z10 = true;
            }
            promise.resolve(Boolean.valueOf(z10));
        } catch (g e10) {
            k.i(e10);
            promise.reject((Throwable) e10);
        }
    }

    @ReactMethod
    public void notifyApplicationReady(Promise promise) {
        try {
            this.mSettingsManager.g();
            promise.resolve("");
        } catch (g e10) {
            k.i(e10);
            promise.reject((Throwable) e10);
        }
    }

    @ReactMethod
    public void recordStatusReported(ReadableMap readableMap) {
        try {
            this.mTelemetryManager.k(readableMap);
        } catch (g e10) {
            k.i(e10);
        }
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    @ReactMethod
    public void restartApp(boolean z10, Promise promise) {
        try {
            restartAppInternal(z10);
            promise.resolve((Object) null);
        } catch (g e10) {
            k.i(e10);
            promise.reject((Throwable) e10);
        }
    }

    @ReactMethod
    public void saveStatusReportForRetry(ReadableMap readableMap) {
        try {
            this.mTelemetryManager.l(readableMap);
        } catch (g e10) {
            k.i(e10);
        }
    }

    @ReactMethod
    public void setLatestRollbackInfo(String str, Promise promise) {
        try {
            this.mSettingsManager.j(str);
            promise.resolve((Object) null);
        } catch (g e10) {
            k.i(e10);
            promise.reject((Throwable) e10);
        }
    }
}
