package x8;

import com.alibaba.pdns.f;
import java.lang.reflect.Method;
import u8.c;
import y8.i;

class d implements u8.d {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f13237a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f13238b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f13239c;

    /* renamed from: d  reason: collision with root package name */
    private final Class f13240d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f13241e;

    /* renamed from: f  reason: collision with root package name */
    private final i f13242f;

    /* renamed from: g  reason: collision with root package name */
    private final c f13243g;

    /* renamed from: h  reason: collision with root package name */
    private final int f13244h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f13245i;

    /* renamed from: j  reason: collision with root package name */
    private final Object f13246j;

    /* renamed from: k  reason: collision with root package name */
    private c f13247k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13248l;

    /* renamed from: m  reason: collision with root package name */
    private Method f13249m;

    d(Class cls, Object[] objArr, Object obj, boolean z10, Method method, i iVar, c cVar) {
        this.f13240d = cls;
        this.f13239c = obj;
        this.f13245i = z10;
        this.f13241e = method;
        this.f13242f = iVar;
        this.f13243g = cVar;
        int i10 = 0;
        if (!z10 || objArr == null) {
            this.f13246j = null;
        } else {
            Object[] objArr2 = new Object[(objArr.length - 1)];
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length - 1);
            this.f13246j = objArr[objArr.length - 1];
            objArr = objArr2;
        }
        this.f13237a = objArr;
        if (objArr != null) {
            this.f13238b = (Object[]) objArr.clone();
        } else {
            this.f13238b = null;
        }
        this.f13244h = objArr != null ? objArr.length : i10;
    }

    private void h(v8.d dVar) {
        Object obj;
        if (this.f13245i && dVar != null && (obj = this.f13246j) != null) {
            y8.d dVar2 = y8.d.f13338a;
            dVar2.b(obj, dVar);
            try {
                Method method = this.f13246j.getClass().getMethod("getCompletion", (Class[]) null);
                method.setAccessible(true);
                Object invoke = method.invoke(this.f13246j, (Object[]) null);
                if (invoke != null) {
                    dVar2.b(invoke, dVar);
                    dVar2.h(obj, invoke);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public Object a() {
        return this.f13239c;
    }

    public Object b() {
        return d(this.f13237a);
    }

    public c c() {
        return this.f13243g;
    }

    public Object d(Object... objArr) {
        return e((v8.d) null, objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object e(v8.d r6, java.lang.Object... r7) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            int r2 = r5.f13244h
            if (r2 <= 0) goto L_0x0014
            if (r7 == 0) goto L_0x000c
            int r3 = r7.length
            if (r3 != r2) goto L_0x000c
            goto L_0x0014
        L_0x000c:
            w8.b r6 = new w8.b
            java.lang.String r7 = "proceed 所参数个数不对"
            r6.<init>(r7)
            throw r6
        L_0x0014:
            boolean r3 = r5.f13245i
            if (r3 == 0) goto L_0x0028
            int r2 = r2 + r0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            if (r7 == 0) goto L_0x0021
            int r3 = r7.length
            java.lang.System.arraycopy(r7, r1, r2, r1, r3)
        L_0x0021:
            int r7 = r5.f13244h
            java.lang.Object r3 = r5.f13246j
            r2[r7] = r3
            r7 = r2
        L_0x0028:
            if (r7 == 0) goto L_0x0034
            java.lang.Object[] r2 = r5.f13237a
            if (r2 == 0) goto L_0x0034
            if (r7 == r2) goto L_0x0034
            int r3 = r2.length
            java.lang.System.arraycopy(r7, r1, r2, r1, r3)
        L_0x0034:
            r5.h(r6)     // Catch:{ all -> 0x0047 }
            boolean r6 = r5.f13248l     // Catch:{ all -> 0x0047 }
            r2 = 0
            if (r6 != 0) goto L_0x0064
            y8.i r6 = r5.f13242f     // Catch:{ all -> 0x0047 }
            if (r6 == 0) goto L_0x0049
            java.lang.Object r0 = r5.f13239c     // Catch:{ all -> 0x0047 }
            java.lang.Object r2 = r6.a(r0, r7)     // Catch:{ all -> 0x0047 }
            goto L_0x006c
        L_0x0047:
            r6 = move-exception
            goto L_0x006d
        L_0x0049:
            java.lang.reflect.Method r6 = r5.f13249m     // Catch:{ all -> 0x0047 }
            if (r6 == 0) goto L_0x005b
            java.lang.Object r3 = r5.f13239c     // Catch:{ all -> 0x0047 }
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0047 }
            r4[r1] = r3     // Catch:{ all -> 0x0047 }
            r4[r0] = r7     // Catch:{ all -> 0x0047 }
            java.lang.Object r2 = r6.invoke(r2, r4)     // Catch:{ all -> 0x0047 }
            goto L_0x006c
        L_0x005b:
            java.lang.reflect.Method r6 = r5.f13241e     // Catch:{ all -> 0x0047 }
            java.lang.Object r0 = r5.f13239c     // Catch:{ all -> 0x0047 }
            java.lang.Object r2 = r6.invoke(r0, r7)     // Catch:{ all -> 0x0047 }
            goto L_0x006c
        L_0x0064:
            x8.c r6 = r5.f13247k     // Catch:{ all -> 0x0047 }
            if (r6 == 0) goto L_0x006c
            java.lang.Object r2 = r6.a()     // Catch:{ all -> 0x0047 }
        L_0x006c:
            return r2
        L_0x006d:
            y8.k r7 = y8.k.f13358a
            java.lang.Throwable r6 = r7.b(r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: x8.d.e(v8.d, java.lang.Object[]):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public void f(boolean z10) {
        this.f13248l = z10;
    }

    /* access modifiers changed from: package-private */
    public void g(c cVar) {
        this.f13247k = cVar;
    }

    /* access modifiers changed from: package-private */
    public void i(Method method) {
        this.f13249m = method;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("JoinPoint[");
        sb2.append(this.f13240d.getName());
        sb2.append(f.G);
        sb2.append(this.f13243g.getName());
        sb2.append("(");
        Class[] a10 = this.f13243g.a();
        for (Class name : a10) {
            sb2.append(name.getName());
            sb2.append(",");
        }
        if (a10.length > 0) {
            sb2.setLength(sb2.length() - 1);
        }
        sb2.append(")]");
        return sb2.toString();
    }
}
