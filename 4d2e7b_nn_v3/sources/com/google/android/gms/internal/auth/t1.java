package com.google.android.gms.internal.auth;

import java.util.Arrays;
import java.util.RandomAccess;

final class t1 extends l0 implements RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    private static final t1 f6998c;

    /* renamed from: a  reason: collision with root package name */
    private Object[] f6999a;

    /* renamed from: b  reason: collision with root package name */
    private int f7000b;

    static {
        t1 t1Var = new t1(new Object[0], 0);
        f6998c = t1Var;
        t1Var.zzb();
    }

    private t1(Object[] objArr, int i10) {
        this.f6999a = objArr;
        this.f7000b = i10;
    }

    public static t1 a() {
        return f6998c;
    }

    private final void c(int i10) {
        if (i10 < 0 || i10 >= this.f7000b) {
            throw new IndexOutOfBoundsException(zzf(i10));
        }
    }

    private final String zzf(int i10) {
        int i11 = this.f7000b;
        return "Index:" + i10 + ", Size:" + i11;
    }

    public final void add(int i10, Object obj) {
        int i11;
        zza();
        if (i10 < 0 || i10 > (i11 = this.f7000b)) {
            throw new IndexOutOfBoundsException(zzf(i10));
        }
        Object[] objArr = this.f6999a;
        if (i11 < objArr.length) {
            System.arraycopy(objArr, i10, objArr, i10 + 1, i11 - i10);
        } else {
            Object[] objArr2 = new Object[(((i11 * 3) / 2) + 1)];
            System.arraycopy(objArr, 0, objArr2, 0, i10);
            System.arraycopy(this.f6999a, i10, objArr2, i10 + 1, this.f7000b - i10);
            this.f6999a = objArr2;
        }
        this.f6999a[i10] = obj;
        this.f7000b++;
        this.modCount++;
    }

    public final Object get(int i10) {
        c(i10);
        return this.f6999a[i10];
    }

    public final Object remove(int i10) {
        zza();
        c(i10);
        Object[] objArr = this.f6999a;
        Object obj = objArr[i10];
        int i11 = this.f7000b;
        if (i10 < i11 - 1) {
            System.arraycopy(objArr, i10 + 1, objArr, i10, (i11 - i10) - 1);
        }
        this.f7000b--;
        this.modCount++;
        return obj;
    }

    public final Object set(int i10, Object obj) {
        zza();
        c(i10);
        Object[] objArr = this.f6999a;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        this.modCount++;
        return obj2;
    }

    public final int size() {
        return this.f7000b;
    }

    public final /* bridge */ /* synthetic */ zzey zzd(int i10) {
        if (i10 >= this.f7000b) {
            return new t1(Arrays.copyOf(this.f6999a, i10), this.f7000b);
        }
        throw new IllegalArgumentException();
    }

    public final boolean add(Object obj) {
        zza();
        int i10 = this.f7000b;
        Object[] objArr = this.f6999a;
        if (i10 == objArr.length) {
            this.f6999a = Arrays.copyOf(objArr, ((i10 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f6999a;
        int i11 = this.f7000b;
        this.f7000b = i11 + 1;
        objArr2[i11] = obj;
        this.modCount++;
        return true;
    }
}
