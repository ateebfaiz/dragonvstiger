package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

@KeepForSdk
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    private boolean zaa = false;
    private ArrayList<Integer> zab;

    @KeepForSdk
    protected EntityBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    private final void zab() {
        synchronized (this) {
            try {
                if (!this.zaa) {
                    int count = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    this.zab = arrayList;
                    if (count > 0) {
                        arrayList.add(0);
                        String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                        String string = this.mDataHolder.getString(primaryDataMarkerColumn, 0, this.mDataHolder.getWindowIndex(0));
                        int i10 = 1;
                        while (i10 < count) {
                            int windowIndex = this.mDataHolder.getWindowIndex(i10);
                            String string2 = this.mDataHolder.getString(primaryDataMarkerColumn, i10, windowIndex);
                            if (string2 != null) {
                                if (!string2.equals(string)) {
                                    this.zab.add(Integer.valueOf(i10));
                                    string = string2;
                                }
                                i10++;
                            } else {
                                StringBuilder sb2 = new StringBuilder(String.valueOf(primaryDataMarkerColumn).length() + 78);
                                sb2.append("Missing value for markerColumn: ");
                                sb2.append(primaryDataMarkerColumn);
                                sb2.append(", at row: ");
                                sb2.append(i10);
                                sb2.append(", for window: ");
                                sb2.append(windowIndex);
                                throw new NullPointerException(sb2.toString());
                            }
                        }
                    }
                    this.zaa = true;
                }
            } finally {
            }
        }
    }

    @NonNull
    @KeepForSdk
    public final T get(int i10) {
        int intValue;
        int intValue2;
        zab();
        int zaa2 = zaa(i10);
        int i11 = 0;
        if (i10 >= 0 && i10 != this.zab.size()) {
            if (i10 == this.zab.size() - 1) {
                intValue = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                intValue2 = this.zab.get(i10).intValue();
            } else {
                intValue = this.zab.get(i10 + 1).intValue();
                intValue2 = this.zab.get(i10).intValue();
            }
            int i12 = intValue - intValue2;
            if (i12 == 1) {
                int zaa3 = zaa(i10);
                int windowIndex = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getWindowIndex(zaa3);
                String childDataMarkerColumn = getChildDataMarkerColumn();
                if (childDataMarkerColumn == null || this.mDataHolder.getString(childDataMarkerColumn, zaa3, windowIndex) != null) {
                    i11 = 1;
                }
            } else {
                i11 = i12;
            }
        }
        return getEntry(zaa2, i11);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public String getChildDataMarkerColumn() {
        return null;
    }

    @KeepForSdk
    public int getCount() {
        zab();
        return this.zab.size();
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public abstract T getEntry(int i10, int i11);

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public abstract String getPrimaryDataMarkerColumn();

    /* access modifiers changed from: package-private */
    public final int zaa(int i10) {
        if (i10 >= 0 && i10 < this.zab.size()) {
            return this.zab.get(i10).intValue();
        }
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("Position ");
        sb2.append(i10);
        sb2.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb2.toString());
    }
}
