package androidx.credentials.exceptions;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class CreateCredentialCancellationException extends CreateCredentialException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_CREATE_CREDENTIAL_CANCELLATION_EXCEPTION = "android.credentials.CreateCredentialException.TYPE_USER_CANCELED";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CreateCredentialCancellationException() {
        this((CharSequence) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateCredentialCancellationException(CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : charSequence);
    }

    public CreateCredentialCancellationException(CharSequence charSequence) {
        super(TYPE_CREATE_CREDENTIAL_CANCELLATION_EXCEPTION, charSequence);
    }
}
