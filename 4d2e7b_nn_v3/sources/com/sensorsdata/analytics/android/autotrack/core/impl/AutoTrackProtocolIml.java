package com.sensorsdata.analytics.android.autotrack.core.impl;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import com.sensorsdata.analytics.android.autotrack.core.beans.ViewContext;
import com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools;
import com.sensorsdata.analytics.android.autotrack.utils.AopUtil;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataIgnoreTrackAppClick;
import com.sensorsdata.analytics.android.sdk.SensorsDataIgnoreTrackAppViewScreen;
import com.sensorsdata.analytics.android.sdk.SensorsDataIgnoreTrackAppViewScreenAndAppClick;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol;
import com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class AutoTrackProtocolIml implements AutoTrackProtocol {
    private static final String TAG = "SA.AutoTrackProtocolIml";
    protected boolean mAutoTrack;
    protected List<Integer> mAutoTrackIgnoredActivities = new ArrayList();
    protected boolean mClearReferrerWhenAppEnd = false;
    private final SAContextManager mContextManager;
    protected IFragmentAPI mFragmentAPI = new FragmentAPI();
    protected List<Class<?>> mIgnoredViewTypeList = new ArrayList();
    private final SAConfigOptions mSAConfigOptions;

    public AutoTrackProtocolIml(SAContextManager sAContextManager) {
        this.mContextManager = sAContextManager;
        SAConfigOptions sAConfigOptions = sAContextManager.getInternalConfigs().saConfigOptions;
        this.mSAConfigOptions = sAConfigOptions;
        this.mAutoTrack = AppInfoUtils.getAppInfoBundle(sAContextManager.getContext()).getBoolean("com.sensorsdata.analytics.android.AutoTrack", false);
        if (sAConfigOptions.getAutoTrackEventType() != 0) {
            enableAutoTrack(sAConfigOptions.getAutoTrackEventType());
            this.mAutoTrack = true;
        }
    }

    public void clearLastScreenUrl() {
        if (this.mClearReferrerWhenAppEnd) {
            SAPageTools.setLastScreenUrl((String) null);
        }
    }

    public void clearReferrerWhenAppEnd() {
        this.mClearReferrerWhenAppEnd = true;
    }

    public void disableAutoTrack(List<SensorsDataAPI.AutoTrackEventType> list) {
        if (list != null) {
            try {
                if (this.mSAConfigOptions.getAutoTrackEventType() != 0) {
                    for (SensorsDataAPI.AutoTrackEventType next : list) {
                        if ((this.mSAConfigOptions.getAutoTrackEventType() | next.eventValue) == this.mSAConfigOptions.getAutoTrackEventType()) {
                            SAConfigOptions sAConfigOptions = this.mSAConfigOptions;
                            sAConfigOptions.setAutoTrackEventType(next.eventValue ^ sAConfigOptions.getAutoTrackEventType());
                        }
                    }
                    if (this.mSAConfigOptions.getAutoTrackEventType() == 0) {
                        this.mAutoTrack = false;
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void enableAutoTrack(List<SensorsDataAPI.AutoTrackEventType> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    this.mAutoTrack = true;
                    for (SensorsDataAPI.AutoTrackEventType autoTrackEventType : list) {
                        SAConfigOptions sAConfigOptions = this.mSAConfigOptions;
                        sAConfigOptions.setAutoTrackEventType(autoTrackEventType.eventValue | sAConfigOptions.getAutoTrackEventType());
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void enableAutoTrackFragment(Class<?> cls) {
        this.mFragmentAPI.enableAutoTrackFragment(cls);
    }

    public void enableAutoTrackFragments(List<Class<?>> list) {
        this.mFragmentAPI.enableAutoTrackFragments(list);
    }

    public List<Class<?>> getIgnoredViewTypeList() {
        if (this.mIgnoredViewTypeList == null) {
            this.mIgnoredViewTypeList = new ArrayList();
        }
        return this.mIgnoredViewTypeList;
    }

    public JSONObject getLastScreenTrackProperties() {
        try {
            JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(SAPageTools.getLastTrackProperties());
            if (cloneJsonObject != null) {
                cloneJsonObject.remove("$lib_method");
            }
            return cloneJsonObject;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return new JSONObject();
        }
    }

    public String getLastScreenUrl() {
        return SAPageTools.getLastScreenUrl();
    }

    public void ignoreAutoTrackActivities(List<Class<?>> list) {
        if (list != null && list.size() != 0) {
            if (this.mAutoTrackIgnoredActivities == null) {
                this.mAutoTrackIgnoredActivities = new ArrayList();
            }
            for (Class next : list) {
                if (next != null) {
                    int hashCode = next.hashCode();
                    if (!this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(hashCode))) {
                        this.mAutoTrackIgnoredActivities.add(Integer.valueOf(hashCode));
                    }
                }
            }
        }
    }

    public void ignoreAutoTrackActivity(Class<?> cls) {
        if (cls != null) {
            if (this.mAutoTrackIgnoredActivities == null) {
                this.mAutoTrackIgnoredActivities = new ArrayList();
            }
            try {
                int hashCode = cls.hashCode();
                if (!this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(hashCode))) {
                    this.mAutoTrackIgnoredActivities.add(Integer.valueOf(hashCode));
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void ignoreAutoTrackFragment(Class<?> cls) {
        this.mFragmentAPI.ignoreAutoTrackFragment(cls);
    }

    public void ignoreAutoTrackFragments(List<Class<?>> list) {
        this.mFragmentAPI.ignoreAutoTrackFragments(list);
    }

    public void ignoreView(View view) {
        if (view != null) {
            view.setTag(R.id.sensors_analytics_tag_view_ignored, "1");
        }
    }

    public void ignoreViewType(Class<?> cls) {
        if (cls != null) {
            if (this.mIgnoredViewTypeList == null) {
                this.mIgnoredViewTypeList = new ArrayList();
            }
            if (!this.mIgnoredViewTypeList.contains(cls)) {
                this.mIgnoredViewTypeList.add(cls);
            }
        }
    }

    public boolean isActivityAutoTrackAppClickIgnored(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        List<Integer> list = this.mAutoTrackIgnoredActivities;
        if ((list != null && list.contains(Integer.valueOf(cls.hashCode()))) || cls.getAnnotation(SensorsDataIgnoreTrackAppViewScreenAndAppClick.class) != null) {
            return true;
        }
        if (cls.getAnnotation(SensorsDataIgnoreTrackAppClick.class) != null) {
            return true;
        }
        return false;
    }

    public boolean isActivityAutoTrackAppViewScreenIgnored(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        List<Integer> list = this.mAutoTrackIgnoredActivities;
        if ((list != null && list.contains(Integer.valueOf(cls.hashCode()))) || cls.getAnnotation(SensorsDataIgnoreTrackAppViewScreenAndAppClick.class) != null) {
            return true;
        }
        if (cls.getAnnotation(SensorsDataIgnoreTrackAppViewScreen.class) != null) {
            return true;
        }
        return false;
    }

    public boolean isAutoTrackEnabled() {
        Boolean isAutoTrackEnabled;
        if (this.mContextManager.getRemoteManager() == null || (isAutoTrackEnabled = this.mContextManager.getRemoteManager().isAutoTrackEnabled()) == null) {
            return this.mAutoTrack;
        }
        return isAutoTrackEnabled.booleanValue();
    }

    public boolean isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
        if (autoTrackEventType == null) {
            return false;
        }
        return isAutoTrackEventTypeIgnored(autoTrackEventType.eventValue);
    }

    public boolean isFragmentAutoTrackAppViewScreen(Class<?> cls) {
        return this.mFragmentAPI.isFragmentAutoTrackAppViewScreen(cls);
    }

    public boolean isTrackFragmentAppViewScreenEnabled() {
        return this.mFragmentAPI.isTrackFragmentAppViewScreenEnabled();
    }

    public void resumeAutoTrackActivities(List<Class<?>> list) {
        if (list != null && list.size() != 0) {
            if (this.mAutoTrackIgnoredActivities == null) {
                this.mAutoTrackIgnoredActivities = new ArrayList();
            }
            try {
                for (Class next : list) {
                    if (next != null) {
                        int hashCode = next.hashCode();
                        if (this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(hashCode))) {
                            this.mAutoTrackIgnoredActivities.remove(Integer.valueOf(hashCode));
                        }
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void resumeAutoTrackActivity(Class<?> cls) {
        if (cls != null) {
            if (this.mAutoTrackIgnoredActivities == null) {
                this.mAutoTrackIgnoredActivities = new ArrayList();
            }
            try {
                int hashCode = cls.hashCode();
                if (this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(hashCode))) {
                    this.mAutoTrackIgnoredActivities.remove(Integer.valueOf(hashCode));
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void resumeIgnoredAutoTrackFragment(Class<?> cls) {
        this.mFragmentAPI.resumeIgnoredAutoTrackFragment(cls);
    }

    public void resumeIgnoredAutoTrackFragments(List<Class<?>> list) {
        this.mFragmentAPI.resumeIgnoredAutoTrackFragments(list);
    }

    public void setViewActivity(View view, Activity activity) {
        if (view != null && activity != null) {
            try {
                view.setTag(R.id.sensors_analytics_tag_view_activity, activity);
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void setViewFragmentName(View view, String str) {
        if (view != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    view.setTag(R.id.sensors_analytics_tag_view_fragment_name2, str);
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void setViewID(View view, String str) {
        if (view != null && !TextUtils.isEmpty(str)) {
            view.setTag(R.id.sensors_analytics_tag_view_id, str);
        }
    }

    public void setViewProperties(View view, JSONObject jSONObject) {
        if (view != null && jSONObject != null) {
            view.setTag(com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_properties, jSONObject);
        }
    }

    public void trackFragmentAppViewScreen() {
        this.mFragmentAPI.trackFragmentAppViewScreen();
    }

    public void trackViewAppClick(View view) {
        trackViewAppClick(view, (JSONObject) null);
    }

    public void trackViewScreen(final String str, JSONObject jSONObject) {
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                public void run() {
                    try {
                        if (TextUtils.isEmpty(str)) {
                            if (cloneJsonObject == null) {
                                return;
                            }
                        }
                        JSONObject jSONObject = new JSONObject();
                        String str = str;
                        JSONObject jSONObject2 = cloneJsonObject;
                        if (jSONObject2 != null) {
                            if (jSONObject2.has("$title")) {
                                SAPageTools.setCurrentTitle(cloneJsonObject.getString("$title"));
                            } else {
                                SAPageTools.setCurrentTitle((String) null);
                            }
                            if (cloneJsonObject.has("$url")) {
                                str = cloneJsonObject.optString("$url");
                            }
                        }
                        SAPageTools.setCurrentScreenUrl(str);
                        if (SAPageTools.getReferrer() != null) {
                            jSONObject.put("$referrer", SAPageTools.getReferrer());
                        }
                        jSONObject.put("$url", SAPageTools.getCurrentScreenUrl());
                        JSONObject jSONObject3 = cloneJsonObject;
                        if (jSONObject3 != null) {
                            JSONUtils.mergeJSONObject(jSONObject3, jSONObject);
                        }
                        SAPageTools.setCurrentScreenTrackProperties(jSONObject);
                        SACoreHelper.getInstance().trackEvent(new InputData().setEventName("$AppViewScreen").setEventType(EventType.TRACK).setProperties(jSONObject));
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void ignoreView(View view, boolean z10) {
        if (view != null) {
            view.setTag(R.id.sensors_analytics_tag_view_ignored, z10 ? "1" : "0");
        }
    }

    public boolean isAutoTrackEventTypeIgnored(int i10) {
        Boolean isAutoTrackEventTypeIgnored;
        if (this.mContextManager.getRemoteManager() == null || (isAutoTrackEventTypeIgnored = this.mContextManager.getRemoteManager().isAutoTrackEventTypeIgnored(i10)) == null) {
            return (i10 | this.mSAConfigOptions.getAutoTrackEventType()) != this.mSAConfigOptions.getAutoTrackEventType();
        }
        if (isAutoTrackEventTypeIgnored.booleanValue()) {
            SALog.i(TAG, "remote config: " + SensorsDataAPI.AutoTrackEventType.autoTrackEventName(i10) + " is ignored by remote config");
        }
        return isAutoTrackEventTypeIgnored.booleanValue();
    }

    public void trackViewAppClick(final View view, JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (view != null) {
            if (jSONObject != null) {
                try {
                    jSONObject2 = JSONUtils.cloneJsonObject(jSONObject);
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                    return;
                }
            } else {
                jSONObject2 = new JSONObject();
            }
            final JSONObject injectClickInfo = AopUtil.injectClickInfo(new ViewContext(view), jSONObject2, true);
            if (injectClickInfo != null) {
                SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                    public void run() {
                        try {
                            SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_MERGE_VISUAL_PROPERTIES, injectClickInfo, view);
                            SACoreHelper.getInstance().trackEvent(new InputData().setEventName("$AppClick").setEventType(EventType.TRACK).setProperties(injectClickInfo));
                        } catch (Exception e10) {
                            SALog.printStackTrace(e10);
                        }
                    }
                });
            }
        }
    }

    public void setViewID(Dialog dialog, String str) {
        if (dialog != null) {
            try {
                if (!TextUtils.isEmpty(str) && dialog.getWindow() != null) {
                    dialog.getWindow().getDecorView().setTag(R.id.sensors_analytics_tag_view_id, str);
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void trackViewScreen(Activity activity) {
        if (activity != null) {
            try {
                trackViewScreen(SAPageTools.getScreenUrl(activity), SAPageInfoUtils.getActivityPageInfo(activity));
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    private void enableAutoTrack(int i10) {
        if (i10 > 0 && i10 <= 15) {
            try {
                this.mAutoTrack = true;
                SAConfigOptions sAConfigOptions = this.mSAConfigOptions;
                sAConfigOptions.setAutoTrackEventType(i10 | sAConfigOptions.getAutoTrackEventType());
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void setViewID(Object obj, String str) {
        Class<AlertDialog> cls;
        Method method;
        Window window;
        Class<AlertDialog> cls2 = AlertDialog.class;
        if (obj != null) {
            try {
                int i10 = AlertDialog.f13887a;
                cls = cls2;
            } catch (Exception unused) {
                cls = null;
            }
            try {
                int i11 = AlertDialog.f13887a;
            } catch (Exception unused2) {
                cls2 = null;
            }
            if (cls == null) {
                cls = cls2;
            }
            if (cls != null) {
                try {
                    if (cls.isInstance(obj) && !TextUtils.isEmpty(str) && (method = obj.getClass().getMethod("getWindow", (Class[]) null)) != null && (window = (Window) method.invoke(obj, (Object[]) null)) != null) {
                        window.getDecorView().setTag(R.id.sensors_analytics_tag_view_id, str);
                    }
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004a, code lost:
        r0 = (com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle) r9.getClass().getAnnotation(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackViewScreen(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Class<com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle> r0 = com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class
            java.lang.Class<androidx.fragment.app.Fragment> r1 = androidx.fragment.app.Fragment.class
            if (r9 != 0) goto L_0x0007
            return
        L_0x0007:
            r2 = 0
            int r3 = androidx.fragment.app.Fragment.f15537a     // Catch:{ Exception -> 0x000c }
            r3 = r1
            goto L_0x000d
        L_0x000c:
            r3 = r2
        L_0x000d:
            java.lang.String r4 = "android.app.Fragment"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0015
        L_0x0014:
            r4 = r2
        L_0x0015:
            int r5 = androidx.fragment.app.Fragment.f15537a     // Catch:{ Exception -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r1 = r2
        L_0x0019:
            if (r3 == 0) goto L_0x0021
            boolean r3 = r3.isInstance(r9)
            if (r3 != 0) goto L_0x0033
        L_0x0021:
            if (r4 == 0) goto L_0x0029
            boolean r3 = r4.isInstance(r9)
            if (r3 != 0) goto L_0x0033
        L_0x0029:
            if (r1 == 0) goto L_0x00c1
            boolean r1 = r1.isInstance(r9)
            if (r1 != 0) goto L_0x0033
            goto L_0x00c1
        L_0x0033:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x005b }
            r1.<init>()     // Catch:{ Exception -> 0x005b }
            java.lang.Class r3 = r9.getClass()     // Catch:{ Exception -> 0x005b }
            java.lang.String r3 = r3.getCanonicalName()     // Catch:{ Exception -> 0x005b }
            java.lang.Class r4 = r9.getClass()     // Catch:{ Exception -> 0x005b }
            boolean r4 = r4.isAnnotationPresent(r0)     // Catch:{ Exception -> 0x005b }
            if (r4 == 0) goto L_0x005d
            java.lang.Class r4 = r9.getClass()     // Catch:{ Exception -> 0x005b }
            java.lang.annotation.Annotation r0 = r4.getAnnotation(r0)     // Catch:{ Exception -> 0x005b }
            com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle r0 = (com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle) r0     // Catch:{ Exception -> 0x005b }
            if (r0 == 0) goto L_0x005d
            java.lang.String r0 = r0.title()     // Catch:{ Exception -> 0x005b }
            goto L_0x005e
        L_0x005b:
            r9 = move-exception
            goto L_0x00be
        L_0x005d:
            r0 = r2
        L_0x005e:
            java.lang.Class r4 = r9.getClass()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r5 = "getActivity"
            java.lang.reflect.Method r4 = r4.getMethod(r5, r2)     // Catch:{ Exception -> 0x0071 }
            if (r4 == 0) goto L_0x0071
            java.lang.Object r4 = r4.invoke(r9, r2)     // Catch:{ Exception -> 0x0071 }
            android.app.Activity r4 = (android.app.Activity) r4     // Catch:{ Exception -> 0x0071 }
            r2 = r4
        L_0x0071:
            if (r2 == 0) goto L_0x0096
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x005b }
            if (r4 == 0) goto L_0x007d
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getActivityTitle(r2)     // Catch:{ Exception -> 0x005b }
        L_0x007d:
            java.util.Locale r4 = com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE     // Catch:{ Exception -> 0x005b }
            java.lang.String r5 = "%s|%s"
            java.lang.Class r2 = r2.getClass()     // Catch:{ Exception -> 0x005b }
            java.lang.String r2 = r2.getCanonicalName()     // Catch:{ Exception -> 0x005b }
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x005b }
            r7 = 0
            r6[r7] = r2     // Catch:{ Exception -> 0x005b }
            r2 = 1
            r6[r2] = r3     // Catch:{ Exception -> 0x005b }
            java.lang.String r3 = java.lang.String.format(r4, r5, r6)     // Catch:{ Exception -> 0x005b }
        L_0x0096:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x005b }
            if (r2 != 0) goto L_0x00a1
            java.lang.String r2 = "$title"
            r1.put(r2, r0)     // Catch:{ Exception -> 0x005b }
        L_0x00a1:
            java.lang.String r0 = "$screen_name"
            r1.put(r0, r3)     // Catch:{ Exception -> 0x005b }
            boolean r0 = r9 instanceof com.sensorsdata.analytics.android.sdk.ScreenAutoTracker     // Catch:{ Exception -> 0x005b }
            if (r0 == 0) goto L_0x00b6
            r0 = r9
            com.sensorsdata.analytics.android.sdk.ScreenAutoTracker r0 = (com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) r0     // Catch:{ Exception -> 0x005b }
            org.json.JSONObject r0 = r0.getTrackProperties()     // Catch:{ Exception -> 0x005b }
            if (r0 == 0) goto L_0x00b6
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(r0, r1)     // Catch:{ Exception -> 0x005b }
        L_0x00b6:
            java.lang.String r9 = com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getScreenUrl(r9)     // Catch:{ Exception -> 0x005b }
            r8.trackViewScreen(r9, r1)     // Catch:{ Exception -> 0x005b }
            goto L_0x00c1
        L_0x00be:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r9)
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.autotrack.core.impl.AutoTrackProtocolIml.trackViewScreen(java.lang.Object):void");
    }

    public void disableAutoTrack(SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
        if (autoTrackEventType != null) {
            try {
                if (this.mSAConfigOptions.getAutoTrackEventType() != 0) {
                    int autoTrackEventType2 = this.mSAConfigOptions.getAutoTrackEventType();
                    int i10 = autoTrackEventType.eventValue;
                    int i11 = autoTrackEventType2 | i10;
                    if (i11 == i10) {
                        this.mSAConfigOptions.setAutoTrackEventType(0);
                    } else {
                        this.mSAConfigOptions.setAutoTrackEventType(i10 ^ i11);
                    }
                    if (this.mSAConfigOptions.getAutoTrackEventType() == 0) {
                        this.mAutoTrack = false;
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }
}
