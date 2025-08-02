package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import vb.o;

public final class TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ o $onTextChanged;

    public TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1(o oVar) {
        this.$onTextChanged = oVar;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }
}
