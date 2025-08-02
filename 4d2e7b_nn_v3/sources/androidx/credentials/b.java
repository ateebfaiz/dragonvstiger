package androidx.credentials;

import android.content.Context;
import android.os.CancellationSignal;
import androidx.credentials.PrepareGetCredentialResponse;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.m;

public abstract /* synthetic */ class b {
    public static void a(CredentialProvider credentialProvider, Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback) {
        m.f(context, "context");
        m.f(pendingGetCredentialHandle, "pendingGetCredentialHandle");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
    }

    public static void b(CredentialProvider credentialProvider, GetCredentialRequest getCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback) {
        m.f(getCredentialRequest, "request");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
    }
}
