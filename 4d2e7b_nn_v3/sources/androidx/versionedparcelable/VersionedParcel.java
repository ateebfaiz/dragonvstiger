package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    class a extends ObjectInputStream {
        a(InputStream inputStream) {
            super(inputStream);
        }

        /* access modifiers changed from: protected */
        public Class resolveClass(ObjectStreamClass objectStreamClass) {
            Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
            if (cls != null) {
                return cls;
            }
            return super.resolveClass(objectStreamClass);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private Exception createException(int i10, String str) {
        switch (i10) {
            case EX_PARCELABLE /*-9*/:
                return (Exception) readParcelable();
            case -7:
                return new UnsupportedOperationException(str);
            case -6:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
            default:
                return new RuntimeException("Unknown exception code: " + i10 + " msg " + str);
        }
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.mParcelizerCache.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.mParcelizerCache.put(cls.getName(), cls3);
        return cls3;
    }

    private Method getReadMethod(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mReadCache.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Class<VersionedParcel> cls = VersionedParcel.class;
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        this.mReadCache.put(str, declaredMethod);
        return declaredMethod;
    }

    @NonNull
    protected static Throwable getRootCause(@NonNull Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private <T> int getType(T t10) {
        if (t10 instanceof String) {
            return 4;
        }
        if (t10 instanceof Parcelable) {
            return 2;
        }
        if (t10 instanceof VersionedParcelable) {
            return 1;
        }
        if (t10 instanceof Serializable) {
            return 3;
        }
        if (t10 instanceof IBinder) {
            return 5;
        }
        if (t10 instanceof Integer) {
            return 7;
        }
        if (t10 instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t10.getClass().getName() + " cannot be VersionedParcelled");
    }

    private Method getWriteMethod(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mWriteCache.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class findParcelClass = findParcelClass(cls);
        System.currentTimeMillis();
        Method declaredMethod = findParcelClass.getDeclaredMethod("write", new Class[]{cls, VersionedParcel.class});
        this.mWriteCache.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private <T, S extends Collection<T>> S readCollection(S s10) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    s10.add(readVersionedParcelable());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    s10.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    s10.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    s10.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    s10.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return s10;
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> collection, int i10) {
        setOutputField(i10);
        writeCollection(collection);
    }

    private void writeVersionedParcelableCreator(VersionedParcelable versionedParcelable) {
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e10);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void closeField();

    /* access modifiers changed from: protected */
    public abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public <T> T[] readArray(T[] tArr, int i10) {
        if (!readField(i10)) {
            return tArr;
        }
        return readArray(tArr);
    }

    /* access modifiers changed from: protected */
    public abstract boolean readBoolean();

    public boolean readBoolean(boolean z10, int i10) {
        if (!readField(i10)) {
            return z10;
        }
        return readBoolean();
    }

    public boolean[] readBooleanArray(boolean[] zArr, int i10) {
        if (!readField(i10)) {
            return zArr;
        }
        return readBooleanArray();
    }

    /* access modifiers changed from: protected */
    public abstract Bundle readBundle();

    public Bundle readBundle(Bundle bundle, int i10) {
        if (!readField(i10)) {
            return bundle;
        }
        return readBundle();
    }

    public byte readByte(byte b10, int i10) {
        if (!readField(i10)) {
            return b10;
        }
        return (byte) (readInt() & 255);
    }

    /* access modifiers changed from: protected */
    public abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i10) {
        if (!readField(i10)) {
            return bArr;
        }
        return readByteArray();
    }

    public char[] readCharArray(char[] cArr, int i10) {
        if (!readField(i10)) {
            return cArr;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        char[] cArr2 = new char[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            cArr2[i11] = (char) readInt();
        }
        return cArr2;
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence charSequence, int i10) {
        if (!readField(i10)) {
            return charSequence;
        }
        return readCharSequence();
    }

    /* access modifiers changed from: protected */
    public abstract double readDouble();

    public double readDouble(double d10, int i10) {
        if (!readField(i10)) {
            return d10;
        }
        return readDouble();
    }

    public double[] readDoubleArray(double[] dArr, int i10) {
        if (!readField(i10)) {
            return dArr;
        }
        return readDoubleArray();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r2 = readExceptionCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Exception readException(java.lang.Exception r1, int r2) {
        /*
            r0 = this;
            boolean r2 = r0.readField(r2)
            if (r2 != 0) goto L_0x0007
            return r1
        L_0x0007:
            int r2 = r0.readExceptionCode()
            if (r2 == 0) goto L_0x0015
            java.lang.String r1 = r0.readString()
            java.lang.Exception r1 = r0.readException((int) r2, (java.lang.String) r1)
        L_0x0015:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.versionedparcelable.VersionedParcel.readException(java.lang.Exception, int):java.lang.Exception");
    }

    /* access modifiers changed from: protected */
    public abstract boolean readField(int i10);

    /* access modifiers changed from: protected */
    public abstract float readFloat();

    public float readFloat(float f10, int i10) {
        if (!readField(i10)) {
            return f10;
        }
        return readFloat();
    }

    public float[] readFloatArray(float[] fArr, int i10) {
        if (!readField(i10)) {
            return fArr;
        }
        return readFloatArray();
    }

    /* access modifiers changed from: protected */
    public <T extends VersionedParcelable> T readFromParcel(String str, VersionedParcel versionedParcel) {
        try {
            return (VersionedParcelable) getReadMethod(str).invoke((Object) null, new Object[]{versionedParcel});
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e10);
        } catch (InvocationTargetException e11) {
            if (e11.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e11.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (ClassNotFoundException e13) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e13);
        }
    }

    /* access modifiers changed from: protected */
    public abstract int readInt();

    public int readInt(int i10, int i11) {
        if (!readField(i11)) {
            return i10;
        }
        return readInt();
    }

    public int[] readIntArray(int[] iArr, int i10) {
        if (!readField(i10)) {
            return iArr;
        }
        return readIntArray();
    }

    public <T> List<T> readList(List<T> list, int i10) {
        if (!readField(i10)) {
            return list;
        }
        return (List) readCollection(new ArrayList());
    }

    /* access modifiers changed from: protected */
    public abstract long readLong();

    public long readLong(long j10, int i10) {
        if (!readField(i10)) {
            return j10;
        }
        return readLong();
    }

    public long[] readLongArray(long[] jArr, int i10) {
        if (!readField(i10)) {
            return jArr;
        }
        return readLongArray();
    }

    public <K, V> Map<K, V> readMap(Map<K, V> map, int i10) {
        if (!readField(i10)) {
            return map;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (readInt == 0) {
            return arrayMap;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        readCollection(arrayList);
        readCollection(arrayList2);
        for (int i11 = 0; i11 < readInt; i11++) {
            arrayMap.put(arrayList.get(i11), arrayList2.get(i11));
        }
        return arrayMap;
    }

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t10, int i10) {
        if (!readField(i10)) {
            return t10;
        }
        return readParcelable();
    }

    /* access modifiers changed from: protected */
    public Serializable readSerializable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        try {
            return (Serializable) new a(new ByteArrayInputStream(readByteArray())).readObject();
        } catch (IOException e10) {
            throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + readString + ")", e10);
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + readString + ")", e11);
        }
    }

    public <T> Set<T> readSet(Set<T> set, int i10) {
        if (!readField(i10)) {
            return set;
        }
        return (Set) readCollection(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size size, int i10) {
        if (!readField(i10)) {
            return size;
        }
        if (readBoolean()) {
            return new Size(readInt(), readInt());
        }
        return null;
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF sizeF, int i10) {
        if (!readField(i10)) {
            return sizeF;
        }
        if (readBoolean()) {
            return new SizeF(readFloat(), readFloat());
        }
        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i10) {
        if (!readField(i10)) {
            return sparseBooleanArray;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(readInt);
        for (int i11 = 0; i11 < readInt; i11++) {
            sparseBooleanArray2.put(readInt(), readBoolean());
        }
        return sparseBooleanArray2;
    }

    /* access modifiers changed from: protected */
    public abstract String readString();

    public String readString(String str, int i10) {
        if (!readField(i10)) {
            return str;
        }
        return readString();
    }

    /* access modifiers changed from: protected */
    public abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder iBinder, int i10) {
        if (!readField(i10)) {
            return iBinder;
        }
        return readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t10, int i10) {
        if (!readField(i10)) {
            return t10;
        }
        return readVersionedParcelable();
    }

    /* access modifiers changed from: protected */
    public abstract void setOutputField(int i10);

    public void setSerializationFlags(boolean z10, boolean z11) {
    }

    public <T> void writeArray(T[] tArr, int i10) {
        setOutputField(i10);
        writeArray(tArr);
    }

    /* access modifiers changed from: protected */
    public abstract void writeBoolean(boolean z10);

    public void writeBoolean(boolean z10, int i10) {
        setOutputField(i10);
        writeBoolean(z10);
    }

    public void writeBooleanArray(boolean[] zArr, int i10) {
        setOutputField(i10);
        writeBooleanArray(zArr);
    }

    /* access modifiers changed from: protected */
    public abstract void writeBundle(Bundle bundle);

    public void writeBundle(Bundle bundle, int i10) {
        setOutputField(i10);
        writeBundle(bundle);
    }

    public void writeByte(byte b10, int i10) {
        setOutputField(i10);
        writeInt(b10);
    }

    /* access modifiers changed from: protected */
    public abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i10) {
        setOutputField(i10);
        writeByteArray(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract void writeByteArray(byte[] bArr, int i10, int i11);

    public void writeCharArray(char[] cArr, int i10) {
        setOutputField(i10);
        if (cArr != null) {
            writeInt(r4);
            for (char writeInt : cArr) {
                writeInt(writeInt);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public abstract void writeCharSequence(CharSequence charSequence);

    public void writeCharSequence(CharSequence charSequence, int i10) {
        setOutputField(i10);
        writeCharSequence(charSequence);
    }

    /* access modifiers changed from: protected */
    public abstract void writeDouble(double d10);

    public void writeDouble(double d10, int i10) {
        setOutputField(i10);
        writeDouble(d10);
    }

    public void writeDoubleArray(double[] dArr, int i10) {
        setOutputField(i10);
        writeDoubleArray(dArr);
    }

    public void writeException(Exception exc, int i10) {
        int i11;
        setOutputField(i10);
        if (exc == null) {
            writeNoException();
            return;
        }
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i11 = EX_PARCELABLE;
        } else if (exc instanceof SecurityException) {
            i11 = -1;
        } else if (exc instanceof BadParcelableException) {
            i11 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i11 = -3;
        } else if (exc instanceof NullPointerException) {
            i11 = -4;
        } else if (exc instanceof IllegalStateException) {
            i11 = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i11 = -6;
        } else if (exc instanceof UnsupportedOperationException) {
            i11 = -7;
        } else {
            i11 = 0;
        }
        writeInt(i11);
        if (i11 != 0) {
            writeString(exc.getMessage());
            if (i11 == EX_PARCELABLE) {
                writeParcelable((Parcelable) exc);
            }
        } else if (exc instanceof RuntimeException) {
            throw ((RuntimeException) exc);
        } else {
            throw new RuntimeException(exc);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void writeFloat(float f10);

    public void writeFloat(float f10, int i10) {
        setOutputField(i10);
        writeFloat(f10);
    }

    public void writeFloatArray(float[] fArr, int i10) {
        setOutputField(i10);
        writeFloatArray(fArr);
    }

    /* access modifiers changed from: protected */
    public abstract void writeInt(int i10);

    public void writeInt(int i10, int i11) {
        setOutputField(i11);
        writeInt(i10);
    }

    public void writeIntArray(int[] iArr, int i10) {
        setOutputField(i10);
        writeIntArray(iArr);
    }

    public <T> void writeList(List<T> list, int i10) {
        writeCollection(list, i10);
    }

    /* access modifiers changed from: protected */
    public abstract void writeLong(long j10);

    public void writeLong(long j10, int i10) {
        setOutputField(i10);
        writeLong(j10);
    }

    public void writeLongArray(long[] jArr, int i10) {
        setOutputField(i10);
        writeLongArray(jArr);
    }

    public <K, V> void writeMap(Map<K, V> map, int i10) {
        setOutputField(i10);
        if (map == null) {
            writeInt(-1);
            return;
        }
        int size = map.size();
        writeInt(size);
        if (size != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(next.getKey());
                arrayList2.add(next.getValue());
            }
            writeCollection(arrayList);
            writeCollection(arrayList2);
        }
    }

    /* access modifiers changed from: protected */
    public void writeNoException() {
        writeInt(0);
    }

    /* access modifiers changed from: protected */
    public abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable parcelable, int i10) {
        setOutputField(i10);
        writeParcelable(parcelable);
    }

    public void writeSerializable(Serializable serializable, int i10) {
        setOutputField(i10);
        writeSerializable(serializable);
    }

    public <T> void writeSet(Set<T> set, int i10) {
        writeCollection(set, i10);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size size, int i10) {
        boolean z10;
        setOutputField(i10);
        if (size != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        writeBoolean(z10);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF sizeF, int i10) {
        boolean z10;
        setOutputField(i10);
        if (sizeF != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        writeBoolean(z10);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i10) {
        setOutputField(i10);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            writeInt(sparseBooleanArray.keyAt(i11));
            writeBoolean(sparseBooleanArray.valueAt(i11));
        }
    }

    /* access modifiers changed from: protected */
    public abstract void writeString(String str);

    public void writeString(String str, int i10) {
        setOutputField(i10);
        writeString(str);
    }

    /* access modifiers changed from: protected */
    public abstract void writeStrongBinder(IBinder iBinder);

    public void writeStrongBinder(IBinder iBinder, int i10) {
        setOutputField(i10);
        writeStrongBinder(iBinder);
    }

    /* access modifiers changed from: protected */
    public abstract void writeStrongInterface(IInterface iInterface);

    public void writeStrongInterface(IInterface iInterface, int i10) {
        setOutputField(i10);
        writeStrongInterface(iInterface);
    }

    /* access modifiers changed from: protected */
    public <T extends VersionedParcelable> void writeToParcel(T t10, VersionedParcel versionedParcel) {
        try {
            getWriteMethod(t10.getClass()).invoke((Object) null, new Object[]{t10, versionedParcel});
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e10);
        } catch (InvocationTargetException e11) {
            if (e11.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e11.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (ClassNotFoundException e13) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e13);
        }
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int i10) {
        setOutputField(i10);
        writeVersionedParcelable(versionedParcelable);
    }

    private <T> void writeCollection(Collection<T> collection) {
        if (collection == null) {
            writeInt(-1);
            return;
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            int type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    for (T writeVersionedParcelable : collection) {
                        writeVersionedParcelable(writeVersionedParcelable);
                    }
                    return;
                case 2:
                    for (T writeParcelable : collection) {
                        writeParcelable(writeParcelable);
                    }
                    return;
                case 3:
                    for (T writeSerializable : collection) {
                        writeSerializable(writeSerializable);
                    }
                    return;
                case 4:
                    for (T writeString : collection) {
                        writeString(writeString);
                    }
                    return;
                case 5:
                    for (T writeStrongBinder : collection) {
                        writeStrongBinder(writeStrongBinder);
                    }
                    return;
                case 7:
                    for (T intValue : collection) {
                        writeInt(intValue.intValue());
                    }
                    return;
                case 8:
                    for (T floatValue : collection) {
                        writeFloat(floatValue.floatValue());
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void writeSerializable(Serializable serializable) {
        if (serializable == null) {
            writeString((String) null);
            return;
        }
        String name = serializable.getClass().getName();
        writeString(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e10) {
            throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + name + ")", e10);
        }
    }

    /* access modifiers changed from: protected */
    public <T> T[] readArray(T[] tArr) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    arrayList.add(readVersionedParcelable());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    arrayList.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    arrayList.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    arrayList.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    arrayList.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return arrayList.toArray(tArr);
    }

    /* access modifiers changed from: protected */
    public boolean[] readBooleanArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        for (int i10 = 0; i10 < readInt; i10++) {
            zArr[i10] = readInt() != 0;
        }
        return zArr;
    }

    /* access modifiers changed from: protected */
    public double[] readDoubleArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        double[] dArr = new double[readInt];
        for (int i10 = 0; i10 < readInt; i10++) {
            dArr[i10] = readDouble();
        }
        return dArr;
    }

    /* access modifiers changed from: protected */
    public float[] readFloatArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        float[] fArr = new float[readInt];
        for (int i10 = 0; i10 < readInt; i10++) {
            fArr[i10] = readFloat();
        }
        return fArr;
    }

    /* access modifiers changed from: protected */
    public int[] readIntArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        int[] iArr = new int[readInt];
        for (int i10 = 0; i10 < readInt; i10++) {
            iArr[i10] = readInt();
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public long[] readLongArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        long[] jArr = new long[readInt];
        for (int i10 = 0; i10 < readInt; i10++) {
            jArr[i10] = readLong();
        }
        return jArr;
    }

    /* access modifiers changed from: protected */
    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        return readFromParcel(readString, createSubParcel());
    }

    /* access modifiers changed from: protected */
    public <T> void writeArray(T[] tArr) {
        if (tArr == null) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i10 = 0;
            int type = getType(tArr[0]);
            writeInt(type);
            if (type == 1) {
                while (i10 < length) {
                    writeVersionedParcelable((VersionedParcelable) tArr[i10]);
                    i10++;
                }
            } else if (type == 2) {
                while (i10 < length) {
                    writeParcelable((Parcelable) tArr[i10]);
                    i10++;
                }
            } else if (type == 3) {
                while (i10 < length) {
                    writeSerializable((Serializable) tArr[i10]);
                    i10++;
                }
            } else if (type == 4) {
                while (i10 < length) {
                    writeString((String) tArr[i10]);
                    i10++;
                }
            } else if (type == 5) {
                while (i10 < length) {
                    writeStrongBinder((IBinder) tArr[i10]);
                    i10++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void writeBooleanArray(boolean[] zArr) {
        if (zArr != null) {
            writeInt(r0);
            for (boolean z10 : zArr) {
                writeInt(z10 ? 1 : 0);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeByteArray(byte[] bArr, int i10, int i11, int i12) {
        setOutputField(i12);
        writeByteArray(bArr, i10, i11);
    }

    /* access modifiers changed from: protected */
    public void writeDoubleArray(double[] dArr) {
        if (dArr != null) {
            writeInt(r0);
            for (double writeDouble : dArr) {
                writeDouble(writeDouble);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void writeFloatArray(float[] fArr) {
        if (fArr != null) {
            writeInt(r0);
            for (float writeFloat : fArr) {
                writeFloat(writeFloat);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void writeIntArray(int[] iArr) {
        if (iArr != null) {
            writeInt(r0);
            for (int writeInt : iArr) {
                writeInt(writeInt);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void writeLongArray(long[] jArr) {
        if (jArr != null) {
            writeInt(r0);
            for (long writeLong : jArr) {
                writeLong(writeLong);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString((String) null);
            return;
        }
        writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel createSubParcel = createSubParcel();
        writeToParcel(versionedParcelable, createSubParcel);
        createSubParcel.closeField();
    }

    private Exception readException(int i10, String str) {
        return createException(i10, str);
    }
}
