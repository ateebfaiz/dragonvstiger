package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

@KeepForSdk
public final class HexDumpUtils {
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    @Nullable
    public static String dump(@NonNull byte[] bArr, int i10, int i11, boolean z10) {
        int length;
        int i12;
        if (bArr == null || (length = bArr.length) == 0 || i10 < 0 || i11 <= 0 || i10 + i11 > length) {
            return null;
        }
        if (z10) {
            i12 = 75;
        } else {
            i12 = 57;
        }
        StringBuilder sb2 = new StringBuilder(i12 * ((i11 + 15) / 16));
        int i13 = i11;
        int i14 = 0;
        int i15 = 0;
        while (i13 > 0) {
            if (i14 == 0) {
                if (i11 < 65536) {
                    sb2.append(String.format("%04X:", new Object[]{Integer.valueOf(i10)}));
                } else {
                    sb2.append(String.format("%08X:", new Object[]{Integer.valueOf(i10)}));
                }
                i15 = i10;
            } else if (i14 == 8) {
                sb2.append(" -");
            }
            sb2.append(String.format(" %02X", new Object[]{Integer.valueOf(bArr[i10] & 255)}));
            i13--;
            i14++;
            if (z10 && (i14 == 16 || i13 == 0)) {
                int i16 = 16 - i14;
                if (i16 > 0) {
                    for (int i17 = 0; i17 < i16; i17++) {
                        sb2.append("   ");
                    }
                }
                if (i16 >= 8) {
                    sb2.append("  ");
                }
                sb2.append("  ");
                for (int i18 = 0; i18 < i14; i18++) {
                    char c10 = (char) bArr[i15 + i18];
                    if (c10 < ' ' || c10 > '~') {
                        c10 = '.';
                    }
                    sb2.append(c10);
                }
            }
            if (i14 == 16 || i13 == 0) {
                sb2.append(10);
                i14 = 0;
            }
            i10++;
        }
        return sb2.toString();
    }
}
