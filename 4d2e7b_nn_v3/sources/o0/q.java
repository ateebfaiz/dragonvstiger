package o0;

import java.util.Collections;
import z0.a;
import z0.c;

public class q extends a {

    /* renamed from: i  reason: collision with root package name */
    private final Object f22949i;

    public q(c cVar) {
        this(cVar, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return 1.0f;
    }

    public Object h() {
        c cVar = this.f22882e;
        Object obj = this.f22949i;
        return cVar.b(0.0f, 0.0f, obj, obj, f(), f(), f());
    }

    /* access modifiers changed from: package-private */
    public Object i(a aVar, float f10) {
        return h();
    }

    public void l() {
        if (this.f22882e != null) {
            super.l();
        }
    }

    public void n(float f10) {
        this.f22881d = f10;
    }

    public q(c cVar, Object obj) {
        super(Collections.emptyList());
        o(cVar);
        this.f22949i = obj;
    }
}
