package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class StateListDrawableCompat extends DrawableContainerCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "StateListDrawableCompat";
    private boolean mMutated;
    private a mStateListState;

    static class a extends DrawableContainerCompat.d {
        int[][] J;

        a(a aVar, StateListDrawableCompat stateListDrawableCompat, Resources resources) {
            super(aVar, stateListDrawableCompat, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[g()][];
            }
        }

        /* access modifiers changed from: package-private */
        public int B(int[] iArr, Drawable drawable) {
            int a10 = a(drawable);
            this.J[a10] = iArr;
            return a10;
        }

        /* access modifiers changed from: package-private */
        public int C(int[] iArr) {
            int[][] iArr2 = this.J;
            int i10 = i();
            for (int i11 = 0; i11 < i10; i11++) {
                if (StateSet.stateSetMatches(iArr2[i11], iArr)) {
                    return i11;
                }
            }
            return -1;
        }

        public Drawable newDrawable() {
            return new StateListDrawableCompat(this, (Resources) null);
        }

        public void p(int i10, int i11) {
            super.p(i10, i11);
            int[][] iArr = new int[i11][];
            System.arraycopy(this.J, 0, iArr, 0, i10);
            this.J = iArr;
        }

        /* access modifiers changed from: package-private */
        public void t() {
            int[] iArr;
            int[][] iArr2 = this.J;
            int[][] iArr3 = new int[iArr2.length][];
            for (int length = iArr2.length - 1; length >= 0; length--) {
                int[] iArr4 = this.J[length];
                if (iArr4 != null) {
                    iArr = (int[]) iArr4.clone();
                } else {
                    iArr = null;
                }
                iArr3[length] = iArr;
            }
            this.J = iArr3;
        }

        public Drawable newDrawable(Resources resources) {
            return new StateListDrawableCompat(this, resources);
        }
    }

    public StateListDrawableCompat() {
        this((a) null, (Resources) null);
    }

    private void inflateChildElements(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        a aVar = this.mStateListState;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next2 == 3) {
                    return;
                }
                if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                    TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                    int resourceId = obtainAttributes.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                    if (resourceId > 0) {
                        drawable = ResourceManagerInternal.get().getDrawable(context, resourceId);
                    } else {
                        drawable = null;
                    }
                    obtainAttributes.recycle();
                    int[] extractStateSet = extractStateSet(attributeSet);
                    if (drawable == null) {
                        do {
                            next = xmlPullParser.next();
                        } while (next == 4);
                        if (next == 2) {
                            drawable = Compatibility.Api21Impl.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                        } else {
                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                    }
                    aVar.B(extractStateSet, drawable);
                }
            } else {
                return;
            }
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        a aVar = this.mStateListState;
        aVar.f14012d |= Compatibility.Api21Impl.getChangingConfigurations(typedArray);
        aVar.f14017i = typedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, aVar.f14017i);
        aVar.f14020l = typedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, aVar.f14020l);
        aVar.A = typedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, aVar.A);
        aVar.B = typedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, aVar.B);
        aVar.f14032x = typedArray.getBoolean(R.styleable.StateListDrawable_android_dither, aVar.f14032x);
    }

    public void addState(int[] iArr, Drawable drawable) {
        if (drawable != null) {
            this.mStateListState.B(iArr, drawable);
            onStateChange(getState());
        }
    }

    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* access modifiers changed from: package-private */
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    /* access modifiers changed from: package-private */
    public int[] extractStateSet(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i10 = 0;
        for (int i11 = 0; i11 < attributeCount; i11++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i11);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i12 = i10 + 1;
                if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i10] = attributeNameResource;
                i10 = i12;
            }
        }
        return StateSet.trimStateSet(iArr, i10);
    }

    /* access modifiers changed from: package-private */
    public int getStateCount() {
        return this.mStateListState.i();
    }

    /* access modifiers changed from: package-private */
    public Drawable getStateDrawable(int i10) {
        return this.mStateListState.h(i10);
    }

    /* access modifiers changed from: package-private */
    public int getStateDrawableIndex(int[] iArr) {
        return this.mStateListState.C(iArr);
    }

    /* access modifiers changed from: package-private */
    public a getStateListState() {
        return this.mStateListState;
    }

    /* access modifiers changed from: package-private */
    public int[] getStateSet(int i10) {
        return this.mStateListState.J[i10];
    }

    public void inflate(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawable);
        setVisible(obtainAttributes.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        updateStateFromTypedArray(obtainAttributes);
        updateDensity(resources);
        obtainAttributes.recycle();
        inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    public boolean isStateful() {
        return true;
    }

    @NonNull
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mStateListState.t();
            this.mMutated = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int C = this.mStateListState.C(iArr);
        if (C < 0) {
            C = this.mStateListState.C(StateSet.WILD_CARD);
        }
        if (selectDrawable(C) || onStateChange) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void setConstantState(@NonNull DrawableContainerCompat.d dVar) {
        super.setConstantState(dVar);
        if (dVar instanceof a) {
            this.mStateListState = (a) dVar;
        }
    }

    StateListDrawableCompat(a aVar, Resources resources) {
        setConstantState(new a(aVar, this, resources));
        onStateChange(getState());
    }

    /* access modifiers changed from: package-private */
    public a cloneConstantState() {
        return new a(this.mStateListState, this, (Resources) null);
    }

    StateListDrawableCompat(@Nullable a aVar) {
        if (aVar != null) {
            setConstantState(aVar);
        }
    }
}
