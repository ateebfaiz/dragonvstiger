package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

public final class LocusIdCompat {
    private final String mId;
    private final LocusId mWrapped;

    private static class a {
        static LocusId a(String str) {
            return new LocusId(str);
        }

        static String b(LocusId locusId) {
            return locusId.getId();
        }
    }

    public LocusIdCompat(@NonNull String str) {
        this.mId = (String) Preconditions.checkStringNotEmpty(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.mWrapped = a.a(str);
        } else {
            this.mWrapped = null;
        }
    }

    @NonNull
    private String getSanitizedId() {
        int length = this.mId.length();
        return length + "_chars";
    }

    @RequiresApi(29)
    @NonNull
    public static LocusIdCompat toLocusIdCompat(@NonNull LocusId locusId) {
        Preconditions.checkNotNull(locusId, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.checkStringNotEmpty(a.b(locusId), "id cannot be empty"));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LocusIdCompat.class != obj.getClass()) {
            return false;
        }
        LocusIdCompat locusIdCompat = (LocusIdCompat) obj;
        String str = this.mId;
        if (str != null) {
            return str.equals(locusIdCompat.mId);
        }
        if (locusIdCompat.mId == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    public int hashCode() {
        int i10;
        String str = this.mId;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        return 31 + i10;
    }

    @RequiresApi(29)
    @NonNull
    public LocusId toLocusId() {
        return this.mWrapped;
    }

    @NonNull
    public String toString() {
        return "LocusIdCompat[" + getSanitizedId() + "]";
    }
}
