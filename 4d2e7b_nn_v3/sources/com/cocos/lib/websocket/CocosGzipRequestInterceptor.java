package com.cocos.lib.websocket;

import java.io.IOException;
import org.cocos2dx.okhttp3.Interceptor;
import org.cocos2dx.okhttp3.MediaType;
import org.cocos2dx.okhttp3.Request;
import org.cocos2dx.okhttp3.RequestBody;
import org.cocos2dx.okhttp3.Response;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.GzipSink;
import org.cocos2dx.okio.Okio;
import org.cocos2dx.okio.Sink;

public class CocosGzipRequestInterceptor implements Interceptor {

    class a extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RequestBody f19399a;

        a(RequestBody requestBody) {
            this.f19399a = requestBody;
        }

        public long contentLength() {
            return -1;
        }

        public MediaType contentType() {
            return this.f19399a.contentType();
        }

        public void writeTo(BufferedSink bufferedSink) {
            BufferedSink buffer = Okio.buffer((Sink) new GzipSink(bufferedSink));
            this.f19399a.writeTo(buffer);
            buffer.close();
        }
    }

    private RequestBody gzip(RequestBody requestBody) {
        return new a(requestBody);
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (request.body() == null || request.header("Content-Encoding") != null) {
            return chain.proceed(request);
        }
        return chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").method(request.method(), gzip(request.body())).build());
    }
}
