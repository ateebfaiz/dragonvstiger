package com.facebook.react.uimanager;

import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public enum h0 {
    NONE,
    BOX_NONE,
    BOX_ONLY,
    AUTO;
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f3688a = null;

    public static final class a {
        private a() {
        }

        public final boolean a(h0 h0Var) {
            m.f(h0Var, "pointerEvents");
            if (h0Var == h0.AUTO || h0Var == h0.BOX_ONLY) {
                return true;
            }
            return false;
        }

        public final boolean b(h0 h0Var) {
            m.f(h0Var, "pointerEvents");
            if (h0Var == h0.AUTO || h0Var == h0.BOX_NONE) {
                return true;
            }
            return false;
        }

        public final h0 c(String str) {
            if (str == null) {
                return h0.AUTO;
            }
            Locale locale = Locale.US;
            m.e(locale, "US");
            String upperCase = str.toUpperCase(locale);
            m.e(upperCase, "toUpperCase(...)");
            return h0.valueOf(j.z(upperCase, "-", "_", false, 4, (Object) null));
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        h0[] a10;
        f3694g = pb.a.a(a10);
        f3688a = new a((DefaultConstructorMarker) null);
    }

    public static final boolean b(h0 h0Var) {
        return f3688a.a(h0Var);
    }

    public static final boolean c(h0 h0Var) {
        return f3688a.b(h0Var);
    }

    public static final h0 d(String str) {
        return f3688a.c(str);
    }
}
