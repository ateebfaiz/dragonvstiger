package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@KeepName
@KeepForSdk
@SafeParcelable.Class(creator = "DataHolderCreator", validate = true)
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<DataHolder> CREATOR = new zaf();
    private static final Builder zaf = new a(new String[0], (String) null);
    @SafeParcelable.VersionField(id = 1000)
    final int zaa;
    Bundle zab;
    int[] zac;
    int zad;
    boolean zae;
    @SafeParcelable.Field(getter = "getColumns", id = 1)
    private final String[] zag;
    @SafeParcelable.Field(getter = "getWindows", id = 2)
    private final CursorWindow[] zah;
    @SafeParcelable.Field(getter = "getStatusCode", id = 3)
    private final int zai;
    @SafeParcelable.Field(getter = "getMetadata", id = 4)
    @Nullable
    private final Bundle zaj;
    private boolean zak;

    @KeepForSdk
    public static class Builder {
        /* access modifiers changed from: private */
        public final String[] zaa;
        /* access modifiers changed from: private */
        public final ArrayList<HashMap<String, Object>> zab = new ArrayList<>();
        private final HashMap<Object, Integer> zac = new HashMap<>();

        /* synthetic */ Builder(String[] strArr, String str, zac zac2) {
            this.zaa = (String[]) Preconditions.checkNotNull(strArr);
        }

        @NonNull
        @KeepForSdk
        public DataHolder build(int i10) {
            return new DataHolder(this, i10);
        }

        @NonNull
        @KeepForSdk
        public Builder withRow(@NonNull ContentValues contentValues) {
            Asserts.checkNotNull(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry next : contentValues.valueSet()) {
                hashMap.put((String) next.getKey(), next.getValue());
            }
            return zaa(hashMap);
        }

        @NonNull
        public Builder zaa(@NonNull HashMap<String, Object> hashMap) {
            Asserts.checkNotNull(hashMap);
            this.zab.add(hashMap);
            return this;
        }

        @NonNull
        @KeepForSdk
        public DataHolder build(int i10, @NonNull Bundle bundle) {
            return new DataHolder(this, i10, bundle);
        }
    }

    @NonNull
    @KeepForSdk
    public static Builder builder(@NonNull String[] strArr) {
        return new Builder(strArr, (String) null, (zac) null);
    }

    @NonNull
    @KeepForSdk
    public static DataHolder empty(int i10) {
        return new DataHolder(zaf, i10, (Bundle) null);
    }

    private final void zae(String str, int i10) {
        String str2;
        Bundle bundle = this.zab;
        if (bundle == null || !bundle.containsKey(str)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "No such column: ".concat(valueOf);
            } else {
                str2 = new String("No such column: ");
            }
            throw new IllegalArgumentException(str2);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i10 < 0 || i10 >= this.zad) {
            throw new CursorIndexOutOfBoundsException(i10, this.zad);
        }
    }

    private static CursorWindow[] zaf(Builder builder, int i10) {
        long j10;
        if (builder.zaa.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList zab2 = builder.zab;
        int size = zab2.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(builder.zaa.length);
        int i11 = 0;
        boolean z10 = false;
        while (i11 < size) {
            try {
                if (!cursorWindow.allocRow()) {
                    StringBuilder sb2 = new StringBuilder(72);
                    sb2.append("Allocating additional cursor window for large data set (row ");
                    sb2.append(i11);
                    sb2.append(")");
                    Log.d("DataHolder", sb2.toString());
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i11);
                    cursorWindow.setNumColumns(builder.zaa.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) zab2.get(i11);
                int i12 = 0;
                boolean z11 = true;
                while (true) {
                    if (i12 < builder.zaa.length) {
                        if (!z11) {
                            break;
                        }
                        String str = builder.zaa[i12];
                        Object obj = map.get(str);
                        if (obj == null) {
                            z11 = cursorWindow.putNull(i11, i12);
                        } else if (obj instanceof String) {
                            z11 = cursorWindow.putString((String) obj, i11, i12);
                        } else if (obj instanceof Long) {
                            z11 = cursorWindow.putLong(((Long) obj).longValue(), i11, i12);
                        } else if (obj instanceof Integer) {
                            z11 = cursorWindow.putLong((long) ((Integer) obj).intValue(), i11, i12);
                        } else if (obj instanceof Boolean) {
                            if (true != ((Boolean) obj).booleanValue()) {
                                j10 = 0;
                            } else {
                                j10 = 1;
                            }
                            z11 = cursorWindow.putLong(j10, i11, i12);
                        } else if (obj instanceof byte[]) {
                            z11 = cursorWindow.putBlob((byte[]) obj, i11, i12);
                        } else if (obj instanceof Double) {
                            z11 = cursorWindow.putDouble(((Double) obj).doubleValue(), i11, i12);
                        } else if (obj instanceof Float) {
                            z11 = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i11, i12);
                        } else {
                            String obj2 = obj.toString();
                            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 32 + obj2.length());
                            sb3.append("Unsupported object for column ");
                            sb3.append(str);
                            sb3.append(": ");
                            sb3.append(obj2);
                            throw new IllegalArgumentException(sb3.toString());
                        }
                        i12++;
                    } else if (z11) {
                        z10 = false;
                    }
                }
                if (!z10) {
                    StringBuilder sb4 = new StringBuilder(74);
                    sb4.append("Couldn't populate window data for row ");
                    sb4.append(i11);
                    sb4.append(" - allocating new window.");
                    Log.d("DataHolder", sb4.toString());
                    cursorWindow.freeLastRow();
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i11);
                    cursorWindow.setNumColumns(builder.zaa.length);
                    arrayList.add(cursorWindow);
                    i11--;
                    z10 = true;
                    i11++;
                } else {
                    throw new zad("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                }
            } catch (RuntimeException e10) {
                int size2 = arrayList.size();
                for (int i13 = 0; i13 < size2; i13++) {
                    ((CursorWindow) arrayList.get(i13)).close();
                }
                throw e10;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    @KeepForSdk
    public void close() {
        synchronized (this) {
            try {
                if (!this.zae) {
                    this.zae = true;
                    int i10 = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.zah;
                        if (i10 >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i10].close();
                        i10++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            if (this.zak && this.zah.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 178);
                sb2.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb2.append(obj);
                sb2.append(")");
                Log.e("DataBuffer", sb2.toString());
            }
        } finally {
            super.finalize();
        }
    }

    @KeepForSdk
    public boolean getBoolean(@NonNull String str, int i10, int i11) {
        zae(str, i10);
        if (this.zah[i11].getLong(i10, this.zab.getInt(str)) == 1) {
            return true;
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public byte[] getByteArray(@NonNull String str, int i10, int i11) {
        zae(str, i10);
        return this.zah[i11].getBlob(i10, this.zab.getInt(str));
    }

    @KeepForSdk
    public int getCount() {
        return this.zad;
    }

    @KeepForSdk
    public int getInteger(@NonNull String str, int i10, int i11) {
        zae(str, i10);
        return this.zah[i11].getInt(i10, this.zab.getInt(str));
    }

    @KeepForSdk
    public long getLong(@NonNull String str, int i10, int i11) {
        zae(str, i10);
        return this.zah[i11].getLong(i10, this.zab.getInt(str));
    }

    @KeepForSdk
    @Nullable
    public Bundle getMetadata() {
        return this.zaj;
    }

    @KeepForSdk
    public int getStatusCode() {
        return this.zai;
    }

    @NonNull
    @KeepForSdk
    public String getString(@NonNull String str, int i10, int i11) {
        zae(str, i10);
        return this.zah[i11].getString(i10, this.zab.getInt(str));
    }

    @KeepForSdk
    public int getWindowIndex(int i10) {
        boolean z10;
        int length;
        int i11 = 0;
        if (i10 < 0 || i10 >= this.zad) {
            z10 = false;
        } else {
            z10 = true;
        }
        Preconditions.checkState(z10);
        while (true) {
            int[] iArr = this.zac;
            length = iArr.length;
            if (i11 >= length) {
                break;
            } else if (i10 < iArr[i11]) {
                i11--;
                break;
            } else {
                i11++;
            }
        }
        if (i11 == length) {
            return i11 - 1;
        }
        return i11;
    }

    @KeepForSdk
    public boolean hasColumn(@NonNull String str) {
        return this.zab.containsKey(str);
    }

    @KeepForSdk
    public boolean hasNull(@NonNull String str, int i10, int i11) {
        zae(str, i10);
        return this.zah[i11].isNull(i10, this.zab.getInt(str));
    }

    @KeepForSdk
    public boolean isClosed() {
        boolean z10;
        synchronized (this) {
            z10 = this.zae;
        }
        return z10;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.zag, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zah, i10, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zaa);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i10 & 1) != 0) {
            close();
        }
    }

    public final double zaa(@NonNull String str, int i10, int i11) {
        zae(str, i10);
        return this.zah[i11].getDouble(i10, this.zab.getInt(str));
    }

    public final float zab(@NonNull String str, int i10, int i11) {
        zae(str, i10);
        return this.zah[i11].getFloat(i10, this.zab.getInt(str));
    }

    public final void zac(@NonNull String str, int i10, int i11, @NonNull CharArrayBuffer charArrayBuffer) {
        zae(str, i10);
        this.zah[i11].copyStringToBuffer(i10, this.zab.getInt(str), charArrayBuffer);
    }

    public final void zad() {
        this.zab = new Bundle();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr = this.zag;
            if (i11 >= strArr.length) {
                break;
            }
            this.zab.putInt(strArr[i11], i11);
            i11++;
        }
        this.zac = new int[this.zah.length];
        int i12 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zah;
            if (i10 < cursorWindowArr.length) {
                this.zac[i10] = i12;
                i12 += this.zah[i10].getNumRows() - (i12 - cursorWindowArr[i10].getStartPosition());
                i10++;
            } else {
                this.zad = i12;
                return;
            }
        }
    }

    @SafeParcelable.Constructor
    DataHolder(@SafeParcelable.Param(id = 1000) int i10, @SafeParcelable.Param(id = 1) String[] strArr, @SafeParcelable.Param(id = 2) CursorWindow[] cursorWindowArr, @SafeParcelable.Param(id = 3) int i11, @SafeParcelable.Param(id = 4) @Nullable Bundle bundle) {
        this.zae = false;
        this.zak = true;
        this.zaa = i10;
        this.zag = strArr;
        this.zah = cursorWindowArr;
        this.zai = i11;
        this.zaj = bundle;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DataHolder(@androidx.annotation.NonNull android.database.Cursor r8, int r9, @androidx.annotation.Nullable android.os.Bundle r10) {
        /*
            r7 = this;
            com.google.android.gms.common.sqlite.CursorWrapper r0 = new com.google.android.gms.common.sqlite.CursorWrapper
            r0.<init>(r8)
            java.lang.String[] r8 = r0.getColumnNames()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.getCount()     // Catch:{ all -> 0x002e }
            android.database.CursorWindow r3 = r0.getWindow()     // Catch:{ all -> 0x002e }
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x0030
            int r6 = r3.getStartPosition()     // Catch:{ all -> 0x002e }
            if (r6 != 0) goto L_0x0030
            r3.acquireReference()     // Catch:{ all -> 0x002e }
            r0.setWindow(r4)     // Catch:{ all -> 0x002e }
            r1.add(r3)     // Catch:{ all -> 0x002e }
            int r3 = r3.getNumRows()     // Catch:{ all -> 0x002e }
            goto L_0x0031
        L_0x002e:
            r8 = move-exception
            goto L_0x0078
        L_0x0030:
            r3 = r5
        L_0x0031:
            if (r3 >= r2) goto L_0x0065
            boolean r6 = r0.moveToPosition(r3)     // Catch:{ all -> 0x002e }
            if (r6 == 0) goto L_0x0065
            android.database.CursorWindow r6 = r0.getWindow()     // Catch:{ all -> 0x002e }
            if (r6 == 0) goto L_0x0046
            r6.acquireReference()     // Catch:{ all -> 0x002e }
            r0.setWindow(r4)     // Catch:{ all -> 0x002e }
            goto L_0x0051
        L_0x0046:
            android.database.CursorWindow r6 = new android.database.CursorWindow     // Catch:{ all -> 0x002e }
            r6.<init>(r5)     // Catch:{ all -> 0x002e }
            r6.setStartPosition(r3)     // Catch:{ all -> 0x002e }
            r0.fillWindow(r3, r6)     // Catch:{ all -> 0x002e }
        L_0x0051:
            int r3 = r6.getNumRows()     // Catch:{ all -> 0x002e }
            if (r3 != 0) goto L_0x0058
            goto L_0x0065
        L_0x0058:
            r1.add(r6)     // Catch:{ all -> 0x002e }
            int r3 = r6.getStartPosition()     // Catch:{ all -> 0x002e }
            int r6 = r6.getNumRows()     // Catch:{ all -> 0x002e }
            int r3 = r3 + r6
            goto L_0x0031
        L_0x0065:
            r0.close()
            int r0 = r1.size()
            android.database.CursorWindow[] r0 = new android.database.CursorWindow[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            android.database.CursorWindow[] r0 = (android.database.CursorWindow[]) r0
            r7.<init>((java.lang.String[]) r8, (android.database.CursorWindow[]) r0, (int) r9, (android.os.Bundle) r10)
            return
        L_0x0078:
            r0.close()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.<init>(android.database.Cursor, int, android.os.Bundle):void");
    }

    private DataHolder(Builder builder, int i10, @Nullable Bundle bundle) {
        this(builder.zaa, zaf(builder, -1), i10, (Bundle) null);
    }

    @KeepForSdk
    public DataHolder(@NonNull String[] strArr, @NonNull CursorWindow[] cursorWindowArr, int i10, @Nullable Bundle bundle) {
        this.zae = false;
        this.zak = true;
        this.zaa = 1;
        this.zag = (String[]) Preconditions.checkNotNull(strArr);
        this.zah = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.zai = i10;
        this.zaj = bundle;
        zad();
    }
}
