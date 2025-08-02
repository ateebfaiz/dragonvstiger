package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.m;

public final class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private final a f728c = new a();

    public static final class a extends ThreadLocal {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    public Random f() {
        Object obj = this.f728c.get();
        m.e(obj, "get(...)");
        return (Random) obj;
    }
}
