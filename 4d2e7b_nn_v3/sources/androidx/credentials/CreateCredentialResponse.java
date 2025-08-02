package androidx.credentials;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class CreateCredentialResponse {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Bundle data;
    private final String type;

    public static final class Companion {
        private Companion() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final CreateCredentialResponse createFrom(String str, Bundle bundle) {
            m.f(str, "type");
            m.f(bundle, "data");
            try {
                if (m.b(str, PasswordCredential.TYPE_PASSWORD_CREDENTIAL)) {
                    return CreatePasswordResponse.Companion.createFrom$credentials_release(bundle);
                }
                if (m.b(str, PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL)) {
                    return CreatePublicKeyCredentialResponse.Companion.createFrom$credentials_release(bundle);
                }
                throw new FrameworkClassParsingException();
            } catch (FrameworkClassParsingException unused) {
                return new CreateCustomCredentialResponse(str, bundle);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CreateCredentialResponse(String str, Bundle bundle) {
        m.f(str, "type");
        m.f(bundle, "data");
        this.type = str;
        this.data = bundle;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final CreateCredentialResponse createFrom(String str, Bundle bundle) {
        return Companion.createFrom(str, bundle);
    }

    public final Bundle getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }
}
