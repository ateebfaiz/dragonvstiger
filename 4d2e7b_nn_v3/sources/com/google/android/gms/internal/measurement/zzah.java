package com.google.android.gms.internal.measurement;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

public final class zzah implements zzap {
    private final Double zza;

    public zzah(Double d10) {
        if (d10 == null) {
            this.zza = Double.valueOf(Double.NaN);
        } else {
            this.zza = d10;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        return this.zza.equals(((zzah) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return zzi();
    }

    public final zzap zzbR(String str, zzg zzg, List list) {
        if ("toString".equals(str)) {
            return new zzat(zzi());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[]{zzi(), str}));
    }

    public final zzap zzd() {
        return new zzah(this.zza);
    }

    public final Boolean zzg() {
        boolean z10 = false;
        if (!Double.isNaN(this.zza.doubleValue()) && this.zza.doubleValue() != 0.0d) {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }

    public final Double zzh() {
        return this.zza;
    }

    public final String zzi() {
        int scale;
        if (Double.isNaN(this.zza.doubleValue())) {
            return "NaN";
        }
        if (!Double.isInfinite(this.zza.doubleValue())) {
            BigDecimal a10 = c.a(BigDecimal.valueOf(this.zza.doubleValue()));
            DecimalFormat decimalFormat = new DecimalFormat("0E0");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (a10.scale() > 0) {
                scale = a10.precision();
            } else {
                scale = a10.scale();
            }
            decimalFormat.setMinimumFractionDigits(scale - 1);
            String format = decimalFormat.format(a10);
            int indexOf = format.indexOf(ExifInterface.LONGITUDE_EAST);
            if (indexOf <= 0) {
                return format;
            }
            int parseInt = Integer.parseInt(format.substring(indexOf + 1));
            if ((parseInt >= 0 || parseInt <= -7) && (parseInt < 0 || parseInt >= 21)) {
                return format.replace("E-", "e-").replace(ExifInterface.LONGITUDE_EAST, "e+");
            }
            return a10.toPlainString();
        } else if (this.zza.doubleValue() > 0.0d) {
            return "Infinity";
        } else {
            return "-Infinity";
        }
    }

    public final Iterator zzl() {
        return null;
    }
}
