package b7;

import com.facebook.react.modules.toast.ToastModule;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ToastModule f2497a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2498b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f2499c;

    public /* synthetic */ c(ToastModule toastModule, String str, int i10) {
        this.f2497a = toastModule;
        this.f2498b = str;
        this.f2499c = i10;
    }

    public final void run() {
        ToastModule.show$lambda$0(this.f2497a, this.f2498b, this.f2499c);
    }
}
