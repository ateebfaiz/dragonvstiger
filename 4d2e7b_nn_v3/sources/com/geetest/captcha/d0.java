package com.geetest.captcha;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.m;

public enum d0 {
    WEB_VIEW_NEW("0"),
    PARAM("1"),
    WEB_VIEW_HTTP(ExifInterface.GPS_MEASUREMENT_2D),
    WEB_VIEW_SSL(ExifInterface.GPS_MEASUREMENT_3D),
    USER_ERROR("4"),
    WEB_CALLBACK_ERROR("5"),
    NET("6");
    
    public String type;

    /* access modifiers changed from: public */
    d0(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        m.f(str, "<set-?>");
        this.type = str;
    }
}
