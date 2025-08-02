package com.alibaba.pdns.model;

import androidx.annotation.Keep;
import java.util.concurrent.CopyOnWriteArrayList;

public class ReportDomanInfo {
    @Keep
    private String accountId;
    @Keep
    private String apiToken;
    @Keep
    private String apiUser;
    @Keep
    private long callPreloadMethodCount;
    private long callResolveMethodCount;
    @Keep
    private CopyOnWriteArrayList<DataJsonBean> items;
    @Keep
    private String platform;
    @Keep
    private String sdkVersion;
    @Keep
    private String termIp;
    @Keep
    private int termIpType;
    @Keep
    private long timestamp;
    @Keep
    private String transactionId;

    public static class DataJsonBean {
        @Keep
        private float avgRtt;
        @Keep
        private long degradeLocalDnsCount;
        @Keep
        private String domainName;
        @Keep
        private long hitDnsCacheCount;
        @Keep
        private long httpabnormalCount;
        @Keep
        private String isp;
        @Keep
        private long localDnsResolveErrCount;
        @Keep
        private float maxRtt;
        @Keep
        private long nonetworkCount;
        @Keep
        private long permissionErrCount;
        @Keep
        private int queryType;
        @Keep
        private long recursiveReqCount;
        @Keep
        private long reqParameterErrCount;
        @Keep
        private long reqPathErrCount;
        @Keep
        private long reqServerErrCount;
        @Keep
        private long reqTimeoutCount;
        @Keep
        private long resolveSuccessCount;
        @Keep
        private long timeoutCount;
        @Keep
        private long utfNetWorkErroNum;

        public float getAvgRtt() {
            return this.avgRtt;
        }

        public long getHttpabnormalCount() {
            return this.httpabnormalCount;
        }

        public String getIsp() {
            return this.isp;
        }

        public float getMaxRtt() {
            return this.maxRtt;
        }

        public long getNonetworkCount() {
            return this.nonetworkCount;
        }

        public long getTimeoutCount() {
            return this.timeoutCount;
        }

        public long getUtfNetWorkErroNum() {
            return this.utfNetWorkErroNum;
        }

        public void setAvgRtt(float f10) {
            this.avgRtt = f10;
        }

        public void setDegradeLocalDnsCount(long j10) {
            this.degradeLocalDnsCount = j10;
        }

        public void setDomainName(String str) {
            this.domainName = str;
        }

        public void setHitDnsCacheCount(long j10) {
            this.hitDnsCacheCount = j10;
        }

        public void setHttpabnormalCount(long j10) {
            this.httpabnormalCount = j10;
        }

        public void setIsp(String str) {
            this.isp = str;
        }

        public void setLocalDnsResolveErrCount(long j10) {
            this.localDnsResolveErrCount = j10;
        }

        public void setMaxRtt(float f10) {
            this.maxRtt = f10;
        }

        public void setNonetworkCount(long j10) {
            this.nonetworkCount = j10;
        }

        public void setPermissionErrCount(long j10) {
            this.permissionErrCount = j10;
        }

        public void setQueryType(int i10) {
            this.queryType = i10;
        }

        public void setRecursiveReqCount(long j10) {
            this.recursiveReqCount = j10;
        }

        public void setReqParameterErrCount(long j10) {
            this.reqParameterErrCount = j10;
        }

        public void setReqPathErrCount(long j10) {
            this.reqPathErrCount = j10;
        }

        public void setReqServerErrCount(long j10) {
            this.reqServerErrCount = j10;
        }

        public void setReqTimeoutCount(long j10) {
            this.reqTimeoutCount = j10;
        }

        public void setResolveSuccessCount(long j10) {
            this.resolveSuccessCount = j10;
        }

        public void setTimeoutCount(long j10) {
            this.timeoutCount = j10;
        }

        public void setUtfNetWorkErroNum(long j10) {
            this.utfNetWorkErroNum = j10;
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

    public long getCallPreloadMethodCount() {
        return this.callPreloadMethodCount;
    }

    public long getCallResolveMethodCount() {
        return this.callResolveMethodCount;
    }

    public CopyOnWriteArrayList<DataJsonBean> getData() {
        return this.items;
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

    public int getTermIpType() {
        return this.termIpType;
    }

    public long getTimestamp() {
        return this.timestamp;
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

    public void setCallPreloadMethodCount(long j10) {
        this.callPreloadMethodCount = j10;
    }

    public void setCallResolveMethodCount(long j10) {
        this.callResolveMethodCount = j10;
    }

    public void setData(CopyOnWriteArrayList<DataJsonBean> copyOnWriteArrayList) {
        this.items = copyOnWriteArrayList;
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

    public void setTermIpType(int i10) {
        this.termIpType = i10;
    }

    public void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }
}
