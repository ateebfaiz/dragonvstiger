package f2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import h2.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.text.h;
import kotlin.text.j;
import v5.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f21502a = new b();

    private b() {
    }

    public static final List a(View view) {
        Class<b> cls = b.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(view, "view");
            ArrayList arrayList = new ArrayList();
            ViewGroup j10 = f.j(view);
            if (j10 != null) {
                for (View view2 : f.b(j10)) {
                    if (view != view2) {
                        arrayList.addAll(f21502a.c(view2));
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|5|(1:7)|10|(1:12)|13|14|(2:16|(2:18|(1:20))(2:21|22))|23|24|(4:27|(2:31|39)|35|25)|36|32) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x007c */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008b A[Catch:{ all -> 0x0029 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List b(android.view.View r6) {
        /*
            java.lang.Class<f2.b> r0 = f2.b.class
            boolean r1 = v5.a.d(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.lang.String r1 = "view"
            kotlin.jvm.internal.m.f(r6, r1)     // Catch:{ all -> 0x0029 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0029 }
            r1.<init>()     // Catch:{ all -> 0x0029 }
            java.lang.String r3 = h2.f.i(r6)     // Catch:{ all -> 0x0029 }
            r1.add(r3)     // Catch:{ all -> 0x0029 }
            java.lang.Object r3 = r6.getTag()     // Catch:{ all -> 0x0029 }
            if (r3 == 0) goto L_0x002c
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0029 }
            r1.add(r3)     // Catch:{ all -> 0x0029 }
            goto L_0x002c
        L_0x0029:
            r6 = move-exception
            goto L_0x00ad
        L_0x002c:
            java.lang.CharSequence r3 = r6.getContentDescription()     // Catch:{ all -> 0x0029 }
            if (r3 == 0) goto L_0x0039
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0029 }
            r1.add(r3)     // Catch:{ all -> 0x0029 }
        L_0x0039:
            int r3 = r6.getId()     // Catch:{ NotFoundException -> 0x007c }
            r4 = -1
            if (r3 == r4) goto L_0x007c
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ NotFoundException -> 0x007c }
            int r6 = r6.getId()     // Catch:{ NotFoundException -> 0x007c }
            java.lang.String r6 = r3.getResourceName(r6)     // Catch:{ NotFoundException -> 0x007c }
            java.lang.String r3 = "resourceName"
            kotlin.jvm.internal.m.e(r6, r3)     // Catch:{ NotFoundException -> 0x007c }
            java.lang.String r3 = "/"
            kotlin.text.h r4 = new kotlin.text.h     // Catch:{ NotFoundException -> 0x007c }
            r4.<init>((java.lang.String) r3)     // Catch:{ NotFoundException -> 0x007c }
            r3 = 0
            java.util.List r6 = r4.e(r6, r3)     // Catch:{ NotFoundException -> 0x007c }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ NotFoundException -> 0x007c }
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ NotFoundException -> 0x007c }
            java.lang.Object[] r6 = r6.toArray(r3)     // Catch:{ NotFoundException -> 0x007c }
            if (r6 == 0) goto L_0x0074
            java.lang.String[] r6 = (java.lang.String[]) r6     // Catch:{ NotFoundException -> 0x007c }
            int r3 = r6.length     // Catch:{ NotFoundException -> 0x007c }
            r4 = 2
            if (r3 != r4) goto L_0x007c
            r3 = 1
            r6 = r6[r3]     // Catch:{ NotFoundException -> 0x007c }
            r1.add(r6)     // Catch:{ NotFoundException -> 0x007c }
            goto L_0x007c
        L_0x0074:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException     // Catch:{ NotFoundException -> 0x007c }
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Array<T>"
            r6.<init>(r3)     // Catch:{ NotFoundException -> 0x007c }
            throw r6     // Catch:{ NotFoundException -> 0x007c }
        L_0x007c:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0029 }
            r6.<init>()     // Catch:{ all -> 0x0029 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0029 }
        L_0x0085:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0029 }
            if (r3 == 0) goto L_0x00ac
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0029 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0029 }
            int r4 = r3.length()     // Catch:{ all -> 0x0029 }
            if (r4 <= 0) goto L_0x0085
            int r4 = r3.length()     // Catch:{ all -> 0x0029 }
            r5 = 100
            if (r4 > r5) goto L_0x0085
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x0029 }
            java.lang.String r4 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.m.e(r3, r4)     // Catch:{ all -> 0x0029 }
            r6.add(r3)     // Catch:{ all -> 0x0029 }
            goto L_0x0085
        L_0x00ac:
            return r6
        L_0x00ad:
            v5.a.b(r6, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.b.b(android.view.View):java.util.List");
    }

    private final List c(View view) {
        if (a.d(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof EditText) {
                return arrayList;
            }
            if (view instanceof TextView) {
                String obj = ((TextView) view).getText().toString();
                if (obj.length() > 0 && obj.length() < 100) {
                    String lowerCase = obj.toLowerCase();
                    m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                    arrayList.add(lowerCase);
                }
                return arrayList;
            }
            for (View c10 : f.b(view)) {
                arrayList.addAll(c(c10));
            }
            return arrayList;
        } catch (Throwable th) {
            a.b(th, this);
            return null;
        }
    }

    private final boolean d(String str, List list) {
        if (a.d(this)) {
            return false;
        }
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (j.K(str, (String) it.next(), false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            a.b(th, this);
            return false;
        }
    }

    public static final boolean e(List list, List list2) {
        Class<b> cls = b.class;
        if (a.d(cls)) {
            return false;
        }
        try {
            m.f(list, "indicators");
            m.f(list2, "keys");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (f21502a.d((String) it.next(), list2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            a.b(th, cls);
            return false;
        }
    }

    public static final boolean f(String str, String str2) {
        Class<b> cls = b.class;
        if (a.d(cls)) {
            return false;
        }
        try {
            m.f(str, "text");
            m.f(str2, "rule");
            return new h(str2).c(str);
        } catch (Throwable th) {
            a.b(th, cls);
            return false;
        }
    }
}
