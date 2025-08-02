package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class c implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final EditText f15491a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f15492b;

    /* renamed from: c  reason: collision with root package name */
    private EmojiCompat.InitCallback f15493c;

    /* renamed from: d  reason: collision with root package name */
    private int f15494d = Integer.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f15495e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15496f;

    private static class a extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference f15497a;

        a(EditText editText) {
            this.f15497a = new WeakReference(editText);
        }

        public void onInitialized() {
            super.onInitialized();
            c.c((EditText) this.f15497a.get(), 1);
        }
    }

    c(EditText editText, boolean z10) {
        this.f15491a = editText;
        this.f15492b = z10;
        this.f15496f = true;
    }

    private EmojiCompat.InitCallback a() {
        if (this.f15493c == null) {
            this.f15493c = new a(this.f15491a);
        }
        return this.f15493c;
    }

    static void c(EditText editText, int i10) {
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.get().process(editableText);
            b.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean g() {
        if (!this.f15496f || (!this.f15492b && !EmojiCompat.isConfigured())) {
            return true;
        }
        return false;
    }

    public void afterTextChanged(Editable editable) {
    }

    public boolean b() {
        return this.f15496f;
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    /* access modifiers changed from: package-private */
    public void d(int i10) {
        this.f15495e = i10;
    }

    public void e(boolean z10) {
        if (this.f15496f != z10) {
            if (this.f15493c != null) {
                EmojiCompat.get().unregisterInitCallback(this.f15493c);
            }
            this.f15496f = z10;
            if (z10) {
                c(this.f15491a, EmojiCompat.get().getLoadState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int i10) {
        this.f15494d = i10;
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (!this.f15491a.isInEditMode() && !g() && i11 <= i12 && (charSequence instanceof Spannable)) {
            int loadState = EmojiCompat.get().getLoadState();
            if (loadState != 0) {
                if (loadState == 1) {
                    EmojiCompat.get().process((Spannable) charSequence, i10, i10 + i12, this.f15494d, this.f15495e);
                    return;
                } else if (loadState != 3) {
                    return;
                }
            }
            EmojiCompat.get().registerInitCallback(a());
        }
    }
}
