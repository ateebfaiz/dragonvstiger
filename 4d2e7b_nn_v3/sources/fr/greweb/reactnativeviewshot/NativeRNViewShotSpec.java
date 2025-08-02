package fr.greweb.reactnativeviewshot;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeRNViewShotSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNViewShot";

    public NativeRNViewShotSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void captureRef(Double d10, ReadableMap readableMap, Promise promise);

    @ReactMethod
    @a
    public abstract void captureScreen(ReadableMap readableMap, Promise promise);

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void releaseCapture(String str);
}
