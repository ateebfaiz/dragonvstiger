package androidx.credentials.exceptions;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ClearCredentialUnknownException extends ClearCredentialException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_CLEAR_CREDENTIAL_UNKNOWN_EXCEPTION = "android.credentials.ClearCredentialStateException.TYPE_UNKNOWN";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ClearCredentialUnknownException() {
        this((CharSequence) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClearCredentialUnknownException(CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : charSequence);
    }

    public ClearCredentialUnknownException(CharSequence charSequence) {
        super(TYPE_CLEAR_CREDENTIAL_UNKNOWN_EXCEPTION, charSequence);
    }
}
