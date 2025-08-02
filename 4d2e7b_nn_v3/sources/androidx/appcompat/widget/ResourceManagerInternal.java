package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ResourceManagerInternal {
    private static final c COLOR_FILTER_CACHE = new c(6);
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static ResourceManagerInternal INSTANCE = null;
    private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final String TAG = "ResourceManagerInternal";
    private SimpleArrayMap<String, e> mDelegates;
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap<>(0);
    private boolean mHasCheckedVectorDrawableSetup;
    private ResourceManagerHooks mHooks;
    private SparseArrayCompat<String> mKnownDrawableIdTags;
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
    private TypedValue mTypedValue;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ResourceManagerHooks {
        @Nullable
        Drawable createDrawableFor(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, @DrawableRes int i10);

        @Nullable
        ColorStateList getTintListForDrawableRes(@NonNull Context context, @DrawableRes int i10);

        @Nullable
        PorterDuff.Mode getTintModeForDrawableRes(int i10);

        boolean tintDrawable(@NonNull Context context, @DrawableRes int i10, @NonNull Drawable drawable);

        boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i10, @NonNull Drawable drawable);
    }

    static class a implements e {
        a() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e10);
                return null;
            }
        }
    }

    private static class b implements e {
        b() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e10);
                return null;
            }
        }
    }

    private static class c extends LruCache {
        public c(int i10) {
            super(i10);
        }

        private static int a(int i10, PorterDuff.Mode mode) {
            return ((i10 + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter b(int i10, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(a(i10, mode)));
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter c(int i10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(a(i10, mode)), porterDuffColorFilter);
        }
    }

    static class d implements e {
        d() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                    Compatibility.Api21Impl.inflate(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e10) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e10);
                }
            }
            return null;
        }
    }

    private interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    private static class f implements e {
        f() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e10);
                return null;
            }
        }
    }

    private void addDelegate(@NonNull String str, @NonNull e eVar) {
        if (this.mDelegates == null) {
            this.mDelegates = new SimpleArrayMap<>();
        }
        this.mDelegates.put(str, eVar);
    }

    private synchronized boolean addDrawableToCache(@NonNull Context context, long j10, @NonNull Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            LongSparseArray longSparseArray = this.mDrawableCaches.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray();
                this.mDrawableCaches.put(context, longSparseArray);
            }
            longSparseArray.put(j10, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void addTintListToCache(@NonNull Context context, @DrawableRes int i10, @NonNull ColorStateList colorStateList) {
        if (this.mTintLists == null) {
            this.mTintLists = new WeakHashMap<>();
        }
        SparseArrayCompat sparseArrayCompat = this.mTintLists.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat();
            this.mTintLists.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(i10, colorStateList);
    }

    private void checkVectorDrawableSetup(@NonNull Context context) {
        if (!this.mHasCheckedVectorDrawableSetup) {
            this.mHasCheckedVectorDrawableSetup = true;
            Drawable drawable = getDrawable(context, R.drawable.abc_vector_test);
            if (drawable == null || !isVectorDrawable(drawable)) {
                this.mHasCheckedVectorDrawableSetup = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static long createCacheKey(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable createDrawableIfNeeded(@NonNull Context context, @DrawableRes int i10) {
        Drawable drawable;
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        context.getResources().getValue(i10, typedValue, true);
        long createCacheKey = createCacheKey(typedValue);
        Drawable cachedDrawable = getCachedDrawable(context, createCacheKey);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        if (resourceManagerHooks == null) {
            drawable = null;
        } else {
            drawable = resourceManagerHooks.createDrawableFor(this, context, i10);
        }
        if (drawable != null) {
            drawable.setChangingConfigurations(typedValue.changingConfigurations);
            addDrawableToCache(context, createCacheKey, drawable);
        }
        return drawable;
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized ResourceManagerInternal get() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            try {
                if (INSTANCE == null) {
                    ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                    INSTANCE = resourceManagerInternal2;
                    installDefaultInflateDelegates(resourceManagerInternal2);
                }
                resourceManagerInternal = INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return resourceManagerInternal;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable getCachedDrawable(@androidx.annotation.NonNull android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.mDrawableCaches     // Catch:{ all -> 0x0028 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0028 }
            androidx.collection.LongSparseArray r0 = (androidx.collection.LongSparseArray) r0     // Catch:{ all -> 0x0028 }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.get(r5)     // Catch:{ all -> 0x0028 }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0028 }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x002a
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0028 }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x0028 }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r4 = move-exception
            goto L_0x002f
        L_0x002a:
            r0.remove(r5)     // Catch:{ all -> 0x0028 }
        L_0x002d:
            monitor-exit(r3)
            return r1
        L_0x002f:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.getCachedDrawable(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter b10;
        synchronized (ResourceManagerInternal.class) {
            c cVar = COLOR_FILTER_CACHE;
            b10 = cVar.b(i10, mode);
            if (b10 == null) {
                b10 = new PorterDuffColorFilter(i10, mode);
                cVar.c(i10, mode, b10);
            }
        }
        return b10;
    }

    private ColorStateList getTintListFromCache(@NonNull Context context, @DrawableRes int i10) {
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.mTintLists;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) sparseArrayCompat.get(i10);
    }

    private static void installDefaultInflateDelegates(@NonNull ResourceManagerInternal resourceManagerInternal) {
        if (Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.addDelegate("vector", new f());
            resourceManagerInternal.addDelegate("animated-vector", new b());
            resourceManagerInternal.addDelegate("animated-selector", new a());
            resourceManagerInternal.addDelegate("drawable", new d());
        }
    }

    private static boolean isVectorDrawable(@NonNull Drawable drawable) {
        if ((drawable instanceof VectorDrawableCompat) || PLATFORM_VD_CLAZZ.equals(drawable.getClass().getName())) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009c A[Catch:{ Exception -> 0x008f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable loadDrawableFromDelegates(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.DrawableRes int r12) {
        /*
            r10 = this;
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$e> r0 = r10.mDelegates
            r1 = 0
            if (r0 == 0) goto L_0x00b3
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b3
            androidx.collection.SparseArrayCompat<java.lang.String> r0 = r10.mKnownDrawableIdTags
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.get(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$e> r3 = r10.mDelegates
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            androidx.collection.SparseArrayCompat r0 = new androidx.collection.SparseArrayCompat
            r0.<init>()
            r10.mKnownDrawableIdTags = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.mTypedValue
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.mTypedValue = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.mTypedValue
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = createCacheKey(r0)
            android.graphics.drawable.Drawable r6 = r10.getCachedDrawable(r11, r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00ab
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00ab
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x008f }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x008f }
        L_0x0067:
            int r8 = r1.next()     // Catch:{ Exception -> 0x008f }
            r9 = 2
            if (r8 == r9) goto L_0x0071
            if (r8 == r3) goto L_0x0071
            goto L_0x0067
        L_0x0071:
            if (r8 != r9) goto L_0x009c
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x008f }
            androidx.collection.SparseArrayCompat<java.lang.String> r8 = r10.mKnownDrawableIdTags     // Catch:{ Exception -> 0x008f }
            r8.append(r12, r3)     // Catch:{ Exception -> 0x008f }
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$e> r8 = r10.mDelegates     // Catch:{ Exception -> 0x008f }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x008f }
            androidx.appcompat.widget.ResourceManagerInternal$e r3 = (androidx.appcompat.widget.ResourceManagerInternal.e) r3     // Catch:{ Exception -> 0x008f }
            if (r3 == 0) goto L_0x0091
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x008f }
            android.graphics.drawable.Drawable r6 = r3.a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x008f }
            goto L_0x0091
        L_0x008f:
            r11 = move-exception
            goto L_0x00a4
        L_0x0091:
            if (r6 == 0) goto L_0x00ab
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x008f }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x008f }
            r10.addDrawableToCache(r11, r4, r6)     // Catch:{ Exception -> 0x008f }
            goto L_0x00ab
        L_0x009c:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x008f }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x008f }
            throw r11     // Catch:{ Exception -> 0x008f }
        L_0x00a4:
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00ab:
            if (r6 != 0) goto L_0x00b2
            androidx.collection.SparseArrayCompat<java.lang.String> r11 = r10.mKnownDrawableIdTags
            r11.append(r12, r2)
        L_0x00b2:
            return r6
        L_0x00b3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.loadDrawableFromDelegates(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private Drawable tintDrawable(@NonNull Context context, @DrawableRes int i10, boolean z10, @NonNull Drawable drawable) {
        ColorStateList tintList = getTintList(context, i10);
        if (tintList != null) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable wrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(wrap, tintList);
            PorterDuff.Mode tintMode = getTintMode(i10);
            if (tintMode == null) {
                return wrap;
            }
            DrawableCompat.setTintMode(wrap, tintMode);
            return wrap;
        }
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        if ((resourceManagerHooks == null || !resourceManagerHooks.tintDrawable(context, i10, drawable)) && !tintDrawableUsingColorFilter(context, i10, drawable) && z10) {
            return null;
        }
        return drawable;
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i10) {
        return getDrawable(context, i10, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList getTintList(@NonNull Context context, @DrawableRes int i10) {
        ColorStateList tintListFromCache;
        tintListFromCache = getTintListFromCache(context, i10);
        if (tintListFromCache == null) {
            ResourceManagerHooks resourceManagerHooks = this.mHooks;
            if (resourceManagerHooks == null) {
                tintListFromCache = null;
            } else {
                tintListFromCache = resourceManagerHooks.getTintListForDrawableRes(context, i10);
            }
            if (tintListFromCache != null) {
                addTintListToCache(context, i10, tintListFromCache);
            }
        }
        return tintListFromCache;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode getTintMode(int i10) {
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        if (resourceManagerHooks == null) {
            return null;
        }
        return resourceManagerHooks.getTintModeForDrawableRes(i10);
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        LongSparseArray longSparseArray = this.mDrawableCaches.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable onDrawableLoadedFromResources(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i10) {
        try {
            Drawable loadDrawableFromDelegates = loadDrawableFromDelegates(context, i10);
            if (loadDrawableFromDelegates == null) {
                loadDrawableFromDelegates = vectorEnabledTintResources.getDrawableCanonical(i10);
            }
            if (loadDrawableFromDelegates == null) {
                return null;
            }
            return tintDrawable(context, i10, false, loadDrawableFromDelegates);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setHooks(ResourceManagerHooks resourceManagerHooks) {
        this.mHooks = resourceManagerHooks;
    }

    /* access modifiers changed from: package-private */
    public boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i10, @NonNull Drawable drawable) {
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        if (resourceManagerHooks == null || !resourceManagerHooks.tintDrawableUsingColorFilter(context, i10, drawable)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i10, boolean z10) {
        Drawable loadDrawableFromDelegates;
        try {
            checkVectorDrawableSetup(context);
            loadDrawableFromDelegates = loadDrawableFromDelegates(context, i10);
            if (loadDrawableFromDelegates == null) {
                loadDrawableFromDelegates = createDrawableIfNeeded(context, i10);
            }
            if (loadDrawableFromDelegates == null) {
                loadDrawableFromDelegates = ContextCompat.getDrawable(context, i10);
            }
            if (loadDrawableFromDelegates != null) {
                loadDrawableFromDelegates = tintDrawable(context, i10, z10, loadDrawableFromDelegates);
            }
            if (loadDrawableFromDelegates != null) {
                DrawableUtils.fixDrawable(loadDrawableFromDelegates);
            }
        } catch (Throwable th) {
            throw th;
        }
        return loadDrawableFromDelegates;
    }

    static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        int[] state = drawable.getState();
        if (!DrawableUtils.canSafelyMutateDrawable(drawable) || drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z10 = tintInfo.mHasTintList;
            if (z10 || tintInfo.mHasTintMode) {
                drawable.setColorFilter(createTintFilter(z10 ? tintInfo.mTintList : null, tintInfo.mHasTintMode ? tintInfo.mTintMode : DEFAULT_MODE, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d(TAG, "Mutated drawable is not the same instance as the input.");
    }
}
