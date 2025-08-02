package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;

@SuppressLint({"ViewConstructor"})
class GhostViewPort extends ViewGroup implements f {

    /* renamed from: a  reason: collision with root package name */
    ViewGroup f16631a;

    /* renamed from: b  reason: collision with root package name */
    View f16632b;

    /* renamed from: c  reason: collision with root package name */
    final View f16633c;

    /* renamed from: d  reason: collision with root package name */
    int f16634d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f16635e;

    /* renamed from: f  reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f16636f = new a();

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        public boolean onPreDraw() {
            View view;
            ViewCompat.postInvalidateOnAnimation(GhostViewPort.this);
            GhostViewPort ghostViewPort = GhostViewPort.this;
            ViewGroup viewGroup = ghostViewPort.f16631a;
            if (viewGroup == null || (view = ghostViewPort.f16632b) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            ViewCompat.postInvalidateOnAnimation(GhostViewPort.this.f16631a);
            GhostViewPort ghostViewPort2 = GhostViewPort.this;
            ghostViewPort2.f16631a = null;
            ghostViewPort2.f16632b = null;
            return true;
        }
    }

    GhostViewPort(View view) {
        super(view.getContext());
        this.f16633c = view;
        setWillNotDraw(false);
        setLayerType(2, (Paint) null);
    }

    static GhostViewPort b(View view, ViewGroup viewGroup, Matrix matrix) {
        int i10;
        GhostViewHolder ghostViewHolder;
        if (view.getParent() instanceof ViewGroup) {
            GhostViewHolder b10 = GhostViewHolder.b(viewGroup);
            GhostViewPort e10 = e(view);
            if (e10 == null || (ghostViewHolder = (GhostViewHolder) e10.getParent()) == b10) {
                i10 = 0;
            } else {
                i10 = e10.f16634d;
                ghostViewHolder.removeView(e10);
                e10 = null;
            }
            if (e10 == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    c(view, viewGroup, matrix);
                }
                e10 = new GhostViewPort(view);
                e10.h(matrix);
                if (b10 == null) {
                    b10 = new GhostViewHolder(viewGroup);
                } else {
                    b10.g();
                }
                d(viewGroup, b10);
                d(viewGroup, e10);
                b10.a(e10);
                e10.f16634d = i10;
            } else if (matrix != null) {
                e10.h(matrix);
            }
            e10.f16634d++;
            return e10;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    static void c(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        b0.j(viewGroup2, matrix);
        matrix.preTranslate((float) (-viewGroup2.getScrollX()), (float) (-viewGroup2.getScrollY()));
        b0.k(viewGroup, matrix);
    }

    static void d(View view, View view2) {
        b0.g(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static GhostViewPort e(View view) {
        return (GhostViewPort) view.getTag(R.id.ghost_view);
    }

    static void f(View view) {
        GhostViewPort e10 = e(view);
        if (e10 != null) {
            int i10 = e10.f16634d - 1;
            e10.f16634d = i10;
            if (i10 <= 0) {
                ((GhostViewHolder) e10.getParent()).removeView(e10);
            }
        }
    }

    static void g(View view, GhostViewPort ghostViewPort) {
        view.setTag(R.id.ghost_view, ghostViewPort);
    }

    public void a(ViewGroup viewGroup, View view) {
        this.f16631a = viewGroup;
        this.f16632b = view;
    }

    /* access modifiers changed from: package-private */
    public void h(Matrix matrix) {
        this.f16635e = matrix;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g(this.f16633c, this);
        this.f16633c.getViewTreeObserver().addOnPreDrawListener(this.f16636f);
        b0.i(this.f16633c, 4);
        if (this.f16633c.getParent() != null) {
            ((View) this.f16633c.getParent()).invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f16633c.getViewTreeObserver().removeOnPreDrawListener(this.f16636f);
        b0.i(this.f16633c, 0);
        g(this.f16633c, (GhostViewPort) null);
        if (this.f16633c.getParent() != null) {
            ((View) this.f16633c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        d.a(canvas, true);
        canvas.setMatrix(this.f16635e);
        b0.i(this.f16633c, 0);
        this.f16633c.invalidate();
        b0.i(this.f16633c, 4);
        drawChild(canvas, this.f16633c, getDrawingTime());
        d.a(canvas, false);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    public void setVisibility(int i10) {
        int i11;
        super.setVisibility(i10);
        if (e(this.f16633c) == this) {
            if (i10 == 0) {
                i11 = 4;
            } else {
                i11 = 0;
            }
            b0.i(this.f16633c, i11);
        }
    }
}
