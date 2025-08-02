package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.h;

public final class BoltsMeasurementEventListener extends BroadcastReceiver {

    /* renamed from: b  reason: collision with root package name */
    private static BoltsMeasurementEventListener f20332b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f20333c = "com.parse.bolts.measurement_event";

    /* renamed from: d  reason: collision with root package name */
    public static final a f20334d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f20335a;

    public static final class a {
        private a() {
        }

        public final BoltsMeasurementEventListener a(Context context) {
            m.f(context, "context");
            if (BoltsMeasurementEventListener.a() != null) {
                return BoltsMeasurementEventListener.a();
            }
            BoltsMeasurementEventListener boltsMeasurementEventListener = new BoltsMeasurementEventListener(context, (DefaultConstructorMarker) null);
            BoltsMeasurementEventListener.b(boltsMeasurementEventListener);
            BoltsMeasurementEventListener.c(boltsMeasurementEventListener);
            return BoltsMeasurementEventListener.a();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private BoltsMeasurementEventListener(Context context) {
        Context applicationContext = context.getApplicationContext();
        m.e(applicationContext, "context.applicationContext");
        this.f20335a = applicationContext;
    }

    public static final /* synthetic */ BoltsMeasurementEventListener a() {
        Class<BoltsMeasurementEventListener> cls = BoltsMeasurementEventListener.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return f20332b;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void b(BoltsMeasurementEventListener boltsMeasurementEventListener) {
        Class<BoltsMeasurementEventListener> cls = BoltsMeasurementEventListener.class;
        if (!v5.a.d(cls)) {
            try {
                boltsMeasurementEventListener.e();
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static final /* synthetic */ void c(BoltsMeasurementEventListener boltsMeasurementEventListener) {
        Class<BoltsMeasurementEventListener> cls = BoltsMeasurementEventListener.class;
        if (!v5.a.d(cls)) {
            try {
                f20332b = boltsMeasurementEventListener;
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private final void d() {
        if (!v5.a.d(this)) {
            try {
                LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.f20335a);
                m.e(instance, "LocalBroadcastManager.ge…tance(applicationContext)");
                instance.unregisterReceiver(this);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    private final void e() {
        if (!v5.a.d(this)) {
            try {
                LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.f20335a);
                m.e(instance, "LocalBroadcastManager.ge…tance(applicationContext)");
                instance.registerReceiver(this, new IntentFilter(f20333c));
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public final void finalize() {
        if (!v5.a.d(this)) {
            try {
                d();
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        String str;
        Bundle bundle;
        if (!v5.a.d(this)) {
            try {
                e2.m mVar = new e2.m(context);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("bf_");
                Set<String> set = null;
                if (intent != null) {
                    str = intent.getStringExtra(DbParams.KEY_CHANNEL_EVENT_NAME);
                } else {
                    str = null;
                }
                sb2.append(str);
                String sb3 = sb2.toString();
                if (intent != null) {
                    bundle = intent.getBundleExtra("event_args");
                } else {
                    bundle = null;
                }
                Bundle bundle2 = new Bundle();
                if (bundle != null) {
                    set = bundle.keySet();
                }
                if (set != null) {
                    for (String next : set) {
                        m.e(next, "key");
                        bundle2.putString(new h("[ -]*$").d(new h("^[ -]*").d(new h("[^0-9a-zA-Z _-]").d(next, "-"), ""), ""), (String) bundle.get(next));
                    }
                }
                mVar.d(sb3, bundle2);
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public /* synthetic */ BoltsMeasurementEventListener(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }
}
