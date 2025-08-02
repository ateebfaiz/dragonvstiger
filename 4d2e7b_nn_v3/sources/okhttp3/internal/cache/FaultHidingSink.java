package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

public class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;
    private final Function1<IOException, Unit> onException;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FaultHidingSink(Sink sink, Function1<? super IOException, Unit> function1) {
        super(sink);
        m.f(sink, "delegate");
        m.f(function1, "onException");
        this.onException = function1;
    }

    public void close() {
        if (!this.hasErrors) {
            try {
                super.close();
            } catch (IOException e10) {
                this.hasErrors = true;
                this.onException.invoke(e10);
            }
        }
    }

    public void flush() {
        if (!this.hasErrors) {
            try {
                super.flush();
            } catch (IOException e10) {
                this.hasErrors = true;
                this.onException.invoke(e10);
            }
        }
    }

    public final Function1<IOException, Unit> getOnException() {
        return this.onException;
    }

    public void write(Buffer buffer, long j10) {
        m.f(buffer, "source");
        if (this.hasErrors) {
            buffer.skip(j10);
            return;
        }
        try {
            super.write(buffer, j10);
        } catch (IOException e10) {
            this.hasErrors = true;
            this.onException.invoke(e10);
        }
    }
}
