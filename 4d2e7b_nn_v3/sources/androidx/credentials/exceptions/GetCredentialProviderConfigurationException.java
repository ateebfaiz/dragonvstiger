package androidx.credentials.exceptions;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class GetCredentialProviderConfigurationException extends GetCredentialException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_GET_CREDENTIAL_PROVIDER_CONFIGURATION_EXCEPTION = "androidx.credentials.TYPE_GET_CREDENTIAL_PROVIDER_CONFIGURATION_EXCEPTION";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GetCredentialProviderConfigurationException() {
        this((CharSequence) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCredentialProviderConfigurationException(CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : charSequence);
    }

    public GetCredentialProviderConfigurationException(CharSequence charSequence) {
        super(TYPE_GET_CREDENTIAL_PROVIDER_CONFIGURATION_EXCEPTION, charSequence);
    }
}
