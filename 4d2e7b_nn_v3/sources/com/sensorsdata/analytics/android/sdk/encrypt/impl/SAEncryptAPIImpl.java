package com.sensorsdata.analytics.android.sdk.encrypt.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.pdns.model.DomainUhfReportModel;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager;
import com.sensorsdata.analytics.android.sdk.encrypt.R;
import com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener;
import com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey;
import com.sensorsdata.analytics.android.sdk.encrypt.biz.SAEventEncryptTools;
import com.sensorsdata.analytics.android.sdk.encrypt.biz.SecretKeyManager;
import com.sensorsdata.analytics.android.sdk.util.SADisplayUtil;
import org.json.JSONException;

public class SAEncryptAPIImpl implements SAEncryptAPI {
    private static final String TAG = "SA.EncryptAPIImpl";
    private SAContextManager mSAContextManager;
    private SecretKeyManager mSecretKeyManager;
    private SAEventEncryptTools mSensorsDataEncrypt;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058 A[Catch:{ Exception -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SAEncryptAPIImpl(com.sensorsdata.analytics.android.sdk.core.SAContextManager r4) {
        /*
            r3 = this;
            r3.<init>()
            r3.mSAContextManager = r4     // Catch:{ Exception -> 0x002e }
            com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions r0 = r4.getInternalConfigs()     // Catch:{ Exception -> 0x002e }
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r0 = r0.saConfigOptions     // Catch:{ Exception -> 0x002e }
            boolean r1 = r0.isEnableEncrypt()     // Catch:{ Exception -> 0x002e }
            if (r1 != 0) goto L_0x0030
            boolean r1 = r0.isTransportEncrypt()     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x0018
            goto L_0x0030
        L_0x0018:
            com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig r1 = r0.getAdvertConfig()     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x0048
            com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig r1 = r0.getAdvertConfig()     // Catch:{ Exception -> 0x002e }
            com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey r1 = r1.secreteKey     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x0048
            com.sensorsdata.analytics.android.sdk.encrypt.biz.SAEventEncryptTools r1 = new com.sensorsdata.analytics.android.sdk.encrypt.biz.SAEventEncryptTools     // Catch:{ Exception -> 0x002e }
            r1.<init>(r4)     // Catch:{ Exception -> 0x002e }
            r3.mSensorsDataEncrypt = r1     // Catch:{ Exception -> 0x002e }
            goto L_0x0048
        L_0x002e:
            r4 = move-exception
            goto L_0x0064
        L_0x0030:
            com.sensorsdata.analytics.android.sdk.encrypt.biz.SAEventEncryptTools r1 = new com.sensorsdata.analytics.android.sdk.encrypt.biz.SAEventEncryptTools     // Catch:{ Exception -> 0x002e }
            r1.<init>(r4)     // Catch:{ Exception -> 0x002e }
            r3.mSensorsDataEncrypt = r1     // Catch:{ Exception -> 0x002e }
            com.sensorsdata.analytics.android.sdk.encrypt.biz.SecretKeyManager r1 = com.sensorsdata.analytics.android.sdk.encrypt.biz.SecretKeyManager.getInstance(r4)     // Catch:{ Exception -> 0x002e }
            r3.mSecretKeyManager = r1     // Catch:{ Exception -> 0x002e }
            com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager r1 = com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager.getInstance()     // Catch:{ Exception -> 0x002e }
            android.content.Context r2 = r4.getContext()     // Catch:{ Exception -> 0x002e }
            r1.initSecretKey(r2)     // Catch:{ Exception -> 0x002e }
        L_0x0048:
            java.util.List r1 = r0.getStorePlugins()     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x0067
            java.util.List r0 = r0.getStorePlugins()     // Catch:{ Exception -> 0x002e }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x002e }
            if (r0 != 0) goto L_0x0067
            com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager r0 = com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager.getInstance()     // Catch:{ Exception -> 0x002e }
            android.content.Context r4 = r4.getContext()     // Catch:{ Exception -> 0x002e }
            r0.initSecretKey(r4)     // Catch:{ Exception -> 0x002e }
            goto L_0x0067
        L_0x0064:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.encrypt.impl.SAEncryptAPIImpl.<init>(com.sensorsdata.analytics.android.sdk.core.SAContextManager):void");
    }

    public String decryptAES(String str) {
        return AESSecretManager.getInstance().decryptAES(str);
    }

    public String encryptAES(String str) {
        return AESSecretManager.getInstance().encryptAES(str);
    }

    public <T> T encryptEventData(T t10) {
        return this.mSensorsDataEncrypt.encryptTrackData(t10);
    }

    public <T> T invokeModuleFunction(String str, Object... objArr) {
        try {
            if (Modules.Encrypt.METHOD_ENCRYPT_AES.equals(str)) {
                return encryptAES(objArr[0]);
            }
            if (Modules.Encrypt.METHOD_DECRYPT_AES.equals(str)) {
                return decryptAES(objArr[0]);
            }
            if (Modules.Encrypt.METHOD_VERIFY_SECRET_KEY.equals(str)) {
                return verifySecretKey(objArr[0]);
            }
            if (Modules.Encrypt.METHOD_ENCRYPT_EVENT_DATA.equals(str)) {
                return encryptEventData(objArr[0]);
            }
            if (Modules.Encrypt.METHOD_ENCRYPT_EVENT_DATA_WITH_KEY.equals(str)) {
                return encryptEventData(objArr[0], objArr[1]);
            }
            if (Modules.Encrypt.METHOD_STORE_SECRET_KEY.equals(str)) {
                storeSecretKey(objArr[0]);
                return null;
            } else if (Modules.Encrypt.METHOD_LOAD_SECRET_KEY.equals(str)) {
                return loadSecretKey();
            } else {
                if (Modules.Encrypt.METHOD_VERIFY_SUPPORT_TRANSPORT.equals(str)) {
                    return this.mSecretKeyManager.isSupportTransportEncrypt();
                }
                if (Modules.Encrypt.METHOD_STORE_EVENT.equals(str)) {
                    SAEncryptListener encryptListener = this.mSensorsDataEncrypt.getEncryptListener();
                    if (encryptListener instanceof AbsSAEncrypt) {
                        return ((AbsSAEncrypt) encryptListener).encryptEventRecord(objArr[0]);
                    }
                    return null;
                } else if (!Modules.Encrypt.METHOD_LOAD_EVENT.equals(str)) {
                    return null;
                } else {
                    SAEncryptListener encryptListener2 = this.mSensorsDataEncrypt.getEncryptListener();
                    if (encryptListener2 instanceof AbsSAEncrypt) {
                        return ((AbsSAEncrypt) encryptListener2).decryptEventRecord(objArr[0]);
                    }
                    return null;
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public String loadSecretKey() {
        try {
            SecreteKey loadSecretKey = this.mSecretKeyManager.loadSecretKey();
            if (this.mSecretKeyManager.getEncryptListener(loadSecretKey) == null) {
                return "";
            }
            return loadSecretKey.toString();
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public void storeSecretKey(String str) {
        SecretKeyManager.getInstance(this.mSAContextManager).storeSecretKey(str);
    }

    public String verifySecretKey(Uri uri) {
        String queryParameter = uri.getQueryParameter(DomainUhfReportModel.ENCRYPTYPE);
        String decode = Uri.decode(uri.getQueryParameter("key"));
        String decode2 = Uri.decode(uri.getQueryParameter("symmetricEncryptType"));
        String decode3 = Uri.decode(uri.getQueryParameter("asymmetricEncryptType"));
        SALog.i(TAG, "Encrypt, version = " + queryParameter + ", key = " + decode + ", symmetricEncryptType = " + decode2 + ", asymmetricEncryptType = " + decode3);
        if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(decode)) {
            return SADisplayUtil.getStringResource(this.mSAContextManager.getContext(), R.string.sensors_analytics_encrypt_fail);
        }
        SecretKeyManager secretKeyManager = this.mSecretKeyManager;
        if (secretKeyManager != null) {
            return secretKeyManager.checkPublicSecretKey(this.mSAContextManager.getContext(), queryParameter, decode, decode2, decode3);
        }
        return SADisplayUtil.getStringResource(this.mSAContextManager.getContext(), R.string.sensors_analytics_encrypt_disable);
    }

    public <T> T encryptEventData(T t10, SecreteKey secreteKey) {
        SAEventEncryptTools sAEventEncryptTools = this.mSensorsDataEncrypt;
        if (sAEventEncryptTools == null) {
            return t10;
        }
        return sAEventEncryptTools.encryptTrackData(t10, secreteKey);
    }
}
