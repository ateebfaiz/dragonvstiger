package com.reactnativecommunity.asyncstorage;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class h {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002d A[SYNTHETIC, Splitter:B:18:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.io.FileInputStream r8, java.io.FileOutputStream r9) {
        /*
            r0 = 0
            java.nio.channels.FileChannel r8 = r8.getChannel()     // Catch:{ all -> 0x0029 }
            java.nio.channels.FileChannel r0 = r9.getChannel()     // Catch:{ all -> 0x0024 }
            long r4 = r8.size()     // Catch:{ all -> 0x0024 }
            r2 = 0
            r1 = r8
            r6 = r0
            r1.transferTo(r2, r4, r6)     // Catch:{ all -> 0x0024 }
            r8.close()     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001c
            r0.close()
        L_0x001c:
            return
        L_0x001d:
            r8 = move-exception
            if (r0 == 0) goto L_0x0023
            r0.close()
        L_0x0023:
            throw r8
        L_0x0024:
            r9 = move-exception
            r7 = r0
            r0 = r8
            r8 = r7
            goto L_0x002b
        L_0x0029:
            r9 = move-exception
            r8 = r0
        L_0x002b:
            if (r0 == 0) goto L_0x0038
            r0.close()     // Catch:{ all -> 0x0031 }
            goto L_0x0038
        L_0x0031:
            r9 = move-exception
            if (r8 == 0) goto L_0x0037
            r8.close()
        L_0x0037:
            throw r9
        L_0x0038:
            if (r8 == 0) goto L_0x003d
            r8.close()
        L_0x003d:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.asyncstorage.h.a(java.io.FileInputStream, java.io.FileOutputStream):void");
    }

    private static ArrayList b(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            File[] listFiles = context.getDatabasePath("noop").getParentFile().listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.getName().startsWith("RKStorage-scoped-experience-") && !file.getName().endsWith("-journal")) {
                        arrayList.add(file);
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return arrayList;
    }

    private static File c(ArrayList arrayList) {
        File file = null;
        if (arrayList.size() == 0) {
            return null;
        }
        Iterator it = arrayList.iterator();
        long j10 = -1;
        while (it.hasNext()) {
            File file2 = (File) it.next();
            long e10 = e(file2);
            if (e10 > j10) {
                file = file2;
                j10 = e10;
            }
        }
        if (file != null) {
            return file;
        }
        return (File) arrayList.get(0);
    }

    private static long d(File file) {
        try {
            return Files.readAttributes(file.toPath(), d.a(), new LinkOption[0]).creationTime().toMillis();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static long e(File file) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return d(file);
            }
            return file.lastModified();
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    private static boolean f(Context context) {
        return context.getDatabasePath("RKStorage").exists();
    }

    public static void g(Context context) {
        if (!f(context)) {
            ArrayList b10 = b(context);
            File c10 = c(b10);
            if (c10 == null) {
                Log.v("AsyncStorageExpoMigration", "No scoped database found");
                return;
            }
            try {
                k.n(context).m();
                a(new FileInputStream(c10), new FileOutputStream(context.getDatabasePath("RKStorage")));
                Log.v("AsyncStorageExpoMigration", "Migrated most recently modified database " + c10.getName() + " to RKStorage");
                try {
                    Iterator it = b10.iterator();
                    while (it.hasNext()) {
                        File file = (File) it.next();
                        if (file.delete()) {
                            Log.v("AsyncStorageExpoMigration", "Deleted scoped database " + file.getName());
                        } else {
                            Log.v("AsyncStorageExpoMigration", "Failed to delete scoped database " + file.getName());
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                Log.v("AsyncStorageExpoMigration", "Completed the scoped AsyncStorage migration");
            } catch (Exception e11) {
                Log.v("AsyncStorageExpoMigration", "Failed to migrate scoped database " + c10.getName());
                e11.printStackTrace();
            }
        }
    }
}
