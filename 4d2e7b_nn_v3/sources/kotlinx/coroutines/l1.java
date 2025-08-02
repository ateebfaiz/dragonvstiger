package kotlinx.coroutines;

import kotlin.jvm.internal.m;

public abstract class l1 extends u implements m0, z0 {

    /* renamed from: d  reason: collision with root package name */
    public JobSupport f1098d;

    public boolean a() {
        return true;
    }

    public o1 c() {
        return null;
    }

    public void dispose() {
        t().w0(this);
    }

    public final JobSupport t() {
        JobSupport jobSupport = this.f1098d;
        if (jobSupport != null) {
            return jobSupport;
        }
        m.u("job");
        return null;
    }

    public String toString() {
        return f0.a(this) + '@' + f0.b(this) + "[job@" + f0.b(t()) + ']';
    }

    public final void u(JobSupport jobSupport) {
        this.f1098d = jobSupport;
    }
}
