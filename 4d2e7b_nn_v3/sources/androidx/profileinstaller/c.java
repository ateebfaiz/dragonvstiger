package androidx.profileinstaller;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceProfileWriter f16074a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f16075b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f16076c;

    public /* synthetic */ c(DeviceProfileWriter deviceProfileWriter, int i10, Object obj) {
        this.f16074a = deviceProfileWriter;
        this.f16075b = i10;
        this.f16076c = obj;
    }

    public final void run() {
        this.f16074a.lambda$result$0(this.f16075b, this.f16076c);
    }
}
