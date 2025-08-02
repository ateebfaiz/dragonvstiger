package androidx.credentials.provider;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class BeginCreateCredentialRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final CallingAppInfo callingAppInfo;
    private final Bundle candidateQueryData;
    private final String type;

    public static final class Companion {
        private Companion() {
        }

        public final Bundle asBundle(BeginCreateCredentialRequest beginCreateCredentialRequest) {
            m.f(beginCreateCredentialRequest, "request");
            Bundle bundle = new Bundle();
            if (Build.VERSION.SDK_INT >= 34) {
                a.a(bundle, beginCreateCredentialRequest);
            }
            return bundle;
        }

        public final BeginCreateCredentialRequest fromBundle(Bundle bundle) {
            m.f(bundle, "bundle");
            if (Build.VERSION.SDK_INT >= 34) {
                return a.b(bundle);
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15319a = new a();

        private a() {
        }

        @DoNotInline
        public static final void a(Bundle bundle, BeginCreateCredentialRequest beginCreateCredentialRequest) {
            m.f(bundle, "bundle");
            m.f(beginCreateCredentialRequest, "request");
            bundle.putParcelable("androidx.credentials.provider.BeginCreateCredentialRequest", BeginCreateCredentialUtil.Companion.convertToFrameworkRequest(beginCreateCredentialRequest));
        }

        @DoNotInline
        public static final BeginCreateCredentialRequest b(Bundle bundle) {
            m.f(bundle, "bundle");
            android.service.credentials.BeginCreateCredentialRequest beginCreateCredentialRequest = (android.service.credentials.BeginCreateCredentialRequest) bundle.getParcelable("androidx.credentials.provider.BeginCreateCredentialRequest", android.service.credentials.BeginCreateCredentialRequest.class);
            if (beginCreateCredentialRequest != null) {
                return BeginCreateCredentialUtil.Companion.convertToJetpackRequest$credentials_release(beginCreateCredentialRequest);
            }
            return null;
        }
    }

    public BeginCreateCredentialRequest(String str, Bundle bundle, CallingAppInfo callingAppInfo2) {
        m.f(str, "type");
        m.f(bundle, "candidateQueryData");
        this.type = str;
        this.candidateQueryData = bundle;
        this.callingAppInfo = callingAppInfo2;
    }

    public static final Bundle asBundle(BeginCreateCredentialRequest beginCreateCredentialRequest) {
        return Companion.asBundle(beginCreateCredentialRequest);
    }

    public static final BeginCreateCredentialRequest fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    public final CallingAppInfo getCallingAppInfo() {
        return this.callingAppInfo;
    }

    public final Bundle getCandidateQueryData() {
        return this.candidateQueryData;
    }

    public final String getType() {
        return this.type;
    }
}
