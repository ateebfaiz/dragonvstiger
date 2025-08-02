package com.appsflyer.internal;

import androidx.annotation.Nullable;

public final class AFb1mSDK {
    @Nullable
    public final AFb1qSDK AFKeystoreWrapper;
    @Nullable
    public final AFb1nSDK valueOf;

    public AFb1mSDK() {
    }

    public static boolean valueOf(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean values(@Nullable String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        AFb1qSDK aFb1qSDK = this.AFKeystoreWrapper;
        if (aFb1qSDK != null) {
            return aFb1qSDK.hashCode();
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x004f A[SYNTHETIC, Splitter:B:8:0x004f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AFb1mSDK(org.json.JSONObject r13) {
        /*
            r12 = this;
            r12.<init>()
            java.lang.String r0 = "exc_mngr"
            boolean r1 = r13.has(r0)
            r2 = 0
            java.lang.String r3 = "v1"
            java.lang.String r4 = "data"
            r5 = 0
            if (r1 == 0) goto L_0x0046
            org.json.JSONArray r0 = r13.getJSONArray(r0)     // Catch:{ NullPointerException | JSONException -> 0x0046 }
            org.json.JSONObject r0 = r0.optJSONObject(r5)     // Catch:{ NullPointerException | JSONException -> 0x0046 }
            org.json.JSONObject r0 = r0.optJSONObject(r4)     // Catch:{ NullPointerException | JSONException -> 0x0046 }
            java.util.Objects.requireNonNull(r0)     // Catch:{ NullPointerException | JSONException -> 0x0046 }
            org.json.JSONObject r0 = r0.optJSONObject(r3)     // Catch:{ NullPointerException | JSONException -> 0x0046 }
            java.lang.String r1 = "sdk_ver"
            java.lang.String r7 = r0.getString(r1)     // Catch:{ NullPointerException | JSONException -> 0x0046 }
            java.lang.String r1 = "min"
            r6 = -1
            int r8 = r0.optInt(r1, r6)     // Catch:{ NullPointerException | JSONException -> 0x0046 }
            java.lang.String r1 = "expire"
            int r9 = r0.optInt(r1, r6)     // Catch:{ NullPointerException | JSONException -> 0x0046 }
            java.lang.String r1 = "ttl"
            r10 = -1
            long r10 = r0.optLong(r1, r10)     // Catch:{ NullPointerException | JSONException -> 0x0046 }
            com.appsflyer.internal.AFb1qSDK r0 = new com.appsflyer.internal.AFb1qSDK     // Catch:{ NullPointerException | JSONException -> 0x0046 }
            r6 = r0
            r6.<init>(r7, r8, r9, r10)     // Catch:{ NullPointerException | JSONException -> 0x0046 }
            goto L_0x0047
        L_0x0046:
            r0 = r2
        L_0x0047:
            java.lang.String r1 = "meta_data"
            boolean r6 = r13.has(r1)
            if (r6 == 0) goto L_0x0070
            org.json.JSONArray r13 = r13.getJSONArray(r1)     // Catch:{ NullPointerException | JSONException -> 0x0070 }
            org.json.JSONObject r13 = r13.optJSONObject(r5)     // Catch:{ NullPointerException | JSONException -> 0x0070 }
            org.json.JSONObject r13 = r13.optJSONObject(r4)     // Catch:{ NullPointerException | JSONException -> 0x0070 }
            java.util.Objects.requireNonNull(r13)     // Catch:{ NullPointerException | JSONException -> 0x0070 }
            org.json.JSONObject r13 = r13.optJSONObject(r3)     // Catch:{ NullPointerException | JSONException -> 0x0070 }
            java.lang.String r1 = "send_rate"
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r13.optDouble(r1, r3)     // Catch:{ NullPointerException | JSONException -> 0x0070 }
            com.appsflyer.internal.AFb1nSDK r13 = new com.appsflyer.internal.AFb1nSDK     // Catch:{ NullPointerException | JSONException -> 0x0070 }
            r13.<init>(r3)     // Catch:{ NullPointerException | JSONException -> 0x0070 }
            r2 = r13
        L_0x0070:
            r12.AFKeystoreWrapper = r0
            r12.valueOf = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1mSDK.<init>(org.json.JSONObject):void");
    }
}
