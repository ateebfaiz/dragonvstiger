package com.airbnb.lottie;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;
import r0.e;
import y0.f;
import y0.l;

public class LottieAnimationView extends AppCompatImageView {
    private static final String O0 = "LottieAnimationView";
    /* access modifiers changed from: private */
    public static final o0 P0 = new g();
    private final Set C = new HashSet();
    private u0 N0;

    /* renamed from: a  reason: collision with root package name */
    private final o0 f17592a = new c(this);

    /* renamed from: b  reason: collision with root package name */
    private final o0 f17593b = new b(this);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public o0 f17594c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f17595d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final k0 f17596e = new k0();

    /* renamed from: f  reason: collision with root package name */
    private String f17597f;

    /* renamed from: g  reason: collision with root package name */
    private int f17598g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f17599h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f17600i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f17601j = true;

    /* renamed from: w  reason: collision with root package name */
    private final Set f17602w = new HashSet();

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f17603a;

        /* renamed from: b  reason: collision with root package name */
        int f17604b;

        /* renamed from: c  reason: collision with root package name */
        float f17605c;

        /* renamed from: d  reason: collision with root package name */
        boolean f17606d;

        /* renamed from: e  reason: collision with root package name */
        String f17607e;

        /* renamed from: f  reason: collision with root package name */
        int f17608f;

        /* renamed from: g  reason: collision with root package name */
        int f17609g;

