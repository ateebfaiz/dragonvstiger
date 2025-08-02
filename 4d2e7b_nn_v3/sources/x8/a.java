package x8;

import java.lang.reflect.Method;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import u8.c;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Method f13230a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f13231b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f13232c;

    /* renamed from: d  reason: collision with root package name */
    private final Class[] f13233d;

    /* renamed from: e  reason: collision with root package name */
    private final Class f13234e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f13235f;

    public a(Method method, boolean z10, String[] strArr, Class[] clsArr, Class cls, boolean z11) {
        m.f(method, "targetMethod");
        m.f(strArr, "mParamNames");
        m.f(clsArr, "mParamClasses");
        m.f(cls, "mReturnType");
        this.f13230a = method;
        this.f13231b = z10;
        this.f13232c = strArr;
        this.f13233d = clsArr;
        this.f13234e = cls;
        this.f13235f = z11;
    }

    public Class[] a() {
        if (!this.f13231b) {
            return this.f13233d;
        }
        Class[] clsArr = this.f13233d;
        return (Class[]) j.i(clsArr, 0, clsArr.length - 1);
    }

    public String getName() {
        String name = this.f13230a.getName();
        m.e(name, "targetMethod.name");
        return name;
    }
}
