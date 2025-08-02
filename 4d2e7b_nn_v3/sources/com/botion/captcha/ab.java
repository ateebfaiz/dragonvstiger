package com.botion.captcha;

import androidx.exifinterface.media.ExifInterface;
import com.zing.zalo.zalosdk.common.Constant;
import kotlin.jvm.internal.m;

public final class ab {

    /* renamed from: a  reason: collision with root package name */
    public static final ab f18458a = new ab();

    public enum a {
        WEB_VIEW_NEW("0"),
        PARAM("1"),
        WEB_VIEW_HTTP(ExifInterface.GPS_MEASUREMENT_2D),
        WEB_VIEW_SSL(ExifInterface.GPS_MEASUREMENT_3D),
        USER_ERROR("4"),
        WEB_CALLBACK_ERROR("5"),
        NET("6");
        
        private String type;

        private a(String str) {
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

    private ab() {
    }

    public static String a(String str, String str2) {
        m.f(str2, Constant.PARAM_OAUTH_CODE);
        return m.n(str, str2);
    }
}
