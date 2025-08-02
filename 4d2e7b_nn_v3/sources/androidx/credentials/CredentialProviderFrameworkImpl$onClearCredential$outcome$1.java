package androidx.credentials;

import android.credentials.ClearCredentialStateException;
import android.os.OutcomeReceiver;
import android.util.Log;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.ClearCredentialUnknownException;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class CredentialProviderFrameworkImpl$onClearCredential$outcome$1 implements OutcomeReceiver {
    final /* synthetic */ CredentialManagerCallback<Void, ClearCredentialException> $callback;

    CredentialProviderFrameworkImpl$onClearCredential$outcome$1(CredentialManagerCallback<Void, ClearCredentialException> credentialManagerCallback) {
        this.$callback = credentialManagerCallback;
    }

    public /* bridge */ /* synthetic */ void onError(Throwable th) {
        onError(j0.a(th));
    }

    public void onError(ClearCredentialStateException clearCredentialStateException) {
        m.f(clearCredentialStateException, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        Log.i("CredManProvService", "ClearCredentialStateException error returned from framework");
        this.$callback.onError(new ClearCredentialUnknownException((CharSequence) null, 1, (DefaultConstructorMarker) null));
    }

    public void onResult(Void voidR) {
        m.f(voidR, "response");
        Log.i("CredManProvService", "Clear result returned from framework: ");
        this.$callback.onResult(voidR);
    }
}
