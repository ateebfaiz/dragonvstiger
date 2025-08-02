package v;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.work.PeriodicWorkRequest;
import com.mah.ndk.MahxServer;
import com.mah.sdk.MahProxyAddress;
import com.mah.sdk.OooO00o;
import com.zing.zalo.zalosdk.common.Constant;
import d.k;
import h.g;
import h.j;
import i.p;
import i.v;
import i.w;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s.e;
import v.a;

public class b {

    /* renamed from: i  reason: collision with root package name */
    public static final String f24361i = w.d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final String f24362a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24363b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24364c;

    /* renamed from: d  reason: collision with root package name */
    public final k f24365d;

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray f24366e;

    /* renamed from: f  reason: collision with root package name */
    public j.b f24367f;

    /* renamed from: g  reason: collision with root package name */
    public final d.c f24368g;

    /* renamed from: h  reason: collision with root package name */
    public final Set f24369h = new HashSet();

    /* renamed from: v.b$b  reason: collision with other inner class name */
    public static class C0346b {

        /* renamed from: a  reason: collision with root package name */
        public final String f24370a;

        /* renamed from: b  reason: collision with root package name */
        public final String f24371b;

        /* renamed from: c  reason: collision with root package name */
        public final int f24372c;

        public C0346b(String str, String str2, int i10) {
            this.f24370a = str;
            this.f24371b = str2;
            this.f24372c = i10;
        }

        public boolean a() {
            if (this.f24372c != -1) {
                return true;
            }
            return false;
        }
    }

    public class c extends j.c {

        /* renamed from: a  reason: collision with root package name */
        public final long f24373a;

        public c(long j10, a aVar) {
            this.f24373a = j10;
        }

        public long a() {
            return this.f24373a;
        }

        public long b() {
            return this.f24373a;
        }

        public void c() {
            if (b.this.p(1)) {
                b.this.f24365d.u();
            } else {
                String str = b.f24361i;
            }
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f24375a;

        /* renamed from: b  reason: collision with root package name */
        public final JSONArray f24376b;

        public d(int i10, JSONArray jSONArray) {
            this.f24375a = i10;
            this.f24376b = jSONArray;
        }
    }

    public b(k kVar, d.c cVar) {
        this.f24365d = kVar;
        this.f24368g = cVar;
        this.f24366e = new SparseArray();
        this.f24362a = cVar.j().h();
        this.f24363b = w.f(OooO00o.OooO0Oo(kVar.OooO00o()), OooO00o.OooO0OO());
        this.f24364c = OooO00o.OooO0Oo();
        A();
    }

    public static String d(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException unused) {
            return str;
        }
    }

    public static d n(String str) {
        if (TextUtils.isEmpty(str)) {
            return new d(-1, (JSONArray) null);
        }
        JSONObject jSONObject = new JSONObject(str);
        int optInt = jSONObject.optInt(Constant.PARAM_OAUTH_CODE);
        if (optInt == 0) {
            return new d(optInt, jSONObject.optJSONArray("configuration"));
        }
        jSONObject.optString("errorMsg", "");
        return new d(optInt, (JSONArray) null);
    }

    public static boolean w(String str) {
        if (TextUtils.isEmpty(str) || !v.k(str)) {
            return false;
        }
        return true;
    }

    public final void A() {
        String b10 = this.f24365d.r().b();
        if (!TextUtils.isEmpty(b10)) {
            this.f24369h.addAll(Arrays.asList(b10.split(";")));
        }
    }

