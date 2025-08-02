package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.m;

public final class ViewModelProviderGetKt {
    public static final CreationExtras defaultCreationExtras(ViewModelStoreOwner viewModelStoreOwner) {
        m.f(viewModelStoreOwner, "owner");
        if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
            return ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras();
        }
        return CreationExtras.Empty.INSTANCE;
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        m.f(viewModelProvider, "<this>");
        m.k(4, "VM");
        return viewModelProvider.get(ViewModel.class);
    }
}
