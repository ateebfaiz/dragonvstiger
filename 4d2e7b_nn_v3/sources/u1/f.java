package u1;

import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class f {

    public static class a implements Comparator {
        /* renamed from: a */
        public int compare(File file, File file2) {
            int i10 = ((file.lastModified() - file2.lastModified()) > 0 ? 1 : ((file.lastModified() - file2.lastModified()) == 0 ? 0 : -1));
            if (i10 < 0) {
                return -1;
            }
            if (i10 > 0) {
                return 1;
            }
            return 0;
        }
    }

    public static void a(File file) {
        if (file != null && !file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(String str, int i10) {
        File[] listFiles;
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (!file.exists() || file.isFile() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                if (listFiles.length != 0) {
                    s1.a.a("FileUtils", "cacheFiles.length " + listFiles.length);
                    if (listFiles.length > i10) {
                        List asList = Arrays.asList(listFiles);
                        Collections.sort(asList, new a());
                        for (int i11 = 0; i11 < asList.size() - i10; i11++) {
                            File file2 = (File) asList.get(i11);
                            if (file2.exists()) {
                                s1.a.a("FileUtils", "Delete cacheFile " + file2.getAbsolutePath());
                                c(file2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean c(File file) {
        try {
            if (!file.exists()) {
                return false;
            }
            if (file.isFile()) {
                return file.delete();
            }
            String[] list = file.list();
            if (list != null) {
                for (String file2 : list) {
                    File file3 = new File(file, file2);
                    if (file3.isDirectory()) {
                        c(file3);
                    } else {
                        file3.delete();
                    }
                }
            }
            return file.delete();
        } catch (Exception unused) {
            s1.a.b("FileUtils", "Delete dir error");
            return false;
        }
    }

    public static boolean d(String str, String str2) {
        byte[] bArr;
        if (str2 != null) {
            try {
                bArr = str2.getBytes("UTF-8");
            } catch (Exception e10) {
                s1.a.h("FileUtils", "getBytes exception:" + e10);
                return false;
            }
        } else {
            bArr = null;
        }
        return e(str, bArr);
    }

    private static boolean e(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(str);
            a(file);
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                o.a(fileOutputStream2);
                return true;
            } catch (Exception e10) {
                e = e10;
                fileOutputStream = fileOutputStream2;
                try {
                    s1.a.h("FileUtils", "save to file exception:" + e + " path = " + str);
                    o.a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    o.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                o.a(fileOutputStream);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            s1.a.h("FileUtils", "save to file exception:" + e + " path = " + str);
            o.a(fileOutputStream);
            return false;
        }
    }
}
