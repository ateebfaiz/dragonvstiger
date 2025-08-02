package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.l;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {

    /* renamed from: c  reason: collision with root package name */
    static boolean f15894c;

    /* renamed from: a  reason: collision with root package name */
    private final LifecycleOwner f15895a;

    /* renamed from: b  reason: collision with root package name */
    private final b f15896b;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
        @Nullable
        private final Bundle mArgs;
        private final int mId;
        private LifecycleOwner mLifecycleOwner;
        @NonNull
        private final Loader<D> mLoader;
        private a mObserver;
        private Loader<D> mPriorLoader;

        LoaderInfo(int i10, @Nullable Bundle bundle, @NonNull Loader<D> loader, @Nullable Loader<D> loader2) {
            this.mId = i10;
            this.mArgs = bundle;
            this.mLoader = loader;
            this.mPriorLoader = loader2;
            loader.registerListener(i10, this);
        }

        /* access modifiers changed from: package-private */
        @MainThread
        public Loader<D> destroy(boolean z10) {
            if (LoaderManagerImpl.f15894c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.mLoader.cancelLoad();
            this.mLoader.abandon();
            a aVar = this.mObserver;
            if (aVar != null) {
                removeObserver(aVar);
                if (z10) {
                    aVar.c();
                }
            }
            this.mLoader.unregisterListener(this);
            if ((aVar == null || aVar.b()) && !z10) {
                return this.mLoader;
            }
            this.mLoader.reset();
            return this.mPriorLoader;
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mArgs=");
            printWriter.println(this.mArgs);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.mLoader);
            Loader<D> loader = this.mLoader;
            loader.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.mObserver != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.mObserver);
                a aVar = this.mObserver;
                aVar.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(getLoader().dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Loader<D> getLoader() {
            return this.mLoader;
        }

        /* access modifiers changed from: package-private */
        public boolean isCallbackWaitingForData() {
            a aVar;
            if (hasActiveObservers() && (aVar = this.mObserver) != null && !aVar.b()) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void markForRedelivery() {
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            a aVar = this.mObserver;
            if (lifecycleOwner != null && aVar != null) {
                super.removeObserver(aVar);
                observe(lifecycleOwner, aVar);
            }
        }

        /* access modifiers changed from: protected */
        public void onActive() {
            if (LoaderManagerImpl.f15894c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.mLoader.startLoading();
        }

        /* access modifiers changed from: protected */
        public void onInactive() {
            if (LoaderManagerImpl.f15894c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.mLoader.stopLoading();
        }

        public void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d10) {
            if (LoaderManagerImpl.f15894c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d10);
                return;
            }
            if (LoaderManagerImpl.f15894c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(d10);
        }

        public void removeObserver(@NonNull Observer<? super D> observer) {
            super.removeObserver(observer);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        /* access modifiers changed from: package-private */
        @MainThread
        @NonNull
        public Loader<D> setCallback(@NonNull LifecycleOwner lifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            a aVar = new a(this.mLoader, loaderCallbacks);
            observe(lifecycleOwner, aVar);
            a aVar2 = this.mObserver;
            if (aVar2 != null) {
                removeObserver(aVar2);
            }
            this.mLifecycleOwner = lifecycleOwner;
            this.mObserver = aVar;
            return this.mLoader;
        }

        public void setValue(D d10) {
            super.setValue(d10);
            Loader<D> loader = this.mPriorLoader;
            if (loader != null) {
                loader.reset();
                this.mPriorLoader = null;
            }
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.mId);
            sb2.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, sb2);
            sb2.append("}}");
            return sb2.toString();
        }
    }

    static class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        private final Loader f15897a;

        /* renamed from: b  reason: collision with root package name */
        private final LoaderManager.LoaderCallbacks f15898b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f15899c = false;

        a(Loader loader, LoaderManager.LoaderCallbacks loaderCallbacks) {
            this.f15897a = loader;
            this.f15898b = loaderCallbacks;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f15899c);
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f15899c;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (this.f15899c) {
                if (LoaderManagerImpl.f15894c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f15897a);
                }
                this.f15898b.onLoaderReset(this.f15897a);
            }
        }

        public void onChanged(Object obj) {
            if (LoaderManagerImpl.f15894c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f15897a + ": " + this.f15897a.dataToString(obj));
            }
            this.f15898b.onLoadFinished(this.f15897a, obj);
            this.f15899c = true;
        }

        public String toString() {
            return this.f15898b.toString();
        }
    }

    static class b extends ViewModel {

        /* renamed from: c  reason: collision with root package name */
        private static final ViewModelProvider.Factory f15900c = new a();

        /* renamed from: a  reason: collision with root package name */
        private SparseArrayCompat f15901a = new SparseArrayCompat();

        /* renamed from: b  reason: collision with root package name */
        private boolean f15902b = false;

        static class a implements ViewModelProvider.Factory {
            a() {
            }

            public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return l.b(this, cls, creationExtras);
            }

            public ViewModel create(Class cls) {
                return new b();
            }
        }

        b() {
        }

        static b c(ViewModelStore viewModelStore) {
            return (b) new ViewModelProvider(viewModelStore, f15900c).get(b.class);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f15901a.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < this.f15901a.size(); i10++) {
                    LoaderInfo loaderInfo = (LoaderInfo) this.f15901a.valueAt(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f15901a.keyAt(i10));
                    printWriter.print(": ");
                    printWriter.println(loaderInfo.toString());
                    loaderInfo.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f15902b = false;
        }

        /* access modifiers changed from: package-private */
        public LoaderInfo d(int i10) {
            return (LoaderInfo) this.f15901a.get(i10);
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            int size = this.f15901a.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((LoaderInfo) this.f15901a.valueAt(i10)).isCallbackWaitingForData()) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean f() {
            return this.f15902b;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int size = this.f15901a.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((LoaderInfo) this.f15901a.valueAt(i10)).markForRedelivery();
            }
        }

        /* access modifiers changed from: package-private */
        public void h(int i10, LoaderInfo loaderInfo) {
            this.f15901a.put(i10, loaderInfo);
        }

        /* access modifiers changed from: package-private */
        public void i(int i10) {
            this.f15901a.remove(i10);
        }

        /* access modifiers changed from: package-private */
        public void j() {
            this.f15902b = true;
        }

        /* access modifiers changed from: protected */
        public void onCleared() {
            super.onCleared();
            int size = this.f15901a.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((LoaderInfo) this.f15901a.valueAt(i10)).destroy(true);
            }
            this.f15901a.clear();
        }
    }

    LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.f15895a = lifecycleOwner;
        this.f15896b = b.c(viewModelStore);
    }

    private Loader a(int i10, Bundle bundle, LoaderManager.LoaderCallbacks loaderCallbacks, Loader loader) {
        try {
            this.f15896b.j();
            Loader onCreateLoader = loaderCallbacks.onCreateLoader(i10, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                    }
                }
                LoaderInfo loaderInfo = new LoaderInfo(i10, bundle, onCreateLoader, loader);
                if (f15894c) {
                    Log.v("LoaderManager", "  Created new loader " + loaderInfo);
                }
                this.f15896b.h(i10, loaderInfo);
                this.f15896b.b();
                return loaderInfo.setCallback(this.f15895a, loaderCallbacks);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f15896b.b();
            throw th;
        }
    }

    public void destroyLoader(int i10) {
        if (this.f15896b.f()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f15894c) {
                Log.v("LoaderManager", "destroyLoader in " + this + " of " + i10);
            }
            LoaderInfo d10 = this.f15896b.d(i10);
            if (d10 != null) {
                d10.destroy(true);
                this.f15896b.i(i10);
            }
        } else {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f15896b.a(str, fileDescriptor, printWriter, strArr);
    }

    public Loader getLoader(int i10) {
        if (!this.f15896b.f()) {
            LoaderInfo d10 = this.f15896b.d(i10);
            if (d10 != null) {
                return d10.getLoader();
            }
            return null;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public boolean hasRunningLoaders() {
        return this.f15896b.e();
    }

    public Loader initLoader(int i10, Bundle bundle, LoaderManager.LoaderCallbacks loaderCallbacks) {
        if (this.f15896b.f()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            LoaderInfo d10 = this.f15896b.d(i10);
            if (f15894c) {
                Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
            }
            if (d10 == null) {
                return a(i10, bundle, loaderCallbacks, (Loader) null);
            }
            if (f15894c) {
                Log.v("LoaderManager", "  Re-using existing loader " + d10);
            }
            return d10.setCallback(this.f15895a, loaderCallbacks);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    public void markForRedelivery() {
        this.f15896b.g();
    }

    public Loader restartLoader(int i10, Bundle bundle, LoaderManager.LoaderCallbacks loaderCallbacks) {
        Loader loader;
        if (this.f15896b.f()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f15894c) {
                Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
            }
            LoaderInfo d10 = this.f15896b.d(i10);
            if (d10 != null) {
                loader = d10.destroy(false);
            } else {
                loader = null;
            }
            return a(i10, bundle, loaderCallbacks, loader);
        } else {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        DebugUtils.buildShortClassTag(this.f15895a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
