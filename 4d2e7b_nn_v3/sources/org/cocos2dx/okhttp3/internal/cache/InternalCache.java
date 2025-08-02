package org.cocos2dx.okhttp3.internal.cache;

import java.io.IOException;
import org.cocos2dx.okhttp3.Request;
import org.cocos2dx.okhttp3.Response;

public interface InternalCache {
    Response get(Request request) throws IOException;

    CacheRequest put(Response response) throws IOException;

    void remove(Request request) throws IOException;

    void trackConditionalCacheHit();

    void trackResponse(CacheStrategy cacheStrategy);

    void update(Response response, Response response2);
}
