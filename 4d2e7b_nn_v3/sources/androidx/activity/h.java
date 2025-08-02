package androidx.activity;

import androidx.activity.result.contract.ActivityResultContract;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity$activityResultRegistry$1 f13818a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f13819b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ActivityResultContract.SynchronousResult f13820c;

    public /* synthetic */ h(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i10, ActivityResultContract.SynchronousResult synchronousResult) {
        this.f13818a = componentActivity$activityResultRegistry$1;
        this.f13819b = i10;
        this.f13820c = synchronousResult;
    }

    public final void run() {
        ComponentActivity$activityResultRegistry$1.onLaunch$lambda$0(this.f13818a, this.f13819b, this.f13820c);
    }
}
