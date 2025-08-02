package l2;

import android.os.AsyncTask;
import java.io.File;
import kotlin.jvm.internal.m;

public final class f extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    private final String f22425a;

    /* renamed from: b  reason: collision with root package name */
    private final File f22426b;

    /* renamed from: c  reason: collision with root package name */
    private final a f22427c;

    public interface a {
        void a(File file);
    }

    public f(String str, File file, a aVar) {
        m.f(str, "uriStr");
        m.f(file, "destFile");
        m.f(aVar, "onSuccess");
        this.f22425a = str;
        this.f22426b = file;
        this.f22427c = aVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004e, code lost:
        return java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x004c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean a(java.lang.String... r5) {
        /*
            r4 = this;
            boolean r0 = v5.a.d(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r0 = "args"
            kotlin.jvm.internal.m.f(r5, r0)     // Catch:{ all -> 0x004a }
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x004c }
            java.lang.String r0 = r4.f22425a     // Catch:{ Exception -> 0x004c }
            r5.<init>(r0)     // Catch:{ Exception -> 0x004c }
            java.net.URLConnection r0 = r5.openConnection()     // Catch:{ Exception -> 0x004c }
            java.lang.String r2 = "conn"
            kotlin.jvm.internal.m.e(r0, r2)     // Catch:{ Exception -> 0x004c }
            int r0 = r0.getContentLength()     // Catch:{ Exception -> 0x004c }
            java.io.DataInputStream r2 = new java.io.DataInputStream     // Catch:{ Exception -> 0x004c }
            java.io.InputStream r5 = r5.openStream()     // Catch:{ Exception -> 0x004c }
            r2.<init>(r5)     // Catch:{ Exception -> 0x004c }
            byte[] r5 = new byte[r0]     // Catch:{ Exception -> 0x004c }
            r2.readFully(r5)     // Catch:{ Exception -> 0x004c }
            r2.close()     // Catch:{ Exception -> 0x004c }
            java.io.DataOutputStream r0 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x004c }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x004c }
            java.io.File r3 = r4.f22426b     // Catch:{ Exception -> 0x004c }
            r2.<init>(r3)     // Catch:{ Exception -> 0x004c }
            r0.<init>(r2)     // Catch:{ Exception -> 0x004c }
            r0.write(r5)     // Catch:{ Exception -> 0x004c }
            r0.flush()     // Catch:{ Exception -> 0x004c }
            r0.close()     // Catch:{ Exception -> 0x004c }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x004c }
            return r5
        L_0x004a:
            r5 = move-exception
            goto L_0x004f
        L_0x004c:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x004a }
            return r5
        L_0x004f:
            v5.a.b(r5, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.f.a(java.lang.String[]):java.lang.Boolean");
    }

    /* access modifiers changed from: protected */
    public void b(boolean z10) {
        if (!v5.a.d(this) && z10) {
            try {
                this.f22427c.a(this.f22426b);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (v5.a.d(this)) {
            return null;
        }
        try {
            return a((String[]) objArr);
        } catch (Throwable th) {
            v5.a.b(th, this);
            return null;
        }
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        if (!v5.a.d(this)) {
            try {
                b(((Boolean) obj).booleanValue());
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }
}
