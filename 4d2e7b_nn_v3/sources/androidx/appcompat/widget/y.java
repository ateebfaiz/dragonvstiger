package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

class y implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static y C;

    /* renamed from: w  reason: collision with root package name */
    private static y f14379w;

    /* renamed from: a  reason: collision with root package name */
    private final View f14380a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f14381b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14382c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f14383d = new w(this);

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f14384e = new x(this);

    /* renamed from: f  reason: collision with root package name */
    private int f14385f;

    /* renamed from: g  reason: collision with root package name */
    private int f14386g;

    /* renamed from: h  reason: collision with root package name */
    private z f14387h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14388i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14389j;

    private y(View view, CharSequence charSequence) {
        this.f14380a = view;
        this.f14381b = charSequence;
        this.f14382c = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.f14380a.removeCallbacks(this.f14383d);
    }

    private void c() {
        this.f14389j = true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    private void f() {
        this.f14380a.postDelayed(this.f14383d, (long) ViewConfiguration.getLongPressTimeout());
    }

    private static void g(y yVar) {
        y yVar2 = f14379w;
        if (yVar2 != null) {
            yVar2.b();
        }
        f14379w = yVar;
        if (yVar != null) {
            yVar.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        y yVar = f14379w;
        if (yVar != null && yVar.f14380a == view) {
            g((y) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            y yVar2 = C;
            if (yVar2 != null && yVar2.f14380a == view) {
                yVar2.d();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new y(view, charSequence);
    }

    private boolean j(MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (!this.f14389j && Math.abs(x10 - this.f14385f) <= this.f14382c && Math.abs(y10 - this.f14386g) <= this.f14382c) {
            return false;
        }
        this.f14385f = x10;
        this.f14386g = y10;
        this.f14389j = false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (C == this) {
            C = null;
            z zVar = this.f14387h;
            if (zVar != null) {
                zVar.c();
                this.f14387h = null;
                c();
                this.f14380a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f14379w == this) {
            g((y) null);
        }
        this.f14380a.removeCallbacks(this.f14384e);
    }

    /* access modifiers changed from: package-private */
    public void i(boolean z10) {
        long j10;
        long longPressTimeout;
        long j11;
        if (ViewCompat.isAttachedToWindow(this.f14380a)) {
            g((y) null);
            y yVar = C;
            if (yVar != null) {
                yVar.d();
            }
            C = this;
            this.f14388i = z10;
            z zVar = new z(this.f14380a.getContext());
            this.f14387h = zVar;
            zVar.e(this.f14380a, this.f14385f, this.f14386g, this.f14388i, this.f14381b);
            this.f14380a.addOnAttachStateChangeListener(this);
            if (this.f14388i) {
                j10 = 2500;
            } else {
                if ((ViewCompat.getWindowSystemUiVisibility(this.f14380a) & 1) == 1) {
                    longPressTimeout = (long) ViewConfiguration.getLongPressTimeout();
                    j11 = 3000;
                } else {
                    longPressTimeout = (long) ViewConfiguration.getLongPressTimeout();
                    j11 = 15000;
                }
                j10 = j11 - longPressTimeout;
            }
            this.f14380a.removeCallbacks(this.f14384e);
            this.f14380a.postDelayed(this.f14384e, j10);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f14387h != null && this.f14388i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f14380a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f14380a.isEnabled() && this.f14387h == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f14385f = view.getWidth() / 2;
        this.f14386g = view.getHeight() / 2;
        i(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
