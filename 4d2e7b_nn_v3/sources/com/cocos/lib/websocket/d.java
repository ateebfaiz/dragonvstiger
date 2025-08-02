package com.cocos.lib.websocket;

import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

abstract class d {
    static KeyStore a(InputStream inputStream) {
        Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
        KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
        instance.load((KeyStore.LoadStoreParameter) null);
        instance.setCertificateEntry("0", generateCertificate);
        return instance;
    }

    static KeyStore b(InputStream inputStream) {
        KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
        instance.load((KeyStore.LoadStoreParameter) null);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int i10 = 0;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            } else if (readLine.contains("BEGIN CERTIFICATE")) {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 == null) {
                        break;
                    } else if (readLine2.contains("END CERTIFICATE")) {
                        instance.setCertificateEntry(Integer.toString(i10), d(Base64.decode(sb2.toString(), 0)));
                        i10++;
                        break;
                    } else {
                        sb2.append(readLine2);
                    }
                }
            }
        }
        bufferedReader.close();
        if (i10 != 0) {
            return instance;
        }
        throw new IllegalArgumentException("No CERTIFICATE found");
    }

    static X509TrustManager c(KeyStore keyStore) {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(keyStore);
        TrustManager[] trustManagers = instance.getTrustManagers();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
    }

    private static Certificate d(byte[] bArr) {
        return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
    }
}
