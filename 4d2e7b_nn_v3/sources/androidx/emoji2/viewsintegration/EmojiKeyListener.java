package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.emoji2.text.EmojiCompat;

final class EmojiKeyListener implements KeyListener {

    /* renamed from: a  reason: collision with root package name */
    private final KeyListener f15478a;

    /* renamed from: b  reason: collision with root package name */
    private final EmojiCompatHandleKeyDownHelper f15479b;

    public static class EmojiCompatHandleKeyDownHelper {
        public boolean handleKeyDown(@NonNull Editable editable, int i10, @NonNull KeyEvent keyEvent) {
            return EmojiCompat.handleOnKeyDown(editable, i10, keyEvent);
        }
    }

    EmojiKeyListener(KeyListener keyListener) {
        this(keyListener, new EmojiCompatHandleKeyDownHelper());
    }

    public void clearMetaKeyState(View view, Editable editable, int i10) {
        this.f15478a.clearMetaKeyState(view, editable, i10);
    }

    public int getInputType() {
        return this.f15478a.getInputType();
    }

    public boolean onKeyDown(View view, Editable editable, int i10, KeyEvent keyEvent) {
        if (this.f15479b.handleKeyDown(editable, i10, keyEvent) || this.f15478a.onKeyDown(view, editable, i10, keyEvent)) {
            return true;
        }
        return false;
    }

    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f15478a.onKeyOther(view, editable, keyEvent);
    }

    public boolean onKeyUp(View view, Editable editable, int i10, KeyEvent keyEvent) {
        return this.f15478a.onKeyUp(view, editable, i10, keyEvent);
    }

    EmojiKeyListener(KeyListener keyListener, EmojiCompatHandleKeyDownHelper emojiCompatHandleKeyDownHelper) {
        this.f15478a = keyListener;
        this.f15479b = emojiCompatHandleKeyDownHelper;
    }
}
