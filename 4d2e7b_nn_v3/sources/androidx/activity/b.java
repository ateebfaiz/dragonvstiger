package androidx.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class b implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f13809a;

    public /* synthetic */ b(ComponentActivity componentActivity) {
        this.f13809a = componentActivity;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ComponentActivity._init_$lambda$2(this.f13809a, lifecycleOwner, event);
    }
}
