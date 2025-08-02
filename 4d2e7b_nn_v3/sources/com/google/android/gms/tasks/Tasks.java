package com.google.android.gms.tasks;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.tasks.zza;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
    private Tasks() {
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        d dVar = new d((zzac) null);
        zzb(task, dVar);
        dVar.a();
        return zza(task);
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> call(@NonNull Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    @NonNull
    public static <TResult> Task<TResult> forCanceled() {
        c0 c0Var = new c0();
        c0Var.c();
        return c0Var;
    }

    @NonNull
    public static <TResult> Task<TResult> forException(@NonNull Exception exc) {
        c0 c0Var = new c0();
        c0Var.a(exc);
        return c0Var;
    }

    @NonNull
    public static <TResult> Task<TResult> forResult(TResult tresult) {
        c0 c0Var = new c0();
        c0Var.b(tresult);
        return c0Var;
    }

    @NonNull
    public static Task<Void> whenAll(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult((Object) null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        c0 c0Var = new c0();
        f fVar = new f(collection.size(), c0Var);
        for (Task zzb : collection) {
            zzb(zzb, fVar);
        }
        return c0Var;
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll(collection).continueWithTask(TaskExecutors.MAIN_THREAD, new c(collection));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Collection<? extends Task> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll((Collection<? extends Task<?>>) collection).continueWith(TaskExecutors.MAIN_THREAD, new b(collection));
    }

    @NonNull
    public static <T> Task<T> withTimeout(@NonNull Task<T> task, long j10, @NonNull TimeUnit timeUnit) {
        boolean z10;
        Preconditions.checkNotNull(task, "Task must not be null");
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "Timeout must be positive");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        g gVar = new g();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(gVar);
        zza zza = new zza(Looper.getMainLooper());
        zza.postDelayed(new zzx(taskCompletionSource), timeUnit.toMillis(j10));
        task.addOnCompleteListener(new zzy(zza, taskCompletionSource, gVar));
        return taskCompletionSource.getTask();
    }

    private static Object zza(@NonNull Task task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    private static void zzb(Task task, e eVar) {
        Executor executor = TaskExecutors.zza;
        task.addOnSuccessListener(executor, eVar);
        task.addOnFailureListener(executor, (OnFailureListener) eVar);
        task.addOnCanceledListener(executor, (OnCanceledListener) eVar);
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> call(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        c0 c0Var = new c0();
        executor.execute(new d0(c0Var, callable));
        return c0Var;
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@Nullable Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllComplete((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Task... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllSuccess((Collection<? extends Task>) Arrays.asList(taskArr));
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task, long j10, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        d dVar = new d((zzac) null);
        zzb(task, dVar);
        if (dVar.b(j10, timeUnit)) {
            return zza(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @NonNull
    public static Task<Void> whenAll(@Nullable Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult((Object) null);
        }
        return whenAll((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }
}
