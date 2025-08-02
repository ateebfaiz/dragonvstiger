package com.sensorsdata.analytics.android.sdk.util;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.ScreenAutoTracker;
import org.json.JSONObject;

public class SAPageInfoUtils {
    public static final String SCREEN_NAME = "$screen_name";
    public static final String TITLE = "$title";

    public static JSONObject getActivityPageInfo(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$screen_name", activity.getClass().getCanonicalName());
            String activityTitle = SensorsDataUtils.getActivityTitle(activity);
            if (!TextUtils.isEmpty(activityTitle)) {
                jSONObject.put("$title", activityTitle);
            }
            if (activity instanceof ScreenAutoTracker) {
                JSONUtils.mergeJSONObject(((ScreenAutoTracker) activity).getTrackProperties(), jSONObject);
            }
            return jSONObject;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return new JSONObject();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065 A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006b A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a3 A[Catch:{ Exception -> 0x0024 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject getFragmentPageInfo(android.app.Activity r9, java.lang.Object r10) {
        /*
            java.lang.Class<com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle> r0 = com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            boolean r2 = r10 instanceof com.sensorsdata.analytics.android.sdk.ScreenAutoTracker     // Catch:{ Exception -> 0x0024 }
            r3 = 0
            java.lang.String r4 = "$title"
            java.lang.String r5 = "$screen_name"
            if (r2 == 0) goto L_0x0036
            r2 = r10
            com.sensorsdata.analytics.android.sdk.ScreenAutoTracker r2 = (com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) r2     // Catch:{ Exception -> 0x0024 }
            org.json.JSONObject r2 = r2.getTrackProperties()     // Catch:{ Exception -> 0x0024 }
            if (r2 == 0) goto L_0x0036
            boolean r6 = r2.has(r5)     // Catch:{ Exception -> 0x0024 }
            if (r6 == 0) goto L_0x0027
            java.lang.String r6 = r2.optString(r5)     // Catch:{ Exception -> 0x0024 }
            goto L_0x0028
        L_0x0024:
            r9 = move-exception
            goto L_0x00af
        L_0x0027:
            r6 = r3
        L_0x0028:
            boolean r7 = r2.has(r4)     // Catch:{ Exception -> 0x0024 }
            if (r7 == 0) goto L_0x0032
            java.lang.String r3 = r2.optString(r4)     // Catch:{ Exception -> 0x0024 }
        L_0x0032:
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(r2, r1)     // Catch:{ Exception -> 0x0024 }
            goto L_0x0037
        L_0x0036:
            r6 = r3
        L_0x0037:
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0024 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0024 }
            if (r2 == 0) goto L_0x005b
            java.lang.Class r2 = r10.getClass()     // Catch:{ Exception -> 0x0024 }
            boolean r2 = r2.isAnnotationPresent(r0)     // Catch:{ Exception -> 0x0024 }
            if (r2 == 0) goto L_0x005b
            java.lang.Class r2 = r10.getClass()     // Catch:{ Exception -> 0x0024 }
            java.lang.annotation.Annotation r0 = r2.getAnnotation(r0)     // Catch:{ Exception -> 0x0024 }
            com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle r0 = (com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle) r0     // Catch:{ Exception -> 0x0024 }
            if (r0 == 0) goto L_0x005b
            java.lang.String r3 = r0.title()     // Catch:{ Exception -> 0x0024 }
        L_0x005b:
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0024 }
            if (r0 != 0) goto L_0x0063
            if (r7 == 0) goto L_0x0094
        L_0x0063:
            if (r9 != 0) goto L_0x0069
            android.app.Activity r9 = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getActivityFromFragment(r10)     // Catch:{ Exception -> 0x0024 }
        L_0x0069:
            if (r9 == 0) goto L_0x0094
            if (r0 == 0) goto L_0x0071
            java.lang.String r3 = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getActivityTitle(r9)     // Catch:{ Exception -> 0x0024 }
        L_0x0071:
            if (r7 == 0) goto L_0x0094
            java.lang.Class r0 = r10.getClass()     // Catch:{ Exception -> 0x0024 }
            java.lang.String r0 = r0.getCanonicalName()     // Catch:{ Exception -> 0x0024 }
            java.util.Locale r2 = com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE     // Catch:{ Exception -> 0x0024 }
            java.lang.String r6 = "%s|%s"
            java.lang.Class r9 = r9.getClass()     // Catch:{ Exception -> 0x0024 }
            java.lang.String r9 = r9.getCanonicalName()     // Catch:{ Exception -> 0x0024 }
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0024 }
            r8 = 0
            r7[r8] = r9     // Catch:{ Exception -> 0x0024 }
            r9 = 1
            r7[r9] = r0     // Catch:{ Exception -> 0x0024 }
            java.lang.String r6 = java.lang.String.format(r2, r6, r7)     // Catch:{ Exception -> 0x0024 }
        L_0x0094:
            boolean r9 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0024 }
            if (r9 != 0) goto L_0x009d
            r1.put(r4, r3)     // Catch:{ Exception -> 0x0024 }
        L_0x009d:
            boolean r9 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0024 }
            if (r9 == 0) goto L_0x00ab
            java.lang.Class r9 = r10.getClass()     // Catch:{ Exception -> 0x0024 }
            java.lang.String r6 = r9.getCanonicalName()     // Catch:{ Exception -> 0x0024 }
        L_0x00ab:
            r1.put(r5, r6)     // Catch:{ Exception -> 0x0024 }
            goto L_0x00b2
        L_0x00af:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r9)
        L_0x00b2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getFragmentPageInfo(android.app.Activity, java.lang.Object):org.json.JSONObject");
    }

    public static JSONObject getRNPageInfo() {
        return getRNPageInfo((View) null);
    }

    public static JSONObject getRNPageInfo(View view) {
        try {
            String str = (String) ReflectUtil.callStaticMethod(ReflectUtil.getCurrentClass(new String[]{"com.sensorsdata.analytics.utils.RNViewUtils"}), "getVisualizeProperties", new Object[0]);
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (view != null && jSONObject.optBoolean("isSetRNViewTag", false)) {
                    Object tag = view.getTag(R.id.sensors_analytics_tag_view_rn_key);
                    if (tag != null) {
                        if (!((Boolean) tag).booleanValue()) {
                        }
                    }
                    return null;
                }
                String optString = jSONObject.optString("$screen_name");
                String optString2 = jSONObject.optString("$title");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("$screen_name", optString);
                jSONObject2.put("$title", optString2);
                return jSONObject2;
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        return null;
    }
}
