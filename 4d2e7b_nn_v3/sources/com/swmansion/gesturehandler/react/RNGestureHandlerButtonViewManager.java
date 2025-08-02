package com.swmansion.gesturehandler.react;

import ab.d;
import ab.o;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.g0;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.sequences.Sequence;
import p7.p;
import p7.q;

@s6.a(name = "RNGestureHandlerButton")
public final class RNGestureHandlerButtonViewManager extends ViewGroupManager<ButtonViewGroup> implements q {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNGestureHandlerButton";
    private final c2 mDelegate = new p(this);

    public static final class ButtonViewGroup extends ViewGroup implements o.d {
        public static final a U0 = new a((DefaultConstructorMarker) null);
        private static TypedValue V0 = new TypedValue();
        private static ButtonViewGroup W0;
        private static ButtonViewGroup X0;
        private static View.OnClickListener Y0 = new b();
        private String C = "solid";
        private boolean N0 = true;
        private int O0;
        private boolean P0;
        private long Q0 = -1;
        private int R0 = -1;
        private boolean S0;
        private boolean T0;

        /* renamed from: a  reason: collision with root package name */
        private Integer f11365a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f11366b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f11367c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f11368d;

        /* renamed from: e  reason: collision with root package name */
        private float f11369e;

        /* renamed from: f  reason: collision with root package name */
        private float f11370f;

        /* renamed from: g  reason: collision with root package name */
        private float f11371g;

        /* renamed from: h  reason: collision with root package name */
        private float f11372h;

        /* renamed from: i  reason: collision with root package name */
        private float f11373i;

        /* renamed from: j  reason: collision with root package name */
        private float f11374j;

        /* renamed from: w  reason: collision with root package name */
        private Integer f11375w;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ButtonViewGroup(Context context) {
            super(context);
            setOnClickListener(Y0);
            setClickable(true);
            setFocusable(true);
            this.P0 = true;
            setClipChildren(false);
        }

        private final boolean getHasBorderRadii() {
            if (this.f11369e == 0.0f && this.f11370f == 0.0f && this.f11371g == 0.0f && this.f11372h == 0.0f && this.f11373i == 0.0f) {
                return false;
            }
            return true;
        }

        private final float[] j() {
            float f10 = this.f11370f;
            float f11 = this.f11371g;
            float f12 = this.f11373i;
            float f13 = this.f11372h;
            float[] fArr = {f10, f10, f11, f11, f12, f12, f13, f13};
            ArrayList arrayList = new ArrayList(8);
            for (int i10 = 0; i10 < 8; i10++) {
                float f14 = fArr[i10];
                if (f14 == 0.0f) {
                    f14 = this.f11369e;
                }
                arrayList.add(Float.valueOf(f14));
            }
            return r.v0(arrayList);
        }

        private final PathEffect k() {
            String str = this.C;
            if (m.b(str, "dotted")) {
                float f10 = this.f11374j;
                return new DashPathEffect(new float[]{f10, f10, f10, f10}, 0.0f);
            } else if (!m.b(str, "dashed")) {
                return null;
            } else {
                float f11 = this.f11374j;
                float f12 = (float) 3;
                return new DashPathEffect(new float[]{f11 * f12, f11 * f12, f11 * f12, f11 * f12}, 0.0f);
            }
        }

        private final Drawable l() {
            int i10;
            PaintDrawable paintDrawable = new PaintDrawable(0);
            if (getHasBorderRadii()) {
                paintDrawable.setCornerRadii(j());
            }
            if (this.f11374j > 0.0f) {
                Paint paint = paintDrawable.getPaint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(this.f11374j);
                Integer num = this.f11375w;
                if (num != null) {
                    i10 = num.intValue();
                } else {
                    i10 = ViewCompat.MEASURED_STATE_MASK;
                }
                paint.setColor(i10);
                paint.setPathEffect(k());
            }
            return paintDrawable;
        }

        private final Drawable m() {
            ColorStateList colorStateList;
            ShapeDrawable shapeDrawable;
            Integer num = this.f11365a;
            if (num != null && num.intValue() == 0) {
                return null;
            }
            int[][] iArr = {new int[]{16842910}};
            Integer num2 = this.f11366b;
            Integer num3 = this.f11365a;
            if (num3 != null) {
                m.c(num3);
                colorStateList = new ColorStateList(iArr, new int[]{num3.intValue()});
            } else {
                getContext().getTheme().resolveAttribute(16843820, V0, true);
                colorStateList = new ColorStateList(iArr, new int[]{V0.data});
            }
            if (this.f11368d) {
                shapeDrawable = null;
            } else {
                shapeDrawable = new ShapeDrawable(new RectShape());
            }
            RippleDrawable rippleDrawable = new RippleDrawable(colorStateList, (Drawable) null, shapeDrawable);
            if (num2 != null) {
                rippleDrawable.setRadius((int) g0.d((float) num2.intValue()));
            }
            return rippleDrawable;
        }

