package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;

public final class ResourcesCompat {
    @AnyRes
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final Object sColorStateCacheLock = new Object();
    @GuardedBy("sColorStateCacheLock")
    private static final WeakHashMap<e, SparseArray<d>> sColorStateCaches = new WeakHashMap<>(0);
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();

    public static abstract class FontCallback {
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Handler getHandler(@Nullable Handler handler) {
            if (handler == null) {
                return new Handler(Looper.getMainLooper());
            }
            return handler;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(int i10, @Nullable Handler handler) {
            getHandler(handler).post(new e(this, i10));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(@NonNull Typeface typeface, @Nullable Handler handler) {
            getHandler(handler).post(new d(this, typeface));
        }

        /* renamed from: onFontRetrievalFailed */
        public abstract void lambda$callbackFailAsync$1(int i10);

        /* renamed from: onFontRetrieved */
        public abstract void lambda$callbackSuccessAsync$0(@NonNull Typeface typeface);
    }

    public static final class ThemeCompat {

        static class a {

            /* renamed from: a  reason: collision with root package name */
            private static final Object f14888a = new Object();

            /* renamed from: b  reason: collision with root package name */
            private static Method f14889b;

            /* renamed from: c  reason: collision with root package name */
            private static boolean f14890c;

            static void a(Resources.Theme theme) {
                synchronized (f14888a) {
                    if (!f14890c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", (Class[]) null);
                            f14889b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e10) {
                            Log.i(ResourcesCompat.TAG, "Failed to retrieve rebase() method", e10);
                        }
                        f14890c = true;
                    }
                    Method method = f14889b;
                    if (method != null) {
                        try {
                            method.invoke(theme, (Object[]) null);
                        } catch (IllegalAccessException | InvocationTargetException e11) {
                            Log.i(ResourcesCompat.TAG, "Failed to invoke rebase() method via reflection", e11);
                            f14889b = null;
                        }
                    }
                }
            }
        }

        static class b {
            @DoNotInline
            static void a(@NonNull Resources.Theme theme) {
                theme.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void rebase(@NonNull Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                b.a(theme);
            } else {
                a.a(theme);
            }
        }
    }

    static class a {
        @DoNotInline
        static Drawable a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getDrawable(i10, theme);
        }

        @DoNotInline
        static Drawable b(Resources resources, int i10, int i11, Resources.Theme theme) {
            return resources.getDrawableForDensity(i10, i11, theme);
        }
    }

    static class b {
        @DoNotInline
        static int a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColor(i10, theme);
        }

        @DoNotInline
        @NonNull
        static ColorStateList b(@NonNull Resources resources, @ColorRes int i10, @Nullable Resources.Theme theme) {
            return resources.getColorStateList(i10, theme);
        }
    }

    static class c {
        @DoNotInline
        static float a(@NonNull Resources resources, @DimenRes int i10) {
            return resources.getFloat(i10);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f14891a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f14892b;

        /* renamed from: c  reason: collision with root package name */
        final int f14893c;

        d(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            int i10;
            this.f14891a = colorStateList;
            this.f14892b = configuration;
            if (theme == null) {
                i10 = 0;
            } else {
                i10 = theme.hashCode();
            }
            this.f14893c = i10;
        }
    }

    private static final class e {

        /* renamed from: a  reason: collision with root package name */
        final Resources f14894a;

        /* renamed from: b  reason: collision with root package name */
        final Resources.Theme f14895b;

        e(Resources resources, Resources.Theme theme) {
            this.f14894a = resources;
            this.f14895b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            if (!this.f14894a.equals(eVar.f14894a) || !ObjectsCompat.equals(this.f14895b, eVar.f14895b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f14894a, this.f14895b);
        }
    }

    private ResourcesCompat() {
    }

