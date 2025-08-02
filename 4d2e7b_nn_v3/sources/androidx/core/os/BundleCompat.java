package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;

public final class BundleCompat {

    static class a {
        @DoNotInline
        static <T> T a(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
            return bundle.getParcelable(str, cls);
        }

        @DoNotInline
        static <T> T[] b(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
            return bundle.getParcelableArray(str, cls);
        }

        @DoNotInline
        static <T> ArrayList<T> c(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends T> cls) {
            return bundle.getParcelableArrayList(str, cls);
        }

        @DoNotInline
        static <T extends Serializable> T d(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
            return bundle.getSerializable(str, cls);
        }

        @DoNotInline
        static <T> SparseArray<T> e(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends T> cls) {
            return bundle.getSparseParcelableArray(str, cls);
        }
    }

    private BundleCompat() {
    }

    @Deprecated
    @Nullable
    public static IBinder getBinder(@NonNull Bundle bundle, @Nullable String str) {
        return bundle.getBinder(str);
    }

    @Nullable
    public static <T> T getParcelable(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(bundle, str, cls);
        }
        T parcelable = bundle.getParcelable(str);
        if (cls.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @Nullable
    public static Parcelable[] getParcelableArray(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends Parcelable> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (Parcelable[]) a.b(bundle, str, cls);
        }
        return bundle.getParcelableArray(str);
    }

    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    @Nullable
    public static <T> ArrayList<T> getParcelableArrayList(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.c(bundle, str, cls);
        }
        return bundle.getParcelableArrayList(str);
    }

    @Nullable
    public static <T extends Serializable> T getSerializable(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.d(bundle, str, cls);
        }
        T serializable = bundle.getSerializable(str);
        if (cls.isInstance(serializable)) {
            return serializable;
        }
        return null;
    }

    @Nullable
    public static <T> SparseArray<T> getSparseParcelableArray(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.e(bundle, str, cls);
        }
        return bundle.getSparseParcelableArray(str);
    }

    @Deprecated
    public static void putBinder(@NonNull Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
