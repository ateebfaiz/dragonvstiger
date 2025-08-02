package com.livechatinc.inappchat;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.firebase.analytics.FirebaseAnalytics;

public abstract class k {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ all -> 0x0030 }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0030 }
            if (r8 == 0) goto L_0x002a
            boolean r9 = r8.moveToFirst()     // Catch:{ all -> 0x0027 }
            if (r9 == 0) goto L_0x002a
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x0027 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ all -> 0x0027 }
            r8.close()
            return r9
        L_0x0027:
            r9 = move-exception
            r7 = r8
            goto L_0x0031
        L_0x002a:
            if (r8 == 0) goto L_0x002f
            r8.close()
        L_0x002f:
            return r7
        L_0x0030:
            r9 = move-exception
        L_0x0031:
            if (r7 == 0) goto L_0x0036
            r7.close()
        L_0x0036:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livechatinc.inappchat.k.a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    private static String b(Context context, Uri uri) {
        return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), (String) null, (String[]) null);
    }

    private static String c(Uri uri) {
        String[] split = DocumentsContract.getDocumentId(uri).split(":");
        String str = split[0];
        String str2 = split[1];
        if (!"primary".equalsIgnoreCase(str)) {
            return uri.getPath();
        }
        return Environment.getExternalStorageDirectory() + DomExceptionUtils.SEPARATOR + str2;
    }

    private static String d(Context context, Uri uri) {
        if (k(uri)) {
            return c(uri);
        }
        if (j(uri)) {
            return b(context, uri);
        }
        if (l(uri)) {
            return e(context, uri);
        }
        return uri.getPath();
    }

    private static String e(Context context, Uri uri) {
        String[] split = DocumentsContract.getDocumentId(uri).split(":");
        return a(context, g(split[0]), "_id=?", new String[]{split[1]});
    }

    public static String f(Context context, Uri uri) {
        if (m() && i(context, uri)) {
            return d(context, uri);
        }
        if (h(uri)) {
            return a(context, uri, (String) null, (String[]) null);
        }
        return uri.getPath();
    }

    private static Uri g(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case 93166550:
                if (str.equals("audio")) {
                    c10 = 0;
                    break;
                }
                break;
            case 100313435:
                if (str.equals("image")) {
                    c10 = 1;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            case 1:
                return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            case 2:
                return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            default:
                return null;
        }
    }

    private static boolean h(Uri uri) {
        return FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(uri.getScheme());
    }

    private static boolean i(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public static boolean j(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean k(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean l(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private static boolean m() {
        return true;
    }
}
