package androidx.credentials;

import androidx.credentials.exceptions.GetCredentialException;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;
import kotlinx.coroutines.CancellableContinuation;

public final class CredentialManager$prepareGetCredential$2$callback$1 implements CredentialManagerCallback<PrepareGetCredentialResponse, GetCredentialException> {
    final /* synthetic */ CancellableContinuation<PrepareGetCredentialResponse> $continuation;

    CredentialManager$prepareGetCredential$2$callback$1(CancellableContinuation<? super PrepareGetCredentialResponse> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onError(GetCredentialException getCredentialException) {
        m.f(getCredentialException, "e");
        if (this.$continuation.a()) {
            CancellableContinuation<PrepareGetCredentialResponse> cancellableContinuation = this.$continuation;
            o.a aVar = o.f12592b;
            cancellableContinuation.d(o.b(p.a(getCredentialException)));
        }
    }

    public void onResult(PrepareGetCredentialResponse prepareGetCredentialResponse) {
        m.f(prepareGetCredentialResponse, DbParams.KEY_CHANNEL_RESULT);
        if (this.$continuation.a()) {
            this.$continuation.d(o.b(prepareGetCredentialResponse));
        }
    }
}
