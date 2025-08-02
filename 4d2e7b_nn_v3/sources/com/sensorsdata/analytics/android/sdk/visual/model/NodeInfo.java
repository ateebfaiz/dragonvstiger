package com.sensorsdata.analytics.android.sdk.visual.model;

import java.util.List;

public class NodeInfo {
    protected List<AlertInfo> alertInfos;
    protected Status status;
    protected String title;
    protected List<? extends CommonNode> webNodes;

    public static class AlertInfo {
        public String linkText;
        public String linkUrl;
        public String message;
        public String title;

        public AlertInfo(String str, String str2, String str3, String str4) {
            this.title = str;
            this.message = str2;
            this.linkText = str3;
            this.linkUrl = str4;
        }
    }

    public static class Builder<T extends NodeInfo> {
        protected List<AlertInfo> alertInfos;
        protected Status status;
        protected String title;
        protected List<? extends CommonNode> webNodes;

        /* access modifiers changed from: package-private */
        public T create() {
            return null;
        }

        /* access modifiers changed from: package-private */
        public Builder<T> setAlertInfo(List<AlertInfo> list) {
            this.alertInfos = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder<T> setStatus(Status status2) {
            this.status = status2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder<T> setTitle(String str) {
            this.title = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder<T> setWebNodes(List<? extends CommonNode> list) {
            this.webNodes = list;
            return this;
        }
    }

    public enum Status {
        SUCCESS,
        FAILURE
    }

    public List<AlertInfo> getAlertInfos() {
        return this.alertInfos;
    }

    public List<? extends CommonNode> getNodes() {
        return this.webNodes;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }
}
