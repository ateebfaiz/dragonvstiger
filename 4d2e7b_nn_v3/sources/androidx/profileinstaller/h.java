package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f16096a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f16097b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f16098c;

    public /* synthetic */ h(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i10, Object obj) {
        this.f16096a = diagnosticsCallback;
        this.f16097b = i10;
        this.f16098c = obj;
    }

    public final void run() {
        this.f16096a.onDiagnosticReceived(this.f16097b, this.f16098c);
    }
}
