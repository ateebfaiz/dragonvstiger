package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.introspect.c;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.type.o;
import com.fasterxml.jackson.databind.util.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class f extends u {

    /* renamed from: d  reason: collision with root package name */
    private final h0 f5319d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f5320e;

    /* renamed from: f  reason: collision with root package name */
    private e f5321f;

    f(b bVar, h0 h0Var, boolean z10) {
        super(bVar);
        this.f5319d = h0Var;
        this.f5320e = z10;
    }

    private List i(j jVar, Class cls) {
        ArrayList arrayList;
        f.a aVar;
        List list;
        int i10;
        if (!jVar.E()) {
            aVar = null;
            arrayList = null;
            for (f.a aVar2 : com.fasterxml.jackson.databind.util.f.w(jVar.s())) {
                if (t(aVar2.a())) {
                    if (aVar2.d() == 0) {
                        aVar = aVar2;
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(aVar2);
                    }
                }
            }
        } else {
            aVar = null;
            arrayList = null;
        }
        if (arrayList == null) {
            list = Collections.emptyList();
            if (aVar == null) {
                return list;
            }
            i10 = 0;
        } else {
            int size = arrayList.size();
            ArrayList arrayList2 = new ArrayList(size);
            for (int i11 = 0; i11 < size; i11++) {
                arrayList2.add((Object) null);
            }
            ArrayList arrayList3 = arrayList2;
            i10 = size;
            list = arrayList3;
        }
        if (cls != null) {
            y[] yVarArr = null;
            for (f.a aVar3 : com.fasterxml.jackson.databind.util.f.w(cls)) {
                if (aVar3.d() == 0) {
                    if (aVar != null) {
                        this.f5321f = q(aVar, aVar3);
                        aVar = null;
                    }
                } else if (arrayList != null) {
                    if (yVarArr == null) {
                        yVarArr = new y[i10];
                        for (int i12 = 0; i12 < i10; i12++) {
                            yVarArr[i12] = new y(((f.a) arrayList.get(i12)).a());
                        }
                    }
                    y yVar = new y(aVar3.a());
                    int i13 = 0;
                    while (true) {
                        if (i13 >= i10) {
                            break;
                        } else if (yVar.equals(yVarArr[i13])) {
                            list.set(i13, s((f.a) arrayList.get(i13), aVar3));
                            break;
                        } else {
                            i13++;
                        }
                    }
                }
            }
        }
        if (aVar != null) {
            this.f5321f = q(aVar, (f.a) null);
        }
        for (int i14 = 0; i14 < i10; i14++) {
            if (((e) list.get(i14)) == null) {
                list.set(i14, s((f.a) arrayList.get(i14), (f.a) null));
            }
        }
        return list;
    }

    private List j(o oVar, j jVar, Class cls) {
        ArrayList arrayList = null;
        for (Method method : com.fasterxml.jackson.databind.util.f.v(jVar.s())) {
            if (k(method)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(method);
            }
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        h0 h0Var = this.f5319d;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList2.add((Object) null);
        }
        if (cls != null) {
            y[] yVarArr = null;
            for (Method method2 : cls.getDeclaredMethods()) {
                if (k(method2)) {
                    if (yVarArr == null) {
                        yVarArr = new y[size];
                        for (int i11 = 0; i11 < size; i11++) {
                            yVarArr[i11] = new y((Method) arrayList.get(i11));
                        }
                    }
                    y yVar = new y(method2);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= size) {
                            break;
                        } else if (yVar.equals(yVarArr[i12])) {
                            arrayList2.set(i12, r((Method) arrayList.get(i12), h0Var, method2));
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
            }
        }
        for (int i13 = 0; i13 < size; i13++) {
            if (((j) arrayList2.get(i13)) == null) {
                Method method3 = (Method) arrayList.get(i13);
                arrayList2.set(i13, r(method3, z.e(method3, jVar, oVar, h0Var), (Method) null));
            } else {
                o oVar2 = oVar;
                j jVar2 = jVar;
            }
        }
        return arrayList2;
    }

    private static boolean k(Method method) {
        if (!Modifier.isStatic(method.getModifiers()) || method.isSynthetic()) {
            return false;
        }
        return true;
    }

    private p m(f.a aVar, f.a aVar2) {
        if (!this.f5320e) {
            return u.a();
        }
        o e10 = e(aVar.b());
        if (aVar2 != null) {
            e10 = d(e10, aVar2.b());
        }
        return e10.b();
    }

    private final p n(AnnotatedElement annotatedElement, AnnotatedElement annotatedElement2) {
        o e10 = e(annotatedElement.getDeclaredAnnotations());
        if (annotatedElement2 != null) {
            e10 = d(e10, annotatedElement2.getDeclaredAnnotations());
        }
        return e10.b();
    }

    private p[] o(Annotation[][] annotationArr, Annotation[][] annotationArr2) {
        if (!this.f5320e) {
            return u.f5416b;
        }
        int length = annotationArr.length;
        p[] pVarArr = new p[length];
        for (int i10 = 0; i10 < length; i10++) {
            o d10 = d(o.e(), annotationArr[i10]);
            if (annotationArr2 != null) {
                d10 = d(d10, annotationArr2[i10]);
            }
            pVarArr[i10] = d10.b();
        }
        return pVarArr;
    }

    public static c.a p(b bVar, o oVar, h0 h0Var, j jVar, Class cls, boolean z10) {
        boolean z11;
        if (cls != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        return new f(bVar, h0Var, z10 | z11).l(oVar, jVar, cls);
    }

    private static boolean t(Constructor constructor) {
        return !constructor.isSynthetic();
    }

    /* access modifiers changed from: package-private */
    public c.a l(o oVar, j jVar, Class cls) {
        List i10 = i(jVar, cls);
        List j10 = j(oVar, jVar, cls);
        if (this.f5320e) {
            e eVar = this.f5321f;
            if (eVar != null && this.f5418a.f0(eVar)) {
                this.f5321f = null;
            }
            int size = i10.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else if (this.f5418a.f0((i) i10.get(size))) {
                    i10.remove(size);
                }
            }
            int size2 = j10.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    break;
                } else if (this.f5418a.f0((i) j10.get(size2))) {
                    j10.remove(size2);
                }
            }
        }
        return new c.a(this.f5321f, i10, j10);
    }

    /* access modifiers changed from: protected */
    public e q(f.a aVar, f.a aVar2) {
        return new e(this.f5319d, aVar.a(), m(aVar, aVar2), u.f5416b);
    }

    /* access modifiers changed from: protected */
    public j r(Method method, h0 h0Var, Method method2) {
        Annotation[][] annotationArr;
        int length = method.getParameterTypes().length;
        if (this.f5418a == null) {
            return new j(h0Var, method, u.a(), u.b(length));
        }
        if (length == 0) {
            return new j(h0Var, method, n(method, method2), u.f5416b);
        }
        p n10 = n(method, method2);
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (method2 == null) {
            annotationArr = null;
        } else {
            annotationArr = method2.getParameterAnnotations();
        }
        return new j(h0Var, method, n10, o(parameterAnnotations, annotationArr));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.annotation.Annotation[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.fasterxml.jackson.databind.introspect.p[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.annotation.Annotation[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: com.fasterxml.jackson.databind.introspect.p[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: com.fasterxml.jackson.databind.introspect.p[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.annotation.Annotation[][]} */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.introspect.e s(com.fasterxml.jackson.databind.util.f.a r9, com.fasterxml.jackson.databind.util.f.a r10) {
        /*
            r8 = this;
            r0 = 1
            r1 = 2
            r2 = 0
            int r3 = r9.d()
            com.fasterxml.jackson.databind.b r4 = r8.f5418a
            if (r4 != 0) goto L_0x001f
            com.fasterxml.jackson.databind.introspect.e r10 = new com.fasterxml.jackson.databind.introspect.e
            com.fasterxml.jackson.databind.introspect.h0 r0 = r8.f5319d
            java.lang.reflect.Constructor r9 = r9.a()
            com.fasterxml.jackson.databind.introspect.p r1 = com.fasterxml.jackson.databind.introspect.u.a()
            com.fasterxml.jackson.databind.introspect.p[] r2 = com.fasterxml.jackson.databind.introspect.u.b(r3)
            r10.<init>(r0, r9, r1, r2)
            return r10
        L_0x001f:
            if (r3 != 0) goto L_0x0033
            com.fasterxml.jackson.databind.introspect.e r0 = new com.fasterxml.jackson.databind.introspect.e
            com.fasterxml.jackson.databind.introspect.h0 r1 = r8.f5319d
            java.lang.reflect.Constructor r2 = r9.a()
            com.fasterxml.jackson.databind.introspect.p r9 = r8.m(r9, r10)
            com.fasterxml.jackson.databind.introspect.p[] r10 = com.fasterxml.jackson.databind.introspect.u.f5416b
            r0.<init>(r1, r2, r9, r10)
            return r0
        L_0x0033:
            java.lang.annotation.Annotation[][] r4 = r9.e()
            int r5 = r4.length
            r6 = 0
            if (r3 == r5) goto L_0x009b
            java.lang.Class r5 = r9.c()
            boolean r7 = com.fasterxml.jackson.databind.util.f.G(r5)
            if (r7 == 0) goto L_0x0057
            int r7 = r4.length
            int r7 = r7 + r1
            if (r3 != r7) goto L_0x0057
            int r5 = r4.length
            int r5 = r5 + r1
            java.lang.annotation.Annotation[][] r5 = new java.lang.annotation.Annotation[r5][]
            int r7 = r4.length
            java.lang.System.arraycopy(r4, r2, r5, r1, r7)
            com.fasterxml.jackson.databind.introspect.p[] r6 = r8.o(r5, r6)
        L_0x0055:
            r4 = r5
            goto L_0x0072
        L_0x0057:
            boolean r5 = r5.isMemberClass()
            if (r5 == 0) goto L_0x0072
            int r5 = r4.length
            int r5 = r5 + r0
            if (r3 != r5) goto L_0x0072
            int r5 = r4.length
            int r5 = r5 + r0
            java.lang.annotation.Annotation[][] r5 = new java.lang.annotation.Annotation[r5][]
            int r7 = r4.length
            java.lang.System.arraycopy(r4, r2, r5, r0, r7)
            java.lang.annotation.Annotation[] r4 = com.fasterxml.jackson.databind.introspect.u.f5417c
            r5[r2] = r4
            com.fasterxml.jackson.databind.introspect.p[] r6 = r8.o(r5, r6)
            goto L_0x0055
        L_0x0072:
            if (r6 == 0) goto L_0x0075
            goto L_0x00a6
        L_0x0075:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.Class r9 = r9.c()
            java.lang.String r9 = r9.getName()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r4 = r4.length
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r2] = r9
            r5[r0] = r3
            r5[r1] = r4
            java.lang.String r9 = "Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations"
            java.lang.String r9 = java.lang.String.format(r9, r5)
            r10.<init>(r9)
            throw r10
        L_0x009b:
            if (r10 != 0) goto L_0x009e
            goto L_0x00a2
        L_0x009e:
            java.lang.annotation.Annotation[][] r6 = r10.e()
        L_0x00a2:
            com.fasterxml.jackson.databind.introspect.p[] r6 = r8.o(r4, r6)
        L_0x00a6:
            com.fasterxml.jackson.databind.introspect.e r0 = new com.fasterxml.jackson.databind.introspect.e
            com.fasterxml.jackson.databind.introspect.h0 r1 = r8.f5319d
            java.lang.reflect.Constructor r2 = r9.a()
            com.fasterxml.jackson.databind.introspect.p r9 = r8.m(r9, r10)
            r0.<init>(r1, r2, r9, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.f.s(com.fasterxml.jackson.databind.util.f$a, com.fasterxml.jackson.databind.util.f$a):com.fasterxml.jackson.databind.introspect.e");
    }
}
