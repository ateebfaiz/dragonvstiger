package h9;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Object f12300a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final String f12301b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12302c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12303d;

    /* renamed from: e  reason: collision with root package name */
    private final SecureRandom f12304e;

    /* renamed from: f  reason: collision with root package name */
    private final SecretKeyFactory f12305f;

    /* renamed from: g  reason: collision with root package name */
    private final Cipher f12306g;

    /* renamed from: h  reason: collision with root package name */
    private final Mac f12307h;

    /* renamed from: i  reason: collision with root package name */
    private a f12308i;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final SecretKey f12309a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final SecretKey f12310b;

        a(SecretKey secretKey, SecretKey secretKey2) {
            this.f12309a = secretKey;
            this.f12310b = secretKey2;
        }
    }

    public b(String str, int i10, boolean z10) {
        this.f12301b = str;
        this.f12302c = i10;
        this.f12303d = z10;
        try {
            this.f12304e = new SecureRandom();
            this.f12305f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            this.f12306g = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f12307h = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e10) {
            throw new RuntimeException(e10);
        }
    }

    private String c(Context context) {
        String str;
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (this.f12303d) {
            str = Build.SERIAL;
        } else {
            str = "";
        }
        return Build.MODEL + Build.MANUFACTURER + str + string + context.getPackageName();
    }

    private byte[] d(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(this.f12301b, 0);
        String string = sharedPreferences.getString("salt", (String) null);
        if (!TextUtils.isEmpty(string)) {
            return Base64.decode(string, 0);
        }
        byte[] bArr = new byte[16];
        this.f12304e.nextBytes(bArr);
        sharedPreferences.edit().putString("salt", Base64.encodeToString(bArr, 0)).apply();
        return bArr;
    }

    private a e(Context context) {
        String c10 = c(context);
        try {
            byte[] encoded = this.f12305f.generateSecret(new PBEKeySpec(c10.toCharArray(), d(context), this.f12302c, 512)).getEncoded();
            return new a(new SecretKeySpec(Arrays.copyOfRange(encoded, 0, 32), "AES"), new SecretKeySpec(Arrays.copyOfRange(encoded, 32, encoded.length), "HmacSHA256"));
        } catch (InvalidKeySpecException e10) {
            throw new RuntimeException(e10);
        }
    }

    public String a(Context context, String str) {
        String str2;
        synchronized (this.f12300a) {
            f(context);
            try {
                byte[] decode = Base64.decode(str, 0);
                byte[] copyOfRange = Arrays.copyOfRange(decode, decode.length - 32, decode.length);
                this.f12307h.init(this.f12308i.f12310b);
                this.f12307h.update(decode, 0, decode.length - 32);
                if (MessageDigest.isEqual(this.f12307h.doFinal(), copyOfRange)) {
                    this.f12306g.init(2, this.f12308i.f12309a, new IvParameterSpec(decode, 0, 16));
                    str2 = new String(this.f12306g.doFinal(decode, 16, decode.length - 48), "UTF-8");
                } else {
                    throw new a("Cipher text has been tampered with.");
                }
            } catch (BadPaddingException e10) {
                throw new a((Throwable) e10);
            } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException | IllegalBlockSizeException e11) {
                throw new RuntimeException(e11);
            }
        }
        return str2;
    }

    public String b(Context context, String str) {
        String encodeToString;
        synchronized (this.f12300a) {
            try {
                f(context);
                int blockSize = this.f12306g.getBlockSize();
                byte[] bArr = new byte[blockSize];
                this.f12304e.nextBytes(bArr);
                this.f12306g.init(1, this.f12308i.f12309a, new IvParameterSpec(bArr));
                byte[] doFinal = this.f12306g.doFinal(str.getBytes("UTF-8"));
                byte[] bArr2 = new byte[(doFinal.length + blockSize + 32)];
                System.arraycopy(bArr, 0, bArr2, 0, blockSize);
                System.arraycopy(doFinal, 0, bArr2, blockSize, doFinal.length);
                this.f12307h.init(this.f12308i.f12310b);
                this.f12307h.update(bArr2, 0, doFinal.length + blockSize);
                byte[] doFinal2 = this.f12307h.doFinal();
                System.arraycopy(doFinal2, 0, bArr2, blockSize + doFinal.length, doFinal2.length);
                encodeToString = Base64.encodeToString(bArr2, 0);
            } catch (BadPaddingException e10) {
                throw new a((Throwable) e10);
            } catch (UnsupportedEncodingException e11) {
                e = e11;
                throw new RuntimeException(e);
            } catch (InvalidKeyException e12) {
                e = e12;
                throw new RuntimeException(e);
            } catch (IllegalBlockSizeException e13) {
                e = e13;
                throw new RuntimeException(e);
            } catch (InvalidAlgorithmParameterException e14) {
                e = e14;
                throw new RuntimeException(e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return encodeToString;
    }

    public void f(Context context) {
        synchronized (this.f12300a) {
            try {
                if (this.f12308i == null) {
                    this.f12308i = e(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
