package w7;

import android.text.SpannableStringBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class g {

    /* renamed from: d  reason: collision with root package name */
    public static final a f13201d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f13202a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13203b;

    /* renamed from: c  reason: collision with root package name */
    public final e f13204c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g(int i10, int i11, e eVar) {
        m.f(eVar, "what");
        this.f13202a = i10;
        this.f13203b = i11;
        this.f13204c = eVar;
    }

    public final void a(SpannableStringBuilder spannableStringBuilder, int i10) {
        int i11;
        m.f(spannableStringBuilder, "builder");
        if (i10 >= 0) {
            if (this.f13202a == 0) {
                i11 = 18;
            } else {
                i11 = 34;
            }
            int i12 = 255 - i10;
            if (i12 < 0) {
                z2.a.G("SetSpanOperation", "Text tree size exceeded the limit, styling may become unpredictable");
            }
            spannableStringBuilder.setSpan(this.f13204c, this.f13202a, this.f13203b, ((Math.max(i12, 0) << 16) & 16711680) | (i11 & -16711681));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
