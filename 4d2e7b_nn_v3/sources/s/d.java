package s;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class d {

    /* renamed from: n  reason: collision with root package name */
    public static c f23698n = c.f23717a;

    /* renamed from: a  reason: collision with root package name */
    public final URL f23699a;

    /* renamed from: b  reason: collision with root package name */
    public final String f23700b;

    /* renamed from: c  reason: collision with root package name */
    public HttpURLConnection f23701c = null;

    /* renamed from: d  reason: collision with root package name */
    public f f23702d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23703e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23704f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23705g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f23706h = 8192;

    /* renamed from: i  reason: collision with root package name */
    public long f23707i = -1;

    /* renamed from: j  reason: collision with root package name */
    public long f23708j = 0;

    /* renamed from: k  reason: collision with root package name */
    public String f23709k;

    /* renamed from: l  reason: collision with root package name */
    public int f23710l;

    /* renamed from: m  reason: collision with root package name */
    public g f23711m = g.f23719a;

    public class a extends b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InputStream f23712c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ OutputStream f23713d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Closeable closeable, boolean z10, InputStream inputStream, OutputStream outputStream) {
            super(closeable, z10);
            this.f23712c = inputStream;
            this.f23713d = outputStream;
        }

        /* renamed from: c */
        public d b() {
            byte[] bArr = new byte[d.this.f23706h];
            while (true) {
                int read = this.f23712c.read(bArr);
                if (read == -1) {
                    return d.this;
                }
                this.f23713d.write(bArr, 0, read);
                d dVar = d.this;
                long j10 = dVar.f23708j + ((long) read);
                dVar.f23708j = j10;
                dVar.f23711m.a(j10, dVar.f23707i);
            }
        }
    }

    public static abstract class b extends e {

        /* renamed from: a  reason: collision with root package name */
        public final Closeable f23715a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f23716b;

        public b(Closeable closeable, boolean z10) {
            this.f23715a = closeable;
            this.f23716b = z10;
        }

        public void a() {
            Closeable closeable = this.f23715a;
            if (closeable instanceof Flushable) {
                ((Flushable) closeable).flush();
            }
            if (this.f23716b) {
                try {
                    this.f23715a.close();
                } catch (IOException unused) {
                }
            } else {
                this.f23715a.close();
            }
        }
    }

    public interface c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f23717a = new a();

        public class a implements c {
            public HttpURLConnection a(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }

            public HttpURLConnection b(URL url) {
                return (HttpURLConnection) url.openConnection();
            }
        }

        HttpURLConnection a(URL url, Proxy proxy);

        HttpURLConnection b(URL url);
    }

    /* renamed from: s.d$d  reason: collision with other inner class name */
    public static class C0329d extends RuntimeException {
        public C0329d(IOException iOException) {
            super(iOException);
        }

        /* renamed from: a */
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    public static abstract class e implements Callable {
        public abstract void a();

        public abstract Object b();

        public Object call() {
            Throwable th;
            boolean z10;
            Throwable th2;
            boolean z11 = true;
            try {
                Object b10 = b();
                try {
                    a();
                    return b10;
                } catch (IOException e10) {
                    throw new C0329d(e10);
                }
            } catch (C0329d e11) {
                throw e11;
            } catch (IOException e12) {
                throw new C0329d(e12);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                z10 = true;
                th2 = th4;
            }
            boolean z12 = z10;
            th = th2;
            z11 = z12;
            a();
            throw th;
        }
    }

    public static class f extends BufferedOutputStream {

        /* renamed from: a  reason: collision with root package name */
        public final CharsetEncoder f23718a;

        public f(OutputStream outputStream, String str, int i10) {
            super(outputStream, i10);
            this.f23718a = Charset.forName(d.B(str)).newEncoder();
        }

        public f a(String str) {
            ByteBuffer encode = this.f23718a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    public interface g {

        /* renamed from: a  reason: collision with root package name */
        public static final g f23719a = new a();

        public class a implements g {
            public void a(long j10, long j11) {
            }
        }

        void a(long j10, long j11);
    }

    public d(CharSequence charSequence, String str) {
        try {
            this.f23699a = new URL(charSequence.toString());
            this.f23700b = str;
        } catch (MalformedURLException e10) {
            throw new C0329d(e10);
        }
    }

    public static String B(String str) {
        if (str == null || str.length() <= 0) {
            return "UTF-8";
        }
        return str;
    }

    public static d s(CharSequence charSequence) {
        return new d(charSequence, "POST");
    }

    public String A() {
        return C("Content-Type", "charset");
    }

    public String C(String str, String str2) {
        return r(H(str), str2);
    }

    public d D(int i10) {
        Q().setReadTimeout(i10);
        return this;
    }

    public int E(String str) {
        return b(str, -1);
    }

    public d F() {
        try {
            return I();
        } catch (IOException e10) {
            throw new C0329d(e10);
        }
    }

    public d G(String str, String str2) {
        return x(str).x(": ").x(str2).x("\r\n");
    }

    public String H(String str) {
        F();
        return Q().getHeaderField(str);
    }

    public d I() {
        n((g) null);
        f fVar = this.f23702d;
        if (fVar == null) {
            return this;
        }
        if (this.f23703e) {
            fVar.a("\r\n--00content0boundary00--\r\n");
        }
        if (this.f23704f) {
            try {
                this.f23702d.close();
            } catch (IOException unused) {
            }
        } else {
            this.f23702d.close();
        }
        this.f23702d = null;
        return this;
    }

    public d J(String str, String str2) {
        return j(str, (String) null, str2);
    }

    public int K() {
        try {
            I();
            return Q().getResponseCode();
        } catch (IOException e10) {
            throw new C0329d(e10);
        }
    }

    public String L() {
        return H("Content-Encoding");
    }

    public final HttpURLConnection M() {
        HttpURLConnection httpURLConnection;
        try {
            if (this.f23709k != null) {
                httpURLConnection = f23698n.a(this.f23699a, N());
            } else {
                httpURLConnection = f23698n.b(this.f23699a);
            }
            httpURLConnection.setRequestMethod(this.f23700b);
            return httpURLConnection;
        } catch (IOException e10) {
            throw new C0329d(e10);
        }
    }

    public final Proxy N() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f23709k, this.f23710l));
    }

    public d O() {
        Q().disconnect();
        return this;
    }

    public String P() {
        return Q().getRequestMethod();
    }

    public HttpURLConnection Q() {
        if (this.f23701c == null) {
            this.f23701c = M();
        }
        return this.f23701c;
    }

    public d R() {
        if (this.f23702d != null) {
            return this;
        }
        Q().setDoOutput(true);
        this.f23702d = new f(Q().getOutputStream(), r(Q().getRequestProperty("Content-Type"), "charset"), this.f23706h);
        return this;
    }

    public InputStream S() {
        InputStream inputStream;
        if (K() < 400) {
            try {
                inputStream = Q().getInputStream();
            } catch (IOException e10) {
                throw new C0329d(e10);
            }
        } else {
            inputStream = Q().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = Q().getInputStream();
                } catch (IOException e11) {
                    if (a() <= 0) {
                        inputStream = new ByteArrayInputStream(new byte[0]);
                    } else {
                        throw new C0329d(e11);
                    }
                }
            }
        }
        if (!this.f23705g || !"gzip".equals(L())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e12) {
            throw new C0329d(e12);
        }
    }

    public d T() {
        if (!this.f23703e) {
            this.f23703e = true;
            y("multipart/form-data; boundary=00content0boundary00").R();
            this.f23702d.a("--00content0boundary00\r\n");
        } else {
            this.f23702d.a("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    public URL U() {
        return Q().getURL();
    }

    public int a() {
        return E("Content-Length");
    }

    public int b(String str, int i10) {
        F();
        return Q().getHeaderFieldInt(str, i10);
    }

    public String d() {
        return q(A());
    }

    public final d f(long j10) {
        if (this.f23707i == -1) {
            this.f23707i = 0;
        }
        this.f23707i += j10;
        return this;
    }

    public d g(InputStream inputStream) {
        try {
            R();
            h(inputStream, this.f23702d);
            return this;
        } catch (IOException e10) {
            throw new C0329d(e10);
        }
    }

    public d h(InputStream inputStream, OutputStream outputStream) {
        return (d) new a(inputStream, this.f23704f, inputStream, outputStream).call();
    }

    public d i(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return z("Content-Type", str);
        }
        return z("Content-Type", str + "; charset=" + str2);
    }

    public d j(String str, String str2, String str3) {
        return l(str, str2, (String) null, str3);
    }

    public d k(String str, String str2, String str3, InputStream inputStream) {
        try {
            T();
            u(str, str2, str3);
            h(inputStream, this.f23702d);
            return this;
        } catch (IOException e10) {
            throw new C0329d(e10);
        }
    }

    public d l(String str, String str2, String str3, String str4) {
        try {
            T();
            u(str, str2, str3);
            this.f23702d.a(str4);
            return this;
        } catch (IOException e10) {
            throw new C0329d(e10);
        }
    }

    public d m(SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        HttpURLConnection Q = Q();
        if (Q instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) Q;
            httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
        }
        return this;
    }

    public d n(g gVar) {
        if (gVar == null) {
            this.f23711m = g.f23719a;
        } else {
            this.f23711m = gVar;
        }
        return this;
    }

    public d o(byte[] bArr) {
        if (bArr != null) {
            f((long) bArr.length);
        }
        return g(new ByteArrayInputStream(bArr));
    }

    public BufferedInputStream p() {
        return new BufferedInputStream(S(), this.f23706h);
    }

    public String q(String str) {
        ByteArrayOutputStream v10 = v();
        try {
            h(p(), v10);
            return v10.toString(B(str));
        } catch (IOException e10) {
            throw new C0329d(e10);
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070 A[EDGE_INSN: B:30:0x0070->B:29:0x0070 ?: BREAK  , SYNTHETIC] */
    public java.lang.String r(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0070
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000a
            goto L_0x0070
        L_0x000a:
            int r1 = r9.length()
            r2 = 59
            int r3 = r9.indexOf(r2)
            r4 = 1
            int r3 = r3 + r4
            if (r3 == 0) goto L_0x0070
            if (r3 != r1) goto L_0x001b
            goto L_0x0070
        L_0x001b:
            int r5 = r9.indexOf(r2, r3)
            r6 = -1
            if (r5 != r6) goto L_0x0023
            goto L_0x006e
        L_0x0023:
            if (r3 >= r5) goto L_0x0070
            r7 = 61
            int r7 = r9.indexOf(r7, r3)
            if (r7 == r6) goto L_0x0066
            if (r7 >= r5) goto L_0x0066
            java.lang.String r3 = r9.substring(r3, r7)
            java.lang.String r3 = r3.trim()
            boolean r3 = r10.equals(r3)
            if (r3 == 0) goto L_0x0066
            int r7 = r7 + 1
            java.lang.String r3 = r9.substring(r7, r5)
            java.lang.String r3 = r3.trim()
            int r7 = r3.length()
            if (r7 == 0) goto L_0x0066
            r9 = 2
            if (r7 <= r9) goto L_0x0065
            r9 = 0
            char r9 = r3.charAt(r9)
            r10 = 34
            if (r10 != r9) goto L_0x0065
            int r7 = r7 - r4
            char r9 = r3.charAt(r7)
            if (r10 != r9) goto L_0x0065
            java.lang.String r9 = r3.substring(r4, r7)
            return r9
        L_0x0065:
            return r3
        L_0x0066:
            int r3 = r5 + 1
            int r5 = r9.indexOf(r2, r3)
            if (r5 != r6) goto L_0x0023
        L_0x006e:
            r5 = r1
            goto L_0x0023
        L_0x0070:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s.d.r(java.lang.String, java.lang.String):java.lang.String");
    }

    public d t(String str, int i10) {
        if (this.f23701c == null) {
            this.f23709k = str;
            this.f23710l = i10;
            return this;
        }
        throw new IllegalStateException("The connection has already been created. This method must be called before reading or writing to the request.");
    }

    public String toString() {
        return P() + ' ' + U();
    }

    public d u(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder("form-data; name=\"");
        sb2.append(str);
        if (str2 != null) {
            sb2.append("\"; filename=\"");
            sb2.append(str2);
        }
        sb2.append('\"');
        G("Content-Disposition", sb2.toString());
        if (str3 != null) {
            G("Content-Type", str3);
        }
        return x("\r\n");
    }

    public ByteArrayOutputStream v() {
        int a10 = a();
        if (a10 > 0) {
            return new ByteArrayOutputStream(a10);
        }
        return new ByteArrayOutputStream();
    }

    public d w(int i10) {
        Q().setConnectTimeout(i10);
        return this;
    }

    public d x(CharSequence charSequence) {
        try {
            R();
            this.f23702d.a(charSequence.toString());
            return this;
        } catch (IOException e10) {
            throw new C0329d(e10);
        }
    }

    public d y(String str) {
        return i(str, (String) null);
    }

    public d z(String str, String str2) {
        Q().setRequestProperty(str, str2);
        return this;
    }
}
