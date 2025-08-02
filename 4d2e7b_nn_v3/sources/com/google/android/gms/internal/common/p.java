package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.NoSuchElementException;

abstract class p extends zzak {

    /* renamed from: a  reason: collision with root package name */
    private final int f7048a;

    /* renamed from: b  reason: collision with root package name */
    private int f7049b;

    protected p(int i10, int i11) {
        zzs.zzb(i11, i10, FirebaseAnalytics.Param.INDEX);
        this.f7048a = i10;
        this.f7049b = i11;
    }

    /* access modifiers changed from: protected */
    public abstract Object a(int i10);

    public final boolean hasNext() {
        return this.f7049b < this.f7048a;
    }

    public final boolean hasPrevious() {
        return this.f7049b > 0;
    }

    public final Object next() {
        if (hasNext()) {
            int i10 = this.f7049b;
            this.f7049b = i10 + 1;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f7049b;
    }

    public final Object previous() {
        if (hasPrevious()) {
            int i10 = this.f7049b - 1;
            this.f7049b = i10;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f7049b - 1;
    }
}
