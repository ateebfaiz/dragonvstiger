package androidx.credentials.internal;

import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class RequestValidationHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final boolean isValidJSON(String str) {
            m.f(str, "jsonString");
            if (str.length() == 0) {
                return false;
            }
            try {
                new JSONObject(str);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final boolean isValidJSON(String str) {
        return Companion.isValidJSON(str);
    }
}
