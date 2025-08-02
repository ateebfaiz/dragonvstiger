package androidx.activity;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;

public final class ActivityViewModelLazyKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy viewModels(ComponentActivity componentActivity, Function0<? extends ViewModelProvider.Factory> function0) {
        m.f(componentActivity, "<this>");
        if (function0 == null) {
            function0 = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        m.k(4, "VM");
        return new ViewModelLazy(z.b(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(componentActivity), function0, new ActivityViewModelLazyKt$viewModels$2(componentActivity));
    }

    public static /* synthetic */ Lazy viewModels$default(ComponentActivity componentActivity, Function0 function0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function0 = null;
        }
        m.f(componentActivity, "<this>");
        if (function0 == null) {
            function0 = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        m.k(4, "VM");
        return new ViewModelLazy(z.b(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(componentActivity), function0, new ActivityViewModelLazyKt$viewModels$2(componentActivity));
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy viewModels(ComponentActivity componentActivity, Function0<? extends CreationExtras> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        m.f(componentActivity, "<this>");
        if (function02 == null) {
            function02 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        m.k(4, "VM");
        return new ViewModelLazy(z.b(ViewModel.class), new ActivityViewModelLazyKt$viewModels$3(componentActivity), function02, new ActivityViewModelLazyKt$viewModels$4(function0, componentActivity));
    }

    public static /* synthetic */ Lazy viewModels$default(ComponentActivity componentActivity, Function0 function0, Function0 function02, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function0 = null;
        }
        if ((i10 & 2) != 0) {
            function02 = null;
        }
        m.f(componentActivity, "<this>");
        if (function02 == null) {
            function02 = new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        m.k(4, "VM");
        return new ViewModelLazy(z.b(ViewModel.class), new ActivityViewModelLazyKt$viewModels$3(componentActivity), function02, new ActivityViewModelLazyKt$viewModels$4(function0, componentActivity));
    }
}
