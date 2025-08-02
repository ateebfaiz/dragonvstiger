package com.onesignal;

import com.onesignal.o3;
import java.util.ArrayList;
import java.util.List;
import ma.e;
import na.c;
import org.json.JSONArray;
import org.json.JSONObject;

public class x2 {

    /* renamed from: a  reason: collision with root package name */
    protected e f11101a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f11102b;

    /* renamed from: c  reason: collision with root package name */
    private c2 f11103c;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f11104a;

        a(List list) {
            this.f11104a = list;
        }

        public void run() {
            Thread.currentThread().setPriority(10);
            x2.this.f11102b.a(this.f11104a);
        }
    }

    public interface b {
        void a(List list);
    }

    public x2(b bVar, e eVar, c2 c2Var) {
        this.f11102b = bVar;
        this.f11101a = eVar;
        this.f11103c = c2Var;
    }

    private void d(o3.r rVar, String str) {
        boolean z10;
        na.a aVar;
        this.f11103c.b("OneSignal SessionManager attemptSessionUpgrade with entryAction: " + rVar);
        ma.a b10 = this.f11101a.b(rVar);
        List<ma.a> d10 = this.f11101a.d(rVar);
        ArrayList arrayList = new ArrayList();
        if (b10 != null) {
            aVar = b10.e();
            c cVar = c.DIRECT;
            if (str == null) {
                str = b10.g();
            }
            z10 = o(b10, cVar, str, (JSONArray) null);
        } else {
            z10 = false;
            aVar = null;
        }
        if (z10) {
            this.f11103c.b("OneSignal SessionManager attemptSessionUpgrade channel updated, search for ending direct influences on channels: " + d10);
            arrayList.add(aVar);
            for (ma.a aVar2 : d10) {
                if (aVar2.k().c()) {
                    arrayList.add(aVar2.e());
                    aVar2.t();
                }
            }
        }
        this.f11103c.b("OneSignal SessionManager attemptSessionUpgrade try UNATTRIBUTED to INDIRECT upgrade");
        for (ma.a aVar3 : d10) {
            if (aVar3.k().f()) {
                JSONArray n10 = aVar3.n();
                if (n10.length() > 0 && !rVar.b()) {
                    na.a e10 = aVar3.e();
                    if (o(aVar3, c.INDIRECT, (String) null, n10)) {
                        arrayList.add(e10);
                    }
                }
            }
        }
        o3.a(o3.v.DEBUG, "Trackers after update attempt: " + this.f11101a.c().toString());
        n(arrayList);
    }

    private void n(List list) {
        c2 c2Var = this.f11103c;
        c2Var.b("OneSignal SessionManager sendSessionEndingWithInfluences with influences: " + list);
        if (list.size() > 0) {
            new Thread(new a(list), "OS_END_CURRENT_SESSION").start();
        }
    }

    private boolean o(ma.a aVar, c cVar, String str, JSONArray jSONArray) {
        if (!p(aVar, cVar, str, jSONArray)) {
            return false;
        }
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "OSChannelTracker changed: " + aVar.h() + "\nfrom:\ninfluenceType: " + aVar.k() + ", directNotificationId: " + aVar.g() + ", indirectNotificationIds: " + aVar.j() + "\nto:\ninfluenceType: " + cVar + ", directNotificationId: " + str + ", indirectNotificationIds: " + jSONArray);
        aVar.y(cVar);
        aVar.w(str);
        aVar.x(jSONArray);
        aVar.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Trackers changed to: ");
        sb2.append(this.f11101a.c().toString());
        o3.a(vVar, sb2.toString());
        return true;
    }

    private boolean p(ma.a aVar, c cVar, String str, JSONArray jSONArray) {
        if (!cVar.equals(aVar.k())) {
            return true;
        }
        c k10 = aVar.k();
        if (k10.c() && aVar.g() != null && !aVar.g().equals(str)) {
            return true;
        }
        if (!k10.e() || aVar.j() == null || aVar.j().length() <= 0 || f0.a(aVar.j(), jSONArray)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b(JSONObject jSONObject, List list) {
        c2 c2Var = this.f11103c;
        c2Var.b("OneSignal SessionManager addSessionData with influences: " + list.toString());
        this.f11101a.a(jSONObject, list);
        c2 c2Var2 = this.f11103c;
        c2Var2.b("OneSignal SessionManager addSessionIds on jsonObject: " + jSONObject);
    }

    /* access modifiers changed from: package-private */
    public void c(o3.r rVar) {
        d(rVar, (String) null);
    }

    /* access modifiers changed from: package-private */
    public List e() {
        return this.f11101a.f();
    }

    /* access modifiers changed from: package-private */
    public List f() {
        return this.f11101a.h();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.f11101a.i();
    }

    /* access modifiers changed from: package-private */
    public void h(String str) {
        c2 c2Var = this.f11103c;
        c2Var.b("OneSignal SessionManager onDirectInfluenceFromIAMClick messageId: " + str);
        o(this.f11101a.e(), c.DIRECT, str, (JSONArray) null);
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.f11103c.b("OneSignal SessionManager onDirectInfluenceFromIAMClickFinished");
        this.f11101a.e().t();
    }

    /* access modifiers changed from: package-private */
    public void j(o3.r rVar, String str) {
        c2 c2Var = this.f11103c;
        c2Var.b("OneSignal SessionManager onDirectInfluenceFromNotificationOpen notificationId: " + str);
        if (str != null && !str.isEmpty()) {
            d(rVar, str);
        }
    }

    /* access modifiers changed from: package-private */
    public void k(String str) {
        c2 c2Var = this.f11103c;
        c2Var.b("OneSignal SessionManager onInAppMessageReceived messageId: " + str);
        ma.a e10 = this.f11101a.e();
        e10.v(str);
        e10.t();
    }

    /* access modifiers changed from: package-private */
    public void l(String str) {
        c2 c2Var = this.f11103c;
        c2Var.b("OneSignal SessionManager onNotificationReceived notificationId: " + str);
        if (str != null && !str.isEmpty()) {
            this.f11101a.g().v(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void m(o3.r rVar) {
        boolean z10;
        List<ma.a> d10 = this.f11101a.d(rVar);
        ArrayList arrayList = new ArrayList();
        c2 c2Var = this.f11103c;
        c2Var.b("OneSignal SessionManager restartSessionIfNeeded with entryAction: " + rVar + "\n channelTrackers: " + d10.toString());
        for (ma.a aVar : d10) {
            JSONArray n10 = aVar.n();
            c2 c2Var2 = this.f11103c;
            c2Var2.b("OneSignal SessionManager restartSessionIfNeeded lastIds: " + n10);
            na.a e10 = aVar.e();
            if (n10.length() > 0) {
                z10 = o(aVar, c.INDIRECT, (String) null, n10);
            } else {
                z10 = o(aVar, c.UNATTRIBUTED, (String) null, (JSONArray) null);
            }
            if (z10) {
                arrayList.add(e10);
            }
        }
        n(arrayList);
    }
}
