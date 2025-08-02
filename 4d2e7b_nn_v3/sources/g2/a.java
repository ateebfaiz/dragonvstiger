package g2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.facebook.o;
import e2.g;
import h2.f;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21623a = new a();

    /* renamed from: g2.a$a  reason: collision with other inner class name */
    public static final class C0279a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private h2.a f21624a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference f21625b;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference f21626c;

        /* renamed from: d  reason: collision with root package name */
        private View.OnClickListener f21627d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f21628e = true;

        public C0279a(h2.a aVar, View view, View view2) {
            m.f(aVar, "mapping");
            m.f(view, "rootView");
            m.f(view2, "hostView");
            this.f21624a = aVar;
            this.f21625b = new WeakReference(view2);
            this.f21626c = new WeakReference(view);
            this.f21627d = f.g(view2);
        }

        public final boolean a() {
            return this.f21628e;
        }

        public void onClick(View view) {
            if (!v5.a.d(this)) {
                try {
                    m.f(view, "view");
                    View.OnClickListener onClickListener = this.f21627d;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    View view2 = (View) this.f21626c.get();
                    View view3 = (View) this.f21625b.get();
                    if (view2 != null && view3 != null) {
                        h2.a aVar = this.f21624a;
                        if (aVar != null) {
                            a.c(aVar, view2, view3);
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.internal.EventBinding");
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    public static final class b implements AdapterView.OnItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private h2.a f21629a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference f21630b;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference f21631c;

        /* renamed from: d  reason: collision with root package name */
        private AdapterView.OnItemClickListener f21632d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f21633e = true;

        public b(h2.a aVar, View view, AdapterView adapterView) {
            m.f(aVar, "mapping");
            m.f(view, "rootView");
            m.f(adapterView, "hostView");
            this.f21629a = aVar;
            this.f21630b = new WeakReference(adapterView);
            this.f21631c = new WeakReference(view);
            this.f21632d = adapterView.getOnItemClickListener();
        }

        public final boolean a() {
            return this.f21633e;
        }

        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            m.f(view, "view");
            AdapterView.OnItemClickListener onItemClickListener = this.f21632d;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i10, j10);
            }
            View view2 = (View) this.f21631c.get();
            AdapterView adapterView2 = (AdapterView) this.f21630b.get();
            if (view2 != null && adapterView2 != null) {
                a.c(this.f21629a, view2, adapterView2);
            }
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21634a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bundle f21635b;

        c(String str, Bundle bundle) {
            this.f21634a = str;
            this.f21635b = bundle;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    g.f21166c.f(o.f()).b(this.f21634a, this.f21635b);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private a() {
    }

    public static final C0279a a(h2.a aVar, View view, View view2) {
        Class<a> cls = a.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(aVar, "mapping");
            m.f(view, "rootView");
            m.f(view2, "hostView");
            return new C0279a(aVar, view, view2);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final b b(h2.a aVar, View view, AdapterView adapterView) {
        Class<a> cls = a.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(aVar, "mapping");
            m.f(view, "rootView");
            m.f(adapterView, "hostView");
            return new b(aVar, view, adapterView);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final void c(h2.a aVar, View view, View view2) {
        Class<a> cls = a.class;
        if (!v5.a.d(cls)) {
            try {
                m.f(aVar, "mapping");
                m.f(view, "rootView");
                m.f(view2, "hostView");
                String b10 = aVar.b();
                Bundle b11 = c.f21649h.b(aVar, view, view2);
                f21623a.d(b11);
                o.p().execute(new c(b10, b11));
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public final void d(Bundle bundle) {
        if (!v5.a.d(this)) {
            try {
                m.f(bundle, "parameters");
                String string = bundle.getString("_valueToSum");
                if (string != null) {
                    bundle.putDouble("_valueToSum", l2.b.g(string));
                }
                bundle.putString("_is_fb_codeless", "1");
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }
}
