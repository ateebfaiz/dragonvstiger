package w7;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.k1;
import com.facebook.react.views.view.g;
import kotlin.jvm.internal.m;

public final class d extends ClickableSpan implements e {

    /* renamed from: a  reason: collision with root package name */
    private final int f13199a;

    public d(int i10) {
        this.f13199a = i10;
    }

    public void onClick(View view) {
        m.f(view, "view");
        Context context = view.getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        e c10 = k1.c(reactContext, this.f13199a);
        if (c10 != null) {
            c10.c(new g(k1.e(reactContext), this.f13199a));
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        m.f(textPaint, "ds");
    }
}
