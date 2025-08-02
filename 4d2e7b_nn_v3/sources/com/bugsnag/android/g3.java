package com.bugsnag.android;

import c1.f;
import com.bugsnag.android.k2;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class g3 {

    /* renamed from: b  reason: collision with root package name */
    public static final a f18749b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final Set f18750c = r0.c(Pattern.compile(".*password.*", 2));

    /* renamed from: a  reason: collision with root package name */
    private Set f18751a = f18750c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void a(k2 k2Var, Object obj) {
        k2Var.h();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            g(this, Array.get(obj, i10), k2Var, false, 4, (Object) null);
        }
        k2Var.m();
    }

    private final void b(k2 k2Var, Collection collection) {
        k2Var.h();
        for (Object g10 : collection) {
            g(this, g10, k2Var, false, 4, (Object) null);
        }
        k2Var.m();
    }

    private final boolean d(String str) {
        Iterable<Pattern> iterable = this.f18751a;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (Pattern matcher : iterable) {
            if (matcher.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    private final void e(k2 k2Var, Map map, boolean z10) {
        k2Var.j();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key instanceof String) {
                String str = (String) key;
                k2Var.v(str);
                if (!z10 || !d(str)) {
                    f(entry.getValue(), k2Var, z10);
                } else {
                    k2Var.K("[REDACTED]");
                }
            }
        }
        k2Var.n();
    }

    public static /* synthetic */ void g(g3 g3Var, Object obj, k2 k2Var, boolean z10, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        g3Var.f(obj, k2Var, z10);
    }

    public final Set c() {
        return this.f18751a;
    }

    public final void f(Object obj, k2 k2Var, boolean z10) {
        if (obj == null) {
            k2Var.y();
        } else if (obj instanceof String) {
            k2Var.K((String) obj);
        } else if (obj instanceof Number) {
            k2Var.J((Number) obj);
        } else if (obj instanceof Boolean) {
            k2Var.L(((Boolean) obj).booleanValue());
        } else if (obj instanceof k2.a) {
            ((k2.a) obj).toStream(k2Var);
        } else if (obj instanceof Date) {
            k2Var.K(f.c((Date) obj));
        } else if (obj instanceof Map) {
            e(k2Var, (Map) obj, z10);
        } else if (obj instanceof Collection) {
            b(k2Var, (Collection) obj);
        } else if (obj.getClass().isArray()) {
            a(k2Var, obj);
        } else {
            k2Var.K("[OBJECT]");
        }
    }

    public final void h(Set set) {
        this.f18751a = set;
    }
}
