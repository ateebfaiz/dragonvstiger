package com.facebook.react.modules.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.alibaba.pdns.f;
import com.facebook.fbreact.specs.NativeIntentAndroidSpec;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.games.paddleboat.GameControllerManager;

@s6.a(name = "IntentAndroid")
public class IntentModule extends NativeIntentAndroidSpec {
    private static final String EXTRA_MAP_KEY_FOR_VALUE = "value";
    /* access modifiers changed from: private */
    @Nullable
    public LifecycleEventListener mInitialURLListener = null;

    class a implements LifecycleEventListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f3300a;

        a(Promise promise) {
            this.f3300a = promise;
        }

        public void onHostDestroy() {
        }

        public void onHostPause() {
        }

        public void onHostResume() {
            IntentModule.this.getInitialURL(this.f3300a);
            IntentModule.this.getReactApplicationContext().removeLifecycleEventListener(this);
            IntentModule.this.mInitialURLListener = null;
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3302a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3302a = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3302a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3302a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.intent.IntentModule.b.<clinit>():void");
        }
    }

    public IntentModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private void sendOSIntent(Intent intent, Boolean bool) {
        String str;
        Activity currentActivity = getCurrentActivity();
        String packageName = getReactApplicationContext().getPackageName();
        ComponentName resolveActivity = intent.resolveActivity(getReactApplicationContext().getPackageManager());
        if (resolveActivity != null) {
            str = resolveActivity.getPackageName();
        } else {
            str = "";
        }
        if (bool.booleanValue() || currentActivity == null || !packageName.equals(str)) {
            intent.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
        }
        if (currentActivity != null) {
            currentActivity.startActivity(intent);
        } else {
            getReactApplicationContext().startActivity(intent);
        }
    }

    private void waitForActivityAndGetInitialURL(Promise promise) {
        if (this.mInitialURLListener != null) {
            promise.reject((Throwable) new IllegalStateException("Cannot await activity from more than one call to getInitialURL"));
            return;
        }
        this.mInitialURLListener = new a(promise);
        getReactApplicationContext().addLifecycleEventListener(this.mInitialURLListener);
    }

    public void canOpenURL(String str, Promise promise) {
        boolean z10;
        if (str == null || str.isEmpty()) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException("Invalid URL: " + str));
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
            if (intent.resolveActivity(getReactApplicationContext().getPackageManager()) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            promise.resolve(Boolean.valueOf(z10));
        } catch (Exception e10) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException("Could not check if URL '" + str + "' can be opened: " + e10.getMessage()));
        }
    }

    public void getInitialURL(Promise promise) {
        String str;
        try {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                waitForActivityAndGetInitialURL(promise);
                return;
            }
            Intent intent = currentActivity.getIntent();
            String action = intent.getAction();
            Uri data = intent.getData();
            if (data == null || (!"android.intent.action.VIEW".equals(action) && !"android.nfc.action.NDEF_DISCOVERED".equals(action))) {
                str = null;
            } else {
                str = data.toString();
            }
            promise.resolve(str);
        } catch (Exception e10) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException("Could not get the initial URL : " + e10.getMessage()));
        }
    }

    public void invalidate() {
        if (this.mInitialURLListener != null) {
            getReactApplicationContext().removeLifecycleEventListener(this.mInitialURLListener);
            this.mInitialURLListener = null;
        }
        super.invalidate();
    }

    public void openSettings(Promise promise) {
        try {
            Intent intent = new Intent();
            Activity currentActivity = getCurrentActivity();
            String packageName = getReactApplicationContext().getPackageName();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + packageName));
            intent.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
            intent.addFlags(1073741824);
            intent.addFlags(8388608);
            currentActivity.startActivity(intent);
            promise.resolve(Boolean.TRUE);
        } catch (Exception e10) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException("Could not open the Settings: " + e10.getMessage()));
        }
    }

    public void openURL(String str, Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException("Invalid URL: " + str));
            return;
        }
        try {
            sendOSIntent(new Intent("android.intent.action.VIEW", Uri.parse(str).normalizeScheme()), Boolean.FALSE);
            promise.resolve(Boolean.TRUE);
        } catch (Exception e10) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException("Could not open URL '" + str + "': " + e10.getMessage()));
        }
    }

    public void sendIntent(String str, @Nullable ReadableArray readableArray, Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException("Invalid Action: " + str + f.G));
            return;
        }
        Intent intent = new Intent(str);
        if (intent.resolveActivity(getReactApplicationContext().getPackageManager()) == null) {
            promise.reject((Throwable) new JSApplicationIllegalArgumentException("Could not launch Intent with action " + str + f.G));
            return;
        }
        if (readableArray != null) {
            for (int i10 = 0; i10 < readableArray.size(); i10++) {
                ReadableMap map = readableArray.getMap(i10);
                String string = map.getString("key");
                int i11 = b.f3302a[map.getType("value").ordinal()];
                if (i11 == 1) {
                    intent.putExtra(string, map.getString("value"));
                } else if (i11 == 2) {
                    intent.putExtra(string, Double.valueOf(map.getDouble("value")));
                } else if (i11 != 3) {
                    promise.reject((Throwable) new JSApplicationIllegalArgumentException("Extra type for " + string + " not supported."));
                    return;
                } else {
                    intent.putExtra(string, map.getBoolean("value"));
                }
            }
        }
        sendOSIntent(intent, Boolean.TRUE);
    }
}
