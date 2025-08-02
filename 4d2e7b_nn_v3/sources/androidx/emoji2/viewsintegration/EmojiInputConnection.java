package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.emoji2.text.EmojiCompat;

final class EmojiInputConnection extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f15476a;

    /* renamed from: b  reason: collision with root package name */
    private final EmojiCompatDeleteHelper f15477b;

    public static class EmojiCompatDeleteHelper {
        public boolean handleDeleteSurroundingText(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i10, @IntRange(from = 0) int i11, boolean z10) {
            return EmojiCompat.handleDeleteSurroundingText(inputConnection, editable, i10, i11, z10);
        }

        public void updateEditorInfoAttrs(@NonNull EditorInfo editorInfo) {
            if (EmojiCompat.isConfigured()) {
                EmojiCompat.get().updateEditorInfo(editorInfo);
            }
        }
    }

    EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new EmojiCompatDeleteHelper());
    }

    private Editable a() {
        return this.f15476a.getEditableText();
    }

    public boolean deleteSurroundingText(int i10, int i11) {
        if (this.f15477b.handleDeleteSurroundingText(this, a(), i10, i11, false) || super.deleteSurroundingText(i10, i11)) {
            return true;
        }
        return false;
    }

    public boolean deleteSurroundingTextInCodePoints(int i10, int i11) {
        if (this.f15477b.handleDeleteSurroundingText(this, a(), i10, i11, true) || super.deleteSurroundingTextInCodePoints(i10, i11)) {
            return true;
        }
        return false;
    }

    EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, EmojiCompatDeleteHelper emojiCompatDeleteHelper) {
        super(inputConnection, false);
        this.f15476a = textView;
        this.f15477b = emojiCompatDeleteHelper;
        emojiCompatDeleteHelper.updateEditorInfoAttrs(editorInfo);
    }
}
