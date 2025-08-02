package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    private static CharSequence coerceToText(@NonNull Context context, @NonNull ClipData.Item item, int i10) {
        if ((i10 & 1) == 0) {
            return item.coerceToStyledText(context);
        }
        CharSequence coerceToText = item.coerceToText(context);
        if (coerceToText instanceof Spanned) {
            return coerceToText.toString();
        }
        return coerceToText;
    }

    private static void replaceSelection(@NonNull Editable editable, @NonNull CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    @Nullable
    public ContentInfoCompat onReceiveContent(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable(LOG_TAG, 3)) {
            Log.d(LOG_TAG, "onReceive: " + contentInfoCompat);
        }
        if (contentInfoCompat.getSource() == 2) {
            return contentInfoCompat;
        }
        ClipData clip = contentInfoCompat.getClip();
        int flags = contentInfoCompat.getFlags();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z10 = false;
        for (int i10 = 0; i10 < clip.getItemCount(); i10++) {
            CharSequence coerceToText = coerceToText(context, clip.getItemAt(i10), flags);
            if (coerceToText != null) {
                if (!z10) {
                    replaceSelection(editable, coerceToText);
                    z10 = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), coerceToText);
                }
            }
        }
        return null;
    }
}
