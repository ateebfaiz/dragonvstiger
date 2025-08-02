package com.bugsnag.android;

import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class p1 {

    /* renamed from: i  reason: collision with root package name */
    public static final a f18911i = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final z f18912a;

    /* renamed from: b  reason: collision with root package name */
    private final Collection f18913b;

    /* renamed from: c  reason: collision with root package name */
    private final k f18914c = new k();

    /* renamed from: d  reason: collision with root package name */
    private final c1 f18915d = new c1();

    /* renamed from: e  reason: collision with root package name */
    private final t3 f18916e;

    /* renamed from: f  reason: collision with root package name */
    private final l1 f18917f;

    /* renamed from: g  reason: collision with root package name */
    private final b4 f18918g;

    /* renamed from: h  reason: collision with root package name */
    private final o f18919h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public p1(z zVar, Collection collection) {
        this.f18912a = zVar;
        this.f18913b = collection;
        t3 t3Var = new t3();
        this.f18916e = t3Var;
        this.f18917f = new l1(t3Var, zVar.t());
        this.f18918g = new b4(t3Var, zVar.t());
        this.f18919h = new o(zVar.t());
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(java.util.Map r10, com.bugsnag.android.o1 r11) {
        /*
            r9 = this;
            java.lang.String r0 = "traceId"
            java.lang.Object r0 = r10.get(r0)
            boolean r1 = r0 instanceof java.lang.String
            r2 = 0
            if (r1 == 0) goto L_0x000e
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x000f
        L_0x000e:
            r0 = r2
        L_0x000f:
            r1 = 16
            if (r0 != 0) goto L_0x0015
        L_0x0013:
            r4 = r2
            goto L_0x004e
        L_0x0015:
            int r3 = r0.length()
            r4 = 32
            if (r3 != r4) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r0 = r2
        L_0x001f:
            if (r0 != 0) goto L_0x0022
            goto L_0x0013
        L_0x0022:
            r3 = 0
            java.lang.String r3 = r0.substring(r3, r1)
            java.lang.String r4 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.m.e(r3, r4)
            java.lang.Long r3 = r9.d(r3)
            java.lang.String r0 = r0.substring(r1)
            java.lang.String r4 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.m.e(r0, r4)
            java.lang.Long r0 = r9.d(r0)
            if (r3 == 0) goto L_0x0013
            if (r0 == 0) goto L_0x0013
            java.util.UUID r4 = new java.util.UUID
            long r5 = r3.longValue()
            long r7 = r0.longValue()
            r4.<init>(r5, r7)
        L_0x004e:
            java.lang.String r0 = "spanId"
            java.lang.Object r10 = r10.get(r0)
            boolean r0 = r10 instanceof java.lang.String
            if (r0 == 0) goto L_0x005b
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x005c
        L_0x005b:
            r10 = r2
        L_0x005c:
            if (r10 != 0) goto L_0x005f
            goto L_0x006e
        L_0x005f:
            int r0 = r10.length()
            if (r0 != r1) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r10 = r2
        L_0x0067:
            if (r10 != 0) goto L_0x006a
            goto L_0x006e
        L_0x006a:
            java.lang.Long r2 = r9.d(r10)
        L_0x006e:
            if (r4 == 0) goto L_0x0079
            if (r2 == 0) goto L_0x0079
            long r0 = r2.longValue()
            r11.x(r4, r0)
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.p1.b(java.util.Map, com.bugsnag.android.o1):void");
    }

    private final boolean c(Map map, boolean z10) {
        Object obj = map.get("unhandledOverridden");
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        if (!((Boolean) obj).booleanValue()) {
            return z10;
        }
        if (!z10) {
            return true;
        }
        return false;
    }

    private final Long d(String str) {
        if (str.length() != 16 || str.charAt(0) == '-' || str.charAt(3) == '-') {
            return null;
        }
        String substring = str.substring(0, 2);
        m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        Long l10 = j.l(substring, 16);
        if (l10 == null) {
            return null;
        }
        long longValue = l10.longValue();
        String substring2 = str.substring(2);
        m.e(substring2, "this as java.lang.String).substring(startIndex)");
        Long l11 = j.l(substring2, 16);
        if (l11 == null) {
            return null;
        }
        return Long.valueOf(l11.longValue() | (longValue << 56));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bugsnag.android.o1 a(java.util.Map r14) {
        /*
            r13 = this;
            java.lang.String r0 = "severityReason"
            java.lang.Object r0 = r14.get(r0)
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>"
            if (r0 == 0) goto L_0x02ae
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r2 = "featureFlags"
            java.lang.Object r2 = r14.get(r2)
            boolean r3 = r2 instanceof java.util.List
            r4 = 0
            if (r3 == 0) goto L_0x001a
            java.util.List r2 = (java.util.List) r2
            goto L_0x001b
        L_0x001a:
            r2 = r4
        L_0x001b:
            java.lang.String r3 = "type"
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.String"
            if (r3 == 0) goto L_0x02a8
            r7 = r3
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r3 = "severity"
            java.lang.Object r3 = r14.get(r3)
            if (r3 == 0) goto L_0x02a2
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r6 = "unhandled"
            java.lang.Object r6 = r14.get(r6)
            if (r6 == 0) goto L_0x029a
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r9 = r6.booleanValue()
            boolean r10 = r13.c(r0, r9)
            com.bugsnag.android.q3 r0 = new com.bugsnag.android.q3
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toUpperCase(r6)
            java.lang.String r6 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.m.e(r3, r6)
            com.bugsnag.android.Severity r8 = com.bugsnag.android.Severity.valueOf(r3)
            r11 = 0
            r12 = 0
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            com.bugsnag.android.z r3 = r13.f18912a
            com.bugsnag.android.o1 r0 = com.bugsnag.android.NativeInterface.createEvent(r4, r3, r0)
            java.lang.String r3 = "context"
            java.lang.Object r3 = r14.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.r(r3)
            java.lang.String r3 = "groupingHash"
            java.lang.Object r3 = r14.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.t(r3)
            java.lang.String r3 = "apiKey"
            java.lang.Object r3 = r14.get(r3)
            boolean r6 = r3 instanceof java.lang.String
            if (r6 == 0) goto L_0x0084
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x0085
        L_0x0084:
            r3 = r4
        L_0x0085:
            if (r3 != 0) goto L_0x0089
        L_0x0087:
            r3 = r4
            goto L_0x008f
        L_0x0089:
            int r6 = r3.length()
            if (r6 <= 0) goto L_0x0087
        L_0x008f:
            if (r3 != 0) goto L_0x0092
            goto L_0x0095
        L_0x0092:
            r0.o(r3)
        L_0x0095:
            com.bugsnag.android.k r3 = r13.f18914c
            java.lang.String r6 = "app"
            java.lang.Object r6 = r14.get(r6)
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>"
            if (r6 == 0) goto L_0x0294
            java.util.Map r6 = kotlin.jvm.internal.c0.d(r6)
            com.bugsnag.android.m r3 = r3.a(r6)
            r0.p(r3)
            com.bugsnag.android.c1 r3 = r13.f18915d
            java.lang.String r6 = "device"
            java.lang.Object r6 = r14.get(r6)
            if (r6 == 0) goto L_0x028e
            java.util.Map r6 = kotlin.jvm.internal.c0.d(r6)
            com.bugsnag.android.i1 r3 = r3.a(r6)
            r0.s(r3)
            com.bugsnag.android.l4 r3 = new com.bugsnag.android.l4
            r3.<init>()
            java.lang.String r6 = "user"
            java.lang.Object r6 = r14.get(r6)
            if (r6 == 0) goto L_0x0288
            java.util.Map r6 = kotlin.jvm.internal.c0.d(r6)
            com.bugsnag.android.k4 r3 = r3.a(r6)
            java.lang.String r6 = r3.b()
            java.lang.String r7 = r3.a()
            java.lang.String r3 = r3.c()
            r0.y(r6, r7, r3)
            r0.d()
            if (r2 != 0) goto L_0x00eb
            goto L_0x0119
        L_0x00eb:
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x00f1:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0119
            java.lang.Object r3 = r2.next()
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r6 = "featureFlag"
            java.lang.Object r6 = r3.get(r6)
            if (r6 == 0) goto L_0x0113
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "variant"
            java.lang.Object r3 = r3.get(r7)
            java.lang.String r3 = (java.lang.String) r3
            r0.a(r6, r3)
            goto L_0x00f1
        L_0x0113:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            r14.<init>(r5)
            throw r14
        L_0x0119:
            java.lang.String r2 = "errors"
            java.lang.Object r2 = r14.get(r2)
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.Any?>>"
            if (r2 == 0) goto L_0x0282
            java.util.List r2 = (java.util.List) r2
            java.util.List r5 = r0.h()
            r5.clear()
            java.util.List r5 = r0.h()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            com.bugsnag.android.l1 r6 = r13.f18917f
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 10
            int r9 = kotlin.collections.r.v(r2, r8)
            r7.<init>(r9)
            java.util.Iterator r2 = r2.iterator()
        L_0x0143:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L_0x0157
            java.lang.Object r9 = r2.next()
            java.util.Map r9 = (java.util.Map) r9
            com.bugsnag.android.k1 r9 = r6.a(r9)
            r7.add(r9)
            goto L_0x0143
        L_0x0157:
            r5.addAll(r7)
            java.lang.String r2 = "nativeStack"
            boolean r2 = r14.containsKey(r2)
            if (r2 == 0) goto L_0x01aa
            java.util.List r2 = r0.h()
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x01aa
            kotlin.o$a r2 = kotlin.o.f12592b     // Catch:{ all -> 0x01a0 }
            java.util.List r2 = r0.h()     // Catch:{ all -> 0x01a0 }
            java.lang.Object r2 = kotlin.collections.r.Y(r2)     // Catch:{ all -> 0x01a0 }
            com.bugsnag.android.k1 r2 = (com.bugsnag.android.k1) r2     // Catch:{ all -> 0x01a0 }
            com.bugsnag.android.a3 r5 = new com.bugsnag.android.a3     // Catch:{ all -> 0x01a0 }
            java.util.Collection r6 = r13.f18913b     // Catch:{ all -> 0x01a0 }
            com.bugsnag.android.z r7 = r13.f18912a     // Catch:{ all -> 0x01a0 }
            c1.j r7 = r7.m()     // Catch:{ all -> 0x01a0 }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x01a0 }
            java.util.List r5 = r5.a(r14)     // Catch:{ all -> 0x01a0 }
            java.util.List r2 = r2.d()     // Catch:{ all -> 0x01a0 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x01a0 }
            r6 = 0
            boolean r2 = r2.addAll(r6, r5)     // Catch:{ all -> 0x01a0 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x01a0 }
            kotlin.o.b(r2)     // Catch:{ all -> 0x01a0 }
            goto L_0x01aa
        L_0x01a0:
            r2 = move-exception
            kotlin.o$a r5 = kotlin.o.f12592b
            java.lang.Object r2 = kotlin.p.a(r2)
            kotlin.o.b(r2)
        L_0x01aa:
            java.lang.String r2 = "threads"
            java.lang.Object r2 = r14.get(r2)
            if (r2 == 0) goto L_0x027c
            java.util.List r2 = (java.util.List) r2
            java.util.List r5 = r0.l()
            r5.clear()
            java.util.List r5 = r0.l()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            com.bugsnag.android.b4 r6 = r13.f18918g
            java.util.ArrayList r7 = new java.util.ArrayList
            int r9 = kotlin.collections.r.v(r2, r8)
            r7.<init>(r9)
            java.util.Iterator r2 = r2.iterator()
        L_0x01d0:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L_0x01e4
            java.lang.Object r9 = r2.next()
            java.util.Map r9 = (java.util.Map) r9
            com.bugsnag.android.a4 r9 = r6.a(r9)
            r7.add(r9)
            goto L_0x01d0
        L_0x01e4:
            r5.addAll(r7)
            java.lang.String r2 = "breadcrumbs"
            java.lang.Object r2 = r14.get(r2)
            if (r2 == 0) goto L_0x0276
            java.util.List r2 = (java.util.List) r2
            java.util.List r3 = r0.g()
            r3.clear()
            java.util.List r3 = r0.g()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            com.bugsnag.android.o r5 = r13.f18919h
            java.util.ArrayList r6 = new java.util.ArrayList
            int r7 = kotlin.collections.r.v(r2, r8)
            r6.<init>(r7)
            java.util.Iterator r2 = r2.iterator()
        L_0x020d:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0221
            java.lang.Object r7 = r2.next()
            java.util.Map r7 = (java.util.Map) r7
            com.bugsnag.android.Breadcrumb r7 = r5.a(r7)
            r6.add(r7)
            goto L_0x020d
        L_0x0221:
            r3.addAll(r6)
            java.lang.String r2 = "metadata"
            java.lang.Object r2 = r14.get(r2)
            if (r2 == 0) goto L_0x026e
            java.util.Map r2 = (java.util.Map) r2
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0236:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x025a
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r5 = r3.getKey()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r3 = r3.getValue()
            if (r3 == 0) goto L_0x0254
            java.util.Map r3 = (java.util.Map) r3
            r0.c(r5, r3)
            goto L_0x0236
        L_0x0254:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            r14.<init>(r1)
            throw r14
        L_0x025a:
            java.lang.String r1 = "correlation"
            java.lang.Object r14 = r14.get(r1)
            boolean r1 = r14 instanceof java.util.Map
            if (r1 == 0) goto L_0x0267
            r4 = r14
            java.util.Map r4 = (java.util.Map) r4
        L_0x0267:
            if (r4 != 0) goto L_0x026a
            goto L_0x026d
        L_0x026a:
            r13.b(r4, r0)
        L_0x026d:
            return r0
        L_0x026e:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>"
            r14.<init>(r0)
            throw r14
        L_0x0276:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            r14.<init>(r3)
            throw r14
        L_0x027c:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            r14.<init>(r3)
            throw r14
        L_0x0282:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            r14.<init>(r3)
            throw r14
        L_0x0288:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            r14.<init>(r7)
            throw r14
        L_0x028e:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            r14.<init>(r7)
            throw r14
        L_0x0294:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            r14.<init>(r7)
            throw r14
        L_0x029a:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Boolean"
            r14.<init>(r0)
            throw r14
        L_0x02a2:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            r14.<init>(r5)
            throw r14
        L_0x02a8:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            r14.<init>(r5)
            throw r14
        L_0x02ae:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            r14.<init>(r1)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.p1.a(java.util.Map):com.bugsnag.android.o1");
    }
}
