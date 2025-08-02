package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

class i {

    /* renamed from: l  reason: collision with root package name */
    private static final RectF f14335l = new RectF();

    /* renamed from: m  reason: collision with root package name */
    private static ConcurrentHashMap f14336m = new ConcurrentHashMap();

    /* renamed from: n  reason: collision with root package name */
    private static ConcurrentHashMap f14337n = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private int f14338a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14339b = false;

    /* renamed from: c  reason: collision with root package name */
    private float f14340c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f14341d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f14342e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    private int[] f14343f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    private boolean f14344g = false;

    /* renamed from: h  reason: collision with root package name */
    private TextPaint f14345h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f14346i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f14347j;

    /* renamed from: k  reason: collision with root package name */
    private final f f14348k;

    private static final class a {
        @DoNotInline
        @NonNull
        static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i10, @NonNull TextView textView, @NonNull TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i10, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        @DoNotInline
        static int b(@NonNull TextView textView) {
            return textView.getMaxLines();
        }
    }

    private static final class b {
        @DoNotInline
        static boolean a(@NonNull View view) {
            return view.isInLayout();
        }
    }

    private static final class c {
        @DoNotInline
        @NonNull
        static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i10, int i11, @NonNull TextView textView, @NonNull TextPaint textPaint, @NonNull f fVar) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i10);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i11 == -1) {
                i11 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i11);
            try {
                fVar.a(obtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return obtain.build();
        }
    }

    private static class d extends f {
        d() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) i.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    private static class e extends d {
        e() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        /* access modifiers changed from: package-private */
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    private static class f {
        f() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a(StaticLayout.Builder builder, TextView textView);

        /* access modifiers changed from: package-private */
        public boolean b(TextView textView) {
            return ((Boolean) i.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    i(TextView textView) {
        this.f14346i = textView;
        this.f14347j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f14348k = new e();
        } else {
            this.f14348k = new d();
        }
    }

    private int[] b(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f14338a = 0;
        this.f14341d = -1.0f;
        this.f14342e = -1.0f;
        this.f14340c = -1.0f;
        this.f14343f = new int[0];
        this.f14339b = false;
    }

    private int e(RectF rectF) {
        int length = this.f14343f.length;
        if (length != 0) {
            int i10 = 1;
            int i11 = length - 1;
            int i12 = 0;
            while (i10 <= i11) {
                int i13 = (i10 + i11) / 2;
                if (x(this.f14343f[i13], rectF)) {
                    int i14 = i13 + 1;
                    i12 = i10;
                    i10 = i14;
                } else {
                    i12 = i13 - 1;
                    i11 = i12;
                }
            }
            return this.f14343f[i12];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private static Method k(String str) {
        try {
            Method method = (Method) f14336m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, (Class[]) null)) != null) {
                method.setAccessible(true);
                f14336m.put(str, method);
            }
            return method;
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e10);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        android.util.Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + r4 + "() method", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return r5;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Object m(java.lang.Object r3, java.lang.String r4, java.lang.Object r5) {
        /*
            java.lang.reflect.Method r0 = k(r4)     // Catch:{ Exception -> 0x000c, all -> 0x000a }
            r1 = 0
            java.lang.Object r5 = r0.invoke(r3, r1)     // Catch:{ Exception -> 0x000c, all -> 0x000a }
            goto L_0x002a
        L_0x000a:
            r3 = move-exception
            goto L_0x000e
        L_0x000c:
            r3 = move-exception
            goto L_0x000f
        L_0x000e:
            throw r3
        L_0x000f:
            java.lang.String r0 = "ACTVAutoSizeHelper"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to invoke TextView#"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = "() method"
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            android.util.Log.w(r0, r4, r3)
        L_0x002a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i.m(java.lang.Object, java.lang.String, java.lang.Object):java.lang.Object");
    }

    private void s(float f10) {
        if (f10 != this.f14346i.getPaint().getTextSize()) {
            this.f14346i.getPaint().setTextSize(f10);
            boolean a10 = b.a(this.f14346i);
            if (this.f14346i.getLayout() != null) {
                this.f14339b = false;
                try {
                    Method k10 = k("nullLayouts");
                    if (k10 != null) {
                        k10.invoke(this.f14346i, (Object[]) null);
                    }
                } catch (Exception e10) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e10);
                }
                if (!a10) {
                    this.f14346i.requestLayout();
                } else {
                    this.f14346i.forceLayout();
                }
                this.f14346i.invalidate();
            }
        }
    }

    private boolean u() {
        if (!y() || this.f14338a != 1) {
            this.f14339b = false;
        } else {
            if (!this.f14344g || this.f14343f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f14342e - this.f14341d) / this.f14340c))) + 1;
                int[] iArr = new int[floor];
                for (int i10 = 0; i10 < floor; i10++) {
                    iArr[i10] = Math.round(this.f14341d + (((float) i10) * this.f14340c));
                }
                this.f14343f = b(iArr);
            }
            this.f14339b = true;
        }
        return this.f14339b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = typedArray.getDimensionPixelSize(i10, -1);
            }
            this.f14343f = b(iArr);
            w();
        }
    }

    private boolean w() {
        boolean z10;
        int[] iArr = this.f14343f;
        int length = iArr.length;
        if (length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f14344g = z10;
        if (z10) {
            this.f14338a = 1;
            this.f14341d = (float) iArr[0];
            this.f14342e = (float) iArr[length - 1];
            this.f14340c = -1.0f;
        }
        return z10;
    }

    private boolean x(int i10, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f14346i.getText();
        TransformationMethod transformationMethod = this.f14346i.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f14346i)) == null)) {
            text = transformation;
        }
        int b10 = a.b(this.f14346i);
        l(i10);
        StaticLayout d10 = d(text, (Layout.Alignment) m(this.f14346i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), b10);
        if ((b10 == -1 || (d10.getLineCount() <= b10 && d10.getLineEnd(d10.getLineCount() - 1) == text.length())) && ((float) d10.getHeight()) <= rectF.bottom) {
            return true;
        }
        return false;
    }

    private boolean y() {
        return !(this.f14346i instanceof AppCompatEditText);
    }

    private void z(float f10, float f11, float f12) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        } else if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        } else if (f12 > 0.0f) {
            this.f14338a = 1;
            this.f14341d = f10;
            this.f14342e = f11;
            this.f14340c = f12;
            this.f14344g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i10;
        if (n()) {
            if (this.f14339b) {
                if (this.f14346i.getMeasuredHeight() > 0 && this.f14346i.getMeasuredWidth() > 0) {
                    if (this.f14348k.b(this.f14346i)) {
                        i10 = 1048576;
                    } else {
                        i10 = (this.f14346i.getMeasuredWidth() - this.f14346i.getTotalPaddingLeft()) - this.f14346i.getTotalPaddingRight();
                    }
                    int height = (this.f14346i.getHeight() - this.f14346i.getCompoundPaddingBottom()) - this.f14346i.getCompoundPaddingTop();
                    if (i10 > 0 && height > 0) {
                        RectF rectF = f14335l;
                        synchronized (rectF) {
                            try {
                                rectF.setEmpty();
                                rectF.right = (float) i10;
                                rectF.bottom = (float) height;
                                float e10 = (float) e(rectF);
                                if (e10 != this.f14346i.getTextSize()) {
                                    t(0, e10);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f14339b = true;
        }
    }

    /* access modifiers changed from: package-private */
    public StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11) {
        return c.a(charSequence, alignment, i10, i11, this.f14346i, this.f14345h, this.f14348k);
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return Math.round(this.f14342e);
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return Math.round(this.f14341d);
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return Math.round(this.f14340c);
    }

    /* access modifiers changed from: package-private */
    public int[] i() {
        return this.f14343f;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f14338a;
    }

    /* access modifiers changed from: package-private */
    public void l(int i10) {
        TextPaint textPaint = this.f14345h;
        if (textPaint == null) {
            this.f14345h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f14345h.set(this.f14346i.getPaint());
        this.f14345h.setTextSize((float) i10);
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        if (!y() || this.f14338a == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void o(AttributeSet attributeSet, int i10) {
        float f10;
        float f11;
        float f12;
        int resourceId;
        TypedArray obtainStyledAttributes = this.f14347j.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i10, 0);
        TextView textView = this.f14346i;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), R.styleable.AppCompatTextView, attributeSet, obtainStyledAttributes, i10, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
            this.f14338a = obtainStyledAttributes.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity)) {
            f10 = obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f);
        } else {
            f10 = -1.0f;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize)) {
            f11 = obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f);
        } else {
            f11 = -1.0f;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize)) {
            f12 = obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f);
        } else {
            f12 = -1.0f;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!y()) {
            this.f14338a = 0;
        } else if (this.f14338a == 1) {
            if (!this.f14344g) {
                DisplayMetrics displayMetrics = this.f14347j.getResources().getDisplayMetrics();
                if (f11 == -1.0f) {
                    f11 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (f12 == -1.0f) {
                    f12 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (f10 == -1.0f) {
                    f10 = 1.0f;
                }
                z(f11, f12, f10);
            }
            u();
        }
    }

    /* access modifiers changed from: package-private */
    public void p(int i10, int i11, int i12, int i13) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f14347j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i13, (float) i10, displayMetrics), TypedValue.applyDimension(i13, (float) i11, displayMetrics), TypedValue.applyDimension(i13, (float) i12, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q(int[] iArr, int i10) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i10 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f14347j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArr2[i11] = Math.round(TypedValue.applyDimension(i10, (float) iArr[i11], displayMetrics));
                    }
                }
                this.f14343f = b(iArr2);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f14344g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(int i10) {
        if (!y()) {
            return;
        }
        if (i10 == 0) {
            c();
        } else if (i10 == 1) {
            DisplayMetrics displayMetrics = this.f14347j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: " + i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(int i10, float f10) {
        Resources resources;
        Context context = this.f14347j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        s(TypedValue.applyDimension(i10, f10, resources.getDisplayMetrics()));
    }
}
