package g4;

import java.io.Closeable;
import kotlin.jvm.internal.m;

public final class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private int f21693a;

    /* renamed from: b  reason: collision with root package name */
    private final c3.a f21694b;

    public a(int i10, c3.a aVar) {
        m.f(aVar, "bitmap");
        this.f21693a = i10;
        this.f21694b = aVar;
    }

    public final c3.a a() {
        return this.f21694b;
    }

    public final int b() {
        return this.f21693a;
    }

    public void close() {
        this.f21694b.close();
    }
}
