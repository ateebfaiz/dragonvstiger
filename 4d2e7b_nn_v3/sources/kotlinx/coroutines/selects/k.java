package kotlinx.coroutines.selects;

import cc.c0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import vb.n;

public abstract class k {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final n f1158a = a.f1164a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f1159b = new c0("STATE_REG");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final c0 f1160c = new c0("STATE_COMPLETED");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final c0 f1161d = new c0("STATE_CANCELLED");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final c0 f1162e = new c0("NO_RESULT");

    /* renamed from: f  reason: collision with root package name */
    private static final c0 f1163f = new c0("PARAM_CLAUSE_0");

    static final class a extends kotlin.jvm.internal.n implements n {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1164a = new a();

        a() {
            super(3);
        }

        /* renamed from: a */
        public final Void e(Object obj, Object obj2, Object obj3) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static final m a(int i10) {
        if (i10 == 0) {
            return m.SUCCESSFUL;
        }
        if (i10 == 1) {
            return m.REREGISTER;
        }
        if (i10 == 2) {
            return m.CANCELLED;
        }
        if (i10 == 3) {
            return m.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i10).toString());
    }

    public static final c0 i() {
        return f1163f;
    }

    /* access modifiers changed from: private */
    public static final boolean j(CancellableContinuation cancellableContinuation, Function1 function1) {
        Object l10 = cancellableContinuation.l(Unit.f12577a, (Object) null, function1);
        if (l10 == null) {
            return false;
        }
        cancellableContinuation.D(l10);
        return true;
    }
}
