package okio;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.m;

public final class AsyncTimeout$source$1 implements Source {
    final /* synthetic */ Source $source;
    final /* synthetic */ AsyncTimeout this$0;

    AsyncTimeout$source$1(AsyncTimeout asyncTimeout, Source source) {
        this.this$0 = asyncTimeout;
        this.$source = source;
    }

    public void close() {
        AsyncTimeout asyncTimeout = this.this$0;
        asyncTimeout.enter();
        try {
            this.$source.close();
            Unit unit = Unit.f12577a;
            if (asyncTimeout.exit()) {
                throw asyncTimeout.access$newTimeoutException((IOException) null);
            }
        } catch (IOException e10) {
            e = e10;
            if (asyncTimeout.exit()) {
                e = asyncTimeout.access$newTimeoutException(e);
            }
            throw e;
        } finally {
            asyncTimeout.exit();
        }
    }

    public long read(Buffer buffer, long j10) {
        m.f(buffer, "sink");
        AsyncTimeout asyncTimeout = this.this$0;
        asyncTimeout.enter();
        try {
            long read = this.$source.read(buffer, j10);
            if (!asyncTimeout.exit()) {
                return read;
            }
            throw asyncTimeout.access$newTimeoutException((IOException) null);
        } catch (IOException e10) {
            e = e10;
            if (asyncTimeout.exit()) {
                e = asyncTimeout.access$newTimeoutException(e);
            }
            throw e;
        } finally {
            asyncTimeout.exit();
        }
    }

    public String toString() {
        return "AsyncTimeout.source(" + this.$source + ')';
    }

    public AsyncTimeout timeout() {
        return this.this$0;
    }
}
