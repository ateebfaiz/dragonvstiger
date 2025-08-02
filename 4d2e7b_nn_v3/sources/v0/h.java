package v0;

import android.content.Context;
import android.util.Pair;
import com.airbnb.lottie.j;
import com.airbnb.lottie.s0;
import com.airbnb.lottie.t;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;
import y0.f;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final g f24384a;

    /* renamed from: b  reason: collision with root package name */
    private final f f24385b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24386a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                v0.c[] r0 = v0.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24386a = r0
                v0.c r1 = v0.c.ZIP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24386a     // Catch:{ NoSuchFieldError -> 0x001d }
                v0.c r1 = v0.c.GZIP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: v0.h.a.<clinit>():void");
        }
    }

    public h(g gVar, f fVar) {
        this.f24384a = gVar;
        this.f24385b = fVar;
    }

    private j a(Context context, String str, String str2) {
        g gVar;
        Pair a10;
        s0 s0Var;
        if (str2 == null || (gVar = this.f24384a) == null || (a10 = gVar.a(str)) == null) {
            return null;
        }
        InputStream inputStream = (InputStream) a10.second;
        int i10 = a.f24386a[((c) a10.first).ordinal()];
        if (i10 == 1) {
            s0Var = t.E(context, new ZipInputStream(inputStream), str2);
        } else if (i10 != 2) {
            s0Var = t.q(inputStream, str2);
        } else {
            try {
                s0Var = t.q(new GZIPInputStream(inputStream), str2);
            } catch (IOException e10) {
                s0Var = new s0((Throwable) e10);
            }
        }
        if (s0Var.b() != null) {
            return (j) s0Var.b();
        }
        return null;
    }

    private s0 b(Context context, String str, String str2) {
        boolean z10;
        f.a("Fetching " + str);
        d dVar = null;
        try {
            dVar = this.f24385b.a(str);
            if (dVar.isSuccessful()) {
                s0 e10 = e(context, str, dVar.t(), dVar.q(), str2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Completed fetch from network. Success: ");
                if (e10.b() != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                sb2.append(z10);
                f.a(sb2.toString());
                try {
                    dVar.close();
                } catch (IOException e11) {
                    f.d("LottieFetchResult close failed ", e11);
                }
                return e10;
            }
            s0 s0Var = new s0((Throwable) new IllegalArgumentException(dVar.r()));
            try {
                dVar.close();
            } catch (IOException e12) {
                f.d("LottieFetchResult close failed ", e12);
            }
            return s0Var;
        } catch (Exception e13) {
            s0 s0Var2 = new s0((Throwable) e13);
            if (dVar != null) {
                try {
                    dVar.close();
                } catch (IOException e14) {
                    f.d("LottieFetchResult close failed ", e14);
                }
            }
            return s0Var2;
        } catch (Throwable th) {
            if (dVar != null) {
                try {
                    dVar.close();
                } catch (IOException e15) {
                    f.d("LottieFetchResult close failed ", e15);
                }
            }
            throw th;
        }
    }

    private s0 d(String str, InputStream inputStream, String str2) {
        g gVar;
        if (str2 == null || (gVar = this.f24384a) == null) {
            return t.q(new GZIPInputStream(inputStream), (String) null);
        }
        return t.q(new GZIPInputStream(new FileInputStream(gVar.g(str, inputStream, c.GZIP))), str);
    }

    private s0 e(Context context, String str, InputStream inputStream, String str2, String str3) {
        s0 s0Var;
        c cVar;
        g gVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            f.a("Handling zip response.");
            c cVar2 = c.ZIP;
            s0Var = g(context, str, inputStream, str3);
            cVar = cVar2;
        } else if (str2.contains("application/gzip") || str2.contains("application/x-gzip") || str.split("\\?")[0].endsWith(".tgs")) {
            f.a("Handling gzip response.");
            cVar = c.GZIP;
            s0Var = d(str, inputStream, str3);
        } else {
            f.a("Received json response.");
            cVar = c.JSON;
            s0Var = f(str, inputStream, str3);
        }
        if (!(str3 == null || s0Var.b() == null || (gVar = this.f24384a) == null)) {
            gVar.f(str, cVar);
        }
        return s0Var;
    }

    private s0 f(String str, InputStream inputStream, String str2) {
        g gVar;
        if (str2 == null || (gVar = this.f24384a) == null) {
            return t.q(inputStream, (String) null);
        }
        return t.q(new FileInputStream(gVar.g(str, inputStream, c.JSON).getAbsolutePath()), str);
    }

    private s0 g(Context context, String str, InputStream inputStream, String str2) {
        g gVar;
        if (str2 == null || (gVar = this.f24384a) == null) {
            return t.E(context, new ZipInputStream(inputStream), (String) null);
        }
        return t.E(context, new ZipInputStream(new FileInputStream(gVar.g(str, inputStream, c.ZIP))), str);
    }

    public s0 c(Context context, String str, String str2) {
        j a10 = a(context, str, str2);
        if (a10 != null) {
            return new s0((Object) a10);
        }
        f.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(context, str, str2);
    }
}
