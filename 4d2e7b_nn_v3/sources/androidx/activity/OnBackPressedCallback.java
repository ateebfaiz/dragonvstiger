package androidx.activity;

import androidx.annotation.MainThread;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;

public abstract class OnBackPressedCallback {
    private final CopyOnWriteArrayList<Cancellable> cancellables = new CopyOnWriteArrayList<>();
    private Function0<Unit> enabledChangedCallback;
    private boolean isEnabled;

    public OnBackPressedCallback(boolean z10) {
        this.isEnabled = z10;
    }

    public final void addCancellable(Cancellable cancellable) {
        m.f(cancellable, "cancellable");
        this.cancellables.add(cancellable);
    }

    public final Function0<Unit> getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    @MainThread
    public void handleOnBackCancelled() {
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public void handleOnBackProgressed(BackEventCompat backEventCompat) {
        m.f(backEventCompat, "backEvent");
    }

    @MainThread
    public void handleOnBackStarted(BackEventCompat backEventCompat) {
        m.f(backEventCompat, "backEvent");
    }

    @MainThread
    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @MainThread
    public final void remove() {
        for (Cancellable cancel : this.cancellables) {
            cancel.cancel();
        }
    }

    public final void removeCancellable(Cancellable cancellable) {
        m.f(cancellable, "cancellable");
        this.cancellables.remove(cancellable);
    }

    @MainThread
    public final void setEnabled(boolean z10) {
        this.isEnabled = z10;
        Function0<Unit> function0 = this.enabledChangedCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(Function0<Unit> function0) {
        this.enabledChangedCallback = function0;
    }
}
