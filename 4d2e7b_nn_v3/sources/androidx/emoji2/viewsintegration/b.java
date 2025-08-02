package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class b implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f15487a;

    /* renamed from: b  reason: collision with root package name */
    private EmojiCompat.InitCallback f15488b;

    private static class a extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference f15489a;

        /* renamed from: b  reason: collision with root package name */
        private final Reference f15490b;

        a(TextView textView, b bVar) {
            this.f15489a = new WeakReference(textView);
            this.f15490b = new WeakReference(bVar);
        }

        private boolean a(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        public void onInitialized() {
            CharSequence text;
            CharSequence process;
            super.onInitialized();
            TextView textView = (TextView) this.f15489a.get();
            if (a(textView, (InputFilter) this.f15490b.get()) && textView.isAttachedToWindow() && (text = textView.getText()) != (process = EmojiCompat.get().process(text))) {
                int selectionStart = Selection.getSelectionStart(process);
                int selectionEnd = Selection.getSelectionEnd(process);
                textView.setText(process);
                if (process instanceof Spannable) {
                    b.b((Spannable) process, selectionStart, selectionEnd);
                }
            }
        }
    }

    b(TextView textView) {
        this.f15487a = textView;
    }

    private EmojiCompat.InitCallback a() {
        if (this.f15488b == null) {
            this.f15488b = new a(this.f15487a, this);
        }
        return this.f15488b;
    }

    static void b(Spannable spannable, int i10, int i11) {
        if (i10 >= 0 && i11 >= 0) {
            Selection.setSelection(spannable, i10, i11);
        } else if (i10 >= 0) {
            Selection.setSelection(spannable, i10);
        } else if (i11 >= 0) {
            Selection.setSelection(spannable, i11);
        }
    }

    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        if (this.f15487a.isInEditMode()) {
            return charSequence;
        }
        int loadState = EmojiCompat.get().getLoadState();
        if (loadState != 0) {
            if (loadState != 1) {
                if (loadState != 3) {
                    return charSequence;
                }
            } else if ((i13 == 0 && i12 == 0 && spanned.length() == 0 && charSequence == this.f15487a.getText()) || charSequence == null) {
                return charSequence;
            } else {
                if (!(i10 == 0 && i11 == charSequence.length())) {
                    charSequence = charSequence.subSequence(i10, i11);
                }
                return EmojiCompat.get().process(charSequence, 0, charSequence.length());
            }
        }
        EmojiCompat.get().registerInitCallback(a());
        return charSequence;
    }
}
