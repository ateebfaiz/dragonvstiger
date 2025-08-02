package q5;

import android.content.Intent;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static a f23240d;

    /* renamed from: e  reason: collision with root package name */
    public static final C0322a f23241e = new C0322a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private Intent f23242a;

    /* renamed from: b  reason: collision with root package name */
    private int f23243b;

    /* renamed from: c  reason: collision with root package name */
    private final UUID f23244c;

    /* renamed from: q5.a$a  reason: collision with other inner class name */
    public static final class C0322a {
        private C0322a() {
        }

        private final void d(a aVar) {
            a.b(aVar);
        }

        /* access modifiers changed from: private */
        public final synchronized boolean e(a aVar) {
            boolean z10;
            a c10 = c();
            d(aVar);
            if (c10 != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            return z10;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized q5.a b(java.util.UUID r4, int r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.String r0 = "callId"
                kotlin.jvm.internal.m.f(r4, r0)     // Catch:{ all -> 0x0025 }
                q5.a r0 = r3.c()     // Catch:{ all -> 0x0025 }
                r1 = 0
                if (r0 == 0) goto L_0x0027
                java.util.UUID r2 = r0.d()     // Catch:{ all -> 0x0025 }
                boolean r4 = kotlin.jvm.internal.m.b(r2, r4)     // Catch:{ all -> 0x0025 }
                r4 = r4 ^ 1
                if (r4 != 0) goto L_0x0027
                int r4 = r0.e()     // Catch:{ all -> 0x0025 }
                if (r4 == r5) goto L_0x0020
                goto L_0x0027
            L_0x0020:
                r3.e(r1)     // Catch:{ all -> 0x0025 }
                monitor-exit(r3)
                return r0
            L_0x0025:
                r4 = move-exception
                goto L_0x0029
            L_0x0027:
                monitor-exit(r3)
                return r1
            L_0x0029:
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: q5.a.C0322a.b(java.util.UUID, int):q5.a");
        }

        public final a c() {
            return a.a();
        }

        public /* synthetic */ C0322a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(int i10) {
        this(i10, (UUID) null, 2, (DefaultConstructorMarker) null);
    }

    public static final /* synthetic */ a a() {
        Class<a> cls = a.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f23240d;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void b(a aVar) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                f23240d = aVar;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final synchronized a c(UUID uuid, int i10) {
        synchronized (a.class) {
            if (v5.a.d(a.class)) {
                return null;
            }
            try {
                a b10 = f23241e.b(uuid, i10);
                return b10;
            } catch (Throwable th) {
                v5.a.b(th, a.class);
                return null;
            }
        }
    }

    public final UUID d() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            return this.f23244c;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public final int e() {
        if (v5.a.d(this)) {
            return 0;
        }
        try {
            return this.f23243b;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return 0;
        }
    }

    public final Intent f() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            return this.f23242a;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public final boolean g() {
        if (v5.a.d(this)) {
            return false;
        }
        try {
            return f23241e.e(this);
        } catch (Throwable th) {
            v5.a.b(th, this);
            return false;
        }
    }

    public final void h(Intent intent) {
        if (!v5.a.d(this)) {
            try {
                this.f23242a = intent;
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public a(int i10, UUID uuid) {
        m.f(uuid, "callId");
        this.f23243b = i10;
        this.f23244c = uuid;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(int r1, java.util.UUID r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000d
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r3 = "UUID.randomUUID()"
            kotlin.jvm.internal.m.e(r2, r3)
        L_0x000d:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.a.<init>(int, java.util.UUID, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
