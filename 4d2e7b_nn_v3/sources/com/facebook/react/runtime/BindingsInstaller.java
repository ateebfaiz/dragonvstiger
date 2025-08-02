package com.facebook.react.runtime;

import com.facebook.jni.HybridData;
import com.facebook.soloader.SoLoader;
import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class BindingsInstaller {
    private static final a Companion = new a((DefaultConstructorMarker) null);
    @d6.a
    private final HybridData mHybridData;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        SoLoader.t("rninstance");
    }

    public BindingsInstaller(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
