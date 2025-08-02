package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.ser.i;
import i8.b;
import java.net.InetAddress;
import q8.g;

public class p extends g0 implements i {

    /* renamed from: c  reason: collision with root package name */
    protected final boolean f5565c;

    public p() {
        this(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.o a(com.fasterxml.jackson.databind.b0 r2, com.fasterxml.jackson.databind.d r3) {
        /*
            r1 = this;
            java.lang.Class r0 = r1.c()
            com.fasterxml.jackson.annotation.i$d r2 = r1.q(r2, r3, r0)
            if (r2 == 0) goto L_0x001a
            com.fasterxml.jackson.annotation.i$c r2 = r2.i()
            boolean r3 = r2.a()
            if (r3 != 0) goto L_0x0018
            com.fasterxml.jackson.annotation.i$c r3 = com.fasterxml.jackson.annotation.i.c.ARRAY
            if (r2 != r3) goto L_0x001a
        L_0x0018:
            r2 = 1
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            boolean r3 = r1.f5565c
            if (r2 == r3) goto L_0x0025
            com.fasterxml.jackson.databind.ser.std.p r3 = new com.fasterxml.jackson.databind.ser.std.p
            r3.<init>(r2)
            return r3
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.p.a(com.fasterxml.jackson.databind.b0, com.fasterxml.jackson.databind.d):com.fasterxml.jackson.databind.o");
    }

    /* renamed from: x */
    public void f(InetAddress inetAddress, f fVar, b0 b0Var) {
        String str;
        if (this.f5565c) {
            str = inetAddress.getHostAddress();
        } else {
            str = inetAddress.toString().trim();
            int indexOf = str.indexOf(47);
            if (indexOf >= 0) {
                if (indexOf == 0) {
                    str = str.substring(1);
                } else {
                    str = str.substring(0, indexOf);
                }
            }
        }
        fVar.s0(str);
    }

    /* renamed from: y */
    public void h(InetAddress inetAddress, f fVar, b0 b0Var, g gVar) {
        b g10 = gVar.g(fVar, gVar.f(inetAddress, InetAddress.class, k.VALUE_STRING));
        f(inetAddress, fVar, b0Var);
        gVar.h(fVar, g10);
    }

    public p(boolean z10) {
        super(InetAddress.class);
        this.f5565c = z10;
    }
}
