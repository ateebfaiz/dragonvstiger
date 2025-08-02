package com.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import e2.m;
import q5.u;
import u2.g;

public abstract class FacebookButtonBase extends Button {

    /* renamed from: a  reason: collision with root package name */
    private String f19508a;

    /* renamed from: b  reason: collision with root package name */
    private String f19509b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnClickListener f19510c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f19511d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19512e;

    /* renamed from: f  reason: collision with root package name */
    private int f19513f;

    /* renamed from: g  reason: collision with root package name */
    private int f19514g;

    /* renamed from: h  reason: collision with root package name */
    private u f19515h;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            if (!v5.a.d(this)) {
                try {
                    FacebookButtonBase facebookButtonBase = FacebookButtonBase.this;
                    facebookButtonBase.f(facebookButtonBase.getContext());
                    if (FacebookButtonBase.a(FacebookButtonBase.this) != null) {
                        FacebookButtonBase.a(FacebookButtonBase.this).onClick(view);
                    } else if (FacebookButtonBase.b(FacebookButtonBase.this) != null) {
                        FacebookButtonBase.b(FacebookButtonBase.this).onClick(view);
                    }
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    protected FacebookButtonBase(Context context, AttributeSet attributeSet, int i10, int i11, String str, String str2) {
        super(context, attributeSet, 0);
        i11 = i11 == 0 ? getDefaultStyleResource() : i11;
        d(context, attributeSet, i10, i11 == 0 ? g.f24302c : i11);
        this.f19508a = str;
        this.f19509b = str2;
        setClickable(true);
        setFocusable(true);
    }

    static /* synthetic */ View.OnClickListener a(FacebookButtonBase facebookButtonBase) {
        Class<FacebookButtonBase> cls = FacebookButtonBase.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return facebookButtonBase.f19511d;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    static /* synthetic */ View.OnClickListener b(FacebookButtonBase facebookButtonBase) {
        Class<FacebookButtonBase> cls = FacebookButtonBase.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return facebookButtonBase.f19510c;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private void h(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes;
        if (!v5.a.d(this)) {
            try {
                if (!isInEditMode()) {
                    obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842964}, i10, i11);
                    if (obtainStyledAttributes.hasValue(0)) {
                        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                        if (resourceId != 0) {
                            setBackgroundResource(resourceId);
                        } else {
                            setBackgroundColor(obtainStyledAttributes.getColor(0, 0));
                        }
                    } else {
                        setBackgroundColor(ContextCompat.getColor(context, u2.a.f24265a));
                    }
                    obtainStyledAttributes.recycle();
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private void i(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes;
        if (!v5.a.d(this)) {
            try {
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16843119, 16843117, 16843120, 16843118, 16843121}, i10, i11);
                setCompoundDrawablesWithIntrinsicBounds(obtainStyledAttributes.getResourceId(0, 0), obtainStyledAttributes.getResourceId(1, 0), obtainStyledAttributes.getResourceId(2, 0), obtainStyledAttributes.getResourceId(3, 0));
                setCompoundDrawablePadding(obtainStyledAttributes.getDimensionPixelSize(4, 0));
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private void j(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes;
        if (!v5.a.d(this)) {
            try {
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842966, 16842967, 16842968, 16842969}, i10, i11);
                setPadding(obtainStyledAttributes.getDimensionPixelSize(0, 0), obtainStyledAttributes.getDimensionPixelSize(1, 0), obtainStyledAttributes.getDimensionPixelSize(2, 0), obtainStyledAttributes.getDimensionPixelSize(3, 0));
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private void k(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes;
        TypedArray obtainStyledAttributes2;
        TypedArray obtainStyledAttributes3;
        if (!v5.a.d(this)) {
            try {
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842904}, i10, i11);
                setTextColor(obtainStyledAttributes.getColorStateList(0));
                obtainStyledAttributes.recycle();
                obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842927}, i10, i11);
                setGravity(obtainStyledAttributes2.getInt(0, 17));
                obtainStyledAttributes2.recycle();
                obtainStyledAttributes3 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842901, 16842903, 16843087}, i10, i11);
                setTextSize(0, (float) obtainStyledAttributes3.getDimensionPixelSize(0, 0));
                setTypeface(Typeface.create(getTypeface(), 1));
                setText(obtainStyledAttributes3.getString(2));
                obtainStyledAttributes3.recycle();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private void l() {
        if (!v5.a.d(this)) {
            try {
                super.setOnClickListener(new a());
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c(View view) {
        if (!v5.a.d(this)) {
            try {
                View.OnClickListener onClickListener = this.f19510c;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d(Context context, AttributeSet attributeSet, int i10, int i11) {
        if (!v5.a.d(this)) {
            try {
                h(context, attributeSet, i10, i11);
                i(context, attributeSet, i10, i11);
                j(context, attributeSet, i10, i11);
                k(context, attributeSet, i10, i11);
                l();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void e(Context context) {
        if (!v5.a.d(this)) {
            try {
                new m(context).f(this.f19508a);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void f(Context context) {
        if (!v5.a.d(this)) {
            try {
                new m(context).f(this.f19509b);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int g(String str) {
        if (v5.a.d(this)) {
            return 0;
        }
        try {
            return (int) Math.ceil((double) getPaint().measureText(str));
        } catch (Throwable th) {
            v5.a.b(th, this);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public Activity getActivity() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            Context context = getContext();
            while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (context instanceof Activity) {
                return (Activity) context;
            }
            throw new l("Unable to get Activity.");
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public String getAnalyticsButtonCreatedEventName() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            return this.f19508a;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public String getAnalyticsButtonTappedEventName() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            return this.f19509b;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    @Nullable
    public ActivityResultRegistryOwner getAndroidxActivityResultRegistryOwner() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            Activity activity = getActivity();
            if (activity instanceof ActivityResultRegistryOwner) {
                return (ActivityResultRegistryOwner) activity;
            }
            return null;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public int getCompoundPaddingLeft() {
        if (v5.a.d(this)) {
            return 0;
        }
        try {
            if (this.f19512e) {
                return this.f19513f;
            }
            return super.getCompoundPaddingLeft();
        } catch (Throwable th) {
            v5.a.b(th, this);
            return 0;
        }
    }

    public int getCompoundPaddingRight() {
        if (v5.a.d(this)) {
            return 0;
        }
        try {
            if (this.f19512e) {
                return this.f19514g;
            }
            return super.getCompoundPaddingRight();
        } catch (Throwable th) {
            v5.a.b(th, this);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public abstract int getDefaultRequestCode();

    /* access modifiers changed from: protected */
    public int getDefaultStyleResource() {
        v5.a.d(this);
        return 0;
    }

    public Fragment getFragment() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            u uVar = this.f19515h;
            if (uVar != null) {
                return uVar.c();
            }
            return null;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public android.app.Fragment getNativeFragment() {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            u uVar = this.f19515h;
            if (uVar != null) {
                return uVar.b();
            }
            return null;
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public int getRequestCode() {
        if (v5.a.d(this)) {
            return 0;
        }
        try {
            return getDefaultRequestCode();
        } catch (Throwable th) {
            v5.a.b(th, this);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        if (!v5.a.d(this)) {
            try {
                super.onAttachedToWindow();
                if (!isInEditMode()) {
                    e(getContext());
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!v5.a.d(this)) {
            try {
                if ((getGravity() & 1) != 0) {
                    int compoundPaddingLeft = getCompoundPaddingLeft();
                    int compoundPaddingRight = getCompoundPaddingRight();
                    int min = Math.min((((getWidth() - (getCompoundDrawablePadding() + compoundPaddingLeft)) - compoundPaddingRight) - g(getText().toString())) / 2, (compoundPaddingLeft - getPaddingLeft()) / 2);
                    this.f19513f = compoundPaddingLeft - min;
                    this.f19514g = compoundPaddingRight + min;
                    this.f19512e = true;
                }
                super.onDraw(canvas);
                this.f19512e = false;
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void setFragment(Fragment fragment) {
        if (!v5.a.d(this)) {
            try {
                this.f19515h = new u(fragment);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setInternalOnClickListener(View.OnClickListener onClickListener) {
        if (!v5.a.d(this)) {
            try {
                this.f19511d = onClickListener;
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (!v5.a.d(this)) {
            try {
                this.f19510c = onClickListener;
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void setFragment(android.app.Fragment fragment) {
        if (!v5.a.d(this)) {
            try {
                this.f19515h = new u(fragment);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }
}
