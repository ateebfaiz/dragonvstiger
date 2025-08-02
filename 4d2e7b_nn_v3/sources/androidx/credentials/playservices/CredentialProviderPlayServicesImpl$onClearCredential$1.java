package androidx.credentials.playservices;

import android.os.CancellationSignal;
import android.util.Log;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class CredentialProviderPlayServicesImpl$onClearCredential$1 extends n implements Function1<Void, Unit> {
    final /* synthetic */ CredentialManagerCallback<Void, ClearCredentialException> $callback;
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ Executor $executor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CredentialProviderPlayServicesImpl$onClearCredential$1(CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<Void, ClearCredentialException> credentialManagerCallback) {
        super(1);
        this.$cancellationSignal = cancellationSignal;
        this.$executor = executor;
        this.$callback = credentialManagerCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Void) obj);
        return Unit.f12577a;
    }

    public final void invoke(Void voidR) {
        CredentialProviderPlayServicesImpl.Companion companion = CredentialProviderPlayServicesImpl.Companion;
        CancellationSignal cancellationSignal = this.$cancellationSignal;
        final Executor executor = this.$executor;
        final CredentialManagerCallback<Void, ClearCredentialException> credentialManagerCallback = this.$callback;
        companion.cancellationReviewerWithCallback$credentials_play_services_auth_release(cancellationSignal, new Function0<Unit>() {
            /* access modifiers changed from: private */
            public static final void invoke$lambda$0(CredentialManagerCallback credentialManagerCallback) {
                m.f(credentialManagerCallback, "$callback");
                credentialManagerCallback.onResult(null);
            }

            public final void invoke() {
                Log.i("PlayServicesImpl", "During clear credential, signed out successfully!");
                executor.execute(new CredentialProviderPlayServicesImpl$onClearCredential$1$1$$ExternalSyntheticLambda0(credentialManagerCallback));
            }
        });
    }
}
