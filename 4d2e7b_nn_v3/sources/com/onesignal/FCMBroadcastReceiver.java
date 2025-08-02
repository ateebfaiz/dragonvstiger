package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.firebase.messaging.Constants;
import com.onesignal.l0;
import com.onesignal.o3;

public class FCMBroadcastReceiver extends WakefulBroadcastReceiver {

    class a implements l0.e {
        a() {
        }

        public void a(l0.f fVar) {
            if (fVar == null) {
                FCMBroadcastReceiver.this.g();
            } else if (fVar.a() || fVar.b()) {
                FCMBroadcastReceiver.this.e();
            } else {
                FCMBroadcastReceiver.this.g();
            }
        }
    }

    class b implements l0.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l0.e f10275a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f10276b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Bundle f10277c;

        b(l0.e eVar, Context context, Bundle bundle) {
            this.f10275a = eVar;
            this.f10276b = context;
            this.f10277c = bundle;
        }

        public void a(l0.f fVar) {
            if (fVar == null || !fVar.c()) {
                FCMBroadcastReceiver.h(this.f10276b, this.f10277c);
                this.f10275a.a(fVar);
                return;
            }
            this.f10275a.a(fVar);
        }
    }

    private static boolean c(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return false;
        }
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE);
        if (stringExtra == null || Constants.MessageTypes.MESSAGE.equals(stringExtra)) {
            return true;
        }
        return false;
    }

    private static void d(Context context, Intent intent, Bundle bundle, l0.e eVar) {
        if (!c(intent)) {
            eVar.a((l0.f) null);
        }
        l0.h(context, bundle, new b(eVar, context, bundle));
    }

    /* access modifiers changed from: private */
    public void e() {
        if (isOrderedBroadcast()) {
            abortBroadcast();
            setResultCode(-1);
        }
    }

    private static m f(Bundle bundle, m mVar) {
        mVar.putString("json_payload", l0.a(bundle).toString());
        mVar.b("timestamp", Long.valueOf(o3.w0().b() / 1000));
        return mVar;
    }

    /* access modifiers changed from: private */
    public void g() {
        if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
    }

    static void h(Context context, Bundle bundle) {
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "startFCMService from: " + context + " and bundle: " + bundle);
        if (!l0.c(bundle)) {
            o3.a(vVar, "startFCMService with no remote resources, no need for services");
            l0.j(context, f(bundle, o.a()));
        } else if (Integer.parseInt(bundle.getString("pri", "0")) <= 9 && Build.VERSION.SDK_INT >= 26) {
            i(context, bundle);
        } else {
            try {
                j(context, bundle);
            } catch (IllegalStateException unused) {
                i(context, bundle);
            }
        }
    }

    private static void i(Context context, Bundle bundle) {
        m f10 = f(bundle, o.a());
        Intent intent = new Intent(context, FCMIntentJobService.class);
        intent.putExtra("Bundle:Parcelable:Extras", (Parcelable) f10.getBundle());
        FCMIntentJobService.j(context, intent);
    }

    private static void j(Context context, Bundle bundle) {
        WakefulBroadcastReceiver.startWakefulService(context, new Intent().replaceExtras((Bundle) f(bundle, new n()).getBundle()).setComponent(new ComponentName(context.getPackageName(), FCMIntentService.class.getName())));
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null && !"google.com/iid".equals(extras.getString(Constants.MessagePayloadKeys.FROM))) {
            o3.L0(context);
            d(context, intent, extras, new a());
        }
    }
}
