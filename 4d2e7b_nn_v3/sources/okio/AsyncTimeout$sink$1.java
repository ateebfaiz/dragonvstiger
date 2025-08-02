package okio;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.m;

public final class AsyncTimeout$sink$1 implements Sink {
    final /* synthetic */ Sink $sink;
    final /* synthetic */ AsyncTimeout this$0;

    AsyncTimeout$sink$1(AsyncTimeout asyncTimeout, Sink sink) {
        this.this$0 = asyncTimeout;
        this.$sink = sink;
    }

    public void close() {
        AsyncTimeout asyncTimeout = this.this$0;
        asyncTimeout.enter();
        try {
            this.$sink.close();
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

    public void flush() {
        AsyncTimeout asyncTimeout = this.this$0;
        asyncTimeout.enter();
        try {
            this.$sink.flush();
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

    public String toString() {
        return "AsyncTimeout.sink(" + this.$sink + ')';
    }

    public void write(Buffer buffer, long j10) {
        m.f(buffer, "source");
        Util.checkOffsetAndCount(buffer.size(), 0, j10);
        while (true) {
            long j11 = 0;
            if (j10 > 0) {
                Segment segment = buffer.head;
                m.c(segment);
                while (true) {
                    if (j11 >= ((long) 65536)) {
                        break;
                    }
                    j11 += (long) (segment.limit - segment.pos);
                    if (j11 >= j10) {
                        j11 = j10;
                        break;
                    } else {
                        segment = segment.next;
                        m.c(segment);
                    }
                }
                AsyncTimeout asyncTimeout = this.this$0;
                asyncTimeout.enter();
                try {
                    this.$sink.write(buffer, j11);
                    Unit unit = Unit.f12577a;
                    if (!asyncTimeout.exit()) {
                        j10 -= j11;
                    } else {
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
            } else {
                return;
            }
        }
    }

    public AsyncTimeout timeout() {
        return this.this$0;
    }
}
