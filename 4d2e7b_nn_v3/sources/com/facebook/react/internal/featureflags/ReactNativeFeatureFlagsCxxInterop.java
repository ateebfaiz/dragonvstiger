package com.facebook.react.internal.featureflags;

import com.facebook.soloader.SoLoader;
import d6.a;

@a
public final class ReactNativeFeatureFlagsCxxInterop {

    /* renamed from: a  reason: collision with root package name */
    public static final ReactNativeFeatureFlagsCxxInterop f3184a = new ReactNativeFeatureFlagsCxxInterop();

    static {
        SoLoader.t("react_featureflagsjni");
    }

    private ReactNativeFeatureFlagsCxxInterop() {
    }

    @a
    public static final native boolean allowCollapsableChildren();

    @a
    public static final native boolean allowRecursiveCommitsWithSynchronousMountOnAndroid();

    @a
    public static final native boolean batchRenderingUpdatesInEventLoop();

    @a
    public static final native boolean commonTestFlag();

    @a
    public static final native void dangerouslyReset();

    @a
    public static final native boolean destroyFabricSurfacesInReactInstanceManager();

    @a
    public static final native boolean enableBackgroundExecutor();

    @a
    public static final native boolean enableCleanTextInputYogaNode();

    @a
    public static final native boolean enableGranularShadowTreeStateReconciliation();

    @a
    public static final native boolean enableMicrotasks();

    @a
    public static final native boolean enableSynchronousStateUpdates();

    @a
    public static final native boolean enableUIConsistency();

    @a
    public static final native boolean fixStoppedSurfaceRemoveDeleteTreeUIFrameCallbackLeak();

    @a
    public static final native boolean forceBatchingMountItemsOnAndroid();

    @a
    public static final native boolean fuseboxEnabledDebug();

    @a
    public static final native boolean fuseboxEnabledRelease();

    @a
    public static final native boolean lazyAnimationCallbacks();

    @a
    public static final native void override(Object obj);

    @a
    public static final native boolean preventDoubleTextMeasure();

    @a
    public static final native boolean setAndroidLayoutDirection();

    @a
    public static final native boolean useImmediateExecutorInAndroidBridgeless();

    @a
    public static final native boolean useModernRuntimeScheduler();

    @a
    public static final native boolean useNativeViewConfigsInBridgelessMode();

    @a
    public static final native boolean useRuntimeShadowNodeReferenceUpdate();

    @a
    public static final native boolean useRuntimeShadowNodeReferenceUpdateOnLayout();

    @a
    public static final native boolean useStateAlignmentMechanism();
}
