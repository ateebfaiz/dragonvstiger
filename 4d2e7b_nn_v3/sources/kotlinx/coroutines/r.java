package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

final class r {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1114a;

    /* renamed from: b  reason: collision with root package name */
    public final g f1115b;

    /* renamed from: c  reason: collision with root package name */
    public final Function1 f1116c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1117d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f1118e;

    public r(Object obj, g gVar, Function1 function1, Object obj2, Throwable th) {
        this.f1114a = obj;
        this.f1115b = gVar;
        this.f1116c = function1;
        this.f1117d = obj2;
        this.f1118e = th;
    }

    public static /* synthetic */ r b(r rVar, Object obj, g gVar, Function1 function1, Object obj2, Throwable th, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = rVar.f1114a;
        }
        if ((i10 & 2) != 0) {
            gVar = rVar.f1115b;
        }
        g gVar2 = gVar;
        if ((i10 & 4) != 0) {
            function1 = rVar.f1116c;
        }
        Function1 function12 = function1;
        if ((i10 & 8) != 0) {
            obj2 = rVar.f1117d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th = rVar.f1118e;
        }
        return rVar.a(obj, gVar2, function12, obj4, th);
    }

    public final r a(Object obj, g gVar, Function1 function1, Object obj2, Throwable th) {
        return new r(obj, gVar, function1, obj2, th);
    }

    public final boolean c() {
        if (this.f1118e != null) {
            return true;
        }
        return false;
    }

    public final void d(CancellableContinuationImpl cancellableContinuationImpl, Throwable th) {
        g gVar = this.f1115b;
        if (gVar != null) {
            cancellableContinuationImpl.n(gVar, th);
        }
        Function1 function1 = this.f1116c;
        if (function1 != null) {
            cancellableContinuationImpl.p(function1, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return m.b(this.f1114a, rVar.f1114a) && m.b(this.f1115b, rVar.f1115b) && m.b(this.f1116c, rVar.f1116c) && m.b(this.f1117d, rVar.f1117d) && m.b(this.f1118e, rVar.f1118e);
    }

    public int hashCode() {
        Object obj = this.f1114a;
        int i10 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        g gVar = this.f1115b;
        int hashCode2 = (hashCode + (gVar == null ? 0 : gVar.hashCode())) * 31;
        Function1 function1 = this.f1116c;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.f1117d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f1118e;
        if (th != null) {
            i10 = th.hashCode();
        }
        return hashCode4 + i10;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f1114a + ", cancelHandler=" + this.f1115b + ", onCancellation=" + this.f1116c + ", idempotentResume=" + this.f1117d + ", cancelCause=" + this.f1118e + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(Object obj, g gVar, Function1 function1, Object obj2, Throwable th, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i10 & 2) != 0 ? null : gVar, (i10 & 4) != 0 ? null : function1, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th);
    }
}
