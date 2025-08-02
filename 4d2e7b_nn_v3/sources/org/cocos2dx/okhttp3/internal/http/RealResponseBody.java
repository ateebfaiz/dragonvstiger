package org.cocos2dx.okhttp3.internal.http;

import org.cocos2dx.okhttp3.MediaType;
import org.cocos2dx.okhttp3.ResponseBody;
import org.cocos2dx.okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final BufferedSource source;

    public RealResponseBody(String str, long j10, BufferedSource bufferedSource) {
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
            return MediaType.parse(str);
        }
        return null;
    }

    public BufferedSource source() {
        return this.source;
    }
}
