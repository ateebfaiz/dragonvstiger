package com.facebook.react.views.text.frescosupport;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.Locale;
import t3.b;
import w7.i;

class a extends v7.a {
    private Uri A;
    private ReadableMap B;
    private final b C;
    private final Object D;
    private float E = Float.NaN;
    private String F;
    private float G = Float.NaN;
    private int H = 0;

    public a(b bVar, Object obj) {
        this.C = bVar;
        this.D = obj;
    }

    private static Uri A1(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return new Uri.Builder().scheme("res").path(String.valueOf(context.getResources().getIdentifier(str.toLowerCase(Locale.getDefault()).replace("-", "_"), "drawable", context.getPackageName()))).build();
    }

    public Uri B1() {
        return this.A;
    }

    @h7.a(name = "headers")
    public void setHeaders(ReadableMap readableMap) {
        this.B = readableMap;
    }

    public void setHeight(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Number) {
            this.G = (float) dynamic.asDouble();
            return;
        }
        z2.a.G("ReactNative", "Inline images must not have percentage based height");
        this.G = Float.NaN;
    }

    @h7.a(name = "resizeMode")
    public void setResizeMode(@Nullable String str) {
        this.F = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r1.getScheme() == null) goto L_0x0025;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
    @h7.a(name = "src")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSource(@androidx.annotation.Nullable com.facebook.react.bridge.ReadableArray r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0016
            int r1 = r4.size()
            if (r1 != 0) goto L_0x000a
            goto L_0x0016
        L_0x000a:
            r1 = 0
            com.facebook.react.bridge.ReadableMap r4 = r4.getMap(r1)
            java.lang.String r1 = "uri"
            java.lang.String r4 = r4.getString(r1)
            goto L_0x0017
        L_0x0016:
            r4 = r0
        L_0x0017:
            if (r4 == 0) goto L_0x002f
            android.net.Uri r1 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r2 = r1.getScheme()     // Catch:{ Exception -> 0x0024 }
            if (r2 != 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r0 = r1
        L_0x0025:
            if (r0 != 0) goto L_0x002f
            com.facebook.react.uimanager.e1 r0 = r3.F()
            android.net.Uri r0 = A1(r0, r4)
        L_0x002f:
            android.net.Uri r4 = r3.A
            if (r0 == r4) goto L_0x0036
            r3.x0()
        L_0x0036:
            r3.A = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.frescosupport.a.setSource(com.facebook.react.bridge.ReadableArray):void");
    }

    @h7.a(customType = "Color", name = "tintColor")
    public void setTintColor(int i10) {
        this.H = i10;
    }

    public void setWidth(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Number) {
            this.E = (float) dynamic.asDouble();
            return;
        }
        z2.a.G("ReactNative", "Inline images must not have percentage based width");
        this.E = Float.NaN;
    }

    public boolean t() {
        return true;
    }

    public i w1() {
        return new b(F().getResources(), (int) Math.ceil((double) this.G), (int) Math.ceil((double) this.E), this.H, B1(), z1(), y1(), x1(), this.F);
    }

    public Object x1() {
        return this.D;
    }

    public b y1() {
        return this.C;
    }

    public ReadableMap z1() {
        return this.B;
    }
}
