package com.onesignal;

import com.onesignal.b4;
import com.onesignal.b5;
import com.onesignal.h0;
import com.onesignal.o3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

abstract class e4 {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f10620a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap f10621b = new HashMap();

    interface a {
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f10622a;

        /* renamed from: b  reason: collision with root package name */
        public String f10623b;

        b(int i10, String str) {
            this.f10622a = i10;
            this.f10623b = str;
        }
    }

    enum c {
        PUSH,
        EMAIL,
        SMS
    }

    static void a() {
        d().o();
        b().o();
        f().o();
    }

    static v4 b() {
        HashMap hashMap = f10621b;
        c cVar = c.EMAIL;
        if (!hashMap.containsKey(cVar) || f10621b.get(cVar) == null) {
            synchronized (f10620a) {
                try {
                    if (f10621b.get(cVar) == null) {
                        f10621b.put(cVar, new v4());
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
        return (v4) f10621b.get(cVar);
    }

    static String c() {
        return d().f0();
    }

    static x4 d() {
        HashMap hashMap = f10621b;
        c cVar = c.PUSH;
        if (!hashMap.containsKey(cVar) || f10621b.get(cVar) == null) {
            synchronized (f10620a) {
                try {
                    if (f10621b.get(cVar) == null) {
                        f10621b.put(cVar, new x4());
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
        return (x4) f10621b.get(cVar);
    }

    static String e() {
        return d().D();
    }

    static z4 f() {
        HashMap hashMap = f10621b;
        c cVar = c.SMS;
        if (!hashMap.containsKey(cVar) || f10621b.get(cVar) == null) {
            synchronized (f10620a) {
                try {
                    if (f10621b.get(cVar) == null) {
                        f10621b.put(cVar, new z4());
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
        return (z4) f10621b.get(cVar);
    }

    static boolean g() {
        if (d().E() || b().E() || f().E()) {
            return true;
        }
        return false;
    }

    static b5.e h(boolean z10) {
        return d().g0(z10);
    }

    static List i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(d());
        if (o3.H0()) {
            arrayList.add(b());
        }
        if (o3.I0()) {
            arrayList.add(f());
        }
        return arrayList;
    }

    static boolean j() {
        return d().h0();
    }

    static void k() {
        d().J();
        b().J();
        f().J();
    }

    static boolean l() {
        boolean P = d().P();
        boolean P2 = b().P();
        boolean P3 = f().P();
        if (P2) {
            if (b().D() != null) {
                P2 = true;
            } else {
                P2 = false;
            }
        }
        if (P3) {
            if (f().D() != null) {
                P3 = true;
            } else {
                P3 = false;
            }
        }
        if (P || P2 || P3) {
            return true;
        }
        return false;
    }

    static void m(boolean z10) {
        d().Q(z10);
        b().Q(z10);
        f().Q(z10);
    }

    static void n() {
        b().j0();
        f().j0();
    }

    static void o() {
        d().R();
        b().R();
        f().R();
        d().i0((String) null);
        b().k0((String) null);
        f().k0((String) null);
        o3.F1(-3660);
    }

    static void p(JSONObject jSONObject, b4.g gVar) {
        for (b5 U : i()) {
            U.U(jSONObject, gVar);
        }
    }

    static void q(JSONObject jSONObject, o3.s sVar) {
        try {
            JSONObject put = new JSONObject().put("tags", jSONObject);
            d().V(put, sVar);
            b().V(put, sVar);
            f().V(put, sVar);
        } catch (JSONException e10) {
            if (sVar != null) {
                sVar.a(new o3.b0(-1, "Encountered an error attempting to serialize your tags into JSON: " + e10.getMessage() + "\n" + e10.getStackTrace()));
            }
            e10.printStackTrace();
        }
    }

    static void r() {
        d().Y();
        b().Y();
        f().Y();
    }

    static void s() {
        b().Y();
    }

    static void t(boolean z10) {
        d().j0(z10);
    }

    static void u(boolean z10) {
        d().a0(z10);
        b().a0(z10);
        f().a0(z10);
    }

    static void v(JSONObject jSONObject, a aVar) {
        d().b0(jSONObject, aVar);
        b().b0(jSONObject, aVar);
        f().b0(jSONObject, aVar);
    }

    static void w(h0.d dVar) {
        d().d0(dVar);
        b().d0(dVar);
        f().d0(dVar);
    }

    static void x(JSONObject jSONObject) {
        d().k0(jSONObject);
    }
}
