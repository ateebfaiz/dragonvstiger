package r7;

import com.facebook.react.views.debuggingoverlay.DebuggingOverlay;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DebuggingOverlay f12941a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f12942b;

    public /* synthetic */ a(DebuggingOverlay debuggingOverlay, int i10) {
        this.f12941a = debuggingOverlay;
        this.f12942b = i10;
    }

    public final void run() {
        DebuggingOverlay.c(this.f12941a, this.f12942b);
    }
}
