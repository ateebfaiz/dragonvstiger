package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import b3.i;
import e5.j;
import java.io.ByteArrayInputStream;
import k5.b;
import w2.a;
import y2.l;

public class o extends m0 {
    public o(i iVar) {
        super(a.a(), iVar);
    }

    static byte[] g(String str) {
        l.b(Boolean.valueOf(str.substring(0, 5).equals("data:")));
        int indexOf = str.indexOf(44);
        String substring = str.substring(indexOf + 1, str.length());
        if (h(str.substring(0, indexOf))) {
            return Base64.decode(substring, 0);
        }
        String decode = Uri.decode(substring);
        l.g(decode);
        return decode.getBytes();
    }

    static boolean h(String str) {
        if (!str.contains(";")) {
            return false;
        }
        String[] split = str.split(";");
        return split[split.length - 1].equals("base64");
    }

    /* access modifiers changed from: protected */
    public j e(b bVar) {
        byte[] g10 = g(bVar.u().toString());
        return c(new ByteArrayInputStream(g10), g10.length);
    }

    /* access modifiers changed from: protected */
    public String f() {
        return "DataFetchProducer";
    }
}
