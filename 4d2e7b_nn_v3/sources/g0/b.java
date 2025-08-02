package g0;

import androidx.credentials.webauthn.Cbor;
import java.util.Comparator;
import kotlin.jvm.internal.y;

public final /* synthetic */ class b implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y f21570a;

    public /* synthetic */ b(y yVar) {
        this.f21570a = yVar;
    }

    public final int compare(Object obj, Object obj2) {
        return Cbor.encode$lambda$0(this.f21570a, (byte[]) obj, (byte[]) obj2);
    }
}
