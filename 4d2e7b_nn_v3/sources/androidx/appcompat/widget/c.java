package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;

class c {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f14318a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f14319b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f14320c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14321d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14322e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14323f;

    c(CompoundButton compoundButton) {
        this.f14318a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.f14318a);
        if (buttonDrawable == null) {
            return;
        }
        if (this.f14321d || this.f14322e) {
            Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
            if (this.f14321d) {
                DrawableCompat.setTintList(mutate, this.f14319b);
            }
            if (this.f14322e) {
                DrawableCompat.setTintMode(mutate, this.f14320c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f14318a.getDrawableState());
            }
            this.f14318a.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    public int b(int i10) {
        return i10;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.f14319b;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        return this.f14320c;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|(2:6|7)|9|10|(1:14)|15|(1:17)|18|(1:20)|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(android.util.AttributeSet r11, int r12) {
        /*
            r10 = this;
            android.widget.CompoundButton r0 = r10.f14318a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R.styleable.CompoundButton
            r2 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r0, r11, r1, r12, r2)
            android.widget.CompoundButton r3 = r10.f14318a
            android.content.Context r4 = r3.getContext()
            int[] r5 = androidx.appcompat.R.styleable.CompoundButton
            android.content.res.TypedArray r7 = r0.getWrappedTypeArray()
            r9 = 0
            r6 = r11
            r8 = r12
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r3, r4, r5, r6, r7, r8, r9)
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x003d }
            boolean r11 = r0.hasValue(r11)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x003f
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x003d }
            int r11 = r0.getResourceId(r11, r2)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x003f
            android.widget.CompoundButton r12 = r10.f14318a     // Catch:{ NotFoundException -> 0x003f }
            android.content.Context r1 = r12.getContext()     // Catch:{ NotFoundException -> 0x003f }
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r11)     // Catch:{ NotFoundException -> 0x003f }
            r12.setButtonDrawable(r11)     // Catch:{ NotFoundException -> 0x003f }
            goto L_0x005c
        L_0x003d:
            r11 = move-exception
            goto L_0x008c
        L_0x003f:
            int r11 = androidx.appcompat.R.styleable.CompoundButton_android_button     // Catch:{ all -> 0x003d }
            boolean r11 = r0.hasValue(r11)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x005c
            int r11 = androidx.appcompat.R.styleable.CompoundButton_android_button     // Catch:{ all -> 0x003d }
            int r11 = r0.getResourceId(r11, r2)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x005c
            android.widget.CompoundButton r12 = r10.f14318a     // Catch:{ all -> 0x003d }
            android.content.Context r1 = r12.getContext()     // Catch:{ all -> 0x003d }
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r11)     // Catch:{ all -> 0x003d }
            r12.setButtonDrawable(r11)     // Catch:{ all -> 0x003d }
        L_0x005c:
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x003d }
            boolean r11 = r0.hasValue(r11)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x006f
            android.widget.CompoundButton r11 = r10.f14318a     // Catch:{ all -> 0x003d }
            int r12 = androidx.appcompat.R.styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x003d }
            android.content.res.ColorStateList r12 = r0.getColorStateList(r12)     // Catch:{ all -> 0x003d }
            androidx.core.widget.CompoundButtonCompat.setButtonTintList(r11, r12)     // Catch:{ all -> 0x003d }
        L_0x006f:
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x003d }
            boolean r11 = r0.hasValue(r11)     // Catch:{ all -> 0x003d }
            if (r11 == 0) goto L_0x0088
            android.widget.CompoundButton r11 = r10.f14318a     // Catch:{ all -> 0x003d }
            int r12 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x003d }
            r1 = -1
            int r12 = r0.getInt(r12, r1)     // Catch:{ all -> 0x003d }
            r1 = 0
            android.graphics.PorterDuff$Mode r12 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r12, r1)     // Catch:{ all -> 0x003d }
            androidx.core.widget.CompoundButtonCompat.setButtonTintMode(r11, r12)     // Catch:{ all -> 0x003d }
        L_0x0088:
            r0.recycle()
            return
        L_0x008c:
            r0.recycle()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.c.e(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.f14323f) {
            this.f14323f = false;
            return;
        }
        this.f14323f = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void g(ColorStateList colorStateList) {
        this.f14319b = colorStateList;
        this.f14321d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void h(PorterDuff.Mode mode) {
        this.f14320c = mode;
        this.f14322e = true;
        a();
    }
}
