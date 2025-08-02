package com.google.android.gms.internal.fido;

import java.math.RoundingMode;

class c0 extends zzch {

    /* renamed from: a  reason: collision with root package name */
    final z f7054a;

    /* renamed from: b  reason: collision with root package name */
    final Character f7055b;

    /* renamed from: c  reason: collision with root package name */
    private volatile zzch f7056c;

    c0(z zVar, Character ch) {
        this.f7054a = zVar;
        if (ch == null || !zVar.c('=')) {
            this.f7055b = ch;
        } else {
            throw new IllegalArgumentException(zzaq.zza("Padding character %s was already in alphabet", ch));
        }
    }

    /* access modifiers changed from: package-private */
    public zzch a(z zVar, Character ch) {
        return new c0(zVar, ch);
    }

    /* access modifiers changed from: package-private */
    public final void b(Appendable appendable, byte[] bArr, int i10, int i11) {
        boolean z10;
        zzap.zze(i10, i10 + i11, bArr.length);
        int i12 = 0;
        if (i11 <= this.f7054a.f7107f) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzap.zzc(z10);
        long j10 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            j10 = (j10 | ((long) (bArr[i10 + i13] & 255))) << 8;
        }
        int i14 = ((i11 + 1) * 8) - this.f7054a.f7105d;
        while (i12 < i11 * 8) {
            z zVar = this.f7054a;
            appendable.append(zVar.a(zVar.f7104c & ((int) (j10 >>> (i14 - i12)))));
            i12 += this.f7054a.f7105d;
        }
        if (this.f7055b != null) {
            while (i12 < this.f7054a.f7107f * 8) {
                this.f7055b.charValue();
                appendable.append('=');
                i12 += this.f7054a.f7105d;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (this.f7054a.equals(c0Var.f7054a)) {
                Character ch = this.f7055b;
                Character ch2 = c0Var.f7055b;
                if (ch == ch2) {
                    return true;
                }
                if (ch == null || !ch.equals(ch2)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        int hashCode = this.f7054a.hashCode();
        Character ch = this.f7055b;
        if (ch == null) {
            i10 = 0;
        } else {
            i10 = ch.hashCode();
        }
        return hashCode ^ i10;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BaseEncoding.");
        sb2.append(this.f7054a);
        if (8 % this.f7054a.f7105d != 0) {
            if (this.f7055b == null) {
                sb2.append(".omitPadding()");
            } else {
                sb2.append(".withPadChar('");
                sb2.append(this.f7055b);
                sb2.append("')");
            }
        }
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public void zzb(Appendable appendable, byte[] bArr, int i10, int i11) {
        int i12 = 0;
        zzap.zze(0, i11, bArr.length);
        while (i12 < i11) {
            b(appendable, bArr, i12, Math.min(this.f7054a.f7107f, i11 - i12));
            i12 += this.f7054a.f7107f;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i10) {
        z zVar = this.f7054a;
        return zVar.f7106e * zzcj.zza(i10, zVar.f7107f, RoundingMode.CEILING);
    }

    public final zzch zzd() {
        zzch zzch = this.f7056c;
        if (zzch == null) {
            z b10 = this.f7054a.b();
            if (b10 == this.f7054a) {
                zzch = this;
            } else {
                zzch = a(b10, this.f7055b);
            }
            this.f7056c = zzch;
        }
        return zzch;
    }

    c0(String str, String str2, Character ch) {
        this(new z(str, str2.toCharArray()), ch);
    }
}
