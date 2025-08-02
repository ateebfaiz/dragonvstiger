package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.login.o;
import com.facebook.login.p;
import com.facebook.login.q;
import java.lang.ref.WeakReference;

public class ToolTipPopup {

    /* renamed from: a  reason: collision with root package name */
    private final String f20651a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference f20652b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f20653c;

    /* renamed from: d  reason: collision with root package name */
    private PopupContentView f20654d;

    /* renamed from: e  reason: collision with root package name */
    private PopupWindow f20655e;

    /* renamed from: f  reason: collision with root package name */
    private d f20656f = d.BLUE;

    /* renamed from: g  reason: collision with root package name */
    private long f20657g = 6000;

    /* renamed from: h  reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f20658h = new a();

    private class PopupContentView extends FrameLayout {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public ImageView f20659a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ImageView f20660b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public View f20661c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public ImageView f20662d;

        public PopupContentView(Context context) {
            super(context);
            e();
        }

        private void e() {
            LayoutInflater.from(getContext()).inflate(q.f20568a, this);
            this.f20659a = (ImageView) findViewById(p.f20567e);
            this.f20660b = (ImageView) findViewById(p.f20565c);
            this.f20661c = findViewById(p.f20563a);
            this.f20662d = (ImageView) findViewById(p.f20564b);
        }

        public void f() {
            this.f20659a.setVisibility(4);
            this.f20660b.setVisibility(0);
        }

        public void g() {
            this.f20659a.setVisibility(0);
            this.f20660b.setVisibility(4);
        }
    }

    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        public void onScrollChanged() {
            if (ToolTipPopup.a(ToolTipPopup.this).get() != null && ToolTipPopup.b(ToolTipPopup.this) != null && ToolTipPopup.b(ToolTipPopup.this).isShowing()) {
                if (ToolTipPopup.b(ToolTipPopup.this).isAboveAnchor()) {
                    ToolTipPopup.c(ToolTipPopup.this).f();
                } else {
                    ToolTipPopup.c(ToolTipPopup.this).g();
                }
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (!v5.a.d(this)) {
                try {
                    ToolTipPopup.this.d();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            if (!v5.a.d(this)) {
                try {
                    ToolTipPopup.this.d();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    public enum d {
        BLUE,
        BLACK
    }

    public ToolTipPopup(String str, View view) {
        this.f20651a = str;
        this.f20652b = new WeakReference(view);
        this.f20653c = view.getContext();
    }

    static /* synthetic */ WeakReference a(ToolTipPopup toolTipPopup) {
        Class<ToolTipPopup> cls = ToolTipPopup.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return toolTipPopup.f20652b;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    static /* synthetic */ PopupWindow b(ToolTipPopup toolTipPopup) {
        Class<ToolTipPopup> cls = ToolTipPopup.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return toolTipPopup.f20655e;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    static /* synthetic */ PopupContentView c(ToolTipPopup toolTipPopup) {
        Class<ToolTipPopup> cls = ToolTipPopup.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return toolTipPopup.f20654d;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private void e() {
        if (!v5.a.d(this)) {
            try {
                i();
                if (this.f20652b.get() != null) {
                    ((View) this.f20652b.get()).getViewTreeObserver().addOnScrollChangedListener(this.f20658h);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private void i() {
        if (!v5.a.d(this)) {
            try {
                if (this.f20652b.get() != null) {
                    ((View) this.f20652b.get()).getViewTreeObserver().removeOnScrollChangedListener(this.f20658h);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private void j() {
        if (!v5.a.d(this)) {
            try {
                PopupWindow popupWindow = this.f20655e;
                if (popupWindow != null && popupWindow.isShowing()) {
                    if (this.f20655e.isAboveAnchor()) {
                        this.f20654d.f();
                    } else {
                        this.f20654d.g();
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void d() {
        if (!v5.a.d(this)) {
            try {
                i();
                PopupWindow popupWindow = this.f20655e;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void f(long j10) {
        if (!v5.a.d(this)) {
            try {
                this.f20657g = j10;
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void g(d dVar) {
        if (!v5.a.d(this)) {
            try {
                this.f20656f = dVar;
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void h() {
        if (!v5.a.d(this)) {
            try {
                if (this.f20652b.get() != null) {
                    PopupContentView popupContentView = new PopupContentView(this.f20653c);
                    this.f20654d = popupContentView;
                    ((TextView) popupContentView.findViewById(p.f20566d)).setText(this.f20651a);
                    if (this.f20656f == d.BLUE) {
                        this.f20654d.f20661c.setBackgroundResource(o.f20559g);
                        this.f20654d.f20660b.setImageResource(o.f20560h);
                        this.f20654d.f20659a.setImageResource(o.f20561i);
                        this.f20654d.f20662d.setImageResource(o.f20562j);
                    } else {
                        this.f20654d.f20661c.setBackgroundResource(o.f20555c);
                        this.f20654d.f20660b.setImageResource(o.f20556d);
                        this.f20654d.f20659a.setImageResource(o.f20557e);
                        this.f20654d.f20662d.setImageResource(o.f20558f);
                    }
                    View decorView = ((Activity) this.f20653c).getWindow().getDecorView();
                    int width = decorView.getWidth();
                    int height = decorView.getHeight();
                    e();
                    this.f20654d.measure(View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
                    PopupContentView popupContentView2 = this.f20654d;
                    PopupWindow popupWindow = new PopupWindow(popupContentView2, popupContentView2.getMeasuredWidth(), this.f20654d.getMeasuredHeight());
                    this.f20655e = popupWindow;
                    popupWindow.showAsDropDown((View) this.f20652b.get());
                    j();
                    if (this.f20657g > 0) {
                        this.f20654d.postDelayed(new b(), this.f20657g);
                    }
                    this.f20655e.setTouchable(true);
                    this.f20654d.setOnClickListener(new c());
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }
}
