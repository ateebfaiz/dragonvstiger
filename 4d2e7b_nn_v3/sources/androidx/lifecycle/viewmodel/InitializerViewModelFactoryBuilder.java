package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import ub.a;
import zb.c;

@ViewModelFactoryDsl
public final class InitializerViewModelFactoryBuilder {
    private final List<ViewModelInitializer<?>> initializers = new ArrayList();

    public final <T extends ViewModel> void addInitializer(c cVar, Function1<? super CreationExtras, ? extends T> function1) {
        m.f(cVar, "clazz");
        m.f(function1, "initializer");
        this.initializers.add(new ViewModelInitializer(a.a(cVar), function1));
    }

    public final ViewModelProvider.Factory build() {
        ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) this.initializers.toArray(new ViewModelInitializer[0]);
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }
}
