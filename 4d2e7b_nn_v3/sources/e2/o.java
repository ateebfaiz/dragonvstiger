package e2;

import android.content.Context;
import com.facebook.GraphRequest;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import q5.b;
import q5.p0;

public final class o {

    /* renamed from: f  reason: collision with root package name */
    private static final String f21210f;

    /* renamed from: g  reason: collision with root package name */
    private static final int f21211g = 1000;

    /* renamed from: h  reason: collision with root package name */
    public static final a f21212h = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private List f21213a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List f21214b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private int f21215c;

    /* renamed from: d  reason: collision with root package name */
    private final b f21216d;

    /* renamed from: e  reason: collision with root package name */
    private final String f21217e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String simpleName = o.class.getSimpleName();
        m.e(simpleName, "SessionEventsState::class.java.simpleName");
        f21210f = simpleName;
    }

    public o(b bVar, String str) {
        m.f(bVar, "attributionIdentifiers");
        m.f(str, "anonymousAppDeviceGUID");
        this.f21216d = bVar;
        this.f21217e = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        v5.a.b(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r5 = new org.json.JSONObject();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void f(com.facebook.GraphRequest r4, android.content.Context r5, int r6, org.json.JSONArray r7, boolean r8) {
        /*
            r3 = this;
            boolean r0 = v5.a.d(r3)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            l2.c$a r0 = l2.c.a.CUSTOM_APP_EVENTS     // Catch:{ JSONException -> 0x001d }
            q5.b r1 = r3.f21216d     // Catch:{ JSONException -> 0x001d }
            java.lang.String r2 = r3.f21217e     // Catch:{ JSONException -> 0x001d }
            org.json.JSONObject r5 = l2.c.a(r0, r1, r2, r8, r5)     // Catch:{ JSONException -> 0x001d }
            int r8 = r3.f21215c     // Catch:{ JSONException -> 0x001d }
            if (r8 <= 0) goto L_0x0022
            java.lang.String r8 = "num_skipped_events"
            r5.put(r8, r6)     // Catch:{ JSONException -> 0x001d }
            goto L_0x0022
        L_0x001b:
            r4 = move-exception
            goto L_0x003e
        L_0x001d:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x001b }
            r5.<init>()     // Catch:{ all -> 0x001b }
        L_0x0022:
            r4.D(r5)     // Catch:{ all -> 0x001b }
            android.os.Bundle r5 = r4.s()     // Catch:{ all -> 0x001b }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x001b }
            java.lang.String r7 = "events.toString()"
            kotlin.jvm.internal.m.e(r6, r7)     // Catch:{ all -> 0x001b }
            java.lang.String r7 = "custom_events"
            r5.putString(r7, r6)     // Catch:{ all -> 0x001b }
            r4.H(r6)     // Catch:{ all -> 0x001b }
            r4.F(r5)     // Catch:{ all -> 0x001b }
            return
        L_0x003e:
            v5.a.b(r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.o.f(com.facebook.GraphRequest, android.content.Context, int, org.json.JSONArray, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(e2.c r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = v5.a.d(r2)     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            java.lang.String r0 = "event"
            kotlin.jvm.internal.m.f(r3, r0)     // Catch:{ all -> 0x0026 }
            java.util.List r0 = r2.f21213a     // Catch:{ all -> 0x0026 }
            int r0 = r0.size()     // Catch:{ all -> 0x0026 }
            java.util.List r1 = r2.f21214b     // Catch:{ all -> 0x0026 }
            int r1 = r1.size()     // Catch:{ all -> 0x0026 }
            int r0 = r0 + r1
            int r1 = f21211g     // Catch:{ all -> 0x0026 }
            if (r0 < r1) goto L_0x0028
            int r3 = r2.f21215c     // Catch:{ all -> 0x0026 }
            int r3 = r3 + 1
            r2.f21215c = r3     // Catch:{ all -> 0x0026 }
            goto L_0x002d
        L_0x0026:
            r3 = move-exception
            goto L_0x002f
        L_0x0028:
            java.util.List r0 = r2.f21213a     // Catch:{ all -> 0x0026 }
            r0.add(r3)     // Catch:{ all -> 0x0026 }
        L_0x002d:
            monitor-exit(r2)
            return
        L_0x002f:
            v5.a.b(r3, r2)     // Catch:{ all -> 0x0034 }
            monitor-exit(r2)
            return
        L_0x0034:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.o.a(e2.c):void");
    }

    public final synchronized void b(boolean z10) {
        if (!v5.a.d(this)) {
            if (z10) {
                try {
                    this.f21213a.addAll(this.f21214b);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                    return;
                }
            }
            this.f21214b.clear();
            this.f21215c = 0;
        }
    }

    public final synchronized int c() {
        if (v5.a.d(this)) {
            return 0;
        }
        try {
            return this.f21213a.size();
        } catch (Throwable th) {
            v5.a.b(th, this);
            return 0;
        }
    }

    public final synchronized List d() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            List list = this.f21213a;
            this.f21213a = new ArrayList();
            return list;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public final int e(GraphRequest graphRequest, Context context, boolean z10, boolean z11) {
        if (v5.a.d(this)) {
            return 0;
        }
        try {
            m.f(graphRequest, "request");
            m.f(context, "applicationContext");
            synchronized (this) {
                int i10 = this.f21215c;
                i2.a.d(this.f21213a);
                this.f21214b.addAll(this.f21213a);
                this.f21213a.clear();
                JSONArray jSONArray = new JSONArray();
                for (c cVar : this.f21214b) {
                    if (cVar.h()) {
                        if (!z10) {
                            if (!cVar.i()) {
                            }
                        }
                        jSONArray.put(cVar.e());
                    } else {
                        String str = f21210f;
                        p0.f0(str, "Event with invalid checksum: " + cVar);
                    }
                }
                if (jSONArray.length() == 0) {
                    return 0;
                }
                Unit unit = Unit.f12577a;
                f(graphRequest, context, i10, jSONArray, z11);
                return jSONArray.length();
            }
        } catch (Throwable th) {
            v5.a.b(th, this);
            return 0;
        }
    }
}
