package androidx.credentials.provider;

import android.os.CancellationSignal;
import android.os.OutcomeReceiver;
import android.service.credentials.BeginCreateCredentialRequest;
import android.service.credentials.BeginGetCredentialRequest;
import android.service.credentials.ClearCredentialStateRequest;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.o;
import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import androidx.credentials.provider.utils.ClearCredentialUtil;
import kotlin.jvm.internal.m;

@RequiresApi(34)
public abstract class CredentialProviderService extends android.service.credentials.CredentialProviderService {
    private boolean isTestMode;
    private ProviderClearCredentialStateRequest lastClearRequest;
    private BeginCreateCredentialRequest lastCreateRequest;
    private BeginGetCredentialRequest lastGetRequest;

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final ProviderClearCredentialStateRequest getLastClearRequest() {
        return this.lastClearRequest;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final BeginCreateCredentialRequest getLastCreateRequest() {
        return this.lastCreateRequest;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final BeginGetCredentialRequest getLastGetRequest() {
        return this.lastGetRequest;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean isTestMode() {
        return this.isTestMode;
    }

    public final void onBeginCreateCredential(BeginCreateCredentialRequest beginCreateCredentialRequest, CancellationSignal cancellationSignal, OutcomeReceiver outcomeReceiver) {
        m.f(beginCreateCredentialRequest, "request");
        m.f(cancellationSignal, "cancellationSignal");
        m.f(outcomeReceiver, "callback");
        CredentialProviderService$onBeginCreateCredential$outcome$1 credentialProviderService$onBeginCreateCredential$outcome$1 = new CredentialProviderService$onBeginCreateCredential$outcome$1(outcomeReceiver);
        BeginCreateCredentialRequest convertToJetpackRequest$credentials_release = BeginCreateCredentialUtil.Companion.convertToJetpackRequest$credentials_release(beginCreateCredentialRequest);
        if (this.isTestMode) {
            this.lastCreateRequest = convertToJetpackRequest$credentials_release;
        }
        onBeginCreateCredentialRequest(convertToJetpackRequest$credentials_release, cancellationSignal, o.a(credentialProviderService$onBeginCreateCredential$outcome$1));
    }

    public abstract void onBeginCreateCredentialRequest(BeginCreateCredentialRequest beginCreateCredentialRequest, CancellationSignal cancellationSignal, OutcomeReceiver outcomeReceiver);

    public final void onBeginGetCredential(BeginGetCredentialRequest beginGetCredentialRequest, CancellationSignal cancellationSignal, OutcomeReceiver outcomeReceiver) {
        m.f(beginGetCredentialRequest, "request");
        m.f(cancellationSignal, "cancellationSignal");
        m.f(outcomeReceiver, "callback");
        BeginGetCredentialRequest convertToJetpackRequest$credentials_release = BeginGetCredentialUtil.Companion.convertToJetpackRequest$credentials_release(beginGetCredentialRequest);
        CredentialProviderService$onBeginGetCredential$outcome$1 credentialProviderService$onBeginGetCredential$outcome$1 = new CredentialProviderService$onBeginGetCredential$outcome$1(outcomeReceiver);
        if (this.isTestMode) {
            this.lastGetRequest = convertToJetpackRequest$credentials_release;
        }
        onBeginGetCredentialRequest(convertToJetpackRequest$credentials_release, cancellationSignal, o.a(credentialProviderService$onBeginGetCredential$outcome$1));
    }

    public abstract void onBeginGetCredentialRequest(BeginGetCredentialRequest beginGetCredentialRequest, CancellationSignal cancellationSignal, OutcomeReceiver outcomeReceiver);

    public final void onClearCredentialState(ClearCredentialStateRequest clearCredentialStateRequest, CancellationSignal cancellationSignal, OutcomeReceiver outcomeReceiver) {
        m.f(clearCredentialStateRequest, "request");
        m.f(cancellationSignal, "cancellationSignal");
        m.f(outcomeReceiver, "callback");
        CredentialProviderService$onClearCredentialState$outcome$1 credentialProviderService$onClearCredentialState$outcome$1 = new CredentialProviderService$onClearCredentialState$outcome$1(outcomeReceiver);
        ProviderClearCredentialStateRequest convertToJetpackRequest$credentials_release = ClearCredentialUtil.Companion.convertToJetpackRequest$credentials_release(clearCredentialStateRequest);
        if (this.isTestMode) {
            this.lastClearRequest = convertToJetpackRequest$credentials_release;
        }
        onClearCredentialStateRequest(convertToJetpackRequest$credentials_release, cancellationSignal, o.a(credentialProviderService$onClearCredentialState$outcome$1));
    }

    public abstract void onClearCredentialStateRequest(ProviderClearCredentialStateRequest providerClearCredentialStateRequest, CancellationSignal cancellationSignal, OutcomeReceiver outcomeReceiver);

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setLastClearRequest(ProviderClearCredentialStateRequest providerClearCredentialStateRequest) {
        this.lastClearRequest = providerClearCredentialStateRequest;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setLastCreateRequest(BeginCreateCredentialRequest beginCreateCredentialRequest) {
        this.lastCreateRequest = beginCreateCredentialRequest;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setLastGetRequest(BeginGetCredentialRequest beginGetCredentialRequest) {
        this.lastGetRequest = beginGetCredentialRequest;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setTestMode(boolean z10) {
        this.isTestMode = z10;
    }
}
