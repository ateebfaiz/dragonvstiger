package com.facebook.react.modules.core;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.fbreact.specs.NativeDeviceEventManagerSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.internal.ImagesContract;
import w6.b;

@s6.a(name = "DeviceEventManager")
public class DeviceEventManagerModule extends NativeDeviceEventManagerSpec {
    private final Runnable mInvokeDefaultBackPressRunnable;

    @d6.a
    public interface RCTDeviceEventEmitter extends JavaScriptModule {
        void emit(@NonNull String str, @Nullable Object obj);
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f3208a;

        a(b bVar) {
            this.f3208a = bVar;
        }

        public void run() {
            UiThreadUtil.assertOnUiThread();
            this.f3208a.invokeDefaultOnBackPressed();
        }
    }

    public DeviceEventManagerModule(ReactApplicationContext reactApplicationContext, b bVar) {
        super(reactApplicationContext);
        this.mInvokeDefaultBackPressRunnable = new a(bVar);
    }

    public void emitHardwareBackPressed() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.emitDeviceEvent("hardwareBackPress", (Object) null);
        }
    }

    public void emitNewIntentReceived(Uri uri) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString(ImagesContract.URL, uri.toString());
            reactApplicationContextIfActiveOrWarn.emitDeviceEvent(ImagesContract.URL, createMap);
        }
    }

    public void invokeDefaultBackPressHandler() {
        getReactApplicationContext().runOnUiQueueThread(this.mInvokeDefaultBackPressRunnable);
    }
}
