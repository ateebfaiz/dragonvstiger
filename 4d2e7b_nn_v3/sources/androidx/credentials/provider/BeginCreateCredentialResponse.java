package androidx.credentials.provider;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class BeginCreateCredentialResponse {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<CreateEntry> createEntries;
    private final RemoteEntry remoteEntry;

    public static final class Builder {
        private List<CreateEntry> createEntries = new ArrayList();
        private RemoteEntry remoteEntry;

        public final Builder addCreateEntry(CreateEntry createEntry) {
            m.f(createEntry, "createEntry");
            this.createEntries.add(createEntry);
            return this;
        }

        public final BeginCreateCredentialResponse build() {
            return new BeginCreateCredentialResponse(r.w0(this.createEntries), this.remoteEntry);
        }

        public final Builder setCreateEntries(List<CreateEntry> list) {
            m.f(list, "createEntries");
            this.createEntries = r.y0(list);
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

        public final Bundle asBundle(BeginCreateCredentialResponse beginCreateCredentialResponse) {
            m.f(beginCreateCredentialResponse, "response");
            Bundle bundle = new Bundle();
            if (Build.VERSION.SDK_INT >= 34) {
                a.a(bundle, beginCreateCredentialResponse);
            }
            return bundle;
        }

        public final BeginCreateCredentialResponse fromBundle(Bundle bundle) {
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
        public static final a f15320a = new a();

        private a() {
        }

        @DoNotInline
        public static final void a(Bundle bundle, BeginCreateCredentialResponse beginCreateCredentialResponse) {
            m.f(bundle, "bundle");
            m.f(beginCreateCredentialResponse, "response");
            bundle.putParcelable("androidx.credentials.provider.BeginCreateCredentialResponse", BeginCreateCredentialUtil.Companion.convertToFrameworkResponse(beginCreateCredentialResponse));
        }

        @DoNotInline
        public static final BeginCreateCredentialResponse b(Bundle bundle) {
            m.f(bundle, "bundle");
            android.service.credentials.BeginCreateCredentialResponse beginCreateCredentialResponse = (android.service.credentials.BeginCreateCredentialResponse) bundle.getParcelable("androidx.credentials.provider.BeginCreateCredentialResponse", android.service.credentials.BeginCreateCredentialResponse.class);
            if (beginCreateCredentialResponse != null) {
                return BeginCreateCredentialUtil.Companion.convertToJetpackResponse(beginCreateCredentialResponse);
            }
            return null;
        }
    }

    public BeginCreateCredentialResponse() {
        this((List) null, (RemoteEntry) null, 3, (DefaultConstructorMarker) null);
    }

    public static final Bundle asBundle(BeginCreateCredentialResponse beginCreateCredentialResponse) {
        return Companion.asBundle(beginCreateCredentialResponse);
    }

    public static final BeginCreateCredentialResponse fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    public final List<CreateEntry> getCreateEntries() {
        return this.createEntries;
    }

    public final RemoteEntry getRemoteEntry() {
        return this.remoteEntry;
    }

    public BeginCreateCredentialResponse(List<CreateEntry> list, RemoteEntry remoteEntry2) {
        m.f(list, "createEntries");
        this.createEntries = list;
        this.remoteEntry = remoteEntry2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BeginCreateCredentialResponse(List list, RemoteEntry remoteEntry2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? r.l() : list, (i10 & 2) != 0 ? null : remoteEntry2);
    }
}
