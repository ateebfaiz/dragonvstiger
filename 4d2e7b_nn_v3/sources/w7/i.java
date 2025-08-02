package w7;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class i extends ReplacementSpan implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f13209a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public final void a(Spannable spannable, TextView textView) {
            m.f(spannable, "spannable");
            Object[] spans = spannable.getSpans(0, spannable.length(), i.class);
            m.e(spans, "getSpans(...)");
            for (Object obj : spans) {
                i iVar = (i) obj;
                iVar.c();
                iVar.h(textView);
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void g(Spannable spannable, TextView textView) {
        f13209a.a(spannable, textView);
    }

    public abstract Drawable a();

    public abstract int b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void h(TextView textView);
}
