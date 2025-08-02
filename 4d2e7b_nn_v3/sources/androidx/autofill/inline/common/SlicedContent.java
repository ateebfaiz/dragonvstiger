package androidx.autofill.inline.common;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.autofill.inline.UiVersions;

@RequiresApi(api = 30)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class SlicedContent implements UiVersions.Content {
    static final Uri INLINE_SLICE_URI = Uri.parse("inline.slice");
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    protected final Slice mSlice;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class Builder<T extends SlicedContent> {
        @NonNull
        protected final Slice.Builder mSliceBuilder;

        protected Builder(@NonNull String str) {
            e.a();
            this.mSliceBuilder = d.a(SlicedContent.INLINE_SLICE_URI, c.a(str, 1));
        }

        @NonNull
        public abstract T build();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    protected SlicedContent(@NonNull Slice slice) {
        this.mSlice = slice;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String getVersion(@NonNull Slice slice) {
        return slice.getSpec().getType();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract PendingIntent getAttributionIntent();

    @NonNull
    public final Slice getSlice() {
        return this.mSlice;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract boolean isValid();
}
