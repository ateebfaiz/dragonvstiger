package androidx.credentials.playservices.controllers.GetSignInIntent;

import androidx.credentials.GetCredentialResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderGetSignInIntentController$handleResponse$3 extends n implements Function0<Unit> {
    final /* synthetic */ GetCredentialResponse $response;
    final /* synthetic */ CredentialProviderGetSignInIntentController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderGetSignInIntentController$handleResponse$3(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController, GetCredentialResponse getCredentialResponse) {
        super(0);
        this.this$0 = credentialProviderGetSignInIntentController;
        this.$response = getCredentialResponse;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController, GetCredentialResponse getCredentialResponse) {
        m.f(credentialProviderGetSignInIntentController, "this$0");
        m.f(getCredentialResponse, "$response");
        credentialProviderGetSignInIntentController.getCallback().onResult(getCredentialResponse);
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderGetSignInIntentController$handleResponse$3$$ExternalSyntheticLambda0(this.this$0, this.$response));
    }
}
