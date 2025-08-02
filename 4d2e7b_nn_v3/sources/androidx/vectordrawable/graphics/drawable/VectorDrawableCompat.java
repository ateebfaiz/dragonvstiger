package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends b {
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    static final String LOGTAG = "VectorDrawableCompat";
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching;
    private Drawable.ConstantState mCachedConstantStateDelegate;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;
    private h mVectorState;

    private static class b extends f {
        b() {
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f16766b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f16765a = PathParser.createNodesFromPathData(string2);
            }
            this.f16767c = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public boolean c() {
            return true;
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, a.f16802d);
                h(obtainAttributes, xmlPullParser);
                obtainAttributes.recycle();
            }
        }

        b(b bVar) {
            super(bVar);
        }
    }

    private static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    private static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f16786a;

        /* renamed from: b  reason: collision with root package name */
        g f16787b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f16788c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f16789d;

        /* renamed from: e  reason: collision with root package name */
        boolean f16790e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f16791f;

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f16792g;

        /* renamed from: h  reason: collision with root package name */
        PorterDuff.Mode f16793h;

        /* renamed from: i  reason: collision with root package name */
        int f16794i;

        /* renamed from: j  reason: collision with root package name */
        boolean f16795j;

        /* renamed from: k  reason: collision with root package name */
        boolean f16796k;

        /* renamed from: l  reason: collision with root package name */
        Paint f16797l;

        public h(h hVar) {
            this.f16788c = null;
            this.f16789d = VectorDrawableCompat.DEFAULT_TINT_MODE;
            if (hVar != null) {
                this.f16786a = hVar.f16786a;
                g gVar = new g(hVar.f16787b);
                this.f16787b = gVar;
                if (hVar.f16787b.f16774e != null) {
                    gVar.f16774e = new Paint(hVar.f16787b.f16774e);
                }
                if (hVar.f16787b.f16773d != null) {
                    this.f16787b.f16773d = new Paint(hVar.f16787b.f16773d);
                }
                this.f16788c = hVar.f16788c;
                this.f16789d = hVar.f16789d;
                this.f16790e = hVar.f16790e;
            }
        }

        public boolean a(int i10, int i11) {
            if (i10 == this.f16791f.getWidth() && i11 == this.f16791f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (!this.f16796k && this.f16792g == this.f16788c && this.f16793h == this.f16789d && this.f16795j == this.f16790e && this.f16794i == this.f16787b.getRootAlpha()) {
                return true;
            }
            return false;
        }

        public void c(int i10, int i11) {
            if (this.f16791f == null || !a(i10, i11)) {
                this.f16791f = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                this.f16796k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f16791f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f16797l == null) {
                Paint paint = new Paint();
                this.f16797l = paint;
                paint.setFilterBitmap(true);
            }
            this.f16797l.setAlpha(this.f16787b.getRootAlpha());
            this.f16797l.setColorFilter(colorFilter);
            return this.f16797l;
        }

        public boolean f() {
            if (this.f16787b.getRootAlpha() < 255) {
                return true;
            }
            return false;
        }

        public boolean g() {
            return this.f16787b.f();
        }

        public int getChangingConfigurations() {
            return this.f16786a;
        }

        public boolean h(int[] iArr) {
            boolean g10 = this.f16787b.g(iArr);
            this.f16796k |= g10;
            return g10;
        }

        public void i() {
            this.f16792g = this.f16788c;
            this.f16793h = this.f16789d;
            this.f16794i = this.f16787b.getRootAlpha();
            this.f16795j = this.f16790e;
            this.f16796k = false;
        }

        public void j(int i10, int i11) {
            this.f16791f.eraseColor(0);
            this.f16787b.b(new Canvas(this.f16791f), i10, i11, (ColorFilter) null);
        }

        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public h() {
            this.f16788c = null;
            this.f16789d = VectorDrawableCompat.DEFAULT_TINT_MODE;
            this.f16787b = new g();
        }
    }

    VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new h();
    }

    static int applyAlpha(int i10, float f10) {
        return (i10 & ViewCompat.MEASURED_SIZE_MASK) | (((int) (((float) Color.alpha(i10)) * f10)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041 A[Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.VectorDrawableCompat create(@androidx.annotation.NonNull android.content.res.Resources r6, @androidx.annotation.DrawableRes int r7, @androidx.annotation.Nullable android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0023
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r0 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
            r0.<init>()
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.ResourcesCompat.getDrawable(r6, r7, r8)
            r0.mDelegateDrawable = r6
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$i r6 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$i
            android.graphics.drawable.Drawable r7 = r0.mDelegateDrawable
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.mCachedConstantStateDelegate = r6
            return r0
        L_0x0023:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
        L_0x002b:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            r4 = 2
            if (r3 == r4) goto L_0x0036
            r5 = 1
            if (r3 == r5) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            if (r3 != r4) goto L_0x0041
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r6 = createFromXmlInner(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            return r6
        L_0x003d:
            r6 = move-exception
            goto L_0x0049
        L_0x003f:
            r6 = move-exception
            goto L_0x004d
        L_0x0041:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            throw r6     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
        L_0x0049:
            android.util.Log.e(r1, r0, r6)
            goto L_0x0050
        L_0x004d:
            android.util.Log.e(r1, r0, r6)
        L_0x0050:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.create(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.graphics.drawable.VectorDrawableCompat");
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    private void inflateInternal(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.mVectorState;
        g gVar = hVar.f16787b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f16777h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z10 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if (SHAPE_PATH.equals(name)) {
                    c cVar = new c();
                    cVar.i(resources, attributeSet, theme, xmlPullParser);
                    dVar.f16753b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f16785p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f16786a = cVar.f16768d | hVar.f16786a;
                    z10 = false;
                } else if (SHAPE_CLIP_PATH.equals(name)) {
                    b bVar = new b();
                    bVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f16753b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f16785p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f16786a = bVar.f16768d | hVar.f16786a;
                } else if (SHAPE_GROUP.equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f16753b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f16785p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f16786a = dVar2.f16762k | hVar.f16786a;
                }
            } else if (eventType == 3 && SHAPE_GROUP.equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z10) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean needMirroring() {
        if (!isAutoMirrored() || DrawableCompat.getLayoutDirection(this) != 1) {
            return false;
        }
        return true;
    }

    private static PorterDuff.Mode parseTintModeCompat(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void printGroupTree(d dVar, int i10) {
        String str = "";
        for (int i11 = 0; i11 < i10; i11++) {
            str = str + "    ";
        }
        Log.v(LOGTAG, str + "current group is :" + dVar.getGroupName() + " rotation is " + dVar.f16754c);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("matrix is :");
        sb2.append(dVar.getLocalMatrix().toString());
        Log.v(LOGTAG, sb2.toString());
        for (int i12 = 0; i12 < dVar.f16753b.size(); i12++) {
            e eVar = (e) dVar.f16753b.get(i12);
            if (eVar instanceof d) {
                printGroupTree((d) eVar, i10 + 1);
            } else {
                ((f) eVar).e(i10 + 1);
            }
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.mVectorState;
        g gVar = hVar.f16787b;
        hVar.f16789d = parseTintModeCompat(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList namedColorStateList = TypedArrayUtils.getNamedColorStateList(typedArray, xmlPullParser, theme, "tint", 1);
        if (namedColorStateList != null) {
            hVar.f16788c = namedColorStateList;
        }
        hVar.f16790e = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f16790e);
        gVar.f16780k = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f16780k);
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f16781l);
        gVar.f16781l = namedFloat;
        if (gVar.f16780k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (namedFloat > 0.0f) {
            gVar.f16778i = typedArray.getDimension(3, gVar.f16778i);
            float dimension = typedArray.getDimension(2, gVar.f16779j);
            gVar.f16779j = dimension;
            if (gVar.f16778i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                gVar.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.f16783n = string;
                    gVar.f16785p.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) {
            return false;
        }
        DrawableCompat.canApplyTheme(drawable);
        return false;
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
        copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() > 0 && this.mTmpBounds.height() > 0) {
            ColorFilter colorFilter = this.mColorFilter;
            if (colorFilter == null) {
                colorFilter = this.mTintFilter;
            }
            canvas.getMatrix(this.mTmpMatrix);
            this.mTmpMatrix.getValues(this.mTmpFloats);
            float abs = Math.abs(this.mTmpFloats[0]);
            float abs2 = Math.abs(this.mTmpFloats[4]);
            float abs3 = Math.abs(this.mTmpFloats[1]);
            float abs4 = Math.abs(this.mTmpFloats[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.mTmpBounds.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.mTmpBounds.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.mTmpBounds;
                canvas.translate((float) rect.left, (float) rect.top);
                if (needMirroring()) {
                    canvas.translate((float) this.mTmpBounds.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.mTmpBounds.offsetTo(0, 0);
                this.mVectorState.c(min, min2);
                if (!this.mAllowCaching) {
                    this.mVectorState.j(min, min2);
                } else if (!this.mVectorState.b()) {
                    this.mVectorState.j(min, min2);
                    this.mVectorState.i();
                }
                this.mVectorState.d(canvas, colorFilter, this.mTmpBounds);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return this.mVectorState.f16787b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat.getColorFilter(drawable);
        }
        return this.mColorFilter;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.mDelegateDrawable.getConstantState());
        }
        this.mVectorState.f16786a = getChangingConfigurations();
        return this.mVectorState;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.mVectorState.f16787b.f16779j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.mVectorState.f16787b.f16778i;
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
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public float getPixelSize() {
        g gVar;
        h hVar = this.mVectorState;
        if (hVar == null || (gVar = hVar.f16787b) == null) {
            return 1.0f;
        }
        float f10 = gVar.f16778i;
        if (f10 == 0.0f) {
            return 1.0f;
        }
        float f11 = gVar.f16779j;
        if (f11 == 0.0f) {
            return 1.0f;
        }
        float f12 = gVar.f16781l;
        if (f12 == 0.0f) {
            return 1.0f;
        }
        float f13 = gVar.f16780k;
        if (f13 == 0.0f) {
            return 1.0f;
        }
        return Math.min(f13 / f10, f12 / f11);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    /* access modifiers changed from: package-private */
    public Object getTargetByName(String str) {
        return this.mVectorState.f16787b.f16785p.get(str);
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat.isAutoMirrored(drawable);
        }
        return this.mVectorState.f16790e;
    }

    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful() || ((hVar = this.mVectorState) != null && (hVar.g() || ((colorStateList = this.mVectorState.f16788c) != null && colorStateList.isStateful())))) {
            return true;
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.mMutated && super.mutate() == this) {
            this.mVectorState = new h(this.mVectorState);
            this.mMutated = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.mVectorState;
        ColorStateList colorStateList = hVar.f16788c;
        if (colorStateList == null || (mode = hVar.f16789d) == null) {
            z10 = false;
        } else {
            this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z10;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    /* access modifiers changed from: package-private */
    public void setAllowCaching(boolean z10) {
        this.mAllowCaching = z10;
    }

    public void setAlpha(int i10) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.mVectorState.f16787b.getRootAlpha() != i10) {
            this.mVectorState.f16787b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z10);
        } else {
            this.mVectorState.f16790e = z10;
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
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            return;
        }
        h hVar = this.mVectorState;
        if (hVar.f16788c != colorStateList) {
            hVar.f16788c = colorStateList;
            this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, hVar.f16789d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
            return;
        }
        h hVar = this.mVectorState;
        if (hVar.f16789d != mode) {
            hVar.f16789d = mode;
            this.mTintFilter = updateTintFilter(this.mTintFilter, hVar.f16788c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        return super.setVisible(z10, z11);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    public PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private static class i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f16798a;

        public i(Drawable.ConstantState constantState) {
            this.f16798a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f16798a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f16798a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.f16798a.newDrawable();
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.f16798a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.f16798a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    private static abstract class f extends e {

        /* renamed from: a  reason: collision with root package name */
        protected PathParser.PathDataNode[] f16765a = null;

        /* renamed from: b  reason: collision with root package name */
        String f16766b;

        /* renamed from: c  reason: collision with root package name */
        int f16767c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f16768d;

        public f() {
            super();
        }

        public boolean c() {
            return false;
        }

        public String d(PathParser.PathDataNode[] pathDataNodeArr) {
            String str = " ";
            for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
                str = str + pathDataNodeArr[i10].mType + ":";
                float[] fArr = pathDataNodeArr[i10].mParams;
                for (int i11 = 0; i11 < fArr.length; i11++) {
                    str = str + fArr[i11] + ",";
                }
            }
            return str;
        }

        public void e(int i10) {
            String str = "";
            for (int i11 = 0; i11 < i10; i11++) {
                str = str + "    ";
            }
            Log.v(VectorDrawableCompat.LOGTAG, str + "current path is :" + this.f16766b + " pathData is " + d(this.f16765a));
        }

        public void f(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.f16765a;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.nodesToPath(pathDataNodeArr, path);
            }
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.f16765a;
        }

        public String getPathName() {
            return this.f16766b;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.canMorph(this.f16765a, pathDataNodeArr)) {
                this.f16765a = PathParser.deepCopyNodes(pathDataNodeArr);
            } else {
                PathParser.updateNodes(this.f16765a, pathDataNodeArr);
            }
        }

        public f(f fVar) {
            super();
            this.f16766b = fVar.f16766b;
            this.f16768d = fVar.f16768d;
            this.f16765a = PathParser.deepCopyNodes(fVar.f16765a);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.mVectorState;
        hVar.f16787b = new g();
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, a.f16799a);
        updateStateFromTypedArray(obtainAttributes, xmlPullParser, theme);
        obtainAttributes.recycle();
        hVar.f16786a = getChangingConfigurations();
        hVar.f16796k = true;
        inflateInternal(resources, xmlPullParser, attributeSet, theme);
        this.mTintFilter = updateTintFilter(this.mTintFilter, hVar.f16788c, hVar.f16789d);
    }

    VectorDrawableCompat(@NonNull h hVar) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = hVar;
        this.mTintFilter = updateTintFilter(this.mTintFilter, hVar.f16788c, hVar.f16789d);
    }

    private static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private int[] f16740e;

        /* renamed from: f  reason: collision with root package name */
        ComplexColorCompat f16741f;

        /* renamed from: g  reason: collision with root package name */
        float f16742g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        ComplexColorCompat f16743h;

        /* renamed from: i  reason: collision with root package name */
        float f16744i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        float f16745j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        float f16746k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        float f16747l = 1.0f;

        /* renamed from: m  reason: collision with root package name */
        float f16748m = 0.0f;

        /* renamed from: n  reason: collision with root package name */
        Paint.Cap f16749n = Paint.Cap.BUTT;

        /* renamed from: o  reason: collision with root package name */
        Paint.Join f16750o = Paint.Join.MITER;

        /* renamed from: p  reason: collision with root package name */
        float f16751p = 4.0f;

        c() {
        }

        private Paint.Cap g(int i10, Paint.Cap cap) {
            if (i10 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i10 == 1) {
                return Paint.Cap.ROUND;
            }
            if (i10 != 2) {
                return cap;
            }
            return Paint.Cap.SQUARE;
        }

        private Paint.Join h(int i10, Paint.Join join) {
            if (i10 == 0) {
                return Paint.Join.MITER;
            }
            if (i10 == 1) {
                return Paint.Join.ROUND;
            }
            if (i10 != 2) {
                return join;
            }
            return Paint.Join.BEVEL;
        }

        private void j(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f16740e = null;
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f16766b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f16765a = PathParser.createNodesFromPathData(string2);
                }
                Resources.Theme theme2 = theme;
                this.f16743h = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f16745j = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.f16745j);
                this.f16749n = g(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f16749n);
                this.f16750o = h(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f16750o);
                this.f16751p = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f16751p);
                this.f16741f = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f16744i = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.f16744i);
                this.f16742g = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, this.f16742g);
                this.f16747l = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.f16747l);
                this.f16748m = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.f16748m);
                this.f16746k = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.f16746k);
                this.f16767c = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, this.f16767c);
            }
        }

        public boolean a() {
            if (this.f16743h.isStateful() || this.f16741f.isStateful()) {
                return true;
            }
            return false;
        }

        public boolean b(int[] iArr) {
            return this.f16741f.onStateChanged(iArr) | this.f16743h.onStateChanged(iArr);
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.f16745j;
        }

        /* access modifiers changed from: package-private */
        @ColorInt
        public int getFillColor() {
            return this.f16743h.getColor();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.f16744i;
        }

        /* access modifiers changed from: package-private */
        @ColorInt
        public int getStrokeColor() {
            return this.f16741f.getColor();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f16742g;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.f16747l;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.f16748m;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.f16746k;
        }

        public void i(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, a.f16801c);
            j(obtainAttributes, xmlPullParser, theme);
            obtainAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f10) {
            this.f16745j = f10;
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i10) {
            this.f16743h.setColor(i10);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f10) {
            this.f16744i = f10;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i10) {
            this.f16741f.setColor(i10);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f10) {
            this.f16742g = f10;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f10) {
            this.f16747l = f10;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f10) {
            this.f16748m = f10;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f10) {
            this.f16746k = f10;
        }

        c(c cVar) {
            super(cVar);
            this.f16740e = cVar.f16740e;
            this.f16741f = cVar.f16741f;
            this.f16742g = cVar.f16742g;
            this.f16744i = cVar.f16744i;
            this.f16743h = cVar.f16743h;
            this.f16767c = cVar.f16767c;
            this.f16745j = cVar.f16745j;
            this.f16746k = cVar.f16746k;
            this.f16747l = cVar.f16747l;
            this.f16748m = cVar.f16748m;
            this.f16749n = cVar.f16749n;
            this.f16750o = cVar.f16750o;
            this.f16751p = cVar.f16751p;
        }
    }

    private static class g {

        /* renamed from: q  reason: collision with root package name */
        private static final Matrix f16769q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        private final Path f16770a;

        /* renamed from: b  reason: collision with root package name */
        private final Path f16771b;

        /* renamed from: c  reason: collision with root package name */
        private final Matrix f16772c;

        /* renamed from: d  reason: collision with root package name */
        Paint f16773d;

        /* renamed from: e  reason: collision with root package name */
        Paint f16774e;

        /* renamed from: f  reason: collision with root package name */
        private PathMeasure f16775f;

        /* renamed from: g  reason: collision with root package name */
        private int f16776g;

        /* renamed from: h  reason: collision with root package name */
        final d f16777h;

        /* renamed from: i  reason: collision with root package name */
        float f16778i;

        /* renamed from: j  reason: collision with root package name */
        float f16779j;

        /* renamed from: k  reason: collision with root package name */
        float f16780k;

        /* renamed from: l  reason: collision with root package name */
        float f16781l;

        /* renamed from: m  reason: collision with root package name */
        int f16782m;

        /* renamed from: n  reason: collision with root package name */
        String f16783n;

        /* renamed from: o  reason: collision with root package name */
        Boolean f16784o;

        /* renamed from: p  reason: collision with root package name */
        final ArrayMap f16785p;

        public g() {
            this.f16772c = new Matrix();
            this.f16778i = 0.0f;
            this.f16779j = 0.0f;
            this.f16780k = 0.0f;
            this.f16781l = 0.0f;
            this.f16782m = 255;
            this.f16783n = null;
            this.f16784o = null;
            this.f16785p = new ArrayMap();
            this.f16777h = new d();
            this.f16770a = new Path();
            this.f16771b = new Path();
        }

        private static float a(float f10, float f11, float f12, float f13) {
            return (f10 * f13) - (f11 * f12);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            dVar.f16752a.set(matrix);
            dVar.f16752a.preConcat(dVar.f16761j);
            canvas.save();
            for (int i12 = 0; i12 < dVar.f16753b.size(); i12++) {
                e eVar = (e) dVar.f16753b.get(i12);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f16752a, canvas, i10, i11, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i10, i11, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            Path.FillType fillType;
            Path.FillType fillType2;
            float f10 = ((float) i10) / this.f16780k;
            float f11 = ((float) i11) / this.f16781l;
            float min = Math.min(f10, f11);
            Matrix matrix = dVar.f16752a;
            this.f16772c.set(matrix);
            this.f16772c.postScale(f10, f11);
            float e10 = e(matrix);
            if (e10 != 0.0f) {
                fVar.f(this.f16770a);
                Path path = this.f16770a;
                this.f16771b.reset();
                if (fVar.c()) {
                    Path path2 = this.f16771b;
                    if (fVar.f16767c == 0) {
                        fillType2 = Path.FillType.WINDING;
                    } else {
                        fillType2 = Path.FillType.EVEN_ODD;
                    }
                    path2.setFillType(fillType2);
                    this.f16771b.addPath(path, this.f16772c);
                    canvas.clipPath(this.f16771b);
                    return;
                }
                c cVar = (c) fVar;
                float f12 = cVar.f16746k;
                if (!(f12 == 0.0f && cVar.f16747l == 1.0f)) {
                    float f13 = cVar.f16748m;
                    float f14 = (f12 + f13) % 1.0f;
                    float f15 = (cVar.f16747l + f13) % 1.0f;
                    if (this.f16775f == null) {
                        this.f16775f = new PathMeasure();
                    }
                    this.f16775f.setPath(this.f16770a, false);
                    float length = this.f16775f.getLength();
                    float f16 = f14 * length;
                    float f17 = f15 * length;
                    path.reset();
                    if (f16 > f17) {
                        this.f16775f.getSegment(f16, length, path, true);
                        this.f16775f.getSegment(0.0f, f17, path, true);
                    } else {
                        this.f16775f.getSegment(f16, f17, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f16771b.addPath(path, this.f16772c);
                if (cVar.f16743h.willDraw()) {
                    ComplexColorCompat complexColorCompat = cVar.f16743h;
                    if (this.f16774e == null) {
                        Paint paint = new Paint(1);
                        this.f16774e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f16774e;
                    if (complexColorCompat.isGradient()) {
                        Shader shader = complexColorCompat.getShader();
                        shader.setLocalMatrix(this.f16772c);
                        paint2.setShader(shader);
                        paint2.setAlpha(Math.round(cVar.f16745j * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(VectorDrawableCompat.applyAlpha(complexColorCompat.getColor(), cVar.f16745j));
                    }
                    paint2.setColorFilter(colorFilter);
                    Path path3 = this.f16771b;
                    if (cVar.f16767c == 0) {
                        fillType = Path.FillType.WINDING;
                    } else {
                        fillType = Path.FillType.EVEN_ODD;
                    }
                    path3.setFillType(fillType);
                    canvas.drawPath(this.f16771b, paint2);
                }
                if (cVar.f16741f.willDraw()) {
                    ComplexColorCompat complexColorCompat2 = cVar.f16741f;
                    if (this.f16773d == null) {
                        Paint paint3 = new Paint(1);
                        this.f16773d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f16773d;
                    Paint.Join join = cVar.f16750o;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = cVar.f16749n;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(cVar.f16751p);
                    if (complexColorCompat2.isGradient()) {
                        Shader shader2 = complexColorCompat2.getShader();
                        shader2.setLocalMatrix(this.f16772c);
                        paint4.setShader(shader2);
                        paint4.setAlpha(Math.round(cVar.f16744i * 255.0f));
                    } else {
                        paint4.setShader((Shader) null);
                        paint4.setAlpha(255);
                        paint4.setColor(VectorDrawableCompat.applyAlpha(complexColorCompat2.getColor(), cVar.f16744i));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(cVar.f16742g * min * e10);
                    canvas.drawPath(this.f16771b, paint4);
                }
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a10 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a10) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            c(this.f16777h, f16769q, canvas, i10, i11, colorFilter);
        }

        public boolean f() {
            if (this.f16784o == null) {
                this.f16784o = Boolean.valueOf(this.f16777h.a());
            }
            return this.f16784o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f16777h.b(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f16782m;
        }

        public void setAlpha(float f10) {
            setRootAlpha((int) (f10 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f16782m = i10;
        }

        public g(g gVar) {
            this.f16772c = new Matrix();
            this.f16778i = 0.0f;
            this.f16779j = 0.0f;
            this.f16780k = 0.0f;
            this.f16781l = 0.0f;
            this.f16782m = 255;
            this.f16783n = null;
            this.f16784o = null;
            ArrayMap arrayMap = new ArrayMap();
            this.f16785p = arrayMap;
            this.f16777h = new d(gVar.f16777h, arrayMap);
            this.f16770a = new Path(gVar.f16770a);
            this.f16771b = new Path(gVar.f16771b);
            this.f16778i = gVar.f16778i;
            this.f16779j = gVar.f16779j;
            this.f16780k = gVar.f16780k;
            this.f16781l = gVar.f16781l;
            this.f16776g = gVar.f16776g;
            this.f16782m = gVar.f16782m;
            this.f16783n = gVar.f16783n;
            String str = gVar.f16783n;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.f16784o = gVar.f16784o;
        }
    }

    private static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f16752a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList f16753b;

        /* renamed from: c  reason: collision with root package name */
        float f16754c;

        /* renamed from: d  reason: collision with root package name */
        private float f16755d;

        /* renamed from: e  reason: collision with root package name */
        private float f16756e;

        /* renamed from: f  reason: collision with root package name */
        private float f16757f;

        /* renamed from: g  reason: collision with root package name */
        private float f16758g;

        /* renamed from: h  reason: collision with root package name */
        private float f16759h;

        /* renamed from: i  reason: collision with root package name */
        private float f16760i;

        /* renamed from: j  reason: collision with root package name */
        final Matrix f16761j;

        /* renamed from: k  reason: collision with root package name */
        int f16762k;

        /* renamed from: l  reason: collision with root package name */
        private int[] f16763l;

        /* renamed from: m  reason: collision with root package name */
        private String f16764m;

        public d(d dVar, ArrayMap arrayMap) {
            super();
            f fVar;
            this.f16752a = new Matrix();
            this.f16753b = new ArrayList();
            this.f16754c = 0.0f;
            this.f16755d = 0.0f;
            this.f16756e = 0.0f;
            this.f16757f = 1.0f;
            this.f16758g = 1.0f;
            this.f16759h = 0.0f;
            this.f16760i = 0.0f;
            Matrix matrix = new Matrix();
            this.f16761j = matrix;
            this.f16764m = null;
            this.f16754c = dVar.f16754c;
            this.f16755d = dVar.f16755d;
            this.f16756e = dVar.f16756e;
            this.f16757f = dVar.f16757f;
            this.f16758g = dVar.f16758g;
            this.f16759h = dVar.f16759h;
            this.f16760i = dVar.f16760i;
            this.f16763l = dVar.f16763l;
            String str = dVar.f16764m;
            this.f16764m = str;
            this.f16762k = dVar.f16762k;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(dVar.f16761j);
            ArrayList arrayList = dVar.f16753b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                Object obj = arrayList.get(i10);
                if (obj instanceof d) {
                    this.f16753b.add(new d((d) obj, arrayMap));
                } else {
                    if (obj instanceof c) {
                        fVar = new c((c) obj);
                    } else if (obj instanceof b) {
                        fVar = new b((b) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f16753b.add(fVar);
                    String str2 = fVar.f16766b;
                    if (str2 != null) {
                        arrayMap.put(str2, fVar);
                    }
                }
            }
        }

        private void d() {
            this.f16761j.reset();
            this.f16761j.postTranslate(-this.f16755d, -this.f16756e);
            this.f16761j.postScale(this.f16757f, this.f16758g);
            this.f16761j.postRotate(this.f16754c, 0.0f, 0.0f);
            this.f16761j.postTranslate(this.f16759h + this.f16755d, this.f16760i + this.f16756e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f16763l = null;
            this.f16754c = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, this.f16754c);
            this.f16755d = typedArray.getFloat(1, this.f16755d);
            this.f16756e = typedArray.getFloat(2, this.f16756e);
            this.f16757f = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.f16757f);
            this.f16758g = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.f16758g);
            this.f16759h = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.f16759h);
            this.f16760i = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.f16760i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f16764m = string;
            }
            d();
        }

        public boolean a() {
            for (int i10 = 0; i10 < this.f16753b.size(); i10++) {
                if (((e) this.f16753b.get(i10)).a()) {
                    return true;
                }
            }
            return false;
        }

        public boolean b(int[] iArr) {
            boolean z10 = false;
            for (int i10 = 0; i10 < this.f16753b.size(); i10++) {
                z10 |= ((e) this.f16753b.get(i10)).b(iArr);
            }
            return z10;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, a.f16800b);
            e(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        public String getGroupName() {
            return this.f16764m;
        }

        public Matrix getLocalMatrix() {
            return this.f16761j;
        }

        public float getPivotX() {
            return this.f16755d;
        }

        public float getPivotY() {
            return this.f16756e;
        }

        public float getRotation() {
            return this.f16754c;
        }

        public float getScaleX() {
            return this.f16757f;
        }

        public float getScaleY() {
            return this.f16758g;
        }

        public float getTranslateX() {
            return this.f16759h;
        }

        public float getTranslateY() {
            return this.f16760i;
        }

        public void setPivotX(float f10) {
            if (f10 != this.f16755d) {
                this.f16755d = f10;
                d();
            }
        }

        public void setPivotY(float f10) {
            if (f10 != this.f16756e) {
                this.f16756e = f10;
                d();
            }
        }

        public void setRotation(float f10) {
            if (f10 != this.f16754c) {
                this.f16754c = f10;
                d();
            }
        }

        public void setScaleX(float f10) {
            if (f10 != this.f16757f) {
                this.f16757f = f10;
                d();
            }
        }

        public void setScaleY(float f10) {
            if (f10 != this.f16758g) {
                this.f16758g = f10;
                d();
            }
        }

        public void setTranslateX(float f10) {
            if (f10 != this.f16759h) {
                this.f16759h = f10;
                d();
            }
        }

        public void setTranslateY(float f10) {
            if (f10 != this.f16760i) {
                this.f16760i = f10;
                d();
            }
        }

        public d() {
            super();
            this.f16752a = new Matrix();
            this.f16753b = new ArrayList();
            this.f16754c = 0.0f;
            this.f16755d = 0.0f;
            this.f16756e = 0.0f;
            this.f16757f = 1.0f;
            this.f16758g = 1.0f;
            this.f16759h = 0.0f;
            this.f16760i = 0.0f;
            this.f16761j = new Matrix();
            this.f16764m = null;
        }
    }
}
