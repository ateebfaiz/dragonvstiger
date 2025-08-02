package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import vb.o;

public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ Function1<Editable, Unit> $afterTextChanged;
    final /* synthetic */ o $beforeTextChanged;
    final /* synthetic */ o $onTextChanged;

    public TextViewKt$addTextChangedListener$textWatcher$1(Function1<? super Editable, Unit> function1, o oVar, o oVar2) {
        this.$afterTextChanged = function1;
        this.$beforeTextChanged = oVar;
        this.$onTextChanged = oVar2;
    }

    public void afterTextChanged(Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }
}
