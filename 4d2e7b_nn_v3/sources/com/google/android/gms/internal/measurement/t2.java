package com.google.android.gms.internal.measurement;

import java.util.List;

final class t2 implements x4 {

    /* renamed from: a  reason: collision with root package name */
    private final zzjm f7319a;

    private t2(zzjm zzjm) {
        zzkn.zzf(zzjm, "output");
        this.f7319a = zzjm;
        zzjm.zza = this;
    }

    public static t2 K(zzjm zzjm) {
        t2 t2Var = zzjm.zza;
        if (t2Var != null) {
            return t2Var;
        }
        return new t2(zzjm);
    }

    public final void A(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).intValue();
                i12 += 4;
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                this.f7319a.zzg(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f7319a.zzf(i10, ((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    public final void B(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Double) list.get(i13)).doubleValue();
                i12 += 8;
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                this.f7319a.zzi(Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f7319a.zzh(i10, Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
            i11++;
        }
    }

    public final void C(int i10, long j10) {
        this.f7319a.zzr(i10, j10);
    }

    public final void D(int i10) {
        this.f7319a.zzo(i10, 3);
    }

    public final void E(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Float) list.get(i13)).floatValue();
                i12 += 4;
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                this.f7319a.zzg(Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f7319a.zzf(i10, Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
            i11++;
        }
    }

    public final void F(int i10, long j10) {
        this.f7319a.zzh(i10, j10);
    }

    public final void G(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                long longValue = ((Long) list.get(i13)).longValue();
                i12 += zzjm.zzB((longValue >> 63) ^ (longValue + longValue));
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                zzjm zzjm = this.f7319a;
                long longValue2 = ((Long) list.get(i11)).longValue();
                zzjm.zzs((longValue2 >> 63) ^ (longValue2 + longValue2));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            zzjm zzjm2 = this.f7319a;
            long longValue3 = ((Long) list.get(i11)).longValue();
            zzjm2.zzr(i10, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i11++;
        }
    }

    public final void H(int i10, Object obj, w3 w3Var) {
        zzlm zzlm = (zzlm) obj;
        s2 s2Var = (s2) this.f7319a;
        s2Var.zzq((i10 << 3) | 2);
        s2Var.zzq(((zzio) zzlm).zzbr(w3Var));
        w3Var.f(zzlm, s2Var.zza);
    }

    public final void I(int i10, long j10) {
        this.f7319a.zzr(i10, (j10 >> 63) ^ (j10 + j10));
    }

    public final void J(int i10) {
        this.f7319a.zzo(i10, 4);
    }

    public final void a(int i10, int i11) {
        this.f7319a.zzp(i10, i11);
    }

    public final void b(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).longValue();
                i12 += 8;
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                this.f7319a.zzi(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f7319a.zzh(i10, ((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    public final void c(int i10, List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f7319a.zze(i10, (zzje) list.get(i11));
        }
    }

    public final void d(int i10, int i11) {
        this.f7319a.zzf(i10, i11);
    }

    public final void e(int i10, boolean z10) {
        this.f7319a.zzd(i10, z10);
    }

    public final void f(int i10, int i11) {
        this.f7319a.zzp(i10, (i11 >> 31) ^ (i11 + i11));
    }

    public final void g(int i10, String str) {
        this.f7319a.zzm(i10, str);
    }

    public final void h(int i10, long j10) {
        this.f7319a.zzr(i10, j10);
    }

    public final void i(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Boolean) list.get(i13)).booleanValue();
                i12++;
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                this.f7319a.zzb(((Boolean) list.get(i11)).booleanValue() ? (byte) 1 : 0);
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f7319a.zzd(i10, ((Boolean) list.get(i11)).booleanValue());
            i11++;
        }
    }

    public final void j(int i10, long j10) {
        this.f7319a.zzh(i10, j10);
    }

    public final void k(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzjm.zzA(((Integer) list.get(i13)).intValue());
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                this.f7319a.zzq(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f7319a.zzp(i10, ((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    public final void l(int i10, Object obj, w3 w3Var) {
        zzjm zzjm = this.f7319a;
        zzjm.zzo(i10, 3);
        w3Var.f((zzlm) obj, zzjm.zza);
        zzjm.zzo(i10, 4);
    }

    public final void m(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).intValue();
                i12 += 4;
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                this.f7319a.zzg(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f7319a.zzf(i10, ((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    public final void n(int i10, zzje zzje) {
        this.f7319a.zze(i10, zzje);
    }

    public final void o(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzjm.zzv(((Integer) list.get(i13)).intValue());
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                this.f7319a.zzk(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f7319a.zzj(i10, ((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    public final void p(int i10, int i11) {
        this.f7319a.zzj(i10, i11);
    }

    public final void q(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzjm.zzv(((Integer) list.get(i13)).intValue());
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                this.f7319a.zzk(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f7319a.zzj(i10, ((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    public final void r(int i10, int i11) {
        this.f7319a.zzj(i10, i11);
    }

    public final void s(int i10, List list) {
        int i11 = 0;
        if (list instanceof zzku) {
            zzku zzku = (zzku) list;
            while (i11 < list.size()) {
                Object zzf = zzku.zzf(i11);
                if (zzf instanceof String) {
                    this.f7319a.zzm(i10, (String) zzf);
                } else {
                    this.f7319a.zze(i10, (zzje) zzf);
                }
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f7319a.zzm(i10, (String) list.get(i11));
            i11++;
        }
    }

    public final void t(int i10, double d10) {
        this.f7319a.zzh(i10, Double.doubleToRawLongBits(d10));
    }

    public final void u(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).longValue();
                i12 += 8;
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                this.f7319a.zzi(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f7319a.zzh(i10, ((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    public final void v(int i10, int i11) {
        this.f7319a.zzf(i10, i11);
    }

    public final void w(int i10, float f10) {
        this.f7319a.zzf(i10, Float.floatToRawIntBits(f10));
    }

    public final void x(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                int intValue = ((Integer) list.get(i13)).intValue();
                i12 += zzjm.zzA((intValue >> 31) ^ (intValue + intValue));
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                zzjm zzjm = this.f7319a;
                int intValue2 = ((Integer) list.get(i11)).intValue();
                zzjm.zzq((intValue2 >> 31) ^ (intValue2 + intValue2));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            zzjm zzjm2 = this.f7319a;
            int intValue3 = ((Integer) list.get(i11)).intValue();
            zzjm2.zzp(i10, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i11++;
        }
    }

    public final void y(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzjm.zzB(((Long) list.get(i13)).longValue());
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                this.f7319a.zzs(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f7319a.zzr(i10, ((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    public final void z(int i10, List list, boolean z10) {
        int i11 = 0;
        if (z10) {
            this.f7319a.zzo(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                i12 += zzjm.zzB(((Long) list.get(i13)).longValue());
            }
            this.f7319a.zzq(i12);
            while (i11 < list.size()) {
                this.f7319a.zzs(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.f7319a.zzr(i10, ((Long) list.get(i11)).longValue());
            i11++;
        }
    }
}
