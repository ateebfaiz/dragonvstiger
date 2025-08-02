package h5;

import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;
import y2.l;

public class f implements v, Closeable {

    /* renamed from: a  reason: collision with root package name */
    private SharedMemory f21941a;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f21942b;

    /* renamed from: c  reason: collision with root package name */
    private final long f21943c;

    public f(int i10) {
        boolean z10;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.b(Boolean.valueOf(z10));
        try {
            SharedMemory a10 = SharedMemory.create("AshmemMemoryChunk", i10);
            this.f21941a = a10;
            this.f21942b = a10.mapReadWrite();
            this.f21943c = (long) System.identityHashCode(this);
        } catch (ErrnoException e10) {
            throw new RuntimeException("Fail to create AshmemMemory", e10);
        }
    }

    private void j(int i10, v vVar, int i11, int i12) {
        if (vVar instanceof f) {
            l.i(!isClosed());
            l.i(!vVar.isClosed());
            l.g(this.f21942b);
            l.g(vVar.e());
            w.b(i10, vVar.getSize(), i11, i12, getSize());
            this.f21942b.position(i10);
            vVar.e().position(i11);
            byte[] bArr = new byte[i12];
            this.f21942b.get(bArr, 0, i12);
            vVar.e().put(bArr, 0, i12);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    public long a() {
        return this.f21943c;
    }

    public synchronized int b(int i10, byte[] bArr, int i11, int i12) {
        int a10;
        l.g(bArr);
        l.g(this.f21942b);
        a10 = w.a(i10, i12, getSize());
        w.b(i10, bArr.length, i11, a10, getSize());
        this.f21942b.position(i10);
        this.f21942b.put(bArr, i11, a10);
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
        if (i10 < getSize()) {
            z11 = true;
        }
        l.b(Boolean.valueOf(z11));
        l.g(this.f21942b);
        return this.f21942b.get(i10);
    }

    public synchronized void close() {
        try {
            if (!isClosed()) {
                SharedMemory sharedMemory = this.f21941a;
                if (sharedMemory != null) {
                    sharedMemory.close();
                }
                ByteBuffer byteBuffer = this.f21942b;
                if (byteBuffer != null) {
                    SharedMemory.unmap(byteBuffer);
                }
                this.f21942b = null;
                this.f21941a = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int d(int i10, byte[] bArr, int i11, int i12) {
        int a10;
        l.g(bArr);
        l.g(this.f21942b);
        a10 = w.a(i10, i12, getSize());
        w.b(i10, bArr.length, i11, a10, getSize());
        this.f21942b.position(i10);
        this.f21942b.get(bArr, i11, a10);
        return a10;
    }

    public ByteBuffer e() {
        return this.f21942b;
    }

    public long f() {
        throw new UnsupportedOperationException("Cannot get the pointer of an  AshmemMemoryChunk");
    }

    public int getSize() {
        l.g(this.f21941a);
        return this.f21941a.getSize();
    }

    public void h(int i10, v vVar, int i11, int i12) {
        l.g(vVar);
        if (vVar.a() == a()) {
            Log.w("AshmemMemoryChunk", "Copying from AshmemMemoryChunk " + Long.toHexString(a()) + " to AshmemMemoryChunk " + Long.toHexString(vVar.a()) + " which are the same ");
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
        if (this.f21942b == null || this.f21941a == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }
}
