package androidx.credentials;

import android.credentials.PrepareGetCredentialResponse;
import android.os.OutcomeReceiver;
import androidx.credentials.exceptions.GetCredentialException;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.m;

public final class CredentialProviderFrameworkImpl$onPrepareCredential$outcome$1 implements OutcomeReceiver {
    final /* synthetic */ CredentialManagerCallback<PrepareGetCredentialResponse, GetCredentialException> $callback;
    final /* synthetic */ CredentialProviderFrameworkImpl this$0;

    CredentialProviderFrameworkImpl$onPrepareCredential$outcome$1(CredentialManagerCallback<PrepareGetCredentialResponse, GetCredentialException> credentialManagerCallback, CredentialProviderFrameworkImpl credentialProviderFrameworkImpl) {
        this.$callback = credentialManagerCallback;
        this.this$0 = credentialProviderFrameworkImpl;
    }

    public /* bridge */ /* synthetic */ void onError(Throwable th) {
        onError(o0.a(th));
    }

    public /* bridge */ /* synthetic */ void onResult(Object obj) {
        onResult(p0.a(obj));
    }

    public void onError(android.credentials.GetCredentialException getCredentialException) {
        m.f(getCredentialException, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        this.$callback.onError(this.this$0.convertToJetpackGetException$credentials_release(getCredentialException));
    }

    public void onResult(PrepareGetCredentialResponse prepareGetCredentialResponse) {
        m.f(prepareGetCredentialResponse, "response");
        this.$callback.onResult(this.this$0.convertPrepareGetResponseToJetpackClass$credentials_release(prepareGetCredentialResponse));
    }
}
