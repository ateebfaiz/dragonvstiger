package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

class c extends DocumentFile {

    /* renamed from: a  reason: collision with root package name */
    private Context f15361a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f15362b;

    c(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.f15361a = context;
        this.f15362b = uri;
    }

    public boolean canRead() {
        return a.a(this.f15361a, this.f15362b);
    }

    public boolean canWrite() {
        return a.b(this.f15361a, this.f15362b);
    }

    public DocumentFile createDirectory(String str) {
        throw new UnsupportedOperationException();
    }

    public DocumentFile createFile(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public boolean delete() {
        try {
            return DocumentsContract.deleteDocument(this.f15361a.getContentResolver(), this.f15362b);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean exists() {
        return a.d(this.f15361a, this.f15362b);
    }

    public String getName() {
        return a.f(this.f15361a, this.f15362b);
    }

    public String getType() {
        return a.h(this.f15361a, this.f15362b);
    }

    public Uri getUri() {
        return this.f15362b;
    }

    public boolean isDirectory() {
        return a.i(this.f15361a, this.f15362b);
    }

    public boolean isFile() {
        return a.j(this.f15361a, this.f15362b);
    }

    public boolean isVirtual() {
        return a.k(this.f15361a, this.f15362b);
    }

    public long lastModified() {
        return a.l(this.f15361a, this.f15362b);
    }

    public long length() {
        return a.m(this.f15361a, this.f15362b);
    }

    public DocumentFile[] listFiles() {
        throw new UnsupportedOperationException();
    }

    public boolean renameTo(String str) {
        throw new UnsupportedOperationException();
    }
}
