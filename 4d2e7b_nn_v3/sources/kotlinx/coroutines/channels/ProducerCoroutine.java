package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.channels.p;

final class ProducerCoroutine<E> extends ChannelCoroutine<E> implements n {
    public ProducerCoroutine(CoroutineContext coroutineContext, e eVar) {
        super(coroutineContext, eVar, true, true);
    }

    /* access modifiers changed from: protected */
    public void J0(Throwable th, boolean z10) {
        if (!N0().r(th) && !z10) {
            a0.a(getContext(), th);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: O0 */
    public void K0(Unit unit) {
        p.a.a(N0(), (Throwable) null, 1, (Object) null);
    }

    public boolean a() {
        return super.a();
    }

    public /* bridge */ /* synthetic */ p i() {
        return M0();
    }
}
