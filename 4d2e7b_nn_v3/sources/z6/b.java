package z6;

import android.util.Pair;
import c8.a;
import g5.a;
import java.util.HashMap;
import java.util.Map;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    int f13440a = 0;

    /* renamed from: b  reason: collision with root package name */
    Map f13441b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    Map f13442c = new HashMap();

    public void a(k5.b bVar, Object obj, String str, boolean z10) {
        if (c8.a.h(0)) {
            Pair create = Pair.create(Integer.valueOf(this.f13440a), "FRESCO_REQUEST_" + bVar.u().toString().replace(':', '_'));
            c8.a.a(0, (String) create.second, this.f13440a);
            this.f13442c.put(str, create);
            this.f13440a = this.f13440a + 1;
        }
    }

    public void b(String str, String str2) {
        if (c8.a.h(0)) {
            Pair create = Pair.create(Integer.valueOf(this.f13440a), "FRESCO_PRODUCER_" + str2.replace(':', '_'));
            c8.a.a(0, (String) create.second, this.f13440a);
            this.f13441b.put(str, create);
            this.f13440a = this.f13440a + 1;
        }
    }

    public void c(String str, String str2, Map map) {
        if (c8.a.h(0) && this.f13441b.containsKey(str)) {
            Pair pair = (Pair) this.f13441b.get(str);
            c8.a.e(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.f13441b.remove(str);
        }
    }

    public boolean e(String str) {
        return false;
    }

    public void f(String str, String str2, String str3) {
        if (c8.a.h(0)) {
            c8.a.l(0, "FRESCO_PRODUCER_EVENT_" + str.replace(':', '_') + "_" + str2.replace(':', '_') + "_" + str3.replace(':', '_'), a.C0044a.THREAD);
        }
    }

    public void g(String str, String str2, Map map) {
        if (c8.a.h(0) && this.f13441b.containsKey(str)) {
            Pair pair = (Pair) this.f13441b.get(str);
            c8.a.e(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.f13441b.remove(str);
        }
    }

    public void h(String str, String str2, Throwable th, Map map) {
        if (c8.a.h(0) && this.f13441b.containsKey(str)) {
            Pair pair = (Pair) this.f13441b.get(str);
            c8.a.e(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.f13441b.remove(str);
        }
    }

    public void i(k5.b bVar, String str, boolean z10) {
        if (c8.a.h(0) && this.f13442c.containsKey(str)) {
            Pair pair = (Pair) this.f13442c.get(str);
            c8.a.e(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.f13442c.remove(str);
        }
    }

    public void j(k5.b bVar, String str, Throwable th, boolean z10) {
        if (c8.a.h(0) && this.f13442c.containsKey(str)) {
            Pair pair = (Pair) this.f13442c.get(str);
            c8.a.e(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.f13442c.remove(str);
        }
    }

    public void k(String str) {
        if (c8.a.h(0) && this.f13442c.containsKey(str)) {
            Pair pair = (Pair) this.f13442c.get(str);
            c8.a.e(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.f13442c.remove(str);
        }
    }
}
