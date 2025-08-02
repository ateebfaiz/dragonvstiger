package androidx.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class c implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f13812a;

    public /* synthetic */ c(ComponentActivity componentActivity) {
        this.f13812a = componentActivity;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ComponentActivity._init_$lambda$3(this.f13812a, lifecycleOwner, event);
    }
}
