package c0;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;

public final /* synthetic */ class b implements Executor {
    public final void execute(Runnable runnable) {
        ArchTaskExecutor.getInstance().executeOnDiskIO(runnable);
    }
}
