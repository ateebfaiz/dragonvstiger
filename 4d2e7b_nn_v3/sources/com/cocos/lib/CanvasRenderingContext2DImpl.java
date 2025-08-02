package com.cocos.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class CanvasRenderingContext2DImpl {
    private static final String TAG = "CanvasContext2D";
    private static final int TEXT_ALIGN_CENTER = 1;
    private static final int TEXT_ALIGN_LEFT = 0;
    private static final int TEXT_ALIGN_RIGHT = 2;
    private static final int TEXT_BASELINE_ALPHABETIC = 3;
    private static final int TEXT_BASELINE_BOTTOM = 2;
    private static final int TEXT_BASELINE_MIDDLE = 1;
    private static final int TEXT_BASELINE_TOP = 0;
    private static float _sApproximatingOblique = -0.25f;
    private static WeakReference<Context> sContext;
    private static HashMap<String, Typeface> sTypefaceCache = new HashMap<>();
    private Bitmap mBitmap;
    private Canvas mCanvas = new Canvas();
    private int mFillStyleA = 255;
    private int mFillStyleB = 0;
    private int mFillStyleG = 0;
    private int mFillStyleR = 0;
    private String mFontName = "Arial";
    private float mFontSize = 40.0f;
    private boolean mIsBoldFont = false;
    private boolean mIsItalicFont = false;
    private boolean mIsObliqueFont = false;
    private boolean mIsSmallCapsFontVariant = false;
    private String mLineCap = "butt";
    private String mLineJoin = "miter";
    private Paint mLinePaint;
    private Path mLinePath;
    private float mLineWidth = 0.0f;
    private float mShadowBlur = 0.0f;
    private int mShadowColorA = 0;
    private int mShadowColorB = 0;
    private int mShadowColorG = 0;
    private int mShadowColorR = 0;
    private float mShadowOffsetX = 0.0f;
    private float mShadowOffsetY = 0.0f;
    private int mStrokeStyleA = 255;
    private int mStrokeStyleB = 0;
    private int mStrokeStyleG = 0;
    private int mStrokeStyleR = 0;
    private int mTextAlign = 0;
    private int mTextBaseline = 2;
    private TextPaint mTextPaint;

    private CanvasRenderingContext2DImpl() {
    }

    private void _fillImageData(int[] iArr, float f10, float f11, float f12, float f13) {
        Log.d(TAG, "_fillImageData: ");
        int i10 = (int) (f10 * f11);
        int[] iArr2 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr2[i11] = Integer.rotateRight(iArr[i11], 8);
        }
        int i12 = (int) f10;
        this.mBitmap.setPixels(iArr2, 0, i12, (int) f12, (int) f13, i12, (int) f11);
    }

    private void beginPath() {
        if (this.mLinePath == null) {
            this.mLinePath = new Path();
        }
        this.mLinePath.reset();
    }

    private void clearRect(float f10, float f11, float f12, float f13) {
        int i10 = (int) (f12 * f13);
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i11] = 0;
        }
        int i12 = (int) f12;
        this.mBitmap.setPixels(iArr, 0, i12, (int) f10, (int) f11, i12, (int) f13);
    }

    private static void clearTypefaceCache() {
        sTypefaceCache.clear();
    }

    private void closePath() {
        this.mLinePath.close();
    }

    private void configShadow(Paint paint) {
        if (Math.abs(this.mShadowOffsetX) > Float.MIN_VALUE || Math.abs(this.mShadowOffsetY) > Float.MIN_VALUE) {
            float f10 = this.mShadowBlur;
            if (f10 >= 0.0f) {
                if (f10 < Float.MIN_VALUE) {
                    this.mShadowBlur = 0.001f;
                }
                paint.setShadowLayer(this.mShadowBlur, this.mShadowOffsetX, this.mShadowOffsetY, Color.argb(this.mShadowColorA, this.mShadowColorR, this.mShadowColorG, this.mShadowColorB));
            }
        }
    }

    private a convertDrawPoint(a aVar, String str) {
        a aVar2 = new a(aVar);
        createTextPaintIfNeeded();
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        float measureText = measureText(str);
        int i10 = this.mTextAlign;
        if (i10 == 1) {
            aVar2.f19210a -= measureText / 2.0f;
        } else if (i10 == 2) {
            aVar2.f19210a -= measureText;
        }
        int i11 = this.mTextBaseline;
        if (i11 == 0) {
            aVar2.f19211b += -fontMetrics.ascent;
        } else if (i11 == 1) {
            float f10 = aVar2.f19211b;
            float f11 = fontMetrics.descent;
            aVar2.f19211b = f10 + (((f11 - fontMetrics.ascent) / 2.0f) - f11);
        } else if (i11 == 2) {
            aVar2.f19211b += -fontMetrics.descent;
        }
        return aVar2;
    }

    private void createTextPaintIfNeeded() {
        if (this.mTextPaint == null) {
            this.mTextPaint = newPaint(this.mFontName, (int) this.mFontSize, this.mIsBoldFont, this.mIsItalicFont, this.mIsObliqueFont, this.mIsSmallCapsFontVariant);
        }
    }

    static void destroy() {
        sContext = null;
    }

    private void fill() {
        if (this.mLinePaint == null) {
            this.mLinePaint = new Paint();
        }
        if (this.mLinePath == null) {
            this.mLinePath = new Path();
        }
        this.mLinePaint.setARGB(this.mFillStyleA, this.mFillStyleR, this.mFillStyleG, this.mFillStyleB);
        this.mLinePaint.setStyle(Paint.Style.FILL);
        this.mCanvas.drawPath(this.mLinePath, this.mLinePaint);
        this.mLinePaint.setStrokeWidth(0.0f);
        setStrokeCap(this.mLinePaint);
        setStrokeJoin(this.mLinePaint);
        this.mLinePaint.setStyle(Paint.Style.STROKE);
        this.mCanvas.drawPath(this.mLinePath, this.mLinePaint);
        this.mLinePaint.setStrokeWidth(this.mLineWidth);
    }

    private void fillRect(float f10, float f11, float f12, float f13) {
        int i10 = ((this.mFillStyleA & 255) << 24) | ((this.mFillStyleR & 255) << 16) | ((this.mFillStyleG & 255) << 8) | (this.mFillStyleB & 255);
        int i11 = (int) (f12 * f13);
        int[] iArr = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr[i12] = i10;
        }
        int i13 = (int) f12;
        this.mBitmap.setPixels(iArr, 0, i13, (int) f10, (int) f11, i13, (int) f13);
    }

    private void fillText(String str, float f10, float f11, float f12) {
        createTextPaintIfNeeded();
        configShadow(this.mTextPaint);
        this.mTextPaint.setARGB(this.mFillStyleA, this.mFillStyleR, this.mFillStyleG, this.mFillStyleB);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        scaleX(this.mTextPaint, str, f12);
        a convertDrawPoint = convertDrawPoint(new a(f10, f11), str);
        this.mCanvas.drawText(str, convertDrawPoint.f19210a, convertDrawPoint.f19211b, this.mTextPaint);
    }

    private Bitmap getBitmap() {
        return this.mBitmap;
    }

    static void init(Context context) {
        sContext = new WeakReference<>(context);
    }

    private void lineTo(float f10, float f11) {
        this.mLinePath.lineTo(f10, f11);
    }

    private static void loadTypeface(String str, String str2) {
        Typeface typeface;
        if (!sTypefaceCache.containsKey(str)) {
            try {
                if (str2.startsWith(DomExceptionUtils.SEPARATOR)) {
                    typeface = Typeface.createFromFile(str2);
                } else if (sContext.get() != null) {
                    if (str2.startsWith("@assets/")) {
                        str2 = str2.substring(8);
                    }
                    typeface = Typeface.createFromAsset(sContext.get().getAssets(), str2);
                } else {
                    typeface = null;
                }
                if (typeface != null) {
                    sTypefaceCache.put(str, typeface);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    private float measureText(String str) {
        createTextPaintIfNeeded();
        return this.mTextPaint.measureText(str);
    }

    private void moveTo(float f10, float f11) {
        this.mLinePath.moveTo(f10, f11);
    }

    private static TextPaint newPaint(String str, int i10, boolean z10, boolean z11, boolean z12, boolean z13) {
        int i11;
        Typeface typeface;
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize((float) i10);
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        if (z10 && z11) {
            textPaint.setFakeBoldText(true);
            i11 = 3;
        } else if (z10) {
            textPaint.setFakeBoldText(true);
            i11 = 1;
        } else if (z11) {
            i11 = 2;
        } else {
            i11 = 0;
        }
        if (sTypefaceCache.containsKey(str)) {
            typeface = Typeface.create(sTypefaceCache.get(str), i11);
        } else {
            typeface = Typeface.create(str, i11);
        }
        textPaint.setTypeface(typeface);
        if (z12) {
            textPaint.setTextSkewX(_sApproximatingOblique);
        }
        if (z13) {
            CocosReflectionHelper.invokeInstanceMethod(textPaint, "setFontFeatureSettings", new Class[]{String.class}, new Object[]{"smcp"});
        }
        return textPaint;
    }

    private void recreateBuffer(float f10, float f11) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) Math.ceil((double) f10), (int) Math.ceil((double) f11), Bitmap.Config.ARGB_8888);
        this.mBitmap = createBitmap;
        this.mCanvas.setBitmap(createBitmap);
    }

    private void rect(float f10, float f11, float f12, float f13) {
        beginPath();
        moveTo(f10, f11);
        float f14 = f13 + f11;
        lineTo(f10, f14);
        float f15 = f10 + f12;
        lineTo(f15, f14);
        lineTo(f15, f11);
        closePath();
    }

    private void restoreContext() {
        if (this.mCanvas.getSaveCount() > 1) {
            this.mCanvas.restore();
        }
    }

    private void saveContext() {
        this.mCanvas.save();
    }

    private void scaleX(TextPaint textPaint, String str, float f10) {
        if (f10 >= Float.MIN_VALUE) {
            float measureText = measureText(str);
            if (measureText - f10 >= Float.MIN_VALUE) {
                textPaint.setTextScaleX(f10 / measureText);
            }
        }
    }

    private void setFillStyle(int i10, int i11, int i12, int i13) {
        this.mFillStyleR = i10;
        this.mFillStyleG = i11;
        this.mFillStyleB = i12;
        this.mFillStyleA = i13;
    }

    private void setLineCap(String str) {
        this.mLineCap = str;
    }

    private void setLineJoin(String str) {
        this.mLineJoin = str;
    }

    private void setLineWidth(float f10) {
        this.mLineWidth = f10;
    }

    private void setShadowBlur(float f10) {
        this.mShadowBlur = f10 * 0.5f;
    }

    private void setShadowColor(int i10, int i11, int i12, int i13) {
        this.mShadowColorR = i10;
        this.mShadowColorG = i11;
        this.mShadowColorB = i12;
        this.mShadowColorA = i13;
    }

    private void setShadowOffsetX(float f10) {
        this.mShadowOffsetX = f10;
    }

    private void setShadowOffsetY(float f10) {
        this.mShadowOffsetY = f10;
    }

    private void setStrokeCap(Paint paint) {
        String str = this.mLineCap;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -894674659:
                if (str.equals("square")) {
                    c10 = 0;
                    break;
                }
                break;
            case 3035667:
                if (str.equals("butt")) {
                    c10 = 1;
                    break;
                }
                break;
            case 108704142:
                if (str.equals("round")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                paint.setStrokeCap(Paint.Cap.SQUARE);
                return;
            case 1:
                paint.setStrokeCap(Paint.Cap.BUTT);
                return;
            case 2:
                paint.setStrokeCap(Paint.Cap.ROUND);
                return;
            default:
                return;
        }
    }

    private void setStrokeJoin(Paint paint) {
        String str = this.mLineJoin;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case 93630586:
                if (str.equals("bevel")) {
                    c10 = 0;
                    break;
                }
                break;
            case 103906565:
                if (str.equals("miter")) {
                    c10 = 1;
                    break;
                }
                break;
            case 108704142:
                if (str.equals("round")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                paint.setStrokeJoin(Paint.Join.BEVEL);
                return;
            case 1:
                paint.setStrokeJoin(Paint.Join.MITER);
                return;
            case 2:
                paint.setStrokeJoin(Paint.Join.ROUND);
                return;
            default:
                return;
        }
    }

    private void setStrokeStyle(int i10, int i11, int i12, int i13) {
        this.mStrokeStyleR = i10;
        this.mStrokeStyleG = i11;
        this.mStrokeStyleB = i12;
        this.mStrokeStyleA = i13;
    }

    private void setTextAlign(int i10) {
        this.mTextAlign = i10;
    }

    private void setTextBaseline(int i10) {
        this.mTextBaseline = i10;
    }

    private void stroke() {
        if (this.mLinePaint == null) {
            Paint paint = new Paint();
            this.mLinePaint = paint;
            paint.setAntiAlias(true);
        }
        if (this.mLinePath == null) {
            this.mLinePath = new Path();
        }
        this.mLinePaint.setARGB(this.mStrokeStyleA, this.mStrokeStyleR, this.mStrokeStyleG, this.mStrokeStyleB);
        this.mLinePaint.setStyle(Paint.Style.STROKE);
        this.mLinePaint.setStrokeWidth(this.mLineWidth);
        setStrokeCap(this.mLinePaint);
        setStrokeJoin(this.mLinePaint);
        this.mCanvas.drawPath(this.mLinePath, this.mLinePaint);
    }

    private void strokeText(String str, float f10, float f11, float f12) {
        createTextPaintIfNeeded();
        configShadow(this.mTextPaint);
        this.mTextPaint.setARGB(this.mStrokeStyleA, this.mStrokeStyleR, this.mStrokeStyleG, this.mStrokeStyleB);
        this.mTextPaint.setStyle(Paint.Style.STROKE);
        this.mTextPaint.setStrokeWidth(this.mLineWidth);
        scaleX(this.mTextPaint, str, f12);
        a convertDrawPoint = convertDrawPoint(new a(f10, f11), str);
        this.mCanvas.drawText(str, convertDrawPoint.f19210a, convertDrawPoint.f19211b, this.mTextPaint);
    }

    private void updateFont(String str, float f10, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.mFontName = str;
        this.mFontSize = f10;
        this.mIsBoldFont = z10;
        this.mIsItalicFont = z11;
        this.mIsObliqueFont = z12;
        this.mIsSmallCapsFontVariant = z13;
        this.mTextPaint = null;
    }

    private class a {

        /* renamed from: a  reason: collision with root package name */
        public float f19210a;

        /* renamed from: b  reason: collision with root package name */
        public float f19211b;

        a(float f10, float f11) {
            this.f19210a = f10;
            this.f19211b = f11;
        }

        a(a aVar) {
            this.f19210a = aVar.f19210a;
            this.f19211b = aVar.f19211b;
        }
    }
}
