package com.swmansion.reanimated;

import androidx.annotation.OptIn;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.swmansion.reanimated.layoutReanimation.LayoutAnimations;
import com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder;
import com.swmansion.reanimated.nativeProxy.NativeProxyCommon;
import com.swmansion.worklets.WorkletsModule;
import com.swmansion.worklets.b;
import d6.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeProxy extends NativeProxyCommon {
    @a
    private final HybridData mHybridData;
    private final AtomicBoolean mInvalidated = new AtomicBoolean(false);

    @OptIn(markerClass = {f6.a.class})
    public NativeProxy(ReactApplicationContext reactApplicationContext, WorkletsModule workletsModule) {
        super(reactApplicationContext);
        CallInvokerHolderImpl a10 = b.a(reactApplicationContext);
        LayoutAnimations layoutAnimations = new LayoutAnimations(reactApplicationContext);
        JavaScriptContextHolder javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder();
        Objects.requireNonNull(javaScriptContextHolder);
        this.mHybridData = initHybrid(workletsModule, javaScriptContextHolder.get(), a10, layoutAnimations, false);
        prepareLayoutAnimations(layoutAnimations);
        installJSIBindings();
    }

    public static NativeMethodsHolder createNativeMethodsHolder(LayoutAnimations layoutAnimations) {
        final WeakReference weakReference = new WeakReference(layoutAnimations);
        return new NativeMethodsHolder() {
            public void cancelAnimation(int i10) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    layoutAnimations.cancelAnimationForTag(i10);
                }
            }

            public void checkDuplicateSharedTag(int i10, int i11) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    layoutAnimations.checkDuplicateSharedTag(i10, i11);
                }
            }

            public void clearAnimationConfig(int i10) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    layoutAnimations.clearAnimationConfigForTag(i10);
                }
            }

            public int findPrecedingViewTagForTransition(int i10) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    return layoutAnimations.findPrecedingViewTagForTransition(i10);
                }
                return -1;
            }

            public int[] getSharedGroup(int i10) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    return layoutAnimations.getSharedGroup(i10);
                }
                return new int[0];
            }

            public boolean hasAnimation(int i10, int i11) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    return layoutAnimations.hasAnimationForTag(i10, i11);
                }
                return false;
            }

            public boolean isLayoutAnimationEnabled() {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    return layoutAnimations.isLayoutAnimationEnabled();
                }
                return false;
            }

            public boolean shouldAnimateExiting(int i10, boolean z10) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    return layoutAnimations.shouldAnimateExiting(i10, z10);
                }
                return false;
            }

            public void startAnimation(int i10, int i11, HashMap<String, Object> hashMap) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    HashMap hashMap2 = new HashMap();
                    for (String next : hashMap.keySet()) {
                        String obj = hashMap.get(next).toString();
                        if (next.endsWith("TransformMatrix")) {
                            hashMap2.put(next, Utils.simplifyStringNumbersList(obj));
                        } else {
                            hashMap2.put(next, obj);
                        }
                    }
                    layoutAnimations.startAnimationForTag(i10, i11, hashMap2);
                }
            }
        };
    }

    @OptIn(markerClass = {f6.a.class})
    private native HybridData initHybrid(WorkletsModule workletsModule, long j10, CallInvokerHolderImpl callInvokerHolderImpl, LayoutAnimations layoutAnimations, boolean z10);

    private native void invalidateCpp();

    /* access modifiers changed from: protected */
    public HybridData getHybridData() {
        return this.mHybridData;
    }

    /* access modifiers changed from: protected */
    public void invalidate() {
        HybridData hybridData;
        if (!this.mInvalidated.getAndSet(true) && (hybridData = this.mHybridData) != null && hybridData.isValid()) {
            invalidateCpp();
        }
    }

    public native boolean isAnyHandlerWaitingForEvent(String str, int i10);

    public native void performOperations();
}
