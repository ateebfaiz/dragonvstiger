package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okio.BufferedSource;

public interface PushObserver {
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private static final class PushObserverCancel implements PushObserver {
            public boolean onData(int i10, BufferedSource bufferedSource, int i11, boolean z10) throws IOException {
                m.f(bufferedSource, "source");
                bufferedSource.skip((long) i11);
                return true;
            }

            public boolean onHeaders(int i10, List<Header> list, boolean z10) {
                m.f(list, "responseHeaders");
                return true;
            }

            public boolean onRequest(int i10, List<Header> list) {
                m.f(list, "requestHeaders");
                return true;
            }

            public void onReset(int i10, ErrorCode errorCode) {
                m.f(errorCode, "errorCode");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    boolean onData(int i10, BufferedSource bufferedSource, int i11, boolean z10) throws IOException;

    boolean onHeaders(int i10, List<Header> list, boolean z10);

    boolean onRequest(int i10, List<Header> list);

    void onReset(int i10, ErrorCode errorCode);
}
