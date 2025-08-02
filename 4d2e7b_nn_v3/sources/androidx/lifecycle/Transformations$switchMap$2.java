package androidx.lifecycle;

import androidx.arch.core.util.Function;
import androidx.lifecycle.Transformations;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class Transformations$switchMap$2 implements Observer {
    final /* synthetic */ MediatorLiveData $result;
    final /* synthetic */ Function $switchMapFunction;
    private LiveData liveData;

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f15871a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(MediatorLiveData mediatorLiveData) {
            super(1);
            this.f15871a = mediatorLiveData;
        }

        public final void a(Object obj) {
            this.f15871a.setValue(obj);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return Unit.f12577a;
        }
    }

    Transformations$switchMap$2(Function function, MediatorLiveData mediatorLiveData) {
        this.$switchMapFunction = function;
        this.$result = mediatorLiveData;
    }

    public final LiveData getLiveData() {
        return this.liveData;
    }

    public void onChanged(Object obj) {
        LiveData liveData2 = (LiveData) this.$switchMapFunction.apply(obj);
        LiveData liveData3 = this.liveData;
        if (liveData3 != liveData2) {
            if (liveData3 != null) {
                MediatorLiveData mediatorLiveData = this.$result;
                m.c(liveData3);
                mediatorLiveData.removeSource(liveData3);
            }
            this.liveData = liveData2;
            if (liveData2 != null) {
                MediatorLiveData mediatorLiveData2 = this.$result;
                m.c(liveData2);
                mediatorLiveData2.addSource(liveData2, new Transformations.d(new a(this.$result)));
            }
        }
    }

    public final void setLiveData(LiveData liveData2) {
        this.liveData = liveData2;
    }
}
