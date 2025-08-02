package com.sensorsdata.analytics.android.sdk.visual.model;

import com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo;
import java.util.List;

public class WebNodeInfo extends NodeInfo {
    private String url;

    public static class WebNodeBuilder extends NodeInfo.Builder<WebNodeInfo> {
        private String url;

        /* access modifiers changed from: package-private */
        public WebNodeBuilder setUrl(String str) {
            this.url = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public WebNodeInfo create() {
            return new WebNodeInfo(this.webNodes, this.alertInfos, this.title, this.url, this.status);
        }
    }

    public static WebNodeInfo createAlertInfo(List<NodeInfo.AlertInfo> list) {
        return (WebNodeInfo) new WebNodeBuilder().setAlertInfo(list).setStatus(NodeInfo.Status.FAILURE).create();
    }

    public static WebNodeInfo createNodesInfo(List<? extends CommonNode> list) {
        return (WebNodeInfo) new WebNodeBuilder().setWebNodes(list).setStatus(NodeInfo.Status.SUCCESS).create();
    }

    public static WebNodeInfo createPageInfo(String str, String str2) {
        return (WebNodeInfo) new WebNodeBuilder().setUrl(str2).setTitle(str).create();
    }

    public String getUrl() {
        return this.url;
    }

    private WebNodeInfo(List<? extends CommonNode> list, List<NodeInfo.AlertInfo> list2, String str, String str2, NodeInfo.Status status) {
        this.webNodes = list;
        this.alertInfos = list2;
        this.title = str;
        this.url = str2;
        this.status = status;
    }
}
