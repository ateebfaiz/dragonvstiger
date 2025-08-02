package h5;

import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;
import y2.l;

public class m implements v, Closeable {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f21969a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21970b;

    /* renamed from: c  reason: collision with root package name */
    private final long f21971c = ((long) System.identityHashCode(this));

    public m(int i10) {
        this.f21969a = ByteBuffer.allocateDirect(i10);
        this.f21970b = i10;
    }

    private void j(int i10, v vVar, int i11, int i12) {
        if (vVar instanceof m) {
            l.i(!isClosed());
            l.i(!vVar.isClosed());
            l.g(this.f21969a);
            w.b(i10, vVar.getSize(), i11, i12, this.f21970b);
            this.f21969a.position(i10);
            ByteBuffer byteBuffer = (ByteBuffer) l.g(vVar.e());
            byteBuffer.position(i11);
            byte[] bArr = new byte[i12];
            this.f21969a.get(bArr, 0, i12);
            byteBuffer.put(bArr, 0, i12);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    public long a() {
        return this.f21971c;
    }

    public synchronized int b(int i10, byte[] bArr, int i11, int i12) {
        int a10;
        l.g(bArr);
        l.i(!isClosed());
        l.g(this.f21969a);
        a10 = w.a(i10, i12, this.f21970b);
        w.b(i10, bArr.length, i11, a10, this.f21970b);
        this.f21969a.position(i10);
        this.f21969a.put(bArr, i11, a10);
        return a10;
    }

    public synchronized byte c(int i10) {
        boolean z10;
        boolean z11 = false;
        l.i(!isClosed());
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        if (i10 < this.f21970b) {
            z11 = true;
        }
        l.b(Boolean.valueOf(z11));
        l.g(this.f21969a);
        return this.f21969a.get(i10);
    }

    public synchronized void close() {
        this.f21969a = null;
    }

    public synchronized int d(int i10, byte[] bArr, int i11, int i12) {
        int a10;
        l.g(bArr);
        l.i(!isClosed());
        l.g(this.f21969a);
        a10 = w.a(i10, i12, this.f21970b);
        w.b(i10, bArr.length, i11, a10, this.f21970b);
        this.f21969a.position(i10);
        this.f21969a.get(bArr, i11, a10);
        return a10;
    }

    public synchronized ByteBuffer e() {
        return this.f21969a;
    }

    public long f() {
        throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
    }

    public int getSize() {
        return this.f21970b;
    }

    public void h(int i10, v vVar, int i11, int i12) {
        l.g(vVar);
        if (vVar.a() == a()) {
            Log.w("BufferMemoryChunk", "Copying from BufferMemoryChunk " + Long.toHexString(a()) + " to BufferMemoryChunk " + Long.toHexString(vVar.a()) + " which are the same ");
            l.b(Boolean.FALSE);
        }
        if (vVar.a() < a()) {
            synchronized (vVar) {
                synchronized (this) {
                    j(i10, vVar, i11, i12);
                }
            }
            return;
        }
        synchronized (this) {
            synchronized (vVar) {
                j(i10, vVar, i11, i12);
            }
        }
    }

    public synchronized boolean isClosed() {
        boolean z10;
        if (this.f21969a == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }
}
