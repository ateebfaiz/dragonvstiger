package f0;

import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b1 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f21294a;

    public /* synthetic */ b1(Function1 function1) {
        this.f21294a = function1;
    }

    public final boolean test(Object obj) {
        return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$13(this.f21294a, obj);
    }
}
