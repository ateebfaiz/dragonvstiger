package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.login.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import q5.e;
import q5.f0;
import q5.p0;
import q5.z;

public final class CustomTabMainActivity extends Activity {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String EXTRA_ACTION;
    public static final String EXTRA_CHROME_PACKAGE;
    public static final String EXTRA_PARAMS;
    public static final String EXTRA_TARGET_APP;
    public static final String EXTRA_URL;
    public static final String NO_ACTIVITY_EXCEPTION;
    public static final String REFRESH_ACTION;

    /* renamed from: a  reason: collision with root package name */
    private boolean f19503a = true;

    /* renamed from: b  reason: collision with root package name */
    private BroadcastReceiver f19504b;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final Bundle b(String str) {
            Uri parse = Uri.parse(str);
            m.e(parse, "uri");
            Bundle l02 = p0.l0(parse.getQuery());
            l02.putAll(p0.l0(parse.getFragment()));
            return l02;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        StringBuilder sb2 = new StringBuilder();
        Class<CustomTabMainActivity> cls = CustomTabMainActivity.class;
        sb2.append(cls.getSimpleName());
        sb2.append(".extra_action");
        EXTRA_ACTION = sb2.toString();
        EXTRA_PARAMS = cls.getSimpleName() + ".extra_params";
        EXTRA_CHROME_PACKAGE = cls.getSimpleName() + ".extra_chromePackage";
        EXTRA_URL = cls.getSimpleName() + ".extra_url";
        EXTRA_TARGET_APP = cls.getSimpleName() + ".extra_targetApp";
        REFRESH_ACTION = cls.getSimpleName() + ".action_refresh";
        NO_ACTIVITY_EXCEPTION = cls.getSimpleName() + ".no_activity_exception";
    }

    private final void a(int i10, Intent intent) {
        Bundle bundle;
        BroadcastReceiver broadcastReceiver = this.f19504b;
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra(EXTRA_URL);
            if (stringExtra != null) {
                bundle = Companion.b(stringExtra);
            } else {
                bundle = new Bundle();
            }
            Intent intent2 = getIntent();
            m.e(intent2, "intent");
            Intent p10 = f0.p(intent2, bundle, (l) null);
            if (p10 != null) {
                intent = p10;
            }
            setResult(i10, intent);
        } else {
            Intent intent3 = getIntent();
            m.e(intent3, "intent");
            setResult(i10, f0.p(intent3, (Bundle) null, (l) null));
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String stringExtra;
        e eVar;
        super.onCreate(bundle);
        String str = CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION;
        Intent intent = getIntent();
        m.e(intent, "intent");
        if (m.b(str, intent.getAction())) {
            setResult(0);
            finish();
        } else if (bundle == null && (stringExtra = getIntent().getStringExtra(EXTRA_ACTION)) != null) {
            Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
            String stringExtra2 = getIntent().getStringExtra(EXTRA_CHROME_PACKAGE);
            if (h.f19699a[k.f20546e.a(getIntent().getStringExtra(EXTRA_TARGET_APP)).ordinal()] != 1) {
                eVar = new e(stringExtra, bundleExtra);
            } else {
                eVar = new z(stringExtra, bundleExtra);
            }
            boolean b10 = eVar.b(this, stringExtra2);
            this.f19503a = false;
            if (!b10) {
                setResult(0, getIntent().putExtra(NO_ACTIVITY_EXCEPTION, true));
                finish();
                return;
            }
            CustomTabMainActivity$onCreate$redirectReceiver$1 customTabMainActivity$onCreate$redirectReceiver$1 = new CustomTabMainActivity$onCreate$redirectReceiver$1(this);
            this.f19504b = customTabMainActivity$onCreate$redirectReceiver$1;
            LocalBroadcastManager.getInstance(this).registerReceiver(customTabMainActivity$onCreate$redirectReceiver$1, new IntentFilter(str));
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        m.f(intent, "intent");
        super.onNewIntent(intent);
        if (m.b(REFRESH_ACTION, intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CustomTabActivity.DESTROY_ACTION));
            a(-1, intent);
        } else if (m.b(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION, intent.getAction())) {
            a(-1, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f19503a) {
            a(0, (Intent) null);
        }
        this.f19503a = true;
    }
}
