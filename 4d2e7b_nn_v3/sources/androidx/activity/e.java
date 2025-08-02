package androidx.activity;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;

public final /* synthetic */ class e implements OnContextAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f13814a;

    public /* synthetic */ e(ComponentActivity componentActivity) {
        this.f13814a = componentActivity;
    }

    public final void onContextAvailable(Context context) {
        ComponentActivity._init_$lambda$5(this.f13814a, context);
    }
}
