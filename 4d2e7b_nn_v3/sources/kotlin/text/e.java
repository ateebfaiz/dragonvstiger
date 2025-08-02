package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import kotlin.sequences.Sequence;

final class e implements Sequence {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f805a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f806b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f807c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Function2 f808d;

    public static final class a implements Iterator, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private int f809a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f810b;

        /* renamed from: c  reason: collision with root package name */
        private int f811c;

        /* renamed from: d  reason: collision with root package name */
        private IntRange f812d;

        /* renamed from: e  reason: collision with root package name */
        private int f813e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ e f814f;

        a(e eVar) {
            this.f814f = eVar;
            int h10 = l.h(eVar.f806b, 0, eVar.f805a.length());
            this.f810b = h10;
            this.f811c = h10;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
            if (r0 < kotlin.text.e.d(r6.f814f)) goto L_0x0023;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f811c
                r1 = 0
                if (r0 >= 0) goto L_0x000c
                r6.f809a = r1
                r0 = 0
                r6.f812d = r0
                goto L_0x009e
            L_0x000c:
                kotlin.text.e r0 = r6.f814f
                int r0 = r0.f807c
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0023
                int r0 = r6.f813e
                int r0 = r0 + r3
                r6.f813e = r0
                kotlin.text.e r4 = r6.f814f
                int r4 = r4.f807c
                if (r0 >= r4) goto L_0x0031
            L_0x0023:
                int r0 = r6.f811c
                kotlin.text.e r4 = r6.f814f
                java.lang.CharSequence r4 = r4.f805a
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x0047
            L_0x0031:
                kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
                int r1 = r6.f810b
                kotlin.text.e r4 = r6.f814f
                java.lang.CharSequence r4 = r4.f805a
                int r4 = kotlin.text.t.P(r4)
                r0.<init>(r1, r4)
                r6.f812d = r0
                r6.f811c = r2
                goto L_0x009c
            L_0x0047:
                kotlin.text.e r0 = r6.f814f
                kotlin.jvm.functions.Function2 r0 = r0.f808d
                kotlin.text.e r4 = r6.f814f
                java.lang.CharSequence r4 = r4.f805a
                int r5 = r6.f811c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L_0x0077
                kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
                int r1 = r6.f810b
                kotlin.text.e r4 = r6.f814f
                java.lang.CharSequence r4 = r4.f805a
                int r4 = kotlin.text.t.P(r4)
                r0.<init>(r1, r4)
                r6.f812d = r0
                r6.f811c = r2
                goto L_0x009c
            L_0x0077:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f810b
                kotlin.ranges.IntRange r4 = kotlin.ranges.l.l(r4, r2)
                r6.f812d = r4
                int r2 = r2 + r0
                r6.f810b = r2
                if (r0 != 0) goto L_0x0099
                r1 = r3
            L_0x0099:
                int r2 = r2 + r1
                r6.f811c = r2
            L_0x009c:
                r6.f809a = r3
            L_0x009e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.e.a.a():void");
        }

        /* renamed from: c */
        public IntRange next() {
            if (this.f809a == -1) {
                a();
            }
            if (this.f809a != 0) {
                IntRange intRange = this.f812d;
                m.d(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f812d = null;
                this.f809a = -1;
                return intRange;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f809a == -1) {
                a();
            }
            if (this.f809a == 1) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(CharSequence charSequence, int i10, int i11, Function2 function2) {
        m.f(charSequence, "input");
        m.f(function2, "getNextMatch");
        this.f805a = charSequence;
        this.f806b = i10;
        this.f807c = i11;
        this.f808d = function2;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
