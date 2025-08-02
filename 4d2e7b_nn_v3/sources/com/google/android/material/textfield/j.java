package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;

class j extends f {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final TextWatcher f8649e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.OnEditTextAttachedListener f8650f = new b();

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.OnEndIconChangedListener f8651g = new c();

    class a extends TextWatcherAdapter {
        a() {
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            j jVar = j.this;
            jVar.f8620c.setChecked(!jVar.g());
        }
    }

    class b implements TextInputLayout.OnEditTextAttachedListener {
        b() {
        }

        public void onEditTextAttached(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            j jVar = j.this;
            jVar.f8620c.setChecked(!jVar.g());
            editText.removeTextChangedListener(j.this.f8649e);
            editText.addTextChangedListener(j.this.f8649e);
        }
    }

    class c implements TextInputLayout.OnEndIconChangedListener {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ EditText f8655a;

            a(EditText editText) {
                this.f8655a = editText;
            }

            public void run() {
                this.f8655a.removeTextChangedListener(j.this.f8649e);
            }
        }

        c() {
        }

        public void onEndIconChanged(TextInputLayout textInputLayout, int i10) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i10 == 1) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editText.post(new a(editText));
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            EditText editText = j.this.f8618a.getEditText();
            if (editText != null) {
                int selectionEnd = editText.getSelectionEnd();
                if (j.this.g()) {
                    editText.setTransformationMethod((TransformationMethod) null);
                } else {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
                j.this.f8618a.refreshEndIconDrawableState();
            }
        }
    }

    j(TextInputLayout textInputLayout, int i10) {
        super(textInputLayout, i10);
    }

    /* access modifiers changed from: private */
    public boolean g() {
        EditText editText = this.f8618a.getEditText();
        if (editText == null || !(editText.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            return false;
        }
        return true;
    }

    private static boolean h(EditText editText) {
        if (editText == null || (editText.getInputType() != 16 && editText.getInputType() != 128 && editText.getInputType() != 144 && editText.getInputType() != 224)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        TextInputLayout textInputLayout = this.f8618a;
        int i10 = this.f8621d;
        if (i10 == 0) {
            i10 = R.drawable.design_password_eye;
        }
        textInputLayout.setEndIconDrawable(i10);
        TextInputLayout textInputLayout2 = this.f8618a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(R.string.password_toggle_content_description));
        this.f8618a.setEndIconVisible(true);
        this.f8618a.setEndIconCheckable(true);
        this.f8618a.setEndIconOnClickListener(new d());
        this.f8618a.addOnEditTextAttachedListener(this.f8650f);
        this.f8618a.addOnEndIconChangedListener(this.f8651g);
        EditText editText = this.f8618a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
