package com.onesignal;

import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.b4;
import com.onesignal.e4;
import com.onesignal.h0;
import com.onesignal.o3;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.HashMap;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

abstract class b5 {

    /* renamed from: a  reason: collision with root package name */
    protected final Object f10422a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public e4.c f10423b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f10424c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f10425d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    private final Queue f10426e = new LinkedBlockingQueue();

    /* renamed from: f  reason: collision with root package name */
    private final Queue f10427f = new LinkedBlockingQueue();

    /* renamed from: g  reason: collision with root package name */
    private final Queue f10428g = new LinkedBlockingQueue();

    /* renamed from: h  reason: collision with root package name */
    HashMap f10429h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private final Object f10430i = new a();

    /* renamed from: j  reason: collision with root package name */
    protected boolean f10431j = false;

    /* renamed from: k  reason: collision with root package name */
    private t4 f10432k;

    /* renamed from: l  reason: collision with root package name */
    private t4 f10433l;

    class a {
        a() {
        }
    }

    class b extends b4.g {
        b() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i10, String str, Throwable th) {
            o3.v vVar = o3.v.WARN;
            o3.a(vVar, "Failed last request. statusCode: " + i10 + "\nresponse: " + str);
            if (b5.this.S(i10, str, "already logged out of email")) {
                b5.this.M();
            } else if (b5.this.S(i10, str, "not a valid device_type")) {
                b5.this.I();
            } else {
                b5.this.H(i10);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
            b5.this.M();
        }
    }

    class c extends b4.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ JSONObject f10436a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f10437b;

        c(JSONObject jSONObject, JSONObject jSONObject2) {
            this.f10436a = jSONObject;
            this.f10437b = jSONObject2;
        }

