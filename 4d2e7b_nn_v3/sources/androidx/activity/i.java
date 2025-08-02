package androidx.activity;

import android.content.IntentSender;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity$activityResultRegistry$1 f13821a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f13822b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IntentSender.SendIntentException f13823c;

    public /* synthetic */ i(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i10, IntentSender.SendIntentException sendIntentException) {
        this.f13821a = componentActivity$activityResultRegistry$1;
        this.f13822b = i10;
        this.f13823c = sendIntentException;
    }

    public final void run() {
        ComponentActivity$activityResultRegistry$1.onLaunch$lambda$1(this.f13821a, this.f13822b, this.f13823c);
    }
}
