package q5;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.o;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a0 f23245a = new a0();

    public interface a {
        void a(String str);
    }

    public static final class b implements InstallReferrerStateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstallReferrerClient f23246a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f23247b;

        b(InstallReferrerClient installReferrerClient, a aVar) {
            this.f23246a = installReferrerClient;
            this.f23247b = aVar;
        }

        public void onInstallReferrerServiceDisconnected() {
        }

        public void onInstallReferrerSetupFinished(int i10) {
            if (!v5.a.d(this)) {
                if (i10 == 0) {
                    try {
                        InstallReferrerClient installReferrerClient = this.f23246a;
                        m.e(installReferrerClient, "referrerClient");
                        ReferrerDetails installReferrer = installReferrerClient.getInstallReferrer();
                        m.e(installReferrer, "referrerClient.installReferrer");
                        String installReferrer2 = installReferrer.getInstallReferrer();
                        if (installReferrer2 != null && (j.K(installReferrer2, "fb", false, 2, (Object) null) || j.K(installReferrer2, "facebook", false, 2, (Object) null))) {
                            this.f23247b.a(installReferrer2);
                        }
                        a0.f23245a.e();
                    } catch (RemoteException unused) {
                    }
                } else if (i10 == 2) {
                    try {
                        a0.f23245a.e();
                    } catch (Throwable th) {
                        v5.a.b(th, this);
                    }
                }
            }
        }
    }

    private a0() {
    }

    private final boolean b() {
        return o.f().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("is_referrer_updated", false);
    }

    private final void c(a aVar) {
        InstallReferrerClient build = InstallReferrerClient.newBuilder(o.f()).build();
        try {
            build.startConnection(new b(build, aVar));
        } catch (Exception unused) {
        }
    }

    public static final void d(a aVar) {
        m.f(aVar, "callback");
        a0 a0Var = f23245a;
        if (!a0Var.b()) {
            a0Var.c(aVar);
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        o.f().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("is_referrer_updated", true).apply();
    }
}
