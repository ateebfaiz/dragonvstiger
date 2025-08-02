package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.a;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final boolean f13765a = false;

    /* renamed from: b  reason: collision with root package name */
    final Handler f13766b = null;

    /* renamed from: c  reason: collision with root package name */
    a f13767c;

    class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        /* renamed from: b */
        public ResultReceiver[] newArray(int i10) {
            return new ResultReceiver[i10];
        }
    }

    class b extends a.C0178a {
        b() {
        }

        public void K(int i10, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.f13766b;
            if (handler != null) {
                handler.post(new c(i10, bundle));
            } else {
                resultReceiver.a(i10, bundle);
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final int f13769a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f13770b;

        c(int i10, Bundle bundle) {
            this.f13769a = i10;
            this.f13770b = bundle;
        }

        public void run() {
            ResultReceiver.this.a(this.f13769a, this.f13770b);
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f13767c = a.C0178a.M(parcel.readStrongBinder());
    }

    /* access modifiers changed from: protected */
    public void a(int i10, Bundle bundle) {
    }

    public void b(int i10, Bundle bundle) {
        if (this.f13765a) {
            Handler handler = this.f13766b;
            if (handler != null) {
                handler.post(new c(i10, bundle));
            } else {
                a(i10, bundle);
            }
        } else {
            a aVar = this.f13767c;
            if (aVar != null) {
                try {
                    aVar.K(i10, bundle);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        synchronized (this) {
            try {
                if (this.f13767c == null) {
                    this.f13767c = new b();
                }
                parcel.writeStrongBinder(this.f13767c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
