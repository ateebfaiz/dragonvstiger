package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class z implements Executor {
    z() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
