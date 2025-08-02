package com.google.android.gms.internal.measurement;

import com.alibaba.pdns.f;
import com.google.android.games.paddleboat.GameControllerManager;
import java.util.List;

public final class zzgd extends zzkf implements zzln {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final zzgd zzd;
    private String zzA = "";
    private long zzB;
    private int zzC;
    private String zzD = "";
    private String zzE = "";
    private boolean zzF;
    /* access modifiers changed from: private */
    public zzkm zzG = zzkf.zzbE();
    private String zzH = "";
    private int zzI;
    private int zzJ;
    private int zzK;
    private String zzL = "";
    private long zzM;
    private long zzN;
    private String zzO = "";
    private String zzP = "";
    private int zzQ;
    private String zzR = "";
    private zzgg zzS;
    private zzkk zzT = zzkf.zzbB();
    private long zzU;
    private long zzV;
    private String zzW = "";
    private String zzX = "";
    private int zzY;
    private boolean zzZ;
    private String zzaa = "";
    private boolean zzab;
    private zzfz zzac;
    private String zzad = "";
    private zzkm zzae = zzkf.zzbE();
    private String zzaf = "";
    private int zze;
    private int zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public zzkm zzh = zzkf.zzbE();
    private zzkm zzi = zzkf.zzbE();
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";
    private int zzs;
    private String zzt = "";
    private String zzu = "";
    private String zzv = "";
    private long zzw;
    private long zzx;
    private String zzy = "";
    private boolean zzz;

    static {
        zzgd zzgd = new zzgd();
        zzd = zzgd;
        zzkf.zzbL(zzgd.class, zzgd);
    }

    private zzgd() {
    }

    static /* synthetic */ void zzP(zzgd zzgd) {
        zzgd.zze &= Integer.MAX_VALUE;
        zzgd.zzO = zzd.zzO;
    }

    static /* synthetic */ void zzQ(zzgd zzgd, int i10) {
        zzgd.zzf |= 2;
        zzgd.zzQ = i10;
    }

    static /* synthetic */ void zzR(zzgd zzgd, int i10, zzft zzft) {
        zzft.getClass();
        zzgd.zzbP();
        zzgd.zzh.set(i10, zzft);
    }

    static /* synthetic */ void zzS(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zzf |= 4;
        zzgd.zzR = str;
    }

    static /* synthetic */ void zzT(zzgd zzgd, zzgg zzgg) {
        zzgg.getClass();
        zzgd.zzS = zzgg;
        zzgd.zzf |= 8;
    }

    static /* synthetic */ void zzU(zzgd zzgd, Iterable iterable) {
        int i10;
        zzkk zzkk = zzgd.zzT;
        if (!zzkk.zzc()) {
            int size = zzkk.size();
            if (size == 0) {
                i10 = 10;
            } else {
                i10 = size + size;
            }
            zzgd.zzT = zzkk.zzg(i10);
        }
        zzio.zzbt(iterable, zzgd.zzT);
    }

    static /* synthetic */ void zzV(zzgd zzgd, zzft zzft) {
        zzft.getClass();
        zzgd.zzbP();
        zzgd.zzh.add(zzft);
    }

    static /* synthetic */ void zzW(zzgd zzgd, long j10) {
        zzgd.zzf |= 16;
        zzgd.zzU = j10;
    }

    static /* synthetic */ void zzX(zzgd zzgd, long j10) {
        zzgd.zzf |= 32;
        zzgd.zzV = j10;
    }

    static /* synthetic */ void zzY(zzgd zzgd, String str) {
        zzgd.zzf |= 128;
        zzgd.zzX = str;
    }

    static /* synthetic */ void zzZ(zzgd zzgd, Iterable iterable) {
        zzgd.zzbP();
        zzio.zzbt(iterable, zzgd.zzh);
    }

    static /* synthetic */ void zzaA(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 8192;
        zzgd.zzv = str;
    }

    static /* synthetic */ void zzaB(zzgd zzgd, long j10) {
        zzgd.zze |= 16384;
        zzgd.zzw = j10;
    }

    static /* synthetic */ void zzaC(zzgd zzgd, long j10) {
        zzgd.zze |= 32768;
        zzgd.zzx = 74029;
    }

    static /* synthetic */ void zzaD(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 65536;
        zzgd.zzy = str;
    }

    static /* synthetic */ void zzaE(zzgd zzgd) {
        zzgd.zze &= -65537;
        zzgd.zzy = zzd.zzy;
    }

    static /* synthetic */ void zzaF(zzgd zzgd, boolean z10) {
        zzgd.zze |= 131072;
        zzgd.zzz = z10;
    }

    static /* synthetic */ void zzaG(zzgd zzgd) {
        zzgd.zze &= -131073;
        zzgd.zzz = false;
    }

    static /* synthetic */ void zzaH(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 262144;
        zzgd.zzA = str;
    }

    static /* synthetic */ void zzaI(zzgd zzgd) {
        zzgd.zze &= -262145;
        zzgd.zzA = zzd.zzA;
    }

    static /* synthetic */ void zzaJ(zzgd zzgd, long j10) {
        zzgd.zze |= 524288;
        zzgd.zzB = j10;
    }

