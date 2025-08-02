package com.sensorsdata.analytics.android.sdk.advert.scan;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper;
import com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpMethod;
import com.sensorsdata.analytics.android.sdk.network.RequestHelper;
import com.sensorsdata.analytics.android.sdk.util.SADisplayUtil;
import com.sensorsdata.analytics.android.sdk.util.ToastUtil;
import com.zing.zalo.zalosdk.common.Constant;
import org.json.JSONObject;
import xa.a;

public class WhiteListScanHelper implements IAdvertScanListener {
    private static void updateWhitelist(final Activity activity, final String str, final String str2, final String str3) {
        new Thread() {
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("android_oaid", SAOaidHelper.getOpenAdIdentifier(activity));
                    jSONObject.put("android_oaid_reflection", SAOaidHelper.getOpenAdIdentifierByReflection(activity));
                    jSONObject.put("android_id", SAAdvertUtils.getIdentifier(activity));
                    jSONObject.put("android_imei", SAAdvertUtils.getInstallSource(activity));
                    jSONObject.put("info_id", str2);
                    jSONObject.put("project_name", str3);
                    jSONObject.put("device_type", ExifInterface.GPS_MEASUREMENT_2D);
                    new RequestHelper.Builder(HttpMethod.POST, str).jsonData(jSONObject.toString()).callback(new HttpCallback.JsonCallback() {
                        public void onAfter() {
                            SensorsDataDialogUtils.startLaunchActivity(activity);
                        }

                        public void onFailure(int i10, String str) {
                            Activity activity = activity;
                            ToastUtil.showLong(activity, SADisplayUtil.getStringResource(activity, a.A));
                        }

                        public void onResponse(JSONObject jSONObject) {
                            if (jSONObject.optInt(Constant.PARAM_OAUTH_CODE, -1) == 0) {
                                Activity activity = activity;
                                ToastUtil.showLong(activity, SADisplayUtil.getStringResource(activity, a.B));
                                return;
                            }
                            Activity activity2 = activity;
                            ToastUtil.showLong(activity2, SADisplayUtil.getStringResource(activity2, a.A));
                        }
                    }).execute();
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        }.start();
    }

    public void handlerScanUri(Activity activity, Uri uri) {
        if (!ExifInterface.GPS_MEASUREMENT_2D.equals(uri.getQueryParameter("device_type"))) {
            ToastUtil.showLong(activity, SADisplayUtil.getStringResource(activity, a.f13323y));
            SensorsDataDialogUtils.startLaunchActivity(activity);
            return;
        }
        String queryParameter = uri.getQueryParameter("apiurl");
        String queryParameter2 = uri.getQueryParameter("info_id");
        if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2)) {
            ToastUtil.showLong(activity, SADisplayUtil.getStringResource(activity, a.A));
            SensorsDataDialogUtils.startLaunchActivity(activity);
            return;
        }
        String queryParameter3 = uri.getQueryParameter("project");
        if (TextUtils.isEmpty(queryParameter3)) {
            queryParameter3 = "default";
        }
        if (!queryParameter3.equals(new ServerUrl(SensorsDataAPI.sharedInstance().getServerUrl()).getProject())) {
            ToastUtil.showLong(activity, SADisplayUtil.getStringResource(activity, a.f13324z));
            SensorsDataDialogUtils.startLaunchActivity(activity);
            return;
        }
        updateWhitelist(activity, queryParameter, queryParameter2, queryParameter3);
    }
}
