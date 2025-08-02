package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class MurmurHash3 {
    private MurmurHash3() {
    }

    @KeepForSdk
    public static int murmurhash3_x86_32(@NonNull byte[] bArr, int i10, int i11, int i12) {
        int i13;
        int i14 = i10;
        while (true) {
            i13 = (i11 & -4) + i10;
            if (i14 >= i13) {
                break;
            }
            int i15 = ((bArr[i14] & 255) | ((bArr[i14 + 1] & 255) << 8) | ((bArr[i14 + 2] & 255) << 16) | (bArr[i14 + 3] << 24)) * -862048943;
            int i16 = i12 ^ (((i15 >>> 17) | (i15 << 15)) * 461845907);
            i12 = (((i16 >>> 19) | (i16 << 13)) * 5) - 430675100;
            i14 += 4;
        }
        int i17 = i11 & 3;
        int i18 = 0;
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 == 3) {
                    i18 = (bArr[i13 + 2] & 255) << 16;
                }
                int i19 = i12 ^ i11;
                int i20 = (i19 ^ (i19 >>> 16)) * -2048144789;
                int i21 = (i20 ^ (i20 >>> 13)) * -1028477387;
                return i21 ^ (i21 >>> 16);
            }
            i18 |= (bArr[i13 + 1] & 255) << 8;
        }
        int i22 = ((bArr[i13] & 255) | i18) * -862048943;
        i12 ^= ((i22 >>> 17) | (i22 << 15)) * 461845907;
        int i192 = i12 ^ i11;
        int i202 = (i192 ^ (i192 >>> 16)) * -2048144789;
        int i212 = (i202 ^ (i202 >>> 13)) * -1028477387;
        return i212 ^ (i212 >>> 16);
    }
}
