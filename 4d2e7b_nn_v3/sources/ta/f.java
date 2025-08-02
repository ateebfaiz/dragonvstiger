package ta;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract /* synthetic */ class f {
    public static /* synthetic */ Set a(Object[] objArr) {
        HashSet hashSet = new HashSet(objArr.length);
        int length = objArr.length;
        int i10 = 0;
        while (i10 < length) {
            Object obj = objArr[i10];
            Objects.requireNonNull(obj);
            if (hashSet.add(obj)) {
                i10++;
            } else {
                throw new IllegalArgumentException("duplicate element: " + obj);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
