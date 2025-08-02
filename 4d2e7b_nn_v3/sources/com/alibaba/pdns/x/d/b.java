package com.alibaba.pdns.x.d;

import android.text.TextUtils;
import com.alibaba.pdns.x.a;
import java.net.InetSocketAddress;

public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    private static final int f18294b = 5;

    /* renamed from: c  reason: collision with root package name */
    private static final String f18295c = "DNS解析正常,连接超时,TCP建立失败";

    /* renamed from: d  reason: collision with root package name */
    private static final String f18296d = "DNS解析正常,IO异常,TCP建立失败";

    /* renamed from: e  reason: collision with root package name */
    private static final String f18297e = "DNS解析失败,主机地址不可达";

    /* renamed from: f  reason: collision with root package name */
    private static final String f18298f = "b";

    /* renamed from: a  reason: collision with root package name */
    private int f18299a = 5000;

    private float b(String str, int i10) {
        boolean z10;
        if (!TextUtils.isEmpty(str)) {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i10);
            float[] fArr = new float[5];
            String str2 = f18298f;
            com.alibaba.pdns.u.a.b(str2, "-----------------------------------------------------");
            com.alibaba.pdns.u.a.c(str2, "Connect to host: " + str + "...\n");
            int i11 = 0;
            while (true) {
                if (i11 >= 5) {
                    z10 = false;
                    break;
                }
                a(inetSocketAddress, fArr, this.f18299a, i11);
                float f10 = fArr[i11];
                if (f10 == -1.0f) {
                    String str3 = f18298f;
                    com.alibaba.pdns.u.a.c(str3, (i11 + 1) + "'s time=TimeOut,  \n");
                    com.alibaba.pdns.u.a.c(str3, "DNS解析正常,连接超时,TCP建立失败\n");
                    this.f18299a = this.f18299a + 4000;
                    if (i11 > 0 && fArr[i11 - 1] == -1.0f) {
                        z10 = true;
                        break;
                    }
                } else if (f10 == -2.0f) {
                    com.alibaba.pdns.u.a.c(f18298f, (i11 + 1) + "'s time=IOException\n");
                    if (i11 > 0 && fArr[i11 - 1] == -2.0f) {
                        z10 = true;
                        break;
                    }
                } else {
                    com.alibaba.pdns.u.a.c(f18298f, (i11 + 1) + "'s time=" + fArr[i11] + "ms,  \n");
                }
                i11++;
            }
            if (z10) {
                com.alibaba.pdns.u.a.c(f18298f, f18295c);
            } else if (z10) {
                com.alibaba.pdns.u.a.c(f18298f, f18296d);
            } else {
                int i12 = 0;
                float f11 = 0.0f;
                for (int i13 = 0; i13 < 5; i13++) {
                    float f12 = fArr[i13];
                    if (f12 > 0.0f) {
                        f11 += f12;
                        i12++;
                    }
                }
                if (i12 > 0) {
                    float f13 = f11 / ((float) i12);
                    com.alibaba.pdns.u.a.c(f18298f, "average=" + f13 + "ms\n");
                    return f13;
                }
            }
        } else {
            com.alibaba.pdns.u.a.c(f18298f, f18297e);
        }
        return -1.0f;
    }

    public float a(String str, int i10) {
        return b(str, i10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0062, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d A[Catch:{ all -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0042 A[SYNTHETIC, Splitter:B:25:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0054 A[Catch:{ all -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0059 A[SYNTHETIC, Splitter:B:36:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0068 A[SYNTHETIC, Splitter:B:43:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.net.InetSocketAddress r7, float[] r8, int r9, int r10) {
        /*
            r6 = this;
            r0 = 0
            java.net.Socket r1 = new java.net.Socket     // Catch:{ SocketTimeoutException -> 0x0033, IOException -> 0x0031 }
            r1.<init>()     // Catch:{ SocketTimeoutException -> 0x0033, IOException -> 0x0031 }
            long r2 = java.lang.System.nanoTime()     // Catch:{ SocketTimeoutException -> 0x0027, IOException -> 0x0025, all -> 0x0023 }
            r1.connect(r7, r9)     // Catch:{ SocketTimeoutException -> 0x0027, IOException -> 0x0025, all -> 0x0023 }
            long r4 = java.lang.System.nanoTime()     // Catch:{ SocketTimeoutException -> 0x0027, IOException -> 0x0025, all -> 0x0023 }
            long r4 = r4 - r2
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r4 / r2
            float r7 = (float) r4     // Catch:{ SocketTimeoutException -> 0x0027, IOException -> 0x0025, all -> 0x0023 }
            r8[r10] = r7     // Catch:{ SocketTimeoutException -> 0x0027, IOException -> 0x0025, all -> 0x0023 }
            r1.close()     // Catch:{ IOException -> 0x001d }
            goto L_0x0065
        L_0x001d:
            r7 = move-exception
            boolean r8 = com.alibaba.pdns.u.a.f18279a
            if (r8 == 0) goto L_0x0065
            goto L_0x0062
        L_0x0023:
            r7 = move-exception
            goto L_0x0029
        L_0x0025:
            r7 = move-exception
            goto L_0x002b
        L_0x0027:
            r7 = move-exception
            goto L_0x002d
        L_0x0029:
            r0 = r1
            goto L_0x0066
        L_0x002b:
            r0 = r1
            goto L_0x0035
        L_0x002d:
            r0 = r1
            goto L_0x004c
        L_0x002f:
            r7 = move-exception
            goto L_0x0066
        L_0x0031:
            r7 = move-exception
            goto L_0x0035
        L_0x0033:
            r7 = move-exception
            goto L_0x004c
        L_0x0035:
            r9 = -1073741824(0xffffffffc0000000, float:-2.0)
            r8[r10] = r9     // Catch:{ all -> 0x002f }
            boolean r8 = com.alibaba.pdns.u.a.f18279a     // Catch:{ all -> 0x002f }
            if (r8 == 0) goto L_0x0040
            r7.printStackTrace()     // Catch:{ all -> 0x002f }
        L_0x0040:
            if (r0 == 0) goto L_0x0065
            r0.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x0065
        L_0x0046:
            r7 = move-exception
            boolean r8 = com.alibaba.pdns.u.a.f18279a
            if (r8 == 0) goto L_0x0065
            goto L_0x0062
        L_0x004c:
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            r8[r10] = r9     // Catch:{ all -> 0x002f }
            boolean r8 = com.alibaba.pdns.u.a.f18279a     // Catch:{ all -> 0x002f }
            if (r8 == 0) goto L_0x0057
            r7.printStackTrace()     // Catch:{ all -> 0x002f }
        L_0x0057:
            if (r0 == 0) goto L_0x0065
            r0.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0065
        L_0x005d:
            r7 = move-exception
            boolean r8 = com.alibaba.pdns.u.a.f18279a
            if (r8 == 0) goto L_0x0065
        L_0x0062:
            r7.printStackTrace()
        L_0x0065:
            return
        L_0x0066:
            if (r0 == 0) goto L_0x0074
            r0.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x0074
        L_0x006c:
            r8 = move-exception
            boolean r9 = com.alibaba.pdns.u.a.f18279a
            if (r9 == 0) goto L_0x0074
            r8.printStackTrace()
        L_0x0074:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.x.d.b.a(java.net.InetSocketAddress, float[], int, int):void");
    }
}
