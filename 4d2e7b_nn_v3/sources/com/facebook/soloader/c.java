package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import com.facebook.soloader.c0;
import com.facebook.soloader.k;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;

public class c extends k {
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final int f4788h;

    protected class a extends k.b {

        /* renamed from: e  reason: collision with root package name */
        private final boolean f4789e;

        /* renamed from: f  reason: collision with root package name */
        private final File f4790f;

        /* renamed from: g  reason: collision with root package name */
        private final int f4791g;

        a(k kVar, boolean z10) {
            super(kVar);
            this.f4789e = z10;
            this.f4790f = new File(c.this.f4793d.getApplicationInfo().nativeLibraryDir);
            this.f4791g = c.this.f4788h;
        }

        /* access modifiers changed from: protected */
        public k.a[] k() {
            k.a[] aVarArr = this.f4826a;
            if (aVarArr != null) {
                return aVarArr;
            }
            k.a[] j10 = j();
            this.f4826a = j10;
            if (this.f4789e) {
                m.g("BackupSoSource", "Unconditonally extracting all DSOs from zip");
                return this.f4826a;
            } else if ((this.f4791g & 1) == 0) {
                m.g("BackupSoSource", "Self-extraction preferred (PREFER_ANDROID_LIBS_DRIECTORY not set)");
                return this.f4826a;
            } else {
                for (k.a aVar : j10) {
                    if (m(aVar.f4824c, aVar.f4800a)) {
                        return this.f4826a;
                    }
                }
                k.a[] aVarArr2 = new k.a[0];
                this.f4826a = aVarArr2;
                return aVarArr2;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean m(ZipEntry zipEntry, String str) {
            String name = zipEntry.getName();
            File file = new File(this.f4790f, str);
            try {
                if (!file.getCanonicalPath().startsWith(this.f4790f.getCanonicalPath())) {
                    m.a("BackupSoSource", "Not allowing consideration of " + name + ": " + str + " not in lib dir.");
                    return false;
                } else if (!file.isFile()) {
                    m.g("BackupSoSource", "Allowing consideration of " + name + ": " + str + " not in system lib dir");
                    return true;
                } else {
                    long length = file.length();
                    long size = zipEntry.getSize();
                    if (length != size) {
                        m.g("BackupSoSource", "Allowing consideration of " + file + ": sysdir file length is " + length + ", but the file is " + size + " bytes long in the APK");
                        return true;
                    }
                    m.g("BackupSoSource", "Not allowing consideration of " + name + ": deferring to libdir");
                    return false;
                }
            } catch (IOException e10) {
                m.g("BackupSoSource", "Not allowing consideration of " + name + ": " + str + ", IOException when constructing path: " + e10.toString());
                return false;
            }
        }
    }

    public c(Context context, File file, String str, int i10) {
        super(context, str, file, "^lib/([^/]+)/([^/]+\\.so)$");
        this.f4788h = i10;
    }

    public String c() {
        return "BackupSoSource";
    }

    /* access modifiers changed from: protected */
    public byte[] m() {
        File canonicalFile = this.f4822f.getCanonicalFile();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile.getPath());
            obtain.writeLong(canonicalFile.lastModified());
            obtain.writeInt(SysUtil.g(this.f4793d));
            if ((this.f4788h & 1) == 0) {
                obtain.writeByte((byte) 0);
                return obtain.marshall();
            }
            String str = this.f4793d.getApplicationInfo().nativeLibraryDir;
            if (str == null) {
                obtain.writeByte((byte) 1);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                return marshall;
            }
            File canonicalFile2 = new File(str).getCanonicalFile();
            if (!canonicalFile2.exists()) {
                obtain.writeByte((byte) 1);
                byte[] marshall2 = obtain.marshall();
                obtain.recycle();
                return marshall2;
            }
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile2.getPath());
            obtain.writeLong(canonicalFile2.lastModified());
            byte[] marshall3 = obtain.marshall();
            obtain.recycle();
            return marshall3;
        } finally {
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public c0.e o(boolean z10) {
        return new a(this, z10);
    }

    public boolean v() {
        boolean z10 = false;
        a aVar = new a(this, false);
        try {
            if (aVar.j().length != 0) {
                z10 = true;
            }
            aVar.close();
            return z10;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
