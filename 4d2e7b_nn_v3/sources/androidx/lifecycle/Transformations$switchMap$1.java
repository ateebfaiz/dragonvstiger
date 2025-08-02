package androidx.lifecycle;

import androidx.lifecycle.Transformations;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class Transformations$switchMap$1 implements Observer<X> {
    final /* synthetic */ MediatorLiveData<Y> $result;
    final /* synthetic */ Function1<X, LiveData<Y>> $transform;
    private LiveData<Y> liveData;

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f15870a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(MediatorLiveData mediatorLiveData) {
            super(1);
            this.f15870a = mediatorLiveData;
        }

        public final void a(Object obj) {
            this.f15870a.setValue(obj);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return Unit.f12577a;
        }
    }

    Transformations$switchMap$1(Function1<X, LiveData<Y>> function1, MediatorLiveData<Y> mediatorLiveData) {
        this.$transform = function1;
        this.$result = mediatorLiveData;
    }

    public final LiveData<Y> getLiveData() {
        return this.liveData;
    }

    public void onChanged(X x10) {
        LiveData<Y> liveData2 = (LiveData) this.$transform.invoke(x10);
        LiveData<Y> liveData3 = this.liveData;
        if (liveData3 != liveData2) {
            if (liveData3 != null) {
                MediatorLiveData<Y> mediatorLiveData = this.$result;
                m.c(liveData3);
                mediatorLiveData.removeSource(liveData3);
            }
            this.liveData = liveData2;
            if (liveData2 != null) {
                MediatorLiveData<Y> mediatorLiveData2 = this.$result;
                m.c(liveData2);
                mediatorLiveData2.addSource(liveData2, new Transformations.d(new a(this.$result)));
            }
        }
    }

    public final void setLiveData(LiveData<Y> liveData2) {
        this.liveData = liveData2;
    }
}
