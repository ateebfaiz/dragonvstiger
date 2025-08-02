package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.HashMap;

@RestrictedInheritance(allowedOnPath = ".*javatests/com/google/android/gmscore/integ/client/common/robolectric/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@ShowFirstParty
@KeepForSdk
public class GmsSignatureVerifier {
    private static final d zza;
    private static final d zzb;
    private static final HashMap zzc = new HashMap();

    static {
        t tVar = new t();
        tVar.d("com.google.android.gms");
        tVar.a(204200000);
        m mVar = o.f6821d;
        tVar.c(zzag.zzn(mVar.N(), o.f6819b.N()));
        m mVar2 = o.f6820c;
        tVar.b(zzag.zzn(mVar2.N(), o.f6818a.N()));
        zza = tVar.e();
        t tVar2 = new t();
        tVar2.d("com.android.vending");
        tVar2.a(82240000);
        tVar2.c(zzag.zzm(mVar.N()));
        tVar2.b(zzag.zzm(mVar2.N()));
        zzb = tVar2.e();
    }
}
