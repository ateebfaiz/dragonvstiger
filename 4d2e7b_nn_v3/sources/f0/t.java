package f0;

import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class t implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f21301a;

    public /* synthetic */ t(Function1 function1) {
        this.f21301a = function1;
    }

    public final boolean test(Object obj) {
        return BeginCreateCredentialUtil.Companion.convertToJetpackResponse$lambda$6(this.f21301a, obj);
    }
}
