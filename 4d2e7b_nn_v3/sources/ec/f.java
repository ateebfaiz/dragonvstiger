package ec;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.w0;

public abstract class f extends w0 {

    /* renamed from: b  reason: collision with root package name */
    private final int f199b;

    /* renamed from: c  reason: collision with root package name */
    private final int f200c;

    /* renamed from: d  reason: collision with root package name */
    private final long f201d;

    /* renamed from: e  reason: collision with root package name */
    private final String f202e;

    /* renamed from: f  reason: collision with root package name */
    private a f203f = G();

    public f(int i10, int i11, long j10, String str) {
        this.f199b = i10;
        this.f200c = i11;
        this.f201d = j10;
        this.f202e = str;
    }

    private final a G() {
        return new a(this.f199b, this.f200c, this.f201d, this.f202e);
    }

    public final void H(Runnable runnable, i iVar, boolean z10) {
        this.f203f.n(runnable, iVar, z10);
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        a.p(this.f203f, runnable, (i) null, false, 6, (Object) null);
    }

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        a.p(this.f203f, runnable, (i) null, true, 2, (Object) null);
    }
}
