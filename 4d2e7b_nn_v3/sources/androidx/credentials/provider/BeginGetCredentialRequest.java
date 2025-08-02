package androidx.credentials.provider;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class BeginGetCredentialRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<BeginGetCredentialOption> beginGetCredentialOptions;
    private final CallingAppInfo callingAppInfo;

    public static final class Companion {
        private Companion() {
        }

        public final Bundle asBundle(BeginGetCredentialRequest beginGetCredentialRequest) {
            m.f(beginGetCredentialRequest, "request");
            Bundle bundle = new Bundle();
            if (Build.VERSION.SDK_INT >= 34) {
                a.a(bundle, beginGetCredentialRequest);
            }
            return bundle;
        }

        public final BeginGetCredentialRequest fromBundle(Bundle bundle) {
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
        public static final a f15322a = new a();

        private a() {
        }

        @DoNotInline
        public static final void a(Bundle bundle, BeginGetCredentialRequest beginGetCredentialRequest) {
            m.f(bundle, "bundle");
            m.f(beginGetCredentialRequest, "request");
            bundle.putParcelable("androidx.credentials.provider.BeginGetCredentialRequest", BeginGetCredentialUtil.Companion.convertToFrameworkRequest(beginGetCredentialRequest));
        }

        @DoNotInline
        public static final BeginGetCredentialRequest b(Bundle bundle) {
            m.f(bundle, "bundle");
            android.service.credentials.BeginGetCredentialRequest beginGetCredentialRequest = (android.service.credentials.BeginGetCredentialRequest) bundle.getParcelable("androidx.credentials.provider.BeginGetCredentialRequest", android.service.credentials.BeginGetCredentialRequest.class);
            if (beginGetCredentialRequest != null) {
                return BeginGetCredentialUtil.Companion.convertToJetpackRequest$credentials_release(beginGetCredentialRequest);
            }
            return null;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BeginGetCredentialRequest(List<? extends BeginGetCredentialOption> list) {
        this(list, (CallingAppInfo) null, 2, (DefaultConstructorMarker) null);
        m.f(list, "beginGetCredentialOptions");
    }

    public static final Bundle asBundle(BeginGetCredentialRequest beginGetCredentialRequest) {
        return Companion.asBundle(beginGetCredentialRequest);
    }

    public static final BeginGetCredentialRequest fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    public final List<BeginGetCredentialOption> getBeginGetCredentialOptions() {
        return this.beginGetCredentialOptions;
    }

    public final CallingAppInfo getCallingAppInfo() {
        return this.callingAppInfo;
    }

    public BeginGetCredentialRequest(List<? extends BeginGetCredentialOption> list, CallingAppInfo callingAppInfo2) {
        m.f(list, "beginGetCredentialOptions");
        this.beginGetCredentialOptions = list;
        this.callingAppInfo = callingAppInfo2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BeginGetCredentialRequest(List list, CallingAppInfo callingAppInfo2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i10 & 2) != 0 ? null : callingAppInfo2);
    }
}
