package androidx.credentials;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.os.CancellationSignal;
import androidx.annotation.RequiresApi;
import androidx.credentials.PrepareGetCredentialResponse;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlinx.coroutines.CancellableContinuationImpl;

@RequiresApi(16)
@SuppressLint({"ObsoleteSdkInt"})
public interface CredentialManager {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: androidx.credentials.CredentialManager$-CC  reason: invalid class name */
    public abstract /* synthetic */ class CC {

        /* renamed from: androidx.credentials.CredentialManager$-CC$a */
        static final class a extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CancellationSignal f15308a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(CancellationSignal cancellationSignal) {
                super(1);
                this.f15308a = cancellationSignal;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f12577a;
            }

            public final void invoke(Throwable th) {
                this.f15308a.cancel();
            }
        }

        /* renamed from: androidx.credentials.CredentialManager$-CC$b */
        static final class b extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CancellationSignal f15309a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(CancellationSignal cancellationSignal) {
                super(1);
                this.f15309a = cancellationSignal;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f12577a;
            }

            public final void invoke(Throwable th) {
                this.f15309a.cancel();
            }
        }

        /* renamed from: androidx.credentials.CredentialManager$-CC$c */
        static final class c extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CancellationSignal f15310a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(CancellationSignal cancellationSignal) {
                super(1);
                this.f15310a = cancellationSignal;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f12577a;
            }

            public final void invoke(Throwable th) {
                this.f15310a.cancel();
            }
        }

        /* renamed from: androidx.credentials.CredentialManager$-CC$d */
        static final class d extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CancellationSignal f15311a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(CancellationSignal cancellationSignal) {
                super(1);
                this.f15311a = cancellationSignal;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f12577a;
            }

            public final void invoke(Throwable th) {
                this.f15311a.cancel();
            }
        }

        /* renamed from: androidx.credentials.CredentialManager$-CC$e */
        static final class e extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CancellationSignal f15312a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(CancellationSignal cancellationSignal) {
                super(1);
                this.f15312a = cancellationSignal;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f12577a;
            }

            public final void invoke(Throwable th) {
                this.f15312a.cancel();
            }
        }

        static {
            Companion companion = CredentialManager.Companion;
        }

        public static Object a(CredentialManager credentialManager, ClearCredentialStateRequest clearCredentialStateRequest, kotlin.coroutines.d dVar) {
            return f(credentialManager, clearCredentialStateRequest, dVar);
        }

        public static Object b(CredentialManager credentialManager, Context context, CreateCredentialRequest createCredentialRequest, kotlin.coroutines.d dVar) {
            return h(credentialManager, context, createCredentialRequest, dVar);
        }

        public static Object c(CredentialManager credentialManager, Context context, GetCredentialRequest getCredentialRequest, kotlin.coroutines.d dVar) {
            return i(credentialManager, context, getCredentialRequest, dVar);
        }

        public static Object d(CredentialManager credentialManager, Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, kotlin.coroutines.d dVar) {
            return j(credentialManager, context, pendingGetCredentialHandle, dVar);
        }

        public static Object e(CredentialManager credentialManager, GetCredentialRequest getCredentialRequest, kotlin.coroutines.d dVar) {
            return k(credentialManager, getCredentialRequest, dVar);
        }

        public static /* synthetic */ Object f(CredentialManager credentialManager, ClearCredentialStateRequest clearCredentialStateRequest, kotlin.coroutines.d dVar) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.b.b(dVar), 1);
            cancellableContinuationImpl.E();
            CancellationSignal cancellationSignal = new CancellationSignal();
            cancellableContinuationImpl.j(new a(cancellationSignal));
            credentialManager.clearCredentialStateAsync(clearCredentialStateRequest, cancellationSignal, new a(), new CredentialManager$clearCredentialState$2$callback$1(cancellableContinuationImpl));
            Object A = cancellableContinuationImpl.A();
            if (A == kotlin.coroutines.intrinsics.b.c()) {
                kotlin.coroutines.jvm.internal.e.c(dVar);
            }
            if (A == kotlin.coroutines.intrinsics.b.c()) {
                return A;
            }
            return Unit.f12577a;
        }

        public static CredentialManager g(Context context) {
            return CredentialManager.Companion.create(context);
        }

        public static /* synthetic */ Object h(CredentialManager credentialManager, Context context, CreateCredentialRequest createCredentialRequest, kotlin.coroutines.d dVar) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.b.b(dVar), 1);
            cancellableContinuationImpl.E();
            CancellationSignal cancellationSignal = new CancellationSignal();
            cancellableContinuationImpl.j(new b(cancellationSignal));
            CredentialManager credentialManager2 = credentialManager;
            Context context2 = context;
            CreateCredentialRequest createCredentialRequest2 = createCredentialRequest;
            credentialManager2.createCredentialAsync(context2, createCredentialRequest2, cancellationSignal, new a(), new CredentialManager$createCredential$2$callback$1(cancellableContinuationImpl));
            Object A = cancellableContinuationImpl.A();
            if (A == kotlin.coroutines.intrinsics.b.c()) {
                kotlin.coroutines.jvm.internal.e.c(dVar);
            }
            return A;
        }

        public static /* synthetic */ Object i(CredentialManager credentialManager, Context context, GetCredentialRequest getCredentialRequest, kotlin.coroutines.d dVar) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.b.b(dVar), 1);
            cancellableContinuationImpl.E();
            CancellationSignal cancellationSignal = new CancellationSignal();
            cancellableContinuationImpl.j(new c(cancellationSignal));
            CredentialManager credentialManager2 = credentialManager;
            Context context2 = context;
            GetCredentialRequest getCredentialRequest2 = getCredentialRequest;
            credentialManager2.getCredentialAsync(context2, getCredentialRequest2, cancellationSignal, (Executor) new a(), (CredentialManagerCallback<GetCredentialResponse, GetCredentialException>) new CredentialManager$getCredential$2$callback$1(cancellableContinuationImpl));
            Object A = cancellableContinuationImpl.A();
            if (A == kotlin.coroutines.intrinsics.b.c()) {
                kotlin.coroutines.jvm.internal.e.c(dVar);
            }
            return A;
        }

        public static /* synthetic */ Object j(CredentialManager credentialManager, Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, kotlin.coroutines.d dVar) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.b.b(dVar), 1);
            cancellableContinuationImpl.E();
            CancellationSignal cancellationSignal = new CancellationSignal();
            cancellableContinuationImpl.j(new d(cancellationSignal));
            CredentialManager credentialManager2 = credentialManager;
            Context context2 = context;
            PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle2 = pendingGetCredentialHandle;
            credentialManager2.getCredentialAsync(context2, pendingGetCredentialHandle2, cancellationSignal, (Executor) new a(), (CredentialManagerCallback<GetCredentialResponse, GetCredentialException>) new CredentialManager$getCredential$4$callback$1(cancellableContinuationImpl));
            Object A = cancellableContinuationImpl.A();
            if (A == kotlin.coroutines.intrinsics.b.c()) {
                kotlin.coroutines.jvm.internal.e.c(dVar);
            }
            return A;
        }

        public static /* synthetic */ Object k(CredentialManager credentialManager, GetCredentialRequest getCredentialRequest, kotlin.coroutines.d dVar) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.b.b(dVar), 1);
            cancellableContinuationImpl.E();
            CancellationSignal cancellationSignal = new CancellationSignal();
            cancellableContinuationImpl.j(new e(cancellationSignal));
            credentialManager.prepareGetCredentialAsync(getCredentialRequest, cancellationSignal, new a(), new CredentialManager$prepareGetCredential$2$callback$1(cancellableContinuationImpl));
            Object A = cancellableContinuationImpl.A();
            if (A == kotlin.coroutines.intrinsics.b.c()) {
                kotlin.coroutines.jvm.internal.e.c(dVar);
            }
            return A;
        }
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final CredentialManager create(Context context) {
            m.f(context, "context");
            return new CredentialManagerImpl(context);
        }
    }

    Object clearCredentialState(ClearCredentialStateRequest clearCredentialStateRequest, d dVar);

    void clearCredentialStateAsync(ClearCredentialStateRequest clearCredentialStateRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<Void, ClearCredentialException> credentialManagerCallback);

    Object createCredential(Context context, CreateCredentialRequest createCredentialRequest, d dVar);

    void createCredentialAsync(Context context, CreateCredentialRequest createCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> credentialManagerCallback);

    @RequiresApi(34)
    PendingIntent createSettingsPendingIntent();

    Object getCredential(Context context, GetCredentialRequest getCredentialRequest, d dVar);

    @RequiresApi(34)
    Object getCredential(Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, d dVar);

    void getCredentialAsync(Context context, GetCredentialRequest getCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> credentialManagerCallback);

    @RequiresApi(34)
    void getCredentialAsync(Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> credentialManagerCallback);

    @RequiresApi(34)
    Object prepareGetCredential(GetCredentialRequest getCredentialRequest, d dVar);

    @RequiresApi(34)
    void prepareGetCredentialAsync(GetCredentialRequest getCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<PrepareGetCredentialResponse, GetCredentialException> credentialManagerCallback);
}
