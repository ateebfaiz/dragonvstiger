package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;
import kotlin.Lazy;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    private boolean restored;
    private Bundle restoredState;
    private final SavedStateRegistry savedStateRegistry;
    private final Lazy viewModel$delegate;

    static final class a extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f15862a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ViewModelStoreOwner viewModelStoreOwner) {
            super(0);
            this.f15862a = viewModelStoreOwner;
        }

        /* renamed from: a */
        public final SavedStateHandlesVM invoke() {
            return SavedStateHandleSupport.getSavedStateHandlesVM(this.f15862a);
        }
    }

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry2, ViewModelStoreOwner viewModelStoreOwner) {
        m.f(savedStateRegistry2, "savedStateRegistry");
        m.f(viewModelStoreOwner, "viewModelStoreOwner");
        this.savedStateRegistry = savedStateRegistry2;
        this.viewModel$delegate = i.b(new a(viewModelStoreOwner));
    }

    private final SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM) this.viewModel$delegate.getValue();
    }

    public final Bundle consumeRestoredStateForKey(String str) {
        Bundle bundle;
        m.f(str, "key");
        performRestore();
        Bundle bundle2 = this.restoredState;
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
        if (bundle4 != null && bundle4.isEmpty()) {
            this.restoredState = null;
        }
        return bundle;
    }

    public final void performRestore() {
        if (!this.restored) {
            Bundle consumeRestoredStateForKey = this.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.restoredState;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            if (consumeRestoredStateForKey != null) {
                bundle.putAll(consumeRestoredStateForKey);
            }
            this.restoredState = bundle;
            this.restored = true;
            getViewModel();
        }
    }

    public Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.restoredState;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry next : getViewModel().getHandles().entrySet()) {
            String str = (String) next.getKey();
            Bundle saveState = ((SavedStateHandle) next.getValue()).savedStateProvider().saveState();
            if (!m.b(saveState, Bundle.EMPTY)) {
                bundle.putBundle(str, saveState);
            }
        }
        this.restored = false;
        return bundle;
    }
}
