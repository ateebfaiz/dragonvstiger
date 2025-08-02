package okhttp3.internal.http;

import kotlin.jvm.internal.m;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final BufferedSource source;

    public RealResponseBody(String str, long j10, BufferedSource bufferedSource) {
        m.f(bufferedSource, "source");
        this.contentTypeString = str;
        this.contentLength = j10;
        this.source = bufferedSource;
    }

    public long contentLength() {
        return this.contentLength;
    }

    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    public BufferedSource source() {
        return this.source;
    }
}
