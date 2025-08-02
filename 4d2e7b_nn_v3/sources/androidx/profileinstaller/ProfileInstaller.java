package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

public class ProfileInstaller {
    public static final int DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST = 2;
    public static final int DIAGNOSTIC_CURRENT_PROFILE_EXISTS = 1;
    public static final int DIAGNOSTIC_PROFILE_IS_COMPRESSED = 5;
    public static final int DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST = 4;
    public static final int DIAGNOSTIC_REF_PROFILE_EXISTS = 3;
    private static final DiagnosticsCallback EMPTY_DIAGNOSTICS = new a();
    @NonNull
    static final DiagnosticsCallback LOG_DIAGNOSTICS = new b();
    private static final String PROFILE_BASE_DIR = "/data/misc/profiles/cur/0";
    private static final String PROFILE_FILE = "primary.prof";
    private static final String PROFILE_INSTALLER_SKIP_FILE_NAME = "profileinstaller_profileWrittenFor_lastUpdateTime.dat";
    private static final String PROFILE_META_LOCATION = "dexopt/baseline.profm";
    private static final String PROFILE_SOURCE_LOCATION = "dexopt/baseline.prof";
    public static final int RESULT_ALREADY_INSTALLED = 2;
    public static final int RESULT_BASELINE_PROFILE_NOT_FOUND = 6;
    public static final int RESULT_BENCHMARK_OPERATION_FAILURE = 15;
    public static final int RESULT_BENCHMARK_OPERATION_SUCCESS = 14;
    public static final int RESULT_BENCHMARK_OPERATION_UNKNOWN = 16;
    public static final int RESULT_DELETE_SKIP_FILE_SUCCESS = 11;
    public static final int RESULT_DESIRED_FORMAT_UNSUPPORTED = 5;
    public static final int RESULT_INSTALL_SKIP_FILE_SUCCESS = 10;
    public static final int RESULT_INSTALL_SUCCESS = 1;
    public static final int RESULT_IO_EXCEPTION = 7;
    public static final int RESULT_META_FILE_REQUIRED_BUT_NOT_FOUND = 9;
    public static final int RESULT_NOT_WRITABLE = 4;
    public static final int RESULT_PARSE_EXCEPTION = 8;
    public static final int RESULT_SAVE_PROFILE_SIGNALLED = 12;
    public static final int RESULT_SAVE_PROFILE_SKIPPED = 13;
    public static final int RESULT_UNSUPPORTED_ART_VERSION = 3;
    private static final String TAG = "ProfileInstaller";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiagnosticCode {
    }

    public interface DiagnosticsCallback {
        void onDiagnosticReceived(int i10, @Nullable Object obj);

        void onResultReceived(int i10, @Nullable Object obj);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultCode {
    }

    class a implements DiagnosticsCallback {
        a() {
        }

        public void onDiagnosticReceived(int i10, Object obj) {
        }

        public void onResultReceived(int i10, Object obj) {
        }
    }

    class b implements DiagnosticsCallback {
        b() {
        }

        public void onDiagnosticReceived(int i10, Object obj) {
            String str;
            if (i10 == 1) {
                str = "DIAGNOSTIC_CURRENT_PROFILE_EXISTS";
            } else if (i10 == 2) {
                str = "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST";
            } else if (i10 == 3) {
                str = "DIAGNOSTIC_REF_PROFILE_EXISTS";
            } else if (i10 == 4) {
                str = "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST";
            } else if (i10 != 5) {
                str = "";
            } else {
                str = "DIAGNOSTIC_PROFILE_IS_COMPRESSED";
            }
            Log.d(ProfileInstaller.TAG, str);
        }

        public void onResultReceived(int i10, Object obj) {
            String str;
            switch (i10) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
                default:
                    str = "";
                    break;
            }
            if (i10 == 6 || i10 == 7 || i10 == 8) {
                Log.e(ProfileInstaller.TAG, str, (Throwable) obj);
            } else {
                Log.d(ProfileInstaller.TAG, str);
            }
        }
    }

