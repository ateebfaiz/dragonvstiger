package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class b3 extends g2 implements RandomAccess, zzkk, s3 {

    /* renamed from: c  reason: collision with root package name */
    private static final b3 f7128c;

    /* renamed from: a  reason: collision with root package name */
    private int[] f7129a;

    /* renamed from: b  reason: collision with root package name */
    private int f7130b;

    static {
        b3 b3Var = new b3(new int[0], 0);
        f7128c = b3Var;
        b3Var.zzb();
    }

    private b3(int[] iArr, int i10) {
        this.f7129a = iArr;
        this.f7130b = i10;
    }

    public static b3 c() {
        return f7128c;
    }

    private final String e(int i10) {
        int i11 = this.f7130b;
        return "Index:" + i10 + ", Size:" + i11;
    }

    private final void f(int i10) {
        if (i10 < 0 || i10 >= this.f7130b) {
            throw new IndexOutOfBoundsException(e(i10));
        }
    }

    public final int a(int i10) {
        f(i10);
        return this.f7129a[i10];
    }

    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        int intValue = ((Integer) obj).intValue();
        zzbT();
        if (i10 < 0 || i10 > (i11 = this.f7130b)) {
            throw new IndexOutOfBoundsException(e(i10));
        }
        int[] iArr = this.f7129a;
        if (i11 < iArr.length) {
            System.arraycopy(iArr, i10, iArr, i10 + 1, i11 - i10);
        } else {
            int[] iArr2 = new int[(((i11 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(this.f7129a, i10, iArr2, i10 + 1, this.f7130b - i10);
            this.f7129a = iArr2;
        }
        this.f7129a[i10] = intValue;
        this.f7130b++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        zzbT();
        zzkn.zze(collection);
        if (!(collection instanceof b3)) {
            return super.addAll(collection);
        }
        b3 b3Var = (b3) collection;
        int i10 = b3Var.f7130b;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f7130b;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            int[] iArr = this.f7129a;
            if (i12 > iArr.length) {
                this.f7129a = Arrays.copyOf(iArr, i12);
            }
            System.arraycopy(b3Var.f7129a, 0, this.f7129a, this.f7130b, b3Var.f7130b);
            this.f7130b = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final void d(int i10) {
        zzbT();
        int i11 = this.f7130b;
        int[] iArr = this.f7129a;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[(((i11 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f7129a = iArr2;
        }
        int[] iArr3 = this.f7129a;
        int i12 = this.f7130b;
        this.f7130b = i12 + 1;
        iArr3[i12] = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b3)) {
            return super.equals(obj);
        }
        b3 b3Var = (b3) obj;
        if (this.f7130b != b3Var.f7130b) {
            return false;
        }
        int[] iArr = b3Var.f7129a;
        for (int i10 = 0; i10 < this.f7130b; i10++) {
            if (this.f7129a[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i10) {
        f(i10);
        return Integer.valueOf(this.f7129a[i10]);
    }

    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f7130b; i11++) {
            i10 = (i10 * 31) + this.f7129a[i11];
        }
        return i10;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i10 = this.f7130b;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f7129a[i11] == intValue) {
                return i11;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        zzbT();
        f(i10);
        int[] iArr = this.f7129a;
        int i11 = iArr[i10];
        int i12 = this.f7130b;
        if (i10 < i12 - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (i12 - i10) - 1);
        }
        this.f7130b--;
        this.modCount++;
        return Integer.valueOf(i11);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i10, int i11) {
        zzbT();
        if (i11 >= i10) {
            int[] iArr = this.f7129a;
            System.arraycopy(iArr, i11, iArr, i10, this.f7130b - i11);
            this.f7130b -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzbT();
        f(i10);
        int[] iArr = this.f7129a;
        int i11 = iArr[i10];
        iArr[i10] = intValue;
        return Integer.valueOf(i11);
    }

    public final int size() {
        return this.f7130b;
    }

    /* renamed from: zzg */
    public final zzkk zzd(int i10) {
        if (i10 >= this.f7130b) {
            return new b3(Arrays.copyOf(this.f7129a, i10), this.f7130b);
        }
        throw new IllegalArgumentException();
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Integer) obj).intValue());
        return true;
    }
}
