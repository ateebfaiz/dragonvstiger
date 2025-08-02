package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;

abstract class o {

    /* renamed from: a  reason: collision with root package name */
    static final m f6818a = new g(k.M("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));

    /* renamed from: b  reason: collision with root package name */
    static final m f6819b = new h(k.M("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));

    /* renamed from: c  reason: collision with root package name */
    static final m f6820c = new i(k.M("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));

    /* renamed from: d  reason: collision with root package name */
    static final m f6821d = new j(k.M("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));

    /* renamed from: e  reason: collision with root package name */
    private static volatile zzag f6822e;

    /* renamed from: f  reason: collision with root package name */
    private static final Object f6823f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static Context f6824g;

    static q a(String str, k kVar, boolean z10, boolean z11) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return h(str, kVar, z10, z11);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    static q b(String str, boolean z10, boolean z11, boolean z12) {
        return i(str, z10, false, false, true);
    }

    static q c(String str, boolean z10, boolean z11, boolean z12) {
        return i(str, z10, false, false, false);
    }

    static /* synthetic */ String d(boolean z10, String str, k kVar) {
        String str2;
        if (z10 || !h(str, kVar, true, false).f6827a) {
            str2 = "not allowed";
        } else {
            str2 = "debug cert rejected";
        }
        MessageDigest zza = AndroidUtilsLight.zza("SHA-256");
        Preconditions.checkNotNull(zza);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", new Object[]{str2, str, Hex.bytesToStringLowercase(zza.digest(kVar.N())), Boolean.valueOf(z10), "12451000.false"});
    }

    static synchronized void e(Context context) {
        synchronized (o.class) {
            if (f6824g != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f6824g = context.getApplicationContext();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    static boolean f() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            j();
            boolean zzg = f6822e.zzg();
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return zzg;
        } catch (RemoteException | DynamiteModule.LoadingException e10) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    static boolean g() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            j();
            boolean zzi = f6822e.zzi();
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return zzi;
        } catch (RemoteException | DynamiteModule.LoadingException e10) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    private static q h(String str, k kVar, boolean z10, boolean z11) {
        try {
            j();
            Preconditions.checkNotNull(f6824g);
            try {
                if (f6822e.zzh(new zzs(str, kVar, z10, z11), ObjectWrapper.wrap(f6824g.getPackageManager()))) {
                    return q.b();
                }
                return new p(new zze(z10, str, kVar), (zzu) null);
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
                return q.d("module call", e10);
            }
        } catch (DynamiteModule.LoadingException e11) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
            return q.d("module init: ".concat(String.valueOf(e11.getMessage())), e11);
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    private static q i(String str, boolean z10, boolean z11, boolean z12, boolean z13) {
        q qVar;
        zzq zzq;
        PackageManager.NameNotFoundException nameNotFoundException;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(f6824g);
            try {
                j();
                zzo zzo = new zzo(str, z10, false, ObjectWrapper.wrap(f6824g), false, true);
                if (z13) {
                    zzq = f6822e.zze(zzo);
                } else {
                    zzq = f6822e.zzf(zzo);
                }
                if (zzq.zzb()) {
                    qVar = q.f(zzq.zzc());
                } else {
                    String zza = zzq.zza();
                    if (zzq.zzd() == 4) {
                        nameNotFoundException = new PackageManager.NameNotFoundException();
                    } else {
                        nameNotFoundException = null;
                    }
                    if (zza == null) {
                        zza = "error checking package certificate";
                    }
                    qVar = q.g(zzq.zzc(), zzq.zzd(), zza, nameNotFoundException);
                }
            } catch (DynamiteModule.LoadingException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
                qVar = q.d("module init: ".concat(String.valueOf(e10.getMessage())), e10);
            }
        } catch (RemoteException e11) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
            qVar = q.d("module call", e11);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return qVar;
    }

    private static void j() {
        if (f6822e == null) {
            Preconditions.checkNotNull(f6824g);
            synchronized (f6823f) {
                try {
                    if (f6822e == null) {
                        f6822e = zzaf.zzb(DynamiteModule.load(f6824g, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
