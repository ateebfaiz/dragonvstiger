package com.sensorsdata.analytics.android.sdk.visual.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.jsbridge.H5Helper;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager;
import com.sensorsdata.analytics.android.sdk.util.SAViewUtils;
import com.sensorsdata.analytics.android.sdk.util.visual.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.HeatMapService;
import com.sensorsdata.analytics.android.sdk.visual.NodesProcess;
import com.sensorsdata.analytics.android.sdk.visual.R;
import com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService;
import com.sensorsdata.analytics.android.sdk.visual.WebViewVisualInterface;
import com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager;
import com.sensorsdata.analytics.android.sdk.visual.utils.AppStateManager;
import com.sensorsdata.analytics.android.sdk.visual.utils.VisualUtil;
import com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog;
import org.json.JSONObject;

public class VisualProtocolImpl {
    private static final String TAG = "SA.SAVisualProtocolImpl";
    private final SAContextManager mSAContextManager;

    public VisualProtocolImpl(SAContextManager sAContextManager) {
        this.mSAContextManager = sAContextManager;
        SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(new AppStateManager());
    }

    private void addVisualJavascriptInterface(View view) {
        if (view != null && view.getTag(R.id.sensors_analytics_tag_view_webview_visual) == null) {
            view.setTag(R.id.sensors_analytics_tag_view_webview_visual, new Object());
            H5Helper.addJavascriptInterface(view, new WebViewVisualInterface(view), "SensorsData_App_Visual_Bridge");
        }
    }

