package t1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.pdns.DNSResolver;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f24067c;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentLinkedQueue f24068a = new ConcurrentLinkedQueue();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentLinkedQueue f24069b = new ConcurrentLinkedQueue();

    public static a b() {
        if (f24067c == null) {
            synchronized (a.class) {
                f24067c = new a();
            }
        }
        return f24067c;
    }

    public void a(Context context, int i10, Bundle bundle) {
        Iterator it = this.f24068a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.j(i10)) {
                bVar.a(context, i10, bundle);
            }
        }
    }

    public void c(Context context, int i10, String str, int i11, Bundle bundle) {
        Iterator it = this.f24068a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (Arrays.asList(bVar.f()).contains(str) && bVar.j(i11)) {
                if (i10 == 0) {
                    bVar.h(context, i11, bundle);
                }
                if (i10 == 1) {
                    bVar.g(context, i11, bundle);
                }
            }
        }
    }

    public void d(Context context, b bVar) {
        if (!this.f24068a.contains(bVar)) {
            String canonicalName = bVar.getClass().getCanonicalName();
            if (!this.f24069b.contains(canonicalName)) {
                s1.a.a("MTObservable", "observer " + canonicalName);
                this.f24068a.add(bVar);
                this.f24069b.add(canonicalName);
                Bundle bundle = new Bundle();
                bundle.putString("observer_name", canonicalName);
                if (p1.a.z(context)) {
                    boolean p10 = p1.a.p();
                    String k10 = p1.a.k();
                    if (!TextUtils.isEmpty(k10)) {
                        bundle.putBoolean("state", p10);
                        bundle.putString("activity", k10);
                        if (bVar.j(1005) || bVar.j(1006)) {
                            bVar.a(context, 1005, (Bundle) null);
                        }
                    }
                    boolean u10 = p1.a.u();
                    int v10 = p1.a.v();
                    String s10 = p1.a.s();
                    String t10 = p1.a.t();
                    if (!TextUtils.isEmpty(t10)) {
                        bundle.putBoolean("state", u10);
                        bundle.putInt("type", v10);
                        bundle.putString("name", s10);
                        bundle.putString("radio", t10);
                        int i10 = 1003;
                        if (bVar.j(1003) || bVar.j(1004)) {
                            if (!u10) {
                                i10 = 1004;
                            }
                            bVar.a(context, i10, (Bundle) null);
                        }
                    }
                }
                i1.a.b().j(context, DNSResolver.GOBACK_LOCAL, bundle);
            }
        }
    }

    public void e(Context context, Bundle bundle) {
        try {
            String string = bundle.getString("observer_name");
            if (!this.f24069b.contains(string)) {
                Object newInstance = Class.forName(string).newInstance();
                if (newInstance instanceof b) {
                    b bVar = (b) newInstance;
                    d(context, bVar);
                    boolean z10 = bundle.getBoolean("state");
                    String string2 = bundle.getString("activity");
                    if (!TextUtils.isEmpty(string2)) {
                        p1.a.E(z10);
                        p1.a.C(string2);
                        int i10 = 1995;
                        if (!bVar.j(1995)) {
                            if (bVar.j(1994)) {
                            }
                        }
                        if (!z10) {
                            i10 = 1994;
                        }
                        bVar.a(context, i10, (Bundle) null);
                    }
                    boolean z11 = bundle.getBoolean("state");
                    int i11 = bundle.getInt("type");
                    String string3 = bundle.getString("name");
                    String string4 = bundle.getString("radio");
                    if (!TextUtils.isEmpty(string4)) {
                        p1.a.H(z11);
                        p1.a.I(i11);
                        p1.a.F(string3);
                        p1.a.G(string4);
                        int i12 = 1997;
                        if (bVar.j(1997) || bVar.j(1996)) {
                            if (!z10) {
                                i12 = 1996;
                            }
                            bVar.a(context, i12, (Bundle) null);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            s1.a.h("MTObservable", "observer failed " + th.getMessage());
        }
    }
}
