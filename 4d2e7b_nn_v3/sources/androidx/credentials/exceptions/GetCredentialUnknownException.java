package androidx.credentials.exceptions;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class GetCredentialUnknownException extends GetCredentialException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_GET_CREDENTIAL_UNKNOWN_EXCEPTION = "android.credentials.GetCredentialException.TYPE_UNKNOWN";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GetCredentialUnknownException() {
        this((CharSequence) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCredentialUnknownException(CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : charSequence);
    }

    public GetCredentialUnknownException(CharSequence charSequence) {
        super(TYPE_GET_CREDENTIAL_UNKNOWN_EXCEPTION, charSequence);
    }
}
