package g1;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class k extends h {

    /* renamed from: d  reason: collision with root package name */
    public SSLSocket f21595d;

    public static class a implements X509TrustManager {

        /* renamed from: a  reason: collision with root package name */
        public X509TrustManager f21596a;

        /* renamed from: b  reason: collision with root package name */
        public X509Certificate f21597b;

        /* renamed from: g1.k$a$a  reason: collision with other inner class name */
        public static class C0278a extends CertificateException {
            public C0278a(String str) {
                super("MyCertificateException:" + str);
            }
        }

        public a(String str) {
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
                X509Certificate x509Certificate = (X509Certificate) instance.generateCertificate(byteArrayInputStream);
                byteArrayInputStream.close();
                this.f21597b = x509Certificate;
                KeyStore.TrustedCertificateEntry trustedCertificateEntry = new KeyStore.TrustedCertificateEntry(x509Certificate);
                KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
                instance2.load((InputStream) null, (char[]) null);
                instance2.setEntry("ca_root", trustedCertificateEntry, (KeyStore.ProtectionParameter) null);
                TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance3.init(instance2);
                for (TrustManager trustManager : instance3.getTrustManagers()) {
                    if (trustManager instanceof X509TrustManager) {
                        this.f21596a = (X509TrustManager) trustManager;
                        return;
                    }
                }
            } catch (Throwable th) {
                s1.a.b("SSLTrustManager", "init trustManager failed, error:" + th);
                throw new C0278a("SSLTrustManager init : " + th);
            }
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            s1.a.a("SSLTrustManager", "checkClientTrusted");
            this.f21596a.checkClientTrusted(x509CertificateArr, str);
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            s1.a.a("SSLTrustManager", "checkServerTrusted");
            if (!(x509CertificateArr == null || x509CertificateArr.length == 0)) {
                if (x509CertificateArr[0] != null) {
                    try {
                        for (X509Certificate x509Certificate : x509CertificateArr) {
                            x509Certificate.checkValidity();
                            x509Certificate.verify(this.f21597b.getPublicKey());
                        }
                        return;
                    } catch (CertificateExpiredException e10) {
                        s1.a.b("SSLTrustManager", ":checkServerTrusted: CertificateExpiredException:" + e10);
                        throw new C0278a("CertificateExpiredException:" + e10);
                    } catch (CertificateNotYetValidException e11) {
                        s1.a.b("SSLTrustManager", ":checkServerTrusted: CertificateNotYetValidException:" + e11);
                        throw new C0278a("CertificateNotYetValidException:" + e11);
                    } catch (NoSuchAlgorithmException e12) {
                        s1.a.b("SSLTrustManager", ":checkServerTrusted: NoSuchAlgorithmException:" + e12);
                        throw new C0278a("NoSuchAlgorithmException:" + e12);
                    } catch (InvalidKeyException e13) {
                        s1.a.b("SSLTrustManager", ":checkServerTrusted: InvalidKeyException:" + e13);
                        throw new C0278a("InvalidKeyException:" + e13);
                    } catch (SignatureException e14) {
                        s1.a.b("SSLTrustManager", ":checkServerTrusted: SignatureException:" + e14);
                        throw new C0278a("SignatureException:" + e14);
                    } catch (NoSuchProviderException e15) {
                        s1.a.b("SSLTrustManager", ":checkServerTrusted: NoSuchProviderException:" + e15);
                        throw new C0278a("NoSuchProviderException:" + e15);
                    }
                }
            }
            throw new C0278a("Check Server x509Certificates is empty");
        }

        public X509Certificate[] getAcceptedIssuers() {
            s1.a.a("SSLTrustManager", "getAcceptedIssuers");
            return this.f21596a.getAcceptedIssuers();
        }
    }

    public String b() {
        return "TcpSSLClient";
    }

    public void g(Context context) {
        try {
            s1.a.a("TcpSSLClient", "tcp disconnectImp");
            SSLSocket sSLSocket = this.f21595d;
            if (sSLSocket != null) {
                sSLSocket.close();
                this.f21595d = null;
            }
        } catch (Throwable th) {
            s1.a.h("TcpSSLClient", "disconnect failed " + th.getMessage());
        }
    }

    public boolean k(Context context, String str, int i10) {
        SSLSocket u10 = u(context, str, i10);
        if (u10 != null) {
            this.f21595d = u10;
            s1.a.a("TcpSSLClient", "tcp connect success");
            return true;
        }
        s1.a.a("TcpSSLClient", "tcp connect fai");
        return false;
    }

    public boolean m(Context context, byte[] bArr) {
        SSLSocket sSLSocket = this.f21595d;
        if (sSLSocket == null || !sSLSocket.isConnected()) {
            return false;
        }
        this.f21595d.getOutputStream().write(bArr);
        return true;
    }

    public List n(Context context) {
        return v(context);
    }

    public byte[] o(Context context) {
        try {
            if (!j()) {
                s1.a.a("TcpSSLClient", "tcp is not connecting");
                return null;
            } else if (!this.f21595d.isConnected()) {
                s1.a.h("TcpSSLClient", "socketChannel is disConnected");
                c(context);
                return null;
            } else {
                if (j()) {
                    byte[] bArr = new byte[2];
                    int read = this.f21595d.getInputStream().read(bArr);
                    if (read < 0) {
                        s1.a.h("TcpSSLClient", "read ahead length = " + read);
                        c(context);
                        return null;
                    }
                    int i10 = ByteBuffer.wrap(bArr).getShort() & 16383;
                    s1.a.a("TcpSSLClient", "read total length = " + i10);
                    if (i10 == 0) {
                        c(context);
                        return null;
                    }
                    ByteBuffer allocate = ByteBuffer.allocate(i10 - 2);
                    while (allocate.hasRemaining()) {
                        byte[] bArr2 = new byte[allocate.remaining()];
                        int read2 = this.f21595d.getInputStream().read(bArr2);
                        s1.a.h("TcpSSLClient", "read content length = " + read2);
                        if (read2 <= 0) {
                            c(context);
                            return null;
                        }
                        allocate.put(bArr2);
                    }
                    byte[] array = allocate.array();
                    s1.a.a("TcpSSLClient", "read total contentBytes.length = " + array.length);
                    byte[] bArr3 = new byte[i10];
                    System.arraycopy(bArr, 0, bArr3, 0, 2);
                    System.arraycopy(array, 0, bArr3, 2, array.length);
                    return bArr3;
                }
                return null;
            }
        } catch (IOException e10) {
            s1.a.h("TcpSSLClient", "receive IOException " + e10.getMessage());
            c(context);
        } catch (Throwable th) {
            s1.a.h("TcpSSLClient", "receive failed " + th.getMessage());
            c(context);
        }
    }

    public final TrustManager t(String str) {
        return new a(str);
    }

    public final SSLSocket u(Context context, String str, int i10) {
        SSLSocket sSLSocket = null;
        try {
            String a10 = n.a(context);
            if (TextUtils.isEmpty(a10)) {
                s1.a.b("TcpSSLClient", "ssl cer is null");
                return null;
            }
            s1.a.a("TcpSSLClient", "host:" + str + ",port:" + i10);
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init((KeyManager[]) null, new TrustManager[]{t(a10)}, new SecureRandom());
            SSLSocket sSLSocket2 = (SSLSocket) instance.getSocketFactory().createSocket(str, i10);
            try {
                sSLSocket2.setKeepAlive(true);
                return sSLSocket2;
            } catch (NoSuchAlgorithmException e10) {
                sSLSocket = sSLSocket2;
                e = e10;
            } catch (KeyManagementException e11) {
                sSLSocket = sSLSocket2;
                e = e11;
                s1.a.b("TcpSSLClient", "ssl KeyManagementException:" + e.getMessage());
                return sSLSocket;
            } catch (CertificateException e12) {
                sSLSocket = sSLSocket2;
                e = e12;
                s1.a.b("TcpSSLClient", "ssl CertificateException:" + e.getMessage());
                return sSLSocket;
            } catch (SocketException e13) {
                sSLSocket = sSLSocket2;
                e = e13;
                s1.a.b("TcpSSLClient", "ssl SocketException:" + e.getMessage());
                return sSLSocket;
            } catch (UnknownHostException e14) {
                sSLSocket = sSLSocket2;
                e = e14;
                s1.a.b("TcpSSLClient", "ssl UnknownHostException:" + e.getMessage());
                return sSLSocket;
            } catch (IOException e15) {
                sSLSocket = sSLSocket2;
                e = e15;
                s1.a.b("TcpSSLClient", "ssl IOException:" + e.getMessage());
                return sSLSocket;
            }
        } catch (NoSuchAlgorithmException e16) {
            e = e16;
            s1.a.b("TcpSSLClient", "ssl NoSuchAlgorithmException:" + e.getMessage());
            return sSLSocket;
        } catch (KeyManagementException e17) {
            e = e17;
            s1.a.b("TcpSSLClient", "ssl KeyManagementException:" + e.getMessage());
            return sSLSocket;
        } catch (CertificateException e18) {
            e = e18;
            s1.a.b("TcpSSLClient", "ssl CertificateException:" + e.getMessage());
            return sSLSocket;
        } catch (SocketException e19) {
            e = e19;
            s1.a.b("TcpSSLClient", "ssl SocketException:" + e.getMessage());
            return sSLSocket;
        } catch (UnknownHostException e20) {
            e = e20;
            s1.a.b("TcpSSLClient", "ssl UnknownHostException:" + e.getMessage());
            return sSLSocket;
        } catch (IOException e21) {
            e = e21;
            s1.a.b("TcpSSLClient", "ssl IOException:" + e.getMessage());
            return sSLSocket;
        }
    }

    public final List v(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(w(context));
        Collections.shuffle(arrayList);
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r0 = x1.a.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set w(android.content.Context r6) {
        /*
            r5 = this;
            java.util.Set r6 = g1.n.D(r6)
            boolean r0 = p1.a.f23052a
            if (r0 == 0) goto L_0x0009
            return r6
        L_0x0009:
            com.engagelab.privates.core.api.Address r0 = x1.a.a()
            int r1 = r0.c()
            if (r1 > 0) goto L_0x0014
            return r6
        L_0x0014:
            java.lang.String r2 = r0.a()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r4 = ":"
            if (r3 != 0) goto L_0x0035
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r4)
            r3.append(r1)
            java.lang.String r2 = r3.toString()
            r6.add(r2)
        L_0x0035:
            java.lang.String r0 = r0.b()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0054
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r4)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            r6.add(r0)
        L_0x0054:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.k.w(android.content.Context):java.util.Set");
    }
}
