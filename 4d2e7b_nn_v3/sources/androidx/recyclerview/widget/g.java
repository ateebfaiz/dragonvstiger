package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class g {

    /* renamed from: a  reason: collision with root package name */
    boolean f16367a = true;

    /* renamed from: b  reason: collision with root package name */
    int f16368b;

    /* renamed from: c  reason: collision with root package name */
    int f16369c;

    /* renamed from: d  reason: collision with root package name */
    int f16370d;

    /* renamed from: e  reason: collision with root package name */
    int f16371e;

    /* renamed from: f  reason: collision with root package name */
    int f16372f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f16373g = 0;

    /* renamed from: h  reason: collision with root package name */
    boolean f16374h;

    /* renamed from: i  reason: collision with root package name */
    boolean f16375i;

    g() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.State state) {
        int i10 = this.f16369c;
        if (i10 < 0 || i10 >= state.getItemCount()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public View b(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.f16369c);
        this.f16369c += this.f16370d;
        return viewForPosition;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f16368b + ", mCurrentPosition=" + this.f16369c + ", mItemDirection=" + this.f16370d + ", mLayoutDirection=" + this.f16371e + ", mStartLine=" + this.f16372f + ", mEndLine=" + this.f16373g + '}';
    }
}
