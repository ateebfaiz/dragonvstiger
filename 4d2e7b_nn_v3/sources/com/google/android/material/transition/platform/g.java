package com.google.android.material.transition.platform;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.transition.platform.MaterialContainerTransform;

class g {

    /* renamed from: a  reason: collision with root package name */
    private final Path f8937a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f8938b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f8939c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final ShapeAppearancePathProvider f8940d = ShapeAppearancePathProvider.getInstance();

    /* renamed from: e  reason: collision with root package name */
    private ShapeAppearanceModel f8941e;

    g() {
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        canvas.clipPath(this.f8937a);
    }

    /* access modifiers changed from: package-private */
    public void b(float f10, ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, RectF rectF3, MaterialContainerTransform.ProgressThresholds progressThresholds) {
        ShapeAppearanceModel o10 = j.o(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.getStart(), progressThresholds.getEnd(), f10);
        this.f8941e = o10;
        this.f8940d.calculatePath(o10, 1.0f, rectF2, this.f8938b);
        this.f8940d.calculatePath(this.f8941e, 1.0f, rectF3, this.f8939c);
        this.f8937a.op(this.f8938b, this.f8939c, Path.Op.UNION);
    }

    /* access modifiers changed from: package-private */
    public ShapeAppearanceModel c() {
        return this.f8941e;
    }

    /* access modifiers changed from: package-private */
    public Path d() {
        return this.f8937a;
    }
}
