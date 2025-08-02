package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;

class f implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f6485a;

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f6486a;

        a(Runnable runnable) {
            this.f6486a = runnable;
        }

        public void run() {
            try {
                this.f6486a.run();
            } catch (Exception e10) {
                Logging.e("Executor", "Background execution failure.", e10);
            }
        }
    }

    f(Executor executor) {
        this.f6485a = executor;
    }

    public void execute(Runnable runnable) {
        this.f6485a.execute(new a(runnable));
    }
}
