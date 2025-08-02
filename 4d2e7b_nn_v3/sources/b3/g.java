package b3;

import c3.h;
import java.io.IOException;
import java.io.InputStream;
import y2.l;
import z2.a;

public class g extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f17162a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f17163b;

    /* renamed from: c  reason: collision with root package name */
    private final h f17164c;

    /* renamed from: d  reason: collision with root package name */
    private int f17165d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f17166e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17167f = false;

    public g(InputStream inputStream, byte[] bArr, h hVar) {
        this.f17162a = (InputStream) l.g(inputStream);
        this.f17163b = (byte[]) l.g(bArr);
        this.f17164c = (h) l.g(hVar);
    }

    private boolean a() {
        if (this.f17166e < this.f17165d) {
            return true;
        }
        int read = this.f17162a.read(this.f17163b);
        if (read <= 0) {
            return false;
        }
        this.f17165d = read;
        this.f17166e = 0;
        return true;
    }

    private void b() {
        if (this.f17167f) {
            throw new IOException("stream already closed");
        }
    }

    public int available() {
        boolean z10;
        if (this.f17166e <= this.f17165d) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.i(z10);
        b();
        return (this.f17165d - this.f17166e) + this.f17162a.available();
    }

    public void close() {
        if (!this.f17167f) {
            this.f17167f = true;
            this.f17164c.release(this.f17163b);
            super.close();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (!this.f17167f) {
            a.j("PooledByteInputStream", "Finalized without closing");
            close();
        }
        super.finalize();
    }

    public int read() {
        l.i(this.f17166e <= this.f17165d);
        b();
        if (!a()) {
            return -1;
        }
        byte[] bArr = this.f17163b;
        int i10 = this.f17166e;
        this.f17166e = i10 + 1;
        return bArr[i10] & 255;
    }

    public long skip(long j10) {
        boolean z10;
        if (this.f17166e <= this.f17165d) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.i(z10);
        b();
        int i10 = this.f17165d;
        int i11 = this.f17166e;
        long j11 = (long) (i10 - i11);
        if (j11 >= j10) {
            this.f17166e = (int) (((long) i11) + j10);
            return j10;
        }
        this.f17166e = i10;
        return j11 + this.f17162a.skip(j10 - j11);
    }

    public int read(byte[] bArr, int i10, int i11) {
        l.i(this.f17166e <= this.f17165d);
        b();
        if (!a()) {
            return -1;
        }
        int min = Math.min(this.f17165d - this.f17166e, i11);
        System.arraycopy(this.f17163b, this.f17166e, bArr, i10, min);
        this.f17166e += min;
        return min;
    }
}
