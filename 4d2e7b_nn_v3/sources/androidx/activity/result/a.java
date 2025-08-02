package androidx.activity.result;

import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f13834a;

    public /* synthetic */ a(Function1 function1) {
        this.f13834a = function1;
    }

    public final void onActivityResult(Object obj) {
        ActivityResultCallerKt.registerForActivityResult$lambda$0(this.f13834a, obj);
    }
}
