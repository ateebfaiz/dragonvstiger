package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

public final /* synthetic */ class k0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f15268a;

    public /* synthetic */ k0(ViewConfiguration viewConfiguration) {
        this.f15268a = viewConfiguration;
    }

    public final Object get() {
        return Integer.valueOf(this.f15268a.getScaledMaximumFlingVelocity());
    }
}
