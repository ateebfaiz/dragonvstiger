package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.core.util.Preconditions;

class m extends GnssStatusCompat {

    /* renamed from: a  reason: collision with root package name */
    private final GnssStatus f15010a;

    static class a {
        @DoNotInline
        static float a(GnssStatus gnssStatus, int i10) {
            return gnssStatus.getCarrierFrequencyHz(i10);
        }

        @DoNotInline
        static boolean b(GnssStatus gnssStatus, int i10) {
            return gnssStatus.hasCarrierFrequencyHz(i10);
        }
    }

    static class b {
        @DoNotInline
        static float a(GnssStatus gnssStatus, int i10) {
            return gnssStatus.getBasebandCn0DbHz(i10);
        }

        @DoNotInline
        static boolean b(GnssStatus gnssStatus, int i10) {
            return gnssStatus.hasBasebandCn0DbHz(i10);
        }
    }

    m(Object obj) {
        this.f15010a = d.a(Preconditions.checkNotNull(d.a(obj)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        return this.f15010a.equals(((m) obj).f15010a);
    }

    public float getAzimuthDegrees(int i10) {
        return this.f15010a.getAzimuthDegrees(i10);
    }

    public float getBasebandCn0DbHz(int i10) {
        if (Build.VERSION.SDK_INT >= 30) {
            return b.a(this.f15010a, i10);
        }
        throw new UnsupportedOperationException();
    }

    public float getCarrierFrequencyHz(int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.a(this.f15010a, i10);
        }
        throw new UnsupportedOperationException();
    }

    public float getCn0DbHz(int i10) {
        return this.f15010a.getCn0DbHz(i10);
    }

    public int getConstellationType(int i10) {
        return this.f15010a.getConstellationType(i10);
    }

    public float getElevationDegrees(int i10) {
        return this.f15010a.getElevationDegrees(i10);
    }

    public int getSatelliteCount() {
        return this.f15010a.getSatelliteCount();
    }

    public int getSvid(int i10) {
        return this.f15010a.getSvid(i10);
    }

    public boolean hasAlmanacData(int i10) {
        return this.f15010a.hasAlmanacData(i10);
    }

    public boolean hasBasebandCn0DbHz(int i10) {
        if (Build.VERSION.SDK_INT >= 30) {
            return b.b(this.f15010a, i10);
        }
        return false;
    }

    public boolean hasCarrierFrequencyHz(int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.b(this.f15010a, i10);
        }
        return false;
    }

    public boolean hasEphemerisData(int i10) {
        return this.f15010a.hasEphemerisData(i10);
    }

    public int hashCode() {
        return this.f15010a.hashCode();
    }

    public boolean usedInFix(int i10) {
        return this.f15010a.usedInFix(i10);
    }
}
