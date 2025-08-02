package com.google.android.datatransport.runtime.retries;

public final class Retries {
    private Retries() {
    }

    public static <TInput, TResult, TException extends Throwable> TResult retry(int i10, TInput tinput, Function<TInput, TResult, TException> function, RetryStrategy<TInput, TResult> retryStrategy) throws Throwable {
        TResult apply;
        if (i10 < 1) {
            return function.apply(tinput);
        }
        do {
            apply = function.apply(tinput);
            tinput = retryStrategy.shouldRetry(tinput, apply);
            if (tinput == null || i10 - 1 < 1) {
                return apply;
            }
            apply = function.apply(tinput);
            tinput = retryStrategy.shouldRetry(tinput, apply);
            break;
        } while (i10 - 1 < 1);
        return apply;
    }
}
