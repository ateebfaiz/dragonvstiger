package b8;

import com.facebook.soloader.m;
import java.io.File;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f2500a;

    /* renamed from: b  reason: collision with root package name */
    private int f2501b;

    public a(int i10) {
        if (i10 > 0) {
            this.f2500a = new String[i10];
            this.f2501b = 0;
            return;
        }
        throw new IllegalArgumentException();
    }

    public synchronized boolean a(String str) {
        for (String equals : this.f2500a) {
            if (str.equals(equals)) {
                return false;
            }
        }
        StringBuilder sb2 = new StringBuilder("Recording new base apk path: ");
        sb2.append(str);
        sb2.append("\n");
        b(sb2);
        m.g("SoLoader", sb2.toString());
        String[] strArr = this.f2500a;
        int i10 = this.f2501b;
        strArr[i10 % strArr.length] = str;
        this.f2501b = i10 + 1;
        return true;
    }

    public synchronized void b(StringBuilder sb2) {
        String str;
        try {
            sb2.append("Previously recorded ");
            sb2.append(this.f2501b);
            sb2.append(" base apk paths.");
            if (this.f2501b > 0) {
                sb2.append(" Most recent ones:");
            }
            int i10 = 0;
            while (true) {
                String[] strArr = this.f2500a;
                if (i10 < strArr.length) {
                    int i11 = (this.f2501b - i10) - 1;
                    if (i11 >= 0) {
                        String str2 = strArr[i11 % strArr.length];
                        sb2.append("\n");
                        sb2.append(str2);
                        sb2.append(" (");
                        if (new File(str2).exists()) {
                            str = "exists";
                        } else {
                            str = "does not exist";
                        }
                        sb2.append(str);
                        sb2.append(")");
                    }
                    i10++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int c() {
        return this.f2501b;
    }
}
