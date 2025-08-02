package com.appsflyer.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Process;
import androidx.annotation.WorkerThread;
import com.appsflyer.AFLogger;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Map;
import kotlin.jvm.internal.m;

@WorkerThread
public final class AFa1cSDK implements AFc1oSDK {
    private final AFc1wSDK AFInAppEventType;

    public AFa1cSDK() {
    }

    public static boolean AFInAppEventParameterName(Context context, String str) {
        int checkPermission = context.checkPermission(str, Process.myPid(), Process.myUid());
        StringBuilder sb2 = new StringBuilder("is Permission Available: ");
        sb2.append(str);
        sb2.append("; res: ");
        sb2.append(checkPermission);
        AFLogger.afRDLog(sb2.toString());
        return checkPermission == 0;
    }

    public static boolean AFInAppEventType() {
        return Build.BRAND.equals("OPPO");
    }

    public static long AFKeystoreWrapper(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo.getLongVersionCode();
            }
            return (long) packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            AFLogger.afErrorLog(e10.getMessage(), e10);
            return 0;
        }
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String valueOf(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException, CertificateException, NoSuchAlgorithmException {
        Signature[] signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        if (signatureArr == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        instance.update(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getEncoded());
        return String.format("%032X", new Object[]{new BigInteger(1, instance.digest())});
    }

    public static boolean values(Context context, Intent intent) {
        return context.getPackageManager().queryIntentServices(intent, 0).size() > 0;
    }

    public AFa1cSDK(AFc1wSDK aFc1wSDK) {
        m.f(aFc1wSDK, "");
        this.AFInAppEventType = aFc1wSDK;
    }

    public static String values(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            AFLogger.afErrorLog(e10.getMessage(), e10);
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        if (r2.equals(com.alibaba.pdns.net.d.f18103f) != false) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.Map<java.lang.String, java.lang.String> AFInAppEventParameterName(android.content.Context r11, java.util.Map<java.lang.String, java.lang.String> r12, android.net.Uri r13) {
        /*
            java.lang.String r0 = "install_time"
            java.util.Set r1 = r13.getQueryParameterNames()
            java.util.Iterator r1 = r1.iterator()
        L_0x000a:
            boolean r2 = r1.hasNext()
            java.lang.String r3 = "media_source"
            r4 = 0
            java.lang.String r5 = "agency"
            if (r2 == 0) goto L_0x0069
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r6 = r13.getQueryParameter(r2)
            boolean r7 = r12.containsKey(r2)
            if (r7 != 0) goto L_0x0064
            int r7 = r2.hashCode()
            r8 = -1420799080(0xffffffffab505398, float:-7.4012454E-13)
            r9 = 2
            r10 = 1
            if (r7 == r8) goto L_0x004d
            r8 = 99
            if (r7 == r8) goto L_0x0044
            r4 = 110987(0x1b18b, float:1.55526E-40)
            if (r7 == r4) goto L_0x003a
            goto L_0x0057
        L_0x003a:
            java.lang.String r4 = "pid"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0057
            r4 = r10
            goto L_0x0058
        L_0x0044:
            java.lang.String r7 = "c"
            boolean r7 = r2.equals(r7)
            if (r7 == 0) goto L_0x0057
            goto L_0x0058
        L_0x004d:
            java.lang.String r4 = "af_prt"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0057
            r4 = r9
            goto L_0x0058
        L_0x0057:
            r4 = -1
        L_0x0058:
            if (r4 == 0) goto L_0x0061
            if (r4 == r10) goto L_0x0065
            if (r4 == r9) goto L_0x005f
            goto L_0x0064
        L_0x005f:
            r3 = r5
            goto L_0x0065
        L_0x0061:
            java.lang.String r3 = "campaign"
            goto L_0x0065
        L_0x0064:
            r3 = r2
        L_0x0065:
            r12.put(r3, r6)
            goto L_0x000a
        L_0x0069:
            boolean r1 = r12.containsKey(r0)     // Catch:{ Exception -> 0x009c }
            if (r1 != 0) goto L_0x00a2
            java.lang.String r1 = "yyyy-MM-dd HH:mm:ss"
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x009c }
            java.util.Locale r6 = java.util.Locale.US     // Catch:{ Exception -> 0x009c }
            r2.<init>(r1, r6)     // Catch:{ Exception -> 0x009c }
            android.content.pm.PackageManager r1 = r11.getPackageManager()     // Catch:{ Exception -> 0x009c }
            java.lang.String r11 = r11.getPackageName()     // Catch:{ Exception -> 0x009c }
            android.content.pm.PackageInfo r11 = r1.getPackageInfo(r11, r4)     // Catch:{ Exception -> 0x009c }
            long r6 = r11.firstInstallTime     // Catch:{ Exception -> 0x009c }
            java.lang.String r11 = "UTC"
            java.util.TimeZone r11 = java.util.TimeZone.getTimeZone(r11)     // Catch:{ Exception -> 0x009c }
            r2.setTimeZone(r11)     // Catch:{ Exception -> 0x009c }
            java.util.Date r11 = new java.util.Date     // Catch:{ Exception -> 0x009c }
            r11.<init>(r6)     // Catch:{ Exception -> 0x009c }
            java.lang.String r11 = r2.format(r11)     // Catch:{ Exception -> 0x009c }
            r12.put(r0, r11)     // Catch:{ Exception -> 0x009c }
            goto L_0x00a2
        L_0x009c:
            r11 = move-exception
            java.lang.String r0 = "Could not fetch install time. "
            com.appsflyer.AFLogger.afErrorLog(r0, r11)
        L_0x00a2:
            java.lang.String r11 = "af_deeplink"
            boolean r11 = r12.containsKey(r11)
            if (r11 == 0) goto L_0x00b7
            java.lang.String r11 = "af_status"
            boolean r0 = r12.containsKey(r11)
            if (r0 != 0) goto L_0x00b7
            java.lang.String r0 = "Non-organic"
            r12.put(r11, r0)
        L_0x00b7:
            boolean r11 = r12.containsKey(r5)
            if (r11 == 0) goto L_0x00c0
            r12.remove(r3)
        L_0x00c0:
            java.lang.String r11 = r13.getPath()
            if (r11 == 0) goto L_0x00cb
            java.lang.String r0 = "path"
            r12.put(r0, r11)
        L_0x00cb:
            java.lang.String r11 = r13.getScheme()
            if (r11 == 0) goto L_0x00d6
            java.lang.String r0 = "scheme"
            r12.put(r0, r11)
        L_0x00d6:
            java.lang.String r11 = r13.getHost()
            if (r11 == 0) goto L_0x00e1
            java.lang.String r13 = "host"
            r12.put(r13, r11)
        L_0x00e1:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1cSDK.AFInAppEventParameterName(android.content.Context, java.util.Map, android.net.Uri):java.util.Map");
    }

    public final void values(byte[] bArr, Map<String, String> map, int i10) {
        m.f(bArr, "");
        m.f(bArr, "");
        if (new AFc1iSDK(bArr, map, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE).AFInAppEventType()) {
            this.AFInAppEventType.values();
        }
    }
}
