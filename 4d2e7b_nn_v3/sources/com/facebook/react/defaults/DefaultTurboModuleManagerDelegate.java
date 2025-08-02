package com.facebook.react.defaults;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.s0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class DefaultTurboModuleManagerDelegate extends s0 {

    /* renamed from: f  reason: collision with root package name */
    private static final b f2945f = new b((DefaultConstructorMarker) null);

    public static final class a extends s0.a {

        /* renamed from: c  reason: collision with root package name */
        private List f2946c = new ArrayList();

        public final a e(Function1 function1) {
            m.f(function1, "provider");
            this.f2946c.add(function1);
            return this;
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public DefaultTurboModuleManagerDelegate b(ReactApplicationContext reactApplicationContext, List list) {
            m.f(reactApplicationContext, "context");
            m.f(list, "packages");
            ArrayList arrayList = new ArrayList();
            for (Function1 invoke : this.f2946c) {
                arrayList.add(invoke.invoke(reactApplicationContext));
            }
            return new DefaultTurboModuleManagerDelegate(reactApplicationContext, list, arrayList, (DefaultConstructorMarker) null);
        }
    }

    private static final class b {
        private b() {
        }

        @d6.a
        public final HybridData initHybrid(List<Object> list) {
            return DefaultTurboModuleManagerDelegate.initHybrid(list);
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        c.f2950a.a();
    }

    public /* synthetic */ DefaultTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, list, list2);
    }

    @d6.a
    public static final native HybridData initHybrid(List<Object> list);

    /* access modifiers changed from: protected */
    public HybridData initHybrid() {
        throw new UnsupportedOperationException("DefaultTurboModuleManagerDelegate.initHybrid() must never be called!");
    }

    private DefaultTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List list, List list2) {
        super(reactApplicationContext, list, f2945f.initHybrid(list2));
    }
}
