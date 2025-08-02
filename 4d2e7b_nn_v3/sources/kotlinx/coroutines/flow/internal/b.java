package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlinx.coroutines.flow.t1;

public abstract class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public d[] f1048a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f1049b;

    /* renamed from: c  reason: collision with root package name */
    private int f1050c;

    /* renamed from: d  reason: collision with root package name */
    private s f1051d;

    /* access modifiers changed from: protected */
    public final d g() {
        d dVar;
        s sVar;
        synchronized (this) {
            try {
                d[] dVarArr = this.f1048a;
                if (dVarArr == null) {
                    dVarArr = k(2);
                    this.f1048a = dVarArr;
                } else if (this.f1049b >= dVarArr.length) {
                    Object[] copyOf = Arrays.copyOf(dVarArr, dVarArr.length * 2);
                    m.e(copyOf, "copyOf(this, newSize)");
                    this.f1048a = (d[]) copyOf;
                    dVarArr = (d[]) copyOf;
                }
                int i10 = this.f1050c;
                do {
                    dVar = dVarArr[i10];
                    if (dVar == null) {
                        dVar = j();
                        dVarArr[i10] = dVar;
                    }
                    i10++;
                    if (i10 >= dVarArr.length) {
                        i10 = 0;
                    }
                    m.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!dVar.a(this));
                this.f1050c = i10;
                this.f1049b++;
                sVar = this.f1051d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (sVar != null) {
            sVar.Z(1);
        }
        return dVar;
    }

    public final t1 h() {
        s sVar;
        synchronized (this) {
            sVar = this.f1051d;
            if (sVar == null) {
                sVar = new s(this.f1049b);
                this.f1051d = sVar;
            }
        }
        return sVar;
    }

    /* access modifiers changed from: protected */
    public abstract d j();

    /* access modifiers changed from: protected */
    public abstract d[] k(int i10);

    /* access modifiers changed from: protected */
    public final void l(d dVar) {
        s sVar;
        int i10;
        d[] b10;
        synchronized (this) {
            try {
                int i11 = this.f1049b - 1;
                this.f1049b = i11;
                sVar = this.f1051d;
                if (i11 == 0) {
                    this.f1050c = 0;
                }
                m.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                b10 = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (d dVar2 : b10) {
            if (dVar2 != null) {
                o.a aVar = o.f12592b;
                dVar2.d(o.b(Unit.f12577a));
            }
        }
        if (sVar != null) {
            sVar.Z(-1);
        }
    }

    /* access modifiers changed from: protected */
    public final int m() {
        return this.f1049b;
    }

    /* access modifiers changed from: protected */
    public final d[] n() {
        return this.f1048a;
    }
}
