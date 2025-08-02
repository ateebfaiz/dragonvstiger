package com.appsflyer.internal;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.pdns.f;

public final class AFe1ySDK {
    private static boolean AFInAppEventParameterName = false;
    private static char[] AFInAppEventType = null;
    private static boolean AFKeystoreWrapper = false;
    private static int afInfoLog = 1;
    private static int valueOf;
    private static int values = ((afInfoLog + 115) % 128);

    static {
        AFKeystoreWrapper();
        ViewConfiguration.getJumpTapTimeout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
        return r7.substring(0, 12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002e, code lost:
        if (r7.length() < 45) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0041, code lost:
        if (r7.length() < 12) goto L_0x0043;
     */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String AFInAppEventParameterName(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            int r0 = afInfoLog
            int r0 = r0 + 43
            int r1 = r0 % 128
            values = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 12
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x0031
            r0 = 4
            java.lang.String[] r5 = new java.lang.String[r0]
            r6 = 1
            r5[r6] = r8
            r5[r6] = r9
            r8 = 3
            r5[r8] = r10
            r5[r0] = r11
            r5[r1] = r4
            java.lang.String r8 = com.appsflyer.internal.AFb1ySDK.valueOf(r5)
            java.lang.String r7 = com.appsflyer.internal.AFb1ySDK.AFKeystoreWrapper(r8, r7)
            int r8 = r7.length()
            r9 = 45
            if (r8 >= r9) goto L_0x0052
            goto L_0x0043
        L_0x0031:
            java.lang.String[] r8 = new java.lang.String[]{r8, r9, r10, r11, r4}
            java.lang.String r8 = com.appsflyer.internal.AFb1ySDK.valueOf(r8)
            java.lang.String r7 = com.appsflyer.internal.AFb1ySDK.AFKeystoreWrapper(r8, r7)
            int r8 = r7.length()
            if (r8 >= r3) goto L_0x0052
        L_0x0043:
            int r8 = values
            int r8 = r8 + 39
            int r9 = r8 % 128
            afInfoLog = r9
            int r8 = r8 % r1
            if (r8 != 0) goto L_0x0051
            r8 = 13
            int r8 = r8 / r2
        L_0x0051:
            return r7
        L_0x0052:
            java.lang.String r7 = r7.substring(r2, r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1ySDK.AFInAppEventParameterName(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    static void AFKeystoreWrapper() {
        AFKeystoreWrapper = true;
        AFInAppEventType = new char[]{'f', 'j', 'i', 'l', 'e', 'g', 'h', 'k', 'c', 'w', 'd', 't', 'x'};
        AFInAppEventParameterName = true;
        valueOf = 51;
    }

    @NonNull
    private static AFe1tSDK values(@NonNull AFb1iSDK aFb1iSDK, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        AFf1tSDK aFf1tSDK;
        boolean z10 = false;
        if (str == null) {
            if (aFb1iSDK.valueOf == AFf1qSDK.DEFAULT) {
                z10 = true;
            }
            return new AFe1tSDK(z10, AFf1tSDK.NA);
        }
        String str4 = "";
        Object[] objArr = new Object[1];
        valueOf("", (String) null, (int[]) null, 127 - TextUtils.indexOf(str4, str4), objArr);
        String intern = ((String) objArr[0]).intern();
        if (aFb1iSDK.valueOf == AFf1qSDK.CUSTOM) {
            str4 = new StringBuilder(str2).reverse().toString();
        } else {
            str3 = intern;
        }
        boolean equals = AFInAppEventParameterName(new StringBuilder(str3).reverse().toString(), aFb1iSDK.values, f.f17924q, "v1", str4).equals(str);
        if (equals) {
            aFf1tSDK = AFf1tSDK.SUCCESS;
        } else {
            aFf1tSDK = AFf1tSDK.FAILURE;
        }
        return new AFe1tSDK(equals, aFf1tSDK);
    }

    @NonNull
    public final AFe1tSDK valueOf(@NonNull AFb1iSDK aFb1iSDK, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        int i10 = values;
        int i11 = i10 + 67;
        afInfoLog = i11 % 128;
        if (i11 % 2 != 0) {
            if (!(aFb1iSDK == null || str2 == null)) {
                afInfoLog = (i10 + 51) % 128;
                if (str3 != null) {
                    return values(aFb1iSDK, str, str2, str3);
                }
            }
            afInfoLog = (i10 + 13) % 128;
            return new AFe1tSDK(false, AFf1tSDK.INTERNAL_ERROR);
        }
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void valueOf(java.lang.String r6, java.lang.String r7, int[] r8, int r9, java.lang.Object[] r10) {
        /*
            if (r7 == 0) goto L_0x0006
            char[] r7 = r7.toCharArray()
        L_0x0006:
            char[] r7 = (char[]) r7
            if (r6 == 0) goto L_0x0010
            java.lang.String r0 = "ISO-8859-1"
            byte[] r6 = r6.getBytes(r0)
        L_0x0010:
            byte[] r6 = (byte[]) r6
            java.lang.Object r0 = com.appsflyer.internal.AFg1rSDK.AFInAppEventParameterName
            monitor-enter(r0)
            char[] r1 = AFInAppEventType     // Catch:{ all -> 0x0042 }
            int r2 = valueOf     // Catch:{ all -> 0x0042 }
            boolean r3 = AFInAppEventParameterName     // Catch:{ all -> 0x0042 }
            r4 = 0
            if (r3 == 0) goto L_0x004d
            int r7 = r6.length     // Catch:{ all -> 0x0042 }
            com.appsflyer.internal.AFg1rSDK.values = r7     // Catch:{ all -> 0x0042 }
            char[] r7 = new char[r7]     // Catch:{ all -> 0x0042 }
            com.appsflyer.internal.AFg1rSDK.valueOf = r4     // Catch:{ all -> 0x0042 }
        L_0x0025:
            int r8 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0042 }
            int r3 = com.appsflyer.internal.AFg1rSDK.values     // Catch:{ all -> 0x0042 }
            if (r8 >= r3) goto L_0x0044
            int r8 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0042 }
            int r3 = com.appsflyer.internal.AFg1rSDK.values     // Catch:{ all -> 0x0042 }
            int r3 = r3 + -1
            int r5 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0042 }
            int r3 = r3 - r5
            byte r3 = r6[r3]     // Catch:{ all -> 0x0042 }
            int r3 = r3 + r9
            char r3 = r1[r3]     // Catch:{ all -> 0x0042 }
            int r3 = r3 - r2
            char r3 = (char) r3     // Catch:{ all -> 0x0042 }
            r7[r8] = r3     // Catch:{ all -> 0x0042 }
            int r5 = r5 + 1
            com.appsflyer.internal.AFg1rSDK.valueOf = r5     // Catch:{ all -> 0x0042 }
            goto L_0x0025
        L_0x0042:
            r6 = move-exception
            goto L_0x00ab
        L_0x0044:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0042 }
            r6.<init>(r7)     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            r10[r4] = r6
            return
        L_0x004d:
            boolean r6 = AFKeystoreWrapper     // Catch:{ all -> 0x0042 }
            if (r6 == 0) goto L_0x007e
            int r6 = r7.length     // Catch:{ all -> 0x0042 }
            com.appsflyer.internal.AFg1rSDK.values = r6     // Catch:{ all -> 0x0042 }
            char[] r6 = new char[r6]     // Catch:{ all -> 0x0042 }
            com.appsflyer.internal.AFg1rSDK.valueOf = r4     // Catch:{ all -> 0x0042 }
        L_0x0058:
            int r8 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0042 }
            int r3 = com.appsflyer.internal.AFg1rSDK.values     // Catch:{ all -> 0x0042 }
            if (r8 >= r3) goto L_0x0075
            int r8 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0042 }
            int r3 = com.appsflyer.internal.AFg1rSDK.values     // Catch:{ all -> 0x0042 }
            int r3 = r3 + -1
            int r5 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0042 }
            int r3 = r3 - r5
            char r3 = r7[r3]     // Catch:{ all -> 0x0042 }
            int r3 = r3 - r9
            char r3 = r1[r3]     // Catch:{ all -> 0x0042 }
            int r3 = r3 - r2
            char r3 = (char) r3     // Catch:{ all -> 0x0042 }
            r6[r8] = r3     // Catch:{ all -> 0x0042 }
            int r5 = r5 + 1
            com.appsflyer.internal.AFg1rSDK.valueOf = r5     // Catch:{ all -> 0x0042 }
            goto L_0x0058
        L_0x0075:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0042 }
            r7.<init>(r6)     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            r10[r4] = r7
            return
        L_0x007e:
            int r6 = r8.length     // Catch:{ all -> 0x0042 }
            com.appsflyer.internal.AFg1rSDK.values = r6     // Catch:{ all -> 0x0042 }
            char[] r6 = new char[r6]     // Catch:{ all -> 0x0042 }
            com.appsflyer.internal.AFg1rSDK.valueOf = r4     // Catch:{ all -> 0x0042 }
        L_0x0085:
            int r7 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0042 }
            int r3 = com.appsflyer.internal.AFg1rSDK.values     // Catch:{ all -> 0x0042 }
            if (r7 >= r3) goto L_0x00a2
            int r7 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0042 }
            int r3 = com.appsflyer.internal.AFg1rSDK.values     // Catch:{ all -> 0x0042 }
            int r3 = r3 + -1
            int r5 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch:{ all -> 0x0042 }
            int r3 = r3 - r5
            r3 = r8[r3]     // Catch:{ all -> 0x0042 }
            int r3 = r3 - r9
            char r3 = r1[r3]     // Catch:{ all -> 0x0042 }
            int r3 = r3 - r2
            char r3 = (char) r3     // Catch:{ all -> 0x0042 }
            r6[r7] = r3     // Catch:{ all -> 0x0042 }
            int r5 = r5 + 1
            com.appsflyer.internal.AFg1rSDK.valueOf = r5     // Catch:{ all -> 0x0042 }
            goto L_0x0085
        L_0x00a2:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0042 }
            r7.<init>(r6)     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            r10[r4] = r7
            return
        L_0x00ab:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1ySDK.valueOf(java.lang.String, java.lang.String, int[], int, java.lang.Object[]):void");
    }
}
