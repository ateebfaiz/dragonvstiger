package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

abstract class g {

    private static final class a {
        /* JADX INFO: finally extract failed */
        @DoNotInline
        static boolean a(@NonNull DragEvent dragEvent, @NonNull TextView textView, @NonNull Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                ViewCompat.performReceiveContent(textView, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }

        @DoNotInline
        static boolean b(@NonNull DragEvent dragEvent, @NonNull View view, @NonNull Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build());
            return true;
        }
    }

    static boolean a(View view, DragEvent dragEvent) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 31 && i10 >= 24 && dragEvent.getLocalState() == null && ViewCompat.getOnReceiveContentMimeTypes(view) != null) {
            Activity c10 = c(view);
            if (c10 == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + view);
                return false;
            } else if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            } else {
                if (dragEvent.getAction() == 3) {
                    if (view instanceof TextView) {
                        return a.a(dragEvent, (TextView) view, c10);
                    }
                    return a.b(dragEvent, view, c10);
                }
            }
        }
        return false;
    }

    static boolean b(TextView textView, int i10) {
        ClipData clipData;
        int i11 = 0;
        if (Build.VERSION.SDK_INT >= 31 || ViewCompat.getOnReceiveContentMimeTypes(textView) == null || (i10 != 16908322 && i10 != 16908337)) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            clipData = null;
        } else {
            clipData = clipboardManager.getPrimaryClip();
        }
        if (clipData != null && clipData.getItemCount() > 0) {
            ContentInfoCompat.Builder builder = new ContentInfoCompat.Builder(clipData, 1);
            if (i10 != 16908322) {
                i11 = 1;
            }
            ViewCompat.performReceiveContent(textView, builder.setFlags(i11).build());
        }
        return true;
    }

    static Activity c(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
