package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

public class ShapeAppearancePathProvider {
    private final Path boundsPath = new Path();
    private final Path cornerPath = new Path();
    private final ShapePath[] cornerPaths = new ShapePath[4];
    private final Matrix[] cornerTransforms = new Matrix[4];
    private boolean edgeIntersectionCheckEnabled = true;
    private final Path edgePath = new Path();
    private final Matrix[] edgeTransforms = new Matrix[4];
    private final Path overlappedEdgePath = new Path();
    private final PointF pointF = new PointF();
    private final float[] scratch = new float[2];
    private final float[] scratch2 = new float[2];
    private final ShapePath shapePath = new ShapePath();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i10);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i10);
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final ShapeAppearancePathProvider f8460a = new ShapeAppearancePathProvider();
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final ShapeAppearanceModel f8461a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f8462b;

        /* renamed from: c  reason: collision with root package name */
        public final RectF f8463c;

        /* renamed from: d  reason: collision with root package name */
        public final PathListener f8464d;

        /* renamed from: e  reason: collision with root package name */
        public final float f8465e;

        b(ShapeAppearanceModel shapeAppearanceModel, float f10, RectF rectF, PathListener pathListener, Path path) {
            this.f8464d = pathListener;
            this.f8461a = shapeAppearanceModel;
            this.f8465e = f10;
            this.f8463c = rectF;
            this.f8462b = path;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.cornerPaths[i10] = new ShapePath();
            this.cornerTransforms[i10] = new Matrix();
            this.edgeTransforms[i10] = new Matrix();
        }
    }

    private float angleOfEdge(int i10) {
        return (float) ((i10 + 1) * 90);
    }

    private void appendCornerPath(@NonNull b bVar, int i10) {
        this.scratch[0] = this.cornerPaths[i10].getStartX();
        this.scratch[1] = this.cornerPaths[i10].getStartY();
        this.cornerTransforms[i10].mapPoints(this.scratch);
        if (i10 == 0) {
            Path path = bVar.f8462b;
            float[] fArr = this.scratch;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = bVar.f8462b;
            float[] fArr2 = this.scratch;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.cornerPaths[i10].applyToPath(this.cornerTransforms[i10], bVar.f8462b);
        PathListener pathListener = bVar.f8464d;
        if (pathListener != null) {
            pathListener.onCornerPathCreated(this.cornerPaths[i10], this.cornerTransforms[i10], i10);
        }
    }

    private void appendEdgePath(@NonNull b bVar, int i10) {
        int i11 = (i10 + 1) % 4;
        this.scratch[0] = this.cornerPaths[i10].getEndX();
        this.scratch[1] = this.cornerPaths[i10].getEndY();
        this.cornerTransforms[i10].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[i11].getStartX();
        this.scratch2[1] = this.cornerPaths[i11].getStartY();
        this.cornerTransforms[i11].mapPoints(this.scratch2);
        float[] fArr = this.scratch;
        float f10 = fArr[0];
        float[] fArr2 = this.scratch2;
        float max = Math.max(((float) Math.hypot((double) (f10 - fArr2[0]), (double) (fArr[1] - fArr2[1]))) - 0.001f, 0.0f);
        float edgeCenterForIndex = getEdgeCenterForIndex(bVar.f8463c, i10);
        this.shapePath.reset(0.0f, 0.0f);
        EdgeTreatment edgeTreatmentForIndex = getEdgeTreatmentForIndex(i10, bVar.f8461a);
        edgeTreatmentForIndex.getEdgePath(max, edgeCenterForIndex, bVar.f8465e, this.shapePath);
        this.edgePath.reset();
        this.shapePath.applyToPath(this.edgeTransforms[i10], this.edgePath);
        if (!this.edgeIntersectionCheckEnabled || (!edgeTreatmentForIndex.forceIntersection() && !pathOverlapsCorner(this.edgePath, i10) && !pathOverlapsCorner(this.edgePath, i11))) {
            this.shapePath.applyToPath(this.edgeTransforms[i10], bVar.f8462b);
        } else {
            Path path = this.edgePath;
            path.op(path, this.boundsPath, Path.Op.DIFFERENCE);
            this.scratch[0] = this.shapePath.getStartX();
            this.scratch[1] = this.shapePath.getStartY();
            this.edgeTransforms[i10].mapPoints(this.scratch);
            Path path2 = this.overlappedEdgePath;
            float[] fArr3 = this.scratch;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.shapePath.applyToPath(this.edgeTransforms[i10], this.overlappedEdgePath);
        }
        PathListener pathListener = bVar.f8464d;
        if (pathListener != null) {
            pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i10], i10);
        }
    }

    private void getCoordinatesOfCorner(int i10, @NonNull RectF rectF, @NonNull PointF pointF2) {
        if (i10 == 1) {
            pointF2.set(rectF.right, rectF.bottom);
        } else if (i10 == 2) {
            pointF2.set(rectF.left, rectF.bottom);
        } else if (i10 != 3) {
            pointF2.set(rectF.right, rectF.top);
        } else {
            pointF2.set(rectF.left, rectF.top);
        }
    }

    private CornerSize getCornerSizeForIndex(int i10, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i10 == 1) {
            return shapeAppearanceModel.getBottomRightCornerSize();
        }
        if (i10 == 2) {
            return shapeAppearanceModel.getBottomLeftCornerSize();
        }
        if (i10 != 3) {
            return shapeAppearanceModel.getTopRightCornerSize();
        }
        return shapeAppearanceModel.getTopLeftCornerSize();
    }

    private CornerTreatment getCornerTreatmentForIndex(int i10, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i10 == 1) {
            return shapeAppearanceModel.getBottomRightCorner();
        }
        if (i10 == 2) {
            return shapeAppearanceModel.getBottomLeftCorner();
        }
        if (i10 != 3) {
            return shapeAppearanceModel.getTopRightCorner();
        }
        return shapeAppearanceModel.getTopLeftCorner();
    }

    private float getEdgeCenterForIndex(@NonNull RectF rectF, int i10) {
        float[] fArr = this.scratch;
        ShapePath shapePath2 = this.cornerPaths[i10];
        fArr[0] = shapePath2.endX;
        fArr[1] = shapePath2.endY;
        this.cornerTransforms[i10].mapPoints(fArr);
        if (i10 == 1 || i10 == 3) {
            return Math.abs(rectF.centerX() - this.scratch[0]);
        }
        return Math.abs(rectF.centerY() - this.scratch[1]);
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int i10, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i10 == 1) {
            return shapeAppearanceModel.getBottomEdge();
        }
        if (i10 == 2) {
            return shapeAppearanceModel.getLeftEdge();
        }
        if (i10 != 3) {
            return shapeAppearanceModel.getRightEdge();
        }
        return shapeAppearanceModel.getTopEdge();
    }

    @UiThread
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static ShapeAppearancePathProvider getInstance() {
        return a.f8460a;
    }

    @RequiresApi(19)
    private boolean pathOverlapsCorner(Path path, int i10) {
        this.cornerPath.reset();
        this.cornerPaths[i10].applyToPath(this.cornerTransforms[i10], this.cornerPath);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.cornerPath.computeBounds(rectF, true);
        path.op(this.cornerPath, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() <= 1.0f || rectF.height() <= 1.0f) {
            return false;
        }
        return true;
    }

    private void setCornerPathAndTransform(@NonNull b bVar, int i10) {
        getCornerTreatmentForIndex(i10, bVar.f8461a).getCornerPath(this.cornerPaths[i10], 90.0f, bVar.f8465e, bVar.f8463c, getCornerSizeForIndex(i10, bVar.f8461a));
        float angleOfEdge = angleOfEdge(i10);
        this.cornerTransforms[i10].reset();
        getCoordinatesOfCorner(i10, bVar.f8463c, this.pointF);
        Matrix matrix = this.cornerTransforms[i10];
        PointF pointF2 = this.pointF;
        matrix.setTranslate(pointF2.x, pointF2.y);
        this.cornerTransforms[i10].preRotate(angleOfEdge);
    }

    private void setEdgePathAndTransform(int i10) {
        this.scratch[0] = this.cornerPaths[i10].getEndX();
        this.scratch[1] = this.cornerPaths[i10].getEndY();
        this.cornerTransforms[i10].mapPoints(this.scratch);
        float angleOfEdge = angleOfEdge(i10);
        this.edgeTransforms[i10].reset();
        Matrix matrix = this.edgeTransforms[i10];
        float[] fArr = this.scratch;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.edgeTransforms[i10].preRotate(angleOfEdge);
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f10, RectF rectF, @NonNull Path path) {
        calculatePath(shapeAppearanceModel, f10, rectF, (PathListener) null, path);
    }

    /* access modifiers changed from: package-private */
    public void setEdgeIntersectionCheckEnable(boolean z10) {
        this.edgeIntersectionCheckEnabled = z10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f10, RectF rectF, PathListener pathListener, @NonNull Path path) {
        path.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(rectF, Path.Direction.CW);
        b bVar = new b(shapeAppearanceModel, f10, rectF, pathListener, path);
        for (int i10 = 0; i10 < 4; i10++) {
            setCornerPathAndTransform(bVar, i10);
            setEdgePathAndTransform(i10);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            appendCornerPath(bVar, i11);
            appendEdgePath(bVar, i11);
        }
        path.close();
        this.overlappedEdgePath.close();
        if (!this.overlappedEdgePath.isEmpty()) {
            path.op(this.overlappedEdgePath, Path.Op.UNION);
        }
    }
}
