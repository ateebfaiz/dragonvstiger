package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private Bundle defaultArgs;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AbstractSavedStateViewModelFactory() {
    }

    public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        m.f(cls, "modelClass");
        m.f(creationExtras, "extras");
        String str = (String) creationExtras.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (this.savedStateRegistry != null) {
            return create(str, cls);
        } else {
            return create(str, cls, SavedStateHandleSupport.createSavedStateHandle(creationExtras));
        }
    }

    /* access modifiers changed from: protected */
    public abstract <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(ViewModel viewModel) {
        m.f(viewModel, "viewModel");
        SavedStateRegistry savedStateRegistry2 = this.savedStateRegistry;
        if (savedStateRegistry2 != null) {
            m.c(savedStateRegistry2);
            Lifecycle lifecycle2 = this.lifecycle;
            m.c(lifecycle2);
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry2, lifecycle2);
        }
    }

    public AbstractSavedStateViewModelFactory(SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        m.f(savedStateRegistryOwner, "owner");
        this.savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.lifecycle = savedStateRegistryOwner.getLifecycle();
        this.defaultArgs = bundle;
    }

    private final <T extends ViewModel> T create(String str, Class<T> cls) {
        SavedStateRegistry savedStateRegistry2 = this.savedStateRegistry;
        m.c(savedStateRegistry2);
        Lifecycle lifecycle2 = this.lifecycle;
        m.c(lifecycle2);
        SavedStateHandleController create = LegacySavedStateHandleController.create(savedStateRegistry2, lifecycle2, str, this.defaultArgs);
        T create2 = create(str, cls, create.getHandle());
        create2.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", create);
        return create2;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        m.f(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        } else if (this.lifecycle != null) {
            return create(canonicalName, cls);
        } else {
            throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }
}
