package androidx.credentials.provider.utils;

import android.content.pm.SigningInfo;
import android.service.credentials.ClearCredentialStateRequest;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.credentials.provider.CallingAppInfo;
import androidx.credentials.provider.ProviderClearCredentialStateRequest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@RequiresApi(34)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ClearCredentialUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public final ProviderClearCredentialStateRequest convertToJetpackRequest$credentials_release(ClearCredentialStateRequest clearCredentialStateRequest) {
            m.f(clearCredentialStateRequest, "request");
            String a10 = clearCredentialStateRequest.getCallingAppInfo().getPackageName();
            m.e(a10, "request.callingAppInfo.packageName");
            SigningInfo a11 = clearCredentialStateRequest.getCallingAppInfo().getSigningInfo();
            m.e(a11, "request.callingAppInfo.signingInfo");
            return new ProviderClearCredentialStateRequest(new CallingAppInfo(a10, a11, clearCredentialStateRequest.getCallingAppInfo().getOrigin()));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final ProviderClearCredentialStateRequest convertToJetpackRequest$credentials_release(ClearCredentialStateRequest clearCredentialStateRequest) {
        return Companion.convertToJetpackRequest$credentials_release(clearCredentialStateRequest);
    }
}
