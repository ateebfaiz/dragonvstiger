package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMappingDictionaryCreator")
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new zao();
    @SafeParcelable.VersionField(id = 1)
    final int zaa;
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zab;
    @SafeParcelable.Field(getter = "getRootClassName", id = 3)
    private final String zac;

    @SafeParcelable.Constructor
    zan(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) ArrayList<zal> arrayList, @SafeParcelable.Param(id = 3) String str) {
        this.zaa = i10;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            zal zal = arrayList.get(i11);
            String str2 = zal.zab;
            HashMap hashMap2 = new HashMap();
            int size2 = ((ArrayList) Preconditions.checkNotNull(zal.zac)).size();
            for (int i12 = 0; i12 < size2; i12++) {
                zam zam = zal.zac.get(i12);
                hashMap2.put(zam.zab, zam.zac);
            }
            hashMap.put(str2, hashMap2);
        }
        this.zab = hashMap;
        this.zac = (String) Preconditions.checkNotNull(str);
        zad();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (String next : this.zab.keySet()) {
            sb2.append(next);
            sb2.append(":\n");
            Map map = this.zab.get(next);
            for (String str : map.keySet()) {
                sb2.append("  ");
                sb2.append(str);
                sb2.append(": ");
                sb2.append(map.get(str));
            }
        }
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        ArrayList arrayList = new ArrayList();
        for (String next : this.zab.keySet()) {
            arrayList.add(new zal(next, this.zab.get(next)));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.writeString(parcel, 3, this.zac, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zaa() {
        return this.zac;
    }

    @Nullable
    public final Map<String, FastJsonResponse.Field<?, ?>> zab(String str) {
        return this.zab.get(str);
    }

    public final void zac() {
        for (String next : this.zab.keySet()) {
            Map map = this.zab.get(next);
            HashMap hashMap = new HashMap();
            for (String str : map.keySet()) {
                hashMap.put(str, ((FastJsonResponse.Field) map.get(str)).zab());
            }
            this.zab.put(next, hashMap);
        }
    }

    public final void zad() {
        for (String str : this.zab.keySet()) {
            Map map = this.zab.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).zai(this);
            }
        }
    }

    public final void zae(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.zab.put((String) Preconditions.checkNotNull(cls.getCanonicalName()), map);
    }

    public final boolean zaf(Class<? extends FastJsonResponse> cls) {
        return this.zab.containsKey(Preconditions.checkNotNull(cls.getCanonicalName()));
    }

    public zan(Class<? extends FastJsonResponse> cls) {
        this.zaa = 1;
        this.zab = new HashMap<>();
        this.zac = (String) Preconditions.checkNotNull(cls.getCanonicalName());
    }
}
