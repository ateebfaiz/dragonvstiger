package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import kotlin.coroutines.d;

@RequiresApi(31)
public final class OutcomeReceiverKt {
    @RequiresApi(31)
    public static final <R, E extends Throwable> OutcomeReceiver asOutcomeReceiver(d dVar) {
        return o.a(new b(dVar));
    }
}
