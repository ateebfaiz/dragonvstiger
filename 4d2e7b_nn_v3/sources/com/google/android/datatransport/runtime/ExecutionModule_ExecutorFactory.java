package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import java.util.concurrent.Executor;

public final class ExecutionModule_ExecutorFactory implements Factory<Executor> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final ExecutionModule_ExecutorFactory f6424a = new ExecutionModule_ExecutorFactory();
    }

    public static ExecutionModule_ExecutorFactory create() {
        return a.f6424a;
    }

    public static Executor executor() {
        return (Executor) Preconditions.checkNotNull(e.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Executor get() {
        return executor();
    }
}
