package com.facebook.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.facebook.AccessToken;
import com.facebook.FacebookActivity;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.l;
import com.facebook.login.LoginClient;
import com.facebook.o;
import com.facebook.r;
import com.facebook.t;
import com.facebook.u;
import com.zing.zalo.zalosdk.common.Constant;
import e2.m;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import q5.j0;
import q5.p0;
import q5.q0;
import q5.s;

public class DeviceAuthDialog extends DialogFragment {
    /* access modifiers changed from: private */
    public LoginClient.Request C = null;

    /* renamed from: b  reason: collision with root package name */
    private View f20379b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f20380c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f20381d;

    /* renamed from: e  reason: collision with root package name */
    private DeviceAuthMethodHandler f20382e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f20383f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    private volatile r f20384g;

    /* renamed from: h  reason: collision with root package name */
    private volatile ScheduledFuture f20385h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public volatile RequestState f20386i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f20387j = false;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f20388w = false;

    private static class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private String f20389a;

        /* renamed from: b  reason: collision with root package name */
        private String f20390b;

        /* renamed from: c  reason: collision with root package name */
        private String f20391c;

        /* renamed from: d  reason: collision with root package name */
        private long f20392d;

        /* renamed from: e  reason: collision with root package name */
        private long f20393e;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public RequestState createFromParcel(Parcel parcel) {
                return new RequestState(parcel);
            }

