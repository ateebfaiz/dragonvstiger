package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import okio.Buffer;

public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (m.g(charAt, 31) <= 0 || m.g(charAt, 127) >= 0 || j.U(" #%/:?@[\\]", charAt, 0, false, 6, (Object) null) != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i10, int i11, byte[] bArr, int i12) {
        int i13 = i12;
        while (i10 < i11) {
            if (i13 == bArr.length) {
                return false;
            }
            if (i13 != i12) {
                if (str.charAt(i10) != '.') {
                    return false;
                }
                i10++;
            }
            int i14 = i10;
            int i15 = 0;
            while (i14 < i11) {
                char charAt = str.charAt(i14);
                if (m.g(charAt, 48) < 0 || m.g(charAt, 57) > 0) {
                    break;
                } else if ((i15 == 0 && i10 != i14) || (i15 = ((i15 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i14++;
                }
            }
            if (i14 - i10 == 0) {
                return false;
            }
            bArr[i13] = (byte) i15;
            i13++;
            i10 = i14;
        }
        if (i13 == i12 + 4) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0097, code lost:
        if (r13 == 16) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        if (r14 != -1) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009c, code lost:
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ae, code lost:
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0084 A[LOOP:0: B:1:0x000e->B:36:0x0084, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0096 A[EDGE_INSN: B:44:0x0096->B:37:0x0096 ?: BREAK  
    EDGE_INSN: B:50:0x0096->B:37:0x0096 ?: BREAK  , RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.net.InetAddress decodeIpv6(java.lang.String r18, int r19, int r20) {
        /*
            r6 = r18
            r7 = r20
            r8 = 16
            byte[] r9 = new byte[r8]
            r11 = -1
            r12 = r19
            r14 = r11
            r15 = r14
            r13 = 0
        L_0x000e:
            r16 = 0
            if (r12 >= r7) goto L_0x0097
            if (r13 != r8) goto L_0x0015
            return r16
        L_0x0015:
            int r5 = r12 + 2
            if (r5 > r7) goto L_0x0038
            r4 = 4
            r17 = 0
            java.lang.String r1 = "::"
            r3 = 0
            r0 = r18
            r2 = r12
            r10 = r5
            r5 = r17
            boolean r0 = kotlin.text.j.E(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0038
            if (r14 == r11) goto L_0x002e
            return r16
        L_0x002e:
            int r13 = r13 + 2
            if (r10 != r7) goto L_0x0035
            r14 = r13
            goto L_0x0097
        L_0x0035:
            r15 = r10
            r14 = r13
            goto L_0x0067
        L_0x0038:
            if (r13 == 0) goto L_0x004a
            r4 = 4
            r5 = 0
            java.lang.String r1 = ":"
            r3 = 0
            r0 = r18
            r2 = r12
            boolean r0 = kotlin.text.j.E(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x004c
            int r12 = r12 + 1
        L_0x004a:
            r15 = r12
            goto L_0x0067
        L_0x004c:
            r4 = 4
            r5 = 0
            java.lang.String r1 = "."
            r3 = 0
            r0 = r18
            r2 = r12
            boolean r0 = kotlin.text.j.E(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0066
            int r0 = r13 + -2
            boolean r0 = decodeIpv4Suffix(r6, r15, r7, r9, r0)
            if (r0 != 0) goto L_0x0063
            return r16
        L_0x0063:
            int r13 = r13 + 2
            goto L_0x0097
        L_0x0066:
            return r16
        L_0x0067:
            r12 = r15
            r0 = 0
        L_0x0069:
            if (r12 >= r7) goto L_0x007c
            char r1 = r6.charAt(r12)
            int r1 = okhttp3.internal.Util.parseHexDigit(r1)
            if (r1 != r11) goto L_0x0076
            goto L_0x007c
        L_0x0076:
            int r0 = r0 << 4
            int r0 = r0 + r1
            int r12 = r12 + 1
            goto L_0x0069
        L_0x007c:
            int r1 = r12 - r15
            if (r1 == 0) goto L_0x0096
            r2 = 4
            if (r1 <= r2) goto L_0x0084
            goto L_0x0096
        L_0x0084:
            int r1 = r13 + 1
            int r2 = r0 >>> 8
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r9[r13] = r2
            int r13 = r13 + 2
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r9[r1] = r0
            goto L_0x000e
        L_0x0096:
            return r16
        L_0x0097:
            if (r13 == r8) goto L_0x00aa
            if (r14 != r11) goto L_0x009c
            return r16
        L_0x009c:
            int r0 = r13 - r14
            int r1 = 16 - r0
            java.lang.System.arraycopy(r9, r14, r9, r1, r0)
            int r8 = r8 - r13
            int r8 = r8 + r14
            r0 = 0
            byte r0 = (byte) r0
            java.util.Arrays.fill(r9, r14, r8, r0)
        L_0x00aa:
            java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.HostnamesKt.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < bArr.length) {
            int i14 = i12;
            while (i14 < 16 && bArr[i14] == 0 && bArr[i14 + 1] == 0) {
                i14 += 2;
            }
            int i15 = i14 - i12;
            if (i15 > i13 && i15 >= 4) {
                i10 = i12;
                i13 = i15;
            }
            i12 = i14 + 2;
        }
        Buffer buffer = new Buffer();
        while (i11 < bArr.length) {
            if (i11 == i10) {
                buffer.writeByte(58);
                i11 += i13;
                if (i11 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i11 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((long) ((Util.and(bArr[i11], 255) << 8) | Util.and(bArr[i11 + 1], 255)));
                i11 += 2;
            }
        }
        return buffer.readUtf8();
    }

    public static final String toCanonicalHost(String str) {
        InetAddress inetAddress;
        m.f(str, "$this$toCanonicalHost");
        if (j.K(str, ":", false, 2, (Object) null)) {
            if (!j.F(str, "[", false, 2, (Object) null) || !j.p(str, "]", false, 2, (Object) null)) {
                inetAddress = decodeIpv6(str, 0, str.length());
            } else {
                inetAddress = decodeIpv6(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                m.e(address, "address");
                return inet6AddressToAscii(address);
            } else if (address.length == 4) {
                return inetAddress.getHostAddress();
            } else {
                throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
            }
        } else {
            try {
                String ascii = IDN.toASCII(str);
                m.e(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                m.e(locale, "Locale.US");
                if (ascii != null) {
                    String lowerCase = ascii.toLowerCase(locale);
                    m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (lowerCase.length() == 0) {
                        return null;
                    }
                    if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                        return null;
                    }
                    return lowerCase;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }
}
