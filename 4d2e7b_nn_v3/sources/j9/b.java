package j9;

import android.text.TextUtils;
import com.linecorp.linesdk.LineAccessToken;
import com.linecorp.linesdk.LineApiError;
import com.linecorp.linesdk.api.a;
import i9.c;
import i9.d;
import k9.j;
import l9.e;
import l9.i;

public class b implements a {

    /* renamed from: e  reason: collision with root package name */
    private static final c f12441e = c.a(d.INTERNAL_ERROR, new LineApiError("access token is null"));

    /* renamed from: a  reason: collision with root package name */
    private final String f12442a;

    /* renamed from: b  reason: collision with root package name */
    private final e f12443b;

    /* renamed from: c  reason: collision with root package name */
    private final i f12444c;

    /* renamed from: d  reason: collision with root package name */
    private final k9.a f12445d;

    public b(String str, e eVar, i iVar, k9.a aVar) {
        this.f12442a = str;
        this.f12443b = eVar;
        this.f12444c = iVar;
        this.f12445d = aVar;
    }

    public c a() {
        String c10;
        k9.e f10 = this.f12445d.f();
        if (f10 == null || TextUtils.isEmpty(f10.d())) {
            return c.a(d.INTERNAL_ERROR, new LineApiError("access token or refresh token is not found."));
        }
        c f11 = this.f12443b.f(this.f12442a, f10);
        if (!f11.g()) {
            return c.a(f11.d(), f11.c());
        }
        j jVar = (j) f11.e();
        if (TextUtils.isEmpty(jVar.c())) {
            c10 = f10.d();
        } else {
            c10 = jVar.c();
        }
        k9.e eVar = new k9.e(jVar.a(), jVar.b(), System.currentTimeMillis(), c10);
        this.f12445d.g(eVar);
        return c.b(new LineAccessToken(eVar.a(), eVar.b(), eVar.c()));
    }
}