    static /* synthetic */ void zzaK(zzgd zzgd, int i10) {
        zzgd.zze |= 1048576;
        zzgd.zzC = i10;
    }

    static /* synthetic */ void zzaL(zzgd zzgd, String str) {
        zzgd.zze |= 2097152;
        zzgd.zzD = str;
    }

    static /* synthetic */ void zzaM(zzgd zzgd) {
        zzgd.zze &= -2097153;
        zzgd.zzD = zzd.zzD;
    }

    static /* synthetic */ void zzaN(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 4194304;
        zzgd.zzE = str;
    }

    static /* synthetic */ void zzaO(zzgd zzgd, boolean z10) {
        zzgd.zze |= 8388608;
        zzgd.zzF = z10;
    }

    static /* synthetic */ void zzaP(zzgd zzgd, Iterable iterable) {
        zzkm zzkm = zzgd.zzG;
        if (!zzkm.zzc()) {
            zzgd.zzG = zzkf.zzbF(zzkm);
        }
        zzio.zzbt(iterable, zzgd.zzG);
    }

    static /* synthetic */ void zzaR(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 16777216;
        zzgd.zzH = str;
    }

    static /* synthetic */ void zzaS(zzgd zzgd, int i10) {
        zzgd.zze |= GameControllerManager.DEVICEFLAG_LIGHT_RGB;
        zzgd.zzI = i10;
    }

    static /* synthetic */ void zzaT(zzgd zzgd, int i10) {
        zzgd.zze |= 1;
        zzgd.zzg = 1;
    }

    static /* synthetic */ void zzaU(zzgd zzgd) {
        zzgd.zze &= -268435457;
        zzgd.zzL = zzd.zzL;
    }

    static /* synthetic */ void zzaV(zzgd zzgd, long j10) {
        zzgd.zze |= 536870912;
        zzgd.zzM = j10;
    }

    static /* synthetic */ void zzaa(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zzf |= 8192;
        zzgd.zzad = str;
    }

    static /* synthetic */ void zzab(zzgd zzgd) {
        zzgd.zzf &= -8193;
        zzgd.zzad = zzd.zzad;
    }

    static /* synthetic */ void zzac(zzgd zzgd, Iterable iterable) {
        zzkm zzkm = zzgd.zzae;
        if (!zzkm.zzc()) {
            zzgd.zzae = zzkf.zzbF(zzkm);
        }
        zzio.zzbt(iterable, zzgd.zzae);
    }

    static /* synthetic */ void zzae(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zzf |= 16384;
        zzgd.zzaf = str;
    }

    static /* synthetic */ void zzaf(zzgd zzgd, int i10) {
        zzgd.zzbP();
        zzgd.zzh.remove(i10);
    }

    static /* synthetic */ void zzag(zzgd zzgd, int i10, zzgm zzgm) {
        zzgm.getClass();
        zzgd.zzbQ();
        zzgd.zzi.set(i10, zzgm);
    }

    static /* synthetic */ void zzah(zzgd zzgd, zzgm zzgm) {
        zzgm.getClass();
        zzgd.zzbQ();
        zzgd.zzi.add(zzgm);
    }

    static /* synthetic */ void zzai(zzgd zzgd, Iterable iterable) {
        zzgd.zzbQ();
        zzio.zzbt(iterable, zzgd.zzi);
    }

    static /* synthetic */ void zzaj(zzgd zzgd, int i10) {
        zzgd.zzbQ();
        zzgd.zzi.remove(i10);
    }

    static /* synthetic */ void zzak(zzgd zzgd, long j10) {
        zzgd.zze |= 2;
        zzgd.zzj = j10;
    }

    static /* synthetic */ void zzal(zzgd zzgd, long j10) {
        zzgd.zze |= 4;
        zzgd.zzk = j10;
    }

    static /* synthetic */ void zzam(zzgd zzgd, long j10) {
        zzgd.zze |= 8;
        zzgd.zzl = j10;
    }

    static /* synthetic */ void zzan(zzgd zzgd, long j10) {
        zzgd.zze |= 16;
        zzgd.zzm = j10;
    }

    static /* synthetic */ void zzao(zzgd zzgd) {
        zzgd.zze &= -17;
        zzgd.zzm = 0;
    }

    static /* synthetic */ void zzap(zzgd zzgd, long j10) {
        zzgd.zze |= 32;
        zzgd.zzn = j10;
    }

    static /* synthetic */ void zzaq(zzgd zzgd) {
        zzgd.zze &= -33;
        zzgd.zzn = 0;
    }

    static /* synthetic */ void zzar(zzgd zzgd, String str) {
        zzgd.zze |= 64;
        zzgd.zzo = f.f17924q;
    }

    static /* synthetic */ void zzas(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 128;
        zzgd.zzp = str;
    }

    static /* synthetic */ void zzat(zzgd zzgd) {
        zzgd.zze &= -129;
        zzgd.zzp = zzd.zzp;
    }

    static /* synthetic */ void zzau(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 256;
        zzgd.zzq = str;
    }

