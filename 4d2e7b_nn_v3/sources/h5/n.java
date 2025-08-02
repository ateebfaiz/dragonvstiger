package h5;

import android.util.SparseIntArray;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f21972a = new n();

    /* renamed from: b  reason: collision with root package name */
    private static final SparseIntArray f21973b = new SparseIntArray(0);

    private n() {
    }

    public static final f0 a() {
        return new f0(0, f21972a.b(), f21973b);
    }

    private final int b() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min > 16777216) {
            return (min / 4) * 3;
        }
        return min / 2;
    }
}
