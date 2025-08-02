package com.facebook.login.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import com.facebook.AccessToken;
import com.facebook.FacebookButtonBase;
import com.facebook.Profile;
import com.facebook.g;
import com.facebook.login.i;
import com.facebook.login.k;
import com.facebook.login.t;
import com.facebook.login.widget.ToolTipPopup;
import com.facebook.o;
import e2.m;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import q5.d;
import q5.p0;
import q5.r;
import q5.s;

public class LoginButton extends FacebookButtonBase {
    protected d C = new d();
    /* access modifiers changed from: private */
    public String N0 = "fb_login_view_usage";
    private boolean O0;
    private ToolTipPopup.d P0 = ToolTipPopup.d.BLUE;
    private f Q0;
    private long R0 = 6000;
    private ToolTipPopup S0;
    private com.facebook.e T0;
    private i U0;
    private Float V0;
    private int W0 = 255;
    private final String X0 = UUID.randomUUID().toString();
    /* access modifiers changed from: private */
    public g Y0 = null;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f20611i;

    /* renamed from: j  reason: collision with root package name */
    private String f20612j;

    /* renamed from: w  reason: collision with root package name */
    private String f20613w;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f20614a;

        /* renamed from: com.facebook.login.widget.LoginButton$a$a  reason: collision with other inner class name */
        class C0258a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ r f20616a;

            C0258a(r rVar) {
                this.f20616a = rVar;
            }

