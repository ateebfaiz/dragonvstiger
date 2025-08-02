package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.core.util.Preconditions;
import java.util.Iterator;

class n extends GnssStatusCompat {

    /* renamed from: a  reason: collision with root package name */
    private final GpsStatus f15014a;

    /* renamed from: b  reason: collision with root package name */
    private int f15015b = -1;

    /* renamed from: c  reason: collision with root package name */
    private Iterator f15016c;

    /* renamed from: d  reason: collision with root package name */
    private int f15017d;

    /* renamed from: e  reason: collision with root package name */
    private GpsSatellite f15018e;

    n(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.checkNotNull(gpsStatus);
        this.f15014a = gpsStatus2;
        this.f15016c = gpsStatus2.getSatellites().iterator();
        this.f15017d = -1;
        this.f15018e = null;
    }

    private static int a(int i10) {
        if (i10 > 0 && i10 <= 32) {
            return 1;
        }
        if (i10 >= 33 && i10 <= 64) {
            return 2;
        }
        if (i10 > 64 && i10 <= 88) {
            return 3;
        }
        if (i10 <= 200 || i10 > 235) {
            return (i10 < 193 || i10 > 200) ? 0 : 4;
        }
        return 5;
    }

    private GpsSatellite b(int i10) {
        GpsSatellite gpsSatellite;
        synchronized (this.f15014a) {
            try {
                if (i10 < this.f15017d) {
                    this.f15016c = this.f15014a.getSatellites().iterator();
                    this.f15017d = -1;
                }
                while (true) {
                    int i11 = this.f15017d;
                    if (i11 >= i10) {
                        break;
                    }
                    this.f15017d = i11 + 1;
                    if (!this.f15016c.hasNext()) {
                        this.f15018e = null;
                        break;
                    }
                    this.f15018e = (GpsSatellite) this.f15016c.next();
                }
                gpsSatellite = this.f15018e;
            } finally {
                while (true) {
                }
            }
        }
        return (GpsSatellite) Preconditions.checkNotNull(gpsSatellite);
    }

    private static int c(int i10) {
        int a10 = a(i10);
        if (a10 == 2) {
            return i10 + 87;
        }
        if (a10 == 3) {
            return i10 - 64;
        }
        if (a10 != 5) {
            return i10;
        }
        return i10 - 200;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        return this.f15014a.equals(((n) obj).f15014a);
    }

    public float getAzimuthDegrees(int i10) {
        return b(i10).getAzimuth();
    }

    public float getBasebandCn0DbHz(int i10) {
        throw new UnsupportedOperationException();
    }

    public float getCarrierFrequencyHz(int i10) {
        throw new UnsupportedOperationException();
    }

    public float getCn0DbHz(int i10) {
        return b(i10).getSnr();
    }

    public int getConstellationType(int i10) {
        if (Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        return a(b(i10).getPrn());
    }

    public float getElevationDegrees(int i10) {
        return b(i10).getElevation();
    }

    public int getSatelliteCount() {
        int i10;
        synchronized (this.f15014a) {
            try {
                if (this.f15015b == -1) {
                    for (GpsSatellite next : this.f15014a.getSatellites()) {
                        this.f15015b++;
                    }
                    this.f15015b++;
                }
                i10 = this.f15015b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i10;
    }

    public int getSvid(int i10) {
        if (Build.VERSION.SDK_INT < 24) {
            return b(i10).getPrn();
        }
        return c(b(i10).getPrn());
    }

    public boolean hasAlmanacData(int i10) {
        return b(i10).hasAlmanac();
    }

    public boolean hasBasebandCn0DbHz(int i10) {
        return false;
    }

    public boolean hasCarrierFrequencyHz(int i10) {
        return false;
    }

    public boolean hasEphemerisData(int i10) {
        return b(i10).hasEphemeris();
    }

    public int hashCode() {
        return this.f15014a.hashCode();
    }

    public boolean usedInFix(int i10) {
        return b(i10).usedInFix();
    }
}
