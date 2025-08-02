package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f16093a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f16094b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f16095c;

    public /* synthetic */ g(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i10, Object obj) {
        this.f16093a = diagnosticsCallback;
        this.f16094b = i10;
        this.f16095c = obj;
    }

    public final void run() {
        this.f16093a.onResultReceived(this.f16094b, this.f16095c);
    }
}
