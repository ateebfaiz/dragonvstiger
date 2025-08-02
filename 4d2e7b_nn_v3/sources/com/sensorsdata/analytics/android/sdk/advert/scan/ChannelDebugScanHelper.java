package com.sensorsdata.analytics.android.sdk.advert.scan;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants;
import com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataLoadingDialog;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpMethod;
import com.sensorsdata.analytics.android.sdk.network.RequestHelper;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SADisplayUtil;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.Date;
import org.json.JSONObject;
import xa.a;

public class ChannelDebugScanHelper implements IAdvertScanListener {
    /* access modifiers changed from: private */
    public static void requestActiveChannel(String str, String str2, String str3, String str4, String str5, boolean z10, HttpCallback httpCallback) {
        String str6;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("monitor_id", str2);
            jSONObject.put("distinct_id", SensorsDataAPI.sharedInstance().getDistinctId());
            jSONObject.put("project_id", str3);
            jSONObject.put("account_id", str4);
            if (z10) {
                str6 = "true";
            } else {
                str6 = "false";
            }
            jSONObject.put("has_active", str6);
            jSONObject.put("device_code", str5);
            HttpMethod httpMethod = HttpMethod.POST;
            new RequestHelper.Builder(httpMethod, str + "/api/sdk/channel_tool/url").jsonData(jSONObject.toString()).callback(httpCallback).execute();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void showChannelDebugActiveDialog(final Activity activity) {
        SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, a.f13313o), SADisplayUtil.getStringResource(activity, a.f13310l), SADisplayUtil.getStringResource(activity, a.f13308j), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i10) {
                ChannelDebugScanHelper.trackChannelDebugInstallation(activity);
                ChannelDebugScanHelper.showChannelDebugActiveDialog(activity);
            }
        }, SADisplayUtil.getStringResource(activity, a.f13309k), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i10) {
                SensorsDataDialogUtils.startLaunchActivity(activity);
            }
        });
    }

    public static void showChannelDebugDialog(final Activity activity, String str, String str2, String str3, String str4) {
        final Activity activity2 = activity;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, a.f13312n), "", SADisplayUtil.getStringResource(activity, a.f13311m), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i10) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                Context applicationContext = activity2.getApplicationContext();
                boolean isTrackInstallation = ChannelUtils.isTrackInstallation();
                if (!isTrackInstallation || ChannelUtils.isCorrectTrackInstallation()) {
                    String identifier = SensorsDataUtils.getIdentifier(applicationContext);
                    String openAdIdentifier = SAOaidHelper.getOpenAdIdentifier(applicationContext);
                    if (isTrackInstallation && !ChannelUtils.isGetDeviceInfo(identifier, openAdIdentifier)) {
                        ChannelDebugScanHelper.showChannelDebugErrorDialog(activity2);
                    } else if (!NetworkUtils.isNetworkAvailable(applicationContext)) {
                        Activity activity = activity2;
                        SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, a.f13316r));
                    } else {
                        Activity activity2 = activity2;
                        String deviceInfo = ChannelUtils.getDeviceInfo(activity2, identifier, openAdIdentifier, SAOaidHelper.getOpenAdIdentifierByReflection(activity2));
                        final SensorsDataLoadingDialog sensorsDataLoadingDialog = new SensorsDataLoadingDialog(activity2);
                        SensorsDataDialogUtils.dialogShowDismissOld(sensorsDataLoadingDialog);
                        ChannelDebugScanHelper.requestActiveChannel(str5, str6, str7, str8, deviceInfo, isTrackInstallation, new HttpCallback.JsonCallback() {
                            public void onFailure(int i10, String str) {
                                sensorsDataLoadingDialog.dismiss();
                                SALog.i(SAAdvertConstants.TAG, "ChannelDebug request error:" + str);
                                Activity activity = activity2;
                                SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, a.f13318t));
                            }

                            public void onResponse(JSONObject jSONObject) {
                                sensorsDataLoadingDialog.dismiss();
                                if (jSONObject == null) {
                                    SALog.i(SAAdvertConstants.TAG, "ChannelDebug response error msg: response is null");
                                    Activity activity = activity2;
                                    SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, a.f13321w));
                                } else if (jSONObject.optInt(Constant.PARAM_OAUTH_CODE, 0) == 1) {
                                    ChannelDebugScanHelper.showChannelDebugActiveDialog(activity2);
                                } else {
                                    SALog.i(SAAdvertConstants.TAG, "ChannelDebug response error msg:" + jSONObject.optString("message"));
                                    Activity activity2 = activity2;
                                    SensorsDataDialogUtils.showDialog(activity2, SADisplayUtil.getStringResource(activity2, a.f13321w));
                                }
                            }
                        });
                    }
                } else {
                    ChannelDebugScanHelper.showChannelDebugErrorDialog(activity2);
                }
            }
        }, SADisplayUtil.getStringResource(activity, a.f13309k), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i10) {
                SensorsDataDialogUtils.startLaunchActivity(activity);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void showChannelDebugErrorDialog(final Activity activity) {
        SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, a.f13315q), SADisplayUtil.getStringResource(activity, a.f13314p), SADisplayUtil.getStringResource(activity, a.f13311m), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i10) {
                SensorsDataDialogUtils.startLaunchActivity(activity);
            }
        }, (String) null, (DialogInterface.OnClickListener) null);
    }

    /* access modifiers changed from: private */
    public static void trackChannelDebugInstallation(final Activity activity) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    Activity activity = activity;
                    jSONObject.put("$ios_install_source", ChannelUtils.getDeviceInfo(activity, SAAdvertUtils.getIdentifier(activity), SAOaidHelper.getOpenAdIdentifier(activity), SAOaidHelper.getOpenAdIdentifierByReflection(activity)));
                    SACoreHelper.getInstance().trackEvent(new InputData().setEventType(EventType.TRACK).setEventName("$ChannelDebugInstall").setProperties(jSONObject));
                    JSONObject jSONObject2 = new JSONObject();
                    JSONUtils.mergeJSONObject(jSONObject, jSONObject2);
                    jSONObject2.put("$first_visit_time", new Date());
                    SACoreHelper.getInstance().trackEvent(new InputData().setEventType(EventType.PROFILE_SET_ONCE).setProperties(jSONObject2));
                    SensorsDataAPI.sharedInstance().flush();
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        }).start();
    }

    public void handlerScanUri(Activity activity, Uri uri) {
        if (ChannelUtils.hasUtmByMetaData(activity)) {
            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, a.f13322x));
            return;
        }
        String queryParameter = uri.getQueryParameter("monitor_id");
        if (TextUtils.isEmpty(queryParameter)) {
            SensorsDataDialogUtils.startLaunchActivity(activity);
            return;
        }
        String serverUrl = SensorsDataAPI.sharedInstance().getServerUrl();
        if (TextUtils.isEmpty(serverUrl)) {
            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, a.f13320v));
            return;
        }
        ServerUrl serverUrl2 = new ServerUrl(serverUrl);
        if (serverUrl2.getProject().equals(uri.getQueryParameter("project_name"))) {
            String queryParameter2 = uri.getQueryParameter("project_id");
            String queryParameter3 = uri.getQueryParameter("account_id");
            if (!"1".equals(uri.getQueryParameter("is_relink"))) {
                showChannelDebugDialog(activity, serverUrl2.getBaseUrl(), queryParameter, queryParameter2, queryParameter3);
            } else if (ChannelUtils.checkDeviceInfo(activity, uri.getQueryParameter("device_code"))) {
                showChannelDebugActiveDialog(activity);
            } else {
                SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, a.f13319u));
            }
        } else {
            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, a.f13317s));
        }
    }
}
