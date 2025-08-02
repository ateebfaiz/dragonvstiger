package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.i;
import java.util.Collection;

public abstract class b0 extends h0 implements i {

    /* renamed from: c  reason: collision with root package name */
    protected final Boolean f5528c;

    protected b0(Class cls) {
        super(cls, false);
        this.f5528c = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.o a(com.fasterxml.jackson.databind.b0 r6, com.fasterxml.jackson.databind.d r7) {
        /*
            r5 = this;
            r0 = 0
            if (r7 == 0) goto L_0x0018
            com.fasterxml.jackson.databind.b r1 = r6.L()
            com.fasterxml.jackson.databind.introspect.i r2 = r7.b()
            if (r2 == 0) goto L_0x0018
            java.lang.Object r1 = r1.f(r2)
            if (r1 == 0) goto L_0x0018
            com.fasterxml.jackson.databind.o r1 = r6.i0(r2, r1)
            goto L_0x0019
        L_0x0018:
            r1 = r0
        L_0x0019:
            java.lang.Class r2 = r5.c()
            com.fasterxml.jackson.annotation.i$d r2 = r5.q(r6, r7, r2)
            if (r2 == 0) goto L_0x002a
            com.fasterxml.jackson.annotation.i$a r3 = com.fasterxml.jackson.annotation.i.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            java.lang.Boolean r2 = r2.e(r3)
            goto L_0x002b
        L_0x002a:
            r2 = r0
        L_0x002b:
            com.fasterxml.jackson.databind.o r1 = r5.n(r6, r7, r1)
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r1 != 0) goto L_0x0037
            com.fasterxml.jackson.databind.o r1 = r6.z(r3, r7)
        L_0x0037:
            boolean r4 = r5.u(r1)
            if (r4 == 0) goto L_0x004b
            java.lang.Boolean r6 = r5.f5528c
            boolean r6 = java.util.Objects.equals(r2, r6)
            if (r6 == 0) goto L_0x0046
            return r5
        L_0x0046:
            com.fasterxml.jackson.databind.o r6 = r5.x(r7, r2)
            return r6
        L_0x004b:
            com.fasterxml.jackson.databind.ser.std.j r7 = new com.fasterxml.jackson.databind.ser.std.j
            com.fasterxml.jackson.databind.j r6 = r6.d(r3)
            r2 = 1
            r7.<init>(r6, r2, r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.b0.a(com.fasterxml.jackson.databind.b0, com.fasterxml.jackson.databind.d):com.fasterxml.jackson.databind.o");
    }

    public abstract o x(d dVar, Boolean bool);

    /* renamed from: y */
    public boolean d(com.fasterxml.jackson.databind.b0 b0Var, Collection collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }

    protected b0(b0 b0Var, Boolean bool) {
        super((h0) b0Var);
        this.f5528c = bool;
    }
}
