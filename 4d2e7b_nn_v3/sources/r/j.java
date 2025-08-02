package r;

import android.text.TextUtils;
import i.c;
import java.io.IOException;

public class j implements g {

    /* renamed from: a  reason: collision with root package name */
    public final String f23591a;

    public j(String str) {
        this.f23591a = str;
    }

    public byte[] b(String str) {
        if (!TextUtils.equals(str, "gzip")) {
            return null;
        }
        try {
            return c.p(this.f23591a.getBytes());
        } catch (IOException unused) {
            return null;
        }
    }
}
