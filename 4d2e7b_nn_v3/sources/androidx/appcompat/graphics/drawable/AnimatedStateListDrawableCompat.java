package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;
import androidx.appcompat.graphics.drawable.StateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements TintAwareDrawable {
    private static final String ELEMENT_ITEM = "item";
    private static final String ELEMENT_TRANSITION = "transition";
    private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String LOGTAG = "AnimatedStateListDrawableCompat";
    private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private boolean mMutated;
    private c mState;
    private g mTransition;
    private int mTransitionFromIndex;
    private int mTransitionToIndex;

    private static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f14000a;

        b(Animatable animatable) {
            super();
            this.f14000a = animatable;
        }

        public void c() {
            this.f14000a.start();
        }

        public void d() {
            this.f14000a.stop();
        }
    }

    static class c extends StateListDrawableCompat.a {
        LongSparseArray K;
        SparseArrayCompat L;

        c(c cVar, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
            super(cVar, animatedStateListDrawableCompat, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
                return;
            }
            this.K = new LongSparseArray();
            this.L = new SparseArrayCompat();
        }

        private static long F(int i10, int i11) {
            return ((long) i11) | (((long) i10) << 32);
        }

        /* access modifiers changed from: package-private */
        public int D(int[] iArr, Drawable drawable, int i10) {
            int B = super.B(iArr, drawable);
            this.L.put(B, Integer.valueOf(i10));
            return B;
        }

        /* access modifiers changed from: package-private */
        public int E(int i10, int i11, Drawable drawable, boolean z10) {
            long j10;
            int a10 = super.a(drawable);
            long F = F(i10, i11);
            if (z10) {
                j10 = 8589934592L;
            } else {
                j10 = 0;
            }
            long j11 = (long) a10;
            this.K.append(F, Long.valueOf(j11 | j10));
            if (z10) {
                this.K.append(F(i11, i10), Long.valueOf(4294967296L | j11 | j10));
            }
            return a10;
        }

        /* access modifiers changed from: package-private */
        public int G(int i10) {
            if (i10 < 0) {
                return 0;
            }
            return ((Integer) this.L.get(i10, 0)).intValue();
        }

        /* access modifiers changed from: package-private */
        public int H(int[] iArr) {
            int C = super.C(iArr);
            if (C >= 0) {
                return C;
            }
            return super.C(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        public int I(int i10, int i11) {
            return (int) ((Long) this.K.get(F(i10, i11), -1L)).longValue();
        }

        /* access modifiers changed from: package-private */
        public boolean J(int i10, int i11) {
            if ((((Long) this.K.get(F(i10, i11), -1L)).longValue() & 4294967296L) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean K(int i10, int i11) {
            if ((((Long) this.K.get(F(i10, i11), -1L)).longValue() & 8589934592L) != 0) {
                return true;
            }
            return false;
        }

        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, (Resources) null);
        }

        /* access modifiers changed from: package-private */
        public void t() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    private static class d extends g {

        /* renamed from: a  reason: collision with root package name */
        private final AnimatedVectorDrawableCompat f14001a;

        d(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super();
            this.f14001a = animatedVectorDrawableCompat;
        }

        public void c() {
            this.f14001a.start();
        }

        public void d() {
            this.f14001a.stop();
        }
    }

    private static class e extends g {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f14002a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f14003b;

        e(AnimationDrawable animationDrawable, boolean z10, boolean z11) {
            super();
            int i10;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i11 = 0;
            if (z10) {
                i10 = numberOfFrames - 1;
            } else {
                i10 = 0;
            }
            i11 = !z10 ? numberOfFrames - 1 : i11;
            f fVar = new f(animationDrawable, z10);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i10, i11});
            Compatibility.Api18Impl.setAutoCancel(ofInt, true);
            ofInt.setDuration((long) fVar.a());
            ofInt.setInterpolator(fVar);
            this.f14003b = z11;
            this.f14002a = ofInt;
        }

        public boolean a() {
            return this.f14003b;
        }

        public void b() {
            this.f14002a.reverse();
        }

        public void c() {
            this.f14002a.start();
        }

        public void d() {
            this.f14002a.cancel();
        }
    }

    private static class f implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private int[] f14004a;

        /* renamed from: b  reason: collision with root package name */
        private int f14005b;

        /* renamed from: c  reason: collision with root package name */
        private int f14006c;

        f(AnimationDrawable animationDrawable, boolean z10) {
            b(animationDrawable, z10);
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f14006c;
        }

        /* access modifiers changed from: package-private */
        public int b(AnimationDrawable animationDrawable, boolean z10) {
            int i10;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f14005b = numberOfFrames;
            int[] iArr = this.f14004a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f14004a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f14004a;
            int i11 = 0;
            for (int i12 = 0; i12 < numberOfFrames; i12++) {
                if (z10) {
                    i10 = (numberOfFrames - i12) - 1;
                } else {
                    i10 = i12;
                }
                int duration = animationDrawable.getDuration(i10);
                iArr2[i12] = duration;
                i11 += duration;
            }
            this.f14006c = i11;
            return i11;
        }

        public float getInterpolation(float f10) {
            float f11;
            int i10 = (int) ((f10 * ((float) this.f14006c)) + 0.5f);
            int i11 = this.f14005b;
            int[] iArr = this.f14004a;
            int i12 = 0;
            while (i12 < i11) {
                int i13 = iArr[i12];
                if (i10 < i13) {
                    break;
                }
                i10 -= i13;
                i12++;
            }
            if (i12 < i11) {
                f11 = ((float) i10) / ((float) this.f14006c);
            } else {
                f11 = 0.0f;
            }
            return (((float) i12) / ((float) i11)) + f11;
        }
    }

    private static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public AnimatedStateListDrawableCompat() {
        this((c) null, (Resources) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0024 A[Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b A[Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat create(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.DrawableRes int r7, @androidx.annotation.Nullable android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            android.content.res.Resources r1 = r6.getResources()     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            android.content.res.XmlResourceParser r7 = r1.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
        L_0x000e:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            r4 = 2
            if (r3 == r4) goto L_0x0019
            r5 = 1
            if (r3 == r5) goto L_0x0019
            goto L_0x000e
        L_0x0019:
            if (r3 != r4) goto L_0x0024
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat r6 = createFromXmlInner(r6, r1, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            return r6
        L_0x0020:
            r6 = move-exception
            goto L_0x002c
        L_0x0022:
            r6 = move-exception
            goto L_0x0032
        L_0x0024:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
        L_0x002c:
            java.lang.String r7 = LOGTAG
            android.util.Log.e(r7, r0, r6)
            goto L_0x0037
        L_0x0032:
            java.lang.String r7 = LOGTAG
            android.util.Log.e(r7, r0, r6)
        L_0x0037:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.create(android.content.Context, int, android.content.res.Resources$Theme):androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat");
    }

    @NonNull
    public static AnimatedStateListDrawableCompat createFromXmlInner(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.inflate(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void inflateChildElements(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals(ELEMENT_ITEM)) {
                        parseItem(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals(ELEMENT_TRANSITION)) {
                        parseTransition(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void init() {
        onStateChange(getState());
    }

    private int parseItem(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        if (resourceId2 > 0) {
            drawable = ResourceManagerInternal.get().getDrawable(context, resourceId2);
        } else {
            drawable = null;
        }
        obtainAttributes.recycle();
        int[] extractStateSet = extractStateSet(attributeSet);
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
            } else if (xmlPullParser.getName().equals("vector")) {
                drawable = VectorDrawableCompat.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Compatibility.Api21Impl.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            }
        }
        if (drawable != null) {
            return this.mState.D(extractStateSet, drawable, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    }

    private int parseTransition(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        if (resourceId3 > 0) {
            drawable = ResourceManagerInternal.get().getDrawable(context, resourceId3);
        } else {
            drawable = null;
        }
        boolean z10 = obtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        obtainAttributes.recycle();
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                drawable = AnimatedVectorDrawableCompat.createFromXmlInner(context, resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Compatibility.Api21Impl.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            }
        }
        if (drawable == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.mState.E(resourceId, resourceId2, drawable, z10);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + TRANSITION_MISSING_FROM_TO_ID);
        }
    }

    private boolean selectTransition(int i10) {
        int i11;
        int I;
        g gVar;
        g gVar2 = this.mTransition;
        if (gVar2 == null) {
            i11 = getCurrentIndex();
        } else if (i10 == this.mTransitionToIndex) {
            return true;
        } else {
            if (i10 != this.mTransitionFromIndex || !gVar2.a()) {
                i11 = this.mTransitionToIndex;
                gVar2.d();
            } else {
                gVar2.b();
                this.mTransitionToIndex = this.mTransitionFromIndex;
                this.mTransitionFromIndex = i10;
                return true;
            }
        }
        this.mTransition = null;
        this.mTransitionFromIndex = -1;
        this.mTransitionToIndex = -1;
        c cVar = this.mState;
        int G = cVar.G(i11);
        int G2 = cVar.G(i10);
        if (G2 == 0 || G == 0 || (I = cVar.I(G, G2)) < 0) {
            return false;
        }
        boolean K = cVar.K(G, G2);
        selectDrawable(I);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            gVar = new e((AnimationDrawable) current, cVar.J(G, G2), K);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            gVar = new d((AnimatedVectorDrawableCompat) current);
        } else {
            if (current instanceof Animatable) {
                gVar = new b((Animatable) current);
            }
            return false;
        }
        gVar.c();
        this.mTransition = gVar;
        this.mTransitionFromIndex = i11;
        this.mTransitionToIndex = i10;
        return true;
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        c cVar = this.mState;
        cVar.f14012d |= Compatibility.Api21Impl.getChangingConfigurations(typedArray);
        cVar.z(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f14017i));
        cVar.v(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, cVar.f14020l));
        cVar.w(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A));
        cVar.x(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.B));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, cVar.f14032x));
    }

    public void addState(@NonNull int[] iArr, @NonNull Drawable drawable, int i10) {
        ObjectsCompat.requireNonNull(drawable);
        this.mState.D(iArr, drawable, i10);
        onStateChange(getState());
    }

    public <T extends Drawable & Animatable> void addTransition(int i10, int i11, @NonNull T t10, boolean z10) {
        ObjectsCompat.requireNonNull(t10);
        this.mState.E(i10, i11, t10, z10);
    }

    /* access modifiers changed from: package-private */
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    public void inflate(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(obtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        updateStateFromTypedArray(obtainAttributes);
        updateDensity(resources);
        obtainAttributes.recycle();
        inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
        init();
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.mTransition;
        if (gVar != null) {
            gVar.d();
            this.mTransition = null;
            selectDrawable(this.mTransitionToIndex);
            this.mTransitionToIndex = -1;
            this.mTransitionFromIndex = -1;
        }
    }

    @NonNull
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mState.t();
            this.mMutated = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean z10;
        int H = this.mState.H(iArr);
        if (H == getCurrentIndex() || (!selectTransition(H) && !selectDrawable(H))) {
            z10 = false;
        } else {
            z10 = true;
        }
        Drawable current = getCurrent();
        if (current != null) {
            return z10 | current.setState(iArr);
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public void setConstantState(@NonNull DrawableContainerCompat.d dVar) {
        super.setConstantState(dVar);
        if (dVar instanceof c) {
            this.mState = (c) dVar;
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        g gVar = this.mTransition;
        if (gVar != null && (visible || z11)) {
            if (z10) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    AnimatedStateListDrawableCompat(@Nullable c cVar, @Nullable Resources resources) {
        super((StateListDrawableCompat.a) null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        setConstantState(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* access modifiers changed from: package-private */
    public c cloneConstantState() {
        return new c(this.mState, this, (Resources) null);
    }
}
