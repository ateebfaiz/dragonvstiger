package v0;

import android.util.Pair;
import com.alibaba.pdns.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import y0.f;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final e f24383a;

    public g(e eVar) {
        this.f24383a = eVar;
    }

    private static String b(String str, c cVar, boolean z10) {
        String str2;
        if (z10) {
            str2 = cVar.b();
        } else {
            str2 = cVar.f24382a;
        }
        String replaceAll = str.replaceAll("\\W+", "");
        int length = 242 - str2.length();
        if (replaceAll.length() > length) {
            replaceAll = d(replaceAll, length);
        }
        return "lottie_cache_" + replaceAll + str2;
    }

    private File c(String str) {
        File file = new File(e(), b(str, c.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(e(), b(str, c.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        File file3 = new File(e(), b(str, c.GZIP, false));
        if (file3.exists()) {
            return file3;
        }
        return null;
    }

    private static String d(String str, int i10) {
        try {
            byte[] digest = MessageDigest.getInstance(j.f17955b).digest(str.getBytes());
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < digest.length; i11++) {
                sb2.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i11])}));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            return str.substring(0, i10);
        }
    }

    private File e() {
        File a10 = this.f24383a.a();
        if (a10.isFile()) {
            a10.delete();
        }
        if (!a10.exists()) {
            a10.mkdirs();
        }
        return a10;
    }

    /* access modifiers changed from: package-private */
    public Pair a(String str) {
        c cVar;
        try {
            File c10 = c(str);
            if (c10 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(c10);
            if (c10.getAbsolutePath().endsWith(".zip")) {
                cVar = c.ZIP;
            } else if (c10.getAbsolutePath().endsWith(".gz")) {
                cVar = c.GZIP;
            } else {
                cVar = c.JSON;
            }
            f.a("Cache hit for " + str + " at " + c10.getAbsolutePath());
            return new Pair(cVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void f(String str, c cVar) {
        File file = new File(e(), b(str, cVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        f.a("Copying temp file to real file (" + file2 + ")");
        if (!renameTo) {
            f.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + com.alibaba.pdns.f.G);
        }
    }

    /* access modifiers changed from: package-private */
    public File g(String str, InputStream inputStream, c cVar) {
        FileOutputStream fileOutputStream;
        File file = new File(e(), b(str, cVar, true));
        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }
}
