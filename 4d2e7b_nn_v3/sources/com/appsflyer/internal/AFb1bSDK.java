package com.appsflyer.internal;

import android.content.Context;
import kotlin.jvm.internal.m;

public interface AFb1bSDK {

    public static final class AFa1ySDK {
        public final float AFKeystoreWrapper;
        public final String values;

        public AFa1ySDK(float f10, String str) {
            this.AFKeystoreWrapper = f10;
            this.values = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AFa1ySDK)) {
                return false;
            }
            AFa1ySDK aFa1ySDK = (AFa1ySDK) obj;
            return m.b(Float.valueOf(this.AFKeystoreWrapper), Float.valueOf(aFa1ySDK.AFKeystoreWrapper)) && m.b(this.values, aFa1ySDK.values);
        }

        public final int hashCode() {
            int i10;
            int floatToIntBits = Float.floatToIntBits(this.AFKeystoreWrapper) * 31;
            String str = this.values;
            if (str == null) {
                i10 = 0;
            } else {
                i10 = str.hashCode();
            }
            return floatToIntBits + i10;
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("BatteryData(level=");
            sb2.append(this.AFKeystoreWrapper);
            sb2.append(", charging=");
            sb2.append(this.values);
            sb2.append(')');
            return sb2.toString();
        }
    }

    AFa1ySDK AFInAppEventType(Context context);
}
