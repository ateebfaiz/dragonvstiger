package com.appsflyer.internal;

import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1oSDK;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

final class AFa1uSDK {

    enum AFa1wSDK {
        UNKNOWN(0),
        ACCELEROMETER(1),
        MAGNETOMETER(2),
        RESERVED(3),
        GYROSCOPE(4);
        
        private int afDebugLog;

        private AFa1wSDK(int i10) {
            this.afDebugLog = i10;
        }
    }

    enum AFa1xSDK {
        UNKNOWN("uk"),
        ACCELEROMETER("am"),
        MAGNETOMETER("mm"),
        RESERVED("rs"),
        GYROSCOPE("gs");
        
        String values;

        private AFa1xSDK(String str) {
            this.values = str;
        }
    }

    enum AFa1ySDK {
        NONE,
        FIRST,
        ALL
    }

    AFa1uSDK() {
    }

    @VisibleForTesting
    static List<BigDecimal> AFInAppEventType(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        Float f10 = (Float) arrayList.get(0);
        Float f11 = (Float) arrayList.get(1);
        Float f12 = (Float) arrayList.get(2);
        ArrayList arrayList2 = new ArrayList();
        try {
            arrayList2.add(BigDecimal.valueOf(AFc1oSDK.AFa1xSDK.AFInAppEventType(f10.toString())));
            arrayList2.add(BigDecimal.valueOf(AFc1oSDK.AFa1xSDK.AFInAppEventType(f11.toString())));
            arrayList2.add(BigDecimal.valueOf(AFc1oSDK.AFa1xSDK.AFInAppEventType(f12.toString())));
        } catch (ParseException e10) {
            AFLogger.afErrorLogForExcManagerOnly("failed to parse string to number", e10);
        }
        return arrayList2;
    }
}
