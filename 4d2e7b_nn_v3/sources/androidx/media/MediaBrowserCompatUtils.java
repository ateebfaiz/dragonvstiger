package androidx.media;

import android.os.Bundle;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MediaBrowserCompatUtils {
    private MediaBrowserCompatUtils() {
    }

    public static boolean areSameOptions(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null) {
            if (bundle2.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) {
                return true;
            }
            return false;
        } else if (bundle2 == null) {
            if (bundle.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) {
                return true;
            }
            return false;
        } else if (bundle.getInt("android.media.browse.extra.PAGE", -1) == bundle2.getInt("android.media.browse.extra.PAGE", -1) && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean hasDuplicatedItems(Bundle bundle, Bundle bundle2) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        if (bundle == null) {
            i10 = -1;
        } else {
            i10 = bundle.getInt("android.media.browse.extra.PAGE", -1);
        }
        if (bundle2 == null) {
            i11 = -1;
        } else {
            i11 = bundle2.getInt("android.media.browse.extra.PAGE", -1);
        }
        if (bundle == null) {
            i12 = -1;
        } else {
            i12 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        }
        if (bundle2 == null) {
            i13 = -1;
        } else {
            i13 = bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        }
        int i17 = Integer.MAX_VALUE;
        if (i10 == -1 || i12 == -1) {
            i14 = Integer.MAX_VALUE;
            i15 = 0;
        } else {
            i15 = i10 * i12;
            i14 = (i12 + i15) - 1;
        }
        if (i11 == -1 || i13 == -1) {
            i16 = 0;
        } else {
            i16 = i11 * i13;
            i17 = (i13 + i16) - 1;
        }
        if (i14 < i16 || i17 < i15) {
            return false;
        }
        return true;
    }
}
