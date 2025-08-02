package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcelable;

public final class zzv implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v7, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r11) {
        /*
            r10 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r11)
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r1 = 0
            r3 = 0
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r3 = r1
        L_0x0010:
            int r1 = r11.dataPosition()
            if (r1 >= r0) goto L_0x0072
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r11)
            int r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r9 = 1
            if (r8 == r9) goto L_0x0066
            r9 = 2
            if (r8 == r9) goto L_0x0055
            r9 = 3
            if (r8 == r9) goto L_0x0049
            r9 = 4
            if (r8 == r9) goto L_0x003d
            r9 = 5
            if (r8 == r9) goto L_0x0031
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r11, r1)
            goto L_0x0010
        L_0x0031:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            r2.add(r1)
            goto L_0x0010
        L_0x003d:
            java.lang.String r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            r2.add(r1)
            goto L_0x0010
        L_0x0049:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            r2.add(r1)
            goto L_0x0010
        L_0x0055:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.accounttransfer.zzw> r4 = com.google.android.gms.auth.api.accounttransfer.zzw.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r11, r1, r4)
            r4 = r1
            com.google.android.gms.auth.api.accounttransfer.zzw r4 = (com.google.android.gms.auth.api.accounttransfer.zzw) r4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            r2.add(r1)
            goto L_0x0010
        L_0x0066:
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r11, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            r2.add(r1)
            goto L_0x0010
        L_0x0072:
            int r1 = r11.dataPosition()
            if (r1 != r0) goto L_0x007f
            com.google.android.gms.auth.api.accounttransfer.zzu r11 = new com.google.android.gms.auth.api.accounttransfer.zzu
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r11
        L_0x007f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException r1 = new com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Overread allowed size end="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0, r11)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.accounttransfer.zzv.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzu[i10];
    }
}
