package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Set;

class b extends VersionedParcel {

    /* renamed from: j  reason: collision with root package name */
    private static final Charset f16820j = Charset.forName("UTF-16");

    /* renamed from: a  reason: collision with root package name */
    private final DataInputStream f16821a;

    /* renamed from: b  reason: collision with root package name */
    private final DataOutputStream f16822b;

    /* renamed from: c  reason: collision with root package name */
    private DataInputStream f16823c;

    /* renamed from: d  reason: collision with root package name */
    private DataOutputStream f16824d;

    /* renamed from: e  reason: collision with root package name */
    private C0217b f16825e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16826f;

    /* renamed from: g  reason: collision with root package name */
    int f16827g;

    /* renamed from: h  reason: collision with root package name */
    private int f16828h;

    /* renamed from: i  reason: collision with root package name */
    int f16829i;

    /* renamed from: androidx.versionedparcelable.b$b  reason: collision with other inner class name */
    private static class C0217b {

        /* renamed from: a  reason: collision with root package name */
        final ByteArrayOutputStream f16831a;

        /* renamed from: b  reason: collision with root package name */
        final DataOutputStream f16832b;

        /* renamed from: c  reason: collision with root package name */
        private final int f16833c;

        /* renamed from: d  reason: collision with root package name */
        private final DataOutputStream f16834d;

        C0217b(int i10, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f16831a = byteArrayOutputStream;
            this.f16832b = new DataOutputStream(byteArrayOutputStream);
            this.f16833c = i10;
            this.f16834d = dataOutputStream;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i10;
            this.f16832b.flush();
            int size = this.f16831a.size();
            int i11 = this.f16833c << 16;
            if (size >= 65535) {
                i10 = 65535;
            } else {
                i10 = size;
            }
            this.f16834d.writeInt(i11 | i10);
            if (size >= 65535) {
                this.f16834d.writeInt(size);
            }
            this.f16831a.writeTo(this.f16834d);
        }
    }

