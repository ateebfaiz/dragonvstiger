package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.Set;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@ShowFirstParty
@KeepForSdk
@CheckReturnValue
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zza;
    private static volatile Set zzb;
    private final Context zzc;
    private volatile String zzd;

    public GoogleSignatureVerifier(@NonNull Context context) {
        this.zzc = context.getApplicationContext();
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            try {
                if (zza == null) {
                    o.e(context);
                    zza = new GoogleSignatureVerifier(context);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return zza;
    }

    static final k zza(PackageInfo packageInfo, k... kVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        l lVar = new l(packageInfo.signatures[0].toByteArray());
        for (int i10 = 0; i10 < kVarArr.length; i10++) {
            if (kVarArr[i10].equals(lVar)) {
                return kVarArr[i10];
            }
        }
        return null;
    }

    public static final boolean zzb(@NonNull PackageInfo packageInfo, boolean z10) {
        k kVar;
        if (z10 && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null || (applicationInfo.flags & 129) == 0) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z10) {
                kVar = zza(packageInfo, n.f6817a);
            } else {
                kVar = zza(packageInfo, n.f6817a[0]);
            }
            if (kVar != null) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final q zzc(String str, boolean z10, boolean z11) {
        q qVar;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return q.c("null pkg");
        }
        if (str.equals(this.zzd)) {
            return q.b();
        }
        if (o.g()) {
            qVar = o.b(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.zzc.getPackageManager().getPackageInfo(str, 64);
                boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc);
                if (packageInfo == null) {
                    qVar = q.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        qVar = q.c("single cert required");
                    } else {
                        l lVar = new l(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        q a10 = o.a(str2, lVar, honorsDebugCertificates, false);
                        if (!a10.f6827a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !o.a(str2, lVar, false, true).f6827a) {
                            qVar = a10;
                        } else {
                            qVar = q.c("debuggable release cert app rejected");
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e10) {
                return q.d("no pkg ".concat(str), e10);
            }
        }
        if (qVar.f6827a) {
            this.zzd = str;
        }
        return qVar;
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(@NonNull PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(@NonNull String str) {
        q zzc2 = zzc(str, false, false);
        zzc2.e();
        return zzc2.f6827a;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i10) {
        q qVar;
        int length;
        String[] packagesForUid = this.zzc.getPackageManager().getPackagesForUid(i10);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            qVar = null;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    Preconditions.checkNotNull(qVar);
                    break;
                }
                qVar = zzc(packagesForUid[i11], false, false);
                if (qVar.f6827a) {
                    break;
                }
                i11++;
            }
        } else {
            qVar = q.c("no pkgs");
        }
        qVar.e();
        return qVar.f6827a;
    }
}
