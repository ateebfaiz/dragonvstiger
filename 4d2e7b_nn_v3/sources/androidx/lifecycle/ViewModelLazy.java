package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import zb.c;

public final class ViewModelLazy<VM extends ViewModel> implements Lazy {
    private VM cached;
    private final Function0<CreationExtras> extrasProducer;
    private final Function0<ViewModelProvider.Factory> factoryProducer;
    private final Function0<ViewModelStore> storeProducer;
    private final c viewModelClass;

    static final class a extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15872a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final CreationExtras.Empty invoke() {
            return CreationExtras.Empty.INSTANCE;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(c cVar, Function0<? extends ViewModelStore> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        this(cVar, function0, function02, (Function0) null, 8, (DefaultConstructorMarker) null);
        m.f(cVar, "viewModelClass");
        m.f(function0, "storeProducer");
        m.f(function02, "factoryProducer");
    }

    public boolean isInitialized() {
        if (this.cached != null) {
            return true;
        }
        return false;
    }

    public ViewModelLazy(c cVar, Function0<? extends ViewModelStore> function0, Function0<? extends ViewModelProvider.Factory> function02, Function0<? extends CreationExtras> function03) {
        m.f(cVar, "viewModelClass");
        m.f(function0, "storeProducer");
        m.f(function02, "factoryProducer");
        m.f(function03, "extrasProducer");
        this.viewModelClass = cVar;
        this.storeProducer = function0;
        this.factoryProducer = function02;
        this.extrasProducer = function03;
    }

    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = new ViewModelProvider((ViewModelStore) this.storeProducer.invoke(), (ViewModelProvider.Factory) this.factoryProducer.invoke(), (CreationExtras) this.extrasProducer.invoke()).get(ub.a.a(this.viewModelClass));
        this.cached = vm2;
        return vm2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelLazy(c cVar, Function0 function0, Function0 function02, Function0 function03, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, function0, function02, (i10 & 8) != 0 ? a.f15872a : function03);
    }
}
