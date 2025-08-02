package androidx.credentials;

import android.annotation.SuppressLint;
import android.content.Context;
import android.credentials.ClearCredentialStateRequest;
import android.credentials.CreateCredentialRequest;
import android.credentials.Credential;
import android.credentials.CredentialManager;
import android.credentials.GetCredentialRequest;
import android.credentials.GetCredentialResponse;
import android.credentials.PrepareGetCredentialResponse;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.os.o;
import androidx.credentials.Credential;
import androidx.credentials.PrepareGetCredentialResponse;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.ClearCredentialUnsupportedException;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialCustomException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialInterruptedException;
import androidx.credentials.exceptions.CreateCredentialNoCreateOptionException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.CreateCredentialUnsupportedException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialCustomException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialInterruptedException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialUnsupportedException;
import androidx.credentials.exceptions.NoCredentialException;
import androidx.credentials.exceptions.publickeycredential.CreatePublicKeyCredentialException;
import androidx.credentials.exceptions.publickeycredential.GetPublicKeyCredentialException;
import androidx.credentials.internal.FrameworkImplHelper;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.text.j;

@RequiresApi(34)
public final class CredentialProviderFrameworkImpl implements CredentialProvider {
    private static final String CREATE_DOM_EXCEPTION_PREFIX = "androidx.credentials.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION";
    private static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String GET_DOM_EXCEPTION_PREFIX = "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION";
    private static final String TAG = "CredManProvService";
    private final CredentialManager credentialManager;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CredentialManagerCallback f15313a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(CredentialManagerCallback credentialManagerCallback) {
            super(0);
            this.f15313a = credentialManagerCallback;
        }

