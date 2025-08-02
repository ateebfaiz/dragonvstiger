package b3;

import androidx.core.util.Pools;
import java.nio.ByteBuffer;

public class b implements Pools.Pool {

    /* renamed from: a  reason: collision with root package name */
    public static final b f17158a = new b();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static int f17159b = 16384;

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal f17160c = new a();

    class a extends ThreadLocal {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ByteBuffer initialValue() {
            return ByteBuffer.allocate(b.f17159b);
        }
    }

    public static int c() {
        return f17159b;
    }

    /* renamed from: b */
    public ByteBuffer acquire() {
        return (ByteBuffer) f17160c.get();
    }

    /* renamed from: d */
    public boolean release(ByteBuffer byteBuffer) {
        return true;
    }
}