        class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (i) null);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, i iVar) {
            this(parcel);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f17603a);
            parcel.writeFloat(this.f17605c);
            parcel.writeInt(this.f17606d ? 1 : 0);
            parcel.writeString(this.f17607e);
            parcel.writeInt(this.f17608f);
            parcel.writeInt(this.f17609g);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f17603a = parcel.readString();
            this.f17605c = parcel.readFloat();
            this.f17606d = parcel.readInt() != 1 ? false : true;
            this.f17607e = parcel.readString();
            this.f17608f = parcel.readInt();
            this.f17609g = parcel.readInt();
        }
    }

    private enum a {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    private static class b implements o0 {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f17617a;

        public b(LottieAnimationView lottieAnimationView) {
            this.f17617a = new WeakReference(lottieAnimationView);
        }

        /* renamed from: a */
        public void onResult(Throwable th) {
            o0 o0Var;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f17617a.get();
            if (lottieAnimationView != null) {
                if (lottieAnimationView.f17595d != 0) {
                    lottieAnimationView.setImageResource(lottieAnimationView.f17595d);
                }
                if (lottieAnimationView.f17594c == null) {
                    o0Var = LottieAnimationView.P0;
                } else {
                    o0Var = lottieAnimationView.f17594c;
                }
                o0Var.onResult(th);
            }
        }
    }

    private static class c implements o0 {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f17618a;

        public c(LottieAnimationView lottieAnimationView) {
            this.f17618a = new WeakReference(lottieAnimationView);
        }

        /* renamed from: a */
        public void onResult(j jVar) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f17618a.get();
            if (lottieAnimationView != null) {
                lottieAnimationView.setComposition(jVar);
            }
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        p((AttributeSet) null, w0.f17792a);
    }

    private void C() {
        boolean q10 = q();
        setImageDrawable((Drawable) null);
        setImageDrawable(this.f17596e);
        if (q10) {
            this.f17596e.B0();
        }
    }

    private void E(float f10, boolean z10) {
        if (z10) {
            this.f17602w.add(a.SET_PROGRESS);
        }
        this.f17596e.b1(f10);
    }

    private void k() {
        u0 u0Var = this.N0;
        if (u0Var != null) {
            u0Var.k(this.f17592a);
            this.N0.j(this.f17593b);
        }
    }

    private void l() {
        this.f17596e.v();
    }

    private u0 n(String str) {
        if (isInEditMode()) {
            return new u0(new f(this, str), true);
        }
        if (this.f17601j) {
            return t.l(getContext(), str);
        }
        return t.m(getContext(), str, (String) null);
    }

    private u0 o(int i10) {
        if (isInEditMode()) {
            return new u0(new h(this, i10), true);
        }
        if (this.f17601j) {
            return t.w(getContext(), i10);
        }
        return t.x(getContext(), i10, (String) null);
    }

    private void p(AttributeSet attributeSet, int i10) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, x0.f17797a, i10, 0);
        this.f17601j = obtainStyledAttributes.getBoolean(x0.f17800d, true);
        boolean hasValue = obtainStyledAttributes.hasValue(x0.f17812p);
        boolean hasValue2 = obtainStyledAttributes.hasValue(x0.f17807k);
        boolean hasValue3 = obtainStyledAttributes.hasValue(x0.f17817u);
        if (!hasValue || !hasValue2) {
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(x0.f17812p, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(x0.f17807k);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(x0.f17817u)) != null) {
                setAnimationFromUrl(string);
            }
            setFallbackResource(obtainStyledAttributes.getResourceId(x0.f17806j, 0));
            if (obtainStyledAttributes.getBoolean(x0.f17799c, false)) {
                this.f17600i = true;
            }
            if (obtainStyledAttributes.getBoolean(x0.f17810n, false)) {
                this.f17596e.d1(-1);
            }
            if (obtainStyledAttributes.hasValue(x0.f17815s)) {
                setRepeatMode(obtainStyledAttributes.getInt(x0.f17815s, 1));
            }
            if (obtainStyledAttributes.hasValue(x0.f17814r)) {
                setRepeatCount(obtainStyledAttributes.getInt(x0.f17814r, -1));
            }
            if (obtainStyledAttributes.hasValue(x0.f17816t)) {
                setSpeed(obtainStyledAttributes.getFloat(x0.f17816t, 1.0f));
            }
            if (obtainStyledAttributes.hasValue(x0.f17802f)) {
                setClipToCompositionBounds(obtainStyledAttributes.getBoolean(x0.f17802f, true));
            }
            if (obtainStyledAttributes.hasValue(x0.f17801e)) {
                setClipTextToBoundingBox(obtainStyledAttributes.getBoolean(x0.f17801e, false));
            }
            if (obtainStyledAttributes.hasValue(x0.f17804h)) {
                setDefaultFontFileExtension(obtainStyledAttributes.getString(x0.f17804h));
            }
            setImageAssetsFolder(obtainStyledAttributes.getString(x0.f17809m));
            E(obtainStyledAttributes.getFloat(x0.f17811o, 0.0f), obtainStyledAttributes.hasValue(x0.f17811o));
            m(obtainStyledAttributes.getBoolean(x0.f17805i, false));
            if (obtainStyledAttributes.hasValue(x0.f17803g)) {
                z0 z0Var = new z0(AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(x0.f17803g, -1)).getDefaultColor());
                i(new e("**"), r0.K, new z0.c(z0Var));
            }
            if (obtainStyledAttributes.hasValue(x0.f17813q)) {
                int i11 = x0.f17813q;
                y0 y0Var = y0.AUTOMATIC;
                int i12 = obtainStyledAttributes.getInt(i11, y0Var.ordinal());
                if (i12 >= y0.values().length) {
                    i12 = y0Var.ordinal();
                }
                setRenderMode(y0.values()[i12]);
            }
            if (obtainStyledAttributes.hasValue(x0.f17798b)) {
                int i13 = x0.f17798b;
                a aVar = a.AUTOMATIC;
                int i14 = obtainStyledAttributes.getInt(i13, aVar.ordinal());
                if (i14 >= y0.values().length) {
                    i14 = aVar.ordinal();
                }
                setAsyncUpdates(a.values()[i14]);
            }
            setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(x0.f17808l, false));
            if (obtainStyledAttributes.hasValue(x0.f17818v)) {
                setUseCompositionFrameRate(obtainStyledAttributes.getBoolean(x0.f17818v, false));
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ s0 r(String str) {
        if (this.f17601j) {
            return t.n(getContext(), str);
        }
        return t.o(getContext(), str, (String) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ s0 s(int i10) {
        if (this.f17601j) {
            return t.y(getContext(), i10);
        }
        return t.z(getContext(), i10, (String) null);
    }

    private void setCompositionTask(u0 u0Var) {
        s0 e10 = u0Var.e();
        k0 k0Var = this.f17596e;
        if (e10 == null || k0Var != getDrawable() || k0Var.J() != e10.b()) {
            this.f17602w.add(a.SET_ANIMATION);
            l();
            k();
            this.N0 = u0Var.d(this.f17592a).c(this.f17593b);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void t(Throwable th) {
        if (l.k(th)) {
            f.d("Unable to load composition.", th);
            return;
        }
        throw new IllegalStateException("Unable to parse composition", th);
    }

    public void A(String str, String str2) {
        y(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void B(String str, String str2) {
        setCompositionTask(t.B(getContext(), str, str2));
    }

    public void D(int i10, int i11) {
        this.f17596e.U0(i10, i11);
    }

    public void g(Animator.AnimatorListener animatorListener) {
        this.f17596e.q(animatorListener);
    }

    public a getAsyncUpdates() {
        return this.f17596e.E();
    }

    public boolean getAsyncUpdatesEnabled() {
        return this.f17596e.F();
    }

    public boolean getClipTextToBoundingBox() {
        return this.f17596e.H();
    }

    public boolean getClipToCompositionBounds() {
        return this.f17596e.I();
    }

    @Nullable
    public j getComposition() {
        Drawable drawable = getDrawable();
        k0 k0Var = this.f17596e;
        if (drawable == k0Var) {
            return k0Var.J();
        }
        return null;
    }

    public long getDuration() {
        j composition = getComposition();
        if (composition != null) {
            return (long) composition.d();
        }
        return 0;
    }

    public int getFrame() {
        return this.f17596e.M();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f17596e.O();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f17596e.Q();
    }

    public float getMaxFrame() {
        return this.f17596e.S();
    }

    public float getMinFrame() {
        return this.f17596e.T();
    }

    @Nullable
    public v0 getPerformanceTracker() {
        return this.f17596e.U();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f17596e.V();
    }

    public y0 getRenderMode() {
        return this.f17596e.W();
    }

    public int getRepeatCount() {
        return this.f17596e.X();
    }

    public int getRepeatMode() {
        return this.f17596e.Y();
    }

    public float getSpeed() {
        return this.f17596e.Z();
    }

    public boolean h(q0 q0Var) {
        j composition = getComposition();
        if (composition != null) {
            q0Var.a(composition);
        }
        return this.C.add(q0Var);
    }

    public void i(e eVar, Object obj, z0.c cVar) {
        this.f17596e.r(eVar, obj, cVar);
    }

    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof k0) && ((k0) drawable).W() == y0.SOFTWARE) {
            this.f17596e.invalidateSelf();
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        k0 k0Var = this.f17596e;
        if (drawable2 == k0Var) {
            super.invalidateDrawable(k0Var);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void j() {
        this.f17600i = false;
        this.f17602w.add(a.PLAY_OPTION);
        this.f17596e.u();
    }

    public void m(boolean z10) {
        this.f17596e.A(l0.MergePathsApi19, z10);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.f17600i) {
            this.f17596e.y0();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i10;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f17597f = savedState.f17603a;
        Set set = this.f17602w;
        a aVar = a.SET_ANIMATION;
        if (!set.contains(aVar) && !TextUtils.isEmpty(this.f17597f)) {
            setAnimation(this.f17597f);
        }
        this.f17598g = savedState.f17604b;
        if (!this.f17602w.contains(aVar) && (i10 = this.f17598g) != 0) {
            setAnimation(i10);
        }
        if (!this.f17602w.contains(a.SET_PROGRESS)) {
            E(savedState.f17605c, false);
        }
        if (!this.f17602w.contains(a.PLAY_OPTION) && savedState.f17606d) {
            v();
        }
        if (!this.f17602w.contains(a.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.f17607e);
        }
        if (!this.f17602w.contains(a.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f17608f);
        }
        if (!this.f17602w.contains(a.SET_REPEAT_COUNT)) {
            setRepeatCount(savedState.f17609g);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f17603a = this.f17597f;
        savedState.f17604b = this.f17598g;
        savedState.f17605c = this.f17596e.V();
        savedState.f17606d = this.f17596e.e0();
        savedState.f17607e = this.f17596e.O();
        savedState.f17608f = this.f17596e.Y();
        savedState.f17609g = this.f17596e.X();
        return savedState;
    }

    public boolean q() {
        return this.f17596e.d0();
    }

    public void setAnimation(@RawRes int i10) {
        this.f17598g = i10;
        this.f17597f = null;
        setCompositionTask(o(i10));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        A(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        u0 u0Var;
        if (this.f17601j) {
            u0Var = t.A(getContext(), str);
        } else {
            u0Var = t.B(getContext(), str, (String) null);
        }
        setCompositionTask(u0Var);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z10) {
        this.f17596e.E0(z10);
    }

    public void setAsyncUpdates(a aVar) {
        this.f17596e.F0(aVar);
    }

    public void setCacheComposition(boolean z10) {
        this.f17601j = z10;
    }

    public void setClipTextToBoundingBox(boolean z10) {
        this.f17596e.G0(z10);
    }

    public void setClipToCompositionBounds(boolean z10) {
        this.f17596e.H0(z10);
    }

    public void setComposition(@NonNull j jVar) {
        if (e.f17634a) {
            String str = O0;
            Log.v(str, "Set Composition \n" + jVar);
        }
        this.f17596e.setCallback(this);
        this.f17599h = true;
        boolean I0 = this.f17596e.I0(jVar);
        if (this.f17600i) {
            this.f17596e.y0();
        }
        this.f17599h = false;
        if (getDrawable() != this.f17596e || I0) {
            if (!I0) {
                C();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (q0 a10 : this.C) {
                a10.a(jVar);
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.f17596e.J0(str);
    }

    public void setFailureListener(@Nullable o0 o0Var) {
        this.f17594c = o0Var;
    }

    public void setFallbackResource(@DrawableRes int i10) {
        this.f17595d = i10;
    }

    public void setFontAssetDelegate(b bVar) {
        this.f17596e.K0(bVar);
    }

    public void setFontMap(@Nullable Map<String, Typeface> map) {
        this.f17596e.L0(map);
    }

    public void setFrame(int i10) {
        this.f17596e.M0(i10);
    }

    @Deprecated
    public void setIgnoreDisabledSystemAnimations(boolean z10) {
        this.f17596e.N0(z10);
    }

    public void setImageAssetDelegate(c cVar) {
        this.f17596e.O0(cVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f17596e.P0(str);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f17598g = 0;
        this.f17597f = null;
        k();
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f17598g = 0;
        this.f17597f = null;
        k();
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int i10) {
        this.f17598g = 0;
        this.f17597f = null;
        k();
        super.setImageResource(i10);
    }

    public void setMaintainOriginalImageBounds(boolean z10) {
        this.f17596e.Q0(z10);
    }

    public void setMaxFrame(int i10) {
        this.f17596e.R0(i10);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.f17596e.T0(f10);
    }

    public void setMinAndMaxFrame(String str) {
        this.f17596e.V0(str);
    }

    public void setMinFrame(int i10) {
        this.f17596e.W0(i10);
    }

    public void setMinProgress(float f10) {
        this.f17596e.Y0(f10);
    }

    public void setOutlineMasksAndMattes(boolean z10) {
        this.f17596e.Z0(z10);
    }

    public void setPerformanceTrackingEnabled(boolean z10) {
        this.f17596e.a1(z10);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        E(f10, true);
    }

    public void setRenderMode(y0 y0Var) {
        this.f17596e.c1(y0Var);
    }

    public void setRepeatCount(int i10) {
        this.f17602w.add(a.SET_REPEAT_COUNT);
        this.f17596e.d1(i10);
    }

    public void setRepeatMode(int i10) {
        this.f17602w.add(a.SET_REPEAT_MODE);
        this.f17596e.e1(i10);
    }

    public void setSafeMode(boolean z10) {
        this.f17596e.f1(z10);
    }

    public void setSpeed(float f10) {
        this.f17596e.g1(f10);
    }

    public void setTextDelegate(a1 a1Var) {
        this.f17596e.h1(a1Var);
    }

    public void setUseCompositionFrameRate(boolean z10) {
        this.f17596e.i1(z10);
    }

    public void u() {
        this.f17600i = false;
        this.f17596e.x0();
    }

    public void unscheduleDrawable(Drawable drawable) {
        k0 k0Var;
        if (!this.f17599h && drawable == (k0Var = this.f17596e) && k0Var.d0()) {
            u();
        } else if (!this.f17599h && (drawable instanceof k0)) {
            k0 k0Var2 = (k0) drawable;
            if (k0Var2.d0()) {
                k0Var2.x0();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void v() {
        this.f17602w.add(a.PLAY_OPTION);
        this.f17596e.y0();
    }

    public void w() {
        this.f17602w.add(a.PLAY_OPTION);
        this.f17596e.B0();
    }

    public void x() {
        this.f17596e.C0();
    }

    public void y(InputStream inputStream, String str) {
        setCompositionTask(t.p(inputStream, str));
    }

    public void z(ZipInputStream zipInputStream, String str) {
        setCompositionTask(t.D(zipInputStream, str));
    }

    public void setMaxFrame(String str) {
        this.f17596e.S0(str);
    }

    public void setMinFrame(String str) {
        this.f17596e.X0(str);
    }

    public void setAnimation(String str) {
        this.f17597f = str;
        this.f17598g = 0;
        setCompositionTask(n(str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p(attributeSet, w0.f17792a);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p(attributeSet, i10);
    }
}
