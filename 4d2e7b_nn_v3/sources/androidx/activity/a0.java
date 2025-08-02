package androidx.activity;

import android.view.View;
import kotlinx.coroutines.channels.n;

public final /* synthetic */ class a0 implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f13808a;

    public /* synthetic */ a0(n nVar) {
        this.f13808a = nVar;
    }

    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.x(this.f13808a, view, i10, i11, i12, i13, i14, i15, i16, i17);
    }
}