            public void run() {
                if (!v5.a.d(this)) {
                    try {
                        LoginButton.this.D(this.f20616a);
                    } catch (Throwable th) {
                        v5.a.b(th, this);
                    }
                }
            }
        }

        a(String str) {
            this.f20614a = str;
        }

        public void run() {
            if (!v5.a.d(this)) {
                try {
                    LoginButton.this.getActivity().runOnUiThread(new C0258a(s.o(this.f20614a, false)));
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    class b extends com.facebook.e {
        b() {
        }

        /* access modifiers changed from: protected */
        public void d(AccessToken accessToken, AccessToken accessToken2) {
            LoginButton.this.B();
            LoginButton.this.z();
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20619a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.login.widget.LoginButton$f[] r0 = com.facebook.login.widget.LoginButton.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20619a = r0
                com.facebook.login.widget.LoginButton$f r1 = com.facebook.login.widget.LoginButton.f.AUTOMATIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20619a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.login.widget.LoginButton$f r1 = com.facebook.login.widget.LoginButton.f.DISPLAY_ALWAYS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20619a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.login.widget.LoginButton$f r1 = com.facebook.login.widget.LoginButton.f.NEVER_DISPLAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.widget.LoginButton.c.<clinit>():void");
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        private com.facebook.login.b f20620a = com.facebook.login.b.FRIENDS;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public List f20621b = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        private com.facebook.login.e f20622c = com.facebook.login.e.NATIVE_WITH_FALLBACK;

        /* renamed from: d  reason: collision with root package name */
        private String f20623d = "rerequest";

        /* renamed from: e  reason: collision with root package name */
        private k f20624e = k.FACEBOOK;

        /* renamed from: f  reason: collision with root package name */
        private boolean f20625f = false;

        /* renamed from: g  reason: collision with root package name */
        private String f20626g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f20627h;

        d() {
        }

        public String b() {
            return this.f20623d;
        }

        public com.facebook.login.b c() {
            return this.f20620a;
        }

        public com.facebook.login.e d() {
            return this.f20622c;
        }

        public k e() {
            return this.f20624e;
        }

        public String f() {
            return this.f20626g;
        }

        /* access modifiers changed from: package-private */
        public List g() {
            return this.f20621b;
        }

        public boolean h() {
            return this.f20627h;
        }

        public boolean i() {
            return this.f20625f;
        }

        public void j(String str) {
            this.f20623d = str;
        }

        public void k(com.facebook.login.b bVar) {
            this.f20620a = bVar;
        }

        public void l(com.facebook.login.e eVar) {
            this.f20622c = eVar;
        }

        public void m(k kVar) {
            this.f20624e = kVar;
        }

        public void n(String str) {
            this.f20626g = str;
        }

        public void o(List list) {
            this.f20621b = list;
        }

        public void p(boolean z10) {
            this.f20627h = z10;
        }
    }

    protected class e implements View.OnClickListener {

        class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i f20629a;

            a(i iVar) {
                this.f20629a = iVar;
            }

            public void onClick(DialogInterface dialogInterface, int i10) {
                this.f20629a.p();
            }
        }

        protected e() {
        }

        /* access modifiers changed from: protected */
        public i a() {
            if (v5.a.d(this)) {
                return null;
            }
            try {
                i e10 = i.e();
                e10.w(LoginButton.this.getDefaultAudience());
                e10.z(LoginButton.this.getLoginBehavior());
                e10.A(b());
                e10.v(LoginButton.this.getAuthType());
                e10.y(c());
                e10.D(LoginButton.this.getShouldSkipAccountDeduplication());
                e10.B(LoginButton.this.getMessengerPageId());
                e10.C(LoginButton.this.getResetMessengerState());
                return e10;
            } catch (Throwable th) {
                v5.a.b(th, this);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public k b() {
            if (v5.a.d(this)) {
                return null;
            }
            try {
                return k.FACEBOOK;
            } catch (Throwable th) {
                v5.a.b(th, this);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public boolean c() {
            v5.a.d(this);
            return false;
        }

        /* access modifiers changed from: protected */
        public void d() {
            g gVar;
            if (!v5.a.d(this)) {
                try {
                    i a10 = a();
                    if (LoginButton.this.getAndroidxActivityResultRegistryOwner() != null) {
                        if (LoginButton.this.Y0 != null) {
                            gVar = LoginButton.this.Y0;
                        } else {
                            gVar = new q5.d();
                        }
                        a10.l(LoginButton.this.getAndroidxActivityResultRegistryOwner(), gVar, LoginButton.this.C.f20621b, LoginButton.this.getLoggerID());
                    } else if (LoginButton.this.getFragment() != null) {
                        a10.m(LoginButton.this.getFragment(), LoginButton.this.C.f20621b, LoginButton.this.getLoggerID());
                    } else if (LoginButton.this.getNativeFragment() != null) {
                        a10.k(LoginButton.this.getNativeFragment(), LoginButton.this.C.f20621b, LoginButton.this.getLoggerID());
                    } else {
                        a10.j(LoginButton.this.getActivity(), LoginButton.this.C.f20621b, LoginButton.this.getLoggerID());
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void e(Context context) {
            String str;
            if (!v5.a.d(this)) {
                try {
                    i a10 = a();
                    if (LoginButton.this.f20611i) {
                        String string = LoginButton.this.getResources().getString(com.facebook.login.r.f20572d);
                        String string2 = LoginButton.this.getResources().getString(com.facebook.login.r.f20569a);
                        Profile c10 = Profile.c();
                        if (c10 == null || c10.e() == null) {
                            str = LoginButton.this.getResources().getString(com.facebook.login.r.f20575g);
                        } else {
                            str = String.format(LoginButton.this.getResources().getString(com.facebook.login.r.f20574f), new Object[]{c10.e()});
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage(str).setCancelable(true).setPositiveButton(string, new a(a10)).setNegativeButton(string2, (DialogInterface.OnClickListener) null);
                        builder.create().show();
                        return;
                    }
                    a10.p();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }

        public void onClick(View view) {
            if (!v5.a.d(this)) {
                try {
                    LoginButton.this.c(view);
                    AccessToken d10 = AccessToken.d();
                    if (AccessToken.o()) {
                        e(LoginButton.this.getContext());
                    } else {
                        d();
                    }
                    m mVar = new m(LoginButton.this.getContext());
                    Bundle bundle = new Bundle();
                    int i10 = 1;
                    if (d10 != null) {
                        i10 = 0;
                    }
                    bundle.putInt("logging_in", i10);
                    bundle.putInt("access_token_expired", AccessToken.o() ? 1 : 0);
                    mVar.g(LoginButton.this.N0, bundle);
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    public enum f {
        AUTOMATIC("automatic", 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);
        

        /* renamed from: f  reason: collision with root package name */
        public static f f20634f;

        /* renamed from: a  reason: collision with root package name */
        private String f20636a;

        /* renamed from: b  reason: collision with root package name */
        private int f20637b;

        static {
            f fVar;
            f20634f = fVar;
        }

        private f(String str, int i10) {
            this.f20636a = str;
            this.f20637b = i10;
        }

        public static f a(int i10) {
            for (f fVar : values()) {
                if (fVar.b() == i10) {
                    return fVar;
                }
            }
            return null;
        }

        public int b() {
            return this.f20637b;
        }

        public String toString() {
            return this.f20636a;
        }
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    /* access modifiers changed from: private */
    public void D(r rVar) {
        if (!v5.a.d(this) && rVar != null) {
            try {
                if (rVar.h() && getVisibility() == 0) {
                    v(rVar.g());
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private void t() {
        if (!v5.a.d(this)) {
            try {
                int i10 = c.f20619a[this.Q0.ordinal()];
                if (i10 == 1) {
                    o.p().execute(new a(p0.E(getContext())));
                } else if (i10 == 2) {
                    v(getResources().getString(com.facebook.login.r.f20576h));
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private void v(String str) {
        if (!v5.a.d(this)) {
            try {
                ToolTipPopup toolTipPopup = new ToolTipPopup(str, this);
                this.S0 = toolTipPopup;
                toolTipPopup.g(this.P0);
                this.S0.f(this.R0);
                this.S0.h();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private int x(String str) {
        if (v5.a.d(this)) {
            return 0;
        }
        try {
            return getCompoundPaddingLeft() + getCompoundDrawablePadding() + g(str) + getCompoundPaddingRight();
        } catch (Throwable th) {
            v5.a.b(th, this);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void A() {
        if (!v5.a.d(this)) {
            try {
                if (this.V0 != null) {
                    Drawable background = getBackground();
                    if (Build.VERSION.SDK_INT >= 29 && (background instanceof StateListDrawable)) {
                        StateListDrawable stateListDrawable = (StateListDrawable) background;
                        for (int i10 = 0; i10 < stateListDrawable.getStateCount(); i10++) {
                            GradientDrawable gradientDrawable = (GradientDrawable) stateListDrawable.getStateDrawable(i10);
                            if (gradientDrawable != null) {
                                gradientDrawable.setCornerRadius(this.V0.floatValue());
                            }
                        }
                    }
                    if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background).setCornerRadius(this.V0.floatValue());
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void B() {
        if (!v5.a.d(this)) {
            try {
                Resources resources = getResources();
                if (isInEditMode() || !AccessToken.o()) {
                    String str = this.f20612j;
                    if (str != null) {
                        setText(str);
                        return;
                    }
                    String string = resources.getString(getLoginButtonContinueLabel());
                    int width = getWidth();
                    if (width != 0 && x(string) > width) {
                        string = resources.getString(com.facebook.login.r.f20570b);
                    }
                    setText(string);
                    return;
                }
                String str2 = this.f20613w;
                if (str2 == null) {
                    str2 = resources.getString(com.facebook.login.r.f20573e);
                }
                setText(str2);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void C() {
        if (!v5.a.d(this)) {
            try {
                getBackground().setAlpha(this.W0);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d(Context context, AttributeSet attributeSet, int i10, int i11) {
        if (!v5.a.d(this)) {
            try {
                super.d(context, attributeSet, i10, i11);
                setInternalOnClickListener(getNewLoginClickListener());
                y(context, attributeSet, i10, i11);
                if (isInEditMode()) {
                    setBackgroundColor(getResources().getColor(u2.a.f24265a));
                    this.f20612j = "Continue with Facebook";
                } else {
                    this.T0 = new b();
                }
                B();
                A();
                C();
                z();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public String getAuthType() {
        return this.C.b();
    }

    @Nullable
    public g getCallbackManager() {
        return this.Y0;
    }

    public com.facebook.login.b getDefaultAudience() {
        return this.C.c();
    }

    /* access modifiers changed from: protected */
    public int getDefaultRequestCode() {
        if (v5.a.d(this)) {
            return 0;
        }
        try {
            return d.c.Login.a();
        } catch (Throwable th) {
            v5.a.b(th, this);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public int getDefaultStyleResource() {
        return com.facebook.login.s.f20577a;
    }

    public String getLoggerID() {
        return this.X0;
    }

    public com.facebook.login.e getLoginBehavior() {
        return this.C.d();
    }

    /* access modifiers changed from: protected */
    @StringRes
    public int getLoginButtonContinueLabel() {
        return com.facebook.login.r.f20571c;
    }

    /* access modifiers changed from: package-private */
    public i getLoginManager() {
        if (this.U0 == null) {
            this.U0 = i.e();
        }
        return this.U0;
    }

    public k getLoginTargetApp() {
        return this.C.e();
    }

    @Nullable
    public String getMessengerPageId() {
        return this.C.f();
    }

    /* access modifiers changed from: protected */
    public e getNewLoginClickListener() {
        return new e();
    }

    /* access modifiers changed from: package-private */
    public List<String> getPermissions() {
        return this.C.g();
    }

    public boolean getResetMessengerState() {
        return this.C.h();
    }

    public boolean getShouldSkipAccountDeduplication() {
        return this.C.i();
    }

    public long getToolTipDisplayTime() {
        return this.R0;
    }

    public f getToolTipMode() {
        return this.Q0;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        if (!v5.a.d(this)) {
            try {
                super.onAttachedToWindow();
                com.facebook.e eVar = this.T0;
                if (eVar != null && !eVar.c()) {
                    this.T0.e();
                    B();
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (!v5.a.d(this)) {
            try {
                super.onDetachedFromWindow();
                com.facebook.e eVar = this.T0;
                if (eVar != null) {
                    eVar.f();
                }
                u();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!v5.a.d(this)) {
            try {
                super.onDraw(canvas);
                if (!this.O0 && !isInEditMode()) {
                    this.O0 = true;
                    t();
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (!v5.a.d(this)) {
            try {
                super.onLayout(z10, i10, i11, i12, i13);
                B();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (!v5.a.d(this)) {
            try {
                Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
                int compoundPaddingTop = getCompoundPaddingTop() + ((int) Math.ceil((double) (Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom)))) + getCompoundPaddingBottom();
                Resources resources = getResources();
                int w10 = w(i10);
                String str = this.f20613w;
                if (str == null) {
                    str = resources.getString(com.facebook.login.r.f20573e);
                }
                setMeasuredDimension(View.resolveSize(Math.max(w10, x(str)), i10), compoundPaddingTop);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i10) {
        if (!v5.a.d(this)) {
            try {
                super.onVisibilityChanged(view, i10);
                if (i10 != 0) {
                    u();
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void setAuthType(String str) {
        this.C.j(str);
    }

    public void setDefaultAudience(com.facebook.login.b bVar) {
        this.C.k(bVar);
    }

    public void setLoginBehavior(com.facebook.login.e eVar) {
        this.C.l(eVar);
    }

    /* access modifiers changed from: package-private */
    public void setLoginManager(i iVar) {
        this.U0 = iVar;
    }

    public void setLoginTargetApp(k kVar) {
        this.C.m(kVar);
    }

    public void setLoginText(String str) {
        this.f20612j = str;
        B();
    }

    public void setLogoutText(String str) {
        this.f20613w = str;
        B();
    }

    public void setMessengerPageId(String str) {
        this.C.n(str);
    }

    public void setPermissions(List<String> list) {
        this.C.o(list);
    }

    /* access modifiers changed from: package-private */
    public void setProperties(d dVar) {
        this.C = dVar;
    }

    public void setPublishPermissions(List<String> list) {
        this.C.o(list);
    }

    public void setReadPermissions(List<String> list) {
        this.C.o(list);
    }

    public void setResetMessengerState(boolean z10) {
        this.C.p(z10);
    }

    public void setToolTipDisplayTime(long j10) {
        this.R0 = j10;
    }

    public void setToolTipMode(f fVar) {
        this.Q0 = fVar;
    }

    public void setToolTipStyle(ToolTipPopup.d dVar) {
        this.P0 = dVar;
    }

    public void u() {
        ToolTipPopup toolTipPopup = this.S0;
        if (toolTipPopup != null) {
            toolTipPopup.d();
            this.S0 = null;
        }
    }

    /* access modifiers changed from: protected */
    public int w(int i10) {
        if (v5.a.d(this)) {
            return 0;
        }
        try {
            Resources resources = getResources();
            String str = this.f20612j;
            if (str == null) {
                str = resources.getString(com.facebook.login.r.f20571c);
                int x10 = x(str);
                if (View.resolveSize(x10, i10) < x10) {
                    str = resources.getString(com.facebook.login.r.f20570b);
                }
            }
            return x(str);
        } catch (Throwable th) {
            v5.a.b(th, this);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void y(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes;
        if (!v5.a.d(this)) {
            try {
                this.Q0 = f.f20634f;
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, t.W, i10, i11);
                this.f20611i = obtainStyledAttributes.getBoolean(t.X, true);
                this.f20612j = obtainStyledAttributes.getString(t.f20579a0);
                this.f20613w = obtainStyledAttributes.getString(t.f20581b0);
                this.Q0 = f.a(obtainStyledAttributes.getInt(t.f20583c0, f.f20634f.b()));
                if (obtainStyledAttributes.hasValue(t.Y)) {
                    this.V0 = Float.valueOf(obtainStyledAttributes.getDimension(t.Y, 0.0f));
                }
                int integer = obtainStyledAttributes.getInteger(t.Z, 255);
                this.W0 = integer;
                if (integer < 0) {
                    this.W0 = 0;
                }
                if (this.W0 > 255) {
                    this.W0 = 255;
                }
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void z() {
        if (!v5.a.d(this)) {
            try {
                setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), u2.c.f24278a), (Drawable) null, (Drawable) null, (Drawable) null);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void setPermissions(String... strArr) {
        this.C.o(Arrays.asList(strArr));
    }

    public void setPublishPermissions(String... strArr) {
        this.C.o(Arrays.asList(strArr));
    }

    public void setReadPermissions(String... strArr) {
        this.C.o(Arrays.asList(strArr));
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }
}
