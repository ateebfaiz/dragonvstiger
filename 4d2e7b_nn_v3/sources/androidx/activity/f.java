package androidx.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class f implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f13815a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f13816b;

    public /* synthetic */ f(OnBackPressedDispatcher onBackPressedDispatcher, ComponentActivity componentActivity) {
        this.f13815a = onBackPressedDispatcher;
        this.f13816b = componentActivity;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ComponentActivity.addObserverForBackInvoker$lambda$7(this.f13815a, this.f13816b, lifecycleOwner, event);
    }
}
