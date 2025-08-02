package hc;

import java.io.EOFException;
import java.io.InputStream;

class q1 extends t1 {

    /* renamed from: c  reason: collision with root package name */
    private int f414c;

    /* renamed from: d  reason: collision with root package name */
    private int f415d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f416e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f417f = true;

    q1(InputStream inputStream, int i10) {
        super(inputStream, i10);
        this.f414c = inputStream.read();
        int read = inputStream.read();
        this.f415d = read;
        if (read >= 0) {
            h();
            return;
        }
        throw new EOFException();
    }

    private boolean h() {
        if (!this.f416e && this.f417f && this.f414c == 0 && this.f415d == 0) {
            this.f416e = true;
            b(true);
        }
        return this.f416e;
    }

    /* access modifiers changed from: package-private */
    public void j(boolean z10) {
        this.f417f = z10;
        h();
    }

    public int read(byte[] bArr, int i10, int i11) {
        if (this.f417f || i11 < 3) {
            return super.read(bArr, i10, i11);
        }
        if (this.f416e) {
            return -1;
        }
        int read = this.f426a.read(bArr, i10 + 2, i11 - 2);
        if (read >= 0) {
            bArr[i10] = (byte) this.f414c;
            bArr[i10 + 1] = (byte) this.f415d;
            this.f414c = this.f426a.read();
            int read2 = this.f426a.read();
            this.f415d = read2;
            if (read2 >= 0) {
                return read + 2;
            }
            throw new EOFException();
        }
        throw new EOFException();
    }

    public int read() {
        if (h()) {
            return -1;
        }
        int read = this.f426a.read();
        if (read >= 0) {
            int i10 = this.f414c;
            this.f414c = this.f415d;
            this.f415d = read;
            return i10;
        }
        throw new EOFException();
    }
}
