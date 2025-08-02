package e6;

import android.net.Uri;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import org.json.JSONException;
import org.json.JSONObject;
import z2.a;

public class c extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final String f11903a;

    private c(String str, String str2, int i10, int i11) {
        super(str + "\n  at " + str2 + ":" + i10 + ":" + i11);
        this.f11903a = str;
    }

    public static c a(String str, String str2, String str3, Throwable th) {
        String replace = "\n\nTry the following to fix the issue:\n• Ensure that Metro is running\n• Ensure that your device/emulator is connected to your machine and has USB debugging enabled - run 'adb devices' to see a list of connected devices\n• Ensure Airplane Mode is disabled\n• If you're on a physical device connected to the same machine, run 'adb reverse tcp:<PORT> tcp:<PORT>' to forward requests from your device\n• If your device is on the same Wi-Fi network, set 'Debug server host & port for device' in 'Dev settings' to your machine's IP address and the port of the local dev server - e.g. 10.0.1.1:<PORT>\n\n".replace("<PORT>", String.valueOf(Uri.parse(str).getPort()));
        return new c(str2 + replace + str3, th);
    }

    public static c b(String str, String str2, Throwable th) {
        return a(str, str2, "", th);
    }

    public static c c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            return new c(jSONObject.getString("message"), d(jSONObject.getString("filename")), jSONObject.getInt("lineNumber"), jSONObject.getInt("column"));
        } catch (JSONException e10) {
            a.H("ReactNative", "Could not parse DebugServerException from: " + str2, e10);
            return null;
        }
    }

    private static String d(String str) {
        String[] split = str.split(DomExceptionUtils.SEPARATOR);
        return split[split.length - 1];
    }

    public c(String str) {
        super(str);
        this.f11903a = str;
    }

    public c(String str, Throwable th) {
        super(str, th);
        this.f11903a = str;
    }
}
