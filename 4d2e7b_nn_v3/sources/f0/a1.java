package f0;

import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import java.util.function.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f21293a;

    public /* synthetic */ a1(Function1 function1) {
        this.f21293a = function1;
    }

    public final Object apply(Object obj) {
        return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$12(this.f21293a, obj);
    }
}
