package okhttp3;

import kotlin.jvm.internal.m;
import okio.BufferedSink;

public final class RequestBody$Companion$toRequestBody$2 extends RequestBody {
    final /* synthetic */ int $byteCount;
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ int $offset;
    final /* synthetic */ byte[] $this_toRequestBody;

    RequestBody$Companion$toRequestBody$2(byte[] bArr, MediaType mediaType, int i10, int i11) {
        this.$this_toRequestBody = bArr;
        this.$contentType = mediaType;
        this.$byteCount = i10;
        this.$offset = i11;
    }

    public long contentLength() {
        return (long) this.$byteCount;
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public void writeTo(BufferedSink bufferedSink) {
        m.f(bufferedSink, "sink");
        bufferedSink.write(this.$this_toRequestBody, this.$offset, this.$byteCount);
    }
}
