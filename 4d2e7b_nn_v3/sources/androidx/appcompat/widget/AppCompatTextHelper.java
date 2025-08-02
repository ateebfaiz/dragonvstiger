package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f14216a;

    /* renamed from: b  reason: collision with root package name */
    private TintInfo f14217b;

    /* renamed from: c  reason: collision with root package name */
    private TintInfo f14218c;

    /* renamed from: d  reason: collision with root package name */
    private TintInfo f14219d;

    /* renamed from: e  reason: collision with root package name */
    private TintInfo f14220e;

    /* renamed from: f  reason: collision with root package name */
    private TintInfo f14221f;

    /* renamed from: g  reason: collision with root package name */
    private TintInfo f14222g;

    /* renamed from: h  reason: collision with root package name */
    private TintInfo f14223h;

    /* renamed from: i  reason: collision with root package name */
    private final i f14224i;

    /* renamed from: j  reason: collision with root package name */
    private int f14225j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f14226k = -1;

    /* renamed from: l  reason: collision with root package name */
    private Typeface f14227l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f14228m;

    class a extends ResourcesCompat.FontCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f14229a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f14230b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WeakReference f14231c;

        a(int i10, int i11, WeakReference weakReference) {
            this.f14229a = i10;
            this.f14230b = i11;
            this.f14231c = weakReference;
        }

        public void onFontRetrievalFailed(int i10) {
        }

        public void onFontRetrieved(Typeface typeface) {
            int i10;
            boolean z10;
            if (Build.VERSION.SDK_INT >= 28 && (i10 = this.f14229a) != -1) {
                if ((this.f14230b & 2) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                typeface = g.a(typeface, i10, z10);
            }
            AppCompatTextHelper.this.n(this.f14231c, typeface);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f14233a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Typeface f14234b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f14235c;

        b(TextView textView, Typeface typeface, int i10) {
            this.f14233a = textView;
            this.f14234b = typeface;
            this.f14235c = i10;
        }

        public void run() {
            this.f14233a.setTypeface(this.f14234b, this.f14235c);
        }
    }

    static class c {
        @DoNotInline
        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        @DoNotInline
        static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        @DoNotInline
        static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    static class d {
        @DoNotInline
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    static class e {
        @DoNotInline
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        @DoNotInline
        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    static class f {
        @DoNotInline
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @DoNotInline
        static void b(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        @DoNotInline
        static void c(TextView textView, int[] iArr, int i10) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        @DoNotInline
        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    static class g {
        @DoNotInline
        static Typeface a(Typeface typeface, int i10, boolean z10) {
            return Typeface.create(typeface, i10, z10);
        }
    }

    AppCompatTextHelper(TextView textView) {
        this.f14216a = textView;
        this.f14224i = new i(textView);
    }

    private void B(int i10, float f10) {
        this.f14224i.t(i10, f10);
    }

    private void C(Context context, TintTypedArray tintTypedArray) {
        int i10;
        String string;
        boolean z10;
        boolean z11;
        this.f14225j = tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.f14225j);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            int i12 = tintTypedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.f14226k = i12;
            if (i12 != -1) {
                this.f14225j &= 2;
            }
        }
        boolean z12 = true;
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_fontFamily) || tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
            this.f14227l = null;
            if (tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
                i10 = R.styleable.TextAppearance_fontFamily;
            } else {
                i10 = R.styleable.TextAppearance_android_fontFamily;
            }
            int i13 = this.f14226k;
            int i14 = this.f14225j;
            if (!context.isRestricted()) {
                try {
                    Typeface font = tintTypedArray.getFont(i10, this.f14225j, new a(i13, i14, new WeakReference(this.f14216a)));
                    if (font != null) {
                        if (i11 < 28 || this.f14226k == -1) {
                            this.f14227l = font;
                        } else {
                            Typeface create = Typeface.create(font, 0);
                            int i15 = this.f14226k;
                            if ((this.f14225j & 2) != 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            this.f14227l = g.a(create, i15, z11);
                        }
                    }
                    if (this.f14227l == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f14228m = z10;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f14227l == null && (string = tintTypedArray.getString(i10)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f14226k == -1) {
                    this.f14227l = Typeface.create(string, this.f14225j);
                    return;
                }
                Typeface create2 = Typeface.create(string, 0);
                int i16 = this.f14226k;
                if ((this.f14225j & 2) == 0) {
                    z12 = false;
                }
                this.f14227l = g.a(create2, i16, z12);
            }
        } else if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_typeface)) {
            this.f14228m = false;
            int i17 = tintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, 1);
            if (i17 == 1) {
                this.f14227l = Typeface.SANS_SERIF;
            } else if (i17 == 2) {
                this.f14227l = Typeface.SERIF;
            } else if (i17 == 3) {
                this.f14227l = Typeface.MONOSPACE;
            }
        }
    }

    private void a(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.f14216a.getDrawableState());
        }
    }

    private static TintInfo d(Context context, AppCompatDrawableManager appCompatDrawableManager, int i10) {
        ColorStateList tintList = appCompatDrawableManager.getTintList(context, i10);
        if (tintList == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = tintList;
        return tintInfo;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] a10 = c.a(this.f14216a);
            TextView textView = this.f14216a;
            if (drawable5 == null) {
                drawable5 = a10[0];
            }
            if (drawable2 == null) {
                drawable2 = a10[1];
            }
            if (drawable6 == null) {
                drawable6 = a10[2];
            }
            if (drawable4 == null) {
                drawable4 = a10[3];
            }
            c.b(textView, drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] a11 = c.a(this.f14216a);
            Drawable drawable7 = a11[0];
            if (drawable7 == null && a11[2] == null) {
                Drawable[] compoundDrawables = this.f14216a.getCompoundDrawables();
                TextView textView2 = this.f14216a;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                return;
            }
            TextView textView3 = this.f14216a;
            if (drawable2 == null) {
                drawable2 = a11[1];
            }
            Drawable drawable8 = a11[2];
            if (drawable4 == null) {
                drawable4 = a11[3];
            }
            c.b(textView3, drawable7, drawable2, drawable8, drawable4);
        }
    }

    private void z() {
        TintInfo tintInfo = this.f14223h;
        this.f14217b = tintInfo;
        this.f14218c = tintInfo;
        this.f14219d = tintInfo;
        this.f14220e = tintInfo;
        this.f14221f = tintInfo;
        this.f14222g = tintInfo;
    }

    /* access modifiers changed from: package-private */
    public void A(int i10, float f10) {
        if (!ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && !l()) {
            B(i10, f10);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!(this.f14217b == null && this.f14218c == null && this.f14219d == null && this.f14220e == null)) {
            Drawable[] compoundDrawables = this.f14216a.getCompoundDrawables();
            a(compoundDrawables[0], this.f14217b);
            a(compoundDrawables[1], this.f14218c);
            a(compoundDrawables[2], this.f14219d);
            a(compoundDrawables[3], this.f14220e);
        }
        if (this.f14221f != null || this.f14222g != null) {
            Drawable[] a10 = c.a(this.f14216a);
            a(a10[0], this.f14221f);
            a(a10[2], this.f14222g);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f14224i.a();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f14224i.f();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f14224i.g();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f14224i.h();
    }

    /* access modifiers changed from: package-private */
    public int[] h() {
        return this.f14224i.i();
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f14224i.j();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList j() {
        TintInfo tintInfo = this.f14223h;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        TintInfo tintInfo = this.f14223h;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.f14224i.n();
    }

    /* access modifiers changed from: package-private */
    public void m(AttributeSet attributeSet, int i10) {
        String str;
        boolean z10;
        boolean z11;
        String str2;
        boolean z12;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        AttributeSet attributeSet2 = attributeSet;
        int i11 = i10;
        Context context = this.f14216a.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet2, R.styleable.AppCompatTextHelper, i11, 0);
        TextView textView = this.f14216a;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), R.styleable.AppCompatTextHelper, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i10, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f14217b = d(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f14218c = d(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.f14219d = d(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.f14220e = d(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableStart)) {
            this.f14221f = d(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.f14222g = d(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        obtainStyledAttributes.recycle();
        boolean z13 = this.f14216a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (resourceId != -1) {
            TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, resourceId, R.styleable.TextAppearance);
            if (z13 || !obtainStyledAttributes2.hasValue(R.styleable.TextAppearance_textAllCaps)) {
                z11 = false;
                z10 = false;
            } else {
                z11 = obtainStyledAttributes2.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
                z10 = true;
            }
            C(context, obtainStyledAttributes2);
            if (obtainStyledAttributes2.hasValue(R.styleable.TextAppearance_textLocale)) {
                str = obtainStyledAttributes2.getString(R.styleable.TextAppearance_textLocale);
            } else {
                str = null;
            }
            if (i12 < 26 || !obtainStyledAttributes2.hasValue(R.styleable.TextAppearance_fontVariationSettings)) {
                str2 = null;
            } else {
                str2 = obtainStyledAttributes2.getString(R.styleable.TextAppearance_fontVariationSettings);
            }
            obtainStyledAttributes2.recycle();
        } else {
            z11 = false;
            z10 = false;
            str2 = null;
            str = null;
        }
        TintTypedArray obtainStyledAttributes3 = TintTypedArray.obtainStyledAttributes(context, attributeSet2, R.styleable.TextAppearance, i11, 0);
        if (z13 || !obtainStyledAttributes3.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            z12 = z10;
        } else {
            z11 = obtainStyledAttributes3.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
            z12 = true;
        }
        if (obtainStyledAttributes3.hasValue(R.styleable.TextAppearance_textLocale)) {
            str = obtainStyledAttributes3.getString(R.styleable.TextAppearance_textLocale);
        }
        if (i12 >= 26 && obtainStyledAttributes3.hasValue(R.styleable.TextAppearance_fontVariationSettings)) {
            str2 = obtainStyledAttributes3.getString(R.styleable.TextAppearance_fontVariationSettings);
        }
        if (i12 >= 28 && obtainStyledAttributes3.hasValue(R.styleable.TextAppearance_android_textSize) && obtainStyledAttributes3.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f14216a.setTextSize(0, 0.0f);
        }
        C(context, obtainStyledAttributes3);
        obtainStyledAttributes3.recycle();
        if (!z13 && z12) {
            s(z11);
        }
        Typeface typeface = this.f14227l;
        if (typeface != null) {
            if (this.f14226k == -1) {
                this.f14216a.setTypeface(typeface, this.f14225j);
            } else {
                this.f14216a.setTypeface(typeface);
            }
        }
        if (str2 != null) {
            f.d(this.f14216a, str2);
        }
        if (str != null) {
            if (i12 >= 24) {
                e.b(this.f14216a, e.a(str));
            } else {
                c.c(this.f14216a, d.a(str.split(",")[0]));
            }
        }
        this.f14224i.o(attributeSet2, i11);
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && this.f14224i.j() != 0) {
            int[] i13 = this.f14224i.i();
            if (i13.length > 0) {
                if (((float) f.a(this.f14216a)) != -1.0f) {
                    f.b(this.f14216a, this.f14224i.g(), this.f14224i.f(), this.f14224i.h(), 0);
                } else {
                    f.c(this.f14216a, i13, 0);
                }
            }
        }
        TintTypedArray obtainStyledAttributes4 = TintTypedArray.obtainStyledAttributes(context, attributeSet2, R.styleable.AppCompatTextView);
        int resourceId2 = obtainStyledAttributes4.getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        if (resourceId2 != -1) {
            drawable = appCompatDrawableManager.getDrawable(context, resourceId2);
        } else {
            drawable = null;
        }
        int resourceId3 = obtainStyledAttributes4.getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        if (resourceId3 != -1) {
            drawable2 = appCompatDrawableManager.getDrawable(context, resourceId3);
        } else {
            drawable2 = null;
        }
        int resourceId4 = obtainStyledAttributes4.getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        if (resourceId4 != -1) {
            drawable3 = appCompatDrawableManager.getDrawable(context, resourceId4);
        } else {
            drawable3 = null;
        }
        int resourceId5 = obtainStyledAttributes4.getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        if (resourceId5 != -1) {
            drawable4 = appCompatDrawableManager.getDrawable(context, resourceId5);
        } else {
            drawable4 = null;
        }
        int resourceId6 = obtainStyledAttributes4.getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        if (resourceId6 != -1) {
            drawable5 = appCompatDrawableManager.getDrawable(context, resourceId6);
        } else {
            drawable5 = null;
        }
        int resourceId7 = obtainStyledAttributes4.getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        if (resourceId7 != -1) {
            drawable6 = appCompatDrawableManager.getDrawable(context, resourceId7);
        } else {
            drawable6 = null;
        }
        y(drawable, drawable2, drawable3, drawable4, drawable5, drawable6);
        if (obtainStyledAttributes4.hasValue(R.styleable.AppCompatTextView_drawableTint)) {
            TextViewCompat.setCompoundDrawableTintList(this.f14216a, obtainStyledAttributes4.getColorStateList(R.styleable.AppCompatTextView_drawableTint));
        }
        if (obtainStyledAttributes4.hasValue(R.styleable.AppCompatTextView_drawableTintMode)) {
            TextViewCompat.setCompoundDrawableTintMode(this.f14216a, DrawableUtils.parseTintMode(obtainStyledAttributes4.getInt(R.styleable.AppCompatTextView_drawableTintMode, -1), (PorterDuff.Mode) null));
        }
        int dimensionPixelSize = obtainStyledAttributes4.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int dimensionPixelSize2 = obtainStyledAttributes4.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int dimensionPixelSize3 = obtainStyledAttributes4.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, -1);
        obtainStyledAttributes4.recycle();
        if (dimensionPixelSize != -1) {
            TextViewCompat.setFirstBaselineToTopHeight(this.f14216a, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != -1) {
            TextViewCompat.setLastBaselineToBottomHeight(this.f14216a, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != -1) {
            TextViewCompat.setLineHeight(this.f14216a, dimensionPixelSize3);
        }
    }

    /* access modifiers changed from: package-private */
    public void n(WeakReference weakReference, Typeface typeface) {
        if (this.f14228m) {
            this.f14227l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView == null) {
                return;
            }
            if (ViewCompat.isAttachedToWindow(textView)) {
                textView.post(new b(textView, typeface, this.f14225j));
            } else {
                textView.setTypeface(typeface, this.f14225j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(boolean z10, int i10, int i11, int i12, int i13) {
        if (!ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* access modifiers changed from: package-private */
    public void q(Context context, int i10) {
        String string;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i10, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_textAllCaps)) {
            s(obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
        }
        int i11 = Build.VERSION.SDK_INT;
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textSize) && obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f14216a.setTextSize(0, 0.0f);
        }
        C(context, obtainStyledAttributes);
        if (i11 >= 26 && obtainStyledAttributes.hasValue(R.styleable.TextAppearance_fontVariationSettings) && (string = obtainStyledAttributes.getString(R.styleable.TextAppearance_fontVariationSettings)) != null) {
            f.d(this.f14216a, string);
        }
        obtainStyledAttributes.recycle();
        Typeface typeface = this.f14227l;
        if (typeface != null) {
            this.f14216a.setTypeface(typeface, this.f14225j);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            EditorInfoCompat.setInitialSurroundingText(editorInfo, textView.getText());
        }
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z10) {
        this.f14216a.setAllCaps(z10);
    }

    /* access modifiers changed from: package-private */
    public void t(int i10, int i11, int i12, int i13) {
        this.f14224i.p(i10, i11, i12, i13);
    }

    /* access modifiers changed from: package-private */
    public void u(int[] iArr, int i10) {
        this.f14224i.q(iArr, i10);
    }

    /* access modifiers changed from: package-private */
    public void v(int i10) {
        this.f14224i.r(i10);
    }

    /* access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        boolean z10;
        if (this.f14223h == null) {
            this.f14223h = new TintInfo();
        }
        TintInfo tintInfo = this.f14223h;
        tintInfo.mTintList = colorStateList;
        if (colorStateList != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        tintInfo.mHasTintList = z10;
        z();
    }

    /* access modifiers changed from: package-private */
    public void x(PorterDuff.Mode mode) {
        boolean z10;
        if (this.f14223h == null) {
            this.f14223h = new TintInfo();
        }
        TintInfo tintInfo = this.f14223h;
        tintInfo.mTintMode = mode;
        if (mode != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        tintInfo.mHasTintMode = z10;
        z();
    }
}
