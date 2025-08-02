package i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.google.android.games.paddleboat.GameControllerManager;
import com.mah.sdk.OooO00o;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import w.d;

public class r {

    /* renamed from: c  reason: collision with root package name */
    public static final String f22027c = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final Handler f22028a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f22029b;

    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference f22030a;

        /* renamed from: b  reason: collision with root package name */
        public final String f22031b;

        public a(r rVar, String str) {
            super(Looper.getMainLooper());
            this.f22030a = new WeakReference(rVar);
            this.f22031b = str;
        }

        public void handleMessage(Message message) {
            r rVar = (r) this.f22030a.get();
            if (rVar != null) {
                int i10 = message.what;
                if (i10 == -1) {
                    rVar.c();
                } else if (i10 == 0) {
                    rVar.h(message.obj.toString(), this.f22031b);
                }
            }
        }
    }

    public r(Activity activity) {
        this.f22029b = activity;
        Context applicationContext = activity.getApplicationContext();
        this.f22028a = new a(this, String.format(Locale.US, "%s.%s", new Object[]{v.a(applicationContext), "mah.log.fileprovider"}));
    }

    public static Uri a(Activity activity, String str, File file) {
        Class<File> cls = File.class;
        Class<String> cls2 = String.class;
        Class<Context> cls3 = Context.class;
        Class<FileProvider> cls4 = FileProvider.class;
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        try {
            int i10 = FileProvider.f14874a;
            Log.i(f22027c, "Try support FileProvider, real className:".concat(cls4.getName()));
            return (Uri) o.a(cls4, "getUriForFile", new Object[]{activity, str, file}, cls3, cls2, cls);
        } catch (ClassNotFoundException unused) {
            int i11 = FileProvider.f14874a;
            Log.i(f22027c, "Try androidx FileProvider, real className:".concat(cls4.getName()));
            return (Uri) o.a(cls4, "getUriForFile", new Object[]{activity, str, file}, cls3, cls2, cls);
        }
    }

    public final String b(String str, String str2) {
        String str3;
        String a10 = v.a(this.f22029b);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        String str4 = File.separator;
        sb2.append(str4);
        sb2.append("com.mah.sdk");
        File file = new File(sb2.toString());
        String str5 = "";
        if (file.exists()) {
            str3 = OooO00o.OooO00o(file, a10);
        } else {
            str3 = str5;
        }
        File file2 = new File(str + str4 + "com.mah.sdk");
        if (file2.exists()) {
            str5 = OooO00o.OooO00o(file2, a10);
        }
        File file3 = new File(str3);
        File file4 = new File(str5);
        if (file3.exists() || !file4.exists()) {
            if (!file4.exists() && file3.exists()) {
                return str3;
            }
            if (file4.exists() && file3.exists()) {
                if (new File(str5, "debug.log").lastModified() <= new File(str3, "debug.log").lastModified()) {
                    return str3;
                }
            }
        }
        return str5;
    }

    public final void c() {
        Toast.makeText(this.f22029b, "Share mah log failed!", 1).show();
    }

    public final void f() {
        String j10 = v.j(this.f22029b);
        String v10 = v.v(this.f22029b);
        File file = new File(v10, "ShareMahLog");
        if (file.exists()) {
            c.o(file);
        }
        if (file.exists() || file.mkdirs()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US);
            String b10 = b(j10, v10);
            String str = (file.getAbsolutePath() + File.separator + "mah_share_com.mah.sdk_android_" + simpleDateFormat.format(new Date())) + ".zip";
            if (c.i(b10, str)) {
                Handler handler = this.f22028a;
                handler.sendMessageDelayed(Message.obtain(handler, 0, str), 50);
                return;
            }
            this.f22028a.sendEmptyMessage(-1);
            return;
        }
        this.f22028a.sendEmptyMessage(-1);
    }

    public final void h(String str, String str2) {
        try {
            Uri a10 = a(this.f22029b, str2, new File(str));
            a10.toString();
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.STREAM", a10);
            intent.setFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
            intent.addFlags(1);
            this.f22029b.startActivity(Intent.createChooser(intent, "ShareMahLog"));
        } catch (Exception e10) {
            c();
            e10.getMessage();
        }
    }
}
