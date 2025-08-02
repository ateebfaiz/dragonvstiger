package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import com.google.android.games.paddleboat.GameControllerManager;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.TreeSet;

public abstract class SysUtil {

    @f
    @TargetApi(21)
    private static final class LollipopSysdeps {
        private LollipopSysdeps() {
        }

        @f
        public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j10) throws IOException {
            int i10;
            try {
                Os.posix_fallocate(fileDescriptor, 0, j10);
            } catch (ErrnoException e10) {
                if (e10.errno != OsConstants.EOPNOTSUPP && (i10 = e10.errno) != OsConstants.ENOSYS && i10 != OsConstants.EINVAL) {
                    throw new IOException(e10.toString(), e10);
                }
            }
        }

        @f
        public static String[] getSupportedAbis() {
            String[] strArr = Build.SUPPORTED_ABIS;
            TreeSet treeSet = new TreeSet();
            try {
                if (is64Bit()) {
                    treeSet.add("arm64-v8a");
                    treeSet.add("x86_64");
                } else {
                    treeSet.add("armeabi-v7a");
                    treeSet.add("x86");
                }
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    if (treeSet.contains(str)) {
                        arrayList.add(str);
                    }
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            } catch (ErrnoException e10) {
                m.b("SysUtil", String.format("Could not read /proc/self/exe. Falling back to default ABI list: %s. errno: %d Err msg: %s", new Object[]{Arrays.toString(strArr), Integer.valueOf(e10.errno), e10.getMessage()}));
                return Build.SUPPORTED_ABIS;
            }
        }

        @f
        public static boolean is64Bit() throws ErrnoException {
            return Os.readlink("/proc/self/exe").contains("64");
        }
    }

    @f
    @TargetApi(23)
    private static final class MarshmallowSysdeps {
        private MarshmallowSysdeps() {
        }

        public static boolean a(Context context) {
            if (context == null || (context.getApplicationInfo().flags & GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR) != 0) {
                return false;
            }
            return true;
        }

        public static boolean b(Context context, int i10) {
            if (i10 == 2) {
                return true;
            }
            return a(context);
        }

        @f
        public static String[] getSupportedAbis() {
            String[] strArr = Build.SUPPORTED_ABIS;
            TreeSet treeSet = new TreeSet();
            if (is64Bit()) {
                treeSet.add("arm64-v8a");
                treeSet.add("x86_64");
            } else {
                treeSet.add("armeabi-v7a");
                treeSet.add("x86");
            }
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (treeSet.contains(str)) {
                    arrayList.add(str);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        @f
        public static boolean is64Bit() {
            return Process.is64Bit();
        }
    }

    static int a(RandomAccessFile randomAccessFile, InputStream inputStream, int i10, byte[] bArr) {
        int i11 = 0;
        while (i11 < i10) {
            int read = inputStream.read(bArr, 0, Math.min(bArr.length, i10 - i11));
            if (read == -1) {
                break;
            }
            randomAccessFile.write(bArr, 0, read);
            i11 += read;
        }
        return i11;
    }

    public static void b(File file) {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.canWrite() && !parentFile.setWritable(true)) {
            m.b("SysUtil", "Enable write permission failed: " + parentFile);
        }
        if (!file.delete() && file.exists()) {
            throw new IOException("Could not delete file " + file);
        }
    }

    public static void c(File file) {
        Stack stack = new Stack();
        stack.push(file);
        ArrayList arrayList = new ArrayList();
        while (!stack.isEmpty()) {
            File file2 = (File) stack.pop();
            if (!file2.isDirectory()) {
                b(file2);
            } else {
                arrayList.add(file2);
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    for (File push : listFiles) {
                        stack.push(push);
                    }
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            b((File) arrayList.get(size));
        }
    }

    public static void d(FileDescriptor fileDescriptor, long j10) {
        LollipopSysdeps.fallocateIfSupported(fileDescriptor, j10);
    }

    public static int e(String[] strArr, String str) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String str2 = strArr[i10];
            if (str2 != null && str.equals(str2)) {
                return i10;
            }
        }
        return -1;
    }

    public static void f(File file) {
        RandomAccessFile randomAccessFile;
        Stack stack = new Stack();
        stack.push(file);
        while (!stack.isEmpty()) {
            File file2 = (File) stack.pop();
            if (file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    for (File push : listFiles) {
                        stack.push(push);
                    }
                } else {
                    throw new IOException("cannot list directory " + file2);
                }
            } else if (!file2.getPath().endsWith("_lock")) {
                try {
                    randomAccessFile = new RandomAccessFile(file2, "r");
                    randomAccessFile.getFD().sync();
                    randomAccessFile.close();
                } catch (IOException e10) {
                    m.b("SysUtil", "Syncing failed for " + file2 + ": " + e10.getMessage());
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                continue;
            }
        }
        return;
        throw th;
    }

    public static int g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                return packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            }
        }
        return 0;
    }

    @f
    public static String getClassLoaderLdLoadLibrary() {
        ClassLoader classLoader = SoLoader.class.getClassLoader();
        if (classLoader == null || (classLoader instanceof BaseDexClassLoader)) {
            try {
                return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", (Class[]) null).invoke((BaseDexClassLoader) classLoader, (Object[]) null);
            } catch (Exception e10) {
                m.c("SysUtil", "Cannot call getLdLibraryPath", e10);
                return null;
            }
        } else {
            throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
        }
    }

    @f
    public static Method getNativeLoadRuntimeMethod() {
        if (Build.VERSION.SDK_INT > 27) {
            return null;
        }
        try {
            Class<String> cls = String.class;
            Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{cls, ClassLoader.class, cls});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e10) {
            m.h("SysUtil", "Cannot get nativeLoad method", e10);
            return null;
        }
    }

    public static l h(File file) {
        return l.a(file);
    }

    public static l i(File file, File file2) {
        boolean z10;
        try {
            return h(file2);
        } catch (FileNotFoundException e10) {
            z10 = true;
            if (file.setWritable(true)) {
                l h10 = h(file2);
                if (!file.setWritable(false)) {
                    m.g("SysUtil", "error removing " + file.getCanonicalPath() + " write permission");
                }
                return h10;
            }
            throw e10;
        } catch (Throwable th) {
            th = th;
        }
        if (z10 && !file.setWritable(false)) {
            m.g("SysUtil", "error removing " + file.getCanonicalPath() + " write permission");
        }
        throw th;
    }

    public static String[] j() {
        return MarshmallowSysdeps.getSupportedAbis();
    }

    public static boolean k() {
        return MarshmallowSysdeps.is64Bit();
    }

    public static boolean l(Context context, int i10) {
        return MarshmallowSysdeps.b(context, i10);
    }

    public static String m(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    public static void n(File file) {
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("cannot mkdir: " + file);
        }
    }
}
