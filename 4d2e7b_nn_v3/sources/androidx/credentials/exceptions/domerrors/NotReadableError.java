package androidx.credentials.exceptions.domerrors;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class NotReadableError extends DomError {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_READABLE_ERROR = "androidx.credentials.TYPE_NOT_READABLE_ERROR";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public NotReadableError() {
        super(TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_READABLE_ERROR);
    }
}
