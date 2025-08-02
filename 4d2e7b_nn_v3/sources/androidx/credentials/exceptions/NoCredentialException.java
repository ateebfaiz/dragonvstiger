package androidx.credentials.exceptions;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class NoCredentialException extends GetCredentialException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_FRAMEWORK_TYPE_NO_CREDENTIAL = "android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public NoCredentialException() {
        this((CharSequence) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NoCredentialException(CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : charSequence);
    }

    public NoCredentialException(CharSequence charSequence) {
        super(TYPE_FRAMEWORK_TYPE_NO_CREDENTIAL, charSequence);
    }
}
