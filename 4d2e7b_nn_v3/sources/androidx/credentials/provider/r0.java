package androidx.credentials.provider;

import androidx.credentials.provider.PendingIntentHandler;
import java.util.function.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class r0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f15331a;

    public /* synthetic */ r0(Function1 function1) {
        this.f15331a = function1;
    }

    public final Object apply(Object obj) {
        return PendingIntentHandler.Companion.retrieveProviderGetCredentialRequest$lambda$1(this.f15331a, obj);
    }
}
