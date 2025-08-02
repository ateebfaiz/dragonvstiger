package com.zing.zalo.zalosdk.oauth;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

public class BrowserLoginActivity extends Activity {
    /* JADX WARNING: Removed duplicated region for block: B:55:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x011c A[Catch:{ JSONException -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012c A[Catch:{ JSONException -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0162 A[Catch:{ JSONException -> 0x0120 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handleBrowserCallback() {
        /*
            r25 = this;
            java.lang.String r1 = "gender"
            java.lang.String r2 = "dob"
            java.lang.String r3 = "socialId"
            java.lang.String r4 = "scope"
            java.lang.String r5 = "display_name"
            java.lang.String r0 = "error_reason"
            java.lang.String r6 = "error_description"
            java.lang.String r7 = "errorMsg"
            android.content.Intent r8 = r25.getIntent()
            android.net.Uri r8 = r8.getData()
            if (r8 == 0) goto L_0x0020
            java.lang.String r10 = r8.getQuery()
            if (r10 != 0) goto L_0x0025
        L_0x0020:
            r3 = r25
            r4 = 0
            goto L_0x0189
        L_0x0025:
            java.lang.String r10 = r8.getScheme()
            if (r10 == 0) goto L_0x0046
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "zalo-"
            r11.append(r12)
            java.lang.String r12 = com.zing.zalo.zalosdk.core.helper.AppInfo.getAppId(r25)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            boolean r10 = r10.startsWith(r11)
            if (r10 != 0) goto L_0x004b
        L_0x0046:
            r3 = r25
            r4 = 0
            goto L_0x0189
        L_0x004b:
            android.content.Intent r10 = new android.content.Intent
            r10.<init>()
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>()
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            java.lang.String r13 = "error"
            java.lang.String r14 = r8.getQueryParameter(r13)
            java.lang.String r15 = "code"
            java.lang.String r9 = r8.getQueryParameter(r15)
            int r16 = java.lang.Integer.parseInt(r14)     // Catch:{ Exception -> 0x0073 }
            r17 = r2
            r24 = r16
            r16 = r1
            r1 = r24
            goto L_0x0078
        L_0x0073:
            r16 = r1
            r17 = r2
            r1 = 0
        L_0x0078:
            java.lang.String r2 = "handleBrowserCallback"
            r18 = r3
            java.lang.String r3 = "browser"
            r19 = r4
            java.lang.String r4 = "from_source"
            r20 = r5
            java.lang.String r5 = "data"
            if (r14 == 0) goto L_0x00c5
            if (r1 == 0) goto L_0x00c5
            r10.putExtra(r13, r1)
            java.lang.String r1 = r8.getQueryParameter(r7)     // Catch:{ JSONException -> 0x00b7 }
            java.lang.String r9 = r8.getQueryParameter(r6)     // Catch:{ JSONException -> 0x00b7 }
            java.lang.String r8 = r8.getQueryParameter(r0)     // Catch:{ JSONException -> 0x00b7 }
            java.lang.String r13 = ""
            if (r1 == 0) goto L_0x009e
            goto L_0x009f
        L_0x009e:
            r1 = r13
        L_0x009f:
            r12.put(r7, r1)     // Catch:{ JSONException -> 0x00b7 }
            if (r9 == 0) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            r9 = r13
        L_0x00a6:
            r12.put(r6, r9)     // Catch:{ JSONException -> 0x00b7 }
            if (r8 == 0) goto L_0x00ac
            goto L_0x00ad
        L_0x00ac:
            r8 = r13
        L_0x00ad:
            r12.put(r0, r8)     // Catch:{ JSONException -> 0x00b7 }
            r12.put(r4, r3)     // Catch:{ JSONException -> 0x00b7 }
            r11.put(r5, r12)     // Catch:{ JSONException -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r0 = move-exception
            com.zing.zalo.zalosdk.core.log.Log.e((java.lang.String) r2, (java.lang.Exception) r0)
        L_0x00bb:
            java.lang.String r0 = r11.toString()
            r10.putExtra(r5, r0)
        L_0x00c2:
            r1 = 1
            goto L_0x017d
        L_0x00c5:
            if (r9 == 0) goto L_0x00c2
            java.lang.String r1 = "ext_info"
            java.lang.String r0 = r8.getQueryParameter(r1)
            java.lang.String r6 = "uid"
            java.lang.String r7 = r8.getQueryParameter(r6)
            java.lang.String r13 = "state"
            java.lang.String r14 = r8.getQueryParameter(r13)
            boolean r21 = android.text.TextUtils.isEmpty(r0)
            r22 = r2
            java.lang.String r2 = "viewer"
            r23 = 0
            if (r21 != 0) goto L_0x00fc
            r21 = r5
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f5 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r23 = r5.getString(r2)     // Catch:{ Exception -> 0x00f3 }
        L_0x00f0:
            r0 = r23
            goto L_0x0101
        L_0x00f3:
            r0 = move-exception
            goto L_0x00f8
        L_0x00f5:
            r0 = move-exception
            r5 = r23
        L_0x00f8:
            r0.printStackTrace()
            goto L_0x00f0
        L_0x00fc:
            r21 = r5
            r0 = r23
            r5 = r0
        L_0x0101:
            r10.putExtra(r15, r9)
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto L_0x0114
            r9 = r3
            r15 = r4
            long r3 = java.lang.Long.parseLong(r7)
            r10.putExtra(r6, r3)
            goto L_0x0116
        L_0x0114:
            r9 = r3
            r15 = r4
        L_0x0116:
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0120 }
            if (r3 != 0) goto L_0x0126
            r12.put(r2, r0)     // Catch:{ JSONException -> 0x0120 }
            goto L_0x0126
        L_0x0120:
            r0 = move-exception
            r1 = r21
        L_0x0123:
            r2 = r22
            goto L_0x016d
        L_0x0126:
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ JSONException -> 0x0120 }
            if (r0 != 0) goto L_0x012f
            r12.put(r13, r14)     // Catch:{ JSONException -> 0x0120 }
        L_0x012f:
            r2 = r20
            java.lang.String r0 = r8.getQueryParameter(r2)     // Catch:{ JSONException -> 0x0120 }
            r12.put(r2, r0)     // Catch:{ JSONException -> 0x0120 }
            r2 = r19
            java.lang.String r0 = r8.getQueryParameter(r2)     // Catch:{ JSONException -> 0x0120 }
            r12.put(r2, r0)     // Catch:{ JSONException -> 0x0120 }
            r2 = r18
            java.lang.String r0 = r8.getQueryParameter(r2)     // Catch:{ JSONException -> 0x0120 }
            r12.put(r2, r0)     // Catch:{ JSONException -> 0x0120 }
            r2 = r17
            java.lang.String r0 = r8.getQueryParameter(r2)     // Catch:{ JSONException -> 0x0120 }
            r12.put(r2, r0)     // Catch:{ JSONException -> 0x0120 }
            r2 = r16
            java.lang.String r0 = r8.getQueryParameter(r2)     // Catch:{ JSONException -> 0x0120 }
            r12.put(r2, r0)     // Catch:{ JSONException -> 0x0120 }
            r2 = r15
            r12.put(r2, r9)     // Catch:{ JSONException -> 0x0120 }
            if (r5 == 0) goto L_0x0165
            r12.put(r1, r5)     // Catch:{ JSONException -> 0x0120 }
        L_0x0165:
            r1 = r21
            r11.put(r1, r12)     // Catch:{ JSONException -> 0x016b }
            goto L_0x0170
        L_0x016b:
            r0 = move-exception
            goto L_0x0123
        L_0x016d:
            com.zing.zalo.zalosdk.core.log.Log.e((java.lang.String) r2, (java.lang.Exception) r0)
        L_0x0170:
            java.lang.String r0 = r11.toString()
            r10.putExtra(r1, r0)
            java.lang.String r0 = "isWebview"
            r1 = 1
            r10.putExtra(r0, r1)
        L_0x017d:
            com.zing.zalo.zalosdk.oauth.ZaloSDK r0 = com.zing.zalo.zalosdk.oauth.ZaloSDK.Instance
            r2 = 64728(0xfcd8, float:9.0703E-41)
            r4 = 0
            r3 = r25
            r0.onActivityResult(r3, r2, r4, r10)
            return r1
        L_0x0189:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.zalosdk.oauth.BrowserLoginActivity.handleBrowserCallback():boolean");
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (handleBrowserCallback()) {
            finish();
        }
    }
}
