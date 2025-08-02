package q5;

import android.net.Uri;
import com.facebook.w;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import q5.t;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23547a;

    /* renamed from: b  reason: collision with root package name */
    private static t f23548b;

    /* renamed from: c  reason: collision with root package name */
    public static final y f23549c = new y();

    private static final class a extends BufferedInputStream {

        /* renamed from: a  reason: collision with root package name */
        private HttpURLConnection f23550a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, 8192);
            m.f(httpURLConnection, "connection");
            this.f23550a = httpURLConnection;
        }

        public void close() {
            super.close();
            p0.q(this.f23550a);
        }
    }

    static {
        String simpleName = y.class.getSimpleName();
        m.e(simpleName, "ImageResponseCache::class.java.simpleName");
        f23547a = simpleName;
    }

    private y() {
    }

    public static final synchronized t a() {
        t tVar;
        synchronized (y.class) {
            try {
                if (f23548b == null) {
                    f23548b = new t(f23547a, new t.e());
                }
                tVar = f23548b;
                if (tVar == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tVar;
    }

    public static final InputStream b(Uri uri) {
        if (uri == null || !f23549c.d(uri)) {
            return null;
        }
        try {
            t a10 = a();
            String uri2 = uri.toString();
            m.e(uri2, "uri.toString()");
            return t.i(a10, uri2, (String) null, 2, (Object) null);
        } catch (IOException e10) {
            d0.f23283f.a(w.CACHE, 5, f23547a, e10.toString());
            return null;
        }
    }

    public static final InputStream c(HttpURLConnection httpURLConnection) {
        m.f(httpURLConnection, "connection");
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        Uri parse = Uri.parse(httpURLConnection.getURL().toString());
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
            if (!f23549c.d(parse)) {
                return inputStream;
            }
            t a10 = a();
            String uri = parse.toString();
            m.e(uri, "uri.toString()");
            return a10.j(uri, new a(inputStream, httpURLConnection));
        } catch (IOException unused) {
            return inputStream;
        }
    }

    private final boolean d(Uri uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (host != null && j.p(host, "fbcdn.net", false, 2, (Object) null)) {
                return true;
            }
            if (host == null || !j.F(host, "fbcdn", false, 2, (Object) null) || !j.p(host, "akamaihd.net", false, 2, (Object) null)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
