package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public abstract class AbstractCoroutine<T> extends JobSupport implements f1, d, b0 {
    private final CoroutineContext context;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z10, boolean z11) {
        super(z11);
        if (z10) {
            f0((f1) coroutineContext.get(f1.f964r));
        }
        this.context = coroutineContext.plus(this);
    }

    /* access modifiers changed from: protected */
    public void I0(Object obj) {
        J(obj);
    }

    /* access modifiers changed from: protected */
    public void J0(Throwable th, boolean z10) {
    }

    /* access modifiers changed from: protected */
    public void K0(Object obj) {
    }

    public final void L0(d0 d0Var, Object obj, Function2 function2) {
        d0Var.b(function2, obj, this);
    }

    /* access modifiers changed from: protected */
    public String P() {
        return f0.a(this) + " was cancelled";
    }

    public boolean a() {
        return super.a();
    }

    public final void d(Object obj) {
        Object l02 = l0(w.d(obj, (Function1) null, 1, (Object) null));
        if (l02 != m1.f1100b) {
            I0(l02);
        }
    }

    public final void e0(Throwable th) {
        a0.a(this.context, th);
    }

    public final CoroutineContext getContext() {
        return this.context;
    }

    public CoroutineContext getCoroutineContext() {
        return this.context;
    }

    public String n0() {
        String b10 = x.b(this.context);
        if (b10 == null) {
            return super.n0();
        }
        return '\"' + b10 + "\":" + super.n0();
    }

    /* access modifiers changed from: protected */
    public final void s0(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            J0(sVar.f1129a, sVar.a());
            return;
        }
        K0(obj);
    }
}
