package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import b3.d;
import com.facebook.imagepipeline.memory.a;
import h5.f0;
import h5.g0;
import h5.v;
import y2.l;

public abstract class f extends a {

    /* renamed from: k  reason: collision with root package name */
    private final int[] f19984k;

    f(d dVar, f0 f0Var, g0 g0Var) {
        super(dVar, f0Var, g0Var);
        SparseIntArray sparseIntArray = (SparseIntArray) l.g(f0Var.f21946c);
        this.f19984k = new int[sparseIntArray.size()];
        int i10 = 0;
        while (true) {
            int[] iArr = this.f19984k;
            if (i10 < iArr.length) {
                iArr[i10] = sparseIntArray.keyAt(i10);
                i10++;
            } else {
                s();
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public void k(v vVar) {
        l.g(vVar);
        vVar.close();
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public int o(v vVar) {
        l.g(vVar);
        return vVar.getSize();
    }

    /* access modifiers changed from: package-private */
    public int C() {
        return this.f19984k[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public boolean u(v vVar) {
        l.g(vVar);
        return !vVar.isClosed();
    }

    /* access modifiers changed from: protected */
    public int n(int i10) {
        if (i10 > 0) {
            for (int i11 : this.f19984k) {
                if (i11 >= i10) {
                    return i11;
                }
            }
            return i10;
        }
        throw new a.b(Integer.valueOf(i10));
    }

    /* access modifiers changed from: protected */
    public int p(int i10) {
        return i10;
    }
}
