package com.facebook.yoga;

public class YogaNodeJNIFinalizer extends YogaNodeJNIBase {
    public YogaNodeJNIFinalizer() {
    }

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
            YogaNative.jni_YGNodeFinalizeJNI(j10);
        }
    }

    public YogaNodeJNIFinalizer(c cVar) {
        super(cVar);
    }
}
