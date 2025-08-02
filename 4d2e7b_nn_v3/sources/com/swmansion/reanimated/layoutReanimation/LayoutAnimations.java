package com.swmansion.reanimated.layoutReanimation;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.soloader.SoLoader;
import com.swmansion.reanimated.ReanimatedModule;
import d6.a;
import java.lang.ref.WeakReference;
import java.util.Map;

public class LayoutAnimations {
    private final WeakReference<ReactApplicationContext> mContext;
    @a
    private final HybridData mHybridData;
    private WeakReference<AnimationsManager> mWeakAnimationsManager = new WeakReference<>((Object) null);

    public static class Types {
        static final int ENTERING = 1;
        static final int EXITING = 2;
        static final int LAYOUT = 3;
        static final int SHARED_ELEMENT_TRANSITION = 4;
        static final int SHARED_ELEMENT_TRANSITION_PROGRESS = 5;
    }

    static {
        SoLoader.t("reanimated");
    }

    public LayoutAnimations(ReactApplicationContext reactApplicationContext) {
        this.mContext = new WeakReference<>(reactApplicationContext);
        this.mHybridData = initHybrid();
    }

    private void endLayoutAnimation(int i10, boolean z10) {
        AnimationsManager animationsManager = getAnimationsManager();
        if (animationsManager != null) {
            animationsManager.endLayoutAnimation(i10, z10);
        }
    }

    private AnimationsManager getAnimationsManager() {
        if (this.mWeakAnimationsManager.get() != null) {
            return this.mWeakAnimationsManager.get();
        }
        ReactApplicationContext reactApplicationContext = this.mContext.get();
        if (reactApplicationContext == null) {
            return null;
        }
        AnimationsManager animationsManager = ((ReanimatedModule) reactApplicationContext.getNativeModule(ReanimatedModule.class)).getNodesManager().getAnimationsManager();
        this.mWeakAnimationsManager = new WeakReference<>(animationsManager);
        return animationsManager;
    }

    private native HybridData initHybrid();

    private void progressLayoutAnimation(int i10, Map<String, Object> map, boolean z10) {
        AnimationsManager animationsManager = getAnimationsManager();
        if (animationsManager != null) {
            animationsManager.progressLayoutAnimation(i10, map, z10);
        }
    }

    public native void cancelAnimationForTag(int i10);

    public native void checkDuplicateSharedTag(int i10, int i11);

    public native void clearAnimationConfigForTag(int i10);

    public native int findPrecedingViewTagForTransition(int i10);

    public native int[] getSharedGroup(int i10);

    public native boolean hasAnimationForTag(int i10, int i11);

    public native boolean isLayoutAnimationEnabled();

    public native boolean shouldAnimateExiting(int i10, boolean z10);

    public native void startAnimationForTag(int i10, int i11, Map<String, String> map);
}
