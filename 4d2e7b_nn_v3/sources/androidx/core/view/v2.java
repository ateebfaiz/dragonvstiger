package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

public final /* synthetic */ class v2 implements WindowInsetsController.OnControllableInsetsChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsControllerCompat.d f15278a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsControllerCompat.OnControllableInsetsChangedListener f15279b;

    public /* synthetic */ v2(WindowInsetsControllerCompat.d dVar, WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.f15278a = dVar;
        this.f15279b = onControllableInsetsChangedListener;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i10) {
        this.f15278a.m(this.f15279b, windowInsetsController, i10);
    }
}
