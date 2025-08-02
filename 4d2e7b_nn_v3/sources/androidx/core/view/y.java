package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f15282a;

    public /* synthetic */ y(View view) {
        this.f15282a = view;
    }

    public final void run() {
        ((InputMethodManager) this.f15282a.getContext().getSystemService("input_method")).showSoftInput(this.f15282a, 0);
    }
}
