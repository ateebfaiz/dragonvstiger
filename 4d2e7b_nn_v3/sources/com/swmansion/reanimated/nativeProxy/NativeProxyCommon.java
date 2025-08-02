package com.swmansion.reanimated.nativeProxy;

import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.soloader.SoLoader;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import com.swmansion.reanimated.BuildConfig;
import com.swmansion.reanimated.DevMenuUtils;
import com.swmansion.reanimated.NativeProxy;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.ReanimatedModule;
import com.swmansion.reanimated.Utils;
import com.swmansion.reanimated.keyboard.KeyboardAnimationManager;
import com.swmansion.reanimated.keyboard.KeyboardWorkletWrapper;
import com.swmansion.reanimated.layoutReanimation.LayoutAnimations;
import com.swmansion.reanimated.sensor.ReanimatedSensorContainer;
import com.swmansion.reanimated.sensor.ReanimatedSensorType;
import com.swmansion.worklets.WorkletsModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import ya.a;

public abstract class NativeProxyCommon {
    private final int ANIMATIONS_DRAG_FACTOR = 10;
    protected String cppVersion;
    private Long firstUptime = Long.valueOf(SystemClock.uptimeMillis());
    private final a gestureHandlerStateManager;
    private final KeyboardAnimationManager keyboardAnimationManager;
    protected final WeakReference<ReactApplicationContext> mContext;
    protected NodesManager mNodesManager;
    protected final WorkletsModule mWorkletsModule;
    private final ReanimatedSensorContainer reanimatedSensorContainer;
    private boolean slowAnimationsEnabled = false;

    static {
        SoLoader.t("reanimated");
    }

    protected NativeProxyCommon(ReactApplicationContext reactApplicationContext) {
        a aVar = null;
        this.cppVersion = null;
        ReanimatedModule reanimatedModule = (ReanimatedModule) reactApplicationContext.getNativeModule(ReanimatedModule.class);
        Objects.requireNonNull(reanimatedModule);
        this.mWorkletsModule = reanimatedModule.getWorkletsModule();
        WeakReference<ReactApplicationContext> weakReference = new WeakReference<>(reactApplicationContext);
        this.mContext = weakReference;
        this.reanimatedSensorContainer = new ReanimatedSensorContainer(weakReference);
        this.keyboardAnimationManager = new KeyboardAnimationManager(weakReference);
        addDevMenuOption();
        Class cls = RNGestureHandlerModule.class;
        try {
            RNGestureHandlerModule.a aVar2 = RNGestureHandlerModule.Companion;
            aVar = (a) reactApplicationContext.getNativeModule(cls);
        } catch (ClassCastException | ClassNotFoundException unused) {
        }
        this.gestureHandlerStateManager = aVar;
    }

    private void addDevMenuOption() {
        DevMenuUtils.addDevMenuOption(this.mContext.get(), new a(this));
    }

