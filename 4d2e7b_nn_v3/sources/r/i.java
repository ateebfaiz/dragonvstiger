package r;

import android.content.Context;
import android.os.SystemClock;
import com.mah.ndk.MahxServer;
import com.mah.sdk.MahProxyAddress;
import com.mah.sdk.OooO00o;
import d.c;
import d.j;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import s.d;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public final c f23588a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f23589a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f23590b;

        public a(int i10, boolean z10) {
            this.f23589a = i10;
            this.f23590b = z10;
        }
    }

    public i(c cVar, Context context) {
        this.f23588a = cVar;
    }

    public int a(h hVar) {
        int i10;
        int i11 = 0;
        while (true) {
            a b10 = b(hVar, false);
            i10 = b10.f23589a;
            if (i10 == 200 || i10 == -1 || b10.f23590b || (i11 = i11 + 1) > OooO00o.OooO0o0()) {
                return i10;
            }
            String str = f.f23569h;
            SystemClock.sleep((long) 3000);
        }
        return i10;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r5 = r.f.f23569h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r2 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        r2.O();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0049 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final r.i.a b(r.h r5, boolean r6) {
        /*
            r4 = this;
            r0 = -1
            r1 = 0
            d.c r2 = r4.f23588a     // Catch:{ all -> 0x0048 }
            d.i r2 = r2.k()     // Catch:{ all -> 0x0048 }
            d.b r3 = d.b.ADDRESS_TYPE_PROXY_HANDSHAKE     // Catch:{ all -> 0x0048 }
            com.mah.sdk.MahProxyAddress r2 = r2.h(r3)     // Catch:{ all -> 0x0048 }
            boolean r3 = com.mah.sdk.OooO00o.OooO0O0((com.mah.sdk.MahProxyAddress) r2)     // Catch:{ all -> 0x0048 }
            if (r3 != 0) goto L_0x001c
            java.lang.String r5 = r.f.f23569h     // Catch:{ all -> 0x0048 }
            r.i$a r5 = new r.i$a     // Catch:{ all -> 0x0048 }
            r5.<init>(r0, r1)     // Catch:{ all -> 0x0048 }
            return r5
        L_0x001c:
            s.d r2 = r4.c(r2)     // Catch:{ all -> 0x0048 }
            r4.f(r2, r6)     // Catch:{ all -> 0x0049 }
            r4.e(r2, r5)     // Catch:{ all -> 0x0049 }
            r4.h(r2, r5)     // Catch:{ all -> 0x0049 }
            int r0 = r2.K()     // Catch:{ all -> 0x0049 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r0 != r5) goto L_0x0038
            r4.d(r2)     // Catch:{ all -> 0x0049 }
            r4.g(r2)     // Catch:{ all -> 0x0049 }
            goto L_0x004d
        L_0x0038:
            java.lang.String r5 = "0"
            java.lang.String r6 = "X-Mah-Rsp-Type"
            java.lang.String r6 = r2.H(r6)     // Catch:{ all -> 0x0049 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x004d
            r1 = 1
            goto L_0x004d
        L_0x0048:
            r2 = 0
        L_0x0049:
            java.lang.String r5 = r.f.f23569h     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0050
        L_0x004d:
            r2.O()
        L_0x0050:
            r.i$a r5 = new r.i$a
            r5.<init>(r0, r1)
            return r5
        L_0x0056:
            r5 = move-exception
            if (r2 == 0) goto L_0x005c
            r2.O()
        L_0x005c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: r.i.b(r.h, boolean):r.i$a");
    }

    public final d c(MahProxyAddress mahProxyAddress) {
        String h10 = this.f23588a.h();
        String str = f.f23569h;
        d OooO00o = OooO00o.OooO00o(h10, mahProxyAddress);
        OooO00o.w(5000);
        OooO00o.D(OooO00o.OooO0O0(120000));
        return OooO00o;
    }

    public final void d(d dVar) {
        if (w.d.j()) {
            String str = f.f23569h;
            dVar.d();
        }
    }

    public final void e(d dVar, h hVar) {
        if (w.d.j()) {
            for (Map.Entry next : dVar.Q().getRequestProperties().entrySet()) {
                String str = f.f23569h;
                next.getKey();
                ((List) next.getValue()).get(0);
            }
            for (Map.Entry entry : hVar.f23586g.entrySet()) {
                String str2 = f.f23569h;
                entry.getKey();
                entry.getValue();
            }
            String str3 = f.f23569h;
            int length = hVar.f23585f.length;
        }
    }

    public final void f(d dVar, boolean z10) {
        dVar.z("X-Mah-Sdk-Req", "true");
        if (z10) {
            dVar.z("X-Mah-Req-Type", "1008");
        }
    }

    public final void g(d dVar) {
        j l10 = this.f23588a.l();
        if (l10 != null) {
            l10.b(OooO00o.OooO0OO(dVar));
        }
    }

    public final void h(d dVar, h hVar) {
        dVar.J("type", MahxServer.OooO00o(hVar.f23580a));
        dVar.J("codec", hVar.f23581b);
        for (Map.Entry entry : hVar.f23586g.entrySet()) {
            dVar.J((String) entry.getKey(), (String) entry.getValue());
        }
        dVar.k(hVar.f23582c, hVar.f23584e, hVar.f23583d, new ByteArrayInputStream(hVar.f23585f));
    }
}
