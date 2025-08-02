package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import com.alibaba.pdns.model.DomainUhfReportModel;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.n;

public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ n $$this$callbackFlow;
    final /* synthetic */ View.OnLayoutChangeListener $layoutChangeListener;
    final /* synthetic */ ViewTreeObserver.OnScrollChangedListener $scrollChangeListener;
    final /* synthetic */ View $view;

    PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(n nVar, View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener) {
        this.$$this$callbackFlow = nVar;
        this.$view = view;
        this.$scrollChangeListener = onScrollChangedListener;
        this.$layoutChangeListener = onLayoutChangeListener;
    }

    public void onViewAttachedToWindow(View view) {
        m.f(view, DomainUhfReportModel.ENCRYPTYPE);
        this.$$this$callbackFlow.w(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(this.$view));
        this.$view.getViewTreeObserver().addOnScrollChangedListener(this.$scrollChangeListener);
        this.$view.addOnLayoutChangeListener(this.$layoutChangeListener);
    }

    public void onViewDetachedFromWindow(View view) {
        m.f(view, DomainUhfReportModel.ENCRYPTYPE);
        view.getViewTreeObserver().removeOnScrollChangedListener(this.$scrollChangeListener);
        view.removeOnLayoutChangeListener(this.$layoutChangeListener);
    }
}
