package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import okhttp3.Headers;
import okhttp3.internal.Util;

public final class WebSocketExtensions {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    public static final class Companion {
        private Companion() {
        }

        public final WebSocketExtensions parse(Headers headers) throws IOException {
            String str;
            Integer num;
            Integer num2;
            Headers headers2 = headers;
            m.f(headers2, "responseHeaders");
            int size = headers.size();
            boolean z10 = false;
            Integer num3 = null;
            boolean z11 = false;
            Integer num4 = null;
            boolean z12 = false;
            boolean z13 = false;
            for (int i10 = 0; i10 < size; i10++) {
                if (j.q(headers2.name(i10), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true)) {
                    String value = headers2.value(i10);
                    int i11 = 0;
                    while (i11 < value.length()) {
                        int delimiterOffset$default = Util.delimiterOffset$default(value, ',', i11, 0, 4, (Object) null);
                        int delimiterOffset = Util.delimiterOffset(value, ';', i11, delimiterOffset$default);
                        String trimSubstring = Util.trimSubstring(value, i11, delimiterOffset);
                        int i12 = delimiterOffset + 1;
                        if (j.q(trimSubstring, "permessage-deflate", true)) {
                            if (z10) {
                                z13 = true;
                            }
                            while (i12 < delimiterOffset$default) {
                                int delimiterOffset2 = Util.delimiterOffset(value, ';', i12, delimiterOffset$default);
                                int delimiterOffset3 = Util.delimiterOffset(value, '=', i12, delimiterOffset2);
                                String trimSubstring2 = Util.trimSubstring(value, i12, delimiterOffset3);
                                if (delimiterOffset3 < delimiterOffset2) {
                                    str = j.n0(Util.trimSubstring(value, delimiterOffset3 + 1, delimiterOffset2), "\"");
                                } else {
                                    str = null;
                                }
                                int i13 = delimiterOffset2 + 1;
                                if (j.q(trimSubstring2, "client_max_window_bits", true)) {
                                    if (num3 != null) {
                                        z13 = true;
                                    }
                                    if (str != null) {
                                        num2 = j.i(str);
                                    } else {
                                        num2 = null;
                                    }
                                    num3 = num2;
                                    if (num2 != null) {
                                        i12 = i13;
                                    }
                                } else {
                                    if (j.q(trimSubstring2, "client_no_context_takeover", true)) {
                                        if (z11) {
                                            z13 = true;
                                        }
                                        if (str != null) {
                                            z13 = true;
                                        }
                                        z11 = true;
                                    } else if (j.q(trimSubstring2, "server_max_window_bits", true)) {
                                        if (num4 != null) {
                                            z13 = true;
                                        }
                                        if (str != null) {
                                            num = j.i(str);
                                        } else {
                                            num = null;
                                        }
                                        num4 = num;
                                        if (num != null) {
                                        }
                                    } else if (j.q(trimSubstring2, "server_no_context_takeover", true)) {
                                        if (z12) {
                                            z13 = true;
                                        }
                                        if (str != null) {
                                            z13 = true;
                                        }
                                        z12 = true;
                                    }
                                    i12 = i13;
                                }
                                z13 = true;
                                i12 = i13;
                            }
                            i11 = i12;
                            z10 = true;
                        } else {
                            i11 = i12;
                            z13 = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(z10, num3, z11, num4, z12, z13);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WebSocketExtensions() {
        this(false, (Integer) null, false, (Integer) null, false, false, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z10, Integer num, boolean z11, Integer num2, boolean z12, boolean z13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = webSocketExtensions.perMessageDeflate;
        }
        if ((i10 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i10 & 4) != 0) {
            z11 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z14 = z11;
        if ((i10 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i10 & 16) != 0) {
            z12 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z15 = z12;
        if ((i10 & 32) != 0) {
            z13 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z10, num3, z14, num4, z15, z13);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z10, Integer num, boolean z11, Integer num2, boolean z12, boolean z13) {
        return new WebSocketExtensions(z10, num, z11, num2, z12, z13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && m.b(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && m.b(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    public int hashCode() {
        boolean z10 = this.perMessageDeflate;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int i10 = (z10 ? 1 : 0) * true;
        Integer num = this.clientMaxWindowBits;
        int i11 = 0;
        int hashCode = (i10 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z12 = this.clientNoContextTakeover;
        if (z12) {
            z12 = true;
        }
        int i12 = (hashCode + (z12 ? 1 : 0)) * 31;
        Integer num2 = this.serverMaxWindowBits;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        int i13 = (i12 + i11) * 31;
        boolean z13 = this.serverNoContextTakeover;
        if (z13) {
            z13 = true;
        }
        int i14 = (i13 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.unknownValues;
        if (!z14) {
            z11 = z14;
        }
        return i14 + (z11 ? 1 : 0);
    }

    public final boolean noContextTakeover(boolean z10) {
        if (z10) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ")";
    }

    public WebSocketExtensions(boolean z10, Integer num, boolean z11, Integer num2, boolean z12, boolean z13) {
        this.perMessageDeflate = z10;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z11;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z12;
        this.unknownValues = z13;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WebSocketExtensions(boolean r6, java.lang.Integer r7, boolean r8, java.lang.Integer r9, boolean r10, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            r1 = 0
            if (r6 == 0) goto L_0x000f
            r2 = r1
            goto L_0x0010
        L_0x000f:
            r2 = r7
        L_0x0010:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0016
            r3 = r0
            goto L_0x0017
        L_0x0016:
            r3 = r8
        L_0x0017:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r2
            r9 = r3
            r10 = r1
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.<init>(boolean, java.lang.Integer, boolean, java.lang.Integer, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
