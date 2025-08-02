package androidx.credentials.playservices;

import android.util.Log;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.ClearCredentialUnknownException;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderPlayServicesImpl$onClearCredential$2$1$1 extends n implements Function0<Unit> {
    final /* synthetic */ CredentialManagerCallback<Void, ClearCredentialException> $callback;
    final /* synthetic */ Exception $e;
    final /* synthetic */ Executor $executor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderPlayServicesImpl$onClearCredential$2$1$1(Exception exc, Executor executor, CredentialManagerCallback<Void, ClearCredentialException> credentialManagerCallback) {
        super(0);
        this.$e = exc;
        this.$executor = executor;
        this.$callback = credentialManagerCallback;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialManagerCallback credentialManagerCallback, Exception exc) {
        m.f(credentialManagerCallback, "$callback");
        m.f(exc, "$e");
        credentialManagerCallback.onError(new ClearCredentialUnknownException(exc.getMessage()));
    }

    public final void invoke() {
        Log.w("PlayServicesImpl", "During clear credential sign out failed with " + this.$e);
        this.$executor.execute(new CredentialProviderPlayServicesImpl$onClearCredential$2$1$1$$ExternalSyntheticLambda0(this.$callback, this.$e));
    }
}
