package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.RandomAccess;

final class u3 extends g2 implements RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    private static final u3 f7327c;

    /* renamed from: a  reason: collision with root package name */
    private Object[] f7328a;

    /* renamed from: b  reason: collision with root package name */
    private int f7329b;

    static {
        u3 u3Var = new u3(new Object[0], 0);
        f7327c = u3Var;
        u3Var.zzb();
    }

    private u3(Object[] objArr, int i10) {
        this.f7328a = objArr;
        this.f7329b = i10;
    }

    public static u3 a() {
        return f7327c;
    }

    private final String c(int i10) {
        int i11 = this.f7329b;
        return "Index:" + i10 + ", Size:" + i11;
    }

    private final void d(int i10) {
        if (i10 < 0 || i10 >= this.f7329b) {
            throw new IndexOutOfBoundsException(c(i10));
        }
    }

    public final void add(int i10, Object obj) {
        int i11;
        zzbT();
        if (i10 < 0 || i10 > (i11 = this.f7329b)) {
            throw new IndexOutOfBoundsException(c(i10));
        }
        Object[] objArr = this.f7328a;
        if (i11 < objArr.length) {
            System.arraycopy(objArr, i10, objArr, i10 + 1, i11 - i10);
        } else {
            Object[] objArr2 = new Object[(((i11 * 3) / 2) + 1)];
            System.arraycopy(objArr, 0, objArr2, 0, i10);
            System.arraycopy(this.f7328a, i10, objArr2, i10 + 1, this.f7329b - i10);
            this.f7328a = objArr2;
        }
        this.f7328a[i10] = obj;
        this.f7329b++;
        this.modCount++;
    }

    public final Object get(int i10) {
        d(i10);
        return this.f7328a[i10];
    }

    public final Object remove(int i10) {
        zzbT();
        d(i10);
        Object[] objArr = this.f7328a;
        Object obj = objArr[i10];
        int i11 = this.f7329b;
        if (i10 < i11 - 1) {
            System.arraycopy(objArr, i10 + 1, objArr, i10, (i11 - i10) - 1);
        }
        this.f7329b--;
        this.modCount++;
        return obj;
    }

    public final Object set(int i10, Object obj) {
        zzbT();
        d(i10);
        Object[] objArr = this.f7328a;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        this.modCount++;
        return obj2;
    }

    public final int size() {
        return this.f7329b;
    }

    public final /* bridge */ /* synthetic */ zzkm zzd(int i10) {
        if (i10 >= this.f7329b) {
            return new u3(Arrays.copyOf(this.f7328a, i10), this.f7329b);
        }
        throw new IllegalArgumentException();
    }

    public final boolean add(Object obj) {
        zzbT();
        int i10 = this.f7329b;
        Object[] objArr = this.f7328a;
        if (i10 == objArr.length) {
            this.f7328a = Arrays.copyOf(objArr, ((i10 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f7328a;
        int i11 = this.f7329b;
        this.f7329b = i11 + 1;
        objArr2[i11] = obj;
        this.modCount++;
        return true;
    }
}
