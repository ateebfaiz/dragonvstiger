package com.facebook.share.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.l;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeButton;
import com.facebook.share.internal.d;
import q5.p0;
import q5.u;

@Deprecated
public class LikeView extends FrameLayout {
    private c C = c.f4707f;
    private int N0 = -1;
    private int O0;
    private int P0;
    private u Q0;
    private boolean R0 = true;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f4691a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public g f4692b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f4693c;

    /* renamed from: d  reason: collision with root package name */
    private LikeButton f4694d;

    /* renamed from: e  reason: collision with root package name */
    private LikeBoxCountView f4695e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f4696f;

    /* renamed from: g  reason: collision with root package name */
    private com.facebook.share.internal.d f4697g;

    /* renamed from: h  reason: collision with root package name */
    private BroadcastReceiver f4698h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public e f4699i;

    /* renamed from: j  reason: collision with root package name */
    private i f4700j = i.f4731f;

    /* renamed from: w  reason: collision with root package name */
    private d f4701w = d.f4714f;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            if (!v5.a.d(this)) {
                try {
                    LikeView.this.r();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4703a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.share.widget.LikeView$c[] r0 = com.facebook.share.widget.LikeView.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4703a = r0
                com.facebook.share.widget.LikeView$c r1 = com.facebook.share.widget.LikeView.c.TOP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4703a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.share.widget.LikeView$c r1 = com.facebook.share.widget.LikeView.c.BOTTOM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4703a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.share.widget.LikeView$c r1 = com.facebook.share.widget.LikeView.c.INLINE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.LikeView.b.<clinit>():void");
        }
    }

    public enum c {
        BOTTOM("bottom", 0),
        INLINE("inline", 1),
        TOP("top", 2);
        

        /* renamed from: f  reason: collision with root package name */
        static c f4707f;

        /* renamed from: a  reason: collision with root package name */
        private String f4709a;

        /* renamed from: b  reason: collision with root package name */
        private int f4710b;

        static {
            c cVar;
            f4707f = cVar;
        }

        private c(String str, int i10) {
            this.f4709a = str;
            this.f4710b = i10;
        }

