package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.work.WorkRequest;
import com.onesignal.a4;
import com.onesignal.b4;
import com.onesignal.b5;
import com.onesignal.e2;
import com.onesignal.e4;
import com.onesignal.g2;
import com.onesignal.g4;
import com.onesignal.h0;
import com.onesignal.j4;
import com.onesignal.x2;
import com.zing.zalo.zalosdk.common.Constant;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class o3 {
    private static p3 A = new c4();
    /* access modifiers changed from: private */
    public static y2 B;
    /* access modifiers changed from: private */
    public static ma.e C;
    private static x2 D;
    /* access modifiers changed from: private */
    public static q2 E;
    private static pa.c F;
    private static g2 G;
    private static final Object H = new j();
    public static String I = "native";
    /* access modifiers changed from: private */
    public static String J;
    private static OSUtils K = new OSUtils();
    /* access modifiers changed from: private */
    public static boolean L;
    /* access modifiers changed from: private */
    public static boolean M;
    /* access modifiers changed from: private */
    public static boolean N;
    private static boolean O;
    /* access modifiers changed from: private */
    public static boolean P;
    /* access modifiers changed from: private */
    public static h0.d Q;
    private static Collection R = new ArrayList();
    private static HashSet S = new HashSet();
    /* access modifiers changed from: private */
    public static final ArrayList T = new ArrayList();
    private static r U;
    private static r2 V;
    static r2 W;
    private static o2 X;
    private static OSSubscriptionState Y;
    static OSSubscriptionState Z;

    /* renamed from: a  reason: collision with root package name */
    private static List f10880a = new ArrayList();

    /* renamed from: a0  reason: collision with root package name */
    private static o2 f10881a0;

    /* renamed from: b  reason: collision with root package name */
    static Context f10882b;

    /* renamed from: b0  reason: collision with root package name */
    private static h1 f10883b0;

    /* renamed from: c  reason: collision with root package name */
    static WeakReference f10884c;

    /* renamed from: c0  reason: collision with root package name */
    static h1 f10885c0;

    /* renamed from: d  reason: collision with root package name */
    static String f10886d;

    /* renamed from: d0  reason: collision with root package name */
    private static o2 f10887d0;

    /* renamed from: e  reason: collision with root package name */
    static String f10888e;

    /* renamed from: e0  reason: collision with root package name */
    private static v2 f10889e0;

    /* renamed from: f  reason: collision with root package name */
    private static v f10890f = v.NONE;

    /* renamed from: f0  reason: collision with root package name */
    static v2 f10891f0;

    /* renamed from: g  reason: collision with root package name */
    private static v f10892g = v.WARN;

    /* renamed from: g0  reason: collision with root package name */
    private static o2 f10893g0;

    /* renamed from: h  reason: collision with root package name */
    private static String f10894h = null;

    /* renamed from: h0  reason: collision with root package name */
    private static u f10895h0;

    /* renamed from: i  reason: collision with root package name */
    private static String f10896i = null;

    /* renamed from: i0  reason: collision with root package name */
    private static g4 f10897i0;

    /* renamed from: j  reason: collision with root package name */
    private static String f10898j = null;

    /* renamed from: j0  reason: collision with root package name */
    private static final List f10899j0 = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static int f10900k = Integer.MAX_VALUE;

    /* renamed from: l  reason: collision with root package name */
    static oa.a f10901l = null;

    /* renamed from: m  reason: collision with root package name */
    private static boolean f10902m;

    /* renamed from: n  reason: collision with root package name */
    private static boolean f10903n;

    /* renamed from: o  reason: collision with root package name */
    private static r f10904o = r.APP_CLOSE;

    /* renamed from: p  reason: collision with root package name */
    private static s4 f10905p;

    /* renamed from: q  reason: collision with root package name */
    private static q4 f10906q;

    /* renamed from: r  reason: collision with root package name */
    private static r4 f10907r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static c2 f10908s = new b2();

    /* renamed from: t  reason: collision with root package name */
    private static s f10909t;

    /* renamed from: u  reason: collision with root package name */
    private static x2.b f10910u = new c();

    /* renamed from: v  reason: collision with root package name */
    private static p1 f10911v = new p1();

    /* renamed from: w  reason: collision with root package name */
    private static g3 f10912w = new h3();
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public static u2 f10913x = new u2();

    /* renamed from: y  reason: collision with root package name */
    private static d3 f10914y = new d3(f10908s);

    /* renamed from: z  reason: collision with root package name */
    private static e3 f10915z = new e3(f10913x, f10908s);

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                o3.o1();
            } catch (JSONException e10) {
                o3.b(v.FATAL, "FATAL Error registering device!", e10);
            }
        }
    }

    public interface a0 {
        void a(boolean z10);
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ JSONObject f10916a;

        b(JSONObject jSONObject, s sVar) {
            this.f10916a = jSONObject;
        }

        public void run() {
            o3.f10908s.b("Running sendTags() operation from pending task queue.");
            o3.C1(this.f10916a, (s) null);
        }
    }

    public static class b0 {

        /* renamed from: a  reason: collision with root package name */
        private String f10917a;

        /* renamed from: b  reason: collision with root package name */
        private int f10918b;

        b0(int i10, String str) {
            this.f10917a = str;
            this.f10918b = i10;
        }
    }

    class c implements x2.b {
        c() {
        }

        public void a(List list) {
            if (o3.E == null) {
                o3.a(v.WARN, "OneSignal onSessionEnding called before init!");
            }
            if (o3.E != null) {
                o3.E.e();
            }
            o3.b0().g(list);
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ JSONObject f10919a;

        d(JSONObject jSONObject, s sVar) {
            this.f10919a = jSONObject;
        }

        public void run() {
            if (this.f10919a == null) {
                o3.f10908s.d("Attempted to send null tags");
                return;
            }
            JSONObject jSONObject = e4.h(false).f10444b;
            JSONObject jSONObject2 = new JSONObject();
            Iterator<String> keys = this.f10919a.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    Object opt = this.f10919a.opt(next);
                    if (!(opt instanceof JSONArray)) {
                        if (!(opt instanceof JSONObject)) {
                            if (!this.f10919a.isNull(next)) {
                                if (!"".equals(opt)) {
                                    jSONObject2.put(next, opt.toString());
                                }
                            }
                            if (jSONObject != null && jSONObject.has(next)) {
                                jSONObject2.put(next, "");
                            }
                        }
                    }
                    v vVar = v.ERROR;
                    o3.a(vVar, "Omitting key '" + next + "'! sendTags DO NOT supported nested values!");
                } catch (Throwable unused) {
                }
            }
            if (!jSONObject2.toString().equals("{}")) {
                c2 d10 = o3.f10908s;
                d10.b("Available tags to send: " + jSONObject2.toString());
                e4.q(jSONObject2, (s) null);
                return;
            }
            o3.f10908s.b("Send tags ended successfully");
        }
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f10920a;

        e(w wVar) {
            this.f10920a = wVar;
        }

        public void run() {
            o3.f10908s.b("Running getTags() operation from pending queue.");
            o3.v0(this.f10920a);
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f10921a;

        f(w wVar) {
            this.f10921a = wVar;
        }

        public void run() {
            synchronized (o3.T) {
                try {
                    o3.T.add(this.f10921a);
                    if (o3.T.size() <= 1) {
                        o3.s1();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            JSONObject jSONObject;
            b5.e h10 = e4.h(!o3.N);
            if (h10.f10443a) {
                boolean unused = o3.N = true;
            }
            synchronized (o3.T) {
                try {
                    Iterator it = o3.T.iterator();
                    while (it.hasNext()) {
                        w wVar = (w) it.next();
                        if (h10.f10444b != null) {
                            if (!h10.toString().equals("{}")) {
                                jSONObject = h10.f10444b;
                                wVar.a(jSONObject);
                            }
                        }
                        jSONObject = null;
                        wVar.a(jSONObject);
                    }
                    o3.T.clear();
                } finally {
                }
            }
        }
    }

    class h extends b4.g {
        h() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i10, String str, Throwable th) {
            o3.U0("sending Notification Opened Failed", i10, th, str);
        }
    }

    class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f10922a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f10923b;

        i(x xVar, boolean z10) {
            this.f10922a = xVar;
            this.f10923b = z10;
        }

        public void run() {
            o3.f10908s.b("Running promptLocation() operation from pending queue.");
            o3.i1(this.f10922a, this.f10923b);
        }
    }

    class j {
        j() {
        }
    }

    class k extends h0.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f10924a;

        k(x xVar) {
            this.f10924a = xVar;
        }

        public void a(h0.d dVar) {
            if (!o3.L1("promptLocation()") && dVar != null) {
                e4.w(dVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(z zVar) {
            super.b(zVar);
            x xVar = this.f10924a;
            if (xVar != null) {
                xVar.a(zVar);
            }
        }

        public h0.f getType() {
            return h0.f.PROMPT_LOCATION;
        }
    }

    class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f10925a;

        l(int i10) {
            this.f10925a = i10;
        }

        public void run() {
            o3.f10908s.b("Running removeNotification() operation from pending queue.");
            o3.q1(this.f10925a);
        }
    }

    class m implements h0.b {
        m() {
        }

        public void a(h0.d dVar) {
            h0.d unused = o3.Q = dVar;
            boolean unused2 = o3.M = true;
            o3.n1();
        }

        public h0.f getType() {
            return h0.f.STARTUP;
        }
    }

    class n implements g4.a {
        n() {
        }

        public void a(String str, int i10) {
            c2 d10 = o3.f10908s;
            d10.b("registerForPushToken completed with id: " + str + " status: " + i10);
            if (i10 < 1) {
                if (e4.e() == null && (o3.f10900k == 1 || o3.j1(o3.f10900k))) {
                    int unused = o3.f10900k = i10;
                }
            } else if (o3.j1(o3.f10900k)) {
                int unused2 = o3.f10900k = i10;
            }
            String unused3 = o3.J = str;
            boolean unused4 = o3.L = true;
            o3.U(o3.f10882b).f(str);
            o3.n1();
        }
    }

    class o implements a4.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f10926a;

        o(boolean z10) {
            this.f10926a = z10;
        }

        public void a(a4.f fVar) {
            boolean unused = o3.P = false;
            String str = fVar.f10365a;
            if (str != null) {
                o3.f10888e = str;
            }
            o3.f10913x.q(fVar, o3.C, o3.B, o3.f10908s);
            o3.c1();
            x0.g(o3.f10882b, fVar.f10369e);
            if (this.f10926a) {
                o3.m1();
            }
        }
    }

    class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f10927a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10928b;

        p(v vVar, String str) {
            this.f10927a = vVar;
            this.f10928b = str;
        }

        public void run() {
            if (o3.Q() != null) {
                new AlertDialog.Builder(o3.Q()).setTitle(this.f10927a.toString()).setMessage(this.f10928b).show();
            }
        }
    }

    class q implements Runnable {
        q() {
        }

        public void run() {
            o3.f10908s.b("Running onAppLostFocus() operation from a pending task queue.");
            o3.C();
        }
    }

    public enum r {
        NOTIFICATION_CLICK,
        APP_OPEN,
        APP_CLOSE;

        public boolean b() {
            return equals(APP_CLOSE);
        }

        public boolean c() {
            return equals(APP_OPEN);
        }

        public boolean d() {
            return equals(NOTIFICATION_CLICK);
        }
    }

    public interface s {
        void a(b0 b0Var);
    }

    interface t {
        void a(r rVar);
    }

    private static class u {

        /* renamed from: a  reason: collision with root package name */
        JSONArray f10933a;

        /* renamed from: b  reason: collision with root package name */
        boolean f10934b;

        /* renamed from: c  reason: collision with root package name */
        b4.g f10935c;

        u(JSONArray jSONArray) {
            this.f10933a = jSONArray;
        }
    }

    public enum v {
        NONE,
        FATAL,
        ERROR,
        WARN,
        INFO,
        DEBUG,
        VERBOSE
    }

    public interface w {
        void a(JSONObject jSONObject);
    }

    interface x {
        void a(z zVar);
    }

    public interface y {
        void a(p2 p2Var);
    }

    enum z {
        PERMISSION_GRANTED,
        PERMISSION_DENIED,
        LOCATION_PERMISSIONS_MISSING_MANIFEST,
        ERROR
    }

    static {
        z2 z2Var = new z2();
        B = z2Var;
        ma.e eVar = new ma.e(z2Var, f10908s, f10912w);
        C = eVar;
        D = new x2(f10910u, eVar, f10908s);
    }

    static boolean A() {
        if (f10913x.t()) {
            return OSUtils.a(f10882b);
        }
        return true;
    }

    private static void A0(Context context) {
        boolean z10;
        boolean z11;
        a b10 = b.b();
        boolean z12 = context instanceof Activity;
        if (Q() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || z12) {
            z11 = true;
        } else {
            z11 = false;
        }
        E1(z11);
        f10908s.b("OneSignal handleActivityLifecycleHandler inForeground: " + f10903n);
        if (f10903n) {
            if (z10 && z12 && b10 != null) {
                b10.s((Activity) context);
                b10.t(true);
            }
            OSNotificationRestoreWorkManager.c(context, false);
            b0().b();
        } else if (b10 != null) {
            b10.t(true);
        }
    }

    static void A1(JSONArray jSONArray, boolean z10, b4.g gVar) {
        if (!L1("sendPurchases()")) {
            if (z0() == null) {
                u uVar = new u(jSONArray);
                f10895h0 = uVar;
                uVar.f10934b = z10;
                uVar.f10935c = gVar;
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constant.PARAM_APP_ID, o0());
                if (z10) {
                    jSONObject.put("existing", true);
                }
                jSONObject.put("purchases", jSONArray);
                e4.p(jSONObject, gVar);
            } catch (Throwable th) {
                b(v.ERROR, "Failed to generate JSON for sendPurchases.", th);
            }
        }
    }

    static boolean B(v vVar) {
        if (vVar.compareTo(f10890f) < 1 || vVar.compareTo(f10892g) < 1) {
            return true;
        }
        return false;
    }

    private static void B0() {
        try {
            Class.forName("com.amazon.device.iap.PurchasingListener");
            f10906q = new q4(f10882b);
        } catch (ClassNotFoundException unused) {
        }
    }

    public static void B1(JSONObject jSONObject) {
        C1(jSONObject, (s) null);
    }

    static void C() {
        if (!f10903n) {
            q4 q4Var = f10906q;
            if (q4Var != null) {
                q4Var.c();
            }
            b0().a();
            y1();
        }
    }

    private static void C0() {
        String o02 = o0();
        if (o02 == null) {
            v vVar = v.DEBUG;
            a(vVar, "App id set for first time:  " + f10886d);
            l.d(0, f10882b);
            u1(f10886d);
        } else if (!o02.equals(f10886d)) {
            v vVar2 = v.DEBUG;
            a(vVar2, "App id has changed:\nFrom: " + o02 + "\n To: " + f10886d + "\nClearing the user id, app state, and remoteParams as they are no longer valid");
            u1(f10886d);
            e4.o();
            f10913x.a();
        }
    }

    public static void C1(JSONObject jSONObject, s sVar) {
        if (f10915z.g("sendTags()")) {
            f10908s.d("Waiting for remote params. Moving sendTags() operation to a pending task queue.");
            f10915z.c(new b(jSONObject, sVar));
        } else if (!L1("sendTags()")) {
            d dVar = new d(jSONObject, sVar);
            if (f10915z.e()) {
                f10908s.b("Sending sendTags() operation to pending task queue.");
                f10915z.c(dVar);
                return;
            }
            dVar.run();
        }
    }

    static void D(r rVar) {
        for (t a10 : new ArrayList(f10880a)) {
            a10.a(rVar);
        }
    }

    static void D0() {
    }

    public static void D1(String str) {
        if (str == null || str.isEmpty()) {
            c2 c2Var = f10908s;
            c2Var.c("setAppId called with id: " + str + ", ignoring!");
            return;
        }
        if (!str.equals(f10886d)) {
            f10902m = false;
            c2 c2Var2 = f10908s;
            c2Var2.e("setAppId called with id: " + str + " changing id from: " + f10886d);
        }
        f10886d = str;
        if (f10882b == null) {
            f10908s.c("appId set, but please call initWithContext(appContext) with Application context to complete OneSignal init!");
            return;
        }
        WeakReference weakReference = f10884c;
        if (weakReference == null || weakReference.get() == null) {
            K0(f10882b);
        } else {
            K0((Context) f10884c.get());
        }
    }

    private static void E(v vVar, String str, Throwable th) {
        if (th != null) {
            str = str + "\n" + Log.getStackTraceString(th);
        }
        Iterator it = f10899j0.iterator();
        if (it.hasNext()) {
            c.d.a(it.next());
            new ka.a(vVar, str);
            throw null;
        }
    }

    static void E0(Activity activity, JSONArray jSONArray, String str) {
        if (!L1((String) null)) {
            X0(activity, jSONArray);
            if (f10907r != null && a0()) {
                f10907r.g(M(jSONArray));
            }
            if (K1(activity, jSONArray)) {
                z(str);
            }
            e1(activity, jSONArray);
            t1(jSONArray);
        }
    }

    static void E1(boolean z10) {
        f10903n = z10;
    }

    public static void F(JSONArray jSONArray, s sVar) {
        if (!L1("deleteTags()")) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    jSONObject.put(jSONArray.getString(i10), "");
                }
                C1(jSONObject, sVar);
            } catch (Throwable th) {
                b(v.ERROR, "Failed to generate JSON for deleteTags.", th);
            }
        }
    }

    static void F0(i2 i2Var) {
        try {
            JSONObject jSONObject = new JSONObject(i2Var.e().toString());
            jSONObject.put("androidNotificationId", i2Var.a());
            m2 M2 = M(l0.g(jSONObject));
            if (f10907r != null && a0()) {
                f10907r.h(M2);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    static void F1(long j10) {
        c2 c2Var = f10908s;
        c2Var.b("Last session time set to: " + j10);
        z3.l(z3.f11153a, "OS_LAST_SESSION_TIME", j10);
    }

    private static void G() {
        if (M1()) {
            c2 c2Var = f10908s;
            c2Var.b("Starting new session with appEntryState: " + N());
            e4.r();
            g0().e();
            D.m(N());
            c0().q0();
            F1(f10912w.b());
        } else if (O0()) {
            c2 c2Var2 = f10908s;
            c2Var2.b("Continue on same session with appEntryState: " + N());
            D.c(N());
        }
        c0().W();
        if (!f10903n && J0()) {
            f10908s.b("doSessionInit on background with already registered user");
        }
        P1();
    }

    static void G0() {
    }

    public static void G1(boolean z10) {
        if (k0().f()) {
            f10908s.c("setRequiresUserPrivacyConsent already called by remote params!, ignoring user set");
        } else if (!r1() || z10) {
            k0().o(z10);
        } else {
            a(v.ERROR, "Cannot change requiresUserPrivacyConsent() from TRUE to FALSE");
        }
    }

    static void H() {
    }

    static boolean H0() {
        return !TextUtils.isEmpty(f10896i);
    }

    private static void H1(boolean z10) {
        b.c((Application) f10882b);
        if (z10) {
            f10901l = new oa.a(B);
            z3.o();
            v3 V2 = V();
            g2 g2Var = new g2(V2, f10908s);
            G = g2Var;
            g2Var.h();
            c0().G();
            if (F == null) {
                F = new pa.c(f10908s, A, V2, B);
            }
            D.g();
            g0().d();
        }
    }

    static void I() {
    }

    static boolean I0() {
        return !TextUtils.isEmpty(f10898j);
    }

    private static void I1(Context context) {
        String string;
        ApplicationInfo a10 = j.f10703a.a(context);
        if (a10 != null && (string = a10.metaData.getString("com.onesignal.PrivacyConsent")) != null) {
            G1("ENABLE".equalsIgnoreCase(string));
        }
    }

    static void J(f2 f2Var) {
        d1(v.INFO, "Fire notificationWillShowInForegroundHandler");
        n2 c10 = f2Var.c();
        try {
            throw null;
        } catch (Throwable th) {
            d1(v.ERROR, "Exception thrown while notification was being processed for display by notificationWillShowInForegroundHandler, showing notification in foreground!");
            c10.b(c10.c());
            throw th;
        }
    }

    static boolean J0() {
        if (z0() != null) {
            return true;
        }
        return false;
    }

    static boolean J1(i2 i2Var) {
        if (!O0()) {
            d1(v.INFO, "App is in background, show notification");
            return false;
        }
        d1(v.INFO, "No NotificationWillShowInForegroundHandler setup, show notification");
        return false;
    }

    static void K() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d1, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void K0(android.content.Context r5) {
        /*
            java.lang.Class<com.onesignal.o3> r0 = com.onesignal.o3.class
            monitor-enter(r0)
            com.onesignal.c2 r1 = f10908s     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = "Starting OneSignal initialization!"
            r1.e(r2)     // Catch:{ all -> 0x0049 }
            android.content.Context r1 = f10882b     // Catch:{ all -> 0x0049 }
            com.onesignal.f2.h(r1)     // Catch:{ all -> 0x0049 }
            boolean r1 = r1()     // Catch:{ all -> 0x0049 }
            r2 = 0
            if (r1 != 0) goto L_0x009e
            com.onesignal.u2 r1 = f10913x     // Catch:{ all -> 0x0049 }
            boolean r1 = r1.k()     // Catch:{ all -> 0x0049 }
            if (r1 != 0) goto L_0x0020
            goto L_0x009e
        L_0x0020:
            int r1 = f10900k     // Catch:{ all -> 0x0049 }
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == r3) goto L_0x0028
            goto L_0x0032
        L_0x0028:
            com.onesignal.OSUtils r1 = K     // Catch:{ all -> 0x0049 }
            android.content.Context r3 = f10882b     // Catch:{ all -> 0x0049 }
            java.lang.String r4 = f10886d     // Catch:{ all -> 0x0049 }
            int r1 = r1.A(r3, r4)     // Catch:{ all -> 0x0049 }
        L_0x0032:
            f10900k = r1     // Catch:{ all -> 0x0049 }
            boolean r1 = S0()     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x003c
            monitor-exit(r0)
            return
        L_0x003c:
            boolean r1 = f10902m     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x004c
            com.onesignal.c2 r5 = f10908s     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = "OneSignal SDK initialization already completed."
            r5.b(r1)     // Catch:{ all -> 0x0049 }
            monitor-exit(r0)
            return
        L_0x0049:
            r5 = move-exception
            goto L_0x00d2
        L_0x004c:
            A0(r5)     // Catch:{ all -> 0x0049 }
            f10884c = r2     // Catch:{ all -> 0x0049 }
            com.onesignal.e4.k()     // Catch:{ all -> 0x0049 }
            C0()     // Catch:{ all -> 0x0049 }
            B0()     // Catch:{ all -> 0x0049 }
            android.content.Context r5 = f10882b     // Catch:{ all -> 0x0049 }
            com.onesignal.r2 r5 = S(r5)     // Catch:{ all -> 0x0049 }
            com.onesignal.OSPermissionChangedInternalObserver.b(r5)     // Catch:{ all -> 0x0049 }
            G()     // Catch:{ all -> 0x0049 }
            android.content.Context r5 = f10882b     // Catch:{ all -> 0x0049 }
            boolean r5 = com.onesignal.s4.a(r5)     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0077
            com.onesignal.s4 r5 = new com.onesignal.s4     // Catch:{ all -> 0x0049 }
            android.content.Context r1 = f10882b     // Catch:{ all -> 0x0049 }
            r5.<init>(r1)     // Catch:{ all -> 0x0049 }
            f10905p = r5     // Catch:{ all -> 0x0049 }
        L_0x0077:
            boolean r5 = com.onesignal.r4.a()     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0086
            com.onesignal.r4 r5 = new com.onesignal.r4     // Catch:{ all -> 0x0049 }
            android.content.Context r1 = f10882b     // Catch:{ all -> 0x0049 }
            r5.<init>(r1)     // Catch:{ all -> 0x0049 }
            f10907r = r5     // Catch:{ all -> 0x0049 }
        L_0x0086:
            r5 = 1
            f10902m = r5     // Catch:{ all -> 0x0049 }
            com.onesignal.o3$v r5 = com.onesignal.o3.v.VERBOSE     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = "OneSignal SDK initialization done."
            a(r5, r1)     // Catch:{ all -> 0x0049 }
            com.onesignal.q2 r5 = g0()     // Catch:{ all -> 0x0049 }
            r5.q()     // Catch:{ all -> 0x0049 }
            com.onesignal.e3 r5 = f10915z     // Catch:{ all -> 0x0049 }
            r5.f()     // Catch:{ all -> 0x0049 }
            monitor-exit(r0)
            return
        L_0x009e:
            com.onesignal.u2 r1 = f10913x     // Catch:{ all -> 0x0049 }
            boolean r1 = r1.k()     // Catch:{ all -> 0x0049 }
            if (r1 != 0) goto L_0x00ae
            com.onesignal.c2 r1 = f10908s     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = "OneSignal SDK initialization delayed, waiting for remote params."
            r1.e(r3)     // Catch:{ all -> 0x0049 }
            goto L_0x00b5
        L_0x00ae:
            com.onesignal.c2 r1 = f10908s     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = "OneSignal SDK initialization delayed, waiting for privacy consent to be set."
            r1.e(r3)     // Catch:{ all -> 0x0049 }
        L_0x00b5:
            com.onesignal.r r1 = new com.onesignal.r     // Catch:{ all -> 0x0049 }
            android.content.Context r3 = f10882b     // Catch:{ all -> 0x0049 }
            java.lang.String r4 = f10886d     // Catch:{ all -> 0x0049 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0049 }
            U = r1     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = f10886d     // Catch:{ all -> 0x0049 }
            f10886d = r2     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x00d0
            if (r5 == 0) goto L_0x00d0
            java.lang.String r5 = z0()     // Catch:{ all -> 0x0049 }
            r2 = 0
            V0(r1, r5, r2)     // Catch:{ all -> 0x0049 }
        L_0x00d0:
            monitor-exit(r0)
            return
        L_0x00d2:
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.o3.K0(android.content.Context):void");
    }

    private static boolean K1(Activity activity, JSONArray jSONArray) {
        if (f10903n) {
            return false;
        }
        try {
            return new l2(activity, jSONArray.getJSONObject(0)).a();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return true;
        }
    }

    static void L(JSONObject jSONObject) {
    }

    public static void L0(Context context) {
        boolean z10;
        if (context == null) {
            f10908s.c("initWithContext called with null context, ignoring!");
            return;
        }
        if (context instanceof Activity) {
            f10884c = new WeakReference((Activity) context);
        }
        if (f10882b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        f10882b = context.getApplicationContext();
        H1(z10);
        I1(f10882b);
        if (f10886d == null) {
            String o02 = o0();
            if (o02 == null) {
                f10908s.c("appContext set, but please call setAppId(appId) with a valid appId to complete OneSignal init!");
                return;
            }
            c2 c2Var = f10908s;
            c2Var.e("appContext set and cached app id found, calling setAppId with: " + o02);
            D1(o02);
            return;
        }
        c2 c2Var2 = f10908s;
        c2Var2.e("initWithContext called with: " + context);
        K0(context);
    }

    static boolean L1(String str) {
        if (!r1()) {
            return false;
        }
        if (str == null) {
            return true;
        }
        v vVar = v.WARN;
        a(vVar, "Method " + str + " was called before the user provided privacy consent. Your application is set to require the user's privacy consent before the OneSignal SDK can be initialized. Please ensure the user has provided consent before calling this method. You can check the latest OneSignal consent status by calling OneSignal.userProvidedPrivacyConsent()");
        return true;
    }

    private static m2 M(JSONArray jSONArray) {
        e2.a aVar;
        int length = jSONArray.length();
        int optInt = jSONArray.optJSONObject(0).optInt("androidNotificationId");
        ArrayList arrayList = new ArrayList();
        boolean z10 = true;
        String str = null;
        JSONObject jSONObject = null;
        for (int i10 = 0; i10 < length; i10++) {
            try {
                jSONObject = jSONArray.getJSONObject(i10);
                if (str == null && jSONObject.has("actionId")) {
                    str = jSONObject.optString("actionId", (String) null);
                }
                if (z10) {
                    z10 = false;
                } else {
                    arrayList.add(new d2(jSONObject));
                }
            } catch (Throwable th) {
                b(v.ERROR, "Error parsing JSON item " + i10 + DomExceptionUtils.SEPARATOR + length + " for callback.", th);
            }
        }
        if (str != null) {
            aVar = e2.a.ActionTaken;
        } else {
            aVar = e2.a.Opened;
        }
        return new m2(new d2(arrayList, jSONObject, optInt), new e2(aVar, str));
    }

    private static void M0() {
        ArrayList arrayList = T;
        synchronized (arrayList) {
            try {
                if (arrayList.size() != 0) {
                    new Thread(new g(), "OS_GETTAGS_CALLBACK").start();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private static boolean M1() {
        if (O0() && R0()) {
            return true;
        }
        return false;
    }

    static r N() {
        return f10904o;
    }

    static boolean N0() {
        if (!f10902m || !O0()) {
            return false;
        }
        return true;
    }

    static void N1(boolean z10) {
        c2 c2Var = f10908s;
        c2Var.b("OneSignal startLocationShared: " + z10);
        k0().n(z10);
        if (!z10) {
            f10908s.b("OneSignal is shareLocation set false, clearing last location!");
            e4.a();
        }
    }

    private static Integer O() {
        y a10 = f4.f10638a.a(f10882b, f10882b.getPackageName(), 0);
        if (!a10.b() || a10.a() == null) {
            return null;
        }
        return Integer.valueOf(a10.a().versionCode);
    }

    static boolean O0() {
        return f10903n;
    }

    private static void O1() {
        h0.g(f10882b, false, false, new m());
    }

    static boolean P() {
        return f10913x.b();
    }

    static boolean P0() {
        return f10902m;
    }

    private static void P1() {
        if (!O) {
            O = true;
            if (f10903n && e4.g()) {
                M = false;
            }
            O1();
            L = false;
            if (l0() != null) {
                m1();
            } else {
                V0(f10886d, z0(), true);
            }
        }
    }

    static Activity Q() {
        a b10 = b.b();
        if (b10 != null) {
            return b10.e();
        }
        return null;
    }

    public static boolean Q0() {
        return f10913x.h();
    }

    static void Q1(String str) {
        v1(str);
        R(f10882b).d(str);
        try {
            e4.x(new JSONObject().put("parent_player_id", str));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    private static h1 R(Context context) {
        if (context == null) {
            return null;
        }
        if (f10883b0 == null) {
            h1 h1Var = new h1(false);
            f10883b0 = h1Var;
            h1Var.a().b(new OSEmailSubscriptionChangedInternalObserver());
        }
        return f10883b0;
    }

    private static boolean R0() {
        long b10 = w0().b();
        long d02 = d0();
        long j10 = b10 - d02;
        c2 c2Var = f10908s;
        c2Var.b("isPastOnSessionTime currentTimeMillis: " + b10 + " lastSessionTime: " + d02 + " difference: " + j10);
        if (j10 >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            return true;
        }
        return false;
    }

    static void R1(String str) {
        w1(str);
        T(f10882b).d(str);
    }

    private static r2 S(Context context) {
        if (context == null) {
            return null;
        }
        if (V == null) {
            r2 r2Var = new r2(false);
            V = r2Var;
            r2Var.b().b(new OSPermissionChangedInternalObserver());
        }
        return V;
    }

    private static boolean S0() {
        if (f10900k == -999) {
            return true;
        }
        return false;
    }

    static void S1(String str) {
        x1(str);
        M0();
        U(f10882b).g(str);
        u uVar = f10895h0;
        if (uVar != null) {
            A1(uVar.f10933a, uVar.f10934b, uVar.f10935c);
            f10895h0 = null;
        }
        e4.n();
    }

    private static v2 T(Context context) {
        if (context == null) {
            return null;
        }
        if (f10889e0 == null) {
            v2 v2Var = new v2(false);
            f10889e0 = v2Var;
            v2Var.a().b(new OSSMSSubscriptionChangedInternalObserver());
        }
        return f10889e0;
    }

    static boolean T0() {
        return f10913x.i();
    }

    public static boolean T1() {
        return f10913x.e();
    }

    /* access modifiers changed from: private */
    public static OSSubscriptionState U(Context context) {
        if (context == null) {
            return null;
        }
        if (Y == null) {
            Y = new OSSubscriptionState(false, S(context).a());
            S(context).b().a(Y);
            Y.a().b(new OSSubscriptionChangedInternalObserver());
        }
        return Y;
    }

    static void U0(String str, int i10, Throwable th, String str2) {
        String str3;
        if (str2 == null || !B(v.INFO)) {
            str3 = "";
        } else {
            str3 = "\n" + str2 + "\n";
        }
        b(v.WARN, "HTTP code: " + i10 + " " + str + str3, th);
    }

    static v3 V() {
        return v3.n(f10882b);
    }

    private static void V0(String str, String str2, boolean z10) {
        if (l0() == null && !P) {
            P = true;
            a4.e(str, str2, new o(z10));
        }
    }

    static v3 W(Context context) {
        return v3.n(context);
    }

    static void W0(Context context, JSONObject jSONObject, g2.d dVar) {
        if (G == null) {
            G = new g2(W(context), f10908s);
        }
        G.j(jSONObject, dVar);
    }

    static boolean X() {
        return f10913x.g();
    }

    private static void X0(Context context, JSONArray jSONArray) {
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                String optString = new JSONObject(jSONArray.getJSONObject(i10).optString("custom", (String) null)).optString("i", (String) null);
                if (!S.contains(optString)) {
                    S.add(optString);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(Constant.PARAM_APP_ID, p0(context));
                    jSONObject.put("player_id", q0(context));
                    jSONObject.put("opened", true);
                    jSONObject.put("device_type", K.e());
                    b4.l("notifications/" + optString, jSONObject, new h());
                }
            } catch (Throwable th) {
                b(v.ERROR, "Failed to generate JSON to send notification opened.", th);
            }
        }
    }

    static String Y() {
        if (f10896i == null && f10882b != null) {
            f10896i = z3.f(z3.f11153a, "OS_EMAIL_ID", (String) null);
        }
        if (TextUtils.isEmpty(f10896i)) {
            return null;
        }
        return f10896i;
    }

    static void Y0() {
        v vVar = v.DEBUG;
        a(vVar, "Application on focus");
        E1(true);
        r rVar = f10904o;
        r rVar2 = r.NOTIFICATION_CLICK;
        if (!rVar.equals(rVar2)) {
            D(f10904o);
            if (!f10904o.equals(rVar2)) {
                f10904o = r.APP_OPEN;
            }
        }
        h0.l();
        b1.f10386a.h();
        if (!OSUtils.T(f10886d)) {
            if (!f10913x.k()) {
                a(vVar, "Delay onAppFocus logic due to missing remote params");
                V0(f10886d, z0(), false);
                return;
            }
            Z0();
        }
    }

    static o2 Z() {
        if (f10887d0 == null) {
            f10887d0 = new o2("onOSEmailSubscriptionChanged", true);
        }
        return f10887d0;
    }

    private static void Z0() {
        if (!L1("onAppFocus")) {
            b0().b();
            G();
            s4 s4Var = f10905p;
            if (s4Var != null) {
                s4Var.u();
            }
            OSNotificationRestoreWorkManager.c(f10882b, false);
            l1();
            if (f10907r != null && a0()) {
                f10907r.f();
            }
            b3.q().p(f10882b);
        }
    }

    static void a(v vVar, String str) {
        b(vVar, str, (Throwable) null);
    }

    static boolean a0() {
        return f10913x.c();
    }

    static void a1() {
        v vVar = v.DEBUG;
        a(vVar, "Application lost focus initDone: " + f10902m);
        E1(false);
        f10904o = r.APP_CLOSE;
        F1(w0().b());
        h0.l();
        if (f10902m) {
            C();
        } else if (f10915z.g("onAppLostFocus()")) {
            f10908s.d("Waiting for remote params. Moving onAppLostFocus() operation to a pending task queue.");
            f10915z.c(new q());
        }
    }

    static void b(v vVar, String str, Throwable th) {
        if (vVar.compareTo(f10892g) < 1) {
            if (vVar == v.VERBOSE) {
                Log.v("OneSignal", str, th);
            } else if (vVar == v.DEBUG) {
                Log.d("OneSignal", str, th);
            } else if (vVar == v.INFO) {
                Log.i("OneSignal", str, th);
            } else if (vVar == v.WARN) {
                Log.w("OneSignal", str, th);
            } else if (vVar == v.ERROR || vVar == v.FATAL) {
                Log.e("OneSignal", str, th);
            }
        }
        if (vVar.compareTo(f10890f) < 1 && Q() != null) {
            try {
                String str2 = str + "\n";
                if (th != null) {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    str2 = (str2 + th.getMessage()) + stringWriter.toString();
                }
                OSUtils.S(new p(vVar, str2));
            } catch (Throwable th2) {
                Log.e("OneSignal", "Error showing logging message.", th2);
            }
        }
        E(vVar, str, th);
    }

    static s b0() {
        if (f10909t == null) {
            f10909t = new s(new k1(), f10908s);
        }
        return f10909t;
    }

    static void b1() {
        l1();
    }

    static o1 c0() {
        return f10911v.a(V(), f10914y, e0(), t0(), f10901l);
    }

    static void c1() {
        if (!k1() && f10903n) {
            Z0();
        }
    }

    private static long d0() {
        return z3.d(z3.f11153a, "OS_LAST_SESSION_TIME", -31000);
    }

    public static void d1(v vVar, String str) {
        a(vVar, str);
    }

    static c2 e0() {
        return f10908s;
    }

    static void e1(Activity activity, JSONArray jSONArray) {
        try {
            Intent b10 = x.f11099a.a(activity, jSONArray.getJSONObject(0)).b();
            if (b10 != null) {
                c2 c2Var = f10908s;
                c2Var.f("SDK running startActivity with Intent: " + b10);
                activity.startActivity(b10);
                return;
            }
            f10908s.f("SDK not showing an Activity automatically due to it's settings.");
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    static String f0(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("custom"));
            if (jSONObject2.has("i")) {
                return jSONObject2.optString("i", (String) null);
            }
            f10908s.b("Not a OneSignal formatted FCM message. No 'i' field in custom.");
            return null;
        } catch (JSONException unused) {
            f10908s.b("Not a OneSignal formatted FCM message. No 'custom' field in the JSONObject.");
        }
    }

    public static void f1() {
        g1(false);
    }

    static q2 g0() {
        if (E == null) {
            synchronized (H) {
                try {
                    if (E == null) {
                        if (F == null) {
                            F = new pa.c(f10908s, A, V(), B);
                        }
                        E = new q2(D, F);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return E;
    }

    public static void g1(boolean z10) {
        h1(z10, (a0) null);
    }

    static o2 h0() {
        if (X == null) {
            X = new o2("onOSPermissionChanged", true);
        }
        return X;
    }

    public static void h1(boolean z10, a0 a0Var) {
        b1.f10386a.i(z10, a0Var);
    }

    private static g4 i0() {
        g4 g4Var = f10897i0;
        if (g4Var != null) {
            return g4Var;
        }
        if (OSUtils.C()) {
            f10897i0 = new h4();
        } else if (!OSUtils.B()) {
            f10897i0 = new k4();
        } else if (OSUtils.r()) {
            f10897i0 = j0();
        }
        return f10897i0;
    }

    static void i1(x xVar, boolean z10) {
        if (f10915z.g("promptLocation()")) {
            f10908s.d("Waiting for remote params. Moving promptLocation() operation to a pending queue.");
            f10915z.c(new i(xVar, z10));
        } else if (!L1("promptLocation()")) {
            h0.g(f10882b, true, z10, new k(xVar));
        }
    }

    private static j4 j0() {
        j4.a aVar;
        a4.d dVar = f10913x.d().f10379o;
        if (dVar != null) {
            aVar = new j4.a(dVar.f10354a, dVar.f10355b, dVar.f10356c);
        } else {
            aVar = null;
        }
        return new j4(f10882b, aVar);
    }

    /* access modifiers changed from: private */
    public static boolean j1(int i10) {
        return i10 < -6;
    }

    static u2 k0() {
        return f10913x;
    }

    private static boolean k1() {
        Context context;
        String str;
        if (f10902m) {
            return false;
        }
        r rVar = U;
        if (rVar == null) {
            str = o0();
            context = f10882b;
            f10908s.d("Trying to continue OneSignal with null delayed params");
        } else {
            str = rVar.a();
            context = U.b();
        }
        c2 c2Var = f10908s;
        c2Var.b("reassignDelayedInitParams with appContext: " + f10882b);
        U = null;
        D1(str);
        if (f10902m) {
            return true;
        }
        if (context == null) {
            f10908s.d("Trying to continue OneSignal with null delayed params context");
            return false;
        }
        L0(context);
        return true;
    }

    static a4.f l0() {
        return f10913x.d();
    }

    static void l1() {
        S(f10882b).d();
    }

    static String m0() {
        if (f10898j == null && f10882b != null) {
            f10898j = z3.f(z3.f11153a, "PREFS_OS_SMS_ID", (String) null);
        }
        if (TextUtils.isEmpty(f10898j)) {
            return null;
        }
        return f10898j;
    }

    /* access modifiers changed from: private */
    public static void m1() {
        i0().a(f10882b, f10888e, new n());
    }

    static o2 n0() {
        if (f10893g0 == null) {
            f10893g0 = new o2("onSMSSubscriptionChanged", true);
        }
        return f10893g0;
    }

    /* access modifiers changed from: private */
    public static void n1() {
        c2 c2Var = f10908s;
        c2Var.b("registerUser:registerForPushFired:" + L + ", locationFired: " + M + ", remoteParams: " + l0() + ", appId: " + f10886d);
        if (!L || !M || l0() == null || f10886d == null) {
            f10908s.b("registerUser not possible");
        } else {
            OSUtils.W(new Thread(new a(), "OS_REG_USER"));
        }
    }

    static String o0() {
        return p0(f10882b);
    }

    /* access modifiers changed from: private */
    public static void o1() {
        h0.d dVar;
        String packageName = f10882b.getPackageName();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constant.PARAM_APP_ID, o0());
        jSONObject.put("device_os", Build.VERSION.RELEASE);
        jSONObject.put("timezone", y0());
        jSONObject.put("timezone_id", x0());
        jSONObject.put("language", f10901l.b());
        jSONObject.put("sdk", "040812");
        jSONObject.put("sdk_type", I);
        jSONObject.put("android_package", packageName);
        jSONObject.put("device_model", Build.MODEL);
        Integer O2 = O();
        if (O2 != null) {
            jSONObject.put("game_version", O2);
        }
        jSONObject.put("net_type", K.i());
        jSONObject.put("carrier", K.d());
        jSONObject.put("rooted", p4.a());
        e4.v(jSONObject, (e4.a) null);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("identifier", J);
        jSONObject2.put("subscribableStatus", f10900k);
        jSONObject2.put("androidPermission", A());
        jSONObject2.put("device_type", K.e());
        e4.x(jSONObject2);
        if (Q0() && (dVar = Q) != null) {
            e4.w(dVar);
        }
        f10908s.b("registerUserTask calling readyToUpdate");
        e4.m(true);
        O = false;
    }

    private static String p0(Context context) {
        if (context == null) {
            return null;
        }
        return z3.f(z3.f11153a, "GT_APP_ID", (String) null);
    }

    static void p1(t tVar) {
        f10880a.remove(tVar);
    }

    private static String q0(Context context) {
        if (context == null) {
            return null;
        }
        return z3.f(z3.f11153a, "GT_PLAYER_ID", (String) null);
    }

    public static void q1(int i10) {
        if (f10915z.g("removeNotification()") || G == null) {
            f10908s.d("Waiting for remote params. Moving removeNotification() operation to a pending queue.");
            f10915z.c(new l(i10));
        } else if (!L1("removeNotification()")) {
            G.k(i10, new WeakReference(f10882b));
        }
    }

    public static String r0() {
        return "040812";
    }

    public static boolean r1() {
        if (f10882b == null || (T0() && !T1())) {
            return true;
        }
        return false;
    }

    static x2 s0() {
        return D;
    }

    /* access modifiers changed from: private */
    public static void s1() {
        if (z0() == null) {
            f10908s.c("getTags called under a null user!");
        } else {
            M0();
        }
    }

    static y2 t0() {
        return B;
    }

    private static void t1(JSONArray jSONArray) {
        R.add(jSONArray);
    }

    static o2 u0() {
        if (f10881a0 == null) {
            f10881a0 = new o2("onOSSubscriptionChanged", true);
        }
        return f10881a0;
    }

    private static void u1(String str) {
        if (f10882b != null) {
            z3.m(z3.f11153a, "GT_APP_ID", str);
        }
    }

    public static void v0(w wVar) {
        if (f10915z.g("getTags()")) {
            f10908s.d("Waiting for remote params. Moving getTags() operation to a pending queue.");
            f10915z.c(new e(wVar));
        } else if (!L1("getTags()")) {
            if (wVar == null) {
                f10908s.d("getTags called with null GetTagsHandler!");
            } else {
                new Thread(new f(wVar), "OS_GETTAGS").start();
            }
        }
    }

    static void v1(String str) {
        String str2;
        f10896i = str;
        if (f10882b != null) {
            String str3 = z3.f11153a;
            if ("".equals(f10896i)) {
                str2 = null;
            } else {
                str2 = f10896i;
            }
            z3.m(str3, "OS_EMAIL_ID", str2);
        }
    }

    static g3 w0() {
        return f10912w;
    }

    static void w1(String str) {
        String str2;
        f10898j = str;
        if (f10882b != null) {
            String str3 = z3.f11153a;
            if ("".equals(f10898j)) {
                str2 = null;
            } else {
                str2 = f10898j;
            }
            z3.m(str3, "PREFS_OS_SMS_ID", str2);
        }
    }

    static void x(JSONObject jSONObject) {
        try {
            jSONObject.put("net_type", K.i());
        } catch (Throwable unused) {
        }
    }

    private static String x0() {
        if (Build.VERSION.SDK_INT >= 26) {
            return ZoneId.systemDefault().getId();
        }
        return TimeZone.getDefault().getID();
    }

    static void x1(String str) {
        f10894h = str;
        if (f10882b != null) {
            z3.m(z3.f11153a, "GT_PLAYER_ID", f10894h);
        }
    }

    public static void y(String str, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, obj);
        c0().C(hashMap);
    }

    private static int y0() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        if (timeZone.inDaylightTime(new Date())) {
            rawOffset += timeZone.getDSTSavings();
        }
        return rawOffset / 1000;
    }

    private static boolean y1() {
        boolean l10 = e4.l();
        c2 c2Var = f10908s;
        c2Var.b("OneSignal scheduleSyncService unsyncedChanges: " + l10);
        if (l10) {
            b3.q().s(f10882b);
        }
        boolean m10 = h0.m(f10882b);
        c2 c2Var2 = f10908s;
        c2Var2.b("OneSignal scheduleSyncService locationScheduled: " + m10);
        if (m10 || l10) {
            return true;
        }
        return false;
    }

    static void z(String str) {
        r rVar = r.NOTIFICATION_CLICK;
        f10904o = rVar;
        D.j(rVar, str);
    }

    static String z0() {
        Context context;
        if (f10894h == null && (context = f10882b) != null) {
            f10894h = q0(context);
        }
        return f10894h;
    }

    static void z1(List list) {
        q2 q2Var = E;
        if (q2Var == null || f10886d == null) {
            a(v.ERROR, "Make sure OneSignal.init is called first");
        } else {
            q2Var.m(list);
        }
    }
}
