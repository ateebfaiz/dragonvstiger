package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.Map;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMappingDictionaryEntryCreator")
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new zap();
    @SafeParcelable.VersionField(id = 1)
    final int zaa;
    @SafeParcelable.Field(id = 2)
    final String zab;
    @SafeParcelable.Field(id = 3)
    @Nullable
    final ArrayList<zam> zac;

    @SafeParcelable.Constructor
    zal(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) ArrayList<zam> arrayList) {
        this.zaa = i10;
        this.zab = str;
        this.zac = arrayList;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeString(parcel, 2, this.zab, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zac, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    zal(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zam> arrayList;
        this.zaa = 1;
        this.zab = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String next : map.keySet()) {
                arrayList.add(new zam(next, map.get(next)));
            }
        }
        this.zac = arrayList;
    }
}
