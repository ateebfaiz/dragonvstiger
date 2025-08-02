package ma;

import com.onesignal.a4;
import com.onesignal.c2;
import com.onesignal.g3;
import com.onesignal.o3;
import com.onesignal.y2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import na.b;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap f12821a;

    /* renamed from: b  reason: collision with root package name */
    private final c f12822b;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12823a;

        static {
            int[] iArr = new int[b.values().length];
            iArr[b.NOTIFICATION.ordinal()] = 1;
            iArr[b.IAM.ordinal()] = 2;
            f12823a = iArr;
        }
    }

    public e(y2 y2Var, c2 c2Var, g3 g3Var) {
        m.f(y2Var, "preferences");
        m.f(c2Var, "logger");
        m.f(g3Var, "timeProvider");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f12821a = concurrentHashMap;
        c cVar = new c(y2Var);
        this.f12822b = cVar;
        la.a aVar = la.a.f12772a;
        concurrentHashMap.put(aVar.a(), new b(cVar, c2Var, g3Var));
        concurrentHashMap.put(aVar.b(), new d(cVar, c2Var, g3Var));
    }

    public final void a(JSONObject jSONObject, List list) {
        m.f(jSONObject, "jsonObject");
        m.f(list, "influences");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            na.a aVar = (na.a) it.next();
            if (a.f12823a[aVar.c().ordinal()] == 1) {
                g().a(jSONObject, aVar);
            }
        }
    }

    public final a b(o3.r rVar) {
        m.f(rVar, "entryAction");
        if (rVar.d()) {
            return g();
        }
        return null;
    }

    public final List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(g());
        arrayList.add(e());
        return arrayList;
    }

    public final List d(o3.r rVar) {
        a aVar;
        m.f(rVar, "entryAction");
        ArrayList arrayList = new ArrayList();
        if (rVar.b()) {
            return arrayList;
        }
        if (rVar.c()) {
            aVar = g();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            arrayList.add(aVar);
        }
        arrayList.add(e());
        return arrayList;
    }

    public final a e() {
        Object obj = this.f12821a.get(la.a.f12772a.a());
        m.c(obj);
        m.e(obj, "trackers[OSInfluenceConstants.IAM_TAG]!!");
        return (a) obj;
    }

    public final List f() {
        Collection values = this.f12821a.values();
        m.e(values, "trackers.values");
        Iterable<a> iterable = values;
        ArrayList arrayList = new ArrayList(r.v(iterable, 10));
        for (a e10 : iterable) {
            arrayList.add(e10.e());
        }
        return arrayList;
    }

    public final a g() {
        Object obj = this.f12821a.get(la.a.f12772a.b());
        m.c(obj);
        m.e(obj, "trackers[OSInfluenceConstants.NOTIFICATION_TAG]!!");
        return (a) obj;
    }

    public final List h() {
        Collection values = this.f12821a.values();
        m.e(values, "trackers.values");
        ArrayList<a> arrayList = new ArrayList<>();
        for (Object next : values) {
            if (!m.b(((a) next).h(), la.a.f12772a.a())) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(r.v(arrayList, 10));
        for (a e10 : arrayList) {
            arrayList2.add(e10.e());
        }
        return arrayList2;
    }

    public final void i() {
        Collection<a> values = this.f12821a.values();
        m.e(values, "trackers.values");
        for (a p10 : values) {
            p10.p();
        }
    }

    public final void j(a4.e eVar) {
        m.f(eVar, "influenceParams");
        this.f12822b.q(eVar);
    }
}
