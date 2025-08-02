package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CheckedTextViewCompat;

class b {

    /* renamed from: a  reason: collision with root package name */
    private final CheckedTextView f14312a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f14313b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f14314c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14315d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14316e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14317f;

    b(CheckedTextView checkedTextView) {
        this.f14312a = checkedTextView;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable checkMarkDrawable = CheckedTextViewCompat.getCheckMarkDrawable(this.f14312a);
        if (checkMarkDrawable == null) {
            return;
        }
        if (this.f14315d || this.f14316e) {
            Drawable mutate = DrawableCompat.wrap(checkMarkDrawable).mutate();
            if (this.f14315d) {
                DrawableCompat.setTintList(mutate, this.f14313b);
            }
            if (this.f14316e) {
                DrawableCompat.setTintMode(mutate, this.f14314c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f14312a.getDrawableState());
            }
            this.f14312a.setCheckMarkDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f14313b;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        return this.f14314c;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|(2:6|7)|9|10|(1:14)|15|(1:17)|18|(1:20)|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(android.util.AttributeSet r11, int r12) {
        /*
            r10 = this;
            android.widget.CheckedTextView r0 = r10.f14312a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R.styleable.CheckedTextView
            r2 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r0, r11, r1, r12, r2)
            android.widget.CheckedTextView r3 = r10.f14312a
            android.content.Context r4 = r3.getContext()
            int[] r5 = androidx.appcompat.R.styleable.CheckedTextView
            android.content.res.TypedArray r7 = r0.getWrappedTypeArray()
            r9 = 0
            r6 = r11
            r8 = r12
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r3, r4, r5, r6, r7, r8, r9)
            int r11 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkCompat     // Catch:{ all -> 0x003d }
            boolean r11 = r0.hasValue(r11)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x003f
            int r11 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkCompat     // Catch:{ all -> 0x003d }
            int r11 = r0.getResourceId(r11, r2)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x003f
            android.widget.CheckedTextView r12 = r10.f14312a     // Catch:{ NotFoundException -> 0x003f }
            android.content.Context r1 = r12.getContext()     // Catch:{ NotFoundException -> 0x003f }
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r11)     // Catch:{ NotFoundException -> 0x003f }
            r12.setCheckMarkDrawable(r11)     // Catch:{ NotFoundException -> 0x003f }
            goto L_0x005c
        L_0x003d:
            r11 = move-exception
            goto L_0x008c
        L_0x003f:
            int r11 = androidx.appcompat.R.styleable.CheckedTextView_android_checkMark     // Catch:{ all -> 0x003d }
            boolean r11 = r0.hasValue(r11)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x005c
            int r11 = androidx.appcompat.R.styleable.CheckedTextView_android_checkMark     // Catch:{ all -> 0x003d }
            int r11 = r0.getResourceId(r11, r2)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x005c
            android.widget.CheckedTextView r12 = r10.f14312a     // Catch:{ all -> 0x003d }
            android.content.Context r1 = r12.getContext()     // Catch:{ all -> 0x003d }
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r11)     // Catch:{ all -> 0x003d }
            r12.setCheckMarkDrawable(r11)     // Catch:{ all -> 0x003d }
        L_0x005c:
            int r11 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkTint     // Catch:{ all -> 0x003d }
            boolean r11 = r0.hasValue(r11)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x006f
            android.widget.CheckedTextView r11 = r10.f14312a     // Catch:{ all -> 0x003d }
            int r12 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkTint     // Catch:{ all -> 0x003d }
            android.content.res.ColorStateList r12 = r0.getColorStateList(r12)     // Catch:{ all -> 0x003d }
            androidx.core.widget.CheckedTextViewCompat.setCheckMarkTintList(r11, r12)     // Catch:{ all -> 0x003d }
        L_0x006f:
            int r11 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkTintMode     // Catch:{ all -> 0x003d }
            boolean r11 = r0.hasValue(r11)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x0088
            android.widget.CheckedTextView r11 = r10.f14312a     // Catch:{ all -> 0x003d }
            int r12 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkTintMode     // Catch:{ all -> 0x003d }
            r1 = -1
            int r12 = r0.getInt(r12, r1)     // Catch:{ all -> 0x003d }
            r1 = 0
            android.graphics.PorterDuff$Mode r12 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r12, r1)     // Catch:{ all -> 0x003d }
            androidx.core.widget.CheckedTextViewCompat.setCheckMarkTintMode(r11, r12)     // Catch:{ all -> 0x003d }
        L_0x0088:
            r0.recycle()
            return
        L_0x008c:
            r0.recycle()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b.d(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.f14317f) {
            this.f14317f = false;
            return;
        }
        this.f14317f = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void f(ColorStateList colorStateList) {
        this.f14313b = colorStateList;
        this.f14315d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void g(PorterDuff.Mode mode) {
        this.f14314c = mode;
        this.f14316e = true;
        a();
    }
}
