package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

public interface Interceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        Connection connection();

        Response proceed(Request request) throws IOException;

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int i10, TimeUnit timeUnit);

        Chain withReadTimeout(int i10, TimeUnit timeUnit);

        Chain withWriteTimeout(int i10, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final Interceptor invoke(Function1<? super Chain, Response> function1) {
            m.f(function1, "block");
            return new Interceptor$Companion$invoke$1(function1);
        }
    }

    Response intercept(Chain chain) throws IOException;
}
