package androidx.activity;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function1;

@c(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", l = {185}, m = "reportWhenComplete")
final class FullyDrawnReporterKt$reportWhenComplete$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    FullyDrawnReporterKt$reportWhenComplete$1(d dVar) {
        super(dVar);
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FullyDrawnReporterKt.reportWhenComplete((FullyDrawnReporter) null, (Function1<? super d, ? extends Object>) null, this);
    }
}
