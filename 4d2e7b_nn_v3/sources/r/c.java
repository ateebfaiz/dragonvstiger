package r;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

public class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public final File f23563a;

    /* renamed from: b  reason: collision with root package name */
    public final long f23564b;

    /* renamed from: c  reason: collision with root package name */
    public final long f23565c;

    public c(File file) {
        this.f23563a = file;
        this.f23564b = -1;
        this.f23565c = 0;
    }

    public final boolean a() {
        if (this.f23564b == -1 && this.f23565c == 0) {
            return true;
        }
        return false;
    }

    public byte[] b(String str) {
        File file;
        if (!TextUtils.equals(str, "gzip") || (file = this.f23563a) == null) {
            return null;
        }
        if (!file.exists()) {
            this.f23563a.getAbsolutePath();
            return null;
        } else if (!a()) {
            return i.c.j(this.f23563a, this.f23564b, this.f23565c);
        } else {
            try {
                return i.c.r(this.f23563a);
            } catch (IOException unused) {
                return null;
            }
        }
    }

    public c(File file, long j10, long j11) {
        this.f23563a = file;
        this.f23564b = j10;
        this.f23565c = j11;
    }
}
