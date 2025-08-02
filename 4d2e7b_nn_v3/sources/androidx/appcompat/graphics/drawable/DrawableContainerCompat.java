package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableContainerCompat extends Drawable implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainerCompat";
    private int mAlpha = 255;
    private Runnable mAnimationRunnable;
    private c mBlockInvalidateCallback;
    private int mCurIndex = -1;
    private Drawable mCurrDrawable;
    private d mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private boolean mHasAlpha;
    private Rect mHotspotBounds;
    private Drawable mLastDrawable;
    private boolean mMutated;

    class a implements Runnable {
        a() {
        }

        public void run() {
            DrawableContainerCompat.this.animate(true);
            DrawableContainerCompat.this.invalidateSelf();
        }
    }

    private static class b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    static class c implements Drawable.Callback {

        /* renamed from: a  reason: collision with root package name */
        private Drawable.Callback f14008a;

        c() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f14008a;
            this.f14008a = null;
            return callback;
        }

        public c b(Drawable.Callback callback) {
            this.f14008a = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            Drawable.Callback callback = this.f14008a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j10);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f14008a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static abstract class d extends Drawable.ConstantState {
        int A = 0;
        int B = 0;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a  reason: collision with root package name */
        final DrawableContainerCompat f14009a;

        /* renamed from: b  reason: collision with root package name */
        Resources f14010b;

        /* renamed from: c  reason: collision with root package name */
        int f14011c;

        /* renamed from: d  reason: collision with root package name */
        int f14012d;

        /* renamed from: e  reason: collision with root package name */
        int f14013e;

        /* renamed from: f  reason: collision with root package name */
        SparseArray f14014f;

        /* renamed from: g  reason: collision with root package name */
        Drawable[] f14015g;

        /* renamed from: h  reason: collision with root package name */
        int f14016h;

        /* renamed from: i  reason: collision with root package name */
        boolean f14017i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f14018j;

        /* renamed from: k  reason: collision with root package name */
        Rect f14019k;

        /* renamed from: l  reason: collision with root package name */
        boolean f14020l = false;

        /* renamed from: m  reason: collision with root package name */
        boolean f14021m;

        /* renamed from: n  reason: collision with root package name */
        int f14022n;

        /* renamed from: o  reason: collision with root package name */
        int f14023o;

        /* renamed from: p  reason: collision with root package name */
        int f14024p;

        /* renamed from: q  reason: collision with root package name */
        int f14025q;

        /* renamed from: r  reason: collision with root package name */
        boolean f14026r;

        /* renamed from: s  reason: collision with root package name */
        int f14027s;

        /* renamed from: t  reason: collision with root package name */
        boolean f14028t;

        /* renamed from: u  reason: collision with root package name */
        boolean f14029u;

        /* renamed from: v  reason: collision with root package name */
        boolean f14030v;

        /* renamed from: w  reason: collision with root package name */
        boolean f14031w;

        /* renamed from: x  reason: collision with root package name */
        boolean f14032x = true;

        /* renamed from: y  reason: collision with root package name */
        boolean f14033y;

        /* renamed from: z  reason: collision with root package name */
        int f14034z;

        d(d dVar, DrawableContainerCompat drawableContainerCompat, Resources resources) {
            Resources resources2;
            int i10;
            this.f14009a = drawableContainerCompat;
            Rect rect = null;
            if (resources != null) {
                resources2 = resources;
            } else if (dVar != null) {
                resources2 = dVar.f14010b;
            } else {
                resources2 = null;
            }
            this.f14010b = resources2;
            if (dVar != null) {
                i10 = dVar.f14011c;
            } else {
                i10 = 0;
            }
            int resolveDensity = DrawableContainerCompat.resolveDensity(resources, i10);
            this.f14011c = resolveDensity;
            if (dVar != null) {
                this.f14012d = dVar.f14012d;
                this.f14013e = dVar.f14013e;
                this.f14030v = true;
                this.f14031w = true;
                this.f14017i = dVar.f14017i;
                this.f14020l = dVar.f14020l;
                this.f14032x = dVar.f14032x;
                this.f14033y = dVar.f14033y;
                this.f14034z = dVar.f14034z;
                this.A = dVar.A;
                this.B = dVar.B;
                this.C = dVar.C;
                this.D = dVar.D;
                this.E = dVar.E;
                this.F = dVar.F;
                this.G = dVar.G;
                this.H = dVar.H;
                this.I = dVar.I;
                if (dVar.f14011c == resolveDensity) {
                    if (dVar.f14018j) {
                        this.f14019k = dVar.f14019k != null ? new Rect(dVar.f14019k) : rect;
                        this.f14018j = true;
                    }
                    if (dVar.f14021m) {
                        this.f14022n = dVar.f14022n;
                        this.f14023o = dVar.f14023o;
                        this.f14024p = dVar.f14024p;
                        this.f14025q = dVar.f14025q;
                        this.f14021m = true;
                    }
                }
                if (dVar.f14026r) {
                    this.f14027s = dVar.f14027s;
                    this.f14026r = true;
                }
                if (dVar.f14028t) {
                    this.f14029u = dVar.f14029u;
                    this.f14028t = true;
                }
                Drawable[] drawableArr = dVar.f14015g;
                this.f14015g = new Drawable[drawableArr.length];
                this.f14016h = dVar.f14016h;
                SparseArray sparseArray = dVar.f14014f;
                if (sparseArray != null) {
                    this.f14014f = sparseArray.clone();
                } else {
                    this.f14014f = new SparseArray(this.f14016h);
                }
                int i11 = this.f14016h;
                for (int i12 = 0; i12 < i11; i12++) {
                    Drawable drawable = drawableArr[i12];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.f14014f.put(i12, constantState);
                        } else {
                            this.f14015g[i12] = drawableArr[i12];
                        }
                    }
                }
                return;
            }
            this.f14015g = new Drawable[10];
            this.f14016h = 0;
        }

        private void f() {
            SparseArray sparseArray = this.f14014f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.f14015g[this.f14014f.keyAt(i10)] = u(((Drawable.ConstantState) this.f14014f.valueAt(i10)).newDrawable(this.f14010b));
                }
                this.f14014f = null;
            }
        }

        private Drawable u(Drawable drawable) {
            DrawableCompat.setLayoutDirection(drawable, this.f14034z);
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f14009a);
            return mutate;
        }

        /* access modifiers changed from: package-private */
        public final void A(Resources resources) {
            if (resources != null) {
                this.f14010b = resources;
                int resolveDensity = DrawableContainerCompat.resolveDensity(resources, this.f14011c);
                int i10 = this.f14011c;
                this.f14011c = resolveDensity;
                if (i10 != resolveDensity) {
                    this.f14021m = false;
                    this.f14018j = false;
                }
            }
        }

        public final int a(Drawable drawable) {
            int i10 = this.f14016h;
            if (i10 >= this.f14015g.length) {
                p(i10, i10 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f14009a);
            this.f14015g[i10] = drawable;
            this.f14016h++;
            this.f14013e = drawable.getChangingConfigurations() | this.f14013e;
            q();
            this.f14019k = null;
            this.f14018j = false;
            this.f14021m = false;
            this.f14030v = false;
            return i10;
        }

        /* access modifiers changed from: package-private */
        public final void b(Resources.Theme theme) {
            if (theme != null) {
                f();
                int i10 = this.f14016h;
                Drawable[] drawableArr = this.f14015g;
                for (int i11 = 0; i11 < i10; i11++) {
                    Drawable drawable = drawableArr[i11];
                    if (drawable != null && DrawableCompat.canApplyTheme(drawable)) {
                        DrawableCompat.applyTheme(drawableArr[i11], theme);
                        this.f14013e |= drawableArr[i11].getChangingConfigurations();
                    }
                }
                A(b.c(theme));
            }
        }

        public boolean c() {
            if (this.f14030v) {
                return this.f14031w;
            }
            f();
            this.f14030v = true;
            int i10 = this.f14016h;
            Drawable[] drawableArr = this.f14015g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getConstantState() == null) {
                    this.f14031w = false;
                    return false;
                }
            }
            this.f14031w = true;
            return true;
        }

        public boolean canApplyTheme() {
            int i10 = this.f14016h;
            Drawable[] drawableArr = this.f14015g;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                if (drawable == null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f14014f.get(i11);
                    if (constantState != null && b.a(constantState)) {
                        return true;
                    }
                } else if (DrawableCompat.canApplyTheme(drawable)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            this.f14033y = false;
        }

        /* access modifiers changed from: protected */
        public void e() {
            this.f14021m = true;
            f();
            int i10 = this.f14016h;
            Drawable[] drawableArr = this.f14015g;
            this.f14023o = -1;
            this.f14022n = -1;
            this.f14025q = 0;
            this.f14024p = 0;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f14022n) {
                    this.f14022n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f14023o) {
                    this.f14023o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f14024p) {
                    this.f14024p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f14025q) {
                    this.f14025q = minimumHeight;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final int g() {
            return this.f14015g.length;
        }

        public int getChangingConfigurations() {
            return this.f14012d | this.f14013e;
        }

        public final Drawable h(int i10) {
            int indexOfKey;
            Drawable drawable = this.f14015g[i10];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.f14014f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i10)) < 0) {
                return null;
            }
            Drawable u10 = u(((Drawable.ConstantState) this.f14014f.valueAt(indexOfKey)).newDrawable(this.f14010b));
            this.f14015g[i10] = u10;
            this.f14014f.removeAt(indexOfKey);
            if (this.f14014f.size() == 0) {
                this.f14014f = null;
            }
            return u10;
        }

        public final int i() {
            return this.f14016h;
        }

        public final int j() {
            if (!this.f14021m) {
                e();
            }
            return this.f14023o;
        }

        public final int k() {
            if (!this.f14021m) {
                e();
            }
            return this.f14025q;
        }

        public final int l() {
            if (!this.f14021m) {
                e();
            }
            return this.f14024p;
        }

        public final Rect m() {
            Rect rect = null;
            if (this.f14017i) {
                return null;
            }
            Rect rect2 = this.f14019k;
            if (rect2 != null || this.f14018j) {
                return rect2;
            }
            f();
            Rect rect3 = new Rect();
            int i10 = this.f14016h;
            Drawable[] drawableArr = this.f14015g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i12 = rect3.left;
                    if (i12 > rect.left) {
                        rect.left = i12;
                    }
                    int i13 = rect3.top;
                    if (i13 > rect.top) {
                        rect.top = i13;
                    }
                    int i14 = rect3.right;
                    if (i14 > rect.right) {
                        rect.right = i14;
                    }
                    int i15 = rect3.bottom;
                    if (i15 > rect.bottom) {
                        rect.bottom = i15;
                    }
                }
            }
            this.f14018j = true;
            this.f14019k = rect;
            return rect;
        }

        public final int n() {
            if (!this.f14021m) {
                e();
            }
            return this.f14022n;
        }

        public final int o() {
            int i10;
            if (this.f14026r) {
                return this.f14027s;
            }
            f();
            int i11 = this.f14016h;
            Drawable[] drawableArr = this.f14015g;
            if (i11 > 0) {
                i10 = drawableArr[0].getOpacity();
            } else {
                i10 = -2;
            }
            for (int i12 = 1; i12 < i11; i12++) {
                i10 = Drawable.resolveOpacity(i10, drawableArr[i12].getOpacity());
            }
            this.f14027s = i10;
            this.f14026r = true;
            return i10;
        }

        public void p(int i10, int i11) {
            Drawable[] drawableArr = new Drawable[i11];
            Drawable[] drawableArr2 = this.f14015g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i10);
            }
            this.f14015g = drawableArr;
        }

        /* access modifiers changed from: package-private */
        public void q() {
            this.f14026r = false;
            this.f14028t = false;
        }

        public final boolean r() {
            return this.f14020l;
        }

        public final boolean s() {
            if (this.f14028t) {
                return this.f14029u;
            }
            f();
            int i10 = this.f14016h;
            Drawable[] drawableArr = this.f14015g;
            boolean z10 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    break;
                } else if (drawableArr[i11].isStateful()) {
                    z10 = true;
                    break;
                } else {
                    i11++;
                }
            }
            this.f14029u = z10;
            this.f14028t = true;
            return z10;
        }

        /* access modifiers changed from: package-private */
        public abstract void t();

        public final void v(boolean z10) {
            this.f14020l = z10;
        }

        public final void w(int i10) {
            this.A = i10;
        }

        public final void x(int i10) {
            this.B = i10;
        }

        /* access modifiers changed from: package-private */
        public final boolean y(int i10, int i11) {
            int i12 = this.f14016h;
            Drawable[] drawableArr = this.f14015g;
            boolean z10 = false;
            for (int i13 = 0; i13 < i12; i13++) {
                Drawable drawable = drawableArr[i13];
                if (drawable != null) {
                    boolean layoutDirection = DrawableCompat.setLayoutDirection(drawable, i10);
                    if (i13 == i11) {
                        z10 = layoutDirection;
                    }
                }
            }
            this.f14034z = i10;
            return z10;
        }

        public final void z(boolean z10) {
            this.f14017i = z10;
        }
    }

    private void initializeDrawableForDisplay(Drawable drawable) {
        if (this.mBlockInvalidateCallback == null) {
            this.mBlockInvalidateCallback = new c();
        }
        drawable.setCallback(this.mBlockInvalidateCallback.b(drawable.getCallback()));
        try {
            if (this.mDrawableContainerState.A <= 0 && this.mHasAlpha) {
                drawable.setAlpha(this.mAlpha);
            }
            d dVar = this.mDrawableContainerState;
            if (dVar.E) {
                drawable.setColorFilter(dVar.D);
            } else {
                if (dVar.H) {
                    DrawableCompat.setTintList(drawable, dVar.F);
                }
                d dVar2 = this.mDrawableContainerState;
                if (dVar2.I) {
                    DrawableCompat.setTintMode(drawable, dVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.mDrawableContainerState.f14032x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
            DrawableCompat.setAutoMirrored(drawable, this.mDrawableContainerState.C);
            Rect rect = this.mHotspotBounds;
            if (rect != null) {
                DrawableCompat.setHotspotBounds(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            drawable.setCallback(this.mBlockInvalidateCallback.a());
        } catch (Throwable th) {
            drawable.setCallback(this.mBlockInvalidateCallback.a());
            throw th;
        }
    }

    private boolean needsMirroring() {
        if (!isAutoMirrored() || DrawableCompat.getLayoutDirection(this) != 1) {
            return false;
        }
        return true;
    }

    static int resolveDensity(@Nullable Resources resources, int i10) {
        if (resources != null) {
            i10 = resources.getDisplayMetrics().densityDpi;
        }
        if (i10 == 0) {
            return 160;
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void animate(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.mHasAlpha = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.mCurrDrawable
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L_0x0036
            long r9 = r13.mEnterAnimationEnd
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x0038
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0022
            int r9 = r13.mAlpha
            r3.setAlpha(r9)
            r13.mEnterAnimationEnd = r6
            goto L_0x0038
        L_0x0022:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r9 = (int) r9
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$d r10 = r13.mDrawableContainerState
            int r10 = r10.A
            int r9 = r9 / r10
            int r9 = 255 - r9
            int r10 = r13.mAlpha
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = r0
            goto L_0x0039
        L_0x0036:
            r13.mEnterAnimationEnd = r6
        L_0x0038:
            r3 = r8
        L_0x0039:
            android.graphics.drawable.Drawable r9 = r13.mLastDrawable
            if (r9 == 0) goto L_0x0061
            long r10 = r13.mExitAnimationEnd
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x0063
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0050
            r9.setVisible(r8, r8)
            r0 = 0
            r13.mLastDrawable = r0
            r13.mExitAnimationEnd = r6
            goto L_0x0063
        L_0x0050:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$d r4 = r13.mDrawableContainerState
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.mAlpha
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L_0x0064
        L_0x0061:
            r13.mExitAnimationEnd = r6
        L_0x0063:
            r0 = r3
        L_0x0064:
            if (r14 == 0) goto L_0x0070
            if (r0 == 0) goto L_0x0070
            java.lang.Runnable r14 = r13.mAnimationRunnable
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.animate(boolean):void");
    }

    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        this.mDrawableContainerState.b(theme);
    }

    @RequiresApi(21)
    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    /* access modifiers changed from: package-private */
    public void clearMutated() {
        this.mDrawableContainerState.d();
        this.mMutated = false;
    }

    /* access modifiers changed from: package-private */
    public d cloneConstantState() {
        return this.mDrawableContainerState;
    }

    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.mLastDrawable;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.mDrawableContainerState.c()) {
            return null;
        }
        this.mDrawableContainerState.f14012d = getChangingConfigurations();
        return this.mDrawableContainerState;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    /* access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.mCurIndex;
    }

    public void getHotspotBounds(@NonNull Rect rect) {
        Rect rect2 = this.mHotspotBounds;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.mDrawableContainerState.r()) {
            return this.mDrawableContainerState.j();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.mDrawableContainerState.r()) {
            return this.mDrawableContainerState.n();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.mDrawableContainerState.r()) {
            return this.mDrawableContainerState.k();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.mDrawableContainerState.r()) {
            return this.mDrawableContainerState.l();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.mCurrDrawable;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.mDrawableContainerState.o();
    }

    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            b.b(drawable, outline);
        }
    }

    public boolean getPadding(@NonNull Rect rect) {
        boolean z10;
        Rect m10 = this.mDrawableContainerState.m();
        if (m10 != null) {
            rect.set(m10);
            if ((m10.right | m10.left | m10.top | m10.bottom) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                z10 = drawable.getPadding(rect);
            } else {
                z10 = super.getPadding(rect);
            }
        }
        if (needsMirroring()) {
            int i10 = rect.left;
            rect.left = rect.right;
            rect.right = i10;
        }
        return z10;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        d dVar = this.mDrawableContainerState;
        if (dVar != null) {
            dVar.q();
        }
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.C;
    }

    public boolean isStateful() {
        return this.mDrawableContainerState.s();
    }

    public void jumpToCurrentState() {
        boolean z10;
        Drawable drawable = this.mLastDrawable;
        boolean z11 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.mLastDrawable = null;
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.mHasAlpha) {
                this.mCurrDrawable.setAlpha(this.mAlpha);
            }
        }
        if (this.mExitAnimationEnd != 0) {
            this.mExitAnimationEnd = 0;
            z10 = true;
        }
        if (this.mEnterAnimationEnd != 0) {
            this.mEnterAnimationEnd = 0;
        } else {
            z11 = z10;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            d cloneConstantState = cloneConstantState();
            cloneConstantState.t();
            setConstantState(cloneConstantState);
            this.mMutated = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i10) {
        return this.mDrawableContainerState.y(i10, getCurrentIndex());
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setLevel(i10);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(@NonNull int[] iArr) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j10) {
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j10);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean selectDrawable(int r10) {
        /*
            r9 = this;
            int r0 = r9.mCurIndex
            r1 = 0
            if (r10 != r0) goto L_0x0006
            return r1
        L_0x0006:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$d r0 = r9.mDrawableContainerState
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r9.mLastDrawable
            if (r0 == 0) goto L_0x001a
            r0.setVisible(r1, r1)
        L_0x001a:
            android.graphics.drawable.Drawable r0 = r9.mCurrDrawable
            if (r0 == 0) goto L_0x0029
            r9.mLastDrawable = r0
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$d r0 = r9.mDrawableContainerState
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.mExitAnimationEnd = r0
            goto L_0x0035
        L_0x0029:
            r9.mLastDrawable = r4
            r9.mExitAnimationEnd = r5
            goto L_0x0035
        L_0x002e:
            android.graphics.drawable.Drawable r0 = r9.mCurrDrawable
            if (r0 == 0) goto L_0x0035
            r0.setVisible(r1, r1)
        L_0x0035:
            if (r10 < 0) goto L_0x0055
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$d r0 = r9.mDrawableContainerState
            int r1 = r0.f14016h
            if (r10 >= r1) goto L_0x0055
            android.graphics.drawable.Drawable r0 = r0.h(r10)
            r9.mCurrDrawable = r0
            r9.mCurIndex = r10
            if (r0 == 0) goto L_0x005a
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$d r10 = r9.mDrawableContainerState
            int r10 = r10.A
            if (r10 <= 0) goto L_0x0051
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.mEnterAnimationEnd = r2
        L_0x0051:
            r9.initializeDrawableForDisplay(r0)
            goto L_0x005a
        L_0x0055:
            r9.mCurrDrawable = r4
            r10 = -1
            r9.mCurIndex = r10
        L_0x005a:
            long r0 = r9.mEnterAnimationEnd
            int r10 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = 1
            if (r10 != 0) goto L_0x0067
            long r1 = r9.mExitAnimationEnd
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x0079
        L_0x0067:
            java.lang.Runnable r10 = r9.mAnimationRunnable
            if (r10 != 0) goto L_0x0073
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$a r10 = new androidx.appcompat.graphics.drawable.DrawableContainerCompat$a
            r10.<init>()
            r9.mAnimationRunnable = r10
            goto L_0x0076
        L_0x0073:
            r9.unscheduleSelf(r10)
        L_0x0076:
            r9.animate(r0)
        L_0x0079:
            r9.invalidateSelf()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.selectDrawable(int):boolean");
    }

    public void setAlpha(int i10) {
        if (!this.mHasAlpha || this.mAlpha != i10) {
            this.mHasAlpha = true;
            this.mAlpha = i10;
            Drawable drawable = this.mCurrDrawable;
            if (drawable == null) {
                return;
            }
            if (this.mEnterAnimationEnd == 0) {
                drawable.setAlpha(i10);
            } else {
                animate(false);
            }
        }
    }

    public void setAutoMirrored(boolean z10) {
        d dVar = this.mDrawableContainerState;
        if (dVar.C != z10) {
            dVar.C = z10;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                DrawableCompat.setAutoMirrored(drawable, z10);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.mDrawableContainerState;
        dVar.E = true;
        if (dVar.D != colorFilter) {
            dVar.D = colorFilter;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setConstantState(d dVar) {
        this.mDrawableContainerState = dVar;
        int i10 = this.mCurIndex;
        if (i10 >= 0) {
            Drawable h10 = dVar.h(i10);
            this.mCurrDrawable = h10;
            if (h10 != null) {
                initializeDrawableForDisplay(h10);
            }
        }
        this.mLastDrawable = null;
    }

    /* access modifiers changed from: package-private */
    public void setCurrentIndex(int i10) {
        selectDrawable(i10);
    }

    public void setDither(boolean z10) {
        d dVar = this.mDrawableContainerState;
        if (dVar.f14032x != z10) {
            dVar.f14032x = z10;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setDither(z10);
            }
        }
    }

    public void setEnterFadeDuration(int i10) {
        this.mDrawableContainerState.A = i10;
    }

    public void setExitFadeDuration(int i10) {
        this.mDrawableContainerState.B = i10;
    }

    public void setHotspot(float f10, float f11) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f10, f11);
        }
    }

    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        Rect rect = this.mHotspotBounds;
        if (rect == null) {
            this.mHotspotBounds = new Rect(i10, i11, i12, i13);
        } else {
            rect.set(i10, i11, i12, i13);
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            DrawableCompat.setHotspotBounds(drawable, i10, i11, i12, i13);
        }
    }

    public void setTint(@ColorInt int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.mDrawableContainerState;
        dVar.H = true;
        if (dVar.F != colorStateList) {
            dVar.F = colorStateList;
            DrawableCompat.setTintList(this.mCurrDrawable, colorStateList);
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        d dVar = this.mDrawableContainerState;
        dVar.I = true;
        if (dVar.G != mode) {
            dVar.G = mode;
            DrawableCompat.setTintMode(this.mCurrDrawable, mode);
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setVisible(z10, z11);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setVisible(z10, z11);
        }
        return visible;
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    /* access modifiers changed from: package-private */
    public final void updateDensity(Resources resources) {
        this.mDrawableContainerState.A(resources);
    }
}
