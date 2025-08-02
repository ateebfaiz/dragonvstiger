package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zae implements Parcelable.Creator<GoogleSignInOptions> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        ArrayList<Scope> arrayList = null;
        Account account = null;
        String str = null;
        String str2 = null;
        ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2 = null;
        String str3 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i10 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.createParcelable(parcel, readHeader, Account.CREATOR);
                    break;
                case 4:
                    z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 7:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    arrayList2 = SafeParcelReader.createTypedList(parcel, readHeader, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case 10:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new GoogleSignInOptions(i10, arrayList, account, z10, z11, z12, str, str2, arrayList2, str3);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new GoogleSignInOptions[i10];
    }
}
