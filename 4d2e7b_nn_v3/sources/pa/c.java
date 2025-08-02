package pa;

import com.onesignal.c2;
import com.onesignal.p3;
import com.onesignal.u3;
import com.onesignal.y2;
import kotlin.jvm.internal.m;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final c2 f12900a;

    /* renamed from: b  reason: collision with root package name */
    private final p3 f12901b;

    /* renamed from: c  reason: collision with root package name */
    private final a f12902c;

    /* renamed from: d  reason: collision with root package name */
    private qa.c f12903d;

    public c(c2 c2Var, p3 p3Var, u3 u3Var, y2 y2Var) {
        m.f(c2Var, "logger");
        m.f(p3Var, "apiClient");
        this.f12900a = c2Var;
        this.f12901b = p3Var;
        m.c(u3Var);
        m.c(y2Var);
        this.f12902c = new a(c2Var, u3Var, y2Var);
    }

    private final d a() {
        if (this.f12902c.j()) {
            return new g(this.f12900a, this.f12902c, new h(this.f12901b));
        }
        return new e(this.f12900a, this.f12902c, new f(this.f12901b));
    }

    private final qa.c c() {
        if (!this.f12902c.j()) {
            qa.c cVar = this.f12903d;
            if (cVar instanceof e) {
                m.c(cVar);
                return cVar;
            }
        }
        if (this.f12902c.j()) {
            qa.c cVar2 = this.f12903d;
            if (cVar2 instanceof g) {
                m.c(cVar2);
                return cVar2;
            }
        }
        return a();
    }

    public final qa.c b() {
        if (this.f12903d != null) {
            return c();
        }
        return a();
    }
}
