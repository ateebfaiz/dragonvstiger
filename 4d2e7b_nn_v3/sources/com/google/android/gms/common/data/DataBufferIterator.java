package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@KeepForSdk
public class DataBufferIterator<T> implements Iterator<T> {
    @NonNull
    protected final DataBuffer<T> zaa;
    protected int zab = -1;

    public DataBufferIterator(@NonNull DataBuffer<T> dataBuffer) {
        this.zaa = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    public final boolean hasNext() {
        if (this.zab < this.zaa.getCount() - 1) {
            return true;
        }
        return false;
    }

    @NonNull
    public T next() {
        if (hasNext()) {
            DataBuffer<T> dataBuffer = this.zaa;
            int i10 = this.zab + 1;
            this.zab = i10;
            return dataBuffer.get(i10);
        }
        int i11 = this.zab;
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Cannot advance the iterator beyond ");
        sb2.append(i11);
        throw new NoSuchElementException(sb2.toString());
    }

    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
