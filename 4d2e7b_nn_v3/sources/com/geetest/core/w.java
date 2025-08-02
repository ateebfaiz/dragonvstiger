package com.geetest.core;

public class w {

    /* renamed from: a  reason: collision with root package name */
    public static final v[] f6197a = new v[0];

    /* renamed from: b  reason: collision with root package name */
    public v[] f6198b;

    /* renamed from: c  reason: collision with root package name */
    public int f6199c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6200d;

    public w(int i10) {
        v[] vVarArr;
        if (i10 >= 0) {
            if (i10 == 0) {
                vVarArr = f6197a;
            } else {
                vVarArr = new v[i10];
            }
            this.f6198b = vVarArr;
            this.f6199c = 0;
            this.f6200d = false;
            return;
        }
        throw new IllegalArgumentException("'initialCapacity' must not be negative");
    }

    public void a(v vVar) {
        if (vVar != null) {
            v[] vVarArr = this.f6198b;
            int length = vVarArr.length;
            boolean z10 = true;
            int i10 = this.f6199c + 1;
            if (i10 <= length) {
                z10 = false;
            }
            if (this.f6200d || z10) {
                v[] vVarArr2 = new v[Math.max(vVarArr.length, (i10 >> 1) + i10)];
                System.arraycopy(this.f6198b, 0, vVarArr2, 0, this.f6199c);
                this.f6198b = vVarArr2;
                this.f6200d = false;
            }
            this.f6198b[this.f6199c] = vVar;
            this.f6199c = i10;
            return;
        }
        throw new NullPointerException("'element' cannot be null");
    }

    public int b() {
        return this.f6199c;
    }

    public v[] c() {
        int i10 = this.f6199c;
        if (i10 == 0) {
            return f6197a;
        }
        v[] vVarArr = this.f6198b;
        if (vVarArr.length == i10) {
            this.f6200d = true;
            return vVarArr;
        }
        v[] vVarArr2 = new v[i10];
        System.arraycopy(vVarArr, 0, vVarArr2, 0, i10);
        return vVarArr2;
    }

    public v a(int i10) {
        if (i10 < this.f6199c) {
            return this.f6198b[i10];
        }
        throw new ArrayIndexOutOfBoundsException(i10 + " >= " + this.f6199c);
    }

    public v[] a() {
        int i10 = this.f6199c;
        if (i10 == 0) {
            return f6197a;
        }
        v[] vVarArr = new v[i10];
        System.arraycopy(this.f6198b, 0, vVarArr, 0, i10);
        return vVarArr;
    }

    public static v[] a(v[] vVarArr) {
        return vVarArr.length < 1 ? f6197a : (v[]) vVarArr.clone();
    }
}
