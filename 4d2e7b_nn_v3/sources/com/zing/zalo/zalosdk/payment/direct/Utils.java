package com.zing.zalo.zalosdk.payment.direct;

import android.content.Context;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.core.type.FromSourceType;
import com.zing.zalo.zalosdk.core.type.LangType;
import com.zing.zalo.zalosdk.oauth.ZaloSDK;
import com.zing.zalo.zalosdk.payment.direct.PaymentAlertDialog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils {
    private static LangType language;

    public static String getExtInfo(JSONObject jSONObject, boolean z10) throws UnsupportedEncodingException, JSONException {
        String str;
        JSONObject prepareExtraInfo = ZaloSDK.Instance.getBaseAppInfo().prepareExtraInfo(FromSourceType.SDK.getCode());
        if (jSONObject == null) {
            str = prepareExtraInfo.toString();
        } else {
            Iterator<String> keys = prepareExtraInfo.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, prepareExtraInfo.get(next));
            }
            str = jSONObject.toString();
        }
        return z10 ? URLEncoder.encode(str, "UTF-8") : str;
    }

    public static String getLanguage(Context context) {
        if (language == null) {
            return Locale.getDefault().getLanguage();
        }
        Log.i("debuglog", "AAAA----current.getLanguage() : " + language);
        if (language == LangType.MY) {
            return "my";
        }
        if (language != LangType.VN) {
            return "en";
        }
        return "vi";
    }

    public static void setLanguage(Context context, LangType langType) {
        language = langType;
    }

    public static void showAlertDialog(Context context, String str, String str2, PaymentAlertDialog.OnOkListener onOkListener, PaymentAlertDialog.OnCancelListener onCancelListener) {
        PaymentAlertDialog paymentAlertDialog = new PaymentAlertDialog(context, onOkListener, onCancelListener);
        paymentAlertDialog.setOkButtonTitle(str2);
        paymentAlertDialog.showAlert(str);
    }

    public static void showAlertDialog(Context context, String str, PaymentAlertDialog.OnOkListener onOkListener) {
        new PaymentAlertDialog(context, onOkListener).showAlert(str);
    }

    public static String getExtInfo(JSONObject jSONObject) throws UnsupportedEncodingException, JSONException {
        return getExtInfo(jSONObject, true);
    }
}
