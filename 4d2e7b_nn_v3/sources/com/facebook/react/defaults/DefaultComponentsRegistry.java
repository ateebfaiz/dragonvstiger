package com.facebook.react.defaults;

import com.facebook.jni.HybridData;
import com.facebook.react.fabric.ComponentFactory;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@d6.a
public final class DefaultComponentsRegistry {

    /* renamed from: a  reason: collision with root package name */
    public static final a f2935a = new a((DefaultConstructorMarker) null);
    @d6.a
    private final HybridData mHybridData;

    public static final class a {
        private a() {
        }

        @d6.a
        public final DefaultComponentsRegistry register(ComponentFactory componentFactory) {
            m.f(componentFactory, "componentFactory");
            return new DefaultComponentsRegistry(componentFactory, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        c.f2950a.a();
    }

    public /* synthetic */ DefaultComponentsRegistry(ComponentFactory componentFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(componentFactory);
    }

    @d6.a
    private final native HybridData initHybrid(ComponentFactory componentFactory);

    @d6.a
    public static final DefaultComponentsRegistry register(ComponentFactory componentFactory) {
        return f2935a.register(componentFactory);
    }

    @d6.a
    private DefaultComponentsRegistry(ComponentFactory componentFactory) {
        this.mHybridData = initHybrid(componentFactory);
    }
}
