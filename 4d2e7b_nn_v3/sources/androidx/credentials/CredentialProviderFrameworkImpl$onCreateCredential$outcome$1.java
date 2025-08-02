package androidx.credentials;

import android.credentials.CreateCredentialResponse;
import android.os.Bundle;
import android.os.OutcomeReceiver;
import android.util.Log;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.exceptions.CreateCredentialException;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.m;

public final class CredentialProviderFrameworkImpl$onCreateCredential$outcome$1 implements OutcomeReceiver {
    final /* synthetic */ CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> $callback;
    final /* synthetic */ CreateCredentialRequest $request;
    final /* synthetic */ CredentialProviderFrameworkImpl this$0;

    CredentialProviderFrameworkImpl$onCreateCredential$outcome$1(CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> credentialManagerCallback, CreateCredentialRequest createCredentialRequest, CredentialProviderFrameworkImpl credentialProviderFrameworkImpl) {
        this.$callback = credentialManagerCallback;
        this.$request = createCredentialRequest;
        this.this$0 = credentialProviderFrameworkImpl;
    }

    public /* bridge */ /* synthetic */ void onError(Throwable th) {
        onError(k0.a(th));
    }

    public /* bridge */ /* synthetic */ void onResult(Object obj) {
        onResult(m0.a(obj));
    }

    public void onError(android.credentials.CreateCredentialException createCredentialException) {
        m.f(createCredentialException, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        Log.i("CredManProvService", "CreateCredentialResponse error returned from framework");
        this.$callback.onError(this.this$0.convertToJetpackCreateException$credentials_release(createCredentialException));
    }

    public void onResult(CreateCredentialResponse createCredentialResponse) {
        m.f(createCredentialResponse, "response");
        Log.i("CredManProvService", "Create Result returned from framework: ");
        CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> credentialManagerCallback = this.$callback;
        CreateCredentialResponse.Companion companion = CreateCredentialResponse.Companion;
        String type = this.$request.getType();
        Bundle a10 = createCredentialResponse.getData();
        m.e(a10, "response.data");
        credentialManagerCallback.onResult(companion.createFrom(type, a10));
    }
}
