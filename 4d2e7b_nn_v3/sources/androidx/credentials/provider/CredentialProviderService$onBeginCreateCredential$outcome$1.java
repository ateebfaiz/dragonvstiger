package androidx.credentials.provider;

import android.os.OutcomeReceiver;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.m;

public final class CredentialProviderService$onBeginCreateCredential$outcome$1 implements OutcomeReceiver {
    final /* synthetic */ OutcomeReceiver $callback;

    CredentialProviderService$onBeginCreateCredential$outcome$1(OutcomeReceiver outcomeReceiver) {
        this.$callback = outcomeReceiver;
    }

    public void onError(CreateCredentialException createCredentialException) {
        m.f(createCredentialException, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        OutcomeReceiver outcomeReceiver = this.$callback;
        h.a();
        outcomeReceiver.onError(g.a(createCredentialException.getType(), createCredentialException.getMessage()));
    }

    public void onResult(BeginCreateCredentialResponse beginCreateCredentialResponse) {
        m.f(beginCreateCredentialResponse, "response");
        this.$callback.onResult(BeginCreateCredentialUtil.Companion.convertToFrameworkResponse(beginCreateCredentialResponse));
    }
}
