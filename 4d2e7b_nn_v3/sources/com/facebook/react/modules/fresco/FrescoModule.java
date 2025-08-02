package com.facebook.react.modules.fresco;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.modules.network.e;
import com.facebook.react.modules.network.h;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.HashSet;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import p3.c;
import s6.a;
import z4.k;
import z4.l;
import z6.b;

@a(name = "FrescoModule", needsEagerInit = true)
public class FrescoModule extends ReactContextBaseJavaModule implements LifecycleEventListener, TurboModule {
    public static final String NAME = "FrescoModule";
    private static boolean sHasBeenInitialized;
    private final boolean mClearOnDestroy;
    @Nullable
    private l mConfig;
    @Nullable
    private k mImagePipeline;

    public FrescoModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, true, (l) null);
    }

    private static l getDefaultConfig(ReactContext reactContext) {
        return getDefaultConfigBuilder(reactContext).a();
    }

    public static l.a getDefaultConfigBuilder(ReactContext reactContext) {
        HashSet hashSet = new HashSet();
        hashSet.add(new b());
        OkHttpClient a10 = h.a();
        ((com.facebook.react.modules.network.a) a10.cookieJar()).b(new JavaNetCookieJar(new e(reactContext)));
        return v4.a.a(reactContext.getApplicationContext(), a10).R(new a(a10)).P(false).S(hashSet);
    }

    private k getImagePipeline() {
        if (this.mImagePipeline == null) {
            this.mImagePipeline = c.a();
        }
        return this.mImagePipeline;
    }

    public static boolean hasBeenInitialized() {
        return sHasBeenInitialized;
    }

    public void clearSensitiveData() {
        getImagePipeline().c();
    }

    public String getName() {
        return NAME;
    }

    public void initialize() {
        super.initialize();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.addLifecycleEventListener(this);
        if (!hasBeenInitialized()) {
            if (this.mConfig == null) {
                this.mConfig = getDefaultConfig(reactApplicationContext);
            }
            c.c(reactApplicationContext.getApplicationContext(), this.mConfig);
            sHasBeenInitialized = true;
        } else if (this.mConfig != null) {
            z2.a.G("ReactNative", "Fresco has already been initialized with a different config. The new Fresco configuration will be ignored!");
        }
        this.mConfig = null;
    }

    public void invalidate() {
        getReactApplicationContext().removeLifecycleEventListener(this);
        super.invalidate();
    }

    public void onHostDestroy() {
        if (hasBeenInitialized() && this.mClearOnDestroy) {
            getImagePipeline().e();
        }
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public FrescoModule(ReactApplicationContext reactApplicationContext, boolean z10) {
        this(reactApplicationContext, z10, (l) null);
    }

    public FrescoModule(ReactApplicationContext reactApplicationContext, @Nullable k kVar, boolean z10) {
        this(reactApplicationContext, kVar, z10, false);
    }

    public FrescoModule(ReactApplicationContext reactApplicationContext, @Nullable k kVar, boolean z10, boolean z11) {
        this(reactApplicationContext, z10);
        this.mImagePipeline = kVar;
        if (z11) {
            sHasBeenInitialized = true;
        }
    }

    public FrescoModule(ReactApplicationContext reactApplicationContext, boolean z10, @Nullable l lVar) {
        super(reactApplicationContext);
        this.mClearOnDestroy = z10;
        this.mConfig = lVar;
    }
}
