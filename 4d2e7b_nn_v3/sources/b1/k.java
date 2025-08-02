package b1;

import java.io.ByteArrayOutputStream;

public class k extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final c f17156a;

    public k(c cVar, int i10) {
        this.f17156a = cVar;
        this.buf = cVar.a(Math.max(i10, 256));
    }

    private void a(int i10) {
        int i11 = this.count;
        if (i11 + i10 > this.buf.length) {
            byte[] a10 = this.f17156a.a((i11 + i10) * 2);
            System.arraycopy(this.buf, 0, a10, 0, this.count);
            this.f17156a.b(this.buf);
            this.buf = a10;
        }
    }

    public void close() {
        this.f17156a.b(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f17156a.b(this.buf);
    }

    public synchronized void write(byte[] bArr, int i10, int i11) {
        a(i11);
        super.write(bArr, i10, i11);
    }

    public synchronized void write(int i10) {
        a(1);
        super.write(i10);
    }
}
