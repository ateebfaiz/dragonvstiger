package androidx.documentfile.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.alibaba.pdns.f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class b extends DocumentFile {

    /* renamed from: a  reason: collision with root package name */
    private File f15360a;

    b(DocumentFile documentFile, File file) {
        super(documentFile);
        this.f15360a = file;
    }

    private static boolean a(File file) {
        File[] listFiles = file.listFiles();
        boolean z10 = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z10 &= a(file2);
                }
                if (!file2.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + file2);
                    z10 = false;
                }
            }
        }
        return z10;
    }

    private static String b(String str) {
        String mimeTypeFromExtension;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(lastIndexOf + 1).toLowerCase())) == null) {
            return "application/octet-stream";
        }
        return mimeTypeFromExtension;
    }

    public boolean canRead() {
        return this.f15360a.canRead();
    }

    public boolean canWrite() {
        return this.f15360a.canWrite();
    }

    public DocumentFile createDirectory(String str) {
        File file = new File(this.f15360a, str);
        if (file.isDirectory() || file.mkdir()) {
            return new b(this, file);
        }
        return null;
    }

    public DocumentFile createFile(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + f.G + extensionFromMimeType;
        }
        File file = new File(this.f15360a, str2);
        try {
            file.createNewFile();
            return new b(this, file);
        } catch (IOException e10) {
            Log.w("DocumentFile", "Failed to createFile: " + e10);
            return null;
        }
    }

    public boolean delete() {
        a(this.f15360a);
        return this.f15360a.delete();
    }

    public boolean exists() {
        return this.f15360a.exists();
    }

    public String getName() {
        return this.f15360a.getName();
    }

    public String getType() {
        if (this.f15360a.isDirectory()) {
            return null;
        }
        return b(this.f15360a.getName());
    }

    public Uri getUri() {
        return Uri.fromFile(this.f15360a);
    }

    public boolean isDirectory() {
        return this.f15360a.isDirectory();
    }

    public boolean isFile() {
        return this.f15360a.isFile();
    }

    public boolean isVirtual() {
        return false;
    }

    public long lastModified() {
        return this.f15360a.lastModified();
    }

    public long length() {
        return this.f15360a.length();
    }

    public DocumentFile[] listFiles() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.f15360a.listFiles();
        if (listFiles != null) {
            for (File bVar : listFiles) {
                arrayList.add(new b(this, bVar));
            }
        }
        return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    public boolean renameTo(String str) {
        File file = new File(this.f15360a.getParentFile(), str);
        if (!this.f15360a.renameTo(file)) {
            return false;
        }
        this.f15360a = file;
        return true;
    }
}
