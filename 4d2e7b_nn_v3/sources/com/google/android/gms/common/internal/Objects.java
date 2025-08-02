package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@KeepForSdk
public final class Objects {

    @KeepForSdk
    public static final class ToStringHelper {
        private final List zza = new ArrayList();
        private final Object zzb;

        /* synthetic */ ToStringHelper(Object obj, zzai zzai) {
            Preconditions.checkNotNull(obj);
            this.zzb = obj;
        }

        @NonNull
        @KeepForSdk
        @CanIgnoreReturnValue
        public ToStringHelper add(@NonNull String str, @Nullable Object obj) {
            List list = this.zza;
            Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            list.add(str + "=" + valueOf);
            return this;
        }

        @NonNull
        @KeepForSdk
        public String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.zzb.getClass().getSimpleName());
            sb2.append('{');
            int size = this.zza.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append((String) this.zza.get(i10));
                if (i10 < size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static boolean checkBundlesEquality(@NonNull Bundle bundle, @NonNull Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            if (bundle == bundle2) {
                return true;
            }
            return false;
        } else if (bundle.size() != bundle2.size()) {
            return false;
        } else {
            Set<String> keySet = bundle.keySet();
            if (!keySet.containsAll(bundle2.keySet())) {
                return false;
            }
            for (String next : keySet) {
                if (!equal(bundle.get(next), bundle2.get(next))) {
                    return false;
                }
            }
            return true;
        }
    }

    @KeepForSdk
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public static int hashCode(@NonNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @NonNull
    @KeepForSdk
    public static ToStringHelper toStringHelper(@NonNull Object obj) {
        return new ToStringHelper(obj, (zzai) null);
    }
}
