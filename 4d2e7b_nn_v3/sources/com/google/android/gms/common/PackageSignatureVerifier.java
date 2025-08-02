package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*javatests.*/com/google/android/gms/common/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@ShowFirstParty
@KeepForSdk
@CheckReturnValue
public class PackageSignatureVerifier {
    @Nullable
    @VisibleForTesting
    static volatile e zza;
    @Nullable
    private static f zzb;

    private static f zza() {
        f fVar;
        synchronized (f.class) {
            try {
                if (zzb == null) {
                    zzb = new f();
                }
                fVar = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerified(@NonNull Context context, @NonNull String str) {
        String str2;
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        zza();
        if (o.f()) {
            if (true != honorsDebugCertificates) {
                str2 = "-0";
            } else {
                str2 = "-1";
            }
            String concat = String.valueOf(str).concat(str2);
            if (zza != null && zza.f6763a.equals(concat)) {
                return zza.f6764b;
            }
            zza();
            q c10 = o.c(str, honorsDebugCertificates, false, false);
            if (c10.f6827a) {
                zza = new e(concat, PackageVerificationResult.zzd(str, c10.f6830d));
                return zza.f6764b;
            }
            Preconditions.checkNotNull(c10.f6828b);
            return PackageVerificationResult.zza(str, c10.f6828b, c10.f6829c);
        }
        throw new zzae();
    }

    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(@NonNull Context context, @NonNull String str) {
        try {
            PackageVerificationResult queryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            queryPackageSignatureVerified.zzb();
            return queryPackageSignatureVerified;
        } catch (SecurityException e10) {
            PackageVerificationResult queryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (!queryPackageSignatureVerified2.zzc()) {
                return queryPackageSignatureVerified2;
            }
            Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e10);
            return queryPackageSignatureVerified2;
        }
    }
}
