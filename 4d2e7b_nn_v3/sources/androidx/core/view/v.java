package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class v implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f15275a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f15276b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f15277c;

    public /* synthetic */ v(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.f15275a = menuHostHelper;
        this.f15276b = state;
        this.f15277c = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f15275a.lambda$addMenuProvider$1(this.f15276b, this.f15277c, lifecycleOwner, event);
    }
}
