package com.facebook.react.turbomodule.core;

import com.facebook.jni.HybridData;
import com.facebook.react.internal.turbomodule.core.NativeModuleSoLoader;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import f6.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

@a
public final class CallInvokerHolderImpl implements CallInvokerHolder {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @d6.a
    private final HybridData mHybridData;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        NativeModuleSoLoader.Companion.maybeLoadSoLibrary();
    }

    private CallInvokerHolderImpl(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
