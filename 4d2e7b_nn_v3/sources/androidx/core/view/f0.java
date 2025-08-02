package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class f0 implements WindowInsetsController.OnControllableInsetsChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f15254a;

    public /* synthetic */ f0(AtomicBoolean atomicBoolean) {
        this.f15254a = atomicBoolean;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i10) {
        SoftwareKeyboardControllerCompat.b.f(this.f15254a, windowInsetsController, i10);
    }
}
