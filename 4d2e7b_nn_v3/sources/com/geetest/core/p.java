package com.geetest.core;

import android.util.Base64;
import java.security.cert.CertificateParsingException;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f6123a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6124b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6125c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f6126d;

    public p(v vVar) throws CertificateParsingException {
        if (vVar instanceof s0) {
            s0 s0Var = (s0) vVar;
            this.f6123a = c.b(s0Var.a(0));
            this.f6124b = c.a(s0Var.a(1));
            this.f6125c = c.c(s0Var.a(2));
            if (s0Var.m() == 3) {
                this.f6126d = null;
            } else {
                this.f6126d = c.b(s0Var.a(3));
            }
        } else {
            throw new CertificateParsingException("Expected sequence for root of trust, found " + vVar.getClass().getName());
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Verified boot Key: ");
        sb2.append(Base64.encodeToString(this.f6123a, 0));
        sb2.append(" (base64)");
        sb2.append(10);
        sb2.append("Device locked: ");
        sb2.append(this.f6124b);
        sb2.append(10);
        sb2.append("Verified boot state: ");
        int i10 = this.f6125c;
        if (i10 == 0) {
            str = "Verified";
        } else if (i10 == 1) {
            str = "Self-signed";
        } else if (i10 == 2) {
            str = "Unverified";
        } else if (i10 != 3) {
            str = "Unknown (" + i10 + ")";
        } else {
            str = "Failed";
        }
        sb2.append(str);
        sb2.append(10);
        if (this.f6126d != null) {
            sb2.append("Verified boot hash: ");
            sb2.append(Base64.encodeToString(this.f6126d, 0));
            sb2.append(" (base64)");
        }
        return sb2.toString();
    }

    public p(byte[] bArr, boolean z10, int i10, byte[] bArr2) {
        this.f6123a = bArr;
        this.f6124b = z10;
        this.f6125c = i10;
        this.f6126d = bArr2;
    }
}
