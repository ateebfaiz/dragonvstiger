package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogEvent;
import java.util.Arrays;

final class d extends LogEvent {

    /* renamed from: a  reason: collision with root package name */
    private final long f6370a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f6371b;

    /* renamed from: c  reason: collision with root package name */
    private final long f6372c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f6373d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6374e;

    /* renamed from: f  reason: collision with root package name */
    private final long f6375f;

    /* renamed from: g  reason: collision with root package name */
    private final NetworkConnectionInfo f6376g;

    static final class b extends LogEvent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f6377a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f6378b;

        /* renamed from: c  reason: collision with root package name */
        private Long f6379c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f6380d;

        /* renamed from: e  reason: collision with root package name */
        private String f6381e;

        /* renamed from: f  reason: collision with root package name */
        private Long f6382f;

        /* renamed from: g  reason: collision with root package name */
        private NetworkConnectionInfo f6383g;

        b() {
        }

        public LogEvent build() {
            String str = "";
            if (this.f6377a == null) {
                str = str + " eventTimeMs";
            }
            if (this.f6379c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f6382f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new d(this.f6377a.longValue(), this.f6378b, this.f6379c.longValue(), this.f6380d, this.f6381e, this.f6382f.longValue(), this.f6383g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public LogEvent.Builder setEventCode(Integer num) {
            this.f6378b = num;
            return this;
        }

        public LogEvent.Builder setEventTimeMs(long j10) {
            this.f6377a = Long.valueOf(j10);
            return this;
        }

        public LogEvent.Builder setEventUptimeMs(long j10) {
            this.f6379c = Long.valueOf(j10);
            return this;
        }

        public LogEvent.Builder setNetworkConnectionInfo(NetworkConnectionInfo networkConnectionInfo) {
            this.f6383g = networkConnectionInfo;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogEvent.Builder setSourceExtension(byte[] bArr) {
            this.f6380d = bArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogEvent.Builder setSourceExtensionJsonProto3(String str) {
            this.f6381e = str;
            return this;
        }

        public LogEvent.Builder setTimezoneOffsetSeconds(long j10) {
            this.f6382f = Long.valueOf(j10);
            return this;
        }
    }

    public boolean equals(Object obj) {
        Integer num;
        byte[] bArr;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        if (this.f6370a == logEvent.getEventTimeMs() && ((num = this.f6371b) != null ? num.equals(logEvent.getEventCode()) : logEvent.getEventCode() == null) && this.f6372c == logEvent.getEventUptimeMs()) {
            byte[] bArr2 = this.f6373d;
            if (logEvent instanceof d) {
                bArr = ((d) logEvent).f6373d;
            } else {
                bArr = logEvent.getSourceExtension();
            }
            if (Arrays.equals(bArr2, bArr) && ((str = this.f6374e) != null ? str.equals(logEvent.getSourceExtensionJsonProto3()) : logEvent.getSourceExtensionJsonProto3() == null) && this.f6375f == logEvent.getTimezoneOffsetSeconds()) {
                NetworkConnectionInfo networkConnectionInfo = this.f6376g;
                if (networkConnectionInfo == null) {
                    if (logEvent.getNetworkConnectionInfo() == null) {
                        return true;
                    }
                } else if (networkConnectionInfo.equals(logEvent.getNetworkConnectionInfo())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Integer getEventCode() {
        return this.f6371b;
    }

    public long getEventTimeMs() {
        return this.f6370a;
    }

    public long getEventUptimeMs() {
        return this.f6372c;
    }

    public NetworkConnectionInfo getNetworkConnectionInfo() {
        return this.f6376g;
    }

    public byte[] getSourceExtension() {
        return this.f6373d;
    }

    public String getSourceExtensionJsonProto3() {
        return this.f6374e;
    }

    public long getTimezoneOffsetSeconds() {
        return this.f6375f;
    }

    public int hashCode() {
        int i10;
        int i11;
        long j10 = this.f6370a;
        int i12 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f6371b;
        int i13 = 0;
        if (num == null) {
            i10 = 0;
        } else {
            i10 = num.hashCode();
        }
        long j11 = this.f6372c;
        int hashCode = (((((i12 ^ i10) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f6373d)) * 1000003;
        String str = this.f6374e;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        long j12 = this.f6375f;
        int i14 = (((hashCode ^ i11) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f6376g;
        if (networkConnectionInfo != null) {
            i13 = networkConnectionInfo.hashCode();
        }
        return i14 ^ i13;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f6370a + ", eventCode=" + this.f6371b + ", eventUptimeMs=" + this.f6372c + ", sourceExtension=" + Arrays.toString(this.f6373d) + ", sourceExtensionJsonProto3=" + this.f6374e + ", timezoneOffsetSeconds=" + this.f6375f + ", networkConnectionInfo=" + this.f6376g + "}";
    }

    private d(long j10, Integer num, long j11, byte[] bArr, String str, long j12, NetworkConnectionInfo networkConnectionInfo) {
        this.f6370a = j10;
        this.f6371b = num;
        this.f6372c = j11;
        this.f6373d = bArr;
        this.f6374e = str;
        this.f6375f = j12;
        this.f6376g = networkConnectionInfo;
    }
}
