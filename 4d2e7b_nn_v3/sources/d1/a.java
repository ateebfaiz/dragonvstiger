package d1;

import c1.s;
import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final c1.a f21012a;

    /* renamed from: b  reason: collision with root package name */
    public final s f21013b;

    public a(c1.a aVar, s sVar) {
        this.f21012a = aVar;
        this.f21013b = sVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(c1.a aVar, s sVar, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i10 & 2) != 0 ? s.DEFAULT : sVar);
    }
}
