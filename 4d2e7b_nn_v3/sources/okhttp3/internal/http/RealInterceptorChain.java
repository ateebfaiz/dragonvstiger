package okhttp3.internal.http;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.m;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;

public final class RealInterceptorChain implements Interceptor.Chain {
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;
    private final Request request;
    private final int writeTimeoutMillis;

    public RealInterceptorChain(RealCall realCall, List<? extends Interceptor> list, int i10, Exchange exchange2, Request request2, int i11, int i12, int i13) {
        m.f(realCall, NotificationCompat.CATEGORY_CALL);
        m.f(list, "interceptors");
        m.f(request2, "request");
        this.call = realCall;
        this.interceptors = list;
        this.index = i10;
        this.exchange = exchange2;
        this.request = request2;
        this.connectTimeoutMillis = i11;
        this.readTimeoutMillis = i12;
        this.writeTimeoutMillis = i13;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i10, Exchange exchange2, Request request2, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = realInterceptorChain.index;
        }
        if ((i14 & 2) != 0) {
            exchange2 = realInterceptorChain.exchange;
        }
        Exchange exchange3 = exchange2;
        if ((i14 & 4) != 0) {
            request2 = realInterceptorChain.request;
        }
        Request request3 = request2;
        if ((i14 & 8) != 0) {
            i11 = realInterceptorChain.connectTimeoutMillis;
        }
        int i15 = i11;
        if ((i14 & 16) != 0) {
            i12 = realInterceptorChain.readTimeoutMillis;
        }
        int i16 = i12;
        if ((i14 & 32) != 0) {
            i13 = realInterceptorChain.writeTimeoutMillis;
        }
        return realInterceptorChain.copy$okhttp(i10, exchange3, request3, i15, i16, i13);
    }

    public Call call() {
        return this.call;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public Connection connection() {
        Exchange exchange2 = this.exchange;
        if (exchange2 != null) {
            return exchange2.getConnection$okhttp();
        }
        return null;
    }

    public final RealInterceptorChain copy$okhttp(int i10, Exchange exchange2, Request request2, int i11, int i12, int i13) {
        m.f(request2, "request");
        return new RealInterceptorChain(this.call, this.interceptors, i10, exchange2, request2, i11, i12, i13);
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    public Response proceed(Request request2) throws IOException {
        boolean z10;
        boolean z11;
        boolean z12;
        m.f(request2, "request");
        boolean z13 = false;
        if (this.index < this.interceptors.size()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.calls++;
            Exchange exchange2 = this.exchange;
            if (exchange2 != null) {
                if (exchange2.getFinder$okhttp().sameHostAndPort(request2.url())) {
                    if (this.calls == 1) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z12) {
                        throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
                    }
                } else {
                    throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
                }
            }
            RealInterceptorChain copy$okhttp$default = copy$okhttp$default(this, this.index + 1, (Exchange) null, request2, 0, 0, 0, 58, (Object) null);
            Interceptor interceptor = this.interceptors.get(this.index);
            Response intercept = interceptor.intercept(copy$okhttp$default);
            if (intercept != null) {
                if (this.exchange != null) {
                    if (this.index + 1 >= this.interceptors.size() || copy$okhttp$default.calls == 1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
                    }
                }
                if (intercept.body() != null) {
                    z13 = true;
                }
                if (z13) {
                    return intercept;
                }
                throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
            }
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public Request request() {
        return this.request;
    }

    public Interceptor.Chain withConnectTimeout(int i10, TimeUnit timeUnit) {
        boolean z10;
        m.f(timeUnit, "unit");
        if (this.exchange == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return copy$okhttp$default(this, 0, (Exchange) null, (Request) null, Util.checkDuration("connectTimeout", (long) i10, timeUnit), 0, 0, 55, (Object) null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    public Interceptor.Chain withReadTimeout(int i10, TimeUnit timeUnit) {
        boolean z10;
        m.f(timeUnit, "unit");
        if (this.exchange == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return copy$okhttp$default(this, 0, (Exchange) null, (Request) null, 0, Util.checkDuration("readTimeout", (long) i10, timeUnit), 0, 47, (Object) null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    public Interceptor.Chain withWriteTimeout(int i10, TimeUnit timeUnit) {
        boolean z10;
        m.f(timeUnit, "unit");
        if (this.exchange == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return copy$okhttp$default(this, 0, (Exchange) null, (Request) null, 0, 0, Util.checkDuration("writeTimeout", (long) i10, timeUnit), 31, (Object) null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
