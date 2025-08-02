package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.transition.MaterialContainerTransform;

class g {

    /* renamed from: a  reason: collision with root package name */
    private final Path f8844a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f8845b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f8846c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final ShapeAppearancePathProvider f8847d = ShapeAppearancePathProvider.getInstance();

    /* renamed from: e  reason: collision with root package name */
    private ShapeAppearanceModel f8848e;

    g() {
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        canvas.clipPath(this.f8844a);
    }

    /* access modifiers changed from: package-private */
    public void b(float f10, ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, RectF rectF3, MaterialContainerTransform.ProgressThresholds progressThresholds) {
        ShapeAppearanceModel n10 = j.n(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.getStart(), progressThresholds.getEnd(), f10);
        this.f8848e = n10;
        this.f8847d.calculatePath(n10, 1.0f, rectF2, this.f8845b);
        this.f8847d.calculatePath(this.f8848e, 1.0f, rectF3, this.f8846c);
        this.f8844a.op(this.f8845b, this.f8846c, Path.Op.UNION);
    }

    /* access modifiers changed from: package-private */
    public ShapeAppearanceModel c() {
        return this.f8848e;
    }

    /* access modifiers changed from: package-private */
    public Path d() {
        return this.f8844a;
    }
}
