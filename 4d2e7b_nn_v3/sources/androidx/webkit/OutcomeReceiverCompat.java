package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.webkit.Profile;
import java.lang.Throwable;

@Profile.ExperimentalUrlPrefetch
public interface OutcomeReceiverCompat<T, E extends Throwable> {
    void onError(@NonNull E e10);

    void onResult(T t10);
}
