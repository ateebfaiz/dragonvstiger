package com.facebook.react.bridge;

import androidx.annotation.Nullable;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaJSExecutor;
import d6.a;

@a
public class ProxyJavaScriptExecutor extends JavaScriptExecutor {
    @Nullable
    private JavaJSExecutor mJavaJSExecutor;

    public static class Factory implements JavaScriptExecutorFactory {
        private final JavaJSExecutor.Factory mJavaJSExecutorFactory;

        public Factory(JavaJSExecutor.Factory factory) {
            this.mJavaJSExecutorFactory = factory;
        }

        public JavaScriptExecutor create() throws Exception {
            return new ProxyJavaScriptExecutor(this.mJavaJSExecutorFactory.create());
        }

        public void startSamplingProfiler() {
            throw new UnsupportedOperationException("Starting sampling profiler not supported on " + toString());
        }

        public void stopSamplingProfiler(String str) {
            throw new UnsupportedOperationException("Stopping sampling profiler not supported on " + toString());
        }
    }

    static {
        ReactBridge.staticInit();
    }

    public ProxyJavaScriptExecutor(JavaJSExecutor javaJSExecutor) {
        super(initHybrid(javaJSExecutor));
        this.mJavaJSExecutor = javaJSExecutor;
    }

    private static native HybridData initHybrid(JavaJSExecutor javaJSExecutor);

    public void close() {
        JavaJSExecutor javaJSExecutor = this.mJavaJSExecutor;
        if (javaJSExecutor != null) {
            javaJSExecutor.close();
            this.mJavaJSExecutor = null;
        }
    }

    public String getName() {
        return "ProxyJavaScriptExecutor";
    }
}