    public final void B() {
        if (this.f24367f == null) {
            this.f24367f = j.a.a().b(new c(PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS, (a) null));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public v.b.C0346b a(java.lang.String r8) {
        /*
            r7 = this;
            v.b$b r0 = r7.s(r8)
            if (r0 == 0) goto L_0x0007
            return r0
        L_0x0007:
            d.k r1 = r7.f24365d
            s.e r1 = r1.f()
            java.lang.String r2 = r7.u()
            android.net.Uri r2 = android.net.Uri.parse(r2)
            java.lang.String r2 = r2.getHost()
            boolean r2 = r8.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0028
            int r0 = r1.f()
            v.b$b r8 = r7.i(r8, r0)
            return r8
        L_0x0028:
            v.a r1 = r7.h(r8, r1)
            r2 = 1
            java.lang.String r3 = r7.f(r1, r2)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto L_0x003d
            boolean r3 = r7.l(r3, r1)     // Catch:{ JSONException -> 0x003d }
            goto L_0x003f
        L_0x003d:
            r2 = r5
            r3 = r2
        L_0x003f:
            if (r3 == 0) goto L_0x0060
            java.util.Map r3 = r1.f24352c
            java.lang.Object r3 = r3.get(r8)
            v.a$a r3 = (v.a.C0344a) r3
            if (r3 == 0) goto L_0x005d
            java.lang.String r4 = r3.d()
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x005d
            r7.k(r3, r1)
            v.b$b r0 = new v.b$b
            r0.<init>(r8, r4, r5)
        L_0x005d:
            r7.B()
        L_0x0060:
            if (r0 == 0) goto L_0x0063
            return r0
        L_0x0063:
            if (r2 == 0) goto L_0x006e
            v.b$b r0 = new v.b$b
            java.lang.String r1 = ""
            r2 = 3
            r0.<init>(r8, r1, r2)
            return r0
        L_0x006e:
            v.b$b r8 = r7.z(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: v.b.a(java.lang.String):v.b$b");
    }

    public final void b() {
        this.f24365d.r().g(TextUtils.join(";", this.f24369h));
    }

    public final String c(int i10, String str) {
        String str2 = "";
        synchronized (this.f24366e) {
            try {
                a aVar = (a) this.f24366e.get(i10);
                if (aVar != null) {
                    str2 = aVar.a(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    public String e(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String c10 = p.c(valueOf, this.f24362a);
            jSONObject.put("sdkType", 3);
            jSONObject.put("packageName", this.f24362a);
            jSONObject.put("timestamp", valueOf);
            jSONObject.put("imsi", this.f24363b);
            jSONObject.put("networkType", aVar.f24351b);
            jSONObject.put("authKey", c10);
            jSONObject.put("platform", this.f24364c);
            jSONObject.put("sessionId", this.f24368g.f().b());
            JSONObject jSONObject2 = new JSONObject();
            r.a.b(jSONObject2, this.f24368g.j());
            jSONObject.put("extension", jSONObject2);
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry entry : aVar.f24352c.entrySet()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("name", entry.getKey());
                jSONObject3.put("md5", ((a.C0344a) entry.getValue()).f24355c);
                jSONArray.put(jSONObject3);
            }
            jSONObject.put("serverHost", jSONArray);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public String f(a aVar, boolean z10) {
        boolean z11;
        String e10 = e(aVar);
        if (TextUtils.isEmpty(e10)) {
            return null;
        }
        int i10 = 0;
        s.d dVar = null;
        while (true) {
            try {
                MahProxyAddress h10 = this.f24365d.h(d.b.ADDRESS_TYPE_PROXY_HANDSHAKE);
                if (OooO00o.OooO0O0(h10)) {
                    dVar = OooO00o.OooO00o(u(), h10);
                    dVar.w(5000);
                    dVar.D(OooO00o.OooO0O0(30000));
                    j(dVar, false);
                    dVar.o(e10.getBytes());
                    if (dVar.K() != 200) {
                        dVar.O();
                        z11 = true;
                        if (!z11 || i10 >= 1) {
                            break;
                        }
                        i10++;
                    } else {
                        String a10 = w.a(dVar.d(), OooO00o.OooO0OO());
                        if (!TextUtils.isEmpty(a10)) {
                            String OooO0OO = OooO00o.OooO0OO(dVar);
                            if (!TextUtils.isEmpty(OooO0OO)) {
                                this.f24365d.r().k(OooO0OO);
                            }
                        }
                        dVar.O();
                        return a10;
                    }
                } else if (dVar != null) {
                    dVar.O();
                }
            } catch (Throwable th) {
                if (dVar != null) {
                    dVar.O();
                }
                throw th;
            }
        }
        return null;
    }

    public a g(int i10) {
        synchronized (this.f24366e) {
            try {
                a aVar = (a) this.f24366e.get(i10);
                if (aVar == null) {
                    return null;
                }
                a d10 = aVar.d();
                return d10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final a h(String str, e eVar) {
        int f10 = eVar.f();
        String a10 = eVar.a();
        HashMap hashMap = new HashMap(1);
        hashMap.put(str, a.C0344a.b(true, str));
        return new a(f10, a10, hashMap);
    }

    public final C0346b i(String str, int i10) {
        C0346b bVar;
        synchronized (this.f24366e) {
            try {
                a aVar = (a) this.f24366e.get(i10);
                String str2 = "";
                if (aVar != null) {
                    str2 = aVar.e(this.f24365d.o().b(i10).f21740b);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = MahxServer.OooO0OO();
                }
                bVar = new C0346b(str, str2, 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public final void j(s.d dVar, boolean z10) {
        dVar.z("Content-Type", "text/plain; charset=UTF-8");
        dVar.z("Connection", "close");
        dVar.z("X-Mah-Sdk-Req", "true");
        if (z10) {
            dVar.z("X-Mah-Req-Type", "1008");
        }
    }

    public final void k(a.C0344a aVar, a aVar2) {
        v(aVar.f24353a);
        synchronized (this.f24366e) {
            try {
                int i10 = aVar2.f24350a;
                a aVar3 = (a) this.f24366e.get(i10);
                if (aVar3 != null) {
                    aVar3.f24352c.put(aVar.f24353a, aVar);
                } else {
                    this.f24366e.put(i10, aVar2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean l(String str, a aVar) {
        JSONArray jSONArray = n(str).f24376b;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return false;
        }
        return m(jSONArray, aVar);
    }

    public final boolean m(JSONArray jSONArray, a aVar) {
        boolean z10 = false;
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("hostName");
                JSONArray optJSONArray = optJSONObject.optJSONArray("mesIps");
                String optString2 = optJSONObject.optString("md5");
                if (!TextUtils.isEmpty(optString) && optJSONArray != null && optJSONArray.length() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i11 = 0;
                    while (true) {
                        if (i11 < optJSONArray.length()) {
                            String optString3 = optJSONArray.optString(i11);
                            if (!w(optString3)) {
                                break;
                            }
                            arrayList.add(d(optString3));
                            i11++;
                        } else {
                            a.C0344a aVar2 = (a.C0344a) aVar.f24352c.get(optString);
                            if (aVar2 != null) {
                                aVar.f24352c.put(optString, aVar2.e().c(optString2).a(arrayList).b());
                                z10 = true;
                            }
                        }
                    }
                }
            }
        }
        return z10;
    }

    public void o() {
        j.b bVar = this.f24367f;
        if (bVar != null) {
            bVar.a();
            this.f24367f = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0038, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean p(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            v.a r0 = r3.y()     // Catch:{ all -> 0x0017 }
            r1 = 2
            if (r4 != r1) goto L_0x0019
            android.util.SparseArray r4 = r3.f24366e     // Catch:{ all -> 0x0017 }
            monitor-enter(r4)     // Catch:{ all -> 0x0017 }
            android.util.SparseArray r1 = r3.f24366e     // Catch:{ all -> 0x0014 }
            int r2 = r0.f24350a     // Catch:{ all -> 0x0014 }
            r1.remove(r2)     // Catch:{ all -> 0x0014 }
            monitor-exit(r4)     // Catch:{ all -> 0x0014 }
            goto L_0x0019
        L_0x0014:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0014 }
            throw r0     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r4 = move-exception
            goto L_0x0039
        L_0x0019:
            java.util.Map r4 = r0.f24352c     // Catch:{ all -> 0x0017 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0017 }
            r1 = 0
            if (r4 == 0) goto L_0x0024
            monitor-exit(r3)
            return r1
        L_0x0024:
            java.lang.String r4 = r3.f(r0, r1)     // Catch:{ all -> 0x0017 }
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0017 }
            if (r2 != 0) goto L_0x0032
            boolean r1 = r3.q(r4, r0)     // Catch:{ JSONException -> 0x0032 }
        L_0x0032:
            if (r1 == 0) goto L_0x0037
            r3.t(r0)     // Catch:{ all -> 0x0017 }
        L_0x0037:
            monitor-exit(r3)
            return r1
        L_0x0039:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: v.b.p(int):boolean");
    }

    public final boolean q(String str, a aVar) {
        d n10 = n(str);
        JSONArray jSONArray = n10.f24376b;
        if (jSONArray != null && jSONArray.length() > 0) {
            boolean m10 = m(jSONArray, aVar);
            boolean r10 = r(aVar);
            B();
            if (m10 || r10) {
                return true;
            }
            return false;
        } else if (n10.f24375a == 2) {
            return r(aVar);
        } else {
            return false;
        }
    }

    public final boolean r(a aVar) {
        synchronized (this.f24369h) {
            try {
                ArrayList arrayList = new ArrayList(this.f24369h.size());
                for (String str : this.f24369h) {
                    if (TextUtils.isEmpty(aVar.e(str))) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.isEmpty()) {
                    return false;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f24369h.remove((String) it.next());
                }
                b();
                return true;
            } finally {
            }
        }
    }

    public final C0346b s(String str) {
        int f10 = this.f24365d.f().f();
        synchronized (this.f24366e) {
            try {
                a aVar = (a) this.f24366e.get(f10);
                if (aVar == null) {
                    return null;
                }
                String e10 = aVar.e(str);
                if (TextUtils.isEmpty(e10)) {
                    return null;
                }
                C0346b bVar = new C0346b(str, e10, 1);
                return bVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t(a aVar) {
        synchronized (this.f24366e) {
            try {
                int i10 = aVar.f24350a;
                a aVar2 = (a) this.f24366e.get(i10);
                if (aVar2 != null) {
                    Map map = aVar.f24352c;
                    for (Map.Entry entry : aVar2.f24352c.entrySet()) {
                        String str = (String) entry.getKey();
                        if (!map.containsKey(str)) {
                            a.C0344a aVar3 = (a.C0344a) entry.getValue();
                            if (!TextUtils.isEmpty(a.c(aVar3))) {
                                map.put(str, aVar3);
                            }
                        }
                    }
                }
                this.f24366e.put(i10, aVar);
            } finally {
            }
        }
    }

    public final String u() {
        String str = this.f24365d.o().T;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return "https://au.relauservice.com/frontoffice/ipDispatch";
    }

    public final void v(String str) {
        synchronized (this.f24369h) {
            this.f24369h.add(str);
            b();
        }
    }

    public final String x(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (InetAddress hostAddress : InetAddress.getAllByName(str)) {
            sb2.append(hostAddress.getHostAddress());
            sb2.append(";");
        }
        return sb2.toString();
    }

    public final a y() {
        e f10 = this.f24365d.f();
        int f11 = f10.f();
        String a10 = f10.a();
        HashMap hashMap = new HashMap(8);
        g o10 = this.f24365d.o();
        String str = o10.b(f11).f21740b;
        if (!TextUtils.isEmpty(str) && !v.k(str)) {
            hashMap.put(str, a.C0344a.c(false, str, c(f11, str)));
        }
        List<j> list = o10.K;
        if (list != null) {
            for (j jVar : list) {
                String str2 = jVar.f21832a;
                if (!TextUtils.isEmpty(str2) && !v.k(str2)) {
                    hashMap.put(str2, a.C0344a.c(false, str2, c(f11, str2)));
                }
            }
        }
        for (String str3 : this.f24369h) {
            hashMap.put(str3, a.C0344a.c(true, str3, c(f11, str3)));
        }
        return new a(f11, a10, hashMap);
    }

    public C0346b z(String str) {
        try {
            return new C0346b(str, x(str), 2);
        } catch (UnknownHostException unused) {
            return new C0346b(str, "", -1);
        }
    }
}
