package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.i;
import q8.g;

public final class e extends g0 implements i {

    /* renamed from: c  reason: collision with root package name */
    protected final boolean f5546c;

    static final class a extends g0 implements i {

        /* renamed from: c  reason: collision with root package name */
        protected final boolean f5547c;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(boolean r3) {
            /*
                r2 = this;
                if (r3 == 0) goto L_0x0005
                java.lang.Class r0 = java.lang.Boolean.TYPE
                goto L_0x0007
            L_0x0005:
                java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            L_0x0007:
                r1 = 0
                r2.<init>(r0, r1)
                r2.f5547c = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.e.a.<init>(boolean):void");
        }

        public o a(b0 b0Var, d dVar) {
            i.d q10 = q(b0Var, dVar, Boolean.class);
            if (q10 == null || q10.i().a()) {
                return this;
            }
            return new e(this.f5547c);
        }

        public void f(Object obj, f fVar, b0 b0Var) {
            fVar.X(Boolean.FALSE.equals(obj) ^ true ? 1 : 0);
        }

        public final void h(Object obj, f fVar, b0 b0Var, g gVar) {
            fVar.O(Boolean.TRUE.equals(obj));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0005
            java.lang.Class r0 = java.lang.Boolean.TYPE
            goto L_0x0007
        L_0x0005:
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
        L_0x0007:
            r1 = 0
            r2.<init>(r0, r1)
            r2.f5546c = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.e.<init>(boolean):void");
    }

    public o a(b0 b0Var, d dVar) {
        i.d q10 = q(b0Var, dVar, c());
        if (q10 != null) {
            i.c i10 = q10.i();
            if (i10.a()) {
                return new a(this.f5546c);
            }
            if (i10 == i.c.STRING) {
                return new l0(this.f5555a);
            }
        }
        return this;
    }

    public void f(Object obj, f fVar, b0 b0Var) {
        fVar.O(Boolean.TRUE.equals(obj));
    }

    public final void h(Object obj, f fVar, b0 b0Var, g gVar) {
        fVar.O(Boolean.TRUE.equals(obj));
    }
}
