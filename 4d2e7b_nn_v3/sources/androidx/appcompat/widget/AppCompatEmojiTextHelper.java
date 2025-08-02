package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

class AppCompatEmojiTextHelper {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f14190a;

    /* renamed from: b  reason: collision with root package name */
    private final EmojiTextViewHelper f14191b;

    AppCompatEmojiTextHelper(TextView textView) {
        this.f14190a = textView;
        this.f14191b = new EmojiTextViewHelper(textView, false);
    }

    /* access modifiers changed from: package-private */
    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f14191b.getFilters(inputFilterArr);
    }

    public boolean b() {
        return this.f14191b.isEnabled();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = this.f14190a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i10, 0);
        try {
            boolean z10 = true;
            if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled)) {
                z10 = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true);
            }
            obtainStyledAttributes.recycle();
            e(z10);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(boolean z10) {
        this.f14191b.setAllCaps(z10);
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z10) {
        this.f14191b.setEnabled(z10);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f14191b.wrapTransformationMethod(transformationMethod);
    }
}