        /* access modifiers changed from: private */
        public static final void n(View view) {
        }

        private final RNGestureHandlerRootView o() {
            RNGestureHandlerRootView rNGestureHandlerRootView = null;
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof RNGestureHandlerRootView) {
                    rNGestureHandlerRootView = (RNGestureHandlerRootView) parent;
                }
            }
            return rNGestureHandlerRootView;
        }

        private final boolean p(Sequence sequence) {
            Iterator it = sequence.iterator();
            while (it.hasNext()) {
                View view = (View) it.next();
                if (view instanceof ButtonViewGroup) {
                    ButtonViewGroup buttonViewGroup = (ButtonViewGroup) view;
                    if (buttonViewGroup.T0 || buttonViewGroup.isPressed()) {
                        return true;
                    }
                }
                if ((view instanceof ViewGroup) && p(ViewGroupKt.getChildren((ViewGroup) view))) {
                    return true;
                }
            }
            return false;
        }

        static /* synthetic */ boolean q(ButtonViewGroup buttonViewGroup, Sequence<View> sequence, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                sequence = ViewGroupKt.getChildren(buttonViewGroup);
            }
            return buttonViewGroup.p(sequence);
        }

        private final void r() {
            if (W0 == this) {
                W0 = null;
                X0 = this;
            }
        }

        private final boolean s() {
            boolean z10;
            if (q(this, (Sequence) null, 1, (Object) null)) {
                return false;
            }
            ButtonViewGroup buttonViewGroup = W0;
            if (buttonViewGroup == null) {
                W0 = this;
                return true;
            }
            if (!this.N0) {
                if (buttonViewGroup != null) {
                    z10 = buttonViewGroup.N0;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    return true;
                }
            } else if (buttonViewGroup == this) {
                return true;
            }
            return false;
        }

        private final void u(int i10, Drawable drawable, Drawable drawable2) {
            PaintDrawable paintDrawable = new PaintDrawable(i10);
            if (getHasBorderRadii()) {
                paintDrawable.setCornerRadii(j());
            }
            setBackground(new LayerDrawable(drawable2 != null ? new Drawable[]{paintDrawable, drawable2, drawable} : new Drawable[]{paintDrawable, drawable}));
        }

        public boolean a() {
            return o.d.a.f(this);
        }

        public Boolean b(d dVar) {
            return o.d.a.g(this, dVar);
        }

        public boolean c(MotionEvent motionEvent) {
            m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1 || motionEvent.getActionMasked() == 6) {
                return false;
            }
            boolean s10 = s();
            if (s10) {
                this.T0 = true;
            }
            return s10;
        }

        public boolean d() {
            return o.d.a.h(this);
        }

        public void dispatchDrawableHotspotChanged(float f10, float f11) {
        }

        public void drawableHotspotChanged(float f10, float f11) {
            ButtonViewGroup buttonViewGroup = W0;
            if (buttonViewGroup == null || buttonViewGroup == this) {
                super.drawableHotspotChanged(f10, f11);
            }
        }

        public boolean e(View view) {
            return o.d.a.b(this, view);
        }

        public void f(MotionEvent motionEvent) {
            o.d.a.d(this, motionEvent);
        }

        public Boolean g(View view, MotionEvent motionEvent) {
            return o.d.a.e(this, view, motionEvent);
        }

        public final float getBorderBottomLeftRadius() {
            return this.f11372h;
        }

        public final float getBorderBottomRightRadius() {
            return this.f11373i;
        }

        public final Integer getBorderColor() {
            return this.f11375w;
        }

        public final float getBorderRadius() {
            return this.f11369e;
        }

        public final String getBorderStyle() {
            return this.C;
        }

        public final float getBorderTopLeftRadius() {
            return this.f11370f;
        }

        public final float getBorderTopRightRadius() {
            return this.f11371g;
        }

        public final float getBorderWidth() {
            return this.f11374j;
        }

        public final boolean getExclusive() {
            return this.N0;
        }

        public final Integer getRippleColor() {
            return this.f11365a;
        }

        public final Integer getRippleRadius() {
            return this.f11366b;
        }

        public final boolean getUseBorderlessDrawable() {
            return this.f11368d;
        }

        public final boolean getUseDrawableOnForeground() {
            return this.f11367c;
        }

        public void h(MotionEvent motionEvent) {
            m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            r();
            this.T0 = false;
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            m.f(accessibilityNodeInfo, "info");
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            Object tag = super.getTag(com.facebook.react.m.f20860q);
            if (tag instanceof String) {
                accessibilityNodeInfo.setViewIdResourceName((String) tag);
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            m.f(motionEvent, "ev");
            if (super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            onTouchEvent(motionEvent);
            return isPressed();
        }

        public boolean onKeyUp(int i10, KeyEvent keyEvent) {
            this.S0 = true;
            return super.onKeyUp(i10, keyEvent);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            long eventTime = motionEvent.getEventTime();
            int action = motionEvent.getAction();
            ButtonViewGroup buttonViewGroup = W0;
            if (!(buttonViewGroup == null || buttonViewGroup == this)) {
                m.c(buttonViewGroup);
                if (buttonViewGroup.N0) {
                    if (isPressed()) {
                        setPressed(false);
                    }
                    this.Q0 = eventTime;
                    this.R0 = action;
                    return false;
                }
            }
            if (motionEvent.getAction() == 3) {
                r();
            }
            if (this.Q0 == eventTime && this.R0 == action && action != 3) {
                return false;
            }
            this.Q0 = eventTime;
            this.R0 = action;
            return super.onTouchEvent(motionEvent);
        }

        public boolean performClick() {
            if (q(this, (Sequence) null, 1, (Object) null)) {
                return false;
            }
            Context context = getContext();
            m.e(context, "getContext(...)");
            if (a.c(context)) {
                RNGestureHandlerRootView o10 = o();
                if (o10 != null) {
                    o10.p(this);
                }
            } else if (this.S0) {
                RNGestureHandlerRootView o11 = o();
                if (o11 != null) {
                    o11.p(this);
                }
                this.S0 = false;
            }
            if (X0 != this) {
                return false;
            }
            r();
            X0 = null;
            return super.performClick();
        }

        public void setBackgroundColor(int i10) {
            this.O0 = i10;
            this.P0 = true;
        }

        public final void setBorderBottomLeftRadius(float f10) {
            this.f11372h = f10 * getResources().getDisplayMetrics().density;
            this.P0 = true;
        }

        public final void setBorderBottomRightRadius(float f10) {
            this.f11373i = f10 * getResources().getDisplayMetrics().density;
            this.P0 = true;
        }

        public final void setBorderColor(Integer num) {
            this.f11375w = num;
            this.P0 = true;
        }

        public final void setBorderRadius(float f10) {
            this.f11369e = f10 * getResources().getDisplayMetrics().density;
            this.P0 = true;
        }

        public final void setBorderStyle(String str) {
            this.C = str;
            this.P0 = true;
        }

        public final void setBorderTopLeftRadius(float f10) {
            this.f11370f = f10 * getResources().getDisplayMetrics().density;
            this.P0 = true;
        }

        public final void setBorderTopRightRadius(float f10) {
            this.f11371g = f10 * getResources().getDisplayMetrics().density;
            this.P0 = true;
        }

        public final void setBorderWidth(float f10) {
            this.f11374j = f10 * getResources().getDisplayMetrics().density;
            this.P0 = true;
        }

        public final void setExclusive(boolean z10) {
            this.N0 = z10;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
            if (q(r3, (kotlin.sequences.Sequence) null, 1, (java.lang.Object) null) != false) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
            if (r0.N0 == true) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void setPressed(boolean r4) {
            /*
                r3 = this;
                if (r4 == 0) goto L_0x000a
                boolean r0 = r3.s()
                if (r0 == 0) goto L_0x000a
                X0 = r3
            L_0x000a:
                boolean r0 = r3.N0
                r1 = 0
                if (r0 != 0) goto L_0x0021
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup r0 = W0
                r2 = 1
                if (r0 == 0) goto L_0x0019
                boolean r0 = r0.N0
                if (r0 != r2) goto L_0x0019
                goto L_0x0021
            L_0x0019:
                r0 = 0
                boolean r0 = q(r3, r0, r2, r0)
                if (r0 != 0) goto L_0x0021
                goto L_0x0022
            L_0x0021:
                r2 = r1
            L_0x0022:
                if (r4 == 0) goto L_0x002a
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup r0 = W0
                if (r0 == r3) goto L_0x002a
                if (r2 == 0) goto L_0x002f
            L_0x002a:
                r3.T0 = r4
                super.setPressed(r4)
            L_0x002f:
                if (r4 != 0) goto L_0x0037
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup r4 = W0
                if (r4 != r3) goto L_0x0037
                r3.T0 = r1
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager.ButtonViewGroup.setPressed(boolean):void");
        }

        public final void setRippleColor(Integer num) {
            this.f11365a = num;
            this.P0 = true;
        }

        public final void setRippleRadius(Integer num) {
            this.f11366b = num;
            this.P0 = true;
        }

        public final void setTouched(boolean z10) {
            this.T0 = z10;
        }

        public final void setUseBorderlessDrawable(boolean z10) {
            this.f11368d = z10;
        }

        public final void setUseDrawableOnForeground(boolean z10) {
            this.f11367c = z10;
            this.P0 = true;
        }

        public final void t() {
            if (this.P0) {
                this.P0 = false;
                if (this.O0 == 0) {
                    setBackground((Drawable) null);
                }
                setForeground((Drawable) null);
                Drawable m10 = m();
                Drawable l10 = l();
                if (getHasBorderRadii() && (m10 instanceof RippleDrawable)) {
                    PaintDrawable paintDrawable = new PaintDrawable(-1);
                    paintDrawable.setCornerRadii(j());
                    ((RippleDrawable) m10).setDrawableByLayerId(16908334, paintDrawable);
                }
                if (this.f11367c) {
                    setForeground(m10);
                    int i10 = this.O0;
                    if (i10 != 0) {
                        u(i10, l10, (Drawable) null);
                        return;
                    }
                    return;
                }
                int i11 = this.O0;
                if (i11 == 0 && this.f11365a == null) {
                    setBackground(new LayerDrawable(new Drawable[]{m10, l10}));
                    return;
                }
                u(i11, l10, m10);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.mDelegate;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        com.facebook.react.uimanager.p.a(this, view);
    }

    public ButtonViewGroup createViewInstance(e1 e1Var) {
        m.f(e1Var, "context");
        return new ButtonViewGroup(e1Var);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ButtonViewGroup buttonViewGroup) {
        m.f(buttonViewGroup, "view");
        super.onAfterUpdateTransaction(buttonViewGroup);
        buttonViewGroup.t();
    }

    @h7.a(name = "backgroundColor")
    public void setBackgroundColor(ButtonViewGroup buttonViewGroup, int i10) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setBackgroundColor(i10);
    }

    @h7.a(name = "borderBottomLeftRadius")
    public void setBorderBottomLeftRadius(ButtonViewGroup buttonViewGroup, float f10) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setBorderBottomLeftRadius(f10);
    }

    @h7.a(name = "borderBottomRightRadius")
    public void setBorderBottomRightRadius(ButtonViewGroup buttonViewGroup, float f10) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setBorderBottomRightRadius(f10);
    }

    @h7.a(name = "borderColor")
    public void setBorderColor(ButtonViewGroup buttonViewGroup, Integer num) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setBorderColor(num);
    }

    @h7.a(name = "borderRadius")
    public void setBorderRadius(ButtonViewGroup buttonViewGroup, float f10) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setBorderRadius(f10);
    }

    @h7.a(name = "borderStyle")
    public void setBorderStyle(ButtonViewGroup buttonViewGroup, String str) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setBorderStyle(str);
    }

    @h7.a(name = "borderTopLeftRadius")
    public void setBorderTopLeftRadius(ButtonViewGroup buttonViewGroup, float f10) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setBorderTopLeftRadius(f10);
    }

    @h7.a(name = "borderTopRightRadius")
    public void setBorderTopRightRadius(ButtonViewGroup buttonViewGroup, float f10) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setBorderTopRightRadius(f10);
    }

    @h7.a(name = "borderWidth")
    public void setBorderWidth(ButtonViewGroup buttonViewGroup, float f10) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setBorderWidth(f10);
    }

    @h7.a(name = "borderless")
    public void setBorderless(ButtonViewGroup buttonViewGroup, boolean z10) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setUseBorderlessDrawable(z10);
    }

    @h7.a(name = "enabled")
    public void setEnabled(ButtonViewGroup buttonViewGroup, boolean z10) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setEnabled(z10);
    }

    @h7.a(name = "exclusive")
    public void setExclusive(ButtonViewGroup buttonViewGroup, boolean z10) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setExclusive(z10);
    }

    @TargetApi(23)
    @h7.a(name = "foreground")
    public void setForeground(ButtonViewGroup buttonViewGroup, boolean z10) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setUseDrawableOnForeground(z10);
    }

    @h7.a(name = "rippleColor")
    public void setRippleColor(ButtonViewGroup buttonViewGroup, Integer num) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setRippleColor(num);
    }

    @h7.a(name = "rippleRadius")
    public void setRippleRadius(ButtonViewGroup buttonViewGroup, int i10) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setRippleRadius(Integer.valueOf(i10));
    }

    @h7.a(name = "touchSoundDisabled")
    public void setTouchSoundDisabled(ButtonViewGroup buttonViewGroup, boolean z10) {
        m.f(buttonViewGroup, "view");
        buttonViewGroup.setSoundEffectsEnabled(!z10);
    }
}
