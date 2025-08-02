package kotlinx.coroutines;

import cc.c0;

public abstract class m1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f1099a = new c0("COMPLETING_ALREADY");

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f1100b = new c0("COMPLETING_WAITING_CHILDREN");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final c0 f1101c = new c0("COMPLETING_RETRY");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final c0 f1102d = new c0("TOO_LATE_TO_CANCEL");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final c0 f1103e = new c0("SEALED");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final p0 f1104f = new p0(false);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final p0 f1105g = new p0(true);

    public static final Object g(Object obj) {
        if (obj instanceof z0) {
            return new a1((z0) obj);
        }
        return obj;
    }

    public static final Object h(Object obj) {
        a1 a1Var;
        z0 z0Var;
        if (obj instanceof a1) {
            a1Var = (a1) obj;
        } else {
            a1Var = null;
        }
        if (a1Var == null || (z0Var = a1Var.f847a) == null) {
            return obj;
        }
        return z0Var;
    }
}
