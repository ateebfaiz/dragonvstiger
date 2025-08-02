package okhttp3.internal.http2;

import kotlin.jvm.internal.x;
import kotlin.jvm.internal.y;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.http2.Http2Connection;

public final class Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1 extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ boolean $clearPrevious$inlined;
    final /* synthetic */ x $delta$inlined;
    final /* synthetic */ String $name;
    final /* synthetic */ y $newPeerSettings$inlined;
    final /* synthetic */ Settings $settings$inlined;
    final /* synthetic */ y $streamsToNotify$inlined;
    final /* synthetic */ Http2Connection.ReaderRunnable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1(String str, boolean z10, String str2, boolean z11, Http2Connection.ReaderRunnable readerRunnable, y yVar, boolean z12, Settings settings, x xVar, y yVar2) {
        super(str2, z11);
        this.$name = str;
        this.$cancelable = z10;
        this.this$0 = readerRunnable;
        this.$newPeerSettings$inlined = yVar;
        this.$clearPrevious$inlined = z12;
        this.$settings$inlined = settings;
        this.$delta$inlined = xVar;
        this.$streamsToNotify$inlined = yVar2;
    }

    public long runOnce() {
        this.this$0.this$0.getListener$okhttp().onSettings(this.this$0.this$0, (Settings) this.$newPeerSettings$inlined.f725a);
        return -1;
    }
}
