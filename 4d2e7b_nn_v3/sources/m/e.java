package m;

import android.content.Context;
import d.c;
import d.k;
import java.io.File;
import r.d;
import r.f;
import r.g;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final k f22480a;

    /* renamed from: b  reason: collision with root package name */
    public final c f22481b;

    /* renamed from: c  reason: collision with root package name */
    public long f22482c = 0;

    public class a implements d.a {
        public a() {
        }

        public void OooO00o() {
            String str = b.f22462j;
        }

        public void e() {
            String str = b.f22462j;
        }
    }

    public static class b extends c {
        public b(g gVar, String str, Context context, c cVar) {
            super("mah-ndk-debug", "abnormal_debug.gzip", gVar, str, context, cVar);
        }
    }

    public e(k kVar, c cVar) {
        this.f22480a = kVar;
        this.f22481b = cVar;
    }

    public void a(String str) {
        File file = new File(k.a.f().e());
        b bVar = new b(new r.c(file, 10485760, this.f22482c), str, this.f22480a.OooO00o(), this.f22481b);
        String str2 = b.f22462j;
        file.getAbsoluteFile();
        f.c().m(new d(bVar, new a()));
        this.f22482c = file.length();
    }
}
