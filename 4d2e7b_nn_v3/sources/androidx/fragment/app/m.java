package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

final class m extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f15812a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f15813b = new StringBuilder(128);

    m(String str) {
        this.f15812a = str;
    }

    private void a() {
        if (this.f15813b.length() > 0) {
            Log.d(this.f15812a, this.f15813b.toString());
            StringBuilder sb2 = this.f15813b;
            sb2.delete(0, sb2.length());
        }
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == 10) {
                a();
            } else {
                this.f15813b.append(c10);
            }
        }
    }
}
