package x7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.CustomTabMainActivity;
import com.facebook.o;
import com.zing.zalo.zalosdk.common.Constant;
import q5.e;
import q5.f;
import q5.p0;

class a {

    /* renamed from: a  reason: collision with root package name */
    private Fragment f13226a;

    /* renamed from: b  reason: collision with root package name */
    private String f13227b;

    /* renamed from: c  reason: collision with root package name */
    protected String f13228c;

    a(Fragment fragment) {
        this.f13226a = fragment;
    }

    private void a(int i10, Intent intent) {
        FragmentActivity activity;
        if (this.f13226a.isAdded() && (activity = this.f13226a.getActivity()) != null) {
            activity.setResult(i10, intent);
            activity.finish();
        }
    }

    private String b() {
        if (this.f13227b == null) {
            this.f13227b = f.a();
        }
        return this.f13227b;
    }

    static String c() {
        return "fb" + o.g() + "://authorize";
    }

    private Bundle d() {
        Bundle bundle = new Bundle();
        this.f13228c = p0.s(20);
        bundle.putString("redirect_uri", f.c(c()));
        bundle.putString(Constant.PARAM_APP_ID, o.g());
        bundle.putString("state", this.f13228c);
        return bundle;
    }

    private boolean e() {
        if (b() != null) {
            return true;
        }
        return false;
    }

    private boolean h() {
        if (this.f13226a.getActivity() == null || this.f13226a.getActivity().checkCallingOrSelfPermission("android.permission.INTERNET") != 0 || !e()) {
            return false;
        }
        Bundle d10 = d();
        if (o.f20687p) {
            com.facebook.login.a.e(e.a("share_referral", d10));
        }
        Intent intent = new Intent(this.f13226a.getActivity(), CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, "share_referral");
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, d10);
        intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, b());
        this.f13226a.startActivityForResult(intent, 1);
        return true;
    }

    private boolean i(Bundle bundle) {
        if (this.f13228c == null) {
            return true;
        }
        boolean equals = this.f13228c.equals(bundle.getString("state"));
        this.f13228c = null;
        return equals;
    }

    /* access modifiers changed from: package-private */
    public void f(int i10, int i11, Intent intent) {
        String stringExtra;
        if (i10 == 1) {
            if (!(intent == null || (stringExtra = intent.getStringExtra(CustomTabMainActivity.EXTRA_URL)) == null || !stringExtra.startsWith(f.c(c())))) {
                Bundle l02 = p0.l0(Uri.parse(stringExtra).getQuery());
                if (i(l02)) {
                    intent.putExtras(l02);
                } else {
                    intent.putExtra("error_message", "The referral response was missing a valid challenge string.");
                    i11 = 0;
                }
            }
            a(i11, intent);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (!h()) {
            Intent intent = new Intent();
            intent.putExtra("error_message", "Failed to open Referral dialog: Chrome custom tab could not be started. Please make sure internet permission is granted and Chrome is installed");
            a(0, intent);
        }
    }
}
