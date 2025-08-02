package b7;

import com.facebook.react.modules.toast.ToastModule;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ToastModule f2493a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2494b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f2495c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2496d;

    public /* synthetic */ b(ToastModule toastModule, String str, int i10, int i11) {
        this.f2493a = toastModule;
        this.f2494b = str;
        this.f2495c = i10;
        this.f2496d = i11;
    }

    public final void run() {
        ToastModule.showWithGravity$lambda$1(this.f2493a, this.f2494b, this.f2495c, this.f2496d);
    }
}
