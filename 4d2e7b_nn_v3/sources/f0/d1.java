package f0;

import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import java.util.function.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f21296a;

    public /* synthetic */ d1(Function1 function1) {
        this.f21296a = function1;
    }

    public final Object apply(Object obj) {
        return BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$6(this.f21296a, obj);
    }
}
