package androidx.core.util;

import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

public final class SizeFCompat {
    private final float mHeight;
    private final float mWidth;

    private static final class a {
        @DoNotInline
        @NonNull
        static SizeF a(@NonNull SizeFCompat sizeFCompat) {
            Preconditions.checkNotNull(sizeFCompat);
            return new SizeF(sizeFCompat.getWidth(), sizeFCompat.getHeight());
        }

        @DoNotInline
        @NonNull
        static SizeFCompat b(@NonNull SizeF sizeF) {
            Preconditions.checkNotNull(sizeF);
            return new SizeFCompat(sizeF.getWidth(), sizeF.getHeight());
        }
    }

    public SizeFCompat(float f10, float f11) {
        this.mWidth = Preconditions.checkArgumentFinite(f10, Snapshot.WIDTH);
        this.mHeight = Preconditions.checkArgumentFinite(f11, Snapshot.HEIGHT);
    }

    @RequiresApi(21)
    @NonNull
    public static SizeFCompat toSizeFCompat(@NonNull SizeF sizeF) {
        return a.b(sizeF);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeFCompat)) {
            return false;
        }
        SizeFCompat sizeFCompat = (SizeFCompat) obj;
        if (sizeFCompat.mWidth == this.mWidth && sizeFCompat.mHeight == this.mHeight) {
            return true;
        }
        return false;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.mWidth) ^ Float.floatToIntBits(this.mHeight);
    }

    @RequiresApi(21)
    @NonNull
    public SizeF toSizeF() {
        return a.a(this);
    }

    @NonNull
    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}
