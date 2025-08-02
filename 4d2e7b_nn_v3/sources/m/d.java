package m;

import android.content.Context;
import android.text.TextUtils;
import d.c;
import d.k;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import r.d;
import r.f;
import r.g;
import r.j;

public class d implements l.b {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f22475a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final k f22476b;

    /* renamed from: c  reason: collision with root package name */
    public final c f22477c;

    /* renamed from: d  reason: collision with root package name */
    public int f22478d = 1;

    public class a implements d.a {
        public a() {
        }

        public void OooO00o() {
            String str = b.f22462j;
        }

        public void e() {
            String str = b.f22462j;
        }
    }

    public static class b extends c {
        public b(g gVar, String str, Context context, c cVar) {
            super("mah-access-debug", "abnormal_access.gzip", gVar, str, context, cVar);
        }
    }

    public d(k kVar, c cVar) {
        this.f22476b = kVar;
        this.f22477c = cVar;
        l.a.a().c(this);
    }

    public void a(l.c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.f22343a)) {
            this.f22475a.add(cVar.f22343a);
        }
    }

    public final String b(ArrayList arrayList) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            sb2.append((String) arrayList.get(i10));
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public final ArrayList c() {
        ArrayList arrayList = new ArrayList(this.f22475a);
        String str = b.f22462j;
        arrayList.size();
        this.f22478d = arrayList.size() + this.f22478d;
        this.f22475a.clear();
        return arrayList;
    }

    public void d(String str) {
        ArrayList c10 = c();
        if (!c10.isEmpty()) {
            String str2 = b.f22462j;
            c10.size();
            f.c().m(new r.d(new b(new j(b(c10)), str, this.f22476b.OooO00o(), this.f22477c), new a()));
        }
    }

    public void e() {
        l.a.a().e(this);
    }
}
