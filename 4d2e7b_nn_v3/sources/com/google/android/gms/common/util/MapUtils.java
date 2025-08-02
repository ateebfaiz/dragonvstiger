package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;

@KeepForSdk
public class MapUtils {
    @KeepForSdk
    public static void writeStringMapToJson(@NonNull StringBuilder sb2, @NonNull HashMap<String, String> hashMap) {
        sb2.append("{");
        boolean z10 = true;
        for (String next : hashMap.keySet()) {
            if (!z10) {
                sb2.append(",");
            }
            String str = hashMap.get(next);
            sb2.append("\"");
            sb2.append(next);
            sb2.append("\":");
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\"");
            }
            z10 = false;
        }
        sb2.append("}");
    }
}
