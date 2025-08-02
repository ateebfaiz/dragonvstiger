package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

class d {

    /* renamed from: a  reason: collision with root package name */
    private final EditText f14324a;

    /* renamed from: b  reason: collision with root package name */
    private final EmojiEditTextHelper f14325b;

    d(EditText editText) {
        this.f14324a = editText;
        this.f14325b = new EmojiEditTextHelper(editText, false);
    }

    /* access modifiers changed from: package-private */
    public KeyListener a(KeyListener keyListener) {
        if (b(keyListener)) {
            return this.f14325b.getKeyListener(keyListener);
        }
        return keyListener;
    }

    /* access modifiers changed from: package-private */
    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f14325b.isEnabled();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void d(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = this.f14324a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i10, 0);
        try {
            boolean z10 = true;
            if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled)) {
                z10 = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true);
            }
            obtainStyledAttributes.recycle();
            f(z10);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public InputConnection e(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f14325b.onCreateInputConnection(inputConnection, editorInfo);
    }

    /* access modifiers changed from: package-private */
    public void f(boolean z10) {
        this.f14325b.setEnabled(z10);
    }
}
