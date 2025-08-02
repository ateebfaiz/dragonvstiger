package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class CustomTabActivity extends Activity {
    public static final String CUSTOM_TAB_REDIRECT_ACTION;
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String DESTROY_ACTION;

    /* renamed from: a  reason: collision with root package name */
    private BroadcastReceiver f19501a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        StringBuilder sb2 = new StringBuilder();
        Class<CustomTabActivity> cls = CustomTabActivity.class;
        sb2.append(cls.getSimpleName());
        sb2.append(".action_customTabRedirect");
        CUSTOM_TAB_REDIRECT_ACTION = sb2.toString();
        DESTROY_ACTION = cls.getSimpleName() + ".action_destroy";
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == 0) {
            Intent intent2 = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
            String str = CustomTabMainActivity.EXTRA_URL;
            Intent intent3 = getIntent();
            m.e(intent3, "intent");
            intent2.putExtra(str, intent3.getDataString());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
            CustomTabActivity$onActivityResult$closeReceiver$1 customTabActivity$onActivityResult$closeReceiver$1 = new CustomTabActivity$onActivityResult$closeReceiver$1(this);
            LocalBroadcastManager.getInstance(this).registerReceiver(customTabActivity$onActivityResult$closeReceiver$1, new IntentFilter(DESTROY_ACTION));
            this.f19501a = customTabActivity$onActivityResult$closeReceiver$1;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, CustomTabMainActivity.class);
        intent.setAction(CUSTOM_TAB_REDIRECT_ACTION);
        String str = CustomTabMainActivity.EXTRA_URL;
        Intent intent2 = getIntent();
        m.e(intent2, "getIntent()");
        intent.putExtra(str, intent2.getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.f19501a;
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }
        super.onDestroy();
    }
}
