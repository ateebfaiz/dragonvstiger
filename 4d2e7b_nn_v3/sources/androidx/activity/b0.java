package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlinx.coroutines.channels.n;

public final /* synthetic */ class b0 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f13810a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f13811b;

    public /* synthetic */ b0(n nVar, View view) {
        this.f13810a = nVar;
        this.f13811b = view;
    }

    public final void onScrollChanged() {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.y(this.f13810a, this.f13811b);
    }
}
