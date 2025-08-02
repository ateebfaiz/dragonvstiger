package f0;

import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import java.util.function.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class g1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f21299a;

    public /* synthetic */ g1(Function1 function1) {
        this.f21299a = function1;
    }

    public final Object apply(Object obj) {
        return BeginGetCredentialUtil.Companion.convertToFrameworkRequest$lambda$5(this.f21299a, obj);
    }
}
