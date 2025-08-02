package androidx.credentials;

import androidx.credentials.exceptions.ClearCredentialException;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;
import kotlinx.coroutines.CancellableContinuation;

public final class CredentialManager$clearCredentialState$2$callback$1 implements CredentialManagerCallback<Void, ClearCredentialException> {
    final /* synthetic */ CancellableContinuation<Unit> $continuation;

    CredentialManager$clearCredentialState$2$callback$1(CancellableContinuation<? super Unit> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onError(ClearCredentialException clearCredentialException) {
        m.f(clearCredentialException, "e");
        if (this.$continuation.a()) {
            CancellableContinuation<Unit> cancellableContinuation = this.$continuation;
            o.a aVar = o.f12592b;
            cancellableContinuation.d(o.b(p.a(clearCredentialException)));
        }
    }

    public void onResult(Void voidR) {
        if (this.$continuation.a()) {
            CancellableContinuation<Unit> cancellableContinuation = this.$continuation;
            o.a aVar = o.f12592b;
            cancellableContinuation.d(o.b(Unit.f12577a));
        }
    }
}
