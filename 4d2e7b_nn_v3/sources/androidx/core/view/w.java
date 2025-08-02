package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class w implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f15280a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f15281b;

    public /* synthetic */ w(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.f15280a = menuHostHelper;
        this.f15281b = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f15280a.lambda$addMenuProvider$0(this.f15281b, lifecycleOwner, event);
    }
}
