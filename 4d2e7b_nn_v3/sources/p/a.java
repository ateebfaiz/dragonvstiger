package p;

import android.content.Context;
import com.mah.sdk.MahProxy;
import com.mah.sdk.OooO00o;
import d.k;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;
import k.a;
import org.json.JSONObject;
import r.d;
import r.f;
import r.g;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public k f23029a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c f23030b;

    /* renamed from: c  reason: collision with root package name */
    public String f23031c;

    /* renamed from: d  reason: collision with root package name */
    public final String f23032d = k.a.f().d();

    /* renamed from: e  reason: collision with root package name */
    public final String f23033e = a.C0295a.f22232a.e();

    /* renamed from: f  reason: collision with root package name */
    public final int f23034f;

    /* renamed from: p.a$a  reason: collision with other inner class name */
    public class C0318a implements FilenameFilter {
        public C0318a() {
        }

        public boolean accept(File file, String str) {
            return str.startsWith("access.log");
        }
    }

    public class b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f23036a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f23037b;

        public b(String str, File file) {
            this.f23036a = str;
            this.f23037b = file;
        }

        public void OooO00o() {
            String str = b.f23043f;
            i.c.o(this.f23037b);
        }

        public void e() {
            String str = b.f23043f;
            i.c.o(this.f23037b);
        }
    }

    public static class c extends r.a {

        /* renamed from: i  reason: collision with root package name */
        public final String f23039i;

        /* renamed from: j  reason: collision with root package name */
        public final Context f23040j;

        /* renamed from: k  reason: collision with root package name */
        public final int f23041k;

        /* renamed from: l  reason: collision with root package name */
        public final d.c f23042l;

        public c(String str, String str2, g gVar, String str3, Context context, int i10, d.c cVar) {
            super(str2, str, gVar, 2, cVar.f().a());
            this.f23039i = str3;
            this.f23040j = context;
            this.f23041k = i10;
            this.f23042l = cVar;
        }

        public void a(JSONObject jSONObject) {
            r.a.b(jSONObject, this.f23042l.j());
        }

        public Map c() {
            String OooO0OO = OooO00o.OooO0OO(this.f23042l.b());
            HashMap hashMap = new HashMap(8);
            hashMap.put("packageName", this.f23042l.j().h());
            hashMap.put("timestamp", this.f23039i);
            hashMap.put("model", OooO00o.OooO0O0());
            hashMap.put("subType", String.valueOf(this.f23041k));
            hashMap.put("appVersion", OooO00o.OooO00o(this.f23040j));
            hashMap.put("sdkVersion", MahProxy.getVersion());
            hashMap.put("imei", OooO0OO);
            hashMap.put("platform", OooO00o.OooO0Oo());
            String str = b.f23043f;
            hashMap.toString();
            return hashMap;
        }
    }

    public a(k kVar, d.c cVar, String str, int i10) {
        this.f23029a = kVar;
        this.f23030b = cVar;
        this.f23031c = str;
        this.f23034f = i10;
    }

    public static File a(File file) {
        File parentFile = file.getParentFile();
        File file2 = new File(parentFile, "bak_" + file.getName());
        if (file.renameTo(file2)) {
            return file2;
        }
        String str = b.f23043f;
        file.getName();
        return null;
    }

    public void b() {
        try {
            e();
            d();
        } catch (Throwable unused) {
            String str = b.f23043f;
        }
    }

    public final void c(File file, String str, String str2, boolean z10, long j10) {
        String str3 = b.f23043f;
        file.getAbsoluteFile();
        r.c cVar = new r.c(file, j10, 0);
        String str4 = str;
        String str5 = str2;
        r.c cVar2 = cVar;
        f.c().m(new d(new c(str4, str5, cVar2, this.f23031c, this.f23029a.OooO00o(), this.f23034f, this.f23030b), new b(str, file)));
    }

    public final void d() {
        File parentFile = new File(this.f23032d).getParentFile();
        if (parentFile == null) {
            String str = b.f23043f;
            return;
        }
        File[] listFiles = parentFile.listFiles(new C0318a());
        if (listFiles == null) {
            String str2 = b.f23043f;
            return;
        }
        int min = Math.min(3, listFiles.length);
        for (int i10 = 0; i10 < min; i10++) {
            File a10 = a(listFiles[i10]);
            if (a10 != null) {
                String str3 = b.f23043f;
                a10.getName();
                a10.getAbsolutePath();
                c(a10, "access.log", "mah-access-debug", false, 1048576);
            }
        }
    }

    public final void e() {
        File file = new File(this.f23033e);
        if (!file.exists()) {
            String str = b.f23043f;
            file.getName();
            return;
        }
        File a10 = a(file);
        if (a10 != null) {
            String str2 = b.f23043f;
            a10.getAbsolutePath();
            c(a10, "ndk_debug.log", "mah-ndk-debug", true, 10485760);
        }
    }
}