            /* renamed from: b */
            public RequestState[] newArray(int i10) {
                return new RequestState[i10];
            }
        }

        RequestState() {
        }

        public String a() {
            return this.f20389a;
        }

        public long b() {
            return this.f20392d;
        }

        public String c() {
            return this.f20391c;
        }

        public String d() {
            return this.f20390b;
        }

        public int describeContents() {
            return 0;
        }

        public void e(long j10) {
            this.f20392d = j10;
        }

        public void f(long j10) {
            this.f20393e = j10;
        }

        public void g(String str) {
            this.f20391c = str;
        }

        public void h(String str) {
            this.f20390b = str;
            this.f20389a = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", new Object[]{str});
        }

        public boolean i() {
            if (this.f20393e != 0 && (new Date().getTime() - this.f20393e) - (this.f20392d * 1000) < 0) {
                return true;
            }
            return false;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f20389a);
            parcel.writeString(this.f20390b);
            parcel.writeString(this.f20391c);
            parcel.writeLong(this.f20392d);
            parcel.writeLong(this.f20393e);
        }

        protected RequestState(Parcel parcel) {
            this.f20389a = parcel.readString();
            this.f20390b = parcel.readString();
            this.f20391c = parcel.readString();
            this.f20392d = parcel.readLong();
            this.f20393e = parcel.readLong();
        }
    }

    class a extends Dialog {
        a(Context context, int i10) {
            super(context, i10);
        }

        public void onBackPressed() {
            DeviceAuthDialog.this.F();
            super.onBackPressed();
        }
    }

    class b implements GraphRequest.b {
        b() {
        }

        public void a(t tVar) {
            if (!DeviceAuthDialog.this.f20387j) {
                if (tVar.b() != null) {
                    DeviceAuthDialog.this.H(tVar.b().e());
                    return;
                }
                JSONObject c10 = tVar.c();
                RequestState requestState = new RequestState();
                try {
                    requestState.h(c10.getString("user_code"));
                    requestState.g(c10.getString(Constant.PARAM_OAUTH_CODE));
                    requestState.e(c10.getLong("interval"));
                    DeviceAuthDialog.this.M(requestState);
                } catch (JSONException e10) {
                    DeviceAuthDialog.this.H(new l((Throwable) e10));
                }
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            if (!v5.a.d(this)) {
                try {
                    DeviceAuthDialog.this.G();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            if (!v5.a.d(this)) {
                try {
                    DeviceAuthDialog.this.J();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    class e implements GraphRequest.b {
        e() {
        }

        public void a(t tVar) {
            if (!DeviceAuthDialog.this.f20383f.get()) {
                FacebookRequestError b10 = tVar.b();
                if (b10 != null) {
                    int h10 = b10.h();
                    if (h10 != 1349152) {
                        switch (h10) {
                            case 1349172:
                            case 1349174:
                                DeviceAuthDialog.this.L();
                                return;
                            case 1349173:
                                DeviceAuthDialog.this.G();
                                return;
                            default:
                                DeviceAuthDialog.this.H(tVar.b().e());
                                return;
                        }
                    } else {
                        if (DeviceAuthDialog.this.f20386i != null) {
                            m3.a.a(DeviceAuthDialog.this.f20386i.d());
                        }
                        if (DeviceAuthDialog.this.C != null) {
                            DeviceAuthDialog deviceAuthDialog = DeviceAuthDialog.this;
                            deviceAuthDialog.N(deviceAuthDialog.C);
                            return;
                        }
                        DeviceAuthDialog.this.G();
                    }
                } else {
                    try {
                        JSONObject c10 = tVar.c();
                        DeviceAuthDialog.this.I(c10.getString("access_token"), Long.valueOf(c10.getLong("expires_in")), Long.valueOf(c10.optLong("data_access_expiration_time")));
                    } catch (JSONException e10) {
                        DeviceAuthDialog.this.H(new l((Throwable) e10));
                    }
                }
            }
        }
    }

    class f implements DialogInterface.OnClickListener {
        f() {
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            DeviceAuthDialog.this.getDialog().setContentView(DeviceAuthDialog.this.E(false));
            DeviceAuthDialog deviceAuthDialog = DeviceAuthDialog.this;
            deviceAuthDialog.N(deviceAuthDialog.C);
        }
    }

    class g implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f20400a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p0.c f20401b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f20402c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Date f20403d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Date f20404e;

        g(String str, p0.c cVar, String str2, Date date, Date date2) {
            this.f20400a = str;
            this.f20401b = cVar;
            this.f20402c = str2;
            this.f20403d = date;
            this.f20404e = date2;
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            DeviceAuthDialog.this.B(this.f20400a, this.f20401b, this.f20402c, this.f20403d, this.f20404e);
        }
    }

    class h implements GraphRequest.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f20406a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Date f20407b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Date f20408c;

        h(String str, Date date, Date date2) {
            this.f20406a = str;
            this.f20407b = date;
            this.f20408c = date2;
        }

        public void a(t tVar) {
            if (!DeviceAuthDialog.this.f20383f.get()) {
                if (tVar.b() != null) {
                    DeviceAuthDialog.this.H(tVar.b().e());
                    return;
                }
                try {
                    JSONObject c10 = tVar.c();
                    String string = c10.getString("id");
                    p0.c L = p0.L(c10);
                    String string2 = c10.getString("name");
                    m3.a.a(DeviceAuthDialog.this.f20386i.d());
                    if (!s.j(o.g()).m().contains(j0.RequireConfirm) || DeviceAuthDialog.this.f20388w) {
                        DeviceAuthDialog.this.B(string, L, this.f20406a, this.f20407b, this.f20408c);
                        return;
                    }
                    boolean unused = DeviceAuthDialog.this.f20388w = true;
                    DeviceAuthDialog.this.K(string, L, this.f20406a, string2, this.f20407b, this.f20408c);
                } catch (JSONException e10) {
                    DeviceAuthDialog.this.H(new l((Throwable) e10));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void B(String str, p0.c cVar, String str2, Date date, Date date2) {
        this.f20382e.t(str2, o.g(), str, cVar.c(), cVar.a(), cVar.b(), com.facebook.d.DEVICE_AUTH, date, (Date) null, date2);
        getDialog().dismiss();
    }

    private GraphRequest D() {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.PARAM_OAUTH_CODE, this.f20386i.c());
        return new GraphRequest((AccessToken) null, "device/login_status", bundle, u.POST, new e());
    }

    /* access modifiers changed from: private */
    public void I(String str, Long l10, Long l11) {
        Date date;
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        Date date2 = null;
        if (l10.longValue() != 0) {
            date = new Date(new Date().getTime() + (l10.longValue() * 1000));
        } else {
            date = null;
        }
        if (l11.longValue() != 0) {
            date2 = new Date(l11.longValue() * 1000);
        }
        new GraphRequest(new AccessToken(str, o.g(), "0", (Collection) null, (Collection) null, (Collection) null, (com.facebook.d) null, date, (Date) null, date2), "me", bundle, u.GET, new h(str, date, date2)).j();
    }

    /* access modifiers changed from: private */
    public void J() {
        this.f20386i.f(new Date().getTime());
        this.f20384g = D().j();
    }

    /* access modifiers changed from: private */
    public void K(String str, p0.c cVar, String str2, String str3, Date date, Date date2) {
        String string = getResources().getString(u2.f.f24299i);
        String string2 = getResources().getString(u2.f.f24298h);
        String string3 = getResources().getString(u2.f.f24297g);
        String format = String.format(string2, new Object[]{str3});
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new g(str, cVar, str2, date, date2)).setPositiveButton(string3, new f());
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public void L() {
        this.f20385h = DeviceAuthMethodHandler.q().schedule(new d(), this.f20386i.b(), TimeUnit.SECONDS);
    }

    /* access modifiers changed from: private */
    public void M(RequestState requestState) {
        this.f20386i = requestState;
        this.f20380c.setText(requestState.d());
        this.f20381d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, new BitmapDrawable(getResources(), m3.a.c(requestState.a())), (Drawable) null, (Drawable) null);
        this.f20380c.setVisibility(0);
        this.f20379b.setVisibility(8);
        if (!this.f20388w && m3.a.g(requestState.d())) {
            new m(getContext()).f("fb_smart_login_service");
        }
        if (requestState.i()) {
            L();
        } else {
            J();
        }
    }

    /* access modifiers changed from: package-private */
    public Map A() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int C(boolean z10) {
        if (z10) {
            return u2.e.f24290d;
        }
        return u2.e.f24288b;
    }

    /* access modifiers changed from: protected */
    public View E(boolean z10) {
        View inflate = getActivity().getLayoutInflater().inflate(C(z10), (ViewGroup) null);
        this.f20379b = inflate.findViewById(u2.d.f24286f);
        this.f20380c = (TextView) inflate.findViewById(u2.d.f24285e);
        ((Button) inflate.findViewById(u2.d.f24281a)).setOnClickListener(new c());
        TextView textView = (TextView) inflate.findViewById(u2.d.f24282b);
        this.f20381d = textView;
        textView.setText(Html.fromHtml(getString(u2.f.f24291a)));
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void F() {
    }

    /* access modifiers changed from: protected */
    public void G() {
        if (this.f20383f.compareAndSet(false, true)) {
            if (this.f20386i != null) {
                m3.a.a(this.f20386i.d());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler = this.f20382e;
            if (deviceAuthMethodHandler != null) {
                deviceAuthMethodHandler.r();
            }
            getDialog().dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void H(l lVar) {
        if (this.f20383f.compareAndSet(false, true)) {
            if (this.f20386i != null) {
                m3.a.a(this.f20386i.d());
            }
            this.f20382e.s(lVar);
            getDialog().dismiss();
        }
    }

    public void N(LoginClient.Request request) {
        this.C = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.k()));
        String f10 = request.f();
        if (f10 != null) {
            bundle.putString("redirect_uri", f10);
        }
        String e10 = request.e();
        if (e10 != null) {
            bundle.putString("target_user_id", e10);
        }
        bundle.putString("access_token", q0.b() + "|" + q0.c());
        bundle.putString("device_info", m3.a.e(A()));
        new GraphRequest((AccessToken) null, "device/login", bundle, u.POST, new b()).j();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        boolean z10;
        a aVar = new a(getActivity(), u2.g.f24301b);
        if (!m3.a.f() || this.f20388w) {
            z10 = false;
        } else {
            z10 = true;
        }
        aVar.setContentView(E(z10));
        return aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f20382e = (DeviceAuthMethodHandler) ((g) ((FacebookActivity) getActivity()).getCurrentFragment()).r().j();
        if (!(bundle == null || (requestState = (RequestState) bundle.getParcelable("request_state")) == null)) {
            M(requestState);
        }
        return onCreateView;
    }

    public void onDestroyView() {
        this.f20387j = true;
        this.f20383f.set(true);
        super.onDestroyView();
        if (this.f20384g != null) {
            this.f20384g.cancel(true);
        }
        if (this.f20385h != null) {
            this.f20385h.cancel(true);
        }
        this.f20379b = null;
        this.f20380c = null;
        this.f20381d = null;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.f20387j) {
            G();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f20386i != null) {
            bundle.putParcelable("request_state", this.f20386i);
        }
    }
}
