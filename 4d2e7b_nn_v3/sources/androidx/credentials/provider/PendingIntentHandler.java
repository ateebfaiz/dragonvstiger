package androidx.credentials.provider;

import android.content.Intent;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.service.credentials.BeginGetCredentialRequest;
import android.service.credentials.GetCredentialRequest;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.credentials.CreateCredentialRequest;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CredentialOption;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.provider.ProviderGetCredentialRequest;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

@RequiresApi(34)
public final class PendingIntentHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "PendingIntentHandler";

    public static final class Companion {

        static final class a extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final a f15329a = new a();

            a() {
                super(1);
            }

            public final CredentialOption a(android.credentials.CredentialOption credentialOption) {
                CredentialOption.Companion companion = CredentialOption.Companion;
                String a10 = t0.a(credentialOption);
                m.e(a10, "option.type");
                Bundle a11 = u0.a(credentialOption);
                m.e(a11, "option.credentialRetrievalData");
                Bundle a12 = v0.a(credentialOption);
                m.e(a12, "option.candidateQueryData");
                boolean a13 = w0.a(credentialOption);
                Set a14 = x0.a(credentialOption);
                m.e(a14, "option.allowedProviders");
                return companion.createFrom(a10, a11, a12, a13, a14);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(s0.a(obj));
            }
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public static final CredentialOption retrieveProviderGetCredentialRequest$lambda$1(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return (CredentialOption) function1.invoke(obj);
        }

        public final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(Intent intent) {
            m.f(intent, "intent");
            BeginGetCredentialRequest a10 = w.a(intent.getParcelableExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_REQUEST", v.a()));
            if (a10 != null) {
                return BeginGetCredentialUtil.Companion.convertToJetpackRequest$credentials_release(a10);
            }
            return null;
        }

        public final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(Intent intent) {
            m.f(intent, "intent");
            ProviderCreateCredentialRequest a10 = z.a(intent.getParcelableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_REQUEST", x.a()));
            if (a10 == null) {
                Log.i(PendingIntentHandler.TAG, "Request not found in pendingIntent");
                return a10;
            }
            CreateCredentialRequest.Companion companion = CreateCredentialRequest.Companion;
            String a11 = a10.getType();
            m.e(a11, "frameworkReq.type");
            Bundle a12 = a10.getData();
            m.e(a12, "frameworkReq.data");
            Bundle a13 = a10.getData();
            m.e(a13, "frameworkReq.data");
            CreateCredentialRequest createFrom = companion.createFrom(a11, a12, a13, false, a10.getCallingAppInfo().getOrigin());
            if (createFrom == null) {
                return null;
            }
            String a14 = a10.getCallingAppInfo().getPackageName();
            m.e(a14, "frameworkReq.callingAppInfo.packageName");
            SigningInfo a15 = a10.getCallingAppInfo().getSigningInfo();
            m.e(a15, "frameworkReq.callingAppInfo.signingInfo");
            return new ProviderCreateCredentialRequest(createFrom, new CallingAppInfo(a14, a15, a10.getCallingAppInfo().getOrigin()));
        }

        public final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(Intent intent) {
            m.f(intent, "intent");
            GetCredentialRequest a10 = m0.a(intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_REQUEST", t.a()));
            if (a10 == null) {
                Log.i(PendingIntentHandler.TAG, "Get request from framework is null");
                return null;
            }
            ProviderGetCredentialRequest.Companion companion = ProviderGetCredentialRequest.Companion;
            Object a11 = a10.getCredentialOptions().stream().map(new r0(a.f15329a)).collect(Collectors.toList());
            m.e(a11, "frameworkReq.credentialO…lect(Collectors.toList())");
            String a12 = a10.getCallingAppInfo().getPackageName();
            m.e(a12, "frameworkReq.callingAppInfo.packageName");
            SigningInfo a13 = a10.getCallingAppInfo().getSigningInfo();
            m.e(a13, "frameworkReq.callingAppInfo.signingInfo");
            return companion.createFrom$credentials_release((List) a11, new CallingAppInfo(a12, a13, a10.getCallingAppInfo().getOrigin()));
        }

        public final void setBeginGetCredentialResponse(Intent intent, BeginGetCredentialResponse beginGetCredentialResponse) {
            m.f(intent, "intent");
            m.f(beginGetCredentialResponse, "response");
            intent.putExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_RESPONSE", BeginGetCredentialUtil.Companion.convertToFrameworkResponse(beginGetCredentialResponse));
        }

        public final void setCreateCredentialException(Intent intent, CreateCredentialException createCredentialException) {
            m.f(intent, "intent");
            m.f(createCredentialException, "exception");
            h.a();
            intent.putExtra("android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION", g.a(createCredentialException.getType(), createCredentialException.getMessage()));
        }

        public final void setCreateCredentialResponse(Intent intent, CreateCredentialResponse createCredentialResponse) {
            m.f(intent, "intent");
            m.f(createCredentialResponse, "response");
            i0.a();
            intent.putExtra("android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE", h0.a(createCredentialResponse.getData()));
        }

        public final void setGetCredentialException(Intent intent, GetCredentialException getCredentialException) {
            m.f(intent, "intent");
            m.f(getCredentialException, "exception");
            j.a();
            intent.putExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", i.a(getCredentialException.getType(), getCredentialException.getMessage()));
        }

        public final void setGetCredentialResponse(Intent intent, GetCredentialResponse getCredentialResponse) {
            m.f(intent, "intent");
            m.f(getCredentialResponse, "response");
            f0.a();
            g0.a();
            intent.putExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", d0.a(c0.a(getCredentialResponse.getCredential().getType(), getCredentialResponse.getCredential().getData())));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(Intent intent) {
        return Companion.retrieveBeginGetCredentialRequest(intent);
    }

    public static final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(Intent intent) {
        return Companion.retrieveProviderCreateCredentialRequest(intent);
    }

    public static final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(Intent intent) {
        return Companion.retrieveProviderGetCredentialRequest(intent);
    }

    public static final void setBeginGetCredentialResponse(Intent intent, BeginGetCredentialResponse beginGetCredentialResponse) {
        Companion.setBeginGetCredentialResponse(intent, beginGetCredentialResponse);
    }

    public static final void setCreateCredentialException(Intent intent, CreateCredentialException createCredentialException) {
        Companion.setCreateCredentialException(intent, createCredentialException);
    }

    public static final void setCreateCredentialResponse(Intent intent, CreateCredentialResponse createCredentialResponse) {
        Companion.setCreateCredentialResponse(intent, createCredentialResponse);
    }

    public static final void setGetCredentialException(Intent intent, GetCredentialException getCredentialException) {
        Companion.setGetCredentialException(intent, getCredentialException);
    }

    public static final void setGetCredentialResponse(Intent intent, GetCredentialResponse getCredentialResponse) {
        Companion.setGetCredentialResponse(intent, getCredentialResponse);
    }
}
