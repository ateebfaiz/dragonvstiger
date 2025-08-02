package com.bumptech.glide.load.engine.executor;

import android.os.StrictMode;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

final class RuntimeCompat {
    private static final String CPU_LOCATION = "/sys/devices/system/cpu/";
    private static final String CPU_NAME_REGEX = "cpu[0-9]+";
    private static final String TAG = "GlideRuntimeCompat";

    private RuntimeCompat() {
    }

    static int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* JADX INFO: finally extract failed */
    private static int getCoreCountPre17() {
        File[] fileArr;
        int i10;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            File file = new File(CPU_LOCATION);
            final Pattern compile = Pattern.compile(CPU_NAME_REGEX);
            fileArr = file.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return compile.matcher(str).matches();
                }
            });
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        if (fileArr != null) {
            i10 = fileArr.length;
        } else {
            i10 = 0;
        }
        return Math.max(1, i10);
    }
}
