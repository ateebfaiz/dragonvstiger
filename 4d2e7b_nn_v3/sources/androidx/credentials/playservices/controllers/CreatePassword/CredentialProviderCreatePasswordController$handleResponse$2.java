package androidx.credentials.playservices.controllers.CreatePassword;

import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.CreateCredentialException;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderCreatePasswordController$handleResponse$2 extends n implements Function1<CreateCredentialException, Unit> {
    final /* synthetic */ CredentialProviderCreatePasswordController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderCreatePasswordController$handleResponse$2(CredentialProviderCreatePasswordController credentialProviderCreatePasswordController) {
        super(1);
        this.this$0 = credentialProviderCreatePasswordController;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderCreatePasswordController credentialProviderCreatePasswordController, CreateCredentialException createCredentialException) {
        m.f(credentialProviderCreatePasswordController, "this$0");
        m.f(createCredentialException, "$e");
        CredentialManagerCallback access$getCallback$p = credentialProviderCreatePasswordController.callback;
        if (access$getCallback$p == null) {
            m.u("callback");
            access$getCallback$p = null;
        }
        access$getCallback$p.onError(createCredentialException);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CreateCredentialException) obj);
        return Unit.f12577a;
    }

    public final void invoke(CreateCredentialException createCredentialException) {
        m.f(createCredentialException, "e");
        Executor access$getExecutor$p = this.this$0.executor;
        if (access$getExecutor$p == null) {
            m.u("executor");
            access$getExecutor$p = null;
        }
        access$getExecutor$p.execute(new CredentialProviderCreatePasswordController$handleResponse$2$$ExternalSyntheticLambda0(this.this$0, createCredentialException));
    }
}
