package androidx.credentials.playservices.controllers;

import androidx.credentials.CredentialManagerCallback;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderController$maybeReportErrorFromResultReceiver$1 extends n implements Function0<Unit> {
    final /* synthetic */ CredentialManagerCallback<R1, E1> $callback;
    final /* synthetic */ E1 $exception;
    final /* synthetic */ Executor $executor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderController$maybeReportErrorFromResultReceiver$1(Executor executor, CredentialManagerCallback<R1, E1> credentialManagerCallback, E1 e12) {
        super(0);
        this.$executor = executor;
        this.$callback = credentialManagerCallback;
        this.$exception = e12;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialManagerCallback credentialManagerCallback, Object obj) {
        m.f(credentialManagerCallback, "$callback");
        m.f(obj, "$exception");
        credentialManagerCallback.onError(obj);
    }

    public final void invoke() {
        this.$executor.execute(new CredentialProviderController$maybeReportErrorFromResultReceiver$1$$ExternalSyntheticLambda0(this.$callback, this.$exception));
    }
}
