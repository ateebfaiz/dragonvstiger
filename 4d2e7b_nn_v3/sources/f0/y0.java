package f0;

import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class y0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f21304a;

    public /* synthetic */ y0(Function1 function1) {
        this.f21304a = function1;
    }

    public final boolean test(Object obj) {
        return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$10(this.f21304a, obj);
    }
}
