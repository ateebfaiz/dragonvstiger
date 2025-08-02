package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;

final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f7674a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f7675b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Object f7676c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Object f7677d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Object f7678e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzeh f7679f;

    q(zzeh zzeh, int i10, String str, Object obj, Object obj2, Object obj3) {
        this.f7679f = zzeh;
        this.f7674a = i10;
        this.f7675b = str;
        this.f7676c = obj;
        this.f7677d = obj2;
        this.f7678e = obj3;
    }

    public final void run() {
        x zzm = this.f7679f.zzt.zzm();
        if (zzm.zzx()) {
            zzeh zzeh = this.f7679f;
            if (zzeh.zza == 0) {
                if (zzeh.zzt.zzf().zzy()) {
                    zzeh zzeh2 = this.f7679f;
                    zzeh2.zzt.zzaw();
                    zzeh2.zza = 'C';
                } else {
                    zzeh zzeh3 = this.f7679f;
                    zzeh3.zzt.zzaw();
                    zzeh3.zza = 'c';
                }
            }
            zzeh zzeh4 = this.f7679f;
            if (zzeh4.zzb < 0) {
                zzeh4.zzt.zzf().zzh();
                zzeh4.zzb = 74029;
            }
            char charAt = "01VDIWEA?".charAt(this.f7674a);
            zzeh zzeh5 = this.f7679f;
            String str = ExifInterface.GPS_MEASUREMENT_2D + charAt + zzeh5.zza + zzeh5.zzb + ":" + zzeh.zzo(true, this.f7675b, this.f7676c, this.f7677d, this.f7678e);
            if (str.length() > 1024) {
                str = this.f7675b.substring(0, 1024);
            }
            zzeu zzeu = zzm.f7769b;
            if (zzeu != null) {
                zzeu.zzb(str, 1);
                return;
            }
            return;
        }
        Log.println(6, this.f7679f.zzq(), "Persisted config not initialized. Not logging error/warn");
    }
}
