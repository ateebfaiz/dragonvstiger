package u8;

import com.alibaba.pdns.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.coroutines.d;
import w8.c;
import y8.i;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Object f13136a;

    /* renamed from: b  reason: collision with root package name */
    private final Class f13137b;

    /* renamed from: c  reason: collision with root package name */
    private Class[] f13138c;

    /* renamed from: d  reason: collision with root package name */
    private Class f13139d;

    /* renamed from: e  reason: collision with root package name */
    private String[] f13140e;

    /* renamed from: f  reason: collision with root package name */
    private final String f13141f;

    /* renamed from: g  reason: collision with root package name */
    private final String f13142g;

    /* renamed from: h  reason: collision with root package name */
    private Method f13143h;

    /* renamed from: i  reason: collision with root package name */
    private Method f13144i;

    /* renamed from: j  reason: collision with root package name */
    private Method f13145j;

    /* renamed from: k  reason: collision with root package name */
    private String[] f13146k;

    /* renamed from: l  reason: collision with root package name */
    private final String f13147l;

    /* renamed from: m  reason: collision with root package name */
    private i f13148m;

    /* renamed from: n  reason: collision with root package name */
    private Class f13149n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f13150o;

    /* renamed from: p  reason: collision with root package name */
    private final String f13151p;

    /* renamed from: q  reason: collision with root package name */
    private c f13152q;

    /* renamed from: r  reason: collision with root package name */
    private List f13153r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f13154s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f13155t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f13156u;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        Annotation f13157a;

        /* renamed from: b  reason: collision with root package name */
        v8.b f13158b;

        public a(v8.b bVar) {
            this.f13158b = bVar;
        }

        public String toString() {
            String str;
            String str2;
            Annotation annotation = this.f13157a;
            if (annotation != null) {
                str = annotation.annotationType().getName();
            } else {
                str = "null";
            }
            v8.b bVar = this.f13158b;
            if (bVar != null) {
                str2 = bVar.getClass().getName();
            } else {
                str2 = "null";
            }
            return "PointCutAnnotation{annotation=" + str + ", basePointCut=" + "null" + ", matchClassMethod=" + str2 + "}";
        }
    }

    static {
        y8.a.f13334a.a();
    }

    public b(String str, Class cls, String str2, String str3, boolean z10, Object obj) {
        this.f13151p = str;
        this.f13147l = cls.getName();
        this.f13142g = str2;
        this.f13141f = str3;
        this.f13137b = cls;
        this.f13150o = z10;
        this.f13136a = obj;
    }

    private static String b(String str) {
        for (StackTraceElement methodName : Thread.currentThread().getStackTrace()) {
            String methodName2 = methodName.getMethodName();
            if (methodName2.contains(str)) {
                return methodName2;
            }
        }
        return null;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            java.lang.reflect.Method r2 = r6.f13143h
            if (r2 == 0) goto L_0x000b
            java.lang.reflect.Method r2 = r6.f13145j
            if (r2 == 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.Class[] r2 = r6.f13138c     // Catch:{ NoSuchMethodException -> 0x0012 }
            if (r2 != 0) goto L_0x0014
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0012 }
            goto L_0x0014
        L_0x0012:
            r0 = move-exception
            goto L_0x006f
        L_0x0014:
            java.lang.Class r3 = r6.f13137b     // Catch:{ NoSuchMethodException -> 0x0012 }
            if (r3 == 0) goto L_0x0067
            java.lang.String r4 = r6.f13141f     // Catch:{ NoSuchMethodException -> 0x0012 }
            java.lang.reflect.Method r4 = r3.getDeclaredMethod(r4, r2)     // Catch:{ NoSuchMethodException -> 0x0012 }
            r6.f13143h = r4     // Catch:{ NoSuchMethodException -> 0x0012 }
            java.lang.String r4 = r6.f13142g     // Catch:{ NoSuchMethodException -> 0x0029 }
            java.lang.reflect.Method r4 = r3.getDeclaredMethod(r4, r2)     // Catch:{ NoSuchMethodException -> 0x0029 }
            r6.f13145j = r4     // Catch:{ NoSuchMethodException -> 0x0029 }
            goto L_0x0038
        L_0x0029:
            r4 = move-exception
            java.lang.String r5 = r6.f13142g     // Catch:{ NoSuchMethodException -> 0x0012 }
            java.lang.String r5 = b(r5)     // Catch:{ NoSuchMethodException -> 0x0012 }
            if (r5 == 0) goto L_0x0061
            java.lang.reflect.Method r2 = r3.getDeclaredMethod(r5, r2)     // Catch:{ NoSuchMethodException -> 0x0012 }
            r6.f13145j = r2     // Catch:{ NoSuchMethodException -> 0x0012 }
        L_0x0038:
            java.lang.reflect.Method r2 = r6.f13143h     // Catch:{ NoSuchMethodException -> 0x0012 }
            r2.setAccessible(r0)     // Catch:{ NoSuchMethodException -> 0x0012 }
            java.lang.reflect.Method r2 = r6.f13145j     // Catch:{ NoSuchMethodException -> 0x0012 }
            r2.setAccessible(r0)     // Catch:{ NoSuchMethodException -> 0x0012 }
            boolean r2 = r6.f13154s     // Catch:{ NoSuchMethodException -> 0x0012 }
            if (r2 == 0) goto L_0x0060
            java.lang.Class r2 = r6.f13149n     // Catch:{ NoSuchMethodException -> 0x0012 }
            if (r2 == 0) goto L_0x0060
            java.lang.String r3 = r6.f13151p     // Catch:{ NoSuchMethodException -> 0x0012 }
            r4 = 2
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0012 }
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            r4[r1] = r5     // Catch:{ NoSuchMethodException -> 0x0012 }
            java.lang.Class<java.lang.Object[]> r1 = java.lang.Object[].class
            r4[r0] = r1     // Catch:{ NoSuchMethodException -> 0x0012 }
            java.lang.reflect.Method r1 = r2.getDeclaredMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0012 }
            r6.f13144i = r1     // Catch:{ NoSuchMethodException -> 0x0012 }
            r1.setAccessible(r0)     // Catch:{ NoSuchMethodException -> 0x0012 }
        L_0x0060:
            return
        L_0x0061:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ NoSuchMethodException -> 0x0012 }
            r0.<init>(r4)     // Catch:{ NoSuchMethodException -> 0x0012 }
            throw r0     // Catch:{ NoSuchMethodException -> 0x0012 }
        L_0x0067:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ NoSuchMethodException -> 0x0012 }
            java.lang.String r1 = "织入代码异常"
            r0.<init>(r1)     // Catch:{ NoSuchMethodException -> 0x0012 }
            throw r0     // Catch:{ NoSuchMethodException -> 0x0012 }
        L_0x006f:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u8.b.c():void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object e(ListIterator listIterator, d dVar, boolean z10, d dVar2, Object[] objArr) {
        Object obj;
        if (!listIterator.hasNext()) {
            return objArr[0];
        }
        a aVar = (a) listIterator.next();
        x8.b.f13236a.c(dVar, listIterator.hasNext());
        aVar.getClass();
        if (z10) {
            try {
                obj = aVar.f13158b.invoke(dVar, dVar.c().getName());
            } catch (ClassCastException e10) {
                String message = e10.getMessage();
                if (message == null || !message.contains("kotlin.coroutines.intrinsics.CoroutineSingletons")) {
                    throw e10;
                }
                throw new w8.d("协程函数的切面不可修改返回值，请使用 MatchClassMethodSuspend");
            }
        } else {
            obj = aVar.f13158b.invoke(dVar, dVar.c().getName());
        }
        objArr[0] = obj;
        return obj;
    }

    public Object d(Object[] objArr, d dVar) {
        d dVar2;
        Object obj = this.f13136a;
        boolean z10 = this.f13155t;
        y8.d dVar3 = y8.d.f13338a;
        Object[] d10 = dVar3.d();
        if (z10) {
            dVar2 = x8.b.f13236a.b(this.f13137b, objArr, obj, true, this.f13143h, this.f13148m, this.f13152q);
        } else {
            dVar2 = x8.b.f13236a.a(this.f13137b, objArr, obj, false, this.f13143h, this.f13148m, this.f13152q);
        }
        x8.b bVar = x8.b.f13236a;
        bVar.e(dVar2, this.f13144i);
        ListIterator listIterator = this.f13153r.listIterator();
        bVar.c(dVar2, this.f13156u);
        if (listIterator.hasNext()) {
            if (this.f13156u) {
                bVar.d(dVar2, new a(listIterator, dVar2, z10, dVar, d10));
            }
            a aVar = (a) listIterator.next();
            aVar.getClass();
            if (z10) {
                try {
                    d10[0] = aVar.f13158b.invoke(dVar2, dVar2.c().getName());
                } catch (ClassCastException e10) {
                    String message = e10.getMessage();
                    if (message == null || !message.contains("kotlin.coroutines.intrinsics.CoroutineSingletons")) {
                        throw e10;
                    }
                    throw new w8.d("协程函数的切面不可修改返回值，请使用 MatchClassMethodSuspend");
                }
            } else {
                d10[0] = aVar.f13158b.invoke(dVar2, dVar2.c().getName());
            }
            return dVar3.g(d10);
        } else if (!y8.a.f13334a.b()) {
            return dVar2.b();
        } else {
            String str = this.f13147l;
            String str2 = this.f13142g;
            throw new c("在" + str + f.G + str2 + "上没有找到切面处理类，请 clean 项目并重新编译");
        }
    }

    public void f(Class[] clsArr) {
        this.f13138c = clsArr;
    }

    public void g(String[] strArr) {
        this.f13146k = strArr;
    }

    public void h(i iVar, boolean z10) {
        boolean z11 = false;
        this.f13154s = false;
        this.f13148m = iVar;
        this.f13155t = z10;
        c();
        if (this.f13152q == null) {
            this.f13152q = new x8.a(this.f13145j, z10, this.f13140e, this.f13138c, this.f13139d, this.f13150o);
        }
        if (this.f13153r == null) {
            Annotation[] annotations = this.f13145j.getAnnotations();
            this.f13153r = new ArrayList();
            for (Annotation annotationType : annotations) {
                y8.d.f13338a.e(annotationType.annotationType().getName());
            }
            String[] strArr = this.f13146k;
            if (strArr != null) {
                for (String f10 : strArr) {
                    v8.c f11 = y8.d.f13338a.f(f10);
                    if (f11 != null) {
                        this.f13153r.add(new a(f11.newInstance()));
                    }
                }
            }
        }
        if (this.f13153r.size() > 1) {
            z11 = true;
        }
        this.f13156u = z11;
    }

    public void i(String[] strArr) {
        this.f13140e = strArr;
    }

    public void j(Class cls) {
        this.f13139d = cls;
    }
}
