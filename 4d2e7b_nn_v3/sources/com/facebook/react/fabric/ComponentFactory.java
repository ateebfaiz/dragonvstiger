package com.facebook.react.fabric;

import com.facebook.jni.HybridData;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ComponentFactory {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HybridData mHybridData = Companion.initHybrid();

    private static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        public final HybridData initHybrid() {
            return ComponentFactory.initHybrid();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        FabricSoLoader.staticInit();
    }

    private static /* synthetic */ void getMHybridData$annotations() {
    }

    /* access modifiers changed from: private */
    public static final native HybridData initHybrid();
}
