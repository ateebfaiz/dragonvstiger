package com.facebook.yoga;

public class YogaConfigJNIFinalizer extends YogaConfigJNIBase {
    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            freeNatives();
        } finally {
            super.finalize();
        }
    }

    public void freeNatives() {
        long j10 = this.mNativePointer;
        if (j10 != 0) {
            this.mNativePointer = 0;
            YogaNative.jni_YGConfigFreeJNI(j10);
        }
    }
}
