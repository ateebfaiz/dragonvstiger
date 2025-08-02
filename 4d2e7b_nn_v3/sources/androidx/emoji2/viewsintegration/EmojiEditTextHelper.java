package androidx.emoji2.viewsintegration;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

public final class EmojiEditTextHelper {
    private int mEmojiReplaceStrategy;
    private final b mHelper;
    private int mMaxEmojiCount;

    private static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        private final EditText f15474a;

        /* renamed from: b  reason: collision with root package name */
        private final c f15475b;

        a(EditText editText, boolean z10) {
            this.f15474a = editText;
            c cVar = new c(editText, z10);
            this.f15475b = cVar;
            editText.addTextChangedListener(cVar);
            editText.setEditableFactory(a.getInstance());
        }

        /* access modifiers changed from: package-private */
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            if (keyListener instanceof NumberKeyListener) {
                return keyListener;
            }
            return new EmojiKeyListener(keyListener);
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f15475b.b();
        }

        /* access modifiers changed from: package-private */
        public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            if (inputConnection instanceof EmojiInputConnection) {
                return inputConnection;
            }
            return new EmojiInputConnection(this.f15474a, inputConnection, editorInfo);
        }

        /* access modifiers changed from: package-private */
        public void d(int i10) {
            this.f15475b.d(i10);
        }

        /* access modifiers changed from: package-private */
        public void e(boolean z10) {
            this.f15475b.e(z10);
        }

        /* access modifiers changed from: package-private */
        public void f(int i10) {
            this.f15475b.f(i10);
        }
    }

    static class b {
        b() {
        }

        /* access modifiers changed from: package-private */
        public abstract KeyListener a(KeyListener keyListener);

        /* access modifiers changed from: package-private */
        public abstract boolean b();

        /* access modifiers changed from: package-private */
        public abstract InputConnection c(InputConnection inputConnection, EditorInfo editorInfo);

        /* access modifiers changed from: package-private */
        public abstract void d(int i10);

        /* access modifiers changed from: package-private */
        public abstract void e(boolean z10);

        /* access modifiers changed from: package-private */
        public abstract void f(int i10);
    }

    public EmojiEditTextHelper(@NonNull EditText editText) {
        this(editText, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    @Nullable
    public KeyListener getKeyListener(@Nullable KeyListener keyListener) {
        return this.mHelper.a(keyListener);
    }

    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public boolean isEnabled() {
        return this.mHelper.b();
    }

    @Nullable
    public InputConnection onCreateInputConnection(@Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.mHelper.c(inputConnection, editorInfo);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEmojiReplaceStrategy(int i10) {
        this.mEmojiReplaceStrategy = i10;
        this.mHelper.d(i10);
    }

    public void setEnabled(boolean z10) {
        this.mHelper.e(z10);
    }

    public void setMaxEmojiCount(@IntRange(from = 0) int i10) {
        Preconditions.checkArgumentNonnegative(i10, "maxEmojiCount should be greater than 0");
        this.mMaxEmojiCount = i10;
        this.mHelper.f(i10);
    }

    public EmojiEditTextHelper(@NonNull EditText editText, boolean z10) {
        this.mMaxEmojiCount = Integer.MAX_VALUE;
        this.mEmojiReplaceStrategy = 0;
        Preconditions.checkNotNull(editText, "editText cannot be null");
        this.mHelper = new a(editText, z10);
    }
}
