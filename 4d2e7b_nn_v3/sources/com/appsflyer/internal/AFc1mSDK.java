package com.appsflyer.internal;

import androidx.annotation.VisibleForTesting;
import com.appsflyer.AppsFlyerLib;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;

public final class AFc1mSDK extends AFc1rSDK {
    public static final AFa1xSDK AFa1xSDK = new AFa1xSDK((DefaultConstructorMarker) null);

    public static final class AFa1xSDK {
        private AFa1xSDK() {
        }

        static String AFKeystoreWrapper(String str, String str2, String str3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.format(AFc1kSDK.values, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()}));
            sb2.append(str);
            sb2.append(str3);
            sb2.append("?device_id=");
            sb2.append(str2);
            return sb2.toString();
        }

        public /* synthetic */ AFa1xSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static String AFKeystoreWrapper(String str, String str2, String str3, String str4, String str5) {
            m.f(str, "");
            m.f(str2, "");
            m.f(str4, "");
            m.f(str5, "");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str2);
            return AFb1ySDK.AFKeystoreWrapper(AFb1ySDK.valueOf(str5, str3, sb2.toString()), str4);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ AFc1mSDK(String str, Map map, byte[] bArr, String str2, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i10 & 4) != 0 ? null : bArr, (i10 & 8) != 0 ? "GET" : str2, (i10 & 16) != 0 ? false : z10);
    }

    public static final AFc1mSDK valueOf(String str, String str2, String str3, String str4) {
        m.f(str, "");
        m.f(str3, "");
        m.f(str4, "");
        String AFKeystoreWrapper = AFa1xSDK.AFKeystoreWrapper(str, str2, str3);
        String valueOf = String.valueOf(System.currentTimeMillis());
        AFc1mSDK aFc1mSDK = new AFc1mSDK(AFKeystoreWrapper, i0.i(t.a("Connection", "close"), t.a("af_request_epoch_ms", valueOf), t.a("af_sig", AFa1xSDK.AFKeystoreWrapper(str, str3, str2, str4, valueOf))), (byte[]) null, (String) null, false, 28, (DefaultConstructorMarker) null);
        aFc1mSDK.valueOf(10000);
        return aFc1mSDK;
    }

    private AFc1mSDK(String str, Map<String, String> map, byte[] bArr, String str2, boolean z10) {
        super(str, bArr, str2, map, z10);
    }
}
