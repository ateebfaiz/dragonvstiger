package com.google.android.gms.internal.fido;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.NoSuchElementException;

abstract class d extends zzcc {

    /* renamed from: a  reason: collision with root package name */
    private final int f7057a;

    /* renamed from: b  reason: collision with root package name */
    private int f7058b;

    protected d(int i10, int i11) {
        zzap.zzb(i11, i10, FirebaseAnalytics.Param.INDEX);
        this.f7057a = i10;
        this.f7058b = i11;
    }

    /* access modifiers changed from: protected */
    public abstract Object a(int i10);

    public final boolean hasNext() {
        return this.f7058b < this.f7057a;
    }

    public final boolean hasPrevious() {
        return this.f7058b > 0;
    }

    public final Object next() {
        if (hasNext()) {
            int i10 = this.f7058b;
            this.f7058b = i10 + 1;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f7058b;
    }

    public final Object previous() {
        if (hasPrevious()) {
            int i10 = this.f7058b - 1;
            this.f7058b = i10;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f7058b - 1;
    }
}
