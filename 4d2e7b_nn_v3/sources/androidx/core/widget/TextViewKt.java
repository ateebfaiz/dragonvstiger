package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import vb.o;

public final class TextViewKt {
    public static final TextWatcher addTextChangedListener(TextView textView, o oVar, o oVar2, Function1<? super Editable, Unit> function1) {
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(function1, oVar, oVar2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, o oVar, o oVar2, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            oVar = TextViewKt$addTextChangedListener$1.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            oVar2 = TextViewKt$addTextChangedListener$2.INSTANCE;
        }
        if ((i10 & 4) != 0) {
            function1 = TextViewKt$addTextChangedListener$3.INSTANCE;
        }
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(function1, oVar, oVar2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static final TextWatcher doAfterTextChanged(TextView textView, Function1<? super Editable, Unit> function1) {
        TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 = new TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(function1);
        textView.addTextChangedListener(textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1);
        return textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1;
    }

    public static final TextWatcher doBeforeTextChanged(TextView textView, o oVar) {
        TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 = new TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(oVar);
        textView.addTextChangedListener(textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1);
        return textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1;
    }

    public static final TextWatcher doOnTextChanged(TextView textView, o oVar) {
        TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 textViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 = new TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1(oVar);
        textView.addTextChangedListener(textViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1);
        return textViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1;
    }
}
