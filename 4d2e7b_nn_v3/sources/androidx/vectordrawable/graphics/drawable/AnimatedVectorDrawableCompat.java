package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat extends b implements Animatable2Compat {
    private static final String ANIMATED_VECTOR = "animated-vector";
    private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    private static final String LOGTAG = "AnimatedVDCompat";
    private static final String TARGET = "target";
    private c mAnimatedVectorState;
    ArrayList<Animatable2Compat.AnimationCallback> mAnimationCallbacks;
    private Animator.AnimatorListener mAnimatorListener;
    private ArgbEvaluator mArgbEvaluator;
    d mCachedConstantStateDelegate;
    final Drawable.Callback mCallback;
    private Context mContext;

    class a implements Drawable.Callback {
        a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            AnimatedVectorDrawableCompat.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j10);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.mAnimationCallbacks);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((Animatable2Compat.AnimationCallback) arrayList.get(i10)).onAnimationEnd(AnimatedVectorDrawableCompat.this);
            }
        }

        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.mAnimationCallbacks);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((Animatable2Compat.AnimationCallback) arrayList.get(i10)).onAnimationStart(AnimatedVectorDrawableCompat.this);
            }
        }
    }

    private static class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f16733a;

        /* renamed from: b  reason: collision with root package name */
        VectorDrawableCompat f16734b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f16735c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList f16736d;

        /* renamed from: e  reason: collision with root package name */
        ArrayMap f16737e;

        public c(Context context, c cVar, Drawable.Callback callback, Resources resources) {
            if (cVar != null) {
                this.f16733a = cVar.f16733a;
                VectorDrawableCompat vectorDrawableCompat = cVar.f16734b;
                if (vectorDrawableCompat != null) {
                    Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                    if (resources != null) {
                        this.f16734b = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.f16734b = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    VectorDrawableCompat vectorDrawableCompat2 = (VectorDrawableCompat) this.f16734b.mutate();
                    this.f16734b = vectorDrawableCompat2;
                    vectorDrawableCompat2.setCallback(callback);
                    this.f16734b.setBounds(cVar.f16734b.getBounds());
                    this.f16734b.setAllowCaching(false);
                }
                ArrayList arrayList = cVar.f16736d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f16736d = new ArrayList(size);
                    this.f16737e = new ArrayMap(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        Animator animator = (Animator) cVar.f16736d.get(i10);
                        Animator clone = animator.clone();
                        String str = (String) cVar.f16737e.get(animator);
                        clone.setTarget(this.f16734b.getTargetByName(str));
                        this.f16736d.add(clone);
                        this.f16737e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f16735c == null) {
                this.f16735c = new AnimatorSet();
            }
            this.f16735c.playTogether(this.f16736d);
        }

        public int getChangingConfigurations() {
            return this.f16733a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    AnimatedVectorDrawableCompat() {
        this((Context) null, (c) null, (Resources) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A[Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a A[Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat create(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.DrawableRes int r7) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "AnimatedVDCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0030
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r0 = new androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
            r0.<init>(r6)
            android.content.res.Resources r1 = r6.getResources()
            android.content.res.Resources$Theme r6 = r6.getTheme()
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.ResourcesCompat.getDrawable(r1, r7, r6)
            r0.mDelegateDrawable = r6
            android.graphics.drawable.Drawable$Callback r7 = r0.mCallback
            r6.setCallback(r7)
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$d r6 = new androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$d
            android.graphics.drawable.Drawable r7 = r0.mDelegateDrawable
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.mCachedConstantStateDelegate = r6
            return r0
        L_0x0030:
            android.content.res.Resources r2 = r6.getResources()
            android.content.res.XmlResourceParser r7 = r2.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
        L_0x003c:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            r4 = 2
            if (r3 == r4) goto L_0x0047
            r5 = 1
            if (r3 == r5) goto L_0x0047
            goto L_0x003c
        L_0x0047:
            if (r3 != r4) goto L_0x005a
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            android.content.res.Resources$Theme r4 = r6.getTheme()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r6 = createFromXmlInner(r6, r3, r7, r2, r4)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            return r6
        L_0x0056:
            r6 = move-exception
            goto L_0x0062
        L_0x0058:
            r6 = move-exception
            goto L_0x0066
        L_0x005a:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
        L_0x0062:
            android.util.Log.e(r1, r0, r6)
            goto L_0x0069
        L_0x0066:
            android.util.Log.e(r1, r0, r6)
        L_0x0069:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.create(android.content.Context, int):androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat");
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    @RequiresApi(23)
    private static void registerPlatformCallback(@NonNull AnimatedVectorDrawable animatedVectorDrawable, @NonNull Animatable2Compat.AnimationCallback animationCallback) {
        animatedVectorDrawable.registerAnimationCallback(animationCallback.getPlatformCallback());
    }

    private void removeAnimatorSetListener() {
        Animator.AnimatorListener animatorListener = this.mAnimatorListener;
        if (animatorListener != null) {
            this.mAnimatedVectorState.f16735c.removeListener(animatorListener);
            this.mAnimatorListener = null;
        }
    }

    private void setupAnimatorsForTarget(String str, Animator animator) {
        animator.setTarget(this.mAnimatedVectorState.f16734b.getTargetByName(str));
        c cVar = this.mAnimatedVectorState;
        if (cVar.f16736d == null) {
            cVar.f16736d = new ArrayList();
            this.mAnimatedVectorState.f16737e = new ArrayMap();
        }
        this.mAnimatedVectorState.f16736d.add(animator);
        this.mAnimatedVectorState.f16737e.put(animator, str);
    }

    private void setupColorAnimator(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i10 = 0; i10 < childAnimations.size(); i10++) {
                setupColorAnimator(childAnimations.get(i10));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.mArgbEvaluator == null) {
                    this.mArgbEvaluator = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.mArgbEvaluator);
            }
        }
    }

    @RequiresApi(23)
    private static boolean unregisterPlatformCallback(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        return animatedVectorDrawable.unregisterAnimationCallback(animationCallback.getPlatformCallback());
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.applyTheme(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat.canApplyTheme(drawable);
        }
        return false;
    }

    public void clearAnimationCallbacks() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            return;
        }
        removeAnimatorSetListener();
        ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.mAnimationCallbacks;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.mAnimatedVectorState.f16734b.draw(canvas);
        if (this.mAnimatedVectorState.f16735c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return this.mAnimatedVectorState.f16734b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mAnimatedVectorState.f16733a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat.getColorFilter(drawable);
        }
        return this.mAnimatedVectorState.f16734b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new d(this.mDelegateDrawable.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.mAnimatedVectorState.f16734b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.mAnimatedVectorState.f16734b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.mAnimatedVectorState.f16734b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (ANIMATED_VECTOR.equals(name)) {
                    TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, a.f16803e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat create = VectorDrawableCompat.create(resources, resourceId, theme);
                        create.setAllowCaching(false);
                        create.setCallback(this.mCallback);
                        VectorDrawableCompat vectorDrawableCompat = this.mAnimatedVectorState.f16734b;
                        if (vectorDrawableCompat != null) {
                            vectorDrawableCompat.setCallback((Drawable.Callback) null);
                        }
                        this.mAnimatedVectorState.f16734b = create;
                    }
                    obtainAttributes.recycle();
                } else if (TARGET.equals(name)) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, a.f16804f);
                    String string = obtainAttributes2.getString(0);
                    int resourceId2 = obtainAttributes2.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.mContext;
                        if (context != null) {
                            setupAnimatorsForTarget(string, AnimatorInflaterCompat.loadAnimator(context, resourceId2));
                        } else {
                            obtainAttributes2.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes2.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.mAnimatedVectorState.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat.isAutoMirrored(drawable);
        }
        return this.mAnimatedVectorState.f16734b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.mAnimatedVectorState.f16735c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.mAnimatedVectorState.f16734b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.mAnimatedVectorState.f16734b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        return this.mAnimatedVectorState.f16734b.setLevel(i10);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.mAnimatedVectorState.f16734b.setState(iArr);
    }

    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            registerPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
        } else if (animationCallback != null) {
            if (this.mAnimationCallbacks == null) {
                this.mAnimationCallbacks = new ArrayList<>();
            }
            if (!this.mAnimationCallbacks.contains(animationCallback)) {
                this.mAnimationCallbacks.add(animationCallback);
                if (this.mAnimatorListener == null) {
                    this.mAnimatorListener = new b();
                }
                this.mAnimatedVectorState.f16735c.addListener(this.mAnimatorListener);
            }
        }
    }

    public void setAlpha(int i10) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.mAnimatedVectorState.f16734b.setAlpha(i10);
        }
    }

    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z10);
        } else {
            this.mAnimatedVectorState.f16734b.setAutoMirrored(z10);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i10) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i10);
        } else {
            this.mAnimatedVectorState.f16734b.setTint(i10);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        } else {
            this.mAnimatedVectorState.f16734b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
        } else {
            this.mAnimatedVectorState.f16734b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.mAnimatedVectorState.f16734b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    public void start() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.mAnimatedVectorState.f16735c.isStarted()) {
            this.mAnimatedVectorState.f16735c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.mAnimatedVectorState.f16735c.end();
        }
    }

    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            unregisterPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
        }
        ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.mAnimationCallbacks;
        if (arrayList == null || animationCallback == null) {
            return false;
        }
        boolean remove = arrayList.remove(animationCallback);
        if (this.mAnimationCallbacks.size() == 0) {
            removeAnimatorSetListener();
        }
        return remove;
    }

    private AnimatedVectorDrawableCompat(@Nullable Context context) {
        this(context, (c) null, (Resources) null);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.mAnimatedVectorState.f16734b.setColorFilter(colorFilter);
        }
    }

    private static class d extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f16738a;

        public d(Drawable.ConstantState constantState) {
            this.f16738a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f16738a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f16738a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f16738a.newDrawable();
            animatedVectorDrawableCompat.mDelegateDrawable = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f16738a.newDrawable(resources);
            animatedVectorDrawableCompat.mDelegateDrawable = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f16738a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.mDelegateDrawable = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
            return animatedVectorDrawableCompat;
        }
    }

    private AnimatedVectorDrawableCompat(@Nullable Context context, @Nullable c cVar, @Nullable Resources resources) {
        this.mArgbEvaluator = null;
        this.mAnimatorListener = null;
        this.mAnimationCallbacks = null;
        a aVar = new a();
        this.mCallback = aVar;
        this.mContext = context;
        if (cVar != null) {
            this.mAnimatedVectorState = cVar;
        } else {
            this.mAnimatedVectorState = new c(context, cVar, aVar, resources);
        }
    }

    public static void clearAnimationCallbacks(Drawable drawable) {
        if (drawable instanceof Animatable) {
            if (Build.VERSION.SDK_INT >= 24) {
                ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            } else {
                ((AnimatedVectorDrawableCompat) drawable).clearAnimationCallbacks();
            }
        }
    }

    public static boolean unregisterAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable == null || animationCallback == null || !(drawable instanceof Animatable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return unregisterPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
        }
        return ((AnimatedVectorDrawableCompat) drawable).unregisterAnimationCallback(animationCallback);
    }

    public static void registerAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable != null && animationCallback != null && (drawable instanceof Animatable)) {
            if (Build.VERSION.SDK_INT >= 24) {
                registerPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
            } else {
                ((AnimatedVectorDrawableCompat) drawable).registerAnimationCallback(animationCallback);
            }
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }
}
