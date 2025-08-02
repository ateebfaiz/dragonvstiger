package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class IntRange extends g implements f {

    /* renamed from: e  reason: collision with root package name */
    public static final a f732e = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final IntRange f733f = new IntRange(1, 0);

    public static final class a {
        private a() {
        }

        public final IntRange a() {
            return IntRange.f733f;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public IntRange(int i10, int i11) {
        super(i10, i11, 1);
    }

    public boolean b(int i10) {
        if (a() > i10 || i10 > c()) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntRange) {
            if (!isEmpty() || !((IntRange) obj).isEmpty()) {
                IntRange intRange = (IntRange) obj;
                if (!(a() == intRange.a() && c() == intRange.c())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public Integer getEndInclusive() {
        return Integer.valueOf(c());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + c();
    }

    /* renamed from: i */
    public Integer getStart() {
        return Integer.valueOf(a());
    }

    public boolean isEmpty() {
        if (a() > c()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return a() + ".." + c();
    }
}
