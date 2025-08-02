package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.ser.i;
import java.util.UUID;

public class o0 extends g0 implements i {

    /* renamed from: d  reason: collision with root package name */
    static final char[] f5563d = "0123456789abcdef".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    protected final Boolean f5564c;

    public o0() {
        this((Boolean) null);
    }

    private static final byte[] A(UUID uuid) {
        byte[] bArr = new byte[16];
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        x((int) (mostSignificantBits >> 32), bArr, 0);
        x((int) mostSignificantBits, bArr, 4);
        x((int) (leastSignificantBits >> 32), bArr, 8);
        x((int) leastSignificantBits, bArr, 12);
        return bArr;
    }

    private static final void x(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) (i10 >> 24);
        bArr[i11 + 1] = (byte) (i10 >> 16);
        bArr[i11 + 2] = (byte) (i10 >> 8);
        bArr[i11 + 3] = (byte) i10;
    }

    private static void y(int i10, char[] cArr, int i11) {
        z(i10 >> 16, cArr, i11);
        z(i10, cArr, i11 + 4);
    }

    private static void z(int i10, char[] cArr, int i11) {
        char[] cArr2 = f5563d;
        cArr[i11] = cArr2[(i10 >> 12) & 15];
        cArr[i11 + 1] = cArr2[(i10 >> 8) & 15];
        cArr[i11 + 2] = cArr2[(i10 >> 4) & 15];
        cArr[i11 + 3] = cArr2[i10 & 15];
    }

    /* access modifiers changed from: protected */
    public boolean B(f fVar) {
        Boolean bool = this.f5564c;
        if (bool != null) {
            return bool.booleanValue();
        }
        return fVar.k();
    }

    /* renamed from: C */
    public boolean d(b0 b0Var, UUID uuid) {
        if (uuid.getLeastSignificantBits() == 0 && uuid.getMostSignificantBits() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: D */
    public void f(UUID uuid, f fVar, b0 b0Var) {
        if (B(fVar)) {
            fVar.M(A(uuid));
            return;
        }
        char[] cArr = new char[36];
        long mostSignificantBits = uuid.getMostSignificantBits();
        y((int) (mostSignificantBits >> 32), cArr, 0);
        cArr[8] = '-';
        int i10 = (int) mostSignificantBits;
        z(i10 >>> 16, cArr, 9);
        cArr[13] = '-';
        z(i10, cArr, 14);
        cArr[18] = '-';
        long leastSignificantBits = uuid.getLeastSignificantBits();
        z((int) (leastSignificantBits >>> 48), cArr, 19);
        cArr[23] = '-';
        z((int) (leastSignificantBits >>> 32), cArr, 24);
        y((int) leastSignificantBits, cArr, 28);
        fVar.t0(cArr, 0, 36);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.o a(com.fasterxml.jackson.databind.b0 r2, com.fasterxml.jackson.databind.d r3) {
        /*
            r1 = this;
            java.lang.Class r0 = r1.c()
            com.fasterxml.jackson.annotation.i$d r2 = r1.q(r2, r3, r0)
            if (r2 == 0) goto L_0x001c
            com.fasterxml.jackson.annotation.i$c r2 = r2.i()
            com.fasterxml.jackson.annotation.i$c r3 = com.fasterxml.jackson.annotation.i.c.BINARY
            if (r2 != r3) goto L_0x0015
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            goto L_0x001d
        L_0x0015:
            com.fasterxml.jackson.annotation.i$c r3 = com.fasterxml.jackson.annotation.i.c.STRING
            if (r2 != r3) goto L_0x001c
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            goto L_0x001d
        L_0x001c:
            r2 = 0
        L_0x001d:
            java.lang.Boolean r3 = r1.f5564c
            boolean r3 = java.util.Objects.equals(r2, r3)
            if (r3 != 0) goto L_0x002b
            com.fasterxml.jackson.databind.ser.std.o0 r3 = new com.fasterxml.jackson.databind.ser.std.o0
            r3.<init>(r2)
            return r3
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.o0.a(com.fasterxml.jackson.databind.b0, com.fasterxml.jackson.databind.d):com.fasterxml.jackson.databind.o");
    }

    protected o0(Boolean bool) {
        super(UUID.class);
        this.f5564c = bool;
    }
}
