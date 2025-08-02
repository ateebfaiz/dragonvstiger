package com.sensorsdata.analytics.android.sdk.visual.utils;

import android.content.Context;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.util.SADisplayUtil;
import com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler;
import com.sensorsdata.analytics.android.sdk.visual.NodesProcess;
import com.sensorsdata.analytics.android.sdk.visual.R;
import com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo;
import com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo;
import com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class AlertMessageUtils {
    private static final String TAG = "SA.AlertMessageUtils";

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$analytics$android$sdk$visual$utils$AlertMessageUtils$AlertRunnable$AlertType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils$AlertRunnable$AlertType[] r0 = com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AlertRunnable.AlertType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$sensorsdata$analytics$android$sdk$visual$utils$AlertMessageUtils$AlertRunnable$AlertType = r0
                com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils$AlertRunnable$AlertType r1 = com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AlertRunnable.AlertType.H5     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$sensorsdata$analytics$android$sdk$visual$utils$AlertMessageUtils$AlertRunnable$AlertType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils$AlertRunnable$AlertType r1 = com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AlertRunnable.AlertType.FLUTTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AnonymousClass1.<clinit>():void");
        }
    }

    public static class AlertRunnable implements Runnable {
        private final AlertType alertType;
        private final String unique;

        public enum AlertType {
            H5,
            FLUTTER
        }

        public AlertRunnable(AlertType alertType2, String str) {
            this.unique = str;
            this.alertType = alertType2;
        }

        public void run() {
            int i10 = AnonymousClass1.$SwitchMap$com$sensorsdata$analytics$android$sdk$visual$utils$AlertMessageUtils$AlertRunnable$AlertType[this.alertType.ordinal()];
            if (i10 == 1) {
                AlertMessageUtils.h5AlertHandlerFailure(this.unique);
            } else if (i10 == 2) {
                AlertMessageUtils.flutterAlertHandlerFailure(this.unique);
            }
        }
    }

    private static void buildAlertInfo(OutputStream outputStream, String str, List<NodeInfo.AlertInfo> list, Context context) throws IOException {
        if (list != null && list.size() > 0) {
            outputStream.write(",\"app_alert_infos\":".getBytes());
            outputStream.flush();
            outputStream.write("[".getBytes());
            for (int i10 = 0; i10 < list.size(); i10++) {
                if (i10 > 0) {
                    outputStream.write(",".getBytes());
                }
                NodeInfo.AlertInfo alertInfo = list.get(i10);
                if (alertInfo != null) {
                    if (TextUtils.equals(AbstractViewCrawler.TYPE_HEAT_MAP, str)) {
                        alertInfo.title = alertInfo.title.replace(SADisplayUtil.getStringResource(context, R.string.sensors_analytics_visual), SADisplayUtil.getStringResource(context, R.string.sensors_analytics_heatmap));
                    }
                    outputStream.write("{".getBytes());
                    outputStream.write("\"title\":".getBytes());
                    outputStream.write(("\"" + alertInfo.title + "\"").getBytes());
                    outputStream.write(",".getBytes());
                    outputStream.write("\"message\":".getBytes());
                    outputStream.write(("\"" + alertInfo.message + "\"").getBytes());
                    outputStream.write(",".getBytes());
                    outputStream.write("\"link_text\":".getBytes());
                    outputStream.write(("\"" + alertInfo.linkText + "\"").getBytes());
                    outputStream.write(",".getBytes());
                    outputStream.write("\"link_url\":".getBytes());
                    outputStream.write(("\"" + alertInfo.linkUrl + "\"").getBytes());
                    outputStream.write("}".getBytes());
                }
            }
            outputStream.write("]".getBytes());
            outputStream.flush();
        }
    }

    public static void buildFlutterAlertInfo(OutputStream outputStream, String str, SnapInfo snapInfo, Context context) throws IOException {
        buildAlertInfo(outputStream, str, snapInfo.flutter_alertInfos, context);
    }

    public static void buildH5AlertInfo(OutputStream outputStream, String str, SnapInfo snapInfo, Context context) throws IOException {
        WebNodeInfo webNodeInfo = (WebNodeInfo) NodesProcess.getInstance().getWebNodesManager().getPageInfo(snapInfo.webViewUrl);
        if (webNodeInfo != null) {
            if (!TextUtils.isEmpty(webNodeInfo.getUrl())) {
                outputStream.write((",\"h5_url\": \"" + webNodeInfo.getUrl() + "\"").getBytes());
            }
            if (!TextUtils.isEmpty(webNodeInfo.getTitle())) {
                outputStream.write((",\"h5_title\": \"" + webNodeInfo.getTitle() + "\"").getBytes());
            }
        }
        buildAlertInfo(outputStream, str, snapInfo.alertInfos, context);
    }

    /* access modifiers changed from: private */
    public static void flutterAlertHandlerFailure(String str) {
        SALog.i(TAG, "Flutter page is not integrated SDK");
        if (!TextUtils.isEmpty(str)) {
            Context context = SensorsDataAPI.sharedInstance().getSAContextManager().getContext();
            String stringResource = SADisplayUtil.getStringResource(context, R.string.sensors_analytics_visual_sa_h5);
            String stringResource2 = SADisplayUtil.getStringResource(context, R.string.sensors_analytics_visual_sa_flutter_error);
            String stringResource3 = SADisplayUtil.getStringResource(context, R.string.sensors_analytics_visual_sa_h5_error_link);
            NodesProcess.getInstance().getFlutterNodesManager().handlerFailure(str, "{\"callType\":\"app_alert\",\"data\":[{\"title\":\"" + stringResource + "\",\"message\":\"" + stringResource2 + "\",\"link_text\":\"" + stringResource3 + "\",\"link_url\":\"https://manual.sensorsdata.cn/sa/latest/flutter-22257963.html\"}]}");
        }
    }

    /* access modifiers changed from: private */
    public static void h5AlertHandlerFailure(String str) {
        if (!TextUtils.isEmpty(str) && ((WebNodeInfo) NodesProcess.getInstance().getWebNodesManager().getNodes(str)) == null) {
            SALog.i(TAG, "H5 page is not integrated Web JS SDK");
            Context context = SensorsDataAPI.sharedInstance().getSAContextManager().getContext();
            String stringResource = SADisplayUtil.getStringResource(context, R.string.sensors_analytics_visual_sa_h5);
            String stringResource2 = SADisplayUtil.getStringResource(context, R.string.sensors_analytics_visual_sa_h5_error);
            String stringResource3 = SADisplayUtil.getStringResource(context, R.string.sensors_analytics_visual_sa_h5_error_link);
            NodesProcess.getInstance().getWebNodesManager().handlerFailure(str, "{\"callType\":\"app_alert\",\"data\":[{\"title\":\"" + stringResource + "\",\"message\":\"" + stringResource2 + "\",\"link_text\":\"" + stringResource3 + "\",\"link_url\":\"https://manual.sensorsdata.cn/sa/latest/tech_sdk_client_web_use-7545346.html\"}]}");
        }
    }
}
