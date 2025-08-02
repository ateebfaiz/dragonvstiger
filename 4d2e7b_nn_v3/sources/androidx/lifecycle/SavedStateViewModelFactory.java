package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.m;

public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    private Application application;
    private Bundle defaultArgs;
    private final ViewModelProvider.Factory factory;
    private Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;

    public SavedStateViewModelFactory() {
        this.factory = new ViewModelProvider.AndroidViewModelFactory();
    }

    public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        Constructor<T> constructor;
        m.f(cls, "modelClass");
        m.f(creationExtras, "extras");
        String str = (String) creationExtras.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (creationExtras.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) != null && creationExtras.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) != null) {
            Application application2 = (Application) creationExtras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            if (!isAssignableFrom || application2 == null) {
                constructor = SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.VIEWMODEL_SIGNATURE);
            } else {
                constructor = SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.ANDROID_VIEWMODEL_SIGNATURE);
            }
            if (constructor == null) {
                return this.factory.create(cls, creationExtras);
            }
            if (!isAssignableFrom || application2 == null) {
                return SavedStateViewModelFactoryKt.newInstance(cls, constructor, SavedStateHandleSupport.createSavedStateHandle(creationExtras));
            }
            return SavedStateViewModelFactoryKt.newInstance(cls, constructor, application2, SavedStateHandleSupport.createSavedStateHandle(creationExtras));
        } else if (this.lifecycle != null) {
            return create(str, cls);
        } else {
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(ViewModel viewModel) {
        m.f(viewModel, "viewModel");
        if (this.lifecycle != null) {
            SavedStateRegistry savedStateRegistry2 = this.savedStateRegistry;
            m.c(savedStateRegistry2);
            Lifecycle lifecycle2 = this.lifecycle;
            m.c(lifecycle2);
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry2, lifecycle2);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SavedStateViewModelFactory(Application application2, SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application2, savedStateRegistryOwner, (Bundle) null);
        m.f(savedStateRegistryOwner, "owner");
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(Application application2, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        m.f(savedStateRegistryOwner, "owner");
        this.savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.lifecycle = savedStateRegistryOwner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = application2;
        if (application2 != null) {
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.Companion.getInstance(application2);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        }
        this.factory = androidViewModelFactory;
    }

    public final <T extends ViewModel> T create(String str, Class<T> cls) {
        Constructor<T> constructor;
        T t10;
        Application application2;
        m.f(str, "key");
        m.f(cls, "modelClass");
        Lifecycle lifecycle2 = this.lifecycle;
        if (lifecycle2 != null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            if (!isAssignableFrom || this.application == null) {
                constructor = SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.VIEWMODEL_SIGNATURE);
            } else {
                constructor = SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.ANDROID_VIEWMODEL_SIGNATURE);
            }
            if (constructor != null) {
                SavedStateRegistry savedStateRegistry2 = this.savedStateRegistry;
                m.c(savedStateRegistry2);
                SavedStateHandleController create = LegacySavedStateHandleController.create(savedStateRegistry2, lifecycle2, str, this.defaultArgs);
                if (!isAssignableFrom || (application2 = this.application) == null) {
                    t10 = SavedStateViewModelFactoryKt.newInstance(cls, constructor, create.getHandle());
                } else {
                    m.c(application2);
                    t10 = SavedStateViewModelFactoryKt.newInstance(cls, constructor, application2, create.getHandle());
                }
                t10.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", create);
                return t10;
            } else if (this.application != null) {
                return this.factory.create(cls);
            } else {
                return ViewModelProvider.NewInstanceFactory.Companion.getInstance().create(cls);
            }
        } else {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        m.f(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
