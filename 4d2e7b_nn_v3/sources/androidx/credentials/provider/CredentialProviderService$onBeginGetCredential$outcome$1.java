package androidx.credentials.provider;

import android.os.OutcomeReceiver;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.m;

public final class CredentialProviderService$onBeginGetCredential$outcome$1 implements OutcomeReceiver {
    final /* synthetic */ OutcomeReceiver $callback;

    CredentialProviderService$onBeginGetCredential$outcome$1(OutcomeReceiver outcomeReceiver) {
        this.$callback = outcomeReceiver;
    }

    public void onError(GetCredentialException getCredentialException) {
        m.f(getCredentialException, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        OutcomeReceiver outcomeReceiver = this.$callback;
        j.a();
        outcomeReceiver.onError(i.a(getCredentialException.getType(), getCredentialException.getMessage()));
    }

    public void onResult(BeginGetCredentialResponse beginGetCredentialResponse) {
        m.f(beginGetCredentialResponse, "response");
        this.$callback.onResult(BeginGetCredentialUtil.Companion.convertToFrameworkResponse(beginGetCredentialResponse));
    }
}
