package f0;

import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class e1 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f21297a;

    public /* synthetic */ e1(Function1 function1) {
        this.f21297a = function1;
    }

    public final boolean test(Object obj) {
        return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$7(this.f21297a, obj);
    }
}
