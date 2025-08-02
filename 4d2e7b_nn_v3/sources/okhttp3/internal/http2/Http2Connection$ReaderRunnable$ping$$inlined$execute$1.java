package okhttp3.internal.http2;

import okhttp3.internal.concurrent.Task;
import okhttp3.internal.http2.Http2Connection;

public final class Http2Connection$ReaderRunnable$ping$$inlined$execute$1 extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ String $name;
    final /* synthetic */ int $payload1$inlined;
    final /* synthetic */ int $payload2$inlined;
    final /* synthetic */ Http2Connection.ReaderRunnable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$ReaderRunnable$ping$$inlined$execute$1(String str, boolean z10, String str2, boolean z11, Http2Connection.ReaderRunnable readerRunnable, int i10, int i11) {
        super(str2, z11);
        this.$name = str;
        this.$cancelable = z10;
        this.this$0 = readerRunnable;
        this.$payload1$inlined = i10;
        this.$payload2$inlined = i11;
    }

    public long runOnce() {
        this.this$0.this$0.writePing(true, this.$payload1$inlined, this.$payload2$inlined);
        return -1;
    }
}
