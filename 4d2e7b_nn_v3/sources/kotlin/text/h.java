package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;

public final class h implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f820b = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Pattern f821a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class b implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        public static final a f822c = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final String f823a;

        /* renamed from: b  reason: collision with root package name */
        private final int f824b;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(String str, int i10) {
            m.f(str, "pattern");
            this.f823a = str;
            this.f824b = i10;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.f823a, this.f824b);
            m.e(compile, "compile(...)");
            return new h(compile);
        }
    }

    public h(Pattern pattern) {
        m.f(pattern, "nativePattern");
        this.f821a = pattern;
    }

    private final Object writeReplace() {
        String pattern = this.f821a.pattern();
        m.e(pattern, "pattern(...)");
        return new b(pattern, this.f821a.flags());
    }

    public final MatchResult b(CharSequence charSequence) {
        m.f(charSequence, "input");
        Matcher matcher = this.f821a.matcher(charSequence);
        m.e(matcher, "matcher(...)");
        return i.c(matcher, charSequence);
    }

    public final boolean c(CharSequence charSequence) {
        m.f(charSequence, "input");
        return this.f821a.matcher(charSequence).matches();
    }

    public final String d(CharSequence charSequence, String str) {
        m.f(charSequence, "input");
        m.f(str, "replacement");
        String replaceAll = this.f821a.matcher(charSequence).replaceAll(str);
        m.e(replaceAll, "replaceAll(...)");
        return replaceAll;
    }

    public final List e(CharSequence charSequence, int i10) {
        m.f(charSequence, "input");
        t.q0(i10);
        Matcher matcher = this.f821a.matcher(charSequence);
        if (i10 == 1 || !matcher.find()) {
            return r.e(charSequence.toString());
        }
        int i11 = 10;
        if (i10 > 0) {
            i11 = l.f(i10, 10);
        }
        ArrayList arrayList = new ArrayList(i11);
        int i12 = i10 - 1;
        int i13 = 0;
        do {
            arrayList.add(charSequence.subSequence(i13, matcher.start()).toString());
            i13 = matcher.end();
            if ((i12 >= 0 && arrayList.size() == i12) || !matcher.find()) {
                arrayList.add(charSequence.subSequence(i13, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i13, matcher.start()).toString());
            i13 = matcher.end();
            break;
        } while (!matcher.find());
        arrayList.add(charSequence.subSequence(i13, charSequence.length()).toString());
        return arrayList;
    }

    public String toString() {
        String pattern = this.f821a.toString();
        m.e(pattern, "toString(...)");
        return pattern;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.m.f(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(...)"
            kotlin.jvm.internal.m.e(r2, r0)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.h.<init>(java.lang.String):void");
    }
}
