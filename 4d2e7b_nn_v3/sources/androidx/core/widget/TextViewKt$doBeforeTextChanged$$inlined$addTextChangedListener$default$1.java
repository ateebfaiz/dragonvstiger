package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import vb.o;

public final class TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ o $beforeTextChanged;

    public TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(o oVar) {
        this.$beforeTextChanged = oVar;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
