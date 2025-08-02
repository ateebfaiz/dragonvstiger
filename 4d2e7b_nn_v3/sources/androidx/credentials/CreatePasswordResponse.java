package androidx.credentials;

import android.os.Bundle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class CreatePasswordResponse extends CreateCredentialResponse {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public final CreatePasswordResponse createFrom$credentials_release(Bundle bundle) {
            m.f(bundle, "data");
            return new CreatePasswordResponse(bundle, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ CreatePasswordResponse(Bundle bundle, DefaultConstructorMarker defaultConstructorMarker) {
        this(bundle);
    }

    public static final CreatePasswordResponse createFrom$credentials_release(Bundle bundle) {
        return Companion.createFrom$credentials_release(bundle);
    }

    private CreatePasswordResponse(Bundle bundle) {
        super(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, bundle);
    }

    public CreatePasswordResponse() {
        this(new Bundle());
    }
}
