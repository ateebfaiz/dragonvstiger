package androidx.core.view;

import kotlin.jvm.functions.Function0;

public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f15270a;

    public /* synthetic */ m0(Function0 function0) {
        this.f15270a = function0;
    }

    public final void run() {
        ViewKt.postOnAnimationDelayed$lambda$1(this.f15270a);
    }
}
