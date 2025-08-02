package j8;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.zing.zalo.zalosdk.ZaloOAuthResultCode;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f12395c = {ZaloOAuthResultCode.RESULTCODE_REGIS_IDENTIFY_CARD_NUMBER_SUCCESS, ZaloOAuthResultCode.RESULTCODE_REGIS_IDENTIFY_CARD_NUMBER_SUCCESS, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f12396d = {4000, 4000, 200, 200};

    /* renamed from: a  reason: collision with root package name */
    protected final AtomicReferenceArray f12397a;

    /* renamed from: b  reason: collision with root package name */
    protected final AtomicReferenceArray f12398b;

    public a() {
        this(4, 4);
    }

    public final byte[] a(int i10) {
        return b(i10, 0);
    }

    public byte[] b(int i10, int i11) {
        int f10 = f(i10);
        if (i11 < f10) {
            i11 = f10;
        }
        byte[] bArr = (byte[]) this.f12397a.getAndSet(i10, (Object) null);
        if (bArr == null || bArr.length < i11) {
            return e(i11);
        }
        return bArr;
    }

    public final char[] c(int i10) {
        return d(i10, 0);
    }

    public char[] d(int i10, int i11) {
        int h10 = h(i10);
        if (i11 < h10) {
            i11 = h10;
        }
        char[] cArr = (char[]) this.f12398b.getAndSet(i10, (Object) null);
        if (cArr == null || cArr.length < i11) {
            return g(i11);
        }
        return cArr;
    }

    /* access modifiers changed from: protected */
    public byte[] e(int i10) {
        return new byte[i10];
    }

    /* access modifiers changed from: protected */
    public int f(int i10) {
        return f12395c[i10];
    }

    /* access modifiers changed from: protected */
    public char[] g(int i10) {
        return new char[i10];
    }

    /* access modifiers changed from: protected */
    public int h(int i10) {
        return f12396d[i10];
    }

    public void i(int i10, byte[] bArr) {
        this.f12397a.set(i10, bArr);
    }

    public void j(int i10, char[] cArr) {
        this.f12398b.set(i10, cArr);
    }

    protected a(int i10, int i11) {
        this.f12397a = new AtomicReferenceArray(i10);
        this.f12398b = new AtomicReferenceArray(i11);
    }
}
