package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity
public class Preference {
    @ColumnInfo(name = "key")
    @NonNull
    @PrimaryKey
    public String mKey;
    @ColumnInfo(name = "long_value")
    @Nullable
    public Long mValue;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Preference(@NonNull String str, boolean z10) {
        this(str, z10 ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        if (!this.mKey.equals(preference.mKey)) {
            return false;
        }
        Long l10 = this.mValue;
        Long l11 = preference.mValue;
        if (l10 != null) {
            return l10.equals(l11);
        }
        if (l11 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.mKey.hashCode() * 31;
        Long l10 = this.mValue;
        if (l10 != null) {
            i10 = l10.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public Preference(@NonNull String str, long j10) {
        this.mKey = str;
        this.mValue = Long.valueOf(j10);
    }
}
