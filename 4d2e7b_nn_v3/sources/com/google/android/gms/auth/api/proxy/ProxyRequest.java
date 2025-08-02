package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Patterns;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@KeepForSdkWithMembers
@ShowFirstParty
@SafeParcelable.Class(creator = "ProxyRequestCreator")
public class ProxyRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zza();
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int LAST_CODE = 7;
    public static final int VERSION_CODE = 2;
    @SafeParcelable.Field(id = 4)
    @NonNull
    public final byte[] body;
    @SafeParcelable.Field(id = 2)
    public final int httpMethod;
    @SafeParcelable.Field(id = 3)
    public final long timeoutMillis;
    @SafeParcelable.Field(id = 1)
    @NonNull
    public final String url;
    @SafeParcelable.VersionField(id = 1000)
    final int zza;
    @SafeParcelable.Field(id = 5)
    Bundle zzb;

    @KeepForSdkWithMembers
    @ShowFirstParty
    public static class Builder {
        private final String zza;
        private int zzb = ProxyRequest.HTTP_METHOD_GET;
        private long zzc = 3000;
        private byte[] zzd = new byte[0];
        private final Bundle zze = new Bundle();

        public Builder(@NonNull String str) {
            Preconditions.checkNotEmpty(str);
            if (Patterns.WEB_URL.matcher(str).matches()) {
                this.zza = str;
                return;
            }
            throw new IllegalArgumentException("The supplied url [ " + str + "] is not match Patterns.WEB_URL!");
        }

        @NonNull
        public ProxyRequest build() {
            if (this.zzd == null) {
                this.zzd = new byte[0];
            }
            return new ProxyRequest(2, this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        @NonNull
        public Builder putHeader(@NonNull String str, @NonNull String str2) {
            Preconditions.checkNotEmpty(str, "Header name cannot be null or empty!");
            Bundle bundle = this.zze;
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString(str, str2);
            return this;
        }

        @NonNull
        public Builder setBody(@NonNull byte[] bArr) {
            this.zzd = bArr;
            return this;
        }

        @NonNull
        public Builder setHttpMethod(int i10) {
            boolean z10 = false;
            if (i10 >= 0 && i10 <= ProxyRequest.LAST_CODE) {
                z10 = true;
            }
            Preconditions.checkArgument(z10, "Unrecognized http method code.");
            this.zzb = i10;
            return this;
        }

        @NonNull
        public Builder setTimeoutMillis(long j10) {
            boolean z10;
            if (j10 >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "The specified timeout must be non-negative.");
            this.zzc = j10;
            return this;
        }
    }

    @SafeParcelable.Constructor
    ProxyRequest(@SafeParcelable.Param(id = 1000) int i10, @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) long j10, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) Bundle bundle) {
        this.zza = i10;
        this.url = str;
        this.httpMethod = i11;
        this.timeoutMillis = j10;
        this.body = bArr;
        this.zzb = bundle;
    }

    @NonNull
    public Map<String, String> getHeaderMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.zzb.size());
        for (String next : this.zzb.keySet()) {
            String string = this.zzb.getString(next);
            if (string == null) {
                string = "";
            }
            linkedHashMap.put(next, string);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    @NonNull
    public String toString() {
        String str = this.url;
        int i10 = this.httpMethod;
        return "ProxyRequest[ url: " + str + ", method: " + i10 + " ]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeInt(parcel, 2, this.httpMethod);
        SafeParcelWriter.writeLong(parcel, 3, this.timeoutMillis);
        SafeParcelWriter.writeByteArray(parcel, 4, this.body, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
