package b3;

import java.io.InputStream;
import y2.l;

public class j extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    final h f17168a;

    /* renamed from: b  reason: collision with root package name */
    int f17169b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f17170c = 0;

    public j(h hVar) {
        l.b(Boolean.valueOf(!hVar.isClosed()));
        this.f17168a = (h) l.g(hVar);
    }

    public int available() {
        return this.f17168a.size() - this.f17169b;
    }

    public void mark(int i10) {
        this.f17170c = this.f17169b;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        if (available() <= 0) {
            return -1;
        }
        h hVar = this.f17168a;
        int i10 = this.f17169b;
        this.f17169b = i10 + 1;
        return hVar.c(i10) & 255;
    }

    public void reset() {
        this.f17169b = this.f17170c;
    }

    public long skip(long j10) {
        boolean z10;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        int min = Math.min((int) j10, available());
        this.f17169b += min;
        return (long) min;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i10, int i11) {
        if (i10 < 0 || i11 < 0 || i10 + i11 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i10 + "; regionLength=" + i11);
        }
        int available = available();
        if (available <= 0) {
            return -1;
        }
        if (i11 <= 0) {
            return 0;
        }
        int min = Math.min(available, i11);
        this.f17168a.d(this.f17169b, bArr, i10, min);
        this.f17169b += min;
        return min;
    }
}
