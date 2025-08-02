package com.google.android.gms.common.data;

import androidx.annotation.NonNull;

public interface DataBufferObserver {

    public interface Observable {
        void addObserver(@NonNull DataBufferObserver dataBufferObserver);

        void removeObserver(@NonNull DataBufferObserver dataBufferObserver);
    }

    void onDataChanged();

    void onDataRangeChanged(int i10, int i11);

    void onDataRangeInserted(int i10, int i11);

    void onDataRangeMoved(int i10, int i11, int i12);

    void onDataRangeRemoved(int i10, int i11);
}
