package com.sensorsdata.analytics.android.autotrack.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.ToggleButton;
import com.sensorsdata.analytics.android.autotrack.R;
import com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants;
import com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.ScreenAutoTracker;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils;
import com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.SAViewUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AopUtil {
    private static final String TAG = "SA.AopUtil";

    public static JSONObject buildTitleNoAutoTrackerProperties(Activity activity) {
        JSONObject trackProperties;
        try {
            JSONObject buildTitleAndScreenName = SAViewUtils.buildTitleAndScreenName(activity);
            if ((activity instanceof ScreenAutoTracker) && (trackProperties = ((ScreenAutoTracker) activity).getTrackProperties()) != null) {
                if (trackProperties.has("$screen_name")) {
                    buildTitleAndScreenName.put("$screen_name", trackProperties.optString("$screen_name"));
                }
                if (trackProperties.has("$title")) {
                    buildTitleAndScreenName.put("$title", trackProperties.optString("$title"));
                }
            }
            return buildTitleAndScreenName;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return new JSONObject();
        }
    }

    public static JSONObject injectClickInfo(ViewContext viewContext, JSONObject jSONObject, boolean z10) {
        View view = viewContext.view;
        if (view == null) {
            return jSONObject;
        }
        try {
            if (!isTrackEvent(view, z10)) {
                return null;
            }
            Context context = viewContext.view.getContext();
            JSONObject jSONObject2 = new JSONObject();
            String viewId = SAViewUtils.getViewId(viewContext.view);
            if (!TextUtils.isEmpty(viewId)) {
                jSONObject2.put(AutoTrackConstants.ELEMENT_ID, viewId);
            }
            String viewContent = SAViewUtils.getViewContent(viewContext.view);
            if (!TextUtils.isEmpty(viewContent)) {
                jSONObject2.put(AutoTrackConstants.ELEMENT_CONTENT, viewContent);
            }
            jSONObject2.put(AutoTrackConstants.ELEMENT_TYPE, SAViewUtils.getViewType(viewContext.view));
            Activity activity = viewContext.activity;
            if (activity == null) {
                activity = SAViewUtils.getActivityOfView(context, viewContext.view);
            }
            if (activity != null) {
                JSONUtils.mergeJSONObject(SAPageInfoUtils.getActivityPageInfo(activity), jSONObject2);
            }
            Object obj = viewContext.fragment;
            if (obj == null) {
                obj = SAFragmentUtils.getFragmentFromView(viewContext.view, activity);
            }
            if (obj != null) {
                JSONUtils.mergeJSONObject(SAPageInfoUtils.getFragmentPageInfo(activity, obj), jSONObject2);
            }
            JSONObject jSONObject3 = (JSONObject) viewContext.view.getTag(R.id.sensors_analytics_tag_view_properties);
            if (jSONObject3 != null) {
                JSONUtils.mergeJSONObject(jSONObject3, jSONObject2);
            }
            JSONUtils.mergeDistinctProperty(jSONObject2, jSONObject);
            return jSONObject;
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
            return jSONObject;
        }
    }

    static boolean isTrackEvent(View view, boolean z10) {
        if (view instanceof CheckBox) {
            if (!z10) {
                return false;
            }
        } else if (view instanceof RadioButton) {
            if (!z10) {
                return false;
            }
        } else if (view instanceof ToggleButton) {
            if (!z10) {
                return false;
            }
        } else if ((view instanceof CompoundButton) && !z10) {
            return false;
        }
        if (view instanceof RatingBar) {
            return z10;
        }
        return true;
    }
}
