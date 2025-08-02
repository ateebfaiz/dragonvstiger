package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.ViewCompat;

public final /* synthetic */ class j0 implements View.OnUnhandledKeyEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewCompat.OnUnhandledKeyEventListenerCompat f15267a;

    public /* synthetic */ j0(ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        this.f15267a = onUnhandledKeyEventListenerCompat;
    }

    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.f15267a.onUnhandledKeyEvent(view, keyEvent);
    }
}
