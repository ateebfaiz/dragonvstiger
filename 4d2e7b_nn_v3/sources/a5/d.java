package a5;

import com.facebook.imagepipeline.producers.d1;
import com.facebook.imagepipeline.producers.l1;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import i3.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class d extends a {

    /* renamed from: j  reason: collision with root package name */
    public static final a f13680j = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public final c a(d1 d1Var, l1 l1Var, g5.d dVar) {
            m.f(d1Var, "producer");
            m.f(l1Var, "settableProducerContext");
            m.f(dVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            return new d(d1Var, l1Var, dVar, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ d(d1 d1Var, l1 l1Var, g5.d dVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(d1Var, l1Var, dVar);
    }

    private d(d1 d1Var, l1 l1Var, g5.d dVar) {
        super(d1Var, l1Var, dVar);
    }
}
