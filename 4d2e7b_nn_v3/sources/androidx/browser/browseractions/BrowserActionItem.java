package androidx.browser.browseractions;

import android.app.PendingIntent;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class BrowserActionItem {
    private final PendingIntent mAction;
    @DrawableRes
    private final int mIconId;
    private final String mTitle;

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent, @DrawableRes int i10) {
        this.mTitle = str;
        this.mAction = pendingIntent;
        this.mIconId = i10;
    }

    public PendingIntent getAction() {
        return this.mAction;
    }

    public int getIconId() {
        return this.mIconId;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent) {
        this(str, pendingIntent, 0);
    }
}
