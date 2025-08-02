package g3;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import p5.a;
import y2.l;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f21692a = Uri.withAppendedPath((Uri) a.e(ContactsContract.AUTHORITY_URI), "display_photo");

    public static AssetFileDescriptor a(ContentResolver contentResolver, Uri uri) {
        if (l(uri)) {
            try {
                return contentResolver.openAssetFileDescriptor(uri, "r");
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    private static String b(boolean z10) {
        return "_data";
    }

    private static Uri c(boolean z10) {
        if (z10) {
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    private static String d(boolean z10) {
        return "_id";
    }

    public static String e(ContentResolver contentResolver, Uri uri) {
        boolean z10;
        String[] strArr;
        String str;
        Uri uri2;
        int columnIndexOrThrow;
        String type = contentResolver.getType(uri);
        String str2 = null;
        if (l(uri)) {
            if (type == null || !type.startsWith("video/")) {
                z10 = false;
            } else {
                z10 = true;
            }
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String documentId = DocumentsContract.getDocumentId(uri);
                l.g(documentId);
                String[] strArr2 = {documentId.split(":")[1]};
                uri2 = (Uri) l.g(c(z10));
                str = d(z10) + "=?";
                strArr = strArr2;
            } else {
                uri2 = uri;
                str = null;
                strArr = null;
            }
            Cursor query = contentResolver.query(uri2, new String[]{b(z10)}, str, strArr, (String) null);
            if (query != null) {
                try {
                    if (query.moveToFirst() && (columnIndexOrThrow = query.getColumnIndexOrThrow(b(z10))) != -1) {
                        str2 = query.getString(columnIndexOrThrow);
                    }
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            if (query == null) {
                return str2;
            }
            query.close();
            return str2;
        } else if (m(uri)) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    public static String f(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    public static Uri g(int i10) {
        return new Uri.Builder().scheme("res").path(String.valueOf(i10)).build();
    }

    public static boolean h(Uri uri) {
        return "data".equals(f(uri));
    }

    public static boolean i(Uri uri) {
        return "asset".equals(f(uri));
    }

    public static boolean j(Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString())) {
            return true;
        }
        return false;
    }

    public static boolean k(Uri uri) {
        if (uri.getPath() != null && l(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith((String) a.e(f21692a.getPath()))) {
            return true;
        }
        return false;
    }

    public static boolean l(Uri uri) {
        return FirebaseAnalytics.Param.CONTENT.equals(f(uri));
    }

    public static boolean m(Uri uri) {
        return "file".equals(f(uri));
    }

    public static boolean n(Uri uri) {
        return "res".equals(f(uri));
    }

    public static boolean o(Uri uri) {
        String f10 = f(uri);
        if ("https".equals(f10) || "http".equals(f10)) {
            return true;
        }
        return false;
    }

    public static boolean p(Uri uri) {
        return "android.resource".equals(f(uri));
    }

    public static URL q(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URL(uri.toString());
        } catch (MalformedURLException e10) {
            throw new RuntimeException(e10);
        }
    }
}
