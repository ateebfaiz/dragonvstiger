package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.alibaba.pdns.j;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.zing.zalo.zalosdk.common.Constant;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzlb extends y0 {
    private static final String[] zza = {"firebase_", "google_", "ga_"};
    private static final String[] zzb = {"_err"};
    private SecureRandom zzc;
    private final AtomicLong zzd = new AtomicLong(0);
    private int zze;
    private Integer zzf = null;

    zzlb(zzfr zzfr) {
        super(zzfr);
    }

    static MessageDigest zzF() {
        int i10 = 0;
        while (i10 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(j.f17955b);
                if (instance != null) {
                    return instance;
                }
                i10++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static ArrayList zzH(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzac zzac = (zzac) it.next();
            Bundle bundle = new Bundle();
            bundle.putString(Constant.PARAM_APP_ID, zzac.zza);
            bundle.putString("origin", zzac.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzac.zzd);
            bundle.putString("name", zzac.zzc.zzb);
            zzgn.zzb(bundle, Preconditions.checkNotNull(zzac.zzc.zza()));
            bundle.putBoolean("active", zzac.zze);
            String str = zzac.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzaw zzaw = zzac.zzg;
            if (zzaw != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzaw.zza);
                zzau zzau = zzaw.zzb;
                if (zzau != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzau.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzac.zzh);
            zzaw zzaw2 = zzac.zzi;
            if (zzaw2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzaw2.zza);
                zzau zzau2 = zzaw2.zzb;
                if (zzau2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzau2.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzac.zzc.zzc);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzac.zzj);
            zzaw zzaw3 = zzac.zzk;
            if (zzaw3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzaw3.zza);
                zzau zzau3 = zzaw3.zzb;
                if (zzau3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzau3.zzc());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    @WorkerThread
    public static void zzK(zzie zzie, Bundle bundle, boolean z10) {
        if (!(bundle == null || zzie == null)) {
            if (!bundle.containsKey("_sc") || z10) {
                String str = zzie.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzie.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzie.zzc);
                return;
            }
            z10 = false;
        }
        if (bundle != null && zzie == null && z10) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    static boolean zzah(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("_")) {
            return false;
        }
        return true;
    }

    static boolean zzai(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    static boolean zzaj(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static boolean zzak(Context context, boolean z10) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return zzat(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzat(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean zzal(String str) {
        if (zzb[0].equals(str)) {
            return false;
        }
        return true;
    }

    static final boolean zzao(Bundle bundle, int i10) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i10);
        return true;
    }

    @VisibleForTesting
    static final boolean zzap(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final int zzaq(String str) {
        if ("_ldl".equals(str)) {
            this.zzt.zzf();
            return 2048;
        } else if ("_id".equals(str)) {
            this.zzt.zzf();
            return 256;
        } else if ("_lgclid".equals(str)) {
            this.zzt.zzf();
            return 100;
        } else {
            this.zzt.zzf();
            return 36;
        }
    }

    private final Object zzar(int i10, Object obj, boolean z10, boolean z11) {
        long j10;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            if (true != ((Boolean) obj).booleanValue()) {
                j10 = 0;
            } else {
                j10 = 1;
            }
            return Long.valueOf(j10);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zzD(obj.toString(), i10, z10);
            }
            if (!z11 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (parcelable instanceof Bundle) {
                    Bundle zzt = zzt((Bundle) parcelable);
                    if (!zzt.isEmpty()) {
                        arrayList.add(zzt);
                    }
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    private static boolean zzas(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String zza2 : strArr) {
            if (zzkz.zza(str, zza2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean zzat(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    @VisibleForTesting
    static long zzp(byte[] bArr) {
        boolean z10;
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i10 = 0;
        if (length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        int i11 = length - 1;
        long j10 = 0;
        while (i11 >= 0 && i11 >= bArr.length - 8) {
            j10 += (((long) bArr[i11]) & 255) << i10;
            i10 += 8;
            i11--;
        }
        return j10;
    }

    /* access modifiers changed from: package-private */
    public final Object zzA(String str, Object obj) {
        int i10 = 256;
        if ("_ev".equals(str)) {
            this.zzt.zzf();
            return zzar(256, obj, true, true);
        }
        if (zzah(str)) {
            this.zzt.zzf();
        } else {
            this.zzt.zzf();
            i10 = 100;
        }
        return zzar(i10, obj, false, true);
    }

    /* access modifiers changed from: package-private */
    public final Object zzB(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zzar(zzaq(str), obj, true, false);
        }
        return zzar(zzaq(str), obj, false, false);
    }

    /* access modifiers changed from: package-private */
    public final String zzC() {
        byte[] bArr = new byte[16];
        zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    public final String zzD(String str, int i10, boolean z10) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i10) {
            return str;
        }
        if (z10) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i10))).concat("...");
        }
        return null;
    }

    public final URL zzE(long j10, String str, String str2, long j11) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{74029L, Integer.valueOf(zzm())}), str2, str, Long.valueOf(j11)});
            if (str.equals(this.zzt.zzf().zzm())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (MalformedURLException e10) {
            e = e10;
            this.zzt.zzay().zzd().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (IllegalArgumentException e11) {
            e = e11;
            this.zzt.zzay().zzd().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @EnsuresNonNull({"this.secureRandom"})
    public final SecureRandom zzG() {
        zzg();
        if (this.zzc == null) {
            this.zzc = new SecureRandom();
        }
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzI(Bundle bundle, long j10) {
        long j11 = bundle.getLong("_et");
        if (j11 != 0) {
            this.zzt.zzay().zzk().zzb("Params already contained engagement", Long.valueOf(j11));
        } else {
            j11 = 0;
        }
        bundle.putLong("_et", j10 + j11);
    }

    /* access modifiers changed from: package-private */
    public final void zzJ(Bundle bundle, int i10, String str, String str2, Object obj) {
        if (zzao(bundle, i10)) {
            this.zzt.zzf();
            bundle.putString("_ev", zzD(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) obj.toString().length());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzL(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String next : bundle2.keySet()) {
                if (!bundle.containsKey(next)) {
                    this.zzt.zzv().zzO(bundle, next, bundle2.get(next));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzM(zzei zzei, int i10) {
        int i11 = 0;
        for (String str : new TreeSet(zzei.zzd.keySet())) {
            if (zzai(str) && (i11 = i11 + 1) > i10) {
                this.zzt.zzay().zze().zzc("Event can't contain more than " + i10 + " params", this.zzt.zzj().zzd(zzei.zza), this.zzt.zzj().zzb(zzei.zzd));
                zzao(zzei.zzd, 5);
                zzei.zzd.remove(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzN(f4 f4Var, String str, int i10, String str2, String str3, int i11) {
        Bundle bundle = new Bundle();
        zzao(bundle, i10);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i10 == 6 || i10 == 7 || i10 == 2) {
            bundle.putLong("_el", (long) i11);
        }
        f4Var.a(str, "_err", bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zzO(Bundle bundle, String str, Object obj) {
        String str2;
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                if (obj != null) {
                    str2 = obj.getClass().getSimpleName();
                } else {
                    str2 = null;
                }
                this.zzt.zzay().zzl().zzc("Not putting event parameter. Invalid value type. name, type", this.zzt.zzj().zze(str), str2);
            }
        }
    }

    public final void zzP(zzcf zzcf, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z10);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.zzt.zzay().zzk().zzb("Error returning boolean value to wrapper", e10);
        }
    }

    public final void zzQ(zzcf zzcf, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.zzt.zzay().zzk().zzb("Error returning bundle list to wrapper", e10);
        }
    }

    public final void zzR(zzcf zzcf, Bundle bundle) {
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.zzt.zzay().zzk().zzb("Error returning bundle value to wrapper", e10);
        }
    }

    public final void zzS(zzcf zzcf, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.zzt.zzay().zzk().zzb("Error returning byte array to wrapper", e10);
        }
    }

    public final void zzT(zzcf zzcf, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i10);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.zzt.zzay().zzk().zzb("Error returning int value to wrapper", e10);
        }
    }

    public final void zzU(zzcf zzcf, long j10) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j10);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.zzt.zzay().zzk().zzb("Error returning long value to wrapper", e10);
        }
    }

    public final void zzV(zzcf zzcf, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e10) {
            this.zzt.zzay().zzk().zzb("Error returning string value to wrapper", e10);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzW(String str, String str2, String str3, Bundle bundle, List list, boolean z10) {
        int i10;
        String str4;
        int i11;
        String str5;
        int i12;
        String str6 = str2;
        Bundle bundle2 = bundle;
        List list2 = list;
        if (bundle2 != null) {
            this.zzt.zzf();
            int i13 = 0;
            for (String str7 : new TreeSet(bundle.keySet())) {
                if (list2 == null || !list2.contains(str7)) {
                    if (!z10) {
                        i12 = zzj(str7);
                    } else {
                        i12 = 0;
                    }
                    if (i12 == 0) {
                        i12 = zzi(str7);
                    }
                    i10 = i12;
                } else {
                    i10 = 0;
                }
                if (i10 != 0) {
                    if (i10 == 3) {
                        str5 = str7;
                    } else {
                        str5 = null;
                    }
                    zzJ(bundle, i10, str7, str7, str5);
                    bundle2.remove(str7);
                } else {
                    if (zzaf(bundle2.get(str7))) {
                        this.zzt.zzay().zzl().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str6, str3, str7);
                        i11 = 22;
                        str4 = str7;
                    } else {
                        String str8 = str3;
                        str4 = str7;
                        i11 = zza(str, str2, str7, bundle2.get(str7), bundle, list, z10, false);
                    }
                    if (i11 != 0 && !"_ev".equals(str4)) {
                        zzJ(bundle, i11, str4, str4, bundle2.get(str4));
                        bundle2.remove(str4);
                    } else if (zzai(str4) && !zzas(str4, zzgp.zzd) && (i13 = i13 + 1) > 0) {
                        this.zzt.zzay().zze().zzc("Item cannot contain custom parameters", this.zzt.zzj().zzd(str6), this.zzt.zzj().zzb(bundle2));
                        zzao(bundle2, 23);
                        bundle2.remove(str4);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzX(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (zzap(str)) {
                return true;
            }
            if (this.zzt.zzL()) {
                this.zzt.zzay().zze().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzeh.zzn(str));
            }
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            if (this.zzt.zzL()) {
                this.zzt.zzay().zze().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        } else if (zzap(str2)) {
            return true;
        } else {
            this.zzt.zzay().zze().zzb("Invalid admob_app_id. Analytics disabled.", zzeh.zzn(str2));
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzY(String str, int i10, String str2) {
        if (str2 == null) {
            this.zzt.zzay().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i10) {
            return true;
        } else {
            this.zzt.zzay().zze().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i10), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzZ(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzt.zzay().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zza;
        for (int i10 = 0; i10 < 3; i10++) {
            if (str2.startsWith(strArr3[i10])) {
                this.zzt.zzay().zze().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zzas(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && zzas(str2, strArr2)) {
            return true;
        }
        this.zzt.zzay().zze().zzc("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d1  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Object r17, android.os.Bundle r18, java.util.List r19, boolean r20, boolean r21) {
        /*
            r13 = this;
            r7 = r13
            r8 = r16
            r0 = r17
            r1 = r18
            r13.zzg()
            boolean r2 = r13.zzaf(r0)
            java.lang.String r3 = "param"
            r4 = 0
            if (r2 == 0) goto L_0x00a9
            if (r21 == 0) goto L_0x00ab
            java.lang.String[] r2 = com.google.android.gms.measurement.internal.zzgp.zzc
            boolean r2 = zzas(r8, r2)
            if (r2 != 0) goto L_0x0020
            r0 = 20
            return r0
        L_0x0020:
            com.google.android.gms.measurement.internal.zzfr r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzjm r2 = r2.zzt()
            r2.zzg()
            r2.zza()
            boolean r5 = r2.zzN()
            if (r5 != 0) goto L_0x0033
            goto L_0x0045
        L_0x0033:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzlb r2 = r2.zzv()
            int r2 = r2.zzm()
            r5 = 200900(0x310c4, float:2.81521E-40)
            if (r2 >= r5) goto L_0x0045
            r0 = 25
            return r0
        L_0x0045:
            com.google.android.gms.measurement.internal.zzfr r2 = r7.zzt
            r2.zzf()
            boolean r2 = r0 instanceof android.os.Parcelable[]
            if (r2 == 0) goto L_0x0053
            r5 = r0
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r5 = r5.length
            goto L_0x005e
        L_0x0053:
            boolean r5 = r0 instanceof java.util.ArrayList
            if (r5 == 0) goto L_0x00a9
            r5 = r0
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r5 = r5.size()
        L_0x005e:
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 <= r6) goto L_0x00a9
            com.google.android.gms.measurement.internal.zzfr r9 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzl()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r10 = "Parameter array is too long; discarded. Value kind, name, array length"
            r9.zzd(r10, r3, r8, r5)
            com.google.android.gms.measurement.internal.zzfr r5 = r7.zzt
            r5.zzf()
            r5 = 17
            if (r2 == 0) goto L_0x008f
            r2 = r0
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            int r9 = r2.length
            if (r9 <= r6) goto L_0x008d
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r6)
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            r1.putParcelableArray(r8, r2)
        L_0x008d:
            r9 = r5
            goto L_0x00ae
        L_0x008f:
            boolean r2 = r0 instanceof java.util.ArrayList
            if (r2 == 0) goto L_0x008d
            r2 = r0
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r9 = r2.size()
            if (r9 <= r6) goto L_0x008d
            java.util.ArrayList r9 = new java.util.ArrayList
            java.util.List r2 = r2.subList(r4, r6)
            r9.<init>(r2)
            r1.putParcelableArrayList(r8, r9)
            goto L_0x008d
        L_0x00a9:
            r9 = r4
            goto L_0x00ae
        L_0x00ab:
            r0 = 21
            return r0
        L_0x00ae:
            boolean r1 = zzah(r15)
            if (r1 != 0) goto L_0x00c3
            boolean r1 = zzah(r16)
            if (r1 == 0) goto L_0x00bb
            goto L_0x00c3
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzfr r1 = r7.zzt
            r1.zzf()
            r1 = 100
            goto L_0x00ca
        L_0x00c3:
            com.google.android.gms.measurement.internal.zzfr r1 = r7.zzt
            r1.zzf()
            r1 = 256(0x100, float:3.59E-43)
        L_0x00ca:
            boolean r1 = r13.zzaa(r3, r8, r1, r0)
            if (r1 == 0) goto L_0x00d1
            return r9
        L_0x00d1:
            if (r21 == 0) goto L_0x0161
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 == 0) goto L_0x00e8
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.zzW(r1, r2, r3, r4, r5, r6)
            goto L_0x0160
        L_0x00e8:
            boolean r1 = r0 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x011f
            r10 = r0
            android.os.Parcelable[] r10 = (android.os.Parcelable[]) r10
            int r11 = r10.length
            r12 = r4
        L_0x00f1:
            if (r12 >= r11) goto L_0x0160
            r0 = r10[r12]
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x010d
            com.google.android.gms.measurement.internal.zzfr r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzl()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r2 = "All Parcelable[] elements must be of type Bundle. Value type, name"
            r1.zzc(r2, r0, r8)
            goto L_0x0161
        L_0x010d:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.zzW(r1, r2, r3, r4, r5, r6)
            int r12 = r12 + 1
            goto L_0x00f1
        L_0x011f:
            boolean r1 = r0 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x0161
            r10 = r0
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            int r11 = r10.size()
            r12 = r4
        L_0x012b:
            if (r12 >= r11) goto L_0x0160
            java.lang.Object r0 = r10.get(r12)
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x014e
            com.google.android.gms.measurement.internal.zzfr r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzl()
            if (r0 == 0) goto L_0x0146
            java.lang.Class r0 = r0.getClass()
            goto L_0x0148
        L_0x0146:
            java.lang.String r0 = "null"
        L_0x0148:
            java.lang.String r2 = "All ArrayList elements must be of type Bundle. Value type, name"
            r1.zzc(r2, r0, r8)
            goto L_0x0161
        L_0x014e:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.zzW(r1, r2, r3, r4, r5, r6)
            int r12 = r12 + 1
            goto L_0x012b
        L_0x0160:
            return r9
        L_0x0161:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlb.zza(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzaA() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.zzt.zzay().zzk().zza("Utils falling back to Random for random id");
            }
        }
        this.zzd.set(nextLong);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaa(String str, String str2, int i10, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i10) {
                this.zzt.zzay().zzl().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzab(String str, String str2) {
        if (str2 == null) {
            this.zzt.zzay().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzt.zzay().zze().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                if (codePointAt == 95) {
                    codePointAt = 95;
                } else {
                    this.zzt.zzay().zze().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                    return false;
                }
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.zzt.zzay().zze().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzac(String str, String str2) {
        if (str2 == null) {
            this.zzt.zzay().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzt.zzay().zze().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                this.zzt.zzay().zze().zzc("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.zzt.zzay().zze().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzad(String str) {
        zzg();
        if (Wrappers.packageManager(this.zzt.zzau()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        this.zzt.zzay().zzc().zzb("Permission not granted", str);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzae(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String zzl = this.zzt.zzf().zzl();
        this.zzt.zzaw();
        return zzl.equals(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaf(Object obj) {
        if ((obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean zzag(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e10) {
            this.zzt.zzay().zzd().zzb("Error obtaining certificate", e10);
            return true;
        } catch (PackageManager.NameNotFoundException e11) {
            this.zzt.zzay().zzd().zzb("Package name not found", e11);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzam(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            if (!str.equals(str2)) {
                return true;
            }
            return false;
        } else if (!isEmpty || !isEmpty2) {
            if (!isEmpty) {
                if (TextUtils.isEmpty(str4)) {
                    return false;
                }
                if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
                    return true;
                }
                return false;
            } else if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
                return true;
            } else {
                return false;
            }
        } else if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (!TextUtils.isEmpty(str4)) {
                return true;
            }
            return false;
        } else if (!str3.equals(str4)) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzan(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzd(String str, Object obj) {
        boolean z10;
        if ("_ldl".equals(str)) {
            z10 = zzaa("user property referrer", str, zzaq(str), obj);
        } else {
            z10 = zzaa("user property", str, zzaq(str), obj);
        }
        if (z10) {
            return 0;
        }
        return 7;
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int zzh(String str) {
        if (!zzab(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!zzZ(NotificationCompat.CATEGORY_EVENT, zzgo.zza, zzgo.zzb, str)) {
            return 13;
        }
        this.zzt.zzf();
        if (!zzY(NotificationCompat.CATEGORY_EVENT, 40, str)) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzi(String str) {
        if (!zzab("event param", str)) {
            return 3;
        }
        if (!zzZ("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        this.zzt.zzf();
        if (!zzY("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzj(String str) {
        if (!zzac("event param", str)) {
            return 3;
        }
        if (!zzZ("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        this.zzt.zzf();
        if (!zzY("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzl(String str) {
        if (!zzab("user property", str)) {
            return 6;
        }
        if (!zzZ("user property", zzgq.zza, (String[]) null, str)) {
            return 15;
        }
        this.zzt.zzf();
        if (!zzY("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzm() {
        if (this.zzf == null) {
            this.zzf = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzt.zzau()) / 1000);
        }
        return this.zzf.intValue();
    }

    public final int zzo(int i10) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzt.zzau(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public final long zzq() {
        long andIncrement;
        long j10;
        if (this.zzd.get() == 0) {
            synchronized (this.zzd) {
                long nextLong = new Random(System.nanoTime() ^ this.zzt.zzav().currentTimeMillis()).nextLong();
                int i10 = this.zze + 1;
                this.zze = i10;
                j10 = nextLong + ((long) i10);
            }
            return j10;
        }
        synchronized (this.zzd) {
            this.zzd.compareAndSet(-1, 1);
            andIncrement = this.zzd.getAndIncrement();
        }
        return andIncrement;
    }

    public final long zzr(long j10, long j11) {
        return (j10 + (j11 * 60000)) / 86400000;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzs(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    str7 = uri.getQueryParameter("utm_campaign");
                    str6 = uri.getQueryParameter("utm_source");
                    str5 = uri.getQueryParameter("utm_medium");
                    str4 = uri.getQueryParameter("gclid");
                    str3 = uri.getQueryParameter("utm_id");
                    str2 = uri.getQueryParameter("dclid");
                    str = uri.getQueryParameter("srsltid");
                } else {
                    str7 = null;
                    str6 = null;
                    str5 = null;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                if (TextUtils.isEmpty(str7) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str7)) {
                    bundle.putString("campaign", str7);
                }
                if (!TextUtils.isEmpty(str6)) {
                    bundle.putString("source", str6);
                }
                if (!TextUtils.isEmpty(str5)) {
                    bundle.putString("medium", str5);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("gclid", str4);
                }
                String queryParameter = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
                }
                String queryParameter2 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter2);
                }
                String queryParameter3 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
                }
                String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
                }
                String queryParameter5 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("anid", queryParameter5);
                }
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("campaign_id", str3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putString("dclid", str2);
                }
                String queryParameter6 = uri.getQueryParameter("utm_source_platform");
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString("source_platform", queryParameter6);
                }
                String queryParameter7 = uri.getQueryParameter("utm_creative_format");
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString("creative_format", queryParameter7);
                }
                String queryParameter8 = uri.getQueryParameter("utm_marketing_tactic");
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString("marketing_tactic", queryParameter8);
                }
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("srsltid", str);
                }
                return bundle;
            } catch (UnsupportedOperationException e10) {
                this.zzt.zzay().zzk().zzb("Install referrer url isn't a hierarchical URI", e10);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzt(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                Object zzA = zzA(next, bundle.get(next));
                if (zzA == null) {
                    this.zzt.zzay().zzl().zzb("Param value can't be null", this.zzt.zzj().zze(next));
                } else {
                    zzO(bundle2, next, zzA);
                }
            }
        }
        return bundle2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0108 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzy(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, java.util.List r24, boolean r25) {
        /*
            r20 = this;
            r9 = r20
            r10 = r22
            r11 = r23
            r12 = r24
            java.lang.String[] r0 = com.google.android.gms.measurement.internal.zzgo.zzd
            boolean r13 = zzas(r10, r0)
            if (r11 == 0) goto L_0x010d
            android.os.Bundle r15 = new android.os.Bundle
            r15.<init>(r11)
            com.google.android.gms.measurement.internal.zzfr r0 = r9.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            int r8 = r0.zzc()
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Set r1 = r23.keySet()
            r0.<init>(r1)
            java.util.Iterator r16 = r0.iterator()
            r17 = 0
            r18 = r17
        L_0x0030:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x010b
            java.lang.Object r0 = r16.next()
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
            if (r12 == 0) goto L_0x0049
            boolean r0 = r12.contains(r7)
            if (r0 != 0) goto L_0x0046
            goto L_0x0049
        L_0x0046:
            r2 = r17
            goto L_0x0059
        L_0x0049:
            if (r25 != 0) goto L_0x0050
            int r0 = r9.zzj(r7)
            goto L_0x0052
        L_0x0050:
            r0 = r17
        L_0x0052:
            if (r0 != 0) goto L_0x0058
            int r0 = r9.zzi(r7)
        L_0x0058:
            r2 = r0
        L_0x0059:
            if (r2 == 0) goto L_0x006f
            r0 = 3
            if (r2 != r0) goto L_0x0060
            r5 = r7
            goto L_0x0061
        L_0x0060:
            r5 = 0
        L_0x0061:
            r0 = r20
            r1 = r15
            r3 = r7
            r4 = r7
            r0.zzJ(r1, r2, r3, r4, r5)
            r15.remove(r7)
            r14 = r8
            goto L_0x0108
        L_0x006f:
            java.lang.Object r4 = r11.get(r7)
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r7
            r5 = r15
            r6 = r24
            r19 = r7
            r7 = r25
            r14 = r8
            r8 = r13
            int r2 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 17
            if (r2 != r0) goto L_0x009c
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r2 = 17
            r0 = r20
            r1 = r15
            r3 = r19
            r4 = r19
            r0.zzJ(r1, r2, r3, r4, r5)
        L_0x0099:
            r6 = r19
            goto L_0x00be
        L_0x009c:
            if (r2 == 0) goto L_0x0099
            java.lang.String r0 = "_ev"
            r6 = r19
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x00be
            r0 = 21
            if (r2 != r0) goto L_0x00ae
            r3 = r10
            goto L_0x00af
        L_0x00ae:
            r3 = r6
        L_0x00af:
            java.lang.Object r5 = r11.get(r6)
            r0 = r20
            r1 = r15
            r4 = r6
            r0.zzJ(r1, r2, r3, r4, r5)
            r15.remove(r6)
            goto L_0x0108
        L_0x00be:
            boolean r0 = zzai(r6)
            if (r0 == 0) goto L_0x0108
            int r0 = r18 + 1
            if (r0 <= r14) goto L_0x0106
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Event can't contain more than "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r2 = " params"
            r1.append(r2)
            com.google.android.gms.measurement.internal.zzfr r2 = r9.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zze()
            java.lang.String r1 = r1.toString()
            com.google.android.gms.measurement.internal.zzfr r3 = r9.zzt
            com.google.android.gms.measurement.internal.zzec r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r10)
            com.google.android.gms.measurement.internal.zzfr r4 = r9.zzt
            com.google.android.gms.measurement.internal.zzec r4 = r4.zzj()
            java.lang.String r4 = r4.zzb(r11)
            r2.zzc(r1, r3, r4)
            r1 = 5
            zzao(r15, r1)
            r15.remove(r6)
        L_0x0106:
            r18 = r0
        L_0x0108:
            r8 = r14
            goto L_0x0030
        L_0x010b:
            r14 = r15
            goto L_0x010e
        L_0x010d:
            r14 = 0
        L_0x010e:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlb.zzy(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    public final zzaw zzz(String str, String str2, Bundle bundle, String str3, long j10, boolean z10, boolean z11) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzh(str2) == 0) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            Bundle zzy = zzy(str, str2, bundle3, CollectionUtils.listOf("_o"), true);
            if (z10) {
                zzy = zzt(zzy);
            }
            Preconditions.checkNotNull(zzy);
            return new zzaw(str2, new zzau(zzy), str3, j10);
        }
        this.zzt.zzay().zzd().zzb("Invalid conditional property event name", this.zzt.zzj().zzf(str2));
        throw new IllegalArgumentException();
    }
}
