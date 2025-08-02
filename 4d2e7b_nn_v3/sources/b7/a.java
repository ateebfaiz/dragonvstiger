package b7;

import com.facebook.react.modules.toast.ToastModule;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ToastModule f2487a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2488b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f2489c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f2490d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f2491e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f2492f;

    public /* synthetic */ a(ToastModule toastModule, String str, int i10, int i11, int i12, int i13) {
        this.f2487a = toastModule;
        this.f2488b = str;
        this.f2489c = i10;
        this.f2490d = i11;
        this.f2491e = i12;
        this.f2492f = i13;
    }

    public final void run() {
        ToastModule.showWithGravityAndOffset$lambda$2(this.f2487a, this.f2488b, this.f2489c, this.f2490d, this.f2491e, this.f2492f);
    }
}
