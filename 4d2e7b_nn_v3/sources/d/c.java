package d;

import android.content.Context;
import android.text.TextUtils;
import i.e;
import java.util.concurrent.atomic.AtomicReference;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f20990a;

    /* renamed from: b  reason: collision with root package name */
    public final String f20991b;

    /* renamed from: c  reason: collision with root package name */
    public final e f20992c;

    /* renamed from: d  reason: collision with root package name */
    public final g f20993d;

    /* renamed from: e  reason: collision with root package name */
    public final e f20994e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference f20995f = new AtomicReference();

    /* renamed from: g  reason: collision with root package name */
    public String f20996g;

    /* renamed from: h  reason: collision with root package name */
    public i f20997h;

    /* renamed from: i  reason: collision with root package name */
    public j f20998i;

    public c(Context context, String str, String str2, e eVar) {
        this.f20991b = str;
        this.f20990a = str2;
        this.f20992c = eVar;
        e eVar2 = new e(context);
        this.f20994e = eVar2;
        this.f20993d = new g(context, str2, str, eVar2.b());
        g(eVar2.c());
    }

    public e a() {
        return this.f20994e;
    }

    public String b() {
        return this.f20996g;
    }

    public void c(i iVar) {
        this.f20997h = iVar;
    }

    public void d(j jVar) {
        this.f20998i = jVar;
    }

    public void e(String str) {
        this.f20996g = str;
    }

    public e f() {
        return this.f20992c;
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "https://rep.relrzreport.com/sce/upload";
        }
        this.f20995f.set(i(str));
    }

    public String h() {
        return (String) this.f20995f.get();
    }

    public final String i(String str) {
        if (str.startsWith(com.alibaba.pdns.s.e.c.f18246k)) {
            return str.replace(com.alibaba.pdns.s.e.c.f18246k, com.alibaba.pdns.s.e.c.f18247l);
        }
        return str;
    }

    public g j() {
        return this.f20993d;
    }

    public i k() {
        return this.f20997h;
    }

    public j l() {
        return this.f20998i;
    }
}
