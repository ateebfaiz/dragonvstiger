package androidx.core.view.autofill;

import android.view.autofill.AutofillId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import e0.a;

public class AutofillIdCompat {
    private final Object mWrappedObj;

    @RequiresApi(26)
    private AutofillIdCompat(@NonNull AutofillId autofillId) {
        this.mWrappedObj = autofillId;
    }

    @RequiresApi(26)
    @NonNull
    public static AutofillIdCompat toAutofillIdCompat(@NonNull AutofillId autofillId) {
        return new AutofillIdCompat(autofillId);
    }

    @RequiresApi(26)
    @NonNull
    public AutofillId toAutofillId() {
        return a.a(this.mWrappedObj);
    }
}
