package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuHostHelper {
    private final CopyOnWriteArrayList<MenuProvider> mMenuProviders = new CopyOnWriteArrayList<>();
    private final Runnable mOnInvalidateMenuCallback;
    private final Map<MenuProvider, a> mProviderToLifecycleContainers = new HashMap();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f15156a;

        /* renamed from: b  reason: collision with root package name */
        private LifecycleEventObserver f15157b;

        a(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            this.f15156a = lifecycle;
            this.f15157b = lifecycleEventObserver;
            lifecycle.addObserver(lifecycleEventObserver);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f15156a.removeObserver(this.f15157b);
            this.f15157b = null;
        }
    }

    public MenuHostHelper(@NonNull Runnable runnable) {
        this.mOnInvalidateMenuCallback = runnable;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addMenuProvider$0(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            removeMenuProvider(menuProvider);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addMenuProvider$1(Lifecycle.State state, MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            addMenuProvider(menuProvider);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            removeMenuProvider(menuProvider);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            this.mMenuProviders.remove(menuProvider);
            this.mOnInvalidateMenuCallback.run();
        }
    }

    public void addMenuProvider(@NonNull MenuProvider menuProvider) {
        this.mMenuProviders.add(menuProvider);
        this.mOnInvalidateMenuCallback.run();
    }

    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            it.next().onCreateMenu(menu, menuInflater);
        }
    }

    public void onMenuClosed(@NonNull Menu menu) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            it.next().onMenuClosed(menu);
        }
    }

    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            if (it.next().onMenuItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void onPrepareMenu(@NonNull Menu menu) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            it.next().onPrepareMenu(menu);
        }
    }

    public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
        this.mMenuProviders.remove(menuProvider);
        a remove = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.mOnInvalidateMenuCallback.run();
    }

    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner) {
        addMenuProvider(menuProvider);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        a remove = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.mProviderToLifecycleContainers.put(menuProvider, new a(lifecycle, new w(this, menuProvider)));
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        a remove = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.mProviderToLifecycleContainers.put(menuProvider, new a(lifecycle, new v(this, state, menuProvider)));
    }
}
