package com.linecorp.linesdk.auth.internal;

class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f10068a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10069b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10070c;

    public b(int i10, int i11, int i12) {
        this.f10068a = i10;
        this.f10069b = i11;
        this.f10070c = i12;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.linecorp.linesdk.auth.internal.b a(android.content.Context r4) {
        /*
            r0 = 0
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{  }
            java.lang.String r1 = "jp.naver.line.android"
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r1, r2)     // Catch:{  }
            java.lang.String r4 = r4.versionName
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L_0x0016
            return r0
        L_0x0016:
            java.util.StringTokenizer r1 = new java.util.StringTokenizer
            java.lang.String r2 = "."
            r1.<init>(r4, r2)
            com.linecorp.linesdk.auth.internal.b r4 = new com.linecorp.linesdk.auth.internal.b     // Catch:{ NameNotFoundException -> 0x003b }
            java.lang.String r2 = r1.nextToken()     // Catch:{ NameNotFoundException -> 0x003b }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NameNotFoundException -> 0x003b }
            java.lang.String r3 = r1.nextToken()     // Catch:{ NameNotFoundException -> 0x003b }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NameNotFoundException -> 0x003b }
            java.lang.String r1 = r1.nextToken()     // Catch:{ NameNotFoundException -> 0x003b }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NameNotFoundException -> 0x003b }
            r4.<init>(r2, r3, r1)     // Catch:{ NameNotFoundException -> 0x003b }
            return r4
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.linecorp.linesdk.auth.internal.b.a(android.content.Context):com.linecorp.linesdk.auth.internal.b");
    }

    public boolean b(b bVar) {
        if (bVar == null) {
            return false;
        }
        int i10 = this.f10068a;
        int i11 = bVar.f10068a;
        if (i10 == i11) {
            int i12 = this.f10069b;
            int i13 = bVar.f10069b;
            if (i12 != i13) {
                if (i12 >= i13) {
                    return true;
                }
                return false;
            } else if (this.f10070c >= bVar.f10070c) {
                return true;
            } else {
                return false;
            }
        } else if (i10 >= i11) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f10068a == bVar.f10068a && this.f10069b == bVar.f10069b && this.f10070c == bVar.f10070c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f10068a * 31) + this.f10069b) * 31) + this.f10070c;
    }
}