        /* access modifiers changed from: package-private */
        public void a(int i10, String str, Throwable th) {
            o3.v vVar = o3.v.ERROR;
            o3.a(vVar, "Failed PUT sync request with status code: " + i10 + " and response: " + str);
            synchronized (b5.this.f10422a) {
                try {
                    if (b5.this.S(i10, str, "No user with this id found")) {
                        b5.this.I();
                    } else {
                        b5.this.H(i10);
                    }
                } catch (Throwable th2) {
                    while (true) {
                        throw th2;
                    }
                }
            }
            if (this.f10436a.has("tags")) {
                b5.this.W(new o3.b0(i10, str));
            }
            if (this.f10436a.has("external_user_id")) {
                o3.d1(vVar, "Error setting external user id for push with status code: " + i10 + " and message: " + str);
                b5.this.u();
            }
            if (this.f10436a.has("language")) {
                b5.this.p(new e4.b(i10, str));
            }
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
            synchronized (b5.this.f10422a) {
                b5.this.z().r(this.f10437b, this.f10436a);
                b5.this.O(this.f10436a);
            }
            if (this.f10436a.has("tags")) {
                b5.this.X();
            }
            if (this.f10436a.has("external_user_id")) {
                b5.this.v();
            }
            if (this.f10436a.has("language")) {
                b5.this.q();
            }
        }
    }

    class d extends b4.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ JSONObject f10439a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f10440b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10441c;

        d(JSONObject jSONObject, JSONObject jSONObject2, String str) {
            this.f10439a = jSONObject;
            this.f10440b = jSONObject2;
            this.f10441c = str;
        }

        /* access modifiers changed from: package-private */
        public void a(int i10, String str, Throwable th) {
            synchronized (b5.this.f10422a) {
                try {
                    b5.this.f10431j = false;
                    o3.v vVar = o3.v.WARN;
                    o3.a(vVar, "Failed last request. statusCode: " + i10 + "\nresponse: " + str);
                    if (b5.this.S(i10, str, "not a valid device_type")) {
                        b5.this.I();
                    } else {
                        b5.this.H(i10);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
            synchronized (b5.this.f10422a) {
                try {
                    b5 b5Var = b5.this;
                    b5Var.f10431j = false;
                    b5Var.z().r(this.f10439a, this.f10440b);
                    o3.v vVar = o3.v.DEBUG;
                    o3.d1(vVar, "doCreateOrNewSession:response: " + str);
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("id")) {
                        String optString = jSONObject.optString("id");
                        b5.this.c0(optString);
                        o3.v vVar2 = o3.v.INFO;
                        o3.a(vVar2, "Device registered, UserId = " + optString);
                    } else {
                        o3.v vVar3 = o3.v.INFO;
                        o3.a(vVar3, "session sent, UserId = " + this.f10441c);
                    }
                    b5.this.G().s("session", Boolean.FALSE);
                    b5.this.G().q();
                    if (jSONObject.has("in_app_messages")) {
                        o3.c0().o0(jSONObject.getJSONArray("in_app_messages"));
                    }
                    b5.this.O(this.f10440b);
                } catch (JSONException e10) {
                    o3.b(o3.v.ERROR, "ERROR parsing on_session or create JSON Response.", e10);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        boolean f10443a;

        /* renamed from: b  reason: collision with root package name */
        JSONObject f10444b;

        e(boolean z10, JSONObject jSONObject) {
            this.f10443a = z10;
            this.f10444b = jSONObject;
        }
    }

    class f extends HandlerThread {

        /* renamed from: a  reason: collision with root package name */
        int f10445a;

        /* renamed from: b  reason: collision with root package name */
        Handler f10446b = new Handler(getLooper());

        /* renamed from: c  reason: collision with root package name */
        int f10447c;

        class a implements Runnable {
            a() {
            }

            public void run() {
                if (!b5.this.f10425d.get()) {
                    b5.this.a0(false);
                }
            }
        }

        f(int i10) {
            super("OSH_NetworkHandlerThread_" + b5.this.f10423b);
            this.f10445a = i10;
            start();
        }

        private Runnable b() {
            if (this.f10445a != 0) {
                return null;
            }
            return new a();
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            boolean z10;
            boolean hasMessages;
            synchronized (this.f10446b) {
                try {
                    if (this.f10447c < 3) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    boolean hasMessages2 = this.f10446b.hasMessages(0);
                    if (z10 && !hasMessages2) {
                        this.f10447c++;
                        this.f10446b.postDelayed(b(), (long) (this.f10447c * 15000));
                    }
                    hasMessages = this.f10446b.hasMessages(0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return hasMessages;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (b5.this.f10424c) {
                synchronized (this.f10446b) {
                    this.f10447c = 0;
                    this.f10446b.removeCallbacksAndMessages((Object) null);
                    this.f10446b.postDelayed(b(), 5000);
                }
            }
        }
    }

    b5(e4.c cVar) {
        this.f10423b = cVar;
    }

    /* access modifiers changed from: private */
    public void H(int i10) {
        if (i10 == 403) {
            o3.a(o3.v.FATAL, "403 error updating player, omitting further retries!");
            x();
        } else if (!C(0).a()) {
            x();
        }
    }

    /* access modifiers changed from: private */
    public void I() {
        o3.a(o3.v.WARN, "Creating new player based on missing player_id noted above.");
        o3.G0();
        R();
        c0((String) null);
        T();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007a, code lost:
        if (r9 != false) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007c, code lost:
        t(r0, r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
        r(r0, r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void K(boolean r9) {
        /*
            r8 = this;
            java.lang.String r0 = r8.A()
            boolean r1 = r8.Z()
            if (r1 == 0) goto L_0x0010
            if (r0 == 0) goto L_0x0010
            r8.s(r0)
            return
        L_0x0010:
            com.onesignal.t4 r1 = r8.f10432k
            if (r1 != 0) goto L_0x0017
            r8.J()
        L_0x0017:
            if (r9 != 0) goto L_0x0021
            boolean r9 = r8.L()
            if (r9 == 0) goto L_0x0021
            r9 = 1
            goto L_0x0022
        L_0x0021:
            r9 = 0
        L_0x0022:
            java.lang.Object r1 = r8.f10422a
            monitor-enter(r1)
            com.onesignal.t4 r2 = r8.z()     // Catch:{ all -> 0x0070 }
            com.onesignal.t4 r3 = r8.F()     // Catch:{ all -> 0x0070 }
            org.json.JSONObject r2 = r2.d(r3, r9)     // Catch:{ all -> 0x0070 }
            com.onesignal.t4 r3 = r8.F()     // Catch:{ all -> 0x0070 }
            com.onesignal.t4 r4 = r8.z()     // Catch:{ all -> 0x0070 }
            r5 = 0
            org.json.JSONObject r3 = r4.f(r3, r5)     // Catch:{ all -> 0x0070 }
            com.onesignal.o3$v r4 = com.onesignal.o3.v.DEBUG     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            r6.<init>()     // Catch:{ all -> 0x0070 }
            java.lang.String r7 = "UserStateSynchronizer internalSyncUserState from session call: "
            r6.append(r7)     // Catch:{ all -> 0x0070 }
            r6.append(r9)     // Catch:{ all -> 0x0070 }
            java.lang.String r7 = " jsonBody: "
            r6.append(r7)     // Catch:{ all -> 0x0070 }
            r6.append(r2)     // Catch:{ all -> 0x0070 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0070 }
            com.onesignal.o3.d1(r4, r6)     // Catch:{ all -> 0x0070 }
            if (r2 != 0) goto L_0x0072
            com.onesignal.t4 r9 = r8.z()     // Catch:{ all -> 0x0070 }
            r9.r(r3, r5)     // Catch:{ all -> 0x0070 }
            r8.X()     // Catch:{ all -> 0x0070 }
            r8.v()     // Catch:{ all -> 0x0070 }
            r8.q()     // Catch:{ all -> 0x0070 }
            monitor-exit(r1)     // Catch:{ all -> 0x0070 }
            return
        L_0x0070:
            r9 = move-exception
            goto L_0x0084
        L_0x0072:
            com.onesignal.t4 r4 = r8.F()     // Catch:{ all -> 0x0070 }
            r4.q()     // Catch:{ all -> 0x0070 }
            monitor-exit(r1)     // Catch:{ all -> 0x0070 }
            if (r9 != 0) goto L_0x0080
            r8.t(r0, r2, r3)
            goto L_0x0083
        L_0x0080:
            r8.r(r0, r2, r3)
        L_0x0083:
            return
        L_0x0084:
            monitor-exit(r1)     // Catch:{ all -> 0x0070 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.b5.K(boolean):void");
    }

    private boolean L() {
        if ((F().i().b("session") || A() == null) && !this.f10431j) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void M() {
        F().v("logoutEmail");
        this.f10433l.v("email_auth_hash");
        this.f10433l.w("parent_player_id");
        this.f10433l.w("email");
        this.f10433l.q();
        z().v("email_auth_hash");
        z().w("parent_player_id");
        String f10 = z().l().f("email");
        z().w("email");
        e4.s();
        o3.v vVar = o3.v.INFO;
        o3.a(vVar, "Device successfully logged out of email: " + f10);
        o3.G0();
    }

    /* access modifiers changed from: private */
    public boolean S(int i10, String str, String str2) {
        if (i10 == 400 && str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("errors") || !jSONObject.optString("errors").contains(str2)) {
                    return false;
                }
                return true;
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void W(o3.b0 b0Var) {
        c.d.a(this.f10426e.poll());
    }

    /* access modifiers changed from: private */
    public void X() {
        JSONObject jSONObject = e4.h(false).f10444b;
        c.d.a(this.f10426e.poll());
    }

    private boolean Z() {
        return F().i().c("logoutEmail", false);
    }

    /* access modifiers changed from: private */
    public void p(e4.b bVar) {
        c.d.a(this.f10428g.poll());
    }

    /* access modifiers changed from: private */
    public void q() {
        e4.c();
        c.d.a(this.f10428g.poll());
    }

    private void r(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        String str2;
        if (str == null) {
            str2 = "players";
        } else {
            str2 = "players/" + str + "/on_session";
        }
        this.f10431j = true;
        n(jSONObject);
        b4.k(str2, jSONObject, new d(jSONObject2, jSONObject, str));
    }

    private void s(String str) {
        String str2 = "players/" + str + "/email_logout";
        JSONObject jSONObject = new JSONObject();
        try {
            c0 i10 = z().i();
            if (i10.a("email_auth_hash")) {
                jSONObject.put("email_auth_hash", i10.f("email_auth_hash"));
            }
            c0 l10 = z().l();
            if (l10.a("parent_player_id")) {
                jSONObject.put("parent_player_id", l10.f("parent_player_id"));
            }
            jSONObject.put(Constant.PARAM_APP_ID, l10.f(Constant.PARAM_APP_ID));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b4.k(str2, jSONObject, new b());
    }

    private void t(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (str == null) {
            o3.d1(B(), "Error updating the user record because of the null user id");
            W(new o3.b0(-1, "Unable to update tags: the current user is not registered with OneSignal"));
            u();
            p(new e4.b(-1, "Unable to set Language: the current user is not registered with OneSignal"));
            return;
        }
        b4.m("players/" + str, jSONObject, new c(jSONObject, jSONObject2));
    }

    /* access modifiers changed from: private */
    public void u() {
        c.d.a(this.f10427f.poll());
    }

    /* access modifiers changed from: private */
    public void v() {
        c.d.a(this.f10427f.poll());
    }

    private void x() {
        JSONObject d10 = z().d(this.f10433l, false);
        if (d10 != null) {
            w(d10);
        }
        if (F().i().c("logoutEmail", false)) {
            o3.D0();
        }
    }

    /* access modifiers changed from: protected */
    public abstract String A();

    /* access modifiers changed from: protected */
    public abstract o3.v B();

    /* access modifiers changed from: protected */
    public f C(Integer num) {
        f fVar;
        synchronized (this.f10430i) {
            try {
                if (!this.f10429h.containsKey(num)) {
                    this.f10429h.put(num, new f(num.intValue()));
                }
                fVar = (f) this.f10429h.get(num);
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    /* access modifiers changed from: package-private */
    public String D() {
        return F().l().g("identifier", (String) null);
    }

    /* access modifiers changed from: package-private */
    public boolean E() {
        return G().i().b("session");
    }

    /* access modifiers changed from: protected */
    public t4 F() {
        if (this.f10433l == null) {
            synchronized (this.f10422a) {
                try {
                    if (this.f10433l == null) {
                        this.f10433l = N("TOSYNC_STATE", true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f10433l;
    }

    /* access modifiers changed from: protected */
    public t4 G() {
        if (this.f10433l == null) {
            this.f10433l = z().c("TOSYNC_STATE");
        }
        T();
        return this.f10433l;
    }

    /* access modifiers changed from: package-private */
    public void J() {
        if (this.f10432k == null) {
            synchronized (this.f10422a) {
                try {
                    if (this.f10432k == null) {
                        this.f10432k = N("CURRENT_STATE", true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        F();
    }

    /* access modifiers changed from: protected */
    public abstract t4 N(String str, boolean z10);

    /* access modifiers changed from: protected */
    public abstract void O(JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    public boolean P() {
        boolean z10 = false;
        if (this.f10433l == null) {
            return false;
        }
        synchronized (this.f10422a) {
            if (z().d(this.f10433l, L()) != null) {
                z10 = true;
            }
            this.f10433l.q();
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public void Q(boolean z10) {
        boolean z11;
        if (this.f10424c != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f10424c = z10;
        if (z11 && z10) {
            T();
        }
    }

    /* access modifiers changed from: package-private */
    public void R() {
        z().z(new JSONObject());
        z().q();
    }

    /* access modifiers changed from: protected */
    public abstract void T();

    /* access modifiers changed from: package-private */
    public void U(JSONObject jSONObject, b4.g gVar) {
        b4.j("players/" + A() + "/on_purchase", jSONObject, gVar);
    }

    /* access modifiers changed from: package-private */
    public void V(JSONObject jSONObject, o3.s sVar) {
        if (sVar != null) {
            this.f10426e.add(sVar);
        }
        G().h(jSONObject, (Set) null);
    }

    /* access modifiers changed from: package-private */
    public void Y() {
        try {
            synchronized (this.f10422a) {
                G().s("session", Boolean.TRUE);
                G().q();
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(boolean z10) {
        this.f10425d.set(true);
        K(z10);
        this.f10425d.set(false);
    }

    /* access modifiers changed from: package-private */
    public void b0(JSONObject jSONObject, e4.a aVar) {
        if (aVar != null) {
            this.f10428g.add(aVar);
        }
        G().h(jSONObject, (Set) null);
    }

    /* access modifiers changed from: package-private */
    public abstract void c0(String str);

    /* access modifiers changed from: package-private */
    public void d0(h0.d dVar) {
        G().y(dVar);
    }

    /* access modifiers changed from: protected */
    public abstract void n(JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    public void o() {
        F().b();
        F().q();
    }

    /* access modifiers changed from: protected */
    public abstract void w(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public JSONObject y(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set set) {
        JSONObject b10;
        synchronized (this.f10422a) {
            b10 = f0.b(jSONObject, jSONObject2, jSONObject3, set);
        }
        return b10;
    }

    /* access modifiers changed from: protected */
    public t4 z() {
        if (this.f10432k == null) {
            synchronized (this.f10422a) {
                try {
                    if (this.f10432k == null) {
                        this.f10432k = N("CURRENT_STATE", true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f10432k;
    }
}
