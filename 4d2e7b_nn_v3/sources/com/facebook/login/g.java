package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.login.LoginClient;
import u2.d;
import u2.e;

public class g extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private String f20502b;

    /* renamed from: c  reason: collision with root package name */
    private LoginClient f20503c;

    /* renamed from: d  reason: collision with root package name */
    private LoginClient.Request f20504d;

    class a implements LoginClient.c {
        a() {
        }

        public void a(LoginClient.Result result) {
            g.this.t(result);
        }
    }

    class b implements LoginClient.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f20506a;

        b(View view) {
            this.f20506a = view;
        }

        public void a() {
            this.f20506a.setVisibility(0);
        }

        public void b() {
            this.f20506a.setVisibility(8);
        }
    }

    private void s(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            this.f20502b = callingActivity.getPackageName();
        }
    }

    /* access modifiers changed from: private */
    public void t(LoginClient.Result result) {
        int i10;
        this.f20504d = null;
        if (result.f20447a == LoginClient.Result.b.CANCEL) {
            i10 = 0;
        } else {
            i10 = -1;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(i10, intent);
            getActivity().finish();
        }
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.f20503c.w(i10, i11, intent);
    }

    public void onCreate(Bundle bundle) {
        Bundle bundleExtra;
        super.onCreate(bundle);
        if (bundle != null) {
            LoginClient loginClient = (LoginClient) bundle.getParcelable("loginClient");
            this.f20503c = loginClient;
            loginClient.y(this);
        } else {
            this.f20503c = p();
        }
        this.f20503c.z(new a());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            s(activity);
            Intent intent = activity.getIntent();
            if (intent != null && (bundleExtra = intent.getBundleExtra("com.facebook.LoginFragment:Request")) != null) {
                this.f20504d = (LoginClient.Request) bundleExtra.getParcelable("request");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(q(), viewGroup, false);
        this.f20503c.x(new b(inflate.findViewById(d.f24284d)));
        return inflate;
    }

    public void onDestroy() {
        this.f20503c.c();
        super.onDestroy();
    }

    public void onPause() {
        View view;
        super.onPause();
        if (getView() == null) {
            view = null;
        } else {
            view = getView().findViewById(d.f24284d);
        }
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f20502b == null) {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            getActivity().finish();
            return;
        }
        this.f20503c.A(this.f20504d);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("loginClient", this.f20503c);
    }

    /* access modifiers changed from: protected */
    public LoginClient p() {
        return new LoginClient((Fragment) this);
    }

    /* access modifiers changed from: protected */
    public int q() {
        return e.f24289c;
    }

    /* access modifiers changed from: package-private */
    public LoginClient r() {
        return this.f20503c;
    }
}
