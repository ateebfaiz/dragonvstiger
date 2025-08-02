package y9;

import ba.f;
import ga.b;
import ga.c;
import java.io.IOException;

public abstract class r {

    class a extends r {
        a() {
        }

        public Object b(ga.a aVar) {
            if (aVar.O() != b.NULL) {
                return r.this.b(aVar);
            }
            aVar.K();
            return null;
        }

        public void d(c cVar, Object obj) {
            if (obj == null) {
                cVar.B();
            } else {
                r.this.d(cVar, obj);
            }
        }
    }

    public final r a() {
        return new a();
    }

    public abstract Object b(ga.a aVar);

    public final g c(Object obj) {
        try {
            f fVar = new f();
            d(fVar, obj);
            return fVar.U();
        } catch (IOException e10) {
            throw new h((Throwable) e10);
        }
    }

    public abstract void d(c cVar, Object obj);
}
