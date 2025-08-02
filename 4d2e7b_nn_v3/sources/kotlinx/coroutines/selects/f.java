package kotlinx.coroutines.selects;

import kotlin.jvm.internal.DefaultConstructorMarker;
import vb.n;

public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1150a;

    /* renamed from: b  reason: collision with root package name */
    private final n f1151b;

    /* renamed from: c  reason: collision with root package name */
    private final n f1152c;

    /* renamed from: d  reason: collision with root package name */
    private final n f1153d;

    public f(Object obj, n nVar, n nVar2) {
        this.f1150a = obj;
        this.f1151b = nVar;
        this.f1152c = nVar2;
        this.f1153d = k.f1158a;
    }

    public n a() {
        return this.f1151b;
    }

    public Object b() {
        return this.f1150a;
    }

    public n c() {
        return this.f1152c;
    }

    public n d() {
        return this.f1153d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(Object obj, n nVar, n nVar2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, nVar, (i10 & 4) != 0 ? null : nVar2);
    }
}
