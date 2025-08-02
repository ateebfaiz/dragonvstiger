package androidx.credentials.exceptions;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ClearCredentialInterruptedException extends ClearCredentialException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_CLEAR_CREDENTIAL_INTERRUPTED_EXCEPTION = "androidx.credentials.TYPE_CLEAR_CREDENTIAL_INTERRUPTED_EXCEPTION";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ClearCredentialInterruptedException() {
        this((CharSequence) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClearCredentialInterruptedException(CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : charSequence);
    }

    public ClearCredentialInterruptedException(CharSequence charSequence) {
        super(TYPE_CLEAR_CREDENTIAL_INTERRUPTED_EXCEPTION, charSequence);
    }
}
