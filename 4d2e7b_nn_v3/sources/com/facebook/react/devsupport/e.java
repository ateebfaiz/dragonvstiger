package com.facebook.react.devsupport;

import android.content.Context;
import com.alibaba.pdns.f;
import e6.j;
import java.util.Map;
import k6.b;
import k6.c;
import k6.h;
import k6.i;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class e implements e0 {

    /* renamed from: a  reason: collision with root package name */
    private static final a f3071a = new a((DefaultConstructorMarker) null);

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public k6.e a(Context context, x0 x0Var, String str, boolean z10, i iVar, b bVar, int i10, Map map, j jVar, c cVar, h hVar) {
        k6.e w0Var;
        Context context2 = context;
        x0 x0Var2 = x0Var;
        m.f(context2, "applicationContext");
        m.f(x0Var2, "reactInstanceManagerHelper");
        if (!z10) {
            return new b1();
        }
        try {
            String str2 = "com.facebook.react.devsupport" + f.G + "BridgeDevSupportManager";
            m.e(str2, "toString(...)");
            Object newInstance = Class.forName(str2).getConstructor(new Class[]{Context.class, x0.class, String.class, Boolean.TYPE, i.class, b.class, Integer.TYPE, Map.class, j.class, c.class, h.class}).newInstance(new Object[]{context2, x0Var2, str, Boolean.TRUE, iVar, bVar, Integer.valueOf(i10), map, jVar, cVar, hVar});
            m.d(newInstance, "null cannot be cast to non-null type com.facebook.react.devsupport.interfaces.DevSupportManager");
            w0Var = (k6.e) newInstance;
        } catch (Exception unused) {
            w0Var = new w0(context2);
        }
        return w0Var;
    }
}
