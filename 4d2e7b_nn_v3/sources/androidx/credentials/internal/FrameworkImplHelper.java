package androidx.credentials.internal;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.credentials.CreateCredentialRequest;
import androidx.credentials.CreatePasswordRequest;
import androidx.credentials.CreatePublicKeyCredentialRequest;
import androidx.credentials.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@RequiresApi(23)
public final class FrameworkImplHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        @RequiresApi(23)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final Bundle getFinalCreateCredentialData(CreateCredentialRequest createCredentialRequest, Context context) {
            int i10;
            m.f(createCredentialRequest, "request");
            m.f(context, "context");
            Bundle credentialData = createCredentialRequest.getCredentialData();
            Bundle bundle = createCredentialRequest.getDisplayInfo().toBundle();
            if (createCredentialRequest instanceof CreatePasswordRequest) {
                i10 = R.drawable.ic_password;
            } else if (createCredentialRequest instanceof CreatePublicKeyCredentialRequest) {
                i10 = R.drawable.ic_passkey;
            } else {
                i10 = R.drawable.ic_other_sign_in;
            }
            bundle.putParcelable(CreateCredentialRequest.DisplayInfo.BUNDLE_KEY_CREDENTIAL_TYPE_ICON, Icon.createWithResource(context, i10));
            credentialData.putBundle(CreateCredentialRequest.DisplayInfo.BUNDLE_KEY_REQUEST_DISPLAY_INFO, bundle);
            return credentialData;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Bundle getFinalCreateCredentialData(CreateCredentialRequest createCredentialRequest, Context context) {
        return Companion.getFinalCreateCredentialData(createCredentialRequest, context);
    }
}
