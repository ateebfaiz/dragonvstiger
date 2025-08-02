package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ParcelCompat {

    static class a {
        @DoNotInline
        static <T extends Parcelable> List<T> a(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader) {
            return parcel.readParcelableList(list, classLoader);
        }
    }

    static class b {
        @DoNotInline
        static Parcelable.Creator<?> a(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            return parcel.readParcelableCreator(classLoader);
        }
    }

    static class c {
        @DoNotInline
        static <T> T[] a(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return parcel.readArray(classLoader, cls);
        }

        @DoNotInline
        static <T> ArrayList<T> b(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            return parcel.readArrayList(classLoader, cls);
        }

        @DoNotInline
        static <V, K> HashMap<K, V> c(Parcel parcel, ClassLoader classLoader, Class<? extends K> cls, Class<? extends V> cls2) {
            return parcel.readHashMap(classLoader, cls, cls2);
        }

        @DoNotInline
        static <T> void d(@NonNull Parcel parcel, @NonNull List<? super T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            parcel.readList(list, classLoader, cls);
        }

        @DoNotInline
        static <K, V> void e(Parcel parcel, Map<? super K, ? super V> map, ClassLoader classLoader, Class<K> cls, Class<V> cls2) {
            parcel.readMap(map, classLoader, cls, cls2);
        }

        @DoNotInline
        static <T extends Parcelable> T f(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return (Parcelable) parcel.readParcelable(classLoader, cls);
        }

        @DoNotInline
        static <T> T[] g(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return parcel.readParcelableArray(classLoader, cls);
        }

        @DoNotInline
        static <T> Parcelable.Creator<T> h(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return parcel.readParcelableCreator(classLoader, cls);
        }

        @DoNotInline
        static <T> List<T> i(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return parcel.readParcelableList(list, classLoader, cls);
        }

        @DoNotInline
        static <T extends Serializable> T j(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
            return (Serializable) parcel.readSerializable(classLoader, cls);
        }

        @DoNotInline
        static <T> SparseArray<T> k(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            return parcel.readSparseArray(classLoader, cls);
        }
    }

    private ParcelCompat() {
    }

    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @Nullable
    public static <T> Object[] readArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.a(parcel, classLoader, cls);
        }
        return parcel.readArray(classLoader);
    }

    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    @Nullable
    public static <T> ArrayList<T> readArrayList(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.b(parcel, classLoader, cls);
        }
        return parcel.readArrayList(classLoader);
    }

    public static boolean readBoolean(@NonNull Parcel parcel) {
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    @Nullable
    public static <K, V> HashMap<K, V> readHashMap(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends K> cls, @NonNull Class<? extends V> cls2) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.c(parcel, classLoader, cls, cls2);
        }
        return parcel.readHashMap(classLoader);
    }

    public static <T> void readList(@NonNull Parcel parcel, @NonNull List<? super T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            c.d(parcel, list, classLoader, cls);
        } else {
            parcel.readList(list, classLoader);
        }
    }

    public static <K, V> void readMap(@NonNull Parcel parcel, @NonNull Map<? super K, ? super V> map, @Nullable ClassLoader classLoader, @NonNull Class<K> cls, @NonNull Class<V> cls2) {
        if (Build.VERSION.SDK_INT >= 34) {
            c.e(parcel, map, classLoader, cls, cls2);
        } else {
            parcel.readMap(map, classLoader);
        }
    }

    @Nullable
    public static <T extends Parcelable> T readParcelable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.f(parcel, classLoader, cls);
        }
        T readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null || cls.isInstance(readParcelable)) {
            return readParcelable;
        }
        throw new BadParcelableException("Parcelable " + readParcelable.getClass() + " is not a subclass of required class " + cls.getName() + " provided in the parameter");
    }

    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @Nullable
    @Deprecated
    public static <T> T[] readParcelableArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.g(parcel, classLoader, cls);
        }
        T[] readParcelableArray = parcel.readParcelableArray(classLoader);
        if (cls.isAssignableFrom(Parcelable.class)) {
            return readParcelableArray;
        }
        T[] tArr = (Object[]) Array.newInstance(cls, readParcelableArray.length);
        int i10 = 0;
        while (i10 < readParcelableArray.length) {
            try {
                tArr[i10] = cls.cast(readParcelableArray[i10]);
                i10++;
            } catch (ClassCastException unused) {
                throw new BadParcelableException("Parcelable at index " + i10 + " is not a subclass of required class " + cls.getName() + " provided in the parameter");
            }
        }
        return tArr;
    }

    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @Nullable
    public static <T> Parcelable[] readParcelableArrayTyped(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (Parcelable[]) c.g(parcel, classLoader, cls);
        }
        return parcel.readParcelableArray(classLoader);
    }

    @RequiresApi(30)
    @Nullable
    public static <T> Parcelable.Creator<T> readParcelableCreator(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.h(parcel, classLoader, cls);
        }
        return b.a(parcel, classLoader);
    }

    @RequiresApi(api = 29)
    @NonNull
    public static <T> List<T> readParcelableList(@NonNull Parcel parcel, @NonNull List<T> list, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.i(parcel, list, classLoader, cls);
        }
        return a.a(parcel, list, classLoader);
    }

    @Nullable
    public static <T extends Serializable> T readSerializable(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 33) {
            return c.j(parcel, classLoader, cls);
        }
        return parcel.readSerializable();
    }

    @Nullable
    public static <T> SparseArray<T> readSparseArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader, @NonNull Class<? extends T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.k(parcel, classLoader, cls);
        }
        return parcel.readSparseArray(classLoader);
    }

    public static void writeBoolean(@NonNull Parcel parcel, boolean z10) {
        parcel.writeInt(z10 ? 1 : 0);
    }
}
