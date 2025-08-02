package androidx.appcompat.widget;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Toolbar f14375a;

    public /* synthetic */ u(Toolbar toolbar) {
        this.f14375a = toolbar;
    }

    public final void run() {
        this.f14375a.invalidateMenu();
    }
}
