package androidx.activity;

import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.sequences.h;

public final class ViewTreeFullyDrawnReporterOwner {

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f13803a = new a();

        a() {
            super(1);
        }

        /* renamed from: a */
        public final View invoke(View view) {
            m.f(view, "it");
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                return (View) parent;
            }
            return null;
        }
    }

    static final class b extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f13804a = new b();

        b() {
            super(1);
        }

        /* renamed from: a */
        public final FullyDrawnReporterOwner invoke(View view) {
            m.f(view, "it");
            Object tag = view.getTag(R.id.report_drawn);
            if (tag instanceof FullyDrawnReporterOwner) {
                return (FullyDrawnReporterOwner) tag;
            }
            return null;
        }
    }

    public static final FullyDrawnReporterOwner get(View view) {
        m.f(view, "<this>");
        return (FullyDrawnReporterOwner) h.m(h.r(h.e(view, a.f13803a), b.f13804a));
    }

    public static final void set(View view, FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        m.f(view, "<this>");
        m.f(fullyDrawnReporterOwner, "fullyDrawnReporterOwner");
        view.setTag(R.id.report_drawn, fullyDrawnReporterOwner);
    }
}
