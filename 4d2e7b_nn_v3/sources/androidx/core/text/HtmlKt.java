package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

public final class HtmlKt {
    public static final Spanned parseAsHtml(String str, int i10, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return HtmlCompat.fromHtml(str, i10, imageGetter, tagHandler);
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i10, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            imageGetter = null;
        }
        if ((i11 & 4) != 0) {
            tagHandler = null;
        }
        return HtmlCompat.fromHtml(str, i10, imageGetter, tagHandler);
    }

    public static final String toHtml(Spanned spanned, int i10) {
        return HtmlCompat.toHtml(spanned, i10);
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return HtmlCompat.toHtml(spanned, i10);
    }
}
