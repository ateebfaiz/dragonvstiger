package androidx.activity;

import androidx.activity.ComponentActivity;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f13824a;

    public /* synthetic */ j(ComponentActivity componentActivity) {
        this.f13824a = componentActivity;
    }

    public final void run() {
        ComponentActivity.g.d(this.f13824a);
    }
}
