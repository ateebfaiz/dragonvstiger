package com.alibaba.pdns.model;

import androidx.annotation.Keep;
import java.util.concurrent.CopyOnWriteArrayList;

public class DomainRttModel {
    @Keep
    private String accountId;
    @Keep
    private String apiToken;
    @Keep
    private String apiUser;
    @Keep
    private CopyOnWriteArrayList<ItemsJosnBean> items;
    @Keep
    private String transactionId;

    @Keep
    public static class ItemsJosnBean {
        @Keep
        private String detectDomainName;
        @Keep
        private String detectIp;
        @Keep
        private int detectIpVersion;
        @Keep
        private int detectPort;
        @Keep
        private String detectProtocol;
        @Keep
        private double latency;
        @Keep
        private String platform;
        @Keep
        private String sdkVersion;
        @Keep
        private String termIp;
        @Keep
        private long timestamp;

        public String getDetectDomainName() {
            return this.detectDomainName;
        }

        public String getDetectIp() {
            return this.detectIp;
        }

        public int getDetectIpVersion() {
            return this.detectIpVersion;
        }

        public int getDetectPort() {
            return this.detectPort;
        }

        public String getDetectProtocol() {
            return this.detectProtocol;
        }

        public double getLatency() {
            return this.latency;
        }

        public String getPlatform() {
            return this.platform;
        }

        public String getSdkVersion() {
            return this.sdkVersion;
        }

        public String getTermIp() {
            return this.termIp;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public void setDetectDomainName(String str) {
            this.detectDomainName = str;
        }

        public void setDetectIp(String str) {
            this.detectIp = str;
        }

        public void setDetectIpVersion(int i10) {
            this.detectIpVersion = i10;
        }

        public void setDetectPort(int i10) {
            this.detectPort = i10;
        }

        public void setDetectProtocol(String str) {
            this.detectProtocol = str;
        }

        public void setLatency(double d10) {
            this.latency = d10;
        }

        public void setPlatform(String str) {
            this.platform = str;
        }

        public void setSdkVersion(String str) {
            this.sdkVersion = str;
        }

        public void setTermIp(String str) {
            this.termIp = str;
        }

        public void setTimestamp(long j10) {
            this.timestamp = j10;
        }
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getApiToken() {
        return this.apiToken;
    }

    public String getApiUser() {
        return this.apiUser;
    }

    public CopyOnWriteArrayList<ItemsJosnBean> getItems() {
        return this.items;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setApiToken(String str) {
        this.apiToken = str;
    }

    public void setApiUser(String str) {
        this.apiUser = str;
    }

    public void setItems(CopyOnWriteArrayList<ItemsJosnBean> copyOnWriteArrayList) {
        this.items = copyOnWriteArrayList;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }
}
