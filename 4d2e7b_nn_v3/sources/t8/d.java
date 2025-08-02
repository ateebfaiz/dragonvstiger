package t8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.c;
import com.fasterxml.jackson.databind.util.l;
import java.io.Serializable;

public abstract class d {

    private static final class a extends c implements Serializable {
        protected final c R0;
        protected final Class[] S0;

        protected a(c cVar, Class[] clsArr) {
            super(cVar);
            this.R0 = cVar;
            this.S0 = clsArr;
        }

        private final boolean C(Class cls) {
            if (cls == null) {
                return true;
            }
            for (Class isAssignableFrom : this.S0) {
                if (isAssignableFrom.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: D */
        public a t(l lVar) {
            return new a(this.R0.t(lVar), this.S0);
        }

        public void h(o oVar) {
            this.R0.h(oVar);
        }

        public void i(o oVar) {
            this.R0.i(oVar);
        }

        public void u(Object obj, f fVar, b0 b0Var) {
            if (C(b0Var.K())) {
                this.R0.u(obj, fVar, b0Var);
            } else {
                this.R0.x(obj, fVar, b0Var);
            }
        }

        public void v(Object obj, f fVar, b0 b0Var) {
            if (C(b0Var.K())) {
                this.R0.v(obj, fVar, b0Var);
            } else {
                this.R0.w(obj, fVar, b0Var);
            }
        }
    }

    private static final class b extends c implements Serializable {
        protected final c R0;
        protected final Class S0;

        protected b(c cVar, Class cls) {
            super(cVar);
            this.R0 = cVar;
            this.S0 = cls;
        }

        /* renamed from: C */
        public b t(l lVar) {
            return new b(this.R0.t(lVar), this.S0);
        }

        public void h(o oVar) {
            this.R0.h(oVar);
        }

        public void i(o oVar) {
            this.R0.i(oVar);
        }

        public void u(Object obj, f fVar, b0 b0Var) {
            Class K = b0Var.K();
            if (K == null || this.S0.isAssignableFrom(K)) {
                this.R0.u(obj, fVar, b0Var);
            } else {
                this.R0.x(obj, fVar, b0Var);
            }
        }

        public void v(Object obj, f fVar, b0 b0Var) {
            Class K = b0Var.K();
            if (K == null || this.S0.isAssignableFrom(K)) {
                this.R0.v(obj, fVar, b0Var);
            } else {
                this.R0.w(obj, fVar, b0Var);
            }
        }
    }

    public static c a(c cVar, Class[] clsArr) {
        if (clsArr.length == 1) {
            return new b(cVar, clsArr[0]);
        }
        return new a(cVar, clsArr);
    }
}
