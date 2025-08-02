package androidx.core.content.res;

import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f14904a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f14905b;

    public /* synthetic */ e(ResourcesCompat.FontCallback fontCallback, int i10) {
        this.f14904a = fontCallback;
        this.f14905b = i10;
    }

    public final void run() {
        this.f14904a.lambda$callbackFailAsync$1(this.f14905b);
    }
}
