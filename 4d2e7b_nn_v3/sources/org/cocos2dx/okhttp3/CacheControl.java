package org.cocos2dx.okhttp3;

import java.util.concurrent.TimeUnit;

public final class CacheControl {
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    public static final class Builder {
        boolean immutable;
        int maxAgeSeconds = -1;
        int maxStaleSeconds = -1;
        int minFreshSeconds = -1;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public CacheControl build() {
            return new CacheControl(this);
        }

        public Builder immutable() {
            this.immutable = true;
            return this;
        }

        public Builder maxAge(int i10, TimeUnit timeUnit) {
            int i11;
            if (i10 >= 0) {
                long seconds = timeUnit.toSeconds((long) i10);
                if (seconds > 2147483647L) {
                    i11 = Integer.MAX_VALUE;
                } else {
                    i11 = (int) seconds;
                }
                this.maxAgeSeconds = i11;
                return this;
            }
            throw new IllegalArgumentException("maxAge < 0: " + i10);
        }

        public Builder maxStale(int i10, TimeUnit timeUnit) {
            int i11;
            if (i10 >= 0) {
                long seconds = timeUnit.toSeconds((long) i10);
                if (seconds > 2147483647L) {
                    i11 = Integer.MAX_VALUE;
                } else {
                    i11 = (int) seconds;
                }
                this.maxStaleSeconds = i11;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i10);
        }

        public Builder minFresh(int i10, TimeUnit timeUnit) {
            int i11;
            if (i10 >= 0) {
                long seconds = timeUnit.toSeconds((long) i10);
                if (seconds > 2147483647L) {
                    i11 = Integer.MAX_VALUE;
                } else {
                    i11 = (int) seconds;
                }
                this.minFreshSeconds = i11;
                return this;
            }
            throw new IllegalArgumentException("minFresh < 0: " + i10);
        }

        public Builder noCache() {
            this.noCache = true;
            return this;
        }

        public Builder noStore() {
            this.noStore = true;
            return this;
        }

        public Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    private CacheControl(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str) {
        this.noCache = z10;
        this.noStore = z11;
        this.maxAgeSeconds = i10;
        this.sMaxAgeSeconds = i11;
        this.isPrivate = z12;
        this.isPublic = z13;
        this.mustRevalidate = z14;
        this.maxStaleSeconds = i12;
        this.minFreshSeconds = i13;
        this.onlyIfCached = z15;
        this.noTransform = z16;
        this.immutable = z17;
        this.headerValue = str;
    }

    private String headerValue() {
        StringBuilder sb2 = new StringBuilder();
        if (this.noCache) {
            sb2.append("no-cache, ");
        }
        if (this.noStore) {
            sb2.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb2.append("max-age=");
            sb2.append(this.maxAgeSeconds);
            sb2.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.sMaxAgeSeconds);
            sb2.append(", ");
        }
        if (this.isPrivate) {
            sb2.append("private, ");
        }
        if (this.isPublic) {
            sb2.append("public, ");
        }
        if (this.mustRevalidate) {
            sb2.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb2.append("max-stale=");
            sb2.append(this.maxStaleSeconds);
            sb2.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.minFreshSeconds);
            sb2.append(", ");
        }
        if (this.onlyIfCached) {
            sb2.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb2.append("no-transform, ");
        }
        if (this.immutable) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        return sb2.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.cocos2dx.okhttp3.CacheControl parse(org.cocos2dx.okhttp3.Headers r22) {
        /*
            r0 = r22
            int r1 = r22.size()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x001a:
            if (r6 >= r1) goto L_0x0147
            java.lang.String r2 = r0.name(r6)
            java.lang.String r5 = r0.value(r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0032
            if (r8 == 0) goto L_0x0030
        L_0x002e:
            r7 = 0
            goto L_0x003b
        L_0x0030:
            r8 = r5
            goto L_0x003b
        L_0x0032:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0140
            goto L_0x002e
        L_0x003b:
            r2 = 0
        L_0x003c:
            int r3 = r5.length()
            if (r2 >= r3) goto L_0x0140
            java.lang.String r3 = "=,;"
            int r3 = org.cocos2dx.okhttp3.internal.http.HttpHeaders.skipUntil(r5, r2, r3)
            java.lang.String r2 = r5.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r4 = r5.length()
            if (r3 == r4) goto L_0x0066
            char r4 = r5.charAt(r3)
            r0 = 44
            if (r4 == r0) goto L_0x0066
            char r0 = r5.charAt(r3)
            r4 = 59
            if (r0 != r4) goto L_0x0068
        L_0x0066:
            r4 = 1
            goto L_0x009b
        L_0x0068:
            int r3 = r3 + 1
            int r0 = org.cocos2dx.okhttp3.internal.http.HttpHeaders.skipWhitespace(r5, r3)
            int r3 = r5.length()
            if (r0 >= r3) goto L_0x008b
            char r3 = r5.charAt(r0)
            r4 = 34
            if (r3 != r4) goto L_0x008b
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = org.cocos2dx.okhttp3.internal.http.HttpHeaders.skipUntil(r5, r0, r3)
            java.lang.String r0 = r5.substring(r0, r3)
            r4 = 1
            int r3 = r3 + r4
            goto L_0x009e
        L_0x008b:
            r4 = 1
            java.lang.String r3 = ",;"
            int r3 = org.cocos2dx.okhttp3.internal.http.HttpHeaders.skipUntil(r5, r0, r3)
            java.lang.String r0 = r5.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009e
        L_0x009b:
            int r3 = r3 + 1
            r0 = 0
        L_0x009e:
            java.lang.String r4 = "no-cache"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00aa
            r4 = -1
            r9 = 1
            goto L_0x013b
        L_0x00aa:
            java.lang.String r4 = "no-store"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00b6
            r4 = -1
            r10 = 1
            goto L_0x013b
        L_0x00b6:
            java.lang.String r4 = "max-age"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00c6
            r4 = -1
            int r0 = org.cocos2dx.okhttp3.internal.http.HttpHeaders.parseSeconds(r0, r4)
            r11 = r0
            goto L_0x013b
        L_0x00c6:
            java.lang.String r4 = "s-maxage"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00d6
            r4 = -1
            int r0 = org.cocos2dx.okhttp3.internal.http.HttpHeaders.parseSeconds(r0, r4)
            r12 = r0
            goto L_0x013b
        L_0x00d6:
            java.lang.String r4 = "private"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00e1
            r4 = -1
            r13 = 1
            goto L_0x013b
        L_0x00e1:
            java.lang.String r4 = "public"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00ec
            r4 = -1
            r14 = 1
            goto L_0x013b
        L_0x00ec:
            java.lang.String r4 = "must-revalidate"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00f7
            r4 = -1
            r15 = 1
            goto L_0x013b
        L_0x00f7:
            java.lang.String r4 = "max-stale"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x010a
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r0 = org.cocos2dx.okhttp3.internal.http.HttpHeaders.parseSeconds(r0, r2)
            r16 = r0
            r4 = -1
            goto L_0x013b
        L_0x010a:
            java.lang.String r4 = "min-fresh"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x011a
            r4 = -1
            int r0 = org.cocos2dx.okhttp3.internal.http.HttpHeaders.parseSeconds(r0, r4)
            r17 = r0
            goto L_0x013b
        L_0x011a:
            r4 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0126
            r18 = 1
            goto L_0x013b
        L_0x0126:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0131
            r19 = 1
            goto L_0x013b
        L_0x0131:
            java.lang.String r0 = "immutable"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x013b
            r20 = 1
        L_0x013b:
            r0 = r22
            r2 = r3
            goto L_0x003c
        L_0x0140:
            r4 = -1
            int r6 = r6 + 1
            r0 = r22
            goto L_0x001a
        L_0x0147:
            if (r7 != 0) goto L_0x014c
            r21 = 0
            goto L_0x014e
        L_0x014c:
            r21 = r8
        L_0x014e:
            org.cocos2dx.okhttp3.CacheControl r0 = new org.cocos2dx.okhttp3.CacheControl
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.CacheControl.parse(org.cocos2dx.okhttp3.Headers):org.cocos2dx.okhttp3.CacheControl");
    }

    public boolean immutable() {
        return this.immutable;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public boolean noCache() {
        return this.noCache;
    }

    public boolean noStore() {
        return this.noStore;
    }

    public boolean noTransform() {
        return this.noTransform;
    }

    public boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        String headerValue2 = headerValue();
        this.headerValue = headerValue2;
        return headerValue2;
    }

    CacheControl(Builder builder) {
        this.noCache = builder.noCache;
        this.noStore = builder.noStore;
        this.maxAgeSeconds = builder.maxAgeSeconds;
        this.sMaxAgeSeconds = -1;
        this.isPrivate = false;
        this.isPublic = false;
        this.mustRevalidate = false;
        this.maxStaleSeconds = builder.maxStaleSeconds;
        this.minFreshSeconds = builder.minFreshSeconds;
        this.onlyIfCached = builder.onlyIfCached;
        this.noTransform = builder.noTransform;
        this.immutable = builder.immutable;
    }
}
