package androidx.credentials.exceptions;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class GetCredentialInterruptedException extends GetCredentialException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_GET_CREDENTIAL_INTERRUPTED_EXCEPTION = "android.credentials.GetCredentialException.TYPE_INTERRUPTED";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GetCredentialInterruptedException() {
        this((CharSequence) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCredentialInterruptedException(CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : charSequence);
    }

    public GetCredentialInterruptedException(CharSequence charSequence) {
        super(TYPE_GET_CREDENTIAL_INTERRUPTED_EXCEPTION, charSequence);
    }
}
