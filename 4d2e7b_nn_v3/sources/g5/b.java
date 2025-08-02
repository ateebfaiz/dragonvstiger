package g5;

import com.facebook.imagepipeline.producers.e1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class b implements d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21736b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final List f21737a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(Set set) {
        if (set == null) {
            this.f21737a = new ArrayList();
            return;
        }
        ArrayList arrayList = new ArrayList(set.size());
        this.f21737a = arrayList;
        r.W(set, arrayList);
    }

    public void a(e1 e1Var, String str, String str2) {
        m.f(e1Var, "producerContext");
        m.f(str, "producerName");
        m.f(str2, "producerEventName");
        for (d a10 : this.f21737a) {
            try {
                a10.a(e1Var, str, str2);
            } catch (Exception e10) {
                z2.a.k("ForwardingRequestListener2", "InternalListener exception in " + "onIntermediateChunkStart", e10);
            }
        }
    }

    public void b(e1 e1Var) {
        m.f(e1Var, "producerContext");
        for (d b10 : this.f21737a) {
            try {
                b10.b(e1Var);
            } catch (Exception e10) {
                z2.a.k("ForwardingRequestListener2", "InternalListener exception in " + "onRequestStart", e10);
            }
        }
    }

    public void c(e1 e1Var, String str, boolean z10) {
        m.f(e1Var, "producerContext");
        m.f(str, "producerName");
        for (d c10 : this.f21737a) {
            try {
                c10.c(e1Var, str, z10);
            } catch (Exception e10) {
                z2.a.k("ForwardingRequestListener2", "InternalListener exception in " + "onProducerFinishWithSuccess", e10);
            }
        }
    }

    public void d(e1 e1Var, String str, Map map) {
        for (d d10 : this.f21737a) {
            try {
                d10.d(e1Var, str, map);
            } catch (Exception e10) {
                z2.a.k("ForwardingRequestListener2", "InternalListener exception in " + "onProducerFinishWithCancellation", e10);
            }
        }
    }

    public void e(e1 e1Var, String str) {
        m.f(e1Var, "producerContext");
        m.f(str, "producerName");
        for (d e10 : this.f21737a) {
            try {
                e10.e(e1Var, str);
            } catch (Exception e11) {
                z2.a.k("ForwardingRequestListener2", "InternalListener exception in " + "onProducerStart", e11);
            }
        }
    }

    public void f(e1 e1Var) {
        m.f(e1Var, "producerContext");
        for (d f10 : this.f21737a) {
            try {
                f10.f(e1Var);
            } catch (Exception e10) {
                z2.a.k("ForwardingRequestListener2", "InternalListener exception in " + "onRequestSuccess", e10);
            }
        }
    }

    public boolean g(e1 e1Var, String str) {
        m.f(e1Var, "producerContext");
        m.f(str, "producerName");
        Iterable<d> iterable = this.f21737a;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (d g10 : iterable) {
            if (g10.g(e1Var, str)) {
                return true;
            }
        }
        return false;
    }

    public void h(e1 e1Var, Throwable th) {
        m.f(e1Var, "producerContext");
        m.f(th, "throwable");
        for (d h10 : this.f21737a) {
            try {
                h10.h(e1Var, th);
            } catch (Exception e10) {
                z2.a.k("ForwardingRequestListener2", "InternalListener exception in " + "onRequestFailure", e10);
            }
        }
    }

    public void i(e1 e1Var) {
        m.f(e1Var, "producerContext");
        for (d i10 : this.f21737a) {
            try {
                i10.i(e1Var);
            } catch (Exception e10) {
                z2.a.k("ForwardingRequestListener2", "InternalListener exception in " + "onRequestCancellation", e10);
            }
        }
    }

    public void j(e1 e1Var, String str, Map map) {
        for (d j10 : this.f21737a) {
            try {
                j10.j(e1Var, str, map);
            } catch (Exception e10) {
                z2.a.k("ForwardingRequestListener2", "InternalListener exception in " + "onProducerFinishWithSuccess", e10);
            }
        }
    }

    public void k(e1 e1Var, String str, Throwable th, Map map) {
        for (d k10 : this.f21737a) {
            try {
                k10.k(e1Var, str, th, map);
            } catch (Exception e10) {
                z2.a.k("ForwardingRequestListener2", "InternalListener exception in " + "onProducerFinishWithFailure", e10);
            }
        }
    }
}
