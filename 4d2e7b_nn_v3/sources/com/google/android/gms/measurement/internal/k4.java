package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgj;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zznz;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class k4 {

    /* renamed from: a  reason: collision with root package name */
    private String f7595a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7596b;

    /* renamed from: c  reason: collision with root package name */
    private zzgi f7597c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public BitSet f7598d;

    /* renamed from: e  reason: collision with root package name */
    private BitSet f7599e;

    /* renamed from: f  reason: collision with root package name */
    private Map f7600f;

    /* renamed from: g  reason: collision with root package name */
    private Map f7601g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ b f7602h;

    /* synthetic */ k4(b bVar, String str, zzt zzt) {
        this.f7602h = bVar;
        this.f7595a = str;
        this.f7596b = true;
        this.f7598d = new BitSet();
        this.f7599e = new BitSet();
        this.f7600f = new ArrayMap();
        this.f7601g = new ArrayMap();
    }

    /* access modifiers changed from: package-private */
    public final zzfp a(int i10) {
        ArrayList arrayList;
        List list;
        zzfo zzb = zzfp.zzb();
        zzb.zza(i10);
        zzb.zzc(this.f7596b);
        zzgi zzgi = this.f7597c;
        if (zzgi != null) {
            zzb.zzd(zzgi);
        }
        zzgh zzf = zzgi.zzf();
        zzf.zzb(zzkv.zzr(this.f7598d));
        zzf.zzd(zzkv.zzr(this.f7599e));
        Map map = this.f7600f;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.f7600f.keySet()) {
                int intValue = num.intValue();
                Long l10 = (Long) this.f7600f.get(num);
                if (l10 != null) {
                    zzfq zzc = zzfr.zzc();
                    zzc.zzb(intValue);
                    zzc.zza(l10.longValue());
                    arrayList2.add((zzfr) zzc.zzaC());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzf.zza(arrayList);
        }
        Map map2 = this.f7601g;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.f7601g.keySet()) {
                zzgj zzd = zzgk.zzd();
                zzd.zzb(num2.intValue());
                List list2 = (List) this.f7601g.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzd.zza(list2);
                }
                arrayList3.add((zzgk) zzd.zzaC());
            }
            list = arrayList3;
        }
        zzf.zzc(list);
        zzb.zzb(zzf);
        return (zzfp) zzb.zzaC();
    }

    /* access modifiers changed from: package-private */
    public final void c(n4 n4Var) {
        int a10 = n4Var.a();
        Boolean bool = n4Var.f7647c;
        if (bool != null) {
            this.f7599e.set(a10, bool.booleanValue());
        }
        Boolean bool2 = n4Var.f7648d;
        if (bool2 != null) {
            this.f7598d.set(a10, bool2.booleanValue());
        }
        if (n4Var.f7649e != null) {
            Map map = this.f7600f;
            Integer valueOf = Integer.valueOf(a10);
            Long l10 = (Long) map.get(valueOf);
            long longValue = n4Var.f7649e.longValue() / 1000;
            if (l10 == null || longValue > l10.longValue()) {
                this.f7600f.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (n4Var.f7650f != null) {
            Map map2 = this.f7601g;
            Integer valueOf2 = Integer.valueOf(a10);
            List list = (List) map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.f7601g.put(valueOf2, list);
            }
            if (n4Var.c()) {
                list.clear();
            }
            zznz.zzc();
            zzag zzf = this.f7602h.zzt.zzf();
            String str = this.f7595a;
            zzdt zzdt = zzdu.zzW;
            if (zzf.zzs(str, zzdt) && n4Var.b()) {
                list.clear();
            }
            zznz.zzc();
            if (this.f7602h.zzt.zzf().zzs(this.f7595a, zzdt)) {
                Long valueOf3 = Long.valueOf(n4Var.f7650f.longValue() / 1000);
                if (!list.contains(valueOf3)) {
                    list.add(valueOf3);
                    return;
                }
                return;
            }
            list.add(Long.valueOf(n4Var.f7650f.longValue() / 1000));
        }
    }

    /* synthetic */ k4(b bVar, String str, zzgi zzgi, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzt zzt) {
        this.f7602h = bVar;
        this.f7595a = str;
        this.f7598d = bitSet;
        this.f7599e = bitSet2;
        this.f7600f = map;
        this.f7601g = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.f7601g.put(num, arrayList);
        }
        this.f7596b = false;
        this.f7597c = zzgi;
    }
}
