package com.yalantis.ucrop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import jb.i;

public class UCropActivity extends AppCompatActivity {
    public static final int ALL = 3;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    public static final int SCALE = 1;
    /* access modifiers changed from: private */
    public UCropView C;
    private ViewGroup N0;
    private ViewGroup O0;
    private ViewGroup P0;
    private ViewGroup Q0;
    private ViewGroup R0;
    /* access modifiers changed from: private */
    public List S0 = new ArrayList();
    private TextView T0;
    private TextView U0;
    /* access modifiers changed from: private */
    public View V0;
    private Transition W0;
    /* access modifiers changed from: private */
    public GestureCropImageView X;
    private Bitmap.CompressFormat X0 = DEFAULT_COMPRESS_FORMAT;
    private OverlayView Y;
    private int Y0 = 90;
    private ViewGroup Z;
    private int[] Z0 = {1, 2, 3};

    /* renamed from: a  reason: collision with root package name */
    private String f11739a;

    /* renamed from: a1  reason: collision with root package name */
    private TransformImageView.b f11740a1 = new a();

    /* renamed from: b  reason: collision with root package name */
    private int f11741b;

    /* renamed from: b1  reason: collision with root package name */
    private final View.OnClickListener f11742b1 = new g();

    /* renamed from: c  reason: collision with root package name */
    private int f11743c;

    /* renamed from: d  reason: collision with root package name */
    private int f11744d;

    /* renamed from: e  reason: collision with root package name */
    private int f11745e;

    /* renamed from: f  reason: collision with root package name */
    private int f11746f;

    /* renamed from: g  reason: collision with root package name */
    private int f11747g;

    /* renamed from: h  reason: collision with root package name */
    private int f11748h;

    /* renamed from: i  reason: collision with root package name */
    private int f11749i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11750j;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f11751w = true;

    class a implements TransformImageView.b {
        a() {
        }

        public void a(float f10) {
            UCropActivity.this.y(f10);
        }

