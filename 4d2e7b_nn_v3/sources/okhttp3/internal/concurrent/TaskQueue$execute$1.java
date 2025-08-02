package okhttp3.internal.concurrent;

import kotlin.jvm.functions.Function0;

public final class TaskQueue$execute$1 extends Task {
    final /* synthetic */ Function0 $block;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ String $name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskQueue$execute$1(Function0 function0, String str, boolean z10, String str2, boolean z11) {
        super(str2, z11);
        this.$block = function0;
        this.$name = str;
        this.$cancelable = z10;
    }

    public long runOnce() {
        this.$block.invoke();
        return -1;
    }
}
