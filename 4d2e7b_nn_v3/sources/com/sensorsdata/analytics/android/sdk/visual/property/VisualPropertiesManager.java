package com.sensorsdata.analytics.android.sdk.visual.property;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.AppStateTools;
import com.sensorsdata.analytics.android.sdk.util.SADisplayUtil;
import com.sensorsdata.analytics.android.sdk.util.SAViewUtils;
import com.sensorsdata.analytics.android.sdk.util.visual.ViewNode;
import com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable;
import com.sensorsdata.analytics.android.sdk.visual.R;
import com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants;
import com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig;
import com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

public class VisualPropertiesManager {
    private static final String PROPERTY_TYPE_NUMBER = "NUMBER";
    private static final String TAG = "SA.VP.VisualPropertiesManager";
    private CollectLogListener mCollectLogListener;
    private final VisualPropertiesCache mConfigCache;
    private final VisualConfigRequestHelper mRequestHelper;
    private VisualConfig mVisualConfig;
    private final VisualPropertiesH5Helper mVisualPropertiesH5Helper;

    interface CollectLogListener {
        void onCheckEventConfigFailure();

        void onCheckVisualConfigFailure(String str);

        void onFindPropertyElementFailure(String str, String str2, String str3);

        void onOtherError(String str);

        void onParsePropertyContentFailure(String str, String str2, String str3, String str4);

        void onStart(String str, String str2, ViewNode viewNode);

        void onSwitchClose();
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final VisualPropertiesManager INSTANCE = new VisualPropertiesManager();

        private SingletonHolder() {
        }
    }

    public enum VisualEventType {
        APP_CLICK("appclick", "$AppClick"),
        WEB_CLICK("appclick", VisualConstants.WEB_CLICK_EVENT_NAME);
        
        private final String trackEventType;
        /* access modifiers changed from: private */
        public final String visualEventType;

        private VisualEventType(String str, String str2) {
            this.visualEventType = str;
            this.trackEventType = str2;
        }

        public String getVisualEventType() {
            return this.visualEventType;
        }

        public static VisualEventType getVisualEventType(String str) {
            for (VisualEventType visualEventType2 : values()) {
                if (TextUtils.equals(visualEventType2.trackEventType, str)) {
                    return visualEventType2;
                }
            }
            return null;
        }
    }

