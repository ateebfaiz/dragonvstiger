package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.StyleRes;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public class ComponentDialog extends Dialog implements LifecycleOwner, OnBackPressedDispatcherOwner, SavedStateRegistryOwner {
    private LifecycleRegistry _lifecycleRegistry;
    private final OnBackPressedDispatcher onBackPressedDispatcher;
    private final SavedStateRegistryController savedStateRegistryController;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ComponentDialog(Context context) {
        this(context, 0, 2, (DefaultConstructorMarker) null);
        m.f(context, "context");
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        LifecycleRegistry lifecycleRegistry = this._lifecycleRegistry;
        if (lifecycleRegistry != null) {
            return lifecycleRegistry;
        }
        LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this);
        this._lifecycleRegistry = lifecycleRegistry2;
        return lifecycleRegistry2;
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    /* access modifiers changed from: private */
    public static final void onBackPressedDispatcher$lambda$1(ComponentDialog componentDialog) {
        m.f(componentDialog, "this$0");
        super.onBackPressed();
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m.f(view, "view");
        initializeViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    @CallSuper
    public void initializeViewTreeOwners() {
        Window window = getWindow();
        m.c(window);
        View decorView = window.getDecorView();
        m.e(decorView, "window!!.decorView");
        ViewTreeLifecycleOwner.set(decorView, this);
        Window window2 = getWindow();
        m.c(window2);
        View decorView2 = window2.getDecorView();
        m.e(decorView2, "window!!.decorView");
        ViewTreeOnBackPressedDispatcherOwner.set(decorView2, this);
        Window window3 = getWindow();
        m.c(window3);
        View decorView3 = window3.getDecorView();
        m.e(decorView3, "window!!.decorView");
        ViewTreeSavedStateRegistryOwner.set(decorView3, this);
    }

    @CallSuper
    public void onBackPressed() {
        this.onBackPressedDispatcher.onBackPressed();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher2 = this.onBackPressedDispatcher;
            OnBackInvokedDispatcher a10 = getOnBackInvokedDispatcher();
            m.e(a10, "onBackInvokedDispatcher");
            onBackPressedDispatcher2.setOnBackInvokedDispatcher(a10);
        }
        this.savedStateRegistryController.performRestore(bundle);
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        m.e(onSaveInstanceState, "super.onSaveInstanceState()");
        this.savedStateRegistryController.performSave(onSaveInstanceState);
        return onSaveInstanceState;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onStart() {
        super.onStart();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onStop() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    public void setContentView(int i10) {
        initializeViewTreeOwners();
        super.setContentView(i10);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComponentDialog(Context context, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? 0 : i10);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComponentDialog(Context context, @StyleRes int i10) {
        super(context, i10);
        m.f(context, "context");
        this.savedStateRegistryController = SavedStateRegistryController.Companion.create(this);
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new m(this));
    }

    public void setContentView(View view) {
        m.f(view, "view");
        initializeViewTreeOwners();
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m.f(view, "view");
        initializeViewTreeOwners();
        super.setContentView(view, layoutParams);
    }
}
