package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.pdns.f;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzge;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzpd;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

final class s0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzaw f7698a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7699b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzgj f7700c;

    s0(zzgj zzgj, zzaw zzaw, String str) {
        this.f7700c = zzgj;
        this.f7698a = zzaw;
        this.f7699b = str;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        d4 d4Var;
        zzga zzga;
        zzgc zzgc;
        String str;
        Bundle bundle;
        c1 c1Var;
        long j10;
        String str2;
        i iVar;
        String str3;
        byte[] bArr;
        zzkt zzkt;
        this.f7700c.zza.zzA();
        b2 zzr = this.f7700c.zza.zzr();
        zzaw zzaw = this.f7698a;
        String str4 = this.f7699b;
        zzr.zzg();
        zzfr.zzO();
        Preconditions.checkNotNull(zzaw);
        Preconditions.checkNotEmpty(str4);
        if (!zzr.zzt.zzf().zzs(str4, zzdu.zzS)) {
            zzr.zzt.zzay().zzc().zzb("Generating ScionPayload disabled. packageName", str4);
            return new byte[0];
        } else if ("_iap".equals(zzaw.zza) || "_iapx".equals(zzaw.zza)) {
            zzga zza = zzgb.zza();
            zzr.zzf.zzi().zzw();
            c1 D = zzr.zzf.zzi().D(str4);
            if (D == null) {
                zzr.zzt.zzay().zzc().zzb("Log and bundle not available. package_name", str4);
                bArr = new byte[0];
                zzkt = zzr.zzf;
            } else if (!D.J()) {
                zzr.zzt.zzay().zzc().zzb("Log and bundle disabled. package_name", str4);
                bArr = new byte[0];
                zzkt = zzr.zzf;
            } else {
                zzgc zzt = zzgd.zzt();
                zzt.zzad(1);
                zzt.zzZ(f.f17924q);
                if (!TextUtils.isEmpty(D.d0())) {
                    zzt.zzD(D.d0());
                }
                if (!TextUtils.isEmpty(D.f0())) {
                    zzt.zzF((String) Preconditions.checkNotNull(D.f0()));
                }
                if (!TextUtils.isEmpty(D.g0())) {
                    zzt.zzG((String) Preconditions.checkNotNull(D.g0()));
                }
                if (D.L() != -2147483648L) {
                    zzt.zzH((int) D.L());
                }
                zzt.zzV(D.W());
                zzt.zzP(D.U());
                String i02 = D.i0();
                String b02 = D.b0();
                if (!TextUtils.isEmpty(i02)) {
                    zzt.zzU(i02);
                } else if (!TextUtils.isEmpty(b02)) {
                    zzt.zzC(b02);
                }
                zzai zzh = zzr.zzf.zzh(str4);
                zzt.zzM(D.T());
                if (zzr.zzt.zzJ() && zzr.zzt.zzf().zzt(zzt.zzap()) && zzh.zzi(zzah.AD_STORAGE) && !TextUtils.isEmpty((CharSequence) null)) {
                    zzt.zzO((String) null);
                }
                zzt.zzL(zzh.zzh());
                if (zzh.zzi(zzah.AD_STORAGE) && D.I()) {
                    Pair zzd = zzr.zzf.zzs().zzd(D.d0(), zzh);
                    if (D.I() && !TextUtils.isEmpty((CharSequence) zzd.first)) {
                        try {
                            zzt.zzae(b2.zza((String) zzd.first, Long.toString(zzaw.zzd)));
                            Object obj = zzd.second;
                            if (obj != null) {
                                zzt.zzX(((Boolean) obj).booleanValue());
                            }
                        } catch (SecurityException e10) {
                            zzr.zzt.zzay().zzc().zzb("Resettable device id encryption failed", e10.getMessage());
                            bArr = new byte[0];
                            zzkt = zzr.zzf;
                        } catch (Throwable th) {
                            zzr.zzf.zzi().P();
                            throw th;
                        }
                    }
                }
                zzr.zzt.zzg().zzu();
                zzt.zzN(Build.MODEL);
                zzr.zzt.zzg().zzu();
                zzt.zzY(Build.VERSION.RELEASE);
                zzt.zzaj((int) zzr.zzt.zzg().zzb());
                zzt.zzan(zzr.zzt.zzg().zzc());
                try {
                    if (zzh.zzi(zzah.ANALYTICS_STORAGE) && D.e0() != null) {
                        zzt.zzE(b2.zza((String) Preconditions.checkNotNull(D.e0()), Long.toString(zzaw.zzd)));
                    }
                    if (!TextUtils.isEmpty(D.h0())) {
                        zzt.zzT((String) Preconditions.checkNotNull(D.h0()));
                    }
                    String d02 = D.d0();
                    List N = zzr.zzf.zzi().N(d02);
                    Iterator it = N.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            d4Var = null;
                            break;
                        }
                        d4Var = (d4) it.next();
                        if ("_lte".equals(d4Var.f7463c)) {
                            break;
                        }
                    }
                    if (d4Var == null || d4Var.f7465e == null) {
                        d4 d4Var2 = new d4(d02, "auto", "_lte", zzr.zzt.zzav().currentTimeMillis(), 0L);
                        N.add(d4Var2);
                        zzr.zzf.zzi().k(d4Var2);
                    }
                    zzkv zzu = zzr.zzf.zzu();
                    zzu.zzt.zzay().zzj().zza("Checking account type status for ad personalization signals");
                    if (zzu.zzt.zzg().zze()) {
                        String d03 = D.d0();
                        Preconditions.checkNotNull(d03);
                        if (D.I() && zzu.zzf.zzo().zzn(d03)) {
                            zzu.zzt.zzay().zzc().zza("Turning off ad personalization due to account type");
                            Iterator it2 = N.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                } else if ("_npa".equals(((d4) it2.next()).f7463c)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            N.add(new d4(d03, "auto", "_npa", zzu.zzt.zzav().currentTimeMillis(), 1L));
                        }
                    }
                    zzgm[] zzgmArr = new zzgm[N.size()];
                    for (int i10 = 0; i10 < N.size(); i10++) {
                        zzgl zzd2 = zzgm.zzd();
                        zzd2.zzf(((d4) N.get(i10)).f7463c);
                        zzd2.zzg(((d4) N.get(i10)).f7464d);
                        zzr.zzf.zzu().zzu(zzd2, ((d4) N.get(i10)).f7465e);
                        zzgmArr[i10] = (zzgm) zzd2.zzaC();
                    }
                    zzt.zzj(Arrays.asList(zzgmArr));
                    zzei zzb = zzei.zzb(zzaw);
                    zzr.zzt.zzv().zzL(zzb.zzd, zzr.zzf.zzi().C(str4));
                    zzr.zzt.zzv().zzM(zzb, zzr.zzt.zzf().zzd(str4));
                    Bundle bundle2 = zzb.zzd;
                    bundle2.putLong("_c", 1);
                    zzr.zzt.zzay().zzc().zza("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1);
                    bundle2.putString("_o", zzaw.zzc);
                    if (zzr.zzt.zzv().zzae(zzt.zzap())) {
                        zzr.zzt.zzv().zzO(bundle2, "_dbg", 1L);
                        zzr.zzt.zzv().zzO(bundle2, "_r", 1L);
                    }
                    i H = zzr.zzf.zzi().H(str4, zzaw.zza);
                    if (H == null) {
                        zzgc = zzt;
                        c1Var = D;
                        zzga = zza;
                        str = str4;
                        bundle = bundle2;
                        str2 = null;
                        iVar = new i(str4, zzaw.zza, 0, 0, 0, zzaw.zzd, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                        j10 = 0;
                    } else {
                        c1Var = D;
                        zzga = zza;
                        str = str4;
                        bundle = bundle2;
                        zzgc = zzt;
                        str2 = null;
                        long j11 = H.f7542f;
                        iVar = H.c(zzaw.zzd);
                        j10 = j11;
                    }
                    zzr.zzf.zzi().d(iVar);
                    zzar zzar = new zzar(zzr.zzt, zzaw.zzc, str, zzaw.zza, zzaw.zzd, j10, bundle);
                    zzfs zze = zzft.zze();
                    zze.zzm(zzar.zzd);
                    zze.zzi(zzar.zzb);
                    zze.zzl(zzar.zze);
                    j jVar = new j(zzar.zzf);
                    while (jVar.hasNext()) {
                        String a10 = jVar.next();
                        zzfw zze2 = zzfx.zze();
                        zze2.zzj(a10);
                        Object zzf = zzar.zzf.zzf(a10);
                        if (zzf != null) {
                            zzr.zzf.zzu().zzt(zze2, zzf);
                            zze.zze(zze2);
                        }
                    }
                    zzgc zzgc2 = zzgc;
                    zzgc2.zzk(zze);
                    zzge zza2 = zzgg.zza();
                    zzfu zza3 = zzfv.zza();
                    zza3.zza(iVar.f7539c);
                    zza3.zzb(zzaw.zza);
                    zza2.zza(zza3);
                    zzgc2.zzaa(zza2);
                    zzgc2.zzf(zzr.zzf.zzf().a(c1Var.d0(), Collections.emptyList(), zzgc2.zzat(), Long.valueOf(zze.zzc()), Long.valueOf(zze.zzc())));
                    if (zze.zzq()) {
                        zzgc2.zzai(zze.zzc());
                        zzgc2.zzQ(zze.zzc());
                    }
                    long X = c1Var.X();
                    int i11 = (X > 0 ? 1 : (X == 0 ? 0 : -1));
                    if (i11 != 0) {
                        zzgc2.zzab(X);
                    }
                    long Z = c1Var.Z();
                    if (Z != 0) {
                        zzgc2.zzac(Z);
                    } else if (i11 != 0) {
                        zzgc2.zzac(X);
                    }
                    String b10 = c1Var.b();
                    zzpd.zzc();
                    if (zzr.zzt.zzf().zzs(str2, zzdu.zzal)) {
                        str3 = str;
                        if (zzr.zzt.zzf().zzs(str3, zzdu.zzan) && b10 != null) {
                            zzgc2.zzah(b10);
                        }
                    } else {
                        str3 = str;
                    }
                    c1Var.e();
                    zzgc2.zzI((int) c1Var.Y());
                    zzr.zzt.zzf().zzh();
                    zzgc2.zzal(74029);
                    zzgc2.zzak(zzr.zzt.zzav().currentTimeMillis());
                    zzgc2.zzag(true);
                    if (zzr.zzt.zzf().zzs(str2, zzdu.zzar)) {
                        zzr.zzf.zzC(zzgc2.zzap(), zzgc2);
                    }
                    zzga zzga2 = zzga;
                    zzga2.zza(zzgc2);
                    c1 c1Var2 = c1Var;
                    c1Var2.C(zzgc2.zzd());
                    c1Var2.z(zzgc2.zzc());
                    zzr.zzf.zzi().c(c1Var2);
                    zzr.zzf.zzi().zzC();
                    zzr.zzf.zzi().P();
                    try {
                        return zzr.zzf.zzu().zzy(((zzgb) zzga2.zzaC()).zzbu());
                    } catch (IOException e11) {
                        zzr.zzt.zzay().zzd().zzc("Data loss. Failed to bundle and serialize. appId", zzeh.zzn(str3), e11);
                        return str2;
                    }
                } catch (SecurityException e12) {
                    zzr.zzt.zzay().zzc().zzb("app instance id encryption failed", e12.getMessage());
                    byte[] bArr2 = new byte[0];
                    zzr.zzf.zzi().P();
                    return bArr2;
                }
            }
            zzkt.zzi().P();
            return bArr;
        } else {
            zzr.zzt.zzay().zzc().zzc("Generating a payload for this event is not available. package_name, event_name", str4, zzaw.zza);
            return null;
        }
    }
}
