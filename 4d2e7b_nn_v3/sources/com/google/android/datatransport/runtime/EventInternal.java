package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.a;
import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@AutoValue
public abstract class EventInternal {

    @AutoValue.Builder
    public static abstract class Builder {
        public final Builder addMetadata(String str, String str2) {
            getAutoMetadata().put(str, str2);
            return this;
        }

        public abstract EventInternal build();

        /* access modifiers changed from: protected */
        public abstract Map<String, String> getAutoMetadata();

        /* access modifiers changed from: protected */
        public abstract Builder setAutoMetadata(Map<String, String> map);

        public abstract Builder setCode(Integer num);

        public abstract Builder setEncodedPayload(EncodedPayload encodedPayload);

        public abstract Builder setEventMillis(long j10);

        public abstract Builder setTransportName(String str);

        public abstract Builder setUptimeMillis(long j10);

        public final Builder addMetadata(String str, long j10) {
            getAutoMetadata().put(str, String.valueOf(j10));
            return this;
        }

        public final Builder addMetadata(String str, int i10) {
            getAutoMetadata().put(str, String.valueOf(i10));
            return this;
        }
    }

    public static Builder builder() {
        return new a.b().setAutoMetadata(new HashMap());
    }

    public final String get(String str) {
        String str2 = getAutoMetadata().get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, String> getAutoMetadata();

    @Nullable
    public abstract Integer getCode();

    public abstract EncodedPayload getEncodedPayload();

    public abstract long getEventMillis();

    public final int getInteger(String str) {
        String str2 = getAutoMetadata().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final long getLong(String str) {
        String str2 = getAutoMetadata().get(str);
        if (str2 == null) {
            return 0;
        }
        return Long.valueOf(str2).longValue();
    }

    public final Map<String, String> getMetadata() {
        return Collections.unmodifiableMap(getAutoMetadata());
    }

    public final String getOrDefault(String str, String str2) {
        String str3 = getAutoMetadata().get(str);
        if (str3 == null) {
            return str2;
        }
        return str3;
    }

    @Deprecated
    public byte[] getPayload() {
        return getEncodedPayload().getBytes();
    }

    public abstract String getTransportName();

    public abstract long getUptimeMillis();

    public Builder toBuilder() {
        return new a.b().setTransportName(getTransportName()).setCode(getCode()).setEncodedPayload(getEncodedPayload()).setEventMillis(getEventMillis()).setUptimeMillis(getUptimeMillis()).setAutoMetadata(new HashMap(getAutoMetadata()));
    }
}
