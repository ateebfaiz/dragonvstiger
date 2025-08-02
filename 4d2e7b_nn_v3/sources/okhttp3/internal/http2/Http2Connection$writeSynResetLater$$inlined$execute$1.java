package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.concurrent.Task;

public final class Http2Connection$writeSynResetLater$$inlined$execute$1 extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ ErrorCode $errorCode$inlined;
    final /* synthetic */ String $name;
    final /* synthetic */ int $streamId$inlined;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$writeSynResetLater$$inlined$execute$1(String str, boolean z10, String str2, boolean z11, Http2Connection http2Connection, int i10, ErrorCode errorCode) {
        super(str2, z11);
        this.$name = str;
        this.$cancelable = z10;
        this.this$0 = http2Connection;
        this.$streamId$inlined = i10;
        this.$errorCode$inlined = errorCode;
    }

    public long runOnce() {
        try {
            this.this$0.writeSynReset$okhttp(this.$streamId$inlined, this.$errorCode$inlined);
            return -1;
        } catch (IOException e10) {
            this.this$0.failConnection(e10);
            return -1;
        }
    }
}
