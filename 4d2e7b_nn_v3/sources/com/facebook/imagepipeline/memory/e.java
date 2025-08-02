package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import b3.a;
import b3.d;
import com.facebook.imagepipeline.memory.a;
import h5.f0;
import h5.g0;
import kotlin.jvm.internal.m;

public class e extends a implements a {

    /* renamed from: k  reason: collision with root package name */
    private final int[] f19983k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(d dVar, f0 f0Var, g0 g0Var) {
        super(dVar, f0Var, g0Var);
        m.f(dVar, "memoryTrimmableRegistry");
        m.f(f0Var, "poolParams");
        m.f(g0Var, "poolStatsTracker");
        SparseIntArray sparseIntArray = f0Var.f21946c;
        if (sparseIntArray != null) {
            this.f19983k = new int[sparseIntArray.size()];
            int size = sparseIntArray.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f19983k[i10] = sparseIntArray.keyAt(i10);
            }
        } else {
            this.f19983k = new int[0];
        }
        s();
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public byte[] g(int i10) {
        return new byte[i10];
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public void k(byte[] bArr) {
        m.f(bArr, "value");
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public int o(byte[] bArr) {
        m.f(bArr, "value");
        return bArr.length;
    }

    /* access modifiers changed from: protected */
    public int n(int i10) {
        if (i10 > 0) {
            for (int i11 : this.f19983k) {
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
