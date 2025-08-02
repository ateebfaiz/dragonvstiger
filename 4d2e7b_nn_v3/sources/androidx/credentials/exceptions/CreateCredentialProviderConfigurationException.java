package androidx.credentials.exceptions;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class CreateCredentialProviderConfigurationException extends CreateCredentialException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_CREATE_CREDENTIAL_PROVIDER_CONFIGURATION_EXCEPTION = "androidx.credentials.TYPE_CREATE_CREDENTIAL_PROVIDER_CONFIGURATION_EXCEPTION";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CreateCredentialProviderConfigurationException() {
        this((CharSequence) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateCredentialProviderConfigurationException(CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : charSequence);
    }

    public CreateCredentialProviderConfigurationException(CharSequence charSequence) {
        super(TYPE_CREATE_CREDENTIAL_PROVIDER_CONFIGURATION_EXCEPTION, charSequence);
    }
}
