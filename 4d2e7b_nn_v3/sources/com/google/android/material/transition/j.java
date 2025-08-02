package com.google.android.material.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import androidx.core.graphics.PathParser;
import androidx.transition.PathMotion;
import androidx.transition.PatternPathMotion;
import androidx.transition.Transition;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private static final RectF f8849a = new RectF();

    class a implements ShapeAppearanceModel.CornerSizeUnaryOperator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RectF f8850a;

        a(RectF rectF) {
            this.f8850a = rectF;
        }

        public CornerSize apply(CornerSize cornerSize) {
            if (cornerSize instanceof RelativeCornerSize) {
                return cornerSize;
            }
            return new RelativeCornerSize(cornerSize.getCornerSize(this.f8850a) / this.f8850a.height());
        }
    }

    class b implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RectF f8851a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RectF f8852b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f8853c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f8854d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f8855e;

        b(RectF rectF, RectF rectF2, float f10, float f11, float f12) {
            this.f8851a = rectF;
            this.f8852b = rectF2;
            this.f8853c = f10;
            this.f8854d = f11;
            this.f8855e = f12;
        }

        public CornerSize a(CornerSize cornerSize, CornerSize cornerSize2) {
            return new AbsoluteCornerSize(j.k(cornerSize.getCornerSize(this.f8851a), cornerSize2.getCornerSize(this.f8852b), this.f8853c, this.f8854d, this.f8855e));
        }
    }

    interface c {
        void a(Canvas canvas);
    }

    interface d {
        CornerSize a(CornerSize cornerSize, CornerSize cornerSize2);
    }

    static float a(RectF rectF) {
        return rectF.width() * rectF.height();
    }

    static ShapeAppearanceModel b(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        return shapeAppearanceModel.withTransformedCornerSizes(new a(rectF));
    }

    static Shader c(int i10) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i10, i10, Shader.TileMode.CLAMP);
    }

    static Object d(Object obj, Object obj2) {
        return obj != null ? obj : obj2;
    }

    static View e(View view, int i10) {
        String resourceName = view.getResources().getResourceName(i10);
        while (view != null) {
            if (view.getId() != i10) {
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    static View f(View view, int i10) {
        View findViewById = view.findViewById(i10);
        if (findViewById != null) {
            return findViewById;
        }
        return e(view, i10);
    }

    static RectF g(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        return new RectF((float) i10, (float) i11, (float) (view.getWidth() + i10), (float) (view.getHeight() + i11));
    }

    static RectF h(View view) {
        return new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
    }

    private static boolean i(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        if (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) {
            return false;
        }
        return true;
    }

    static float j(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    static float k(float f10, float f11, float f12, float f13, float f14) {
        return l(f10, f11, f12, f13, f14, false);
    }

    static float l(float f10, float f11, float f12, float f13, float f14, boolean z10) {
        if (z10 && (f14 < 0.0f || f14 > 1.0f)) {
            return j(f10, f11, f14);
        }
        if (f14 < f12) {
            return f10;
        }
        if (f14 > f13) {
            return f11;
        }
        return j(f10, f11, (f14 - f12) / (f13 - f12));
    }

    static int m(int i10, int i11, float f10, float f11, float f12) {
        if (f12 < f10) {
            return i10;
        }
        if (f12 > f11) {
            return i11;
        }
        return (int) j((float) i10, (float) i11, (f12 - f10) / (f11 - f10));
    }

    static ShapeAppearanceModel n(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, float f10, float f11, float f12) {
        if (f12 < f10) {
            return shapeAppearanceModel;
        }
        if (f12 > f11) {
            return shapeAppearanceModel2;
        }
        return u(shapeAppearanceModel, shapeAppearanceModel2, rectF, new b(rectF, rectF2, f10, f11, f12));
    }

    static boolean o(Transition transition, Context context, int i10) {
        int resolveThemeDuration;
        if (i10 == 0 || transition.getDuration() != -1 || (resolveThemeDuration = MotionUtils.resolveThemeDuration(context, i10, -1)) == -1) {
            return false;
        }
        transition.setDuration((long) resolveThemeDuration);
        return true;
    }

    static boolean p(Transition transition, Context context, int i10, TimeInterpolator timeInterpolator) {
        if (i10 == 0 || transition.getInterpolator() != null) {
            return false;
        }
        transition.setInterpolator(MotionUtils.resolveThemeInterpolator(context, i10, timeInterpolator));
        return true;
    }

    static boolean q(Transition transition, Context context, int i10) {
        PathMotion r10;
        if (i10 == 0 || (r10 = r(context, i10)) == null) {
            return false;
        }
        transition.setPathMotion(r10);
        return true;
    }

    static PathMotion r(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.type;
        if (i11 == 16) {
            int i12 = typedValue.data;
            if (i12 == 0) {
                return null;
            }
            if (i12 == 1) {
                return new MaterialArcMotion();
            }
            throw new IllegalArgumentException("Invalid motion path type: " + i12);
        } else if (i11 == 3) {
            return new PatternPathMotion(PathParser.createPathFromPathData(String.valueOf(typedValue.string)));
        } else {
            throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
        }
    }

    private static int s(Canvas canvas, Rect rect, int i10) {
        RectF rectF = f8849a;
        rectF.set(rect);
        return canvas.saveLayerAlpha(rectF, i10);
    }

    static void t(Canvas canvas, Rect rect, float f10, float f11, float f12, int i10, c cVar) {
        if (i10 > 0) {
            int save = canvas.save();
            canvas.translate(f10, f11);
            canvas.scale(f12, f12);
            if (i10 < 255) {
                s(canvas, rect, i10);
            }
            cVar.a(canvas);
            canvas.restoreToCount(save);
        }
    }

    static ShapeAppearanceModel u(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, d dVar) {
        ShapeAppearanceModel shapeAppearanceModel3;
        if (i(shapeAppearanceModel, rectF)) {
            shapeAppearanceModel3 = shapeAppearanceModel;
        } else {
            shapeAppearanceModel3 = shapeAppearanceModel2;
        }
        return shapeAppearanceModel3.toBuilder().setTopLeftCornerSize(dVar.a(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(dVar.a(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(dVar.a(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(dVar.a(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
    }
}
