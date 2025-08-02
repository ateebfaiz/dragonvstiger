package androidx.emoji2.viewsintegration;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

class d implements TransformationMethod {

    /* renamed from: a  reason: collision with root package name */
    private final TransformationMethod f15498a;

    d(TransformationMethod transformationMethod) {
        this.f15498a = transformationMethod;
    }

    public TransformationMethod a() {
        return this.f15498a;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f15498a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence == null || EmojiCompat.get().getLoadState() != 1) {
            return charSequence;
        }
        return EmojiCompat.get().process(charSequence);
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z10, int i10, Rect rect) {
        TransformationMethod transformationMethod = this.f15498a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z10, i10, rect);
        }
    }
}
