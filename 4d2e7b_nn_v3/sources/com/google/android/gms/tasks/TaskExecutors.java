package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public final class TaskExecutors {
    @NonNull
    public static final Executor MAIN_THREAD = new a0();
    static final Executor zza = new z();

    private TaskExecutors() {
    }
}
