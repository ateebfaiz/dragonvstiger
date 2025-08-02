package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.z;

public final class SavedStateHandleSupport {
    public static final CreationExtras.Key<Bundle> DEFAULT_ARGS_KEY = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();
    private static final String SAVED_STATE_KEY = "androidx.lifecycle.internal.SavedStateHandlesProvider";
    public static final CreationExtras.Key<SavedStateRegistryOwner> SAVED_STATE_REGISTRY_OWNER_KEY = new SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1();
    private static final String VIEWMODEL_KEY = "androidx.lifecycle.internal.SavedStateHandlesVM";
    public static final CreationExtras.Key<ViewModelStoreOwner> VIEW_MODEL_STORE_OWNER_KEY = new SavedStateHandleSupport$VIEW_MODEL_STORE_OWNER_KEY$1();

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15861a = new a();

        a() {
            super(1);
        }

        /* renamed from: a */
        public final SavedStateHandlesVM invoke(CreationExtras creationExtras) {
            m.f(creationExtras, "$this$initializer");
            return new SavedStateHandlesVM();
        }
    }

    private static final SavedStateHandle createSavedStateHandle(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, String str, Bundle bundle) {
        SavedStateHandlesProvider savedStateHandlesProvider = getSavedStateHandlesProvider(savedStateRegistryOwner);
        SavedStateHandlesVM savedStateHandlesVM = getSavedStateHandlesVM(viewModelStoreOwner);
        SavedStateHandle savedStateHandle = savedStateHandlesVM.getHandles().get(str);
        if (savedStateHandle != null) {
            return savedStateHandle;
        }
        SavedStateHandle createHandle = SavedStateHandle.Companion.createHandle(savedStateHandlesProvider.consumeRestoredStateForKey(str), bundle);
        savedStateHandlesVM.getHandles().put(str, createHandle);
        return createHandle;
    }

    @MainThread
    public static final <T extends SavedStateRegistryOwner & ViewModelStoreOwner> void enableSavedStateHandles(T t10) {
        m.f(t10, "<this>");
        Lifecycle.State currentState = t10.getLifecycle().getCurrentState();
        if (currentState != Lifecycle.State.INITIALIZED && currentState != Lifecycle.State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (t10.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY) == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(t10.getSavedStateRegistry(), (ViewModelStoreOwner) t10);
            t10.getSavedStateRegistry().registerSavedStateProvider(SAVED_STATE_KEY, savedStateHandlesProvider);
            t10.getLifecycle().addObserver(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesProvider getSavedStateHandlesProvider(SavedStateRegistryOwner savedStateRegistryOwner) {
        SavedStateHandlesProvider savedStateHandlesProvider;
        m.f(savedStateRegistryOwner, "<this>");
        SavedStateRegistry.SavedStateProvider savedStateProvider = savedStateRegistryOwner.getSavedStateRegistry().getSavedStateProvider(SAVED_STATE_KEY);
        if (savedStateProvider instanceof SavedStateHandlesProvider) {
            savedStateHandlesProvider = (SavedStateHandlesProvider) savedStateProvider;
        } else {
            savedStateHandlesProvider = null;
        }
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final SavedStateHandlesVM getSavedStateHandlesVM(ViewModelStoreOwner viewModelStoreOwner) {
        m.f(viewModelStoreOwner, "<this>");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        Class cls = SavedStateHandlesVM.class;
        initializerViewModelFactoryBuilder.addInitializer(z.b(cls), a.f15861a);
        return (SavedStateHandlesVM) new ViewModelProvider(viewModelStoreOwner, initializerViewModelFactoryBuilder.build()).get(VIEWMODEL_KEY, cls);
    }

    @MainThread
    public static final SavedStateHandle createSavedStateHandle(CreationExtras creationExtras) {
        m.f(creationExtras, "<this>");
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) creationExtras.get(SAVED_STATE_REGISTRY_OWNER_KEY);
        if (savedStateRegistryOwner != null) {
            ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) creationExtras.get(VIEW_MODEL_STORE_OWNER_KEY);
            if (viewModelStoreOwner != null) {
                Bundle bundle = (Bundle) creationExtras.get(DEFAULT_ARGS_KEY);
                String str = (String) creationExtras.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
                if (str != null) {
                    return createSavedStateHandle(savedStateRegistryOwner, viewModelStoreOwner, str, bundle);
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }
}
