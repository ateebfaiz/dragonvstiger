package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.internal.RequestValidationHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class PublicKeyCredential extends Credential {
    public static final String BUNDLE_KEY_AUTHENTICATION_RESPONSE_JSON = "androidx.credentials.BUNDLE_KEY_AUTHENTICATION_RESPONSE_JSON";
    public static final String BUNDLE_KEY_SUBTYPE = "androidx.credentials.BUNDLE_KEY_SUBTYPE";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_PUBLIC_KEY_CREDENTIAL = "androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL";
    private final String authenticationResponseJson;

    public static final class Companion {
        private Companion() {
        }

        public final PublicKeyCredential createFrom$credentials_release(Bundle bundle) {
            m.f(bundle, "data");
            try {
                String string = bundle.getString(PublicKeyCredential.BUNDLE_KEY_AUTHENTICATION_RESPONSE_JSON);
                m.c(string);
                return new PublicKeyCredential(string, bundle, (DefaultConstructorMarker) null);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        public final Bundle toBundle$credentials_release(String str) {
            m.f(str, "authenticationResponseJson");
            Bundle bundle = new Bundle();
            bundle.putString(PublicKeyCredential.BUNDLE_KEY_AUTHENTICATION_RESPONSE_JSON, str);
            return bundle;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ PublicKeyCredential(String str, Bundle bundle, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bundle);
    }

    public static final PublicKeyCredential createFrom$credentials_release(Bundle bundle) {
        return Companion.createFrom$credentials_release(bundle);
    }

    public static final Bundle toBundle$credentials_release(String str) {
        return Companion.toBundle$credentials_release(str);
    }

    public final String getAuthenticationResponseJson() {
        return this.authenticationResponseJson;
    }

    private PublicKeyCredential(String str, Bundle bundle) {
        super(TYPE_PUBLIC_KEY_CREDENTIAL, bundle);
        this.authenticationResponseJson = str;
        if (!RequestValidationHelper.Companion.isValidJSON(str)) {
            throw new IllegalArgumentException("authenticationResponseJson must not be empty, and must be a valid JSON".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PublicKeyCredential(String str) {
        this(str, Companion.toBundle$credentials_release(str));
        m.f(str, "authenticationResponseJson");
    }
}
