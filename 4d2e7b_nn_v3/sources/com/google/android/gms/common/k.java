package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class k extends zzz {

    /* renamed from: a  reason: collision with root package name */
    private final int f6813a;

    protected k(byte[] bArr) {
        boolean z10;
        if (bArr.length == 25) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        this.f6813a = Arrays.hashCode(bArr);
    }

    protected static byte[] M(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] N();

    public final boolean equals(Object obj) {
        IObjectWrapper zzd;
        if (obj != null && (obj instanceof zzaa)) {
            try {
                zzaa zzaa = (zzaa) obj;
                if (zzaa.zzc() != this.f6813a || (zzd = zzaa.zzd()) == null) {
                    return false;
                }
                return Arrays.equals(N(), (byte[]) ObjectWrapper.unwrap(zzd));
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f6813a;
    }

    public final int zzc() {
        return this.f6813a;
    }

    public final IObjectWrapper zzd() {
        return ObjectWrapper.wrap(N());
    }
}
