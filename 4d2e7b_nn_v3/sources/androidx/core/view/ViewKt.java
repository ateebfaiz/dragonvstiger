package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.sequences.Sequence;
import kotlin.sequences.h;

public final class ViewKt {

    /* synthetic */ class a extends j implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15176a = new a();

        a() {
            super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
        }

        /* renamed from: c */
        public final ViewParent invoke(ViewParent viewParent) {
            return viewParent.getParent();
        }
    }

    public static final void doOnAttach(View view, Function1<? super View, Unit> function1) {
        if (view.isAttachedToWindow()) {
            function1.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewKt$doOnAttach$1(view, function1));
        }
    }

    public static final void doOnDetach(View view, Function1<? super View, Unit> function1) {
        if (!view.isAttachedToWindow()) {
            function1.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewKt$doOnDetach$1(view, function1));
        }
    }

    public static final void doOnLayout(View view, Function1<? super View, Unit> function1) {
        if (!view.isLaidOut() || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(function1));
        } else {
            function1.invoke(view);
        }
    }

    public static final void doOnNextLayout(View view, Function1<? super View, Unit> function1) {
        view.addOnLayoutChangeListener(new ViewKt$doOnNextLayout$1(function1));
    }

    public static final OneShotPreDrawListener doOnPreDraw(View view, Function1<? super View, Unit> function1) {
        return OneShotPreDrawListener.add(view, new ViewKt$doOnPreDraw$1(function1, view));
    }

    public static final Bitmap drawToBitmap(View view, Bitmap.Config config) {
        if (view.isLaidOut()) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-((float) view.getScrollX()), -((float) view.getScrollY()));
            view.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final Sequence<View> getAllViews(View view) {
        return h.b(new ViewKt$allViews$1(view, (d) null));
    }

    public static final Sequence<ViewParent> getAncestors(View view) {
        return h.e(view.getParent(), a.f15176a);
    }

    public static final int getMarginBottom(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
        }
        return 0;
    }

    public static final int getMarginLeft(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart();
        }
        return 0;
    }

    public static final int getMarginTop(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(View view) {
        if (view.getVisibility() == 8) {
            return true;
        }
        return false;
    }

    public static final boolean isInvisible(View view) {
        if (view.getVisibility() == 4) {
            return true;
        }
        return false;
    }

    public static final boolean isVisible(View view) {
        if (view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public static final Runnable postDelayed(View view, long j10, Function0<Unit> function0) {
        ViewKt$postDelayed$runnable$1 viewKt$postDelayed$runnable$1 = new ViewKt$postDelayed$runnable$1(function0);
        view.postDelayed(viewKt$postDelayed$runnable$1, j10);
        return viewKt$postDelayed$runnable$1;
    }

    public static final Runnable postOnAnimationDelayed(View view, long j10, Function0<Unit> function0) {
        m0 m0Var = new m0(function0);
        view.postOnAnimationDelayed(m0Var, j10);
        return m0Var;
    }

    /* access modifiers changed from: private */
    public static final void postOnAnimationDelayed$lambda$1(Function0 function0) {
        function0.invoke();
    }

    public static final void setGone(View view, boolean z10) {
        int i10;
        if (z10) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        view.setVisibility(i10);
    }

    public static final void setInvisible(View view, boolean z10) {
        int i10;
        if (z10) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        view.setVisibility(i10);
    }

    public static final void setPadding(View view, @Px int i10) {
        view.setPadding(i10, i10, i10, i10);
    }

    public static final void setVisible(View view, boolean z10) {
        int i10;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        view.setVisibility(i10);
    }

    public static final void updateLayoutParams(View view, Function1<? super ViewGroup.LayoutParams, Unit> function1) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            function1.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, Function1<? super T, Unit> function1) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        m.k(1, ExifInterface.GPS_DIRECTION_TRUE);
        function1.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(View view, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        view.setPadding(i10, i11, i12, i13);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = view.getPaddingLeft();
        }
        if ((i14 & 2) != 0) {
            i11 = view.getPaddingTop();
        }
        if ((i14 & 4) != 0) {
            i12 = view.getPaddingRight();
        }
        if ((i14 & 8) != 0) {
            i13 = view.getPaddingBottom();
        }
        view.setPadding(i10, i11, i12, i13);
    }

    public static final void updatePaddingRelative(View view, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        view.setPaddingRelative(i10, i11, i12, i13);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = view.getPaddingStart();
        }
        if ((i14 & 2) != 0) {
            i11 = view.getPaddingTop();
        }
        if ((i14 & 4) != 0) {
            i12 = view.getPaddingEnd();
        }
        if ((i14 & 8) != 0) {
            i13 = view.getPaddingBottom();
        }
        view.setPaddingRelative(i10, i11, i12, i13);
    }
}
