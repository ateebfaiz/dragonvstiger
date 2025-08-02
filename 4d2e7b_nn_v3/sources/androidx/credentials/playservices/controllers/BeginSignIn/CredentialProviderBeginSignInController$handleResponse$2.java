package androidx.credentials.playservices.controllers.BeginSignIn;

import androidx.credentials.exceptions.GetCredentialException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderBeginSignInController$handleResponse$2 extends n implements Function1<GetCredentialException, Unit> {
    final /* synthetic */ CredentialProviderBeginSignInController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderBeginSignInController$handleResponse$2(CredentialProviderBeginSignInController credentialProviderBeginSignInController) {
        super(1);
        this.this$0 = credentialProviderBeginSignInController;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderBeginSignInController credentialProviderBeginSignInController, GetCredentialException getCredentialException) {
        m.f(credentialProviderBeginSignInController, "this$0");
        m.f(getCredentialException, "$e");
        credentialProviderBeginSignInController.getCallback().onError(getCredentialException);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GetCredentialException) obj);
        return Unit.f12577a;
    }

    public final void invoke(GetCredentialException getCredentialException) {
        m.f(getCredentialException, "e");
        this.this$0.getExecutor().execute(new CredentialProviderBeginSignInController$handleResponse$2$$ExternalSyntheticLambda0(this.this$0, getCredentialException));
    }
}
