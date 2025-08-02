package androidx.activity.result;

import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f13835a;

    public /* synthetic */ b(Function1 function1) {
        this.f13835a = function1;
    }

    public final void onActivityResult(Object obj) {
        ActivityResultCallerKt.registerForActivityResult$lambda$1(this.f13835a, obj);
    }
}