        static c b(int i10) {
            for (c cVar : values()) {
                if (cVar.c() == i10) {
                    return cVar;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public int c() {
            return this.f4710b;
        }

        public String toString() {
            return this.f4709a;
        }
    }

    public enum d {
        CENTER("center", 0),
        LEFT("left", 1),
        RIGHT("right", 2);
        

        /* renamed from: f  reason: collision with root package name */
        static d f4714f;

        /* renamed from: a  reason: collision with root package name */
        private String f4716a;

        /* renamed from: b  reason: collision with root package name */
        private int f4717b;

        static {
            d dVar;
            f4714f = dVar;
        }

        private d(String str, int i10) {
            this.f4716a = str;
            this.f4717b = i10;
        }

        static d b(int i10) {
            for (d dVar : values()) {
                if (dVar.c() == i10) {
                    return dVar;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public int c() {
            return this.f4717b;
        }

        public String toString() {
            return this.f4716a;
        }
    }

    private class e implements d.o {

        /* renamed from: a  reason: collision with root package name */
        private boolean f4718a;

        private e() {
        }

        public void a(com.facebook.share.internal.d dVar, l lVar) {
            if (!this.f4718a) {
                if (dVar != null) {
                    if (!dVar.q0()) {
                        lVar = new l("Cannot use LikeView. The device may not be supported.");
                    }
                    LikeView.this.i(dVar);
                    LikeView.this.u();
                }
                if (lVar != null) {
                    h unused = LikeView.this.getClass();
                }
                e unused2 = LikeView.this.f4699i = null;
            }
        }

        public void b() {
            this.f4718a = true;
        }

        /* synthetic */ e(LikeView likeView, a aVar) {
            this();
        }
    }

    private class f extends BroadcastReceiver {
        private f() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
                if (!p0.Y(string) && !p0.c(LikeView.this.f4691a, string)) {
                    return;
                }
            }
            if ("com.facebook.sdk.LikeActionController.UPDATED".equals(action)) {
                LikeView.this.u();
            } else if ("com.facebook.sdk.LikeActionController.DID_ERROR".equals(action)) {
                h unused = LikeView.this.getClass();
            } else if ("com.facebook.sdk.LikeActionController.DID_RESET".equals(action)) {
                LikeView likeView = LikeView.this;
                likeView.p(likeView.f4691a, LikeView.this.f4692b);
                LikeView.this.u();
            }
        }

        /* synthetic */ f(LikeView likeView, a aVar) {
            this();
        }
    }

    public enum g {
        UNKNOWN("unknown", 0),
        OPEN_GRAPH("open_graph", 1),
        PAGE("page", 2);
        

        /* renamed from: f  reason: collision with root package name */
        public static g f4724f;

        /* renamed from: a  reason: collision with root package name */
        private String f4726a;

        /* renamed from: b  reason: collision with root package name */
        private int f4727b;

        static {
            g gVar;
            f4724f = gVar;
        }

        private g(String str, int i10) {
            this.f4726a = str;
            this.f4727b = i10;
        }

        public static g a(int i10) {
            for (g gVar : values()) {
                if (gVar.b() == i10) {
                    return gVar;
                }
            }
            return null;
        }

        public int b() {
            return this.f4727b;
        }

        public String toString() {
            return this.f4726a;
        }
    }

    public interface h {
    }

    public enum i {
        STANDARD("standard", 0),
        BUTTON("button", 1),
        BOX_COUNT("box_count", 2);
        

        /* renamed from: f  reason: collision with root package name */
        static i f4731f;

        /* renamed from: a  reason: collision with root package name */
        private String f4733a;

        /* renamed from: b  reason: collision with root package name */
        private int f4734b;

        static {
            i iVar;
            f4731f = iVar;
        }

        private i(String str, int i10) {
            this.f4733a = str;
            this.f4734b = i10;
        }

        static i b(int i10) {
            for (i iVar : values()) {
                if (iVar.c() == i10) {
                    return iVar;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public int c() {
            return this.f4734b;
        }

        public String toString() {
            return this.f4733a;
        }
    }

    @Deprecated
    public LikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(attributeSet);
        j(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.app.Activity getActivity() {
        /*
            r3 = this;
            android.content.Context r0 = r3.getContext()
        L_0x0004:
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 != 0) goto L_0x0013
            boolean r2 = r0 instanceof android.content.ContextWrapper
            if (r2 == 0) goto L_0x0013
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            goto L_0x0004
        L_0x0013:
            if (r1 == 0) goto L_0x0018
            android.app.Activity r0 = (android.app.Activity) r0
            return r0
        L_0x0018:
            com.facebook.l r0 = new com.facebook.l
            java.lang.String r1 = "Unable to get Activity."
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.LikeView.getActivity():android.app.Activity");
    }

    private Bundle getAnalyticsParameters() {
        Bundle bundle = new Bundle();
        bundle.putString("style", this.f4700j.toString());
        bundle.putString("auxiliary_position", this.C.toString());
        bundle.putString("horizontal_alignment", this.f4701w.toString());
        bundle.putString("object_id", p0.j(this.f4691a, ""));
        bundle.putString("object_type", this.f4692b.toString());
        return bundle;
    }

    /* access modifiers changed from: private */
    public void i(com.facebook.share.internal.d dVar) {
        this.f4697g = dVar;
        this.f4698h = new f(this, (a) null);
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.LikeActionController.UPDATED");
        intentFilter.addAction("com.facebook.sdk.LikeActionController.DID_ERROR");
        intentFilter.addAction("com.facebook.sdk.LikeActionController.DID_RESET");
        instance.registerReceiver(this.f4698h, intentFilter);
    }

    private void j(Context context) {
        this.O0 = getResources().getDimensionPixelSize(u2.b.f24275g);
        this.P0 = getResources().getDimensionPixelSize(u2.b.f24276h);
        if (this.N0 == -1) {
            this.N0 = getResources().getColor(u2.a.f24268d);
        }
        setBackgroundColor(0);
        this.f4693c = new LinearLayout(context);
        this.f4693c.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        k(context);
        m(context);
        l(context);
        this.f4693c.addView(this.f4694d);
        this.f4693c.addView(this.f4696f);
        this.f4693c.addView(this.f4695e);
        addView(this.f4693c);
        p(this.f4691a, this.f4692b);
        u();
    }

    private void k(Context context) {
        boolean z10;
        com.facebook.share.internal.d dVar = this.f4697g;
        if (dVar == null || !dVar.X()) {
            z10 = false;
        } else {
            z10 = true;
        }
        LikeButton likeButton = new LikeButton(context, z10);
        this.f4694d = likeButton;
        likeButton.setOnClickListener(new a());
        this.f4694d.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    private void l(Context context) {
        this.f4695e = new LikeBoxCountView(context);
        this.f4695e.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    private void m(Context context) {
        TextView textView = new TextView(context);
        this.f4696f = textView;
        textView.setTextSize(0, getResources().getDimension(u2.b.f24277i));
        this.f4696f.setMaxLines(2);
        this.f4696f.setTextColor(this.N0);
        this.f4696f.setGravity(17);
        this.f4696f.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    }

    private void n(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet != null && getContext() != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, u2.h.V)) != null) {
            this.f4691a = p0.j(obtainStyledAttributes.getString(u2.h.Z), (String) null);
            this.f4692b = g.a(obtainStyledAttributes.getInt(u2.h.f24305a0, g.f4724f.b()));
            i b10 = i.b(obtainStyledAttributes.getInt(u2.h.f24307b0, i.f4731f.c()));
            this.f4700j = b10;
            if (b10 != null) {
                c b11 = c.b(obtainStyledAttributes.getInt(u2.h.W, c.f4707f.c()));
                this.C = b11;
                if (b11 != null) {
                    d b12 = d.b(obtainStyledAttributes.getInt(u2.h.Y, d.f4714f.c()));
                    this.f4701w = b12;
                    if (b12 != null) {
                        this.N0 = obtainStyledAttributes.getColor(u2.h.X, -1);
                        obtainStyledAttributes.recycle();
                        return;
                    }
                    throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
                }
                throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
            }
            throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
        }
    }

    /* access modifiers changed from: private */
    public void p(String str, g gVar) {
        q();
        this.f4691a = str;
        this.f4692b = gVar;
        if (!p0.Y(str)) {
            this.f4699i = new e(this, (a) null);
            if (!isInEditMode()) {
                com.facebook.share.internal.d.P(str, gVar, this.f4699i);
            }
        }
    }

    private void q() {
        if (this.f4698h != null) {
            LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.f4698h);
            this.f4698h = null;
        }
        e eVar = this.f4699i;
        if (eVar != null) {
            eVar.b();
            this.f4699i = null;
        }
        this.f4697g = null;
    }

    /* access modifiers changed from: private */
    public void r() {
        Activity activity;
        if (this.f4697g != null) {
            if (this.Q0 == null) {
                activity = getActivity();
            } else {
                activity = null;
            }
            this.f4697g.s0(activity, this.Q0, getAnalyticsParameters());
        }
    }

    private void s() {
        LikeBoxCountView.b bVar;
        int i10 = b.f4703a[this.C.ordinal()];
        if (i10 == 1) {
            this.f4695e.setCaretPosition(LikeBoxCountView.b.BOTTOM);
        } else if (i10 == 2) {
            this.f4695e.setCaretPosition(LikeBoxCountView.b.TOP);
        } else if (i10 == 3) {
            LikeBoxCountView likeBoxCountView = this.f4695e;
            if (this.f4701w == d.RIGHT) {
                bVar = LikeBoxCountView.b.RIGHT;
            } else {
                bVar = LikeBoxCountView.b.LEFT;
            }
            likeBoxCountView.setCaretPosition(bVar);
        }
    }

    private void t() {
        int i10;
        View view;
        com.facebook.share.internal.d dVar;
        com.facebook.share.internal.d dVar2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f4693c.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f4694d.getLayoutParams();
        d dVar3 = this.f4701w;
        if (dVar3 == d.LEFT) {
            i10 = 3;
        } else if (dVar3 == d.CENTER) {
            i10 = 1;
        } else {
            i10 = 5;
        }
        layoutParams.gravity = i10 | 48;
        layoutParams2.gravity = i10;
        this.f4696f.setVisibility(8);
        this.f4695e.setVisibility(8);
        if (this.f4700j == i.STANDARD && (dVar2 = this.f4697g) != null && !p0.Y(dVar2.U())) {
            view = this.f4696f;
        } else if (this.f4700j == i.BOX_COUNT && (dVar = this.f4697g) != null && !p0.Y(dVar.R())) {
            s();
            view = this.f4695e;
        } else {
            return;
        }
        int i11 = 0;
        view.setVisibility(0);
        ((LinearLayout.LayoutParams) view.getLayoutParams()).gravity = i10;
        LinearLayout linearLayout = this.f4693c;
        c cVar = this.C;
        c cVar2 = c.INLINE;
        if (cVar != cVar2) {
            i11 = 1;
        }
        linearLayout.setOrientation(i11);
        c cVar3 = this.C;
        if (cVar3 == c.TOP || (cVar3 == cVar2 && this.f4701w == d.RIGHT)) {
            this.f4693c.removeView(this.f4694d);
            this.f4693c.addView(this.f4694d);
        } else {
            this.f4693c.removeView(view);
            this.f4693c.addView(view);
        }
        int i12 = b.f4703a[this.C.ordinal()];
        if (i12 == 1) {
            int i13 = this.O0;
            view.setPadding(i13, i13, i13, this.P0);
        } else if (i12 == 2) {
            int i14 = this.O0;
            view.setPadding(i14, this.P0, i14, i14);
        } else if (i12 == 3) {
            if (this.f4701w == d.RIGHT) {
                int i15 = this.O0;
                view.setPadding(i15, i15, this.P0, i15);
                return;
            }
            int i16 = this.P0;
            int i17 = this.O0;
            view.setPadding(i16, i17, i17, i17);
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        boolean z10 = !this.R0;
        com.facebook.share.internal.d dVar = this.f4697g;
        if (dVar == null) {
            this.f4694d.setSelected(false);
            this.f4696f.setText((CharSequence) null);
            this.f4695e.setText((String) null);
        } else {
            this.f4694d.setSelected(dVar.X());
            this.f4696f.setText(this.f4697g.U());
            this.f4695e.setText(this.f4697g.R());
            z10 &= this.f4697g.q0();
        }
        super.setEnabled(z10);
        this.f4694d.setEnabled(z10);
        t();
    }

    @Deprecated
    public h getOnErrorListener() {
        return null;
    }

    public void o(String str, g gVar) {
        String j10 = p0.j(str, (String) null);
        if (gVar == null) {
            gVar = g.f4724f;
        }
        if (!p0.c(j10, this.f4691a) || gVar != this.f4692b) {
            p(j10, gVar);
            u();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        o((String) null, g.UNKNOWN);
        super.onDetachedFromWindow();
    }

    @Deprecated
    public void setAuxiliaryViewPosition(c cVar) {
        if (cVar == null) {
            cVar = c.f4707f;
        }
        if (this.C != cVar) {
            this.C = cVar;
            t();
        }
    }

    @Deprecated
    public void setEnabled(boolean z10) {
        this.R0 = true;
        u();
    }

    @Deprecated
    public void setForegroundColor(int i10) {
        if (this.N0 != i10) {
            this.f4696f.setTextColor(i10);
        }
    }

    @Deprecated
    public void setFragment(Fragment fragment) {
        this.Q0 = new u(fragment);
    }

    @Deprecated
    public void setHorizontalAlignment(d dVar) {
        if (dVar == null) {
            dVar = d.f4714f;
        }
        if (this.f4701w != dVar) {
            this.f4701w = dVar;
            t();
        }
    }

    @Deprecated
    public void setLikeViewStyle(i iVar) {
        if (iVar == null) {
            iVar = i.f4731f;
        }
        if (this.f4700j != iVar) {
            this.f4700j = iVar;
            t();
        }
    }

    @Deprecated
    public void setOnErrorListener(h hVar) {
    }

    @Deprecated
    public void setFragment(android.app.Fragment fragment) {
        this.Q0 = new u(fragment);
    }
}