    static /* synthetic */ void zzav(zzgd zzgd) {
        zzgd.zze &= -257;
        zzgd.zzq = zzd.zzq;
    }

    static /* synthetic */ void zzaw(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 512;
        zzgd.zzr = str;
    }

    static /* synthetic */ void zzax(zzgd zzgd, int i10) {
        zzgd.zze |= 1024;
        zzgd.zzs = i10;
    }

    static /* synthetic */ void zzay(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 2048;
        zzgd.zzt = str;
    }

    static /* synthetic */ void zzaz(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 4096;
        zzgd.zzu = str;
    }

    private final void zzbP() {
        zzkm zzkm = this.zzh;
        if (!zzkm.zzc()) {
            this.zzh = zzkf.zzbF(zzkm);
        }
    }

    private final void zzbQ() {
        zzkm zzkm = this.zzi;
        if (!zzkm.zzc()) {
            this.zzi = zzkf.zzbF(zzkm);
        }
    }

    public static zzgc zzt() {
        return (zzgc) zzd.zzbx();
    }

    public final String zzA() {
        return this.zzv;
    }

    public final String zzB() {
        return this.zzX;
    }

    public final String zzC() {
        return this.zzq;
    }

    public final String zzD() {
        return this.zzO;
    }

    public final String zzE() {
        return this.zzH;
    }

    public final String zzF() {
        return this.zzE;
    }

    public final String zzG() {
        return this.zzD;
    }

    public final String zzH() {
        return this.zzp;
    }

    public final String zzI() {
        return this.zzo;
    }

    public final String zzJ() {
        return this.zzy;
    }

    public final String zzK() {
        return this.zzad;
    }

    public final String zzL() {
        return this.zzr;
    }

    public final List zzM() {
        return this.zzG;
    }

    public final List zzN() {
        return this.zzh;
    }

    public final List zzO() {
        return this.zzi;
    }

    public final int zza() {
        return this.zzI;
    }

    public final boolean zzaW() {
        return this.zzz;
    }

    public final boolean zzaX() {
        return this.zzF;
    }

    public final boolean zzaY() {
        return (this.zze & GameControllerManager.DEVICEFLAG_LIGHT_RGB) != 0;
    }

    public final boolean zzaZ() {
        return (this.zze & 1048576) != 0;
    }

    public final int zzb() {
        return this.zzC;
    }

    public final boolean zzba() {
        return (this.zze & 536870912) != 0;
    }

    public final boolean zzbb() {
        return (this.zzf & 128) != 0;
    }

    public final boolean zzbc() {
        return (this.zze & 524288) != 0;
    }

    public final boolean zzbd() {
        return (this.zzf & 16) != 0;
    }

    public final boolean zzbe() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzbf() {
        return (this.zze & 16384) != 0;
    }

    public final boolean zzbg() {
        return (this.zze & 131072) != 0;
    }

    public final boolean zzbh() {
        return (this.zze & 32) != 0;
    }

    public final boolean zzbi() {
        return (this.zze & 16) != 0;
    }

    public final boolean zzbj() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzbk() {
        return (this.zzf & 2) != 0;
    }

    public final boolean zzbl() {
        return (this.zze & 8388608) != 0;
    }

    public final boolean zzbm() {
        return (this.zzf & 8192) != 0;
    }

    public final boolean zzbn() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzbo() {
        return (this.zze & 1024) != 0;
    }

    public final boolean zzbp() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzbq() {
        return (this.zze & 32768) != 0;
    }

    public final int zzc() {
        return this.zzh.size();
    }

    public final int zzd() {
        return this.zzg;
    }

    public final int zze() {
        return this.zzQ;
    }

    public final int zzf() {
        return this.zzs;
    }

    public final int zzg() {
        return this.zzi.size();
    }

    public final long zzh() {
        return this.zzM;
    }

    public final long zzi() {
        return this.zzB;
    }

    public final long zzj() {
        return this.zzU;
    }

    public final long zzk() {
        return this.zzl;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zzd, "\u00014\u0000\u0002\u0001A4\u0000\u0005\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.", new Object[]{"zze", "zzf", "zzg", "zzh", zzft.class, "zzi", zzgm.class, "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzm", "zzF", "zzG", zzfp.class, "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", "zzY", l1.f7218a, "zzZ", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf"});
        } else if (i11 == 3) {
            return new zzgd();
        } else {
            if (i11 == 4) {
                return new zzgc((k1) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzd;
        }
    }

    public final long zzm() {
        return this.zzw;
    }

    public final long zzn() {
        return this.zzn;
    }

    public final long zzo() {
        return this.zzm;
    }

    public final long zzp() {
        return this.zzk;
    }

    public final long zzq() {
        return this.zzj;
    }

    public final long zzr() {
        return this.zzx;
    }

    public final zzft zzs(int i10) {
        return (zzft) this.zzh.get(i10);
    }

    public final zzgm zzv(int i10) {
        return (zzgm) this.zzi.get(i10);
    }

    public final String zzw() {
        return this.zzR;
    }

    public final String zzx() {
        return this.zzu;
    }

    public final String zzy() {
        return this.zzA;
    }

    public final String zzz() {
        return this.zzt;
    }
}
