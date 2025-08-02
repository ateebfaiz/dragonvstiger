package e;

import android.os.SystemClock;
import android.text.TextUtils;
import com.mah.sdk.OooO00o;
import e.i;
import e.j;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import q.f;
import w.d;

public abstract class k implements Runnable {
    public static final String X = d.f("");
    public static int Y = 0;
    public String C;

    /* renamed from: a  reason: collision with root package name */
    public final i.a f21093a;

    /* renamed from: b  reason: collision with root package name */
    public final d.k f21094b;

    /* renamed from: c  reason: collision with root package name */
    public a f21095c;

    /* renamed from: d  reason: collision with root package name */
    public int f21096d;

    /* renamed from: e  reason: collision with root package name */
    public String f21097e;

    /* renamed from: f  reason: collision with root package name */
    public final int f21098f;

    /* renamed from: g  reason: collision with root package name */
    public final f f21099g = f.f();

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f21100h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    public final m f21101i;

    /* renamed from: j  reason: collision with root package name */
    public int f21102j;

    /* renamed from: w  reason: collision with root package name */
    public int f21103w;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f21104a;

        /* renamed from: b  reason: collision with root package name */
        public final String f21105b;

        /* renamed from: c  reason: collision with root package name */
        public final String f21106c;

        public a(String str, b bVar, String str2) {
            this.f21105b = str;
            this.f21104a = bVar;
            this.f21106c = str2;
        }
    }

    public enum b {
        NONE,
        FINISH
    }

    public k(i.a aVar, d.k kVar, m mVar) {
        this.f21093a = aVar;
        this.f21094b = kVar;
        this.f21101i = mVar;
        int i10 = Y + 1;
        Y = i10;
        this.f21098f = i10;
        this.f21102j = 0;
    }

    public final j a(String str, String str2, JSONObject jSONObject) {
        try {
            j b10 = j.b(str, str2);
            j.a a10 = b10.a();
            if (a10 == j.a.NOT_FOUND) {
                f(3, c("No \"code\" found in response", new Object[0]));
            } else if (a10 == j.a.SUCCESS) {
                JSONObject e10 = b10.e();
                if (e10 != null) {
                    b10.f();
                    this.f21101i.a(e10);
                }
            } else if (a10 == j.a.DATA_NO_CHANGE) {
                b10.g(jSONObject);
                if (jSONObject != null) {
                    jSONObject.toString();
                }
            } else {
                int i10 = a10.f21092a;
                b10.h();
                if (a10 == j.a.PARAMETER_ERROR) {
                    f(4, c("Server response parameter error", new Object[0]));
                }
            }
            return b10;
        } catch (JSONException e11) {
            f(3, c("Auth json exception:%s", e11.getMessage()));
            return null;
        }
    }

    public abstract a b(String str, boolean z10);

    public String c(String str, Object... objArr) {
        int i10 = this.f21093a.f21076a;
        return "[" + this.C + "-" + this.f21094b.n().f13473e + "-" + this.f21098f + "-" + i10 + "-" + this.f21102j + "-" + this.f21103w + "]" + String.format(Locale.US, str, objArr);
    }

    public void d() {
        this.f21100h.compareAndSet(false, true);
    }

    public void e(int i10) {
        this.f21102j = i10;
    }

    public void f(int i10, String str) {
        this.f21096d = i10;
        this.f21097e = str;
    }

    public void g(a aVar) {
        this.f21095c = aVar;
    }

    public void h(String str) {
        this.C = str;
    }

    public final boolean i(j jVar) {
        int i10 = this.f21096d;
        if (i10 != 0) {
            this.f21099g.g(i10, this.f21097e);
            if (this.f21096d != 4) {
                return true;
            }
        }
        if (jVar == null) {
            return true;
        }
        j.a a10 = jVar.a();
        if (a10 == j.a.SUCCESS || a10 == j.a.DATA_NO_CHANGE) {
            if (jVar.e() == null) {
                return true;
            }
            this.f21095c.b(this, jVar);
            return false;
        } else if (a10 == j.a.UNKNOWN_SERVER_ERROR || a10 == j.a.SERVER_ERROR) {
            return true;
        } else {
            if (a10 != j.a.APPLICATION_NOT_REGISTERED && a10 != j.a.FINGERPRINT_ERROR && a10 != j.a.PARAMETER_ERROR) {
                return true;
            }
            this.f21095c.c(this, jVar);
            return false;
        }
    }

    public abstract long j();

    public int k() {
        return this.f21098f;
    }

    public boolean l() {
        return this.f21100h.get();
    }

    public void run() {
        j jVar;
        if (!l()) {
            this.f21103w = 0;
            JSONObject OooO00o = this.f21101i.OooO00o();
            String d10 = j.d(OooO00o);
            String str = i.f21059m;
            while (!l()) {
                f(0, "");
                a b10 = b(d10, false);
                if (!TextUtils.isEmpty(b10.f21105b)) {
                    jVar = a(b10.f21105b, b10.f21106c, OooO00o);
                } else {
                    jVar = null;
                }
                if (i(jVar)) {
                    int i10 = this.f21103w + 1;
                    this.f21103w = i10;
                    if (i10 <= OooO00o.OooO0o0()) {
                        SystemClock.sleep(1000);
                    } else {
                        this.f21095c.a(this, this.f21096d, this.f21097e);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }
}
