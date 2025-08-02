package androidx.credentials.exceptions;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class CreateCredentialUnknownException extends CreateCredentialException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_CREATE_CREDENTIAL_UNKNOWN_EXCEPTION = "android.credentials.CreateCredentialException.TYPE_UNKNOWN";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CreateCredentialUnknownException() {
        this((CharSequence) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateCredentialUnknownException(CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : charSequence);
    }

    public CreateCredentialUnknownException(CharSequence charSequence) {
        super(TYPE_CREATE_CREDENTIAL_UNKNOWN_EXCEPTION, charSequence);
    }
}
