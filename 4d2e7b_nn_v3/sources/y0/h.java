package y0;

import androidx.core.os.TraceCompat;
import com.alibaba.pdns.f;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f24850a = new String[5];

    /* renamed from: b  reason: collision with root package name */
    private final long[] f24851b = new long[5];

    /* renamed from: c  reason: collision with root package name */
    private int f24852c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f24853d = 0;

    public void a(String str) {
        int i10 = this.f24852c;
        if (i10 == 5) {
            this.f24853d++;
            return;
        }
        this.f24850a[i10] = str;
        this.f24851b[i10] = System.nanoTime();
        TraceCompat.beginSection(str);
        this.f24852c++;
    }

    public float b(String str) {
        int i10 = this.f24853d;
        if (i10 > 0) {
            this.f24853d = i10 - 1;
            return 0.0f;
        }
        int i11 = this.f24852c - 1;
        this.f24852c = i11;
        if (i11 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else if (str.equals(this.f24850a[i11])) {
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - this.f24851b[this.f24852c])) / 1000000.0f;
        } else {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + this.f24850a[this.f24852c] + f.G);
        }
    }
}
