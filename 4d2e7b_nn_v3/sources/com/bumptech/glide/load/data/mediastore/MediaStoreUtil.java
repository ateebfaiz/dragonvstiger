package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;

public final class MediaStoreUtil {
    private static final int MINI_THUMB_HEIGHT = 384;
    private static final int MINI_THUMB_WIDTH = 512;

    private MediaStoreUtil() {
    }

    public static boolean isMediaStoreImageUri(Uri uri) {
        if (!isMediaStoreUri(uri) || isVideoUri(uri)) {
            return false;
        }
        return true;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        if (uri == null || !FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme()) || !"media".equals(uri.getAuthority())) {
            return false;
        }
        return true;
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        if (!isMediaStoreUri(uri) || !isVideoUri(uri)) {
            return false;
        }
        return true;
    }

    public static boolean isThumbnailSize(int i10, int i11) {
        return i10 != Integer.MIN_VALUE && i11 != Integer.MIN_VALUE && i10 <= 512 && i11 <= MINI_THUMB_HEIGHT;
    }

    private static boolean isVideoUri(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
