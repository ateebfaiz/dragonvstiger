package androidx.customview.poolingcontainer;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f15353a = new ArrayList();

    public final void a(PoolingContainerListener poolingContainerListener) {
        m.f(poolingContainerListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f15353a.add(poolingContainerListener);
    }

    public final void b() {
        for (int n10 = r.n(this.f15353a); -1 < n10; n10--) {
            ((PoolingContainerListener) this.f15353a.get(n10)).onRelease();
        }
    }

    public final void c(PoolingContainerListener poolingContainerListener) {
        m.f(poolingContainerListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f15353a.remove(poolingContainerListener);
    }
}
