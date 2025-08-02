package com.onesignal;

import com.onesignal.b4;
import com.onesignal.o3;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class s {

    /* renamed from: a  reason: collision with root package name */
    private Long f11020a;

    /* renamed from: b  reason: collision with root package name */
    private Object f11021b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private k1 f11022c;

    /* renamed from: d  reason: collision with root package name */
    private c2 f11023d;

    private enum a {
        BACKGROUND,
        END_SESSION
    }

    static class b extends c {
        b() {
            this.f11027a = 1;
            this.f11028b = "OS_UNSENT_ATTRIBUTED_ACTIVE_TIME";
        }

        /* access modifiers changed from: protected */
        public void h(JSONObject jSONObject) {
            o3.s0().b(jSONObject, j());
        }

        /* access modifiers changed from: protected */
        public List j() {
            ArrayList arrayList = new ArrayList();
            for (String aVar : z3.g(z3.f11153a, "PREFS_OS_ATTRIBUTED_INFLUENCES", new HashSet())) {
                try {
                    arrayList.add(new na.a(aVar));
                } catch (JSONException e10) {
                    o3.v vVar = o3.v.ERROR;
                    o3.a(vVar, getClass().getSimpleName() + ": error generation OSInfluence from json object: " + e10);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: protected */
        public void m(List list) {
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    hashSet.add(((na.a) it.next()).g());
                } catch (JSONException e10) {
                    o3.v vVar = o3.v.ERROR;
                    o3.a(vVar, getClass().getSimpleName() + ": error generation json object OSInfluence: " + e10);
                }
            }
            z3.n(z3.f11153a, "PREFS_OS_ATTRIBUTED_INFLUENCES", hashSet);
        }

        /* access modifiers changed from: protected */
        public void r(a aVar) {
            o3.v vVar = o3.v.DEBUG;
            o3.d1(vVar, getClass().getSimpleName() + " sendTime with: " + aVar);
            if (aVar.equals(a.END_SESSION)) {
                u();
            } else {
                b3.q().s(o3.f10882b);
            }
        }
    }

    static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        protected long f11027a;

        /* renamed from: b  reason: collision with root package name */
        protected String f11028b;

        /* renamed from: c  reason: collision with root package name */
        private Long f11029c = null;

        /* renamed from: d  reason: collision with root package name */
        private final AtomicBoolean f11030d = new AtomicBoolean();

        class a extends b4.g {
            a() {
            }

            /* access modifiers changed from: package-private */
            public void a(int i10, String str, Throwable th) {
                o3.U0("sending on_focus Failed", i10, th, str);
            }

            /* access modifiers changed from: package-private */
            public void b(String str) {
                c.this.o(0);
            }
        }

        c() {
        }

        /* access modifiers changed from: private */
        public void g(long j10, List list, a aVar) {
            n(j10, list);
            t(aVar);
        }

        private JSONObject i(long j10) {
            JSONObject put = new JSONObject().put(Constant.PARAM_APP_ID, o3.o0()).put("type", 1).put("state", "ping").put("active_time", j10).put("device_type", new OSUtils().e());
            o3.x(put);
            return put;
        }

        private long k() {
            if (this.f11029c == null) {
                this.f11029c = Long.valueOf(z3.d(z3.f11153a, this.f11028b, 0));
            }
            o3.v vVar = o3.v.DEBUG;
            o3.a(vVar, getClass().getSimpleName() + ":getUnsentActiveTime: " + this.f11029c);
            return this.f11029c.longValue();
        }

        private boolean l() {
            if (k() >= this.f11027a) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public void n(long j10, List list) {
            o3.v vVar = o3.v.DEBUG;
            o3.a(vVar, getClass().getSimpleName() + ":saveUnsentActiveData with lastFocusTimeInfluences: " + list.toString());
            m(list);
            o(k() + j10);
        }

        /* access modifiers changed from: private */
        public void o(long j10) {
            this.f11029c = Long.valueOf(j10);
            o3.v vVar = o3.v.DEBUG;
            o3.a(vVar, getClass().getSimpleName() + ":saveUnsentActiveTime: " + this.f11029c);
            z3.l(z3.f11153a, this.f11028b, j10);
        }

        private void p(long j10) {
            try {
                o3.v vVar = o3.v.DEBUG;
                o3.a(vVar, getClass().getSimpleName() + ":sendOnFocus with totalTimeActive: " + j10);
                JSONObject i10 = i(j10);
                h(i10);
                q(o3.z0(), i10);
                if (o3.H0()) {
                    q(o3.Y(), i(j10));
                }
                if (o3.I0()) {
                    q(o3.m0(), i(j10));
                }
                m(new ArrayList());
            } catch (JSONException e10) {
                o3.b(o3.v.ERROR, "Generating on_focus:JSON Failed.", e10);
            }
        }

        private void q(String str, JSONObject jSONObject) {
            a aVar = new a();
            b4.k("players/" + str + "/on_focus", jSONObject, aVar);
        }

        /* access modifiers changed from: private */
        public void s() {
            List j10 = j();
            long k10 = k();
            o3.v vVar = o3.v.DEBUG;
            o3.a(vVar, getClass().getSimpleName() + ":sendUnsentTimeNow with time: " + k10 + " and influences: " + j10.toString());
            t(a.BACKGROUND);
        }

        /* access modifiers changed from: private */
        public void t(a aVar) {
            if (!o3.J0()) {
                o3.v vVar = o3.v.WARN;
                o3.a(vVar, getClass().getSimpleName() + ":sendUnsentTimeNow not possible due to user id null");
                return;
            }
            r(aVar);
        }

        /* access modifiers changed from: private */
        public void v() {
            if (l()) {
                u();
            }
        }

        /* access modifiers changed from: protected */
        public void h(JSONObject jSONObject) {
        }

        /* access modifiers changed from: protected */
        public abstract List j();

        /* access modifiers changed from: protected */
        public abstract void m(List list);

        /* access modifiers changed from: protected */
        public abstract void r(a aVar);

        /* access modifiers changed from: protected */
        public void u() {
            if (!this.f11030d.get()) {
                synchronized (this.f11030d) {
                    try {
                        this.f11030d.set(true);
                        if (l()) {
                            p(k());
                        }
                        this.f11030d.set(false);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public void w() {
            if (l()) {
                b3.q().s(o3.f10882b);
            }
        }
    }

    static class d extends c {
        d() {
            this.f11027a = 60;
            this.f11028b = "GT_UNSENT_ACTIVE_TIME";
        }

        /* access modifiers changed from: protected */
        public List j() {
            return new ArrayList();
        }

        /* access modifiers changed from: protected */
        public void m(List list) {
        }

        /* access modifiers changed from: protected */
        public void r(a aVar) {
            o3.v vVar = o3.v.DEBUG;
            o3.d1(vVar, getClass().getSimpleName() + " sendTime with: " + aVar);
            if (!aVar.equals(a.END_SESSION)) {
                w();
            }
        }
    }

    s(k1 k1Var, c2 c2Var) {
        this.f11022c = k1Var;
        this.f11023d = c2Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Long e() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f11021b
            monitor-enter(r0)
            java.lang.Long r1 = r7.f11020a     // Catch:{ all -> 0x000a }
            r2 = 0
            if (r1 != 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return r2
        L_0x000a:
            r1 = move-exception
            goto L_0x003c
        L_0x000c:
            com.onesignal.g3 r1 = com.onesignal.o3.w0()     // Catch:{ all -> 0x000a }
            long r3 = r1.a()     // Catch:{ all -> 0x000a }
            java.lang.Long r1 = r7.f11020a     // Catch:{ all -> 0x000a }
            long r5 = r1.longValue()     // Catch:{ all -> 0x000a }
            long r3 = r3 - r5
            double r3 = (double) r3     // Catch:{ all -> 0x000a }
            r5 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r3 = r3 / r5
            r5 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r3 = r3 + r5
            long r3 = (long) r3     // Catch:{ all -> 0x000a }
            r5 = 1
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x003a
            r5 = 86400(0x15180, double:4.26873E-319)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0034
            goto L_0x003a
        L_0x0034:
            java.lang.Long r1 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x000a }
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return r1
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return r2
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.s.e():java.lang.Long");
    }

    private boolean f(List list, a aVar) {
        Long e10 = e();
        if (e10 == null) {
            return false;
        }
        this.f11022c.c(list).g(e10.longValue(), list, aVar);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f11021b) {
            c2 c2Var = this.f11023d;
            c2Var.b("Application backgrounded focus time: " + this.f11020a);
            this.f11022c.b().s();
            this.f11020a = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        synchronized (this.f11021b) {
            this.f11020a = Long.valueOf(o3.w0().a());
            c2 c2Var = this.f11023d;
            c2Var.b("Application foregrounded focus time: " + this.f11020a);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Long e10 = e();
        synchronized (this.f11021b) {
            c2 c2Var = this.f11023d;
            c2Var.b("Application stopped focus time: " + this.f11020a + " timeElapsed: " + e10);
        }
        if (e10 != null) {
            List f10 = o3.s0().f();
            this.f11022c.c(f10).n(e10.longValue(), f10);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (!o3.O0()) {
            this.f11022c.b().v();
        }
    }

    /* access modifiers changed from: package-private */
    public void g(List list) {
        a aVar = a.END_SESSION;
        if (!f(list, aVar)) {
            this.f11022c.c(list).t(aVar);
        }
    }
}
