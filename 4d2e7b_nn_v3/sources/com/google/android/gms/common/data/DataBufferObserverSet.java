package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {
    private HashSet<DataBufferObserver> zaa = new HashSet<>();

    public void addObserver(@NonNull DataBufferObserver dataBufferObserver) {
        this.zaa.add(dataBufferObserver);
    }

    public void clear() {
        this.zaa.clear();
    }

    public boolean hasObservers() {
        if (!this.zaa.isEmpty()) {
            return true;
        }
        return false;
    }

    public void onDataChanged() {
        Iterator<DataBufferObserver> it = this.zaa.iterator();
        while (it.hasNext()) {
            it.next().onDataChanged();
        }
    }

    public void onDataRangeChanged(int i10, int i11) {
        Iterator<DataBufferObserver> it = this.zaa.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeChanged(i10, i11);
        }
    }

    public void onDataRangeInserted(int i10, int i11) {
        Iterator<DataBufferObserver> it = this.zaa.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeInserted(i10, i11);
        }
    }

    public void onDataRangeMoved(int i10, int i11, int i12) {
        Iterator<DataBufferObserver> it = this.zaa.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeMoved(i10, i11, i12);
        }
    }

    public void onDataRangeRemoved(int i10, int i11) {
        Iterator<DataBufferObserver> it = this.zaa.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeRemoved(i10, i11);
        }
    }

    public void removeObserver(@NonNull DataBufferObserver dataBufferObserver) {
        this.zaa.remove(dataBufferObserver);
    }
}
