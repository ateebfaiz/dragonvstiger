package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.ranges.IntRange;
import kotlin.sequences.h;

final class g implements MatchResult {

    /* renamed from: a  reason: collision with root package name */
    private final Matcher f815a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f816b;

    /* renamed from: c  reason: collision with root package name */
    private final f f817c = new a(this);

    public static final class a extends kotlin.collections.a implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f818a;

        /* renamed from: kotlin.text.g$a$a  reason: collision with other inner class name */
        static final class C0013a extends n implements Function1<Integer, MatchGroup> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f819a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0013a(a aVar) {
                super(1);
                this.f819a = aVar;
            }

            public final MatchGroup a(int i10) {
                return this.f819a.get(i10);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).intValue());
            }
        }

        a(g gVar) {
            this.f818a = gVar;
        }

        public /* bridge */ boolean a(MatchGroup matchGroup) {
            return super.contains(matchGroup);
        }

        public final /* bridge */ boolean contains(Object obj) {
            boolean z10;
            if (obj == null) {
                z10 = true;
            } else {
                z10 = obj instanceof MatchGroup;
            }
            if (!z10) {
                return false;
            }
            return a((MatchGroup) obj);
        }

        public MatchGroup get(int i10) {
            IntRange b10 = i.d(this.f818a.c(), i10);
            if (b10.getStart().intValue() < 0) {
                return null;
            }
            String group = this.f818a.c().group(i10);
            m.e(group, "group(...)");
            return new MatchGroup(group, b10);
        }

        public int getSize() {
            return this.f818a.c().groupCount() + 1;
        }

        public boolean isEmpty() {
            return false;
        }

        public Iterator iterator() {
            return h.q(r.Q(r.m(this)), new C0013a(this)).iterator();
        }
    }

    public g(Matcher matcher, CharSequence charSequence) {
        m.f(matcher, "matcher");
        m.f(charSequence, "input");
        this.f815a = matcher;
        this.f816b = charSequence;
    }

    /* access modifiers changed from: private */
    public final MatchResult c() {
        return this.f815a;
    }

    public f a() {
        return this.f817c;
    }
}
