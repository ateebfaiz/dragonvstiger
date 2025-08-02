package r1;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class a implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public String f23633a;

    public a(String str) {
        this.f23633a = str;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f23633a, str);
    }
}
