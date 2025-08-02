package okhttp3;

import okio.BufferedSource;

public final class ResponseBody$Companion$asResponseBody$1 extends ResponseBody {
    final /* synthetic */ long $contentLength;
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ BufferedSource $this_asResponseBody;

    ResponseBody$Companion$asResponseBody$1(BufferedSource bufferedSource, MediaType mediaType, long j10) {
        this.$this_asResponseBody = bufferedSource;
        this.$contentType = mediaType;
        this.$contentLength = j10;
    }

    public long contentLength() {
        return this.$contentLength;
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public BufferedSource source() {
        return this.$this_asResponseBody;
    }
}
