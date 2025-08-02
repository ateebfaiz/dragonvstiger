package androidx.lifecycle;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComputableLiveData f15887a;

    public /* synthetic */ c(ComputableLiveData computableLiveData) {
        this.f15887a = computableLiveData;
    }

    public final void run() {
        ComputableLiveData.invalidationRunnable$lambda$1(this.f15887a);
    }
}
