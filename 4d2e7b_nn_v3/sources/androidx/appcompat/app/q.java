package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.view.KeyEventDispatcher;

public final /* synthetic */ class q implements KeyEventDispatcher.Component {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatDialog f13973a;

    public /* synthetic */ q(AppCompatDialog appCompatDialog) {
        this.f13973a = appCompatDialog;
    }

    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f13973a.superDispatchKeyEvent(keyEvent);
    }
}
