package com.google.android.gms.internal.common;

final class h extends g {

    /* renamed from: a  reason: collision with root package name */
    private final char f7036a;

    h(char c10) {
        this.f7036a = c10;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CharMatcher.is('");
        int i10 = this.f7036a;
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i11 = 0; i11 < 4; i11++) {
            cArr[5 - i11] = "0123456789ABCDEF".charAt(i10 & 15);
            i10 >>= 4;
        }
        sb2.append(String.copyValueOf(cArr));
        sb2.append("')");
        return sb2.toString();
    }

    public final boolean zza(char c10) {
        return c10 == this.f7036a;
    }
}
