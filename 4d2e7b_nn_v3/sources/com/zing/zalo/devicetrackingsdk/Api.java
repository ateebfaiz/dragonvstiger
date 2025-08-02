package com.zing.zalo.devicetrackingsdk;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.pdns.f;
import com.google.firebase.messaging.Constants;
import com.zing.zalo.devicetrackingsdk.model.PreloadInfo;
import com.zing.zalo.zalosdk.Constant;
import com.zing.zalo.zalosdk.core.helper.AppInfo;
import com.zing.zalo.zalosdk.core.helper.DeviceHelper;
import com.zing.zalo.zalosdk.core.helper.Utils;
import com.zing.zalo.zalosdk.core.http.HttpClientFactory;
import com.zing.zalo.zalosdk.core.http.HttpClientRequest;
import com.zing.zalo.zalosdk.core.servicemap.ServiceMapManager;
import com.zing.zalo.zalosdk.core.type.FromSourceType;
import com.zing.zalo.zalosdk.core.type.PlatformType;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

class Api {
    String appId;
    boolean isPreInstalled;
    HttpClientFactory requestFactory;
    String sdkId;
    String viewer;

    static class DeviceIdResponse {
        String deviceId;
        long expireTime;

        DeviceIdResponse(String str, long j10) {
            this.deviceId = str;
            this.expireTime = j10;
        }
    }

    static class SDKIdResponse {
        String privateKey;
        String sdkId;

        SDKIdResponse(String str, String str2) {
            this.sdkId = str;
            this.privateKey = str2;
        }
    }

    Api() {
        this.requestFactory = new HttpClientFactory();
    }

