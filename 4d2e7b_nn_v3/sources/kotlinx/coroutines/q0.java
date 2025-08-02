package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import cc.l;
import kotlin.collections.i;

public abstract class q0 extends y {

    /* renamed from: a  reason: collision with root package name */
    private long f1111a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1112b;

    /* renamed from: c  reason: collision with root package name */
    private i f1113c;

    private final long H(boolean z10) {
        return z10 ? 4294967296L : 1;
    }

    public static /* synthetic */ void L(q0 q0Var, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            q0Var.K(z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void G(boolean z10) {
        long H = this.f1111a - H(z10);
        this.f1111a = H;
        if (H <= 0 && this.f1112b) {
            shutdown();
        }
    }

    public final void I(j0 j0Var) {
        i iVar = this.f1113c;
        if (iVar == null) {
            iVar = new i();
            this.f1113c = iVar;
        }
        iVar.addLast(j0Var);
    }

    /* access modifiers changed from: protected */
    public long J() {
        i iVar = this.f1113c;
        if (iVar != null && !iVar.isEmpty()) {
            return 0;
        }
        return LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public final void K(boolean z10) {
        this.f1111a += H(z10);
        if (!z10) {
            this.f1112b = true;
        }
    }

    public final boolean M() {
        if (this.f1111a >= H(true)) {
            return true;
        }
        return false;
    }

    public final boolean N() {
        i iVar = this.f1113c;
        if (iVar != null) {
            return iVar.isEmpty();
        }
        return true;
    }

    public final boolean O() {
        j0 j0Var;
        i iVar = this.f1113c;
        if (iVar == null || (j0Var = (j0) iVar.m()) == null) {
            return false;
        }
        j0Var.run();
        return true;
    }

    public final y limitedParallelism(int i10) {
        l.a(i10);
        return this;
    }

    public abstract void shutdown();
}
