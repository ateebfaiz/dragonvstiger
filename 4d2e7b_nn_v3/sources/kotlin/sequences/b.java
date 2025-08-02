package kotlin.sequences;

import io.jsonwebtoken.JwtParser;
import java.util.Iterator;
import kotlin.jvm.internal.m;

public final class b implements Sequence, c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Sequence f767a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f768b;

    public static final class a implements Iterator, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator f769a;

        /* renamed from: b  reason: collision with root package name */
        private int f770b;

        a(b bVar) {
            this.f769a = bVar.f767a.iterator();
            this.f770b = bVar.f768b;
        }

        private final void a() {
            while (this.f770b > 0 && this.f769a.hasNext()) {
                this.f769a.next();
                this.f770b--;
            }
        }

        public boolean hasNext() {
            a();
            return this.f769a.hasNext();
        }

        public Object next() {
            a();
            return this.f769a.next();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(Sequence sequence, int i10) {
        m.f(sequence, "sequence");
        this.f767a = sequence;
        this.f768b = i10;
        if (i10 < 0) {
            throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + JwtParser.SEPARATOR_CHAR).toString());
        }
    }

    public Sequence a(int i10) {
        int i11 = this.f768b + i10;
        if (i11 < 0) {
            return new b(this, i10);
        }
        return new b(this.f767a, i11);
    }

    public Iterator iterator() {
        return new a(this);
    }
}
