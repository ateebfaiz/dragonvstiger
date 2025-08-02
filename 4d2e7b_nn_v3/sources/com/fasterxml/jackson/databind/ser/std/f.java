package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.b0;
import i8.b;
import q8.g;

public class f extends h0 {
    public f() {
        super(byte[].class);
    }

    /* renamed from: x */
    public boolean d(b0 b0Var, byte[] bArr) {
        if (bArr.length == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: y */
    public void f(byte[] bArr, com.fasterxml.jackson.core.f fVar, b0 b0Var) {
        fVar.L(b0Var.f().i(), bArr, 0, bArr.length);
    }

    /* renamed from: z */
    public void h(byte[] bArr, com.fasterxml.jackson.core.f fVar, b0 b0Var, g gVar) {
        b g10 = gVar.g(fVar, gVar.d(bArr, k.VALUE_EMBEDDED_OBJECT));
        fVar.L(b0Var.f().i(), bArr, 0, bArr.length);
        gVar.h(fVar, g10);
    }
}
