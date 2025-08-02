package com.android.vending.expansion.zipfile;

import android.content.Context;
import android.os.Environment;
import com.alibaba.pdns.f;
import java.io.File;
import java.util.Vector;

public abstract class a {
    static String[] a(Context context, int i10, int i11) {
        String packageName = context.getPackageName();
        Vector vector = new Vector();
        if (Environment.getExternalStorageState().equals("mounted")) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File file = new File(externalStorageDirectory.toString() + "/Android/obb/" + packageName);
            if (file.exists()) {
                if (i10 > 0) {
                    String str = file + File.separator + "main." + i10 + f.G + packageName + ".obb";
                    if (new File(str).isFile()) {
                        vector.add(str);
                    }
                }
                if (i11 > 0) {
                    String str2 = file + File.separator + "patch." + i10 + f.G + packageName + ".obb";
                    if (new File(str2).isFile()) {
                        vector.add(str2);
                    }
                }
            }
        }
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        return strArr;
    }

    public static b b(Context context, int i10, int i11) {
        return c(a(context, i10, i11));
    }

    public static b c(String[] strArr) {
        b bVar = null;
        for (String str : strArr) {
            if (bVar == null) {
                bVar = new b(str);
            } else {
                bVar.a(str);
            }
        }
        return bVar;
    }
}
