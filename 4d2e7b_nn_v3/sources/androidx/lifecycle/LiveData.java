package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.Map;

public abstract class LiveData<T> {
    static final Object NOT_SET = new Object();
    static final int START_VERSION = -1;
    int mActiveCount;
    private boolean mChangingActiveState;
    private volatile Object mData;
    final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap<Observer<? super T>, LiveData<T>.c> mObservers;
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    class LifecycleBoundObserver extends LiveData<T>.c implements LifecycleEventObserver {

        /* renamed from: e  reason: collision with root package name */
        final LifecycleOwner f15848e;

        LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer observer) {
            super(observer);
            this.f15848e = lifecycleOwner;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f15848e.getLifecycle().removeObserver(this);
        }

        /* access modifiers changed from: package-private */
        public boolean c(LifecycleOwner lifecycleOwner) {
            if (this.f15848e == lifecycleOwner) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return this.f15848e.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State currentState = this.f15848e.getLifecycle().getCurrentState();
            if (currentState == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.f15852a);
                return;
            }
            Lifecycle.State state = null;
            while (state != currentState) {
                a(d());
                state = currentState;
                currentState = this.f15848e.getLifecycle().getCurrentState();
            }
        }
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            Object obj;
            synchronized (LiveData.this.mDataLock) {
                obj = LiveData.this.mPendingData;
                LiveData.this.mPendingData = LiveData.NOT_SET;
            }
            LiveData.this.setValue(obj);
        }
    }

    private class b extends c {
        b(Observer observer) {
            super(observer);
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return true;
        }
    }

    private abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final Observer f15852a;

        /* renamed from: b  reason: collision with root package name */
        boolean f15853b;

        /* renamed from: c  reason: collision with root package name */
        int f15854c = -1;

        c(Observer observer) {
            this.f15852a = observer;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z10) {
            int i10;
            if (z10 != this.f15853b) {
                this.f15853b = z10;
                LiveData liveData = LiveData.this;
                if (z10) {
                    i10 = 1;
                } else {
                    i10 = -1;
                }
                liveData.changeActiveCounter(i10);
                if (this.f15853b) {
                    LiveData.this.dispatchingValue(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
        }

        /* access modifiers changed from: package-private */
        public boolean c(LifecycleOwner lifecycleOwner) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract boolean d();
    }

    public LiveData(T t10) {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap<>();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new a();
        this.mData = t10;
        this.mVersion = 0;
    }

    static void assertMainThread(String str) {
        if (!ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void considerNotify(LiveData<T>.c cVar) {
        if (cVar.f15853b) {
            if (!cVar.d()) {
                cVar.a(false);
                return;
            }
            int i10 = cVar.f15854c;
            int i11 = this.mVersion;
            if (i10 < i11) {
                cVar.f15854c = i11;
                cVar.f15852a.onChanged(this.mData);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public void changeActiveCounter(int i10) {
        boolean z10;
        boolean z11;
        int i11 = this.mActiveCount;
        this.mActiveCount = i10 + i11;
        if (!this.mChangingActiveState) {
            this.mChangingActiveState = true;
            while (true) {
                try {
                    int i12 = this.mActiveCount;
                    if (i11 != i12) {
                        if (i11 != 0 || i12 <= 0) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        if (i11 <= 0 || i12 != 0) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        if (z10) {
                            onActive();
                        } else if (z11) {
                            onInactive();
                        }
                        i11 = i12;
                    } else {
                        this.mChangingActiveState = false;
                        return;
                    }
                } catch (Throwable th) {
                    this.mChangingActiveState = false;
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchingValue(@Nullable LiveData<T>.c cVar) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (cVar == null) {
                SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = this.mObservers.iteratorWithAdditions();
                while (iteratorWithAdditions.hasNext()) {
                    considerNotify((c) ((Map.Entry) iteratorWithAdditions.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            } else {
                considerNotify(cVar);
                cVar = null;
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    @Nullable
    public T getValue() {
        T t10 = this.mData;
        if (t10 != NOT_SET) {
            return t10;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        if (this.mActiveCount > 0) {
            return true;
        }
        return false;
    }

    public boolean hasObservers() {
        if (this.mObservers.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isInitialized() {
        if (this.mData != NOT_SET) {
            return true;
        }
        return false;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        assertMainThread("observe");
        if (lifecycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
            c putIfAbsent = this.mObservers.putIfAbsent(observer, lifecycleBoundObserver);
            if (putIfAbsent != null && !putIfAbsent.c(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (putIfAbsent == null) {
                lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
            }
        }
    }

    @MainThread
    public void observeForever(@NonNull Observer<? super T> observer) {
        assertMainThread("observeForever");
        b bVar = new b(observer);
        c putIfAbsent = this.mObservers.putIfAbsent(observer, bVar);
        if (putIfAbsent instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (putIfAbsent == null) {
            bVar.a(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onActive() {
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
    }

    /* access modifiers changed from: protected */
    public void postValue(T t10) {
        boolean z10;
        synchronized (this.mDataLock) {
            if (this.mPendingData == NOT_SET) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.mPendingData = t10;
        }
        if (z10) {
            ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
        }
    }

    @MainThread
    public void removeObserver(@NonNull Observer<? super T> observer) {
        assertMainThread("removeObserver");
        c remove = this.mObservers.remove(observer);
        if (remove != null) {
            remove.b();
            remove.a(false);
        }
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner lifecycleOwner) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.c>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (((c) next.getValue()).c(lifecycleOwner)) {
                removeObserver((Observer) next.getKey());
            }
        }
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void setValue(T t10) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t10;
        dispatchingValue((LiveData<T>.c) null);
    }

    public LiveData() {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap<>();
        this.mActiveCount = 0;
        Object obj = NOT_SET;
        this.mPendingData = obj;
        this.mPostValueRunnable = new a();
        this.mData = obj;
        this.mVersion = -1;
    }
}
