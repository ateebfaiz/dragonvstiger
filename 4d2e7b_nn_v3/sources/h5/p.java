package h5;

import android.util.SparseIntArray;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final p f21975a = new p();

    /* renamed from: b  reason: collision with root package name */
    private static final int f21976b = Runtime.getRuntime().availableProcessors();

    private p() {
    }

    public static final SparseIntArray a(int i10, int i11, int i12) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i10 <= i11) {
            sparseIntArray.put(i10, i12);
            i10 *= 2;
        }
        return sparseIntArray;
    }

    public static final f0 b() {
        int i10 = f21976b;
        return new f0(4194304, i10 * 4194304, a(131072, 4194304, i10), 131072, 4194304, i10);
    }
}
