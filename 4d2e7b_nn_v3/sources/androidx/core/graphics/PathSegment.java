package androidx.core.graphics;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

public final class PathSegment {
    private final PointF mEnd;
    private final float mEndFraction;
    private final PointF mStart;
    private final float mStartFraction;

    public PathSegment(@NonNull PointF pointF, float f10, @NonNull PointF pointF2, float f11) {
        this.mStart = (PointF) Preconditions.checkNotNull(pointF, "start == null");
        this.mStartFraction = f10;
        this.mEnd = (PointF) Preconditions.checkNotNull(pointF2, "end == null");
        this.mEndFraction = f11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        if (Float.compare(this.mStartFraction, pathSegment.mStartFraction) != 0 || Float.compare(this.mEndFraction, pathSegment.mEndFraction) != 0 || !this.mStart.equals(pathSegment.mStart) || !this.mEnd.equals(pathSegment.mEnd)) {
            return false;
        }
        return true;
    }

    @NonNull
    public PointF getEnd() {
        return this.mEnd;
    }

    public float getEndFraction() {
        return this.mEndFraction;
    }

    @NonNull
    public PointF getStart() {
        return this.mStart;
    }

    public float getStartFraction() {
        return this.mStartFraction;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.mStart.hashCode() * 31;
        float f10 = this.mStartFraction;
        int i11 = 0;
        if (f10 != 0.0f) {
            i10 = Float.floatToIntBits(f10);
        } else {
            i10 = 0;
        }
        int hashCode2 = (((hashCode + i10) * 31) + this.mEnd.hashCode()) * 31;
        float f11 = this.mEndFraction;
        if (f11 != 0.0f) {
            i11 = Float.floatToIntBits(f11);
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "PathSegment{start=" + this.mStart + ", startFraction=" + this.mStartFraction + ", end=" + this.mEnd + ", endFraction=" + this.mEndFraction + '}';
    }
}