    public static VisualPropertiesManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private void mergeVisualProperty(List<VisualConfig.VisualProperty> list, VisualConfig.VisualEvent visualEvent, JSONObject jSONObject, ViewNode viewNode, String str) {
        try {
            HashSet hashSet = new HashSet();
            ViewTreeStatusObservable.getInstance().clearViewNodeCache();
            for (VisualConfig.VisualProperty next : list) {
                if (!next.isH5 || TextUtils.isEmpty(next.webViewElementPath)) {
                    mergeAppVisualProperty(next, visualEvent, jSONObject, viewNode);
                } else {
                    hashSet.add(next.webViewElementPath + next.screenName);
                }
            }
            if (hashSet.size() > 0) {
                this.mVisualPropertiesH5Helper.mergeJSVisualProperties(jSONObject, hashSet, str);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public boolean checkAppIdAndProject() {
        String serverUrl = SensorsDataAPI.sharedInstance().getServerUrl();
        if (TextUtils.isEmpty(serverUrl)) {
            SALog.i(TAG, "serverUrl is empty and return");
            return false;
        }
        String queryParameter = Uri.parse(serverUrl).getQueryParameter("project");
        String processName = AppInfoUtils.getProcessName(SensorsDataAPI.sharedInstance().getSAContextManager().getContext());
        if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(processName)) {
            SALog.i(TAG, "project or app_id is empty and return");
            return false;
        }
        VisualConfig visualConfig = this.mVisualConfig;
        if (visualConfig == null) {
            SALog.i(TAG, "VisualConfig is null and return");
            return false;
        } else if (!TextUtils.equals(processName, visualConfig.appId)) {
            SALog.i(TAG, String.format("app_id is not equals: current app_id is %s, config app_id is %s ", new Object[]{processName, this.mVisualConfig.appId}));
            return false;
        } else if (TextUtils.equals(queryParameter, this.mVisualConfig.project)) {
            return true;
        } else {
            SALog.i(TAG, String.format("project is not equals: current project is %s, config project is %s ", new Object[]{queryParameter, this.mVisualConfig.project}));
            return false;
        }
    }

    public List<VisualConfig.VisualPropertiesConfig> getMatchEventConfigList(List<VisualConfig.VisualPropertiesConfig> list, VisualEventType visualEventType, String str, String str2, String str3, String str4) {
        ArrayList arrayList = new ArrayList();
        try {
            for (VisualConfig.VisualPropertiesConfig next : list) {
                if (TextUtils.equals(next.eventType, visualEventType.getVisualEventType())) {
                    VisualConfig.VisualEvent visualEvent = next.event;
                    if (TextUtils.isEmpty(str) || TextUtils.equals(visualEvent.screenName, str)) {
                        if (visualEventType == VisualEventType.APP_CLICK || visualEventType == VisualEventType.WEB_CLICK) {
                            if (!TextUtils.equals(visualEvent.elementPath, str2)) {
                                SALog.i(TAG, String.format("event element_path is not match: current element_path is %s, config element_path is %s ", new Object[]{str2, visualEvent.elementPath}));
                            } else if (visualEvent.limitElementPosition && !TextUtils.equals(visualEvent.elementPosition, str3)) {
                                SALog.i(TAG, String.format("event element_position is not match: current element_position is %s, config element_position is %s ", new Object[]{str3, visualEvent.elementPosition}));
                            } else if (visualEvent.limitElementContent && !TextUtils.equals(visualEvent.elementContent, str4)) {
                                SALog.i(TAG, String.format("event element_content is not match: current element_content is %s, config element_content is %s ", new Object[]{str4, visualEvent.elementContent}));
                            }
                        }
                        arrayList.add(next);
                    }
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        return arrayList;
    }

    public VisualConfig getVisualConfig() {
        return this.mVisualConfig;
    }

    public String getVisualConfigVersion() {
        VisualConfig visualConfig = this.mVisualConfig;
        if (visualConfig != null) {
            return visualConfig.version;
        }
        return null;
    }

    public VisualPropertiesCache getVisualPropertiesCache() {
        return this.mConfigCache;
    }

    public VisualPropertiesH5Helper getVisualPropertiesH5Helper() {
        return this.mVisualPropertiesH5Helper;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e2 A[Catch:{ Exception -> 0x0014 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0197 A[Catch:{ Exception -> 0x0014 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mergeAppVisualProperty(com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualProperty r8, com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualEvent r9, org.json.JSONObject r10, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode r11) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            java.lang.String r2 = "-"
            java.lang.String r3 = r8.name     // Catch:{ Exception -> 0x0014 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0014 }
            java.lang.String r4 = "SA.VP.VisualPropertiesManager"
            if (r3 == 0) goto L_0x0017
            java.lang.String r8 = "config visual property name is empty"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r4, (java.lang.String) r8)     // Catch:{ Exception -> 0x0014 }
            return
        L_0x0014:
            r8 = move-exception
            goto L_0x01a1
        L_0x0017:
            java.lang.String r3 = r8.elementPath     // Catch:{ Exception -> 0x0014 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0014 }
            if (r3 == 0) goto L_0x0025
            java.lang.String r8 = "config visual property elementPath is empty"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r4, (java.lang.String) r8)     // Catch:{ Exception -> 0x0014 }
            return
        L_0x0025:
            if (r11 == 0) goto L_0x007b
            java.lang.String r3 = r11.getViewPosition()     // Catch:{ Exception -> 0x0014 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0014 }
            if (r3 != 0) goto L_0x007b
            if (r9 == 0) goto L_0x007b
            java.lang.String r3 = r9.elementPosition     // Catch:{ Exception -> 0x0014 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0014 }
            if (r3 != 0) goto L_0x007b
            boolean r3 = r9.limitElementPosition     // Catch:{ Exception -> 0x0014 }
            if (r3 != 0) goto L_0x007b
            java.lang.String r3 = r8.elementPosition     // Catch:{ Exception -> 0x0014 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0014 }
            if (r3 != 0) goto L_0x007b
            java.lang.String r3 = r8.elementPath     // Catch:{ Exception -> 0x0014 }
            java.lang.String[] r3 = r3.split(r2)     // Catch:{ Exception -> 0x0014 }
            r3 = r3[r1]     // Catch:{ Exception -> 0x0014 }
            java.lang.String r9 = r9.elementPath     // Catch:{ Exception -> 0x0014 }
            java.lang.String[] r9 = r9.split(r2)     // Catch:{ Exception -> 0x0014 }
            r9 = r9[r1]     // Catch:{ Exception -> 0x0014 }
            boolean r9 = android.text.TextUtils.equals(r3, r9)     // Catch:{ Exception -> 0x0014 }
            if (r9 == 0) goto L_0x007b
            java.lang.String r9 = r11.getViewPosition()     // Catch:{ Exception -> 0x0014 }
            r8.elementPosition = r9     // Catch:{ Exception -> 0x0014 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0014 }
            r9.<init>()     // Catch:{ Exception -> 0x0014 }
            java.lang.String r2 = "visualProperty elementPosition replace: "
            r9.append(r2)     // Catch:{ Exception -> 0x0014 }
            java.lang.String r2 = r11.getViewPosition()     // Catch:{ Exception -> 0x0014 }
            r9.append(r2)     // Catch:{ Exception -> 0x0014 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0014 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r4, (java.lang.String) r9)     // Catch:{ Exception -> 0x0014 }
        L_0x007b:
            r9 = 0
            com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable r2 = com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable.getInstance()     // Catch:{ Exception -> 0x0087 }
            if (r11 == 0) goto L_0x008a
            java.lang.ref.WeakReference r11 = r11.getView()     // Catch:{ Exception -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r11 = move-exception
            r2 = r9
            goto L_0x00dd
        L_0x008a:
            r11 = r9
        L_0x008b:
            java.lang.String r3 = r8.elementPath     // Catch:{ Exception -> 0x0087 }
            java.lang.String r5 = r8.elementPosition     // Catch:{ Exception -> 0x0087 }
            java.lang.String r6 = r8.screenName     // Catch:{ Exception -> 0x0087 }
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode r11 = r2.getViewNode(r11, r3, r5, r6)     // Catch:{ Exception -> 0x0087 }
            if (r11 == 0) goto L_0x00db
            java.lang.String r2 = r8.elementPath     // Catch:{ Exception -> 0x0087 }
            java.lang.String r3 = r11.getViewPath()     // Catch:{ Exception -> 0x0087 }
            boolean r2 = android.text.TextUtils.equals(r2, r3)     // Catch:{ Exception -> 0x0087 }
            if (r2 == 0) goto L_0x00db
            java.lang.String r2 = r8.elementPosition     // Catch:{ Exception -> 0x0087 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r3 = r8.elementPosition     // Catch:{ Exception -> 0x0087 }
            java.lang.String r5 = r11.getViewPosition()     // Catch:{ Exception -> 0x0087 }
            boolean r3 = android.text.TextUtils.equals(r3, r5)     // Catch:{ Exception -> 0x0087 }
            r2 = r2 | r3
            if (r2 == 0) goto L_0x00db
            java.lang.String r2 = r11.getViewContent()     // Catch:{ Exception -> 0x0087 }
            java.lang.ref.WeakReference r3 = r11.getView()     // Catch:{ Exception -> 0x00c5 }
            if (r3 == 0) goto L_0x00c7
            java.lang.ref.WeakReference r11 = r11.getView()     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00c8
        L_0x00c5:
            r11 = move-exception
            goto L_0x00dd
        L_0x00c7:
            r11 = r9
        L_0x00c8:
            if (r11 == 0) goto L_0x00e0
            java.lang.Object r3 = r11.get()     // Catch:{ Exception -> 0x00c5 }
            if (r3 == 0) goto L_0x00e0
            java.lang.Object r11 = r11.get()     // Catch:{ Exception -> 0x00c5 }
            android.view.View r11 = (android.view.View) r11     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r2 = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(r11, r0)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00e0
        L_0x00db:
            r2 = r9
            goto L_0x00e0
        L_0x00dd:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r11)     // Catch:{ Exception -> 0x0014 }
        L_0x00e0:
            if (r2 == 0) goto L_0x0193
            boolean r11 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0014 }
            if (r11 == 0) goto L_0x00ea
            goto L_0x0193
        L_0x00ea:
            java.lang.String r11 = "find property target view success, property element_path: %s,element_position: %s,element_content: %s"
            java.lang.String r3 = r8.elementPath     // Catch:{ Exception -> 0x0014 }
            java.lang.String r5 = r8.elementPosition     // Catch:{ Exception -> 0x0014 }
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0014 }
            r6[r1] = r3     // Catch:{ Exception -> 0x0014 }
            r6[r0] = r5     // Catch:{ Exception -> 0x0014 }
            r3 = 2
            r6[r3] = r2     // Catch:{ Exception -> 0x0014 }
            java.lang.String r11 = java.lang.String.format(r11, r6)     // Catch:{ Exception -> 0x0014 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r4, (java.lang.String) r11)     // Catch:{ Exception -> 0x0014 }
            java.lang.String r11 = r8.regular     // Catch:{ Exception -> 0x0014 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0014 }
            if (r11 != 0) goto L_0x0153
            java.lang.String r9 = r8.regular     // Catch:{ Exception -> 0x012d }
            r11 = 40
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r9, r11)     // Catch:{ Exception -> 0x012d }
            java.util.regex.Matcher r9 = r9.matcher(r2)     // Catch:{ Exception -> 0x012d }
            boolean r11 = r9.find()     // Catch:{ Exception -> 0x012d }
            if (r11 == 0) goto L_0x012f
            java.lang.String r9 = r9.group()     // Catch:{ Exception -> 0x012d }
            java.lang.String r11 = "propertyValue is: %s"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x012d }
            r0[r1] = r9     // Catch:{ Exception -> 0x012d }
            java.lang.String r11 = java.lang.String.format(r11, r0)     // Catch:{ Exception -> 0x012d }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r4, (java.lang.String) r11)     // Catch:{ Exception -> 0x012d }
            goto L_0x0153
        L_0x012d:
            r9 = move-exception
            goto L_0x0142
        L_0x012f:
            java.lang.String r9 = "matcher not find continue"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r4, (java.lang.String) r9)     // Catch:{ Exception -> 0x012d }
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r9 = r7.mCollectLogListener     // Catch:{ Exception -> 0x012d }
            if (r9 == 0) goto L_0x0141
            java.lang.String r10 = r8.name     // Catch:{ Exception -> 0x012d }
            java.lang.String r11 = r8.type     // Catch:{ Exception -> 0x012d }
            java.lang.String r0 = r8.regular     // Catch:{ Exception -> 0x012d }
            r9.onParsePropertyContentFailure(r10, r11, r2, r0)     // Catch:{ Exception -> 0x012d }
        L_0x0141:
            return
        L_0x0142:
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r10 = r7.mCollectLogListener     // Catch:{ Exception -> 0x0014 }
            if (r10 == 0) goto L_0x014f
            java.lang.String r11 = r8.name     // Catch:{ Exception -> 0x0014 }
            java.lang.String r0 = r8.type     // Catch:{ Exception -> 0x0014 }
            java.lang.String r8 = r8.regular     // Catch:{ Exception -> 0x0014 }
            r10.onParsePropertyContentFailure(r11, r0, r2, r8)     // Catch:{ Exception -> 0x0014 }
        L_0x014f:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r9)     // Catch:{ Exception -> 0x0014 }
            return
        L_0x0153:
            boolean r11 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0014 }
            if (r11 != 0) goto L_0x01a4
            java.lang.String r11 = "NUMBER"
            java.lang.String r0 = r8.type     // Catch:{ Exception -> 0x0014 }
            boolean r11 = android.text.TextUtils.equals(r11, r0)     // Catch:{ Exception -> 0x0014 }
            if (r11 == 0) goto L_0x0180
            if (r9 == 0) goto L_0x01a4
            java.lang.String r8 = r8.name     // Catch:{ Exception -> 0x0173 }
            java.text.NumberFormat r11 = java.text.NumberFormat.getInstance()     // Catch:{ Exception -> 0x0173 }
            java.lang.Number r9 = r11.parse(r9)     // Catch:{ Exception -> 0x0173 }
            r10.put(r8, r9)     // Catch:{ Exception -> 0x0173 }
            goto L_0x01a4
        L_0x0173:
            r8 = move-exception
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r9 = r7.mCollectLogListener     // Catch:{ Exception -> 0x0014 }
            if (r9 == 0) goto L_0x01a4
            java.lang.String r8 = r8.getMessage()     // Catch:{ Exception -> 0x0014 }
            r9.onOtherError(r8)     // Catch:{ Exception -> 0x0014 }
            goto L_0x01a4
        L_0x0180:
            java.lang.String r8 = r8.name     // Catch:{ JSONException -> 0x0186 }
            r10.put(r8, r9)     // Catch:{ JSONException -> 0x0186 }
            goto L_0x01a4
        L_0x0186:
            r8 = move-exception
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r9 = r7.mCollectLogListener     // Catch:{ Exception -> 0x0014 }
            if (r9 == 0) goto L_0x01a4
            java.lang.String r8 = r8.getMessage()     // Catch:{ Exception -> 0x0014 }
            r9.onOtherError(r8)     // Catch:{ Exception -> 0x0014 }
            goto L_0x01a4
        L_0x0193:
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r9 = r7.mCollectLogListener     // Catch:{ Exception -> 0x0014 }
            if (r9 == 0) goto L_0x01a0
            java.lang.String r10 = r8.name     // Catch:{ Exception -> 0x0014 }
            java.lang.String r11 = r8.elementPath     // Catch:{ Exception -> 0x0014 }
            java.lang.String r8 = r8.elementPosition     // Catch:{ Exception -> 0x0014 }
            r9.onFindPropertyElementFailure(r10, r11, r8)     // Catch:{ Exception -> 0x0014 }
        L_0x01a0:
            return
        L_0x01a1:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r8)
        L_0x01a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.mergeAppVisualProperty(com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig$VisualProperty, com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig$VisualEvent, org.json.JSONObject, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode):void");
    }

    public void mergeVisualProperties(VisualEventType visualEventType, JSONObject jSONObject, ViewNode viewNode) {
        Activity activity;
        String str;
        String str2;
        String str3;
        WeakReference<View> view;
        try {
            String optString = jSONObject.optString("$screen_name");
            CollectLogListener collectLogListener = this.mCollectLogListener;
            if (collectLogListener != null) {
                collectLogListener.onStart(visualEventType.visualEventType, optString, viewNode);
            }
            SALog.i(TAG, String.format("mergeVisualProperties eventType: %s, screenName:%s ", new Object[]{visualEventType.getVisualEventType(), optString}));
            if (TextUtils.isEmpty(optString)) {
                SALog.i(TAG, "screenName is empty and return");
            } else if (!SensorsDataAPI.sharedInstance().isVisualizedAutoTrackEnabled()) {
                SALog.i(TAG, "you should call 'enableVisualizedAutoTrack(true)' first");
                CollectLogListener collectLogListener2 = this.mCollectLogListener;
                if (collectLogListener2 != null) {
                    collectLogListener2.onSwitchClose();
                }
            } else {
                if (viewNode == null || (view = viewNode.getView()) == null || view.get() == null) {
                    activity = null;
                } else {
                    activity = SAViewUtils.getActivityOfView(view.get().getContext(), view.get());
                }
                if (activity == null) {
                    activity = AppStateTools.getInstance().getForegroundActivity();
                }
                if (activity != null) {
                    if (SensorsDataAPI.sharedInstance().isVisualizedAutoTrackActivity(activity.getClass())) {
                        if (this.mVisualConfig == null) {
                            SALog.i(TAG, "visual properties is empty and return");
                            CollectLogListener collectLogListener3 = this.mCollectLogListener;
                            if (collectLogListener3 != null) {
                                collectLogListener3.onCheckVisualConfigFailure(SADisplayUtil.getStringResource(SensorsDataAPI.sharedInstance().getSAContextManager().getContext(), R.string.sensors_analytics_visual_cache_no_property_error));
                                return;
                            }
                            return;
                        } else if (!checkAppIdAndProject()) {
                            CollectLogListener collectLogListener4 = this.mCollectLogListener;
                            if (collectLogListener4 != null) {
                                collectLogListener4.onCheckVisualConfigFailure(SADisplayUtil.getStringResource(SensorsDataAPI.sharedInstance().getSAContextManager().getContext(), R.string.sensors_analytics_visual_appid_error));
                                return;
                            }
                            return;
                        } else {
                            List<VisualConfig.VisualPropertiesConfig> list = this.mVisualConfig.events;
                            if (list != null) {
                                if (list.size() != 0) {
                                    if (viewNode != null) {
                                        str3 = viewNode.getViewPath();
                                        str2 = viewNode.getViewPosition();
                                        str = viewNode.getViewContent();
                                    } else {
                                        str3 = null;
                                        str2 = null;
                                        str = null;
                                    }
                                    List<VisualConfig.VisualPropertiesConfig> matchEventConfigList = getMatchEventConfigList(list, visualEventType, optString, str3, str2, str);
                                    if (matchEventConfigList.size() == 0) {
                                        SALog.i(TAG, "event config is empty and return");
                                        CollectLogListener collectLogListener5 = this.mCollectLogListener;
                                        if (collectLogListener5 != null) {
                                            collectLogListener5.onCheckEventConfigFailure();
                                            return;
                                        }
                                        return;
                                    }
                                    for (VisualConfig.VisualPropertiesConfig next : matchEventConfigList) {
                                        VisualConfig.VisualEvent visualEvent = next.event;
                                        if (visualEvent == null || !visualEvent.isH5) {
                                            List<VisualConfig.VisualProperty> list2 = next.properties;
                                            if (list2 != null) {
                                                if (list2.size() != 0) {
                                                    mergeVisualProperty(list2, visualEvent, jSONObject, viewNode, next.eventName);
                                                }
                                            }
                                            SALog.i(TAG, "properties is empty ");
                                        }
                                    }
                                    return;
                                }
                            }
                            SALog.i(TAG, "propertiesConfigs is empty");
                            CollectLogListener collectLogListener6 = this.mCollectLogListener;
                            if (collectLogListener6 != null) {
                                collectLogListener6.onOtherError("propertiesConfigs is empty");
                                return;
                            }
                            return;
                        }
                    }
                }
                SALog.i(TAG, "activity is null or not in white list and return");
                CollectLogListener collectLogListener7 = this.mCollectLogListener;
                if (collectLogListener7 != null) {
                    collectLogListener7.onOtherError("activity is null or not in white list and return");
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void registerCollectLogListener(CollectLogListener collectLogListener) {
        this.mCollectLogListener = collectLogListener;
    }

    public void requestVisualConfig(SAContextManager sAContextManager) {
        if (sAContextManager != null) {
            try {
                if (sAContextManager.getSensorsDataAPI().isNetworkRequestEnable()) {
                    if (!AbstractSensorsDataAPI.isSDKDisabled()) {
                        if (sAContextManager.getInternalConfigs().saConfigOptions.isVisualizedPropertiesEnabled()) {
                            SALog.i(TAG, Modules.Visual.METHOD_REQUEST_VISUAL_CONFIG);
                            this.mRequestHelper.requestVisualConfig(sAContextManager.getContext(), getVisualConfigVersion(), new VisualConfigRequestHelper.IApiCallback() {
                                public void onSuccess(String str) {
                                    VisualPropertiesManager.this.save2Cache(str);
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
                return;
            }
        }
        SALog.i(TAG, "Close network request");
    }

    public void save2Cache(String str) {
        this.mConfigCache.save2Cache(str);
        this.mVisualConfig = this.mConfigCache.getVisualConfig();
    }

    public void unRegisterCollectLogListener() {
        this.mCollectLogListener = null;
    }

    private VisualPropertiesManager() {
        VisualPropertiesCache visualPropertiesCache = new VisualPropertiesCache();
        this.mConfigCache = visualPropertiesCache;
        this.mVisualConfig = visualPropertiesCache.getVisualConfig();
        this.mRequestHelper = new VisualConfigRequestHelper();
        this.mVisualPropertiesH5Helper = new VisualPropertiesH5Helper();
    }
}
