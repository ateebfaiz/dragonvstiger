package com.th3rdwave.safeareacontext;

import android.view.View;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.p;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.t;
import p7.o;
import vb.n;

@s6.a(name = "RNCSafeAreaProvider")
public final class SafeAreaProviderManager extends ViewGroupManager<SafeAreaProvider> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNCSafeAreaProvider";
    private final o mDelegate = new o(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* synthetic */ class b extends j implements n {

        /* renamed from: a  reason: collision with root package name */
        public static final b f11701a = new b();

        b() {
            super(3, f.class, "handleOnInsetsChange", "handleOnInsetsChange(Lcom/th3rdwave/safeareacontext/SafeAreaProvider;Lcom/th3rdwave/safeareacontext/EdgeInsets;Lcom/th3rdwave/safeareacontext/Rect;)V", 1);
        }

        public final void c(SafeAreaProvider safeAreaProvider, a aVar, c cVar) {
            m.f(safeAreaProvider, "p0");
            m.f(aVar, "p1");
            m.f(cVar, "p2");
            f.b(safeAreaProvider, aVar, cVar);
        }

        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3) {
            c((SafeAreaProvider) obj, (a) obj2, (c) obj3);
            return Unit.f12577a;
        }
    }

    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        return i0.j(t.a("topInsetsChange", i0.j(t.a("registrationName", "onInsetsChange"))));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(e1 e1Var, SafeAreaProvider safeAreaProvider) {
        m.f(e1Var, "reactContext");
        m.f(safeAreaProvider, "view");
        super.addEventEmitters(e1Var, safeAreaProvider);
        safeAreaProvider.setOnInsetsChangeHandler(b.f11701a);
    }

    public SafeAreaProvider createViewInstance(e1 e1Var) {
        m.f(e1Var, "context");
        return new SafeAreaProvider(e1Var);
    }

    /* access modifiers changed from: protected */
    public o getDelegate() {
        return this.mDelegate;
    }
}
