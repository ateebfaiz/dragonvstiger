package y5;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final a f24954c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Set f24955a = new LinkedHashSet();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map f24956b = new LinkedHashMap();

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final String b(b bVar, String str) {
            String z10 = j.z(j.z(j.z(str, "\\u003C", "<", false, 4, (Object) null), "\\n", "", false, 4, (Object) null), "\\\"", "\"", false, 4, (Object) null);
            b0 b0Var = b0.f709a;
            String b10 = bVar.b();
            Integer valueOf = Integer.valueOf(bVar.c());
            Integer valueOf2 = Integer.valueOf(bVar.d());
            Integer valueOf3 = Integer.valueOf(bVar.e());
            Integer valueOf4 = Integer.valueOf(bVar.a());
            String substring = z10.substring(1, z10.length() - 1);
            m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String format = String.format("<html id=\"%s\" data-rect=\"%d,%d,%d,%d\">%s</html>", Arrays.copyOf(new Object[]{b10, valueOf, valueOf2, valueOf3, valueOf4, substring}, 6));
            m.e(format, "java.lang.String.format(format, *args)");
            return format;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class b {

        /* renamed from: f  reason: collision with root package name */
        private static final int[] f24957f = new int[2];

        /* renamed from: g  reason: collision with root package name */
        public static final a f24958g = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final String f24959a;

        /* renamed from: b  reason: collision with root package name */
        private final int f24960b;

        /* renamed from: c  reason: collision with root package name */
        private final int f24961c;

        /* renamed from: d  reason: collision with root package name */
        private final int f24962d;

        /* renamed from: e  reason: collision with root package name */
        private final int f24963e;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(WebView webView) {
            m.f(webView, "webView");
            b0 b0Var = b0.f709a;
            String format = String.format("%s{%s}", Arrays.copyOf(new Object[]{webView.getClass().getName(), Integer.toHexString(webView.hashCode())}, 2));
            m.e(format, "java.lang.String.format(format, *args)");
            this.f24959a = format;
            int[] iArr = f24957f;
            webView.getLocationOnScreen(iArr);
            this.f24960b = iArr[0];
            this.f24961c = iArr[1];
            this.f24962d = webView.getWidth();
            this.f24963e = webView.getHeight();
        }

        public final int a() {
            return this.f24963e;
        }

        public final String b() {
            return this.f24959a;
        }

        public final int c() {
            return this.f24960b;
        }

        public final int d() {
            return this.f24961c;
        }

        public final int e() {
            return this.f24962d;
        }
    }

    static final class c implements ValueCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f24964a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f24965b;

        c(d dVar, b bVar) {
            this.f24964a = dVar;
            this.f24965b = bVar;
        }

        /* renamed from: a */
        public final void onReceiveValue(String str) {
            Map a10 = this.f24964a.f24956b;
            String b10 = this.f24965b.b();
            m.e(str, "html");
            a10.put(b10, str);
        }
    }

    public final void b(PrintWriter printWriter) {
        m.f(printWriter, "writer");
        try {
            for (b bVar : this.f24955a) {
                String str = (String) this.f24956b.get(bVar.b());
                if (str != null) {
                    printWriter.print("WebView HTML for ");
                    printWriter.print(bVar);
                    printWriter.println(":");
                    printWriter.println(f24954c.b(bVar, str));
                }
            }
        } catch (Exception unused) {
        }
        this.f24955a.clear();
        this.f24956b.clear();
    }

    public final void c(WebView webView) {
        m.f(webView, "view");
        b bVar = new b(webView);
        this.f24955a.add(bVar);
        Resources resources = webView.getResources();
        m.e(resources, "view.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        b0 b0Var = b0.f709a;
        String format = String.format("(function() {  try {    const leftOf = %d;    const topOf = %d;    const density = %f;    const elements = Array.from(document.querySelectorAll('body, body *'));    for (const el of elements) {      const rect = el.getBoundingClientRect();      const left = Math.round(leftOf + rect.left * density);      const top = Math.round(topOf + rect.top * density);      const width = Math.round(rect.width * density);      const height = Math.round(rect.height * density);      el.setAttribute('data-rect', `${left},${top},${width},${height}`);      const style = window.getComputedStyle(el);      const hidden = style.display === 'none' || style.visibility !== 'visible' || el.getAttribute('hidden') === 'true';      const disabled = el.disabled || el.getAttribute('aria-disabled') === 'true';      const focused = el === document.activeElement;      if (hidden || disabled || focused) {        el.setAttribute('data-flag', `${hidden ? 'H' : ''}${disabled ? 'D' : ''}${focused ? 'F' : ''}`);      } else {        el.removeAttribute('data-flag');      }    }    document.activeElement.setAttribute('focused', 'true');    const doc = document.cloneNode(true);    for (const el of Array.from(doc.querySelectorAll('script, link'))) {      el.remove();    }    for (const el of Array.from(doc.querySelectorAll('*'))) {      el.removeAttribute('class');    }    return doc.getElementsByTagName('body')[0].outerHTML.trim();  } catch (e) {    return 'Failed: ' + e;  }})();", Arrays.copyOf(new Object[]{Integer.valueOf(bVar.c()), Integer.valueOf(bVar.d()), Float.valueOf(displayMetrics.scaledDensity)}, 3));
        m.e(format, "java.lang.String.format(format, *args)");
        webView.evaluateJavascript(format, new c(this, bVar));
    }
}
