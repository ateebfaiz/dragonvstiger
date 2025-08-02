package q5;

import android.net.Uri;
import com.facebook.w;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;
import kotlin.text.d;
import q5.d0;
import q5.t;

public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23365a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f23366b;

    /* renamed from: c  reason: collision with root package name */
    private static t f23367c;

    /* renamed from: d  reason: collision with root package name */
    public static final k0 f23368d = new k0();

    static {
        String b10 = z.b(k0.class).b();
        if (b10 == null) {
            b10 = "UrlRedirectCache";
        }
        f23365a = b10;
        f23366b = b10 + "_Redirect";
    }

    private k0() {
    }

    public static final void a(Uri uri, Uri uri2) {
        if (uri != null && uri2 != null) {
            OutputStream outputStream = null;
            try {
                t b10 = b();
                String uri3 = uri.toString();
                m.e(uri3, "fromUri.toString()");
                outputStream = b10.l(uri3, f23366b);
                String uri4 = uri2.toString();
                m.e(uri4, "toUri.toString()");
                Charset charset = d.f797b;
                if (uri4 != null) {
                    byte[] bytes = uri4.getBytes(charset);
                    m.e(bytes, "(this as java.lang.String).getBytes(charset)");
                    outputStream.write(bytes);
                    p0.i(outputStream);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (IOException e10) {
                d0.a aVar = d0.f23283f;
                w wVar = w.CACHE;
                String str = f23365a;
                aVar.a(wVar, 4, str, "IOException when accessing cache: " + e10.getMessage());
            } catch (Throwable th) {
                p0.i(outputStream);
                throw th;
            }
        }
    }

    public static final synchronized t b() {
        t tVar;
        synchronized (k0.class) {
            tVar = f23367c;
            if (tVar == null) {
                tVar = new t(f23365a, new t.e());
            }
            f23367c = tVar;
        }
        return tVar;
    }

    public static final Uri c(Uri uri) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3 = null;
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        m.e(uri2, "uri.toString()");
        HashSet hashSet = new HashSet();
        hashSet.add(uri2);
        try {
            t b10 = b();
            InputStream h10 = b10.h(uri2, f23366b);
            inputStreamReader = null;
            boolean z10 = false;
            while (true) {
                if (h10 == null) {
                    break;
                }
                try {
                    inputStreamReader2 = new InputStreamReader(h10);
                } catch (IOException e10) {
                    e = e10;
                    try {
                        d0.f23283f.a(w.CACHE, 4, f23365a, "IOException when accessing cache: " + e.getMessage());
                        p0.i(inputStreamReader);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader3 = inputStreamReader;
                    }
                }
                try {
                    char[] cArr = new char[128];
                    StringBuilder sb2 = new StringBuilder();
                    for (int read = inputStreamReader2.read(cArr, 0, 128); read > 0; read = inputStreamReader2.read(cArr, 0, 128)) {
                        sb2.append(cArr, 0, read);
                    }
                    p0.i(inputStreamReader2);
                    String sb3 = sb2.toString();
                    m.e(sb3, "urlBuilder.toString()");
                    if (!hashSet.contains(sb3)) {
                        hashSet.add(sb3);
                        inputStreamReader = inputStreamReader2;
                        z10 = true;
                        String str = sb3;
                        h10 = b10.h(sb3, f23366b);
                        uri2 = str;
                    } else if (m.b(sb3, uri2)) {
                        inputStreamReader = inputStreamReader2;
                        z10 = true;
                    } else {
                        d0.f23283f.a(w.CACHE, 6, f23365a, "A loop detected in UrlRedirectCache");
                        p0.i(inputStreamReader2);
                        return null;
                    }
                } catch (IOException e11) {
                    e = e11;
                    inputStreamReader = inputStreamReader2;
                    d0.f23283f.a(w.CACHE, 4, f23365a, "IOException when accessing cache: " + e.getMessage());
                    p0.i(inputStreamReader);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader3 = inputStreamReader2;
                    p0.i(inputStreamReader3);
                    throw th;
                }
            }
            if (z10) {
                Uri parse = Uri.parse(uri2);
                p0.i(inputStreamReader);
                return parse;
            }
        } catch (IOException e12) {
            e = e12;
            inputStreamReader = null;
            d0.f23283f.a(w.CACHE, 4, f23365a, "IOException when accessing cache: " + e.getMessage());
            p0.i(inputStreamReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            p0.i(inputStreamReader3);
            throw th;
        }
        p0.i(inputStreamReader);
        return null;
    }
}
