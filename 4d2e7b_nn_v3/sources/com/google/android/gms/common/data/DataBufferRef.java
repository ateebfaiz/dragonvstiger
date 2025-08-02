package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public abstract class DataBufferRef {
    @NonNull
    @KeepForSdk
    protected final DataHolder mDataHolder;
    @KeepForSdk
    protected int mDataRow;
    private int zaa;

    @KeepForSdk
    public DataBufferRef(@NonNull DataHolder dataHolder, int i10) {
        this.mDataHolder = (DataHolder) Preconditions.checkNotNull(dataHolder);
        zaa(i10);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void copyToBuffer(@NonNull String str, @NonNull CharArrayBuffer charArrayBuffer) {
        this.mDataHolder.zac(str, this.mDataRow, this.zaa, charArrayBuffer);
    }

    @KeepForSdk
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (!Objects.equal(Integer.valueOf(dataBufferRef.mDataRow), Integer.valueOf(this.mDataRow)) || !Objects.equal(Integer.valueOf(dataBufferRef.zaa), Integer.valueOf(this.zaa)) || dataBufferRef.mDataHolder != this.mDataHolder) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public boolean getBoolean(@NonNull String str) {
        return this.mDataHolder.getBoolean(str, this.mDataRow, this.zaa);
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public byte[] getByteArray(@NonNull String str) {
        return this.mDataHolder.getByteArray(str, this.mDataRow, this.zaa);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public int getDataRow() {
        return this.mDataRow;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public double getDouble(@NonNull String str) {
        return this.mDataHolder.zaa(str, this.mDataRow, this.zaa);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public float getFloat(@NonNull String str) {
        return this.mDataHolder.zab(str, this.mDataRow, this.zaa);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public int getInteger(@NonNull String str) {
        return this.mDataHolder.getInteger(str, this.mDataRow, this.zaa);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public long getLong(@NonNull String str) {
        return this.mDataHolder.getLong(str, this.mDataRow, this.zaa);
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public String getString(@NonNull String str) {
        return this.mDataHolder.getString(str, this.mDataRow, this.zaa);
    }

    @KeepForSdk
    public boolean hasColumn(@NonNull String str) {
        return this.mDataHolder.hasColumn(str);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public boolean hasNull(@NonNull String str) {
        return this.mDataHolder.hasNull(str, this.mDataRow, this.zaa);
    }

    @KeepForSdk
    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.zaa), this.mDataHolder);
    }

    @KeepForSdk
    public boolean isDataValid() {
        if (!this.mDataHolder.isClosed()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public Uri parseUri(@NonNull String str) {
        String string = this.mDataHolder.getString(str, this.mDataRow, this.zaa);
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    /* access modifiers changed from: protected */
    public final void zaa(int i10) {
        boolean z10 = false;
        if (i10 >= 0 && i10 < this.mDataHolder.getCount()) {
            z10 = true;
        }
        Preconditions.checkState(z10);
        this.mDataRow = i10;
        this.zaa = this.mDataHolder.getWindowIndex(i10);
    }
}
