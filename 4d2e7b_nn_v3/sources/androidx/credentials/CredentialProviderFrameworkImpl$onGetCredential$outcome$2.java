package androidx.credentials;

import android.credentials.GetCredentialResponse;
import android.os.OutcomeReceiver;
import android.util.Log;
import androidx.credentials.exceptions.GetCredentialException;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.m;

public final class CredentialProviderFrameworkImpl$onGetCredential$outcome$2 implements OutcomeReceiver {
    final /* synthetic */ CredentialManagerCallback<GetCredentialResponse, GetCredentialException> $callback;
    final /* synthetic */ CredentialProviderFrameworkImpl this$0;

    CredentialProviderFrameworkImpl$onGetCredential$outcome$2(CredentialManagerCallback<GetCredentialResponse, GetCredentialException> credentialManagerCallback, CredentialProviderFrameworkImpl credentialProviderFrameworkImpl) {
        this.$callback = credentialManagerCallback;
        this.this$0 = credentialProviderFrameworkImpl;
    }

    public /* bridge */ /* synthetic */ void onError(Throwable th) {
        onError(o0.a(th));
    }

    public /* bridge */ /* synthetic */ void onResult(Object obj) {
        onResult(n0.a(obj));
    }

    public void onError(android.credentials.GetCredentialException getCredentialException) {
        m.f(getCredentialException, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        Log.i("CredManProvService", "GetCredentialResponse error returned from framework");
        this.$callback.onError(this.this$0.convertToJetpackGetException$credentials_release(getCredentialException));
    }

    public void onResult(GetCredentialResponse getCredentialResponse) {
        m.f(getCredentialResponse, "response");
        Log.i("CredManProvService", "GetCredentialResponse returned from framework");
        this.$callback.onResult(this.this$0.convertGetResponseToJetpackClass$credentials_release(getCredentialResponse));
    }
}
