package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import okhttp3.Protocol;
import okhttp3.Response;

public final class StatusLine {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    public static final class Companion {
        private Companion() {
        }

        public final StatusLine get(Response response) {
            m.f(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String str) throws IOException {
            int i10;
            Protocol protocol;
            String str2;
            m.f(str, "statusLine");
            if (j.F(str, "HTTP/1.", false, 2, (Object) null)) {
                i10 = 9;
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else if (charAt == 1) {
                    protocol = Protocol.HTTP_1_1;
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else if (j.F(str, "ICY ", false, 2, (Object) null)) {
                protocol = Protocol.HTTP_1_0;
                i10 = 4;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int i11 = i10 + 3;
            if (str.length() >= i11) {
                try {
                    String substring = str.substring(i10, i11);
                    m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    int parseInt = Integer.parseInt(substring);
                    if (str.length() <= i11) {
                        str2 = "";
                    } else if (str.charAt(i11) == ' ') {
                        str2 = str.substring(i10 + 4);
                        m.e(str2, "(this as java.lang.String).substring(startIndex)");
                    } else {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    return new StatusLine(protocol, parseInt, str2);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StatusLine(Protocol protocol2, int i10, String str) {
        m.f(protocol2, "protocol");
        m.f(str, "message");
        this.protocol = protocol2;
        this.code = i10;
        this.message = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb2.append("HTTP/1.0");
        } else {
            sb2.append("HTTP/1.1");
        }
        sb2.append(' ');
        sb2.append(this.code);
        sb2.append(' ');
        sb2.append(this.message);
        String sb3 = sb2.toString();
        m.e(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
