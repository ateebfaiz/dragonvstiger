package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

class d extends DocumentFile {

    /* renamed from: a  reason: collision with root package name */
    private Context f15363a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f15364b;

    d(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.f15363a = context;
        this.f15364b = uri;
    }

    private static void a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    private static Uri b(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean canRead() {
        return a.a(this.f15363a, this.f15364b);
    }

    public boolean canWrite() {
        return a.b(this.f15363a, this.f15364b);
    }

    public DocumentFile createDirectory(String str) {
        Uri b10 = b(this.f15363a, this.f15364b, "vnd.android.document/directory", str);
        if (b10 != null) {
            return new d(this, this.f15363a, b10);
        }
        return null;
    }

    public DocumentFile createFile(String str, String str2) {
        Uri b10 = b(this.f15363a, this.f15364b, str, str2);
        if (b10 != null) {
            return new d(this, this.f15363a, b10);
        }
        return null;
    }

    public boolean delete() {
        try {
            return DocumentsContract.deleteDocument(this.f15363a.getContentResolver(), this.f15364b);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean exists() {
        return a.d(this.f15363a, this.f15364b);
    }

    public String getName() {
        return a.f(this.f15363a, this.f15364b);
    }

    public String getType() {
        return a.h(this.f15363a, this.f15364b);
    }

    public Uri getUri() {
        return this.f15364b;
    }

    public boolean isDirectory() {
        return a.i(this.f15363a, this.f15364b);
    }

    public boolean isFile() {
        return a.j(this.f15363a, this.f15364b);
    }

    public boolean isVirtual() {
        return a.k(this.f15363a, this.f15364b);
    }

    public long lastModified() {
        return a.l(this.f15363a, this.f15364b);
    }

    public long length() {
        return a.m(this.f15363a, this.f15364b);
    }

    public DocumentFile[] listFiles() {
        ContentResolver contentResolver = this.f15363a.getContentResolver();
        Uri uri = this.f15364b;
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, (String) null, (String[]) null, (String) null);
            while (cursor.moveToNext()) {
                arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.f15364b, cursor.getString(0)));
            }
        } catch (Exception e10) {
            Log.w("DocumentFile", "Failed query: " + e10);
        } catch (Throwable th) {
            a((AutoCloseable) null);
            throw th;
        }
        a(cursor);
        Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
        DocumentFile[] documentFileArr = new DocumentFile[uriArr.length];
        for (int i10 = 0; i10 < uriArr.length; i10++) {
            documentFileArr[i10] = new d(this, this.f15363a, uriArr[i10]);
        }
        return documentFileArr;
    }

    public boolean renameTo(String str) {
        try {
            Uri renameDocument = DocumentsContract.renameDocument(this.f15363a.getContentResolver(), this.f15364b, str);
            if (renameDocument != null) {
                this.f15364b = renameDocument;
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
