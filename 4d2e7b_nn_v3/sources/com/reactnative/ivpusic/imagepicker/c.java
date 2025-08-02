package com.reactnative.ivpusic.imagepicker;

import android.media.ExifInterface;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;

public class c {

    /* renamed from: a  reason: collision with root package name */
    Float f11185a;

    /* renamed from: b  reason: collision with root package name */
    Float f11186b;

    public c(ExifInterface exifInterface) {
        String attribute = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE);
        String attribute2 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF);
        String attribute3 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE);
        String attribute4 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF);
        if (attribute != null && attribute2 != null && attribute3 != null && attribute4 != null) {
            if (attribute2.equals("N")) {
                this.f11185a = a(attribute);
            } else {
                this.f11185a = Float.valueOf(0.0f - a(attribute).floatValue());
            }
            if (attribute4.equals(androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST)) {
                this.f11186b = a(attribute3);
            } else {
                this.f11186b = Float.valueOf(0.0f - a(attribute3).floatValue());
            }
        }
    }

    private Float a(String str) {
        String[] split = str.split(",", 3);
        String[] split2 = split[0].split(DomExceptionUtils.SEPARATOR, 2);
        Double valueOf = Double.valueOf(split2[0]);
        Double valueOf2 = Double.valueOf(split2[1]);
        String[] split3 = split[1].split(DomExceptionUtils.SEPARATOR, 2);
        Double valueOf3 = Double.valueOf(split3[0]);
        Double valueOf4 = Double.valueOf(split3[1]);
        String[] split4 = split[2].split(DomExceptionUtils.SEPARATOR, 2);
        return Float.valueOf((float) ((valueOf.doubleValue() / valueOf2.doubleValue()) + ((valueOf3.doubleValue() / valueOf4.doubleValue()) / 60.0d) + ((Double.valueOf(split4[0]).doubleValue() / Double.valueOf(split4[1]).doubleValue()) / 3600.0d)));
    }

    public Float b() {
        return this.f11185a;
    }

    public Float c() {
        return this.f11186b;
    }
}
