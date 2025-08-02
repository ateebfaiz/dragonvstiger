package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.introspect.t;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.type.o;
import com.fasterxml.jackson.databind.util.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

public class k extends u {

    /* renamed from: d  reason: collision with root package name */
    private final t.a f5375d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f5376e;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public h0 f5377a;

        /* renamed from: b  reason: collision with root package name */
        public Method f5378b;

        /* renamed from: c  reason: collision with root package name */
        public o f5379c;

        public a(h0 h0Var, Method method, o oVar) {
            this.f5377a = h0Var;
            this.f5378b = method;
            this.f5379c = oVar;
        }

        public j a() {
            Method method = this.f5378b;
            if (method == null) {
                return null;
            }
            return new j(this.f5377a, method, this.f5379c.b(), (p[]) null);
        }
    }

    k(b bVar, t.a aVar, boolean z10) {
        super(bVar);
        this.f5375d = bVar == null ? null : aVar;
        this.f5376e = z10;
    }

    private void i(h0 h0Var, Class cls, Map map, Class cls2) {
        o oVar;
        if (cls2 != null) {
            j(h0Var, cls, map, cls2);
        }
        if (cls != null) {
            for (Method method : f.v(cls)) {
                if (k(method)) {
                    y yVar = new y(method);
                    a aVar = (a) map.get(yVar);
                    if (aVar == null) {
                        if (this.f5418a == null) {
                            oVar = o.e();
                        } else {
                            oVar = e(method.getDeclaredAnnotations());
                        }
                        map.put(yVar, new a(h0Var, method, oVar));
                    } else {
                        if (this.f5376e) {
                            aVar.f5379c = f(aVar.f5379c, method.getDeclaredAnnotations());
                        }
                        Method method2 = aVar.f5378b;
                        if (method2 == null) {
                            aVar.f5378b = method;
                        } else if (Modifier.isAbstract(method2.getModifiers()) && !Modifier.isAbstract(method.getModifiers())) {
                            aVar.f5378b = method;
                            aVar.f5377a = h0Var;
                        }
                    }
                }
            }
        }
    }

    private static boolean k(Method method) {
        if (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge() || method.getParameterTypes().length > 2) {
            return false;
        }
        return true;
    }

    public static l m(b bVar, h0 h0Var, t.a aVar, o oVar, j jVar, List list, Class cls, boolean z10) {
        return new k(bVar, aVar, z10).l(oVar, h0Var, jVar, list, cls);
    }

    /* access modifiers changed from: protected */
    public void j(h0 h0Var, Class cls, Map map, Class cls2) {
        if (this.f5418a != null) {
            for (Class declaredMethods : f.t(cls2, cls, true)) {
                for (Method method : declaredMethods.getDeclaredMethods()) {
                    if (k(method)) {
                        y yVar = new y(method);
                        a aVar = (a) map.get(yVar);
                        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                        if (aVar == null) {
                            map.put(yVar, new a(h0Var, (Method) null, e(declaredAnnotations)));
                        } else {
                            aVar.f5379c = f(aVar.f5379c, declaredAnnotations);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003f, code lost:
        r8 = java.lang.Object.class;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.introspect.l l(com.fasterxml.jackson.databind.type.o r5, com.fasterxml.jackson.databind.introspect.h0 r6, com.fasterxml.jackson.databind.j r7, java.util.List r8, java.lang.Class r9) {
        /*
            r4 = this;
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.lang.Class r1 = r7.s()
            r4.i(r6, r1, r0, r9)
            java.util.Iterator r8 = r8.iterator()
        L_0x0010:
            boolean r9 = r8.hasNext()
            r1 = 0
            if (r9 == 0) goto L_0x003b
            java.lang.Object r9 = r8.next()
            com.fasterxml.jackson.databind.j r9 = (com.fasterxml.jackson.databind.j) r9
            com.fasterxml.jackson.databind.introspect.t$a r2 = r4.f5375d
            if (r2 != 0) goto L_0x0022
            goto L_0x002a
        L_0x0022:
            java.lang.Class r1 = r9.s()
            java.lang.Class r1 = r2.a(r1)
        L_0x002a:
            com.fasterxml.jackson.databind.introspect.h0$a r2 = new com.fasterxml.jackson.databind.introspect.h0$a
            com.fasterxml.jackson.databind.type.n r3 = r9.k()
            r2.<init>(r5, r3)
            java.lang.Class r9 = r9.s()
            r4.i(r2, r9, r0, r1)
            goto L_0x0010
        L_0x003b:
            com.fasterxml.jackson.databind.introspect.t$a r5 = r4.f5375d
            if (r5 == 0) goto L_0x00a4
            java.lang.Class<java.lang.Object> r8 = java.lang.Object.class
            java.lang.Class r5 = r5.a(r8)
            if (r5 == 0) goto L_0x00a4
            java.lang.Class r7 = r7.s()
            r4.j(r6, r7, r0, r5)
            com.fasterxml.jackson.databind.b r5 = r4.f5418a
            if (r5 == 0) goto L_0x00a4
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x00a4
            java.util.Set r5 = r0.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0060:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00a4
            java.lang.Object r6 = r5.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r7 = r6.getKey()
            com.fasterxml.jackson.databind.introspect.y r7 = (com.fasterxml.jackson.databind.introspect.y) r7
            java.lang.String r9 = r7.b()
            java.lang.String r2 = "hashCode"
            boolean r9 = r2.equals(r9)
            if (r9 == 0) goto L_0x0060
            int r9 = r7.a()
            if (r9 == 0) goto L_0x0085
            goto L_0x0060
        L_0x0085:
            java.lang.String r7 = r7.b()     // Catch:{ Exception -> 0x0060 }
            java.lang.reflect.Method r7 = r8.getDeclaredMethod(r7, r1)     // Catch:{ Exception -> 0x0060 }
            if (r7 == 0) goto L_0x0060
            java.lang.Object r6 = r6.getValue()     // Catch:{ Exception -> 0x0060 }
            com.fasterxml.jackson.databind.introspect.k$a r6 = (com.fasterxml.jackson.databind.introspect.k.a) r6     // Catch:{ Exception -> 0x0060 }
            com.fasterxml.jackson.databind.introspect.o r9 = r6.f5379c     // Catch:{ Exception -> 0x0060 }
            java.lang.annotation.Annotation[] r2 = r7.getDeclaredAnnotations()     // Catch:{ Exception -> 0x0060 }
            com.fasterxml.jackson.databind.introspect.o r9 = r4.f(r9, r2)     // Catch:{ Exception -> 0x0060 }
            r6.f5379c = r9     // Catch:{ Exception -> 0x0060 }
            r6.f5378b = r7     // Catch:{ Exception -> 0x0060 }
            goto L_0x0060
        L_0x00a4:
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L_0x00b0
            com.fasterxml.jackson.databind.introspect.l r5 = new com.fasterxml.jackson.databind.introspect.l
            r5.<init>()
            return r5
        L_0x00b0:
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            int r6 = r0.size()
            r5.<init>(r6)
            java.util.Set r6 = r0.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x00c1:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00e1
            java.lang.Object r7 = r6.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getValue()
            com.fasterxml.jackson.databind.introspect.k$a r8 = (com.fasterxml.jackson.databind.introspect.k.a) r8
            com.fasterxml.jackson.databind.introspect.j r8 = r8.a()
            if (r8 == 0) goto L_0x00c1
            java.lang.Object r7 = r7.getKey()
            r5.put(r7, r8)
            goto L_0x00c1
        L_0x00e1:
            com.fasterxml.jackson.databind.introspect.l r6 = new com.fasterxml.jackson.databind.introspect.l
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.k.l(com.fasterxml.jackson.databind.type.o, com.fasterxml.jackson.databind.introspect.h0, com.fasterxml.jackson.databind.j, java.util.List, java.lang.Class):com.fasterxml.jackson.databind.introspect.l");
    }
}
