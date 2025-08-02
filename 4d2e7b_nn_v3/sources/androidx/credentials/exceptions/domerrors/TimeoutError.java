package androidx.credentials.exceptions.domerrors;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class TimeoutError extends DomError {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_TIMEOUT_ERROR = "androidx.credentials.TYPE_TIMEOUT_ERROR";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TimeoutError() {
        super(TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_TIMEOUT_ERROR);
    }
}
