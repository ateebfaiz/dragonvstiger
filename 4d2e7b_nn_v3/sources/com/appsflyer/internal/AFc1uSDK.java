package com.appsflyer.internal;

import android.util.Base64;
import com.google.firebase.messaging.Constants;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.d;
import kotlin.text.j;
import org.json.JSONObject;

public final class AFc1uSDK {
    public static final AFa1xSDK AFa1xSDK = new AFa1xSDK((DefaultConstructorMarker) null);
    public final String AFInAppEventParameterName;
    public int AFKeystoreWrapper;
    public final String valueOf;
    public final String values;

    public static final class AFa1xSDK {
        private AFa1xSDK() {
        }

        private static String AFInAppEventParameterName(String str, String str2) {
            String substring = str.substring(str2.length());
            m.e(substring, "");
            String obj = j.P0(substring).toString();
            m.f(obj, "");
            Charset charset = d.f797b;
            byte[] bytes = obj.getBytes(charset);
            m.e(bytes, "");
            m.f(bytes, "");
            byte[] decode = Base64.decode(bytes, 2);
            m.e(decode, "");
            return new String(decode, charset);
        }

        public static AFc1uSDK AFInAppEventType(String str) {
            m.f(str, "");
            List<String> v02 = j.v0(str, new String[]{"\n"}, false, 0, 6, (Object) null);
            if (v02.size() != 4) {
                return null;
            }
            String str2 = null;
            String str3 = null;
            String str4 = null;
            Integer num = null;
            for (String str5 : v02) {
                if (!j.F(str5, "label=", false, 2, (Object) null)) {
                    if (!j.F(str5, "hashName=", false, 2, (Object) null)) {
                        if (!j.F(str5, "stackTrace=", false, 2, (Object) null)) {
                            if (!j.F(str5, "c=", false, 2, (Object) null)) {
                                break;
                            }
                            String substring = str5.substring(2);
                            m.e(substring, "");
                            num = Integer.valueOf(Integer.parseInt(j.P0(substring).toString()));
                        } else {
                            str4 = AFInAppEventParameterName(str5, "stackTrace=");
                        }
                    } else {
                        str3 = AFInAppEventParameterName(str5, "hashName=");
                    }
                } else {
                    str2 = AFInAppEventParameterName(str5, "label=");
                }
            }
            if (valueOf(num, str2, str3, str4)) {
                return null;
            }
            m.c(str2);
            m.c(str3);
            m.c(str4);
            m.c(num);
            return new AFc1uSDK(str2, str3, str4, num.intValue());
        }

        private static boolean valueOf(Integer num, String... strArr) {
            boolean z10;
            boolean z11;
            if (num == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            int length = strArr.length;
            for (int i10 = 0; i10 < 3; i10++) {
                String str = strArr[i10];
                if (z10 || str == null || str.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            }
            return z10;
        }

        public /* synthetic */ AFa1xSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AFc1uSDK(String str, String str2, String str3, int i10) {
        m.f(str, "");
        m.f(str2, "");
        m.f(str3, "");
        this.valueOf = str;
        this.AFInAppEventParameterName = str2;
        this.values = str3;
        this.AFKeystoreWrapper = i10;
    }

    public final JSONObject AFKeystoreWrapper() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.ScionAnalytics.PARAM_LABEL, this.valueOf);
        jSONObject.put("hash_name", this.AFInAppEventParameterName);
        jSONObject.put("st", this.values);
        jSONObject.put(com.alibaba.pdns.net.d.f18103f, String.valueOf(this.AFKeystoreWrapper));
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFc1uSDK)) {
            return false;
        }
        AFc1uSDK aFc1uSDK = (AFc1uSDK) obj;
        return m.b(this.valueOf, aFc1uSDK.valueOf) && m.b(this.AFInAppEventParameterName, aFc1uSDK.AFInAppEventParameterName) && m.b(this.values, aFc1uSDK.values) && this.AFKeystoreWrapper == aFc1uSDK.AFKeystoreWrapper;
    }

    public final int hashCode() {
        return (((((this.valueOf.hashCode() * 31) + this.AFInAppEventParameterName.hashCode()) * 31) + this.values.hashCode()) * 31) + this.AFKeystoreWrapper;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AFc1uSDK(AFKeystoreWrapper=");
        sb2.append(this.valueOf);
        sb2.append(", valueOf=");
        sb2.append(this.AFInAppEventParameterName);
        sb2.append(", values=");
        sb2.append(this.values);
        sb2.append(", AFInAppEventParameterName=");
        sb2.append(this.AFKeystoreWrapper);
        sb2.append(')');
        return sb2.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AFc1uSDK(String str, String str2, String str3, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i11 & 8) != 0 ? 1 : i10);
    }
}
