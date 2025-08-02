package com.appsflyer.internal;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AppCompatDelegate;
import com.appsflyer.AFLogger;
import java.lang.ref.WeakReference;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public final class AFb1ySDK {
    private static int AFInAppEventParameterName = 1;
    private static int AFKeystoreWrapper = 0;
    private static long values = -3426542386320976008L;

    public static String AFInAppEventParameterName(String str) {
        AFKeystoreWrapper = (AFInAppEventParameterName + 59) % 128;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes());
            String AFKeystoreWrapper2 = AFKeystoreWrapper(instance.digest());
            AFKeystoreWrapper = (AFInAppEventParameterName + 67) % 128;
            return AFKeystoreWrapper2;
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder("Error turning ");
            sb2.append(str.substring(0, 6));
            sb2.append(".. to SHA-256");
            AFLogger.afErrorLog(sb2.toString(), e10);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r3 = r0;
        r0 = r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFKeystoreWrapper(java.lang.String r5) {
        /*
            int r0 = AFKeystoreWrapper
            int r0 = r0 + 35
            int r1 = r0 % 128
            AFInAppEventParameterName = r1
            int r0 = r0 % 2
            java.lang.String r1 = "UTF-8"
            java.lang.String r2 = "SHA-1"
            r3 = 0
            if (r0 == 0) goto L_0x002a
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0028 }
            r0.reset()     // Catch:{ Exception -> 0x0028 }
            byte[] r1 = r5.getBytes(r1)     // Catch:{ Exception -> 0x0028 }
            r0.update(r1)     // Catch:{ Exception -> 0x0028 }
            byte[] r0 = r0.digest()     // Catch:{ Exception -> 0x0028 }
            java.lang.String r5 = values((byte[]) r0)     // Catch:{ Exception -> 0x0028 }
            goto L_0x0063
        L_0x0028:
            r0 = move-exception
            goto L_0x0046
        L_0x002a:
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0028 }
            r0.reset()     // Catch:{ Exception -> 0x0028 }
            byte[] r1 = r5.getBytes(r1)     // Catch:{ Exception -> 0x0028 }
            r0.update(r1)     // Catch:{ Exception -> 0x0028 }
            byte[] r0 = r0.digest()     // Catch:{ Exception -> 0x0028 }
            java.lang.String r0 = values((byte[]) r0)     // Catch:{ Exception -> 0x0028 }
            throw r3     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
        L_0x0041:
            r5 = move-exception
            throw r5
        L_0x0043:
            r1 = move-exception
            r3 = r0
            r0 = r1
        L_0x0046:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Error turning "
            r1.<init>(r2)
            r2 = 0
            r4 = 6
            java.lang.String r5 = r5.substring(r2, r4)
            r1.append(r5)
            java.lang.String r5 = ".. to SHA1"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            com.appsflyer.AFLogger.afErrorLog(r5, r0)
            r5 = r3
        L_0x0063:
            int r0 = AFKeystoreWrapper
            int r0 = r0 + 17
            int r0 = r0 % 128
            AFInAppEventParameterName = r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1ySDK.AFKeystoreWrapper(java.lang.String):java.lang.String");
    }

    public static String valueOf(String... strArr) {
        AFInAppEventParameterName = (AFKeystoreWrapper + 35) % 128;
        String join = TextUtils.join("⁣", strArr);
        AFKeystoreWrapper = (AFInAppEventParameterName + 91) % 128;
        return join;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r3 = r0;
        r0 = r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String values(java.lang.String r5) {
        /*
            int r0 = AFKeystoreWrapper
            int r0 = r0 + 81
            int r1 = r0 % 128
            AFInAppEventParameterName = r1
            int r0 = r0 % 2
            java.lang.String r1 = "UTF-8"
            java.lang.String r2 = "MD5"
            r3 = 0
            if (r0 == 0) goto L_0x002a
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0028 }
            r0.reset()     // Catch:{ Exception -> 0x0028 }
            byte[] r1 = r5.getBytes(r1)     // Catch:{ Exception -> 0x0028 }
            r0.update(r1)     // Catch:{ Exception -> 0x0028 }
            byte[] r0 = r0.digest()     // Catch:{ Exception -> 0x0028 }
            java.lang.String r5 = values((byte[]) r0)     // Catch:{ Exception -> 0x0028 }
            goto L_0x0063
        L_0x0028:
            r0 = move-exception
            goto L_0x0046
        L_0x002a:
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0028 }
            r0.reset()     // Catch:{ Exception -> 0x0028 }
            byte[] r1 = r5.getBytes(r1)     // Catch:{ Exception -> 0x0028 }
            r0.update(r1)     // Catch:{ Exception -> 0x0028 }
            byte[] r0 = r0.digest()     // Catch:{ Exception -> 0x0028 }
            java.lang.String r0 = values((byte[]) r0)     // Catch:{ Exception -> 0x0028 }
            throw r3     // Catch:{ Exception -> 0x0043, all -> 0x0041 }
        L_0x0041:
            r5 = move-exception
            throw r5
        L_0x0043:
            r1 = move-exception
            r3 = r0
            r0 = r1
        L_0x0046:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Error turning "
            r1.<init>(r2)
            r2 = 0
            r4 = 6
            java.lang.String r5 = r5.substring(r2, r4)
            r1.append(r5)
            java.lang.String r5 = ".. to MD5"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            com.appsflyer.AFLogger.afErrorLog(r5, r0)
            r5 = r3
        L_0x0063:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1ySDK.values(java.lang.String):java.lang.String");
    }

    public static String AFInAppEventParameterName(Map<String, Object> map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((String) map.get("appsflyerKey"));
        Object[] objArr = new Object[1];
        AFInAppEventParameterName("휙⟛㚭Ճᐅ擌玃䉨儤ꇴ낧轿", (SystemClock.uptimeMillis() > 0 ? 1 : (SystemClock.uptimeMillis() == 0 ? 0 : -1)) + 61636, objArr);
        sb2.append(map.get(((String) objArr[0]).intern()));
        String obj = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append(map.get("uid"));
        String obj2 = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(obj2);
        sb4.append(map.get("installDate"));
        String obj3 = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(obj3);
        sb5.append(map.get("counter"));
        String obj4 = sb5.toString();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(obj4);
        sb6.append(map.get("iaecounter"));
        String AFKeystoreWrapper2 = AFKeystoreWrapper(values(sb6.toString()));
        AFInAppEventParameterName = (AFKeystoreWrapper + 117) % 128;
        return AFKeystoreWrapper2;
    }

    private static String values(byte[] bArr) {
        Formatter formatter = new Formatter();
        int length = bArr.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = AFKeystoreWrapper + 33;
            AFInAppEventParameterName = i11 % 128;
            if (i11 % 2 == 0) {
                Object[] objArr = new Object[1];
                objArr[1] = Byte.valueOf(bArr[i10]);
                formatter.format("%02x", objArr);
                i10 += 19;
            } else {
                formatter.format("%02x", new Object[]{Byte.valueOf(bArr[i10])});
                i10++;
            }
        }
        String obj = formatter.toString();
        formatter.close();
        int i12 = AFInAppEventParameterName + 121;
        AFKeystoreWrapper = i12 % 128;
        if (i12 % 2 != 0) {
            int i13 = 78 / 0;
        }
        return obj;
    }

    private static String AFKeystoreWrapper(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            AFKeystoreWrapper = (AFInAppEventParameterName + 93) % 128;
            sb2.append(Integer.toString((b10 & 255) + 256, 16).substring(1));
        }
        String obj = sb2.toString();
        AFKeystoreWrapper = (AFInAppEventParameterName + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) % 128;
        return obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void AFInAppEventParameterName(java.lang.String r7, int r8, java.lang.Object[] r9) {
        /*
            if (r7 == 0) goto L_0x0006
            char[] r7 = r7.toCharArray()
        L_0x0006:
            char[] r7 = (char[]) r7
            java.lang.Object r0 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper
            monitor-enter(r0)
            com.appsflyer.internal.AFg1tSDK.AFInAppEventType = r8     // Catch:{ all -> 0x002d }
            int r8 = r7.length     // Catch:{ all -> 0x002d }
            char[] r8 = new char[r8]     // Catch:{ all -> 0x002d }
            r1 = 0
            com.appsflyer.internal.AFg1tSDK.AFInAppEventParameterName = r1     // Catch:{ all -> 0x002d }
        L_0x0013:
            int r2 = com.appsflyer.internal.AFg1tSDK.AFInAppEventParameterName     // Catch:{ all -> 0x002d }
            int r3 = r7.length     // Catch:{ all -> 0x002d }
            if (r2 >= r3) goto L_0x002f
            char r3 = r7[r2]     // Catch:{ all -> 0x002d }
            int r4 = com.appsflyer.internal.AFg1tSDK.AFInAppEventType     // Catch:{ all -> 0x002d }
            int r4 = r4 * r2
            r3 = r3 ^ r4
            long r3 = (long) r3     // Catch:{ all -> 0x002d }
            long r5 = values     // Catch:{ all -> 0x002d }
            long r3 = r3 ^ r5
            int r3 = (int) r3     // Catch:{ all -> 0x002d }
            char r3 = (char) r3     // Catch:{ all -> 0x002d }
            r8[r2] = r3     // Catch:{ all -> 0x002d }
            int r2 = com.appsflyer.internal.AFg1tSDK.AFInAppEventParameterName     // Catch:{ all -> 0x002d }
            int r2 = r2 + 1
            com.appsflyer.internal.AFg1tSDK.AFInAppEventParameterName = r2     // Catch:{ all -> 0x002d }
            goto L_0x0013
        L_0x002d:
            r7 = move-exception
            goto L_0x0038
        L_0x002f:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x002d }
            r7.<init>(r8)     // Catch:{ all -> 0x002d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            r9[r1] = r7
            return
        L_0x0038:
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1ySDK.AFInAppEventParameterName(java.lang.String, int, java.lang.Object[]):void");
    }

    public static String AFKeystoreWrapper(String str, String str2) {
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            String lowerCase = AFKeystoreWrapper(instance.doFinal(str.getBytes())).toLowerCase(Locale.getDefault());
            int i10 = AFInAppEventParameterName + 23;
            AFKeystoreWrapper = i10 % 128;
            if (i10 % 2 == 0) {
                return lowerCase;
            }
            throw null;
        } catch (InvalidKeyException | NoSuchAlgorithmException e10) {
            AFLogger.afErrorLog(e10.getMessage(), e10, true);
            return e10.getMessage();
        }
    }

    public static String values(Map<String, Object> map) {
        Object[] objArr = new Object[1];
        AFInAppEventParameterName("휙⟛㚭Ճᐅ擌玃䉨儤ꇴ낧轿", 61638 - (ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1)), objArr);
        String str = (String) map.get(((String) objArr[0]).intern());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((String) map.get("appsflyerKey")).substring(0, 7));
        sb2.append(((String) map.get("uid")).substring(0, 7));
        sb2.append(str.substring(str.length() - 7));
        String AFKeystoreWrapper2 = AFKeystoreWrapper(sb2.toString());
        AFKeystoreWrapper = (AFInAppEventParameterName + 81) % 128;
        return AFKeystoreWrapper2;
    }

    public static boolean AFKeystoreWrapper(Map<String, Object> map, String[] strArr, AFc1zSDK aFc1zSDK) throws IllegalStateException {
        if (map == null || map.isEmpty()) {
            return false;
        }
        int length = strArr.length;
        int i10 = 0;
        while (i10 < length) {
            if (map.containsKey(strArr[i10])) {
                i10++;
                AFKeystoreWrapper = (AFInAppEventParameterName + 107) % 128;
            } else {
                int i11 = AFInAppEventParameterName + 31;
                AFKeystoreWrapper = i11 % 128;
                if (i11 % 2 != 0) {
                    return true;
                }
                return false;
            }
        }
        String str = (String) map.remove("sig");
        if (str == null) {
            return false;
        }
        String valueOf = AFc1zSDK.valueOf();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(new JSONObject(map));
        sb2.append(valueOf);
        return AFKeystoreWrapper(sb2.toString(), AFb1wSDK.AFKeystoreWrapper(new WeakReference(aFc1zSDK.AFKeystoreWrapper.AFKeystoreWrapper))).equals(str);
    }
}
