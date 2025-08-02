package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

public class s {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1128b = AtomicIntegerFieldUpdater.newUpdater(s.class, "_handled");
    private volatile int _handled;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f1129a;

    public s(Throwable th, boolean z10) {
        this.f1129a = th;
        this._handled = z10 ? 1 : 0;
    }

    public final boolean a() {
        if (f1128b.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        return f1128b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return f0.a(this) + '[' + this.f1129a + ']';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(Throwable th, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i10 & 2) != 0 ? false : z10);
    }
}
