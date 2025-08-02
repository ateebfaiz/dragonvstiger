package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.google.android.games.paddleboat.GameControllerManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PackageInfoCompat {

    private static class a {
        @DoNotInline
        @Nullable
        static Signature[] a(@NonNull SigningInfo signingInfo) {
            return signingInfo.getApkContentsSigners();
        }

        @DoNotInline
        static long b(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }

        @DoNotInline
        @Nullable
        static Signature[] c(@NonNull SigningInfo signingInfo) {
            return signingInfo.getSigningCertificateHistory();
        }

        @DoNotInline
        static boolean d(@NonNull SigningInfo signingInfo) {
            return signingInfo.hasMultipleSigners();
        }

        @DoNotInline
        static boolean e(@NonNull PackageManager packageManager, @NonNull String str, @NonNull byte[] bArr, int i10) {
            return packageManager.hasSigningCertificate(str, bArr, i10);
        }
    }

    private PackageInfoCompat() {
    }

    private static boolean byteArrayContains(@NonNull byte[][] bArr, @NonNull byte[] bArr2) {
        for (byte[] equals : bArr) {
            if (Arrays.equals(bArr2, equals)) {
                return true;
            }
        }
        return false;
    }

    private static byte[] computeSHA256Digest(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA256").digest(bArr);
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Device doesn't support SHA256 cert checking", e10);
        }
    }

    public static long getLongVersionCode(@NonNull PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.b(packageInfo);
        }
        return (long) packageInfo.versionCode;
    }

    @NonNull
    public static List<Signature> getSignatures(@NonNull PackageManager packageManager, @NonNull String str) throws PackageManager.NameNotFoundException {
        Signature[] signatureArr;
        if (Build.VERSION.SDK_INT >= 28) {
            SigningInfo a10 = packageManager.getPackageInfo(str, GameControllerManager.DEVICEFLAG_VIBRATION).signingInfo;
            if (a.d(a10)) {
                signatureArr = a.a(a10);
            } else {
                signatureArr = a.c(a10);
            }
        } else {
            signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        }
        if (signatureArr == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(signatureArr);
    }

    public static boolean hasSignatures(@NonNull PackageManager packageManager, @NonNull String str, @Size(min = 1) @NonNull Map<byte[], Integer> map, boolean z10) throws PackageManager.NameNotFoundException {
        byte[][] bArr;
        if (map.isEmpty()) {
            return false;
        }
        Set<byte[]> keySet = map.keySet();
        for (byte[] next : keySet) {
            if (next != null) {
                Integer num = map.get(next);
                if (num != null) {
                    int intValue = num.intValue();
                    if (intValue != 0 && intValue != 1) {
                        throw new IllegalArgumentException("Unsupported certificate type " + num + " when verifying " + str);
                    }
                } else {
                    throw new IllegalArgumentException("Type must be specified for cert when verifying " + str);
                }
            } else {
                throw new IllegalArgumentException("Cert byte array cannot be null when verifying " + str);
            }
        }
        List<Signature> signatures = getSignatures(packageManager, str);
        if (z10 || Build.VERSION.SDK_INT < 28) {
            if (signatures.size() != 0 && map.size() <= signatures.size() && (!z10 || map.size() == signatures.size())) {
                if (map.containsValue(1)) {
                    bArr = new byte[signatures.size()][];
                    for (int i10 = 0; i10 < signatures.size(); i10++) {
                        bArr[i10] = computeSHA256Digest(signatures.get(i10).toByteArray());
                    }
                } else {
                    bArr = null;
                }
                Iterator<byte[]> it = keySet.iterator();
                if (it.hasNext()) {
                    byte[] next2 = it.next();
                    Integer num2 = map.get(next2);
                    int intValue2 = num2.intValue();
                    if (intValue2 != 0) {
                        if (intValue2 != 1) {
                            throw new IllegalArgumentException("Unsupported certificate type " + num2);
                        } else if (!byteArrayContains(bArr, next2)) {
                            return false;
                        }
                    } else if (!signatures.contains(new Signature(next2))) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
        for (byte[] next3 : keySet) {
            if (!a.e(packageManager, str, next3, map.get(next3).intValue())) {
                return false;
            }
        }
        return true;
    }
}