    private static void addColorStateListToCache(@NonNull e eVar, @ColorRes int i10, @NonNull ColorStateList colorStateList, @Nullable Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            try {
                WeakHashMap<e, SparseArray<d>> weakHashMap = sColorStateCaches;
                SparseArray sparseArray = weakHashMap.get(eVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(eVar, sparseArray);
                }
                sparseArray.append(i10, new d(colorStateList, eVar.f14894a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void clearCachesForTheme(@NonNull Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            try {
                Iterator<e> it = sColorStateCaches.keySet().iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    if (next != null && theme.equals(next.f14895b)) {
                        it.remove();
                    }
                }
            } finally {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        if (r2.f14893c == r5.hashCode()) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList getCachedColorStateList(@androidx.annotation.NonNull androidx.core.content.res.ResourcesCompat.e r5, @androidx.annotation.ColorRes int r6) {
        /*
            java.lang.Object r0 = sColorStateCacheLock
            monitor-enter(r0)
            java.util.WeakHashMap<androidx.core.content.res.ResourcesCompat$e, android.util.SparseArray<androidx.core.content.res.ResourcesCompat$d>> r1 = sColorStateCaches     // Catch:{ all -> 0x0032 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0032 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0045
            int r2 = r1.size()     // Catch:{ all -> 0x0032 }
            if (r2 <= 0) goto L_0x0045
            java.lang.Object r2 = r1.get(r6)     // Catch:{ all -> 0x0032 }
            androidx.core.content.res.ResourcesCompat$d r2 = (androidx.core.content.res.ResourcesCompat.d) r2     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0045
            android.content.res.Configuration r3 = r2.f14892b     // Catch:{ all -> 0x0032 }
            android.content.res.Resources r4 = r5.f14894a     // Catch:{ all -> 0x0032 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0032 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x0042
            android.content.res.Resources$Theme r5 = r5.f14895b     // Catch:{ all -> 0x0032 }
            if (r5 != 0) goto L_0x0034
            int r3 = r2.f14893c     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x003e
            goto L_0x0034
        L_0x0032:
            r5 = move-exception
            goto L_0x0048
        L_0x0034:
            if (r5 == 0) goto L_0x0042
            int r3 = r2.f14893c     // Catch:{ all -> 0x0032 }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x0032 }
            if (r3 != r5) goto L_0x0042
        L_0x003e:
            android.content.res.ColorStateList r5 = r2.f14891a     // Catch:{ all -> 0x0032 }
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r5
        L_0x0042:
            r1.remove(r6)     // Catch:{ all -> 0x0032 }
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            r5 = 0
            return r5
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.getCachedColorStateList(androidx.core.content.res.ResourcesCompat$e, int):android.content.res.ColorStateList");
    }

    @Nullable
    public static Typeface getCachedFont(@NonNull Context context, @FontRes int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i10, new TypedValue(), 0, (FontCallback) null, (Handler) null, false, true);
    }

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i10, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return b.a(resources, i10, theme);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i10, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        e eVar = new e(resources, theme);
        ColorStateList cachedColorStateList = getCachedColorStateList(eVar, i10);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        ColorStateList inflateColorStateList = inflateColorStateList(resources, i10, theme);
        if (inflateColorStateList == null) {
            return b.b(resources, i10, theme);
        }
        addColorStateListToCache(eVar, i10, inflateColorStateList, theme);
        return inflateColorStateList;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i10, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return a.a(resources, i10, theme);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i10, int i11, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return a.b(resources, i10, i11, theme);
    }

    public static float getFloat(@NonNull Resources resources, @DimenRes int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            return c.a(resources, i10);
        }
        TypedValue typedValue = getTypedValue();
        resources.getValue(i10, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i10) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i10, new TypedValue(), 0, (FontCallback) null, (Handler) null, false, false);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = sTempTypedValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @Nullable
    private static ColorStateList inflateColorStateList(Resources resources, int i10, @Nullable Resources.Theme theme) {
        if (isColorInt(resources, i10)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.w(TAG, "Failed to inflate ColorStateList, leaving it to the framework", e10);
            return null;
        }
    }

    private static boolean isColorInt(@NonNull Resources resources, @ColorRes int i10) {
        TypedValue typedValue = getTypedValue();
        resources.getValue(i10, typedValue, true);
        int i11 = typedValue.type;
        if (i11 < 28 || i11 > 31) {
            return false;
        }
        return true;
    }

    private static Typeface loadFont(@NonNull Context context, int i10, @NonNull TypedValue typedValue, int i11, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z10, boolean z11) {
        Resources resources = context.getResources();
        int i12 = i10;
        resources.getValue(i10, typedValue, true);
        Typeface loadFont = loadFont(context, resources, typedValue, i10, i11, fontCallback, handler, z10, z11);
        if (loadFont != null || fontCallback != null || z11) {
            return loadFont;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i10) + " could not be retrieved.");
    }

    public static void getFont(@NonNull Context context, @FontRes int i10, @NonNull FontCallback fontCallback, @Nullable Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
            return;
        }
        loadFont(context, i10, new TypedValue(), 0, fontCallback, handler, false, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface loadFont(@androidx.annotation.NonNull android.content.Context r16, android.content.res.Resources r17, @androidx.annotation.NonNull android.util.TypedValue r18, int r19, int r20, @androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback r21, @androidx.annotation.Nullable android.os.Handler r22, boolean r23, boolean r24) {
        /*
            r0 = r17
            r1 = r18
            r4 = r19
            r11 = r21
            r12 = r22
            java.lang.String r13 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L_0x00c6
            java.lang.String r14 = r2.toString()
            java.lang.String r2 = "res/"
            boolean r2 = r14.startsWith(r2)
            r15 = 0
            r10 = -3
            if (r2 != 0) goto L_0x0024
            if (r11 == 0) goto L_0x0023
            r11.callbackFailAsync(r10, r12)
        L_0x0023:
            return r15
        L_0x0024:
            int r2 = r1.assetCookie
            r7 = r20
            android.graphics.Typeface r2 = androidx.core.graphics.TypefaceCompat.findFromCache(r0, r4, r14, r2, r7)
            if (r2 == 0) goto L_0x0034
            if (r11 == 0) goto L_0x0033
            r11.callbackSuccessAsync(r2, r12)
        L_0x0033:
            return r2
        L_0x0034:
            if (r24 == 0) goto L_0x0037
            return r15
        L_0x0037:
            java.lang.String r2 = r14.toLowerCase()     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            java.lang.String r3 = ".xml"
            boolean r2 = r2.endsWith(r3)     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            if (r2 == 0) goto L_0x007a
            android.content.res.XmlResourceParser r2 = r0.getXml(r4)     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r2 = androidx.core.content.res.FontResourcesParserCompat.parse(r2, r0)     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            if (r2 != 0) goto L_0x005f
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r13, r0)     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            if (r11 == 0) goto L_0x005e
            r11.callbackFailAsync(r10, r12)     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            goto L_0x005e
        L_0x0058:
            r0 = move-exception
            r15 = r10
            goto L_0x0096
        L_0x005b:
            r0 = move-exception
            r15 = r10
            goto L_0x00ab
        L_0x005e:
            return r15
        L_0x005f:
            int r6 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            r1 = r16
            r3 = r17
            r4 = r19
            r5 = r14
            r7 = r20
            r8 = r21
            r9 = r22
            r15 = r10
            r10 = r23
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.createFromResourcesFamilyXml(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ XmlPullParserException -> 0x0078, IOException -> 0x0076 }
            return r0
        L_0x0076:
            r0 = move-exception
            goto L_0x0096
        L_0x0078:
            r0 = move-exception
            goto L_0x00ab
        L_0x007a:
            r15 = r10
            int r5 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x0078, IOException -> 0x0076 }
            r1 = r16
            r2 = r17
            r3 = r19
            r4 = r14
            r6 = r20
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.createFromResourcesFontFile(r1, r2, r3, r4, r5, r6)     // Catch:{ XmlPullParserException -> 0x0078, IOException -> 0x0076 }
            if (r11 == 0) goto L_0x0095
            if (r0 == 0) goto L_0x0092
            r11.callbackSuccessAsync(r0, r12)     // Catch:{ XmlPullParserException -> 0x0078, IOException -> 0x0076 }
            goto L_0x0095
        L_0x0092:
            r11.callbackFailAsync(r15, r12)     // Catch:{ XmlPullParserException -> 0x0078, IOException -> 0x0076 }
        L_0x0095:
            return r0
        L_0x0096:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
            goto L_0x00bf
        L_0x00ab:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
        L_0x00bf:
            if (r11 == 0) goto L_0x00c4
            r11.callbackFailAsync(r15, r12)
        L_0x00c4:
            r1 = 0
            return r1
        L_0x00c6:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r19)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.loadFont(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context context, @FontRes int i10, @NonNull TypedValue typedValue, int i11, @Nullable FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i10, typedValue, i11, fontCallback, (Handler) null, true, false);
    }
}
