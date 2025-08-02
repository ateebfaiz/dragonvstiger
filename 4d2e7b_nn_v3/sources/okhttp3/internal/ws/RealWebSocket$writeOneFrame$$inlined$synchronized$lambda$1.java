package okhttp3.internal.ws;

import kotlin.jvm.internal.w;
import kotlin.jvm.internal.y;
import okhttp3.internal.concurrent.Task;
import okio.ByteString;

public final class RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1 extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ y $messageOrClose$inlined;
    final /* synthetic */ String $name;
    final /* synthetic */ ByteString $pong$inlined;
    final /* synthetic */ y $readerToClose$inlined;
    final /* synthetic */ w $receivedCloseCode$inlined;
    final /* synthetic */ y $receivedCloseReason$inlined;
    final /* synthetic */ y $streamsToClose$inlined;
    final /* synthetic */ WebSocketWriter $writer$inlined;
    final /* synthetic */ y $writerToClose$inlined;
    final /* synthetic */ RealWebSocket this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1(String str, boolean z10, String str2, boolean z11, RealWebSocket realWebSocket, WebSocketWriter webSocketWriter, ByteString byteString, y yVar, w wVar, y yVar2, y yVar3, y yVar4, y yVar5) {
        super(str2, z11);
        this.$name = str;
        this.$cancelable = z10;
        this.this$0 = realWebSocket;
        this.$writer$inlined = webSocketWriter;
        this.$pong$inlined = byteString;
        this.$messageOrClose$inlined = yVar;
        this.$receivedCloseCode$inlined = wVar;
        this.$receivedCloseReason$inlined = yVar2;
        this.$streamsToClose$inlined = yVar3;
        this.$readerToClose$inlined = yVar4;
        this.$writerToClose$inlined = yVar5;
    }

    public long runOnce() {
        this.this$0.cancel();
        return -1;
    }
}
