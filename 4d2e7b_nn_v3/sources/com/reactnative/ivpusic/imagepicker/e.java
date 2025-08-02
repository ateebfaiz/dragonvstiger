package com.reactnative.ivpusic.imagepicker;

import android.content.Context;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

abstract class e {
    /* JADX WARNING: type inference failed for: r8v4, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r9, android.net.Uri r10, java.lang.String r11, java.lang.String[] r12) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String r1 = "_display_name"
            java.lang.String[] r4 = new java.lang.String[]{r0, r1}
            r8 = 0
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch:{ all -> 0x0050 }
            r7 = 0
            r3 = r10
            r5 = r11
            r6 = r12
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0050 }
            if (r11 == 0) goto L_0x004a
            boolean r12 = r11.moveToFirst()     // Catch:{ all -> 0x0029 }
            if (r12 == 0) goto L_0x004a
            int r12 = r11.getColumnIndex(r0)     // Catch:{ all -> 0x0029 }
            r0 = -1
            if (r12 <= r0) goto L_0x002c
            java.lang.String r8 = r11.getString(r12)     // Catch:{ all -> 0x0029 }
            goto L_0x002c
        L_0x0029:
            r9 = move-exception
            r8 = r11
            goto L_0x0051
        L_0x002c:
            if (r8 == 0) goto L_0x0036
            java.lang.String r9 = r11.getString(r12)     // Catch:{ all -> 0x0029 }
            r11.close()
            return r9
        L_0x0036:
            int r12 = r11.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0029 }
            java.lang.String r12 = r11.getString(r12)     // Catch:{ all -> 0x0029 }
            java.io.File r9 = d(r9, r12, r10)     // Catch:{ all -> 0x0029 }
            java.lang.String r9 = r9.getAbsolutePath()     // Catch:{ all -> 0x0029 }
            r11.close()
            return r9
        L_0x004a:
            if (r11 == 0) goto L_0x004f
            r11.close()
        L_0x004f:
            return r8
        L_0x0050:
            r9 = move-exception
        L_0x0051:
            if (r8 == 0) goto L_0x0056
            r8.close()
        L_0x0056:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnative.ivpusic.imagepicker.e.a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    static String b(Context context, Uri uri) {
        if (FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(uri.getScheme())) {
            if (c(uri)) {
                return uri.getLastPathSegment();
            }
            return a(context, uri, (String) null, (String[]) null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    private static boolean c(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    private static File d(Context context, String str, Uri uri) {
        String str2 = context.getCacheDir() + "/react-native-image-crop-picker";
        new File(str2).mkdir();
        File file = new File(new File(str2), str.substring(str.lastIndexOf(47) + 1));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[8192];
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            while (true) {
                int read = openInputStream.read(bArr, 0, 8192);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            openInputStream.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return file;
    }
}
