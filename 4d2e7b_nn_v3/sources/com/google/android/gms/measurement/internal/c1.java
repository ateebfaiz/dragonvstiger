package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

final class c1 {
    private long A;
    private String B;
    private boolean C;
    private long D;
    private long E;

    /* renamed from: a  reason: collision with root package name */
    private final zzfr f7412a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7413b;

    /* renamed from: c  reason: collision with root package name */
    private String f7414c;

    /* renamed from: d  reason: collision with root package name */
    private String f7415d;

    /* renamed from: e  reason: collision with root package name */
    private String f7416e;

    /* renamed from: f  reason: collision with root package name */
    private String f7417f;

    /* renamed from: g  reason: collision with root package name */
    private long f7418g;

    /* renamed from: h  reason: collision with root package name */
    private long f7419h;

    /* renamed from: i  reason: collision with root package name */
    private long f7420i;

    /* renamed from: j  reason: collision with root package name */
    private String f7421j;

    /* renamed from: k  reason: collision with root package name */
    private long f7422k;

    /* renamed from: l  reason: collision with root package name */
    private String f7423l;

    /* renamed from: m  reason: collision with root package name */
    private long f7424m;

    /* renamed from: n  reason: collision with root package name */
    private long f7425n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f7426o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f7427p;

    /* renamed from: q  reason: collision with root package name */
    private String f7428q;

    /* renamed from: r  reason: collision with root package name */
    private Boolean f7429r;

    /* renamed from: s  reason: collision with root package name */
    private long f7430s;

    /* renamed from: t  reason: collision with root package name */
    private List f7431t;

    /* renamed from: u  reason: collision with root package name */
    private String f7432u;

    /* renamed from: v  reason: collision with root package name */
    private long f7433v;

    /* renamed from: w  reason: collision with root package name */
    private long f7434w;

    /* renamed from: x  reason: collision with root package name */
    private long f7435x;

    /* renamed from: y  reason: collision with root package name */
    private long f7436y;

    /* renamed from: z  reason: collision with root package name */
    private long f7437z;

    c1(zzfr zzfr, String str) {
        Preconditions.checkNotNull(zzfr);
        Preconditions.checkNotEmpty(str);
        this.f7412a = zzfr;
        this.f7413b = str;
        zzfr.zzaz().zzg();
    }

    public final long A() {
        this.f7412a.zzaz().zzg();
        return 0;
    }

    public final void B(long j10) {
        boolean z10;
        boolean z11 = false;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        this.f7412a.zzaz().zzg();
        boolean z12 = this.C;
        if (this.f7418g != j10) {
            z11 = true;
        }
        this.C = z12 | z11;
        this.f7418g = j10;
    }

    public final void C(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.f7419h != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.f7419h = j10;
    }

