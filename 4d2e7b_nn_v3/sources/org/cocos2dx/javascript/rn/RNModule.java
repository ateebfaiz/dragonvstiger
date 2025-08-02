package org.cocos2dx.javascript.rn;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import com.cocos.lib.CocosLocalStorage;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.gson.Gson;
import org.cocos2dx.javascript.AppActivity;
import org.cocos2dx.javascript.PasskeyManager;
import org.cocos2dx.javascript.PlatformUtils;
import org.cocos2dx.javascript.SDKInfo;
import org.cocos2dx.javascript.UniqueIdManager;
import org.cocos2dx.javascript.sdk.AdjustSDK;
import org.cocos2dx.javascript.sdk.AppsFlyerSDK;
import org.cocos2dx.javascript.sdk.FireBaseSDK;

public class RNModule extends ReactContextBaseJavaModule {
    private static RNModule instance;
    private final ActivityEventListener mActivityEventListener;
    private ReactApplicationContext mContext;
    private Gson mGson = new Gson();

    class a extends BaseActivityEventListener {
        a() {
        }

        public void onActivityResult(Activity activity, int i10, int i11, Intent intent) {
            Log.d("RNModule", "onActivityResult " + i10);
        }
    }

    RNModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        a aVar = new a();
        this.mActivityEventListener = aVar;
        Log.d("RNModule", "RNModule init");
        instance = this;
        this.mContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(aVar);
    }

    public static RNModule getInstance() {
        if (instance == null) {
            Log.d("RNModule", "getInstance: null");
        }
        return instance;
    }

    @ReactMethod
    public void asyncGetDataFromNative(Callback callback) {
        WritableMap createMap = Arguments.createMap();
        createMap.merge(RNCtrl.nativeData);
        callback.invoke(this.mGson.toJson((Object) createMap.toHashMap()));
    }

    @ReactMethod
    public void changeWindowFocus() {
        AppActivity appActivity = PlatformUtils.mActivity;
        appActivity.runOnUiThread(new e(appActivity));
    }

    @ReactMethod
    public void checkSDK(String str, Callback callback) {
        callback.invoke(Boolean.valueOf(SDKInfo.CheckSDK(str)));
    }

    @ReactMethod
    public void clearClipboard() {
        PlatformUtils.clearClipboard();
    }

    @ReactMethod
    public void codePushInstallSuccess() {
        RNDelegateManager.getInstance().codePushInstallSuccess();
    }

    @ReactMethod
    public void destroyBotion() {
        PlatformUtils.destroyBotion();
    }

    @ReactMethod
    public void destroyGeetest() {
        PlatformUtils.destroyGeetest();
    }

    @ReactMethod
    public void eventBurialPoint(String str, String str2, String str3) {
        if ("af".equals(str)) {
            AdjustSDK.EventBurialPoint(str2, str3);
        } else if ("fb".equals(str)) {
            FireBaseSDK.EventBurialPoint(str2, str3);
        }
    }

    @ReactMethod
    public void getAdid(Callback callback) {
        callback.invoke(AdjustSDK.getAdid());
    }

    @ReactMethod
    public void getBundleName(Callback callback) {
        callback.invoke(PlatformUtils.getBundleName());
    }

    @ReactMethod
    public void getClip(Callback callback) {
        callback.invoke(PlatformUtils.getClip());
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getDataFromNative() {
        WritableMap createMap = Arguments.createMap();
        createMap.merge(RNCtrl.nativeData);
        return this.mGson.toJson((Object) createMap.toHashMap());
    }

    @ReactMethod
    public void getDeviceBrand(Callback callback) {
        callback.invoke(PlatformUtils.getDeviceBrand());
    }

    @ReactMethod
    public void getDeviceHash(Callback callback) {
        callback.invoke(UniqueIdManager.INSTANCE.getUniqueId(PlatformUtils.mActivity));
    }

    @ReactMethod
    public void getHallVersion(Callback callback) {
        callback.invoke(PlatformUtils.getHallVersion());
    }

    @ReactMethod
    public void getMTPushID(Callback callback) {
        callback.invoke(PlatformUtils.getMTPushID());
    }

    @ReactMethod
    public void getMetaInfo(String str, Callback callback) {
        callback.invoke(PlatformUtils.getInfoValue(str));
    }

    @NonNull
    public String getName() {
        return "PushNativeModule";
    }

    @ReactMethod
    public void getNetworkType(Callback callback) {
        callback.invoke(PlatformUtils.getNetworkType());
    }

    @ReactMethod
    public void getOrientation(Callback callback) {
        callback.invoke(Integer.valueOf(PlatformUtils.getOrientation()));
    }

    @ReactMethod
    public void getSystemVersion(Callback callback) {
        callback.invoke(PlatformUtils.getSystemVersion());
    }

    @ReactMethod
    public void getUid(Callback callback) {
        callback.invoke(AppsFlyerSDK.getUid());
    }

    @ReactMethod
    public void getUniq(Callback callback) {
        callback.invoke(PlatformUtils.getUniq());
    }

    @ReactMethod
    public void getZlZMetaInfo(Callback callback) {
        callback.invoke(PlatformUtils.getZlzMetaInfo());
    }

    @ReactMethod
    public void getgeeGuardToken(String str, String str2, Callback callback) {
        callback.invoke(PlatformUtils.getgeeGuardToken(str, str2));
    }

    @ReactMethod
    public void hideLaunchImage() {
        PlatformUtils.removeSplashView();
    }

    @ReactMethod
    public void initLoginUser(String str, String str2) {
        PlatformUtils.initLoginUser(str, str2);
    }

    @ReactMethod
    public void initZlZ(String str, String str2, String str3, Callback callback) {
        PlatformUtils.initZlz(str, str2, str3, callback);
    }

    @ReactMethod
    public void localStorageGetItem(String str, Callback callback) {
        callback.invoke(CocosLocalStorage.getItem(str));
    }

    @ReactMethod
    public void localStorageRemoveItem(String str) {
        CocosLocalStorage.removeItem(str);
    }

    @ReactMethod
    public void localStorageSetItem(String str, String str2) {
        CocosLocalStorage.setItem(str, str2);
    }

    @ReactMethod
    public void onBackPressed(boolean z10) {
        Log.d("RNModule", "RNModule onBackPressed");
        RNDelegateManager.getInstance().hide(z10);
    }

    @ReactMethod
    public void openApp(int i10, String str, String str2) {
        ShareUtils.openAPP(i10 + "", str2, str);
    }

    @ReactMethod
    public void passkeyRegister(String str, String str2, String str3, String str4, Callback callback) {
        PasskeyManager.INSTANCE.register(str, str2, str3, str4, callback);
    }

    @ReactMethod
    public void passkeySignIn(String str, String str2, Callback callback) {
        PasskeyManager.INSTANCE.signIn(str, str2, callback);
    }

    @ReactMethod
    public void preloadRnEnd() {
        PlatformUtils.preloadRnEnd();
    }

    @ReactMethod
    public void selectLang(String str, String str2) {
        PlatformUtils.selectLang(str, str2);
    }

    @ReactMethod
    public void sendEmail(String str, String str2, String str3) {
        PlatformUtils.sendEmail(str, str2, str3);
    }

    @ReactMethod
    public void sendEventToCocos(String str, String str2) {
        Log.d("RNModule", "sendEventToCocos: " + str);
        PlatformUtils.callJsbBridgeWrapper(str, str2);
    }

    public void sendEventToRN(Object obj) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("kDataEventName", obj);
    }

    @ReactMethod
    public void setOrientation(String str) {
        PlatformUtils.setOrientation(str);
    }

    @ReactMethod
    public void shareAllPlatform(String str) {
        ShareUtils.sysShare(str);
    }

    @ReactMethod
    public void startBotion(String str, String str2, String str3, Callback callback) {
        PlatformUtils.startBotion(str, str2, str3, callback);
    }

    @ReactMethod
    public void startGeeTest(String str, String str2, Callback callback) {
        PlatformUtils.startGeetest(str, str2, callback);
    }

    @ReactMethod
    public void startHCaptcha(String str, String str2, Callback callback) {
        PlatformUtils.startHCaptcha(str, str2, callback);
    }
}
