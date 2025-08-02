package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;

public final class InitializerViewModelFactoryKt {
    public static final /* synthetic */ <VM extends ViewModel> void initializer(InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder, Function1<? super CreationExtras, ? extends VM> function1) {
        m.f(initializerViewModelFactoryBuilder, "<this>");
        m.f(function1, "initializer");
        m.k(4, "VM");
        initializerViewModelFactoryBuilder.addInitializer(z.b(ViewModel.class), function1);
    }

    public static final ViewModelProvider.Factory viewModelFactory(Function1<? super InitializerViewModelFactoryBuilder, Unit> function1) {
        m.f(function1, "builder");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        function1.invoke(initializerViewModelFactoryBuilder);
        return initializerViewModelFactoryBuilder.build();
    }
}
