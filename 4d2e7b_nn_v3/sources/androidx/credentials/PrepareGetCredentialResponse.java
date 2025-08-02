package androidx.credentials;

import android.annotation.SuppressLint;
import android.credentials.PrepareGetCredentialResponse;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

@RequiresApi(34)
@SuppressLint({"MissingGetterMatchingBuilder"})
public final class PrepareGetCredentialResponse {
    private final Function1<String, Boolean> credentialTypeDelegate;
    private final Function0<Boolean> hasAuthResultsDelegate;
    private final Function0<Boolean> hasRemoteResultsDelegate;
    private final boolean isNullHandlesForTest;
    private final PendingGetCredentialHandle pendingGetCredentialHandle;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class Builder {
        private android.credentials.PrepareGetCredentialResponse frameworkResponse;
        private Function0<Boolean> hasAuthResultsDelegate;
        private Function1<? super String, Boolean> hasCredentialResultsDelegate;
        private Function0<Boolean> hasRemoteResultsDelegate;
        private PendingGetCredentialHandle pendingGetCredentialHandle;

        /* synthetic */ class a extends j implements Function1 {
            a(Object obj) {
                super(1, obj, Builder.class, "hasCredentialType", "hasCredentialType(Ljava/lang/String;)Z", 0);
            }

            /* renamed from: c */
            public final Boolean invoke(String str) {
                m.f(str, "p0");
                return Boolean.valueOf(((Builder) this.receiver).hasCredentialType(str));
            }
        }

        /* synthetic */ class b extends j implements Function0 {
            b(Object obj) {
                super(0, obj, Builder.class, "hasAuthenticationResults", "hasAuthenticationResults()Z", 0);
            }

            /* renamed from: c */
            public final Boolean invoke() {
                return Boolean.valueOf(((Builder) this.receiver).hasAuthenticationResults());
            }
        }

        /* synthetic */ class c extends j implements Function0 {
            c(Object obj) {
                super(0, obj, Builder.class, "hasRemoteResults", "hasRemoteResults()Z", 0);
            }

            /* renamed from: c */
            public final Boolean invoke() {
                return Boolean.valueOf(((Builder) this.receiver).hasRemoteResults());
            }
        }

        /* access modifiers changed from: private */
        @RequiresPermission("android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS")
        public final boolean hasAuthenticationResults() {
            android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse = this.frameworkResponse;
            m.c(prepareGetCredentialResponse);
            return prepareGetCredentialResponse.hasAuthenticationResults();
        }

        /* access modifiers changed from: private */
        @RequiresPermission("android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS")
        public final boolean hasCredentialType(String str) {
            android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse = this.frameworkResponse;
            m.c(prepareGetCredentialResponse);
            return prepareGetCredentialResponse.hasCredentialResults(str);
        }

        /* access modifiers changed from: private */
        @RequiresPermission("android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS")
        public final boolean hasRemoteResults() {
            android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse = this.frameworkResponse;
            m.c(prepareGetCredentialResponse);
            return prepareGetCredentialResponse.hasRemoteResults();
        }

        public final PrepareGetCredentialResponse build() {
            return new PrepareGetCredentialResponse(this.pendingGetCredentialHandle, this.hasRemoteResultsDelegate, this.hasAuthResultsDelegate, this.hasCredentialResultsDelegate, false, (DefaultConstructorMarker) null);
        }

        public final Builder setFrameworkResponse(android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse) {
            this.frameworkResponse = prepareGetCredentialResponse;
            if (prepareGetCredentialResponse != null) {
                this.hasCredentialResultsDelegate = new a(this);
                this.hasAuthResultsDelegate = new b(this);
                this.hasRemoteResultsDelegate = new c(this);
            }
            return this;
        }

        public final Builder setPendingGetCredentialHandle(PendingGetCredentialHandle pendingGetCredentialHandle2) {
            m.f(pendingGetCredentialHandle2, "handle");
            this.pendingGetCredentialHandle = pendingGetCredentialHandle2;
            return this;
        }
    }

