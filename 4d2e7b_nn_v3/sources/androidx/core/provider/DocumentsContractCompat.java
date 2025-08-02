package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileNotFoundException;
import java.util.List;

public final class DocumentsContractCompat {
    private static final String PATH_TREE = "tree";

    public static final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 512;

        private DocumentCompat() {
        }
    }

    private static class a {
        @DoNotInline
        static Uri a(String str, String str2) {
            return DocumentsContract.buildChildDocumentsUri(str, str2);
        }

        @DoNotInline
        static Uri b(Uri uri, String str) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(uri, str);
        }

        @DoNotInline
        static Uri c(Uri uri, String str) {
            return DocumentsContract.buildDocumentUriUsingTree(uri, str);
        }

        @DoNotInline
        public static Uri d(String str, String str2) {
            return DocumentsContract.buildTreeDocumentUri(str, str2);
        }

        @DoNotInline
        static Uri e(ContentResolver contentResolver, Uri uri, String str, String str2) throws FileNotFoundException {
            return DocumentsContract.createDocument(contentResolver, uri, str, str2);
        }

        @DoNotInline
        static String f(Uri uri) {
            return DocumentsContract.getTreeDocumentId(uri);
        }

        @DoNotInline
        static Uri g(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
            return DocumentsContract.renameDocument(contentResolver, uri, str);
        }
    }

    private static class b {
        @DoNotInline
        static boolean a(@NonNull Uri uri) {
            return DocumentsContract.isTreeUri(uri);
        }

        @DoNotInline
        static boolean b(ContentResolver contentResolver, Uri uri, Uri uri2) throws FileNotFoundException {
            return DocumentsContract.removeDocument(contentResolver, uri, uri2);
        }
    }

    private DocumentsContractCompat() {
    }

    @Nullable
    public static Uri buildChildDocumentsUri(@NonNull String str, @Nullable String str2) {
        return a.a(str, str2);
    }

    @Nullable
    public static Uri buildChildDocumentsUriUsingTree(@NonNull Uri uri, @NonNull String str) {
        return a.b(uri, str);
    }

    @Nullable
    public static Uri buildDocumentUri(@NonNull String str, @NonNull String str2) {
        return DocumentsContract.buildDocumentUri(str, str2);
    }

    @Nullable
    public static Uri buildDocumentUriUsingTree(@NonNull Uri uri, @NonNull String str) {
        return a.c(uri, str);
    }

    @Nullable
    public static Uri buildTreeDocumentUri(@NonNull String str, @NonNull String str2) {
        return a.d(str, str2);
    }

    @Nullable
    public static Uri createDocument(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull String str, @NonNull String str2) throws FileNotFoundException {
        return a.e(contentResolver, uri, str, str2);
    }

    @Nullable
    public static String getDocumentId(@NonNull Uri uri) {
        return DocumentsContract.getDocumentId(uri);
    }

    @Nullable
    public static String getTreeDocumentId(@NonNull Uri uri) {
        return a.f(uri);
    }

    public static boolean isDocumentUri(@NonNull Context context, @Nullable Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public static boolean isTreeUri(@NonNull Uri uri) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.a(uri);
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() < 2 || !PATH_TREE.equals(pathSegments.get(0))) {
            return false;
        }
        return true;
    }

    public static boolean removeDocument(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull Uri uri2) throws FileNotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.b(contentResolver, uri, uri2);
        }
        return DocumentsContract.deleteDocument(contentResolver, uri);
    }

    @Nullable
    public static Uri renameDocument(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        return a.g(contentResolver, uri, str);
    }
}
