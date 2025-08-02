package androidx.credentials;

import android.os.Bundle;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class FederatedCredential extends Credential {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_FEDERATED_CREDENTIAL = "type.federated_credential";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private FederatedCredential() {
        super(TYPE_FEDERATED_CREDENTIAL, new Bundle());
    }
}
