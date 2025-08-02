package com.sensorsdata.analytics.android.sdk.encrypt.biz;

import android.content.Context;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.encrypt.IPersistentSecretKey;
import com.sensorsdata.analytics.android.sdk.encrypt.R;
import com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener;
import com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey;
import com.sensorsdata.analytics.android.sdk.encrypt.encryptor.SAECEncrypt;
import com.sensorsdata.analytics.android.sdk.encrypt.encryptor.SARSAEncrypt;
import com.sensorsdata.analytics.android.sdk.encrypt.utils.EncryptUtils;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import com.sensorsdata.analytics.android.sdk.util.SADisplayUtil;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SecretKeyManager {
    private static SecretKeyManager INSTANCE = null;
    private static final int KEY_VERSION_DEFAULT = 0;
    private static final String SP_SECRET_KEY = "secret_key";
    private static final String SP_SUPPORT_TRANSPORT_ENCRYPT = "supportTransportEncrypt";
    private static final String TAG = "SA.SecretKeyManager";
    private final List<SAEncryptListener> mListeners;
    private final IPersistentSecretKey mPersistentSecretKey;
    private final SAConfigOptions mSAConfigOptions;

    private SecretKeyManager(SAContextManager sAContextManager) {
        this.mSAConfigOptions = sAContextManager.getInternalConfigs().saConfigOptions;
        this.mPersistentSecretKey = sAContextManager.getInternalConfigs().saConfigOptions.getPersistentSecretKey();
        List<SAEncryptListener> encryptors = sAContextManager.getInternalConfigs().saConfigOptions.getEncryptors();
        this.mListeners = encryptors;
        encryptors.add(new SARSAEncrypt());
        if (EncryptUtils.isECEncrypt()) {
            encryptors.add(new SAECEncrypt());
        }
    }

    private String disposeECPublicKey(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("EC:")) {
            return str;
        }
        return str.substring(str.indexOf(":") + 1);
    }

    public static SecretKeyManager getInstance(SAContextManager sAContextManager) {
        if (INSTANCE == null) {
            INSTANCE = new SecretKeyManager(sAContextManager);
        }
        return INSTANCE;
    }

    private boolean isEncryptorTypeNull(SAEncryptListener sAEncryptListener) {
        if (TextUtils.isEmpty(sAEncryptListener.asymmetricEncryptType()) || TextUtils.isEmpty(sAEncryptListener.symmetricEncryptType())) {
            return true;
        }
        return false;
    }

    private boolean isMatchEncryptType(SAEncryptListener sAEncryptListener, SecreteKey secreteKey) {
        if (sAEncryptListener == null || isSecretKeyNull(secreteKey) || isEncryptorTypeNull(sAEncryptListener) || !sAEncryptListener.asymmetricEncryptType().equals(secreteKey.asymmetricEncryptType) || !sAEncryptListener.symmetricEncryptType().equals(secreteKey.symmetricEncryptType)) {
            return false;
        }
        return true;
    }

    private void parseSecreteKey(JSONObject jSONObject, SecreteKey secreteKey) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("key_ec") && EncryptUtils.isECEncrypt()) {
                    String optString = jSONObject.optString("key_ec");
                    if (!TextUtils.isEmpty(optString)) {
                        jSONObject = new JSONObject(optString);
                    }
                }
                secreteKey.key = jSONObject.optString("public_key");
                secreteKey.symmetricEncryptType = "AES";
                if (jSONObject.has("type")) {
                    String optString2 = jSONObject.optString("type");
                    secreteKey.key = optString2 + ":" + secreteKey.key;
                    secreteKey.asymmetricEncryptType = optString2;
                } else {
                    secreteKey.asymmetricEncryptType = "RSA";
                }
                secreteKey.version = jSONObject.optInt("pkv");
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    private SecreteKey readAppKey() {
        String str;
        int i10;
        String str2;
        String str3;
        SecreteKey loadSecretKey = this.mPersistentSecretKey.loadSecretKey();
        if (loadSecretKey != null) {
            str2 = loadSecretKey.key;
            i10 = loadSecretKey.version;
            str = loadSecretKey.symmetricEncryptType;
            str3 = loadSecretKey.asymmetricEncryptType;
        } else {
            str2 = "";
            i10 = 0;
            str3 = str2;
            str = str3;
        }
        SALog.i(TAG, "readAppKey [key = " + str2 + " ,v = " + i10 + " ,symmetricEncryptType = " + str + " ,asymmetricEncryptType = " + str3 + "]");
        return new SecreteKey(str2, i10, str, str3);
    }

    private SecreteKey readLocalKey() throws JSONException {
        String str;
        String str2;
        String str3 = "";
        String string = SAStoreManager.getInstance().getString(SP_SECRET_KEY, str3);
        int i10 = 0;
        if (!TextUtils.isEmpty(string)) {
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("key", str3);
            i10 = jSONObject.optInt("version", 0);
            str = jSONObject.optString("symmetricEncryptType", str3);
            String optString2 = jSONObject.optString("asymmetricEncryptType", str3);
            str3 = optString;
            str2 = optString2;
        } else {
            str2 = str3;
            str = str2;
        }
        SALog.i(TAG, "readLocalKey [key = " + str3 + " ,v = " + i10 + " ,symmetricEncryptType = " + str + " ,asymmetricEncryptType = " + str2 + "]");
        return new SecreteKey(str3, i10, str, str2);
    }

    public String checkPublicSecretKey(Context context, String str, String str2, String str3, String str4) {
        try {
            SecreteKey loadSecretKey = loadSecretKey();
            if (loadSecretKey != null) {
                if (!TextUtils.isEmpty(loadSecretKey.key)) {
                    if (!str.equals(loadSecretKey.version + "") || !disposeECPublicKey(str2).equals(disposeECPublicKey(loadSecretKey.key))) {
                        return String.format(SADisplayUtil.getStringResource(context, R.string.sensors_analytics_encrypt_verify_fail_version), new Object[]{str, Integer.valueOf(loadSecretKey.version)});
                    }
                    if (!(str3 == null || str4 == null)) {
                        if (!str3.equals(loadSecretKey.symmetricEncryptType) || !str4.equals(loadSecretKey.asymmetricEncryptType)) {
                            return String.format(SADisplayUtil.getStringResource(context, R.string.sensors_analytics_encrypt_verify_fail_type), new Object[]{str3, str4, loadSecretKey.symmetricEncryptType, loadSecretKey.asymmetricEncryptType});
                        }
                    }
                    return SADisplayUtil.getStringResource(context, R.string.sensors_analytics_encrypt_pass);
                }
            }
            return SADisplayUtil.getStringResource(context, R.string.sensors_analytics_encrypt_key_null);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public SAEncryptListener getEncryptListener(SecreteKey secreteKey) {
        if (isSecretKeyNull(secreteKey)) {
            return null;
        }
        for (SAEncryptListener next : this.mListeners) {
            if (isMatchEncryptType(next, secreteKey)) {
                return next;
            }
        }
        return null;
    }

    public boolean isSecretKeyNull(SecreteKey secreteKey) {
        if (secreteKey == null || TextUtils.isEmpty(secreteKey.key) || secreteKey.version == 0) {
            return true;
        }
        return false;
    }

    public Boolean isSupportTransportEncrypt() {
        if (SAStoreManager.getInstance().isExists("supportTransportEncrypt")) {
            return Boolean.valueOf(SAStoreManager.getInstance().getBool("supportTransportEncrypt", false));
        }
        return null;
    }

    public SecreteKey loadSecretKey() throws JSONException {
        if (this.mPersistentSecretKey != null) {
            return readAppKey();
        }
        return readLocalKey();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ad A[Catch:{ JSONException -> 0x001b }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b9 A[Catch:{ JSONException -> 0x001b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void storeSecretKey(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "supportTransportEncrypt"
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001b }
            r2.<init>(r10)     // Catch:{ JSONException -> 0x001b }
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r10 = r9.mSAConfigOptions     // Catch:{ JSONException -> 0x001b }
            boolean r10 = r10.isEnableEncrypt()     // Catch:{ JSONException -> 0x001b }
            r3 = 0
            if (r10 != 0) goto L_0x001e
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r10 = r9.mSAConfigOptions     // Catch:{ JSONException -> 0x001b }
            boolean r10 = r10.isTransportEncrypt()     // Catch:{ JSONException -> 0x001b }
            if (r10 == 0) goto L_0x00a7
            goto L_0x001e
        L_0x001b:
            r10 = move-exception
            goto L_0x00c1
        L_0x001e:
            java.lang.String r10 = "configs"
            java.lang.String r10 = r2.optString(r10)     // Catch:{ JSONException -> 0x001b }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001b }
            r2.<init>(r10)     // Catch:{ JSONException -> 0x001b }
            com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey r10 = new com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey     // Catch:{ JSONException -> 0x001b }
            r4 = -1
            r10.<init>(r0, r4, r0, r0)     // Catch:{ JSONException -> 0x001b }
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r0 = r9.mSAConfigOptions     // Catch:{ JSONException -> 0x001b }
            java.util.List r0 = r0.getEncryptors()     // Catch:{ JSONException -> 0x001b }
            if (r0 == 0) goto L_0x00a4
            boolean r4 = r0.isEmpty()     // Catch:{ JSONException -> 0x001b }
            if (r4 != 0) goto L_0x00a4
            java.lang.String r4 = "key_v2"
            org.json.JSONObject r4 = r2.optJSONObject(r4)     // Catch:{ JSONException -> 0x001b }
            if (r4 == 0) goto L_0x0093
            java.lang.String r5 = "type"
            java.lang.String r5 = r4.optString(r5)     // Catch:{ JSONException -> 0x001b }
            java.lang.String r6 = "\\+"
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ JSONException -> 0x001b }
            int r6 = r5.length     // Catch:{ JSONException -> 0x001b }
            r7 = 2
            if (r6 != r7) goto L_0x0093
            r6 = r5[r3]     // Catch:{ JSONException -> 0x001b }
            r7 = 1
            r5 = r5[r7]     // Catch:{ JSONException -> 0x001b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x001b }
        L_0x005e:
            boolean r7 = r0.hasNext()     // Catch:{ JSONException -> 0x001b }
            if (r7 == 0) goto L_0x0093
            java.lang.Object r7 = r0.next()     // Catch:{ JSONException -> 0x001b }
            com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener r7 = (com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener) r7     // Catch:{ JSONException -> 0x001b }
            java.lang.String r8 = r7.asymmetricEncryptType()     // Catch:{ JSONException -> 0x001b }
            boolean r8 = r6.equals(r8)     // Catch:{ JSONException -> 0x001b }
            if (r8 == 0) goto L_0x005e
            java.lang.String r7 = r7.symmetricEncryptType()     // Catch:{ JSONException -> 0x001b }
            boolean r7 = r5.equals(r7)     // Catch:{ JSONException -> 0x001b }
            if (r7 == 0) goto L_0x005e
            java.lang.String r7 = "public_key"
            java.lang.String r7 = r4.optString(r7)     // Catch:{ JSONException -> 0x001b }
            r10.key = r7     // Catch:{ JSONException -> 0x001b }
            java.lang.String r7 = "pkv"
            int r7 = r4.optInt(r7)     // Catch:{ JSONException -> 0x001b }
            r10.version = r7     // Catch:{ JSONException -> 0x001b }
            r10.asymmetricEncryptType = r6     // Catch:{ JSONException -> 0x001b }
            r10.symmetricEncryptType = r5     // Catch:{ JSONException -> 0x001b }
            goto L_0x005e
        L_0x0093:
            java.lang.String r0 = r10.key     // Catch:{ JSONException -> 0x001b }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x001b }
            if (r0 == 0) goto L_0x00a4
            java.lang.String r0 = "key"
            org.json.JSONObject r0 = r2.optJSONObject(r0)     // Catch:{ JSONException -> 0x001b }
            r9.parseSecreteKey(r0, r10)     // Catch:{ JSONException -> 0x001b }
        L_0x00a4:
            r9.storeSecretKey((com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey) r10)     // Catch:{ JSONException -> 0x001b }
        L_0x00a7:
            boolean r10 = r2.has(r1)     // Catch:{ JSONException -> 0x001b }
            if (r10 == 0) goto L_0x00b9
            com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager r10 = com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance()     // Catch:{ JSONException -> 0x001b }
            boolean r0 = r2.optBoolean(r1)     // Catch:{ JSONException -> 0x001b }
            r10.setBool(r1, r0)     // Catch:{ JSONException -> 0x001b }
            goto L_0x00c4
        L_0x00b9:
            com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager r10 = com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance()     // Catch:{ JSONException -> 0x001b }
            r10.setBool(r1, r3)     // Catch:{ JSONException -> 0x001b }
            goto L_0x00c4
        L_0x00c1:
            r10.printStackTrace()
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.encrypt.biz.SecretKeyManager.storeSecretKey(java.lang.String):void");
    }

    private void storeSecretKey(SecreteKey secreteKey) {
        try {
            SALog.i(TAG, "[saveSecretKey] publicKey = " + secreteKey.toString());
            if (getEncryptListener(secreteKey) != null) {
                IPersistentSecretKey iPersistentSecretKey = this.mPersistentSecretKey;
                if (iPersistentSecretKey != null) {
                    iPersistentSecretKey.saveSecretKey(secreteKey);
                    SAStoreManager.getInstance().setString(SP_SECRET_KEY, "");
                    return;
                }
                SAStoreManager.getInstance().setString(SP_SECRET_KEY, secreteKey.toString());
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}
