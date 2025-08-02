package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.firebase.installations.remote.b;

@AutoValue
public abstract class TokenResult {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract TokenResult build();

        @NonNull
        public abstract Builder setResponseCode(@NonNull ResponseCode responseCode);

        @NonNull
        public abstract Builder setToken(@NonNull String str);

        @NonNull
        public abstract Builder setTokenExpirationTimestamp(long j10);
    }

    public enum ResponseCode {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    @NonNull
    public static Builder builder() {
        return new b.C0107b().setTokenExpirationTimestamp(0);
    }

    @Nullable
    public abstract ResponseCode getResponseCode();

    @Nullable
    public abstract String getToken();

    @NonNull
    public abstract long getTokenExpirationTimestamp();

    @NonNull
    public abstract Builder toBuilder();
}
