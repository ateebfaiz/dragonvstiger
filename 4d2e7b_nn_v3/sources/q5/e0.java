package q5;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookContentProvider;
import com.facebook.l;
import com.facebook.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23290a;

    /* renamed from: b  reason: collision with root package name */
    private static File f23291b;

    /* renamed from: c  reason: collision with root package name */
    public static final e0 f23292c = new e0();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f23293a;

        /* renamed from: b  reason: collision with root package name */
        private final String f23294b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f23295c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f23296d;

        /* renamed from: e  reason: collision with root package name */
        private final UUID f23297e;

        /* renamed from: f  reason: collision with root package name */
        private final Bitmap f23298f;

        /* renamed from: g  reason: collision with root package name */
        private final Uri f23299g;

        public a(UUID uuid, Bitmap bitmap, Uri uri) {
            String str;
            m.f(uuid, "callId");
            this.f23297e = uuid;
            this.f23298f = bitmap;
            this.f23299g = uri;
            String str2 = null;
            boolean z10 = true;
            if (uri != null) {
                String scheme = uri.getScheme();
                if (j.q(FirebaseAnalytics.Param.CONTENT, scheme, true)) {
                    this.f23295c = true;
                    String authority = uri.getAuthority();
                    this.f23296d = (authority == null || j.F(authority, "media", false, 2, (Object) null)) ? false : z10;
                } else if (j.q("file", uri.getScheme(), true)) {
                    this.f23296d = true;
                } else if (!p0.a0(uri)) {
                    throw new l("Unsupported scheme for media Uri : " + scheme);
                }
            } else if (bitmap != null) {
                this.f23296d = true;
            } else {
                throw new l("Cannot share media without a bitmap or Uri set");
            }
            str2 = this.f23296d ? UUID.randomUUID().toString() : str2;
            this.f23294b = str2;
            if (!this.f23296d) {
                str = String.valueOf(uri);
            } else {
                str = FacebookContentProvider.f19518b.a(o.g(), uuid, str2);
            }
            this.f23293a = str;
        }

        public final String a() {
            return this.f23294b;
        }

        public final String b() {
            return this.f23293a;
        }

        public final Bitmap c() {
            return this.f23298f;
        }

        public final UUID d() {
            return this.f23297e;
        }

        public final Uri e() {
            return this.f23299g;
        }

        public final boolean f() {
            return this.f23296d;
        }

        public final boolean g() {
            return this.f23295c;
        }
    }

    static {
        String name = e0.class.getName();
        m.e(name, "NativeAppCallAttachmentStore::class.java.name");
        f23290a = name;
    }

    private e0() {
    }

    public static final void a(Collection collection) {
        if (collection != null && !collection.isEmpty()) {
            if (f23291b == null) {
                b();
            }
            f();
            ArrayList<File> arrayList = new ArrayList<>();
            try {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.f()) {
                        File g10 = g(aVar.d(), aVar.a(), true);
                        if (g10 != null) {
                            arrayList.add(g10);
                            if (aVar.c() != null) {
                                f23292c.k(aVar.c(), g10);
                            } else if (aVar.e() != null) {
                                f23292c.l(aVar.e(), aVar.g(), g10);
                            }
                        }
                    }
                }
            } catch (IOException e10) {
                String str = f23290a;
                Log.e(str, "Got unexpected exception:" + e10);
                for (File file : arrayList) {
                    if (file != null) {
                        try {
                            file.delete();
                        } catch (Exception unused) {
                        }
                    }
                }
                throw new l((Throwable) e10);
            }
        }
    }

    public static final void b() {
        p0.p(h());
    }

    public static final void c(UUID uuid) {
        m.f(uuid, "callId");
        File i10 = i(uuid, false);
        if (i10 != null) {
            p0.p(i10);
        }
    }

    public static final a d(UUID uuid, Bitmap bitmap) {
        m.f(uuid, "callId");
        m.f(bitmap, "attachmentBitmap");
        return new a(uuid, bitmap, (Uri) null);
    }

    public static final a e(UUID uuid, Uri uri) {
        m.f(uuid, "callId");
        m.f(uri, "attachmentUri");
        return new a(uuid, (Bitmap) null, uri);
    }

    public static final File f() {
        File h10 = h();
        if (h10 != null) {
            h10.mkdirs();
        }
        return h10;
    }

    public static final File g(UUID uuid, String str, boolean z10) {
        m.f(uuid, "callId");
        File i10 = i(uuid, z10);
        if (i10 == null) {
            return null;
        }
        try {
            return new File(i10, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static final synchronized File h() {
        File file;
        synchronized (e0.class) {
            try {
                if (f23291b == null) {
                    f23291b = new File(o.f().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
                }
                file = f23291b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    public static final File i(UUID uuid, boolean z10) {
        m.f(uuid, "callId");
        if (f23291b == null) {
            return null;
        }
        File file = new File(f23291b, uuid.toString());
        if (z10 && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static final File j(UUID uuid, String str) {
        if (p0.Y(str) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return g(uuid, str, false);
        } catch (IOException unused) {
            throw new FileNotFoundException();
        }
    }

    private final void k(Bitmap bitmap, File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } finally {
            p0.i(fileOutputStream);
        }
    }

    private final void l(Uri uri, boolean z10, File file) {
        InputStream inputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if (!z10) {
            try {
                inputStream = new FileInputStream(uri.getPath());
            } catch (Throwable th) {
                p0.i(fileOutputStream);
                throw th;
            }
        } else {
            inputStream = o.f().getContentResolver().openInputStream(uri);
        }
        p0.o(inputStream, fileOutputStream);
        p0.i(fileOutputStream);
    }
}
