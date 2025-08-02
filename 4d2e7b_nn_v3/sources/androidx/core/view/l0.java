package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

public final /* synthetic */ class l0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f15269a;

    public /* synthetic */ l0(ViewConfiguration viewConfiguration) {
        this.f15269a = viewConfiguration;
    }

    public final Object get() {
        return Integer.valueOf(this.f15269a.getScaledMinimumFlingVelocity());
    }
}
