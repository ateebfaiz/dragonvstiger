package com.facebook.react.fabric;

import com.facebook.jni.HybridData;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class CoreComponentsRegistry {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HybridData mHybridData;

    public static final class Companion {
        private Companion() {
        }

        public final CoreComponentsRegistry register(ComponentFactory componentFactory) {
            m.f(componentFactory, "componentFactory");
            return new CoreComponentsRegistry(componentFactory, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        FabricSoLoader.staticInit();
    }

    public /* synthetic */ CoreComponentsRegistry(ComponentFactory componentFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(componentFactory);
    }

    private static /* synthetic */ void getMHybridData$annotations() {
    }

    private final native HybridData initHybrid(ComponentFactory componentFactory);

    public static final CoreComponentsRegistry register(ComponentFactory componentFactory) {
        return Companion.register(componentFactory);
    }

    private CoreComponentsRegistry(ComponentFactory componentFactory) {
        this.mHybridData = initHybrid(componentFactory);
    }
}
