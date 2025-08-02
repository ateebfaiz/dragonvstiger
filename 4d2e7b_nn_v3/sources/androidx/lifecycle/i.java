package androidx.lifecycle;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProcessLifecycleOwner f15892a;

    public /* synthetic */ i(ProcessLifecycleOwner processLifecycleOwner) {
        this.f15892a = processLifecycleOwner;
    }

    public final void run() {
        ProcessLifecycleOwner.delayedPauseRunnable$lambda$0(this.f15892a);
    }
}
