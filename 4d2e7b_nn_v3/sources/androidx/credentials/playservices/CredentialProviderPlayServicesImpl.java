package androidx.credentials.playservices;

import android.content.Context;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.credentials.ClearCredentialStateRequest;
import androidx.credentials.CreateCredentialRequest;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CreatePasswordRequest;
import androidx.credentials.CreatePublicKeyCredentialRequest;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.CredentialOption;
import androidx.credentials.CredentialProvider;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.PrepareGetCredentialResponse;
import androidx.credentials.b;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.playservices.controllers.BeginSignIn.CredentialProviderBeginSignInController;
import androidx.credentials.playservices.controllers.CreatePassword.CredentialProviderCreatePasswordController;
import androidx.credentials.playservices.controllers.CreatePublicKeyCredential.CredentialProviderCreatePublicKeyCredentialController;
import androidx.credentials.playservices.controllers.GetSignInIntent.CredentialProviderGetSignInIntentController;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class CredentialProviderPlayServicesImpl implements CredentialProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int MIN_GMS_APK_VERSION = 230815045;
    private static final String TAG = "PlayServicesImpl";
    private final Context context;
    private GoogleApiAvailability googleApiAvailability;

    public static final class Companion {
        private Companion() {
        }

        public final boolean cancellationReviewer$credentials_play_services_auth_release(CancellationSignal cancellationSignal) {
            if (cancellationSignal == null) {
                Log.i(CredentialProviderPlayServicesImpl.TAG, "No cancellationSignal found");
                return false;
            } else if (!cancellationSignal.isCanceled()) {
                return false;
            } else {
                Log.i(CredentialProviderPlayServicesImpl.TAG, "the flow has been canceled");
                return true;
            }
        }

        public final void cancellationReviewerWithCallback$credentials_play_services_auth_release(CancellationSignal cancellationSignal, Function0<Unit> function0) {
            m.f(function0, "callback");
            if (!cancellationReviewer$credentials_play_services_auth_release(cancellationSignal)) {
                function0.invoke();
            }
        }

        public final boolean isGetSignInIntentRequest$credentials_play_services_auth_release(GetCredentialRequest getCredentialRequest) {
            m.f(getCredentialRequest, "request");
            for (CredentialOption credentialOption : getCredentialRequest.getCredentialOptions()) {
                if (credentialOption instanceof GetSignInWithGoogleOption) {
                    return true;
                }
            }
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CredentialProviderPlayServicesImpl(Context context2) {
        m.f(context2, "context");
        this.context = context2;
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        m.e(instance, "getInstance()");
        this.googleApiAvailability = instance;
    }

    @VisibleForTesting
    public static /* synthetic */ void getGoogleApiAvailability$annotations() {
    }

    private final int isGooglePlayServicesAvailable(Context context2) {
        return this.googleApiAvailability.isGooglePlayServicesAvailable(context2, MIN_GMS_APK_VERSION);
    }

    /* access modifiers changed from: private */
    public static final void onClearCredential$lambda$0(Function1 function1, Object obj) {
        m.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void onClearCredential$lambda$2(CredentialProviderPlayServicesImpl credentialProviderPlayServicesImpl, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback, Exception exc) {
        m.f(credentialProviderPlayServicesImpl, "this$0");
        m.f(executor, "$executor");
        m.f(credentialManagerCallback, "$callback");
        m.f(exc, "e");
        Companion.cancellationReviewerWithCallback$credentials_play_services_auth_release(cancellationSignal, new CredentialProviderPlayServicesImpl$onClearCredential$2$1$1(exc, executor, credentialManagerCallback));
    }

    public final GoogleApiAvailability getGoogleApiAvailability() {
        return this.googleApiAvailability;
    }

    public boolean isAvailableOnDevice() {
        boolean z10;
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(this.context);
        if (isGooglePlayServicesAvailable == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            ConnectionResult connectionResult = new ConnectionResult(isGooglePlayServicesAvailable);
            Log.w(TAG, "Connection with Google Play Services was not successful. Connection result is: " + connectionResult);
        }
        return z10;
    }

    public void onClearCredential(ClearCredentialStateRequest clearCredentialStateRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<Void, ClearCredentialException> credentialManagerCallback) {
        m.f(clearCredentialStateRequest, "request");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        if (!Companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal)) {
            Identity.getSignInClient(this.context).signOut().addOnSuccessListener(new CredentialProviderPlayServicesImpl$$ExternalSyntheticLambda0(new CredentialProviderPlayServicesImpl$onClearCredential$1(cancellationSignal, executor, credentialManagerCallback))).addOnFailureListener(new CredentialProviderPlayServicesImpl$$ExternalSyntheticLambda1(this, cancellationSignal, executor, credentialManagerCallback));
        }
    }

    public void onCreateCredential(Context context2, CreateCredentialRequest createCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> credentialManagerCallback) {
        m.f(context2, "context");
        m.f(createCredentialRequest, "request");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        if (!Companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal)) {
            if (createCredentialRequest instanceof CreatePasswordRequest) {
                CredentialProviderCreatePasswordController.Companion.getInstance(context2).invokePlayServices((CreatePasswordRequest) createCredentialRequest, credentialManagerCallback, executor, cancellationSignal);
            } else if (createCredentialRequest instanceof CreatePublicKeyCredentialRequest) {
                CredentialProviderCreatePublicKeyCredentialController.Companion.getInstance(context2).invokePlayServices((CreatePublicKeyCredentialRequest) createCredentialRequest, credentialManagerCallback, executor, cancellationSignal);
            } else {
                throw new UnsupportedOperationException("Create Credential request is unsupported, not password or publickeycredential");
            }
        }
    }

    public /* synthetic */ void onGetCredential(Context context2, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback) {
        b.a(this, context2, pendingGetCredentialHandle, cancellationSignal, executor, credentialManagerCallback);
    }

    public /* synthetic */ void onPrepareCredential(GetCredentialRequest getCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback) {
        b.b(this, getCredentialRequest, cancellationSignal, executor, credentialManagerCallback);
    }

    public final void setGoogleApiAvailability(GoogleApiAvailability googleApiAvailability2) {
        m.f(googleApiAvailability2, "<set-?>");
        this.googleApiAvailability = googleApiAvailability2;
    }

    public void onGetCredential(Context context2, GetCredentialRequest getCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> credentialManagerCallback) {
        m.f(context2, "context");
        m.f(getCredentialRequest, "request");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        Companion companion = Companion;
        if (!companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal)) {
            if (companion.isGetSignInIntentRequest$credentials_play_services_auth_release(getCredentialRequest)) {
                new CredentialProviderGetSignInIntentController(context2).invokePlayServices(getCredentialRequest, credentialManagerCallback, executor, cancellationSignal);
            } else {
                new CredentialProviderBeginSignInController(context2).invokePlayServices(getCredentialRequest, credentialManagerCallback, executor, cancellationSignal);
            }
        }
    }
}
