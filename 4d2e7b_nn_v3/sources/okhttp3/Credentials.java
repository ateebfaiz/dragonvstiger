package okhttp3;

import androidx.autofill.HintConstants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.m;
import okio.ByteString;

public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    public static final String basic(String str, String str2) {
        return basic$default(str, str2, (Charset) null, 4, (Object) null);
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            charset = StandardCharsets.ISO_8859_1;
            m.e(charset, "ISO_8859_1");
        }
        return basic(str, str2, charset);
    }

    public static final String basic(String str, String str2, Charset charset) {
        m.f(str, HintConstants.AUTOFILL_HINT_USERNAME);
        m.f(str2, HintConstants.AUTOFILL_HINT_PASSWORD);
        m.f(charset, "charset");
        String base64 = ByteString.Companion.encodeString(str + ':' + str2, charset).base64();
        return "Basic " + base64;
    }
}
