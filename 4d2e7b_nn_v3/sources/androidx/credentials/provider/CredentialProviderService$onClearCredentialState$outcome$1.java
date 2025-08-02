package androidx.credentials.provider;

import android.os.OutcomeReceiver;
import androidx.credentials.exceptions.ClearCredentialException;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.m;

public final class CredentialProviderService$onClearCredentialState$outcome$1 implements OutcomeReceiver {
    final /* synthetic */ OutcomeReceiver $callback;

    CredentialProviderService$onClearCredentialState$outcome$1(OutcomeReceiver outcomeReceiver) {
        this.$callback = outcomeReceiver;
    }

    public void onError(ClearCredentialException clearCredentialException) {
        m.f(clearCredentialException, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        OutcomeReceiver outcomeReceiver = this.$callback;
        l.a();
        outcomeReceiver.onError(k.a(clearCredentialException.getType(), clearCredentialException.getMessage()));
    }

    public void onResult(Void voidR) {
        this.$callback.onResult(voidR);
    }
}
