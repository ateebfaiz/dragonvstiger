package com.onesignal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.onesignal.c3;
import com.onesignal.f1;
import com.onesignal.m1;
import com.onesignal.o3;
import com.onesignal.z1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class o1 extends d1 implements f1.c, c3.c {
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public static final Object f10822u = new Object();

    /* renamed from: v  reason: collision with root package name */
    private static ArrayList f10823v = new h();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c2 f10824a;

    /* renamed from: b  reason: collision with root package name */
    private final d3 f10825b;

    /* renamed from: c  reason: collision with root package name */
    private final oa.a f10826c;

    /* renamed from: d  reason: collision with root package name */
    private c3 f10827d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public z1 f10828e;

    /* renamed from: f  reason: collision with root package name */
    k3 f10829f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList f10830g;

    /* renamed from: h  reason: collision with root package name */
    private final Set f10831h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final Set f10832i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Set f10833j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final Set f10834k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList f10835l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public List f10836m = null;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public v1 f10837n = null;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10838o = true;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f10839p = false;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public String f10840q = "";
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public n1 f10841r = null;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public boolean f10842s = false;

    /* renamed from: t  reason: collision with root package name */
    Date f10843t = null;

    class a implements z1.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10844a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q1 f10845b;

        a(String str, q1 q1Var) {
            this.f10844a = str;
            this.f10845b = q1Var;
        }

        public void onFailure(String str) {
            o1.this.f10834k.remove(this.f10844a);
            this.f10845b.m(this.f10844a);
        }

        public void onSuccess(String str) {
        }
    }

    class b extends k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q1 f10847a;

        b(q1 q1Var) {
            this.f10847a = q1Var;
        }

        public void run() {
            super.run();
            o1.this.f10828e.A(this.f10847a);
            o1.this.f10828e.B(o1.this.f10843t);
        }
    }

    class c implements o3.w {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f10849a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q1 f10850b;

        c(boolean z10, q1 q1Var) {
            this.f10849a = z10;
            this.f10850b = q1Var;
        }

        public void a(JSONObject jSONObject) {
            boolean unused = o1.this.f10842s = false;
            if (jSONObject != null) {
                String unused2 = o1.this.f10840q = jSONObject.toString();
            }
            if (o1.this.f10841r != null) {
                if (!this.f10849a) {
                    o3.s0().k(this.f10850b.f10768a);
                }
                n1 n10 = o1.this.f10841r;
                o1 o1Var = o1.this;
                n10.h(o1Var.w0(o1Var.f10841r.a()));
                c5.I(this.f10850b, o1.this.f10841r);
                n1 unused3 = o1.this.f10841r = null;
            }
        }
    }

    class d implements z1.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q1 f10852a;

        d(q1 q1Var) {
            this.f10852a = q1Var;
        }

        public void onFailure(String str) {
            boolean unused = o1.this.f10839p = false;
            try {
                if (new JSONObject(str).getBoolean("retry")) {
                    o1.this.n0(this.f10852a);
                } else {
                    o1.this.b0(this.f10852a, true);
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }

        public void onSuccess(String str) {
            try {
                n1 p10 = o1.this.k0(new JSONObject(str), this.f10852a);
                if (p10.a() == null) {
                    o1.this.f10824a.b("displayMessage:OnSuccess: No HTML retrieved from loadMessageContent");
                } else if (o1.this.f10842s) {
                    n1 unused = o1.this.f10841r = p10;
                } else {
                    o3.s0().k(this.f10852a.f10768a);
                    o1.this.i0(this.f10852a);
                    p10.h(o1.this.w0(p10.a()));
                    c5.I(this.f10852a, p10);
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
    }

    class e implements z1.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q1 f10854a;

        e(q1 q1Var) {
            this.f10854a = q1Var;
        }

        public void onFailure(String str) {
            o1.this.H((q1) null);
        }

        public void onSuccess(String str) {
            try {
                n1 p10 = o1.this.k0(new JSONObject(str), this.f10854a);
                if (p10.a() == null) {
                    o1.this.f10824a.b("displayPreviewMessage:OnSuccess: No HTML retrieved from loadMessageContent");
                } else if (o1.this.f10842s) {
                    n1 unused = o1.this.f10841r = p10;
                } else {
                    o1.this.i0(this.f10854a);
                    p10.h(o1.this.w0(p10.a()));
                    c5.I(this.f10854a, p10);
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
    }

    class f extends k {
        f() {
        }

        public void run() {
            super.run();
            o1.this.f10828e.h();
        }
    }

    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f10857a;

        g(Map map) {
            this.f10857a = map;
        }

        public void run() {
            o1.this.f10824a.b("Delaying addTriggers due to redisplay data not retrieved yet");
            o1.this.F(this.f10857a.keySet());
        }
    }

    class h extends ArrayList {
        h() {
            add(com.alibaba.pdns.f.f17924q);
            add("app");
            add("all");
        }
    }

    class i extends k {
        i() {
        }

        public void run() {
            super.run();
            synchronized (o1.f10822u) {
                o1 o1Var = o1.this;
                List unused = o1Var.f10836m = o1Var.f10828e.k();
                c2 v10 = o1.this.f10824a;
                v10.b("Retrieved IAMs from DB redisplayedInAppMessages: " + o1.this.f10836m.toString());
            }
        }
    }

    class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ JSONArray f10860a;

        j(JSONArray jSONArray) {
            this.f10860a = jSONArray;
        }

        public void run() {
            o1.this.p0();
            try {
                o1.this.m0(this.f10860a);
            } catch (JSONException e10) {
                o1.this.f10824a.a("ERROR processing InAppMessageJson JSON Response.", e10);
            }
        }
    }

    class k implements Runnable {
        k() {
        }

        public void run() {
            o1.this.f10824a.b("Delaying evaluateInAppMessages due to redisplay data not retrieved yet");
            o1.this.K();
        }
    }

    class l implements z1.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q1 f10863a;

        l(q1 q1Var) {
            this.f10863a = q1Var;
        }

        public void onFailure(String str) {
            o1.this.f10832i.remove(this.f10863a.f10768a);
        }

        public void onSuccess(String str) {
        }
    }

    class m implements o3.x {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q1 f10865a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f10866b;

        m(q1 q1Var, List list) {
            this.f10865a = q1Var;
            this.f10866b = list;
        }

        public void a(o3.z zVar) {
            v1 unused = o1.this.f10837n = null;
            c2 v10 = o1.this.f10824a;
            v10.b("IAM prompt to handle finished with result: " + zVar);
            q1 q1Var = this.f10865a;
            if (!q1Var.f10982k || zVar != o3.z.LOCATION_PERMISSIONS_MISSING_MANIFEST) {
                o1.this.v0(q1Var, this.f10866b);
            } else {
                o1.this.u0(q1Var, this.f10866b);
            }
        }
    }

    class n implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q1 f10868a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f10869b;

        n(q1 q1Var, List list) {
            this.f10868a = q1Var;
            this.f10869b = list;
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            o1.this.v0(this.f10868a, this.f10869b);
        }
    }

    class o implements z1.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10871a;

        o(String str) {
            this.f10871a = str;
        }

        public void onFailure(String str) {
            o1.this.f10833j.remove(this.f10871a);
        }

        public void onSuccess(String str) {
        }
    }

    protected o1(v3 v3Var, d3 d3Var, c2 c2Var, y2 y2Var, oa.a aVar) {
        this.f10825b = d3Var;
        this.f10830g = new ArrayList();
        Set K = OSUtils.K();
        this.f10831h = K;
        this.f10835l = new ArrayList();
        Set K2 = OSUtils.K();
        this.f10832i = K2;
        Set K3 = OSUtils.K();
        this.f10833j = K3;
        Set K4 = OSUtils.K();
        this.f10834k = K4;
        this.f10829f = new k3(this);
        this.f10827d = new c3(this);
        this.f10826c = aVar;
        this.f10824a = c2Var;
        z1 S = S(v3Var, c2Var, y2Var);
        this.f10828e = S;
        Set m10 = S.m();
        if (m10 != null) {
            K.addAll(m10);
        }
        Set p10 = this.f10828e.p();
        if (p10 != null) {
            K2.addAll(p10);
        }
        Set s10 = this.f10828e.s();
        if (s10 != null) {
            K3.addAll(s10);
        }
        Set l10 = this.f10828e.l();
        if (l10 != null) {
            K4.addAll(l10);
        }
        Date q10 = this.f10828e.q();
        if (q10 != null) {
            this.f10843t = q10;
        }
        V();
    }

    private void D() {
        synchronized (this.f10835l) {
            try {
                if (!this.f10827d.c()) {
                    this.f10824a.c("In app message not showing due to system condition not correct");
                    return;
                }
                c2 c2Var = this.f10824a;
                c2Var.b("displayFirstIAMOnQueue: " + this.f10835l);
                if (this.f10835l.size() <= 0 || X()) {
                    c2 c2Var2 = this.f10824a;
                    c2Var2.b("In app message is currently showing or there are no IAMs left in the queue! isInAppMessageShowing: " + X());
                    return;
                }
                this.f10824a.b("No IAM showing currently, showing first item in the queue!");
                I((q1) this.f10835l.get(0));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void E(q1 q1Var, List list) {
        if (list.size() > 0) {
            c2 c2Var = this.f10824a;
            c2Var.b("IAM showing prompts from IAM: " + q1Var.toString());
            c5.x();
            v0(q1Var, list);
        }
    }

    /* access modifiers changed from: private */
    public void F(Collection collection) {
        Z(collection);
        K();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H(com.onesignal.q1 r6) {
        /*
            r5 = this;
            com.onesignal.x2 r0 = com.onesignal.o3.s0()
            r0.i()
            boolean r0 = r5.t0()
            if (r0 == 0) goto L_0x0015
            com.onesignal.c2 r6 = r5.f10824a
            java.lang.String r0 = "Stop evaluateMessageDisplayQueue because prompt is currently displayed"
            r6.b(r0)
            return
        L_0x0015:
            r0 = 0
            r5.f10839p = r0
            java.util.ArrayList r1 = r5.f10835l
            monitor-enter(r1)
            if (r6 == 0) goto L_0x0061
            boolean r2 = r6.f10982k     // Catch:{ all -> 0x003a }
            if (r2 != 0) goto L_0x0061
            java.util.ArrayList r2 = r5.f10835l     // Catch:{ all -> 0x003a }
            int r2 = r2.size()     // Catch:{ all -> 0x003a }
            if (r2 <= 0) goto L_0x0061
            java.util.ArrayList r2 = r5.f10835l     // Catch:{ all -> 0x003a }
            boolean r6 = r2.contains(r6)     // Catch:{ all -> 0x003a }
            if (r6 != 0) goto L_0x003c
            com.onesignal.c2 r6 = r5.f10824a     // Catch:{ all -> 0x003a }
            java.lang.String r0 = "Message already removed from the queue!"
            r6.b(r0)     // Catch:{ all -> 0x003a }
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r6 = move-exception
            goto L_0x00a1
        L_0x003c:
            java.util.ArrayList r6 = r5.f10835l     // Catch:{ all -> 0x003a }
            java.lang.Object r6 = r6.remove(r0)     // Catch:{ all -> 0x003a }
            com.onesignal.q1 r6 = (com.onesignal.q1) r6     // Catch:{ all -> 0x003a }
            java.lang.String r6 = r6.f10768a     // Catch:{ all -> 0x003a }
            com.onesignal.c2 r2 = r5.f10824a     // Catch:{ all -> 0x003a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r3.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "In app message with id: "
            r3.append(r4)     // Catch:{ all -> 0x003a }
            r3.append(r6)     // Catch:{ all -> 0x003a }
            java.lang.String r6 = ", dismissed (removed) from the queue!"
            r3.append(r6)     // Catch:{ all -> 0x003a }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x003a }
            r2.b(r6)     // Catch:{ all -> 0x003a }
        L_0x0061:
            java.util.ArrayList r6 = r5.f10835l     // Catch:{ all -> 0x003a }
            int r6 = r6.size()     // Catch:{ all -> 0x003a }
            if (r6 <= 0) goto L_0x0095
            com.onesignal.c2 r6 = r5.f10824a     // Catch:{ all -> 0x003a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r2.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r3 = "In app message on queue available: "
            r2.append(r3)     // Catch:{ all -> 0x003a }
            java.util.ArrayList r3 = r5.f10835l     // Catch:{ all -> 0x003a }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x003a }
            com.onesignal.q1 r3 = (com.onesignal.q1) r3     // Catch:{ all -> 0x003a }
            java.lang.String r3 = r3.f10768a     // Catch:{ all -> 0x003a }
            r2.append(r3)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x003a }
            r6.b(r2)     // Catch:{ all -> 0x003a }
            java.util.ArrayList r6 = r5.f10835l     // Catch:{ all -> 0x003a }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ all -> 0x003a }
            com.onesignal.q1 r6 = (com.onesignal.q1) r6     // Catch:{ all -> 0x003a }
            r5.I(r6)     // Catch:{ all -> 0x003a }
            goto L_0x009f
        L_0x0095:
            com.onesignal.c2 r6 = r5.f10824a     // Catch:{ all -> 0x003a }
            java.lang.String r0 = "In app message dismissed evaluating messages"
            r6.b(r0)     // Catch:{ all -> 0x003a }
            r5.K()     // Catch:{ all -> 0x003a }
        L_0x009f:
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            return
        L_0x00a1:
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.o1.H(com.onesignal.q1):void");
    }

    private void I(q1 q1Var) {
        if (!this.f10838o) {
            this.f10824a.e("In app messaging is currently paused, in app messages will not be shown!");
            return;
        }
        this.f10839p = true;
        T(q1Var, false);
        this.f10828e.n(o3.f10886d, q1Var.f10768a, x0(q1Var), new d(q1Var));
    }

    /* access modifiers changed from: private */
    public void K() {
        this.f10824a.b("Starting evaluateInAppMessages");
        if (s0()) {
            this.f10825b.c(new k());
            return;
        }
        Iterator it = this.f10830g.iterator();
        while (it.hasNext()) {
            q1 q1Var = (q1) it.next();
            if (this.f10829f.c(q1Var)) {
                r0(q1Var);
                if (!this.f10831h.contains(q1Var.f10768a) && !q1Var.h()) {
                    n0(q1Var);
                }
            }
        }
    }

    private void M(m1 m1Var) {
        if (m1Var.b() != null && !m1Var.b().isEmpty()) {
            if (m1Var.f() == m1.a.BROWSER) {
                OSUtils.N(m1Var.b());
            } else if (m1Var.f() == m1.a.IN_APP_WEBVIEW) {
                t3.b(m1Var.b(), true);
            }
        }
    }

    private void N(String str, List list) {
        o3.s0().h(str);
        o3.z1(list);
    }

    private void O(String str, m1 m1Var) {
        String str2 = o3.I;
    }

    private void P(q1 q1Var, m1 m1Var) {
        String x02 = x0(q1Var);
        if (x02 != null) {
            String a10 = m1Var.a();
            if ((q1Var.e().e() && q1Var.f(a10)) || !this.f10834k.contains(a10)) {
                this.f10834k.add(a10);
                q1Var.a(a10);
                this.f10828e.D(o3.f10886d, o3.z0(), x02, new OSUtils().e(), q1Var.f10768a, a10, m1Var.g(), this.f10834k, new a(a10, q1Var));
            }
        }
    }

    private void Q(q1 q1Var, t1 t1Var) {
        String x02 = x0(q1Var);
        if (x02 != null) {
            String a10 = t1Var.a();
            String str = q1Var.f10768a + a10;
            if (this.f10833j.contains(str)) {
                this.f10824a.e("Already sent page impression for id: " + a10);
                return;
            }
            this.f10833j.add(str);
            this.f10828e.F(o3.f10886d, o3.z0(), x02, new OSUtils().e(), q1Var.f10768a, a10, this.f10833j, new o(str));
        }
    }

    private void R(m1 m1Var) {
        if (m1Var.e() != null) {
            a2 e10 = m1Var.e();
            if (e10.a() != null) {
                o3.B1(e10.a());
            }
            if (e10.b() != null) {
                o3.F(e10.b(), (o3.s) null);
            }
        }
    }

    private void T(q1 q1Var, boolean z10) {
        this.f10842s = false;
        if (z10 || q1Var.d()) {
            this.f10842s = true;
            o3.v0(new c(z10, q1Var));
        }
    }

    private boolean U(q1 q1Var) {
        boolean z10;
        if (this.f10829f.f(q1Var)) {
            return !q1Var.g();
        }
        if (q1Var.g() || !q1Var.f10974c.isEmpty()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (q1Var.i() || z10) {
            return true;
        }
        return false;
    }

    private void Y(m1 m1Var) {
        if (m1Var.e() != null) {
            c2 c2Var = this.f10824a;
            c2Var.b("Tags detected inside of the action click payload, ignoring because action came from IAM preview:: " + m1Var.e().toString());
        }
        if (m1Var.c().size() > 0) {
            c2 c2Var2 = this.f10824a;
            c2Var2.b("Outcomes detected inside of the action click payload, ignoring because action came from IAM preview: " + m1Var.c().toString());
        }
    }

    private void Z(Collection collection) {
        Iterator it = this.f10830g.iterator();
        while (it.hasNext()) {
            q1 q1Var = (q1) it.next();
            if (!q1Var.i() && this.f10836m.contains(q1Var) && this.f10829f.e(q1Var, collection)) {
                c2 c2Var = this.f10824a;
                c2Var.b("Trigger changed for message: " + q1Var.toString());
                q1Var.p(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public n1 k0(JSONObject jSONObject, q1 q1Var) {
        n1 n1Var = new n1(jSONObject);
        q1Var.n(n1Var.b().doubleValue());
        return n1Var;
    }

    private void l0(q1 q1Var) {
        q1Var.e().h(o3.w0().b() / 1000);
        q1Var.e().c();
        q1Var.p(false);
        q1Var.o(true);
        d(new b(q1Var), "OS_IAM_DB_ACCESS");
        int indexOf = this.f10836m.indexOf(q1Var);
        if (indexOf != -1) {
            this.f10836m.set(indexOf, q1Var);
        } else {
            this.f10836m.add(q1Var);
        }
        c2 c2Var = this.f10824a;
        c2Var.b("persistInAppMessageForRedisplay: " + q1Var.toString() + " with msg array data: " + this.f10836m.toString());
    }

    /* access modifiers changed from: private */
    public void m0(JSONArray jSONArray) {
        synchronized (f10822u) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    q1 q1Var = new q1(jSONArray.getJSONObject(i10));
                    if (q1Var.f10768a != null) {
                        arrayList.add(q1Var);
                    }
                }
                this.f10830g = arrayList;
            } finally {
                while (true) {
                }
            }
        }
        K();
    }

    /* access modifiers changed from: private */
    public void n0(q1 q1Var) {
        synchronized (this.f10835l) {
            try {
                if (!this.f10835l.contains(q1Var)) {
                    this.f10835l.add(q1Var);
                    c2 c2Var = this.f10824a;
                    c2Var.b("In app message with id: " + q1Var.f10768a + ", added to the queue");
                }
                D();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public void p0() {
        for (q1 o10 : this.f10836m) {
            o10.o(false);
        }
    }

    private void r0(q1 q1Var) {
        boolean contains = this.f10831h.contains(q1Var.f10768a);
        int indexOf = this.f10836m.indexOf(q1Var);
        if (contains && indexOf != -1) {
            q1 q1Var2 = (q1) this.f10836m.get(indexOf);
            q1Var.e().g(q1Var2.e());
            q1Var.o(q1Var2.g());
            boolean U = U(q1Var);
            c2 c2Var = this.f10824a;
            c2Var.b("setDataForRedisplay: " + q1Var.toString() + " triggerHasChanged: " + U);
            if (U && q1Var.e().d() && q1Var.e().i()) {
                c2 c2Var2 = this.f10824a;
                c2Var2.b("setDataForRedisplay message available for redisplay: " + q1Var.f10768a);
                this.f10831h.remove(q1Var.f10768a);
                this.f10832i.remove(q1Var.f10768a);
                this.f10833j.clear();
                this.f10828e.C(this.f10833j);
                q1Var.b();
            }
        }
    }

    private boolean t0() {
        if (this.f10837n != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void u0(q1 q1Var, List list) {
        String string = o3.f10882b.getString(o4.f10950b);
        new AlertDialog.Builder(o3.Q()).setTitle(string).setMessage(o3.f10882b.getString(o4.f10949a)).setPositiveButton(17039370, new n(q1Var, list)).show();
    }

    /* access modifiers changed from: private */
    public void v0(q1 q1Var, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            v1 v1Var = (v1) it.next();
            if (!v1Var.c()) {
                this.f10837n = v1Var;
                break;
            }
        }
        if (this.f10837n != null) {
            c2 c2Var = this.f10824a;
            c2Var.b("IAM prompt to handle: " + this.f10837n.toString());
            this.f10837n.d(true);
            this.f10837n.b(new m(q1Var, list));
            return;
        }
        c2 c2Var2 = this.f10824a;
        c2Var2.b("No IAM prompt to handle, dismiss message: " + q1Var.f10768a);
        a0(q1Var);
    }

    private String x0(q1 q1Var) {
        String b10 = this.f10826c.b();
        Iterator it = f10823v.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (q1Var.f10973b.containsKey(str)) {
                HashMap hashMap = (HashMap) q1Var.f10973b.get(str);
                if (hashMap.containsKey(b10)) {
                    return (String) hashMap.get(b10);
                }
                return (String) hashMap.get("default");
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void C(Map map) {
        c2 c2Var = this.f10824a;
        c2Var.b("Triggers added: " + map.toString());
        this.f10829f.a(map);
        if (s0()) {
            this.f10825b.c(new g(map));
        } else {
            F(map.keySet());
        }
    }

    /* access modifiers changed from: package-private */
    public void G() {
        d(new f(), "OS_IAM_DB_ACCESS");
    }

    /* access modifiers changed from: package-private */
    public void J(String str) {
        this.f10839p = true;
        q1 q1Var = new q1(true);
        T(q1Var, true);
        this.f10828e.o(o3.f10886d, str, new e(q1Var));
    }

    /* access modifiers changed from: package-private */
    public void L(Runnable runnable) {
        synchronized (f10822u) {
            try {
                if (s0()) {
                    this.f10824a.b("Delaying task due to redisplay data not retrieved yet");
                    this.f10825b.c(runnable);
                } else {
                    runnable.run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public z1 S(v3 v3Var, c2 c2Var, y2 y2Var) {
        if (this.f10828e == null) {
            this.f10828e = new z1(v3Var, c2Var, y2Var);
        }
        return this.f10828e;
    }

    /* access modifiers changed from: protected */
    public void V() {
        this.f10825b.c(new i());
        this.f10825b.f();
    }

    /* access modifiers changed from: package-private */
    public void W() {
        if (!this.f10830g.isEmpty()) {
            c2 c2Var = this.f10824a;
            c2Var.b("initWithCachedInAppMessages with already in memory messages: " + this.f10830g);
            return;
        }
        String r10 = this.f10828e.r();
        c2 c2Var2 = this.f10824a;
        c2Var2.b("initWithCachedInAppMessages: " + r10);
        if (r10 != null && !r10.isEmpty()) {
            synchronized (f10822u) {
                try {
                    if (this.f10830g.isEmpty()) {
                        m0(new JSONArray(r10));
                    }
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean X() {
        return this.f10839p;
    }

    public void a() {
        this.f10824a.b("messageTriggerConditionChanged called");
        K();
    }

    /* access modifiers changed from: package-private */
    public void a0(q1 q1Var) {
        b0(q1Var, false);
    }

    public void b(String str) {
        c2 c2Var = this.f10824a;
        c2Var.b("messageDynamicTriggerCompleted called with triggerId: " + str);
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        Z(hashSet);
    }

    /* access modifiers changed from: package-private */
    public void b0(q1 q1Var, boolean z10) {
        if (!q1Var.f10982k) {
            this.f10831h.add(q1Var.f10768a);
            if (!z10) {
                this.f10828e.x(this.f10831h);
                this.f10843t = new Date();
                l0(q1Var);
            }
            c2 c2Var = this.f10824a;
            c2Var.b("OSInAppMessageController messageWasDismissed dismissedMessages: " + this.f10831h.toString());
        }
        if (!t0()) {
            e0(q1Var);
        }
        H(q1Var);
    }

    public void c() {
        D();
    }

    /* access modifiers changed from: package-private */
    public void c0(q1 q1Var, JSONObject jSONObject) {
        m1 m1Var = new m1(jSONObject);
        m1Var.j(q1Var.q());
        O(q1Var.f10768a, m1Var);
        E(q1Var, m1Var.d());
        M(m1Var);
        P(q1Var, m1Var);
        R(m1Var);
        N(q1Var.f10768a, m1Var.c());
    }

    /* access modifiers changed from: package-private */
    public void d0(q1 q1Var, JSONObject jSONObject) {
        m1 m1Var = new m1(jSONObject);
        m1Var.j(q1Var.q());
        O(q1Var.f10768a, m1Var);
        E(q1Var, m1Var.d());
        M(m1Var);
        Y(m1Var);
    }

    /* access modifiers changed from: package-private */
    public void e0(q1 q1Var) {
        this.f10824a.e("OSInAppMessageController onMessageDidDismiss: inAppMessageLifecycleHandler is null");
    }

    /* access modifiers changed from: package-private */
    public void f0(q1 q1Var) {
        this.f10824a.e("OSInAppMessageController onMessageDidDisplay: inAppMessageLifecycleHandler is null");
    }

    /* access modifiers changed from: package-private */
    public void g0(q1 q1Var) {
        f0(q1Var);
        if (!q1Var.f10982k && !this.f10832i.contains(q1Var.f10768a)) {
            this.f10832i.add(q1Var.f10768a);
            String x02 = x0(q1Var);
            if (x02 != null) {
                this.f10828e.E(o3.f10886d, o3.z0(), x02, new OSUtils().e(), q1Var.f10768a, this.f10832i, new l(q1Var));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h0(q1 q1Var) {
        this.f10824a.e("OSInAppMessageController onMessageWillDismiss: inAppMessageLifecycleHandler is null");
    }

    /* access modifiers changed from: package-private */
    public void i0(q1 q1Var) {
        this.f10824a.e("OSInAppMessageController onMessageWillDisplay: inAppMessageLifecycleHandler is null");
    }

    /* access modifiers changed from: package-private */
    public void j0(q1 q1Var, JSONObject jSONObject) {
        t1 t1Var = new t1(jSONObject);
        if (!q1Var.f10982k) {
            Q(q1Var, t1Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void o0(JSONArray jSONArray) {
        this.f10828e.y(jSONArray.toString());
        L(new j(jSONArray));
    }

    /* access modifiers changed from: package-private */
    public void q0() {
        f1.e();
    }

    /* access modifiers changed from: package-private */
    public boolean s0() {
        boolean z10;
        synchronized (f10822u) {
            try {
                if (this.f10836m != null || !this.f10825b.e()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public String w0(String str) {
        String str2 = this.f10840q;
        return str + String.format("\n\n<script>\n    setPlayerTags(%s);\n</script>", new Object[]{str2});
    }
}
