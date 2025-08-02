package androidx.credentials.playservices.controllers.BeginSignIn;

import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderBeginSignInController$invokePlayServices$1 extends n implements Function0<Unit> {
    final /* synthetic */ CredentialProviderBeginSignInController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderBeginSignInController$invokePlayServices$1(CredentialProviderBeginSignInController credentialProviderBeginSignInController) {
        super(0);
        this.this$0 = credentialProviderBeginSignInController;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderBeginSignInController credentialProviderBeginSignInController) {
        m.f(credentialProviderBeginSignInController, "this$0");
        credentialProviderBeginSignInController.getCallback().onError(new GetCredentialUnknownException(CredentialProviderController.ERROR_MESSAGE_START_ACTIVITY_FAILED));
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderBeginSignInController$invokePlayServices$1$$ExternalSyntheticLambda0(this.this$0));
    }
}
