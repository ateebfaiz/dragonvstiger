package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

final class AppCompatTextClassifierHelper {

    /* renamed from: a  reason: collision with root package name */
    private TextView f14214a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f14215b;

    private static final class a {
        @DoNotInline
        @NonNull
        static TextClassifier a(@NonNull TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
    }

    AppCompatTextClassifierHelper(TextView textView) {
        this.f14214a = (TextView) Preconditions.checkNotNull(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f14215b;
        if (textClassifier == null) {
            return a.a(this.f14214a);
        }
        return textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f14215b = textClassifier;
    }
}
