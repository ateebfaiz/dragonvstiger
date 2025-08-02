package kotlin.ranges;

import kotlin.collections.q;
import kotlin.jvm.internal.DefaultConstructorMarker;
import qb.c;

public abstract class a implements Iterable<Character>, wb.a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0012a f734d = new C0012a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final char f735a;

    /* renamed from: b  reason: collision with root package name */
    private final char f736b;

    /* renamed from: c  reason: collision with root package name */
    private final int f737c;

    /* renamed from: kotlin.ranges.a$a  reason: collision with other inner class name */
    public static final class C0012a {
        private C0012a() {
        }

        public /* synthetic */ C0012a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(char c10, char c11, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i10 != Integer.MIN_VALUE) {
            this.f735a = c10;
            this.f736b = (char) c.c(c10, c11, i10);
            this.f737c = i10;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final char a() {
        return this.f735a;
    }

    public final char c() {
        return this.f736b;
    }

    /* renamed from: d */
    public q iterator() {
        return new b(this.f735a, this.f736b, this.f737c);
    }
}
