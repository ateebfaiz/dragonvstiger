package com.appsflyer;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Calendar;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;

public class AFKeystoreWrapper {
    public String AFInAppEventParameterName;
    public KeyStore AFInAppEventType;
    private Context AFKeystoreWrapper;
    public int valueOf;
    public final Object values = new Object();

    public AFKeystoreWrapper(Context context) {
        this.AFKeystoreWrapper = context;
        this.AFInAppEventParameterName = "";
        this.valueOf = 0;
        AFLogger.afInfoLog("Initialising KeyStore..");
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            this.AFInAppEventType = instance;
            instance.load((KeyStore.LoadStoreParameter) null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e10) {
            AFLogger.afErrorLog("Couldn't load keystore instance of type: AndroidKeyStore", e10);
        }
    }

    private static boolean AFInAppEventType(String str) {
        return str.startsWith("com.appsflyer");
    }

    public final String AFInAppEventParameterName() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("com.appsflyer,");
        synchronized (this.values) {
            sb2.append("KSAppsFlyerId=");
            sb2.append(this.AFInAppEventParameterName);
            sb2.append(",");
            sb2.append("KSAppsFlyerRICounter=");
            sb2.append(this.valueOf);
        }
        return sb2.toString();
    }

    public final int valueOf() {
        int i10;
        synchronized (this.values) {
            i10 = this.valueOf;
        }
        return i10;
    }

    public final boolean values() {
        boolean z10;
        synchronized (this.values) {
            try {
                KeyStore keyStore = this.AFInAppEventType;
                z10 = false;
                if (keyStore != null) {
                    Enumeration<String> aliases = keyStore.aliases();
                    while (true) {
                        if (!aliases.hasMoreElements()) {
                            break;
                        }
                        String nextElement = aliases.nextElement();
                        if (nextElement != null && AFInAppEventType(nextElement)) {
                            String[] split = nextElement.split(",");
                            if (split.length == 3) {
                                AFLogger.afInfoLog("Found a matching AF key with alias:\n".concat(nextElement));
                                z10 = true;
                                String[] split2 = split[1].trim().split("=");
                                String[] split3 = split[2].trim().split("=");
                                if (split2.length == 2 && split3.length == 2) {
                                    this.AFInAppEventParameterName = split2[1].trim();
                                    this.valueOf = Integer.parseInt(split3[1].trim());
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public final String AFInAppEventType() {
        String str;
        synchronized (this.values) {
            str = this.AFInAppEventParameterName;
        }
        return str;
    }

    public final void values(String str) {
        AFLogger.afInfoLog("Creating a new key with alias: ".concat(String.valueOf(str)));
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 5);
            synchronized (this.values) {
                if (!this.AFInAppEventType.containsAlias(str)) {
                    KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(str, 3).setCertificateSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(instance.getTime()).setCertificateNotAfter(instance2.getTime()).build();
                    KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    instance3.initialize(build);
                    instance3.generateKeyPair();
                } else {
                    AFLogger.afInfoLog("Alias already exists: ".concat(String.valueOf(str)));
                }
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("Exception ");
            sb2.append(th.getMessage());
            sb2.append(" occurred");
            AFLogger.afErrorLog(sb2.toString(), th);
        }
    }
}
