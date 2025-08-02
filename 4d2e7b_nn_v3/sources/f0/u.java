package f0;

import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import java.util.function.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class u implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f21302a;

    public /* synthetic */ u(Function1 function1) {
        this.f21302a = function1;
    }

    public final Object apply(Object obj) {
        return BeginCreateCredentialUtil.Companion.convertToJetpackResponse$lambda$7(this.f21302a, obj);
    }
}
