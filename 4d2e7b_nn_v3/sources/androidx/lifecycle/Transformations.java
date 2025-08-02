package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.v;

public final class Transformations {

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f15863a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ v f15864b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(MediatorLiveData mediatorLiveData, v vVar) {
            super(1);
            this.f15863a = mediatorLiveData;
            this.f15864b = vVar;
        }

        public final void a(Object obj) {
            Object value = this.f15863a.getValue();
            if (this.f15864b.f722a || ((value == null && obj != null) || (value != null && !m.b(value, obj)))) {
                this.f15864b.f722a = false;
                this.f15863a.setValue(obj);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return Unit.f12577a;
        }
    }

    static final class b extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f15865a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Function1 f15866b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MediatorLiveData mediatorLiveData, Function1 function1) {
            super(1);
            this.f15865a = mediatorLiveData;
            this.f15866b = function1;
        }

        public final void a(Object obj) {
            this.f15865a.setValue(this.f15866b.invoke(obj));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return Unit.f12577a;
        }
    }

    static final class c extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f15867a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Function f15868b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(MediatorLiveData mediatorLiveData, Function function) {
            super(1);
            this.f15867a = mediatorLiveData;
            this.f15868b = function;
        }

        public final void a(Object obj) {
            this.f15867a.setValue(this.f15868b.apply(obj));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return Unit.f12577a;
        }
    }

    static final class d implements Observer, g {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f15869a;

        d(Function1 function1) {
            m.f(function1, "function");
            this.f15869a = function1;
        }

        public final kotlin.d a() {
            return this.f15869a;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Observer) || !(obj instanceof g)) {
                return false;
            }
            return m.b(a(), ((g) obj).a());
        }

        public final int hashCode() {
            return a().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f15869a.invoke(obj);
        }
    }

    @CheckResult
    @MainThread
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        m.f(liveData, "<this>");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        v vVar = new v();
        vVar.f722a = true;
        if (liveData.isInitialized()) {
            mediatorLiveData.setValue(liveData.getValue());
            vVar.f722a = false;
        }
        mediatorLiveData.addSource(liveData, new d(new a(mediatorLiveData, vVar)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, Function1<X, Y> function1) {
        m.f(liveData, "<this>");
        m.f(function1, "transform");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new d(new b(mediatorLiveData, function1)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, Function1<X, LiveData<Y>> function1) {
        m.f(liveData, "<this>");
        m.f(function1, "transform");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$switchMap$1(function1, mediatorLiveData));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData liveData, Function function) {
        m.f(liveData, "<this>");
        m.f(function, "mapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new d(new c(mediatorLiveData, function)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, Function function) {
        m.f(liveData, "<this>");
        m.f(function, "switchMapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$switchMap$2(function, mediatorLiveData));
        return mediatorLiveData;
    }
}
