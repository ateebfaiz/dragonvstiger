package org.cocos2dx.okhttp3.internal.connection;

import java.io.IOException;
import org.cocos2dx.okhttp3.Interceptor;
import org.cocos2dx.okhttp3.OkHttpClient;
import org.cocos2dx.okhttp3.Request;
import org.cocos2dx.okhttp3.Response;
import org.cocos2dx.okhttp3.internal.http.RealInterceptorChain;

public final class ConnectInterceptor implements Interceptor {
    public final OkHttpClient client;

    public ConnectInterceptor(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.request();
        StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
        return realInterceptorChain.proceed(request, streamAllocation, streamAllocation.newStream(this.client, chain, !request.method().equals("GET")), streamAllocation.connection());
    }
}
