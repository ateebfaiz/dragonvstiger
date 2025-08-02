package e;

import android.content.Context;
import android.text.TextUtils;
import com.mah.sdk.MahProxy;
import com.mah.sdk.OooO00o;
import d.c;
import d.g;
import d.k;
import e.i;
import e.k;
import i.e;
import i.p;
import i.v;
import i.w;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import r.a;
import w.d;

public class o extends k {
    public static final String P0 = d.f("");
    public static String Q0 = null;
    public final String N0;
    public final c O0;
    public final String Z;

    public o(i.a aVar, String str, String str2, k kVar, m mVar, c cVar) {
        super(aVar, kVar, mVar);
        this.Z = str;
        this.N0 = str2;
        this.O0 = cVar;
    }

    public static String n(Context context, String str) {
        if (Q0 == null) {
            if (TextUtils.isEmpty(str)) {
                Q0 = v.x(context);
            } else {
                Q0 = str;
            }
        }
        return Q0;
    }

    public static void o(s.d dVar) {
        if (d.j()) {
            dVar.U().toString();
            for (Map.Entry next : dVar.Q().getRequestProperties().entrySet()) {
                next.getKey();
                ((List) next.getValue()).get(0);
            }
        }
    }

    public static JSONArray r(String str) {
        String[] h10;
        if (TextUtils.isEmpty(str) || (h10 = v.h(str, ",")) == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str2 : h10) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    jSONArray.put(Long.parseLong(str2));
                } catch (Exception unused) {
                }
            }
        }
        return jSONArray;
    }

    public static boolean u(String str) {
        try {
            InetAddress.getByName(str);
            return false;
        } catch (UnknownHostException unused) {
            return true;
        }
    }

    public k.a b(String str, boolean z10) {
        if (!m()) {
            return q(str, z10);
        }
        f(1, c("Network not connected!", new Object[0]));
        return new k.a("", k.b.FINISH, "");
    }

    public long j() {
        return 1;
    }

    public final boolean m() {
        if (!this.f21094b.f().h() && u("www.baidu.com") && u("www.qq.com")) {
            return true;
        }
        return false;
    }

    public final void p(s.d dVar, boolean z10) {
        dVar.z("Content-Type", "text/plain; charset=UTF-8");
        dVar.z("Connection", "close");
        dVar.z("X-Mah-Sdk-Req", "true");
        if (z10) {
            dVar.z("X-Mah-Req-Type", "1008");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c5, code lost:
        if (r4 == null) goto L_0x00ca;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final e.k.a q(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            java.lang.String r2 = ""
            e.k$b r3 = e.k.b.NONE
            r4 = 0
            d.k r5 = r7.f21094b     // Catch:{ d -> 0x0020, all -> 0x001d }
            d.b r6 = d.b.ADDRESS_TYPE_PROXY_HANDSHAKE     // Catch:{ d -> 0x0020, all -> 0x001d }
            com.mah.sdk.MahProxyAddress r5 = r5.h(r6)     // Catch:{ d -> 0x0020, all -> 0x001d }
            boolean r6 = com.mah.sdk.OooO00o.OooO0O0((com.mah.sdk.MahProxyAddress) r5)     // Catch:{ d -> 0x0020, all -> 0x001d }
            if (r6 != 0) goto L_0x0023
            e.k$a r8 = new e.k$a     // Catch:{ d -> 0x0020, all -> 0x001d }
            e.k$b r9 = e.k.b.FINISH     // Catch:{ d -> 0x0020, all -> 0x001d }
            r8.<init>(r2, r9, r2)     // Catch:{ d -> 0x0020, all -> 0x001d }
            return r8
        L_0x001d:
            r8 = move-exception
            goto L_0x009a
        L_0x0020:
            r8 = move-exception
            goto L_0x00b1
        L_0x0023:
            java.lang.String r6 = r7.N0     // Catch:{ d -> 0x0020, all -> 0x001d }
            s.d r4 = com.mah.sdk.OooO00o.OooO00o((java.lang.String) r6, (com.mah.sdk.MahProxyAddress) r5)     // Catch:{ d -> 0x0020, all -> 0x001d }
            r7.s(r4)     // Catch:{ d -> 0x0020, all -> 0x001d }
            r7.p(r4, r9)     // Catch:{ d -> 0x0020, all -> 0x001d }
            o(r4)     // Catch:{ d -> 0x0020, all -> 0x001d }
            java.lang.String r8 = r7.t(r8)     // Catch:{ d -> 0x0020, all -> 0x001d }
            byte[] r8 = r8.getBytes()     // Catch:{ d -> 0x0020, all -> 0x001d }
            r4.o(r8)     // Catch:{ d -> 0x0020, all -> 0x001d }
            int r8 = r4.K()     // Catch:{ d -> 0x0020, all -> 0x001d }
            r9 = 200(0xc8, float:2.8E-43)
            if (r8 != r9) goto L_0x0073
            java.lang.String r8 = r4.d()     // Catch:{ d -> 0x0020, all -> 0x001d }
            java.lang.String r9 = com.mah.sdk.OooO00o.OooO0OO()     // Catch:{ d -> 0x0020, all -> 0x001d }
            java.lang.String r8 = i.w.a(r8, r9)     // Catch:{ d -> 0x0020, all -> 0x001d }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ d -> 0x0020, all -> 0x001d }
            if (r9 == 0) goto L_0x0064
            java.lang.String r8 = "decrypt return empty"
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ d -> 0x0020, all -> 0x001d }
            java.lang.String r8 = r7.c(r8, r9)     // Catch:{ d -> 0x0020, all -> 0x001d }
            r9 = 3
            r7.f(r9, r8)     // Catch:{ d -> 0x0020, all -> 0x001d }
            goto L_0x00c7
        L_0x0064:
            java.lang.String r9 = com.mah.sdk.OooO00o.OooO0OO((s.d) r4)     // Catch:{ d -> 0x0020, all -> 0x001d }
            e.k$a r5 = new e.k$a     // Catch:{ d -> 0x0020, all -> 0x001d }
            e.k$b r6 = e.k.b.FINISH     // Catch:{ d -> 0x0020, all -> 0x001d }
            r5.<init>(r8, r6, r9)     // Catch:{ d -> 0x0020, all -> 0x001d }
            r4.O()
            return r5
        L_0x0073:
            java.lang.String r8 = "0"
            java.lang.String r9 = "X-Mah-Rsp-Type"
            java.lang.String r9 = r4.H(r9)     // Catch:{ d -> 0x0020, all -> 0x001d }
            boolean r8 = r8.equals(r9)     // Catch:{ d -> 0x0020, all -> 0x001d }
            if (r8 == 0) goto L_0x0083
            e.k$b r3 = e.k.b.FINISH     // Catch:{ d -> 0x0020, all -> 0x001d }
        L_0x0083:
            java.lang.String r8 = "Response code=%d"
            int r9 = r4.K()     // Catch:{ d -> 0x0020, all -> 0x001d }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ d -> 0x0020, all -> 0x001d }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ d -> 0x0020, all -> 0x001d }
            r5[r1] = r9     // Catch:{ d -> 0x0020, all -> 0x001d }
            java.lang.String r8 = r7.c(r8, r5)     // Catch:{ d -> 0x0020, all -> 0x001d }
            r9 = 2
            r7.f(r9, r8)     // Catch:{ d -> 0x0020, all -> 0x001d }
            goto L_0x00c7
        L_0x009a:
            java.lang.String r9 = "Auth unknown exception:%s"
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x00af }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x00af }
            r0[r1] = r8     // Catch:{ all -> 0x00af }
            java.lang.String r8 = r7.c(r9, r0)     // Catch:{ all -> 0x00af }
            r9 = -1
            r7.f(r9, r8)     // Catch:{ all -> 0x00af }
            if (r4 == 0) goto L_0x00ca
            goto L_0x00c7
        L_0x00af:
            r8 = move-exception
            goto L_0x00d0
        L_0x00b1:
            r8.getMessage()     // Catch:{ all -> 0x00af }
            java.lang.String r9 = "Auth HttpRequestException:%s"
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x00af }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x00af }
            r5[r1] = r8     // Catch:{ all -> 0x00af }
            java.lang.String r8 = r7.c(r9, r5)     // Catch:{ all -> 0x00af }
            r7.f(r0, r8)     // Catch:{ all -> 0x00af }
            if (r4 == 0) goto L_0x00ca
        L_0x00c7:
            r4.O()
        L_0x00ca:
            e.k$a r8 = new e.k$a
            r8.<init>(r2, r3, r2)
            return r8
        L_0x00d0:
            if (r4 == 0) goto L_0x00d5
            r4.O()
        L_0x00d5:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e.o.q(java.lang.String, boolean):e.k$a");
    }

    public final void s(s.d dVar) {
        dVar.w(5000);
        dVar.D(OooO00o.OooO0O0(30000));
    }

    public String t(String str) {
        long j10;
        Context OooO00o = this.f21094b.OooO00o();
        g j11 = this.O0.j();
        String h10 = j11.h();
        String b10 = this.O0.b();
        String OooO0Oo = OooO00o.OooO0Oo(OooO00o);
        String version = MahProxy.getVersion();
        String n10 = n(OooO00o, j11.e());
        String OooO00o2 = OooO00o.OooO00o(OooO00o);
        String OooO0O0 = OooO00o.OooO0O0();
        String OooO0Oo2 = OooO00o.OooO0Oo();
        String a10 = this.f21094b.f().a();
        String f10 = w.f(b10, OooO00o.OooO0OO());
        String f11 = w.f(OooO0Oo, OooO00o.OooO0OO());
        String i10 = v.i();
        String c10 = p.c(i10, h10);
        e f12 = this.O0.f();
        i.a aVar = this.f21093a;
        e eVar = f12;
        i.a aVar2 = i.a.AUTH_START;
        boolean z10 = !this.f21094b.m();
        String str2 = OooO00o2;
        if (aVar == aVar2) {
            j10 = this.f21094b.r().q();
        } else {
            j10 = 0;
        }
        JSONObject jSONObject = new JSONObject();
        a.b(jSONObject, j11);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("version", 2);
        jSONObject2.put("packageName", h10);
        jSONObject2.put("fingerPrint", n10);
        jSONObject2.put("timestamp", i10);
        jSONObject2.put("authKey", c10);
        jSONObject2.put("sdkVersion", version);
        jSONObject2.put("platform", OooO0Oo2);
        jSONObject2.put("imei", f10);
        jSONObject2.put("appVersion", str2);
        jSONObject2.put("networkType", a10);
        jSONObject2.put("imsi", f11);
        jSONObject2.put("model", OooO0O0);
        jSONObject2.put("lastRequestNum", 0);
        jSONObject2.put("lastUseTime", 0);
        jSONObject2.put("sdkType", 3);
        jSONObject2.put("type", this.f21093a.f21076a);
        jSONObject2.put("remoteMode", z10);
        jSONObject2.put("contentMD5", str);
        jSONObject2.put("startTime", j10);
        jSONObject2.put("lastSdkCrash", this.f21094b.q());
        jSONObject2.put("sessionId", eVar.b());
        jSONObject2.put("extension", jSONObject);
        JSONArray r10 = r(this.Z);
        if (r10 != null) {
            jSONObject2.put("authFailTime", r10);
        }
        return jSONObject2.toString();
    }
}