        public final void invoke() {
            this.f15313a.onError(new ClearCredentialUnsupportedException("Your device doesn't support credential manager"));
        }
    }

    static final class c extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CredentialManagerCallback f15314a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(CredentialManagerCallback credentialManagerCallback) {
            super(0);
            this.f15314a = credentialManagerCallback;
        }

        public final void invoke() {
            this.f15314a.onError(new CreateCredentialUnsupportedException("Your device doesn't support credential manager"));
        }
    }

    static final class d extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CredentialManagerCallback f15315a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(CredentialManagerCallback credentialManagerCallback) {
            super(0);
            this.f15315a = credentialManagerCallback;
        }

        public final void invoke() {
            this.f15315a.onError(new GetCredentialUnsupportedException("Your device doesn't support credential manager"));
        }
    }

    static final class e extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CredentialManagerCallback f15316a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(CredentialManagerCallback credentialManagerCallback) {
            super(0);
            this.f15316a = credentialManagerCallback;
        }

        public final void invoke() {
            this.f15316a.onError(new GetCredentialUnsupportedException("Your device doesn't support credential manager"));
        }
    }

    static final class f extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CredentialManagerCallback f15317a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(CredentialManagerCallback credentialManagerCallback) {
            super(0);
            this.f15317a = credentialManagerCallback;
        }

        public final void invoke() {
            this.f15317a.onError(new GetCredentialUnsupportedException("Your device doesn't support credential manager"));
        }
    }

    public CredentialProviderFrameworkImpl(Context context) {
        m.f(context, "context");
        this.credentialManager = l.a(context.getSystemService("credential"));
    }

    private final CreateCredentialRequest convertCreateRequestToFrameworkClass(CreateCredentialRequest createCredentialRequest, Context context) {
        b0.a();
        CreateCredentialRequest.Builder a10 = a0.a(createCredentialRequest.getType(), FrameworkImplHelper.Companion.getFinalCreateCredentialData(createCredentialRequest, context), createCredentialRequest.getCandidateQueryData()).setIsSystemProviderRequired(createCredentialRequest.isSystemProviderRequired()).setAlwaysSendAppInfoToProvider(true);
        m.e(a10, "Builder(request.type,\n  …ndAppInfoToProvider(true)");
        setOriginForCreateRequest(createCredentialRequest, a10);
        CreateCredentialRequest a11 = a10.build();
        m.e(a11, "createCredentialRequestBuilder.build()");
        return a11;
    }

    private final GetCredentialRequest convertGetRequestToFrameworkClass(GetCredentialRequest getCredentialRequest) {
        x.a();
        GetCredentialRequest.Builder a10 = v.a(GetCredentialRequest.Companion.toRequestDataBundle(getCredentialRequest));
        for (CredentialOption credentialOption : getCredentialRequest.getCredentialOptions()) {
            y.a();
            GetCredentialRequest.Builder unused = a10.addCredentialOption(w.a(credentialOption.getType(), credentialOption.getRequestData(), credentialOption.getCandidateQueryData()).setIsSystemProviderRequired(credentialOption.isSystemProviderRequired()).setAllowedProviders(credentialOption.getAllowedProviders()).build());
        }
        setOriginForGetRequest(getCredentialRequest, a10);
        GetCredentialRequest a11 = a10.build();
        m.e(a11, "builder.build()");
        return a11;
    }

    private final ClearCredentialStateRequest createFrameworkClearCredentialRequest() {
        u.a();
        return t.a(new Bundle());
    }

    private final boolean isCredmanDisabled(Function0<Unit> function0) {
        if (this.credentialManager != null) {
            return false;
        }
        function0.invoke();
        return true;
    }

    @SuppressLint({"MissingPermission"})
    private final void setOriginForCreateRequest(CreateCredentialRequest createCredentialRequest, CreateCredentialRequest.Builder builder) {
        if (createCredentialRequest.getOrigin() != null) {
            CreateCredentialRequest.Builder unused = builder.setOrigin(createCredentialRequest.getOrigin());
        }
    }

    @SuppressLint({"MissingPermission"})
    private final void setOriginForGetRequest(GetCredentialRequest getCredentialRequest, GetCredentialRequest.Builder builder) {
        if (getCredentialRequest.getOrigin() != null) {
            GetCredentialRequest.Builder unused = builder.setOrigin(getCredentialRequest.getOrigin());
        }
    }

    public final GetCredentialResponse convertGetResponseToJetpackClass$credentials_release(GetCredentialResponse getCredentialResponse) {
        m.f(getCredentialResponse, "response");
        Credential a10 = getCredentialResponse.getCredential();
        m.e(a10, "response.credential");
        Credential.Companion companion = Credential.Companion;
        String a11 = a10.getType();
        m.e(a11, "credential.type");
        Bundle a12 = a10.getData();
        m.e(a12, "credential.data");
        return new GetCredentialResponse(companion.createFrom(a11, a12));
    }

    public final PrepareGetCredentialResponse convertPrepareGetResponseToJetpackClass$credentials_release(PrepareGetCredentialResponse prepareGetCredentialResponse) {
        m.f(prepareGetCredentialResponse, "response");
        return new PrepareGetCredentialResponse.Builder().setFrameworkResponse(prepareGetCredentialResponse).setPendingGetCredentialHandle(new PrepareGetCredentialResponse.PendingGetCredentialHandle(prepareGetCredentialResponse.getPendingGetCredentialHandle())).build();
    }

    public final CreateCredentialException convertToJetpackCreateException$credentials_release(android.credentials.CreateCredentialException createCredentialException) {
        m.f(createCredentialException, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        String a10 = createCredentialException.getType();
        switch (a10.hashCode()) {
            case -2055374133:
                if (a10.equals(CreateCredentialCancellationException.TYPE_CREATE_CREDENTIAL_CANCELLATION_EXCEPTION)) {
                    return new CreateCredentialCancellationException(createCredentialException.getMessage());
                }
                break;
            case 1316905704:
                if (a10.equals(CreateCredentialUnknownException.TYPE_CREATE_CREDENTIAL_UNKNOWN_EXCEPTION)) {
                    return new CreateCredentialUnknownException(createCredentialException.getMessage());
                }
                break;
            case 2092588512:
                if (a10.equals(CreateCredentialInterruptedException.TYPE_CREATE_CREDENTIAL_INTERRUPTED_EXCEPTION)) {
                    return new CreateCredentialInterruptedException(createCredentialException.getMessage());
                }
                break;
            case 2131915191:
                if (a10.equals(CreateCredentialNoCreateOptionException.TYPE_CREATE_CREDENTIAL_NO_CREATE_OPTION)) {
                    return new CreateCredentialNoCreateOptionException(createCredentialException.getMessage());
                }
                break;
        }
        String a11 = createCredentialException.getType();
        m.e(a11, "error.type");
        if (j.F(a11, "androidx.credentials.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION", false, 2, (Object) null)) {
            CreatePublicKeyCredentialException.Companion companion = CreatePublicKeyCredentialException.Companion;
            String a12 = createCredentialException.getType();
            m.e(a12, "error.type");
            return companion.createFrom(a12, createCredentialException.getMessage());
        }
        String a13 = createCredentialException.getType();
        m.e(a13, "error.type");
        return new CreateCredentialCustomException(a13, createCredentialException.getMessage());
    }

    public final GetCredentialException convertToJetpackGetException$credentials_release(android.credentials.GetCredentialException getCredentialException) {
        m.f(getCredentialException, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        String a10 = getCredentialException.getType();
        switch (a10.hashCode()) {
            case -781118336:
                if (a10.equals(GetCredentialUnknownException.TYPE_GET_CREDENTIAL_UNKNOWN_EXCEPTION)) {
                    return new GetCredentialUnknownException(getCredentialException.getMessage());
                }
                break;
            case -45448328:
                if (a10.equals(GetCredentialInterruptedException.TYPE_GET_CREDENTIAL_INTERRUPTED_EXCEPTION)) {
                    return new GetCredentialInterruptedException(getCredentialException.getMessage());
                }
                break;
            case 580557411:
                if (a10.equals(GetCredentialCancellationException.TYPE_GET_CREDENTIAL_CANCELLATION_EXCEPTION)) {
                    return new GetCredentialCancellationException(getCredentialException.getMessage());
                }
                break;
            case 627896683:
                if (a10.equals(NoCredentialException.TYPE_FRAMEWORK_TYPE_NO_CREDENTIAL)) {
                    return new NoCredentialException(getCredentialException.getMessage());
                }
                break;
        }
        String a11 = getCredentialException.getType();
        m.e(a11, "error.type");
        if (j.F(a11, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION", false, 2, (Object) null)) {
            GetPublicKeyCredentialException.Companion companion = GetPublicKeyCredentialException.Companion;
            String a12 = getCredentialException.getType();
            m.e(a12, "error.type");
            return companion.createFrom(a12, getCredentialException.getMessage());
        }
        String a13 = getCredentialException.getType();
        m.e(a13, "error.type");
        return new GetCredentialCustomException(a13, getCredentialException.getMessage());
    }

    public boolean isAvailableOnDevice() {
        if (Build.VERSION.SDK_INT >= 34) {
            return true;
        }
        return false;
    }

    public void onClearCredential(ClearCredentialStateRequest clearCredentialStateRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<Void, ClearCredentialException> credentialManagerCallback) {
        m.f(clearCredentialStateRequest, "request");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        Log.i(TAG, "In CredentialProviderFrameworkImpl onClearCredential");
        if (!isCredmanDisabled(new b(credentialManagerCallback))) {
            CredentialProviderFrameworkImpl$onClearCredential$outcome$1 credentialProviderFrameworkImpl$onClearCredential$outcome$1 = new CredentialProviderFrameworkImpl$onClearCredential$outcome$1(credentialManagerCallback);
            CredentialManager credentialManager2 = this.credentialManager;
            m.c(credentialManager2);
            credentialManager2.clearCredentialState(createFrameworkClearCredentialRequest(), cancellationSignal, executor, o.a(credentialProviderFrameworkImpl$onClearCredential$outcome$1));
        }
    }

    public void onCreateCredential(Context context, CreateCredentialRequest createCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> credentialManagerCallback) {
        m.f(context, "context");
        m.f(createCredentialRequest, "request");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        if (!isCredmanDisabled(new c(credentialManagerCallback))) {
            CredentialProviderFrameworkImpl$onCreateCredential$outcome$1 credentialProviderFrameworkImpl$onCreateCredential$outcome$1 = new CredentialProviderFrameworkImpl$onCreateCredential$outcome$1(credentialManagerCallback, createCredentialRequest, this);
            CredentialManager credentialManager2 = this.credentialManager;
            m.c(credentialManager2);
            credentialManager2.createCredential(context, convertCreateRequestToFrameworkClass(createCredentialRequest, context), cancellationSignal, executor, o.a(credentialProviderFrameworkImpl$onCreateCredential$outcome$1));
        }
    }

    public void onGetCredential(Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> credentialManagerCallback) {
        m.f(context, "context");
        m.f(pendingGetCredentialHandle, "pendingGetCredentialHandle");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        if (!isCredmanDisabled(new d(credentialManagerCallback))) {
            CredentialProviderFrameworkImpl$onGetCredential$outcome$1 credentialProviderFrameworkImpl$onGetCredential$outcome$1 = new CredentialProviderFrameworkImpl$onGetCredential$outcome$1(credentialManagerCallback, this);
            CredentialManager credentialManager2 = this.credentialManager;
            m.c(credentialManager2);
            PrepareGetCredentialResponse.PendingGetCredentialHandle frameworkHandle = pendingGetCredentialHandle.getFrameworkHandle();
            m.c(frameworkHandle);
            credentialManager2.getCredential(context, frameworkHandle, cancellationSignal, executor, o.a(credentialProviderFrameworkImpl$onGetCredential$outcome$1));
        }
    }

    public void onPrepareCredential(GetCredentialRequest getCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<PrepareGetCredentialResponse, GetCredentialException> credentialManagerCallback) {
        m.f(getCredentialRequest, "request");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        if (!isCredmanDisabled(new f(credentialManagerCallback))) {
            CredentialProviderFrameworkImpl$onPrepareCredential$outcome$1 credentialProviderFrameworkImpl$onPrepareCredential$outcome$1 = new CredentialProviderFrameworkImpl$onPrepareCredential$outcome$1(credentialManagerCallback, this);
            CredentialManager credentialManager2 = this.credentialManager;
            m.c(credentialManager2);
            credentialManager2.prepareGetCredential(convertGetRequestToFrameworkClass(getCredentialRequest), cancellationSignal, executor, o.a(credentialProviderFrameworkImpl$onPrepareCredential$outcome$1));
        }
    }

    public void onGetCredential(Context context, GetCredentialRequest getCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> credentialManagerCallback) {
        m.f(context, "context");
        m.f(getCredentialRequest, "request");
        m.f(executor, "executor");
        m.f(credentialManagerCallback, "callback");
        if (!isCredmanDisabled(new e(credentialManagerCallback))) {
            CredentialProviderFrameworkImpl$onGetCredential$outcome$2 credentialProviderFrameworkImpl$onGetCredential$outcome$2 = new CredentialProviderFrameworkImpl$onGetCredential$outcome$2(credentialManagerCallback, this);
            CredentialManager credentialManager2 = this.credentialManager;
            m.c(credentialManager2);
            credentialManager2.getCredential(context, convertGetRequestToFrameworkClass(getCredentialRequest), cancellationSignal, executor, o.a(credentialProviderFrameworkImpl$onGetCredential$outcome$2));
        }
    }
}
