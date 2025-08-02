package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.login.g;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import q5.f0;
import q5.j;
import q5.p0;
import u2.d;
import u2.e;
import y5.b;

public class FacebookActivity extends FragmentActivity {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String PASS_THROUGH_CANCEL_ACTION = "PassThrough";

    /* renamed from: b  reason: collision with root package name */
    private static final String f19506b;

    /* renamed from: a  reason: collision with root package name */
    private Fragment f19507a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String name = FacebookActivity.class.getName();
        m.e(name, "FacebookActivity::class.java.name");
        f19506b = name;
    }

    private final void h() {
        Intent intent = getIntent();
        m.e(intent, "requestIntent");
        l v10 = f0.v(f0.A(intent));
        Intent intent2 = getIntent();
        m.e(intent2, "intent");
        setResult(0, f0.p(intent2, (Bundle) null, v10));
        finish();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (!v5.a.d(this)) {
            try {
                m.f(str, "prefix");
                m.f(printWriter, "writer");
                if (!b.f24946f.n(str, printWriter, strArr)) {
                    super.dump(str, fileDescriptor, printWriter, strArr);
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Fragment g() {
        Intent intent = getIntent();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        m.e(supportFragmentManager, "supportFragmentManager");
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag("SingleFragment");
        if (findFragmentByTag != null) {
            return findFragmentByTag;
        }
        m.e(intent, "intent");
        if (m.b("FacebookDialogFragment", intent.getAction())) {
            j jVar = new j();
            jVar.setRetainInstance(true);
            jVar.show(supportFragmentManager, "SingleFragment");
            return jVar;
        } else if (m.b("DeviceShareDialogFragment", intent.getAction())) {
            Log.w(f19506b, "Please stop use Device Share Dialog, this feature has been disabled and all related classes in Facebook Android SDK will be removed from v13.0.0 release.");
            DeviceShareDialogFragment deviceShareDialogFragment = new DeviceShareDialogFragment();
            deviceShareDialogFragment.setRetainInstance(true);
            Parcelable parcelableExtra = intent.getParcelableExtra(FirebaseAnalytics.Param.CONTENT);
            if (parcelableExtra != null) {
                deviceShareDialogFragment.x((ShareContent) parcelableExtra);
                deviceShareDialogFragment.show(supportFragmentManager, "SingleFragment");
                return deviceShareDialogFragment;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.share.model.ShareContent<*, *>");
        } else if (m.b("ReferralFragment", intent.getAction())) {
            x7.b bVar = new x7.b();
            bVar.setRetainInstance(true);
            supportFragmentManager.beginTransaction().add(d.f24283c, (Fragment) bVar, "SingleFragment").commit();
            return bVar;
        } else {
            g gVar = new g();
            gVar.setRetainInstance(true);
            supportFragmentManager.beginTransaction().add(d.f24283c, (Fragment) gVar, "SingleFragment").commit();
            return gVar;
        }
    }

    public final Fragment getCurrentFragment() {
        return this.f19507a;
    }

    public void onConfigurationChanged(Configuration configuration) {
        m.f(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Fragment fragment = this.f19507a;
        if (fragment != null) {
            fragment.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!o.A()) {
            p0.f0(f19506b, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            Context applicationContext = getApplicationContext();
            m.e(applicationContext, "applicationContext");
            o.G(applicationContext);
        }
        setContentView(e.f24287a);
        m.e(intent, "intent");
        if (m.b(PASS_THROUGH_CANCEL_ACTION, intent.getAction())) {
            h();
        } else {
            this.f19507a = g();
        }
    }
}
