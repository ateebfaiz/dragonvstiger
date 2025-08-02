package androidx.credentials;

import androidx.credentials.exceptions.CreateCredentialException;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;
import kotlinx.coroutines.CancellableContinuation;

public final class CredentialManager$createCredential$2$callback$1 implements CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> {
    final /* synthetic */ CancellableContinuation<CreateCredentialResponse> $continuation;

    CredentialManager$createCredential$2$callback$1(CancellableContinuation<? super CreateCredentialResponse> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onError(CreateCredentialException createCredentialException) {
        m.f(createCredentialException, "e");
        if (this.$continuation.a()) {
            CancellableContinuation<CreateCredentialResponse> cancellableContinuation = this.$continuation;
            o.a aVar = o.f12592b;
            cancellableContinuation.d(o.b(p.a(createCredentialException)));
        }
    }

    public void onResult(CreateCredentialResponse createCredentialResponse) {
        m.f(createCredentialResponse, DbParams.KEY_CHANNEL_RESULT);
        if (this.$continuation.a()) {
            this.$continuation.d(o.b(createCredentialResponse));
        }
    }
}
