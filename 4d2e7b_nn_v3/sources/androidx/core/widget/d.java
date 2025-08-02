package androidx.core.widget;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f15306a;

    public /* synthetic */ d(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f15306a = contentLoadingProgressBar;
    }

    public final void run() {
        this.f15306a.hideOnUiThread();
    }
}