    /* access modifiers changed from: package-private */
    public DeviceIdResponse getDeviceId(Context context, String str) throws JSONException {
        return getDeviceId(context, str, System.currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public SDKIdResponse getSdkId(Context context) throws JSONException {
        JSONObject prepareDeviceIdData = prepareDeviceIdData(context);
        HttpClientRequest newRequest = this.requestFactory.newRequest(HttpClientRequest.Type.POST, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_CENTRALIZED, Constant.API_SDK_ID_URL));
        newRequest.addParams("appId", this.appId);
        newRequest.addParams("sdkv", Utils.getSDKVersion());
        newRequest.addParams("pl", f.f17924q);
        newRequest.addParams("osv", DeviceHelper.getOSVersion());
        newRequest.addParams("model", DeviceHelper.getModel());
        newRequest.addParams("screenSize", DeviceHelper.getScreenSize(context));
        newRequest.addParams("device", prepareDeviceIdData.toString());
        newRequest.addParams("ref", AppInfo.getReferrer(context));
        JSONObject json = newRequest.getJSON();
        if (json == null || json.getInt(Constants.IPC_BUNDLE_KEY_SEND_ERROR) != 0) {
            return null;
        }
        JSONObject jSONObject = json.getJSONObject("data");
        return new SDKIdResponse(jSONObject.optString("sdkId"), jSONObject.optString("privateKey"));
    }

    /* access modifiers changed from: package-private */
    public JSONObject prepareCommonHeaderData(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fs", "" + FromSourceType.SDK.getCode());
            jSONObject.put("sdkv", "" + Utils.getSDKVersionCode());
            jSONObject.put("av", AppInfo.getVersionName(context));
            jSONObject.put("an", AppInfo.getAppName(context));
            jSONObject.put("plf", "" + PlatformType.ANDROID.getCode());
            jSONObject.put("osv", DeviceHelper.getOSVersion());
            jSONObject.put("conn", DeviceHelper.getNetworkType(context));
            jSONObject.put("mno", DeviceHelper.getMobileNetworkCode(context));
            jSONObject.put("mod", DeviceHelper.getModel());
            jSONObject.put("dId", DeviceHelper.getAdvertiseID(context));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public JSONObject prepareDeviceIdData(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dId", DeviceHelper.getAdvertiseID(context));
            jSONObject.put("aId", DeviceHelper.getAndroidId(context));
            jSONObject.put("ser", DeviceHelper.getSerial());
            jSONObject.put("mod", DeviceHelper.getModel());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    public JSONObject prepareExtraInfo(int i10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from_source", "" + i10);
            jSONObject.put("sdk_ver", "" + Utils.getSDKVersionCode());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public JSONObject prepareTrackingData(Context context, String str, long j10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pkg", AppInfo.getPackageName(context));
            jSONObject.put("pl", f.f17924q);
            jSONObject.put("osv", DeviceHelper.getOSVersion());
            jSONObject.put("sdkv", Utils.getSDKVersion());
            jSONObject.put("an", AppInfo.getAppName(context));
            jSONObject.put("av", AppInfo.getVersionName(context));
            jSONObject.put("dId", DeviceHelper.getAdvertiseID(context));
            jSONObject.put("aId", DeviceHelper.getAndroidId(context));
            jSONObject.put("ser", DeviceHelper.getSerial());
            jSONObject.put("mod", DeviceHelper.getModel());
            jSONObject.put("ss", DeviceHelper.getScreenSize(context));
            jSONObject.put("mac", DeviceHelper.getWLANMACAddress(context));
            jSONObject.put("conn", DeviceHelper.getConnectionType(context));
            jSONObject.put("mno", DeviceHelper.getMobileNetworkCode(context));
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("sId", str);
            }
            jSONObject.put("adId", DeviceHelper.getAdvertiseID(context));
            jSONObject.put("ins_pkg", AppInfo.getInstallerPackageName(context));
            if (!TextUtils.isEmpty(AppInfo.getReferrer(context))) {
                jSONObject.put("ref", AppInfo.getReferrer(context));
            }
            jSONObject.put("ins_dte", AppInfo.getInstallDate(context));
            jSONObject.put("fst_ins_dte", AppInfo.getFirstInstallDate(context));
            jSONObject.put("lst_ins_dte", AppInfo.getLastUpdateDate(context));
            jSONObject.put("fst_run_dte", AppInfo.getFirstRunDate(context));
            jSONObject.put("ts", String.valueOf(j10));
            jSONObject.put("brd", DeviceHelper.getBrand());
            jSONObject.put("dev", Build.DEVICE);
            jSONObject.put("prd", DeviceHelper.getProduct());
            jSONObject.put("adk_ver", Build.VERSION.SDK_INT);
            jSONObject.put("mnft", DeviceHelper.getManufacturer());
            jSONObject.put("dev_type", Build.TYPE);
            jSONObject.put("avc", AppInfo.getVersionCode(context));
            jSONObject.put("was_ins", String.valueOf(this.isPreInstalled));
            jSONObject.put("lang", Locale.getDefault().toString());
            jSONObject.put("dpi", (double) context.getResources().getDisplayMetrics().density);
            PreloadInfo preloadInfo = DeviceHelper.getPreloadInfo(context);
            jSONObject.put("preload", preloadInfo.preload);
            jSONObject.put("preloadDefault", AppInfo.getPreloadChannel(context));
            if (!preloadInfo.isPreloaded()) {
                jSONObject.put("preloadFailed", preloadInfo.error);
            }
            Location location = DeviceHelper.getLocation(context);
            if (location != null) {
                jSONObject.put("lat", String.valueOf(location.getLatitude()));
                jSONObject.put("lng", String.valueOf(location.getLongitude()));
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public DeviceIdResponse getDeviceId(Context context, String str, long j10) throws JSONException {
        JSONObject prepareDeviceIdData = prepareDeviceIdData(context);
        JSONObject prepareTrackingData = prepareTrackingData(context, str, j10);
        if (this.sdkId == null) {
            this.sdkId = "";
        }
        String str2 = this.appId;
        String str3 = this.viewer;
        String jSONObject = prepareDeviceIdData.toString();
        String jSONObject2 = prepareTrackingData.toString();
        String signature = Utils.getSignature(new String[]{"pl", "appId", "viewer", "device", "data", "ts", "sdkId"}, new String[]{f.f17924q, str2, str3, jSONObject, jSONObject2, "" + j10, this.sdkId}, Constant.TRK_SECRECT_KEY);
        HttpClientRequest newRequest = this.requestFactory.newRequest(HttpClientRequest.Type.POST, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_CENTRALIZED, Constant.API_HARDWARE_ID_URL));
        newRequest.addParams("pl", f.f17924q);
        newRequest.addParams("appId", this.appId);
        newRequest.addParams("viewer", this.viewer);
        newRequest.addParams("device", prepareDeviceIdData.toString());
        newRequest.addParams("data", prepareTrackingData.toString());
        newRequest.addParams("ts", "" + j10);
        newRequest.addParams("sig", signature);
        newRequest.addParams("sdkId", this.sdkId);
        JSONObject json = newRequest.getJSON();
        if (json == null || json.getInt(Constants.IPC_BUNDLE_KEY_SEND_ERROR) != 0) {
            return null;
        }
        JSONObject jSONObject3 = json.getJSONObject("data");
        return new DeviceIdResponse(jSONObject3.optString("deviceId"), jSONObject3.optLong("expiredTime") + System.currentTimeMillis());
    }

    Api(HttpClientFactory httpClientFactory) {
        this.requestFactory = httpClientFactory;
    }
}
