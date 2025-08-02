package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

abstract class g extends Fragment {
    protected final LinkedHashSet<OnSelectionChangedListener<Object>> onSelectionChangedListeners = new LinkedHashSet<>();

    g() {
    }

    /* access modifiers changed from: package-private */
    public boolean addOnSelectionChangedListener(OnSelectionChangedListener<Object> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.add(onSelectionChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void clearOnSelectionChangedListeners() {
        this.onSelectionChangedListeners.clear();
    }

    /* access modifiers changed from: package-private */
    public boolean removeOnSelectionChangedListener(OnSelectionChangedListener<Object> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.remove(onSelectionChangedListener);
    }
}
