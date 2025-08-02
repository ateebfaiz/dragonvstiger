package v0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import y0.f;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final HttpURLConnection f24377a;

    public a(HttpURLConnection httpURLConnection) {
        this.f24377a = httpURLConnection;
    }

    private String a(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb2.append(readLine);
                    sb2.append(10);
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb2.toString();
    }

    public void close() {
        this.f24377a.disconnect();
    }

    public boolean isSuccessful() {
        try {
            if (this.f24377a.getResponseCode() / 100 == 2) {
                return true;
            }
            return false;
        } catch (IOException unused) {
            return false;
        }
    }

    public String q() {
        return this.f24377a.getContentType();
    }

    public String r() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.f24377a.getURL() + ". Failed with " + this.f24377a.getResponseCode() + "\n" + a(this.f24377a);
        } catch (IOException e10) {
            f.d("get error failed ", e10);
            return e10.getMessage();
        }
    }

    public InputStream t() {
        return this.f24377a.getInputStream();
    }
}
