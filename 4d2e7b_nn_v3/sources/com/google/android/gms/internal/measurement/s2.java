package com.google.android.gms.internal.measurement;

final class s2 extends zzjm {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f7310a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7311b;

    /* renamed from: c  reason: collision with root package name */
    private int f7312c;

    s2(byte[] bArr, int i10, int i11) {
        super((zzjl) null);
        if (bArr != null) {
            int length = bArr.length;
            if (((length - i11) | i11) >= 0) {
                this.f7310a = bArr;
                this.f7312c = 0;
                this.f7311b = i11;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i11)}));
        }
        throw new NullPointerException("buffer");
    }

    public final void a(byte[] bArr, int i10, int i11) {
        try {
            System.arraycopy(bArr, 0, this.f7310a, this.f7312c, i11);
            this.f7312c += i11;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f7312c), Integer.valueOf(this.f7311b), Integer.valueOf(i11)}), e10);
        }
    }

    public final void b(String str) {
        int i10 = this.f7312c;
        try {
            int zzA = zzjm.zzA(str.length() * 3);
            int zzA2 = zzjm.zzA(str.length());
            if (zzA2 == zzA) {
                int i11 = i10 + zzA2;
                this.f7312c = i11;
                int b10 = w4.b(str, this.f7310a, i11, this.f7311b - i11);
                this.f7312c = i10;
                zzq((b10 - i10) - zzA2);
                this.f7312c = b10;
                return;
            }
            zzq(w4.c(str));
            byte[] bArr = this.f7310a;
            int i12 = this.f7312c;
            this.f7312c = w4.b(str, bArr, i12, this.f7311b - i12);
        } catch (v4 e10) {
            this.f7312c = i10;
            zzE(str, e10);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzjk(e11);
        }
    }

    public final int zza() {
        return this.f7311b - this.f7312c;
    }

    public final void zzb(byte b10) {
        try {
            byte[] bArr = this.f7310a;
            int i10 = this.f7312c;
            this.f7312c = i10 + 1;
            bArr[i10] = b10;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f7312c), Integer.valueOf(this.f7311b), 1}), e10);
        }
    }

    public final void zzd(int i10, boolean z10) {
        zzq(i10 << 3);
        zzb(z10 ? (byte) 1 : 0);
    }

    public final void zze(int i10, zzje zzje) {
        zzq((i10 << 3) | 2);
        zzq(zzje.zzd());
        zzje.zzh(this);
    }

    public final void zzf(int i10, int i11) {
        zzq((i10 << 3) | 5);
        zzg(i11);
    }

    public final void zzg(int i10) {
        try {
            byte[] bArr = this.f7310a;
            int i11 = this.f7312c;
            bArr[i11] = (byte) (i10 & 255);
            bArr[i11 + 1] = (byte) ((i10 >> 8) & 255);
            bArr[i11 + 2] = (byte) ((i10 >> 16) & 255);
            this.f7312c = i11 + 4;
            bArr[i11 + 3] = (byte) ((i10 >> 24) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f7312c), Integer.valueOf(this.f7311b), 1}), e10);
        }
    }

    public final void zzh(int i10, long j10) {
        zzq((i10 << 3) | 1);
        zzi(j10);
    }

    public final void zzi(long j10) {
        try {
            byte[] bArr = this.f7310a;
            int i10 = this.f7312c;
            bArr[i10] = (byte) (((int) j10) & 255);
            bArr[i10 + 1] = (byte) (((int) (j10 >> 8)) & 255);
            bArr[i10 + 2] = (byte) (((int) (j10 >> 16)) & 255);
            bArr[i10 + 3] = (byte) (((int) (j10 >> 24)) & 255);
            bArr[i10 + 4] = (byte) (((int) (j10 >> 32)) & 255);
            bArr[i10 + 5] = (byte) (((int) (j10 >> 40)) & 255);
            bArr[i10 + 6] = (byte) (((int) (j10 >> 48)) & 255);
            this.f7312c = i10 + 8;
            bArr[i10 + 7] = (byte) (((int) (j10 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f7312c), Integer.valueOf(this.f7311b), 1}), e10);
        }
    }

    public final void zzj(int i10, int i11) {
        zzq(i10 << 3);
        zzk(i11);
    }

    public final void zzk(int i10) {
        if (i10 >= 0) {
            zzq(i10);
        } else {
            zzs((long) i10);
        }
    }

    public final void zzl(byte[] bArr, int i10, int i11) {
        a(bArr, 0, i11);
    }

    public final void zzm(int i10, String str) {
        zzq((i10 << 3) | 2);
        b(str);
    }

    public final void zzo(int i10, int i11) {
        zzq((i10 << 3) | i11);
    }

    public final void zzp(int i10, int i11) {
        zzq(i10 << 3);
        zzq(i11);
    }

    public final void zzq(int i10) {
        while ((i10 & -128) != 0) {
            byte[] bArr = this.f7310a;
            int i11 = this.f7312c;
            this.f7312c = i11 + 1;
            bArr[i11] = (byte) ((i10 & 127) | 128);
            i10 >>>= 7;
        }
        try {
            byte[] bArr2 = this.f7310a;
            int i12 = this.f7312c;
            this.f7312c = i12 + 1;
            bArr2[i12] = (byte) i10;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f7312c), Integer.valueOf(this.f7311b), 1}), e10);
        }
    }

    public final void zzr(int i10, long j10) {
        zzq(i10 << 3);
        zzs(j10);
    }

    public final void zzs(long j10) {
        if (!zzjm.zzc || this.f7311b - this.f7312c < 10) {
            while ((j10 & -128) != 0) {
                byte[] bArr = this.f7310a;
                int i10 = this.f7312c;
                this.f7312c = i10 + 1;
                bArr[i10] = (byte) ((((int) j10) & 127) | 128);
                j10 >>>= 7;
            }
            try {
                byte[] bArr2 = this.f7310a;
                int i11 = this.f7312c;
                this.f7312c = i11 + 1;
                bArr2[i11] = (byte) ((int) j10);
            } catch (IndexOutOfBoundsException e10) {
                throw new zzjk(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f7312c), Integer.valueOf(this.f7311b), 1}), e10);
            }
        } else {
            while ((j10 & -128) != 0) {
                byte[] bArr3 = this.f7310a;
                int i12 = this.f7312c;
                this.f7312c = i12 + 1;
                r4.s(bArr3, (long) i12, (byte) ((((int) j10) & 127) | 128));
                j10 >>>= 7;
            }
            byte[] bArr4 = this.f7310a;
            int i13 = this.f7312c;
            this.f7312c = 1 + i13;
            r4.s(bArr4, (long) i13, (byte) ((int) j10));
        }
    }
}