    public b(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private void a(int i10, String str, Bundle bundle) {
        switch (i10) {
            case 0:
                bundle.putParcelable(str, (Parcelable) null);
                return;
            case 1:
                bundle.putBundle(str, readBundle());
                return;
            case 2:
                bundle.putBundle(str, readBundle());
                return;
            case 3:
                bundle.putString(str, readString());
                return;
            case 4:
                bundle.putStringArray(str, (String[]) readArray(new String[0]));
                return;
            case 5:
                bundle.putBoolean(str, readBoolean());
                return;
            case 6:
                bundle.putBooleanArray(str, readBooleanArray());
                return;
            case 7:
                bundle.putDouble(str, readDouble());
                return;
            case 8:
                bundle.putDoubleArray(str, readDoubleArray());
                return;
            case 9:
                bundle.putInt(str, readInt());
                return;
            case 10:
                bundle.putIntArray(str, readIntArray());
                return;
            case 11:
                bundle.putLong(str, readLong());
                return;
            case 12:
                bundle.putLongArray(str, readLongArray());
                return;
            case 13:
                bundle.putFloat(str, readFloat());
                return;
            case 14:
                bundle.putFloatArray(str, readFloatArray());
                return;
            default:
                throw new RuntimeException("Unknown type " + i10);
        }
    }

    private void b(Object obj) {
        if (obj == null) {
            writeInt(0);
        } else if (obj instanceof Bundle) {
            writeInt(1);
            writeBundle((Bundle) obj);
        } else if (obj instanceof String) {
            writeInt(3);
            writeString((String) obj);
        } else if (obj instanceof String[]) {
            writeInt(4);
            writeArray((String[]) obj);
        } else if (obj instanceof Boolean) {
            writeInt(5);
            writeBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            writeInt(6);
            writeBooleanArray((boolean[]) obj);
        } else if (obj instanceof Double) {
            writeInt(7);
            writeDouble(((Double) obj).doubleValue());
        } else if (obj instanceof double[]) {
            writeInt(8);
            writeDoubleArray((double[]) obj);
        } else if (obj instanceof Integer) {
            writeInt(9);
            writeInt(((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            writeInt(10);
            writeIntArray((int[]) obj);
        } else if (obj instanceof Long) {
            writeInt(11);
            writeLong(((Long) obj).longValue());
        } else if (obj instanceof long[]) {
            writeInt(12);
            writeLongArray((long[]) obj);
        } else if (obj instanceof Float) {
            writeInt(13);
            writeFloat(((Float) obj).floatValue());
        } else if (obj instanceof float[]) {
            writeInt(14);
            writeFloatArray((float[]) obj);
        } else {
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    public void closeField() {
        C0217b bVar = this.f16825e;
        if (bVar != null) {
            try {
                if (bVar.f16831a.size() != 0) {
                    this.f16825e.a();
                }
                this.f16825e = null;
            } catch (IOException e10) {
                throw new VersionedParcel.ParcelException(e10);
            }
        }
    }

    /* access modifiers changed from: protected */
    public VersionedParcel createSubParcel() {
        return new b(this.f16823c, this.f16824d, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    public boolean isStream() {
        return true;
    }

    public boolean readBoolean() {
        try {
            return this.f16823c.readBoolean();
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    public Bundle readBundle() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i10 = 0; i10 < readInt; i10++) {
            a(readInt(), readString(), bundle);
        }
        return bundle;
    }

    public byte[] readByteArray() {
        try {
            int readInt = this.f16823c.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.f16823c.readFully(bArr);
            return bArr;
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    /* access modifiers changed from: protected */
    public CharSequence readCharSequence() {
        return null;
    }

    public double readDouble() {
        try {
            return this.f16823c.readDouble();
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    public boolean readField(int i10) {
        while (true) {
            try {
                int i11 = this.f16828h;
                if (i11 == i10) {
                    return true;
                }
                if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                    return false;
                }
                int i12 = this.f16827g;
                int i13 = this.f16829i;
                if (i12 < i13) {
                    this.f16821a.skip((long) (i13 - i12));
                }
                this.f16829i = -1;
                int readInt = this.f16821a.readInt();
                this.f16827g = 0;
                int i14 = readInt & 65535;
                if (i14 == 65535) {
                    i14 = this.f16821a.readInt();
                }
                this.f16828h = (readInt >> 16) & 65535;
                this.f16829i = i14;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public float readFloat() {
        try {
            return this.f16823c.readFloat();
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    public int readInt() {
        try {
            return this.f16823c.readInt();
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    public long readLong() {
        try {
            return this.f16823c.readLong();
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    public Parcelable readParcelable() {
        return null;
    }

    public String readString() {
        try {
            int readInt = this.f16823c.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.f16823c.readFully(bArr);
            return new String(bArr, f16820j);
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    public IBinder readStrongBinder() {
        return null;
    }

    public void setOutputField(int i10) {
        closeField();
        C0217b bVar = new C0217b(i10, this.f16822b);
        this.f16825e = bVar;
        this.f16824d = bVar.f16832b;
    }

    public void setSerializationFlags(boolean z10, boolean z11) {
        if (z10) {
            this.f16826f = z11;
            return;
        }
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    public void writeBoolean(boolean z10) {
        try {
            this.f16824d.writeBoolean(z10);
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    public void writeBundle(Bundle bundle) {
        if (bundle != null) {
            try {
                Set<String> keySet = bundle.keySet();
                this.f16824d.writeInt(keySet.size());
                for (String next : keySet) {
                    writeString(next);
                    b(bundle.get(next));
                }
            } catch (IOException e10) {
                throw new VersionedParcel.ParcelException(e10);
            }
        } else {
            this.f16824d.writeInt(-1);
        }
    }

    public void writeByteArray(byte[] bArr) {
        if (bArr != null) {
            try {
                this.f16824d.writeInt(bArr.length);
                this.f16824d.write(bArr);
            } catch (IOException e10) {
                throw new VersionedParcel.ParcelException(e10);
            }
        } else {
            this.f16824d.writeInt(-1);
        }
    }

    /* access modifiers changed from: protected */
    public void writeCharSequence(CharSequence charSequence) {
        if (!this.f16826f) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    public void writeDouble(double d10) {
        try {
            this.f16824d.writeDouble(d10);
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    public void writeFloat(float f10) {
        try {
            this.f16824d.writeFloat(f10);
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    public void writeInt(int i10) {
        try {
            this.f16824d.writeInt(i10);
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    public void writeLong(long j10) {
        try {
            this.f16824d.writeLong(j10);
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    public void writeParcelable(Parcelable parcelable) {
        if (!this.f16826f) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    public void writeString(String str) {
        if (str != null) {
            try {
                byte[] bytes = str.getBytes(f16820j);
                this.f16824d.writeInt(bytes.length);
                this.f16824d.write(bytes);
            } catch (IOException e10) {
                throw new VersionedParcel.ParcelException(e10);
            }
        } else {
            this.f16824d.writeInt(-1);
        }
    }

    public void writeStrongBinder(IBinder iBinder) {
        if (!this.f16826f) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    public void writeStrongInterface(IInterface iInterface) {
        if (!this.f16826f) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    private b(InputStream inputStream, OutputStream outputStream, ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f16827g = 0;
        this.f16828h = -1;
        this.f16829i = -1;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new a(inputStream)) : null;
        this.f16821a = dataInputStream;
        dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : dataOutputStream;
        this.f16822b = dataOutputStream;
        this.f16823c = dataInputStream;
        this.f16824d = dataOutputStream;
    }

    class a extends FilterInputStream {
        a(InputStream inputStream) {
            super(inputStream);
        }

        public int read() {
            b bVar = b.this;
            int i10 = bVar.f16829i;
            if (i10 == -1 || bVar.f16827g < i10) {
                int read = super.read();
                b.this.f16827g++;
                return read;
            }
            throw new IOException();
        }

        public long skip(long j10) {
            b bVar = b.this;
            int i10 = bVar.f16829i;
            if (i10 == -1 || bVar.f16827g < i10) {
                long skip = super.skip(j10);
                if (skip > 0) {
                    b.this.f16827g += (int) skip;
                }
                return skip;
            }
            throw new IOException();
        }

        public int read(byte[] bArr, int i10, int i11) {
            b bVar = b.this;
            int i12 = bVar.f16829i;
            if (i12 == -1 || bVar.f16827g < i12) {
                int read = super.read(bArr, i10, i11);
                if (read > 0) {
                    b.this.f16827g += read;
                }
                return read;
            }
            throw new IOException();
        }
    }

    public void writeByteArray(byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            try {
                this.f16824d.writeInt(i11);
                this.f16824d.write(bArr, i10, i11);
            } catch (IOException e10) {
                throw new VersionedParcel.ParcelException(e10);
            }
        } else {
            this.f16824d.writeInt(-1);
        }
    }
}
