package z5;

import android.util.Base64;
import android.util.Log;
import io.jsonwebtoken.JwsHeader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.text.d;
import kotlin.text.j;
import org.json.JSONObject;
import tb.o;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f25251a = "/.well-known/oauth/openid/keys/";

    /* renamed from: b  reason: collision with root package name */
    public static final b f25252b = new b();

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ URL f25253a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y f25254b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25255c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ReentrantLock f25256d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Condition f25257e;

        a(URL url, y yVar, String str, ReentrantLock reentrantLock, Condition condition) {
            this.f25253a = url;
            this.f25254b = yVar;
            this.f25255c = str;
            this.f25256d = reentrantLock;
            this.f25257e = condition;
        }

        public final void run() {
            HttpURLConnection httpURLConnection;
            ReentrantLock reentrantLock;
            ReentrantLock reentrantLock2;
            BufferedReader bufferedReader;
            if (!v5.a.d(this)) {
                try {
                    URLConnection openConnection = this.f25253a.openConnection();
                    if (openConnection != null) {
                        httpURLConnection = (HttpURLConnection) openConnection;
                        try {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            m.e(inputStream, "connection.inputStream");
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, d.f797b);
                            if (inputStreamReader instanceof BufferedReader) {
                                bufferedReader = (BufferedReader) inputStreamReader;
                            } else {
                                bufferedReader = new BufferedReader(inputStreamReader, 8192);
                            }
                            String f10 = o.f(bufferedReader);
                            httpURLConnection.getInputStream().close();
                            this.f25254b.f725a = new JSONObject(f10).optString(this.f25255c);
                            httpURLConnection.disconnect();
                            reentrantLock = this.f25256d;
                            reentrantLock.lock();
                            this.f25257e.signal();
                            Unit unit = Unit.f12577a;
                        } catch (Exception e10) {
                            String name = b.f25252b.getClass().getName();
                            String message = e10.getMessage();
                            if (message == null) {
                                message = "Error getting public key";
                            }
                            Log.d(name, message);
                            httpURLConnection.disconnect();
                            reentrantLock = this.f25256d;
                            reentrantLock.lock();
                            this.f25257e.signal();
                            Unit unit2 = Unit.f12577a;
                        } catch (Throwable th) {
                            reentrantLock.unlock();
                            throw th;
                        }
                        reentrantLock.unlock();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                } catch (Throwable th2) {
                    reentrantLock2.unlock();
                    throw th2;
                }
            }
        }
    }

    private b() {
    }

    public static final PublicKey a(String str) {
        m.f(str, "key");
        byte[] decode = Base64.decode(j.z(j.z(j.z(str, "\n", "", false, 4, (Object) null), "-----BEGIN PUBLIC KEY-----", "", false, 4, (Object) null), "-----END PUBLIC KEY-----", "", false, 4, (Object) null), 0);
        m.e(decode, "Base64.decode(pubKeyString, Base64.DEFAULT)");
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decode));
        m.e(generatePublic, "kf.generatePublic(x509publicKey)");
        return generatePublic;
    }

    /* JADX INFO: finally extract failed */
    public static final String b(String str) {
        m.f(str, JwsHeader.KEY_ID);
        URL url = new URL("https", "www." + com.facebook.o.q(), f25251a);
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        y yVar = new y();
        yVar.f725a = null;
        com.facebook.o.p().execute(new a(url, yVar, str, reentrantLock, newCondition));
        reentrantLock.lock();
        try {
            newCondition.await(5000, TimeUnit.MILLISECONDS);
            reentrantLock.unlock();
            return (String) yVar.f725a;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static final boolean c(PublicKey publicKey, String str, String str2) {
        m.f(publicKey, "publicKey");
        m.f(str, "data");
        m.f(str2, "signature");
        try {
            Signature instance = Signature.getInstance("SHA256withRSA");
            instance.initVerify(publicKey);
            byte[] bytes = str.getBytes(d.f797b);
            m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            instance.update(bytes);
            byte[] decode = Base64.decode(str2, 8);
            m.e(decode, "Base64.decode(signature, Base64.URL_SAFE)");
            return instance.verify(decode);
        } catch (Exception unused) {
            return false;
        }
    }
}
