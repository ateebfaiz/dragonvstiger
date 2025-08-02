package androidx.credentials.exceptions.domerrors;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ReadOnlyError extends DomError {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_READ_ONLY_ERROR = "androidx.credentials.TYPE_READ_ONLY_ERROR";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ReadOnlyError() {
        super(TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_READ_ONLY_ERROR);
    }
}
