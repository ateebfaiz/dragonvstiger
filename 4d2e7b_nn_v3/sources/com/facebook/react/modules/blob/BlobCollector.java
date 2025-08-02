package com.facebook.react.modules.blob;

import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactContext;
import com.facebook.soloader.SoLoader;

abstract class BlobCollector {

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReactContext f3198a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BlobModule f3199b;

        a(ReactContext reactContext, BlobModule blobModule) {
            this.f3198a = reactContext;
            this.f3199b = blobModule;
        }

        public void run() {
            JavaScriptContextHolder javaScriptContextHolder = this.f3198a.getJavaScriptContextHolder();
            if (javaScriptContextHolder != null && javaScriptContextHolder.get() != 0) {
                BlobCollector.nativeInstall(this.f3199b, javaScriptContextHolder.get());
            }
        }
    }

    static {
        SoLoader.t("reactnativeblob");
    }

    static void b(ReactContext reactContext, BlobModule blobModule) {
        reactContext.runOnJSQueueThread(new a(reactContext, blobModule));
    }

    /* access modifiers changed from: private */
    public static native void nativeInstall(Object obj, long j10);
}
