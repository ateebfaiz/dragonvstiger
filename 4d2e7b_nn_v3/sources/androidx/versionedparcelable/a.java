package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;

class a extends VersionedParcel {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f16812a;

    /* renamed from: b  reason: collision with root package name */
    private final Parcel f16813b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16814c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16815d;

    /* renamed from: e  reason: collision with root package name */
    private final String f16816e;

    /* renamed from: f  reason: collision with root package name */
    private int f16817f;

    /* renamed from: g  reason: collision with root package name */
    private int f16818g;

    /* renamed from: h  reason: collision with root package name */
    private int f16819h;

    a(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    public void closeField() {
        int i10 = this.f16817f;
        if (i10 >= 0) {
            int i11 = this.f16812a.get(i10);
            int dataPosition = this.f16813b.dataPosition();
            this.f16813b.setDataPosition(i11);
            this.f16813b.writeInt(dataPosition - i11);
            this.f16813b.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    public VersionedParcel createSubParcel() {
        Parcel parcel = this.f16813b;
        int dataPosition = parcel.dataPosition();
        int i10 = this.f16818g;
        if (i10 == this.f16814c) {
            i10 = this.f16815d;
        }
        int i11 = i10;
        return new a(parcel, dataPosition, i11, this.f16816e + "  ", this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    public boolean readBoolean() {
        if (this.f16813b.readInt() != 0) {
            return true;
        }
        return false;
    }

    public Bundle readBundle() {
        return this.f16813b.readBundle(getClass().getClassLoader());
    }

    public byte[] readByteArray() {
        int readInt = this.f16813b.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f16813b.readByteArray(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public CharSequence readCharSequence() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f16813b);
    }

    public double readDouble() {
        return this.f16813b.readDouble();
    }

    public boolean readField(int i10) {
        while (this.f16818g < this.f16815d) {
            int i11 = this.f16819h;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f16813b.setDataPosition(this.f16818g);
            int readInt = this.f16813b.readInt();
            this.f16819h = this.f16813b.readInt();
            this.f16818g += readInt;
        }
        if (this.f16819h == i10) {
            return true;
        }
        return false;
    }

    public float readFloat() {
        return this.f16813b.readFloat();
    }

    public int readInt() {
        return this.f16813b.readInt();
    }

    public long readLong() {
        return this.f16813b.readLong();
    }

    public Parcelable readParcelable() {
        return this.f16813b.readParcelable(getClass().getClassLoader());
    }

    public String readString() {
        return this.f16813b.readString();
    }

    public IBinder readStrongBinder() {
        return this.f16813b.readStrongBinder();
    }

    public void setOutputField(int i10) {
        closeField();
        this.f16817f = i10;
        this.f16812a.put(i10, this.f16813b.dataPosition());
        writeInt(0);
        writeInt(i10);
    }

    public void writeBoolean(boolean z10) {
        this.f16813b.writeInt(z10 ? 1 : 0);
    }

    public void writeBundle(Bundle bundle) {
        this.f16813b.writeBundle(bundle);
    }

    public void writeByteArray(byte[] bArr) {
        if (bArr != null) {
            this.f16813b.writeInt(bArr.length);
            this.f16813b.writeByteArray(bArr);
            return;
        }
        this.f16813b.writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void writeCharSequence(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f16813b, 0);
    }

    public void writeDouble(double d10) {
        this.f16813b.writeDouble(d10);
    }

    public void writeFloat(float f10) {
        this.f16813b.writeFloat(f10);
    }

    public void writeInt(int i10) {
        this.f16813b.writeInt(i10);
    }

    public void writeLong(long j10) {
        this.f16813b.writeLong(j10);
    }

    public void writeParcelable(Parcelable parcelable) {
        this.f16813b.writeParcelable(parcelable, 0);
    }

    public void writeString(String str) {
        this.f16813b.writeString(str);
    }

    public void writeStrongBinder(IBinder iBinder) {
        this.f16813b.writeStrongBinder(iBinder);
    }

    public void writeStrongInterface(IInterface iInterface) {
        this.f16813b.writeStrongInterface(iInterface);
    }

    private a(Parcel parcel, int i10, int i11, String str, ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f16812a = new SparseIntArray();
        this.f16817f = -1;
        this.f16819h = -1;
        this.f16813b = parcel;
        this.f16814c = i10;
        this.f16815d = i11;
        this.f16818g = i10;
        this.f16816e = str;
    }

    public void writeByteArray(byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            this.f16813b.writeInt(bArr.length);
            this.f16813b.writeByteArray(bArr, i10, i11);
            return;
        }
        this.f16813b.writeInt(-1);
    }
}
