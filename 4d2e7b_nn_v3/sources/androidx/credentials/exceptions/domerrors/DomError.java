package androidx.credentials.exceptions.domerrors;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import kotlin.jvm.internal.m;

public abstract class DomError {
    private final String type;

    public DomError(String str) {
        m.f(str, "type");
        this.type = str;
    }

    @VisibleForTesting(otherwise = 3)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getType() {
        return this.type;
    }
}
