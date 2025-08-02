package d2;

public class a {
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0102 A[SYNTHETIC, Splitter:B:49:0x0102] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010a A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0148 A[SYNTHETIC, Splitter:B:61:0x0148] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0150 A[Catch:{ all -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0189 A[SYNTHETIC, Splitter:B:72:0x0189] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0191 A[Catch:{ all -> 0x018d }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01ad A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ae  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:46:0x00e8=Splitter:B:46:0x00e8, B:58:0x012e=Splitter:B:58:0x012e, B:69:0x016f=Splitter:B:69:0x016f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] a(android.content.Context r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "close failed "
            boolean r9 = u1.n.b(r9)
            r1 = 0
            java.lang.String r2 = "HttpClient"
            if (r9 != 0) goto L_0x0011
            java.lang.String r9 = "can't get, network is disConnected"
            s1.a.a(r2, r9)
            return r1
        L_0x0011:
            java.net.URL r9 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r9.<init>(r10)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            java.net.URLConnection r9 = r9.openConnection()     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            java.lang.String r10 = "GET"
            r9.setRequestMethod(r10)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r10 = 6000(0x1770, float:8.408E-42)
            r9.setConnectTimeout(r10)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r9.setReadTimeout(r10)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            java.lang.String r10 = "Accept-Encoding"
            java.lang.String r3 = "identity"
            r9.setRequestProperty(r10, r3)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            java.lang.String r10 = "Connection"
            java.lang.String r3 = "Close"
            r9.addRequestProperty(r10, r3)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            java.lang.String r10 = "Charset"
            java.lang.String r3 = o1.a.f22951b     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r9.setRequestProperty(r10, r3)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            boolean r10 = r9 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            if (r10 == 0) goto L_0x0075
            java.lang.String r10 = "TLS"
            javax.net.ssl.SSLContext r10 = javax.net.ssl.SSLContext.getInstance(r10)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r10.init(r1, r1, r1)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r3 = r9
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            javax.net.ssl.SSLSocketFactory r10 = r10.getSocketFactory()     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r3.setSSLSocketFactory(r10)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r10 = r9
            javax.net.ssl.HttpsURLConnection r10 = (javax.net.ssl.HttpsURLConnection) r10     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r1.a r3 = new r1.a     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            java.net.URL r4 = r9.getURL()     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            java.lang.String r4 = r4.getHost()     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r3.<init>(r4)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r10.setHostnameVerifier(r3)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            goto L_0x0075
        L_0x0069:
            r9 = move-exception
            r10 = r1
            goto L_0x00e4
        L_0x006d:
            r9 = move-exception
            r10 = r1
            goto L_0x012a
        L_0x0071:
            r9 = move-exception
            r10 = r1
            goto L_0x016b
        L_0x0075:
            r10 = 1
            r9.setDoInput(r10)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r10 = 0
            r9.setUseCaches(r10)     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r9.connect()     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            int r3 = r9.getContentLength()     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            int r4 = r9.getResponseCode()     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto L_0x00bb
            java.io.InputStream r9 = r9.getInputStream()     // Catch:{ MalformedURLException -> 0x0071, IOException -> 0x006d, all -> 0x0069 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ MalformedURLException -> 0x00b5, IOException -> 0x00af, all -> 0x00aa }
            r4.<init>()     // Catch:{ MalformedURLException -> 0x00b5, IOException -> 0x00af, all -> 0x00aa }
            byte[] r3 = new byte[r3]     // Catch:{ MalformedURLException -> 0x00a7, IOException -> 0x00a4, all -> 0x00a2 }
        L_0x0097:
            int r5 = r9.read(r3)     // Catch:{ MalformedURLException -> 0x00a7, IOException -> 0x00a4, all -> 0x00a2 }
            r6 = -1
            if (r5 == r6) goto L_0x00bd
            r4.write(r3, r10, r5)     // Catch:{ MalformedURLException -> 0x00a7, IOException -> 0x00a4, all -> 0x00a2 }
            goto L_0x0097
        L_0x00a2:
            r10 = move-exception
            goto L_0x00e8
        L_0x00a4:
            r10 = move-exception
            goto L_0x012e
        L_0x00a7:
            r10 = move-exception
            goto L_0x016f
        L_0x00aa:
            r10 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00e4
        L_0x00af:
            r10 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x012a
        L_0x00b5:
            r10 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x016b
        L_0x00bb:
            r9 = r1
            r4 = r9
        L_0x00bd:
            if (r4 == 0) goto L_0x00c5
            r4.close()     // Catch:{ all -> 0x00c3 }
            goto L_0x00c5
        L_0x00c3:
            r9 = move-exception
            goto L_0x00cc
        L_0x00c5:
            if (r9 == 0) goto L_0x01ab
            r9.close()     // Catch:{ all -> 0x00c3 }
            goto L_0x01ab
        L_0x00cc:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            s1.a.h(r2, r9)
            goto L_0x01ab
        L_0x00e4:
            r4 = r1
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x00e8:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r3.<init>()     // Catch:{ all -> 0x0127 }
            java.lang.String r5 = "get failed "
            r3.append(r5)     // Catch:{ all -> 0x0127 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x0127 }
            r3.append(r10)     // Catch:{ all -> 0x0127 }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x0127 }
            s1.a.h(r2, r10)     // Catch:{ all -> 0x0127 }
            if (r4 == 0) goto L_0x0108
            r4.close()     // Catch:{ all -> 0x0106 }
            goto L_0x0108
        L_0x0106:
            r9 = move-exception
            goto L_0x010f
        L_0x0108:
            if (r9 == 0) goto L_0x01ab
            r9.close()     // Catch:{ all -> 0x0106 }
            goto L_0x01ab
        L_0x010f:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            s1.a.h(r2, r9)
            goto L_0x01ab
        L_0x0127:
            r10 = move-exception
            goto L_0x01b3
        L_0x012a:
            r4 = r1
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x012e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r3.<init>()     // Catch:{ all -> 0x0127 }
            java.lang.String r5 = "get ioException:"
            r3.append(r5)     // Catch:{ all -> 0x0127 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x0127 }
            r3.append(r10)     // Catch:{ all -> 0x0127 }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x0127 }
            s1.a.h(r2, r10)     // Catch:{ all -> 0x0127 }
            if (r4 == 0) goto L_0x014e
            r4.close()     // Catch:{ all -> 0x014c }
            goto L_0x014e
        L_0x014c:
            r9 = move-exception
            goto L_0x0154
        L_0x014e:
            if (r9 == 0) goto L_0x01ab
            r9.close()     // Catch:{ all -> 0x014c }
            goto L_0x01ab
        L_0x0154:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            s1.a.h(r2, r9)
            goto L_0x01ab
        L_0x016b:
            r4 = r1
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x016f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r3.<init>()     // Catch:{ all -> 0x0127 }
            java.lang.String r5 = "get malformedURLException:"
            r3.append(r5)     // Catch:{ all -> 0x0127 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x0127 }
            r3.append(r10)     // Catch:{ all -> 0x0127 }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x0127 }
            s1.a.h(r2, r10)     // Catch:{ all -> 0x0127 }
            if (r4 == 0) goto L_0x018f
            r4.close()     // Catch:{ all -> 0x018d }
            goto L_0x018f
        L_0x018d:
            r9 = move-exception
            goto L_0x0195
        L_0x018f:
            if (r9 == 0) goto L_0x01ab
            r9.close()     // Catch:{ all -> 0x018d }
            goto L_0x01ab
        L_0x0195:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            s1.a.h(r2, r9)
        L_0x01ab:
            if (r4 != 0) goto L_0x01ae
            return r1
        L_0x01ae:
            byte[] r9 = r4.toByteArray()
            return r9
        L_0x01b3:
            if (r4 == 0) goto L_0x01bb
            r4.close()     // Catch:{ all -> 0x01b9 }
            goto L_0x01bb
        L_0x01b9:
            r9 = move-exception
            goto L_0x01c1
        L_0x01bb:
            if (r9 == 0) goto L_0x01d7
            r9.close()     // Catch:{ all -> 0x01b9 }
            goto L_0x01d7
        L_0x01c1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r9 = r9.getMessage()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            s1.a.h(r2, r9)
        L_0x01d7:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.a.a(android.content.Context, java.lang.String):byte[]");
    }
}