    public final void D(boolean z10) {
        boolean z11;
        this.f7412a.zzaz().zzg();
        boolean z12 = this.C;
        if (this.f7426o != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.C = z12 | z11;
        this.f7426o = z10;
    }

    public final void E(Boolean bool) {
        this.f7412a.zzaz().zzg();
        this.C |= !zzg.zza(this.f7429r, bool);
        this.f7429r = bool;
    }

    public final void F(String str) {
        this.f7412a.zzaz().zzg();
        this.C |= !zzg.zza(this.f7416e, str);
        this.f7416e = str;
    }

    public final void G(List list) {
        ArrayList arrayList;
        this.f7412a.zzaz().zzg();
        if (!zzg.zza(this.f7431t, list)) {
            this.C = true;
            if (list != null) {
                arrayList = new ArrayList(list);
            } else {
                arrayList = null;
            }
            this.f7431t = arrayList;
        }
    }

    public final void H(String str) {
        this.f7412a.zzaz().zzg();
        this.C |= !zzg.zza(this.f7432u, str);
        this.f7432u = str;
    }

    public final boolean I() {
        this.f7412a.zzaz().zzg();
        return this.f7427p;
    }

    public final boolean J() {
        this.f7412a.zzaz().zzg();
        return this.f7426o;
    }

    public final boolean K() {
        this.f7412a.zzaz().zzg();
        return this.C;
    }

    public final long L() {
        this.f7412a.zzaz().zzg();
        return this.f7422k;
    }

    public final long M() {
        this.f7412a.zzaz().zzg();
        return this.D;
    }

    public final long N() {
        this.f7412a.zzaz().zzg();
        return this.f7436y;
    }

    public final long O() {
        this.f7412a.zzaz().zzg();
        return this.f7437z;
    }

    public final long P() {
        this.f7412a.zzaz().zzg();
        return this.f7435x;
    }

    public final long Q() {
        this.f7412a.zzaz().zzg();
        return this.f7434w;
    }

    public final long R() {
        this.f7412a.zzaz().zzg();
        return this.A;
    }

    public final long S() {
        this.f7412a.zzaz().zzg();
        return this.f7433v;
    }

    public final long T() {
        this.f7412a.zzaz().zzg();
        return this.f7425n;
    }

    public final long U() {
        this.f7412a.zzaz().zzg();
        return this.f7430s;
    }

    public final long V() {
        this.f7412a.zzaz().zzg();
        return this.E;
    }

    public final long W() {
        this.f7412a.zzaz().zzg();
        return this.f7424m;
    }

    public final long X() {
        this.f7412a.zzaz().zzg();
        return this.f7420i;
    }

    public final long Y() {
        this.f7412a.zzaz().zzg();
        return this.f7418g;
    }

    public final long Z() {
        this.f7412a.zzaz().zzg();
        return this.f7419h;
    }

    public final String a() {
        this.f7412a.zzaz().zzg();
        return this.f7416e;
    }

    public final Boolean a0() {
        this.f7412a.zzaz().zzg();
        return this.f7429r;
    }

    public final String b() {
        this.f7412a.zzaz().zzg();
        return this.f7432u;
    }

    public final String b0() {
        this.f7412a.zzaz().zzg();
        return this.f7428q;
    }

    public final List c() {
        this.f7412a.zzaz().zzg();
        return this.f7431t;
    }

    public final String c0() {
        this.f7412a.zzaz().zzg();
        String str = this.B;
        y((String) null);
        return str;
    }

    public final void d() {
        this.f7412a.zzaz().zzg();
        this.C = false;
    }

    public final String d0() {
        this.f7412a.zzaz().zzg();
        return this.f7413b;
    }

    public final void e() {
        this.f7412a.zzaz().zzg();
        long j10 = this.f7418g + 1;
        if (j10 > 2147483647L) {
            this.f7412a.zzay().zzk().zzb("Bundle index overflow. appId", zzeh.zzn(this.f7413b));
            j10 = 0;
        }
        this.C = true;
        this.f7418g = j10;
    }

    public final String e0() {
        this.f7412a.zzaz().zzg();
        return this.f7414c;
    }

    public final void f(String str) {
        this.f7412a.zzaz().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.C |= true ^ zzg.zza(this.f7428q, str);
        this.f7428q = str;
    }

    public final String f0() {
        this.f7412a.zzaz().zzg();
        return this.f7423l;
    }

    public final void g(boolean z10) {
        boolean z11;
        this.f7412a.zzaz().zzg();
        boolean z12 = this.C;
        if (this.f7427p != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.C = z12 | z11;
        this.f7427p = z10;
    }

    public final String g0() {
        this.f7412a.zzaz().zzg();
        return this.f7421j;
    }

    public final void h(String str) {
        this.f7412a.zzaz().zzg();
        this.C |= !zzg.zza(this.f7414c, str);
        this.f7414c = str;
    }

    public final String h0() {
        this.f7412a.zzaz().zzg();
        return this.f7417f;
    }

    public final void i(String str) {
        this.f7412a.zzaz().zzg();
        this.C |= !zzg.zza(this.f7423l, str);
        this.f7423l = str;
    }

    public final String i0() {
        this.f7412a.zzaz().zzg();
        return this.f7415d;
    }

    public final void j(String str) {
        this.f7412a.zzaz().zzg();
        this.C |= !zzg.zza(this.f7421j, str);
        this.f7421j = str;
    }

    public final String j0() {
        this.f7412a.zzaz().zzg();
        return this.B;
    }

    public final void k(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.f7422k != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.f7422k = j10;
    }

    public final void l(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.D != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.D = j10;
    }

    public final void m(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.f7436y != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.f7436y = j10;
    }

    public final void n(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.f7437z != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.f7437z = j10;
    }

    public final void o(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.f7435x != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.f7435x = j10;
    }

    public final void p(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.f7434w != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.f7434w = j10;
    }

    public final void q(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.A != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.A = j10;
    }

    public final void r(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.f7433v != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.f7433v = j10;
    }

    public final void s(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.f7425n != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.f7425n = j10;
    }

    public final void t(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.f7430s != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.f7430s = j10;
    }

    public final void u(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.E != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.E = j10;
    }

    public final void v(String str) {
        this.f7412a.zzaz().zzg();
        this.C |= !zzg.zza(this.f7417f, str);
        this.f7417f = str;
    }

    public final void w(String str) {
        this.f7412a.zzaz().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.C |= true ^ zzg.zza(this.f7415d, str);
        this.f7415d = str;
    }

    public final void x(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.f7424m != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.f7424m = j10;
    }

    public final void y(String str) {
        this.f7412a.zzaz().zzg();
        this.C |= !zzg.zza(this.B, str);
        this.B = str;
    }

    public final void z(long j10) {
        boolean z10;
        this.f7412a.zzaz().zzg();
        boolean z11 = this.C;
        if (this.f7420i != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.C = z11 | z10;
        this.f7420i = j10;
    }
}
