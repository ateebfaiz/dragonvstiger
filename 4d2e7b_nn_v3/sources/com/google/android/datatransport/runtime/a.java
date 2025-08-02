package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.EventInternal;
import java.util.Map;

final class a extends EventInternal {

    /* renamed from: a  reason: collision with root package name */
    private final String f6425a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f6426b;

    /* renamed from: c  reason: collision with root package name */
    private final EncodedPayload f6427c;

    /* renamed from: d  reason: collision with root package name */
    private final long f6428d;

    /* renamed from: e  reason: collision with root package name */
    private final long f6429e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f6430f;

    static final class b extends EventInternal.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f6431a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f6432b;

        /* renamed from: c  reason: collision with root package name */
        private EncodedPayload f6433c;

        /* renamed from: d  reason: collision with root package name */
        private Long f6434d;

        /* renamed from: e  reason: collision with root package name */
        private Long f6435e;

        /* renamed from: f  reason: collision with root package name */
        private Map f6436f;

        b() {
        }

        public EventInternal build() {
            String str = "";
            if (this.f6431a == null) {
                str = str + " transportName";
            }
            if (this.f6433c == null) {
                str = str + " encodedPayload";
            }
            if (this.f6434d == null) {
                str = str + " eventMillis";
            }
            if (this.f6435e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f6436f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new a(this.f6431a, this.f6432b, this.f6433c, this.f6434d.longValue(), this.f6435e.longValue(), this.f6436f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: protected */
        public Map getAutoMetadata() {
            Map map = this.f6436f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* access modifiers changed from: protected */
        public EventInternal.Builder setAutoMetadata(Map map) {
            if (map != null) {
                this.f6436f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        public EventInternal.Builder setCode(Integer num) {
            this.f6432b = num;
            return this;
        }

        public EventInternal.Builder setEncodedPayload(EncodedPayload encodedPayload) {
            if (encodedPayload != null) {
                this.f6433c = encodedPayload;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        public EventInternal.Builder setEventMillis(long j10) {
            this.f6434d = Long.valueOf(j10);
            return this;
        }

        public EventInternal.Builder setTransportName(String str) {
            if (str != null) {
                this.f6431a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        public EventInternal.Builder setUptimeMillis(long j10) {
            this.f6435e = Long.valueOf(j10);
            return this;
        }
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        if (!this.f6425a.equals(eventInternal.getTransportName()) || ((num = this.f6426b) != null ? !num.equals(eventInternal.getCode()) : eventInternal.getCode() != null) || !this.f6427c.equals(eventInternal.getEncodedPayload()) || this.f6428d != eventInternal.getEventMillis() || this.f6429e != eventInternal.getUptimeMillis() || !this.f6430f.equals(eventInternal.getAutoMetadata())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public Map getAutoMetadata() {
        return this.f6430f;
    }

    public Integer getCode() {
        return this.f6426b;
    }

    public EncodedPayload getEncodedPayload() {
        return this.f6427c;
    }

    public long getEventMillis() {
        return this.f6428d;
    }

    public String getTransportName() {
        return this.f6425a;
    }

    public long getUptimeMillis() {
        return this.f6429e;
    }

    public int hashCode() {
        int i10;
        int hashCode = (this.f6425a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f6426b;
        if (num == null) {
            i10 = 0;
        } else {
            i10 = num.hashCode();
        }
        long j10 = this.f6428d;
        long j11 = this.f6429e;
        return ((((((((hashCode ^ i10) * 1000003) ^ this.f6427c.hashCode()) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f6430f.hashCode();
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f6425a + ", code=" + this.f6426b + ", encodedPayload=" + this.f6427c + ", eventMillis=" + this.f6428d + ", uptimeMillis=" + this.f6429e + ", autoMetadata=" + this.f6430f + "}";
    }

    private a(String str, Integer num, EncodedPayload encodedPayload, long j10, long j11, Map map) {
        this.f6425a = str;
        this.f6426b = num;
        this.f6427c = encodedPayload;
        this.f6428d = j10;
        this.f6429e = j11;
        this.f6430f = map;
    }
}
