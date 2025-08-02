package g5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k5.b;
import z2.a;

public class c implements e {

    /* renamed from: a  reason: collision with root package name */
    private final List f21738a;

    public c(Set set) {
        this.f21738a = new ArrayList(set.size());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar != null) {
                this.f21738a.add(eVar);
            }
        }
    }

    private void l(String str, Throwable th) {
        a.k("ForwardingRequestListener", str, th);
    }

    public void a(b bVar, Object obj, String str, boolean z10) {
        int size = this.f21738a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ((e) this.f21738a.get(i10)).a(bVar, obj, str, z10);
            } catch (Exception e10) {
                l("InternalListener exception in onRequestStart", e10);
            }
        }
    }

    public void b(String str, String str2) {
        int size = this.f21738a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ((e) this.f21738a.get(i10)).b(str, str2);
            } catch (Exception e10) {
                l("InternalListener exception in onProducerStart", e10);
            }
        }
    }

    public void c(String str, String str2, Map map) {
        int size = this.f21738a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ((e) this.f21738a.get(i10)).c(str, str2, map);
            } catch (Exception e10) {
                l("InternalListener exception in onProducerFinishWithCancellation", e10);
            }
        }
    }

    public void d(String str, String str2, boolean z10) {
        int size = this.f21738a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ((e) this.f21738a.get(i10)).d(str, str2, z10);
            } catch (Exception e10) {
                l("InternalListener exception in onProducerFinishWithSuccess", e10);
            }
        }
    }

    public boolean e(String str) {
        int size = this.f21738a.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((e) this.f21738a.get(i10)).e(str)) {
                return true;
            }
        }
        return false;
    }

    public void f(String str, String str2, String str3) {
        int size = this.f21738a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ((e) this.f21738a.get(i10)).f(str, str2, str3);
            } catch (Exception e10) {
                l("InternalListener exception in onIntermediateChunkStart", e10);
            }
        }
    }

    public void g(String str, String str2, Map map) {
        int size = this.f21738a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ((e) this.f21738a.get(i10)).g(str, str2, map);
            } catch (Exception e10) {
                l("InternalListener exception in onProducerFinishWithSuccess", e10);
            }
        }
    }

    public void h(String str, String str2, Throwable th, Map map) {
        int size = this.f21738a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ((e) this.f21738a.get(i10)).h(str, str2, th, map);
            } catch (Exception e10) {
                l("InternalListener exception in onProducerFinishWithFailure", e10);
            }
        }
    }

    public void i(b bVar, String str, boolean z10) {
        int size = this.f21738a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ((e) this.f21738a.get(i10)).i(bVar, str, z10);
            } catch (Exception e10) {
                l("InternalListener exception in onRequestSuccess", e10);
            }
        }
    }

    public void j(b bVar, String str, Throwable th, boolean z10) {
        int size = this.f21738a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ((e) this.f21738a.get(i10)).j(bVar, str, th, z10);
            } catch (Exception e10) {
                l("InternalListener exception in onRequestFailure", e10);
            }
        }
    }

    public void k(String str) {
        int size = this.f21738a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ((e) this.f21738a.get(i10)).k(str);
            } catch (Exception e10) {
                l("InternalListener exception in onRequestCancellation", e10);
            }
        }
    }

    public c(e... eVarArr) {
        this.f21738a = new ArrayList(eVarArr.length);
        for (e eVar : eVarArr) {
            if (eVar != null) {
                this.f21738a.add(eVar);
            }
        }
    }
}
