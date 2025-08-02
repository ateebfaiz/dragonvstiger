package androidx.core.widget;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f15305a;

    public /* synthetic */ c(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f15305a = contentLoadingProgressBar;
    }

    public final void run() {
        this.f15305a.showOnUiThread();
    }
}
