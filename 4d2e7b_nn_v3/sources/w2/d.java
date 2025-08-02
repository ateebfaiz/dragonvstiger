package w2;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class d extends c implements g {
    public d(Executor executor) {
        super("SerialExecutor", 1, executor, new LinkedBlockingQueue());
    }

    public synchronized void execute(Runnable runnable) {
        super.execute(runnable);
    }
}
