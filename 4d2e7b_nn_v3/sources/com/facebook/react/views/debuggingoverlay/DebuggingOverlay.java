package com.facebook.react.views.debuggingoverlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.UiThread;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.m;
import r7.a;
import r7.b;

public final class DebuggingOverlay extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f3979a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap f3980b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap f3981c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Paint f3982d;

    /* renamed from: e  reason: collision with root package name */
    private List f3983e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DebuggingOverlay(Context context) {
        super(context);
        m.f(context, "context");
        Paint paint = new Paint();
        this.f3979a = paint;
        Paint paint2 = new Paint();
        this.f3982d = paint2;
        this.f3983e = new ArrayList();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6.0f);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(-859248897);
    }

    /* access modifiers changed from: private */
    public static final void c(DebuggingOverlay debuggingOverlay, int i10) {
        m.f(debuggingOverlay, "this$0");
        debuggingOverlay.f3980b.remove(Integer.valueOf(i10));
        debuggingOverlay.f3981c.remove(Integer.valueOf(i10));
        debuggingOverlay.invalidate();
    }

    public final void b() {
        this.f3983e.clear();
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        m.f(canvas, "canvas");
        super.onDraw(canvas);
        for (b bVar : this.f3980b.values()) {
            this.f3979a.setColor(bVar.a());
            canvas.drawRect(bVar.c(), this.f3979a);
            int b10 = bVar.b();
            a aVar = new a(this, b10);
            if (!this.f3981c.containsKey(Integer.valueOf(b10))) {
                this.f3981c.put(Integer.valueOf(b10), aVar);
                UiThreadUtil.runOnUiThread(aVar, 2000);
            }
        }
        for (RectF drawRect : this.f3983e) {
            canvas.drawRect(drawRect, this.f3982d);
        }
    }

    @UiThread
    public final void setHighlightedElementsRectangles(List<RectF> list) {
        m.f(list, "elementsRectangles");
        this.f3983e = list;
        invalidate();
    }

    @UiThread
    public final void setTraceUpdates(List<b> list) {
        m.f(list, "traceUpdates");
        for (b next : list) {
            int b10 = next.b();
            if (this.f3981c.containsKey(Integer.valueOf(b10))) {
                UiThreadUtil.removeOnUiThread((Runnable) this.f3981c.get(Integer.valueOf(b10)));
                this.f3981c.remove(Integer.valueOf(b10));
            }
            this.f3980b.put(Integer.valueOf(b10), next);
        }
        invalidate();
    }
}
