package androidx.lifecycle;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DispatchQueue f15888a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f15889b;

    public /* synthetic */ e(DispatchQueue dispatchQueue, Runnable runnable) {
        this.f15888a = dispatchQueue;
        this.f15889b = runnable;
    }

    public final void run() {
        DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1(this.f15888a, this.f15889b);
    }
}
