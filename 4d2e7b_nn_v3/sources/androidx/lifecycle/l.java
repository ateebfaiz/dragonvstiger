package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import kotlin.jvm.internal.m;

public abstract /* synthetic */ class l {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.Companion;
    }

    public static ViewModel a(ViewModelProvider.Factory factory, Class cls) {
        m.f(cls, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static ViewModel b(ViewModelProvider.Factory factory, Class cls, CreationExtras creationExtras) {
        m.f(cls, "modelClass");
        m.f(creationExtras, "extras");
        return factory.create(cls);
    }

    public static ViewModelProvider.Factory c(ViewModelInitializer... viewModelInitializerArr) {
        return ViewModelProvider.Factory.Companion.from(viewModelInitializerArr);
    }
}
