package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;

public interface a extends p {
    void b(CancellationException cancellationException);

    ReceiveChannel s();
}
