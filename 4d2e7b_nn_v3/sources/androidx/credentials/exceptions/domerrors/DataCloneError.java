package androidx.credentials.exceptions.domerrors;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class DataCloneError extends DomError {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DATA_CLONE_ERROR = "androidx.credentials.TYPE_DATA_CLONE_ERROR";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DataCloneError() {
        super(TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DATA_CLONE_ERROR);
    }
}
