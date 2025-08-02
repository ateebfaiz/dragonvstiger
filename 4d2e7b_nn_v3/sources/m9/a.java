package m9;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.linecorp.linesdk.LineApiError;
import g9.b;
import i9.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import n9.d;

public class a {

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f12804e = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private final e f12805a;

    /* renamed from: b  reason: collision with root package name */
    private final d f12806b;

    /* renamed from: c  reason: collision with root package name */
    private int f12807c;

    /* renamed from: d  reason: collision with root package name */
    private int f12808d;

    public a(Context context, String str) {
        this(new e(context, str));
    }

    private static byte[] a(Map map) {
        if (map.isEmpty()) {
            return f12804e;
        }
        try {
            return d.c("", map).getEncodedQuery().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static c c(HttpURLConnection httpURLConnection, c cVar, c cVar2) {
        InputStream d10 = d(httpURLConnection);
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            return c.b(cVar.a(d10));
        }
        try {
            return c.a(i9.d.SERVER_ERROR, new LineApiError(responseCode, (String) cVar2.a(d10)));
        } catch (IOException e10) {
            return c.a(i9.d.INTERNAL_ERROR, new LineApiError(responseCode, (Exception) e10));
        }
    }

    private static InputStream d(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        if (httpURLConnection.getResponseCode() < 400) {
            inputStream = httpURLConnection.getInputStream();
        } else {
            inputStream = httpURLConnection.getErrorStream();
        }
        if (e(httpURLConnection)) {
            return new GZIPInputStream(inputStream);
        }
        return inputStream;
    }

    private static boolean e(HttpURLConnection httpURLConnection) {
        List list = httpURLConnection.getHeaderFields().get("Content-Encoding");
        if (list != null && !list.isEmpty()) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                if (((String) list.get(i10)).equalsIgnoreCase("gzip")) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void f(c cVar, Exception exc) {
    }

    private HttpURLConnection g(Uri uri) {
        HttpURLConnection h10 = h(uri);
        h10.setInstanceFollowRedirects(true);
        h10.setRequestProperty("User-Agent", this.f12805a.b());
        h10.setRequestProperty("Accept-Encoding", "gzip");
        h10.setConnectTimeout(this.f12807c);
        h10.setReadTimeout(this.f12808d);
        h10.setRequestMethod("GET");
        return h10;
    }

    private HttpURLConnection i(Uri uri, int i10) {
        HttpURLConnection h10 = h(uri);
        h10.setInstanceFollowRedirects(true);
        h10.setRequestProperty("User-Agent", this.f12805a.b());
        h10.setRequestProperty("Accept-Encoding", "gzip");
        h10.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        h10.setRequestProperty("Content-Length", String.valueOf(i10));
        h10.setConnectTimeout(this.f12807c);
        h10.setReadTimeout(this.f12808d);
        h10.setRequestMethod("POST");
        h10.setDoOutput(true);
        return h10;
    }

    private static void k(HttpURLConnection httpURLConnection, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public c b(Uri uri, Map map, Map map2, c cVar) {
        Uri b10 = d.b(uri, map2);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection g10 = g(b10);
            k(g10, map);
            g10.connect();
            c c10 = c(g10, cVar, this.f12806b);
            g10.disconnect();
            return c10;
        } catch (IOException e10) {
            c a10 = c.a(i9.d.NETWORK_ERROR, new LineApiError((Exception) e10));
            f(a10, e10);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return a10;
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection h(Uri uri) {
        URLConnection openConnection = new URL(uri.toString()).openConnection();
        if (!(openConnection instanceof HttpsURLConnection)) {
            throw new IllegalArgumentException("The scheme of the server url must be https." + uri);
        } else if (Build.VERSION.SDK_INT >= 24) {
            return (HttpURLConnection) openConnection;
        } else {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            httpsURLConnection.setSSLSocketFactory(new b(httpsURLConnection.getSSLSocketFactory()));
            return httpsURLConnection;
        }
    }

    public c j(Uri uri, Map map, Map map2, c cVar) {
        byte[] a10 = a(map2);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection i10 = i(uri, a10.length);
            k(i10, map);
            i10.connect();
            OutputStream outputStream = i10.getOutputStream();
            outputStream.write(a10);
            outputStream.flush();
            c c10 = c(i10, cVar, this.f12806b);
            i10.disconnect();
            return c10;
        } catch (IOException e10) {
            c a11 = c.a(i9.d.NETWORK_ERROR, new LineApiError((Exception) e10));
            f(a11, e10);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return a11;
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    protected a(e eVar) {
        this.f12805a = eVar;
        this.f12806b = new d("UTF-8");
        this.f12807c = 90000;
        this.f12808d = 90000;
    }
}
