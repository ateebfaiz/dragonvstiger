package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.l;
import kotlin.jvm.internal.m;

public final class InitializerViewModelFactory implements ViewModelProvider.Factory {
    private final ViewModelInitializer<?>[] initializers;

    public InitializerViewModelFactory(ViewModelInitializer<?>... viewModelInitializerArr) {
        m.f(viewModelInitializerArr, "initializers");
        this.initializers = viewModelInitializerArr;
    }

    public /* synthetic */ ViewModel create(Class cls) {
        return l.a(this, cls);
    }

    public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        m.f(cls, "modelClass");
        m.f(creationExtras, "extras");
        T t10 = null;
        for (ViewModelInitializer<?> viewModelInitializer : this.initializers) {
            if (m.b(viewModelInitializer.getClazz$lifecycle_viewmodel_release(), cls)) {
                T invoke = viewModelInitializer.getInitializer$lifecycle_viewmodel_release().invoke(creationExtras);
                t10 = invoke instanceof ViewModel ? (ViewModel) invoke : null;
            }
        }
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("No initializer set for given class " + cls.getName());
    }
}
