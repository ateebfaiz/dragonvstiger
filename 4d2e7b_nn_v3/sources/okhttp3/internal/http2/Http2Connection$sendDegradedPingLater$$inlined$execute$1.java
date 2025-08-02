package okhttp3.internal.http2;

import okhttp3.internal.concurrent.Task;

public final class Http2Connection$sendDegradedPingLater$$inlined$execute$1 extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ String $name;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$sendDegradedPingLater$$inlined$execute$1(String str, boolean z10, String str2, boolean z11, Http2Connection http2Connection) {
        super(str2, z11);
        this.$name = str;
        this.$cancelable = z10;
        this.this$0 = http2Connection;
    }

    public long runOnce() {
        this.this$0.writePing(false, 2, 0);
        return -1;
    }
}
