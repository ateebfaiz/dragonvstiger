package com.facebook.soloader;

import android.content.Context;

public class x extends y {
    public x(String str, String str2) {
        super(str, str2);
    }

    public static x b(String str, Context context, a0[] a0VarArr) {
        StringBuilder sb2 = new StringBuilder("couldn't find DSO to load: ");
        sb2.append(str);
        sb2.append("\n\texisting SO sources: ");
        for (int i10 = 0; i10 < a0VarArr.length; i10++) {
            sb2.append("\n\t\tSoSource ");
            sb2.append(i10);
            sb2.append(": ");
            sb2.append(a0VarArr[i10].toString());
        }
        if (context != null) {
            sb2.append("\n\tNative lib dir: ");
            sb2.append(context.getApplicationInfo().nativeLibraryDir);
            sb2.append("\n");
        }
        return new x(str, sb2.toString());
    }
}