    private String appVisualConfig() {
        try {
            if (this.mSAContextManager.getInternalConfigs().saConfigOptions != null) {
                if (this.mSAContextManager.getInternalConfigs().saConfigOptions.isVisualizedPropertiesEnabled()) {
                    VisualPropertiesManager.getInstance().getVisualPropertiesH5Helper().registerListeners();
                    return VisualPropertiesManager.getInstance().getVisualPropertiesCache().getVisualCache();
                }
            }
            return null;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    private void mergeVisualProperties(JSONObject jSONObject, View view) {
        if (view != null) {
            try {
                ViewNode addViewPathProperties = VisualUtil.addViewPathProperties(SAViewUtils.getActivityOfView(view.getContext(), view), view, jSONObject);
                if (this.mSAContextManager.getInternalConfigs().saConfigOptions.isVisualizedPropertiesEnabled()) {
                    VisualPropertiesManager.getInstance().mergeVisualProperties(VisualPropertiesManager.VisualEventType.APP_CLICK, jSONObject, addViewPathProperties);
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    private void showPairingCodeInputDialog(final Context context) {
        if (this.mSAContextManager.getContext() == null) {
            SALog.i(TAG, "The argument context can't be null");
        } else if (!(context instanceof Activity)) {
            SALog.i(TAG, "The static method showPairingCodeEditDialog(Context context) only accepts Activity as a parameter");
        } else {
            ((Activity) context).runOnUiThread(new Runnable() {
                public void run() {
                    new PairingCodeEditDialog(context).show();
                }
            });
        }
    }

    public String flutterGetAppVisualConfig() {
        String appVisualConfig = appVisualConfig();
        if (!TextUtils.isEmpty(appVisualConfig)) {
            return Base64.encodeToString(appVisualConfig.getBytes(), 2);
        }
        return null;
    }

    public Boolean getVisualState() {
        boolean z10;
        if (VisualizedAutoTrackService.getInstance().isServiceRunning() || HeatMapService.getInstance().isServiceRunning()) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    public String h5GetAppVisualConfig() {
        String appVisualConfig = appVisualConfig();
        if (!TextUtils.isEmpty(appVisualConfig)) {
            return Base64.encodeToString(appVisualConfig.getBytes(), 0);
        }
        return null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T invokeModuleFunction(java.lang.String r5, java.lang.Object... r6) {
        /*
            r4 = this;
            int r0 = r5.hashCode()     // Catch:{ Exception -> 0x0018 }
            r1 = 2
            r2 = 1
            r3 = 0
            switch(r0) {
                case -2132080600: goto L_0x009b;
                case -2103270069: goto L_0x0091;
                case -2071982886: goto L_0x0086;
                case -1974002693: goto L_0x007b;
                case -1706331910: goto L_0x0071;
                case -746052307: goto L_0x0066;
                case -467015053: goto L_0x005c;
                case -366380714: goto L_0x0052;
                case -288956309: goto L_0x0048;
                case 561737425: goto L_0x003e;
                case 834619917: goto L_0x0032;
                case 873596527: goto L_0x0026;
                case 1417500907: goto L_0x001b;
                case 1571660393: goto L_0x000c;
                default: goto L_0x000a;
            }     // Catch:{ Exception -> 0x0018 }
        L_0x000a:
            goto L_0x00a5
        L_0x000c:
            java.lang.String r0 = "flutterGetAppVisualConfig"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = 11
            goto L_0x00a6
        L_0x0018:
            r5 = move-exception
            goto L_0x0129
        L_0x001b:
            java.lang.String r0 = "mergeVisualProperties"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = r1
            goto L_0x00a6
        L_0x0026:
            java.lang.String r0 = "sendVisualizedMessage"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = 13
            goto L_0x00a6
        L_0x0032:
            java.lang.String r0 = "showOpenHeatMapDialog"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = 8
            goto L_0x00a6
        L_0x003e:
            java.lang.String r0 = "requestVisualConfig"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = r2
            goto L_0x00a6
        L_0x0048:
            java.lang.String r0 = "stopHeatMapService"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = 6
            goto L_0x00a6
        L_0x0052:
            java.lang.String r0 = "resumeHeatMapService"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = 5
            goto L_0x00a6
        L_0x005c:
            java.lang.String r0 = "stopVisualService"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = 4
            goto L_0x00a6
        L_0x0066:
            java.lang.String r0 = "showOpenVisualizedAutoTrackDialog"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = 9
            goto L_0x00a6
        L_0x0071:
            java.lang.String r0 = "showPairingCodeInputDialog"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = 7
            goto L_0x00a6
        L_0x007b:
            java.lang.String r0 = "getVisualState"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = 12
            goto L_0x00a6
        L_0x0086:
            java.lang.String r0 = "h5GetAppVisualConfig"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = 10
            goto L_0x00a6
        L_0x0091:
            java.lang.String r0 = "addVisualJavascriptInterface"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = r3
            goto L_0x00a6
        L_0x009b:
            java.lang.String r0 = "resumeVisualService"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x00a5
            r5 = 3
            goto L_0x00a6
        L_0x00a5:
            r5 = -1
        L_0x00a6:
            switch(r5) {
                case 0: goto L_0x0121;
                case 1: goto L_0x0117;
                case 2: goto L_0x010b;
                case 3: goto L_0x0103;
                case 4: goto L_0x00fb;
                case 5: goto L_0x00f3;
                case 6: goto L_0x00eb;
                case 7: goto L_0x00e3;
                case 8: goto L_0x00d3;
                case 9: goto L_0x00c3;
                case 10: goto L_0x00be;
                case 11: goto L_0x00b9;
                case 12: goto L_0x00b4;
                case 13: goto L_0x00ab;
                default: goto L_0x00a9;
            }     // Catch:{ Exception -> 0x0018 }
        L_0x00a9:
            goto L_0x012c
        L_0x00ab:
            r5 = r6[r3]     // Catch:{ Exception -> 0x0018 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0018 }
            r4.sendVisualizedMessage(r5)     // Catch:{ Exception -> 0x0018 }
            goto L_0x012c
        L_0x00b4:
            java.lang.Boolean r5 = r4.getVisualState()     // Catch:{ Exception -> 0x0018 }
            return r5
        L_0x00b9:
            java.lang.String r5 = r4.flutterGetAppVisualConfig()     // Catch:{ Exception -> 0x0018 }
            return r5
        L_0x00be:
            java.lang.String r5 = r4.h5GetAppVisualConfig()     // Catch:{ Exception -> 0x0018 }
            return r5
        L_0x00c3:
            r5 = r6[r3]     // Catch:{ Exception -> 0x0018 }
            android.app.Activity r5 = (android.app.Activity) r5     // Catch:{ Exception -> 0x0018 }
            r0 = r6[r2]     // Catch:{ Exception -> 0x0018 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0018 }
            r6 = r6[r1]     // Catch:{ Exception -> 0x0018 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0018 }
            com.sensorsdata.analytics.android.sdk.visual.view.VisualDialog.showOpenVisualizedAutoTrackDialog(r5, r0, r6)     // Catch:{ Exception -> 0x0018 }
            goto L_0x012c
        L_0x00d3:
            r5 = r6[r3]     // Catch:{ Exception -> 0x0018 }
            android.app.Activity r5 = (android.app.Activity) r5     // Catch:{ Exception -> 0x0018 }
            r0 = r6[r2]     // Catch:{ Exception -> 0x0018 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0018 }
            r6 = r6[r1]     // Catch:{ Exception -> 0x0018 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0018 }
            com.sensorsdata.analytics.android.sdk.visual.view.VisualDialog.showOpenHeatMapDialog(r5, r0, r6)     // Catch:{ Exception -> 0x0018 }
            goto L_0x012c
        L_0x00e3:
            r5 = r6[r3]     // Catch:{ Exception -> 0x0018 }
            android.content.Context r5 = (android.content.Context) r5     // Catch:{ Exception -> 0x0018 }
            r4.showPairingCodeInputDialog(r5)     // Catch:{ Exception -> 0x0018 }
            goto L_0x012c
        L_0x00eb:
            com.sensorsdata.analytics.android.sdk.visual.HeatMapService r5 = com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance()     // Catch:{ Exception -> 0x0018 }
            r5.stop()     // Catch:{ Exception -> 0x0018 }
            goto L_0x012c
        L_0x00f3:
            com.sensorsdata.analytics.android.sdk.visual.HeatMapService r5 = com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance()     // Catch:{ Exception -> 0x0018 }
            r5.resume()     // Catch:{ Exception -> 0x0018 }
            goto L_0x012c
        L_0x00fb:
            com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r5 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()     // Catch:{ Exception -> 0x0018 }
            r5.stop()     // Catch:{ Exception -> 0x0018 }
            goto L_0x012c
        L_0x0103:
            com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r5 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()     // Catch:{ Exception -> 0x0018 }
            r5.resume()     // Catch:{ Exception -> 0x0018 }
            goto L_0x012c
        L_0x010b:
            r5 = r6[r3]     // Catch:{ Exception -> 0x0018 }
            org.json.JSONObject r5 = (org.json.JSONObject) r5     // Catch:{ Exception -> 0x0018 }
            r6 = r6[r2]     // Catch:{ Exception -> 0x0018 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ Exception -> 0x0018 }
            r4.mergeVisualProperties(r5, r6)     // Catch:{ Exception -> 0x0018 }
            goto L_0x012c
        L_0x0117:
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager r5 = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance()     // Catch:{ Exception -> 0x0018 }
            com.sensorsdata.analytics.android.sdk.core.SAContextManager r6 = r4.mSAContextManager     // Catch:{ Exception -> 0x0018 }
            r5.requestVisualConfig(r6)     // Catch:{ Exception -> 0x0018 }
            goto L_0x012c
        L_0x0121:
            r5 = r6[r3]     // Catch:{ Exception -> 0x0018 }
            android.view.View r5 = (android.view.View) r5     // Catch:{ Exception -> 0x0018 }
            r4.addVisualJavascriptInterface(r5)     // Catch:{ Exception -> 0x0018 }
            goto L_0x012c
        L_0x0129:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x012c:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.impl.VisualProtocolImpl.invokeModuleFunction(java.lang.String, java.lang.Object[]):java.lang.Object");
    }

    public void sendVisualizedMessage(String str) {
        NodesProcess.getInstance().getFlutterNodesManager().handlerMessage(str);
    }
}
