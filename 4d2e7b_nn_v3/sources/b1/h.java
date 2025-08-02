package b1;

import a1.g;
import a1.n;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class h extends a {

    /* renamed from: a  reason: collision with root package name */
    private final SSLSocketFactory f17155a;

    public interface a {
    }

    public h() {
        this((a) null);
    }

    private static void b(HttpURLConnection httpURLConnection, n nVar, byte[] bArr) {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.addRequestProperty("Content-Type", nVar.i());
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    private static void c(HttpURLConnection httpURLConnection, n nVar) {
        byte[] h10 = nVar.h();
        if (h10 != null) {
            b(httpURLConnection, nVar, h10);
        }
    }

    static List d(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String gVar : (List) entry.getValue()) {
                    arrayList.add(new g((String) entry.getKey(), gVar));
                }
            }
        }
        return arrayList;
    }

    private static boolean f(int i10, int i11) {
        if (i10 == 4 || ((100 <= i11 && i11 < 200) || i11 == 204 || i11 == 304)) {
            return false;
        }
        return true;
    }

    private static InputStream g(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private HttpURLConnection h(URL url, n nVar) {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection e10 = e(url);
        int q10 = nVar.q();
        e10.setConnectTimeout(q10);
        e10.setReadTimeout(q10);
        e10.setUseCaches(false);
        e10.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f17155a) != null) {
            ((HttpsURLConnection) e10).setSSLSocketFactory(sSLSocketFactory);
        }
        return e10;
    }

    static void i(HttpURLConnection httpURLConnection, n nVar) {
        switch (nVar.m()) {
            case -1:
                byte[] n10 = nVar.n();
                if (n10 != null) {
                    httpURLConnection.setRequestMethod("POST");
                    b(httpURLConnection, nVar, n10);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                c(httpURLConnection, nVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                c(httpURLConnection, nVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                c(httpURLConnection, nVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    public f a(n nVar, Map map) {
        String s10 = nVar.s();
        HashMap hashMap = new HashMap();
        hashMap.putAll(nVar.l());
        hashMap.putAll(map);
        HttpURLConnection h10 = h(new URL(s10), nVar);
        for (String str : hashMap.keySet()) {
            h10.addRequestProperty(str, (String) hashMap.get(str));
        }
        i(h10, nVar);
        int responseCode = h10.getResponseCode();
        if (responseCode == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        } else if (!f(nVar.m(), responseCode)) {
            return new f(responseCode, d(h10.getHeaderFields()));
        } else {
            return new f(responseCode, d(h10.getHeaderFields()), h10.getContentLength(), g(h10));
        }
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection e(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    public h(a aVar) {
        this(aVar, (SSLSocketFactory) null);
    }

    public h(a aVar, SSLSocketFactory sSLSocketFactory) {
        this.f17155a = sSLSocketFactory;
    }
}
