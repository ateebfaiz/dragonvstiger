package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.R;

class CircleImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Animation.AnimationListener f16517a;

    /* renamed from: b  reason: collision with root package name */
    private int f16518b;

    /* renamed from: c  reason: collision with root package name */
    private int f16519c;

    private static class a extends OvalShape {

        /* renamed from: a  reason: collision with root package name */
        private Paint f16520a = new Paint();

        /* renamed from: b  reason: collision with root package name */
        private int f16521b;

        /* renamed from: c  reason: collision with root package name */
        private CircleImageView f16522c;

        a(CircleImageView circleImageView, int i10) {
            this.f16522c = circleImageView;
            this.f16521b = i10;
            a((int) rect().width());
        }

        private void a(int i10) {
            float f10 = (float) (i10 / 2);
            this.f16520a.setShader(new RadialGradient(f10, f10, (float) this.f16521b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP));
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = this.f16522c.getWidth() / 2;
            float f10 = (float) width;
            float height = (float) (this.f16522c.getHeight() / 2);
            canvas.drawCircle(f10, height, f10, this.f16520a);
            canvas.drawCircle(f10, height, (float) (width - this.f16521b), paint);
        }

        /* access modifiers changed from: protected */
        public void onResize(float f10, float f11) {
            super.onResize(f10, f11);
            a((int) f10);
        }
    }

    CircleImageView(Context context) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f10 = getContext().getResources().getDisplayMetrics().density;
        int i10 = (int) (1.75f * f10);
        int i11 = (int) (0.0f * f10);
        this.f16518b = (int) (3.5f * f10);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.SwipeRefreshLayout);
        this.f16519c = obtainStyledAttributes.getColor(R.styleable.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, -328966);
        obtainStyledAttributes.recycle();
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f10 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new a(this, this.f16518b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f16518b, (float) i11, (float) i10, 503316480);
            int i12 = this.f16518b;
            setPadding(i12, i12, i12, i12);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(this.f16519c);
        ViewCompat.setBackground(this, shapeDrawable);
    }

    private boolean a() {
        return true;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.f16517a = animationListener;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f16517a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f16517a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f16518b * 2), getMeasuredHeight() + (this.f16518b * 2));
        }
    }

    public void setBackgroundColor(int i10) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i10);
            this.f16519c = i10;
        }
    }
}
