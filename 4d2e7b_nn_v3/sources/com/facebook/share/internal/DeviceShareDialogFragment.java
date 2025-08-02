package com.facebook.share.internal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.t;
import com.facebook.u;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import q5.q0;
import u2.d;
import u2.e;
import u2.f;
import u2.g;

@Deprecated
public class DeviceShareDialogFragment extends DialogFragment {

    /* renamed from: h  reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f4379h;

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f4380b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f4381c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Dialog f4382d;

    /* renamed from: e  reason: collision with root package name */
    private volatile RequestState f4383e;

    /* renamed from: f  reason: collision with root package name */
    private volatile ScheduledFuture f4384f;

    /* renamed from: g  reason: collision with root package name */
    private ShareContent f4385g;

    private static class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private String f4386a;

        /* renamed from: b  reason: collision with root package name */
        private long f4387b;

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

        public long a() {
            return this.f4387b;
        }

        public String b() {
            return this.f4386a;
        }

        public void c(long j10) {
            this.f4387b = j10;
        }

        public void d(String str) {
            this.f4386a = str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f4386a);
            parcel.writeLong(this.f4387b);
        }

        protected RequestState(Parcel parcel) {
            this.f4386a = parcel.readString();
            this.f4387b = parcel.readLong();
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            if (!v5.a.d(this)) {
                try {
                    DeviceShareDialogFragment.this.f4382d.dismiss();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    class b implements GraphRequest.b {
        b() {
        }

        public void a(t tVar) {
            FacebookRequestError b10 = tVar.b();
            if (b10 != null) {
                DeviceShareDialogFragment.this.t(b10);
                return;
            }
            JSONObject c10 = tVar.c();
            RequestState requestState = new RequestState();
            try {
                requestState.d(c10.getString("user_code"));
                requestState.c(c10.getLong("expires_in"));
                DeviceShareDialogFragment.this.w(requestState);
            } catch (JSONException unused) {
                DeviceShareDialogFragment.this.t(new FacebookRequestError(0, "", "Malformed server response"));
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            if (!v5.a.d(this)) {
                try {
                    DeviceShareDialogFragment.this.f4382d.dismiss();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    private void r() {
        if (isAdded()) {
            getFragmentManager().beginTransaction().remove(this).commit();
        }
    }

    private void s(int i10, Intent intent) {
        if (this.f4383e != null) {
            m3.a.a(this.f4383e.b());
        }
        FacebookRequestError facebookRequestError = (FacebookRequestError) intent.getParcelableExtra(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        if (facebookRequestError != null) {
            Toast.makeText(getContext(), facebookRequestError.c(), 0).show();
        }
        if (isAdded()) {
            FragmentActivity activity = getActivity();
            activity.setResult(i10, intent);
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    public void t(FacebookRequestError facebookRequestError) {
        r();
        Intent intent = new Intent();
        intent.putExtra(Constants.IPC_BUNDLE_KEY_SEND_ERROR, facebookRequestError);
        s(-1, intent);
    }

    private static synchronized ScheduledThreadPoolExecutor u() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceShareDialogFragment.class) {
            try {
                if (f4379h == null) {
                    f4379h = new ScheduledThreadPoolExecutor(1);
                }
                scheduledThreadPoolExecutor = f4379h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return scheduledThreadPoolExecutor;
    }

    private Bundle v() {
        ShareContent shareContent = this.f4385g;
        if (shareContent == null) {
            return null;
        }
        if (shareContent instanceof ShareLinkContent) {
            return r.a((ShareLinkContent) shareContent);
        }
        if (shareContent instanceof ShareOpenGraphContent) {
            return r.b((ShareOpenGraphContent) shareContent);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void w(RequestState requestState) {
        this.f4383e = requestState;
        this.f4381c.setText(requestState.b());
        this.f4381c.setVisibility(0);
        this.f4380b.setVisibility(8);
        this.f4384f = u().schedule(new c(), requestState.a(), TimeUnit.SECONDS);
    }

    private void y() {
        Bundle v10 = v();
        if (v10 == null || v10.size() == 0) {
            t(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        v10.putString("access_token", q0.b() + "|" + q0.c());
        v10.putString("device_info", m3.a.d());
        new GraphRequest((AccessToken) null, "device/share", v10, u.POST, new b()).j();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.f4382d = new Dialog(getActivity(), g.f24301b);
        View inflate = getActivity().getLayoutInflater().inflate(e.f24288b, (ViewGroup) null);
        this.f4380b = (ProgressBar) inflate.findViewById(d.f24286f);
        this.f4381c = (TextView) inflate.findViewById(d.f24285e);
        ((Button) inflate.findViewById(d.f24281a)).setOnClickListener(new a());
        ((TextView) inflate.findViewById(d.f24282b)).setText(Html.fromHtml(getString(f.f24291a)));
        this.f4382d.setContentView(inflate);
        y();
        return this.f4382d;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (!(bundle == null || (requestState = (RequestState) bundle.getParcelable("request_state")) == null)) {
            w(requestState);
        }
        return onCreateView;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f4384f != null) {
            this.f4384f.cancel(true);
        }
        s(-1, new Intent());
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f4383e != null) {
            bundle.putParcelable("request_state", this.f4383e);
        }
    }

    public void x(ShareContent shareContent) {
        this.f4385g = shareContent;
    }
}
