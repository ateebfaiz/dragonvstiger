package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.functions.Function1;

public final class TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ Function1 $afterTextChanged;

    public TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(Function1 function1) {
        this.$afterTextChanged = function1;
    }

    public void afterTextChanged(Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
