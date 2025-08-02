package com.facebook.yoga;

public abstract class YogaConfigJNIBase extends c {
    private YogaLogger mLogger;
    long mNativePointer;

    private YogaConfigJNIBase(long j10) {
        if (j10 != 0) {
            this.mNativePointer = j10;
            return;
        }
        throw new IllegalStateException("Failed to allocate native memory");
    }

    public i getErrata() {
        return i.b(YogaNative.jni_YGConfigGetErrataJNI(this.mNativePointer));
    }

    public YogaLogger getLogger() {
        return this.mLogger;
    }

    /* access modifiers changed from: protected */
    public long getNativePointer() {
        return this.mNativePointer;
    }

    public void setErrata(i iVar) {
        YogaNative.jni_YGConfigSetErrataJNI(this.mNativePointer, iVar.c());
    }

    public void setExperimentalFeatureEnabled(j jVar, boolean z10) {
        YogaNative.jni_YGConfigSetExperimentalFeatureEnabledJNI(this.mNativePointer, jVar.b(), z10);
    }

    public void setLogger(YogaLogger yogaLogger) {
        this.mLogger = yogaLogger;
        YogaNative.jni_YGConfigSetLoggerJNI(this.mNativePointer, yogaLogger);
    }

    public void setPointScaleFactor(float f10) {
        YogaNative.jni_YGConfigSetPointScaleFactorJNI(this.mNativePointer, f10);
    }

    public void setUseWebDefaults(boolean z10) {
        YogaNative.jni_YGConfigSetUseWebDefaultsJNI(this.mNativePointer, z10);
    }

    YogaConfigJNIBase() {
        this(YogaNative.jni_YGConfigNewJNI());
    }

    YogaConfigJNIBase(boolean z10) {
        this(YogaNative.jni_YGConfigNewJNI());
    }
}
