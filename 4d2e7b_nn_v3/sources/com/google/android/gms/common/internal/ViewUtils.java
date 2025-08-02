package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class ViewUtils {
    private ViewUtils() {
    }

    @KeepForSdk
    @Nullable
    public static String getXmlAttributeString(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z10, boolean z11, @NonNull String str3) {
        String str4;
        if (attributeSet == null) {
            str4 = null;
        } else {
            str4 = attributeSet.getAttributeValue(str, str2);
        }
        if (str4 != null && str4.startsWith("@string/") && z10) {
            String substring = str4.substring(8);
            String packageName = context.getPackageName();
            TypedValue typedValue = new TypedValue();
            try {
                Resources resources = context.getResources();
                resources.getValue(packageName + ":string/" + substring, typedValue, true);
            } catch (Resources.NotFoundException unused) {
                Log.w(str3, "Could not find resource for " + str2 + ": " + str4);
            }
            CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                str4 = charSequence.toString();
            } else {
                String obj = typedValue.toString();
                Log.w(str3, "Resource " + str2 + " was not a string: " + obj);
            }
        }
        if (z11 && str4 == null) {
            Log.w(str3, "Required XML attribute \"" + str2 + "\" missing");
        }
        return str4;
    }
}
