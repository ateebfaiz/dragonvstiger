package bc;

import kotlinx.coroutines.m0;

public final /* synthetic */ class c implements m0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f20a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f21b;

    public /* synthetic */ c(d dVar, Runnable runnable) {
        this.f20a = dVar;
        this.f21b = runnable;
    }

    public final void dispose() {
        d.M(this.f20a, this.f21b);
    }
}
