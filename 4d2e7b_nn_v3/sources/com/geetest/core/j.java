package com.geetest.core;

import android.content.pm.PackageManager;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import java.security.spec.ECGenParameterSpec;
import java.util.Date;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f6037a;

    public j(PackageManager packageManager) {
        boolean z10;
        if (Build.VERSION.SDK_INT < 28 || !packageManager.hasSystemFeature("android.hardware.strongbox_keystore")) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f6037a = z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ad A[SYNTHETIC, Splitter:B:30:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c3 A[EDGE_INSN: B:65:0x00c3->B:34:0x00c3 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.geetest.core.m a(java.lang.String r9, boolean r10) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            r1 = -2
            r8.b(r9, r10)     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            java.lang.String r10 = "AndroidKeyStore"
            java.security.KeyStore r10 = java.security.KeyStore.getInstance(r10)     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            r2 = 0
            r10.load(r2)     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            java.security.cert.Certificate[] r9 = r10.getCertificateChain(r9)     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            if (r9 == 0) goto L_0x00cf
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            int r3 = r9.length     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            r10.<init>(r3)     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            java.lang.String r3 = "X.509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r3)     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            int r4 = r9.length     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            r5 = 0
        L_0x0024:
            if (r5 >= r4) goto L_0x0041
            r6 = r9[r5]     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            java.io.ByteArrayInputStream r7 = new java.io.ByteArrayInputStream     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            byte[] r6 = r6.getEncoded()     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            r7.<init>(r6)     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            java.security.cert.Certificate r6 = r3.generateCertificate(r7)     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            r10.add(r6)     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            int r5 = r5 + 1
            goto L_0x0024
        L_0x003b:
            r9 = move-exception
            goto L_0x00d7
        L_0x003e:
            r9 = move-exception
            goto L_0x00dd
        L_0x0041:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x004a:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x0060
            java.lang.Object r1 = r10.next()
            java.security.cert.Certificate r1 = (java.security.cert.Certificate) r1
            boolean r3 = r1 instanceof java.security.cert.X509Certificate
            if (r3 == 0) goto L_0x004a
            java.security.cert.X509Certificate r1 = (java.security.cert.X509Certificate) r1
            r9.add(r1)
            goto L_0x004a
        L_0x0060:
            int r10 = com.geetest.core.c.a((java.util.List<java.security.cert.X509Certificate>) r9)     // Catch:{ GeneralSecurityException -> 0x00a2 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ GeneralSecurityException -> 0x00a3 }
            r1.<init>()     // Catch:{ GeneralSecurityException -> 0x00a3 }
            java.util.Iterator r3 = r9.iterator()     // Catch:{ GeneralSecurityException -> 0x00a3 }
        L_0x006d:
            boolean r4 = r3.hasNext()     // Catch:{ GeneralSecurityException -> 0x00a3 }
            if (r4 == 0) goto L_0x008b
            java.lang.Object r4 = r3.next()     // Catch:{ GeneralSecurityException -> 0x00a3 }
            java.security.cert.X509Certificate r4 = (java.security.cert.X509Certificate) r4     // Catch:{ GeneralSecurityException -> 0x00a3 }
            java.math.BigInteger r4 = r4.getSerialNumber()     // Catch:{ GeneralSecurityException -> 0x00a3 }
            r5 = 16
            java.lang.String r4 = r4.toString(r5)     // Catch:{ GeneralSecurityException -> 0x00a3 }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ GeneralSecurityException -> 0x00a3 }
            r1.add(r4)     // Catch:{ GeneralSecurityException -> 0x00a3 }
            goto L_0x006d
        L_0x008b:
            java.lang.String r1 = r1.toString()     // Catch:{ GeneralSecurityException -> 0x00a3 }
            java.lang.String r3 = " "
            java.lang.String r1 = r1.replace(r3, r0)     // Catch:{ GeneralSecurityException -> 0x00a3 }
            java.lang.String r3 = "["
            java.lang.String r1 = r1.replace(r3, r0)     // Catch:{ GeneralSecurityException -> 0x00a3 }
            java.lang.String r3 = "]"
            java.lang.String r0 = r1.replace(r3, r0)     // Catch:{ GeneralSecurityException -> 0x00a3 }
            goto L_0x00a4
        L_0x00a2:
            r10 = -1
        L_0x00a3:
            r0 = r2
        L_0x00a4:
            int r1 = r9.size()
            int r1 = r1 + -1
            r3 = r2
        L_0x00ab:
            if (r1 < 0) goto L_0x00c3
            java.lang.Object r4 = r9.get(r1)     // Catch:{ CertificateParsingException -> 0x00b8 }
            java.security.cert.X509Certificate r4 = (java.security.cert.X509Certificate) r4     // Catch:{ CertificateParsingException -> 0x00b8 }
            com.geetest.core.h r2 = com.geetest.core.h.a((java.security.cert.X509Certificate) r4)     // Catch:{ CertificateParsingException -> 0x00b8 }
            goto L_0x00c3
        L_0x00b8:
            r3 = move-exception
            com.geetest.core.k r4 = new com.geetest.core.k
            r5 = -4
            r4.<init>(r5, r3)
            int r1 = r1 + -1
            r3 = r4
            goto L_0x00ab
        L_0x00c3:
            if (r2 != 0) goto L_0x00c9
            if (r3 != 0) goto L_0x00c8
            goto L_0x00c9
        L_0x00c8:
            throw r3
        L_0x00c9:
            com.geetest.core.m r9 = new com.geetest.core.m
            r9.<init>(r2, r10, r0)
            return r9
        L_0x00cf:
            java.security.cert.CertificateException r9 = new java.security.cert.CertificateException     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            java.lang.String r10 = "Unable to get certificate chain"
            r9.<init>(r10)     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
            throw r9     // Catch:{ ProviderException -> 0x003e, Exception -> 0x003b }
        L_0x00d7:
            com.geetest.core.k r10 = new com.geetest.core.k
            r10.<init>(r1, r9)
            throw r10
        L_0x00dd:
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 28
            if (r10 < r0) goto L_0x00f1
            boolean r10 = z8.n.a(r9)
            if (r10 != 0) goto L_0x00ea
            goto L_0x00f1
        L_0x00ea:
            com.geetest.core.k r10 = new com.geetest.core.k
            r0 = -5
            r10.<init>(r0, r9)
            throw r10
        L_0x00f1:
            java.lang.Throwable r10 = r9.getCause()
            if (r10 == 0) goto L_0x0118
            java.lang.Throwable r10 = r9.getCause()
            java.lang.String r10 = r10.getMessage()
            if (r10 == 0) goto L_0x0118
            java.lang.Throwable r10 = r9.getCause()
            java.lang.String r10 = r10.getMessage()
            java.lang.String r0 = "device ids"
            boolean r10 = r10.contains(r0)
            if (r10 == 0) goto L_0x0118
            com.geetest.core.k r10 = new com.geetest.core.k
            r0 = -6
            r10.<init>(r0, r9)
            throw r10
        L_0x0118:
            com.geetest.core.k r10 = new com.geetest.core.k
            r10.<init>(r1, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.j.a(java.lang.String, boolean):com.geetest.core.m");
    }

    public final void b(String str, boolean z10) throws GeneralSecurityException {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
            Date date = new Date();
            Date date2 = new Date(date.getTime() + 1000000);
            Date date3 = new Date(date.getTime() + 2000000);
            KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(str, 4);
            KeyGenParameterSpec.Builder unused = builder.setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setKeyValidityStart(date).setKeyValidityForOriginationEnd(date2).setKeyValidityForConsumptionEnd(date3).setAttestationChallenge(date.toString().getBytes(StandardCharsets.UTF_8));
            if (i10 >= 28 && z10) {
                KeyGenParameterSpec.Builder unused2 = builder.setIsStrongBoxBacked(true);
            }
            builder.setDigests(new String[]{"NONE", "SHA-256"});
            instance.initialize(builder.build());
            instance.generateKeyPair();
        }
    }
}
