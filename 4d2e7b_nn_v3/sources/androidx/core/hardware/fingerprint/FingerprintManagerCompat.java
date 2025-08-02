package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FingerprintManagerCompat {
    private final Context mContext;

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i10, @NonNull CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i10, @NonNull CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(@NonNull AuthenticationResult authenticationResult) {
        }
    }

    public static final class AuthenticationResult {
        private final CryptoObject mCryptoObject;

        public AuthenticationResult(@NonNull CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        @NonNull
        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    class a extends FingerprintManager.AuthenticationCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AuthenticationCallback f14948a;

        a(AuthenticationCallback authenticationCallback) {
            this.f14948a = authenticationCallback;
        }

        public void onAuthenticationError(int i10, CharSequence charSequence) {
            this.f14948a.onAuthenticationError(i10, charSequence);
        }

        public void onAuthenticationFailed() {
            this.f14948a.onAuthenticationFailed();
        }

        public void onAuthenticationHelp(int i10, CharSequence charSequence) {
            this.f14948a.onAuthenticationHelp(i10, charSequence);
        }

        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            this.f14948a.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerCompat.unwrapCryptoObject(b.b(authenticationResult))));
        }
    }

    static class b {
        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        static void a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i10, Object obj3, Handler handler) {
            ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i10, (FingerprintManager.AuthenticationCallback) obj3, handler);
        }

        @DoNotInline
        static FingerprintManager.CryptoObject b(Object obj) {
            return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
        }

        @DoNotInline
        public static FingerprintManager c(Context context) {
            int i10 = Build.VERSION.SDK_INT;
            Class cls = FingerprintManager.class;
            if (i10 == 23) {
                return (FingerprintManager) context.getSystemService(cls);
            }
            if (i10 <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
                return null;
            }
            return (FingerprintManager) context.getSystemService(cls);
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        static boolean d(Object obj) {
            return ((FingerprintManager) obj).hasEnrolledFingerprints();
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        static boolean e(Object obj) {
            return ((FingerprintManager) obj).isHardwareDetected();
        }

        @DoNotInline
        public static CryptoObject f(Object obj) {
            FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        @DoNotInline
        public static FingerprintManager.CryptoObject g(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.getMac());
            }
            return null;
        }
    }

    private FingerprintManagerCompat(Context context) {
        this.mContext = context;
    }

    @NonNull
    public static FingerprintManagerCompat from(@NonNull Context context) {
        return new FingerprintManagerCompat(context);
    }

    @RequiresApi(23)
    @Nullable
    private static FingerprintManager getFingerprintManagerOrNull(@NonNull Context context) {
        return b.c(context);
    }

    @RequiresApi(23)
    static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject cryptoObject) {
        return b.f(cryptoObject);
    }

    @RequiresApi(23)
    private static FingerprintManager.AuthenticationCallback wrapCallback(AuthenticationCallback authenticationCallback) {
        return new a(authenticationCallback);
    }

    @RequiresApi(23)
    private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        return b.g(cryptoObject);
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void authenticate(@Nullable CryptoObject cryptoObject, int i10, @Nullable androidx.core.os.CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        authenticate(cryptoObject, i10, cancellationSignal != null ? (CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, authenticationCallback, handler);
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean hasEnrolledFingerprints() {
        FingerprintManager fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManagerOrNull == null || !b.d(fingerprintManagerOrNull)) {
            return false;
        }
        return true;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean isHardwareDetected() {
        FingerprintManager fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManagerOrNull == null || !b.e(fingerprintManagerOrNull)) {
            return false;
        }
        return true;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public void authenticate(@Nullable CryptoObject cryptoObject, int i10, @Nullable CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        FingerprintManager fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManagerOrNull != null) {
            b.a(fingerprintManagerOrNull, wrapCryptoObject(cryptoObject), cancellationSignal, i10, wrapCallback(authenticationCallback), handler);
        }
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(@NonNull Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        @Nullable
        public Cipher getCipher() {
            return this.mCipher;
        }

        @Nullable
        public Mac getMac() {
            return this.mMac;
        }

        @Nullable
        public Signature getSignature() {
            return this.mSignature;
        }

        public CryptoObject(@NonNull Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(@NonNull Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }
    }
}
