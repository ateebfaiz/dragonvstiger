package com.sensorsdata.analytics.android.sdk.core.mediator.autotrack;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import java.util.List;
import org.json.JSONObject;

public interface AutoTrackProtocol extends IFragmentAPI {
    void clearLastScreenUrl();

    void clearReferrerWhenAppEnd();

    void disableAutoTrack(SensorsDataAPI.AutoTrackEventType autoTrackEventType);

    void disableAutoTrack(List<SensorsDataAPI.AutoTrackEventType> list);

    void enableAutoTrack(List<SensorsDataAPI.AutoTrackEventType> list);

    List<Class<?>> getIgnoredViewTypeList();

    JSONObject getLastScreenTrackProperties();

    String getLastScreenUrl();

    void ignoreAutoTrackActivities(List<Class<?>> list);

    void ignoreAutoTrackActivity(Class<?> cls);

    void ignoreView(View view);

    void ignoreView(View view, boolean z10);

    void ignoreViewType(Class<?> cls);

    boolean isActivityAutoTrackAppClickIgnored(Class<?> cls);

    boolean isActivityAutoTrackAppViewScreenIgnored(Class<?> cls);

    boolean isAutoTrackEnabled();

    boolean isAutoTrackEventTypeIgnored(int i10);

    boolean isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType autoTrackEventType);

    void resumeAutoTrackActivities(List<Class<?>> list);

    void resumeAutoTrackActivity(Class<?> cls);

    void setViewActivity(View view, Activity activity);

    void setViewFragmentName(View view, String str);

    void setViewID(Dialog dialog, String str);

    void setViewID(View view, String str);

    void setViewID(Object obj, String str);

    void setViewProperties(View view, JSONObject jSONObject);

    void trackViewAppClick(View view);

    void trackViewAppClick(View view, JSONObject jSONObject);

    void trackViewScreen(Activity activity);

    void trackViewScreen(Object obj);

    void trackViewScreen(String str, JSONObject jSONObject);
}
