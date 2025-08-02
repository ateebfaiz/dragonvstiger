package g1;

public abstract class p {
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f1, code lost:
        if (r7 == null) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f3, code lost:
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0118, code lost:
        if (r7 == null) goto L_0x011e;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:40:0x00d0=Splitter:B:40:0x00d0, B:46:0x00f7=Splitter:B:46:0x00f7} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r5, java.lang.String r6, java.lang.String r7, byte[] r8) {
        /*
            java.lang.String r0 = "HttpClient"
            r1 = -1
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x00cc, all -> 0x00c8 }
            r3.<init>(r6)     // Catch:{ SocketTimeoutException -> 0x00cc, all -> 0x00c8 }
            java.net.URLConnection r6 = r3.openConnection()     // Catch:{ SocketTimeoutException -> 0x00cc, all -> 0x00c8 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ SocketTimeoutException -> 0x00cc, all -> 0x00c8 }
            java.lang.String r3 = "POST"
            r6.setRequestMethod(r3)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r3 = 6000(0x1770, float:8.408E-42)
            r6.setConnectTimeout(r3)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r6.setReadTimeout(r3)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            java.lang.String r3 = "Authorization"
            r6.setRequestProperty(r3, r7)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            java.lang.String r7 = "Charset"
            java.lang.String r3 = o1.a.f22951b     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r6.setRequestProperty(r7, r3)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            java.lang.String r7 = "Accept"
            java.lang.String r3 = "application/jason"
            r6.setRequestProperty(r7, r3)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            java.lang.String r7 = "Accept-Encoding"
            java.lang.String r3 = "gzip"
            r6.setRequestProperty(r7, r3)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            java.lang.String r7 = "content-type"
            java.lang.String r3 = "application/octet-stream"
            r6.setRequestProperty(r7, r3)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            java.lang.String r7 = "Content-Length"
            int r3 = r8.length     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r6.setRequestProperty(r7, r3)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            java.lang.String r7 = "X-App-Key"
            java.lang.String r5 = p1.a.b(r5)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r6.setRequestProperty(r7, r5)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            int r5 = p1.a.o()     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r7 = 2
            if (r5 != r7) goto L_0x005a
            java.lang.String r5 = "SM4"
            goto L_0x005c
        L_0x005a:
            java.lang.String r5 = ""
        L_0x005c:
            java.lang.String r7 = "Encrypt-Type"
            r6.setRequestProperty(r7, r5)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            boolean r5 = r6 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            if (r5 == 0) goto L_0x0095
            java.lang.String r5 = "TLS"
            javax.net.ssl.SSLContext r5 = javax.net.ssl.SSLContext.getInstance(r5)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r5.init(r2, r2, r2)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r7 = r6
            javax.net.ssl.HttpsURLConnection r7 = (javax.net.ssl.HttpsURLConnection) r7     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            javax.net.ssl.SSLSocketFactory r5 = r5.getSocketFactory()     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r7.setSSLSocketFactory(r5)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r5 = r6
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r1.a r7 = new r1.a     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            java.net.URL r3 = r6.getURL()     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            java.lang.String r3 = r3.getHost()     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r7.<init>(r3)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r5.setHostnameVerifier(r7)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            goto L_0x0095
        L_0x008c:
            r5 = move-exception
            r7 = r6
            r6 = r2
            goto L_0x00d0
        L_0x0090:
            r5 = move-exception
            r7 = r6
            r6 = r2
            goto L_0x00f7
        L_0x0095:
            r5 = 1
            r6.setDoInput(r5)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r6.setDoOutput(r5)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r5 = 0
            r6.setUseCaches(r5)     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            java.io.OutputStream r5 = r6.getOutputStream()     // Catch:{ SocketTimeoutException -> 0x0090, all -> 0x008c }
            r5.write(r8)     // Catch:{ SocketTimeoutException -> 0x00c2, all -> 0x00bc }
            r5.flush()     // Catch:{ SocketTimeoutException -> 0x00c2, all -> 0x00bc }
            r6.connect()     // Catch:{ SocketTimeoutException -> 0x00c2, all -> 0x00bc }
            int r1 = r6.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x00c2, all -> 0x00bc }
            u1.o.a(r5)
            u1.o.a(r2)
            u1.o.a(r2)
            goto L_0x011b
        L_0x00bc:
            r7 = move-exception
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L_0x00d0
        L_0x00c2:
            r7 = move-exception
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L_0x00f7
        L_0x00c8:
            r5 = move-exception
            r6 = r2
            r7 = r6
            goto L_0x00d0
        L_0x00cc:
            r5 = move-exception
            r6 = r2
            r7 = r6
            goto L_0x00f7
        L_0x00d0:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
            r8.<init>()     // Catch:{ all -> 0x00f5 }
            java.lang.String r3 = "post failed "
            r8.append(r3)     // Catch:{ all -> 0x00f5 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x00f5 }
            r8.append(r5)     // Catch:{ all -> 0x00f5 }
            java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x00f5 }
            s1.a.h(r0, r5)     // Catch:{ all -> 0x00f5 }
            u1.o.a(r6)
            u1.o.a(r2)
            u1.o.a(r2)
            if (r7 == 0) goto L_0x011e
        L_0x00f3:
            r6 = r7
            goto L_0x011b
        L_0x00f5:
            r5 = move-exception
            goto L_0x011f
        L_0x00f7:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
            r8.<init>()     // Catch:{ all -> 0x00f5 }
            java.lang.String r3 = "post socketTimeoutException:"
            r8.append(r3)     // Catch:{ all -> 0x00f5 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x00f5 }
            r8.append(r5)     // Catch:{ all -> 0x00f5 }
            java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x00f5 }
            s1.a.h(r0, r5)     // Catch:{ all -> 0x00f5 }
            u1.o.a(r6)
            u1.o.a(r2)
            u1.o.a(r2)
            if (r7 == 0) goto L_0x011e
            goto L_0x00f3
        L_0x011b:
            r6.disconnect()
        L_0x011e:
            return r1
        L_0x011f:
            u1.o.a(r6)
            u1.o.a(r2)
            u1.o.a(r2)
            if (r7 == 0) goto L_0x012d
            r7.disconnect()
        L_0x012d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.p.a(android.content.Context, java.lang.String, java.lang.String, byte[]):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0120 A[SYNTHETIC, Splitter:B:64:0x0120] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0128 A[Catch:{ all -> 0x0124 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0163 A[SYNTHETIC, Splitter:B:76:0x0163] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x016b A[Catch:{ all -> 0x0167 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01a1 A[SYNTHETIC, Splitter:B:87:0x01a1] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01a9 A[Catch:{ all -> 0x01a5 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:61:0x0106=Splitter:B:61:0x0106, B:84:0x0187=Splitter:B:84:0x0187, B:73:0x0149=Splitter:B:73:0x0149} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "close failed "
            boolean r7 = u1.n.b(r7)
            r1 = 0
            java.lang.String r2 = "HttpClient"
            if (r7 != 0) goto L_0x0011
            java.lang.String r7 = "can't get, network is disConnected"
            s1.a.a(r2, r7)
            return r1
        L_0x0011:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r3 = "requestUrl:"
            r7.append(r3)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            s1.a.a(r2, r7)
            java.net.URL r7 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            r7.<init>(r8)     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            java.lang.String r8 = "GET"
            r7.setRequestMethod(r8)     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            r8 = 6000(0x1770, float:8.408E-42)
            r7.setConnectTimeout(r8)     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            r7.setReadTimeout(r8)     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            java.lang.String r8 = "Authorization"
            r7.setRequestProperty(r8, r9)     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            java.lang.String r8 = "Charset"
            java.lang.String r9 = o1.a.f22951b     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            r7.setRequestProperty(r8, r9)     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            boolean r8 = r7 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            if (r8 == 0) goto L_0x0086
            java.lang.String r8 = "TLS"
            javax.net.ssl.SSLContext r8 = javax.net.ssl.SSLContext.getInstance(r8)     // Catch:{ MalformedURLException -> 0x0078, IOException -> 0x0076, all -> 0x0074 }
            r8.init(r1, r1, r1)     // Catch:{ MalformedURLException -> 0x0078, IOException -> 0x0076, all -> 0x0074 }
            r9 = r7
            javax.net.ssl.HttpsURLConnection r9 = (javax.net.ssl.HttpsURLConnection) r9     // Catch:{ MalformedURLException -> 0x0078, IOException -> 0x0076, all -> 0x0074 }
            javax.net.ssl.SSLSocketFactory r8 = r8.getSocketFactory()     // Catch:{ MalformedURLException -> 0x0078, IOException -> 0x0076, all -> 0x0074 }
            r9.setSSLSocketFactory(r8)     // Catch:{ MalformedURLException -> 0x0078, IOException -> 0x0076, all -> 0x0074 }
            r8 = r7
            javax.net.ssl.HttpsURLConnection r8 = (javax.net.ssl.HttpsURLConnection) r8     // Catch:{ MalformedURLException -> 0x0078, IOException -> 0x0076, all -> 0x0074 }
            r1.a r9 = new r1.a     // Catch:{ MalformedURLException -> 0x0078, IOException -> 0x0076, all -> 0x0074 }
            java.net.URL r3 = r7.getURL()     // Catch:{ MalformedURLException -> 0x0078, IOException -> 0x0076, all -> 0x0074 }
            java.lang.String r3 = r3.getHost()     // Catch:{ MalformedURLException -> 0x0078, IOException -> 0x0076, all -> 0x0074 }
            r9.<init>(r3)     // Catch:{ MalformedURLException -> 0x0078, IOException -> 0x0076, all -> 0x0074 }
            r8.setHostnameVerifier(r9)     // Catch:{ MalformedURLException -> 0x0078, IOException -> 0x0076, all -> 0x0074 }
            goto L_0x0086
        L_0x0074:
            r7 = move-exception
            goto L_0x007a
        L_0x0076:
            r7 = move-exception
            goto L_0x007e
        L_0x0078:
            r7 = move-exception
            goto L_0x0082
        L_0x007a:
            r8 = r1
            r9 = r8
            goto L_0x0106
        L_0x007e:
            r8 = r1
            r9 = r8
            goto L_0x0149
        L_0x0082:
            r8 = r1
            r9 = r8
            goto L_0x0187
        L_0x0086:
            r8 = 1
            r7.setDoInput(r8)     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            r8 = 0
            r7.setUseCaches(r8)     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            r7.connect()     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            r7.getContentLength()     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            int r9 = r7.getResponseCode()     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            r3 = 200(0xc8, float:2.8E-43)
            if (r9 != r3) goto L_0x01c3
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ MalformedURLException -> 0x0101, IOException -> 0x00fe, all -> 0x00fb }
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ MalformedURLException -> 0x00f5, IOException -> 0x00f0, all -> 0x00eb }
            r9.<init>()     // Catch:{ MalformedURLException -> 0x00f5, IOException -> 0x00f0, all -> 0x00eb }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ MalformedURLException -> 0x00b8, IOException -> 0x00b6, all -> 0x00b4 }
        L_0x00a9:
            int r4 = r7.read(r3)     // Catch:{ MalformedURLException -> 0x00b8, IOException -> 0x00b6, all -> 0x00b4 }
            r5 = -1
            if (r4 == r5) goto L_0x00ba
            r9.write(r3, r8, r4)     // Catch:{ MalformedURLException -> 0x00b8, IOException -> 0x00b6, all -> 0x00b4 }
            goto L_0x00a9
        L_0x00b4:
            r8 = move-exception
            goto L_0x00dd
        L_0x00b6:
            r8 = move-exception
            goto L_0x00e1
        L_0x00b8:
            r8 = move-exception
            goto L_0x00e6
        L_0x00ba:
            byte[] r8 = r9.toByteArray()     // Catch:{ MalformedURLException -> 0x00b8, IOException -> 0x00b6, all -> 0x00b4 }
            r9.close()     // Catch:{ all -> 0x00c5 }
            r7.close()     // Catch:{ all -> 0x00c5 }
            goto L_0x00dc
        L_0x00c5:
            r7 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r7 = r7.getMessage()
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            s1.a.h(r2, r7)
        L_0x00dc:
            return r8
        L_0x00dd:
            r6 = r8
            r8 = r7
            r7 = r6
            goto L_0x0106
        L_0x00e1:
            r6 = r8
            r8 = r7
            r7 = r6
            goto L_0x0149
        L_0x00e6:
            r6 = r8
            r8 = r7
            r7 = r6
            goto L_0x0187
        L_0x00eb:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            goto L_0x0105
        L_0x00f0:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            goto L_0x0148
        L_0x00f5:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            goto L_0x0186
        L_0x00fb:
            r7 = move-exception
            r8 = r1
            goto L_0x0105
        L_0x00fe:
            r7 = move-exception
            r8 = r1
            goto L_0x0148
        L_0x0101:
            r7 = move-exception
            r8 = r1
            goto L_0x0186
        L_0x0105:
            r9 = r1
        L_0x0106:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0145 }
            r3.<init>()     // Catch:{ all -> 0x0145 }
            java.lang.String r4 = "get failed "
            r3.append(r4)     // Catch:{ all -> 0x0145 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0145 }
            r3.append(r7)     // Catch:{ all -> 0x0145 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0145 }
            s1.a.h(r2, r7)     // Catch:{ all -> 0x0145 }
            if (r9 == 0) goto L_0x0126
            r9.close()     // Catch:{ all -> 0x0124 }
            goto L_0x0126
        L_0x0124:
            r7 = move-exception
            goto L_0x012d
        L_0x0126:
            if (r8 == 0) goto L_0x01c3
            r8.close()     // Catch:{ all -> 0x0124 }
            goto L_0x01c3
        L_0x012d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            s1.a.h(r2, r7)
            goto L_0x01c3
        L_0x0145:
            r7 = move-exception
            goto L_0x01c4
        L_0x0148:
            r9 = r1
        L_0x0149:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0145 }
            r3.<init>()     // Catch:{ all -> 0x0145 }
            java.lang.String r4 = "get ioException:"
            r3.append(r4)     // Catch:{ all -> 0x0145 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0145 }
            r3.append(r7)     // Catch:{ all -> 0x0145 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0145 }
            s1.a.h(r2, r7)     // Catch:{ all -> 0x0145 }
            if (r9 == 0) goto L_0x0169
            r9.close()     // Catch:{ all -> 0x0167 }
            goto L_0x0169
        L_0x0167:
            r7 = move-exception
            goto L_0x016f
        L_0x0169:
            if (r8 == 0) goto L_0x01c3
            r8.close()     // Catch:{ all -> 0x0167 }
            goto L_0x01c3
        L_0x016f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            s1.a.h(r2, r7)
            goto L_0x01c3
        L_0x0186:
            r9 = r1
        L_0x0187:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0145 }
            r3.<init>()     // Catch:{ all -> 0x0145 }
            java.lang.String r4 = "get malformedURLException:"
            r3.append(r4)     // Catch:{ all -> 0x0145 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0145 }
            r3.append(r7)     // Catch:{ all -> 0x0145 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0145 }
            s1.a.h(r2, r7)     // Catch:{ all -> 0x0145 }
            if (r9 == 0) goto L_0x01a7
            r9.close()     // Catch:{ all -> 0x01a5 }
            goto L_0x01a7
        L_0x01a5:
            r7 = move-exception
            goto L_0x01ad
        L_0x01a7:
            if (r8 == 0) goto L_0x01c3
            r8.close()     // Catch:{ all -> 0x01a5 }
            goto L_0x01c3
        L_0x01ad:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            s1.a.h(r2, r7)
        L_0x01c3:
            return r1
        L_0x01c4:
            if (r9 == 0) goto L_0x01cc
            r9.close()     // Catch:{ all -> 0x01ca }
            goto L_0x01cc
        L_0x01ca:
            r8 = move-exception
            goto L_0x01d2
        L_0x01cc:
            if (r8 == 0) goto L_0x01e8
            r8.close()     // Catch:{ all -> 0x01ca }
            goto L_0x01e8
        L_0x01d2:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r8 = r8.getMessage()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            s1.a.h(r2, r8)
        L_0x01e8:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.p.b(android.content.Context, java.lang.String, java.lang.String):byte[]");
    }
}
