package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class k implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateHandle f15893a;

    public /* synthetic */ k(SavedStateHandle savedStateHandle) {
        this.f15893a = savedStateHandle;
    }

    public final Bundle saveState() {
        return SavedStateHandle.savedStateProvider$lambda$0(this.f15893a);
    }
}