    @RequiresApi(34)
    public static final class PendingGetCredentialHandle {
        private final PrepareGetCredentialResponse.PendingGetCredentialHandle frameworkHandle;

        public PendingGetCredentialHandle(PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle) {
            this.frameworkHandle = pendingGetCredentialHandle;
            if (Build.VERSION.SDK_INT >= 34) {
                m.c(pendingGetCredentialHandle);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final PrepareGetCredentialResponse.PendingGetCredentialHandle getFrameworkHandle() {
            return this.frameworkHandle;
        }
    }

    @VisibleForTesting
    public static final class TestBuilder {
        private Function0<Boolean> hasAuthResultsDelegate;
        private Function1<? super String, Boolean> hasCredentialResultsDelegate;
        private Function0<Boolean> hasRemoteResultsDelegate;

        public final PrepareGetCredentialResponse build() {
            return new PrepareGetCredentialResponse((PendingGetCredentialHandle) null, this.hasRemoteResultsDelegate, this.hasAuthResultsDelegate, this.hasCredentialResultsDelegate, true, (DefaultConstructorMarker) null);
        }

        @VisibleForTesting
        public final TestBuilder setCredentialTypeDelegate(Function1<? super String, Boolean> function1) {
            m.f(function1, "handler");
            this.hasCredentialResultsDelegate = function1;
            return this;
        }

        @VisibleForTesting
        public final TestBuilder setHasAuthResultsDelegate(Function0<Boolean> function0) {
            m.f(function0, "handler");
            this.hasAuthResultsDelegate = function0;
            return this;
        }

        @VisibleForTesting
        public final TestBuilder setHasRemoteResultsDelegate(Function0<Boolean> function0) {
            m.f(function0, "handler");
            this.hasRemoteResultsDelegate = function0;
            return this;
        }
    }

    public /* synthetic */ PrepareGetCredentialResponse(PendingGetCredentialHandle pendingGetCredentialHandle2, Function0 function0, Function0 function02, Function1 function1, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendingGetCredentialHandle2, function0, function02, function1, z10);
    }

    public final Function1<String, Boolean> getCredentialTypeDelegate() {
        return this.credentialTypeDelegate;
    }

    public final Function0<Boolean> getHasAuthResultsDelegate() {
        return this.hasAuthResultsDelegate;
    }

    public final Function0<Boolean> getHasRemoteResultsDelegate() {
        return this.hasRemoteResultsDelegate;
    }

    public final PendingGetCredentialHandle getPendingGetCredentialHandle() {
        return this.pendingGetCredentialHandle;
    }

    @RequiresPermission("android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS")
    public final boolean hasAuthenticationResults() {
        Function0<Boolean> function0 = this.hasAuthResultsDelegate;
        if (function0 != null) {
            return ((Boolean) function0.invoke()).booleanValue();
        }
        return false;
    }

    @RequiresPermission("android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS")
    public final boolean hasCredentialResults(String str) {
        m.f(str, "credentialType");
        Function1<String, Boolean> function1 = this.credentialTypeDelegate;
        if (function1 != null) {
            return ((Boolean) function1.invoke(str)).booleanValue();
        }
        return false;
    }

    @RequiresPermission("android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS")
    public final boolean hasRemoteResults() {
        Function0<Boolean> function0 = this.hasRemoteResultsDelegate;
        if (function0 != null) {
            return ((Boolean) function0.invoke()).booleanValue();
        }
        return false;
    }

    public final boolean isNullHandlesForTest() {
        return this.isNullHandlesForTest;
    }

    private PrepareGetCredentialResponse(PendingGetCredentialHandle pendingGetCredentialHandle2, Function0<Boolean> function0, Function0<Boolean> function02, Function1<? super String, Boolean> function1, boolean z10) {
        this.pendingGetCredentialHandle = pendingGetCredentialHandle2;
        this.hasRemoteResultsDelegate = function0;
        this.hasAuthResultsDelegate = function02;
        this.credentialTypeDelegate = function1;
        this.isNullHandlesForTest = z10;
        if (Build.VERSION.SDK_INT >= 34 && !z10) {
            m.c(pendingGetCredentialHandle2);
        }
    }
}
