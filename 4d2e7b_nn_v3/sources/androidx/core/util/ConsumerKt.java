package androidx.core.util;

import androidx.annotation.RequiresApi;
import java.util.function.Consumer;
import kotlin.coroutines.d;

@RequiresApi(24)
public final class ConsumerKt {
    @RequiresApi(24)
    public static final <T> Consumer<T> asConsumer(d dVar) {
        return b.a(new c(dVar));
    }
}