    private ProfileInstaller() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static boolean deleteProfileWrittenFor(@NonNull File file) {
        return new File(file, PROFILE_INSTALLER_SKIP_FILE_NAME).delete();
    }

    @WorkerThread
    static void deleteSkipFile(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback) {
        deleteProfileWrittenFor(context.getFilesDir());
        result(executor, diagnosticsCallback, 11, (Object) null);
    }

    static void diagnostic(@NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback, int i10, @Nullable Object obj) {
        executor.execute(new h(diagnosticsCallback, i10, obj));
    }

    @WorkerThread
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static boolean hasAlreadyWrittenProfileForThisInstall(PackageInfo packageInfo, File file, DiagnosticsCallback diagnosticsCallback) {
        DataInputStream dataInputStream;
        File file2 = new File(file, PROFILE_INSTALLER_SKIP_FILE_NAME);
        boolean z10 = false;
        if (!file2.exists()) {
            return false;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(file2));
            long readLong = dataInputStream.readLong();
            dataInputStream.close();
            if (readLong == packageInfo.lastUpdateTime) {
                z10 = true;
            }
            if (z10) {
                diagnosticsCallback.onResultReceived(2, (Object) null);
            }
            return z10;
        } catch (IOException unused) {
            return false;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static void noteProfileWrittenFor(@NonNull PackageInfo packageInfo, @NonNull File file) {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, PROFILE_INSTALLER_SKIP_FILE_NAME)));
            dataOutputStream.writeLong(packageInfo.lastUpdateTime);
            dataOutputStream.close();
            return;
        } catch (IOException unused) {
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    static void result(@NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback, int i10, @Nullable Object obj) {
        executor.execute(new g(diagnosticsCallback, i10, obj));
    }

    private static boolean transcodeAndWrite(@NonNull AssetManager assetManager, @NonNull String str, @NonNull PackageInfo packageInfo, @NonNull File file, @NonNull String str2, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback) {
        DeviceProfileWriter deviceProfileWriter = new DeviceProfileWriter(assetManager, executor, diagnosticsCallback, str2, PROFILE_SOURCE_LOCATION, PROFILE_META_LOCATION, new File(new File(PROFILE_BASE_DIR, str), PROFILE_FILE));
        if (!deviceProfileWriter.deviceAllowsProfileInstallerAotWrites()) {
            return false;
        }
        boolean write = deviceProfileWriter.read().transcodeIfNeeded().write();
        if (write) {
            noteProfileWrittenFor(packageInfo, file);
        }
        return write;
    }

    @WorkerThread
    public static void writeProfile(@NonNull Context context) {
        writeProfile(context, new androidx.credentials.a(), EMPTY_DIAGNOSTICS);
    }

    @WorkerThread
    static void writeSkipFile(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback) {
        try {
            noteProfileWrittenFor(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            result(executor, diagnosticsCallback, 10, (Object) null);
        } catch (PackageManager.NameNotFoundException e10) {
            result(executor, diagnosticsCallback, 7, e10);
        }
    }

    @WorkerThread
    public static void writeProfile(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback) {
        writeProfile(context, executor, diagnosticsCallback, false);
    }

    @WorkerThread
    static void writeProfile(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback, boolean z10) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z11 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (z10 || !hasAlreadyWrittenProfileForThisInstall(packageInfo, filesDir, diagnosticsCallback)) {
                Log.d(TAG, "Installing profile for " + context.getPackageName());
                if (transcodeAndWrite(assets, packageName, packageInfo, filesDir, name, executor, diagnosticsCallback) && z10) {
                    z11 = true;
                }
                ProfileVerifier.writeProfileVerification(context, z11);
                return;
            }
            Log.d(TAG, "Skipping profile installation for " + context.getPackageName());
            ProfileVerifier.writeProfileVerification(context, false);
        } catch (PackageManager.NameNotFoundException e10) {
            diagnosticsCallback.onResultReceived(7, e10);
            ProfileVerifier.writeProfileVerification(context, false);
        }
    }
}
