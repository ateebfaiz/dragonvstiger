package y8;

import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import v8.c;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f13338a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentHashMap f13339b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentHashMap f13340c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentHashMap f13341d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final g f13342e = new g(b.f13344a, 10, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, 0, 8, (DefaultConstructorMarker) null);

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f13343a = new a();

        a() {
            super(1);
        }

        /* renamed from: a */
        public final List invoke(Object obj) {
            m.f(obj, "it");
            return new ArrayList();
        }
    }

    static final class b extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f13344a = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final Object[] invoke() {
            return new Object[1];
        }
    }

    private d() {
    }

    /* access modifiers changed from: private */
    public static final List c(Function1 function1, Object obj) {
        m.f(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final void b(java.lang.Object r4, v8.d r5) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.m.f(r4, r0)
            java.lang.String r0 = "onSuspendReturnListener"
            kotlin.jvm.internal.m.f(r5, r0)
            java.util.concurrent.ConcurrentHashMap r0 = f13339b     // Catch:{ all -> 0x001a }
            y8.d$a r1 = y8.d.a.f13343a     // Catch:{ all -> 0x001a }
            y8.c r2 = new y8.c     // Catch:{ all -> 0x001a }
            r2.<init>(r1)     // Catch:{ all -> 0x001a }
            java.lang.Object r0 = r0.computeIfAbsent(r4, r2)     // Catch:{ all -> 0x001a }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x001a }
            goto L_0x0032
        L_0x001a:
            java.util.concurrent.ConcurrentHashMap r0 = f13339b
            monitor-enter(r0)
            java.lang.Object r1 = r0.get(r4)     // Catch:{ all -> 0x002e }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x002e }
            if (r1 != 0) goto L_0x0030
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x002e }
            r1.<init>()     // Catch:{ all -> 0x002e }
            r0.put(r4, r1)     // Catch:{ all -> 0x002e }
            goto L_0x0030
        L_0x002e:
            r4 = move-exception
            goto L_0x0040
        L_0x0030:
            monitor-exit(r0)
            r0 = r1
        L_0x0032:
            java.lang.String r4 = "try {\n            mRetur…l\n            }\n        }"
            kotlin.jvm.internal.m.e(r0, r4)
            monitor-enter(r0)
            r0.add(r5)     // Catch:{ all -> 0x003d }
            monitor-exit(r0)
            return
        L_0x003d:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L_0x0040:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.d.b(java.lang.Object, v8.d):void");
    }

    public final Object[] d() {
        return (Object[]) f13342e.e();
    }

    public final v8.a e(String str) {
        m.f(str, "annotationName");
        j.a(str);
        return null;
    }

    public final c f(String str) {
        m.f(str, "annotationName");
        return j.b(str);
    }

    public final Object g(Object[] objArr) {
        m.f(objArr, "o");
        Object obj = objArr[0];
        f13342e.f(objArr);
        return obj;
    }

    public final void h(Object obj, Object obj2) {
        m.f(obj, "key1");
        m.f(obj2, "key2");
        ConcurrentHashMap concurrentHashMap = f13340c;
        concurrentHashMap.put(obj, obj2);
        concurrentHashMap.put(obj2, obj);
    }
}
