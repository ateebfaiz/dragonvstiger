package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.DelayKt;
import vb.n;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private final long f1146a;

    /* renamed from: kotlinx.coroutines.selects.a$a  reason: collision with other inner class name */
    public static final class C0017a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f1147a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f1148b;

        public C0017a(j jVar, a aVar) {
            this.f1147a = jVar;
            this.f1148b = aVar;
        }

        public final void run() {
            this.f1147a.c(this.f1148b, Unit.f12577a);
        }
    }

    /* synthetic */ class b extends j implements n {

        /* renamed from: a  reason: collision with root package name */
        public static final b f1149a = new b();

        b() {
            super(3, a.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        public final void c(a aVar, j jVar, Object obj) {
            aVar.c(jVar, obj);
        }

        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3) {
            c((a) obj, (j) obj2, obj3);
            return Unit.f12577a;
        }
    }

    public a(long j10) {
        this.f1146a = j10;
    }

    /* access modifiers changed from: private */
    public final void c(j jVar, Object obj) {
        if (this.f1146a <= 0) {
            jVar.g(Unit.f12577a);
            return;
        }
        C0017a aVar = new C0017a(jVar, this);
        m.d(jVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        SelectImplementation selectImplementation = (SelectImplementation) jVar;
        CoroutineContext context = jVar.getContext();
        jVar.a(DelayKt.c(context).w(this.f1146a, aVar, context));
    }

    public final e b() {
        b bVar = b.f1149a;
        m.d(bVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new f(this, (n) c0.e(bVar, 3), (n) null, 4, (DefaultConstructorMarker) null);
    }
}
