package androidx.activity;

import android.window.OnBackInvokedCallback;
import androidx.activity.OnBackPressedDispatcher;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class z implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f13841a;

    public /* synthetic */ z(Function0 function0) {
        this.f13841a = function0;
    }

    public final void onBackInvoked() {
        OnBackPressedDispatcher.Api33Impl.createOnBackInvokedCallback$lambda$0(this.f13841a);
    }
}
