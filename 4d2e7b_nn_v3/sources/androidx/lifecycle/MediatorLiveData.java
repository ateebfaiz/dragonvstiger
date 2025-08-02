package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, a> mSources = new SafeIterableMap<>();

    private static class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final LiveData f15856a;

        /* renamed from: b  reason: collision with root package name */
        final Observer f15857b;

        /* renamed from: c  reason: collision with root package name */
        int f15858c = -1;

        a(LiveData liveData, Observer observer) {
            this.f15856a = liveData;
            this.f15857b = observer;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f15856a.observeForever(this);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f15856a.removeObserver(this);
        }

        public void onChanged(Object obj) {
            if (this.f15858c != this.f15856a.getVersion()) {
                this.f15858c = this.f15856a.getVersion();
                this.f15857b.onChanged(obj);
            }
        }
    }

    public MediatorLiveData() {
    }

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> liveData, @NonNull Observer<? super S> observer) {
        if (liveData != null) {
            a aVar = new a(liveData, observer);
            a putIfAbsent = this.mSources.putIfAbsent(liveData, aVar);
            if (putIfAbsent != null && putIfAbsent.f15857b != observer) {
                throw new IllegalArgumentException("This source was already added with the different observer");
            } else if (putIfAbsent == null && hasActiveObservers()) {
                aVar.a();
            }
        } else {
            throw new NullPointerException("source cannot be null");
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, a>> it = this.mSources.iterator();
        while (it.hasNext()) {
            ((a) it.next().getValue()).a();
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, a>> it = this.mSources.iterator();
        while (it.hasNext()) {
            ((a) it.next().getValue()).b();
        }
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> liveData) {
        a remove = this.mSources.remove(liveData);
        if (remove != null) {
            remove.b();
        }
    }

    public MediatorLiveData(T t10) {
        super(t10);
    }
}