    private Set<String> convertProps(ReadableNativeArray readableNativeArray) {
        HashSet hashSet = new HashSet();
        ArrayList<Object> arrayList = readableNativeArray.toArrayList();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            hashSet.add((String) arrayList.get(i10));
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    public void toggleSlowAnimations() {
        boolean z10 = !this.slowAnimationsEnabled;
        this.slowAnimationsEnabled = z10;
        if (z10) {
            this.firstUptime = Long.valueOf(SystemClock.uptimeMillis());
        }
        this.mNodesManager.enableSlowAnimations(this.slowAnimationsEnabled, 10);
    }

    /* access modifiers changed from: protected */
    public void checkCppVersion() {
        if (this.cppVersion != null) {
            String reanimatedJavaVersion = getReanimatedJavaVersion();
            if (!this.cppVersion.equals(reanimatedJavaVersion)) {
                throw new RuntimeException("[Reanimated] Mismatch between Java code version and C++ code version (" + reanimatedJavaVersion + " vs. " + this.cppVersion + " respectively). See https://docs.swmansion.com/react-native-reanimated/docs/guides/troubleshooting#mismatch-between-java-code-version-and-c-code-version for more information.");
            }
            return;
        }
        throw new RuntimeException("[Reanimated] Java side failed to resolve C++ code version. See https://docs.swmansion.com/react-native-reanimated/docs/guides/troubleshooting#java-side-failed-to-resolve-c-code-version for more information.");
    }

    @d6.a
    public void configureProps(ReadableNativeArray readableNativeArray, ReadableNativeArray readableNativeArray2) {
        this.mNodesManager.configureProps(convertProps(readableNativeArray), convertProps(readableNativeArray2));
    }

    @d6.a
    public void dispatchCommand(int i10, String str, ReadableArray readableArray) {
        this.mNodesManager.dispatchCommand(i10, str, readableArray);
    }

    @d6.a
    public long getAnimationTimestamp() {
        if (this.slowAnimationsEnabled) {
            return this.firstUptime.longValue() + ((SystemClock.uptimeMillis() - this.firstUptime.longValue()) / 10);
        }
        return SystemClock.uptimeMillis();
    }

    /* access modifiers changed from: protected */
    public abstract HybridData getHybridData();

    @d6.a
    public boolean getIsReducedMotion() {
        float f10;
        String string = Settings.Global.getString(this.mContext.get().getContentResolver(), "transition_animation_scale");
        if (string != null) {
            f10 = Float.parseFloat(string);
        } else {
            f10 = 1.0f;
        }
        if (f10 == 0.0f) {
            return true;
        }
        return false;
    }

    @d6.a
    public String getReanimatedJavaVersion() {
        return BuildConfig.REANIMATED_VERSION_JAVA;
    }

    /* access modifiers changed from: protected */
    public native void installJSIBindings();

    /* access modifiers changed from: package-private */
    @d6.a
    public void maybeFlushUIUpdatesQueue() {
        if (!this.mNodesManager.isAnimationRunning()) {
            this.mNodesManager.performOperations();
        }
    }

    @d6.a
    public float[] measure(int i10) {
        return this.mNodesManager.measure(i10);
    }

    @d6.a
    public String obtainProp(int i10, String str) {
        return this.mNodesManager.obtainProp(i10, str);
    }

    public void prepareLayoutAnimations(LayoutAnimations layoutAnimations) {
        if (Utils.isChromeDebugger) {
            Log.w("[REANIMATED]", "You can not use LayoutAnimation with enabled Chrome Debugger");
            return;
        }
        Class cls = ReanimatedModule.class;
        ReanimatedModule reanimatedModule = (ReanimatedModule) this.mContext.get().getNativeModule(cls);
        Objects.requireNonNull(reanimatedModule);
        this.mNodesManager = reanimatedModule.getNodesManager();
        ReanimatedModule reanimatedModule2 = (ReanimatedModule) this.mContext.get().getNativeModule(cls);
        Objects.requireNonNull(reanimatedModule2);
        reanimatedModule2.getNodesManager().getAnimationsManager().setNativeMethods(NativeProxy.createNativeMethodsHolder(layoutAnimations));
    }

    @d6.a
    public void registerEventHandler(EventHandler eventHandler) {
        eventHandler.mCustomEventNamesResolver = this.mNodesManager.getEventNameResolver();
        this.mNodesManager.registerEventHandler(eventHandler);
    }

    @d6.a
    public int registerSensor(int i10, int i11, SensorSetter sensorSetter) {
        return this.reanimatedSensorContainer.registerSensor(ReanimatedSensorType.getInstanceById(i10), i11, sensorSetter);
    }

    @d6.a
    public void requestRender(AnimationFrameCallback animationFrameCallback) {
        this.mNodesManager.postOnAnimation(animationFrameCallback);
    }

    @d6.a
    public void scrollTo(int i10, double d10, double d11, boolean z10) {
        this.mNodesManager.scrollTo(i10, d10, d11, z10);
    }

    /* access modifiers changed from: protected */
    @d6.a
    public void setCppVersion(String str) {
        this.cppVersion = str;
    }

    @d6.a
    public void setGestureState(int i10, int i11) {
        a aVar = this.gestureHandlerStateManager;
        if (aVar != null) {
            aVar.setGestureHandlerState(i10, i11);
        }
    }

    @d6.a
    public int subscribeForKeyboardEvents(KeyboardWorkletWrapper keyboardWorkletWrapper, boolean z10, boolean z11) {
        return this.keyboardAnimationManager.subscribeForKeyboardUpdates(keyboardWorkletWrapper, z10, z11);
    }

    @d6.a
    public void unregisterSensor(int i10) {
        this.reanimatedSensorContainer.unregisterSensor(i10);
    }

    @d6.a
    public void unsubscribeFromKeyboardEvents(int i10) {
        this.keyboardAnimationManager.unsubscribeFromKeyboardUpdates(i10);
    }

    @d6.a
    public void updateProps(int i10, Map<String, Object> map) {
        this.mNodesManager.updateProps(i10, map);
    }
}
