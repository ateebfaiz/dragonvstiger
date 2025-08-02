package org.cocos2dx.okhttp3.internal;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import org.cocos2dx.okhttp3.Address;
import org.cocos2dx.okhttp3.Call;
import org.cocos2dx.okhttp3.ConnectionPool;
import org.cocos2dx.okhttp3.ConnectionSpec;
import org.cocos2dx.okhttp3.Headers;
import org.cocos2dx.okhttp3.OkHttpClient;
import org.cocos2dx.okhttp3.Request;
import org.cocos2dx.okhttp3.Response;
import org.cocos2dx.okhttp3.Route;
import org.cocos2dx.okhttp3.internal.cache.InternalCache;
import org.cocos2dx.okhttp3.internal.connection.RealConnection;
import org.cocos2dx.okhttp3.internal.connection.RouteDatabase;
import org.cocos2dx.okhttp3.internal.connection.StreamAllocation;

public abstract class Internal {
    public static Internal instance;

    public static void initializeInstanceForTests() {
        new OkHttpClient();
    }

    public abstract void addLenient(Headers.Builder builder, String str);

    public abstract void addLenient(Headers.Builder builder, String str, String str2);

    public abstract void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z10);

    public abstract int code(Response.Builder builder);

    public abstract boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection);

    public abstract Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation);

    public abstract boolean equalsNonHost(Address address, Address address2);

    public abstract RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route);

    public abstract boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException);

    public abstract Call newWebSocketCall(OkHttpClient okHttpClient, Request request);

    public abstract void put(ConnectionPool connectionPool, RealConnection realConnection);

    public abstract RouteDatabase routeDatabase(ConnectionPool connectionPool);

    public abstract void setCache(OkHttpClient.Builder builder, InternalCache internalCache);

    public abstract StreamAllocation streamAllocation(Call call);

    public abstract IOException timeoutExit(Call call, IOException iOException);
}
