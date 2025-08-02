package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class GroupView extends RenderableView {

    /* renamed from: a  reason: collision with root package name */
    ReadableMap f9615a;

    /* renamed from: b  reason: collision with root package name */
    private k f9616b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f9617c;

    /* renamed from: d  reason: collision with root package name */
    private Canvas f9618d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f9619e = new Paint(1);

    public GroupView(ReactContext reactContext) {
        super(reactContext);
    }

    private static Object w(Object obj) {
        obj.getClass();
        return obj;
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f10) {
        z(canvas);
        clip(canvas, paint);
        p(canvas, paint, f10);
        renderMarkers(canvas, paint, f10);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = this.mPath;
        if (path != null) {
            return path;
        }
        this.mPath = new Path();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (!(childAt instanceof MaskView) && (childAt instanceof VirtualView)) {
                VirtualView virtualView = (VirtualView) childAt;
                this.mPath.addPath(virtualView.getPath(canvas, paint), virtualView.mMatrix);
            }
        }
        return this.mPath;
    }

    public int hitTest(float[] fArr) {
        int reactTagForTouch;
        VirtualView virtualView;
        int hitTest;
        if (!this.mInvertible) {
            return -1;
        }
        float[] fArr2 = new float[2];
        this.mInvMatrix.mapPoints(fArr2, fArr);
        this.mInvTransform.mapPoints(fArr2);
        int round = Math.round(fArr2[0]);
        int round2 = Math.round(fArr2[1]);
        Path clipPath = getClipPath();
        if (clipPath != null) {
            if (this.mClipRegionPath != clipPath) {
                this.mClipRegionPath = clipPath;
                RectF rectF = new RectF();
                this.mClipBounds = rectF;
                clipPath.computeBounds(rectF, true);
                this.mClipRegion = getRegion(clipPath, this.mClipBounds);
            }
            if (!this.mClipRegion.contains(round, round2)) {
                return -1;
            }
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt instanceof VirtualView) {
                if (!(childAt instanceof MaskView) && (hitTest = virtualView.hitTest(fArr2)) != -1) {
                    if ((virtualView = (VirtualView) childAt).isResponsible() || hitTest != childAt.getId()) {
                        return hitTest;
                    }
                    return getId();
                }
            } else if ((childAt instanceof SvgView) && (reactTagForTouch = ((SvgView) childAt).reactTagForTouch(fArr2[0], fArr2[1])) != childAt.getId()) {
                return reactTagForTouch;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void p(Canvas canvas, Paint paint, float f10) {
        v();
        SvgView svgView = getSvgView();
        RectF rectF = new RectF();
        if (this.mOpacity != 1.0f) {
            Bitmap bitmap = this.f9617c;
            if (bitmap == null) {
                this.f9617c = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
                this.f9618d = new Canvas(this.f9617c);
            } else {
                bitmap.recycle();
                Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
                this.f9617c = createBitmap;
                this.f9618d.setBitmap(createBitmap);
            }
            this.f9618d.save();
            this.f9618d.setMatrix(canvas.getMatrix());
        } else {
            this.f9618d = canvas;
        }
        this.elements = new ArrayList<>();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (!(childAt instanceof MaskView)) {
                if (childAt instanceof VirtualView) {
                    VirtualView virtualView = (VirtualView) childAt;
                    if (!DevicePublicKeyStringDef.NONE.equals(virtualView.mDisplay)) {
                        boolean z10 = virtualView instanceof RenderableView;
                        if (z10) {
                            ((RenderableView) virtualView).mergeProperties(this);
                        }
                        int saveAndSetupCanvas = virtualView.saveAndSetupCanvas(this.f9618d, this.mCTM);
                        virtualView.render(this.f9618d, paint, f10);
                        RectF clientRect = virtualView.getClientRect();
                        if (clientRect != null) {
                            rectF.union(clientRect);
                        }
                        virtualView.restoreCanvas(this.f9618d, saveAndSetupCanvas);
                        if (z10) {
                            ((RenderableView) virtualView).resetProperties();
                        }
                        if (virtualView.isResponsible()) {
                            svgView.enableTouchEvents();
                        }
                        ArrayList<m> arrayList = virtualView.elements;
                        if (arrayList != null) {
                            this.elements.addAll(arrayList);
                        }
                    }
                } else if (childAt instanceof SvgView) {
                    SvgView svgView2 = (SvgView) childAt;
                    svgView2.drawChildren(canvas);
                    if (svgView2.isResponsible()) {
                        svgView.enableTouchEvents();
                    }
                }
            }
        }
        if (this.mOpacity != 1.0f) {
            this.f9618d.restore();
            int save = canvas.save();
            canvas.setMatrix((Matrix) null);
            this.f9619e.setAlpha((int) (this.mOpacity * 255.0f));
            canvas.drawBitmap(this.f9617c, 0.0f, 0.0f, this.f9619e);
            canvas.restoreToCount(save);
        }
        setClientRect(rectF);
        u();
    }

    /* access modifiers changed from: package-private */
    public void q(Canvas canvas, Paint paint, float f10) {
        super.draw(canvas, paint, f10);
    }

    /* access modifiers changed from: package-private */
    public k r() {
        return this.f9616b;
    }

    /* access modifiers changed from: package-private */
    public void resetProperties() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof RenderableView) {
                ((RenderableView) childAt).resetProperties();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Path s(Canvas canvas, Paint paint, Region.Op op) {
        Path path;
        Path path2 = new Path();
        Path.Op valueOf = Path.Op.valueOf(op.name());
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (!(childAt instanceof MaskView) && (childAt instanceof VirtualView)) {
                VirtualView virtualView = (VirtualView) childAt;
                Matrix matrix = virtualView.mMatrix;
                if (virtualView instanceof GroupView) {
                    path = ((GroupView) virtualView).s(canvas, paint, op);
                } else {
                    path = virtualView.getPath(canvas, paint);
                }
                path.transform(matrix);
                path2.op(path, valueOf);
            }
        }
        return path2;
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineTemplate(this, this.mName);
        }
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof VirtualView) {
                ((VirtualView) childAt).saveDefinition();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public k t() {
        return ((GroupView) w(getTextRoot())).r();
    }

    /* access modifiers changed from: package-private */
    public void u() {
        t().n();
    }

    /* access modifiers changed from: package-private */
    public void v() {
        t().o(this, this.f9615a);
    }

    public void x(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Map) {
            this.f9615a = dynamic.asMap();
        } else {
            this.f9615a = null;
        }
        invalidate();
    }

    public void y(ReadableMap readableMap) {
        this.f9615a = readableMap;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void z(Canvas canvas) {
        RectF rectF = new RectF(canvas.getClipBounds());
        Matrix matrix = this.mMatrix;
        if (matrix != null) {
            matrix.mapRect(rectF);
        }
        this.f9616b = new k(this.mScale, rectF.width(), rectF.height());
    }
}
