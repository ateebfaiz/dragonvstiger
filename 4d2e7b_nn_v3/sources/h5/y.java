package h5;

import b3.i;
import b3.l;
import com.facebook.imagepipeline.memory.f;
import com.facebook.imagepipeline.memory.g;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import y2.q;

public final class y implements i {

    /* renamed from: a  reason: collision with root package name */
    private final f f21989a;

    /* renamed from: b  reason: collision with root package name */
    private final l f21990b;

    public y(f fVar, l lVar) {
        m.f(fVar, "pool");
        m.f(lVar, "pooledByteStreams");
        this.f21989a = fVar;
        this.f21990b = lVar;
    }

    public final x f(InputStream inputStream, g gVar) {
        m.f(inputStream, "inputStream");
        m.f(gVar, "outputStream");
        this.f21990b.a(inputStream, gVar);
        return gVar.a();
    }

    /* renamed from: g */
    public x c(InputStream inputStream) {
        m.f(inputStream, "inputStream");
        g gVar = new g(this.f21989a, 0, 2, (DefaultConstructorMarker) null);
        try {
            return f(inputStream, gVar);
        } finally {
            gVar.close();
        }
    }

    /* renamed from: h */
    public x d(InputStream inputStream, int i10) {
        m.f(inputStream, "inputStream");
        g gVar = new g(this.f21989a, i10);
        try {
            return f(inputStream, gVar);
        } finally {
            gVar.close();
        }
    }

    /* renamed from: i */
    public x b(byte[] bArr) {
        m.f(bArr, "bytes");
        g gVar = new g(this.f21989a, bArr.length);
        try {
            gVar.write(bArr, 0, bArr.length);
            x j10 = gVar.a();
            gVar.close();
            return j10;
        } catch (IOException e10) {
            RuntimeException a10 = q.a(e10);
            m.e(a10, "propagate(ioe)");
            throw a10;
        } catch (Throwable th) {
            gVar.close();
            throw th;
        }
    }

    /* renamed from: j */
    public g a() {
        return new g(this.f21989a, 0, 2, (DefaultConstructorMarker) null);
    }

    /* renamed from: k */
    public g e(int i10) {
        return new g(this.f21989a, i10);
    }
}
