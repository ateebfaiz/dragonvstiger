package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.internal.RequestValidationHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class CreatePublicKeyCredentialResponse extends CreateCredentialResponse {
    public static final String BUNDLE_KEY_REGISTRATION_RESPONSE_JSON = "androidx.credentials.BUNDLE_KEY_REGISTRATION_RESPONSE_JSON";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String registrationResponseJson;

    public static final class Companion {
        private Companion() {
        }

        public final CreatePublicKeyCredentialResponse createFrom$credentials_release(Bundle bundle) {
            m.f(bundle, "data");
            try {
                String string = bundle.getString(CreatePublicKeyCredentialResponse.BUNDLE_KEY_REGISTRATION_RESPONSE_JSON);
                m.c(string);
                return new CreatePublicKeyCredentialResponse(string, bundle, (DefaultConstructorMarker) null);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        public final Bundle toBundle$credentials_release(String str) {
            m.f(str, "registrationResponseJson");
            Bundle bundle = new Bundle();
            bundle.putString(CreatePublicKeyCredentialResponse.BUNDLE_KEY_REGISTRATION_RESPONSE_JSON, str);
            return bundle;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ CreatePublicKeyCredentialResponse(String str, Bundle bundle, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bundle);
    }

    public static final CreatePublicKeyCredentialResponse createFrom$credentials_release(Bundle bundle) {
        return Companion.createFrom$credentials_release(bundle);
    }

    public static final Bundle toBundle$credentials_release(String str) {
        return Companion.toBundle$credentials_release(str);
    }

    public final String getRegistrationResponseJson() {
        return this.registrationResponseJson;
    }

    private CreatePublicKeyCredentialResponse(String str, Bundle bundle) {
        super(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, bundle);
        this.registrationResponseJson = str;
        if (!RequestValidationHelper.Companion.isValidJSON(str)) {
            throw new IllegalArgumentException("registrationResponseJson must not be empty, and must be a valid JSON".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreatePublicKeyCredentialResponse(String str) {
        this(str, Companion.toBundle$credentials_release(str));
        m.f(str, "registrationResponseJson");
    }
}
