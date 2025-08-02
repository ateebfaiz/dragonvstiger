package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialType;
import com.google.android.gms.internal.fido.zzbc;
import com.google.android.gms.internal.fido.zzh;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator = "PublicKeyCredentialDescriptorCreator")
@SafeParcelable.Reserved({1})
public class PublicKeyCredentialDescriptor extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialDescriptor> CREATOR = new zzam();
    private static final zzbc zza = zzbc.zzk(zzh.zza, zzh.zzb);
    @SafeParcelable.Field(getter = "getTypeAsString", id = 2, type = "java.lang.String")
    @NonNull
    private final PublicKeyCredentialType zzb;
    @SafeParcelable.Field(getter = "getId", id = 3)
    @NonNull
    private final byte[] zzc;
    @SafeParcelable.Field(getter = "getTransports", id = 4)
    @Nullable
    private final List zzd;

    public static class UnsupportedPubKeyCredDescriptorException extends Exception {
        public UnsupportedPubKeyCredDescriptorException(@NonNull String str) {
            super(str);
        }

        public UnsupportedPubKeyCredDescriptorException(@NonNull String str, @NonNull Throwable th) {
            super(str, th);
        }
    }

    @SafeParcelable.Constructor
    public PublicKeyCredentialDescriptor(@SafeParcelable.Param(id = 2) @NonNull String str, @SafeParcelable.Param(id = 3) @NonNull byte[] bArr, @SafeParcelable.Param(id = 4) @Nullable List<Transport> list) {
        Preconditions.checkNotNull(str);
        try {
            this.zzb = PublicKeyCredentialType.fromString(str);
            this.zzc = (byte[]) Preconditions.checkNotNull(bArr);
            this.zzd = list;
        } catch (PublicKeyCredentialType.UnsupportedPublicKeyCredTypeException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        if (!(obj instanceof PublicKeyCredentialDescriptor)) {
            return false;
        }
        PublicKeyCredentialDescriptor publicKeyCredentialDescriptor = (PublicKeyCredentialDescriptor) obj;
        if (!this.zzb.equals(publicKeyCredentialDescriptor.zzb) || !Arrays.equals(this.zzc, publicKeyCredentialDescriptor.zzc)) {
            return false;
        }
        List list2 = this.zzd;
        if (list2 == null && publicKeyCredentialDescriptor.zzd == null) {
            return true;
        }
        if (list2 == null || (list = publicKeyCredentialDescriptor.zzd) == null || !list2.containsAll(list) || !publicKeyCredentialDescriptor.zzd.containsAll(this.zzd)) {
            return false;
        }
        return true;
    }

    @NonNull
    public byte[] getId() {
        return this.zzc;
    }

    @Nullable
    public List<Transport> getTransports() {
        return this.zzd;
    }

    @NonNull
    public PublicKeyCredentialType getType() {
        return this.zzb;
    }

    @NonNull
    public String getTypeAsString() {
        return this.zzb.toString();
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getTypeAsString(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getId(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getTransports(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
