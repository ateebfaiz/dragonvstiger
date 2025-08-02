package com.sensorsdata.analytics.android.autotrack.core.business;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.ScreenAutoTracker;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackAppViewScreenUrl;
import org.json.JSONObject;

public class SAPageTools {
    private static String mCurrentScreenUrl;
    private static String mCurrentTitle;
    private static String mLastScreenUrl;
    private static String mReferrerTitle;
    private static JSONObject sCurrentScreenTrackProperties;
    private static JSONObject sLastTrackProperties;
    private static String sReferrer;
    private static long sReferrerTitleTime;
    private static long sReferrerUrlTime;
    private static long sTrackPropertiesTime;

    public static String getCurrentScreenUrl() {
        return mCurrentScreenUrl;
    }

    public static String getCurrentTitle() {
        return mCurrentTitle;
    }

    public static String getLastScreenUrl() {
        return mLastScreenUrl;
    }

    public static JSONObject getLastTrackProperties() {
        return sLastTrackProperties;
    }

    public static String getReferrer() {
        return sReferrer;
    }

    public static String getReferrerTitle() {
        return mReferrerTitle;
    }

    public static String getScreenUrl(Object obj) {
        String str = null;
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof ScreenAutoTracker) {
                str = ((ScreenAutoTracker) obj).getScreenUrl();
            } else {
                SensorsDataAutoTrackAppViewScreenUrl sensorsDataAutoTrackAppViewScreenUrl = (SensorsDataAutoTrackAppViewScreenUrl) obj.getClass().getAnnotation(SensorsDataAutoTrackAppViewScreenUrl.class);
                if (sensorsDataAutoTrackAppViewScreenUrl != null) {
                    str = sensorsDataAutoTrackAppViewScreenUrl.url();
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        if (str == null) {
            return obj.getClass().getCanonicalName();
        }
        return str;
    }

    public static void setCurrentScreenTrackProperties(JSONObject jSONObject) {
        if (System.currentTimeMillis() - sTrackPropertiesTime >= 400) {
            sLastTrackProperties = sCurrentScreenTrackProperties;
            sTrackPropertiesTime = System.currentTimeMillis();
        }
        sCurrentScreenTrackProperties = jSONObject;
    }

    public static void setCurrentScreenUrl(String str) {
        if (System.currentTimeMillis() - sReferrerUrlTime >= 400) {
            sReferrer = mCurrentScreenUrl;
            sReferrerUrlTime = System.currentTimeMillis();
        }
        mLastScreenUrl = mCurrentScreenUrl;
        mCurrentScreenUrl = str;
    }

    public static void setCurrentTitle(String str) {
        if (System.currentTimeMillis() - sReferrerTitleTime >= 400) {
            mReferrerTitle = mCurrentTitle;
            sReferrerTitleTime = System.currentTimeMillis();
        }
        mCurrentTitle = str;
    }

    public static void setLastScreenUrl(String str) {
        mLastScreenUrl = str;
    }
}
