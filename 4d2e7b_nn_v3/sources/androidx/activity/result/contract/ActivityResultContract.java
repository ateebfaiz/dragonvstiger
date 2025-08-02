package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.m;

public abstract class ActivityResultContract<I, O> {

    public static final class SynchronousResult<T> {
        private final T value;

        public SynchronousResult(T t10) {
            this.value = t10;
        }

        public final T getValue() {
            return this.value;
        }
    }

    public abstract Intent createIntent(Context context, I i10);

    public SynchronousResult<O> getSynchronousResult(Context context, I i10) {
        m.f(context, "context");
        return null;
    }

    public abstract O parseResult(int i10, Intent intent);
}
