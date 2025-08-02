package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogRequest;
import java.util.List;

final class e extends LogRequest {

    /* renamed from: a  reason: collision with root package name */
    private final long f6384a;

    /* renamed from: b  reason: collision with root package name */
    private final long f6385b;

    /* renamed from: c  reason: collision with root package name */
    private final ClientInfo f6386c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f6387d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6388e;

    /* renamed from: f  reason: collision with root package name */
    private final List f6389f;

    /* renamed from: g  reason: collision with root package name */
    private final QosTier f6390g;

    static final class b extends LogRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f6391a;

        /* renamed from: b  reason: collision with root package name */
        private Long f6392b;

        /* renamed from: c  reason: collision with root package name */
        private ClientInfo f6393c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f6394d;

        /* renamed from: e  reason: collision with root package name */
        private String f6395e;

        /* renamed from: f  reason: collision with root package name */
        private List f6396f;

        /* renamed from: g  reason: collision with root package name */
        private QosTier f6397g;

        b() {
        }

        public LogRequest build() {
            String str = "";
            if (this.f6391a == null) {
                str = str + " requestTimeMs";
            }
            if (this.f6392b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new e(this.f6391a.longValue(), this.f6392b.longValue(), this.f6393c, this.f6394d, this.f6395e, this.f6396f, this.f6397g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public LogRequest.Builder setClientInfo(ClientInfo clientInfo) {
            this.f6393c = clientInfo;
            return this;
        }

        public LogRequest.Builder setLogEvents(List list) {
            this.f6396f = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogRequest.Builder setLogSource(Integer num) {
            this.f6394d = num;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogRequest.Builder setLogSourceName(String str) {
            this.f6395e = str;
            return this;
        }

        public LogRequest.Builder setQosTier(QosTier qosTier) {
            this.f6397g = qosTier;
            return this;
        }

        public LogRequest.Builder setRequestTimeMs(long j10) {
            this.f6391a = Long.valueOf(j10);
            return this;
        }

        public LogRequest.Builder setRequestUptimeMs(long j10) {
            this.f6392b = Long.valueOf(j10);
            return this;
        }
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) obj;
        if (this.f6384a == logRequest.getRequestTimeMs() && this.f6385b == logRequest.getRequestUptimeMs() && ((clientInfo = this.f6386c) != null ? clientInfo.equals(logRequest.getClientInfo()) : logRequest.getClientInfo() == null) && ((num = this.f6387d) != null ? num.equals(logRequest.getLogSource()) : logRequest.getLogSource() == null) && ((str = this.f6388e) != null ? str.equals(logRequest.getLogSourceName()) : logRequest.getLogSourceName() == null) && ((list = this.f6389f) != null ? list.equals(logRequest.getLogEvents()) : logRequest.getLogEvents() == null)) {
            QosTier qosTier = this.f6390g;
            if (qosTier == null) {
                if (logRequest.getQosTier() == null) {
                    return true;
                }
            } else if (qosTier.equals(logRequest.getQosTier())) {
                return true;
            }
        }
        return false;
    }

    public ClientInfo getClientInfo() {
        return this.f6386c;
    }

    public List getLogEvents() {
        return this.f6389f;
    }

    public Integer getLogSource() {
        return this.f6387d;
    }

    public String getLogSourceName() {
        return this.f6388e;
    }

    public QosTier getQosTier() {
        return this.f6390g;
    }

    public long getRequestTimeMs() {
        return this.f6384a;
    }

    public long getRequestUptimeMs() {
        return this.f6385b;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        long j10 = this.f6384a;
        long j11 = this.f6385b;
        int i14 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003;
        ClientInfo clientInfo = this.f6386c;
        int i15 = 0;
        if (clientInfo == null) {
            i10 = 0;
        } else {
            i10 = clientInfo.hashCode();
        }
        int i16 = (i14 ^ i10) * 1000003;
        Integer num = this.f6387d;
        if (num == null) {
            i11 = 0;
        } else {
            i11 = num.hashCode();
        }
        int i17 = (i16 ^ i11) * 1000003;
        String str = this.f6388e;
        if (str == null) {
            i12 = 0;
        } else {
            i12 = str.hashCode();
        }
        int i18 = (i17 ^ i12) * 1000003;
        List list = this.f6389f;
        if (list == null) {
            i13 = 0;
        } else {
            i13 = list.hashCode();
        }
        int i19 = (i18 ^ i13) * 1000003;
        QosTier qosTier = this.f6390g;
        if (qosTier != null) {
            i15 = qosTier.hashCode();
        }
        return i19 ^ i15;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f6384a + ", requestUptimeMs=" + this.f6385b + ", clientInfo=" + this.f6386c + ", logSource=" + this.f6387d + ", logSourceName=" + this.f6388e + ", logEvents=" + this.f6389f + ", qosTier=" + this.f6390g + "}";
    }

    private e(long j10, long j11, ClientInfo clientInfo, Integer num, String str, List list, QosTier qosTier) {
        this.f6384a = j10;
        this.f6385b = j11;
        this.f6386c = clientInfo;
        this.f6387d = num;
        this.f6388e = str;
        this.f6389f = list;
        this.f6390g = qosTier;
    }
}
