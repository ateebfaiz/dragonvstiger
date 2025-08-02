package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class c implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityResultRegistry f13836a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f13837b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ActivityResultCallback f13838c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ActivityResultContract f13839d;

    public /* synthetic */ c(ActivityResultRegistry activityResultRegistry, String str, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract) {
        this.f13836a = activityResultRegistry;
        this.f13837b = str;
        this.f13838c = activityResultCallback;
        this.f13839d = activityResultContract;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ActivityResultRegistry.register$lambda$1(this.f13836a, this.f13837b, this.f13838c, this.f13839d, lifecycleOwner, event);
    }
}
