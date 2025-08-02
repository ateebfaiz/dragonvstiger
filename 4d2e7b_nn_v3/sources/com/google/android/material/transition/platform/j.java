package com.google.android.material.transition.platform;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import androidx.core.graphics.PathParser;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private static final RectF f8942a = new RectF();

    class a implements ShapeAppearanceModel.CornerSizeUnaryOperator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RectF f8943a;

        a(RectF rectF) {
            this.f8943a = rectF;
        }

        public CornerSize apply(CornerSize cornerSize) {
            if (cornerSize instanceof RelativeCornerSize) {
                return cornerSize;
            }
            return new RelativeCornerSize(cornerSize.getCornerSize(this.f8943a) / this.f8943a.height());
        }
    }

    class b implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RectF f8944a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RectF f8945b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f8946c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f8947d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f8948e;

        b(RectF rectF, RectF rectF2, float f10, float f11, float f12) {
            this.f8944a = rectF;
            this.f8945b = rectF2;
            this.f8946c = f10;
            this.f8947d = f11;
            this.f8948e = f12;
        }

        public CornerSize a(CornerSize cornerSize, CornerSize cornerSize2) {
            return new AbsoluteCornerSize(j.l(cornerSize.getCornerSize(this.f8944a), cornerSize2.getCornerSize(this.f8945b), this.f8946c, this.f8947d, this.f8948e));
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

    static Rect i(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private static boolean j(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        if (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) {
            return false;
        }
        return true;
    }

    static float k(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    static float l(float f10, float f11, float f12, float f13, float f14) {
        return m(f10, f11, f12, f13, f14, false);
    }

    static float m(float f10, float f11, float f12, float f13, float f14, boolean z10) {
        if (z10 && (f14 < 0.0f || f14 > 1.0f)) {
            return k(f10, f11, f14);
        }
        if (f14 < f12) {
            return f10;
        }
        if (f14 > f13) {
            return f11;
        }
        return k(f10, f11, (f14 - f12) / (f13 - f12));
    }

    static int n(int i10, int i11, float f10, float f11, float f12) {
        if (f12 < f10) {
            return i10;
        }
        if (f12 > f11) {
            return i11;
        }
        return (int) k((float) i10, (float) i11, (f12 - f10) / (f11 - f10));
    }

    static ShapeAppearanceModel o(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, float f10, float f11, float f12) {
        if (f12 < f10) {
            return shapeAppearanceModel;
        }
        if (f12 > f11) {
            return shapeAppearanceModel2;
        }
        return v(shapeAppearanceModel, shapeAppearanceModel2, rectF, new b(rectF, rectF2, f10, f11, f12));
    }

    static boolean p(Transition transition, Context context, int i10) {
        int resolveThemeDuration;
        if (i10 == 0 || transition.getDuration() != -1 || (resolveThemeDuration = MotionUtils.resolveThemeDuration(context, i10, -1)) == -1) {
            return false;
        }
        transition.setDuration((long) resolveThemeDuration);
        return true;
    }

    static boolean q(Transition transition, Context context, int i10, TimeInterpolator timeInterpolator) {
        if (i10 == 0 || transition.getInterpolator() != null) {
            return false;
        }
        transition.setInterpolator(MotionUtils.resolveThemeInterpolator(context, i10, timeInterpolator));
        return true;
    }

    static boolean r(Transition transition, Context context, int i10) {
        PathMotion s10;
        if (i10 == 0 || (s10 = s(context, i10)) == null) {
            return false;
        }
        transition.setPathMotion(s10);
        return true;
    }

    static PathMotion s(Context context, int i10) {
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

    private static int t(Canvas canvas, Rect rect, int i10) {
        RectF rectF = f8942a;
        rectF.set(rect);
        return canvas.saveLayerAlpha(rectF, i10);
    }

    static void u(Canvas canvas, Rect rect, float f10, float f11, float f12, int i10, c cVar) {
        if (i10 > 0) {
            int save = canvas.save();
            canvas.translate(f10, f11);
            canvas.scale(f12, f12);
            if (i10 < 255) {
                t(canvas, rect, i10);
            }
            cVar.a(canvas);
            canvas.restoreToCount(save);
        }
    }

    static ShapeAppearanceModel v(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, d dVar) {
        ShapeAppearanceModel shapeAppearanceModel3;
        if (j(shapeAppearanceModel, rectF)) {
            shapeAppearanceModel3 = shapeAppearanceModel;
        } else {
            shapeAppearanceModel3 = shapeAppearanceModel2;
        }
        return shapeAppearanceModel3.toBuilder().setTopLeftCornerSize(dVar.a(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(dVar.a(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(dVar.a(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(dVar.a(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
    }
}