        public void b() {
            UCropActivity.this.C.animate().alpha(1.0f).setDuration(300).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.V0.setClickable(false);
            boolean unused = UCropActivity.this.f11751w = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        public void c(Exception exc) {
            UCropActivity.this.C(exc);
            UCropActivity.this.finish();
        }

        public void d(float f10) {
            UCropActivity.this.E(f10);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            boolean z10;
            UCropActivity.this.X.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).b(view.isSelected()));
            UCropActivity.this.X.x();
            if (!view.isSelected()) {
                for (ViewGroup viewGroup : UCropActivity.this.S0) {
                    if (viewGroup == view) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    viewGroup.setSelected(z10);
                }
            }
        }
    }

    class c implements HorizontalProgressWheelView.a {
        c() {
        }

        public void a() {
            UCropActivity.this.X.x();
        }

        public void b(float f10, float f11) {
            UCropActivity.this.X.v(f10 / 42.0f);
        }

        public void c() {
            UCropActivity.this.X.r();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            UCropActivity.this.v();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            UCropActivity.this.w(90);
        }
    }

    class f implements HorizontalProgressWheelView.a {
        f() {
        }

        public void a() {
            UCropActivity.this.X.x();
        }

        public void b(float f10, float f11) {
            if (f10 > 0.0f) {
                UCropActivity.this.X.A(UCropActivity.this.X.getCurrentScale() + (f10 * ((UCropActivity.this.X.getMaxScale() - UCropActivity.this.X.getMinScale()) / 15000.0f)));
            } else {
                UCropActivity.this.X.C(UCropActivity.this.X.getCurrentScale() + (f10 * ((UCropActivity.this.X.getMaxScale() - UCropActivity.this.X.getMinScale()) / 15000.0f)));
            }
        }

        public void c() {
            UCropActivity.this.X.r();
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropActivity.this.H(view.getId());
            }
        }
    }

    class h implements gb.a {
        h() {
        }

        public void a(Uri uri, int i10, int i11, int i12, int i13) {
            UCropActivity uCropActivity = UCropActivity.this;
            uCropActivity.D(uri, uCropActivity.X.getTargetAspectRatio(), i10, i11, i12, i13);
            UCropActivity.this.finish();
        }

        public void b(Throwable th) {
            UCropActivity.this.C(th);
            UCropActivity.this.finish();
        }
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private void A(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.InputUri");
        Uri uri2 = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        u(intent);
        if (uri == null || uri2 == null) {
            C(new NullPointerException(getString(fb.g.f12138a)));
            finish();
            return;
        }
        try {
            this.X.l(uri, uri2);
        } catch (Exception e10) {
            C(e10);
            finish();
        }
    }

    private void B() {
        if (!this.f11750j) {
            x(0);
        } else if (this.Z.getVisibility() == 0) {
            H(fb.d.f12120n);
        } else {
            H(fb.d.f12122p);
        }
    }

    /* access modifiers changed from: private */
    public void E(float f10) {
        TextView textView = this.U0;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf((int) (f10 * 100.0f))}));
        }
    }

    private void F(int i10) {
        TextView textView = this.U0;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    private void G(int i10) {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i10);
        }
    }

    /* access modifiers changed from: private */
    public void H(int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        int i11;
        int i12;
        if (this.f11750j) {
            ViewGroup viewGroup = this.Z;
            if (i10 == fb.d.f12120n) {
                z10 = true;
            } else {
                z10 = false;
            }
            viewGroup.setSelected(z10);
            ViewGroup viewGroup2 = this.N0;
            if (i10 == fb.d.f12121o) {
                z11 = true;
            } else {
                z11 = false;
            }
            viewGroup2.setSelected(z11);
            ViewGroup viewGroup3 = this.O0;
            if (i10 == fb.d.f12122p) {
                z12 = true;
            } else {
                z12 = false;
            }
            viewGroup3.setSelected(z12);
            ViewGroup viewGroup4 = this.P0;
            int i13 = 8;
            if (i10 == fb.d.f12120n) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            viewGroup4.setVisibility(i11);
            ViewGroup viewGroup5 = this.Q0;
            if (i10 == fb.d.f12121o) {
                i12 = 0;
            } else {
                i12 = 8;
            }
            viewGroup5.setVisibility(i12);
            ViewGroup viewGroup6 = this.R0;
            if (i10 == fb.d.f12122p) {
                i13 = 0;
            }
            viewGroup6.setVisibility(i13);
            r(i10);
            if (i10 == fb.d.f12122p) {
                x(0);
            } else if (i10 == fb.d.f12121o) {
                x(1);
            } else {
                x(2);
            }
        }
    }

    private void I() {
        G(this.f11743c);
        Toolbar toolbar = (Toolbar) findViewById(fb.d.f12126t);
        toolbar.setBackgroundColor(this.f11741b);
        toolbar.setTitleTextColor(this.f11745e);
        TextView textView = (TextView) toolbar.findViewById(fb.d.f12127u);
        textView.setTextColor(this.f11745e);
        textView.setText(this.f11739a);
        Drawable mutate = ContextCompat.getDrawable(this, this.f11747g).mutate();
        mutate.setColorFilter(this.f11745e, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(mutate);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void J(Intent intent) {
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio((String) null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(fb.g.f12140c).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio((String) null, 16.0f, 9.0f));
            intExtra = 2;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(fb.d.f12113g);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(fb.e.f12134b, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.f11744d);
            aspectRatioTextView.setAspectRatio((AspectRatio) it.next());
            linearLayout.addView(frameLayout);
            this.S0.add(frameLayout);
        }
        ((ViewGroup) this.S0.get(intExtra)).setSelected(true);
        for (ViewGroup onClickListener : this.S0) {
            onClickListener.setOnClickListener(new b());
        }
    }

    private void K() {
        this.T0 = (TextView) findViewById(fb.d.f12124r);
        ((HorizontalProgressWheelView) findViewById(fb.d.f12118l)).setScrollingListener(new c());
        ((HorizontalProgressWheelView) findViewById(fb.d.f12118l)).setMiddleLineColor(this.f11744d);
        findViewById(fb.d.f12132z).setOnClickListener(new d());
        findViewById(fb.d.A).setOnClickListener(new e());
        z(this.f11744d);
    }

    private void L() {
        this.U0 = (TextView) findViewById(fb.d.f12125s);
        ((HorizontalProgressWheelView) findViewById(fb.d.f12119m)).setScrollingListener(new f());
        ((HorizontalProgressWheelView) findViewById(fb.d.f12119m)).setMiddleLineColor(this.f11744d);
        F(this.f11744d);
    }

    private void M() {
        ImageView imageView = (ImageView) findViewById(fb.d.f12112f);
        ImageView imageView2 = (ImageView) findViewById(fb.d.f12111e);
        ImageView imageView3 = (ImageView) findViewById(fb.d.f12110d);
        imageView.setImageDrawable(new i(imageView.getDrawable(), this.f11744d));
        imageView2.setImageDrawable(new i(imageView2.getDrawable(), this.f11744d));
        imageView3.setImageDrawable(new i(imageView3.getDrawable(), this.f11744d));
    }

    private void N(Intent intent) {
        this.f11743c = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", ContextCompat.getColor(this, fb.a.f12089h));
        this.f11741b = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", ContextCompat.getColor(this, fb.a.f12090i));
        this.f11744d = intent.getIntExtra("com.yalantis.ucrop.UcropColorControlsWidgetActive", ContextCompat.getColor(this, fb.a.f12082a));
        this.f11745e = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", ContextCompat.getColor(this, fb.a.f12091j));
        this.f11747g = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", fb.c.f12105a);
        this.f11748h = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", fb.c.f12106b);
        String stringExtra = intent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
        this.f11739a = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(fb.g.f12139b);
        }
        this.f11739a = stringExtra;
        this.f11749i = intent.getIntExtra("com.yalantis.ucrop.UcropLogoColor", ContextCompat.getColor(this, fb.a.f12087f));
        this.f11750j = !intent.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false);
        this.f11746f = intent.getIntExtra("com.yalantis.ucrop.UcropRootViewBackgroundColor", ContextCompat.getColor(this, fb.a.f12083b));
        I();
        t();
        if (this.f11750j) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(fb.d.f12130x)).findViewById(fb.d.f12107a);
            viewGroup.setVisibility(0);
            LayoutInflater.from(this).inflate(fb.e.f12135c, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.W0 = autoTransition;
            autoTransition.setDuration(50);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(fb.d.f12120n);
            this.Z = viewGroup2;
            viewGroup2.setOnClickListener(this.f11742b1);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(fb.d.f12121o);
            this.N0 = viewGroup3;
            viewGroup3.setOnClickListener(this.f11742b1);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(fb.d.f12122p);
            this.O0 = viewGroup4;
            viewGroup4.setOnClickListener(this.f11742b1);
            this.P0 = (ViewGroup) findViewById(fb.d.f12113g);
            this.Q0 = (ViewGroup) findViewById(fb.d.f12114h);
            this.R0 = (ViewGroup) findViewById(fb.d.f12115i);
            J(intent);
            K();
            L();
            M();
        }
    }

    private void q() {
        if (this.V0 == null) {
            this.V0 = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, fb.d.f12126t);
            this.V0.setLayoutParams(layoutParams);
            this.V0.setClickable(true);
        }
        ((RelativeLayout) findViewById(fb.d.f12130x)).addView(this.V0);
    }

    private void r(int i10) {
        int i11;
        int i12;
        TransitionManager.beginDelayedTransition((ViewGroup) findViewById(fb.d.f12130x), this.W0);
        View findViewById = this.O0.findViewById(fb.d.f12125s);
        int i13 = 8;
        if (i10 == fb.d.f12122p) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        findViewById.setVisibility(i11);
        View findViewById2 = this.Z.findViewById(fb.d.f12123q);
        if (i10 == fb.d.f12120n) {
            i12 = 0;
        } else {
            i12 = 8;
        }
        findViewById2.setVisibility(i12);
        View findViewById3 = this.N0.findViewById(fb.d.f12124r);
        if (i10 == fb.d.f12121o) {
            i13 = 0;
        }
        findViewById3.setVisibility(i13);
    }

    private void t() {
        UCropView uCropView = (UCropView) findViewById(fb.d.f12128v);
        this.C = uCropView;
        this.X = uCropView.getCropImageView();
        this.Y = this.C.getOverlayView();
        this.X.setTransformImageListener(this.f11740a1);
        ((ImageView) findViewById(fb.d.f12109c)).setColorFilter(this.f11749i, PorterDuff.Mode.SRC_ATOP);
        findViewById(fb.d.f12129w).setBackgroundColor(this.f11746f);
        if (!this.f11750j) {
            ((RelativeLayout.LayoutParams) findViewById(fb.d.f12129w).getLayoutParams()).bottomMargin = 0;
            findViewById(fb.d.f12129w).requestLayout();
        }
    }

    private void u(Intent intent) {
        Bitmap.CompressFormat compressFormat;
        String stringExtra = intent.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
        if (!TextUtils.isEmpty(stringExtra)) {
            compressFormat = Bitmap.CompressFormat.valueOf(stringExtra);
        } else {
            compressFormat = null;
        }
        if (compressFormat == null) {
            compressFormat = DEFAULT_COMPRESS_FORMAT;
        }
        this.X0 = compressFormat;
        this.Y0 = intent.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
        int[] intArrayExtra = intent.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.Z0 = intArrayExtra;
        }
        this.X.setMaxBitmapSize(intent.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.X.setMaxScaleMultiplier(intent.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.X.setImageToWrapCropBoundsAnimDuration((long) intent.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.Y.setFreestyleCropEnabled(intent.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
        this.Y.setDimmedColor(intent.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(fb.a.f12086e)));
        this.Y.setCircleDimmedLayer(intent.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.Y.setShowCropFrame(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
        this.Y.setCropFrameColor(intent.getIntExtra("com.yalantis.ucrop.CropFrameColor", getResources().getColor(fb.a.f12084c)));
        this.Y.setCropFrameStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(fb.b.f12095a)));
        this.Y.setShowCropGrid(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
        this.Y.setCropGridRowCount(intent.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
        this.Y.setCropGridColumnCount(intent.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.Y.setCropGridColor(intent.getIntExtra("com.yalantis.ucrop.CropGridColor", getResources().getColor(fb.a.f12085d)));
        this.Y.setCropGridCornerColor(intent.getIntExtra("com.yalantis.ucrop.CropGridCornerColor", getResources().getColor(fb.a.f12085d)));
        this.Y.setCropGridStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(fb.b.f12096b)));
        float floatExtra = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioX", 0.0f);
        float floatExtra2 = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioY", 0.0f);
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (floatExtra > 0.0f && floatExtra2 > 0.0f) {
            ViewGroup viewGroup = this.Z;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.X.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra == null || intExtra >= parcelableArrayListExtra.size()) {
            this.X.setTargetAspectRatio(0.0f);
        } else {
            this.X.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra.get(intExtra)).b() / ((AspectRatio) parcelableArrayListExtra.get(intExtra)).c());
        }
        int intExtra2 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
        int intExtra3 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
        if (intExtra2 > 0 && intExtra3 > 0) {
            this.X.setMaxResultImageSizeX(intExtra2);
            this.X.setMaxResultImageSizeY(intExtra3);
        }
    }

    /* access modifiers changed from: private */
    public void v() {
        GestureCropImageView gestureCropImageView = this.X;
        gestureCropImageView.v(-gestureCropImageView.getCurrentAngle());
        this.X.x();
    }

    /* access modifiers changed from: private */
    public void w(int i10) {
        this.X.v((float) i10);
        this.X.x();
    }

    private void x(int i10) {
        boolean z10;
        GestureCropImageView gestureCropImageView = this.X;
        int i11 = this.Z0[i10];
        boolean z11 = false;
        if (i11 == 3 || i11 == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        gestureCropImageView.setScaleEnabled(z10);
        GestureCropImageView gestureCropImageView2 = this.X;
        int i12 = this.Z0[i10];
        if (i12 == 3 || i12 == 2) {
            z11 = true;
        }
        gestureCropImageView2.setRotateEnabled(z11);
    }

    /* access modifiers changed from: private */
    public void y(float f10) {
        TextView textView = this.T0;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", new Object[]{Float.valueOf(f10)}));
        }
    }

    private void z(int i10) {
        TextView textView = this.T0;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    /* access modifiers changed from: protected */
    public void C(Throwable th) {
        setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", th));
    }

    /* access modifiers changed from: protected */
    public void D(Uri uri, float f10, int i10, int i11, int i12, int i13) {
        setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uri).putExtra("com.yalantis.ucrop.CropAspectRatio", f10).putExtra("com.yalantis.ucrop.ImageWidth", i12).putExtra("com.yalantis.ucrop.ImageHeight", i13).putExtra("com.yalantis.ucrop.OffsetX", i10).putExtra("com.yalantis.ucrop.OffsetY", i11));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(fb.e.f12133a);
        Intent intent = getIntent();
        N(intent);
        A(intent);
        B();
        q();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(fb.f.f12137a, menu);
        MenuItem findItem = menu.findItem(fb.d.f12117k);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.f11745e, PorterDuff.Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (IllegalStateException e10) {
                Log.i("UCropActivity", String.format("%s - %s", new Object[]{e10.getMessage(), getString(fb.g.f12141d)}));
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(fb.d.f12116j);
        Drawable drawable = ContextCompat.getDrawable(this, this.f11748h);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(this.f11745e, PorterDuff.Mode.SRC_ATOP);
            findItem2.setIcon(drawable);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == fb.d.f12116j) {
            s();
            return true;
        } else if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            onBackPressed();
            return true;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(fb.d.f12116j).setVisible(!this.f11751w);
        menu.findItem(fb.d.f12117k).setVisible(this.f11751w);
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.X;
        if (gestureCropImageView != null) {
            gestureCropImageView.r();
        }
    }

    /* access modifiers changed from: protected */
    public void s() {
        this.V0.setClickable(true);
        this.f11751w = true;
        supportInvalidateOptionsMenu();
        this.X.s(this.X0, this.Y0, new h());
    }
}
