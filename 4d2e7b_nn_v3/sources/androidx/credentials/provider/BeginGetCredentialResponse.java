package androidx.credentials.provider;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class BeginGetCredentialResponse {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<Action> actions;
    private final List<AuthenticationAction> authenticationActions;
    private final List<CredentialEntry> credentialEntries;
    private final RemoteEntry remoteEntry;

    public static final class Builder {
        private List<Action> actions = new ArrayList();
        private List<AuthenticationAction> authenticationActions = new ArrayList();
        private List<CredentialEntry> credentialEntries = new ArrayList();
        private RemoteEntry remoteEntry;

        public final Builder addAction(Action action) {
            m.f(action, "action");
            this.actions.add(action);
            return this;
        }

        public final Builder addAuthenticationAction(AuthenticationAction authenticationAction) {
            m.f(authenticationAction, "authenticationAction");
            this.authenticationActions.add(authenticationAction);
            return this;
        }

        public final Builder addCredentialEntry(CredentialEntry credentialEntry) {
            m.f(credentialEntry, "entry");
            this.credentialEntries.add(credentialEntry);
            return this;
        }

        public final BeginGetCredentialResponse build() {
            return new BeginGetCredentialResponse(r.w0(this.credentialEntries), r.w0(this.actions), r.w0(this.authenticationActions), this.remoteEntry);
        }

        public final Builder setActions(List<Action> list) {
            m.f(list, "actions");
            this.actions = r.y0(list);
            return this;
        }

        public final Builder setAuthenticationActions(List<AuthenticationAction> list) {
            m.f(list, "authenticationEntries");
            this.authenticationActions = r.y0(list);
            return this;
        }

        public final Builder setCredentialEntries(List<? extends CredentialEntry> list) {
            m.f(list, "entries");
            this.credentialEntries = r.y0(list);
            return this;
        }

        public final Builder setRemoteEntry(RemoteEntry remoteEntry2) {
            this.remoteEntry = remoteEntry2;
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public final Bundle asBundle(BeginGetCredentialResponse beginGetCredentialResponse) {
            m.f(beginGetCredentialResponse, "response");
            Bundle bundle = new Bundle();
            if (Build.VERSION.SDK_INT >= 34) {
                a.a(bundle, beginGetCredentialResponse);
            }
            return bundle;
        }

        public final BeginGetCredentialResponse fromBundle(Bundle bundle) {
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
        public static final a f15323a = new a();

        private a() {
        }

        @DoNotInline
        public static final void a(Bundle bundle, BeginGetCredentialResponse beginGetCredentialResponse) {
            m.f(bundle, "bundle");
            m.f(beginGetCredentialResponse, "response");
            bundle.putParcelable("androidx.credentials.provider.BeginGetCredentialResponse", BeginGetCredentialUtil.Companion.convertToFrameworkResponse(beginGetCredentialResponse));
        }

        @DoNotInline
        public static final BeginGetCredentialResponse b(Bundle bundle) {
            m.f(bundle, "bundle");
            android.service.credentials.BeginGetCredentialResponse beginGetCredentialResponse = (android.service.credentials.BeginGetCredentialResponse) bundle.getParcelable("androidx.credentials.provider.BeginGetCredentialResponse", android.service.credentials.BeginGetCredentialResponse.class);
            if (beginGetCredentialResponse != null) {
                return BeginGetCredentialUtil.Companion.convertToJetpackResponse(beginGetCredentialResponse);
            }
            return null;
        }
    }

    public BeginGetCredentialResponse() {
        this((List) null, (List) null, (List) null, (RemoteEntry) null, 15, (DefaultConstructorMarker) null);
    }

    public static final Bundle asBundle(BeginGetCredentialResponse beginGetCredentialResponse) {
        return Companion.asBundle(beginGetCredentialResponse);
    }

    public static final BeginGetCredentialResponse fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    public final List<Action> getActions() {
        return this.actions;
    }

    public final List<AuthenticationAction> getAuthenticationActions() {
        return this.authenticationActions;
    }

    public final List<CredentialEntry> getCredentialEntries() {
        return this.credentialEntries;
    }

    public final RemoteEntry getRemoteEntry() {
        return this.remoteEntry;
    }

    public BeginGetCredentialResponse(List<? extends CredentialEntry> list, List<Action> list2, List<AuthenticationAction> list3, RemoteEntry remoteEntry2) {
        m.f(list, "credentialEntries");
        m.f(list2, "actions");
        m.f(list3, "authenticationActions");
        this.credentialEntries = list;
        this.actions = list2;
        this.authenticationActions = list3;
        this.remoteEntry = remoteEntry2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BeginGetCredentialResponse(List list, List list2, List list3, RemoteEntry remoteEntry2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? r.l() : list, (i10 & 2) != 0 ? r.l() : list2, (i10 & 4) != 0 ? r.l() : list3, (i10 & 8) != 0 ? null : remoteEntry2);
    }
}
