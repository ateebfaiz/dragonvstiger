package com.swmansion.worklets;

import androidx.annotation.OptIn;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.soloader.SoLoader;
import com.swmansion.reanimated.NativeWorkletsModuleSpec;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import s6.a;

@a(name = "WorkletsModule")
public class WorkletsModule extends NativeWorkletsModuleSpec {
    private final AndroidUIScheduler mAndroidUIScheduler;
    @d6.a
    private HybridData mHybridData;
    private final AtomicBoolean mInvalidated = new AtomicBoolean(false);
    private final WorkletsMessageQueueThread mMessageQueueThread = new WorkletsMessageQueueThread();

    static {
        SoLoader.t("worklets");
    }

    public WorkletsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mAndroidUIScheduler = new AndroidUIScheduler(reactApplicationContext);
    }

    @OptIn(markerClass = {f6.a.class})
    private native HybridData initHybrid(long j10, String str, MessageQueueThread messageQueueThread, CallInvokerHolderImpl callInvokerHolderImpl, AndroidUIScheduler androidUIScheduler);

    private native void invalidateCpp();

    public AndroidUIScheduler getAndroidUIScheduler() {
        return this.mAndroidUIScheduler;
    }

    /* access modifiers changed from: protected */
    public HybridData getHybridData() {
        return this.mHybridData;
    }

    @OptIn(markerClass = {f6.a.class})
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean installTurboModule(String str) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        JavaScriptContextHolder javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder();
        Objects.requireNonNull(javaScriptContextHolder);
        String str2 = str;
        this.mHybridData = initHybrid(javaScriptContextHolder.get(), str2, this.mMessageQueueThread, b.a(reactApplicationContext), this.mAndroidUIScheduler);
        return true;
    }

    public void invalidate() {
        if (!this.mInvalidated.getAndSet(true)) {
            HybridData hybridData = this.mHybridData;
            if (hybridData != null && hybridData.isValid()) {
                invalidateCpp();
            }
            this.mAndroidUIScheduler.c();
        }
    }
}
