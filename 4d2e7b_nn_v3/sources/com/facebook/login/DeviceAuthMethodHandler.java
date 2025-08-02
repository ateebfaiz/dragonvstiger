package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.d;
import com.facebook.login.LoginClient;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f20410d;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public DeviceAuthMethodHandler createFromParcel(Parcel parcel) {
            return new DeviceAuthMethodHandler(parcel);
        }

        /* renamed from: b */
        public DeviceAuthMethodHandler[] newArray(int i10) {
            return new DeviceAuthMethodHandler[i10];
        }
    }

    DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    public static synchronized ScheduledThreadPoolExecutor q() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceAuthMethodHandler.class) {
            try {
                if (f20410d == null) {
                    f20410d = new ScheduledThreadPoolExecutor(1);
                }
                scheduledThreadPoolExecutor = f20410d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return scheduledThreadPoolExecutor;
    }

    private void u(LoginClient.Request request) {
        FragmentActivity i10 = f().i();
        if (i10 != null && !i10.isFinishing()) {
            DeviceAuthDialog p10 = p();
            p10.show(i10.getSupportFragmentManager(), "login_with_facebook");
            p10.N(request);
        }
    }

    public int describeContents() {
        return 0;
    }

    public String h() {
        return "device_auth";
    }

    public int o(LoginClient.Request request) {
        u(request);
        return 1;
    }

    /* access modifiers changed from: protected */
    public DeviceAuthDialog p() {
        return new DeviceAuthDialog();
    }

    public void r() {
        f().g(LoginClient.Result.a(f().q(), "User canceled log in."));
    }

    public void s(Exception exc) {
        f().g(LoginClient.Result.c(f().q(), (String) null, exc.getMessage()));
    }

    public void t(String str, String str2, String str3, Collection collection, Collection collection2, Collection collection3, d dVar, Date date, Date date2, Date date3) {
        f().g(LoginClient.Result.e(f().q(), new AccessToken(str, str2, str3, collection, collection2, collection3, dVar, date, date2, date3)));
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
    }

    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
