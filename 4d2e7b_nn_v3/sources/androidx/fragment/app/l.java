package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.f;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

class l implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {

    /* renamed from: a  reason: collision with root package name */
    private final Fragment f15807a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewModelStore f15808b;

    /* renamed from: c  reason: collision with root package name */
    private ViewModelProvider.Factory f15809c;

    /* renamed from: d  reason: collision with root package name */
    private LifecycleRegistry f15810d = null;

    /* renamed from: e  reason: collision with root package name */
    private SavedStateRegistryController f15811e = null;

    l(Fragment fragment, ViewModelStore viewModelStore) {
        this.f15807a = fragment;
        this.f15808b = viewModelStore;
    }

    /* access modifiers changed from: package-private */
    public void a(Lifecycle.Event event) {
        this.f15810d.handleLifecycleEvent(event);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f15810d == null) {
            this.f15810d = new LifecycleRegistry(this);
            this.f15811e = SavedStateRegistryController.create(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        if (this.f15810d != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void d(Bundle bundle) {
        this.f15811e.performRestore(bundle);
    }

    /* access modifiers changed from: package-private */
    public void e(Bundle bundle) {
        this.f15811e.performSave(bundle);
    }

    /* access modifiers changed from: package-private */
    public void f(Lifecycle.State state) {
        this.f15810d.setCurrentState(state);
    }

    public /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return f.a(this);
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.f15807a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f15807a.mDefaultFactory)) {
            this.f15809c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f15809c == null) {
            Context applicationContext = this.f15807a.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                } else if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                } else {
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                }
            }
            this.f15809c = new SavedStateViewModelFactory(application, this, this.f15807a.getArguments());
        }
        return this.f15809c;
    }

    public Lifecycle getLifecycle() {
        b();
        return this.f15810d;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        b();
        return this.f15811e.getSavedStateRegistry();
    }

    public ViewModelStore getViewModelStore() {
        b();
        return this.f15808b;
    }
}
