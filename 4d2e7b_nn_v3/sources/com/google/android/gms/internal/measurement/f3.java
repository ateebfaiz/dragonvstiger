package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class f3 extends g2 implements RandomAccess, zzkl, s3 {

    /* renamed from: c  reason: collision with root package name */
    private static final f3 f7167c;

    /* renamed from: a  reason: collision with root package name */
    private long[] f7168a;

    /* renamed from: b  reason: collision with root package name */
    private int f7169b;

    static {
        f3 f3Var = new f3(new long[0], 0);
        f7167c = f3Var;
        f3Var.zzb();
    }

    private f3(long[] jArr, int i10) {
        this.f7168a = jArr;
        this.f7169b = i10;
    }

    public static f3 a() {
        return f7167c;
    }

    private final String d(int i10) {
        int i11 = this.f7169b;
        return "Index:" + i10 + ", Size:" + i11;
    }

    private final void e(int i10) {
        if (i10 < 0 || i10 >= this.f7169b) {
            throw new IndexOutOfBoundsException(d(i10));
        }
    }

    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        long longValue = ((Long) obj).longValue();
        zzbT();
        if (i10 < 0 || i10 > (i11 = this.f7169b)) {
            throw new IndexOutOfBoundsException(d(i10));
        }
        long[] jArr = this.f7168a;
        if (i11 < jArr.length) {
            System.arraycopy(jArr, i10, jArr, i10 + 1, i11 - i10);
        } else {
            long[] jArr2 = new long[(((i11 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            System.arraycopy(this.f7168a, i10, jArr2, i10 + 1, this.f7169b - i10);
            this.f7168a = jArr2;
        }
        this.f7168a[i10] = longValue;
        this.f7169b++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        zzbT();
        zzkn.zze(collection);
        if (!(collection instanceof f3)) {
            return super.addAll(collection);
        }
        f3 f3Var = (f3) collection;
        int i10 = f3Var.f7169b;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f7169b;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            long[] jArr = this.f7168a;
            if (i12 > jArr.length) {
                this.f7168a = Arrays.copyOf(jArr, i12);
            }
            System.arraycopy(f3Var.f7168a, 0, this.f7168a, this.f7169b, f3Var.f7169b);
            this.f7169b = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void c(long j10) {
        zzbT();
        int i10 = this.f7169b;
        long[] jArr = this.f7168a;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[(((i10 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            this.f7168a = jArr2;
        }
        long[] jArr3 = this.f7168a;
        int i11 = this.f7169b;
        this.f7169b = i11 + 1;
        jArr3[i11] = j10;
    }

    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f3)) {
            return super.equals(obj);
        }
        f3 f3Var = (f3) obj;
        if (this.f7169b != f3Var.f7169b) {
            return false;
        }
        long[] jArr = f3Var.f7168a;
        for (int i10 = 0; i10 < this.f7169b; i10++) {
            if (this.f7168a[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i10) {
        e(i10);
        return Long.valueOf(this.f7168a[i10]);
    }

    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f7169b; i11++) {
            i10 = (i10 * 31) + zzkn.zzc(this.f7168a[i11]);
        }
        return i10;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i10 = this.f7169b;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f7168a[i11] == longValue) {
                return i11;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        zzbT();
        e(i10);
        long[] jArr = this.f7168a;
        long j10 = jArr[i10];
        int i11 = this.f7169b;
        if (i10 < i11 - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (i11 - i10) - 1);
        }
        this.f7169b--;
        this.modCount++;
        return Long.valueOf(j10);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i10, int i11) {
        zzbT();
        if (i11 >= i10) {
            long[] jArr = this.f7168a;
            System.arraycopy(jArr, i11, jArr, i10, this.f7169b - i11);
            this.f7169b -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzbT();
        e(i10);
        long[] jArr = this.f7168a;
        long j10 = jArr[i10];
        jArr[i10] = longValue;
        return Long.valueOf(j10);
    }

    public final int size() {
        return this.f7169b;
    }

    public final long zza(int i10) {
        e(i10);
        return this.f7168a[i10];
    }

    /* renamed from: zze */
    public final zzkl zzd(int i10) {
        if (i10 >= this.f7169b) {
            return new f3(Arrays.copyOf(this.f7168a, i10), this.f7169b);
        }
        throw new IllegalArgumentException();
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        c(((Long) obj).longValue());
        return true;
    }
}
