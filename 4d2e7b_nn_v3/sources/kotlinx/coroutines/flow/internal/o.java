package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.d;
import vb.n;

public abstract class o {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final n f1059a;

    /* synthetic */ class a extends j implements n {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1060a = new a();

        a() {
            super(3, d.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        /* renamed from: c */
        public final Object e(d dVar, Object obj, kotlin.coroutines.d dVar2) {
            return dVar.i(obj, dVar2);
        }
    }

    static {
        a aVar = a.f1060a;
        m.d(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f1059a = (n) c0.e(aVar, 3);
    }
}
