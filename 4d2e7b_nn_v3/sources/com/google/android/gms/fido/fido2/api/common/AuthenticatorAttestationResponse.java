package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.fido.u2f.api.common.SignResponseData;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;
import com.google.android.gms.internal.fido.zzch;
import java.util.Arrays;

@SafeParcelable.Class(creator = "AuthenticatorAttestationResponseCreator")
@SafeParcelable.Reserved({1})
public class AuthenticatorAttestationResponse extends AuthenticatorResponse {
    @NonNull
    public static final Parcelable.Creator<AuthenticatorAttestationResponse> CREATOR = new zzk();
    @SafeParcelable.Field(getter = "getKeyHandle", id = 2)
    @NonNull
    private final byte[] zza;
    @SafeParcelable.Field(getter = "getClientDataJSON", id = 3)
    @NonNull
    private final byte[] zzb;
    @SafeParcelable.Field(getter = "getAttestationObject", id = 4)
    @NonNull
    private final byte[] zzc;
    @SafeParcelable.Field(getter = "getTransports", id = 5)
    @NonNull
    private final String[] zzd;

    @SafeParcelable.Constructor
    AuthenticatorAttestationResponse(@SafeParcelable.Param(id = 2) @NonNull byte[] bArr, @SafeParcelable.Param(id = 3) @NonNull byte[] bArr2, @SafeParcelable.Param(id = 4) @NonNull byte[] bArr3, @SafeParcelable.Param(id = 5) @NonNull String[] strArr) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = (byte[]) Preconditions.checkNotNull(bArr2);
        this.zzc = (byte[]) Preconditions.checkNotNull(bArr3);
        this.zzd = (String[]) Preconditions.checkNotNull(strArr);
    }

    @NonNull
    public static AuthenticatorAttestationResponse deserializeFromBytes(@NonNull byte[] bArr) {
        return (AuthenticatorAttestationResponse) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof AuthenticatorAttestationResponse)) {
            return false;
        }
        AuthenticatorAttestationResponse authenticatorAttestationResponse = (AuthenticatorAttestationResponse) obj;
        if (!Arrays.equals(this.zza, authenticatorAttestationResponse.zza) || !Arrays.equals(this.zzb, authenticatorAttestationResponse.zzb) || !Arrays.equals(this.zzc, authenticatorAttestationResponse.zzc)) {
            return false;
        }
        return true;
    }

    @NonNull
    public byte[] getAttestationObject() {
        return this.zzc;
    }

    @NonNull
    public byte[] getClientDataJSON() {
        return this.zzb;
    }

    @NonNull
    @Deprecated
    public byte[] getKeyHandle() {
        return this.zza;
    }

    @NonNull
    public String[] getTransports() {
        return this.zzd;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(Arrays.hashCode(this.zzb)), Integer.valueOf(Arrays.hashCode(this.zzc)));
    }

    @NonNull
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    @NonNull
    public String toString() {
        zzam zza2 = zzan.zza(this);
        zzch zzf = zzch.zzf();
        byte[] bArr = this.zza;
        zza2.zzb(SignResponseData.JSON_RESPONSE_DATA_KEY_HANDLE, zzf.zzg(bArr, 0, bArr.length));
        zzch zzf2 = zzch.zzf();
        byte[] bArr2 = this.zzb;
        zza2.zzb("clientDataJSON", zzf2.zzg(bArr2, 0, bArr2.length));
        zzch zzf3 = zzch.zzf();
        byte[] bArr3 = this.zzc;
        zza2.zzb("attestationObject", zzf3.zzg(bArr3, 0, bArr3.length));
        zza2.zzb("transports", Arrays.toString(this.zzd));
        return zza2.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getKeyHandle(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getClientDataJSON(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getAttestationObject(), false);
        SafeParcelWriter.writeStringArray(parcel, 5, getTransports(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x01f7 A[Catch:{ zzdq -> 0x0232, IllegalArgumentException -> 0x0220, zzdq -> 0x018b, JSONException -> 0x0018 }] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject zza() {
        /*
            r21 = this;
            r1 = r21
            r0 = 2
            r2 = 1
            r3 = 0
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0018 }
            r4.<init>()     // Catch:{ JSONException -> 0x0018 }
            byte[] r5 = r1.zzb     // Catch:{ JSONException -> 0x0018 }
            if (r5 == 0) goto L_0x001b
            java.lang.String r6 = "clientDataJSON"
            java.lang.String r5 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafeNoPadding(r5)     // Catch:{ JSONException -> 0x0018 }
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x0018 }
            goto L_0x001b
        L_0x0018:
            r0 = move-exception
            goto L_0x024f
        L_0x001b:
            byte[] r5 = r1.zzc     // Catch:{ JSONException -> 0x0018 }
            if (r5 == 0) goto L_0x0028
            java.lang.String r6 = "attestationObject"
            java.lang.String r5 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafeNoPadding(r5)     // Catch:{ JSONException -> 0x0018 }
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x0018 }
        L_0x0028:
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0018 }
            r5.<init>()     // Catch:{ JSONException -> 0x0018 }
            r6 = r3
        L_0x002e:
            java.lang.String[] r7 = r1.zzd     // Catch:{ JSONException -> 0x0018 }
            int r8 = r7.length     // Catch:{ JSONException -> 0x0018 }
            if (r6 >= r8) goto L_0x0050
            r7 = r7[r6]     // Catch:{ JSONException -> 0x0018 }
            com.google.android.gms.fido.common.Transport r8 = com.google.android.gms.fido.common.Transport.HYBRID     // Catch:{ JSONException -> 0x0018 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x0018 }
            boolean r7 = r7.equals(r8)     // Catch:{ JSONException -> 0x0018 }
            if (r7 == 0) goto L_0x0047
            java.lang.String r7 = "hybrid"
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x0018 }
            goto L_0x004e
        L_0x0047:
            java.lang.String[] r7 = r1.zzd     // Catch:{ JSONException -> 0x0018 }
            r7 = r7[r6]     // Catch:{ JSONException -> 0x0018 }
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x0018 }
        L_0x004e:
            int r6 = r6 + r2
            goto L_0x002e
        L_0x0050:
            java.lang.String r6 = "transports"
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x0018 }
            byte[] r5 = r1.zzc     // Catch:{ JSONException -> 0x0018 }
            com.google.android.gms.internal.fido.zzdr r5 = com.google.android.gms.internal.fido.zzdr.zzj(r5)     // Catch:{ zzdq -> 0x0246, zzdl -> 0x0244 }
            com.google.android.gms.internal.fido.zzdo r5 = r5.zzh()     // Catch:{ zzdq -> 0x0246, zzdl -> 0x0244 }
            com.google.android.gms.internal.fido.zzbg r5 = r5.zzc()     // Catch:{ zzdq -> 0x0232 }
            java.lang.String r6 = "authData"
            com.google.android.gms.internal.fido.zzdp r6 = com.google.android.gms.internal.fido.zzdr.zzi(r6)     // Catch:{ zzdq -> 0x0232 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ zzdq -> 0x0232 }
            com.google.android.gms.internal.fido.zzdr r5 = (com.google.android.gms.internal.fido.zzdr) r5     // Catch:{ zzdq -> 0x0232 }
            if (r5 == 0) goto L_0x0234
            com.google.android.gms.internal.fido.zzdk r5 = r5.zze()     // Catch:{ zzdq -> 0x0232 }
            com.google.android.gms.internal.fido.zzcz r5 = r5.zzc()     // Catch:{ zzdq -> 0x0232 }
            java.nio.ByteBuffer r6 = r5.zzi()     // Catch:{ JSONException -> 0x0018 }
            int r7 = r6.position()     // Catch:{ IllegalArgumentException -> 0x0220 }
            r8 = 32
            int r7 = r7 + r8
            r6.position(r7)     // Catch:{ IllegalArgumentException -> 0x0220 }
            byte r7 = r6.get()     // Catch:{ IllegalArgumentException -> 0x0220 }
            r7 = r7 & 64
            if (r7 == 0) goto L_0x0222
            int r7 = r6.position()     // Catch:{ IllegalArgumentException -> 0x0220 }
            int r7 = r7 + 4
            r6.position(r7)     // Catch:{ IllegalArgumentException -> 0x0220 }
            int r7 = r6.position()     // Catch:{ IllegalArgumentException -> 0x0220 }
            int r7 = r7 + 16
            r6.position(r7)     // Catch:{ IllegalArgumentException -> 0x0220 }
            short r7 = r6.getShort()     // Catch:{ IllegalArgumentException -> 0x0220 }
            int r9 = r6.position()     // Catch:{ IllegalArgumentException -> 0x0220 }
            int r9 = r9 + r7
            r6.position(r9)     // Catch:{ IllegalArgumentException -> 0x0220 }
            int r6 = r6.position()     // Catch:{ zzdq -> 0x0217, zzdl -> 0x0215 }
            int r7 = r5.zzd()     // Catch:{ zzdq -> 0x0217, zzdl -> 0x0215 }
            com.google.android.gms.internal.fido.zzcz r6 = r5.zzg(r6, r7)     // Catch:{ zzdq -> 0x0217, zzdl -> 0x0215 }
            java.io.InputStream r6 = r6.zzh()     // Catch:{ zzdq -> 0x0217, zzdl -> 0x0215 }
            com.google.android.gms.internal.fido.zzdr r6 = com.google.android.gms.internal.fido.zzdr.zzk(r6)     // Catch:{ zzdq -> 0x0217, zzdl -> 0x0215 }
            com.google.android.gms.internal.fido.zzdo r6 = r6.zzh()     // Catch:{ zzdq -> 0x0217, zzdl -> 0x0215 }
            com.google.android.gms.internal.fido.zzbg r7 = r6.zzc()     // Catch:{ JSONException -> 0x0018 }
            r9 = 3
            com.google.android.gms.internal.fido.zzdm r9 = com.google.android.gms.internal.fido.zzdr.zzg(r9)     // Catch:{ JSONException -> 0x0018 }
            java.lang.Object r7 = r7.get(r9)     // Catch:{ JSONException -> 0x0018 }
            com.google.android.gms.internal.fido.zzdr r7 = (com.google.android.gms.internal.fido.zzdr) r7     // Catch:{ JSONException -> 0x0018 }
            com.google.android.gms.internal.fido.zzbg r9 = r6.zzc()     // Catch:{ JSONException -> 0x0018 }
            r10 = 1
            com.google.android.gms.internal.fido.zzdm r12 = com.google.android.gms.internal.fido.zzdr.zzg(r10)     // Catch:{ JSONException -> 0x0018 }
            java.lang.Object r9 = r9.get(r12)     // Catch:{ JSONException -> 0x0018 }
            com.google.android.gms.internal.fido.zzdr r9 = (com.google.android.gms.internal.fido.zzdr) r9     // Catch:{ JSONException -> 0x0018 }
            java.lang.String r12 = "COSE key missing required fields"
            if (r7 == 0) goto L_0x020f
            if (r9 == 0) goto L_0x020f
            com.google.android.gms.internal.fido.zzdm r7 = r7.zzf()     // Catch:{ zzdq -> 0x018b }
            long r13 = r7.zzc()     // Catch:{ zzdq -> 0x018b }
            com.google.android.gms.internal.fido.zzdm r7 = r9.zzf()     // Catch:{ zzdq -> 0x018b }
            long r15 = r7.zzc()     // Catch:{ zzdq -> 0x018b }
            int r7 = (r15 > r10 ? 1 : (r15 == r10 ? 0 : -1))
            r17 = 2
            if (r7 == 0) goto L_0x010b
            int r7 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r7 != 0) goto L_0x0108
            r15 = r17
            goto L_0x010b
        L_0x0108:
            r9 = 0
            goto L_0x01e3
        L_0x010b:
            com.google.android.gms.internal.fido.zzbg r7 = r6.zzc()     // Catch:{ zzdq -> 0x018b }
            r19 = -1
            com.google.android.gms.internal.fido.zzdm r9 = com.google.android.gms.internal.fido.zzdr.zzg(r19)     // Catch:{ zzdq -> 0x018b }
            java.lang.Object r7 = r7.get(r9)     // Catch:{ zzdq -> 0x018b }
            com.google.android.gms.internal.fido.zzdr r7 = (com.google.android.gms.internal.fido.zzdr) r7     // Catch:{ zzdq -> 0x018b }
            if (r7 == 0) goto L_0x0201
            com.google.android.gms.internal.fido.zzdm r7 = r7.zzf()     // Catch:{ zzdq -> 0x018b }
            long r19 = r7.zzc()     // Catch:{ zzdq -> 0x018b }
            int r7 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            java.lang.String r9 = "COSE coordinates are the wrong size"
            r17 = -2
            if (r7 != 0) goto L_0x019a
            int r7 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r7 != 0) goto L_0x019a
            com.google.android.gms.internal.fido.zzbg r7 = r6.zzc()     // Catch:{ zzdq -> 0x018b }
            com.google.android.gms.internal.fido.zzdm r10 = com.google.android.gms.internal.fido.zzdr.zzg(r17)     // Catch:{ zzdq -> 0x018b }
            java.lang.Object r7 = r7.get(r10)     // Catch:{ zzdq -> 0x018b }
            com.google.android.gms.internal.fido.zzdr r7 = (com.google.android.gms.internal.fido.zzdr) r7     // Catch:{ zzdq -> 0x018b }
            com.google.android.gms.internal.fido.zzbg r6 = r6.zzc()     // Catch:{ zzdq -> 0x018b }
            r10 = -3
            com.google.android.gms.internal.fido.zzdm r10 = com.google.android.gms.internal.fido.zzdr.zzg(r10)     // Catch:{ zzdq -> 0x018b }
            java.lang.Object r6 = r6.get(r10)     // Catch:{ zzdq -> 0x018b }
            com.google.android.gms.internal.fido.zzdr r6 = (com.google.android.gms.internal.fido.zzdr) r6     // Catch:{ zzdq -> 0x018b }
            if (r7 == 0) goto L_0x0194
            if (r6 == 0) goto L_0x0194
            com.google.android.gms.internal.fido.zzdk r7 = r7.zze()     // Catch:{ zzdq -> 0x018b }
            com.google.android.gms.internal.fido.zzcz r7 = r7.zzc()     // Catch:{ zzdq -> 0x018b }
            com.google.android.gms.internal.fido.zzdk r6 = r6.zze()     // Catch:{ zzdq -> 0x018b }
            com.google.android.gms.internal.fido.zzcz r6 = r6.zzc()     // Catch:{ zzdq -> 0x018b }
            int r10 = r7.zzd()     // Catch:{ zzdq -> 0x018b }
            if (r10 != r8) goto L_0x018e
            int r10 = r6.zzd()     // Catch:{ zzdq -> 0x018b }
            if (r10 != r8) goto L_0x018e
            java.lang.String r8 = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE"
            byte[] r8 = android.util.Base64.decode(r8, r3)     // Catch:{ zzdq -> 0x018b }
            byte[] r7 = r7.zzm()     // Catch:{ zzdq -> 0x018b }
            byte[] r6 = r6.zzm()     // Catch:{ zzdq -> 0x018b }
            r9 = 3
            byte[][] r9 = new byte[r9][]     // Catch:{ zzdq -> 0x018b }
            r9[r3] = r8     // Catch:{ zzdq -> 0x018b }
            r9[r2] = r7     // Catch:{ zzdq -> 0x018b }
            r9[r0] = r6     // Catch:{ zzdq -> 0x018b }
            byte[] r9 = com.google.android.gms.internal.fido.zzcl.zza(r9)     // Catch:{ zzdq -> 0x018b }
            goto L_0x01e3
        L_0x018b:
            r0 = move-exception
            goto L_0x0207
        L_0x018e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzdq -> 0x018b }
            r0.<init>(r9)     // Catch:{ zzdq -> 0x018b }
            throw r0     // Catch:{ zzdq -> 0x018b }
        L_0x0194:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzdq -> 0x018b }
            r0.<init>(r12)     // Catch:{ zzdq -> 0x018b }
            throw r0     // Catch:{ zzdq -> 0x018b }
        L_0x019a:
            int r7 = (r15 > r10 ? 1 : (r15 == r10 ? 0 : -1))
            if (r7 != 0) goto L_0x0108
            r10 = 6
            int r7 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r7 != 0) goto L_0x0108
            com.google.android.gms.internal.fido.zzbg r6 = r6.zzc()     // Catch:{ zzdq -> 0x018b }
            com.google.android.gms.internal.fido.zzdm r7 = com.google.android.gms.internal.fido.zzdr.zzg(r17)     // Catch:{ zzdq -> 0x018b }
            java.lang.Object r6 = r6.get(r7)     // Catch:{ zzdq -> 0x018b }
            com.google.android.gms.internal.fido.zzdr r6 = (com.google.android.gms.internal.fido.zzdr) r6     // Catch:{ zzdq -> 0x018b }
            if (r6 == 0) goto L_0x01dd
            com.google.android.gms.internal.fido.zzdk r6 = r6.zze()     // Catch:{ zzdq -> 0x018b }
            com.google.android.gms.internal.fido.zzcz r6 = r6.zzc()     // Catch:{ zzdq -> 0x018b }
            int r7 = r6.zzd()     // Catch:{ zzdq -> 0x018b }
            if (r7 != r8) goto L_0x01d7
            java.lang.String r7 = "MCowBQYDK2VwAyEA"
            byte[] r7 = android.util.Base64.decode(r7, r3)     // Catch:{ zzdq -> 0x018b }
            byte[] r6 = r6.zzm()     // Catch:{ zzdq -> 0x018b }
            byte[][] r0 = new byte[r0][]     // Catch:{ zzdq -> 0x018b }
            r0[r3] = r7     // Catch:{ zzdq -> 0x018b }
            r0[r2] = r6     // Catch:{ zzdq -> 0x018b }
            byte[] r9 = com.google.android.gms.internal.fido.zzcl.zza(r0)     // Catch:{ zzdq -> 0x018b }
            goto L_0x01e3
        L_0x01d7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzdq -> 0x018b }
            r0.<init>(r9)     // Catch:{ zzdq -> 0x018b }
            throw r0     // Catch:{ zzdq -> 0x018b }
        L_0x01dd:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzdq -> 0x018b }
            r0.<init>(r12)     // Catch:{ zzdq -> 0x018b }
            throw r0     // Catch:{ zzdq -> 0x018b }
        L_0x01e3:
            java.lang.String r0 = "authenticatorData"
            byte[] r2 = r5.zzm()     // Catch:{ JSONException -> 0x0018 }
            java.lang.String r2 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafeNoPadding(r2)     // Catch:{ JSONException -> 0x0018 }
            r4.put(r0, r2)     // Catch:{ JSONException -> 0x0018 }
            java.lang.String r0 = "publicKeyAlgorithm"
            r4.put(r0, r13)     // Catch:{ JSONException -> 0x0018 }
            if (r9 == 0) goto L_0x0200
            java.lang.String r0 = "publicKey"
            java.lang.String r2 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafeNoPadding(r9)     // Catch:{ JSONException -> 0x0018 }
            r4.put(r0, r2)     // Catch:{ JSONException -> 0x0018 }
        L_0x0200:
            return r4
        L_0x0201:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzdq -> 0x018b }
            r0.<init>(r12)     // Catch:{ zzdq -> 0x018b }
            throw r0     // Catch:{ zzdq -> 0x018b }
        L_0x0207:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0018 }
            java.lang.String r3 = "COSE key ill-formed"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0018 }
            throw r2     // Catch:{ JSONException -> 0x0018 }
        L_0x020f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0018 }
            r0.<init>(r12)     // Catch:{ JSONException -> 0x0018 }
            throw r0     // Catch:{ JSONException -> 0x0018 }
        L_0x0215:
            r0 = move-exception
            goto L_0x0218
        L_0x0217:
            r0 = move-exception
        L_0x0218:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0018 }
            java.lang.String r3 = "failed to parse COSE key"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0018 }
            throw r2     // Catch:{ JSONException -> 0x0018 }
        L_0x0220:
            r0 = move-exception
            goto L_0x022a
        L_0x0222:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0220 }
            java.lang.String r2 = "authData does not include credential data"
            r0.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0220 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0220 }
        L_0x022a:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0018 }
            java.lang.String r3 = "ill-formed authenticator data"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0018 }
            throw r2     // Catch:{ JSONException -> 0x0018 }
        L_0x0232:
            r0 = move-exception
            goto L_0x023c
        L_0x0234:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzdq -> 0x0232 }
            java.lang.String r2 = "attestation object missing authData"
            r0.<init>(r2)     // Catch:{ zzdq -> 0x0232 }
            throw r0     // Catch:{ zzdq -> 0x0232 }
        L_0x023c:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0018 }
            java.lang.String r3 = "authData value has wrong type"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0018 }
            throw r2     // Catch:{ JSONException -> 0x0018 }
        L_0x0244:
            r0 = move-exception
            goto L_0x0247
        L_0x0246:
            r0 = move-exception
        L_0x0247:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0018 }
            java.lang.String r3 = "failed to parse attestation object"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0018 }
            throw r2     // Catch:{ JSONException -> 0x0018 }
        L_0x024f:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error encoding AuthenticatorAttestationResponse to JSON object"
            r2.<init>(r3, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse.zza():org.json.JSONObject");
    }
}
