package kotlin.ranges;

import kotlin.collections.g0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import qb.c;

public class g implements Iterable<Integer>, wb.a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f744d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f745a;

    /* renamed from: b  reason: collision with root package name */
    private final int f746b;

    /* renamed from: c  reason: collision with root package name */
    private final int f747c;

    public static final class a {
        private a() {
        }

        public final g a(int i10, int i11, int i12) {
            return new g(i10, i11, i12);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i12 != Integer.MIN_VALUE) {
            this.f745a = i10;
            this.f746b = c.c(i10, i11, i12);
            this.f747c = i12;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int a() {
        return this.f745a;
    }

    public final int c() {
        return this.f746b;
    }

    public final int d() {
        return this.f747c;
    }

    /* renamed from: e */
    public g0 iterator() {
        return new h(this.f745a, this.f746b, this.f747c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            if (!isEmpty() || !((g) obj).isEmpty()) {
                g gVar = (g) obj;
                if (!(this.f745a == gVar.f745a && this.f746b == gVar.f746b && this.f747c == gVar.f747c)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f745a * 31) + this.f746b) * 31) + this.f747c;
    }

    public boolean isEmpty() {
        if (this.f747c > 0) {
            if (this.f745a <= this.f746b) {
                return false;
            }
        } else if (this.f745a >= this.f746b) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f747c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f745a);
            sb2.append("..");
            sb2.append(this.f746b);
            sb2.append(" step ");
            i10 = this.f747c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f745a);
            sb2.append(" downTo ");
            sb2.append(this.f746b);
            sb2.append(" step ");
            i10 = -this.f747c;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}
