package androidx.credentials.playservices.controllers.GetSignInIntent;

import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderGetSignInIntentController$invokePlayServices$2 extends n implements Function0<Unit> {
    final /* synthetic */ CredentialProviderGetSignInIntentController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderGetSignInIntentController$invokePlayServices$2(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController) {
        super(0);
        this.this$0 = credentialProviderGetSignInIntentController;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderGetSignInIntentController credentialProviderGetSignInIntentController) {
        m.f(credentialProviderGetSignInIntentController, "this$0");
        credentialProviderGetSignInIntentController.getCallback().onError(new GetCredentialUnknownException(CredentialProviderController.ERROR_MESSAGE_START_ACTIVITY_FAILED));
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderGetSignInIntentController$invokePlayServices$2$$ExternalSyntheticLambda0(this.this$0));
    }
}
