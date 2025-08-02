package kotlinx.coroutines.flow;

import kotlinx.coroutines.flow.internal.d;

public final class o1 extends d {

    /* renamed from: a  reason: collision with root package name */
    public long f1067a = -1;

    /* renamed from: b  reason: collision with root package name */
    public kotlin.coroutines.d f1068b;

    /* renamed from: c */
    public boolean a(SharedFlowImpl sharedFlowImpl) {
        if (this.f1067a >= 0) {
            return false;
        }
        this.f1067a = sharedFlowImpl.Y();
        return true;
    }

    /* renamed from: d */
    public kotlin.coroutines.d[] b(SharedFlowImpl sharedFlowImpl) {
        long j10 = this.f1067a;
        this.f1067a = -1;
        this.f1068b = null;
        return sharedFlowImpl.X(j10);
    }
}
