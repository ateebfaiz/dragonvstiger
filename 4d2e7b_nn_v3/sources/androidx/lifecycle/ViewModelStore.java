package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;

public class ViewModelStore {
    private final Map<String, ViewModel> map = new LinkedHashMap();

    public final void clear() {
        for (ViewModel clear : this.map.values()) {
            clear.clear();
        }
        this.map.clear();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ViewModel get(String str) {
        m.f(str, "key");
        return this.map.get(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Set<String> keys() {
        return new HashSet(this.map.keySet());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void put(String str, ViewModel viewModel) {
        m.f(str, "key");
        m.f(viewModel, "viewModel");
        ViewModel put = this.map.put(str, viewModel);
        if (put != null) {
            put.onCleared();
        }
    }
}
