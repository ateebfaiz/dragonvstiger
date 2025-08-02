package com.sensorsdata.analytics.android.sdk.encrypt.biz;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener;
import com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey;
import org.json.JSONArray;
import org.json.JSONObject;

public class SAEventEncryptTools {
    private final SecretKeyManager mSecretKeyManager;
    private SecreteKey mSecreteKey;

    public SAEventEncryptTools(SAContextManager sAContextManager) {
        this.mSecretKeyManager = SecretKeyManager.getInstance(sAContextManager);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0030 A[SYNTHETIC, Splitter:B:19:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003b A[SYNTHETIC, Splitter:B:25:0x003b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] gzipEventData(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r1.<init>()     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0025 }
            r2.write(r4)     // Catch:{ Exception -> 0x0025 }
            r2.finish()     // Catch:{ Exception -> 0x0025 }
            byte[] r4 = r1.toByteArray()     // Catch:{ Exception -> 0x0025 }
            r2.close()     // Catch:{ Exception -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0021:
            return r4
        L_0x0022:
            r4 = move-exception
            r0 = r2
            goto L_0x0039
        L_0x0025:
            r4 = move-exception
            goto L_0x002b
        L_0x0027:
            r4 = move-exception
            goto L_0x0039
        L_0x0029:
            r4 = move-exception
            r2 = r0
        L_0x002b:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)     // Catch:{ all -> 0x0022 }
            if (r2 == 0) goto L_0x0038
            r2.close()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r4 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)
        L_0x0038:
            return r0
        L_0x0039:
            if (r0 == 0) goto L_0x0043
            r0.close()     // Catch:{ Exception -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0043:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.encrypt.biz.SAEventEncryptTools.gzipEventData(java.lang.String):byte[]");
    }

    public <T> T encryptTrackData(T t10) {
        try {
            if (this.mSecretKeyManager.isSecretKeyNull(this.mSecreteKey)) {
                SecreteKey loadSecretKey = this.mSecretKeyManager.loadSecretKey();
                this.mSecreteKey = loadSecretKey;
                if (this.mSecretKeyManager.isSecretKeyNull(loadSecretKey)) {
                    return t10;
                }
            }
            SAEncryptListener encryptListener = this.mSecretKeyManager.getEncryptListener(this.mSecreteKey);
            if (encryptListener == null) {
                return t10;
            }
            String str = this.mSecreteKey.key;
            if (str.startsWith("EC:")) {
                str = str.substring(str.indexOf(":") + 1);
            }
            String encryptSymmetricKeyWithPublicKey = encryptListener.encryptSymmetricKeyWithPublicKey(str);
            if (TextUtils.isEmpty(encryptSymmetricKeyWithPublicKey)) {
                return t10;
            }
            String encryptEvent = encryptListener.encryptEvent(gzipEventData(t10.toString()));
            if (TextUtils.isEmpty(encryptEvent)) {
                return t10;
            }
            T jSONObject = new JSONObject();
            jSONObject.put("ekey", encryptSymmetricKeyWithPublicKey);
            jSONObject.put("pkv", this.mSecreteKey.version);
            jSONObject.put("payloads", encryptEvent);
            return t10 instanceof String ? jSONObject.toString() : jSONObject;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return t10;
        }
    }

    public SAEncryptListener getEncryptListener() {
        try {
            if (this.mSecretKeyManager.isSecretKeyNull(this.mSecreteKey)) {
                SecreteKey loadSecretKey = this.mSecretKeyManager.loadSecretKey();
                this.mSecreteKey = loadSecretKey;
                if (this.mSecretKeyManager.isSecretKeyNull(loadSecretKey)) {
                    return null;
                }
            }
            return this.mSecretKeyManager.getEncryptListener(this.mSecreteKey);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public <T> T encryptTrackData(T t10, SecreteKey secreteKey) {
        SAEncryptListener encryptListener;
        try {
            if (this.mSecretKeyManager.isSecretKeyNull(secreteKey) || (encryptListener = this.mSecretKeyManager.getEncryptListener(secreteKey)) == null) {
                return t10;
            }
            String str = secreteKey.key;
            if (str.startsWith("EC:")) {
                str = str.substring(str.indexOf(":") + 1);
            }
            String encryptSymmetricKeyWithPublicKey = encryptListener.encryptSymmetricKeyWithPublicKey(str);
            if (TextUtils.isEmpty(encryptSymmetricKeyWithPublicKey)) {
                return t10;
            }
            String encryptEvent = encryptListener.encryptEvent(gzipEventData(t10.toString()));
            if (TextUtils.isEmpty(encryptEvent)) {
                return t10;
            }
            T jSONObject = new JSONObject();
            jSONObject.put("ekey", encryptSymmetricKeyWithPublicKey);
            jSONObject.put("pkv", secreteKey.version);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(encryptEvent);
            jSONObject.put("payloads", jSONArray);
            return t10 instanceof String ? jSONObject.toString() : jSONObject;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return t10;
        }
    }
}
