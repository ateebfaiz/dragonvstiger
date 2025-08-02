package org.cocos2dx.javascript;

import android.util.Base64;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CommonUtils {
    private static final String TAG = "PlatformUtils";
    private static final String secretKey = "thanks,pig4cloud";

    public static String decrypt(String str) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS7Padding");
        instance.init(2, secretKeySpec);
        return new String(instance.doFinal(Base64.decode(str, 0)));
    }

    public static String[] getServersConfigByEncryptedData(String str) {
        String[] strArr;
        try {
            JSONArray parseArray = JSON.parseArray(decrypt(str));
            strArr = new String[parseArray.size()];
            for (int i10 = 0; i10 < parseArray.size(); i10++) {
                strArr[i10] = parseArray.getString(i10);
            }
        } catch (Exception e10) {
            strArr = new String[0];
            e10.printStackTrace();
        }
        Log.i(TAG, strArr.toString());
        return strArr;
    }
}
