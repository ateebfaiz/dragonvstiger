package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import com.alibaba.pdns.model.DomainUhfReportModel;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.p;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.n;

@c(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", l = {85}, m = "invokeSuspend")
final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements Function2<n, d, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    static final class a extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f13796a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewTreeObserver.OnScrollChangedListener f13797b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View.OnLayoutChangeListener f13798c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 f13799d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener, PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1) {
            super(0);
            this.f13796a = view;
            this.f13797b = onScrollChangedListener;
            this.f13798c = onLayoutChangeListener;
            this.f13799d = pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1;
        }

        public final void invoke() {
            this.f13796a.getViewTreeObserver().removeOnScrollChangedListener(this.f13797b);
            this.f13796a.removeOnLayoutChangeListener(this.f13798c);
            this.f13796a.removeOnAttachStateChangeListener(this.f13799d);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PipHintTrackerKt$trackPipAnimationHintView$flow$1(View view, d dVar) {
        super(2, dVar);
        this.$view = view;
    }

    /* access modifiers changed from: private */
    public static final void x(n nVar, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i10 != i14 || i12 != i16 || i11 != i15 || i13 != i17) {
            m.e(view, DomainUhfReportModel.ENCRYPTYPE);
            nVar.w(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view));
        }
    }

    /* access modifiers changed from: private */
    public static final void y(n nVar, View view) {
        nVar.w(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view));
    }

    public final d k(Object obj, d dVar) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, dVar);
        pipHintTrackerKt$trackPipAnimationHintView$flow$1.L$0 = obj;
        return pipHintTrackerKt$trackPipAnimationHintView$flow$1;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            n nVar = (n) this.L$0;
            a0 a0Var = new a0(nVar);
            b0 b0Var = new b0(nVar, this.$view);
            PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(nVar, this.$view, b0Var, a0Var);
            if (this.$view.isAttachedToWindow()) {
                nVar.w(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(this.$view));
                this.$view.getViewTreeObserver().addOnScrollChangedListener(b0Var);
                this.$view.addOnLayoutChangeListener(a0Var);
            }
            this.$view.addOnAttachStateChangeListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1);
            a aVar = new a(this.$view, b0Var, a0Var, pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1);
            this.label = 1;
            if (ProduceKt.a(nVar, aVar, this) == c10) {
                return c10;
            }
        } else if (i10 == 1) {
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f12577a;
    }

    /* renamed from: w */
    public final Object invoke(n nVar, d dVar) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) k(nVar, dVar)).n(Unit.f12577a);
    }
}
