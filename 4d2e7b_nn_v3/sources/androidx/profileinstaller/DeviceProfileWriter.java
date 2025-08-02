package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.MotionEventCompat;
import androidx.profileinstaller.ProfileInstaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DeviceProfileWriter {
    @NonNull
    private final String mApkName;
    @NonNull
    private final AssetManager mAssetManager;
    @NonNull
    private final File mCurProfile;
    @Nullable
    private final byte[] mDesiredVersion;
    private boolean mDeviceSupportsAotProfile = false;
    @NonNull
    private final ProfileInstaller.DiagnosticsCallback mDiagnostics;
    @NonNull
    private final Executor mExecutor;
    @Nullable
    private d[] mProfile;
    @NonNull
    private final String mProfileMetaSourceLocation;
    @NonNull
    private final String mProfileSourceLocation;
    @Nullable
    private byte[] mTranscodedProfile;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter(@NonNull AssetManager assetManager, @NonNull Executor executor, @NonNull ProfileInstaller.DiagnosticsCallback diagnosticsCallback, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull File file) {
        this.mAssetManager = assetManager;
        this.mExecutor = executor;
        this.mDiagnostics = diagnosticsCallback;
        this.mApkName = str;
        this.mProfileSourceLocation = str2;
        this.mProfileMetaSourceLocation = str3;
        this.mCurProfile = file;
        this.mDesiredVersion = desiredVersion();
    }

    @Nullable
    private DeviceProfileWriter addMetadata(d[] dVarArr, byte[] bArr) {
        InputStream openStreamFromAssets;
        try {
            openStreamFromAssets = openStreamFromAssets(this.mAssetManager, this.mProfileMetaSourceLocation);
            if (openStreamFromAssets != null) {
                this.mProfile = m.q(openStreamFromAssets, m.o(openStreamFromAssets, m.f16105b), bArr, dVarArr);
                openStreamFromAssets.close();
                return this;
            }
            if (openStreamFromAssets != null) {
                openStreamFromAssets.close();
            }
            return null;
        } catch (FileNotFoundException e10) {
            this.mDiagnostics.onResultReceived(9, e10);
        } catch (IOException e11) {
            this.mDiagnostics.onResultReceived(7, e11);
        } catch (IllegalStateException e12) {
            this.mProfile = null;
            this.mDiagnostics.onResultReceived(8, e12);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (!this.mDeviceSupportsAotProfile) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    @Nullable
    private static byte[] desiredVersion() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 24 || i10 > 34) {
            return null;
        }
        switch (i10) {
            case 24:
            case 25:
                return ProfileVersion.V001_N;
            case 26:
                return ProfileVersion.V005_O;
            case 27:
                return ProfileVersion.V009_O_MR1;
            case MotionEventCompat.AXIS_RELATIVE_Y:
            case 29:
            case 30:
                return ProfileVersion.V010_P;
            case 31:
            case 32:
            case MotionEventCompat.AXIS_GENERIC_2:
            case 34:
                return ProfileVersion.V015_S;
            default:
                return null;
        }
    }

    @Nullable
    private InputStream getProfileInputStream(AssetManager assetManager) {
        try {
            return openStreamFromAssets(assetManager, this.mProfileSourceLocation);
        } catch (FileNotFoundException e10) {
            this.mDiagnostics.onResultReceived(6, e10);
            return null;
        } catch (IOException e11) {
            this.mDiagnostics.onResultReceived(7, e11);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$result$0(int i10, Object obj) {
        this.mDiagnostics.onResultReceived(i10, obj);
    }

    @Nullable
    private InputStream openStreamFromAssets(AssetManager assetManager, String str) throws IOException {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message != null && message.contains("compressed")) {
                this.mDiagnostics.onDiagnosticReceived(5, (Object) null);
            }
            return null;
        }
    }

    @Nullable
    private d[] readProfileInternal(InputStream inputStream) {
        try {
            d[] w10 = m.w(inputStream, m.o(inputStream, m.f16104a), this.mApkName);
            try {
                inputStream.close();
                return w10;
            } catch (IOException e10) {
                this.mDiagnostics.onResultReceived(7, e10);
                return w10;
            }
        } catch (IOException e11) {
            this.mDiagnostics.onResultReceived(7, e11);
            inputStream.close();
            return null;
        } catch (IllegalStateException e12) {
            this.mDiagnostics.onResultReceived(8, e12);
            try {
                inputStream.close();
            } catch (IOException e13) {
                this.mDiagnostics.onResultReceived(7, e13);
            }
            return null;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e14) {
                this.mDiagnostics.onResultReceived(7, e14);
            }
            throw th;
        }
    }

    private static boolean requiresMetadata() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 24 || i10 > 34) {
            return false;
        }
        if (!(i10 == 24 || i10 == 25)) {
            switch (i10) {
                case 31:
                case 32:
                case MotionEventCompat.AXIS_GENERIC_2:
                case 34:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private void result(int i10, @Nullable Object obj) {
        this.mExecutor.execute(new c(this, i10, obj));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion == null) {
            result(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.mCurProfile.exists()) {
            try {
                this.mCurProfile.createNewFile();
            } catch (IOException unused) {
                result(4, (Object) null);
                return false;
            }
        } else if (!this.mCurProfile.canWrite()) {
            result(4, (Object) null);
            return false;
        }
        this.mDeviceSupportsAotProfile = true;
        return true;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter read() {
        DeviceProfileWriter addMetadata;
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion == null) {
            return this;
        }
        InputStream profileInputStream = getProfileInputStream(this.mAssetManager);
        if (profileInputStream != null) {
            this.mProfile = readProfileInternal(profileInputStream);
        }
        d[] dVarArr = this.mProfile;
        if (dVarArr == null || !requiresMetadata() || (addMetadata = addMetadata(dVarArr, this.mDesiredVersion)) == null) {
            return this;
        }
        return addMetadata;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter transcodeIfNeeded() {
        ByteArrayOutputStream byteArrayOutputStream;
        d[] dVarArr = this.mProfile;
        byte[] bArr = this.mDesiredVersion;
        if (!(dVarArr == null || bArr == null)) {
            assertDeviceAllowsProfileInstallerAotWritesCalled();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                m.E(byteArrayOutputStream, bArr);
                if (!m.B(byteArrayOutputStream, bArr, dVarArr)) {
                    this.mDiagnostics.onResultReceived(5, (Object) null);
                    this.mProfile = null;
                    byteArrayOutputStream.close();
                    return this;
                }
                this.mTranscodedProfile = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                this.mProfile = null;
            } catch (IOException e10) {
                this.mDiagnostics.onResultReceived(7, e10);
            } catch (IllegalStateException e11) {
                this.mDiagnostics.onResultReceived(8, e11);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        return this;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean write() {
        ByteArrayInputStream byteArrayInputStream;
        FileOutputStream fileOutputStream;
        byte[] bArr = this.mTranscodedProfile;
        if (bArr == null) {
            return false;
        }
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            fileOutputStream = new FileOutputStream(this.mCurProfile);
            e.l(byteArrayInputStream, fileOutputStream);
            result(1, (Object) null);
            fileOutputStream.close();
            byteArrayInputStream.close();
            this.mTranscodedProfile = null;
            this.mProfile = null;
            return true;
        } catch (FileNotFoundException e10) {
            result(6, e10);
            this.mTranscodedProfile = null;
            this.mProfile = null;
            return false;
        } catch (IOException e11) {
            result(7, e11);
            this.mTranscodedProfile = null;
            this.mProfile = null;
            return false;
        } catch (Throwable th) {
            this.mTranscodedProfile = null;
            this.mProfile = null;
            throw th;
        }
        throw th;
        throw th;
    }
}
