package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import com.google.android.material.internal.MaterialCheckable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@UiThread
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CheckableGroup<T extends MaterialCheckable<T>> {
    private final Map<Integer, T> checkables = new HashMap();
    private final Set<Integer> checkedIds = new HashSet();
    private OnCheckedStateChangeListener onCheckedStateChangeListener;
    /* access modifiers changed from: private */
    public boolean selectionRequired;
    private boolean singleSelection;

    public interface OnCheckedStateChangeListener {
        void onCheckedStateChanged(@NonNull Set<Integer> set);
    }

    class a implements MaterialCheckable.OnCheckedChangeListener {
        a() {
        }

        /* renamed from: a */
        public void onCheckedChanged(MaterialCheckable materialCheckable, boolean z10) {
            if (!z10) {
                CheckableGroup checkableGroup = CheckableGroup.this;
                if (!checkableGroup.uncheckInternal(materialCheckable, checkableGroup.selectionRequired)) {
                    return;
                }
            } else if (!CheckableGroup.this.checkInternal(materialCheckable)) {
                return;
            }
            CheckableGroup.this.onCheckedStateChanged();
        }
    }

    /* access modifiers changed from: private */
    public boolean checkInternal(@NonNull MaterialCheckable<T> materialCheckable) {
        int id2 = materialCheckable.getId();
        if (this.checkedIds.contains(Integer.valueOf(id2))) {
            return false;
        }
        MaterialCheckable materialCheckable2 = (MaterialCheckable) this.checkables.get(Integer.valueOf(getSingleCheckedId()));
        if (materialCheckable2 != null) {
            uncheckInternal(materialCheckable2, false);
        }
        boolean add = this.checkedIds.add(Integer.valueOf(id2));
        if (!materialCheckable.isChecked()) {
            materialCheckable.setChecked(true);
        }
        return add;
    }

    /* access modifiers changed from: private */
    public void onCheckedStateChanged() {
        OnCheckedStateChangeListener onCheckedStateChangeListener2 = this.onCheckedStateChangeListener;
        if (onCheckedStateChangeListener2 != null) {
            onCheckedStateChangeListener2.onCheckedStateChanged(getCheckedIds());
        }
    }

    /* access modifiers changed from: private */
    public boolean uncheckInternal(@NonNull MaterialCheckable<T> materialCheckable, boolean z10) {
        int id2 = materialCheckable.getId();
        if (!this.checkedIds.contains(Integer.valueOf(id2))) {
            return false;
        }
        if (!z10 || this.checkedIds.size() != 1 || !this.checkedIds.contains(Integer.valueOf(id2))) {
            boolean remove = this.checkedIds.remove(Integer.valueOf(id2));
            if (materialCheckable.isChecked()) {
                materialCheckable.setChecked(false);
            }
            return remove;
        }
        materialCheckable.setChecked(true);
        return false;
    }

    public void addCheckable(T t10) {
        this.checkables.put(Integer.valueOf(t10.getId()), t10);
        if (t10.isChecked()) {
            checkInternal(t10);
        }
        t10.setInternalOnCheckedChangeListener(new a());
    }

    public void check(@IdRes int i10) {
        MaterialCheckable materialCheckable = (MaterialCheckable) this.checkables.get(Integer.valueOf(i10));
        if (materialCheckable != null && checkInternal(materialCheckable)) {
            onCheckedStateChanged();
        }
    }

    public void clearCheck() {
        boolean z10 = !this.checkedIds.isEmpty();
        for (T uncheckInternal : this.checkables.values()) {
            uncheckInternal(uncheckInternal, false);
        }
        if (z10) {
            onCheckedStateChanged();
        }
    }

    @NonNull
    public Set<Integer> getCheckedIds() {
        return new HashSet(this.checkedIds);
    }

    @NonNull
    public List<Integer> getCheckedIdsSortedByChildOrder(@NonNull ViewGroup viewGroup) {
        Set<Integer> checkedIds2 = getCheckedIds();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof MaterialCheckable) && checkedIds2.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    @IdRes
    public int getSingleCheckedId() {
        if (!this.singleSelection || this.checkedIds.isEmpty()) {
            return -1;
        }
        return this.checkedIds.iterator().next().intValue();
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    public void removeCheckable(T t10) {
        t10.setInternalOnCheckedChangeListener((MaterialCheckable.OnCheckedChangeListener) null);
        this.checkables.remove(Integer.valueOf(t10.getId()));
        this.checkedIds.remove(Integer.valueOf(t10.getId()));
    }

    public void setOnCheckedStateChangeListener(@Nullable OnCheckedStateChangeListener onCheckedStateChangeListener2) {
        this.onCheckedStateChangeListener = onCheckedStateChangeListener2;
    }

    public void setSelectionRequired(boolean z10) {
        this.selectionRequired = z10;
    }

    public void setSingleSelection(boolean z10) {
        if (this.singleSelection != z10) {
            this.singleSelection = z10;
            clearCheck();
        }
    }

    public void uncheck(@IdRes int i10) {
        MaterialCheckable materialCheckable = (MaterialCheckable) this.checkables.get(Integer.valueOf(i10));
        if (materialCheckable != null && uncheckInternal(materialCheckable, this.selectionRequired)) {
            onCheckedStateChanged();
        }
    }
}
