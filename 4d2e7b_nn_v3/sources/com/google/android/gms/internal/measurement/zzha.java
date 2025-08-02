package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public final class zzha {
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri zzb = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    static HashMap zze;
    static final HashMap zzf = new HashMap();
    static final HashMap zzg = new HashMap();
    static final HashMap zzh = new HashMap();
    static final HashMap zzi = new HashMap();
    static final String[] zzj = new String[0];
    /* access modifiers changed from: private */
    public static final AtomicBoolean zzk = new AtomicBoolean();
    private static Object zzl;
    private static boolean zzm;

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006e, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        r10 = r10.query(zza, (java.lang.String[]) null, (java.lang.String) null, new java.lang.String[]{r11}, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0081, code lost:
        if (r10 != null) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0083, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        if (r10.moveToFirst() != false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008a, code lost:
        zzc(r0, r11, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0090, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r12 = r10.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0097, code lost:
        if (r12 == null) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009d, code lost:
        if (r12.equals((java.lang.Object) null) == false) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009f, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a0, code lost:
        zzc(r0, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a3, code lost:
        if (r12 != null) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
        r3 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a7, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00aa, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ab, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ae, code lost:
        throw r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zza(android.content.ContentResolver r10, java.lang.String r11, java.lang.String r12) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.zzha> r12 = com.google.android.gms.internal.measurement.zzha.class
            monitor-enter(r12)
            java.util.HashMap r0 = zze     // Catch:{ all -> 0x002a }
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x002d
            java.util.concurrent.atomic.AtomicBoolean r0 = zzk     // Catch:{ all -> 0x002a }
            r0.set(r2)     // Catch:{ all -> 0x002a }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x002a }
            r0.<init>()     // Catch:{ all -> 0x002a }
            zze = r0     // Catch:{ all -> 0x002a }
            java.lang.Object r0 = new java.lang.Object     // Catch:{ all -> 0x002a }
            r0.<init>()     // Catch:{ all -> 0x002a }
            zzl = r0     // Catch:{ all -> 0x002a }
            zzm = r2     // Catch:{ all -> 0x002a }
            android.net.Uri r0 = zza     // Catch:{ all -> 0x002a }
            com.google.android.gms.internal.measurement.q1 r2 = new com.google.android.gms.internal.measurement.q1     // Catch:{ all -> 0x002a }
            r2.<init>(r3)     // Catch:{ all -> 0x002a }
            r10.registerContentObserver(r0, r1, r2)     // Catch:{ all -> 0x002a }
            goto L_0x0057
        L_0x002a:
            r10 = move-exception
            goto L_0x00af
        L_0x002d:
            java.util.concurrent.atomic.AtomicBoolean r0 = zzk     // Catch:{ all -> 0x002a }
            boolean r0 = r0.getAndSet(r2)     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0057
            java.util.HashMap r0 = zze     // Catch:{ all -> 0x002a }
            r0.clear()     // Catch:{ all -> 0x002a }
            java.util.HashMap r0 = zzf     // Catch:{ all -> 0x002a }
            r0.clear()     // Catch:{ all -> 0x002a }
            java.util.HashMap r0 = zzg     // Catch:{ all -> 0x002a }
            r0.clear()     // Catch:{ all -> 0x002a }
            java.util.HashMap r0 = zzh     // Catch:{ all -> 0x002a }
            r0.clear()     // Catch:{ all -> 0x002a }
            java.util.HashMap r0 = zzi     // Catch:{ all -> 0x002a }
            r0.clear()     // Catch:{ all -> 0x002a }
            java.lang.Object r0 = new java.lang.Object     // Catch:{ all -> 0x002a }
            r0.<init>()     // Catch:{ all -> 0x002a }
            zzl = r0     // Catch:{ all -> 0x002a }
            zzm = r2     // Catch:{ all -> 0x002a }
        L_0x0057:
            java.lang.Object r0 = zzl     // Catch:{ all -> 0x002a }
            java.util.HashMap r2 = zze     // Catch:{ all -> 0x002a }
            boolean r2 = r2.containsKey(r11)     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x006f
            java.util.HashMap r10 = zze     // Catch:{ all -> 0x002a }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ all -> 0x002a }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x002a }
            if (r10 != 0) goto L_0x006c
            goto L_0x006d
        L_0x006c:
            r3 = r10
        L_0x006d:
            monitor-exit(r12)     // Catch:{ all -> 0x002a }
            return r3
        L_0x006f:
            java.lang.String[] r2 = zzj     // Catch:{ all -> 0x002a }
            int r2 = r2.length     // Catch:{ all -> 0x002a }
            monitor-exit(r12)     // Catch:{ all -> 0x002a }
            android.net.Uri r5 = zza
            java.lang.String[] r8 = new java.lang.String[]{r11}
            r7 = 0
            r9 = 0
            r6 = 0
            r4 = r10
            android.database.Cursor r10 = r4.query(r5, r6, r7, r8, r9)
            if (r10 != 0) goto L_0x0084
            return r3
        L_0x0084:
            boolean r12 = r10.moveToFirst()     // Catch:{ all -> 0x0091 }
            if (r12 != 0) goto L_0x0093
            zzc(r0, r11, r3)     // Catch:{ all -> 0x0091 }
            r10.close()
            return r3
        L_0x0091:
            r11 = move-exception
            goto L_0x00ab
        L_0x0093:
            java.lang.String r12 = r10.getString(r1)     // Catch:{ all -> 0x0091 }
            if (r12 == 0) goto L_0x00a0
            boolean r1 = r12.equals(r3)     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x00a0
            r12 = r3
        L_0x00a0:
            zzc(r0, r11, r12)     // Catch:{ all -> 0x0091 }
            if (r12 != 0) goto L_0x00a6
            goto L_0x00a7
        L_0x00a6:
            r3 = r12
        L_0x00a7:
            r10.close()
            return r3
        L_0x00ab:
            r10.close()
            throw r11
        L_0x00af:
            monitor-exit(r12)     // Catch:{ all -> 0x002a }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzha.zza(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    private static void zzc(Object obj, String str, String str2) {
        synchronized (zzha.class) {
            try {
                if (obj == zzl) {
                    zze.put(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
