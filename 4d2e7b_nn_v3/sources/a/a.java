package a;

public abstract class a {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.io.ObjectOutputStream} */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x009b, code lost:
        if (r5 != null) goto L_0x009d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005f A[SYNTHETIC, Splitter:B:38:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0064 A[Catch:{ IOException -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0069 A[Catch:{ IOException -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x006e A[Catch:{ IOException -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0078 A[SYNTHETIC, Splitter:B:52:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x007d A[Catch:{ IOException -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0082 A[Catch:{ IOException -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0087 A[Catch:{ IOException -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x008e A[Catch:{ IOException -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0093 A[Catch:{ IOException -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0098 A[Catch:{ IOException -> 0x00a0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object a(java.lang.Object r5) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0088, ClassNotFoundException -> 0x0072, all -> 0x0058 }
            r1.<init>()     // Catch:{ IOException -> 0x0088, ClassNotFoundException -> 0x0072, all -> 0x0058 }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0054, ClassNotFoundException -> 0x0050, all -> 0x004b }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0054, ClassNotFoundException -> 0x0050, all -> 0x004b }
            r2.writeObject(r5)     // Catch:{ IOException -> 0x0048, ClassNotFoundException -> 0x0045, all -> 0x003f }
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0048, ClassNotFoundException -> 0x0045, all -> 0x003f }
            byte[] r3 = r1.toByteArray()     // Catch:{ IOException -> 0x0048, ClassNotFoundException -> 0x0045, all -> 0x003f }
            r5.<init>(r3)     // Catch:{ IOException -> 0x0048, ClassNotFoundException -> 0x0045, all -> 0x003f }
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x0039, all -> 0x0033 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x0039, all -> 0x0033 }
            java.lang.Object r0 = r3.readObject()     // Catch:{ IOException -> 0x008c, ClassNotFoundException -> 0x0076, all -> 0x002e }
            r2.close()     // Catch:{ IOException -> 0x00a0 }
            r3.close()     // Catch:{ IOException -> 0x00a0 }
            r1.close()     // Catch:{ IOException -> 0x00a0 }
            r5.close()     // Catch:{ IOException -> 0x00a0 }
            goto L_0x00a0
        L_0x002e:
            r0 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
            goto L_0x005d
        L_0x0033:
            r3 = move-exception
            r4 = r3
            r3 = r0
            r0 = r2
            r2 = r4
            goto L_0x005d
        L_0x0039:
            r3 = r0
            goto L_0x0076
        L_0x003c:
            r3 = r0
            goto L_0x008c
        L_0x003f:
            r5 = move-exception
            r3 = r0
            r0 = r2
            r2 = r5
            r5 = r3
            goto L_0x005d
        L_0x0045:
            r5 = r0
            r3 = r5
            goto L_0x0076
        L_0x0048:
            r5 = r0
            r3 = r5
            goto L_0x008c
        L_0x004b:
            r5 = move-exception
            r2 = r5
            r5 = r0
            r3 = r5
            goto L_0x005d
        L_0x0050:
            r5 = r0
            r2 = r5
        L_0x0052:
            r3 = r2
            goto L_0x0076
        L_0x0054:
            r5 = r0
            r2 = r5
        L_0x0056:
            r3 = r2
            goto L_0x008c
        L_0x0058:
            r5 = move-exception
            r2 = r5
            r5 = r0
            r1 = r5
            r3 = r1
        L_0x005d:
            if (r0 == 0) goto L_0x0062
            r0.close()     // Catch:{ IOException -> 0x0071 }
        L_0x0062:
            if (r3 == 0) goto L_0x0067
            r3.close()     // Catch:{ IOException -> 0x0071 }
        L_0x0067:
            if (r1 == 0) goto L_0x006c
            r1.close()     // Catch:{ IOException -> 0x0071 }
        L_0x006c:
            if (r5 == 0) goto L_0x0071
            r5.close()     // Catch:{ IOException -> 0x0071 }
        L_0x0071:
            throw r2
        L_0x0072:
            r5 = r0
            r1 = r5
            r2 = r1
            goto L_0x0052
        L_0x0076:
            if (r2 == 0) goto L_0x007b
            r2.close()     // Catch:{ IOException -> 0x00a0 }
        L_0x007b:
            if (r3 == 0) goto L_0x0080
            r3.close()     // Catch:{ IOException -> 0x00a0 }
        L_0x0080:
            if (r1 == 0) goto L_0x0085
            r1.close()     // Catch:{ IOException -> 0x00a0 }
        L_0x0085:
            if (r5 == 0) goto L_0x00a0
            goto L_0x009d
        L_0x0088:
            r5 = r0
            r1 = r5
            r2 = r1
            goto L_0x0056
        L_0x008c:
            if (r2 == 0) goto L_0x0091
            r2.close()     // Catch:{ IOException -> 0x00a0 }
        L_0x0091:
            if (r3 == 0) goto L_0x0096
            r3.close()     // Catch:{ IOException -> 0x00a0 }
        L_0x0096:
            if (r1 == 0) goto L_0x009b
            r1.close()     // Catch:{ IOException -> 0x00a0 }
        L_0x009b:
            if (r5 == 0) goto L_0x00a0
        L_0x009d:
            r5.close()     // Catch:{ IOException -> 0x00a0 }
        L_0x00a0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a(java.lang.Object):java.lang.Object");
    }
}
