package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;

public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;
    @Deprecated
    public float currentShadowAngle;
    @Deprecated
    public float endShadowAngle;
    @Deprecated
    public float endX;
    @Deprecated
    public float endY;
    private final List<PathOperation> operations = new ArrayList();
    private final List<d> shadowCompatOperations = new ArrayList();
    @Deprecated
    public float startX;
    @Deprecated
    public float startY;

    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = new RectF();
        @Deprecated
        public float bottom;
        @Deprecated
        public float left;
        @Deprecated
        public float right;
        @Deprecated
        public float startAngle;
        @Deprecated
        public float sweepAngle;
        @Deprecated
        public float top;

        public PathArcOperation(float f10, float f11, float f12, float f13) {
            setLeft(f10);
            setTop(f11);
            setRight(f12);
            setBottom(f13);
        }

        /* access modifiers changed from: private */
        public float getBottom() {
            return this.bottom;
        }

        /* access modifiers changed from: private */
        public float getLeft() {
            return this.left;
        }

        /* access modifiers changed from: private */
        public float getRight() {
            return this.right;
        }

        /* access modifiers changed from: private */
        public float getStartAngle() {
            return this.startAngle;
        }

        /* access modifiers changed from: private */
        public float getSweepAngle() {
            return this.sweepAngle;
        }

        /* access modifiers changed from: private */
        public float getTop() {
            return this.top;
        }

        private void setBottom(float f10) {
            this.bottom = f10;
        }

        private void setLeft(float f10) {
            this.left = f10;
        }

        private void setRight(float f10) {
            this.right = f10;
        }

        /* access modifiers changed from: private */
        public void setStartAngle(float f10) {
            this.startAngle = f10;
        }

        /* access modifiers changed from: private */
        public void setSweepAngle(float f10) {
            this.sweepAngle = f10;
        }

        private void setTop(float f10) {
            this.top = f10;
        }

        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF2 = rectF;
            rectF2.set(getLeft(), getTop(), getRight(), getBottom());
            path.arcTo(rectF2, getStartAngle(), getSweepAngle(), false);
            path.transform(matrix);
        }
    }

    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float f10, float f11, float f12, float f13, float f14, float f15) {
            setControlX1(f10);
            setControlY1(f11);
            setControlX2(f12);
            setControlY2(f13);
            setEndX(f14);
            setEndY(f15);
        }

        private float getControlX1() {
            return this.controlX1;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX1(float f10) {
            this.controlX1 = f10;
        }

        private void setControlX2(float f10) {
            this.controlX2 = f10;
        }

        private void setControlY1(float f10) {
            this.controlY1 = f10;
        }

        private void setControlY2(float f10) {
            this.controlY2 = f10;
        }

        private void setEndX(float f10) {
            this.endX = f10;
        }

        private void setEndY(float f10) {
            this.endY = f10;
        }

        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            path.transform(matrix);
        }
    }

    public static class PathLineOperation extends PathOperation {
        /* access modifiers changed from: private */

        /* renamed from: x  reason: collision with root package name */
        public float f8466x;
        /* access modifiers changed from: private */

        /* renamed from: y  reason: collision with root package name */
        public float f8467y;

        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f8466x, this.f8467y);
            path.transform(matrix);
        }
    }

    public static abstract class PathOperation {
        protected final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix2, Path path);
    }

    public static class PathQuadOperation extends PathOperation {
        @Deprecated
        public float controlX;
        @Deprecated
        public float controlY;
        @Deprecated
        public float endX;
        @Deprecated
        public float endY;

        private float getControlX() {
            return this.controlX;
        }

        private float getControlY() {
            return this.controlY;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        /* access modifiers changed from: private */
        public void setControlX(float f10) {
            this.controlX = f10;
        }

        /* access modifiers changed from: private */
        public void setControlY(float f10) {
            this.controlY = f10;
        }

        /* access modifiers changed from: private */
        public void setEndX(float f10) {
            this.endX = f10;
        }

        /* access modifiers changed from: private */
        public void setEndY(float f10) {
            this.endY = f10;
        }

        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            path.transform(matrix);
        }
    }

    class a extends d {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f8468b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Matrix f8469c;

        a(List list, Matrix matrix) {
            this.f8468b = list;
            this.f8469c = matrix;
        }

        public void a(Matrix matrix, ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
            for (d a10 : this.f8468b) {
                a10.a(this.f8469c, shadowRenderer, i10, canvas);
            }
        }
    }

    static class b extends d {

        /* renamed from: b  reason: collision with root package name */
        private final PathArcOperation f8471b;

        public b(PathArcOperation pathArcOperation) {
            this.f8471b = pathArcOperation;
        }

        public void a(Matrix matrix, ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
            float access$800 = this.f8471b.getStartAngle();
            float access$900 = this.f8471b.getSweepAngle();
            shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(this.f8471b.getLeft(), this.f8471b.getTop(), this.f8471b.getRight(), this.f8471b.getBottom()), i10, access$800, access$900);
        }
    }

    static class c extends d {

        /* renamed from: b  reason: collision with root package name */
        private final PathLineOperation f8472b;

        /* renamed from: c  reason: collision with root package name */
        private final float f8473c;

        /* renamed from: d  reason: collision with root package name */
        private final float f8474d;

        public c(PathLineOperation pathLineOperation, float f10, float f11) {
            this.f8472b = pathLineOperation;
            this.f8473c = f10;
            this.f8474d = f11;
        }

        public void a(Matrix matrix, ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (this.f8472b.f8467y - this.f8474d), (double) (this.f8472b.f8466x - this.f8473c)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f8473c, this.f8474d);
            matrix2.preRotate(c());
            shadowRenderer.drawEdgeShadow(canvas, matrix2, rectF, i10);
        }

        /* access modifiers changed from: package-private */
        public float c() {
            return (float) Math.toDegrees(Math.atan((double) ((this.f8472b.f8467y - this.f8474d) / (this.f8472b.f8466x - this.f8473c))));
        }
    }

    static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        static final Matrix f8475a = new Matrix();

        d() {
        }

        public abstract void a(Matrix matrix, ShadowRenderer shadowRenderer, int i10, Canvas canvas);

        public final void b(ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
            a(f8475a, shadowRenderer, i10, canvas);
        }
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    private void addConnectingShadowIfNecessary(float f10) {
        if (getCurrentShadowAngle() != f10) {
            float currentShadowAngle2 = ((f10 - getCurrentShadowAngle()) + 360.0f) % 360.0f;
            if (currentShadowAngle2 <= ANGLE_LEFT) {
                PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
                pathArcOperation.setStartAngle(getCurrentShadowAngle());
                pathArcOperation.setSweepAngle(currentShadowAngle2);
                this.shadowCompatOperations.add(new b(pathArcOperation));
                setCurrentShadowAngle(f10);
            }
        }
    }

    private void addShadowCompatOperation(d dVar, float f10, float f11) {
        addConnectingShadowIfNecessary(f10);
        this.shadowCompatOperations.add(dVar);
        setCurrentShadowAngle(f11);
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setCurrentShadowAngle(float f10) {
        this.currentShadowAngle = f10;
    }

    private void setEndShadowAngle(float f10) {
        this.endShadowAngle = f10;
    }

    private void setEndX(float f10) {
        this.endX = f10;
    }

    private void setEndY(float f10) {
        this.endY = f10;
    }

    private void setStartX(float f10) {
        this.startX = f10;
    }

    private void setStartY(float f10) {
        this.startY = f10;
    }

    public void addArc(float f10, float f11, float f12, float f13, float f14, float f15) {
        boolean z10;
        float f16;
        PathArcOperation pathArcOperation = new PathArcOperation(f10, f11, f12, f13);
        pathArcOperation.setStartAngle(f14);
        pathArcOperation.setSweepAngle(f15);
        this.operations.add(pathArcOperation);
        b bVar = new b(pathArcOperation);
        float f17 = f14 + f15;
        if (f15 < 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            f14 = (f14 + ANGLE_LEFT) % 360.0f;
        }
        if (z10) {
            f16 = (ANGLE_LEFT + f17) % 360.0f;
        } else {
            f16 = f17;
        }
        addShadowCompatOperation(bVar, f14, f16);
        double d10 = (double) f17;
        setEndX(((f10 + f12) * 0.5f) + (((f12 - f10) / 2.0f) * ((float) Math.cos(Math.toRadians(d10)))));
        setEndY(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.sin(Math.toRadians(d10)))));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.operations.get(i10).applyToPath(matrix, path);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public d createShadowCompatOperation(Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        return new a(new ArrayList(this.shadowCompatOperations), new Matrix(matrix));
    }

    @RequiresApi(21)
    public void cubicToPoint(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.operations.add(new PathCubicOperation(f10, f11, f12, f13, f14, f15));
        this.containsIncompatibleShadowOp = true;
        setEndX(f14);
        setEndY(f15);
    }

    /* access modifiers changed from: package-private */
    public float getEndX() {
        return this.endX;
    }

    /* access modifiers changed from: package-private */
    public float getEndY() {
        return this.endY;
    }

    /* access modifiers changed from: package-private */
    public float getStartX() {
        return this.startX;
    }

    /* access modifiers changed from: package-private */
    public float getStartY() {
        return this.startY;
    }

    public void lineTo(float f10, float f11) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        float unused = pathLineOperation.f8466x = f10;
        float unused2 = pathLineOperation.f8467y = f11;
        this.operations.add(pathLineOperation);
        c cVar = new c(pathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(cVar, cVar.c() + ANGLE_UP, cVar.c() + ANGLE_UP);
        setEndX(f10);
        setEndY(f11);
    }

    @RequiresApi(21)
    public void quadToPoint(float f10, float f11, float f12, float f13) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.setControlX(f10);
        pathQuadOperation.setControlY(f11);
        pathQuadOperation.setEndX(f12);
        pathQuadOperation.setEndY(f13);
        this.operations.add(pathQuadOperation);
        this.containsIncompatibleShadowOp = true;
        setEndX(f12);
        setEndY(f13);
    }

    public void reset(float f10, float f11) {
        reset(f10, f11, ANGLE_UP, 0.0f);
    }

    public void reset(float f10, float f11, float f12, float f13) {
        setStartX(f10);
        setStartY(f11);
        setEndX(f10);
        setEndY(f11);
        setCurrentShadowAngle(f12);
        setEndShadowAngle((f12 + f13) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    public ShapePath(float f10, float f11) {
        reset(f10, f11);
    }
}
