package com.facebook.react.internal.featureflags;

import d6.a;

@a
public interface ReactNativeFeatureFlagsProvider {
    @a
    boolean allowCollapsableChildren();

    @a
    boolean allowRecursiveCommitsWithSynchronousMountOnAndroid();

    @a
    boolean batchRenderingUpdatesInEventLoop();

    @a
    boolean commonTestFlag();

    @a
    boolean destroyFabricSurfacesInReactInstanceManager();

    @a
    boolean enableBackgroundExecutor();

    @a
    boolean enableCleanTextInputYogaNode();

    @a
    boolean enableGranularShadowTreeStateReconciliation();

    @a
    boolean enableMicrotasks();

    @a
    boolean enableSynchronousStateUpdates();

    @a
    boolean enableUIConsistency();

    @a
    boolean fixStoppedSurfaceRemoveDeleteTreeUIFrameCallbackLeak();

    @a
    boolean forceBatchingMountItemsOnAndroid();

    @a
    boolean fuseboxEnabledDebug();

    @a
    boolean fuseboxEnabledRelease();

    @a
    boolean lazyAnimationCallbacks();

    @a
    boolean preventDoubleTextMeasure();

    @a
    boolean setAndroidLayoutDirection();

    @a
    boolean useImmediateExecutorInAndroidBridgeless();

    @a
    boolean useModernRuntimeScheduler();

    @a
    boolean useNativeViewConfigsInBridgelessMode();

    @a
    boolean useRuntimeShadowNodeReferenceUpdate();

    @a
    boolean useRuntimeShadowNodeReferenceUpdateOnLayout();

    @a
    boolean useStateAlignmentMechanism();
}
