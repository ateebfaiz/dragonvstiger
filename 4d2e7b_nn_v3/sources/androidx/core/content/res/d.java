package androidx.core.content.res;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f14902a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Typeface f14903b;

    public /* synthetic */ d(ResourcesCompat.FontCallback fontCallback, Typeface typeface) {
        this.f14902a = fontCallback;
        this.f14903b = typeface;
    }

    public final void run() {
        this.f14902a.lambda$callbackSuccessAsync$0(this.f14903b);
    }
}
