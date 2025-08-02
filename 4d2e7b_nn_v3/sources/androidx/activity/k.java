package androidx.activity;

import androidx.activity.ComponentActivity;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f13825a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f13826b;

    public /* synthetic */ k(ComponentActivity componentActivity, OnBackPressedDispatcher onBackPressedDispatcher) {
        this.f13825a = componentActivity;
        this.f13826b = onBackPressedDispatcher;
    }

    public final void run() {
        ComponentActivity.g.f(this.f13825a, this.f13826b);
    }
}
