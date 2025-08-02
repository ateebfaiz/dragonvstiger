package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {
    private static final a Companion = new a((DefaultConstructorMarker) null);
    @Deprecated
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;
    private final SafeIterableMap<String, SavedStateProvider> components = new SafeIterableMap<>();
    private boolean isAllowingSavingState = true;
    private boolean isRestored;
    private Recreator.SavedStateProvider recreatorProvider;
    private Bundle restoredState;

    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    public interface SavedStateProvider {
        Bundle saveState();
    }

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public static final void performAttach$lambda$4(SavedStateRegistry savedStateRegistry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.f(savedStateRegistry, "this$0");
        m.f(lifecycleOwner, "<anonymous parameter 0>");
        m.f(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_START) {
            savedStateRegistry.isAllowingSavingState = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            savedStateRegistry.isAllowingSavingState = false;
        }
    }

    @MainThread
    public final Bundle consumeRestoredStateForKey(String str) {
        Bundle bundle;
        m.f(str, "key");
        if (this.isRestored) {
            Bundle bundle2 = this.restoredState;
            if (bundle2 == null) {
                return null;
            }
            if (bundle2 != null) {
                bundle = bundle2.getBundle(str);
            } else {
                bundle = null;
            }
            Bundle bundle3 = this.restoredState;
            if (bundle3 != null) {
                bundle3.remove(str);
            }
            Bundle bundle4 = this.restoredState;
            if (bundle4 == null || bundle4.isEmpty()) {
                this.restoredState = null;
            }
            return bundle;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final SavedStateProvider getSavedStateProvider(String str) {
        m.f(str, "key");
        Iterator<Map.Entry<String, SavedStateProvider>> it = this.components.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            m.e(next, "components");
            SavedStateProvider savedStateProvider = (SavedStateProvider) next.getValue();
            if (m.b((String) next.getKey(), str)) {
                return savedStateProvider;
            }
        }
        return null;
    }

    public final boolean isAllowingSavingState$savedstate_release() {
        return this.isAllowingSavingState;
    }

    @MainThread
    public final boolean isRestored() {
        return this.isRestored;
    }

    @MainThread
    public final void performAttach$savedstate_release(Lifecycle lifecycle) {
        m.f(lifecycle, "lifecycle");
        if (!this.attached) {
            lifecycle.addObserver(new i0.a(this));
            this.attached = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    @MainThread
    public final void performRestore$savedstate_release(Bundle bundle) {
        Bundle bundle2;
        if (!this.attached) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        } else if (!this.isRestored) {
            if (bundle != null) {
                bundle2 = bundle.getBundle(SAVED_COMPONENTS_KEY);
            } else {
                bundle2 = null;
            }
            this.restoredState = bundle2;
            this.isRestored = true;
        } else {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
    }

    @MainThread
    public final void performSave(Bundle bundle) {
        m.f(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.restoredState;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = this.components.iteratorWithAdditions();
        m.e(iteratorWithAdditions, "this.components.iteratorWithAdditions()");
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
            bundle2.putBundle((String) entry.getKey(), ((SavedStateProvider) entry.getValue()).saveState());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle(SAVED_COMPONENTS_KEY, bundle2);
        }
    }

    @MainThread
    public final void registerSavedStateProvider(String str, SavedStateProvider savedStateProvider) {
        m.f(str, "key");
        m.f(savedStateProvider, "provider");
        if (this.components.putIfAbsent(str, savedStateProvider) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    @MainThread
    public final void runOnNextRecreation(Class<? extends AutoRecreated> cls) {
        m.f(cls, "clazz");
        if (this.isAllowingSavingState) {
            Recreator.SavedStateProvider savedStateProvider = this.recreatorProvider;
            if (savedStateProvider == null) {
                savedStateProvider = new Recreator.SavedStateProvider(this);
            }
            this.recreatorProvider = savedStateProvider;
            try {
                cls.getDeclaredConstructor((Class[]) null);
                Recreator.SavedStateProvider savedStateProvider2 = this.recreatorProvider;
                if (savedStateProvider2 != null) {
                    String name = cls.getName();
                    m.e(name, "clazz.name");
                    savedStateProvider2.add(name);
                }
            } catch (NoSuchMethodException e10) {
                throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
    }

    public final void setAllowingSavingState$savedstate_release(boolean z10) {
        this.isAllowingSavingState = z10;
    }

    @MainThread
    public final void unregisterSavedStateProvider(String str) {
        m.f(str, "key");
        this.components.remove(str);
    }
}
