package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

abstract class a {
    public static boolean a(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(g(context, uri))) {
            return true;
        }
        return false;
    }

    public static boolean b(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String g10 = g(context, uri);
        int n10 = n(context, uri, "flags", 0);
        if (TextUtils.isEmpty(g10)) {
            return false;
        }
        if ((n10 & 4) != 0) {
            return true;
        }
        if ("vnd.android.document/directory".equals(g10) && (n10 & 8) != 0) {
            return true;
        }
        if (TextUtils.isEmpty(g10) || (n10 & 2) == 0) {
            return false;
        }
        return true;
    }

    private static void c(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean d(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        boolean z10 = false;
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, new String[]{"document_id"}, (String) null, (String[]) null, (String) null);
            if (cursor.getCount() > 0) {
                z10 = true;
            }
            return z10;
        } catch (Exception e10) {
            Log.w("DocumentFile", "Failed query: " + e10);
            return false;
        } finally {
            c(cursor);
        }
    }

    public static long e(Context context, Uri uri) {
        return o(context, uri, "flags", 0);
    }

    public static String f(Context context, Uri uri) {
        return p(context, uri, "_display_name", (String) null);
    }

    private static String g(Context context, Uri uri) {
        return p(context, uri, "mime_type", (String) null);
    }

    public static String h(Context context, Uri uri) {
        String g10 = g(context, uri);
        if ("vnd.android.document/directory".equals(g10)) {
            return null;
        }
        return g10;
    }

    public static boolean i(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(g(context, uri));
    }

    public static boolean j(Context context, Uri uri) {
        String g10 = g(context, uri);
        if ("vnd.android.document/directory".equals(g10) || TextUtils.isEmpty(g10)) {
            return false;
        }
        return true;
    }

    public static boolean k(Context context, Uri uri) {
        if (DocumentsContract.isDocumentUri(context, uri) && (e(context, uri) & 512) != 0) {
            return true;
        }
        return false;
    }

    public static long l(Context context, Uri uri) {
        return o(context, uri, "last_modified", 0);
    }

    public static long m(Context context, Uri uri) {
        return o(context, uri, "_size", 0);
    }

    private static int n(Context context, Uri uri, String str, int i10) {
        return (int) o(context, uri, str, (long) i10);
    }

    private static long o(Context context, Uri uri, String str, long j10) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, new String[]{str}, (String) null, (String[]) null, (String) null);
            if (cursor.moveToFirst() && !cursor.isNull(0)) {
                return cursor.getLong(0);
            }
            c(cursor);
            return j10;
        } catch (Exception e10) {
            Log.w("DocumentFile", "Failed query: " + e10);
            return j10;
        } finally {
            c(cursor);
        }
    }

    private static String p(Context context, Uri uri, String str, String str2) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, new String[]{str}, (String) null, (String[]) null, (String) null);
            if (cursor.moveToFirst() && !cursor.isNull(0)) {
                return cursor.getString(0);
            }
            c(cursor);
            return str2;
        } catch (Exception e10) {
            Log.w("DocumentFile", "Failed query: " + e10);
            return str2;
        } finally {
            c(cursor);
        }
    }
}
