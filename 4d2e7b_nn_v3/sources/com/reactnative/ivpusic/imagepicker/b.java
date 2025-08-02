package com.reactnative.ivpusic.imagepicker;

import android.media.ExifInterface;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class b {
    static WritableMap a(String str) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        List<String> b10 = b();
        b10.addAll(c());
        ExifInterface exifInterface = new ExifInterface(str);
        try {
            c cVar = new c(exifInterface);
            if (!(cVar.b() == null || cVar.c() == null)) {
                writableNativeMap.putDouble("Latitude", (double) cVar.b().floatValue());
                writableNativeMap.putDouble("Longitude", (double) cVar.c().floatValue());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        for (String str2 : b10) {
            writableNativeMap.putString(str2, exifInterface.getAttribute(str2));
        }
        return writableNativeMap;
    }

    private static List b() {
        return new ArrayList(Arrays.asList(new String[]{androidx.exifinterface.media.ExifInterface.TAG_F_NUMBER, androidx.exifinterface.media.ExifInterface.TAG_DATETIME, androidx.exifinterface.media.ExifInterface.TAG_EXPOSURE_TIME, androidx.exifinterface.media.ExifInterface.TAG_FLASH, androidx.exifinterface.media.ExifInterface.TAG_FOCAL_LENGTH, androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE, androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE_REF, androidx.exifinterface.media.ExifInterface.TAG_GPS_DATESTAMP, androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE, androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF, androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE, androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF, androidx.exifinterface.media.ExifInterface.TAG_GPS_PROCESSING_METHOD, androidx.exifinterface.media.ExifInterface.TAG_GPS_TIMESTAMP, androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED_RATINGS, androidx.exifinterface.media.ExifInterface.TAG_MAKE, androidx.exifinterface.media.ExifInterface.TAG_MODEL, androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, androidx.exifinterface.media.ExifInterface.TAG_WHITE_BALANCE}));
    }

    private static List c() {
        return new ArrayList(Arrays.asList(new String[]{androidx.exifinterface.media.ExifInterface.TAG_DATETIME_DIGITIZED, androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME, androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_ORIGINAL}));
    }
}
