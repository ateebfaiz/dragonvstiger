package androidx.credentials.playservices.controllers.BeginSignIn;

import androidx.credentials.GetCredentialResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderBeginSignInController$handleResponse$3 extends n implements Function0<Unit> {
    final /* synthetic */ GetCredentialResponse $response;
    final /* synthetic */ CredentialProviderBeginSignInController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderBeginSignInController$handleResponse$3(CredentialProviderBeginSignInController credentialProviderBeginSignInController, GetCredentialResponse getCredentialResponse) {
        super(0);
        this.this$0 = credentialProviderBeginSignInController;
        this.$response = getCredentialResponse;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderBeginSignInController credentialProviderBeginSignInController, GetCredentialResponse getCredentialResponse) {
        m.f(credentialProviderBeginSignInController, "this$0");
        m.f(getCredentialResponse, "$response");
        credentialProviderBeginSignInController.getCallback().onResult(getCredentialResponse);
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderBeginSignInController$handleResponse$3$$ExternalSyntheticLambda0(this.this$0, this.$response));
    }
}
