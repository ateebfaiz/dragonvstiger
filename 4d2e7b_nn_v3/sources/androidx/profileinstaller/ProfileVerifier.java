package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public final class ProfileVerifier {
    private static final String CUR_PROFILES_BASE_DIR = "/data/misc/profiles/cur/0/";
    private static final String PROFILE_FILE_NAME = "primary.prof";
    private static final String PROFILE_INSTALLED_CACHE_FILE_NAME = "profileInstalled";
    private static final String REF_PROFILES_BASE_DIR = "/data/misc/profiles/ref/";
    private static final Object SYNC_OBJ = new Object();
    private static final String TAG = "ProfileVerifier";
    @Nullable
    private static CompilationStatus sCompilationStatus = null;
    private static final ResolvableFuture<CompilationStatus> sFuture = ResolvableFuture.create();

    public static class CompilationStatus {
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE = 1;
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE_NON_MATCHING = 3;
        public static final int RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ = 131072;
        public static final int RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE = 196608;
        private static final int RESULT_CODE_ERROR_CODE_BIT_SHIFT = 16;
        public static final int RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST = 65536;
        public static final int RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION = 262144;
        public static final int RESULT_CODE_NO_PROFILE = 0;
        public static final int RESULT_CODE_PROFILE_ENQUEUED_FOR_COMPILATION = 2;
        private final boolean mHasCurrentProfile;
        private final boolean mHasReferenceProfile;
        final int mResultCode;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        CompilationStatus(int i10, boolean z10, boolean z11) {
            this.mResultCode = i10;
            this.mHasCurrentProfile = z11;
            this.mHasReferenceProfile = z10;
        }

        public int getProfileInstallResultCode() {
            return this.mResultCode;
        }

        public boolean hasProfileEnqueuedForCompilation() {
            return this.mHasCurrentProfile;
        }

        public boolean isCompiledWithProfile() {
            return this.mHasReferenceProfile;
        }
    }

    private static class a {
        @DoNotInline
        static PackageInfo a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f16070a;

        /* renamed from: b  reason: collision with root package name */
        final int f16071b;

        /* renamed from: c  reason: collision with root package name */
        final long f16072c;

        /* renamed from: d  reason: collision with root package name */
        final long f16073d;

        b(int i10, int i11, long j10, long j11) {
            this.f16070a = i10;
            this.f16071b = i11;
            this.f16072c = j10;
            this.f16073d = j11;
        }

        static b a(File file) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        /* access modifiers changed from: package-private */
        public void b(File file) {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f16070a);
                dataOutputStream.writeInt(this.f16071b);
                dataOutputStream.writeLong(this.f16072c);
                dataOutputStream.writeLong(this.f16073d);
                dataOutputStream.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f16071b == bVar.f16071b && this.f16072c == bVar.f16072c && this.f16070a == bVar.f16070a && this.f16073d == bVar.f16073d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.f16071b), Long.valueOf(this.f16072c), Integer.valueOf(this.f16070a), Long.valueOf(this.f16073d)});
        }
    }

    private ProfileVerifier() {
    }

    @NonNull
    public static ListenableFuture<CompilationStatus> getCompilationStatusAsync() {
        return sFuture;
    }

    private static long getPackageLastUpdateTime(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return a.a(packageManager, context).lastUpdateTime;
        }
        return packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    private static CompilationStatus setCompilationStatus(int i10, boolean z10, boolean z11) {
        CompilationStatus compilationStatus = new CompilationStatus(i10, z10, z11);
        sCompilationStatus = compilationStatus;
        sFuture.set(compilationStatus);
        return sCompilationStatus;
    }

    @WorkerThread
    @NonNull
    public static CompilationStatus writeProfileVerification(@NonNull Context context) {
        return writeProfileVerification(context, false);
    }

    @WorkerThread
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static CompilationStatus writeProfileVerification(@NonNull Context context, boolean z10) {
        boolean z11;
        boolean z12;
        b bVar;
        b bVar2;
        CompilationStatus compilationStatus;
        if (!z10 && (compilationStatus = sCompilationStatus) != null) {
            return compilationStatus;
        }
        synchronized (SYNC_OBJ) {
            if (!z10) {
                try {
                    CompilationStatus compilationStatus2 = sCompilationStatus;
                    if (compilationStatus2 != null) {
                        return compilationStatus2;
                    }
                } catch (IOException unused) {
                    return setCompilationStatus(131072, z11, z12);
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i10 = Build.VERSION.SDK_INT;
            int i11 = 0;
            if (i10 >= 28) {
                if (i10 != 30) {
                    File file = new File(new File(REF_PROFILES_BASE_DIR, context.getPackageName()), PROFILE_FILE_NAME);
                    long length = file.length();
                    z11 = file.exists() && length > 0;
                    File file2 = new File(new File(CUR_PROFILES_BASE_DIR, context.getPackageName()), PROFILE_FILE_NAME);
                    long length2 = file2.length();
                    z12 = file2.exists() && length2 > 0;
                    try {
                        long packageLastUpdateTime = getPackageLastUpdateTime(context);
                        File file3 = new File(context.getFilesDir(), PROFILE_INSTALLED_CACHE_FILE_NAME);
                        if (file3.exists()) {
                            bVar = b.a(file3);
                        } else {
                            bVar = null;
                        }
                        if (bVar != null && bVar.f16072c == packageLastUpdateTime) {
                            int i12 = bVar.f16071b;
                            if (i12 != 2) {
                                i11 = i12;
                                if (z10 && z12 && i11 != 1) {
                                    i11 = 2;
                                }
                                if (bVar != null && bVar.f16071b == 2 && i11 == 1 && length < bVar.f16073d) {
                                    i11 = 3;
                                }
                                bVar2 = new b(1, i11, packageLastUpdateTime, length2);
                                if (bVar == null || !bVar.equals(bVar2)) {
                                    bVar2.b(file3);
                                }
                                CompilationStatus compilationStatus3 = setCompilationStatus(i11, z11, z12);
                                return compilationStatus3;
                            }
                        }
                        if (z11) {
                            i11 = 1;
                        } else if (z12) {
                            i11 = 2;
                        }
                        i11 = 2;
                        i11 = 3;
                        bVar2 = new b(1, i11, packageLastUpdateTime, length2);
                        try {
                            bVar2.b(file3);
                        } catch (IOException unused2) {
                            i11 = CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        }
                        CompilationStatus compilationStatus32 = setCompilationStatus(i11, z11, z12);
                        return compilationStatus32;
                    } catch (PackageManager.NameNotFoundException unused3) {
                        return setCompilationStatus(65536, z11, z12);
                    }
                }
            }
            CompilationStatus compilationStatus4 = setCompilationStatus(262144, false, false);
            return compilationStatus4;
        }
    }
}
