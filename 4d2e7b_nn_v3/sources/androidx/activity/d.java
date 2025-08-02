package androidx.activity;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class d implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f13813a;

    public /* synthetic */ d(ComponentActivity componentActivity) {
        this.f13813a = componentActivity;
    }

    public final Bundle saveState() {
        return ComponentActivity._init_$lambda$4(this.f13813a);
    }
}
