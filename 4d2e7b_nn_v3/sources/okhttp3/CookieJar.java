package okhttp3;

import com.google.android.gms.common.internal.ImagesContract;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public interface CookieJar {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final CookieJar NO_COOKIES = new Companion.NoCookies();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private static final class NoCookies implements CookieJar {
            public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                m.f(httpUrl, ImagesContract.URL);
                return r.l();
            }

            public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                m.f(httpUrl, ImagesContract.URL);
                m.f(list, "cookies");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
