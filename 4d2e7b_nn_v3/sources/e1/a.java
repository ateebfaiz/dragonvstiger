package e1;

import com.bugsnag.android.ndk.NativeBridge;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NativeBridge f21116a;

    public /* synthetic */ a(NativeBridge nativeBridge) {
        this.f21116a = nativeBridge;
    }

    public final void run() {
        this.f21116a.refreshSymbolTable();
    }
}
