package androidx.credentials;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.annotation.RequiresApi;
import androidx.credentials.CredentialManager;
import androidx.credentials.PrepareGetCredentialResponse;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.ClearCredentialProviderConfigurationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialProviderConfigurationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialProviderConfigurationException;
import java.util.concurrent.Executor;
import kotlin.coroutines.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@RequiresApi(16)
@SuppressLint({"ObsoleteSdkInt"})
public final class CredentialManagerImpl implements CredentialManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String INTENT_ACTION_FOR_CREDENTIAL_PROVIDER_SETTINGS = "android.settings.CREDENTIAL_PROVIDER";
    private final Context context;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CredentialManagerImpl(Context context2) {
        m.f(context2, "context");
        this.context = context2;
    }

    public /* synthetic */ Object clearCredentialState(ClearCredentialStateRequest clearCredentialStateRequest, d dVar) {
        return CredentialManager.CC.a(this, clearCredentialStateRequest, dVar);
    }

    public void clearCredentialStateAsync(ClearCredentialStateRequest clearCredentialStateRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<Void, ClearCredentialException> credentialManagerCallback) {
        m.f(clearCredentialStateRequest, "request");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        CredentialProvider bestAvailableProvider = CredentialProviderFactory.Companion.getBestAvailableProvider(this.context);
        if (bestAvailableProvider == null) {
            credentialManagerCallback.onError(new ClearCredentialProviderConfigurationException("clearCredentialStateAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        } else {
            bestAvailableProvider.onClearCredential(clearCredentialStateRequest, cancellationSignal, executor, credentialManagerCallback);
        }
    }

    public /* synthetic */ Object createCredential(Context context2, CreateCredentialRequest createCredentialRequest, d dVar) {
        return CredentialManager.CC.b(this, context2, createCredentialRequest, dVar);
    }

    public void createCredentialAsync(Context context2, CreateCredentialRequest createCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> credentialManagerCallback) {
        m.f(context2, "context");
        m.f(createCredentialRequest, "request");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        CredentialProvider bestAvailableProvider = CredentialProviderFactory.Companion.getBestAvailableProvider(this.context);
        if (bestAvailableProvider == null) {
            credentialManagerCallback.onError(new CreateCredentialProviderConfigurationException("createCredentialAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        } else {
            bestAvailableProvider.onCreateCredential(context2, createCredentialRequest, cancellationSignal, executor, credentialManagerCallback);
        }
    }

    @RequiresApi(34)
    public PendingIntent createSettingsPendingIntent() {
        Intent intent = new Intent(INTENT_ACTION_FOR_CREDENTIAL_PROVIDER_SETTINGS);
        intent.setData(Uri.parse("package:" + this.context.getPackageName()));
        PendingIntent activity = PendingIntent.getActivity(this.context, 0, intent, 67108864);
        m.e(activity, "getActivity(context, 0, …ingIntent.FLAG_IMMUTABLE)");
        return activity;
    }

    public /* synthetic */ Object getCredential(Context context2, GetCredentialRequest getCredentialRequest, d dVar) {
        return CredentialManager.CC.c(this, context2, getCredentialRequest, dVar);
    }

    public void getCredentialAsync(Context context2, GetCredentialRequest getCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> credentialManagerCallback) {
        m.f(context2, "context");
        m.f(getCredentialRequest, "request");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        CredentialProvider bestAvailableProvider = CredentialProviderFactory.Companion.getBestAvailableProvider(this.context);
        if (bestAvailableProvider == null) {
            credentialManagerCallback.onError(new GetCredentialProviderConfigurationException("getCredentialAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        } else {
            bestAvailableProvider.onGetCredential(context2, getCredentialRequest, cancellationSignal, executor, credentialManagerCallback);
        }
    }

    public /* synthetic */ Object prepareGetCredential(GetCredentialRequest getCredentialRequest, d dVar) {
        return CredentialManager.CC.e(this, getCredentialRequest, dVar);
    }

    @RequiresApi(34)
    public void prepareGetCredentialAsync(GetCredentialRequest getCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<PrepareGetCredentialResponse, GetCredentialException> credentialManagerCallback) {
        m.f(getCredentialRequest, "request");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        CredentialProviderFactory.Companion.getUAndAboveProvider(this.context).onPrepareCredential(getCredentialRequest, cancellationSignal, executor, credentialManagerCallback);
    }

    public /* synthetic */ Object getCredential(Context context2, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, d dVar) {
        return CredentialManager.CC.d(this, context2, pendingGetCredentialHandle, dVar);
    }

    @RequiresApi(34)
    public void getCredentialAsync(Context context2, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> credentialManagerCallback) {
        m.f(context2, "context");
        m.f(pendingGetCredentialHandle, "pendingGetCredentialHandle");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        CredentialProviderFactory.Companion.getUAndAboveProvider(context2).onGetCredential(context2, pendingGetCredentialHandle, cancellationSignal, executor, credentialManagerCallback);
    }
}
