package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f16706a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f16707b = true;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f16708c;

    static class a implements TypeEvaluator {

        /* renamed from: a  reason: collision with root package name */
        final float[] f16709a = new float[9];

        /* renamed from: b  reason: collision with root package name */
        final float[] f16710b = new float[9];

        /* renamed from: c  reason: collision with root package name */
        final Matrix f16711c = new Matrix();

        a() {
        }

        /* renamed from: a */
        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f16709a);
            matrix2.getValues(this.f16710b);
            for (int i10 = 0; i10 < 9; i10++) {
                float[] fArr = this.f16710b;
                float f11 = fArr[i10];
                float f12 = this.f16709a[i10];
                fArr[i10] = f12 + ((f11 - f12) * f10);
            }
            this.f16711c.setValues(this.f16710b);
            return this.f16711c;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = true;
        if (i10 < 28) {
            z10 = false;
        }
        f16708c = z10;
    }

    static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        b0.j(view, matrix);
        b0.k(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap b10 = b(view, matrix, rectF, viewGroup);
        if (b10 != null) {
            imageView.setImageBitmap(b10);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    private static Bitmap b(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z10;
        boolean z11;
        int i10;
        ViewGroup viewGroup2;
        if (f16706a) {
            z11 = !view.isAttachedToWindow();
            if (viewGroup == null) {
                z10 = false;
            } else {
                z10 = viewGroup.isAttachedToWindow();
            }
        } else {
            z11 = false;
            z10 = false;
        }
        boolean z12 = f16707b;
        Bitmap bitmap = null;
        if (!z12 || !z11) {
            i10 = 0;
            viewGroup2 = null;
        } else if (!z10) {
            return null;
        } else {
            viewGroup2 = (ViewGroup) view.getParent();
            i10 = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        }
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (round > 0 && round2 > 0) {
            float min = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
            int round3 = Math.round(((float) round) * min);
            int round4 = Math.round(((float) round2) * min);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(min, min);
            if (f16708c) {
                Picture picture = new Picture();
                Canvas beginRecording = picture.beginRecording(round3, round4);
                beginRecording.concat(matrix);
                view.draw(beginRecording);
                picture.endRecording();
                bitmap = Bitmap.createBitmap(picture);
            } else {
                bitmap = Bitmap.createBitmap(round3, round4, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.concat(matrix);
                view.draw(canvas);
            }
        }
        if (z12 && z11) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, i10);
        }
        return bitmap;
    }

    static Animator c(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }
}
