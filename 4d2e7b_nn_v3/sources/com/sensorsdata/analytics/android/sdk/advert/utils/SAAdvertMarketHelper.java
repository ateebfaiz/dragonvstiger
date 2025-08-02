package com.sensorsdata.analytics.android.sdk.advert.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SAAdvertisingConfig;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants;
import com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager;
import com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDailyDate;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import org.json.JSONObject;

public class SAAdvertMarketHelper {
    public static void handleAdMarket(final Activity activity, final SAAdvertisingConfig sAAdvertisingConfig) {
        if (sAAdvertisingConfig != null) {
            try {
                if (sAAdvertisingConfig.isEnableRemarketing() && isDailyFirst()) {
                    SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                        public void run() {
                            Intent intent;
                            try {
                                boolean z10 = true;
                                if (!TextUtils.isEmpty(sAAdvertisingConfig.getWakeupUrl())) {
                                    intent = Intent.parseUri(sAAdvertisingConfig.getWakeupUrl(), 1);
                                } else {
                                    intent = null;
                                }
                                Context applicationContext = activity.getApplicationContext();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("$ios_install_source", ChannelUtils.getDeviceInfo(applicationContext, SensorsDataUtils.getIdentifier(applicationContext), SAOaidHelper.getOpenAdIdentifier(applicationContext), SAOaidHelper.getOpenAdIdentifierByReflection(applicationContext)));
                                if (!DeepLinkManager.isDeepLink(activity.getIntent())) {
                                    if (!DeepLinkManager.isDeepLink(intent)) {
                                        z10 = false;
                                    }
                                }
                                jSONObject.put("$sat_awake_from_deeplink", z10);
                                jSONObject.put("$sat_has_installed_app", SAAdvertUtils.isInstallationTracked());
                                SACoreHelper.getInstance().trackEvent(new InputData().setEventType(EventType.TRACK).setEventName(SAAdvertConstants.EventName.APP_INTERACT).setProperties(jSONObject));
                            } catch (Exception e10) {
                                SALog.printStackTrace(e10);
                            }
                        }
                    });
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static boolean isDailyFirst() {
        PersistentDailyDate dayDatePst = PersistentLoader.getInstance().getDayDatePst();
        String formatTime = TimeUtils.formatTime(System.currentTimeMillis(), TimeUtils.YYYY_MM_DD);
        if (formatTime.equals(dayDatePst.get())) {
            return false;
        }
        dayDatePst.commit(formatTime);
        return true;
    }
}
