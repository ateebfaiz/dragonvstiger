package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Base64;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.g;
import com.facebook.react.uimanager.m0;
import com.facebook.react.uimanager.n0;
import com.facebook.react.views.view.ReactViewGroup;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public class SvgView extends ReactViewGroup implements m0, n0 {
    private String mAlign;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Bitmap mCurrentBitmap;
    int mCurrentColor;
    private final Map<String, a> mDefinedBrushes = new HashMap();
    private final Map<String, VirtualView> mDefinedClipPaths = new HashMap();
    private final Map<String, VirtualView> mDefinedFilters = new HashMap();
    private final Map<String, VirtualView> mDefinedMarkers = new HashMap();
    private final Map<String, VirtualView> mDefinedMasks = new HashMap();
    private final Map<String, VirtualView> mDefinedTemplates = new HashMap();
    final Matrix mInvViewBoxMatrix;
    private boolean mInvertible;
    private int mMeetOrSlice;
    private float mMinX;
    private float mMinY;
    private final Paint mPaint;
    private boolean mRemovalTransitionStarted;
    private boolean mRendered;
    private boolean mResponsible = false;
    private final float mScale;
    private float mVbHeight;
    private float mVbWidth;
    private SVGLength mbbHeight;
    private SVGLength mbbWidth;
    private Runnable toDataUrlTask = null;

    public enum Events {
        EVENT_DATA_URL("onDataURL");
        
        private final String mName;

        private Events(String str) {
            this.mName = str;
        }

        public String toString() {
            return this.mName;
        }
    }

    public SvgView(ReactContext reactContext) {
        super(reactContext);
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mInvViewBoxMatrix = new Matrix();
        this.mInvertible = true;
        this.mRendered = false;
        this.mCurrentColor = ViewCompat.MEASURED_STATE_MASK;
        this.mScale = g.c().density;
        paint.setFlags(385);
        paint.setTypeface(Typeface.DEFAULT);
        setWillNotDraw(false);
    }

    private void clearChildCache() {
        if (this.mRendered) {
            this.mRendered = false;
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (childAt instanceof VirtualView) {
                    ((VirtualView) childAt).clearChildCache();
                }
            }
        }
    }

    private Bitmap drawOutput() {
        this.mRendered = true;
        float width = (float) getWidth();
        float height = (float) getHeight();
        if (Float.isNaN(width) || Float.isNaN(height) || width < 1.0f || height < 1.0f || Math.log10((double) width) + Math.log10((double) height) > 42.0d) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) width, (int) height, Bitmap.Config.ARGB_8888);
        this.mCurrentBitmap = createBitmap;
        drawChildren(new Canvas(createBitmap));
        return createBitmap;
    }

    private RectF getViewBox() {
        float f10 = this.mMinX;
        float f11 = this.mScale;
        float f12 = this.mMinY;
        return new RectF(f10 * f11, f12 * f11, (f10 + this.mVbWidth) * f11, (f12 + this.mVbHeight) * f11);
    }

    private int hitTest(float f10, float f11) {
        if (!this.mResponsible || !this.mInvertible) {
            return getId();
        }
        float[] fArr = {f10, f11};
        this.mInvViewBoxMatrix.mapPoints(fArr);
        int i10 = -1;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt instanceof VirtualView) {
                i10 = ((VirtualView) childAt).hitTest(fArr);
            } else if (childAt instanceof SvgView) {
                i10 = ((SvgView) childAt).hitTest(f10, f11);
            }
            if (i10 != -1) {
                break;
            }
        }
        if (i10 == -1) {
            return getId();
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public void defineBrush(a aVar, String str) {
        this.mDefinedBrushes.put(str, aVar);
    }

    /* access modifiers changed from: package-private */
    public void defineClipPath(VirtualView virtualView, String str) {
        this.mDefinedClipPaths.put(str, virtualView);
    }

    /* access modifiers changed from: package-private */
    public void defineFilter(VirtualView virtualView, String str) {
        this.mDefinedFilters.put(str, virtualView);
    }

    /* access modifiers changed from: package-private */
    public void defineMarker(VirtualView virtualView, String str) {
        this.mDefinedMarkers.put(str, virtualView);
    }

    /* access modifiers changed from: package-private */
    public void defineMask(VirtualView virtualView, String str) {
        this.mDefinedMasks.put(str, virtualView);
    }

    /* access modifiers changed from: package-private */
    public void defineTemplate(VirtualView virtualView, String str) {
        this.mDefinedTemplates.put(str, virtualView);
    }

    /* access modifiers changed from: package-private */
    public synchronized void drawChildren(Canvas canvas) {
        try {
            this.mRendered = true;
            this.mCanvas = canvas;
            Matrix matrix = new Matrix();
            if (this.mAlign != null) {
                RectF viewBox = getViewBox();
                float width = (float) canvas.getWidth();
                float height = (float) canvas.getHeight();
                boolean z10 = getParent() instanceof VirtualView;
                if (z10) {
                    width = (float) p.a(this.mbbWidth, (double) width, 0.0d, (double) this.mScale, 12.0d);
                    height = (float) p.a(this.mbbHeight, (double) height, 0.0d, (double) this.mScale, 12.0d);
                }
                RectF rectF = new RectF(0.0f, 0.0f, width, height);
                if (z10) {
                    canvas.clipRect(rectF);
                }
                matrix = m0.a(viewBox, rectF, this.mAlign, this.mMeetOrSlice);
                this.mInvertible = matrix.invert(this.mInvViewBoxMatrix);
                canvas.concat(matrix);
            }
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (childAt instanceof VirtualView) {
                    ((VirtualView) childAt).saveDefinition();
                }
            }
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt2 = getChildAt(i11);
                if (childAt2 instanceof VirtualView) {
                    VirtualView virtualView = (VirtualView) childAt2;
                    int saveAndSetupCanvas = virtualView.saveAndSetupCanvas(canvas, matrix);
                    virtualView.render(canvas, this.mPaint, 1.0f);
                    virtualView.restoreCanvas(canvas, saveAndSetupCanvas);
                    if (virtualView.isResponsible() && !this.mResponsible) {
                        this.mResponsible = true;
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void enableTouchEvents() {
        if (!this.mResponsible) {
            this.mResponsible = true;
        }
    }

    /* access modifiers changed from: package-private */
    public Rect getCanvasBounds() {
        return this.mCanvas.getClipBounds();
    }

    /* access modifiers changed from: package-private */
    public float getCanvasHeight() {
        return (float) this.mCanvas.getHeight();
    }

    /* access modifiers changed from: package-private */
    public float getCanvasWidth() {
        return (float) this.mCanvas.getWidth();
    }

    /* access modifiers changed from: package-private */
    public Matrix getCtm() {
        return this.mCanvas.getMatrix();
    }

    public Bitmap getCurrentBitmap() {
        return this.mCurrentBitmap;
    }

    /* access modifiers changed from: package-private */
    public a getDefinedBrush(String str) {
        return this.mDefinedBrushes.get(str);
    }

    /* access modifiers changed from: package-private */
    public VirtualView getDefinedClipPath(String str) {
        return this.mDefinedClipPaths.get(str);
    }

    /* access modifiers changed from: package-private */
    public VirtualView getDefinedFilter(String str) {
        return this.mDefinedFilters.get(str);
    }

    /* access modifiers changed from: package-private */
    public VirtualView getDefinedMarker(String str) {
        return this.mDefinedMarkers.get(str);
    }

    /* access modifiers changed from: package-private */
    public VirtualView getDefinedMask(String str) {
        return this.mDefinedMasks.get(str);
    }

    /* access modifiers changed from: package-private */
    public VirtualView getDefinedTemplate(String str) {
        return this.mDefinedTemplates.get(str);
    }

    public boolean interceptsTouchEvent(float f10, float f11) {
        return true;
    }

    public void invalidate() {
        super.invalidate();
        ViewParent parent = getParent();
        if (parent instanceof VirtualView) {
            if (this.mRendered) {
                this.mRendered = false;
                ((VirtualView) parent).getSvgView().invalidate();
            }
        } else if (!this.mRemovalTransitionStarted) {
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mBitmap = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isResponsible() {
        return this.mResponsible;
    }

    /* access modifiers changed from: package-private */
    public boolean notRendered() {
        return !this.mRendered;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mBitmap = null;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!(getParent() instanceof VirtualView)) {
            super.onDraw(canvas);
            if (this.mBitmap == null) {
                this.mBitmap = drawOutput();
            }
            if (this.mBitmap != null) {
                this.mPaint.reset();
                this.mPaint.setFlags(387);
                this.mPaint.setTypeface(Typeface.DEFAULT);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, this.mPaint);
                Runnable runnable = this.toDataUrlTask;
                if (runnable != null) {
                    runnable.run();
                    this.toDataUrlTask = null;
                }
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setVisibleToUser(getGlobalVisibleRect(new Rect()));
        accessibilityNodeInfo.setClassName(getClass().getCanonicalName());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        invalidate();
    }

    public int reactTagForTouch(float f10, float f11) {
        return hitTest(f10, f11);
    }

    public void setAlign(String str) {
        this.mAlign = str;
        invalidate();
        clearChildCache();
    }

    public void setBbHeight(Dynamic dynamic) {
        this.mbbHeight = SVGLength.b(dynamic);
        invalidate();
        clearChildCache();
    }

    public void setBbWidth(Dynamic dynamic) {
        this.mbbWidth = SVGLength.b(dynamic);
        invalidate();
        clearChildCache();
    }

    public void setCurrentColor(Integer num) {
        int i10;
        if (num != null) {
            i10 = num.intValue();
        } else {
            i10 = 0;
        }
        this.mCurrentColor = i10;
        invalidate();
        clearChildCache();
    }

    public void setId(int i10) {
        super.setId(i10);
        SvgViewManager.setSvgView(i10, this);
    }

    public void setMeetOrSlice(int i10) {
        this.mMeetOrSlice = i10;
        invalidate();
        clearChildCache();
    }

    public void setMinX(float f10) {
        this.mMinX = f10;
        invalidate();
        clearChildCache();
    }

    public void setMinY(float f10) {
        this.mMinY = f10;
        invalidate();
        clearChildCache();
    }

    /* access modifiers changed from: package-private */
    public void setToDataUrlTask(Runnable runnable) {
        this.toDataUrlTask = runnable;
    }

    public void setVbHeight(float f10) {
        this.mVbHeight = f10;
        invalidate();
        clearChildCache();
    }

    public void setVbWidth(float f10) {
        this.mVbWidth = f10;
        invalidate();
        clearChildCache();
    }

    public void startViewTransition(View view) {
        this.mRemovalTransitionStarted = true;
    }

    /* access modifiers changed from: package-private */
    public String toDataURL() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        clearChildCache();
        drawChildren(new Canvas(createBitmap));
        clearChildCache();
        invalidate();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        createBitmap.recycle();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    /* access modifiers changed from: package-private */
    public String toDataURL(int i10, int i11) {
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        clearChildCache();
        drawChildren(new Canvas(createBitmap));
        clearChildCache();
        invalidate();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        createBitmap.recycle();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }
}
