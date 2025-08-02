package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public abstract class InputMergerFactory {

    class a extends InputMergerFactory {
        a() {
        }

        public InputMerger createInputMerger(String str) {
            return null;
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static InputMergerFactory getDefaultInputMergerFactory() {
        return new a();
    }

    @Nullable
    public abstract InputMerger createInputMerger(@NonNull String str);

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final InputMerger createInputMergerWithDefaultFallback(@NonNull String str) {
        InputMerger createInputMerger = createInputMerger(str);
        if (createInputMerger == null) {
            return InputMerger.fromClassName(str);
        }
        return createInputMerger;
    }
}
