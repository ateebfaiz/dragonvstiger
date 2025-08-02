package h5;

import android.util.SparseIntArray;
import y2.l;

public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f21944a;

    /* renamed from: b  reason: collision with root package name */
    public final int f21945b;

    /* renamed from: c  reason: collision with root package name */
    public final SparseIntArray f21946c;

    /* renamed from: d  reason: collision with root package name */
    public final int f21947d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21948e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21949f;

    /* renamed from: g  reason: collision with root package name */
    public final int f21950g;

    public f0(int i10, int i11, SparseIntArray sparseIntArray) {
        this(i10, i11, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public f0(int i10, int i11, SparseIntArray sparseIntArray, int i12, int i13, int i14) {
        l.i(i10 >= 0 && i11 >= i10);
        this.f21945b = i10;
        this.f21944a = i11;
        this.f21946c = sparseIntArray;
        this.f21947d = i12;
        this.f21948e = i13;
        this.f21950g = i14;
    }
}
