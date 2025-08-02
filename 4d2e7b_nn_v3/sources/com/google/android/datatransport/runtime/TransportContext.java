package com.google.android.datatransport.runtime;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.c;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TransportContext {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract TransportContext build();

        public abstract Builder setBackendName(String str);

        public abstract Builder setExtras(@Nullable byte[] bArr);

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public abstract Builder setPriority(Priority priority);
    }

    public static Builder builder() {
        return new c.b().setPriority(Priority.DEFAULT);
    }

    public abstract String getBackendName();

    @Nullable
    public abstract byte[] getExtras();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract Priority getPriority();

    public boolean shouldUploadClientHealthMetrics() {
        if (getExtras() != null) {
            return true;
        }
        return false;
    }

    public final String toString() {
        String str;
        String backendName = getBackendName();
        Priority priority = getPriority();
        if (getExtras() == null) {
            str = "";
        } else {
            str = Base64.encodeToString(getExtras(), 2);
        }
        return String.format("TransportContext(%s, %s, %s)", new Object[]{backendName, priority, str});
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TransportContext withPriority(Priority priority) {
        return builder().setBackendName(getBackendName()).setPriority(priority).setExtras(getExtras()).build();
    }
}
