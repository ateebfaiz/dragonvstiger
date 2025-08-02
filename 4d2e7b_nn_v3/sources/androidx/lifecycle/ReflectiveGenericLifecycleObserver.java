package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.a;

@Deprecated
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    private final Object f15859a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0203a f15860b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f15859a = obj;
        this.f15860b = a.f15879c.c(obj.getClass());
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f15860b.a(lifecycleOwner, event, this.f15859a);
    }
}
