package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class SavedStateRegistryController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean attached;
    private final SavedStateRegistryOwner owner;
    private final SavedStateRegistry savedStateRegistry;

    public static final class Companion {
        private Companion() {
        }

        public final SavedStateRegistryController create(SavedStateRegistryOwner savedStateRegistryOwner) {
            m.f(savedStateRegistryOwner, "owner");
            return new SavedStateRegistryController(savedStateRegistryOwner, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner, DefaultConstructorMarker defaultConstructorMarker) {
        this(savedStateRegistryOwner);
    }

    public static final SavedStateRegistryController create(SavedStateRegistryOwner savedStateRegistryOwner) {
        return Companion.create(savedStateRegistryOwner);
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    @MainThread
    public final void performAttach() {
        Lifecycle lifecycle = this.owner.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.INITIALIZED) {
            lifecycle.addObserver(new Recreator(this.owner));
            this.savedStateRegistry.performAttach$savedstate_release(lifecycle);
            this.attached = true;
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }

    @MainThread
    public final void performRestore(Bundle bundle) {
        if (!this.attached) {
            performAttach();
        }
        Lifecycle lifecycle = this.owner.getLifecycle();
        if (!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            this.savedStateRegistry.performRestore$savedstate_release(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.getCurrentState()).toString());
    }

    @MainThread
    public final void performSave(Bundle bundle) {
        m.f(bundle, "outBundle");
        this.savedStateRegistry.performSave(bundle);
    }

    private SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.owner = savedStateRegistryOwner;
        this.savedStateRegistry = new SavedStateRegistry();
    }
}
