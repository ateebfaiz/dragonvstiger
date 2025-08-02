package d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import i.p;
import i.v;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final Context f21002a;

    /* renamed from: b  reason: collision with root package name */
    public final String f21003b;

    /* renamed from: c  reason: collision with root package name */
    public final String f21004c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference f21005d;

    /* renamed from: e  reason: collision with root package name */
    public final File f21006e = i();

    /* renamed from: f  reason: collision with root package name */
    public boolean f21007f = false;

    /* renamed from: g  reason: collision with root package name */
    public String f21008g = "";

    /* renamed from: h  reason: collision with root package name */
    public final String f21009h;

    /* renamed from: i  reason: collision with root package name */
    public final String f21010i;

    public g(Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        Context b10 = v.b(context);
        this.f21002a = b10;
        this.f21003b = str;
        this.f21004c = str2;
        this.f21005d = new AtomicReference(str3);
        String str6 = null;
        try {
            Bundle bundle = b10.getPackageManager().getApplicationInfo(str2, 128).metaData;
            if (bundle != null) {
                str5 = bundle.getString("MAH_PACKAGE_NAME");
                try {
                    str6 = bundle.getString("MAH_FINGER_PRINT");
                } catch (Exception unused) {
                }
                str4 = str6;
                str6 = str5;
                this.f21009h = str6;
                this.f21010i = str4;
            }
            str4 = null;
            this.f21009h = str6;
            this.f21010i = str4;
        } catch (Exception unused2) {
            str5 = null;
        }
    }

    public File a(String str) {
        File externalFilesDir = this.f21002a.getExternalFilesDir(str);
        return new File(externalFilesDir, "com.mah.sdk" + File.separator + g());
    }

    public String b() {
        return this.f21004c;
    }

    public File c() {
        return this.f21006e;
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            a.a(this.f21005d, "", str);
        }
    }

    public String e() {
        return this.f21010i;
    }

    public String f() {
        return this.f21009h;
    }

    public final String g() {
        if (this.f21007f) {
            return this.f21008g;
        }
        return this.f21003b;
    }

    public String h() {
        if (!TextUtils.isEmpty(this.f21009h)) {
            return this.f21009h;
        }
        return this.f21004c + ((String) this.f21005d.get());
    }

    public final File i() {
        File filesDir = this.f21002a.getFilesDir();
        StringBuilder sb2 = new StringBuilder("com.mah.sdk");
        String str = File.separator;
        sb2.append(str);
        sb2.append(this.f21003b);
        File file = new File(filesDir, sb2.toString());
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        String b10 = p.b(this.f21003b);
        File file2 = new File(filesDir, "com.mah.sdk" + str + b10);
        if (!file2.exists() && !file2.mkdirs()) {
            return null;
        }
        this.f21007f = true;
        this.f21008g = b10;
        return file2;
    }
}
