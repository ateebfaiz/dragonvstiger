package x;

import OooO0o0.OooO0Oo;
import android.content.Context;
import android.os.Binder;
import com.mah.sdk.MahProxyAddress;
import d.b;
import f.a;

public class h {

    /* renamed from: d  reason: collision with root package name */
    public static h f24665d;

    /* renamed from: a  reason: collision with root package name */
    public final k f24666a;

    /* renamed from: b  reason: collision with root package name */
    public final f f24667b;

    /* renamed from: c  reason: collision with root package name */
    public final Binder f24668c = new a();

    public class a extends a.C0268a {
        public a() {
        }

        public void OooO00o() {
            h.this.f24667b.S(0);
        }

        public MahProxyAddress c(int i10) {
            return h.this.f24667b.h(b.a(i10));
        }

        public void d(f.b bVar) {
            h.this.f24666a.d(bVar);
        }

        public void e(f.b bVar) {
            h.this.f24666a.e(bVar);
        }

        public int x(OooO0Oo oooO0Oo) {
            return h.this.f24667b.y(oooO0Oo);
        }
    }

    public h(Context context) {
        j jVar = new j();
        this.f24666a = jVar;
        this.f24667b = new f(context, true, jVar);
    }

    public static h b(Context context) {
        if (f24665d == null) {
            f24665d = new h(context);
        }
        return f24665d;
    }

    public f.a a() {
        return a.C0268a.M(this.f24668c);
    }
}
