package y6;

import com.facebook.react.modules.devloading.DevLoadingModule;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DevLoadingModule f13326a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f13327b;

    public /* synthetic */ b(DevLoadingModule devLoadingModule, String str) {
        this.f13326a = devLoadingModule;
        this.f13327b = str;
    }

    public final void run() {
        DevLoadingModule.showMessage$lambda$0(this.f13326a, this.f13327b);
    }
}
