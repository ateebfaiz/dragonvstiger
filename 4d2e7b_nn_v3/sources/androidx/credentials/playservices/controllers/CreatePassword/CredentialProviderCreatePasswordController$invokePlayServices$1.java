package androidx.credentials.playservices.controllers.CreatePassword;

import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderCreatePasswordController$invokePlayServices$1 extends n implements Function0<Unit> {
    final /* synthetic */ CredentialProviderCreatePasswordController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderCreatePasswordController$invokePlayServices$1(CredentialProviderCreatePasswordController credentialProviderCreatePasswordController) {
        super(0);
        this.this$0 = credentialProviderCreatePasswordController;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderCreatePasswordController credentialProviderCreatePasswordController) {
        m.f(credentialProviderCreatePasswordController, "this$0");
        CredentialManagerCallback access$getCallback$p = credentialProviderCreatePasswordController.callback;
        if (access$getCallback$p == null) {
            m.u("callback");
            access$getCallback$p = null;
        }
        access$getCallback$p.onError(new CreateCredentialUnknownException(CredentialProviderController.ERROR_MESSAGE_START_ACTIVITY_FAILED));
    }

    public final void invoke() {
        Executor access$getExecutor$p = this.this$0.executor;
        if (access$getExecutor$p == null) {
            m.u("executor");
            access$getExecutor$p = null;
        }
        access$getExecutor$p.execute(new CredentialProviderCreatePasswordController$invokePlayServices$1$$ExternalSyntheticLambda0(this.this$0));
    }
}
