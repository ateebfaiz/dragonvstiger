package androidx.credentials;

import androidx.credentials.exceptions.GetCredentialException;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;
import kotlinx.coroutines.CancellableContinuation;

public final class CredentialManager$getCredential$4$callback$1 implements CredentialManagerCallback<GetCredentialResponse, GetCredentialException> {
    final /* synthetic */ CancellableContinuation<GetCredentialResponse> $continuation;

    CredentialManager$getCredential$4$callback$1(CancellableContinuation<? super GetCredentialResponse> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onError(GetCredentialException getCredentialException) {
        m.f(getCredentialException, "e");
        if (this.$continuation.a()) {
            CancellableContinuation<GetCredentialResponse> cancellableContinuation = this.$continuation;
            o.a aVar = o.f12592b;
            cancellableContinuation.d(o.b(p.a(getCredentialException)));
        }
    }

    public void onResult(GetCredentialResponse getCredentialResponse) {
        m.f(getCredentialResponse, DbParams.KEY_CHANNEL_RESULT);
        if (this.$continuation.a()) {
            this.$continuation.d(o.b(getCredentialResponse));
        }
    }
}
